// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankStateOperateDealNew.java

package com.sinosoft.banklns.lnsmodel;

import java.io.PrintStream;
import java.util.List;
import java.util.regex.Pattern;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			BankStateOperateDeal, BankStateOperateDealIface

public class BankStateOperateDealNew extends BankStateOperateDeal
	implements BankStateOperateDealIface
{

	public BankStateOperateDealNew()
	{
	}

	public boolean checkEditOperate(String state, String sheetType, String userType, String contNo)
	{
		boolean flag = false;
		flag = super.checkEditOperate(state, "", sheetType, userType, contNo);
		return flag;
	}

	public boolean checkButtonOperate(String state, String editState, int buttonType, String userType, String contNo)
	{
		boolean flag = false;
		if (contNo != null)
		{
			System.out.println("保单号不为空~什么都没做");
		} else
		{
			boolean tempFlag = false;
			if ("0".equals(userType) && buttonType == 1)
				tempFlag = true;
			else
			if ("1".equals(userType) && buttonType != 1)
				tempFlag = true;
			else
			if ("2".equals(userType))
				tempFlag = true;
			flag = super.checkOperate(state, editState, buttonType) && tempFlag;
		}
		return flag;
	}

	public List infoOprate(String state, String editState, String operateType, String infoType)
	{
		return super.infoOprate(state, editState, operateType, infoType);
	}

	public String updateEditStateDone(String editstate, int index)
	{
		return super.updateEditStateDone(editstate, index);
	}

	public String updateEditStateUNDone(String editstate, int index)
	{
		return super.updateEditStateUNDone(editstate, index);
	}

	public static void main(String args[])
	{
		BankStateOperateDeal detal = new BankStateOperateDealNew();
		String editStateArry[] = {
			"1", "1", "1", "1", "1", "1", "1", "1", "x", "1", 
			"0"
		};
		String state = "05";
		List list = detal.modifySateByEditState(state, editStateArry);
		System.out.println((String)list.get(0));
		editStateArry = (String[])list.get(1);
		for (int i = 0; i < editStateArry.length; i++)
			System.out.print((new StringBuilder(String.valueOf(editStateArry[i]))).append("|").toString());

		boolean flag = Pattern.matches("^[1]{4}\\d{3}[^1]{1}\\d{2}$", "1111000000");
		System.out.println(flag);
	}
}
