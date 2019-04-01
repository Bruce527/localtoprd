// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ECPubFun.java

package com.sinosoft.map.ec.utility;

import com.sinosoft.map.common.WebVisitor;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.el.*;
import javax.faces.application.*;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class ECPubFun
{

	public ECPubFun()
	{
	}

	protected static ClassLoader getCurrentClassLoader(Object defaultObject)
	{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null)
			loader = defaultObject.getClass().getClassLoader();
		return loader;
	}

	public static Locale getLocale()
	{
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

	public static String getDisplayString(String bundleName, String id, Object params[])
	{
		String text = null;
		ResourceBundle bundle;
		try
		{
			bundle = ResourceBundle.getBundle(bundleName, getLocale(), getCurrentClassLoader(((Object) (params))));
		}
		catch (Exception e)
		{
			return id;
		}
		try
		{
			text = bundle.getString(id);
		}
		catch (MissingResourceException e)
		{
			text = (new StringBuilder("[")).append(id).append("]").toString();
		}
		if (params != null)
		{
			MessageFormat mf = new MessageFormat(text, getLocale());
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

	public static void addMessage(String type, String bundleName, String id, Object params[])
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String summary = getDisplayString(bundleName, type, null);
		String detail = getDisplayString(bundleName, id, params);
		FacesMessage message = null;
		if (type.equals("Info"))
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		else
		if (type.equals("Warn"))
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
		else
		if (type.equals("Error"))
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		else
		if (type.equals("Fatal"))
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
		facesContext.addMessage(null, message);
	}

	public static void addInfoMessage(String bundleName, String id, Object params[])
	{
		addMessage("Info", bundleName, id, params);
	}

	public static void addWarnMessage(String bundleName, String id, Object params[])
	{
		addMessage("Warn", bundleName, id, params);
	}

	public static void addErrorMessage(String bundleName, String id, Object params[])
	{
		addMessage("Error", bundleName, id, params);
	}

	public static void addFatalMessage(String bundleName, String id, Object params[])
	{
		addMessage("Fatal", bundleName, id, params);
	}

	public static void addInfoMessage(String bundleName, String id)
	{
		addMessage("Info", bundleName, id, null);
	}

	public static void addWarnMessage(String bundleName, String id)
	{
		addMessage("Warn", bundleName, id, null);
	}

	public static void addErrorMessage(String bundleName, String id)
	{
		addMessage("Error", bundleName, id, null);
	}

	public static void addFatalMessage(String bundleName, String id)
	{
		addMessage("Fatal", bundleName, id, null);
	}

	public static FacesContext getFacesContext()
	{
		return FacesContext.getCurrentInstance();
	}

	public static Application getApplication()
	{
		return getFacesContext().getApplication();
	}

	public static ELContext getELContext()
	{
		return getFacesContext().getELContext();
	}

	public static void redirect(String uri)
	{
		FacesContext fc = getFacesContext();
		Application app = getApplication();
		UIViewRoot view = app.getViewHandler().createView(fc, uri);
		fc.setViewRoot(view);
		fc.renderResponse();
	}

	public static void redirect2(String uri)
	{
		try
		{
			String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
			FacesContext.getCurrentInstance().getExternalContext().redirect((new StringBuilder(String.valueOf(contextPath))).append(uri).toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String getCurrentDate()
	{
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(nowDate);
	}

	public static String getCurrentTime()
	{
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(nowTime);
	}

	public static WebVisitor getWebVisitor()
	{
		WebVisitor visitor = null;
		try
		{
			Application app = FacesContext.getCurrentInstance().getApplication();
			ELContext elc = FacesContext.getCurrentInstance().getELContext();
			ExpressionFactory ef = app.getExpressionFactory();
			ValueExpression ve = ef.createValueExpression(elc, "#{webVisitor}", com/sinosoft/map/common/WebVisitor);
			try
			{
				visitor = (WebVisitor)ve.getValue(elc);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return visitor;
	}
}
