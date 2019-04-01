// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PdfToolFun.java

package com.sinosoft.map.utility;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.sinosoft.map.style.pdf.FileStyle;
import com.sinosoft.map.style.pdf.FontStyle;
import com.sinosoft.map.style.pdf.FooterStyle;
import com.sinosoft.map.style.pdf.HeaderStyle;
import com.sinosoft.map.style.pdf.ImageStyle;
import com.sinosoft.map.style.pdf.TableBodyStyle;
import com.sinosoft.map.style.pdf.TableHeadStyle;
import com.sinosoft.map.style.pdf.TextStyle;
import com.sinosoft.map.style.pdf.TitleStyle;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Vector;
import org.apache.log4j.Logger;

// Referenced classes of package com.sinosoft.map.utility:
//			pdfTool, StrTool, Header, XmlTable, 
//			SSRS

public class PdfToolFun extends PdfPageEventHelper
{

	private static final Logger logger = Logger.getLogger(com/sinosoft/map/utility/pdfTool);
	public static final int TYPE_FILE = 0;
	public static final int TYPE_HEADER = 1;
	public static final int TYPE_FOOTER = 2;
	public static final int TYPE_IMAGE = 6;
	public static final int TYPE_TEXT = 5;
	public static final int TYPE_TITLE = 4;
	public static final int TYPE_NEWPAGE = 3;
	public static final int TYPE_TABLEHEAD = 7;
	public static final int TYPE_TABLEBODY = 8;
	private int recoverNum;
	private int recoverA4Num;
	private int printNums;
	protected String path;
	public PdfTemplate tpl;
	public BaseFont helv;
	protected HashMap hsmTitleUnitRow;

	public Vector makeFileFun(Document document, PdfWriter pdfWriter, String tFilePath, FileStyle fs)
	{
		Vector vetData = new Vector();
		try
		{
			document = new Document();
			document.setMargins(fs.getMarginLeft(), fs.getMarginRight(), fs.getMarginTop(), fs.getMarginBottom());
			document.setPageSize(fs.getPageSize());
			File file = new File(tFilePath);
			pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			Font pageNumFont = new Font(bfChinese, 9F, 0);
			if (!fs.isHeaderOrFooterInFirstPage())
			{
				pdfWriter.setPageEvent(this);
				document.open();
			}
			document.open();
			vetData.add(document);
			vetData.add(pdfWriter);
		}
		catch (DocumentException de)
		{
			logger.error((new StringBuilder("makeFile(String, FileStyle) - ")).append(de.getMessage()).toString(), de);
			return null;
		}
		catch (IOException ioe)
		{
			logger.error((new StringBuilder("makeFile(String, FileStyle) - ")).append(ioe.getMessage()).toString(), ioe);
			return null;
		}
		return vetData;
	}

	public Vector makeFileFun(Document document, PdfWriter pdfWriter, String tFilePath, FileStyle fs, boolean needA4rotate)
	{
		Vector vetData = new Vector();
		try
		{
			document = new Document();
			document.setMargins(fs.getMarginLeft(), fs.getMarginRight(), fs.getMarginTop(), fs.getMarginBottom());
			document.setPageSize(fs.getPageSize());
			if (needA4rotate)
				document.setPageSize(PageSize.A4.rotate());
			File file = new File(tFilePath);
			pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			Font pageNumFont = new Font(bfChinese, 9F, 0);
			if (!fs.isHeaderOrFooterInFirstPage())
			{
				pdfWriter.setPageEvent(this);
				document.open();
			}
			vetData.add(document);
			vetData.add(pdfWriter);
		}
		catch (DocumentException de)
		{
			logger.error((new StringBuilder("makeFile(String, FileStyle) - ")).append(de.getMessage()).toString(), de);
			return null;
		}
		catch (IOException ioe)
		{
			logger.error((new StringBuilder("makeFile(String, FileStyle) - ")).append(ioe.getMessage()).toString(), ioe);
			return null;
		}
		return vetData;
	}

