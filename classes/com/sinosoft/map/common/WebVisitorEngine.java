// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WebVisitorEngine.java

package com.sinosoft.map.common;

import com.sinosoft.map.common.config.BaseConfig;
import com.sinosoft.map.common.logs.VisitorLog;
import com.sinosoft.map.common.logs.WebLoginLogDB;
import com.sinosoft.map.user.UserModel;
import java.io.PrintStream;
import java.util.*;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.map.common:
//			WebVisitor, WebApplication

public class WebVisitorEngine extends BaseConfig
{

	private Map _visitors;
	private int _freeTime;
	private long _interval;
	private Thread _vListener;
	private int _totalOnline;
	private int _totalUser;
	private int _totalHidden;
	private int _totalGuest;
	private VisitorLog _visitorLog;

	public WebVisitorEngine()
	{
		_freeTime = 60;
		_interval = 30L;
		_visitors = new HashMap();
	}

	public void start()
	{
		initVisitorLog();
	}

	public Map getVisitors()
	{
		return _visitors;
	}

	public List getVisitorsList()
	{
		List visitors = new ArrayList();
		Set keys = _visitors.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();)
		{
			String key = (String)iterator.next();
			WebVisitor visitor = (WebVisitor)_visitors.get(key);
			if (visitor.isLogin())
				visitors.add(0, visitor);
			else
				visitors.add(visitor);
		}

		return visitors;
	}

	public int getTotalOnline()
	{
		return _totalOnline;
	}

	public void setTotalOnline(int totalOnline)
	{
		_totalOnline = totalOnline;
	}

	public int getTotalUser()
	{
		return _totalUser;
	}

	public int getTotalHidden()
	{
		return _totalHidden;
	}

	public int getTotalGuest()
	{
		return _totalGuest;
	}

	public boolean checkAllow(String ip)
	{
		HashMap disallows = (HashMap)getWebApplication().getDisaccessHashMap();
		return disallows.get(ip) == null;
	}

	public void checkVisitor(WebVisitor visitor)
	{
		if (visitor.isLogin())
		{
			addVisitor(visitor);
			if (WebLoginLogDB.saveLoginLog(visitor))
				System.out.println("有用户登陆,记录完毕");
			else
				System.out.println("有用户登陆,记录出现异常");
		} else
		{
			System.out.println("无用户登陆");
		}
	}

	public void addVisitor(WebVisitor visitor)
	{
		HttpSession session = (HttpSession)getFacesContext().getExternalContext().getSession(false);
		_visitors.put(session.getId(), visitor);
		_totalOnline++;
	}

	public void removeVisitor(WebVisitor webvisitor)
	{
	}

	public void login(UserModel user, boolean hidden)
	{
		Application app = getApplication();
		javax.el.ELContext elc = getELContext();
		ExpressionFactory ef = app.getExpressionFactory();
		ValueExpression ve = ef.createValueExpression(elc, "#{webVisitor}", com/sinosoft/map/common/WebVisitor);
		WebVisitor visitor = null;
		try
		{
			visitor = (WebVisitor)ve.getValue(elc);
		}
		catch (Exception exception) { }
		if (user != null)
		{
			if (visitor != null)
			{
				System.out.println("============webvisitor已经被加载==========");
				visitor.setUser(user);
				visitor.setLogin(true);
				visitor.setHidden(hidden);
			} else
			{
				System.out.println("============webvisitor尚未加载==========");
				visitor = new WebVisitor();
				visitor.setUser(user);
				visitor.setLogin(true);
				visitor.setHidden(hidden);
				ve.setValue(elc, visitor);
			}
			System.out.println("============checkVisitor==========");
			checkVisitor(visitor);
		} else
		if (visitor != null)
		{
			visitor.setHalfLogin(true);
		} else
		{
			visitor = new WebVisitor();
			visitor.setHalfLogin(true);
			ve.setValue(elc, visitor);
		}
	}

	public void logout(WebVisitor visitor)
	{
		WebLoginLogDB.saveLogoutLog(visitor);
		HttpSession session = (HttpSession)getFacesContext().getExternalContext().getSession(false);
		if (session != null)
			session.invalidate();
	}

	public void showVisitors()
	{
		if (!_visitors.isEmpty())
		{
			Set keys = _visitors.keySet();
			System.out.println("--------visitors state");
			String key;
			for (Iterator iterator = keys.iterator(); iterator.hasNext(); System.out.println((new StringBuilder(String.valueOf(key))).append(":").append(((WebVisitor)_visitors.get(key)).getUser().getUserCode()).toString()))
				key = (String)iterator.next();

		} else
		{
			System.out.println("no visitors");
		}
	}

	public void showOnline()
	{
		System.out.println((new StringBuilder("totalOnline:")).append(_totalOnline).toString());
		System.out.println((new StringBuilder("totalUser:")).append(_totalUser).toString());
		System.out.println((new StringBuilder("totalHidden:")).append(_totalHidden).toString());
		System.out.println((new StringBuilder("totalGuest:")).append(_totalGuest).toString());
	}

	private void initVisitorLog()
	{
		_visitorLog = new VisitorLog();
	}

	public VisitorLog getVlog()
	{
		return _visitorLog;
	}

	public void release()
	{
		_vListener = null;
	}
}
