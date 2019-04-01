// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskElementImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.pubfun.PubFun1;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vdb.LNPInvestRiskDataDBSet;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.lnsmodel.util.ForSpcCalImpl;
import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Hashtable;

public class RiskElementImpl
{

	private String RISKCODE;
	private boolean hidePayEndYear;

	public RiskElementImpl()
	{
		RISKCODE = "";
		hidePayEndYear = false;
	}

	public boolean CheckControlValueValid(String ControlCode, PolElementSchema tPolElementSchema)
	{
		tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
		boolean flag = true;
		LNPRiskScreenValidateDB ttLNPRiskScreenValidateDB = new LNPRiskScreenValidateDB();
		ttLNPRiskScreenValidateDB.setRiskCode(tPolElementSchema.getRiskCode());
		ttLNPRiskScreenValidateDB.setControlCode(ControlCode);
		ttLNPRiskScreenValidateDB.setFunctionType("0");
		LNPRiskScreenValidateSet ttLNPRiskScreenValidateSet = ttLNPRiskScreenValidateDB.query();
		if (ttLNPRiskScreenValidateSet.size() > 0)
		{
			ExeSQL rExeSQL = new ExeSQL();
			for (int i = 1; i <= ttLNPRiskScreenValidateSet.size(); i++)
			{
				LNPRiskScreenValidateSchema rrLNPRiskScreenValidateSchema = ttLNPRiskScreenValidateSet.get(i);
				String serialno = rrLNPRiskScreenValidateSchema.getCalCode();
				LNPCheckFieldDB ttLNPCheckFieldDB = new LNPCheckFieldDB();
				ttLNPCheckFieldDB.setSerialNo(serialno);
				ttLNPCheckFieldDB.setRiskCode(tPolElementSchema.getRiskCode());
				LNPCheckFieldSet ttLNPCheckFieldSet = ttLNPCheckFieldDB.query();
				if (ttLNPCheckFieldSet.size() == 0)
				{
					System.out.println((new StringBuilder("§µ?????[")).append(serialno).append("]??LMCheckField?§Ó?????!").toString());
					return false;
				}
				LNPCalModeDB ttLNPCalmodeDB = new LNPCalModeDB();
				ttLNPCalmodeDB.setRiskCode(tPolElementSchema.getRiskCode());
				ttLNPCalmodeDB.setCalCode(ttLNPCheckFieldSet.get(1).getCalCode());
				ttLNPCalmodeDB.getInfo();
				String sql = ttLNPCalmodeDB.getCalSQL();
				sql = transeToTypical(sql, tPolElementSchema);
				SSRS ttSSRS = rExeSQL.execSQL(sql);
				if (ttSSRS.GetText(1, 1).equals("1"))
				{
					flag = false;
					System.out.println("ttLNPCheckFieldSet.get(1).getMsg()");
				}
			}

		}
		return flag;
	}

	public VData getRelaDivShowOrNot(String ControlCode, String ControlValue, PolElementSchema tPolElementSchema)
	{
		tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
		VData result = new VData();
		LNPRiskScreenValidateDB ttLNPRiskScreenValidateDB = new LNPRiskScreenValidateDB();
		ttLNPRiskScreenValidateDB.setRiskCode(tPolElementSchema.getRiskCode());
		ttLNPRiskScreenValidateDB.setFunctionType("2");
		ttLNPRiskScreenValidateDB.setControlCode(ControlCode);
		ttLNPRiskScreenValidateDB.setControlValue(ControlValue);
		LNPRiskScreenValidateSet rrLBPRiskScreenValidateSet = ttLNPRiskScreenValidateDB.query();
		if (rrLBPRiskScreenValidateSet.size() > 0)
		{
			for (int i = 1; i <= rrLBPRiskScreenValidateSet.size(); i++)
			{
				String rVdata[] = new String[2];
				rVdata[0] = rrLBPRiskScreenValidateSet.get(i).getRelaDivCode();
				rVdata[1] = rrLBPRiskScreenValidateSet.get(i).getRelaDivShow();
				result.add(rVdata);
			}

		}
		return result;
	}

	public VData getReleControlValue(String ControlCode, String ControlValue, PolElementSchema tPolElementSchema)
	{
		tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
		VData result = new VData();
		LNPRiskScreenValidateDB ttLNPRiskScreenValidateDB = new LNPRiskScreenValidateDB();
		ttLNPRiskScreenValidateDB.setRiskCode(tPolElementSchema.getRiskCode());
		ttLNPRiskScreenValidateDB.setFunctionType("1");
		ttLNPRiskScreenValidateDB.setControlCode(ControlCode);
		ttLNPRiskScreenValidateDB.setControlValue(ControlValue);
		LNPRiskScreenValidateSet rrLNPRiskScreenValidateSet = ttLNPRiskScreenValidateDB.query();
		if (rrLNPRiskScreenValidateSet.size() > 0)
		{
			ExeSQL rExeSQL = new ExeSQL();
			for (int i = 1; i <= rrLNPRiskScreenValidateSet.size(); i++)
			{
				String controlVData[] = new String[4];
				String value = "=?????";
				LNPRiskScreenValidateSchema ttLNPRiskScreenValidateSchema = rrLNPRiskScreenValidateSet.get(i);
				controlVData[0] = ttLNPRiskScreenValidateSchema.getRelaControlCode();
				controlVData[1] = ttLNPRiskScreenValidateSchema.getRelaControlType();
				String sql = ttLNPRiskScreenValidateSchema.getRelaValueSql();
				sql = transeToTypical(sql, tPolElementSchema);
				SSRS ttSSRS = rExeSQL.execSQL(sql);
				if (ttLNPRiskScreenValidateSchema.getRelaControlType().equals("1"))
				{
					for (int r = 1; r <= ttSSRS.MaxRow; r++)
						if (ttSSRS.getMaxRow() == 1)
							value = (new StringBuilder(String.valueOf(ttSSRS.GetText(r, 1)))).append("=").append(ttSSRS.GetText(r, 2)).toString();
						else
							value = (new StringBuilder(String.valueOf(value))).append("&").append(ttSSRS.GetText(r, 1)).append("=").append(ttSSRS.GetText(r, 2)).toString();

					if (value != null)
					{
						String temp[] = value.split("&");
						if (temp.length == 2)
							value = value.replace("=?????&", "");
					}
					controlVData[2] = value;
				} else
				{
					DecimalFormat myformat = new DecimalFormat("#0.00");
					value = myformat.format(Double.parseDouble(ttSSRS.GetText(1, 1)));
					controlVData[2] = value;
				}
				String temp = "";
				if (rrLNPRiskScreenValidateSet.get(i).getNoti() != null && rrLNPRiskScreenValidateSet.get(i).getNoti().length() != 0)
					temp = rrLNPRiskScreenValidateSet.get(i).getNoti();
				controlVData[3] = temp;
				result.add(controlVData);
			}

		}
		return result;
	}

