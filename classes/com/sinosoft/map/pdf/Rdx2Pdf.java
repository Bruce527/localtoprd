// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Rdx2Pdf.java

package com.sinosoft.map.pdf;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.sinosoft.map.lis.pubfun.XMLByJDOM;
import com.sinosoft.map.pdf.iText.BaseStyle;
import com.sinosoft.map.utility.StaticConst;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.jdom.Element;

public class Rdx2Pdf
{

	private static boolean isTitle = false;

	public Rdx2Pdf()
	{
	}

	public static boolean ChangeToPdf(String rdxPath, String pdfPath)
	{
		boolean flag;
		org.jdom.Document doc111;
		Document document;
		flag = true;
		XMLByJDOM tXMLByJDOM = new XMLByJDOM();
		doc111 = tXMLByJDOM.loadXMLFileByJDOM(rdxPath);
		document = null;
		try
		{
			document = new Document(PageSize.A4, 50F, 50F, 49F, 50F);
			PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			Element preElement_page_width = null;
			Element reportProperties = doc111.getRootElement().getChild("ReportProperties");
			if (reportProperties != null)
			{
				Element page = reportProperties.getChild("Page");
				if (page != null)
					preElement_page_width = page.getChild("Width");
			}
			String page_width = getElementText("827", preElement_page_width);
			Element premElement_header = doc111.getRootElement().getChild("Header");
			if (premElement_header != null)
			{
				int pageNum = pw.getPageNumber();
				int curPage = pw.getCurrentPageNumber();
				HeaderFooter headerfooter = new HeaderFooter(new Phrase("This is a header."), false);
			}
			Element premElement_footer = doc111.getRootElement().getChild("Footer");
			if (premElement_footer != null)
			{
				Font f = BaseStyle.getContext("宋体");
				HeaderFooter footer = new HeaderFooter(new Phrase("第 ", f), new Phrase(" 页", f));
				footer.setAlignment(1);
				footer.setBorder(0);
			}
			document.open();
			Element premElement_body = doc111.getRootElement().getChild("Body");
			List bodyElementList = premElement_body.getChildren();
			int inBodyAmount = bodyElementList.size();
			for (int i = 0; i < inBodyAmount; i++)
			{
				Element el = (Element)bodyElementList.get(i);
				String el_name = el.getName();
				if (el_name.equals("Table"))
					addTable(document, el, page_width);
				if (el_name.equals("Text"))
					addText(document, el);
				if (el_name.equals("PageBreak"))
					document.newPage();
			}

			break MISSING_BLOCK_LABEL_403;
		}
		catch (Exception e)
		{
			System.out.println((new StringBuilder("============= make ")).append(pdfPath).append(" === error").toString());
			e.printStackTrace();
			flag = false;
		}
		document.close();
		break MISSING_BLOCK_LABEL_408;
		Exception exception;
		exception;
		document.close();
		throw exception;
		document.close();
		return flag;
	}

