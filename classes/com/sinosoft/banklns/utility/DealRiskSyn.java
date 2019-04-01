// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DealRiskSyn.java

package com.sinosoft.banklns.utility;

import java.io.*;
import java.util.LinkedList;
import java.util.zip.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, CError

public class DealRiskSyn
{

	public CErrors mErrors;
	private String mFileName;
	private ZipInputStream mZIn;
	private FileInputStream mFIn;
	private ZipEntry ze;
	private ZipFile zf;
	private LinkedList mLinkedList;

	public DealRiskSyn()
	{
		mErrors = new CErrors();
		mFileName = null;
		mZIn = null;
		mFIn = null;
		ze = null;
		zf = null;
		mLinkedList = new LinkedList();
	}

	public LinkedList getLinkedList()
	{
		return mLinkedList;
	}

	public void setFileName(String aFileName)
	{
		mFileName = aFileName;
	}

	public boolean parseZipFile()
	{
		try
		{
			zf = new ZipFile(mFileName);
			mFIn = new FileInputStream(mFileName);
			mZIn = new ZipInputStream(mFIn);
			while ((ze = mZIn.getNextEntry()) != null) 
			{
				System.out.println(ze.getName());
				mLinkedList.add(ze.getName());
				mZIn.closeEntry();
			}
			mZIn.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			buildError("parseZipFile", "����Zip�ļ���?");
			return false;
		}
		return true;
	}

	public InputStream getEntInp(String aEnFileName)
	{
		InputStream ins = null;
		ze = zf.getEntry(aEnFileName);
		if (ze != null)
			break MISSING_BLOCK_LABEL_31;
		buildError("getEntInp", "����Zip�ļ���?");
		return ins;
		try
		{
			ins = zf.getInputStream(ze);
		}
		catch (Exception ex)
		{
			buildError("getEntInp", ex.toString());
			return ins;
		}
		return ins;
	}

	public boolean closeEntry()
	{
		try
		{
			mZIn.closeEntry();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			buildError("closeEntry", "�ر�Zip���ļ���?");
			return false;
		}
		return true;
	}

	public boolean close()
	{
		try
		{
			mZIn.close();
			mFIn.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			buildError("close", "�ر�Zip�ļ���?");
			return false;
		}
		return true;
	}

	private void buildError(String szFunc, String szErrMsg)
	{
		CError cError = new CError();
		cError.moduleName = "DealRiskSyn";
		cError.functionName = szFunc;
		cError.errorMessage = szErrMsg;
		mErrors.addOneError(cError);
	}

	public static void main(String args[])
	{
		try
		{
			String tFileName = "e:\\112201.zip";
			ZipInputStream zin = new ZipInputStream(new FileInputStream(tFileName));
			ZipEntry ze;
			while ((ze = zin.getNextEntry()) != null) 
			{
				System.out.println(ze.getName());
				zin.closeEntry();
			}
			zin.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
