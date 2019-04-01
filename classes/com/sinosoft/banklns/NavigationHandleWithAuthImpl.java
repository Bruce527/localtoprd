// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NavigationHandleWithAuthImpl.java

package com.sinosoft.banklns;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import javax.faces.application.*;
import javax.faces.component.UIViewRoot;
import javax.faces.context.*;
import javax.faces.render.RenderKit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NavigationHandleWithAuthImpl extends NavigationHandler
{

	public NavigationHandleWithAuthImpl()
	{
	}

	public void handleNavigation(FacesContext context, String fromAction, String outcome)
	{
		try
		{
			FacesContext face = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest)face.getExternalContext().getRequest();
			String ip = (new StringBuilder(String.valueOf(req.getScheme()))).append("://").append(req.getServerName()).append(":").append(req.getServerPort()).toString();
			System.out.println((new StringBuilder("--->ip:")).append(ip).toString());
			HttpServletResponse rsp = (HttpServletResponse)face.getExternalContext().getResponse();
			rsp.sendRedirect("");
			face.responseComplete();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		NavigationHandleWithAuthImpl i = new NavigationHandleWithAuthImpl();
		FacesContext context = new FacesContext() {

			public void setViewRoot(UIViewRoot uiviewroot)
			{
			}

			public void setResponseWriter(ResponseWriter responsewriter)
			{
			}

			public void setResponseStream(ResponseStream responsestream)
			{
			}

			public void responseComplete()
			{
			}

			public void renderResponse()
			{
			}

			public void release()
			{
			}

			public UIViewRoot getViewRoot()
			{
				return null;
			}

			public ResponseWriter getResponseWriter()
			{
				return null;
			}

			public ResponseStream getResponseStream()
			{
				return null;
			}

			public boolean getResponseComplete()
			{
				return false;
			}

			public boolean getRenderResponse()
			{
				return false;
			}

			public RenderKit getRenderKit()
			{
				return null;
			}

			public Iterator getMessages(String arg0)
			{
				return null;
			}

			public Iterator getMessages()
			{
				return null;
			}

			public javax.faces.application.FacesMessage.Severity getMaximumSeverity()
			{
				return null;
			}

			public ExternalContext getExternalContext()
			{
				return null;
			}

			public Iterator getClientIdsWithMessages()
			{
				return null;
			}

			public Application getApplication()
			{
				return null;
			}

			public void addMessage(String s, FacesMessage facesmessage)
			{
			}

		};
		String fromAction = "";
		String outcome = "";
		i.handleNavigation(context, fromAction, outcome);
	}
}
