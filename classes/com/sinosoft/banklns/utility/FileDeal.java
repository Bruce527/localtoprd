// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileDeal.java

package com.sinosoft.banklns.utility;

import java.io.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, CError

public class FileDeal
{

	public CErrors mErrors;
	private String OriPathName;
	private String DesPathName;
	private File mFile;
	private String DesDir;

	public FileDeal()
	{
		mErrors = new CErrors();
	}

	public FileDeal(String aStr)
	{
		mErrors = new CErrors();
		OriPathName = aStr;
	}

	public boolean FileCopy(String aStr)
	{
		if (createDir(aStr))
			break MISSING_BLOCK_LABEL_44;
		CError tError = new CError();
		tError.moduleName = "FileDeal";
		tError.functionName = "FileCopy";
		tError.errorMessage = "�����ļ��г��?!";
		mErrors.addOneError(tError);
		return false;
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
			tError.errorMessage = "�ļ����Ƴ��?!";
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public boolean FileMove(String aStr)
	{
		if (createDir(aStr))
			break MISSING_BLOCK_LABEL_44;
		CError tError = new CError();
		tError.moduleName = "FileDeal";
		tError.functionName = "FileCopy";
		tError.errorMessage = "�����ļ��г��?!";
		mErrors.addOneError(tError);
		return false;
		DesPathName = aStr;
		mFile = new File(OriPathName);
		File tFile = new File(DesPathName);
		if (mFile.renameTo(tFile))
			break MISSING_BLOCK_LABEL_123;
		CError tError = new CError();
		tError.moduleName = "FileDeal";
		tError.functionName = "FileMove";
		tError.errorMessage = "�ļ��ƶ����?!";
		mErrors.addOneError(tError);
		return false;
		if (mFile.createNewFile())
			break MISSING_BLOCK_LABEL_169;
		CError tError = new CError();
		tError.moduleName = "FileDeal";
		tError.functionName = "FileMove";
		tError.errorMessage = "�ļ��ƶ����?!";
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
				tError.errorMessage = "�ļ��ƶ����?!";
				mErrors.addOneError(tError);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				CError tError = new CError();
				tError.moduleName = "FileDeal";
				tError.functionName = "FileMove";
				tError.errorMessage = "�ļ��ƶ����?!";
				mErrors.addOneError(tError);
				return false;
			}
			return false;
		}
		return true;
	}

	public boolean FileDel()
	{
label0:
		{
			try
			{
				File tFile = new File(OriPathName);
				if (tFile.delete())
					break label0;
				CError tError = new CError();
				tError.moduleName = "FileDeal";
				tError.functionName = "FileDel";
				tError.errorMessage = "�ļ�ɾ����!";
				mErrors.addOneError(tError);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				CError tError = new CError();
				tError.moduleName = "FileDeal";
				tError.functionName = "FileDel";
				tError.errorMessage = "�ļ�ɾ����!";
				mErrors.addOneError(tError);
				return false;
			}
			return false;
		}
		return true;
	}

	public boolean createDir(String aStr)
	{
		int index = aStr.lastIndexOf("\\");
		if (index == -1)
			index = aStr.lastIndexOf("/");
		DesDir = aStr.substring(0, index);
		File tDir = new File(DesDir);
		if (!tDir.exists())
			try
			{
				tDir.mkdirs();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				CError tError = new CError();
				tError.moduleName = "FileDeal";
				tError.functionName = "FileCopy";
				tError.errorMessage = "�����ļ��г��?!";
				mErrors.addOneError(tError);
				return false;
			}
		return true;
	}

	public static void main(String args[])
	{
		FileDeal fileDeal1 = new FileDeal("\\test.xml");
		fileDeal1.FileCopy(".\\uia\\test.xml");
	}
}