	public String getRusult(LNPRiskParamSchema inLNPRiskParamSchema, LNPPolSchema mainLNPPolShcema)
	{
		String expression = inLNPRiskParamSchema.getExpression();
		Hashtable reHashtable = new Hashtable();
		reHashtable.put("Amnt", Double.valueOf(mainLNPPolShcema.getAmnt()));
		reHashtable.put("Get", Double.valueOf(mainLNPPolShcema.getAmnt()));
		reHashtable.put("Prem", Double.valueOf(mainLNPPolShcema.getPrem()));
		reHashtable.put("TopUpPrem", Double.valueOf(mainLNPPolShcema.getTopUpPrem()));
		reHashtable.put("DeadAmntType", mainLNPPolShcema.getDeadAmntType());
		reHashtable.put("Mult", Double.valueOf(mainLNPPolShcema.getMult()));
		reHashtable.put("PayIntv", Integer.valueOf(mainLNPPolShcema.getPayIntv()));
		reHashtable.put("InsuYear", Integer.valueOf(mainLNPPolShcema.getInsuYear()));
		reHashtable.put("InsuYearFlag", (new StringBuilder(String.valueOf(mainLNPPolShcema.getInsuYearFlag()))).toString());
		reHashtable.put("PayEndYear", Integer.valueOf(mainLNPPolShcema.getPayEndYear()));
		reHashtable.put("PayEndYearFlag", (new StringBuilder(String.valueOf(mainLNPPolShcema.getPayEndYearFlag()))).toString());
		reHashtable.put("LiveGetMode", (new StringBuilder(String.valueOf(mainLNPPolShcema.getLiveGetMode()))).toString());
		reHashtable.put("StandbyFlag1", (new StringBuilder(String.valueOf(mainLNPPolShcema.getStandbyFlag1()))).toString());
		reHashtable.put("StandbyFlag2", (new StringBuilder(String.valueOf(mainLNPPolShcema.getStandbyFlag2()))).toString());
		reHashtable.put("StandbyFlag3", (new StringBuilder(String.valueOf(mainLNPPolShcema.getStandbyFlag3()))).toString());
		reHashtable.put("MainRiskCode", (new StringBuilder(String.valueOf(mainLNPPolShcema.getRiskCode()))).toString());
		ForSpcCalImpl forSpcCalIntf = new ForSpcCalImpl();
		EvalJavaTool evalJavaTool = new EvalJavaTool();
		reHashtable.put("SpcCalInst", forSpcCalIntf);
		String result = evalJavaTool.executeByExpress(expression, reHashtable);
		return result;
	}

