// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExcelPubFun.java

package com.sinosoft.banklns.utility;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, CError, SSRS

public class ExcelPubFun
{

	public CErrors mErrors;
	public SSRS tResult;

	public ExcelPubFun()
	{
		mErrors = new CErrors();
	}

	public static void main(String args1[])
	{
	}

	public boolean ReadExcelData(String tExcelName, String tExcelPath, String tSheetName, String tStartPosition, int tColCount)
	{
		tExcelPath = tExcelPath.charAt(tExcelPath.length() - 1) == '/' ? tExcelPath : (new StringBuilder(String.valueOf(tExcelPath))).append("/").toString();
		String tCheckFile = CheckFilePath(tExcelName, tExcelPath);
		if (tCheckFile.equals("Succ"))
			break MISSING_BLOCK_LABEL_97;
		CError tError = new CError();
		tError.moduleName = "LAAddSubImportBL";
		tError.functionName = "readExcelFile";
		tError.errorMessage = tCheckFile;
		mErrors.addOneError(tError);
		return false;
		HSSFSheet tWorkSheet;
		tExcelPath = tExcelPath.charAt(tExcelPath.length() - 1) == '/' ? tExcelPath : (new StringBuilder(String.valueOf(tExcelPath))).append("/").toString();
		POIFSFileSystem tInputFile = new POIFSFileSystem(new FileInputStream((new StringBuilder(String.valueOf(tExcelPath))).append(tExcelName).toString()));
		HSSFWorkbook tWorkBook = new HSSFWorkbook(tInputFile);
		tWorkSheet = tWorkBook.getSheet(tSheetName);
		if (tWorkSheet == null)
			tWorkSheet = tWorkBook.getSheetAt(0);
		HSSFRow tWorkRow = null;
		HSSFCell tWorkCell = null;
		if (CheckCoordinate(tStartPosition))
			break MISSING_BLOCK_LABEL_258;
		CError tError = new CError();
		tError.moduleName = "LAAddSubImportBL";
		tError.functionName = "readExcelFile";
		tError.errorMessage = "�趨����ݿ����Ͻ���겻��ȷ,��������¶�ȡExcel";
		mErrors.addOneError(tError);
		return false;
		try
		{
			double tRealTargetStart[][] = GetCoordinate(tStartPosition);
			tResult = new SSRS(tColCount);
			DecimalFormat df = new DecimalFormat("############.#####");
			boolean tReadFlag = true;
			for (int i = (int)tRealTargetStart[0][1] - 1; tReadFlag; i++)
			{
				HSSFRow tWorkRow = tWorkSheet.getRow(i);
				if (tWorkRow == null)
				{
					tReadFlag = false;
					break;
				}
				for (int j = 0; j < tColCount; j++)
				{
					HSSFCell tWorkCell = tWorkRow.getCell((short)(((int)tRealTargetStart[0][0] + j) - 1));
					if (tWorkCell == null)
						tResult.SetText("");
					else
						switch (tWorkCell.getCellType())
						{
						case 1: // '\001'
							tResult.SetText(tWorkCell.getStringCellValue());
							break;

						case 0: // '\0'
							tResult.SetText(df.format(tWorkCell.getNumericCellValue()));
							break;

						case 2: // '\002'
							tResult.SetText(df.format(tWorkCell.getNumericCellValue()));
							break;

						case 3: // '\003'
							tResult.SetText("");
							break;
						}
				}

			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "LAAddSubImportBL";
			tError.functionName = "readExcelFile";
			tError.errorMessage = (new StringBuilder("����Excel��ݳ��,ԭ����")).append(e).toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	private boolean CheckCoordinate(String tTargetString)
	{
		if (tTargetString == null || tTargetString.equals(""))
			return false;
		char tCode[] = tTargetString.toUpperCase().toCharArray();
		for (int i = 0; i < tCode.length; i++)
		{
			int tASC = tCode[i];
			if (tASC < 48 || tASC > 90 || tASC > 57 && tASC < 65)
				return false;
			if (i == 0 && tASC < 65)
				return false;
		}

		return true;
	}

	public double[][] GetCoordinate(String tTargetString)
	{
		double tResult[][] = {
			{
				0.0D, 0.0D
			}
		};
		char tCode[] = tTargetString.toUpperCase().toCharArray();
		int tSplitKey = 0;
		int tASC = 0;
		double tMI = 0.0D;
		for (int i = 0; i < tCode.length; i++)
		{
			tASC = tCode[i];
			if (tASC >= 65)
				continue;
			tSplitKey = i;
			break;
		}

		char tCol[] = tTargetString.substring(0, tSplitKey).toCharArray();
		for (int i = 0; i < tCol.length; i++)
		{
			tASC = tCode[i];
			int tColint = tCol.length - i - 1;
			tMI = tColint;
			tResult[0][0] = tResult[0][0] + Math.pow(26D, tMI) * (double)(tASC - 64);
		}

		tResult[0][1] = Double.parseDouble(tTargetString.substring(tSplitKey, tTargetString.length()));
		return tResult;
	}

	private static String CheckFilePath(String tReportFile, String tFilePath)
	{
		File file = new File(tFilePath);
		if (!file.exists())
			return "�ļ����·�������ڣ���ȷ�ϴ��·��������ȷ�� ";
		File file2 = new File(tFilePath, tReportFile);
		if (!file2.exists())
			return "Excel�ļ������ڣ���ȷ���ļ��Ѿ���ȷ�ϴ��� ";
		else
			return "Succ";
	}

	public SSRS getExcelData()
	{
		return tResult;
	}

	public CErrors getErrors()
	{
		return mErrors;
	}
}
