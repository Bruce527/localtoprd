// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CodeQueryBL.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.lis.db.LNPCodeDB;
import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;

public class CodeQueryBL
{

	public CErrors mErrors;
	private VData mResult;
	private String mOperate;
	private String mSQL;
	private LNPCodeSchema mLNPCodeSchema;
	private LNPCodeSet mLNPCodeSet;
	private ExeSQL mExeSQL;
	private SSRS mSSRS;

	public CodeQueryBL()
	{
		mErrors = new CErrors();
		mResult = new VData();
		mSQL = "";
		mLNPCodeSchema = new LNPCodeSchema();
		mLNPCodeSet = new LNPCodeSet();
		mExeSQL = null;
		mSSRS = new SSRS();
	}

	public boolean submitData(VData cInputData, String cOperate)
	{
		mOperate = cOperate;
		if (!getInputData(cInputData))
			return false;
		if (mOperate.equals("QUERY||CODE"))
		{
			if (!queryCodeData())
			{
				CError tError = new CError();
				tError.moduleName = "CodeQueryBL";
				tError.functionName = "submitData";
				tError.errorMessage = "数据处理失败CodeQueryBL-->dealData!";
				mErrors.addOneError(tError);
				return false;
			}
		} else
		if (mOperate.equals("QUERY||SQL") && !querySqlData())
		{
			CError tError = new CError();
			tError.moduleName = "CodeQueryBL";
			tError.functionName = "submitData";
			tError.errorMessage = "数据处理失败CodeQueryBL-->dealData!";
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public VData getResult()
	{
		return mResult;
	}

	private boolean getInputData(VData cInputData)
	{
		if (mOperate.equals("QUERY||CODE"))
			mLNPCodeSchema.setSchema((LNPCodeSchema)cInputData.getObjectByObjectName("LNPCodeSchema", 0));
		else
		if (mOperate.equals("QUERY||SQL"))
			mSQL = (String)cInputData.getObjectByObjectName("String", 0);
		return true;
	}

	private boolean queryCodeData()
	{
		mResult.clear();
		LNPCodeDB tLNPCodeDB = new LNPCodeDB();
		tLNPCodeDB.setSchema(mLNPCodeSchema);
		LNPCodeSet tLNPCodeSet = new LNPCodeSet();
		tLNPCodeSet.set(tLNPCodeDB.query());
		if (tLNPCodeDB.mErrors.needDealError())
		{
			mErrors.copyAllErrors(tLNPCodeDB.mErrors);
			CError tError = new CError();
			tError.moduleName = "SLatncyGrpBL";
			tError.functionName = "submitData";
			tError.errorMessage = "数据查询失败!";
			mErrors.addOneError(tError);
			return false;
		}
		LNPCodeSchema tLNPCodeSchema = new LNPCodeSchema();
		for (int i = 1; i <= tLNPCodeSet.size(); i++)
		{
			tLNPCodeSchema.setSchema(tLNPCodeSet.get(i));
			String tResultStr = new String();
			tResultStr = (new StringBuilder(String.valueOf(tLNPCodeSchema.getCode()))).append("-").append(tLNPCodeSchema.getCodeName()).toString();
			mResult.add(tResultStr);
		}

		return true;
	}

	private boolean querySqlData()
	{
		mResult.clear();
		mExeSQL = new ExeSQL();
		mSSRS = mExeSQL.execSQL(mSQL);
		if (mExeSQL.mErrors.needDealError())
			mErrors.copyAllErrors(mExeSQL.mErrors);
		for (int i = 1; i <= mSSRS.getMaxRow(); i++)
		{
			String tResultStr = "";
			for (int j = 1; j <= mSSRS.getMaxCol(); j++)
			{
				String tStr = mSSRS.GetText(i, j);
				if (j == 1)
					tResultStr = tStr;
				else
					tResultStr = (new StringBuilder(String.valueOf(tResultStr))).append("-").append(tStr).toString();
			}

			mResult.add(tResultStr);
		}

		return true;
	}

	public static void main(String args[])
	{
		CodeQueryBL codeQueryBL1 = new CodeQueryBL();
		codeQueryBL1.mLNPCodeSchema.setCodeType("riskind");
		VData tVData = codeQueryBL1.getResult();
		System.out.println(codeQueryBL1.mSQL);
		System.out.println(tVData.get(0));
	}
}
