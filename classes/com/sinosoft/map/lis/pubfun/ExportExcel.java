// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExportExcel.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.DBConnPool;
import com.sinosoft.map.utility.StrTool;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			FDate, PubFun

public class ExportExcel
{
	public static class Cell
	{

		public int col;
		public int row;
		public int width;
		public int height;
		public boolean bBorder;
		public boolean bBold;
		public String content;

		public Cell()
		{
			width = 1;
			height = 1;
			bBorder = false;
			bBold = false;
			content = "";
		}
	}

	public static class Format
	{

		public ArrayList mListCell;
		public ArrayList mListBL;
		public ArrayList mListColWidth;

		public Format()
		{
			mListCell = null;
			mListBL = null;
			mListColWidth = null;
		}
	}

	public static class ListBlock
	{

		private String companyCode;
		public String colName[];
		public String sql;
		public int row1;
		public int col1;
		public int row2;
		public int col2;
		public int size;
		public String data[][];

		public boolean InitData()
		{
			Connection conn;
			if (sql == null || sql.equals(""))
				return false;
			conn = null;
			conn = DBConnPool.getConnection();
			if (conn != null)
				break MISSING_BLOCK_LABEL_52;
			System.out.println("数据库连接失败！");
			try
			{
				conn.close();
			}
			catch (Exception exception1) { }
			return false;
			try
			{
				data = ExportExcel.exeSQL(sql, conn);
				if (data == null)
				{
					row2 = row1;
					col2 = col1;
					if (colName != null)
					{
						row2++;
						col2 += colName.length;
					}
				} else
				{
					row2 = row1 + data.length;
					size = data.length;
					if (colName != null)
					{
						row2++;
						col2 = col1 + colName.length;
					} else
					if (data.length > 1)
						col2 = col1 + data[0].length;
					else
						col2 = col1;
				}
				break MISSING_BLOCK_LABEL_252;
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			try
			{
				conn.close();
			}
			catch (Exception exception2) { }
			return false;
			Exception exception;
			exception;
			try
			{
				conn.close();
			}
			catch (Exception exception3) { }
			throw exception;
			try
			{
				conn.close();
			}
			catch (Exception exception4) { }
			return true;
		}

		public ListBlock(String str)
		{
			colName = null;
			row1 = 0;
			col1 = 0;
			size = 0;
			data = null;
			companyCode = str;
		}
	}


	public static void AddCellToList(ArrayList list, String text, int row, int col, int width, int height, boolean bBorder, boolean bBold)
	{
		Cell tCell = new Cell();
		tCell.row = row;
		tCell.col = col;
		tCell.bBorder = bBorder;
		tCell.bBold = bBold;
		tCell.height = height;
		tCell.width = width;
		tCell.content = text;
		list.add(tCell);
	}

	public ExportExcel()
	{
	}

