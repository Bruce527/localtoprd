// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AbstractConfig.java

package com.sinosoft.map.common.config;

import com.sinosoft.map.common.WebApplication;
import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.common.logs.ErrorsLog;
import java.io.*;
import java.text.MessageFormat;
import java.util.*;
import javax.el.*;
import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractConfig
	implements Serializable
{

	public AbstractConfig()
	{
	}

	public void out(Object x)
	{
		System.out.println(x);
	}

	public void printRequest()
	{
		HttpServletRequest request = (HttpServletRequest)getFacesContext().getExternalContext().getRequest();
		out((new StringBuilder("requestURI=")).append(request.getRequestURI()).toString());
		out((new StringBuilder("requestURL=")).append(request.getRequestURL().toString()).toString());
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

	public HttpServletRequest getHttpServletRequest()
	{
		return (HttpServletRequest)getFacesContext().getExternalContext().getRequest();
	}

	public String getContextPath()
	{
		return getFacesContext().getExternalContext().getRequestContextPath();
	}

	public static WebApplication getWebApplication()
	{
		return WebApplication.getInstance();
	}

	public static WebVisitor getVisitor()
	{
		Application app = getApplication();
		ELContext elc = getELContext();
		ExpressionFactory ef = app.getExpressionFactory();
		ValueExpression ve = ef.createValueExpression(elc, "#{webVisitor}", com/sinosoft/map/common/WebVisitor);
		WebVisitor visitor = (WebVisitor)ve.getValue(elc);
		if (visitor == null)
		{
			visitor = new WebVisitor();
			ve.setValue(elc, visitor);
		}
		return visitor;
	}

	public String getParameter(String key)
	{
		String value = null;
		value = (String)getFacesContext().getExternalContext().getRequestParameterMap().get(key);
		return value;
	}

	public ValueExpression getValueExpression(String name, String scope)
	{
		Application app = getApplication();
		ELContext elc = getELContext();
		ExpressionFactory ef = app.getExpressionFactory();
		ValueExpression ve = ef.createValueExpression(elc, (new StringBuilder("#{")).append(scope).append(".").append(name).append("}").toString(), java/lang/Object);
		return ve;
	}

	public Object getValue(String name, String scope)
	{
		ValueExpression ve = getValueExpression(name, scope);
		Object obj = ve.getValue(getELContext());
		return obj;
	}

	public void redirect(String target)
	{
		try
		{
			FacesContext fc = getFacesContext();
			HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
			response.sendRedirect(target);
		}
		catch (IOException ioexception) { }
	}

	public void redirectByContext(String target)
	{
		redirect((new StringBuilder(String.valueOf(getContextPath()))).append(target).toString());
	}

	public static Locale getRootLocale()
	{
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

	public String getBundleString(String bundleName, String sid, Object params[])
	{
		String bundleString = "";
		try
		{
			ResourceBundle rb = ResourceBundle.getBundle(bundleName, getRootLocale());
			bundleString = rb.getString(sid);
			if (params != null)
				bundleString = MessageFormat.format(bundleString, params);
		}
		catch (Exception ex)
		{
			ErrorsLog.log((new StringBuilder("AbstractConfig:getBundleString:")).append(ex.getMessage()).toString());
		}
		return bundleString;
	}

	public abstract String getBundle();

	public abstract String getStringByID(String s, Object aobj[]);

	public abstract String getDatabase();
}
