// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankStateOperateDeal.java

package com.sinosoft.banklns.lnsmodel;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			BankStateOperateDealIface

public abstract class BankStateOperateDeal
	implements BankStateOperateDealIface
{

	public BankStateOperateDeal()
	{
	}

	public boolean checkOperate(String state, String editState, int buttonType)
	{
		boolean flag = false;
		switch (buttonType)
		{
		case 1: // '\001'
			flag = checkSubmitViewOperate(state, editState);
			break;

		case 2: // '\002'
			flag = checkCalculateOperate(state, editState);
			break;

		case 3: // '\003'
			flag = checkSendOperate(state, editState);
			break;

		case 4: // '\004'
			flag = checkCancelOperate(state, editState);
			break;

		case 5: // '\005'
			flag = checkResumeOperate(state, editState);
			break;
		}
		return flag;
	}

	private boolean checkSubmitViewOperate(String state, String editState)
	{
		boolean flag = false;
		String regex = "^[1]{4}\\d{6}\\d*$";
		flag = "01".equals(state) && Pattern.matches(regex, editState);
		return flag;
	}

	private boolean checkCalculateOperate(String state, String editState)
	{
		boolean flag = false;
		String regex = "^[1]{4}\\d{2}[1]{1}[^1]{1}\\d*$";
		flag = "02".equals(state) && Pattern.matches(regex, editState);
		return flag;
	}

	private boolean checkSendOperate(String state, String editState)
	{
		boolean flag = false;
		String regex = "^[1]{4}\\d{3}[^(0|2)]{1}[^1]{1}\\d*$";
		flag = "03".equals(state) && Pattern.matches(regex, editState);
		return flag;
	}

	private boolean checkCancelOperate(String state, String editState)
	{
		boolean flag = false;
		String regex = "^[1]{4}\\d{4}[^1]{2}\\d*$";
		flag = !"06".equals(state) && !"05".equals(state) && !"01".equals(state) && Pattern.matches(regex, editState);
		return flag;
	}

	private boolean checkResumeOperate(String state, String editState)
	{
		boolean flag = false;
		String regex = "^[1]{4}\\d{4}[^1]{1}[1]{1}\\d*$";
		flag = "05".equals(state) && Pattern.matches(regex, editState);
		return flag;
	}

	public boolean checkEditOperate(String state, String editState, String sheetType, String userType, String contNo)
	{
		boolean flag = false;
		if ("0".equals(userType))
		{
			if (("01".equals(sheetType) || "02".equals(sheetType) || "03".equals(sheetType) || "04".equals(sheetType)) && "01".indexOf(state) >= 0)
				flag = true;
		} else
		if ("1".equals(userType))
		{
			if (("01".equals(sheetType) || "02".equals(sheetType) || "03".equals(sheetType) || "04".equals(sheetType)) && "02,03,04,07".indexOf(state) >= 0)
				flag = true;
		} else
		if ("2".equals(userType) && ("01".equals(sheetType) || "02".equals(sheetType) || "03".equals(sheetType) || "04".equals(sheetType)) && "01,02,03,04,07".indexOf(state) >= 0)
			flag = true;
		return flag;
	}

	public List infoOprate(String state, String editState, String operateType, String infoType)
	{
		System.out.println("BankStateOperateDeal(old)");
		if ("modify".equals(operateType))
			return addInfoOperate(state, editState, infoType);
		if ("delete".equals(operateType))
			return deleteInfoOperate(state, editState, infoType);
		else
			return null;
	}

	private List addInfoOperate(String state, String editState, String infoType)
	{
		String tState = state;
		String tEditState = "";
		List arrays = new ArrayList();
		String editStateArray[] = new String[editState.length()];
		for (int i = 0; i < editState.length(); i++)
			editStateArray[i] = editState.substring(i, i + 1);

		int infoTypeNo;
		if (infoType.startsWith("0"))
			infoTypeNo = Integer.parseInt(infoType.substring(1));
		else
			infoTypeNo = Integer.parseInt(infoType);
		if (infoTypeNo <= 6)
		{
			switch (infoTypeNo)
			{
			case 1: // '\001'
				editStateArray[0] = "1";
				break;

			case 2: // '\002'
				editStateArray[1] = "1";
				break;

			case 3: // '\003'
				editStateArray[2] = "1";
				break;

			case 4: // '\004'
				editStateArray[3] = "1";
				break;

			case 5: // '\005'
				editStateArray[4] = "1";
				break;

			case 6: // '\006'
				editStateArray[5] = "1";
				break;
			}
		} else
		{
			int arry[] = new int[2];
			arry[0] = Integer.parseInt(infoType.substring(0, 1));
			arry[1] = Integer.parseInt(infoType.substring(1, 2));
			switch (arry[0])
			{
			case 7: // '\007'
				editStateArray[6] = arry[1] <= 0 ? "2" : "1";
				break;

			case 8: // '\b'
				editStateArray[7] = arry[1] <= 0 ? "2" : "1";
				break;

			case 9: // '\t'
				editStateArray[8] = arry[1] <= 0 ? "2" : "1";
				break;
			}
		}
		List list = modifySateByEditState(state, editStateArray);
		tState = (String)list.get(0);
		editStateArray = (String[])list.get(1);
		for (int i = 0; i < editStateArray.length; i++)
			tEditState = (new StringBuilder(String.valueOf(tEditState))).append(editStateArray[i]).toString();

		arrays.add(tState);
		arrays.add(tEditState);
		return arrays;
	}

	private List deleteInfoOperate(String state, String editState, String infoType)
	{
		String tState = state;
		String tEditState = "";
		List arrays = new ArrayList();
		String editStateArray[] = new String[editState.length()];
		for (int i = 0; i < editState.length(); i++)
			editStateArray[i] = editState.substring(i, i + 1);

		if (infoType.startsWith("A"))
		{
			int infoTypeNo = Integer.parseInt(infoType.substring(1));
			switch (infoTypeNo)
			{
			case 10: // '\n'
				editStateArray[9] = "0";
				break;

			case 11: // '\013'
				editStateArray[9] = "1";
				break;
			}
		}
		List list = modifySateByEditState(state, editStateArray);
		tState = (String)list.get(0);
		editStateArray = (String[])list.get(1);
		for (int i = 0; i < editStateArray.length; i++)
			tEditState = (new StringBuilder(String.valueOf(tEditState))).append(editStateArray[i]).toString();

		arrays.add(tState);
		arrays.add(tEditState);
		return arrays;
	}

	public List modifySateByEditState(String state, String editStateArry[])
	{
		String tState = state;
		boolean tFlag = true;
		List list = new ArrayList();
		if ("01".equals(state))
		{
			for (int i = 0; i < 4; i++)
			{
				if ("1".equals(editStateArry[i]))
					continue;
				tFlag = false;
				break;
			}

			if (tFlag && "1".equals(editStateArry[6]))
				tState = "02";
		}
		if ("02".equals(state) && "1".equals(editStateArry[6]) && !"0".equals(editStateArry[7]))
			if ("1".equals(editStateArry[7]))
			{
				tState = "03";
			} else
			{
				tState = "04";
				editStateArry[7] = "2";
			}
		if ("03".equals(state) && "1".equals(editStateArry[7]) && !"0".equals(editStateArry[8]))
			if ("1".equals(editStateArry[8]))
			{
				tState = "06";
			} else
			{
				tState = "07";
				editStateArry[8] = "2";
			}
		if (!"05".equals(state) && !"06".equals(state) && "1".equals(editStateArry[9]))
			tState = "05";
		if ("05".equals(state) && "0".equals(editStateArry[9]))
		{
			tState = "02";
			editStateArry[7] = "0";
			editStateArry[8] = "0";
		}
		if (("02".equals(state) || "04".equals(state)) && "2".equals(editStateArry[7]) && !"1".equals(editStateArry[9]))
			if ("1".equals(editStateArry[7]))
			{
				tState = "03";
				editStateArry[7] = "1";
			} else
			{
				tState = "04";
				editStateArry[7] = "2";
			}
		if (("02".equals(state) || "07".equals(state)) && "2".equals(editStateArry[8]) && !"1".equals(editStateArry[9]))
			if ("1".equals(editStateArry[8]))
			{
				tState = "06";
				editStateArry[8] = "1";
			} else
			{
				tState = "07";
				editStateArry[8] = "2";
			}
		list.add(tState);
		list.add(editStateArry);
		return list;
	}

	public String updateEditStateDone(String editstate, int index)
	{
		String reEditState = (new StringBuilder(String.valueOf(editstate.substring(0, index - 1)))).append("1").append(editstate.substring(index)).toString();
		return reEditState;
	}

	public String updateEditStateUNDone(String editstate, int index)
	{
		String reEditState = (new StringBuilder(String.valueOf(editstate.substring(0, index - 1)))).append("0").append(editstate.substring(index)).toString();
		return reEditState;
	}
}
