// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MainListener.java

package com.sinosoft.map.common;

import com.sinosoft.map.common.config.AccessauthConfig;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.*;

// Referenced classes of package com.sinosoft.map.common:
//			WebApplication, WebVisitor

public class MainListener
	implements PhaseListener
{

	private FilterConfig filterConfig;
	private static final String DISAUTH_URI = "/error/404.jsf";
	private static final String DISAUTH_URI_MANAGER = "/error/404.jsf";
	private static int firstRequest = 0;
	public static HashMap sessionMap = new HashMap();

	public MainListener()
	{
		filterConfig = null;
	}

	public PhaseId getPhaseId()
	{
		return PhaseId.RESTORE_VIEW;
	}

	public void beforePhase(PhaseEvent event)
	{
		System.out.println((new StringBuilder("Phase ֮ǰ [")).append(new Date()).append("]: ").append(event.getSource()).append("\t").append(event.getPhaseId()).toString());
		FacesContext facesContext = event.getFacesContext();
		HttpServletResponse responseHttp = (HttpServletResponse)facesContext.getExternalContext().getResponse();
		HttpServletRequest requestHttp = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		HttpSession session = requestHttp.getSession();
	}

	public void afterPhase(PhaseEvent phaseevent)
	{
	}

	private boolean checkAuthorization(HttpServletRequest request)
		throws IOException
	{
		String uri = request.getRequestURI();
		WebVisitor visitor = getVisitor(request);
		AccessauthConfig auth = WebApplication.getInstance().getAuthConf();
		return auth.isAllow(uri, visitor);
	}

	private WebVisitor getVisitor(HttpServletRequest request)
	{
		WebVisitor visitor = null;
		HttpSession session = request.getSession(false);
		try
		{
			visitor = (WebVisitor)session.getAttribute("webVisitor");
		}
		catch (Exception exception) { }
		return visitor;
	}

}
