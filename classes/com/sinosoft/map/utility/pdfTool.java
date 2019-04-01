// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   pdfTool.java

package com.sinosoft.map.utility;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.sinosoft.map.lis.db.MCodeDB;
import com.sinosoft.map.lis.vschema.MCodeSet;
import com.sinosoft.map.style.pdf.FileStyle;
import com.sinosoft.map.style.pdf.FooterStyle;
import com.sinosoft.map.style.pdf.HeaderStyle;
import com.sinosoft.map.style.pdf.ImageStyle;
import com.sinosoft.map.style.pdf.TableBodyStyle;
import com.sinosoft.map.style.pdf.TableHeadStyle;
import com.sinosoft.map.style.pdf.TextStyle;
import com.sinosoft.map.style.pdf.TitleStyle;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Referenced classes of package com.sinosoft.map.utility:
//			PdfToolFun, VData, XMLParser, SSRS

public class pdfTool extends PdfToolFun
{

	private static final Logger logger = Logger.getLogger(com/sinosoft/map/utility/pdfTool);
	protected Document document;
	protected PdfWriter pdfWriter;
	protected Table table;
	protected PdfPTable pdfPtable;
	protected Paragraph tempPara;
	private VData headerInfo;
	protected Image tempImage;
	public PdfTemplate tpl;
	public BaseFont helv;
	private int printNum;
	private int recoverNum;
	private int recoverA4Num;
	private boolean needRepeat;
	private ArrayList rotateList;

