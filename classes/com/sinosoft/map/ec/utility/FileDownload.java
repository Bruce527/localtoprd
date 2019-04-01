// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileDownload.java

package com.sinosoft.map.ec.utility;

import com.sinosoft.map.lis.excel.ExcelInfo;
import com.sinosoft.map.lis.excel.ReportHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

public class FileDownload
{

	public FileDownload()
	{
	}

	public static String downloadExcel(ReportHelper helper)
	{
		ExcelInfo info;
		FacesContext context;
		HttpServletResponse response;
		info = helper.getInfo();
		context = FacesContext.getCurrentInstance();
		response = (HttpServletResponse)context.getExternalContext().getResponse();
		response.reset();
		response.setContentType("application/OCTET-STREAM");
		response.setHeader("Content-disposition", (new StringBuilder("attachment;filename=")).append(new String("Excel.xls".getBytes(), "iso-8859-1")).toString());
		ReportHelper.download(response.getOutputStream(), info.getReportPath());
		break MISSING_BLOCK_LABEL_124;
		UnsupportedEncodingException e1;
		e1;
		e1.printStackTrace();
		context.responseComplete();
		break MISSING_BLOCK_LABEL_128;
		IOException e;
		e;
		e.printStackTrace();
		context.responseComplete();
		break MISSING_BLOCK_LABEL_128;
		Exception exception;
		exception;
		context.responseComplete();
		throw exception;
		context.responseComplete();
		return null;
	}
}
