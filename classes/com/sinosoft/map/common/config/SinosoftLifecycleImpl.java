// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SinosoftLifecycleImpl.java

package com.sinosoft.map.common.config;

import java.io.PrintStream;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.myfaces.lifecycle.LifecycleImpl;

public class SinosoftLifecycleImpl extends LifecycleImpl
{

	public SinosoftLifecycleImpl()
	{
	}

	public void execute(FacesContext context)
	{
		try
		{
			super.execute(context);
		}
		catch (ViewExpiredException vee)
		{
			redirect(context);
		}
		catch (FacesException fe)
		{
			throw fe;
		}
	}

	private void redirect(FacesContext context)
	{
		try
		{
			context.responseComplete();
			context.renderResponse();
			HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
			HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
			String url = request.getRequestURI();
			System.out.println((new StringBuilder("LifecycleSinosoftImpl url=")).append(url).toString());
			response.sendRedirect(url);
		}
		catch (ViewExpiredException vex)
		{
			System.out.println("url redirect javax.faces.application.ViewExpiredException .");
			vex.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("url redirect Exception. ");
			e.printStackTrace();
		}
	}

	public static void main(String args1[])
	{
	}
}
