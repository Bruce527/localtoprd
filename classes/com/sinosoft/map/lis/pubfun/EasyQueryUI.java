// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EasyQueryUI.java

package com.sinosoft.map.lis.pubfun;

import com.sinosoft.map.utility.CErrors;
import com.sinosoft.map.utility.VData;

// Referenced classes of package com.sinosoft.map.lis.pubfun:
//			EasyQueryBL

public class EasyQueryUI
{

	private VData mResult;
	private String mOperate;
	public CErrors mErrors;

	public EasyQueryUI()
	{
		mResult = new VData();
		mErrors = new CErrors();
	}

	public boolean submitData(VData cInputData, String cOperate)
	{
		mOperate = cOperate;
		EasyQueryBL tEasyQueryBL = new EasyQueryBL();
		if (tEasyQueryBL.submitData(cInputData, mOperate))
		{
			mResult = tEasyQueryBL.getResult();
		} else
		{
			mErrors.copyAllErrors(tEasyQueryBL.mErrors);
			mResult.clear();
			return false;
		}
		return true;
	}

	public VData getResult()
	{
		return mResult;
	}

	public static void main(String args1[])
	{
	}
}
