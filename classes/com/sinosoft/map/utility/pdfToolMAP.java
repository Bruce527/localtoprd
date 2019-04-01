// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   pdfToolMAP.java

package com.sinosoft.map.utility;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.sinosoft.map.style.pdf.FileStyle;
import com.sinosoft.map.style.pdf.FooterStyle;
import java.io.PrintStream;
import java.util.Vector;

// Referenced classes of package com.sinosoft.map.utility:
//			pdfTool

public class pdfToolMAP extends pdfTool
{

	public boolean makeFile(String tFilePath, FileStyle fs)
	{
		Vector vctGetReData = makeFileHfFun(document, pdfWriter, tFilePath, fs);
		if (vctGetReData.size() != 2)
		{
			return false;
		} else
		{
			document = (Document)vctGetReData.get(0);
			pdfWriter = (PdfWriter)vctGetReData.get(1);
			return true;
		}
	}

	public boolean makeFooter(String content, FooterStyle fs)
	{
		try
		{
			if (!fs.isContinue())
				document.resetPageCount();
			com.lowagie.text.HeaderFooter footer = makeFooterFun(content, fs);
			document.setFooter(footer);
			System.out.println("yejiao success !");
			document.open();
		}
		catch (Exception ex)
		{
			System.err.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public pdfToolMAP()
	{
	}

	public pdfToolMAP(String path)
	{
		this.path = path;
	}
}