	public Vector makeFileHfFun(Document document, PdfWriter pdfWriter, String tFilePath, FileStyle fs)
	{
		Vector vctReData = new Vector();
		try
		{
			document = new Document();
			document.setMargins(fs.getMarginLeft(), fs.getMarginRight(), fs.getMarginTop(), fs.getMarginBottom());
			document.setPageSize(fs.getPageSize());
			pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(tFilePath));
			vctReData.add(document);
			vctReData.add(pdfWriter);
		}
		catch (DocumentException de)
		{
			logger.error((new StringBuilder("makeFileHfFun(Document, PdfWriter, String, FileStyle) - ")).append(de.getMessage()).toString(), de);
			return null;
		}
		catch (IOException ioe)
		{
			logger.error((new StringBuilder("makeFileHfFun(Document, PdfWriter, String, FileStyle) - ")).append(ioe.getMessage()).toString(), ioe);
			return null;
		}
		return vctReData;
	}

	protected boolean makeCloseFun(Document document)
	{
		document.close();
		return true;
	}

	protected Font getFontChineseFun(FontStyle fs)
	{
		Font FontChinese;
		BaseFont bfChinese = getBaseFontFun(fs);
		FontChinese = new Font(bfChinese, fs.getSize(), fs.getStyle(), fs.getColor());
		return FontChinese;
		Exception ex;
		ex;
		logger.error((new StringBuilder("getFontChinese(FontStyle) - ")).append(ex.getMessage()).toString(), ex);
		return null;
	}

	protected BaseFont getBaseFontFun(FontStyle fs)
	{
		BaseFont bfChinese;
		bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/simkai.ttf").toString(), "Identity-H", false);
		switch (fs.getFontName())
		{
		case 1: // '\001'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/simkai.ttf").toString(), "Identity-H", false);
			break;

		case 2: // '\002'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/simkai.ttf").toString(), "Identity-H", false);
			break;

		case 3: // '\003'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/simhei.ttf").toString(), "Identity-H", false);
			break;

		case 4: // '\004'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/arial.ttf").toString(), "Cp1252", false);
			break;

		case 5: // '\005'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/arialbd.ttf").toString(), "Cp1252", false);
			break;

		case 6: // '\006'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/ariali.ttf").toString(), "Cp1252", false);
			break;

		case 7: // '\007'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/arialbi.ttf").toString(), "Cp1252", false);
			break;

		case 8: // '\b'
			bfChinese = BaseFont.createFont((new StringBuilder(String.valueOf(path))).append("conf/Font/tahoma.ttf").toString(), "Cp1252", false);
			break;
		}
		return bfChinese;
		Exception ex;
		ex;
		logger.error((new StringBuilder("getBaseFont(FontStyle) - ")).append(ex.getMessage()).toString(), ex);
		return null;
	}

	public Paragraph makeTextFun(String tContent, TextStyle ts)
	{
		tContent = StrTool.replaceEx(tContent, "<br>", "\n");
		Paragraph paragraph = new Paragraph(ts.getLeading(), tContent, getFontChineseFun(ts));
		paragraph.setAlignment(ts.getAlign());
		return paragraph;
	}

	public boolean makeTitleFun(PdfWriter pdfWriter, String title, TitleStyle ts)
	{
		String titles[] = title.split("<br>");
		PdfContentByte cb = pdfWriter.getDirectContent();
		try
		{
			cb.beginText();
			cb.setFontAndSize(getBaseFontFun(ts), ts.getSize());
			float step = 5F;
			for (int i = 0; i < titles.length; i++)
				cb.showTextAligned(ts.getAlign(), titles[i], (ts.getPx() * 72F) / 25.4F, ((ts.getPy() - step * (float)i) * 72F) / 25.4F, 0.0F);

			cb.endText();
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTitle(String, TitleStyle) - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	public Image makeImageFun(String path, ImageStyle is)
	{
		Image image = null;
		File file = new File(path);
		if (file.exists())
		{
			try
			{
				image = Image.getInstance(path);
			}
			catch (BadElementException e)
			{
				logger.error("makeImageFun(String, ImageStyle)", e);
			}
			catch (MalformedURLException e)
			{
				logger.error("makeImageFun(String, ImageStyle)", e);
			}
			catch (IOException e)
			{
				logger.error("makeImageFun(String, ImageStyle)", e);
			}
			image.setAlignment(is.getAlign());
			image.scalePercent(is.getScalePercent());
			if (is.getAbsolute())
				image.setAbsolutePosition(is.getPx(), is.getPy());
		}
		return image;
	}

	public Table makeTableHeadFun(Table table, String colNames[], TableHeadStyle ths)
	{
		try
		{
			int col = ths.getCol();
			table = new Table(col);
			table.setBorderWidth(ths.getBorder());
			table.setWidth(ths.getWidth());
			if (ths.getWidths() != null)
				table.setWidths(ths.getWidths());
			table.setBorderColor(ths.getColor());
			table.setPadding(ths.getPadding());
			table.setSpacing(ths.getSpacing());
			Font font = getFontChineseFun(ths);
			for (int i = 0; i < col; i++)
			{
				Phrase phrase = new Phrase(colNames[i], font);
				Cell cell = new Cell(phrase);
				cell.setHorizontalAlignment(ths.getAlign());
				cell.setBorder(ths.getBorder());
				cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
				table.addCell(cell);
			}

			table.endHeaders();
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableHead(String[], TableHeadStyle) - ")).append(ex.getMessage()).toString(), ex);
			logger.error("makeTableHeadFun(Table, String[], TableHeadStyle)", ex);
		}
		return table;
	}

	public PdfPTable makePdfPTableHeadFun(String colNames[], TableHeadStyle ths)
	{
		PdfPTable pdfpTable = null;
		try
		{
			int col = ths.getCol();
			pdfpTable = new PdfPTable(col);
			if (ths.getWidths() != null)
				pdfpTable.setWidths(ths.getWidths());
			pdfpTable.setWidthPercentage(ths.getWidth());
			pdfpTable.setHorizontalAlignment(ths.getTableAlign());
			pdfpTable.setSpacingBefore(ths.getPadding());
			pdfpTable.setSpacingAfter(ths.getPadding());
			Font font = getFontChineseFun(ths);
			for (int i = 0; i < col; i++)
			{
				Phrase phrase = new Phrase(colNames[i], font);
				PdfPCell pdfpCell = new PdfPCell(phrase);
				pdfpCell.setHorizontalAlignment(ths.getAlign());
				pdfpCell.setVerticalAlignment(1);
				pdfpCell.setBorder(ths.getBorder());
				pdfpCell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
				pdfpTable.addCell(pdfpCell);
			}

		}
		catch (Exception ex)
		{
			logger.error("makePdfPTableHeadFun(String[], TableHeadStyle)", ex);
		}
		return pdfpTable;
	}

	public Table makeTableHeadFun(java.util.List headers, TableHeadStyle ths)
	{
		Table table;
		try
		{
			int col = ths.getCol();
			table = new Table(col);
			table.setBorderWidth(ths.getBorder());
			table.setBorder(0);
			table.setWidth(ths.getWidth());
			table.setWidths(ths.getWidths());
			table.setPadding(ths.getPadding());
			table.setSpacing(ths.getSpacing());
			table.setAlignment(ths.getTableAlign());
			Font font = getFontChineseFun(ths);
			Cell cell = null;
			for (int i = 0; i < headers.size(); i++)
			{
				cell = getHeaderToCell((Header)headers.get(i), cell, font, ths);
				table.addCell(cell);
			}

			table.endHeaders();
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableHead(List, TableHeadStyle) - ")).append(ex.getMessage()).toString(), ex);
			logger.error("makeTableHeadFun(List, TableHeadStyle)", ex);
			return null;
		}
		return table;
	}

	public PdfPTable makePdfPTableHeadFun(java.util.List headers, TableHeadStyle ths)
	{
		PdfPTable table = new PdfPTable(ths.getCol());
		try
		{
			table.setWidthPercentage(ths.getWidth());
			table.setWidths(ths.getWidths());
			table.setSpacingBefore(ths.getPadding());
			table.setSpacingAfter(ths.getPadding());
			Font font = getFontChineseFun(ths);
			PdfPCell pdfpcell = null;
			XmlTable xmlTable = null;
			PdfPTable tableElement = null;
			for (int i = 0; i < headers.size(); i++)
				if (headers.get(i).getClass().getSimpleName().equals("Header"))
				{
					pdfpcell = getHeaderToPdfPCell((Header)headers.get(i), font, ths);
					table.addCell(pdfpcell);
				} else
				{
					xmlTable = (XmlTable)headers.get(i);
					tableElement = makePdfPTableFun(xmlTable.getHeaders(), xmlTable.getTableHeadStyle(), ths);
					pdfpcell = getHeaderToTable(tableElement, font, ths);
					table.addCell(pdfpcell);
				}

			table.setHeadersInEvent(true);
			table.setHeaderRows(table.size());
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableHead(List, TableHeadStyle) - ")).append(ex.getMessage()).toString(), ex);
			logger.error("makePdfPTableHeadFun(List, TableHeadStyle)", ex);
			return null;
		}
		return table;
	}

	public PdfPTable makePdfPTableFun(java.util.List headers, TableHeadStyle ths, TableHeadStyle thstwo)
	{
		PdfPTable pdfPTable = null;
		int col = ths.getCol();
		pdfPTable = new PdfPTable(col);
		pdfPTable.setWidthPercentage(ths.getWidth());
		try
		{
			pdfPTable.setWidths(ths.getWidths());
		}
		catch (DocumentException e)
		{
			logger.error("makePdfPTableFun(List, TableHeadStyle, TableHeadStyle)", e);
		}
		try
		{
			Font font = getFontChineseFun(thstwo);
			for (int i = 0; i < headers.size(); i++)
			{
				PdfPCell pdfPCell = getHeaderToPdfPCell((Header)headers.get(i), font, ths);
				pdfPTable.addCell(pdfPCell);
			}

		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeTableHead(List, TableHeadStyle) - ")).append(ex.getMessage()).toString(), ex);
			logger.error("makePdfPTableFun(List, TableHeadStyle, TableHeadStyle)", ex);
			return null;
		}
		return pdfPTable;
	}

	private Cell getHeaderToCell(Header header, Cell cell, Font font, TableHeadStyle ths)
	{
		if (cell == null)
			cell = new Cell();
		try
		{
			cell = new Cell(new Phrase(header.getName(), font));
		}
		catch (BadElementException e)
		{
			throw new RuntimeException("headrtocell转换错误", e);
		}
		cell.setHorizontalAlignment(ths.getAlign());
		cell.setVerticalAlignment(0);
		cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
		if (header.getRow() > 1)
			cell.setRowspan(header.getRow());
		if (header.getCol() > 1)
			cell.setColspan(header.getCol());
		return cell;
	}

	private PdfPCell getHeaderToPdfPCell(Header header, Font font, TableHeadStyle ths)
	{
		PdfPCell cell = new PdfPCell(new Phrase(header.getName(), font));
		cell.setHorizontalAlignment(ths.getAlign());
		cell.setVerticalAlignment(5);
		cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
		if (header.getCol() > 1)
			cell.setColspan(header.getCol());
		return cell;
	}

	private Cell getHeaderToTable(Table table, Font font, TableHeadStyle ths)
	{
		Cell cell = null;
		try
		{
			cell = new Cell(table);
		}
		catch (BadElementException e)
		{
			throw new RuntimeException("headrtocell转换错误", e);
		}
		cell.setHorizontalAlignment(ths.getAlign());
		cell.setVerticalAlignment(0);
		cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
		if (table.size() > 1)
			cell.setRowspan(table.size());
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("getHeaderToTable(Table, Font, TableHeadStyle) - ")).append(table.size()).append("table.size()").toString());
		if (table.getColumns() > 1)
			cell.setColspan(table.getColumns());
		if (logger.isDebugEnabled())
			logger.debug((new StringBuilder("getHeaderToTable(Table, Font, TableHeadStyle) - ")).append(table.getColumns()).append("table.columns()").toString());
		return cell;
	}

	private PdfPCell getHeaderToTable(PdfPTable table, Font font, TableHeadStyle ths)
	{
		PdfPCell cell = null;
		cell = new PdfPCell(table);
		cell.setPaddingBottom(0.0F);
		cell.setPaddingTop(0.0F);
		cell.setPadding(0.0F);
		cell.setHorizontalAlignment(ths.getAlign());
		cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
		if (table.getAbsoluteWidths().length > 1)
			cell.setColspan(table.getAbsoluteWidths().length);
		return cell;
	}

	public PdfPTable makeTableBodyFun(PdfPTable table, SSRS tSSRS, TableBodyStyle tbs)
	{
		Font font = getFontChineseFun(tbs);
		int Align = tbs.getAlign();
		for (int j = 1; j <= tSSRS.getMaxRow(); j++)
		{
			for (int i = 1; i <= tSSRS.getMaxCol(); i++)
			{
				Phrase phrase = new Phrase(tSSRS.GetText(j, i), font);
				PdfPCell cell = new PdfPCell(phrase);
				if (Align == 3 && i == tSSRS.getMaxCol())
					cell.setHorizontalAlignment(2);
				else
				if (Align == 3 && i < tSSRS.getMaxCol())
					cell.setHorizontalAlignment(1);
				else
				if (Align == 20 && i < 3)
					cell.setHorizontalAlignment(1);
				else
				if (Align == 20 && i >= 3)
					cell.setHorizontalAlignment(2);
				else
					cell.setHorizontalAlignment(tbs.getAlign());
				cell.setVerticalAlignment(0);
				cell.setBorder(tbs.getBorder());
				if (tbs.getBodyType() != 2)
				{
					if (j % 2 == 0)
						cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cell);
			}

		}

		Exception ex;
		if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
			return table;
		else
			return null;
		ex;
		logger.error((new StringBuilder("makeTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
		return null;
	}

	public PdfPTable makeTableBodyFunH(PdfPTable table, SSRS tSSRS, TableBodyStyle tbs)
	{
		Font font = getFontChineseFun(tbs);
		for (int j = 1; j <= tSSRS.getMaxRow(); j++)
			if (j == tSSRS.getMaxRow() - 1)
			{
				int k = tSSRS.getMaxCol();
				Phrase phrase = new Phrase(tSSRS.GetText(j, k - 1), font);
				PdfPCell cell = new PdfPCell(phrase);
				cell.setColspan(k - 1);
				cell.setHorizontalAlignment(2);
				cell.setVerticalAlignment(0);
				cell.setBorder(tbs.getBorder());
				if (tbs.getBodyType() != 2)
				{
					if (j % 2 == 0)
						cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cell);
				phrase = new Phrase(tSSRS.GetText(j, k), font);
				PdfPCell cellL = new PdfPCell(phrase);
				cellL.setHorizontalAlignment(2);
				cellL.setVerticalAlignment(0);
				cellL.setBorder(tbs.getBorder());
				if (tbs.getBodyType() != 2)
				{
					if (j % 2 == 0)
						cellL.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cellL.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cellL);
			} else
			if (j == tSSRS.getMaxRow())
			{
				int k = tSSRS.getMaxCol();
				Phrase phrase = new Phrase(tSSRS.GetText(j, 1), font);
				PdfPCell cell = new PdfPCell(phrase);
				cell.setHorizontalAlignment(tbs.getAlign());
				cell.setVerticalAlignment(0);
				cell.setBorder(tbs.getBorder());
				if (tbs.getBodyType() != 2)
				{
					if (j % 2 == 0)
						cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cell);
				phrase = new Phrase(tSSRS.GetText(j, k), font);
				PdfPCell cellL = new PdfPCell(phrase);
				cellL.setColspan(k - 1);
				cellL.setHorizontalAlignment(2);
				cellL.setVerticalAlignment(0);
				cellL.setBorder(tbs.getBorder());
				if (tbs.getBodyType() != 2)
				{
					if (j % 2 == 0)
						cellL.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cellL.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cellL);
			} else
			{
				for (int i = 1; i <= tSSRS.getMaxCol(); i++)
				{
					Phrase phrase = new Phrase(tSSRS.GetText(j, i), font);
					PdfPCell cell = new PdfPCell(phrase);
					if (i == tSSRS.getMaxCol() || i == tSSRS.getMaxCol() - 1)
						cell.setHorizontalAlignment(2);
					else
						cell.setHorizontalAlignment(tbs.getAlign());
					cell.setVerticalAlignment(0);
					cell.setBorder(tbs.getBorder());
					if (tbs.getBodyType() != 2)
					{
						if (j % 2 == 0)
							cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
					} else
					{
						cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
					}
					table.addCell(cell);
				}

			}

		Exception ex;
		if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
			return table;
		else
			return null;
		ex;
		logger.error((new StringBuilder("makeTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
		return null;
	}

	public Table makeTableBodyFun(Table table, SSRS tSSRS, TableBodyStyle tbs)
	{
		Font font = getFontChineseFun(tbs);
		for (int j = 1; j <= tSSRS.getMaxRow(); j++)
		{
			for (int i = 1; i <= tSSRS.getMaxCol(); i++)
			{
				Phrase phrase = new Phrase(tSSRS.GetText(j, i), font);
				Cell cell = new Cell(phrase);
				cell.setHorizontalAlignment(tbs.getAlign());
				cell.setVerticalAlignment(0);
				if (tbs.getBodyType() != 2)
				{
					if (j % 2 == 0)
						cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cell);
			}

		}

		Exception ex;
		if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
			return table;
		else
			return null;
		ex;
		logger.error((new StringBuilder("makeTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
		return null;
	}

	protected PdfPTable makeOnTableBodyFun(SSRS tSSRS, TableBodyStyle tbs)
	{
		String sqbf = "";
		PdfPTable table;
		table = new PdfPTable(tSSRS.getMaxCol());
		Font font = getFontChineseFun(tbs);
		table.setWidthPercentage(100F);
		table.setWidths(tbs.getWidths());
		table.setSpacingBefore(tbs.getPad());
		table.setSpacingAfter(tbs.getPad());
		int maxCellRow = 0;
		for (int j = 1; j <= tSSRS.getMaxRow(); j++)
		{
			for (int i = 1; i <= tSSRS.getMaxCol(); i++)
			{
				String value = tSSRS.GetText(j, i);
				int maxRowNum = value.length() / 32;
				if (maxRowNum > maxCellRow)
					maxCellRow = maxRowNum;
				String type = value.substring(value.lastIndexOf(".") + 1).toUpperCase();
				value = StrTool.replaceEx(value, "<br>", "\n");
				Phrase phrase = new Phrase(value, font);
				PdfPCell cell = new PdfPCell(phrase);
				cell.setPadding(10F);
				cell.setLeading(1.0F, 1.5F);
				if (i == 1)
					cell.setHorizontalAlignment(1);
				else
					cell.setHorizontalAlignment(0);
				if (tbs.getBodyType() != 2)
				{
					if (i % 2 == 1)
						cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				} else
				{
					cell.setBackgroundColor(new Color(tbs.getR(), tbs.getG(), tbs.getB()));
				}
				table.addCell(cell);
			}

		}

		Exception ex;
		if (tbs.getBodyType() == 0 || tbs.getBodyType() == 2)
			return table;
		else
			return table;
		ex;
		logger.error((new StringBuilder("makeOnTableBody(SSRS, TableBodyStyle) - ")).append(ex.getMessage()).toString(), ex);
		return null;
	}

	public HeaderFooter makeHeaderFun(String content, HeaderStyle hs)
	{
		HeaderFooter header;
		try
		{
			Phrase phrase = null;
			Image image = Image.getInstance(content);
			image.scalePercent(60F);
			image.setAlignment(hs.getAlign());
			Paragraph p = new Paragraph();
			p.add(image);
			header = new HeaderFooter(p, false);
			header.setBorder(0);
			header.setBorderWidth(0.0F);
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder("makeHeader(String, HeaderStyle) - ")).append(header.getHeight()).toString());
			if (logger.isDebugEnabled())
				logger.debug("makeHeader(String, HeaderStyle) - yemei success !");
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeHeader(String, HeaderStyle) - ")).append(ex.getMessage()).toString(), ex);
			return null;
		}
		return header;
	}

	public HeaderFooter makeFooterFun(String content, FooterStyle fs)
	{
		HeaderFooter footer = null;
		try
		{
			Phrase phrase = null;
			Phrase afterPhrase = null;
			Phrase paragraph = new Phrase(content, getFontChineseFun(fs));
			switch (fs.getContentType())
			{
			case 0: // '\0'
				phrase = new Phrase();
				break;

			case 1: // '\001'
				String tempStr[] = content.split("pagenumber");
				phrase = new Phrase(StrTool.replaceEx(tempStr[0], "<br>", "\n"), getFontChineseFun(fs));
				if (tempStr.length > 1)
					afterPhrase = new Phrase(StrTool.replaceEx(tempStr[1], "<br>", "\n"), getFontChineseFun(fs));
				break;

			case 2: // '\002'
				Image image = Image.getInstance(content);
				paragraph = new Paragraph(new Chunk(image, 0.0F, 0.0F));
				break;
			}
			if (fs.getBumbered())
				footer = new HeaderFooter(phrase, false);
			else
				footer = new HeaderFooter(phrase, false);
			footer.setBorder(fs.getBorder());
		}
		catch (Exception ex)
		{
			logger.error("makeFooterFun(String, FooterStyle)", ex);
		}
		return footer;
	}

	public boolean makeNewPageFun(Document document)
	{
		try
		{
			document.newPage();
		}
		catch (Exception ex)
		{
			logger.error((new StringBuilder("makeNewPage() - ")).append(ex.getMessage()).toString(), ex);
			return false;
		}
		return true;
	}

	protected Phrase getPhraseFun(String value, FooterStyle fs)
	{
		float size = fs.getSize();
		int style = fs.getStyle();
		if (value.indexOf("<size:") != -1 && value.indexOf(">") != -1)
		{
			size = Float.parseFloat(value.substring(value.indexOf("<size:") + 6, value.indexOf(">")));
			value = value.substring(value.indexOf(">") + 1);
		}
		FontStyle fontStyle = new FontStyle();
		fontStyle.setSize(size);
		fontStyle.setStyle(style);
		fontStyle.setColor(fs.getColor());
		Font font = getFontChineseFun(fontStyle);
		return new Phrase(value, font);
	}

	public boolean makePdfPTableHead(java.util.List headers, TableHeadStyle ths)
	{
		PdfPTable pdfpTable = null;
		try
		{
			int col = ths.getCol();
			pdfpTable = new PdfPTable(col);
			pdfpTable.setTotalWidth(ths.getWidth());
			pdfpTable.setWidths(ths.getWidths());
			pdfpTable.setHorizontalAlignment(ths.getTableAlign());
			pdfpTable.setSpacingBefore(ths.getPadding());
			pdfpTable.setSpacingAfter(ths.getPadding());
			Font font = getFontChineseFun(ths);
			String colName = "";
			int colSpan = 1;
			PdfPCell pdfpCell = null;
			Phrase phrase = null;
			Header header = null;
			for (int i = 0; i < headers.size(); i++)
			{
				header = (Header)headers.get(i);
				colName = header.getName();
				colSpan = header.getCol();
				phrase = new Phrase(colName, font);
				pdfpCell = new PdfPCell(phrase);
				pdfpCell.setHorizontalAlignment(ths.getAlign());
				pdfpCell.setVerticalAlignment(1);
				pdfpCell.setBorderWidth(ths.getBorder());
				pdfpCell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
				if (colSpan > 1)
					pdfpCell.setColspan(colSpan);
				pdfpTable.addCell(pdfpCell);
			}

		}
		catch (Exception ex)
		{
			logger.error("在处理Table表头时发生异常，具体原因为：", ex);
			return false;
		}
		return true;
	}

	public boolean makeTableHead(String colNames[], TableHeadStyle ths)
	{
		int col = ths.getCol();
		Table table = null;
		try
		{
			table = new Table(col);
			table.setBorderWidth(ths.getBorder());
			table.setWidth(ths.getWidth());
			if (ths.getWidths() != null)
				table.setWidths(ths.getWidths());
			table.setBorderColor(ths.getColor());
			table.setPadding(ths.getPadding());
			table.setSpacing(ths.getSpacing());
			Font font = getFontChineseFun(ths);
			for (int i = 0; i < col; i++)
			{
				Phrase phrase = new Phrase(colNames[i], font);
				Cell cell = new Cell(phrase);
				cell.setHorizontalAlignment(ths.getAlign());
				cell.setBorder(ths.getBorder());
				cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
				table.addCell(cell);
			}

		}
		catch (Exception ex)
		{
			logger.error("makeTableHead(String[], TableHeadStyle)", ex);
		}
		return true;
	}

	public Table makeTableHead(java.util.List headers, TableHeadStyle ths)
	{
		int col = ths.getCol();
		Table table = null;
		try
		{
			table = new Table(col);
			table.setBorderWidth(ths.getBorder());
			table.setWidth(ths.getWidth());
			table.setWidths(ths.getWidths());
			table.setPadding(ths.getPadding());
			table.setSpacing(ths.getSpacing());
			table.setAlignment(ths.getTableAlign());
			Font font = getFontChineseFun(ths);
			String colName = "";
			int rowSpan = 1;
			int colSpan = 1;
			Cell cell = null;
			Phrase phrase = null;
			Header header = null;
			for (int i = 0; i < headers.size(); i++)
			{
				header = (Header)headers.get(i);
				colName = header.getName();
				rowSpan = header.getRow();
				colSpan = header.getCol();
				phrase = new Phrase(colName, font);
				cell = new Cell(phrase);
				cell.setHorizontalAlignment(ths.getAlign());
				cell.setBorder(ths.getBorder());
				cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
				if (rowSpan > 1)
					cell.setRowspan(rowSpan);
				if (colSpan > 1)
					cell.setColspan(colSpan);
				table.addCell(cell);
			}

		}
		catch (Exception ex)
		{
			logger.error("makeTableHead(List, TableHeadStyle)", ex);
			logger.error("在处理Table表头时发生异常，具体原因为：", ex);
		}
		return table;
	}

	public Chunk makeLargeTextFun(String content, TextStyle ts)
	{
		Font font = getFontChineseFun(ts);
		Chunk chunk = new Chunk(content, font);
		return chunk;
	}

	public PdfPTable makePicPTableFun(Paragraph p, Image image, TableBodyStyle tbs)
	{
		PdfPTable table = new PdfPTable(1);
		try
		{
			if (!tbs.isHasHead())
			{
				table.setWidthPercentage(100F);
				table.setWidths(tbs.getWidths());
				table.setHorizontalAlignment(tbs.getAlign());
				table.setSpacingBefore(tbs.getPad());
				table.setSpacingAfter(tbs.getPad());
			}
			PdfPCell cell = new PdfPCell(p);
			cell.setBorder(2);
			cell.setVerticalAlignment(5);
			cell.setHorizontalAlignment(0);
			cell.setMinimumHeight(20F);
			table.addCell(cell);
			PdfPCell cell1 = new PdfPCell(image);
			cell1.setBorder(0);
			cell1.setVerticalAlignment(5);
			cell.setHorizontalAlignment(0);
			table.addCell(cell1);
		}
		catch (DocumentException e)
		{
			logger.error("makePicPTableFun(Paragraph, Image, TableBodyStyle)", e);
		}
		return table;
	}

	public PdfToolFun()
	{
		recoverNum = 10000;
		recoverA4Num = 10000;
		printNums = 0;
		path = "";
		hsmTitleUnitRow = new HashMap();
	}

	public PdfToolFun(String path)
	{
		recoverNum = 10000;
		recoverA4Num = 10000;
		printNums = 0;
		this.path = "";
		hsmTitleUnitRow = new HashMap();
		this.path = path;
	}

	public void SetneedRepeat(int recoverNum, int recoverA4Num)
	{
		this.recoverNum = recoverNum;
		this.recoverA4Num = recoverA4Num;
	}

	private Font getFontChinese(FontStyle fs)
	{
		Font FontChinese;
		BaseFont bfChinese = getBaseFontFun(fs);
		FontChinese = new Font(bfChinese, fs.getSize(), fs.getStyle(), fs.getColor());
		return FontChinese;
		Exception ex;
		ex;
		logger.error("getFontChinese(FontStyle fs)", ex);
		return null;
	}

	public void onCloseDocument(PdfWriter writer, Document arg1)
	{
		tpl.beginText();
		tpl.setFontAndSize(helv, 9F);
		tpl.setTextMatrix(0.0F, 0.0F);
		tpl.showText((new StringBuilder()).append(writer.getPageNumber() - 1).append("页").toString());
		tpl.endText();
	}

	public void onStartPage(PdfWriter writer, Document document)
	{
		printNums++;
		super.onStartPage(writer, document);
	}

	public void onEndPage(PdfWriter writer, Document document)
	{
		if (printNums == recoverNum)
			document.setPageSize(PageSize.A4.rotate());
		if (printNums == recoverA4Num)
		{
			System.out.println((new StringBuilder(String.valueOf(printNums))).append("-------------------------").append(recoverA4Num).toString());
			document.setPageSize(PageSize.A4);
		}
		PdfContentByte cb = writer.getDirectContent();
		String text = (new StringBuilder("                                                                                              第 ")).append(writer.getPageNumber()).append(" 页/共 ").toString();
		if (writer.getPageNumber() == 0)
			text = "                                                                                                                                                                                  ";
		float textSize = helv.getWidthPoint(text, 9F);
		float textBase = document.bottom();
		cb.beginText();
		cb.setFontAndSize(helv, 9F);
		cb.setTextMatrix(document.right(278F), textBase);
		cb.showText(text);
		cb.endText();
		cb.addTemplate(tpl, document.right(278F) + textSize, textBase);
	}

	public void onOpenDocument(PdfWriter writer, Document arg1)
	{
		try
		{
			tpl = writer.getDirectContent().createTemplate(100F, 100F);
			helv = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
		}
		catch (Exception exception) { }
	}

	public int getPrintNums()
	{
		return printNums;
	}

	public void setPrintNums(int printNums)
	{
		this.printNums = printNums;
	}

}