	public boolean write(Format format, BufferedOutputStream bos)
	{
		if (format == null)
			return false;
		ArrayList listCell = format.mListCell;
		ArrayList listLB = format.mListBL;
		ArrayList listColWidth = format.mListColWidth;
		if (listCell == null && listLB == null)
			return false;
		if (bos == null)
			return false;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		try
		{
			if (listColWidth != null)
			{
				for (int i = 0; i < listColWidth.size(); i++)
				{
					String para[] = (String[])listColWidth.get(i);
					short nCol = (short)Integer.parseInt(para[0]);
					short nWidth = (short)Integer.parseInt(para[1]);
					sheet.setColumnWidth(nCol, nWidth);
				}

			}
			HSSFFont fontBold = wb.createFont();
			fontBold.setFontHeightInPoints((short)10);
			fontBold.setFontName("宋体");
			fontBold.setBoldweight((short)700);
			HSSFFont fontNormal = wb.createFont();
			fontNormal.setFontHeightInPoints((short)10);
			fontNormal.setFontName("宋体");
			fontNormal.setBoldweight((short)400);
			HSSFCellStyle styleBorderBold = wb.createCellStyle();
			styleBorderBold.setBorderBottom((short)1);
			styleBorderBold.setBorderLeft((short)1);
			styleBorderBold.setBorderRight((short)1);
			styleBorderBold.setBorderTop((short)1);
			styleBorderBold.setFont(fontBold);
			HSSFCellStyle styleBorderNormal = wb.createCellStyle();
			styleBorderNormal.setBorderBottom((short)1);
			styleBorderNormal.setBorderLeft((short)1);
			styleBorderNormal.setBorderRight((short)1);
			styleBorderNormal.setBorderTop((short)1);
			styleBorderNormal.setFont(fontNormal);
			HSSFCellStyle styleBold = wb.createCellStyle();
			styleBold.setFont(fontBold);
			HSSFCellStyle styleNormal = wb.createCellStyle();
			styleNormal.setFont(fontNormal);
			if (listLB != null)
			{
				for (int iLB = 0; iLB < listLB.size(); iLB++)
				{
					ListBlock currLB = (ListBlock)listLB.get(iLB);
					int startRow = currLB.row1;
					for (int i = 0; currLB.colName != null && i < currLB.colName.length; i++)
					{
						int rowIndex = startRow;
						int colIndex = currLB.col1 + i;
						HSSFRow row = sheet.getRow(rowIndex);
						if (row == null)
							row = sheet.createRow(rowIndex);
						HSSFCell cell = row.getCell((short)colIndex);
						if (cell == null)
							cell = row.createCell((short)colIndex);
						cell.setCellType(1);
						cell.setCellStyle(styleBorderBold);
						cell.setEncoding((short)1);
						cell.setCellValue(currLB.colName[i]);
					}

					if (currLB.colName != null)
						startRow = currLB.row1 + 1;
					String data[][] = currLB.data;
					if (data != null)
					{
						for (int i = 0; i < data.length; i++)
						{
							for (int j = 0; j < data[i].length; j++)
							{
								int rowIndex = startRow + i;
								int colIndex = currLB.col1 + j;
								HSSFRow row = sheet.getRow(rowIndex);
								if (row == null)
									row = sheet.createRow(rowIndex);
								HSSFCell cell = row.getCell((short)colIndex);
								if (cell == null)
									cell = row.createCell((short)colIndex);
								cell.setCellType(1);
								cell.setCellStyle(styleBorderNormal);
								cell.setEncoding((short)1);
								cell.setCellValue(data[i][j]);
							}

						}

					}
				}

			}
			if (listCell != null)
			{
				for (int i = 0; i < listCell.size(); i++)
				{
					Cell currCell = (Cell)listCell.get(i);
					for (int j = currCell.row; j < currCell.row + currCell.height; j++)
					{
						for (int k = currCell.col; k < currCell.col + currCell.width; k++)
						{
							HSSFRow trow = sheet.getRow(j);
							if (trow == null)
								trow = sheet.createRow(j);
							HSSFCell tcell = trow.getCell((short)k);
							if (tcell == null)
								tcell = trow.createCell((short)k);
							tcell.setCellType(1);
							tcell.setEncoding((short)1);
							if (j == currCell.row && k == currCell.col)
								tcell.setCellValue(currCell.content);
							if (currCell.bBorder)
							{
								if (currCell.bBold)
									tcell.setCellStyle(styleBorderBold);
								else
									tcell.setCellStyle(styleBorderNormal);
							} else
							if (currCell.bBold)
								tcell.setCellStyle(styleBold);
							else
								tcell.setCellStyle(styleNormal);
						}

					}

					if (currCell.height > 1 || currCell.width > 1)
						sheet.addMergedRegion(new Region(currCell.row, (short)currCell.col, (currCell.row + currCell.height) - 1, (short)((currCell.col + currCell.width) - 1)));
				}

			}
			wb.write(bos);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}

	public static String[][] exeSQL(String sql, String companyCode)
	{
		String retArray[][];
		Statement stmt;
		ResultSet rs;
		ArrayList tempList;
		Connection conn;
		retArray = null;
		stmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		String mResult = "";
		tempList = new ArrayList();
		System.out.println((new StringBuilder("ExportExcel.exeSQL() : ")).append(sql.trim()).toString());
		conn = null;
		conn = DBConnPool.getConnection();
		if (conn == null)
		{
			System.out.println("数据库连接失败！");
			return null;
		}
		try
		{
			stmt = conn.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			int k = 0;
			String tempRow[];
			for (; rs.next(); tempList.add(tempRow))
			{
				tempRow = new String[n];
				k++;
				for (int j = 1; j <= n; j++)
				{
					String strValue = "";
					strValue = getDataValue(rsmd, rs, j);
					tempRow[j - 1] = strValue;
				}

			}

			rs.close();
			stmt.close();
			if (tempList.size() > 0)
			{
				retArray = new String[tempList.size()][];
				for (int i = 0; i < tempList.size(); i++)
				{
					String row[] = (String[])tempList.get(i);
					retArray[i] = row;
				}

			}
			break MISSING_BLOCK_LABEL_318;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				rs.close();
				stmt.close();
			}
			catch (Exception exception) { }
		}
		try
		{
			conn.close();
		}
		catch (Exception exception2) { }
		break MISSING_BLOCK_LABEL_330;
		Exception exception1;
		exception1;
		try
		{
			conn.close();
		}
		catch (Exception exception3) { }
		throw exception1;
		try
		{
			conn.close();
		}
		catch (Exception exception4) { }
		return retArray;
	}

