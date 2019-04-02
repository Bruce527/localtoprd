// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CheckUser.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import com.sinosoft.map.lis.db.MSysVarDB;
import com.sinosoft.map.lis.db.MUserDB;
import com.sinosoft.map.lis.schema.MSysVarSchema;
import java.io.PrintStream;
import java.util.List;
import org.jdom.Element;
import org.jdom.Namespace;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.interfaces:
//			PublicInterfaces

public class CheckUser extends PublicInterfaces
{

	private LNPContSchema tLNPContSchema;
	private LNPPersonSet tLNPPersonSet;
	private LNPAppntSchema tLNPAppntSchema;
	private LNPInsuredSchema tLNPInsuredSchema;
	private String userName;
	private String password;

	public CheckUser()
	{
	}

	protected void initObject()
	{
		modelFileName = "dupli_in.xml";
		sendFileName = "dupli_in";
		returnFileName = "dupli_out";
		defaultErrorMessage = "客户相似度校验失败！";
		super.initObject();
	}

	protected boolean dealReturn()
	{
		LNPPersonSet bakPersonSet;
		LNPContSchema bakLNPContSchema;
		LNPAppntSchema bakLNPAppntSchema;
		LNPInsuredSchema bakLNPInsuredSchema;
		Element returnN;
		String valiReason;
		bakPersonSet = new LNPPersonSet();
		bakPersonSet.set(tLNPPersonSet);
		bakLNPContSchema = new LNPContSchema();
		bakLNPContSchema.setSchema(tLNPContSchema);
		bakLNPAppntSchema = new LNPAppntSchema();
		bakLNPAppntSchema.setSchema(tLNPAppntSchema);
		bakLNPInsuredSchema = new LNPInsuredSchema();
		bakLNPInsuredSchema.setSchema(tLNPInsuredSchema);
		returnN = getReturnBody();
		Namespace err = Namespace.getNamespace("http://www.csc.smart/bo/schemas/Error");
		Element errorN = returnN.getChild("ERROR", err);
		if (errorN == null)
			break MISSING_BLOCK_LABEL_194;
		System.out.println("EAI调用LA成功，但返回了错误！");
		Element statusN = errorN.getChild("STATUS", err);
		Element reason = errorN.getChild("REASON", err);
		valiReason = reason.getChild("ERROR_DESC", err).getText();
		this;
		message;
		JVM INSTR new #131 <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		valiReason;
		append();
		toString();
		message;
		System.out.println((new StringBuilder("ERROR_DESC==")).append(message).toString());
		return false;
		Element returnInfoN;
		returnInfoN = returnN.getChild("RETURNINFO");
		if (returnInfoN != null)
			break MISSING_BLOCK_LABEL_218;
		System.out.println("***********************SOAP ERROR**************MSP接口CLTService调用出错！");
		return false;
		if (!"".equals(getValueInXML(returnInfoN, "ERRCODE")) && getValueInXML(returnInfoN, "ERRCODE") != null && !"0".equals(getValueInXML(returnInfoN, "ERRCODE")))
			break MISSING_BLOCK_LABEL_695;
		List clientList = returnInfoN.getChildren("CLIENTLIST");
		for (int i = 1; i <= tLNPPersonSet.size() && i <= clientList.size(); i++)
		{
			Element client = ((Element)clientList.get(i - 1)).getChild("CLIENTINFO");
			String seqnoN = getValueInXML(client, "SEQNO");
			if ("1".equals(seqnoN))
			{
				setModifyTime(tLNPContSchema);
				tLNPContSchema.setAppntNo(getValueInXML(client, "LIFCNUM"));
				setModifyTime(tLNPAppntSchema);
				tLNPAppntSchema.setAppntNo(getValueInXML(client, "LIFCNUM"));
				for (int j = 1; j <= tLNPPersonSet.size(); j++)
				{
					LNPPersonSchema tempSchema = tLNPPersonSet.get(j);
					if (tempSchema == null || !tLNPAppntSchema.getAppntId().equals(tempSchema.getCustomerId()))
						continue;
					tempSchema.setCustomerNo(getValueInXML(client, "LIFCNUM"));
					setModifyTime(tempSchema);
					break;
				}

			}
			if ("2".equals(seqnoN))
			{
				setModifyTime(tLNPContSchema);
				tLNPContSchema.setInsuredNo(getValueInXML(client, "LIFCNUM"));
				setModifyTime(tLNPInsuredSchema);
				tLNPInsuredSchema.setInsuredNo(getValueInXML(client, "LIFCNUM"));
				for (int j = 1; j <= tLNPPersonSet.size(); j++)
				{
					LNPPersonSchema tempSchema = tLNPPersonSet.get(j);
					if (tempSchema == null || !tLNPInsuredSchema.getInsuredId().equals(tempSchema.getCustomerId()))
						continue;
					tempSchema.setCustomerNo(getValueInXML(client, "LIFCNUM"));
					setModifyTime(tempSchema);
					break;
				}

			}
		}

		bakMap.put(bakPersonSet, "UPDATE");
		bakMap.put(bakLNPContSchema, "UPDATE");
		bakMap.put(bakLNPAppntSchema, "UPDATE");
		bakMap.put(bakLNPInsuredSchema, "UPDATE");
		map.put(tLNPPersonSet, "UPDATE");
		map.put(tLNPContSchema, "UPDATE");
		map.put(tLNPAppntSchema, "UPDATE");
		map.put(tLNPInsuredSchema, "UPDATE");
		return true;
		try
		{
			message = getValueInXML(returnInfoN, "PDESC");
			System.out.println("出现错误！");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}

	protected boolean dealSend()
	{
		try
		{
			Element msgBody = getSendBody();
			String company = mappingCode(tLNPContSchema.getManageCom(), "BankSigned");
			Element client = null;
			Element clientList = null;
			if (NBFlag() && agentFlag())
			{
				updateText(msgBody, "BRANCH", company);
				updateText(msgBody, "COMMITFLAG", "Y");
				updateText(msgBody, "COMPANY", "2");
				updateText(msgBody, "IGNOREDRIVERHELD", "Y");
				updateText(msgBody, "LANGUAGE", "S");
				updateText(msgBody, "OBJECTID", "CLT");
				updateText(msgBody, "PASSWORD", password);
				updateText(msgBody, "USRPRF", userName);
				updateText(msgBody, "VERBID", "VAL");
				updateText(msgBody, "XSUPPRESSRCLRSC", "N");
				Element app = msgBody.getChild("AppClientList");
				updateText(app, "CNTBRANCH", company);
				updateText(app, "TTMPRCNO", tLNPContSchema.getContNo());
				clientList = app.getChild("ClientList");
				client = clientList.getChild("ClientInfo");
				clientList.removeContent();
			} else
			{
				Namespace msp = Namespace.getNamespace("http://www.csc.smart/msp/schemas/MSPContext");
				List msgList = msgBody.getChildren();
				Element mspContent = (Element)msgList.get(0);
				Element userId = mspContent.getChild("UserId", msp);
				userId.setText(userName);
				Element uerPassword = mspContent.getChild("UserPassword", msp);
				uerPassword.setText(password);
				Element reqps = mspContent.getChild("RequestParameters", msp);
				Element requestParameter = reqps.getChild("RequestParameter", msp);
				requestParameter.setAttribute("name", "BRANCH").setAttribute("value", company);
				Element app = msgBody.getChild("APPCLIENTLIST");
				updateText(app, "CNTBRANCH", company);
				updateText(app, "TTMPRCNO", tLNPContSchema.getContNo());
				clientList = app.getChild("CLIENTLIST");
				client = clientList.getChild("CLIENTINFO");
				clientList.removeContent();
			}
			Element tempClient_app = (Element)client.clone();
			updateText(tempClient_app, "SEQNO", "01");
			updateText(tempClient_app, "LSURNAME", tLNPAppntSchema.getAppntName());
			updateText(tempClient_app, "DOB", fomartDate(tLNPAppntSchema.getAppntBirthday()));
			updateText(tempClient_app, "IDNNUM", tLNPAppntSchema.getIDNo());
			updateText(tempClient_app, "IDNPRF", mappingCode(tLNPAppntSchema.getIDType(), "BankCertType"));
			updateText(tempClient_app, "NATLTY", tLNPAppntSchema.getNativePlace());
			updateText(tempClient_app, "CLTSEX", mappingCode(tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
			clientList.addContent(tempClient_app);
			Element tempClient_ins = (Element)client.clone();
			updateText(tempClient_ins, "SEQNO", "02");
			updateText(tempClient_ins, "LSURNAME", tLNPInsuredSchema.getName());
			updateText(tempClient_ins, "DOB", fomartDate(tLNPInsuredSchema.getBirthday()));
			updateText(tempClient_ins, "IDNNUM", tLNPInsuredSchema.getIDNo());
			updateText(tempClient_ins, "IDNPRF", mappingCode(tLNPInsuredSchema.getIDType(), "BankCertType"));
			updateText(tempClient_ins, "NATLTY", tLNPInsuredSchema.getNativePlace());
			updateText(tempClient_ins, "CLTSEX", mappingCode(tLNPInsuredSchema.getSex(), "BankPolicySex"));
			clientList.addContent(tempClient_ins);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean agentFlag()
	{
		ExeSQL exeSql = new ExeSQL();
		String sql_lnpCode = "SELECT code FROM lnpcode where codetype = 'agentCode'";
		SSRS ssr1 = exeSql.execSQL(sql_lnpCode);
		if (ssr1.getMaxRow() > 0)
		{
			MUserDB mUser = new MUserDB();
			mUser.setUserCode(ssr1.GetText(1, 1));
			boolean mUserFlag = mUser.getInfo();
			String sql_laagent = (new StringBuilder("SELECT 'X' FROM LAAGENT WHERE AGENTCODE = '")).append(ssr1.GetText(1, 1)).append("'").toString();
			SSRS ssr2 = exeSql.execSQL(sql_laagent);
			if (mUserFlag || ssr2.getMaxRow() > 0)
				return true;
		}
		return false;
	}

	private boolean NBFlag()
	{
		MSysVarDB msy = new MSysVarDB();
		msy.setVarType("NBSwitch");
		return msy.getInfo() && "Y".equalsIgnoreCase(msy.getSchema().getVarValue());
	}

	protected boolean getInputData(String tContNo)
	{
		super.valiPassFlag = true;
		ExeSQL exeSQL = new ExeSQL(con);
		SSRS ssrs = exeSQL.execSQL("select sysvartype,sysvarvalue from lnpsysvar where SysVar='issue_user_password'");
		if (ssrs.MaxRow > 0)
		{
			userName = ssrs.GetText(1, 1);
			password = ssrs.GetText(1, 2);
			break MISSING_BLOCK_LABEL_69;
		}
		message = "缺失权限,请获取权限后继续操作!";
		return valiPassFlag = false;
		LNPContDB ldb;
		ldb = new LNPContDB(con);
		ldb.setContNo(tContNo);
		if (ldb.getInfo())
			break MISSING_BLOCK_LABEL_110;
		message = "获取投保书信息失败！";
		return valiPassFlag = false;
		tLNPContSchema = ldb.getSchema();
		LNPAppntDB lpadb = new LNPAppntDB(con);
		lpadb.setContNo(tContNo);
		if (lpadb.getInfo())
		{
			tLNPAppntSchema = lpadb.getSchema();
			break MISSING_BLOCK_LABEL_172;
		}
		message = "获取投保人信息失败！";
		return valiPassFlag = false;
		try
		{
			LNPInsuredDB lpidb = new LNPInsuredDB(con);
			lpidb.setContNo(tContNo);
			tLNPInsuredSchema = lpidb.query().get(1);
			LNPPersonDB lpdb = new LNPPersonDB(con);
			tLNPPersonSet = lpdb.executeQuery((new StringBuilder("select * from lnpperson where CustomerId in ('")).append(tLNPAppntSchema.getAppntId()).append("','").append(tLNPInsuredSchema.getInsuredId()).append("')").toString());
		}
		catch (Exception e)
		{
			message = "获取被保人信息失败！";
			return valiPassFlag = false;
		}
		return true;
	}

	public static void main(String args[])
	{
		CheckUser cal = new CheckUser();
		String tContNo = "123213213123";
		tContNo = "201707071123";
		cal.dealSend();
	}
}
