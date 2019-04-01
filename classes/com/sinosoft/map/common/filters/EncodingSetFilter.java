// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EncodingSetFilter.java

package com.sinosoft.map.common.filters;

import java.io.IOException;
import javax.servlet.*;

public class EncodingSetFilter
	implements Filter
{

	protected String encoding;
	protected FilterConfig filterConfig;
	protected boolean ignore;

	public EncodingSetFilter()
	{
		encoding = null;
		filterConfig = null;
		ignore = true;
	}

	public void destroy()
	{
		encoding = null;
		filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		if (ignore || request.getCharacterEncoding() == null)
		{
			String encoding = selectEncoding(request);
			if (encoding != null)
				request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig)
		throws ServletException
	{
		this.filterConfig = filterConfig;
		encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null)
			ignore = true;
		else
		if (value.equalsIgnoreCase("true"))
			ignore = true;
		else
		if (value.equalsIgnoreCase("yes"))
			ignore = true;
		else
			ignore = false;
	}

	protected String selectEncoding(ServletRequest request)
	{
		return encoding;
	}
}
