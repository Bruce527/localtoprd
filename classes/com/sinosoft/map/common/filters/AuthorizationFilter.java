// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AuthorizationFilter.java

package com.sinosoft.map.common.filters;

import com.sinosoft.map.common.*;
import com.sinosoft.map.common.config.AccessauthConfig;
import com.sinosoft.map.common.logs.ErrorsLog;
import com.sinosoft.map.ec.utility.ECPubFun;
import java.io.*;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthorizationFilter
	implements Filter
{

	private FilterConfig filterConfig;
	private static final String DISAUTH_URI = (new StringBuilder("/")).append(WebApplication.getInstance().get_URIPrefix()).append("/index.jsf").toString();
	private static final String DISAUTH_URI_MANAGER = "/admin.jsf";

	public AuthorizationFilter()
	{
		filterConfig = null;
		System.out.println("========启动目录访问权限过滤器========");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		HttpServletRequest requestHttp;
		HttpServletResponse responseHttp;
		requestHttp = (HttpServletRequest)request;
		responseHttp = (HttpServletResponse)response;
		if (!checkAuthorization(requestHttp))
		{
			System.out.println("拒绝访问...");
			String uri = requestHttp.getRequestURI();
			if (uri.indexOf("/sysmanage/") != -1)
				ECPubFun.redirect2("/admin.jsf");
			else
				ECPubFun.redirect2(DISAUTH_URI);
			break MISSING_BLOCK_LABEL_435;
		}
		if (!WebApplication.getInstance().getVisitorsOper().checkAllow(requestHttp.getRemoteAddr()))
		{
			responseHttp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = responseHttp.getWriter();
			out.write("<HTML>\r\n");
			out.write("<HEAD>\r\n");
			out.write("<TITLE>访问受限</TITLE>\r\n");
			out.write("</HEAD>\r\n");
			out.write("<BODY>\r\n");
			out.write("\r\n");
			out.write((new StringBuilder("<center>IP地址：")).append(requestHttp.getRemoteAddr()).append("访问受限.</center></BODY>\r\n").toString());
			out.write("</HTML>\r\n");
			out.write("\r\n");
			return;
		}
		String url = requestHttp.getServletPath();
		if (WebApplication.getInstance().isWebStatistics())
			url.indexOf("index.jsf");
		if (url.indexOf("sysmanage") <= -1 && url.indexOf("rightsmanage") <= -1 && url.indexOf("productsmanage") <= -1 && url.indexOf("sysReport") <= -1)
			break MISSING_BLOCK_LABEL_399;
		WebApplication app = WebApplication.getInstance();
		Map VisitorList = app.get_webVisitorEngine().getVisitors();
		if (VisitorList != null && VisitorList.size() > 0)
		{
			HttpSession session = requestHttp.getSession();
			WebVisitor visitor = (WebVisitor)VisitorList.get(session.getId());
			if (visitor == null || !visitor.isLogin())
			{
				responseHttp.sendRedirect((new StringBuilder(String.valueOf(requestHttp.getContextPath()))).append("/admin.jsf").toString());
				return;
			}
			break MISSING_BLOCK_LABEL_399;
		}
		try
		{
			responseHttp.sendRedirect((new StringBuilder(String.valueOf(requestHttp.getContextPath()))).append("/admin.jsf").toString());
			return;
		}
		catch (Throwable t)
		{
			ErrorsLog.log((new StringBuilder("AuthorizationFilter:doFilter:")).append(t.getMessage()).toString());
		}
		break MISSING_BLOCK_LABEL_435;
		chain.doFilter(request, response);
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

	public FilterConfig getFilterConfig()
	{
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig)
	{
		this.filterConfig = filterConfig;
	}

	public void destroy()
	{
	}

	public void init(FilterConfig filterConfig)
	{
		this.filterConfig = filterConfig;
	}

}
