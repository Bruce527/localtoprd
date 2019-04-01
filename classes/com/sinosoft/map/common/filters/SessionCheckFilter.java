// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SessionCheckFilter.java

package com.sinosoft.map.common.filters;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionCheckFilter
	implements Filter
{

	private static int firstRequest = 0;

	public SessionCheckFilter()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		HttpServletRequest hreq = (HttpServletRequest)request;
		HttpServletResponse hres = (HttpServletResponse)response;
		HttpSession session = hreq.getSession();
		if (session.isNew())
			if (firstRequest == 0)
			{
				firstRequest++;
			} else
			{
				System.out.println("--------success---------------------------------------------------");
				hres.sendRedirect("template/doLogin.jsf");
				return;
			}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterconfig)
		throws ServletException
	{
	}

	public void destroy()
	{
	}

}
