// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EasyQueryBL.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.*;

public class EasyQueryBL
{

	private VData mInputData;
	private VData mResult;
	private String mOperate;
	public CErrors mErrors;
	private String mSQL;
	private int mStartIndex;
	private String mEncodedResult;

	public EasyQueryBL()
	{
		mInputData = new VData();
		mResult = new VData();
		mErrors = new CErrors();
		mSQL = "";
		mEncodedResult = "";
	}

	public boolean submitData(VData cInputData, String cOperate)
	{
		mInputData = (VData)cInputData.clone();
		mOperate = cOperate;
		if (!getInputData())
			return false;
		return !mOperate.equals("QUERY||MAIN") || queryData();
	}

	private boolean getInputData()
	{
		mSQL = (String)mInputData.getObject(0);
		if (mSQL == null || mSQL.trim().equals(""))
		{
			CError tError = new CError();
			tError.moduleName = "EasyQueryBL";
			tError.functionName = "getInputData";
			tError.errorMessage = "没有传入SQL语句!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			Integer tStart = (Integer)mInputData.getObject(1);
			mStartIndex = tStart.intValue();
			return true;
		}
	}

	private boolean queryData()
	{
		ExeSQL tExeSQL = new ExeSQL();
		mEncodedResult = tExeSQL.getEncodedResult(mSQL, mStartIndex);
		if (tExeSQL.mErrors.needDealError())
		{
			mErrors.copyAllErrors(tExeSQL.mErrors);
			mEncodedResult = "";
			return false;
		} else
		{
			mResult.add(mEncodedResult);
			return true;
		}
	}

	public VData getResult()
	{
		return mResult;
	}

	public static void main(String args1[])
	{
	}
}