	private static void addTable(Document document, Element el, String page_width)
		throws Exception
	{
		boolean blankFlag = false;
		List rowsList = el.getChildren("TableRows");
		int rowsAmount = rowsList.size();
		Table table = new Table(1);
		Table rowTable = null;
		Element table_style = el.getChild("Style");
		Element table_pos_width = null;
		Element table_padding_bottom = null;
		if (table_style != null)
		{
			Element table_sty_pos = table_style.getChild("Positioning");
			Element table_sty_padding = table_style.getChild("Padding");
			if (table_sty_pos != null)
				table_pos_width = table_sty_pos.getChild("Width");
			if (table_sty_padding != null)
				table_padding_bottom = table_sty_padding.getChild("Bottom");
		}
		String tableWidth = getElementText("100%", table_pos_width);
		String tableBottom = getElementText("10", table_padding_bottom);
		String tab_width[] = tableWidth.split("%");
		table.setWidth(Float.parseFloat(tab_width[0]));
		table.setBottom(Float.parseFloat(tableBottom));
		table.setBorder(0);
		table.setPadding(0.0F);
		table.setSpacing(0.0F);
		for (int c = 0; c < rowsAmount; c++)
		{
			List rowList = ((Element)rowsList.get(c)).getChildren("TableRow");
			int rows = rowList.size();
			for (int j = 0; j < rows; j++)
			{
				List cellList = ((Element)rowList.get(j)).getChild("TableCells").getChildren("TableCell");
				int colAmount = cellList.size();
				float widths[] = new float[colAmount];
				for (int g = 0; g < colAmount; g++)
				{
					Element cell_sty = ((Element)cellList.get(g)).getChild("Style");
					String width = "100%";
					if (cell_sty != null)
					{
						Element cell_posi = cell_sty.getChild("Positioning");
						if (cell_posi != null)
							width = cell_posi.getChildText("Width");
					}
					if (width != null && !width.equals(""))
						if (!width.contains("%"))
						{
							int ac = Integer.parseInt(width);
							Double acc = Double.valueOf(((new Double((ac * 100) / Integer.parseInt(page_width))).doubleValue() * 72D) / 25.399999618530273D);
							widths[g] = acc.floatValue();
						} else
						{
							String ab[] = width.split("%");
							Double doubleWidth = Double.valueOf((Double.parseDouble(ab[0]) * 72D) / 25.399999618530273D);
							widths[g] = doubleWidth.floatValue();
						}
				}

				rowTable = new Table(colAmount);
				rowTable.setWidth(100F);
				rowTable.setWidths(widths);
				rowTable.setBorder(0);
				for (int g = 0; g < colAmount; g++)
				{
					Element cell_sty = ((Element)cellList.get(g)).getChild("Style");
					Element cell_sty_bor_left = null;
					Element cell_sty_bor_right = null;
					Element cell_sty_bor_top = null;
					Element cell_sty_bor_bottom = null;
					Element cell_font_family = null;
					Element cell_font_color = null;
					Element cell_font_size = null;
					Element cell_font_blod = null;
					Element cell_posi_width = null;
					Element cell_format_align = null;
					if (cell_sty != null)
					{
						Element cell_sty_bor = cell_sty.getChild("Border");
						Element cell_font = cell_sty.getChild("Font");
						Element cell_posi = cell_sty.getChild("Positioning");
						Element cell_format = cell_sty.getChild("Format");
						if (cell_sty_bor != null)
						{
							cell_sty_bor_left = cell_sty_bor.getChild("LeftWidth");
							cell_sty_bor_right = cell_sty_bor.getChild("RightWidth");
							cell_sty_bor_top = cell_sty_bor.getChild("TopWidth");
							cell_sty_bor_bottom = cell_sty_bor.getChild("BottomWidth");
						}
						if (cell_font != null)
						{
							cell_font_family = cell_font.getChild("Family");
							cell_font_color = cell_font.getChild("Color");
							cell_font_size = cell_font.getChild("Size");
							cell_font_blod = cell_font.getChild("Bold");
							Element cell_font_format = cell_font.getChild("Format");
							if (cell_font_format != null)
								cell_format_align = cell_font_format.getChild("Alignment");
						}
						if (cell_posi != null)
							cell_posi_width = cell_posi.getChild("Width");
						if (cell_format != null)
							cell_format_align = cell_format.getChild("Alignment");
					}
					String borderLeft = getElementText("0", cell_sty_bor_left);
					String borderRight = getElementText("0", cell_sty_bor_right);
					String borderTop = getElementText("0", cell_sty_bor_top);
					String borderBottom = getElementText("0", cell_sty_bor_bottom);
					String fontFamily = getElementText("宋体", cell_font_family);
					String fontColor = getElementText("Black", cell_font_color);
					String fontSize = getElementText("12", cell_font_size);
					String fontBlod = getElementText("false", cell_font_blod).toLowerCase();
					String positioningWidth = getElementText("33%", cell_posi_width);
					String format_align = getElementText("Left", cell_format_align);
					Element cell = ((Element)cellList.get(g)).getChild("Value");
					String cellText = getElementText("", cell).trim();
					cellText = cellText.replace("：", ":");
					if (g == 0 && cellText.contains("告知事项"))
					{
						blankFlag = true;
						cellText = (new StringBuilder(" ")).append(cellText).toString();
					}
					if (blankFlag)
					{
						cellText = (new StringBuilder(" ")).append(cellText).toString();
						if (cellText.trim().startsWith("□"))
							cellText = (new StringBuilder("   ")).append(cellText).toString();
						char chs[] = cellText.trim().toCharArray();
						if (chs != null && chs.length > 0 && (chs[0] >= 'a' && chs[0] <= 'z' || chs[0] >= 'A' && chs[0] <= 'Z'))
							cellText = (new StringBuilder(" ")).append(cellText).toString();
						if (cellText.trim().endsWith("按国家规定进行接种？"))
							cellText = (new StringBuilder(String.valueOf(cellText))).append("\n").append("\n").toString();
					}
					if (fontFamily.contains("仿宋"))
						fontFamily = "仿宋";
					Font f = BaseStyle.getContext(fontFamily);
					if (fontBlod.equals("true"))
						f = new Font(StaticConst.getInstance().getFont(fontFamily).getBaseFont(), Float.parseFloat(fontSize), 1);
					f.setSize(Float.parseFloat(fontSize));
					f.setColor(java.awt.Color.BLACK);
					Cell cel = new Cell(new Paragraph(cellText, f));
					cel.setVerticalAlignment(1);
					if (format_align.equals("Center"))
						cel.setHorizontalAlignment(1);
					else
					if (format_align.endsWith("Right"))
						cel.setHorizontalAlignment(2);
					else
					if (format_align.endsWith("Left"))
						cel.setHorizontalAlignment(3);
					else
						cel.setHorizontalAlignment(1);
					if (borderLeft.equals("0") || borderRight.equals("0") || borderBottom.equals("0") || borderTop.equals("0"))
					{
						if (!borderLeft.equals("0"))
							cel.setBorderWidthLeft(0.5F);
						else
							cel.setBorderWidthLeft(0.0F);
						if (!borderRight.equals("0"))
							cel.setBorderWidthRight(0.5F);
						else
							cel.setBorderWidthRight(0.0F);
						if (!borderTop.equals("0"))
							cel.setBorderWidthTop(0.5F);
						else
							cel.setBorderWidthTop(0.0F);
						if (!borderBottom.equals("0"))
							cel.setBorderWidthBottom(0.5F);
						else
							cel.setBorderWidthBottom(0.0F);
					}
					cel.setUseDescender(true);
					if (cellText.trim().equals("") && (!borderTop.equals("0") || !borderBottom.equals("0")))
						cel.add(new Paragraph("\n"));
					rowTable.addCell(cel);
				}

				table.addCell(new Cell(rowTable));
			}

		}

		document.add(table);
	}

