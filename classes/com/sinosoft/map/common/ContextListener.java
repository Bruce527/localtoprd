// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ContextListener.java

package com.sinosoft.map.common;

import com.sinosoft.banklns.lnsmodel.BankOperateDeal;
import com.sinosoft.map.common.logs.WebLoginLogDB;
import com.sinosoft.map.user.UserModel;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

// Referenced classes of package com.sinosoft.map.common:
//			WebApplication, WebVisitorEngine, WebVisitor, MainListener

public class ContextListener
	implements ServletContextListener, HttpSessionListener
{

	private ServletContext application;
	BankOperateDeal operateDeal;

	public ContextListener()
	{
		application = null;
	}

	public void contextInitialized(ServletContextEvent event)
	{
		ServletContext sc = event.getServletContext();
		application = sc;
		String servletContextPath = sc.getRealPath("/");
		WebApplication app = WebApplication.getInstance();
		System.out.println((new StringBuilder("------------------------------>")).append(servletContextPath).toString());
		app.init(servletContextPath);
		sc.setAttribute("WebApplication", app);
	}

	public void contextDestroyed(ServletContextEvent event)
	{
		System.out.println("...sessionDestroyed...");
	}

	public void sessionCreated(HttpSessionEvent event)
	{
		System.out.println("...sessionCreated...");
		System.out.println(event.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		try
		{
			if (arg0 != null)
			{
				System.out.println("######################################session is overtime######################################");
				operateDeal = new BankOperateDeal();
				operateDeal.turnEditPolicy(arg0.getSession(), null, false);
				String sessionId = arg0.getSession().getId();
				WebApplication app = (WebApplication)application.getAttribute("WebApplication");
				Map VisitorList = app.get_webVisitorEngine().getVisitors();
				WebVisitor visitor = (WebVisitor)VisitorList.get(arg0.getSession().getId());
				if (visitor != null)
				{
					String usercode = visitor.getUser().getUserCode();
					app.get_webVisitorEngine().removeVisitor(visitor);
					VisitorList.remove(arg0.getSession().getId());
					if (MainListener.sessionMap.containsKey(sessionId))
					{
						MainListener.sessionMap.remove(sessionId);
						WebLoginLogDB.saveLogoutLogOther(sessionId, usercode);
						arg0.getSession().invalidate();
						System.out.println("---sessionDestroyed---");
						System.out.println(arg0.getSession().getId());
					}
					if (visitor != null)
					{
						int onLineNum = app.get_webVisitorEngine().getTotalOnline();
						if (--onLineNum < 0)
							onLineNum = 0;
						app.get_webVisitorEngine().setTotalOnline(onLineNum);
					}
				}
			}
		}
		catch (Exception e)
		{
			arg0.getSession().invalidate();
			e.printStackTrace();
		}
	}
}
