// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileDeal.java

package com.sinosoft.map.utility;

import java.io.*;

// Referenced classes of package com.sinosoft.map.utility:
//			CErrors, CError

public class FileDeal
{

	public CErrors mErrors;
	private String OriPathName;
	private String DesPathName;
	private File mFile;

	public FileDeal(String aStr)
	{
		mErrors = new CErrors();
		OriPathName = aStr;
	}

	public boolean FileCopy(String aStr)
	{
		try
		{
			DesPathName = aStr;
			int nChar = -1;
			FileInputStream in = new FileInputStream(OriPathName);
			FileOutputStream out = new FileOutputStream(DesPathName);
			while ((nChar = in.read()) != -1) 
				out.write(nChar);
			out.flush();
			in.close();
			out.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "FileDeal";
			tError.functionName = "FileCopy";
			tError.errorMessage = "文件复制出错!";
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public boolean FileMove(String aStr)
	{
		DesPathName = aStr;
		mFile = new File(OriPathName);
		File tFile = new File(DesPathName);
		if (mFile.renameTo(tFile))
			break MISSING_BLOCK_LABEL_79;
		CError tError = new CError();
		tError.moduleName = "FileDeal";
		tError.functionName = "FileMove";
		tError.errorMessage = "文件移动出错!";
		mErrors.addOneError(tError);
		return false;
		if (mFile.createNewFile())
			break MISSING_BLOCK_LABEL_125;
		CError tError = new CError();
		tError.moduleName = "FileDeal";
		tError.functionName = "FileMove";
		tError.errorMessage = "文件移动出错!";
		mErrors.addOneError(tError);
		return false;
label0:
		{
			try
			{
				File tFile = new File(OriPathName);
				if (tFile.delete())
					break label0;
				CError tError = new CError();
				tError.moduleName = "FileDeal";
				tError.functionName = "FileMove";
				tError.errorMessage = "文件移动出错!";
				mErrors.addOneError(tError);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				CError tError = new CError();
				tError.moduleName = "FileDeal";
				tError.functionName = "FileMove";
				tError.errorMessage = "文件移动出错!";
				mErrors.addOneError(tError);
				return false;
			}
			return false;
		}
		return true;
	}

	public boolean FileDel()
	{
		File tFile = new File(OriPathName);
		if (!tFile.delete())
		{
			CError tError = new CError();
			tError.moduleName = "FileDeal";
			tError.functionName = "FileDel";
			tError.errorMessage = "文件删除出错!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			return true;
		}
	}

	public static void main(String args[])
	{
		FileDeal fileDeal1 = new FileDeal("E:\\test.xml");
		fileDeal1.FileCopy("E:\\ui\\test.xml");
	}
}