	public boolean makeFile(String tFilePath, FileStyle fs)
	{
		boolean needRotate = false;
		boolean needA4rotate = false;
		String riskCode = headerInfo.get(0).toString();
		String needAtone = headerInfo.get(1).toString();
		MCodeDB MCodeDB = new MCodeDB();
		String sql = (new StringBuilder("select * from MCode where code='")).append(riskCode).append("' and codetype='printType'").toString();
		MCodeSet MCodeSet = MCodeDB.executeQuery(sql);
		if (MCodeSet != null && MCodeSet.size() != 0)
			needRotate = true;
		if (needRotate && needAtone.equals("one"))
			needA4rotate = true;
		Vector vector = makeFileFun(document, pdfWriter, tFilePath, fs, needA4rotate);
		if (vector == null)
			return false;
		if (vector == null)
			return false;
		document = (Document)vector.get(0);
		pdfWriter = (PdfWriter)vector.get(1);
		try
		{
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			Font font = new Font(bfChinese, 9F, 0);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	public boolean makeText(String tContent, TextStyle ts)
	{
		try
		{
			Paragraph paragraph = makeTextFun(tContent, ts);
			if (ts.isAlone())
				document.add(paragraph);
			else
				tempPara = paragraph;
		}
		catch (DocumentException de)
		{
			logger.error((new StringBuilder("makeText(String, TextStyle) - ")).append(de.getMessage()).toString(), de);
			return false;
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeText(String, TextStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public boolean makeTitle(String title, TitleStyle ts)
	{
		boolean reBln = makeTitleFun(pdfWriter, title, ts);
		return reBln;
	}

	public boolean makeImage(String path, ImageStyle is)
	{
		try
		{
			Image image = makeImageFun(path, is);
			if (image != null && is.isAlone())
				document.add(image);
			else
				tempImage = image;
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeImage(String, ImageStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public boolean makeTableHead(java.util.List headers, TableHeadStyle ths, boolean tableType)
	{
		if (tableType)
			return makePdfPTableHead(headers, ths);
		else
			return false;
	}

	public boolean makeTableHead(String colNames[], TableHeadStyle ths, boolean pdfpTable)
	{
		if (pdfpTable)
			return makePdfPTableHead(colNames, ths);
		else
			return makeTableHead(colNames, ths);
	}

	public boolean makeTableHead(String colNames[], TableHeadStyle ths)
	{
		table = makeTableHeadFun(table, colNames, ths);
		if (table == null)
			return false;
		try
		{
			if (ths.haveTableBody())
				table.endHeaders();
			else
				document.add(table);
		}
		catch (DocumentException e)
		{
			logger.error("makeTableHead(String[], TableHeadStyle)", e);
		}
		return true;
	}

	public boolean makePdfPTableHead(String colNames[], TableHeadStyle ths)
	{
		try
		{
			pdfPtable = makePdfPTableHeadFun(colNames, ths);
			if (ths.haveTableBody())
				pdfPtable.setHeaderRows(ths.getHeaderRows());
			else
				document.add(pdfPtable);
		}
		catch (Exception ex)
		{
			logger.error("makePdfPTableHead(String[], TableHeadStyle)", ex);
		}
		return true;
	}

	public boolean makePdfPTableHead(java.util.List headers, TableHeadStyle ths)
	{
		try
		{
			pdfPtable = makePdfPTableHeadFun(headers, ths);
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableHead(List, TableHeadStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public boolean makePDFPTableBody(SSRS tSSRS, TableBodyStyle tbs)
	{
		try
		{
			makeTableBodyFun(pdfPtable, tSSRS, tbs);
			if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
				document.add(pdfPtable);
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public boolean makePDFPTableBodyH(SSRS tSSRS, TableBodyStyle tbs)
	{
		try
		{
			makeTableBodyFunH(pdfPtable, tSSRS, tbs);
			if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
				document.add(pdfPtable);
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public boolean makeTableBody(SSRS tSSRS, TableBodyStyle tbs)
	{
		try
		{
			makeTableBodyFun(table, tSSRS, tbs);
			if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
				document.add(table);
		}
		catch (DocumentException e)
		{
			logger.error("makeTableBody(SSRS, TableBodyStyle)", e);
			return false;
		}
		return true;
	}

	protected boolean makeOnTableBody(SSRS tSSRS, TableBodyStyle tbs)
	{
		try
		{
			PdfPTable pdfPTable = makeOnTableBodyFun(tSSRS, tbs);
			if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
				document.add(pdfPTable);
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeOnTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public boolean makeHeader(String content, HeaderStyle hs)
	{
		try
		{
			com.lowagie.text.HeaderFooter headerFooter = makeHeaderFun(content, hs);
			document.setHeader(headerFooter);
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeHeader(String, HeaderStyle) - ")).append(ex.getMessage()).toString(), ex);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("makeHeader(String, HeaderStyle) - ")).append(ex).toString());
			return false;
		}
		return true;
	}

	public boolean makeFooter(String content, FooterStyle fs)
	{
		try
		{
			if (!fs.isContinue())
				document.resetPageCount();
			com.lowagie.text.HeaderFooter footer = makeFooterFun(content, fs);
			document.setFooter(footer);
			if (logger.isDebugEnabled())
				logger.debug("makeFooter(String, FooterStyle) - yejiao success !");
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeFooter(String, FooterStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	protected boolean makeNewLine()
	{
		try
		{
			Chunk chunk = new Chunk("                                                                                                                                            ");
			chunk.setUnderline(new Color(128, 128, 128), 0.01F, 0.01F, 15F, 0.0F, 0);
			document.add(chunk);
		}
		catch (DocumentException e)
		{
			logger.error("makeNewLine()", e);
			return false;
		}
		return true;
	}

	public boolean makePicTalbe(TableBodyStyle tbs)
	{
		if (tempImage == null || tempPara == null)
		{
			logger.equals("mekePicTable fail");
			return false;
		}
		if (tbs.isUsePdfPTable())
		{
			if (!makePicPdfPtable(tbs))
				return false;
		} else
		if (!makePicTable(tbs))
			return false;
		return true;
	}

	public boolean makePicPdfPtable(TableBodyStyle tbs)
	{
		PdfPTable table = makePicPTableFun(tempPara, tempImage, tbs);
		PdfPTable pTable = new PdfPTable(1);
		pTable.setWidthPercentage(100F);
		PdfPCell cell = new PdfPCell(table);
		cell.setBorder(0);
		pTable.addCell(cell);
		try
		{
			document.add(pTable);
		}
		catch (DocumentException e)
		{
			logger.error("makePicPdfPtable(TableBodyStyle)", e);
		}
		return true;
	}

	public boolean makeLargeText(Element element)
	{
		Paragraph largeText = null;
		NodeList list = element.getElementsByTagName("header");
		Element e = null;
		TextStyle ts = null;
		String size = null;
		String content = null;
		String font = null;
		String style = null;
		String align = null;
		String space = null;
		String remark = null;
		String isStart = null;
		String isEnd = null;
		for (int i = 0; i < list.getLength(); i++)
		{
			ts = new TextStyle();
			e = (Element)list.item(i);
			size = XMLParser.getTagContent(e, "size", "");
			font = XMLParser.getTagContent(e, "font", "");
			style = XMLParser.getTagContent(e, "style", "");
			content = XMLParser.getTagContent(e, "content", "");
			align = XMLParser.getTagContent(e, "align", "");
			isStart = XMLParser.getTagContent(e, "isStart", "");
			isEnd = XMLParser.getTagContent(e, "isEnd", "");
			space = XMLParser.getTagContent(e, "space", "");
			ts.setSize(Float.parseFloat(size));
			if (font == null || font.equals(""))
				ts.setFontName(0);
			else
			if (font.equalsIgnoreCase("黑体"))
				ts.setFontName(3);
			else
			if (font.equalsIgnoreCase("楷体"))
				ts.setFontName(2);
			else
			if (font.equalsIgnoreCase("仿宋"))
				ts.setFontName(1);
			else
			if (font.equalsIgnoreCase("Arial"))
				ts.setFontName(4);
			else
			if (font.equalsIgnoreCase("Arial_BOLD"))
				ts.setFontName(5);
			else
			if (font.equalsIgnoreCase("Arial_ITALIC"))
				ts.setFontName(6);
			else
			if (font.equalsIgnoreCase("Arial_BOLDITALIC"))
				ts.setFontName(7);
			if (align == null)
				ts.setAlign(1);
			else
			if (align.equalsIgnoreCase("ALIGN_RIGHT"))
				ts.setAlign(2);
			else
			if (align.equalsIgnoreCase("ALIGN_LEFT"))
				ts.setAlign(0);
			else
			if (align.equalsIgnoreCase("ALIGN_CENTER"))
				ts.setAlign(1);
			if (style == null || style.trim().equals(""))
				ts.setStyle(0);
			else
			if (style.equalsIgnoreCase("BOLD"))
				ts.setStyle(1);
			else
			if (style.equalsIgnoreCase("ITALIC"))
				ts.setStyle(2);
			else
			if (style.equalsIgnoreCase("BOLDITALIC"))
				ts.setStyle(3);
			else
				ts.setStyle(0);
			if (isStart != null && !isStart.equals(""))
				ts.setStart(Boolean.valueOf(isStart).booleanValue());
			if (isEnd != null && !isEnd.equals(""))
				ts.setEnd(Boolean.valueOf(isEnd).booleanValue());
			if (ts.isStart())
				if (space != null && !space.equals(""))
					largeText = new Paragraph(Float.parseFloat(space));
				else
					largeText = new Paragraph();
			Chunk chunk = makeLargeTextFun(content, ts);
			largeText.add(chunk);
			largeText.setAlignment(ts.getAlign());
			if (ts.isEnd())
				try
				{
					document.add(largeText);
				}
				catch (DocumentException e1)
				{
					logger.error("makeLargeText(org.w3c.dom.Element)", e1);
				}
		}

		return true;
	}

	public boolean makePicTable(TableBodyStyle tbs)
	{
		return false;
	}

	private boolean addElement(com.lowagie.text.Element element)
	{
		try
		{
			document.add(element);
		}
		catch (Exception e)
		{
			logger.error("PDF在处理Element时发生异常，具体原因为：", e);
			return false;
		}
		return true;
	}

	public boolean MakePDF1(VData Vtype, VData Vcontent, VData Vstyle)
	{
		String type = "";
		String content = "";
		if (Vtype.size() < 5)
		{
			Vtype.add("TEXT");
			Vcontent.add("  ");
			Vstyle.add(new TextStyle());
		}
		for (int i = 0; i < Vtype.size(); i++)
		{
			type = (String)Vtype.get(i);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("MakePDF1(VData, VData, VData) - ID--")).append(i).append("********TYPE--").append(type).append("********Content--").append(Vcontent.get(i).toString()).toString());
			if (type.equals("FILE"))
			{
				content = (String)Vcontent.get(i);
				FileStyle fs = (FileStyle)Vstyle.get(i);
				if (!makeFile(content, fs))
					return false;
			}
			if (type.equals("TEXT"))
			{
				Object value = Vcontent.get(i);
				if (value instanceof String)
				{
					if (logger.isDebugEnabled())
						logger.debug((new StringBuilder("MakePDF1(VData, VData, VData) - content = ")).append(value).toString());
					TextStyle ts = new TextStyle();
					ts = (TextStyle)Vstyle.get(i);
					if (!makeText(value.toString(), ts))
						return false;
				} else
				if (value instanceof Element)
				{
					Element element = (Element)value;
					if (!makeLargeText(element))
						return false;
				}
			}
			if (type.equals("TITLE"))
			{
				content = (String)Vcontent.get(i);
				TitleStyle TS = new TitleStyle();
				TS = (TitleStyle)Vstyle.get(i);
				if (!makeTitle(content, TS))
					return false;
			}
			if (type.equals("IMAGE"))
			{
				content = (String)Vcontent.get(i);
				ImageStyle is = new ImageStyle();
				is = (ImageStyle)Vstyle.get(i);
				String imageType = is.getImageType().toUpperCase();
				if ((imageType.equals("JPG") || imageType.equals("GIF") || imageType.equals("PNG")) && !makeImage(content, is))
					return false;
			}
			if (type.equals("TABLEHEAD"))
			{
				TableHeadStyle ths = new TableHeadStyle();
				ths = (TableHeadStyle)Vstyle.get(i);
				boolean usePDFPTable = false;
				if (ths.getheadType() < 0)
					usePDFPTable = true;
				if (Math.abs(ths.getheadType()) == 1)
				{
					java.util.List list = (java.util.List)Vcontent.get(i);
					if (!makeTableHead(list, ths, usePDFPTable))
						return false;
				}
				if (Math.abs(ths.getheadType()) == 2)
				{
					String col[] = (String[])Vcontent.get(i);
					if (!makeTableHead(col, ths, usePDFPTable))
						return false;
				}
			}
			if (type.equals("TABLEBODY"))
			{
				SSRS tSSRS = (SSRS)Vcontent.get(i);
				TableBodyStyle tbs = new TableBodyStyle();
				tbs = (TableBodyStyle)Vstyle.get(i);
				if (tbs.isUsePdfPTable())
				{
					if (!makePDFPTableBody(tSSRS, tbs))
						return false;
				} else
				if (!makeTableBody(tSSRS, tbs))
					return false;
			}
			if (type.equals("TABLEBODY-H"))
			{
				SSRS tSSRS = (SSRS)Vcontent.get(i);
				TableBodyStyle tbs = new TableBodyStyle();
				tbs = (TableBodyStyle)Vstyle.get(i);
				if (tbs.isUsePdfPTable())
				{
					if (!makePDFPTableBodyH(tSSRS, tbs))
						return false;
				} else
				if (!makeTableBody(tSSRS, tbs))
					return false;
			}
			if (type.equals("PICTABLEBODY"))
			{
				TableBodyStyle tbs = (TableBodyStyle)Vstyle.get(i);
				if (!makePicTalbe(tbs))
					return false;
			}
			if (type.equals("ONTABLEBODY"))
			{
				SSRS tSSRS = (SSRS)Vcontent.get(i);
				TableBodyStyle tbs = new TableBodyStyle();
				tbs = (TableBodyStyle)Vstyle.get(i);
				if (!makeOnTableBody(tSSRS, tbs))
					return false;
			}
			if (type.equals("HEADER"))
			{
				content = (String)Vcontent.get(i);
				if (logger.isDebugEnabled())
					logger.debug((new StringBuilder("MakePDF1(VData, VData, VData) - ")).append(content).toString());
				HeaderStyle hs = new HeaderStyle();
				hs = (HeaderStyle)Vstyle.get(i);
				if (!makeHeader(content, hs))
					return false;
			}
			if (type.equals("FOOTER"))
			{
				content = (String)Vcontent.get(i);
				FooterStyle fs = new FooterStyle();
				fs = (FooterStyle)Vstyle.get(i);
				if (!makeFooter(content, fs))
					return false;
			}
			if (type.equals("NEWPAGE") && !makeNewPageFun(document))
				return false;
			if (type.equals("ELEMENT"))
			{
				com.lowagie.text.Element element = (com.lowagie.text.Element)Vcontent.get(i);
				if (!addElement(element))
					return false;
			}
		}

		makeCloseFun(document);
		return true;
	}

	public boolean MakePDF1(VData Vtype, VData Vcontent, VData Vstyle, VData headerInfo)
	{
		setPrintNums(0);
		if (needRepeat)
			SetneedRepeat(recoverNum, recoverA4Num);
		boolean isLongTitle = false;
		int isTitle = 0;
		this.headerInfo = headerInfo;
		String type = "";
		String content = "";
		int newPage = 0;
		int isRotate = 0;
		int offset = 3;
		boolean needRotate = false;
		int vcontentOffset = 5;
		String riskCode = this.headerInfo.get(0).toString();
		String needAtone = this.headerInfo.get(1).toString();
		boolean haveT = ((Boolean)this.headerInfo.get(2)).booleanValue();
		boolean haveS = ((Boolean)this.headerInfo.get(3)).booleanValue();
		MCodeDB MCodeDB = new MCodeDB();
		String sql = (new StringBuilder("select * from MCode where code='")).append(riskCode).append("' and codetype='printType'").toString();
		MCodeSet MCodeSet = MCodeDB.executeQuery(sql);
		if (MCodeSet != null && MCodeSet.size() != 0)
		{
			needRotate = true;
			vcontentOffset = 3;
		}
		if (haveT)
			offset = 2;
		for (int i = 0; i < Vtype.size(); i++)
		{
			rotateList.clear();
			type = (String)Vtype.get(i);
			if (i < Vcontent.size() - vcontentOffset && !type.equalsIgnoreCase("FOOTER") && !type.equalsIgnoreCase("HEADER") && (!needRotate || !needAtone.equals("one")) && needRotate && i + offset < Vcontent.size() && Vcontent.get(i + offset).toString().lastIndexOf("保险利益测算演示表") != -1 && i != 0)
			{
				newPage = 1;
				isRotate = 0;
			}
			if (type.equals("ELEMENT"))
			{
				openDocument();
				com.lowagie.text.Element element = (com.lowagie.text.Element)Vcontent.get(i);
				if (!addElement(element))
					return false;
			}
			if (type.equals("FILE"))
			{
				content = (String)Vcontent.get(i);
				FileStyle fs = (FileStyle)Vstyle.get(i);
				if (!makeFile(content, fs))
					return false;
			}
			if (type.equals("TEXT"))
			{
				openDocument();
				Object value = Vcontent.get(i);
				if (value instanceof String)
				{
					if (logger.isDebugEnabled())
						logger.debug((new StringBuilder("MakePDF1(VData, VData, VData) - content = ")).append(value).toString());
					TextStyle ts = new TextStyle();
					ts = (TextStyle)Vstyle.get(i);
					if (!makeText(value.toString(), ts))
						return false;
				} else
				if (value instanceof Element)
				{
					Element element = (Element)value;
					if (!makeLargeText(element))
						return false;
				}
			}
			if (type.equals("TITLE"))
			{
				openDocument();
				content = (String)Vcontent.get(i);
				TitleStyle TS = new TitleStyle();
				TS = (TitleStyle)Vstyle.get(i);
				if (!makeTitle(content, TS))
					return false;
			}
			if (type.equals("IMAGE"))
			{
				openDocument();
				content = (String)Vcontent.get(i);
				ImageStyle is = new ImageStyle();
				is = (ImageStyle)Vstyle.get(i);
				String imageType = is.getImageType().toUpperCase();
				if ((imageType.equals("JPG") || imageType.equals("GIF") || imageType.equals("PNG")) && !makeImage(content, is))
					return false;
			}
			if (type.equals("TABLEHEAD"))
			{
				openDocument();
				TableHeadStyle ths = new TableHeadStyle();
				ths = (TableHeadStyle)Vstyle.get(i);
				boolean usePDFPTable = false;
				if (ths.getheadType() < 0)
					usePDFPTable = true;
				if (Math.abs(ths.getheadType()) == 1)
				{
					java.util.List list = (java.util.List)Vcontent.get(i);
					if (!makeTableHead(list, ths, usePDFPTable))
						return false;
				}
				if (Math.abs(ths.getheadType()) == 2)
				{
					String col[] = (String[])Vcontent.get(i);
					if (!makeTableHead(col, ths, usePDFPTable))
						return false;
				}
			}
			if (type.equals("TABLEBODY"))
			{
				openDocument();
				SSRS tSSRS = (SSRS)Vcontent.get(i);
				TableBodyStyle tbs = new TableBodyStyle();
				tbs = (TableBodyStyle)Vstyle.get(i);
				if (tbs.isUsePdfPTable())
				{
					if (!makePDFPTableBody(tSSRS, tbs))
						return false;
				} else
				if (!makeTableBody(tSSRS, tbs))
					return false;
			}
			if (type.equals("TABLEBODY-H"))
			{
				openDocument();
				SSRS tSSRS = (SSRS)Vcontent.get(i);
				TableBodyStyle tbs = new TableBodyStyle();
				tbs = (TableBodyStyle)Vstyle.get(i);
				if (tbs.isUsePdfPTable())
				{
					if (!makePDFPTableBodyH(tSSRS, tbs))
						return false;
				} else
				if (!makeTableBody(tSSRS, tbs))
					return false;
			}
			if (type.equals("PICTABLEBODY"))
			{
				openDocument();
				TableBodyStyle tbs = (TableBodyStyle)Vstyle.get(i);
				if (!makePicTalbe(tbs))
					return false;
			}
			if (type.equals("ONTABLEBODY"))
			{
				openDocument();
				SSRS tSSRS = (SSRS)Vcontent.get(i);
				TableBodyStyle tbs = new TableBodyStyle();
				tbs = (TableBodyStyle)Vstyle.get(i);
				if (!makeOnTableBody(tSSRS, tbs))
					return false;
			}
			if (type.equals("HEADER"))
			{
				content = (String)Vcontent.get(i);
				if (logger.isDebugEnabled())
					logger.debug((new StringBuilder("MakePDF1(VData, VData, VData) - ")).append(content).toString());
				HeaderStyle hs = new HeaderStyle();
				hs = (HeaderStyle)Vstyle.get(i);
				if (!makeHeader(content, hs))
					return false;
			}
			if (type.equals("FOOTER"))
			{
				content = (String)Vcontent.get(i);
				FooterStyle fs = new FooterStyle();
				fs = (FooterStyle)Vstyle.get(i);
				if (!makeFooter(content, fs))
					return false;
			}
			if (type.equals("NEWPAGE"))
			{
				openDocument();
				if (!makeNewPageFun(document))
					return false;
			}
			if (newPage == 1 && isRotate != 1)
			{
				rotateList.add("rorate");
				document.setPageSize(PageSize.A4.rotate());
				openDocument();
				if (!makeNewPageFun(document))
					return false;
				newPage = 0;
				isRotate = 1;
			}
			if (needRotate && !haveT && !haveS)
			{
				if (!isLongTitle && needRotate)
				{
					for (int j = Vcontent.size() - 1; j > 0; j--)
					{
						if (j - 7 <= 0 || Vcontent.get(j - 7).toString().lastIndexOf("保险利益测算演示表") == -1 || !needRotate)
							continue;
						isLongTitle = true;
						isTitle = j;
						break;
					}

				}
				if (i == isTitle && needRotate)
				{
					rotateList.add("rorateA4");
					document.setPageSize(PageSize.A4);
					openDocument();
					if (!makeNewPageFun(document))
						return false;
				}
			} else
			if (i - 7 > 0 && Vcontent.get(i - 7).toString().lastIndexOf("保险利益测算演示表") != -1 && needRotate)
			{
				rotateList.add("rorateA4");
				document.setPageSize(PageSize.A4);
				openDocument();
				if (!makeNewPageFun(document))
					return false;
			}
			if (rotateList.size() >= 1 && "rorate".equals(((String)rotateList.get(rotateList.size() - 1)).toString()))
			{
				printNum = getPrintNums();
				recoverNum = printNum - 1;
				needRepeat = true;
			}
			if (rotateList.size() >= 1 && "rorateA4".equals(((String)rotateList.get(rotateList.size() - 1)).toString()))
			{
				printNum = getPrintNums();
				recoverA4Num = printNum - 1;
				needRepeat = true;
			}
		}

		makeCloseFun(document);
		return true;
	}

	private void openDocument()
	{
		if (!document.isOpen())
		{
			pdfWriter.setPageEvent(this);
			document.open();
		}
	}

	public pdfTool()
	{
		printNum = 0;
		recoverNum = 10000;
		recoverA4Num = 10000;
		needRepeat = false;
		rotateList = new ArrayList();
	}

	public pdfTool(String path)
	{
		printNum = 0;
		recoverNum = 10000;
		recoverA4Num = 10000;
		needRepeat = false;
		rotateList = new ArrayList();
		this.path = path;
	}

	public static void main(String args1[])
	{
	}

	public VData getHeaderInfo()
	{
		return headerInfo;
	}

	public void setHeaderInfo(VData headerInfo)
	{
		this.headerInfo = headerInfo;
	}

	public boolean isNeedRepeat()
	{
		return needRepeat;
	}

}
