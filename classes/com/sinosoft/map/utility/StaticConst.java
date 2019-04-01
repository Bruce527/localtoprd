// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StaticConst.java

package com.sinosoft.map.utility;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import java.io.*;
import java.util.*;
import javax.servlet.ServletContext;

// Referenced classes of package com.sinosoft.map.utility:
//			ExeSQL, SSRS

public class StaticConst
{

	private static StaticConst me;
	private String RealRootPath;
	private String root;
	private HashMap fontMapping;
	private ServletContext ctx;
	String path;
	private int maleDeathAge;
	private int femaleDeathAge;
	private int defaultEduEne;
	private int femaleRetireAge;
	private int maleRetireAge;
	private double AfterDeathRate;
	private double ChildAdoutRate;
	private double RetiredRate;
	private double AfterDeathRateR;
	private int childFeedEndAge;
	private int levelChildAdout;
	private int levelRetired;
	private int levelDeath;
	private int endAge;
	private int PdfImgWidth;
	private int PdfImgHeight;
	private int PdfImgLabelSize;
	private int PageImgWidth;
	private int PageImgHeight;
	private int PageImgLabelSize;
	private double BLoanRate;
	private double LoanRate;

	private StaticConst(ServletContext ctx)
	{
		RealRootPath = null;
		root = null;
		fontMapping = new HashMap();
		path = "/MAPFont";
		maleDeathAge = 0;
		femaleDeathAge = 0;
		endAge = 105;
		PdfImgWidth = 800;
		PdfImgHeight = 800;
		PdfImgLabelSize = 12;
		PageImgWidth = 800;
		PageImgHeight = 800;
		PageImgLabelSize = 12;
		this.ctx = ctx;
		init();
	}

	private StaticConst()
	{
		RealRootPath = null;
		root = null;
		fontMapping = new HashMap();
		path = "/MAPFont";
		maleDeathAge = 0;
		femaleDeathAge = 0;
		endAge = 105;
		PdfImgWidth = 800;
		PdfImgHeight = 800;
		PdfImgLabelSize = 12;
		PageImgWidth = 800;
		PageImgHeight = 800;
		PageImgLabelSize = 12;
		newInit();
	}

