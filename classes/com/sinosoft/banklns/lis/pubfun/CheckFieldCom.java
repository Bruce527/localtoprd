// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CheckFieldCom.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			Calculator, FieldCarrier

public class CheckFieldCom
{

	public CErrors mErrors;
	private Calculator mCalculator;
	private FieldCarrier mFieldCarrier;
	private LNPCheckFieldSchema mLNPCheckFieldSchema;
	private LNPCheckFieldSet mLNPCheckFieldSet;

	public CheckFieldCom()
	{
		mErrors = new CErrors();
		mCalculator = new Calculator();
		mFieldCarrier = new FieldCarrier();
		mLNPCheckFieldSchema = new LNPCheckFieldSchema();
		mLNPCheckFieldSet = new LNPCheckFieldSet();
	}

	private boolean InitData(VData InputData)
	{
		if (InputData == null)
			return SetError("InitData", "�������(VData)����Ϊ�գ�");
		mFieldCarrier = (FieldCarrier)InputData.getObjectByObjectName("FieldCarrier", 0);
		if (mFieldCarrier == null)
			return SetError("InitData", "�������(FieldCarrier)����Ϊ�գ�");
		mLNPCheckFieldSchema = (LNPCheckFieldSchema)InputData.getObjectByObjectName("LNPCheckFieldSchema", 0);
		if (mLNPCheckFieldSchema == null)
			return SetError("InitData", "�������(LNPCheckFieldSchema)����Ϊ�գ�");
		else
			return true;
	}

	private boolean SaveFactor()
	{
		Class ClassOfFieldCarrier = mFieldCarrier.getClass();
		Field fields[] = ClassOfFieldCarrier.getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		for (int n = 0; n < fields.length; n++)
		{
			String fieldName = fields[n].getName();
			Class classOfFieldType = fields[n].getType();
			String fieldTypeName = classOfFieldType.getName();
			Object obj;
			if (fields[n].isAccessible())
				try
				{
					obj = fields[n].get(mFieldCarrier);
				}
				catch (Exception ex)
				{
					System.out.println((new StringBuilder("�׳����⣺")).append(ex.toString()).toString());
					return SetError("SaveField", ex.toString());
				}
			else
				return SetError("SaveField", (new StringBuilder("����������ֶ�")).append(fieldName).append("����Ϊ���ܴ�ȡ��").toString());
		}

		return true;
	}

	public LNPCheckFieldSet GetCheckFieldSet()
	{
		return mLNPCheckFieldSet;
	}

	private boolean SetError(String funName, String errMsg)
	{
		CError tError = new CError();
		tError.moduleName = "CheckFieldCom";
		tError.functionName = funName;
		tError.errorMessage = errMsg;
		mErrors.addOneError(tError);
		return false;
	}

	public static void main(String args1[])
	{
	}
}