	private static void addText(Document document, Element el)
		throws Exception
	{
		Element text_sty = el.getChild("Style");
		Element text_font_family = null;
		Element text_font_color = null;
		Element text_font_size = null;
		Element text_font_bold = null;
		Element text_font_align = null;
		Element text_padding_bottom = null;
		Element text_pos_width = null;
		if (text_sty != null)
		{
			Element text_sty_font = text_sty.getChild("Font");
			Element text_sty_padding = text_sty.getChild("Padding");
			Element text_sty_pos = text_sty.getChild("Positioning");
			if (text_sty_font != null)
			{
				text_font_family = text_sty_font.getChild("Family");
				text_font_color = text_sty_font.getChild("Color");
				text_font_size = text_sty_font.getChild("Size");
				text_font_bold = text_sty_font.getChild("Bold");
				Element text_font_format = text_sty_font.getChild("Format");
				if (text_font_format != null)
					text_font_align = text_font_format.getChild("Alignment");
			}
			if (text_sty_padding != null)
				text_padding_bottom = text_sty_padding.getChild("Bottom");
			if (text_sty_pos != null)
				text_pos_width = text_sty_pos.getChild("Width");
		}
		String text_family = getElementText("宋体", text_font_family);
		if (text_family.contains("仿宋"))
			text_family = "仿宋";
		String text_color = getElementText("BLACK", text_font_color);
		String text_size = getElementText("10", text_font_size);
		String text_bold = getElementText("false", text_font_bold);
		String text_align = getElementText("Left", text_font_align);
		String text_bottom = getElementText("20", text_padding_bottom);
		String text_width = getElementText("100%", text_pos_width);
		String text = el.getChildText("Value");
		text = text.replace("：", ":");
		int align = 3;
		if (text_align.equals("Center"))
			align = 1;
		else
		if (text_align.equals("Left"))
			align = 3;
		else
		if (text_align.equals("Right"))
			align = 2;
		if (isTitle)
			isTitle = false;
		if ((new Double(text_size)).doubleValue() > 12D && "true".equals(text_bold) && "Center".equals(text_align))
		{
			isTitle = true;
			text = (new StringBuilder("\n")).append(text).toString();
		}
		Font f1 = BaseStyle.getContext(text_family);
		f1.setColor(java.awt.Color.BLACK);
		f1.setSize(Float.parseFloat(text_size));
		if (text_bold.equals("true"))
			f1 = new Font(StaticConst.getInstance().getFont(text_family).getBaseFont(), Float.parseFloat(text_size), 1);
		Chunk cc = new Chunk();
		cc.setFont(f1);
		String trimText = rightTrim(text);
		if (rightTrim(text).startsWith("    "))
			trimText = (new StringBuilder("  ")).append(rightTrim(text).trim()).toString();
		if (text.trim().startsWith("◎"))
			trimText = leftTrim(trimText);
		cc.append(trimText);
		Paragraph par = new Paragraph();
		par.setAlignment(align);
		par.add(cc);
		par.setSpacingAfter(Float.parseFloat(text_bottom));
		par.setFont(f1);
		document.add(par);
	}

	private static String getElementText(String defaultText, Element element)
	{
		if (element != null && !"".equals(element.getText()))
			defaultText = element.getText();
		return defaultText;
	}

	public static void main(String arg[])
	{
		ChangeToPdf("D:\\pdftest\\xml\\634160979311206822598_续年度核保告知书.rdx", "D:\\pdftest\\out\\634160979311206822598_续年度核保告知书.pdf");
	}

	public static String rightTrim(String str)
	{
		int end = str.indexOf(str.trim());
		str = str.substring(0, end + str.trim().length());
		return str;
	}

	public static String leftTrim(String str)
	{
		int end = str.indexOf(str.trim());
		str = str.substring(end, str.length());
		return str;
	}

}