	public VData getUIElementsData(String contNo, String riskCode, String insuredNo, String CurrentMainPolNo, String operatortype)
	{
		VData result = new VData();
		DBConn conn;
		PolElementSchema tPolElementSchema;
		LNPRiskScreenSet itLNPRiskScreenSet;
		ExeSQL rExeSQL;
		int i;
		conn = DBConnPool.getConnection();
		tPolElementSchema = new PolElementSchema();
		tPolElementSchema.setContNo(contNo);
		tPolElementSchema.setRiskCode(riskCode);
		tPolElementSchema.setMasterPolNo(CurrentMainPolNo);
		tPolElementSchema.setInsuredId(insuredNo);
		tPolElementSchema = setAppntAndInsuredInfo(tPolElementSchema);
		LNPRiskScreenDB tLNPRiskScreenDB = new LNPRiskScreenDB(conn);
		String sql = (new StringBuilder("select * from lnpriskscreen Where riskcode='")).append(riskCode).append("' Order By ctrlindex").toString();
		itLNPRiskScreenSet = tLNPRiskScreenDB.executeQuery(sql);
		rExeSQL = new ExeSQL(conn);
		i = 1;
		  goto _L1
_L13:
		VData controlVData;
		String value;
		LNPRiskScreenSchema ttLNPRiskScreenSchema;
		LNPRiskParamSet inLNPParamSet;
		LNPPolDB mainLNPPolDB;
		controlVData = new VData();
		value = "=?????";
		ttLNPRiskScreenSchema = itLNPRiskScreenSet.get(i);
		LNPRiskParamDB inLNPRiskParamdb = new LNPRiskParamDB(conn);
		inLNPRiskParamdb.setRiskCode(riskCode);
		inLNPRiskParamdb.setType("RelaToMainRisk");
		inLNPRiskParamdb.setParam("PayIntv");
		inLNPParamSet = inLNPRiskParamdb.query();
		mainLNPPolDB = new LNPPolDB(conn);
		mainLNPPolDB.setPolNo(CurrentMainPolNo);
		if (inLNPParamSet == null || inLNPParamSet.size() <= 0 || !mainLNPPolDB.getInfo() || !ttLNPRiskScreenSchema.getCtrlCode().equals("PayIntv") && !ttLNPRiskScreenSchema.getCtrlCode().equals("PayEndYear")) goto _L3; else goto _L2
_L2:
		LNPRiskParamSchema inLNPRiskParamSchema = inLNPParamSet.get(1);
		int b = mainLNPPolDB.getPayIntv();
		String c = mainLNPPolDB.getRiskCode();
		if (b == 0 && !c.equals("ULES") && !c.equals("ULDX"))
		{
			String a = getRusult(inLNPRiskParamSchema, mainLNPPolDB);
			if (!a.equals("0"));
			continue; /* Loop/switch isn't completed */
		}
		controlVData.add(ttLNPRiskScreenSchema.getCtrlCode());
		controlVData.add(ttLNPRiskScreenSchema.getCtrlName());
		controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty());
		controlVData.add(ttLNPRiskScreenSchema.getDefaultValue());
		if (ttLNPRiskScreenSchema.getCtrlProperty1() == null || !ttLNPRiskScreenSchema.getCtrlProperty1().equals("02")) goto _L5; else goto _L4
_L4:
		if (CurrentMainPolNo != null && CurrentMainPolNo.length() != 0) goto _L7; else goto _L6
_L6:
		System.out.println((new StringBuilder("?????????[")).append(CurrentMainPolNo).append("]???").toString());
		return null;
_L7:
		LNPPolDB rLNPPolDB;
		rLNPPolDB = new LNPPolDB(conn);
		rLNPPolDB.setPolNo(CurrentMainPolNo);
		if (rLNPPolDB.getInfo())
			break MISSING_BLOCK_LABEL_488;
		System.out.println((new StringBuilder("?????????[")).append(CurrentMainPolNo).append("]???????§Ó??????").toString());
		return null;
		String ctlname = ttLNPRiskScreenSchema.getCtrlBackground();
		if (ctlname.equals("PayIntv"))
		{
			if (rLNPPolDB.getPayIntv() == 0)
				value = (new StringBuilder(String.valueOf(value))).append("&0=?").toString();
			else
			if (rLNPPolDB.getPayIntv() == 1)
				value = (new StringBuilder(String.valueOf(value))).append("&1=?\275?").toString();
			else
			if (rLNPPolDB.getPayIntv() == 3)
				value = (new StringBuilder(String.valueOf(value))).append("&3=????").toString();
			else
			if (rLNPPolDB.getPayIntv() == 6)
				value = (new StringBuilder(String.valueOf(value))).append("&6=????").toString();
			else
			if (rLNPPolDB.getPayIntv() == 12)
				value = (new StringBuilder(String.valueOf(value))).append("&12=??").toString();
		} else
		if (ctlname.equals("Prem"))
			value = (new StringBuilder(String.valueOf(rLNPPolDB.getPrem()))).toString();
		else
		if (ctlname.equals("TopUpPrem"))
			value = (new StringBuilder(String.valueOf(rLNPPolDB.getTopUpPrem()))).toString();
		else
		if (ctlname.equals("DeadAmntType"))
		{
			if ("1".equals(rLNPPolDB.getDeadAmntType()))
				value = (new StringBuilder(String.valueOf(value))).append("&1=????").toString();
			else
			if ("2".equals(rLNPPolDB.getDeadAmntType()))
				value = (new StringBuilder(String.valueOf(value))).append("&2=????").toString();
		} else
		if (ctlname.equals("Amnt"))
			value = (new StringBuilder(String.valueOf((int)rLNPPolDB.getAmnt()))).toString();
		else
		if (ctlname.equals("LiveGetMode"))
			value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getLiveGetMode()).append("=\377").append(rLNPPolDB.getLiveGetMode()).append("?????").toString();
		else
		if (ctlname.equals("BonusGetMode") && rLNPPolDB.getBonusGetMode() != null && rLNPPolDB.getBonusGetMode().length() > 0)
		{
			if (rLNPPolDB.getBonusGetMode().equals("1"))
				value = (new StringBuilder(String.valueOf(value))).append("&1=??????").toString();
			else
			if (rLNPPolDB.getBonusGetMode().equals("2"))
				value = (new StringBuilder(String.valueOf(value))).append("&2=??????").toString();
			else
			if (rLNPPolDB.getBonusGetMode().equals("3"))
				value = (new StringBuilder(String.valueOf(value))).append("&3=??????").toString();
			else
			if (rLNPPolDB.getBonusGetMode().equals("4"))
				value = (new StringBuilder(String.valueOf(value))).append("&4=??????").toString();
		} else
		if (ctlname.equals("PayEndYear"))
		{
			if (rLNPPolDB.getPayEndYearFlag().equals("Y"))
			{
				int payendy = rLNPPolDB.getPayEndYear();
				if (payendy == 1000)
					payendy = 0;
				value = (new StringBuilder(String.valueOf(value))).append("&").append(payendy).append("=").append(payendy).append("??").toString();
			} else
			if (rLNPPolDB.getPayEndYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getPayEndYear()).append("=??").append(rLNPPolDB.getPayEndYear()).append("????").toString();
		} else
		if (ctlname.equals("PayEndYearFlag"))
		{
			if (rLNPPolDB.getPayEndYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&Y=??????").toString();
			else
			if (rLNPPolDB.getPayEndYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&A=??????").toString();
		} else
		if (ctlname.equals("GetYear"))
		{
			if (rLNPPolDB.getGetYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getGetYear()).append("=").append(rLNPPolDB.getGetYear()).append("??").toString();
			else
			if (rLNPPolDB.getGetYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getGetYear()).append("=??").append(rLNPPolDB.getGetYear()).append("????").toString();
		} else
		if (ctlname.equals("GetYearFlag"))
		{
			if (rLNPPolDB.getGetYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&Y=??????").toString();
			else
			if (rLNPPolDB.getGetYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&A=??????").toString();
		} else
		if (ctlname.equals("InsuYear"))
		{
			if (rLNPPolDB.getInsuYearFlag().equals("Y"))
			{
				int insuy = rLNPPolDB.getInsuYear();
				if (insuy == 1000)
					insuy = 106;
				value = (new StringBuilder(String.valueOf(value))).append("&").append(insuy).append("=").append(insuy).append("??").toString();
			} else
			if (rLNPPolDB.getInsuYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getInsuYear()).append("=??").append(rLNPPolDB.getInsuYear()).append("????").toString();
		} else
		if (ctlname.equals("InsuYearFlag"))
			if (rLNPPolDB.getInsuYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&Y=??????").toString();
			else
			if (rLNPPolDB.getInsuYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&A=??????").toString();
		String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
		if (valueSql != null && valueSql.length() > 0)
		{
			valueSql = transeToTypical(valueSql, tPolElementSchema);
			valueSql = StrTool.replace(valueSql, "?MasterPolNo?", CurrentMainPolNo);
			SSRS ttSSRS = rExeSQL.execSQL(valueSql);
			if (ttLNPRiskScreenSchema.getCtrlProperty().equals("01"))
			{
				if (ttSSRS != null && ttSSRS.getMaxRow() > 0)
				{
					for (int r = 1; r <= ttSSRS.MaxRow; r++)
						value = (new StringBuilder(String.valueOf(value))).append("&").append(ttSSRS.GetText(r, 1)).append("=").append(ttSSRS.GetText(r, 2)).toString();

				}
			} else
			{
				value = "";
				if (ttSSRS != null && ttSSRS.getMaxRow() > 0)
					value = ttSSRS.GetText(1, 1);
			}
		}
		controlVData.add(value);
		controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty2());
		result.add(controlVData);
		continue; /* Loop/switch isn't completed */
_L5:
		String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
		valueSql = transeToTypical(valueSql, tPolElementSchema);
		if (valueSql == null || valueSql.equals(""))
		{
			value = "";
		} else
		{
			SSRS ttSSRS = rExeSQL.execSQL(valueSql);
			if (ttLNPRiskScreenSchema.getCtrlProperty().equals("01"))
			{
				for (int r = 1; r <= ttSSRS.MaxRow; r++)
					value = (new StringBuilder(String.valueOf(value))).append("&").append(ttSSRS.GetText(r, 1)).append("=").append(ttSSRS.GetText(r, 2)).toString();

			} else
			{
				value = ttSSRS.GetText(1, 1);
			}
		}
		if (value != null)
		{
			String temp[] = value.split("&");
			if (temp.length == 2)
				value = value.replace("=?????&", "");
		}
		controlVData.add(value);
		controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty2());
		result.add(controlVData);
		continue; /* Loop/switch isn't completed */
_L3:
		if ("add".equals(operatortype) && hidePayEndYear && "PayEndYear".equals(ttLNPRiskScreenSchema.getCtrlCode()))
		{
			hidePayEndYear = false;
			continue; /* Loop/switch isn't completed */
		}
		controlVData.add(ttLNPRiskScreenSchema.getCtrlCode());
		controlVData.add(ttLNPRiskScreenSchema.getCtrlName());
		controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty());
		controlVData.add(ttLNPRiskScreenSchema.getDefaultValue());
		if (ttLNPRiskScreenSchema.getCtrlProperty1() == null || !ttLNPRiskScreenSchema.getCtrlProperty1().equals("02")) goto _L9; else goto _L8
_L8:
		if (CurrentMainPolNo != null && CurrentMainPolNo.length() != 0) goto _L11; else goto _L10
_L10:
		System.out.println((new StringBuilder("?????????[")).append(CurrentMainPolNo).append("]???").toString());
		return null;
_L11:
		LNPPolDB rLNPPolDB;
		rLNPPolDB = new LNPPolDB(conn);
		rLNPPolDB.setPolNo(CurrentMainPolNo);
		if (rLNPPolDB.getInfo())
			break MISSING_BLOCK_LABEL_2471;
		System.out.println((new StringBuilder("?????????[")).append(CurrentMainPolNo).append("]???????§Ó??????").toString());
		return null;
		String ctlname = ttLNPRiskScreenSchema.getCtrlBackground();
		if (ctlname.equals("PayIntv"))
		{
			if (rLNPPolDB.getPayIntv() == 0)
				value = (new StringBuilder(String.valueOf(value))).append("&0=?").toString();
			if (rLNPPolDB.getPayIntv() == 1)
				value = (new StringBuilder(String.valueOf(value))).append("&1=?\275?").toString();
			if (rLNPPolDB.getPayIntv() == 3)
				value = (new StringBuilder(String.valueOf(value))).append("&3=????").toString();
			if (rLNPPolDB.getPayIntv() == 6)
				value = (new StringBuilder(String.valueOf(value))).append("&6=????").toString();
			if (rLNPPolDB.getPayIntv() == 12)
				value = (new StringBuilder(String.valueOf(value))).append("&12=??").toString();
		} else
		if (ctlname.equals("Prem"))
			value = (new StringBuilder(String.valueOf(rLNPPolDB.getPrem()))).toString();
		else
		if (ctlname.equals("TopUpPrem"))
			value = (new StringBuilder(String.valueOf(rLNPPolDB.getTopUpPrem()))).toString();
		else
		if (ctlname.equals("DeadAmntType"))
		{
			if ("1".equals(rLNPPolDB.getDeadAmntType()))
				value = (new StringBuilder(String.valueOf(value))).append("&1=????").toString();
			else
			if ("2".equals(rLNPPolDB.getDeadAmntType()))
				value = (new StringBuilder(String.valueOf(value))).append("&2=????").toString();
		} else
		if (ctlname.equals("Amnt"))
			value = (new StringBuilder(String.valueOf((int)rLNPPolDB.getAmnt()))).toString();
		else
		if (ctlname.equals("LiveGetMode"))
			value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getLiveGetMode()).append("=\377").append(rLNPPolDB.getLiveGetMode()).append("?????").toString();
		else
		if (ctlname.equals("BonusGetMode") && rLNPPolDB.getBonusGetMode() != null && rLNPPolDB.getBonusGetMode().length() > 0)
		{
			if (rLNPPolDB.getBonusGetMode().equals("1"))
				value = (new StringBuilder(String.valueOf(value))).append("&1=??????").toString();
			if (rLNPPolDB.getBonusGetMode().equals("2"))
				value = (new StringBuilder(String.valueOf(value))).append("&2=??????").toString();
			if (rLNPPolDB.getBonusGetMode().equals("3"))
				value = (new StringBuilder(String.valueOf(value))).append("&3=??????").toString();
			if (rLNPPolDB.getBonusGetMode().equals("4"))
				value = (new StringBuilder(String.valueOf(value))).append("&4=??????").toString();
		} else
		if (ctlname.equals("PayEndYear"))
		{
			if (rLNPPolDB.getPayEndYearFlag().equals("Y"))
			{
				int payendy = rLNPPolDB.getPayEndYear();
				if (payendy == 1000)
					payendy = 0;
				value = (new StringBuilder(String.valueOf(value))).append("&").append(payendy).append("=").append(payendy).append("??").toString();
			}
			if (rLNPPolDB.getPayEndYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getPayEndYear()).append("=??").append(rLNPPolDB.getPayEndYear()).append("????").toString();
		} else
		if (ctlname.equals("PayEndYearFlag"))
		{
			if (rLNPPolDB.getPayEndYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&Y=??????").toString();
			if (rLNPPolDB.getPayEndYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&A=??????").toString();
		} else
		if (ctlname.equals("GetYear"))
		{
			if (rLNPPolDB.getGetYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getGetYear()).append("=").append(rLNPPolDB.getGetYear()).append("??").toString();
			if (rLNPPolDB.getGetYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getGetYear()).append("=??").append(rLNPPolDB.getGetYear()).append("????").toString();
		} else
		if (ctlname.equals("GetYearFlag"))
		{
			if (rLNPPolDB.getGetYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&Y=??????").toString();
			if (rLNPPolDB.getGetYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&A=??????").toString();
		} else
		if (ctlname.equals("InsuYear"))
		{
			if (rLNPPolDB.getInsuYearFlag().equals("Y"))
			{
				int insuy = rLNPPolDB.getInsuYear();
				if (insuy == 1000)
					insuy = 106;
				value = (new StringBuilder(String.valueOf(value))).append("&").append(insuy).append("=").append(insuy).append("??").toString();
			}
			if (rLNPPolDB.getInsuYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&").append(rLNPPolDB.getInsuYear()).append("=??").append(rLNPPolDB.getInsuYear()).append("????").toString();
		} else
		if (ctlname.equals("InsuYearFlag"))
		{
			if (rLNPPolDB.getInsuYearFlag().equals("Y"))
				value = (new StringBuilder(String.valueOf(value))).append("&Y=??????").toString();
			if (rLNPPolDB.getInsuYearFlag().equals("A"))
				value = (new StringBuilder(String.valueOf(value))).append("&A=??????").toString();
		}
		String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
		if (valueSql != null && valueSql.length() > 0)
		{
			valueSql = transeToTypical(valueSql, tPolElementSchema);
			valueSql = StrTool.replace(valueSql, "?MasterPolNo?", CurrentMainPolNo);
			SSRS ttSSRS = rExeSQL.execSQL(valueSql);
			if (ttLNPRiskScreenSchema.getCtrlProperty().equals("01"))
			{
				if (ttSSRS != null && ttSSRS.getMaxRow() > 0)
				{
					for (int r = 1; r <= ttSSRS.MaxRow; r++)
						value = (new StringBuilder(String.valueOf(value))).append("&").append(ttSSRS.GetText(r, 1)).append("=").append(ttSSRS.GetText(r, 2)).toString();

				}
			} else
			{
				value = "";
				if (ttSSRS != null && ttSSRS.getMaxRow() > 0)
					value = ttSSRS.GetText(1, 1);
			}
		}
		value = keepPayIntvUnique(value);
		controlVData.add(value);
		controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty2());
		result.add(controlVData);
		continue; /* Loop/switch isn't completed */
_L9:
		String valueSql = ttLNPRiskScreenSchema.getDefaultSql();
		valueSql = transeToTypical(valueSql, tPolElementSchema);
		if (valueSql == null || valueSql.equals(""))
		{
			value = "";
		} else
		{
			SSRS ttSSRS = rExeSQL.execSQL(valueSql);
			if (ttLNPRiskScreenSchema.getCtrlProperty().equals("01"))
			{
				for (int r = 1; r <= ttSSRS.MaxRow; r++)
					value = (new StringBuilder(String.valueOf(value))).append("&").append(ttSSRS.GetText(r, 1)).append("=").append(ttSSRS.GetText(r, 2)).toString();

			} else
			{
				value = ttSSRS.GetText(1, 1);
			}
		}
		if (value != null)
		{
			String temp[] = value.split("&");
			if (temp.length == 2)
				value = value.replace("=?????&", "");
		}
		controlVData.add(value);
		controlVData.add(ttLNPRiskScreenSchema.getCtrlProperty2());
		result.add(controlVData);
		i++;
_L1:
		if (i <= itLNPRiskScreenSet.size()) goto _L13; else goto _L12
_L12:
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		break MISSING_BLOCK_LABEL_4249;
		Exception ex;
		ex;
		ex.printStackTrace();
		return result;
	}

	public String transeToTypical(String sqlStr, PolElementSchema tPolElementSchema)
	{
		String tempsql = sqlStr;
		tempsql = StrTool.replace(tempsql, "?PayIntv?", (new StringBuilder(String.valueOf(tPolElementSchema.getPayIntv()))).toString());
		tempsql = StrTool.replace(tempsql, "?GetIntv?", (new StringBuilder(String.valueOf(tPolElementSchema.getGetIntv()))).toString());
		tempsql = StrTool.replace(tempsql, "?Mult?", subStringInt(tPolElementSchema.getMult()));
		tempsql = StrTool.replace(tempsql, "?DeadAmntType?", tPolElementSchema.getDeadAmntType());
		tempsql = StrTool.replace(tempsql, "?TopUpPrem?", subStringInt(tPolElementSchema.getTopUpPrem()));
		tempsql = StrTool.replace(tempsql, "?Prem?", subStringInt(tPolElementSchema.getPrem()));
		tempsql = StrTool.replace(tempsql, "?AppAge?", (new StringBuilder(String.valueOf(tPolElementSchema.getAppAge()))).toString());
		tempsql = StrTool.replace(tempsql, "?AppAgeType?", (new StringBuilder(String.valueOf(tPolElementSchema.getAppAgeType()))).toString());
		tempsql = StrTool.replace(tempsql, "?Sex?", tPolElementSchema.getSex());
		tempsql = StrTool.replace(tempsql, "?OccupationCode?", tPolElementSchema.getOccupationCode());
		tempsql = StrTool.replace(tempsql, "?PayEndYear?", (new StringBuilder(String.valueOf(tPolElementSchema.getPayEndYear()))).toString());
		tempsql = StrTool.replace(tempsql, "?PayEndYearFlag?", tPolElementSchema.getPayEndYearFlag());
		tempsql = StrTool.replace(tempsql, "?GetYear?", (new StringBuilder(String.valueOf(tPolElementSchema.getGetYear()))).toString());
		tempsql = StrTool.replace(tempsql, "?GetYearFlag?", tPolElementSchema.getGetYearFlag());
		tempsql = StrTool.replace(tempsql, "?Years?", (new StringBuilder(String.valueOf(tPolElementSchema.getYears()))).toString());
		tempsql = StrTool.replace(tempsql, "?InsuYear?", (new StringBuilder(String.valueOf(tPolElementSchema.getInsuYear()))).toString());
		tempsql = StrTool.replace(tempsql, "?InsuYearFlag?", tPolElementSchema.getInsuYearFlag());
		tempsql = StrTool.replace(tempsql, "?LiveGetMode?", tPolElementSchema.getLiveGetMode());
		tempsql = StrTool.replace(tempsql, "?PolNo?", tPolElementSchema.getPolNo());
		tempsql = StrTool.replace(tempsql, "?Amnt?", subStringInt(tPolElementSchema.getAmnt()));
		tempsql = StrTool.replace(tempsql, "?StandbyFlag1?", tPolElementSchema.getStandbyFlag1());
		tempsql = StrTool.replace(tempsql, "?StandbyFlag2?", tPolElementSchema.getStandbyFlag2());
		tempsql = StrTool.replace(tempsql, "?StandbyFlag3?", tPolElementSchema.getStandbyFlag3());
		tempsql = StrTool.replace(tempsql, "?ContNo?", tPolElementSchema.getContNo());
		tempsql = StrTool.replace(tempsql, "?DutyCode?", tPolElementSchema.getDutyCode());
		tempsql = StrTool.replace(tempsql, "?BonusGetMode?", tPolElementSchema.getBonusGetMode());
		tempsql = StrTool.replace(tempsql, "?MainPolNo?", tPolElementSchema.getMainPolNo());
		tempsql = StrTool.replace(tempsql, "?MasterPolNo?", tPolElementSchema.getMasterPolNo());
		tempsql = StrTool.replace(tempsql, "?AppntSex?", tPolElementSchema.getAppntSex());
		tempsql = StrTool.replace(tempsql, "?AppntAge?", (new StringBuilder(String.valueOf(tPolElementSchema.getAppntAge()))).toString());
		tempsql = StrTool.replace(tempsql, "?AppntAgeType?", (new StringBuilder(String.valueOf(tPolElementSchema.getAppntAgeType()))).toString());
		return tempsql;
	}

	public String subStringInt(double value)
	{
		if (value == (double)(int)value)
		{
			return (new StringBuilder(String.valueOf((int)value))).toString();
		} else
		{
			DecimalFormat myformat = new DecimalFormat("#0.00");
			return myformat.format(value);
		}
	}

	public VData getAllCtrolCurrentValue(String PolNo)
	{
		LNPPolDB reLNPPolDB;
		VData reuslt;
		LNPRiskScreenSet reLNPRiskScreenDBSet;
		if (PolNo == null || PolNo.length() == 0)
			return null;
		reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setPolNo(PolNo);
		if (!reLNPPolDB.getInfo())
			break MISSING_BLOCK_LABEL_389;
		reuslt = new VData();
		LNPRiskScreenDB reLNPRiskScreenDB = new LNPRiskScreenDB();
		String sql = (new StringBuilder("select * from lnpriskscreen where riskcode='")).append(reLNPPolDB.getRiskCode()).append("'").append(" ORDER BY CtrlIndex").toString();
		reLNPRiskScreenDBSet = reLNPRiskScreenDB.executeQuery(sql);
		if (reLNPRiskScreenDBSet == null || reLNPRiskScreenDBSet.size() <= 0) goto _L2; else goto _L1
_L1:
		int i;
		LNPRiskScreenSchema rLNPRiskScreenSchema = null;
		i = 1;
		  goto _L3
_L10:
		String set[];
		LNPRiskScreenSchema rLNPRiskScreenSchema = reLNPRiskScreenDBSet.get(i);
		String value = getCtrlInfoFromPol(rLNPRiskScreenSchema.getCtrlCode(), reLNPPolDB);
		set = new String[2];
		set[0] = rLNPRiskScreenSchema.getCtrlCode();
		set[1] = value;
		if (set[0] == null || set[0].equals("null") || !set[0].equalsIgnoreCase("PayEndYear")) goto _L5; else goto _L4
_L4:
		set;
		1;
		JVM INSTR dup2 ;
		JVM INSTR aaload ;
		JVM INSTR new #92  <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"/";
		append();
		getCtrlInfoFromPol("PayEndYearFlag", reLNPPolDB);
		append();
		toString();
		JVM INSTR aastore ;
_L5:
		if (set[0] == null || set[0].equals("null") || !set[0].equalsIgnoreCase("InsuYear")) goto _L7; else goto _L6
_L6:
		set;
		1;
		JVM INSTR dup2 ;
		JVM INSTR aaload ;
		JVM INSTR new #92  <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"/";
		append();
		getCtrlInfoFromPol("InsuYearFlag", reLNPPolDB);
		append();
		toString();
		JVM INSTR aastore ;
_L7:
		if (set[0] == null || set[0].equals("null") || !set[0].equalsIgnoreCase("GetYear")) goto _L9; else goto _L8
_L8:
		set;
		1;
		JVM INSTR dup2 ;
		JVM INSTR aaload ;
		JVM INSTR new #92  <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		"/";
		append();
		getCtrlInfoFromPol("GetYearFlag", reLNPPolDB);
		append();
		toString();
		JVM INSTR aastore ;
_L9:
		reuslt.add(set);
		i++;
_L3:
		if (i <= reLNPRiskScreenDBSet.size()) goto _L10; else goto _L2
_L2:
		return reuslt;
		return null;
	}

	private String getCtrlInfoFromPol(String controlcode, LNPPolDB rLNPPolDB)
	{
		if (controlcode == null || controlcode.length() == 0 || rLNPPolDB == null)
			return "";
		if (controlcode.equals("PayIntv"))
			return (new StringBuilder(String.valueOf(rLNPPolDB.getPayIntv()))).toString();
		if (controlcode.equals("GetIntv"))
			return rLNPPolDB.getApproveCode();
		if (controlcode.equals("Mult"))
			return subStringInt(rLNPPolDB.getMult());
		if (controlcode.equals("TopUpPrem"))
			return subStringInt(rLNPPolDB.getTopUpPrem());
		if (controlcode.equals("DeadAmntType"))
			return rLNPPolDB.getDeadAmntType();
		if (controlcode.equals("Prem"))
		{
			DecimalFormat myformat = new DecimalFormat("#0.00");
			return (new StringBuilder(String.valueOf(myformat.format(rLNPPolDB.getPrem())))).toString();
		}
		if (controlcode.equals("PayEndYear"))
			return (new StringBuilder(String.valueOf(rLNPPolDB.getPayEndYear()))).toString();
		if (controlcode.equals("PayEndYearFlag"))
			return rLNPPolDB.getPayEndYearFlag();
		if (controlcode.equals("GetYear"))
			return (new StringBuilder(String.valueOf(rLNPPolDB.getGetYear()))).toString();
		if (controlcode.equals("GetYearFlag"))
			return rLNPPolDB.getGetYearFlag();
		if (controlcode.equals("InsuYear"))
			return (new StringBuilder(String.valueOf(rLNPPolDB.getInsuYear()))).toString();
		if (controlcode.equals("InsuYearFlag"))
			return rLNPPolDB.getInsuYearFlag();
		if (controlcode.equals("LiveGetMode"))
			return rLNPPolDB.getLiveGetMode();
		if (controlcode.equals("Amnt"))
			return subStringInt(rLNPPolDB.getAmnt());
		if (controlcode.equals("StandbyFlag1"))
			return rLNPPolDB.getStandbyFlag1();
		if (controlcode.equals("StandbyFlag2"))
			return rLNPPolDB.getStandbyFlag2();
		if (controlcode.equals("StandbyFlag3"))
			return rLNPPolDB.getStandbyFlag3();
		if (controlcode.equals("DutyCode"))
			return rLNPPolDB.getStandbyFlag2();
		if (controlcode.equals("BonusGetMode"))
			return rLNPPolDB.getBonusGetMode();
		else
			return "";
	}

	public PolElementSchema getPolElementSchemaByPolNo(String PolNo)
	{
		PolElementSchema rrPolElementSchema = new PolElementSchema();
		LNPPolDB wweLNPPolDB = new LNPPolDB();
		wweLNPPolDB.setPolNo(PolNo);
		if (wweLNPPolDB.getInfo())
		{
			rrPolElementSchema.setAmnt(wweLNPPolDB.getAmnt());
			rrPolElementSchema.setDeadAmntType(wweLNPPolDB.getDeadAmntType());
			rrPolElementSchema.setTopUpPrem(wweLNPPolDB.getTopUpPrem());
			rrPolElementSchema.setPrem(wweLNPPolDB.getPrem());
			rrPolElementSchema.setPayIntv(wweLNPPolDB.getPayIntv());
			String getintvstr = wweLNPPolDB.getApproveCode();
			if (getintvstr != null && getintvstr.length() > 0)
				rrPolElementSchema.setGetIntv(Integer.parseInt(getintvstr));
			rrPolElementSchema.setPayEndYear(wweLNPPolDB.getPayEndYear());
			rrPolElementSchema.setPayEndYearFlag(wweLNPPolDB.getPayEndYearFlag());
			rrPolElementSchema.setGetYear(wweLNPPolDB.getGetYear());
			rrPolElementSchema.setGetYearFlag(wweLNPPolDB.getGetYearFlag());
			rrPolElementSchema.setInsuYear(wweLNPPolDB.getInsuYear());
			rrPolElementSchema.setInsuYearFlag(wweLNPPolDB.getInsuYearFlag());
			rrPolElementSchema.setMasterPolNo(wweLNPPolDB.getMasterPolNo());
			rrPolElementSchema.setRiskCode(wweLNPPolDB.getRiskCode());
			rrPolElementSchema.setStandbyFlag1(wweLNPPolDB.getStandbyFlag1());
			rrPolElementSchema.setStandbyFlag2(wweLNPPolDB.getStandbyFlag2());
			rrPolElementSchema.setStandbyFlag3(wweLNPPolDB.getStandbyFlag3());
			rrPolElementSchema.setLiveGetMode(wweLNPPolDB.getLiveGetMode());
			rrPolElementSchema.setBonusGetMode(wweLNPPolDB.getBonusGetMode());
			rrPolElementSchema.setContNo(wweLNPPolDB.getContNo());
			rrPolElementSchema.setPolNo(wweLNPPolDB.getPolNo());
			LNPContDB reLNPContDB = new LNPContDB();
			reLNPContDB.setContNo(rrPolElementSchema.getContNo());
			if (reLNPContDB.getInfo())
			{
				String insuredId = wweLNPPolDB.getInsuredId();
				if (insuredId != null && insuredId.length() > 0 && !insuredId.equals("null"))
				{
					LNPInsuredDB yuLNPInsuredDB = new LNPInsuredDB();
					yuLNPInsuredDB.setContNo(rrPolElementSchema.getContNo());
					yuLNPInsuredDB.setInsuredId(insuredId);
					if (yuLNPInsuredDB.getInfo())
					{
						rrPolElementSchema.setSex(yuLNPInsuredDB.getSex());
						rrPolElementSchema.setOccupationCode(yuLNPInsuredDB.getOccupationCode());
						int age = yuLNPInsuredDB.getAppAge();
						rrPolElementSchema.setAppAgeType(yuLNPInsuredDB.getAppAgeType());
						rrPolElementSchema.setAppAge(age);
					}
				}
			}
			return rrPolElementSchema;
		} else
		{
			return null;
		}
	}

	public String saveInvestData(VData investData)
	{
		String appendPrem[][] = (String[][])investData.get(0);
		String someGet[][] = (String[][])investData.get(1);
		String changeAmnt[][] = (String[][])investData.get(2);
		String originalId = (String)investData.get(3);
		LNPInvestRiskDataSet inLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
		String newId = PubFun1.CreateMaxNo("InSN", 10);
		if (appendPrem != null && appendPrem.length > 0)
		{
			for (int i = 0; i < appendPrem.length; i++)
			{
				LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
				String investDataId = PubFun1.CreateMaxNo("InID", 20);
				inLNPInvestRiskDataSchema.setDataid(investDataId);
				inLNPInvestRiskDataSchema.setSignno(newId);
				inLNPInvestRiskDataSchema.setType("0");
				inLNPInvestRiskDataSchema.setSerialno(i + 1);
				inLNPInvestRiskDataSchema.setAge(appendPrem[i][0]);
				inLNPInvestRiskDataSchema.setDegree(appendPrem[i][1]);
				inLNPInvestRiskDataSchema.setValue(appendPrem[i][2]);
				inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
			}

		}
		if (someGet != null && someGet.length > 0)
		{
			for (int i = 0; i < someGet.length; i++)
			{
				LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
				String investDataId = PubFun1.CreateMaxNo("InID", 20);
				inLNPInvestRiskDataSchema.setDataid(investDataId);
				inLNPInvestRiskDataSchema.setSignno(newId);
				inLNPInvestRiskDataSchema.setType("1");
				inLNPInvestRiskDataSchema.setSerialno(i + 1);
				inLNPInvestRiskDataSchema.setAge(someGet[i][0]);
				inLNPInvestRiskDataSchema.setDegree(someGet[i][1]);
				inLNPInvestRiskDataSchema.setValue(someGet[i][2]);
				inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
			}

		}
		if (changeAmnt != null && changeAmnt.length > 0)
		{
			for (int i = 0; i < changeAmnt.length; i++)
			{
				LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
				String investDataId = PubFun1.CreateMaxNo("InID", 20);
				inLNPInvestRiskDataSchema.setDataid(investDataId);
				inLNPInvestRiskDataSchema.setSignno(newId);
				inLNPInvestRiskDataSchema.setType("2");
				inLNPInvestRiskDataSchema.setSerialno(i + 1);
				inLNPInvestRiskDataSchema.setAge(changeAmnt[i][0]);
				inLNPInvestRiskDataSchema.setDegree(changeAmnt[i][1]);
				inLNPInvestRiskDataSchema.setValue(changeAmnt[i][2]);
				inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
			}

		}
		LNPInvestRiskDataDBSet reLNPInvestRiskDataDBSet = new LNPInvestRiskDataDBSet();
		reLNPInvestRiskDataDBSet.set(inLNPInvestRiskDataSet);
		if (!reLNPInvestRiskDataDBSet.insert())
			newId = "";
		else
		if (originalId != null && newId.length() > 0)
		{
			String sql = (new StringBuilder("delete from LNPInvestRiskData where signno='")).append(originalId).append("'").toString();
			ExeSQL reExeSQL = new ExeSQL();
			reExeSQL.execUpdateSQL(sql);
		}
		return newId;
	}

	public VData getInvestData(String PolNo)
	{
		String signNo = "";
		String appendData[][] = null;
		String someGetData[][] = null;
		String changeAmntData[][] = null;
		VData resultVData = new VData();
		LNPPolDB ewLNPPolDB = new LNPPolDB();
		ewLNPPolDB.setPolNo(PolNo);
		if (ewLNPPolDB.getInfo())
			signNo = ewLNPPolDB.getStandbyFlag3();
		DecimalFormat wannengformat = new DecimalFormat("#,##0");
		String sql = (new StringBuilder("select * from LNPInvestRiskData where signno='")).append(signNo).append("'").append(" and Type='0' order by SerialNo").toString();
		LNPInvestRiskDataDB reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
		LNPInvestRiskDataSet reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
		if (reLNPInvestRiskDataSet != null && reLNPInvestRiskDataSet.size() > 0)
		{
			appendData = new String[reLNPInvestRiskDataSet.size()][3];
			for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++)
			{
				LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
				appendData[i - 1][0] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getAge()))).toString();
				appendData[i - 1][1] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getDegree()))).toString();
				appendData[i - 1][2] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getValue())))).toString();
			}

		}
		sql = (new StringBuilder("select * from LNPInvestRiskData where signno='")).append(signNo).append("'").append(" and Type='1' order by SerialNo").toString();
		reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
		reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
		if (reLNPInvestRiskDataSet != null && reLNPInvestRiskDataSet.size() > 0)
		{
			someGetData = new String[reLNPInvestRiskDataSet.size()][3];
			for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++)
			{
				LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
				someGetData[i - 1][0] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getAge()))).toString();
				someGetData[i - 1][1] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getDegree()))).toString();
				someGetData[i - 1][2] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getValue())))).toString();
			}

		}
		sql = (new StringBuilder("select * from LNPInvestRiskData where signno='")).append(signNo).append("'").append(" and Type='2' order by SerialNo").toString();
		reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
		reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
		if (reLNPInvestRiskDataSet != null && reLNPInvestRiskDataSet.size() > 0)
		{
			changeAmntData = new String[reLNPInvestRiskDataSet.size()][3];
			for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++)
			{
				LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
				changeAmntData[i - 1][0] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getAge()))).toString();
				changeAmntData[i - 1][1] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getDegree()))).toString();
				changeAmntData[i - 1][2] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getValue())))).toString();
			}

		}
		resultVData.add(appendData);
		resultVData.add(someGetData);
		resultVData.add(changeAmntData);
		return resultVData;
	}

	public String saveInvestData1(VData investData)
	{
		String appendPrem[][] = (String[][])investData.get(0);
		String someGet[][] = (String[][])investData.get(1);
		String AccountNumber[][] = (String[][])investData.get(2);
		String originalId = (String)investData.get(3);
		LNPInvestRiskDataSet inLNPInvestRiskDataSet = new LNPInvestRiskDataSet();
		String newId = PubFun1.CreateMaxNo("InSN", 10);
		if (appendPrem != null && appendPrem.length > 0)
		{
			for (int i = 0; i < appendPrem.length; i++)
			{
				LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
				String investDataId = PubFun1.CreateMaxNo("InID", 20);
				inLNPInvestRiskDataSchema.setDataid(investDataId);
				inLNPInvestRiskDataSchema.setSignno(newId);
				inLNPInvestRiskDataSchema.setType("0");
				inLNPInvestRiskDataSchema.setSerialno(i + 1);
				inLNPInvestRiskDataSchema.setAge(appendPrem[i][0]);
				inLNPInvestRiskDataSchema.setDegree(appendPrem[i][1]);
				inLNPInvestRiskDataSchema.setValue(appendPrem[i][2]);
				inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
			}

		}
		if (someGet != null && someGet.length > 0)
		{
			for (int i = 0; i < someGet.length; i++)
			{
				LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
				String investDataId = PubFun1.CreateMaxNo("InID", 20);
				inLNPInvestRiskDataSchema.setDataid(investDataId);
				inLNPInvestRiskDataSchema.setSignno(newId);
				inLNPInvestRiskDataSchema.setType("1");
				inLNPInvestRiskDataSchema.setSerialno(i + 1);
				inLNPInvestRiskDataSchema.setAge(someGet[i][0]);
				inLNPInvestRiskDataSchema.setDegree(someGet[i][1]);
				inLNPInvestRiskDataSchema.setValue(someGet[i][2]);
				inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
			}

		}
		if (AccountNumber != null && AccountNumber.length > 0)
		{
			for (int i = 0; i < AccountNumber.length; i++)
			{
				LNPInvestRiskDataSchema inLNPInvestRiskDataSchema = new LNPInvestRiskDataSchema();
				String investDataId = PubFun1.CreateMaxNo("InID", 20);
				inLNPInvestRiskDataSchema.setDataid(investDataId);
				inLNPInvestRiskDataSchema.setSignno(newId);
				inLNPInvestRiskDataSchema.setType("5");
				inLNPInvestRiskDataSchema.setSerialno(i + 1);
				inLNPInvestRiskDataSchema.setAge(AccountNumber[i][0]);
				inLNPInvestRiskDataSchema.setProtagonist(AccountNumber[i][1]);
				inLNPInvestRiskDataSchema.setExponent(AccountNumber[i][2]);
				inLNPInvestRiskDataSchema.setBanlance(AccountNumber[i][3]);
				inLNPInvestRiskDataSchema.setPrevent(AccountNumber[i][4]);
				inLNPInvestRiskDataSet.add(inLNPInvestRiskDataSchema);
			}

		}
		LNPInvestRiskDataDBSet reLNPInvestRiskDataDBSet = new LNPInvestRiskDataDBSet();
		reLNPInvestRiskDataDBSet.set(inLNPInvestRiskDataSet);
		if (!reLNPInvestRiskDataDBSet.insert())
			newId = "";
		else
		if (originalId != null && newId.length() > 0)
		{
			String sql = (new StringBuilder("delete from LNPInvestRiskData where signno='")).append(originalId).append("'").toString();
			ExeSQL reExeSQL = new ExeSQL();
			reExeSQL.execUpdateSQL(sql);
		}
		return newId;
	}

	public VData getInvestData1(String PolNo)
	{
		String signNo = "";
		String appendData[][] = null;
		String someGetData[][] = null;
		String changeAmntData[][] = null;
		String AccountData[][] = null;
		VData resultVData = new VData();
		LNPPolDB ewLNPPolDB = new LNPPolDB();
		ewLNPPolDB.setPolNo(PolNo);
		if (ewLNPPolDB.getInfo())
			signNo = ewLNPPolDB.getStandbyFlag3();
		DecimalFormat wannengformat = new DecimalFormat("#,##0");
		String sql = (new StringBuilder("select * from LNPInvestRiskData where signno='")).append(signNo).append("'").append(" and Type='0' order by SerialNo").toString();
		LNPInvestRiskDataDB reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
		LNPInvestRiskDataSet reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
		if (reLNPInvestRiskDataSet != null && reLNPInvestRiskDataSet.size() > 0)
		{
			appendData = new String[reLNPInvestRiskDataSet.size()][3];
			for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++)
			{
				LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
				appendData[i - 1][0] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getAge()))).toString();
				appendData[i - 1][1] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getDegree()))).toString();
				appendData[i - 1][2] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getValue())))).toString();
			}

		}
		sql = (new StringBuilder("select * from LNPInvestRiskData where signno='")).append(signNo).append("'").append(" and Type='1' order by SerialNo").toString();
		reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
		reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
		if (reLNPInvestRiskDataSet != null && reLNPInvestRiskDataSet.size() > 0)
		{
			someGetData = new String[reLNPInvestRiskDataSet.size()][3];
			for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++)
			{
				LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
				someGetData[i - 1][0] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getAge()))).toString();
				someGetData[i - 1][1] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getDegree()))).toString();
				someGetData[i - 1][2] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getValue())))).toString();
			}

		}
		sql = (new StringBuilder("select * from LNPInvestRiskData where signno='")).append(signNo).append("'").append(" and Type='5' order by SerialNo").toString();
		reLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
		reLNPInvestRiskDataSet = reLNPInvestRiskDataDB.executeQuery(sql);
		if (reLNPInvestRiskDataSet != null && reLNPInvestRiskDataSet.size() > 0)
		{
			AccountData = new String[reLNPInvestRiskDataSet.size()][6];
			for (int i = 1; i <= reLNPInvestRiskDataSet.size(); i++)
			{
				LNPInvestRiskDataSchema tempLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
				AccountData[i - 1][0] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getAge()))).toString();
				AccountData[i - 1][1] = (new StringBuilder(String.valueOf(tempLNPInvestRiskDataSchema.getProtagonist()))).toString();
				AccountData[i - 1][2] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getExponent())))).toString();
				AccountData[i - 1][3] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getBanlance())))).toString();
				AccountData[i - 1][4] = (new StringBuilder(String.valueOf(wannengformat.format(tempLNPInvestRiskDataSchema.getPrevent())))).toString();
			}

		}
		resultVData.add(appendData);
		resultVData.add(someGetData);
		resultVData.add(AccountData);
		return resultVData;
	}

	public HashMap getLNPInvestRiskData(String polNo)
	{
		HashMap result = new HashMap();
		LNPPolDB ewLNPPolDB = new LNPPolDB();
		ewLNPPolDB.setPolNo(polNo);
		if (ewLNPPolDB.getInfo())
		{
			DecimalFormat wannengformat = new DecimalFormat("#,##0");
			result.put("Amnt", (new StringBuilder(String.valueOf(wannengformat.format(ewLNPPolDB.getAmnt())))).toString());
			result.put("Prem", (new StringBuilder(String.valueOf(wannengformat.format(ewLNPPolDB.getStandPrem())))).toString());
			result.put("PayEndYear", (new StringBuilder(String.valueOf(wannengformat.format(ewLNPPolDB.getPayEndYear())))).toString());
			result.put("StandbyFlag2", (new StringBuilder(String.valueOf(ewLNPPolDB.getStandbyFlag2()))).toString());
			result.put("StandbyFlag3", (new StringBuilder(String.valueOf(ewLNPPolDB.getStandbyFlag3()))).toString());
			result.put("StandbyFlag1", (new StringBuilder(String.valueOf(ewLNPPolDB.getStandbyFlag1()))).toString());
			LNPContDB rLNPContDB = new LNPContDB();
			rLNPContDB.setContNo(ewLNPPolDB.getContNo());
			rLNPContDB.getInfo();
			LNPInsuredDB rLNPInsuredDB = new LNPInsuredDB();
			rLNPInsuredDB.setContNo(ewLNPPolDB.getContNo());
			rLNPInsuredDB.setInsuredId(ewLNPPolDB.getInsuredId());
			rLNPInsuredDB.getInfo();
			String cvalidate = rLNPContDB.getCValiDate();
			int appage = rLNPInsuredDB.getAppAge();
			String appagetype = rLNPInsuredDB.getAppAgeType();
			result.put("AppAge", (new StringBuilder(String.valueOf(appage))).toString());
			result.put("AppAgeType", (new StringBuilder(String.valueOf(appagetype))).toString());
			HashMap agentHashMap = new HashMap();
			PubFun tPubFun = new PubFun();
			agentHashMap = tPubFun.getLaagent(ewLNPPolDB.getOperator());
			String userManageCom = (String)agentHashMap.get("ManageCom");
			LNPComGrpToComDB reLNPComGrpToComDB = new LNPComGrpToComDB();
			reLNPComGrpToComDB.setComGrpCode("100000");
			LNPComGrpToComSet reLNPComGrpToComSet = reLNPComGrpToComDB.query();
			String flag = "0";
			if (reLNPComGrpToComSet != null && reLNPComGrpToComSet.size() > 0)
			{
				LNPComGrpToComSchema reLNPComGrpToComSchema = null;
				for (int i = 1; i <= reLNPComGrpToComSet.size(); i++)
				{
					reLNPComGrpToComSchema = reLNPComGrpToComSet.get(i);
					String comcode = reLNPComGrpToComSchema.getComCode();
					if (userManageCom.indexOf(comcode) != 0)
						continue;
					flag = "1";
					break;
				}

			}
			result.put("SpecialZoneFlag", flag);
			String str = ewLNPPolDB.getRiskCode();
			if (str != null && str.trim().equals("UL??"))
			{
				String sex = rLNPInsuredDB.getSex();
				String sql = (new StringBuilder("select urate from ULIIAMNT where Age=")).append(appage).append("and Sex=").append(sex).toString();
				ExeSQL exeSQL = new ExeSQL();
				SSRS Rate = new SSRS();
				Rate = exeSQL.execSQL(sql);
				String amntRate = Rate.GetText(1, 1);
				result.put("amntRate", (new StringBuilder(String.valueOf(amntRate))).toString());
			}
		}
		return result;
	}

	public HashMap getInvestAddInitData(String insuredId, String contNo, IGlobalInput eGlobalInput)
	{
		HashMap result = new HashMap();
		LNPContDB ewLNPContDB = new LNPContDB();
		ewLNPContDB.setContNo(contNo);
		ewLNPContDB.getInfo();
		LNPInsuredDB rLNPInsuredDB = new LNPInsuredDB();
		ewLNPContDB.setContNo(contNo);
		ewLNPContDB.setInsuredId(insuredId);
		ewLNPContDB.getInfo();
		String cvalidate = ewLNPContDB.getCValiDate();
		int appage = rLNPInsuredDB.getAppAge();
		result.put("AppAge", (new StringBuilder(String.valueOf(appage))).toString());
		if (RISKCODE != null && !RISKCODE.equals("") && RISKCODE.trim().equals("UL??"))
		{
			String sex = rLNPInsuredDB.getSex();
			String sql = (new StringBuilder("select urate from ULIIAMNT where Age=")).append(appage).append("and Sex=").append(sex).toString();
			ExeSQL exeSQL = new ExeSQL();
			SSRS Rate = new SSRS();
			Rate = exeSQL.execSQL(sql);
			String amntRate = Rate.GetText(1, 1);
			result.put("amntRate", (new StringBuilder(String.valueOf(amntRate))).toString());
		}
		String userManageCom = eGlobalInput.ComCode;
		LNPComGrpToComDB reLNPComGrpToComDB = new LNPComGrpToComDB();
		reLNPComGrpToComDB.setComGrpCode("100000");
		LNPComGrpToComSet reLNPComGrpToComSet = reLNPComGrpToComDB.query();
		String flag = "0";
		if (reLNPComGrpToComSet != null && reLNPComGrpToComSet.size() > 0)
		{
			LNPComGrpToComSchema reLNPComGrpToComSchema = null;
			for (int i = 1; i <= reLNPComGrpToComSet.size(); i++)
			{
				reLNPComGrpToComSchema = reLNPComGrpToComSet.get(i);
				String comcode = reLNPComGrpToComSchema.getComCode();
				if (userManageCom.indexOf(comcode) != 0)
					continue;
				flag = "1";
				break;
			}

		}
		result.put("SpecialZoneFlag", flag);
		return result;
	}

	private PolElementSchema setAppntAndInsuredInfo(PolElementSchema trPolElementSchema)
	{
		LNPAppntDB reLNPAppntDB = new LNPAppntDB();
		reLNPAppntDB.setContNo(trPolElementSchema.getContNo());
		if (reLNPAppntDB.getInfo())
		{
			trPolElementSchema.setAppntAge(reLNPAppntDB.getAppntAge());
			trPolElementSchema.setAppntAgeType(reLNPAppntDB.getAppntAgeType());
			trPolElementSchema.setAppntSex(reLNPAppntDB.getAppntSex());
			trPolElementSchema.setAppntId(reLNPAppntDB.getAppntId());
			trPolElementSchema.setAppntOccupationCode(reLNPAppntDB.getOccupationCode());
		}
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(trPolElementSchema.getContNo());
		reLNPInsuredDB.setInsuredId(trPolElementSchema.getInsuredId());
		if (reLNPInsuredDB.getInfo())
		{
			trPolElementSchema.setAppAge(reLNPInsuredDB.getAppAge());
			trPolElementSchema.setAppAgeType(reLNPInsuredDB.getAppAgeType());
			trPolElementSchema.setSex(reLNPInsuredDB.getSex());
			trPolElementSchema.setOccupationCode(reLNPInsuredDB.getOccupationCode());
		}
		return trPolElementSchema;
	}

	private String keepPayIntvUnique(String value)
	{
		String s[] = value.split("&");
		if (s != null && s.length == 2)
		{
			value = value.replaceFirst((new StringBuilder(String.valueOf(s[0]))).append("&").toString(), "");
			if (value.indexOf("?") > 0)
				hidePayEndYear = true;
		}
		return value;
	}

	public void Setriskcode(String riskcode)
	{
		RISKCODE = riskcode;
	}
}