	private void newInit()
	{
		System.out.println(" new init");
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql1 = " select varvalue from msysvar where vartype='MAPFontPath' ";
		Properties config = new Properties();
		try
		{
			config.load(new FileInputStream(new File((new StringBuilder(String.valueOf(path))).append("/init_params.properties").toString())));
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			defaultEduEne = Integer.parseInt(config.getProperty("SYSTEMCONST.defaultEduEne"));
			System.out.println((new StringBuilder("SYSTEMCONST.defaultEduEne = ")).append(defaultEduEne).toString());
		}
		catch (Exception e)
		{
			defaultEduEne = 18;
		}
		try
		{
			femaleDeathAge = Integer.parseInt(config.getProperty("SYSTEMCONST.femaleDeathAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.femaleDeathAge = ")).append(femaleDeathAge).toString());
		}
		catch (Exception e)
		{
			femaleDeathAge = 83;
		}
		try
		{
			femaleRetireAge = Integer.parseInt(config.getProperty("SYSTEMCONST.femaleRetireAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.femaleRetireAge = ")).append(femaleRetireAge).toString());
		}
		catch (Exception e)
		{
			femaleRetireAge = 55;
		}
		try
		{
			maleDeathAge = Integer.parseInt(config.getProperty("SYSTEMCONST.maleDeathAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.maleDeathAge = ")).append(maleDeathAge).toString());
		}
		catch (Exception e)
		{
			maleDeathAge = 79;
		}
		try
		{
			maleRetireAge = Integer.parseInt(config.getProperty("SYSTEMCONST.maleRetireAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.maleRetireAge = ")).append(maleRetireAge).toString());
		}
		catch (Exception e)
		{
			maleRetireAge = 60;
		}
		try
		{
			AfterDeathRate = Double.parseDouble(config.getProperty("SYSTEMCONST.afterDeathRate"));
			System.out.println((new StringBuilder("SYSTEMCONST.afterDeathRate = ")).append(AfterDeathRate).toString());
		}
		catch (Exception e)
		{
			AfterDeathRate = 0.80000000000000004D;
		}
		try
		{
			ChildAdoutRate = Double.parseDouble(config.getProperty("SYSTEMCONST.ChildAdoutRate"));
			System.out.println((new StringBuilder("SYSTEMCONST.ChildAdoutRate = ")).append(ChildAdoutRate).toString());
		}
		catch (Exception e)
		{
			ChildAdoutRate = 0.69999999999999996D;
		}
		try
		{
			childFeedEndAge = Integer.parseInt(config.getProperty("SYSTEMCONST.childFeedEndAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.childFeedEndAge = ")).append(childFeedEndAge).toString());
		}
		catch (Exception e)
		{
			childFeedEndAge = 22;
		}
		try
		{
			RetiredRate = Double.parseDouble(config.getProperty("SYSTEMCONST.RetiredRate"));
			System.out.println((new StringBuilder("SYSTEMCONST.RetiredRate = ")).append(RetiredRate).toString());
		}
		catch (Exception e)
		{
			RetiredRate = 0.80000000000000004D;
		}
		try
		{
			AfterDeathRateR = Double.parseDouble(config.getProperty("SYSTEMCONST.AfterDeathRateR"));
			System.out.println((new StringBuilder("SYSTEMCONST.AfterDeathRateR = ")).append(AfterDeathRateR).toString());
		}
		catch (Exception e)
		{
			AfterDeathRateR = 0.5D;
		}
		try
		{
			endAge = Integer.parseInt(config.getProperty("SYSTEMCONST.RET_ENDAGE"));
			System.out.println((new StringBuilder("SYSTEMCONST.RET_ENDAGE = ")).append(endAge).toString());
		}
		catch (Exception e)
		{
			endAge = 105;
		}
		try
		{
			PdfImgHeight = Integer.parseInt(config.getProperty("SYSTEMCONST.PDF_IMG_HEIGHT"));
			System.out.println((new StringBuilder("SYSTEMCONST.PDF_IMG_HEIGHT = ")).append(PdfImgHeight).toString());
		}
		catch (Exception e)
		{
			PdfImgHeight = 1000;
		}
		try
		{
			PdfImgWidth = Integer.parseInt(config.getProperty("SYSTEMCONST.PDF_IMG_WIDTH"));
			System.out.println((new StringBuilder("SYSTEMCONST.PDF_IMG_WIDTH = ")).append(PdfImgWidth).toString());
		}
		catch (Exception e)
		{
			PdfImgWidth = 1000;
		}
		try
		{
			PdfImgLabelSize = Integer.parseInt(config.getProperty("SYSTEMCONST.PDF_IMG_LABELSIZE"));
			System.out.println((new StringBuilder("SYSTEMCONST.PDF_IMG_LABELSIZE = ")).append(PdfImgLabelSize).toString());
		}
		catch (Exception e)
		{
			PdfImgLabelSize = 16;
		}
		try
		{
			PageImgWidth = Integer.parseInt(config.getProperty("SYSTEMCONST.PAGE_IMG_WIDTH"));
			System.out.println((new StringBuilder("SYSTEMCONST.PAGE_IMG_WIDTH = ")).append(PageImgWidth).toString());
		}
		catch (Exception e)
		{
			PageImgWidth = 800;
		}
		try
		{
			PageImgHeight = Integer.parseInt(config.getProperty("SYSTEMCONST.PAGE_IMG_HEIGHT"));
			System.out.println((new StringBuilder("SYSTEMCONST.PAGE_IMG_HEIGHT = ")).append(PageImgHeight).toString());
		}
		catch (Exception e)
		{
			PageImgHeight = 800;
		}
		try
		{
			PageImgLabelSize = Integer.parseInt(config.getProperty("SYSTEMCONST.PAGE_IMG_LABELSIZE"));
			System.out.println((new StringBuilder("SYSTEMCONST.PAGE_IMG_LABELSIZE = ")).append(PageImgLabelSize).toString());
		}
		catch (Exception e)
		{
			PageImgLabelSize = 12;
		}
		try
		{
			levelChildAdout = Integer.parseInt(config.getProperty("RET_CONST.ChildAdout"));
			System.out.println((new StringBuilder("RET_CONST.ChildAdout = ")).append(levelChildAdout).toString());
		}
		catch (Exception e)
		{
			levelChildAdout = 2;
		}
		try
		{
			levelRetired = Integer.parseInt(config.getProperty("RET_CONST.Retired"));
			System.out.println((new StringBuilder("RET_CONST.Retired = ")).append(levelRetired).toString());
		}
		catch (Exception e)
		{
			levelRetired = 1;
		}
		try
		{
			levelDeath = Integer.parseInt(config.getProperty("RET_CONST.Death"));
			System.out.println((new StringBuilder("RET_CONST.Death = ")).append(levelDeath).toString());
		}
		catch (Exception e)
		{
			levelDeath = 3;
		}
		try
		{
			BLoanRate = Double.parseDouble(config.getProperty("client.BLoanRate"));
			System.out.println((new StringBuilder("client.BLoanRate = ")).append(BLoanRate).toString());
		}
		catch (Exception e)
		{
			BLoanRate = 0.061199999999999997D;
		}
		try
		{
			LoanRate = Double.parseDouble(config.getProperty("client.LoanRate"));
			System.out.println((new StringBuilder("client.LoanRate = ")).append(LoanRate).toString());
		}
		catch (Exception e)
		{
			LoanRate = 0.038699999999999998D;
		}
		try
		{
			fontMapping.put("宋体", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/songti.ttf").toString(), "Identity-H", false));
			fontMapping.put("仿宋", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/simkai.ttf").toString(), "Identity-H", false));
			fontMapping.put("楷体", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/simkai.ttf").toString(), "Identity-H", false));
			fontMapping.put("黑体", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/simhei.ttf").toString(), "Identity-H", false));
			fontMapping.put("华文细黑", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/STXIHEI.TTF").toString(), "Identity-H", false));
			fontMapping.put("ARIAL", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/arial.ttf").toString(), "Cp1252", false));
			fontMapping.put("ARIALBOLD", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/arialbd.ttf").toString(), "Cp1252", false));
			fontMapping.put("ARIAL_BOLD", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/arialbd.ttf").toString(), "Cp1252", false));
			fontMapping.put("ARIALITALIC", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/ariali.ttf").toString(), "Cp1252", false));
			fontMapping.put("ARIAL_ITALIC", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/ariali.ttf").toString(), "Cp1252", false));
			fontMapping.put("ARIALBOLDITALIC", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/arialbi.ttf").toString(), "Cp1252", false));
			fontMapping.put("ARIAL_BOLDITALIC", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/arialbi.ttf").toString(), "Cp1252", false));
			fontMapping.put("TAHOMA", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/tahoma.ttf").toString(), "Cp1252", false));
			fontMapping.put("STSongStd-Light", BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false));
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void init()
	{
		RealRootPath = ctx.getRealPath("/");
		root = ctx.getAttribute("javax.servlet.context.tempdir").toString();
		if (root.indexOf("\\") >= 0)
			root = (new StringBuilder("/")).append(root.substring(root.lastIndexOf("\\") + 1, root.length())).toString();
		else
			root = root.substring(root.lastIndexOf("/"), root.length());
		root = root.replaceAll("\\.war", "");
		for (Enumeration names = ctx.getAttributeNames(); names.hasMoreElements();)
		{
			String name = names.nextElement().toString();
			String s = ctx.getAttribute(name).toString();
		}

		Properties config = new Properties();
		try
		{
			config.load(new FileInputStream(new File(getRealPath("/conf/init_params.properties"))));
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			defaultEduEne = Integer.parseInt(config.getProperty("SYSTEMCONST.defaultEduEne"));
			System.out.println((new StringBuilder("SYSTEMCONST.defaultEduEne = ")).append(defaultEduEne).toString());
		}
		catch (Exception e)
		{
			defaultEduEne = 18;
		}
		try
		{
			femaleDeathAge = Integer.parseInt(config.getProperty("SYSTEMCONST.femaleDeathAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.femaleDeathAge = ")).append(femaleDeathAge).toString());
		}
		catch (Exception e)
		{
			femaleDeathAge = 83;
		}
		try
		{
			femaleRetireAge = Integer.parseInt(config.getProperty("SYSTEMCONST.femaleRetireAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.femaleRetireAge = ")).append(femaleRetireAge).toString());
		}
		catch (Exception e)
		{
			femaleRetireAge = 55;
		}
		try
		{
			maleDeathAge = Integer.parseInt(config.getProperty("SYSTEMCONST.maleDeathAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.maleDeathAge = ")).append(maleDeathAge).toString());
		}
		catch (Exception e)
		{
			maleDeathAge = 79;
		}
		try
		{
			maleRetireAge = Integer.parseInt(config.getProperty("SYSTEMCONST.maleRetireAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.maleRetireAge = ")).append(maleRetireAge).toString());
		}
		catch (Exception e)
		{
			maleRetireAge = 60;
		}
		try
		{
			AfterDeathRate = Double.parseDouble(config.getProperty("SYSTEMCONST.afterDeathRate"));
			System.out.println((new StringBuilder("SYSTEMCONST.afterDeathRate = ")).append(AfterDeathRate).toString());
		}
		catch (Exception e)
		{
			AfterDeathRate = 0.80000000000000004D;
		}
		try
		{
			ChildAdoutRate = Double.parseDouble(config.getProperty("SYSTEMCONST.ChildAdoutRate"));
			System.out.println((new StringBuilder("SYSTEMCONST.ChildAdoutRate = ")).append(ChildAdoutRate).toString());
		}
		catch (Exception e)
		{
			ChildAdoutRate = 0.69999999999999996D;
		}
		try
		{
			childFeedEndAge = Integer.parseInt(config.getProperty("SYSTEMCONST.childFeedEndAge"));
			System.out.println((new StringBuilder("SYSTEMCONST.childFeedEndAge = ")).append(childFeedEndAge).toString());
		}
		catch (Exception e)
		{
			childFeedEndAge = 22;
		}
		try
		{
			RetiredRate = Double.parseDouble(config.getProperty("SYSTEMCONST.RetiredRate"));
			System.out.println((new StringBuilder("SYSTEMCONST.RetiredRate = ")).append(RetiredRate).toString());
		}
		catch (Exception e)
		{
			RetiredRate = 0.80000000000000004D;
		}
		try
		{
			AfterDeathRateR = Double.parseDouble(config.getProperty("SYSTEMCONST.AfterDeathRateR"));
			System.out.println((new StringBuilder("SYSTEMCONST.AfterDeathRateR = ")).append(AfterDeathRateR).toString());
		}
		catch (Exception e)
		{
			AfterDeathRateR = 0.5D;
		}
		try
		{
			endAge = Integer.parseInt(config.getProperty("SYSTEMCONST.RET_ENDAGE"));
			System.out.println((new StringBuilder("SYSTEMCONST.RET_ENDAGE = ")).append(endAge).toString());
		}
		catch (Exception e)
		{
			endAge = 105;
		}
		try
		{
			PdfImgHeight = Integer.parseInt(config.getProperty("SYSTEMCONST.PDF_IMG_HEIGHT"));
			System.out.println((new StringBuilder("SYSTEMCONST.PDF_IMG_HEIGHT = ")).append(PdfImgHeight).toString());
		}
		catch (Exception e)
		{
			PdfImgHeight = 1000;
		}
		try
		{
			PdfImgWidth = Integer.parseInt(config.getProperty("SYSTEMCONST.PDF_IMG_WIDTH"));
			System.out.println((new StringBuilder("SYSTEMCONST.PDF_IMG_WIDTH = ")).append(PdfImgWidth).toString());
		}
		catch (Exception e)
		{
			PdfImgWidth = 1000;
		}
		try
		{
			PdfImgLabelSize = Integer.parseInt(config.getProperty("SYSTEMCONST.PDF_IMG_LABELSIZE"));
			System.out.println((new StringBuilder("SYSTEMCONST.PDF_IMG_LABELSIZE = ")).append(PdfImgLabelSize).toString());
		}
		catch (Exception e)
		{
			PdfImgLabelSize = 16;
		}
		try
		{
			PageImgWidth = Integer.parseInt(config.getProperty("SYSTEMCONST.PAGE_IMG_WIDTH"));
			System.out.println((new StringBuilder("SYSTEMCONST.PAGE_IMG_WIDTH = ")).append(PageImgWidth).toString());
		}
		catch (Exception e)
		{
			PageImgWidth = 800;
		}
		try
		{
			PageImgHeight = Integer.parseInt(config.getProperty("SYSTEMCONST.PAGE_IMG_HEIGHT"));
			System.out.println((new StringBuilder("SYSTEMCONST.PAGE_IMG_HEIGHT = ")).append(PageImgHeight).toString());
		}
		catch (Exception e)
		{
			PageImgHeight = 800;
		}
		try
		{
			PageImgLabelSize = Integer.parseInt(config.getProperty("SYSTEMCONST.PAGE_IMG_LABELSIZE"));
			System.out.println((new StringBuilder("SYSTEMCONST.PAGE_IMG_LABELSIZE = ")).append(PageImgLabelSize).toString());
		}
		catch (Exception e)
		{
			PageImgLabelSize = 12;
		}
		try
		{
			levelChildAdout = Integer.parseInt(config.getProperty("RET_CONST.ChildAdout"));
			System.out.println((new StringBuilder("RET_CONST.ChildAdout = ")).append(levelChildAdout).toString());
		}
		catch (Exception e)
		{
			levelChildAdout = 2;
		}
		try
		{
			levelRetired = Integer.parseInt(config.getProperty("RET_CONST.Retired"));
			System.out.println((new StringBuilder("RET_CONST.Retired = ")).append(levelRetired).toString());
		}
		catch (Exception e)
		{
			levelRetired = 1;
		}
		try
		{
			levelDeath = Integer.parseInt(config.getProperty("RET_CONST.Death"));
			System.out.println((new StringBuilder("RET_CONST.Death = ")).append(levelDeath).toString());
		}
		catch (Exception e)
		{
			levelDeath = 3;
		}
		try
		{
			BLoanRate = Double.parseDouble(config.getProperty("client.BLoanRate"));
			System.out.println((new StringBuilder("client.BLoanRate = ")).append(BLoanRate).toString());
		}
		catch (Exception e)
		{
			BLoanRate = 0.061199999999999997D;
		}
		try
		{
			LoanRate = Double.parseDouble(config.getProperty("client.LoanRate"));
			System.out.println((new StringBuilder("client.LoanRate = ")).append(LoanRate).toString());
		}
		catch (Exception e)
		{
			LoanRate = 0.038699999999999998D;
		}
		try
		{
			fontMapping.put("宋体", BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("/songti.ttf").toString(), "Identity-H", false));
			fontMapping.put("仿宋", BaseFont.createFont(getRealPath("/conf/Font/simkai.ttf"), "Identity-H", false));
			fontMapping.put("楷体", BaseFont.createFont(getRealPath("/conf/Font/simkai.ttf"), "Identity-H", false));
			fontMapping.put("黑体", BaseFont.createFont(getRealPath("/conf/Font/simhei.ttf"), "Identity-H", false));
			fontMapping.put("华文细黑", BaseFont.createFont(getRealPath("/conf/Font/STXIHEI.TTF"), "Identity-H", false));
			fontMapping.put("ARIAL", BaseFont.createFont(getRealPath("/conf/Font/arial.ttf"), "Cp1252", false));
			fontMapping.put("ARIALBOLD", BaseFont.createFont(getRealPath("/conf/Font/arialbd.ttf"), "Cp1252", false));
			fontMapping.put("ARIAL_BOLD", BaseFont.createFont(getRealPath("/conf/Font/arialbd.ttf"), "Cp1252", false));
			fontMapping.put("ARIALITALIC", BaseFont.createFont(getRealPath("/conf/Font/ariali.ttf"), "Cp1252", false));
			fontMapping.put("ARIAL_ITALIC", BaseFont.createFont(getRealPath("/conf/Font/ariali.ttf"), "Cp1252", false));
			fontMapping.put("ARIALBOLDITALIC", BaseFont.createFont(getRealPath("/conf/Font/arialbi.ttf"), "Cp1252", false));
			fontMapping.put("ARIAL_BOLDITALIC", BaseFont.createFont(getRealPath("/conf/Font/arialbi.ttf"), "Cp1252", false));
			fontMapping.put("TAHOMA", BaseFont.createFont(getRealPath("/conf/Font/tahoma.ttf"), "Cp1252", false));
			fontMapping.put("STSongStd-Light", BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false));
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static StaticConst getInstance()
	{
		if (me == null)
			me = new StaticConst();
		return me;
	}

	public static StaticConst getInstance(ServletContext ctx)
	{
		if (me == null)
			me = new StaticConst(ctx);
		return me;
	}

	public String getRealRootPath()
	{
		return RealRootPath;
	}

	public String getRealPath(String path)
	{
		return ctx.getRealPath(path);
	}

	public int getChildFeedEndAge()
	{
		return childFeedEndAge;
	}

	public int getMaleDeathAge()
	{
		return maleDeathAge;
	}

	public int getFemaleDeathAge()
	{
		return femaleDeathAge;
	}

	public int getDefaultEduEne()
	{
		return defaultEduEne;
	}

	public int getFemaleRetireAge()
	{
		return femaleRetireAge;
	}

	public int getMaleRetireAge()
	{
		return maleRetireAge;
	}

	public double getRetiredRate()
	{
		return RetiredRate;
	}

	public double getAfterDeathRate()
	{
		return AfterDeathRate;
	}

	public double getChildAdoutRate()
	{
		return ChildAdoutRate;
	}

	public int getLevelChildAdout()
	{
		return levelChildAdout;
	}

	public int getLevelRetired()
	{
		return levelRetired;
	}

	public int getLevelDeath()
	{
		return levelDeath;
	}

	public Font getFont(String str_fontname)
	{
		Iterator it = fontMapping.keySet().iterator();
		boolean flag = false;
		while (it.hasNext()) 
		{
			String fontName = (String)it.next();
			if (fontName.equals(str_fontname))
				flag = true;
		}
		if (!flag)
			str_fontname = "宋体";
		return new Font((BaseFont)fontMapping.get(str_fontname));
	}

	public int getEndAge()
	{
		return endAge;
	}

	public int getPdfImgWidth()
	{
		return PdfImgWidth;
	}

	public int getPdfImgHeight()
	{
		return PdfImgHeight;
	}

	public int getPdfImgLabelSize()
	{
		return PdfImgLabelSize;
	}

	public int getPageImgWidth()
	{
		return PageImgWidth;
	}

	public int getPageImgHeight()
	{
		return PageImgHeight;
	}

	public int getPageImgLabelSize()
	{
		return PageImgLabelSize;
	}

	public double getAfterDeathRateR()
	{
		return AfterDeathRateR;
	}

	public double getBLoanRate()
	{
		return BLoanRate;
	}

	public double getLoanRate()
	{
		return LoanRate;
	}
}