	public static String[][] exeSQL(String sql, Connection conn)
	{
		String retArray[][] = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String mResult = "";
		ArrayList tempList = new ArrayList();
		System.out.println((new StringBuilder("ExportExcel.exeSQL() : ")).append(sql.trim()).toString());
		boolean connflag = true;
		if (conn == null)
		{
			System.out.println("数据库连接失败！");
			return null;
		}
		try
		{
			stmt = conn.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			int k = 0;
			String tempRow[];
			for (; rs.next(); tempList.add(tempRow))
			{
				tempRow = new String[n];
				k++;
				for (int j = 1; j <= n; j++)
				{
					String strValue = "";
					strValue = getDataValue(rsmd, rs, j);
					tempRow[j - 1] = strValue;
				}

			}

			rs.close();
			stmt.close();
			if (tempList.size() > 0)
			{
				retArray = new String[tempList.size()][];
				for (int i = 0; i < tempList.size(); i++)
				{
					String row[] = (String[])tempList.get(i);
					retArray[i] = row;
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				rs.close();
				stmt.close();
			}
			catch (Exception exception) { }
		}
		return retArray;
	}

	public static String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
	{
		String strValue = "";
		try
		{
			int dataType = rsmd.getColumnType(i);
			int dataScale = rsmd.getScale(i);
			int dataPrecision = rsmd.getPrecision(i);
			if (dataType == 1 || dataType == 12)
				strValue = StrTool.unicodeToGBK(rs.getString(i));
			if (dataType == 93 || dataType == 91)
				strValue = (new FDate()).getString(rs.getDate(i));
			if (dataType == 3 || dataType == 8)
				strValue = String.valueOf(rs.getDouble(i));
			if (dataType == 4 || dataType == 5)
				strValue = String.valueOf(rs.getInt(i));
			if (dataType == 2)
				if (dataScale == 0)
				{
					if (dataPrecision == 0)
						strValue = String.valueOf(rs.getDouble(i));
					else
						strValue = String.valueOf(rs.getLong(i));
				} else
				{
					strValue = String.valueOf(rs.getBigDecimal(i));
					System.out.println((new StringBuilder("BigDecimal: The Numeric is = ")).append(strValue).toString());
				}
			if (strValue == null)
				strValue = "";
			strValue = PubFun.getInt(strValue);
		}
		catch (Exception exception) { }
		return strValue;
	}

	public static void main(String args[])
	{
		ExportExcel excel = new ExportExcel();
		try
		{
			Format format = new Format();
			ArrayList listCell = new ArrayList();
			ArrayList listLB = new ArrayList();
			ArrayList listColWidth = new ArrayList();
			format.mListCell = listCell;
			format.mListBL = listLB;
			format.mListColWidth = listColWidth;
			listColWidth.add(new String[] {
				"0", "5000"
			});
			ListBlock tLB1 = new ListBlock("001");
			tLB1.colName = (new String[] {
				"集体合同号码", "被保人客户号", "姓名", "性别", "出生日期", "证件类型", "证件号码", "保险计划"
			});
			tLB1.sql = "select Grpcontno,InsuredNo,Name,Sex,Birthday,IDType,IDNo,ContPlanCode From LCInsured where Grpcontno='140110000000041'";
			tLB1.col1 = 0;
			tLB1.row1 = 0;
			tLB1.InitData();
			listLB.add(tLB1);
			File of = new File("d:\\excel.xls");
			FileOutputStream ofs = new FileOutputStream(of);
			BufferedOutputStream bos = new BufferedOutputStream(ofs);
			excel.write(format, bos);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
