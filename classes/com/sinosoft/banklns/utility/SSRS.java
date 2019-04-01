// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SSRS.java

package com.sinosoft.banklns.utility;

import java.util.Vector;

// Referenced classes of package com.sinosoft.banklns.utility:
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
		try
		{
			RData.addElement(strValue);
			MaxNumber = RData.size();
			if (MaxNumber % MaxCol == 0)
				MaxRow = MaxNumber / MaxCol;
			else
				MaxRow = MaxNumber / MaxCol + 1;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
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
			tError.errorMessage = "ָ����λ���ڽ����û�����";
			mErrors.addOneError(tError);
			ErrorFlag = true;
		}
		return Result;
	}

	public boolean SetText(int cRow, int cCol, String newValue)
	{
		String Result = "";
		int Number = ((cRow - 1) * MaxCol + cCol) - 1;
		if (Number <= MaxNumber)
		{
			RData.remove(Number);
			RData.add(Number, newValue);
		} else
		{
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "GetText";
			tError.errorMessage = "ָ����λ���ڽ����û�����";
			mErrors.addOneError(tError);
			ErrorFlag = true;
		}
		return true;
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
			tError.errorMessage = "�ϲ���}��������ȣ�����?";
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
			tError.errorMessage = "��¡��?����";
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

	public boolean addColSSRS(SSRS aSSRS)
	{
		int maxRow = getMaxRow();
		if (MaxRow != aSSRS.getMaxRow())
			maxRow = Math.max(aSSRS.getMaxRow(), getMaxRow());
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
			tError.errorMessage = "��¡��?����";
			mErrors.addOneError(tError);
			return false;
		}
		Clear();
		setMaxCol(bSSRS.getMaxCol() + aSSRS.getMaxCol());
		for (int row = 1; row <= maxRow; row++)
		{
			for (int bcol = 1; bcol <= bSSRS.getMaxCol(); bcol++)
				if (row > bSSRS.getMaxRow())
					SetText(null);
				else
					SetText(StrTool.cTrim(bSSRS.GetText(row, bcol)));

			for (int acol = 1; acol <= aSSRS.getMaxCol(); acol++)
				if (row > aSSRS.getMaxRow())
					SetText(null);
				else
					SetText(StrTool.cTrim(aSSRS.GetText(row, acol)));

		}

		return true;
	}

	public boolean uniteSSRS(SSRS aSSRS, int noAddRow)
	{
		int maxRow = getMaxRow();
		if (MaxRow != aSSRS.getMaxRow())
			maxRow = Math.max(aSSRS.getMaxRow(), getMaxRow());
		int minRow = Math.min(aSSRS.getMaxRow(), getMaxRow());
		int maxCol = getMaxCol();
		if (MaxCol != aSSRS.getMaxCol())
			maxCol = Math.max(aSSRS.getMaxCol(), getMaxCol());
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
			tError.errorMessage = "��¡��?����";
			mErrors.addOneError(tError);
			return false;
		}
		Clear();
		setMaxCol(maxCol);
		for (int row = 1; row <= maxRow; row++)
		{
			for (int col = 1; col <= maxCol; col++)
				if (row > maxRow)
					SetText(null);
				else
				if (row > aSSRS.getMaxRow())
					SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
				else
				if (row > bSSRS.getMaxRow() || this == null)
					SetText(StrTool.cTrim(aSSRS.GetText(row, col)));
				else
				if (1 == col)
					SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
				else
					SetText(Double.toString(Double.parseDouble(StrTool.cTrim(aSSRS.GetText(row, col))) + Double.parseDouble(StrTool.cTrim(bSSRS.GetText(row, col)))));

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
			tError.errorMessage = "�ϲ���}��������ȣ�����?";
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
			tError.errorMessage = "��¡��?����";
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

	public boolean addRowSSRS(SSRS aSSRS)
	{
		int maxCol = getMaxCol();
		if (MaxCol != aSSRS.getMaxCol())
			maxCol = Math.max(getMaxCol(), aSSRS.getMaxCol());
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
			tError.errorMessage = "��¡��?����";
			mErrors.addOneError(tError);
			return false;
		}
		Clear();
		setMaxCol(maxCol);
		for (int row = 1; row <= bSSRS.getMaxRow(); row++)
		{
			for (int col = 1; col <= maxCol; col++)
				if (col > bSSRS.getMaxCol())
					SetText(null);
				else
					SetText(StrTool.cTrim(bSSRS.GetText(row, col)));

		}

		for (int row = 1; row <= aSSRS.getMaxRow(); row++)
		{
			for (int col = 1; col <= maxCol; col++)
				if (col > aSSRS.getMaxCol())
					SetText(null);
				else
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

	public String[] getColData(int col)
	{
		if (col > MaxCol)
			return null;
		String StrArr[] = new String[MaxRow];
		for (int i = 0; i < MaxRow; i++)
			StrArr[i] = GetText(i + 1, col);

		return StrArr;
	}

	public boolean setTextAt(int aRow, int aCol, String aContent)
	{
		boolean result = false;
		int Number = ((aRow - 1) * MaxCol + aCol) - 1;
		if (Number <= MaxNumber)
		{
			try
			{
				RData.setElementAt(aContent, Number);
			}
			catch (Exception ex)
			{
				CError tError = new CError();
				tError.moduleName = "SSRS";
				tError.functionName = "GetText";
				tError.errorMessage = "ָ����λ���ڽ����û�����";
				mErrors.addOneError(tError);
				ErrorFlag = true;
				result = false;
			}
		} else
		{
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "GetText";
			tError.errorMessage = "ָ����λ���ڽ����û�����";
			mErrors.addOneError(tError);
			ErrorFlag = true;
		}
		return result;
	}

	public boolean removeRow(int row)
	{
		if (row <= 0 || row > getMaxRow())
		{
			CError tError = new CError();
			tError.moduleName = "SSRS";
			tError.functionName = "removeRow";
			tError.errorMessage = "�����������Ϸ�";
			mErrors.addOneError(tError);
			return false;
		}
		Vector data = RData;
		int preNum = getMaxCol() * (row - 1) + 1;
		int endNum = getMaxCol() * row;
		for (int i = endNum - 1; i >= preNum - 1; i--)
			data.remove(i);

		MaxRow--;
		MaxNumber = MaxNumber - getMaxCol();
		return true;
	}

	public static void main(String args1[])
	{
	}
}
