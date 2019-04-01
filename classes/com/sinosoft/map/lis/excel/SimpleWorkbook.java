// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SimpleWorkbook.java

package com.sinosoft.map.lis.excel;

import com.sinosoft.map.utility.ListTable;
import com.sinosoft.map.utility.SSRS;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import jxl.*;
import jxl.biff.FontRecord;
import jxl.format.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

// Referenced classes of package com.sinosoft.map.lis.excel:
//			EvanLog, ExcelException, ZipInfo, Config, 
//			ExcelUtil

public class SimpleWorkbook
{

	private WritableWorkbook workbook;
	private int sheetIndex;
	private int size;
	private WritableCellFormat defaultFormat;
	private Map colFormat;
	private Map rowFormat;
	private CellFormat bothFormat;
	private Map numberCols;
	private Map numberColFormat;
	private Set mergeCol;
	private Set downNullMergeCol;
	private Set mergerAllCol;
	private Set noZeroNumber;
	private Map arrayCol;
	private int startCol;
	private int startRow;
	private int endCol;
	private int templetRow;
	private int templetCol;
	private static final String ROW = "#row#";
	private static final String COL = "#col#";
	private static final String BOTH = "#default#";
	private static final String CELL = "#cell#";
	private static final String MERGE = "#merge#";
	private static final String DOWN_NULL_MERGE = "dmerge";
	private static final String TRAIL = "#trail#";
	private static final String END = "#end#";
	private static final String MERGE_ROW_FLAG = "#merge(-1,-0)";
	private String fileName;
	EvanLog logger;

	public SimpleWorkbook()
	{
		workbook = null;
		sheetIndex = 0;
		size = 0;
		defaultFormat = null;
		colFormat = new HashMap();
		rowFormat = new HashMap();
		bothFormat = null;
		numberCols = new HashMap();
		numberColFormat = new HashMap();
		mergeCol = new HashSet();
		downNullMergeCol = new HashSet();
		mergerAllCol = new HashSet();
		noZeroNumber = new HashSet();
		arrayCol = new HashMap();
		startCol = 0;
		startRow = 0;
		endCol = -1;
		templetRow = 0;
		templetCol = 0;
		fileName = null;
		logger = EvanLog.getLoger();
	}

	public SimpleWorkbook(String resultPath, String templetPath)
		throws ExcelException
	{
		workbook = null;
		sheetIndex = 0;
		size = 0;
		defaultFormat = null;
		colFormat = new HashMap();
		rowFormat = new HashMap();
		bothFormat = null;
		numberCols = new HashMap();
		numberColFormat = new HashMap();
		mergeCol = new HashSet();
		downNullMergeCol = new HashSet();
		mergerAllCol = new HashSet();
		noZeroNumber = new HashSet();
		arrayCol = new HashMap();
		startCol = 0;
		startRow = 0;
		endCol = -1;
		templetRow = 0;
		templetCol = 0;
		fileName = null;
		logger = EvanLog.getLoger();
		fileName = resultPath;
		try
		{
			workbook = Workbook.createWorkbook(new File(resultPath), Workbook.getWorkbook(new File(templetPath)));
		}
		catch (BiffException e)
		{
			throw new ExcelException(e);
		}
		catch (IOException e)
		{
			throw new ExcelException(e.getMessage());
		}
		WritableFont datawf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
		defaultFormat = new WritableCellFormat(datawf);
		try
		{
			defaultFormat.setWrap(true);
			defaultFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			defaultFormat.setAlignment(Alignment.CENTRE);
			defaultFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		}
		catch (WriteException e)
		{
			e.printStackTrace();
		}
		collectFormat();
	}

