// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SSRS.java

package com.sinosoft.map.utility;

import java.util.Vector;

// Referenced classes of package com.sinosoft.map.utility:
//			CErrors, CError, StrTool

public class SSRS
{

	private Vector RData;
	public int MaxCol;
	public int MaxRow;
	public int MaxNumber;
	public CErrors mErrors;
	public boolean ErrorFlag;

	public SSRS()
	{
		RData = new Vector();
		MaxCol = 0;
		MaxRow = 0;
		MaxNumber = 0;
		mErrors = new CErrors();
		ErrorFlag = false;
	}

	public SSRS(int n)
	{
		RData = new Vector();
		MaxCol = 0;
		MaxRow = 0;
		MaxNumber = 0;
		mErrors = new CErrors();
		ErrorFlag = false;
		MaxCol = n;
	}

	public void SetText(String strValue)
	{
		RData.addElement(strValue);
		MaxNumber = RData.size();
		if (MaxNumber % MaxCol == 0)
			MaxRow = MaxNumber / MaxCol;
		else
			MaxRow = MaxNumber / MaxCol + 1;
	}

	public String GetText(int cRow, int cCol)
	{
		String Result = "";
		int Number = ((cRow - 1) * MaxCol + cCol) - 1;
		if (Number <= MaxNumber)
		{
			Result = (String)RData.get(Number);
		} else
		{
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "GetText";
			tError.errorMessage = "指定的位置在结果集中没有数据";
			mErrors.addOneError(tError);
			ErrorFlag = true;
		}
		return Result;
	}

	public int getMaxCol()
	{
		return MaxCol;
	}

	public int getMaxRow()
	{
		return MaxRow;
	}

	public int getMaxNumber()
	{
		return MaxNumber;
	}

	public void setMaxCol(int aMaxCol)
	{
		MaxCol = aMaxCol;
	}

	public void setMaxRow(int aMaxRow)
	{
		MaxRow = aMaxRow;
	}

	public void setMaxNumber(int aMaxNumber)
	{
		MaxNumber = aMaxNumber;
	}

	public void Clear()
	{
		RData.clear();
		MaxRow = 0;
		MaxCol = 0;
		MaxNumber = 0;
	}

	public String[] getRowData(int cRow)
	{
		String StrArr[] = new String[MaxCol];
		for (int i = 0; i < MaxCol; i++)
			StrArr[i] = GetText(cRow, i + 1);

		return StrArr;
	}

	public String[][] getAllData()
	{
		String StrArr[][] = new String[MaxRow][MaxCol];
		for (int j = 0; j < MaxRow; j++)
			StrArr[j] = getRowData(j + 1);

		return StrArr;
	}

	public String encode()
	{
		String strReturn = "";
		if (MaxNumber != 0)
		{
			strReturn = (new StringBuilder("0|")).append(String.valueOf(MaxRow)).append("^").toString();
			for (int i = 1; i <= MaxRow; i++)
			{
				for (int j = 1; j <= MaxCol; j++)
					if (j != MaxCol)
						strReturn = (new StringBuilder(String.valueOf(strReturn))).append(GetText(i, j)).append("|").toString();
					else
						strReturn = (new StringBuilder(String.valueOf(strReturn))).append(GetText(i, j)).toString();

				if (i != MaxRow)
					strReturn = (new StringBuilder(String.valueOf(strReturn))).append("^").toString();
			}

		}
		return strReturn;
	}

	public boolean addCol(SSRS aSSRS)
	{
		if (MaxRow != aSSRS.getMaxRow())
		{
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "addCol";
			tError.errorMessage = "合并的两个结果集行数不等！！！";
			mErrors.addOneError(tError);
			return false;
		}
		SSRS bSSRS = null;
		try
		{
			bSSRS = (SSRS)clone();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "addCol";
			tError.errorMessage = "克隆出错！！！";
			mErrors.addOneError(tError);
			return false;
		}
		Clear();
		setMaxCol(bSSRS.getMaxCol() + aSSRS.getMaxCol());
		for (int row = 1; row <= aSSRS.getMaxRow(); row++)
		{
			for (int bcol = 1; bcol <= bSSRS.getMaxCol(); bcol++)
				SetText(StrTool.cTrim(bSSRS.GetText(row, bcol)));

			for (int acol = 1; acol <= aSSRS.getMaxCol(); acol++)
				SetText(StrTool.cTrim(aSSRS.GetText(row, acol)));

		}

		return true;
	}

	public boolean addRow(SSRS aSSRS)
	{
		if (MaxCol != aSSRS.getMaxCol())
		{
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "addRow";
			tError.errorMessage = "合并的两个结果集列数不等！！！";
			mErrors.addOneError(tError);
			return false;
		}
		SSRS bSSRS = null;
		try
		{
			bSSRS = (SSRS)clone();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "addRow";
			tError.errorMessage = "克隆出错！！！";
			mErrors.addOneError(tError);
			return false;
		}
		Clear();
		setMaxCol(bSSRS.getMaxCol());
		for (int row = 1; row <= bSSRS.getMaxRow(); row++)
		{
			for (int col = 1; col <= bSSRS.getMaxCol(); col++)
				SetText(StrTool.cTrim(bSSRS.GetText(row, col)));

		}

		for (int row = 1; row <= aSSRS.getMaxRow(); row++)
		{
			for (int col = 1; col <= aSSRS.getMaxCol(); col++)
				SetText(StrTool.cTrim(aSSRS.GetText(row, col)));

		}

		return true;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		Object tObj = null;
		SSRS tSSRS = new SSRS();
		tSSRS.setMaxCol(getMaxCol());
		tSSRS.setMaxNumber(getMaxNumber());
		tSSRS.setMaxRow(getMaxRow());
		tSSRS.ErrorFlag = ErrorFlag;
		tSSRS.mErrors = mErrors;
		tSSRS.RData = (Vector)RData.clone();
		tObj = tSSRS;
		return tObj;
	}

	public static void main(String args1[])
	{
	}
}