	private void collectFormat()
	{
		WritableSheet sheet = workbook.getSheet(0);
		templetCol = sheet.getColumns();
		templetRow = sheet.getRows();
		logger.log("SimpleWorkbook collectFormat()------for start");
		for (int i = 0; i < templetRow; i++)
		{
			for (int j = 0; j < templetCol; j++)
			{
				Cell cell = sheet.getWritableCell(j, i);
				String c = cell.getContents();
				if (c == null || c.trim().equals(""))
					continue;
				String contents = c.trim();
				if (contents.equals("#default#"))
				{
					bothFormat = cell.getCellFormat();
					startCol = j;
					startRow = i;
					continue;
				}
				if (contents.equals("#row#"))
				{
					rowFormat.put(new Integer(cell.getRow()), cell.getCellFormat());
					continue;
				}
				if (contents.equals("#col#"))
				{
					colFormat.put(new Integer(cell.getColumn()), cell.getCellFormat());
					continue;
				}
				if (contents.startsWith("#.") && contents.endsWith("##"))
				{
					int length = contents.trim().length();
					if (length < 3)
						continue;
					Integer i2 = null;
					try
					{
						i2 = new Integer(contents.substring(2, length - 2));
					}
					catch (Exception e)
					{
						continue;
					}
					numberCols.put(new Integer(cell.getColumn()), i2);
					colFormat.put(new Integer(cell.getColumn()), cell.getCellFormat());
					noZeroNumber.add(new Integer(cell.getColumn()));
					continue;
				}
				if (contents.startsWith("#.") && contents.endsWith("#"))
				{
					int length = contents.trim().length();
					if (length < 3)
						continue;
					Integer i2 = null;
					try
					{
						i2 = new Integer(contents.substring(2, length - 1));
					}
					catch (Exception e)
					{
						continue;
					}
					numberCols.put(new Integer(cell.getColumn()), i2);
					colFormat.put(new Integer(cell.getColumn()), cell.getCellFormat());
					continue;
				}
				if (contents.startsWith("[") && contents.endsWith("]"))
				{
					int length = contents.trim().length();
					if (length < 3)
						continue;
					WritableCellFormat fivedpsFormat = null;
					try
					{
						String format = contents.substring(1, length - 1);
						NumberFormat fivedps = new NumberFormat(format);
						fivedpsFormat = new WritableCellFormat(fivedps);
					}
					catch (Exception e)
					{
						continue;
					}
					numberCols.put(new Integer(cell.getColumn()), new Integer(-100));
					colFormat.put(new Integer(cell.getColumn()), fivedpsFormat);
				} else
				if (contents.equals("#merge#"))
					mergeCol.add(new Integer(j));
				else
				if (contents.startsWith("#$") && contents.endsWith("#"))
				{
					int k = contents.length();
					String str = contents.substring(2, k - 1);
					try
					{
						arrayCol.put(new Integer(cell.getColumn()), new Integer(str));
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				} else
				if (contents.equalsIgnoreCase("dmerge"))
					downNullMergeCol.add(new Integer(j));
				else
				if (contents.equals("#end#"))
					endCol = cell.getColumn();
			}

		}

		logger.log("SimpleWorkbook collectFormat()------for end");
	}

	private SimpleWorkbook add(int row, int column, String contents, String sign)
		throws ExcelException
	{
		return add(row, column, contents, sign, 0);
	}

	private SimpleWorkbook add(int row, int column, String contents, String sign, int sheetIndex)
		throws ExcelException
	{
		WritableSheet sheet = workbook.getSheet(sheetIndex);
		Cell oldCell = sheet.getCell(column, row);
		CellFormat format = getFormat(oldCell);
		try
		{
			if ((sign.equals("AUTO") || sign.equals("NUMBER")) && isNumber(oldCell))
			{
				if (contents == null || contents.trim().equalsIgnoreCase("null") || contents.trim().equals(""))
				{
					contents = "";
					Label label = new Label(column, row, "", format);
					sheet.addCell(label);
				} else
				if (contents.toLowerCase().contains("#merge"))
				{
					String tmp = contents.substring(contents.indexOf("(") + 1, contents.indexOf(")"));
					String left = tmp.substring(0, tmp.indexOf(","));
					String up = tmp.substring(tmp.indexOf(",") + 1);
					sheet.mergeCells(column + Integer.parseInt(left), row + Integer.parseInt(up), column, row);
				} else
				if (Double.parseDouble(contents.trim()) == 0.0D && !"0".equals(contents.trim()) && noZeroNumber.contains(new Integer(column)))
				{
					Label label = new Label(column, row, "", format);
					sheet.addCell(label);
				} else
				{
					WritableCellFormat wcf = getNumberFormat(oldCell);
					Number number = new Number(column, row, (new Double(contents.toString())).doubleValue(), wcf);
					sheet.addCell(number);
				}
			} else
			{
				if (contents == null || contents.trim().equalsIgnoreCase("null") || contents.trim().equals(""))
					contents = "";
				Label label = new Label(column, row, contents, format);
				sheet.addCell(label);
			}
		}
		catch (RowsExceededException e1)
		{
			e1.printStackTrace();
		}
		catch (NumberFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (WriteException e1)
		{
			e1.printStackTrace();
		}
		return this;
	}

	private WritableCellFormat getNumberFormat(Cell oldCell)
	{
		WritableCellFormat wcf = (WritableCellFormat)numberColFormat.get(new Integer(oldCell.getColumn()));
		if (wcf == null)
		{
			if (getFrac(oldCell) == 0)
				wcf = new WritableCellFormat(new NumberFormat("0"));
			else
			if (getFrac(oldCell) == -100)
			{
				wcf = (WritableCellFormat)colFormat.get(new Integer(oldCell.getColumn()));
				try
				{
					wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
				}
				catch (WriteException e)
				{
					e.printStackTrace();
				}
			} else
			if (getFrac(oldCell) == -1)
			{
				wcf = new WritableCellFormat();
			} else
			{
				StringBuffer sb = new StringBuffer("0.");
				logger.log("simpleWorkbook getNumberFormat(Cell oldCell)----for start");
				for (int i = 0; i < getFrac(oldCell); i++)
					sb.append("0");

				logger.log("simpleWorkbook getNumberFormat(Cell oldCell)----for end");
				NumberFormat nf = new NumberFormat(sb.toString());
				wcf = new WritableCellFormat(nf);
			}
			CellFormat format = (CellFormat)colFormat.get(new Integer(oldCell.getColumn()));
			if (format == null)
				format = bothFormat;
			copy(format, wcf);
			numberColFormat.put(new Integer(oldCell.getColumn()), wcf);
		}
		return wcf;
	}

	public void add(String strArr[][])
	{
		addTrail(strArr.length + startRow + 1);
		size = strArr.length;
		int col = startCol;
		int colt = startCol;
		int row = startRow;
		logger.log("SimpleWorkbook add(String[][] strArr)-----for start");
		for (int i = 0; i < strArr.length; i++)
		{
			for (int j = 0; j < strArr[i].length; j++)
			{
				Integer colTmp = redirect(col);
				try
				{
					if (colTmp != null)
						add(row, col, strArr[i][colTmp.intValue()], "AUTO");
					else
						add(row, col, strArr[i][j], "AUTO");
				}
				catch (ExcelException e)
				{
					e.printStackTrace();
				}
				if (++col >= strArr[i].length + colt)
					col = colt;
				if (col != endCol)
					continue;
				col = colt;
				break;
			}

			row++;
		}

		logger.log("SimpleWorkbook add(String[][] strArr)-----for end");
		clearSign();
		merge();
		try
		{
			write();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
		try
		{
			close();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
	}

	public void createZip(String array[], String txtName, String txtPath)
	{
		System.out.println((new StringBuilder("SimpleWorkbook----add(array array):")).append(array).toString());
		int maxRow = 0;
		if (array.length >= maxRow)
		{
			System.out.println((new StringBuilder("aaaaaaaaaaa")).append(fileName).toString());
			int t = fileName.indexOf("E");
			System.out.println((new StringBuilder("bbbbbbbbbbbbb")).append(t).toString());
			String temtxtPath = (new StringBuilder(String.valueOf(txtPath.replace('/', File.separatorChar)))).append(fileName.substring(t + "E:\tmp".length() + 1)).toString();
			System.out.println((new StringBuilder("temtxtPath=")).append(temtxtPath).toString());
			String zipfile = temtxtPath.replaceAll(".xls", ".zip");
			System.out.println((new StringBuilder("create zip:")).append(temtxtPath).toString());
			BufferedWriter writer = null;
			try
			{
				ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(zipfile));
				zipout.putNextEntry(new ZipEntry((new StringBuilder(String.valueOf(txtName))).append(".txt").toString()));
				writer = new BufferedWriter(new OutputStreamWriter(zipout));
				for (int i = 0; i < array.length; i++)
				{
					String row = array[i];
					writer.write(row);
					writer.newLine();
				}

				writer.flush();
				if (writer != null)
				{
					writer.close();
					zipout = null;
				}
				if (zipout != null)
					zipout.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			write();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
		try
		{
			close();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
	}

	public void createTxt(String array[], String txtName, String txtPath)
	{
		System.out.println((new StringBuilder("SimpleWorkbook----add(array array):")).append(array).toString());
		int maxRow = 0;
		if (array.length >= maxRow)
		{
			System.out.println((new StringBuilder("aaaaaaaaaaa")).append(fileName).toString());
			int t = fileName.indexOf("E");
			System.out.println((new StringBuilder("bbbbbbbbbbbbb")).append(t).toString());
			String temtxtPath = (new StringBuilder(String.valueOf(txtPath.replace('/', File.separatorChar)))).append(fileName.substring(t + "E:\tmp".length() + 1)).toString();
			System.out.println((new StringBuilder("temtxtPath=")).append(temtxtPath).toString());
			String txtfile = temtxtPath.replaceAll(".xls", ".zip");
			System.out.println((new StringBuilder("create txt:")).append(txtfile).toString());
			BufferedWriter writer = null;
			try
			{
				FileOutputStream txtout = new FileOutputStream(new File(txtfile));
				writer = new BufferedWriter(new OutputStreamWriter(txtout));
				for (int i = 0; i < array.length; i++)
				{
					String row = array[i];
					writer.write(row);
					writer.newLine();
				}

				writer.flush();
				if (writer != null)
				{
					writer.close();
					txtout = null;
				}
				if (txtout != null)
					txtout.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			write();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
		try
		{
			close();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
	}

	private Integer redirect(int col)
	{
		return (Integer)arrayCol.get(new Integer(col));
	}

	public void add(SSRS sSRS)
	{
		addTrail(sSRS.getMaxRow() + startRow + 1);
		size = sSRS.getMaxRow();
		int col = startCol;
		int colt = startCol;
		int row = startRow;
		logger.log("SimpleWorkbook add(SSRS sSRS)-----for start");
		for (int i = 0; i < sSRS.getMaxRow(); i++)
		{
			for (int j = 0; j < sSRS.getMaxCol(); j++)
			{
				Integer colTmp = redirect(col);
				try
				{
					if (colTmp != null)
						add(row, col, sSRS.GetText(i + 1, colTmp.intValue()), "AUTO");
					else
						add(row, col, sSRS.GetText(i + 1, j + 1), "AUTO");
				}
				catch (ExcelException e)
				{
					e.printStackTrace();
				}
				if (++col >= sSRS.getMaxCol() + colt)
					col = colt;
				if (col != endCol)
					continue;
				col = colt;
				break;
			}

			row++;
		}

		logger.log("SimpleWorkbook add(SSRS sSRS)-----for end");
		clearSign();
		merge();
		try
		{
			write();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
		try
		{
			close();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
	}

	public void add(ListTable listTable)
	{
		System.out.println((new StringBuilder("SimpleWorkbook----add(ListTable listTable):")).append(listTable).toString());
		addTrail(listTable.size() + startRow + 1);
		System.out.println("SimpleWorkbook----addTrail();");
		size = listTable.size();
		int col = startCol;
		int colt = startCol;
		int row = startRow;
		logger.log("SimpleWorkbook add(ListTable listTable)-----for start");
		for (int i = 0; i < listTable.size(); i++)
		{
			String strArr[] = listTable.get(i);
			for (int j = 0; j < strArr.length; j++)
			{
				Integer colTmp = redirect(col);
				try
				{
					if (colTmp != null)
						add(row, col, strArr[colTmp.intValue()], "AUTO");
					else
						add(row, col, strArr[j], "AUTO");
				}
				catch (ExcelException e)
				{
					e.printStackTrace();
				}
				if (++col >= strArr.length + colt)
					col = colt;
				if (col != endCol)
					continue;
				col = colt;
				break;
			}

			row++;
		}

		logger.log("SimpleWorkbook add(ListTable listTable)-----for end");
		System.out.println("SimpleWorkbook----listTable added");
		clearSign();
		System.out.println("SimpleWorkbook----clearSign();");
		merge();
		System.out.println("SimpleWorkbook----merge();");
		try
		{
			write();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
		try
		{
			close();
		}
		catch (ExcelException e)
		{
			e.printStackTrace();
		}
	}

	private void addTrail(int trailStartRow)
	{
		WritableSheet sheet = workbook.getSheet(0);
		int r = sheet.getRows();
		int c = sheet.getColumns();
		Vector cells = new Vector();
		Vector trailRanges = new Vector();
		int startR = 0;
		int trailH = 0;
		logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for1 start");
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				Cell cell = sheet.getCell(j, i);
				String contents = cell.getContents();
				if (contents != null && contents.trim() != "" && contents.trim().equalsIgnoreCase("#trail#"))
					startR = i + 1;
			}

		}

		logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for1 end");
		trailH = (sheet.getRows() - startR) + 1;
		if (startR > 0)
		{
			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for2 start");
			for (int i2 = startR; i2 <= r; i2++)
			{
				Cell cell2s[] = sheet.getRow(i2);
				cells.add(cell2s);
				Range ranges[] = sheet.getMergedCells();
				for (int range = 0; range < ranges.length; range++)
					if (ranges[range].getTopLeft().getRow() >= startR && ranges[range].getBottomRight().getRow() <= r)
						trailRanges.add(ranges[range]);

			}

			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for2 end");
			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for3 start");
			for (int i3 = 0; i3 < cells.size(); i3++)
			{
				Cell cs[] = (Cell[])cells.get(i3);
				for (int j3 = 0; j3 < cs.length; j3++)
				{
					CellFormat format = cs[j3].getCellFormat();
					Label label = null;
					if (format != null)
						label = new Label(j3, i3 + trailStartRow, cs[j3].getContents(), format);
					else
						label = new Label(j3, i3 + trailStartRow, cs[j3].getContents());
					try
					{
						sheet.addCell(label);
					}
					catch (RowsExceededException e)
					{
						e.printStackTrace();
					}
					catch (WriteException e)
					{
						e.printStackTrace();
					}
				}

			}

			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for3 end");
			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for4 start");
			for (int t = 0; t < trailRanges.size(); t++)
			{
				Range range = (Range)trailRanges.get(t);
				Cell topLeft = range.getTopLeft();
				Cell bottomRight = range.getBottomRight();
				int row2 = topLeft.getRow();
				try
				{
					sheet.mergeCells(topLeft.getColumn(), (topLeft.getRow() - startR) + trailStartRow, bottomRight.getColumn(), (bottomRight.getRow() - startR) + trailStartRow);
				}
				catch (RowsExceededException e)
				{
					e.printStackTrace();
				}
				catch (WriteException e)
				{
					e.printStackTrace();
				}
			}

			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for4 end");
			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for5 start");
			for (int i4 = 0; i4 <= trailH; i4++)
			{
				for (int j4 = 0; j4 < trailRanges.size(); j4++)
					sheet.unmergeCells((Range)trailRanges.get(j4));

			}

			logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for5 end");
		}
	}

	private void merge()
	{
		contentsMerge();
		downNullMerge();
	}

	private void contentsMerge()
	{
		WritableSheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Iterator it = mergeCol.iterator();
		logger.log("SimpleWorkbook contentsMerge()-----while start");
		while (it.hasNext()) 
		{
			Integer col = (Integer)it.next();
			Map map = new HashMap();
			String last = null;
			int count = 0;
			for (int i = startRow; i <= rows; i++)
			{
				Cell cell = sheet.getCell(col.intValue(), i);
				String contents = cell.getContents();
				if (last == null || last == "")
					last = contents;
				else
				if (contents.equals(last))
				{
					count++;
				} else
				{
					if (count > 0)
					{
						map.put(new Integer(i - count - 1), new Integer(i - 1));
						count = 0;
					}
					last = contents;
				}
			}

			if (count > 0)
			{
				map.put(new Integer(rows - count), new Integer(rows));
				count = 0;
			}
			Set set = map.keySet();
			for (Iterator it2 = set.iterator(); it2.hasNext();)
			{
				Integer row = (Integer)it2.next();
				Integer row2 = (Integer)map.get(row);
				try
				{
					sheet.mergeCells(col.intValue(), row.intValue(), col.intValue(), row2.intValue());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		}
		logger.log("SimpleWorkbook contentsMerge()-----while end");
	}

	private void downNullMerge()
	{
		WritableSheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Iterator it = downNullMergeCol.iterator();
		logger.log("SimpleWorkbook downNullMerge()-----while start");
		while (it.hasNext()) 
		{
			Integer col = (Integer)it.next();
			Map map = new HashMap();
			String last = null;
			int count = 0;
			for (int i = startRow; i <= rows; i++)
			{
				Cell cell = sheet.getCell(col.intValue(), i);
				String contents = cell.getContents();
				if (contents == null || contents.trim().equals(""))
				{
					count++;
				} else
				{
					if (count > 0 && last != null)
					{
						map.put(new Integer(i - count - 1), new Integer(i - 1));
						count = 0;
					}
					last = contents;
				}
			}

			if (count > 0)
			{
				map.put(new Integer(rows - count), new Integer(rows));
				count = 0;
			}
			Set set = map.keySet();
			for (Iterator it2 = set.iterator(); it2.hasNext();)
			{
				Integer row = (Integer)it2.next();
				Integer row2 = (Integer)map.get(row);
				try
				{
					sheet.mergeCells(col.intValue(), row.intValue(), col.intValue(), row2.intValue());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		}
		logger.log("SimpleWorkbook downNullMerge()-----while end");
	}

	public void set(String name, String value)
	{
		if (value == null)
		{
			System.out.println((new StringBuilder("将")).append(name).append("的值null转化成了空").toString());
			value = "";
		}
		WritableSheet sheet = workbook.getSheet(0);
		logger.log("SimpleWorkbook set(String name, String value)-----for start");
		for (int i = 0; i < sheet.getRows(); i++)
		{
			for (int j = 0; j < sheet.getColumns(); j++)
			{
				Cell cell2 = sheet.getCell(j, i);
				String cont = cell2.getContents().trim();
				if (contains(cont, name))
				{
					cont = replace(cont, name, value);
					try
					{
						add(i, j, cont, "TEXT");
					}
					catch (ExcelException e)
					{
						e.printStackTrace();
					}
				}
			}

		}

		logger.log("SimpleWorkbook set(String name, String value)-----for end");
	}

	private static String replace(String str, String name, String value)
	{
		if (str == null || str.trim().equals(""))
			return "";
		int index = str.indexOf(name);
		if (index == -1)
			return str;
		if (str.substring(index - 2, index).equals("#=") && str.substring(index + name.length()).startsWith("#"))
		{
			StringBuffer sb = new StringBuffer(str.substring(0, index - 2));
			sb.append(value);
			sb.append(str.substring(index + name.length() + 1));
			return replace(sb.toString(), name, value);
		} else
		{
			return str;
		}
	}

	private void copy(CellFormat format, WritableCellFormat wcf)
	{
		try
		{
			wcf.setAlignment(format.getAlignment());
			wcf.setBackground(format.getBackgroundColour(), format.getPattern());
			wcf.setFont((FontRecord)format.getFont());
			wcf.setOrientation(format.getOrientation());
			wcf.setBorder(Border.TOP, format.getBorder(Border.TOP));
			wcf.setBorder(Border.LEFT, format.getBorder(Border.LEFT));
			wcf.setBorder(Border.RIGHT, format.getBorder(Border.RIGHT));
			wcf.setBorder(Border.BOTTOM, format.getBorder(Border.BOTTOM));
			wcf.setVerticalAlignment(format.getVerticalAlignment());
			wcf.setWrap(format.getWrap());
		}
		catch (WriteException e)
		{
			e.printStackTrace();
		}
	}

	private int getFrac(Cell oldCell)
	{
		int column = oldCell.getColumn();
		Integer i = (Integer)numberCols.get(new Integer(column));
		return i.intValue();
	}

	private boolean isNumber(Cell cell)
	{
		int column = cell.getColumn();
		return numberCols.containsKey(new Integer(column));
	}

	private CellFormat getFormat(Cell cell)
	{
		CellFormat format = null;
		String contents = cell.getContents();
		if (contents != null && contents != "")
		{
			int s = contents.indexOf("#=");
			if (contents.trim().equals("#cell#") || s != -1)
			{
				format = cell.getCellFormat();
				return format;
			}
		}
		Integer row = new Integer(cell.getRow());
		Integer col = new Integer(cell.getColumn());
		if (rowFormat.containsKey(row))
		{
			format = (CellFormat)rowFormat.get(row);
			return format;
		}
		if (colFormat.containsKey(col))
		{
			format = (CellFormat)colFormat.get(col);
			return format;
		}
		if (bothFormat != null)
		{
			format = bothFormat;
			return format;
		} else
		{
			return defaultFormat;
		}
	}

	public void write()
		throws ExcelException
	{
		try
		{
			workbook.write();
			System.out.println("SimpleWorkbook----write();");
		}
		catch (IOException e)
		{
			throw new ExcelException(e);
		}
	}

	public void close()
		throws ExcelException
	{
		try
		{
			workbook.close();
			System.out.println("SimpleWorkbook----close();");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new ExcelException(e);
		}
	}

	private void clearSign()
	{
		WritableSheet sheet = workbook.getSheet(0);
		logger.log("SimpleWorkbook clearSign()-----for start");
		Range mc[] = sheet.getMergedCells();
		for (int i = 0; i < templetRow; i++)
		{
			for (int j = 0; j < templetCol; j++)
			{
				Cell cell2 = sheet.getWritableCell(j, i);
				String contents = cell2.getContents();
				if (isSign(contents))
				{
					for (int t = 0; t < mc.length; t++)
					{
						if (mc[t].getTopLeft().getColumn() > cell2.getColumn() || mc[t].getTopLeft().getRow() > cell2.getRow() || mc[t].getBottomRight().getColumn() < cell2.getColumn() || mc[t].getBottomRight().getRow() < cell2.getRow())
							continue;
						int tlc = mc[t].getTopLeft().getColumn();
						int tlr = mc[t].getTopLeft().getRow();
						int brc = mc[t].getBottomRight().getColumn();
						int brr = mc[t].getBottomRight().getRow();
						sheet.unmergeCells(mc[t]);
						try
						{
							for (int t2r = tlr; t2r <= brr; t2r++)
							{
								for (int t2c = tlc; t2c <= brc; t2c++)
									sheet.addCell(new Label(t2c, t2r, ""));

							}

						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						break;
					}

					try
					{
						Label label = new Label(j, i, "");
						sheet.addCell(label);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}

		}

		logger.log("SimpleWorkbook clearSign()-----for end");
	}

	private boolean isSign(String str)
	{
		String cont = str.trim();
		return cont.startsWith("#");
	}

	private boolean contains(String str, String var)
	{
		int s = str.indexOf("#=");
		if (s == -1 || s >= str.length() - 2)
			return false;
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, s));
		String tmp = str.substring(s + 2);
		int e = tmp.indexOf("#");
		if (e == -1)
			return false;
		String v = tmp.substring(0, e);
		return v.equalsIgnoreCase(var);
	}

	public static ZipInfo getZipFiles(String srcFileName[], String zipFileName, long usefullLifeSec)
	{
		ZipInfo info = new ZipInfo();
		long usefulLifeSecs1 = usefullLifeSec;
		File files[] = new File[srcFileName.length];
		for (int i = 0; i < srcFileName.length; i++)
			files[i] = new File((new StringBuilder(String.valueOf(Config.getWorkPath()))).append(File.separator).append(srcFileName[i]).toString());

		File zipFile = new File((new StringBuilder(String.valueOf(Config.getWorkPath()))).append(File.separator).append(zipFileName).toString());
		byte buf[] = new byte[1024];
		try
		{
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
			for (int i = 0; i < files.length; i++)
			{
				FileInputStream in = new FileInputStream(files[i]);
				out.putNextEntry(new ZipEntry(files[i].getName()));
				int len;
				while ((len = in.read(buf)) > 0) 
					out.write(buf, 0, len);
				out.closeEntry();
				in.close();
			}

			out.close();
			System.out.println("压缩完成.");
			info = ExcelUtil.prepare1(zipFileName, usefulLifeSecs1);
		}
		catch (IOException e)
		{
			info.zipExists = false;
			e.printStackTrace();
		}
		return info;
	}

	public static void copyFile(String oldPath, String newPath)
	{
		try
		{
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists())
			{
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte buffer[] = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) 
				{
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		}
		catch (Exception e)
		{
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	public static void main(String args[])
		throws ExcelException
	{
		SimpleWorkbook workbook = new SimpleWorkbook("d:\\var\\map_e2e_file_folder\\tmp\\2007\\8\\22\\633233789295244910282.xls", "d:\\var\\map_e2e_file_folder\\tmp\\2007\\8\\22\\1\\633233789295244910282.xls");
		String array[][] = {
			{
				"1", "1", "1", "1"
			}, {
				"2", "2", "2", "2"
			}, {
				"0", "0", "0", "0"
			}, {
				"3", "3", "3", "3"
			}, {
				"", "", "", ""
			}, {
				"   ", "   ", "   ", "   "
			}, {
				"null", "null", "null", "null"
			}
		};
		workbook.add(array);
		workbook.close();
	}
}
