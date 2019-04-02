// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PublicInterfaces.java

package com.sinosoft.banklns.lnsmodel.interfaces;

import com.sinosoft.banklns.lis.db.LNPCodeDB;
import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
import com.sinosoft.banklns.lnsmodel.webservice.EAIProxy;
import com.sinosoft.banklns.lnsmodel.webservice.XMLEncoder;
import com.sinosoft.banklns.utility.*;
import com.sinosoft.map.common.WebApplication;
import com.sinosoft.map.lis.db.MSysVarDB;
import com.sinosoft.map.lis.db.MUserDB;
import com.sinosoft.map.lis.schema.MSysVarSchema;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import org.jdom.*;
import org.jdom.xpath.XPath;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.interfaces:
//			XMLSaveThread

public abstract class PublicInterfaces
{

	protected String message;
	protected String defaultErrorMessage;
	protected String sendFileName;
	protected String returnFileName;
	protected String modelFileName;
	protected boolean interfacesFlag;
	protected Namespace ns1;
	protected Namespace ns2;
	protected Namespace ns3;
	protected MMap map;
	protected MMap bakMap;
	public String tContNo;
	private static Map mapQuesKey = new Hashtable();
	private static Map mapCodeKey = new Hashtable();
	protected boolean valiPassFlag;
	private String date;
	private String time;
	protected static Hashtable modelList = new Hashtable();
	public Document doc;
	public Document returnDoc;
	protected XMLByJDOM tXMLByJDOM;
	protected Connection con;
	protected ExeSQL exe;

	public PublicInterfaces()
	{
		message = "";
		defaultErrorMessage = null;
		sendFileName = null;
		returnFileName = null;
		modelFileName = null;
		interfacesFlag = true;
		ns1 = null;
		ns2 = null;
		ns3 = null;
		map = null;
		bakMap = null;
		tContNo = null;
		valiPassFlag = true;
		date = PubFun.getCurrentDate();
		time = PubFun.getCurrentTime();
		doc = null;
		returnDoc = null;
		tXMLByJDOM = null;
		con = null;
		exe = null;
	}

	public boolean calInterfaces(String contNo)
	{
		boolean flag1;
		boolean flag = false;
		tContNo = contNo;
		initObject();
		flag = getInputData(contNo);
		flag = flag && dealSend();
		System.out.println((new StringBuilder("--->has used prepareDoc Func?:")).append(interfacesFlag).toString());
		flag = flag && sendXML();
		flag = flag && dealReturn();
		flag = saveData() && flag;
		message = message != null && !"".equals(message) ? message : defaultErrorMessage;
		flag1 = flag;
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return flag1;
		Exception e;
		e;
		e.printStackTrace();
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		Exception exception;
		exception;
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		throw exception;
	}

	private boolean prepareDoc()
	{
		Element root = doc.getRootElement();
		root.addNamespaceDeclaration(ns1);
		root.addNamespaceDeclaration(ns2);
		root.addNamespaceDeclaration(ns3);
		root.setNamespace(ns1);
		List eleList = root.getChildren();
		for (Iterator it = eleList.iterator(); it.hasNext();)
		{
			Element tempElement = (Element)it.next();
			if (!prepareElement(tempElement))
				return false;
		}

		root.removeNamespaceDeclaration(ns3);
		return true;
	}

	private boolean prepareElement(Element ele)
	{
		Element item;
		Iterator it;
		List eleList = ele.getChildren();
		ele.setNamespace(ns2);
		item = new Element("item", ns3);
		if (eleList.isEmpty())
			break MISSING_BLOCK_LABEL_256;
		if (eleList.size() < 2 || !((Element)eleList.get(0)).getName().equals(((Element)eleList.get(1)).getName()))
			break MISSING_BLOCK_LABEL_176;
		eleList = ele.removeContent();
		it = eleList.iterator();
		  goto _L1
_L3:
		Content tempElement;
		tempElement = (Content)it.next();
		item = new Element("item", ns3);
		if (!(tempElement instanceof Element))
			continue; /* Loop/switch isn't completed */
		tempElement = (Element)tempElement;
		item.addContent(tempElement);
		if (!prepareElement((Element)tempElement))
			return false;
		ele.addContent(item);
_L1:
		if (it.hasNext()) goto _L3; else goto _L2
_L2:
		break MISSING_BLOCK_LABEL_256;
		List eleList = ele.removeContent();
		it = eleList.iterator();
		  goto _L4
_L6:
		tempElement = (Content)it.next();
		if (!(tempElement instanceof Element))
			continue; /* Loop/switch isn't completed */
		tempElement = (Element)tempElement;
		item.addContent(tempElement);
		if (!prepareElement((Element)tempElement))
			return false;
_L4:
		if (it.hasNext()) goto _L6; else goto _L5
_L5:
		ele.addContent(item);
		return true;
		Exception e;
		e;
		e.printStackTrace();
		return false;
	}

	public boolean saveData()
	{
		if (!map.keySet().isEmpty())
		{
			VData tVData = new VData();
			tVData.add(map);
			System.out.println("开始执行数据库操作.......");
			PubSubmit tPubSubmit = new PubSubmit();
			if (!tPubSubmit.submitData(tVData, ""))
			{
				System.out.println("数据库操作执行失败！");
				return false;
			}
		}
		System.out.println("数据库操作执行成功！");
		return true;
	}

	public boolean rollbakData()
	{
		if (!bakMap.keySet().isEmpty())
		{
			VData tVData = new VData();
			tVData.add(bakMap);
			System.out.println("开始执行数据库操作.......");
			PubSubmit tPubSubmit = new PubSubmit();
			if (!tPubSubmit.submitData(tVData, ""))
			{
				System.out.println("数据库操作执行失败！");
				return false;
			}
		}
		System.out.println("数据库操作执行成功！");
		return true;
	}

	public void rollbakData(VData tVData)
	{
		if (!bakMap.keySet().isEmpty())
			tVData.add(bakMap);
	}

	protected abstract boolean dealReturn();

	private boolean sendXML()
	{
		saveCreatedXMLFile(doc, sendFileName, tContNo);
		EAIProxy tTMAProxy = new EAIProxy();
		try
		{
			tTMAProxy.setFlag(returnFileName);
			String soapReturnStr = tTMAProxy.doProcess(doc);
			soapReturnStr = XMLEncoder.toDecode(soapReturnStr);
			returnDoc = tXMLByJDOM.stringToXML(soapReturnStr);
			saveCreatedXMLFile(returnDoc, returnFileName, tContNo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void saveCreatedXMLFile(Document doc2, String string, String tContNo2)
	{
		(new XMLSaveThread(doc2, string, tContNo2)).start();
	}

	protected abstract boolean dealSend();

	protected abstract boolean getInputData(String s);

	protected void initObject()
	{
		try
		{
			if ("dupli_in.xml".equals(modelFileName) && NBFlag() && agentFlag())
				modelFileName = "dupliNB_in.xml";
			else
			if ("issue_in.xml".equals(modelFileName) && NBFlag() && agentFlag())
				modelFileName = "issueNB_in.xml";
			tXMLByJDOM = new XMLByJDOM();
			String rootPath = WebApplication.getInstance().getServletContextPath();
			String tranPath = (new StringBuilder(String.valueOf(rootPath != null ? ((Object) (rootPath)) : ""))).append(File.separator).append("templete").append(File.separator).append(modelFileName).toString();
			if (!modelList.containsKey(modelFileName))
				modelList.put(modelFileName, tXMLByJDOM.loadXMLFileByJDOM(tranPath));
			doc = (Document)((Document)modelList.get(modelFileName)).clone();
			map = new MMap();
			bakMap = new MMap();
			con = DBConnPool.getConnection();
			exe = new ExeSQL(con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
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

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Element getSendBody()
	{
		return doc.getRootElement();
	}

	public Element getReturnBody()
	{
		Element returnElement = returnDoc.getRootElement();
		System.out.println((new StringBuilder("element--name----------------->")).append(returnElement.getName()).append("<--->").append(returnElement.getNamespace()).toString());
		return returnElement;
	}

	protected String fomartDate(String date)
	{
		if (date != null)
			return date.replaceAll("^(\\d+)-(\\d+)-(\\d+).*$", "$1$2$3");
		else
			return null;
	}

	protected String fomartNum(double number)
	{
		DecimalFormat formatDouble = new DecimalFormat("#0.00");
		return formatDouble.format(number);
	}

	protected String getValueInXML(Document doc, String nodeName)
		throws JDOMException
	{
		Element element = (Element)XPath.selectSingleNode(doc, nodeName);
		return element.getText();
	}

	protected String getValueInXML(Element ele, String nodeName)
		throws JDOMException
	{
		Element element = ele.getChild(nodeName);
		return element.getText();
	}

	protected void updateText(Element element, String childName, String text)
	{
		if (element == null)
			System.out.println("element is null!");
		if (text != null)
			if (interfacesFlag)
				element.getChild(childName.toUpperCase()).setText(text);
			else
				element.getChild(childName).setText(text);
	}

	protected void updateTextForNB(Element element, String childName, String text)
	{
		if (element == null)
			System.out.println("element is null!");
		if (text != null)
			element.getChild(childName).setText(text);
	}

	protected void setSaveTime(Schema aschema)
	{
		aschema.setV("makedate", date);
		aschema.setV("maketime", time);
		aschema.setV("modifydate", date);
		aschema.setV("modifytime", time);
	}

	protected void setModifyTime(Schema aschema)
	{
		aschema.setV("modifydate", date);
		aschema.setV("modifytime", time);
	}

	protected String turnNullToString(Object object)
	{
		String rst = "";
		try
		{
			rst = object != null ? (new StringBuilder()).append(object).toString() : "";
		}
		catch (Exception e)
		{
			return rst;
		}
		return rst.trim();
	}

	protected String mappingCode(String srcCode, String codeType)
	{
		String tarCode = srcCode;
		LNPCodeDB db = new LNPCodeDB(con);
		String tKV = (String)mapCodeKey.get((new StringBuilder(String.valueOf(codeType))).append(srcCode).toString());
		System.out.println((new StringBuilder("-->key:")).append(codeType).append(srcCode).append("value:").append(tKV).toString());
		if (tKV != null && !"".equals(tKV))
			return tKV;
		String sql = (new StringBuilder("select * from lnpcode where code='")).append(srcCode).append("' and CodeType='").append(codeType).append("'").toString();
		LNPCodeSet set = db.executeQuery(sql);
		if (set.size() > 0)
		{
			tarCode = set.get(1).getCodeAlias();
			tarCode = turnNullToString(tarCode);
			if (mapCodeKey == null)
				mapCodeKey = new Hashtable();
			else
				mapCodeKey.put((new StringBuilder(String.valueOf(codeType))).append(srcCode).toString(), tarCode);
		}
		return tarCode;
	}

	protected String mappingQues(String tarId, String policyType, String contNo, String saleChannel)
	{
		String answer = "";
		String srcId = "";
		try
		{
			srcId = (String)mapQuesKey.get(tarId);
			if (srcId != null && !"".equals(srcId) && !srcId.startsWith(saleChannel.equals("1") ? "0201" : saleChannel.equals("2") ? "0301" : "0101"))
				mapQuesKey.clear();
			if (srcId == null || "".equals(srcId))
			{
				mapQuesKey.clear();
				ExeSQL execSQL = new ExeSQL(con);
				SSRS ssrs = execSQL.execSQL((new StringBuilder("select codename,codealias from lnpcode where codetype='QueCodeMapping' and comcode='")).append(saleChannel).append("'").toString());
				if (ssrs != null && ssrs.MaxRow > 0)
				{
					for (int i = 1; i <= ssrs.MaxRow; i++)
						mapQuesKey.put(ssrs.GetText(i, 1), ssrs.GetText(i, 2));

				}
				srcId = (String)mapQuesKey.get(tarId);
			}
			LNPCustImpResultDB db = new LNPCustImpResultDB(con);
			String sql = (new StringBuilder("select * from LNPCustImpResult where QuestionId='")).append(srcId).append("' and ContNo='").append(contNo).append("' and CustomerNo='").append(policyType).append("'").toString();
			System.out.println((new StringBuilder("-->sql：")).append(sql).toString());
			LNPCustImpResultSet set = db.executeQuery(sql);
			if (set.size() > 0)
			{
				LNPCustImpResultSchema tSchema = set.get(1);
				answer = "1".equals(tSchema.getQuestionType()) ? "1".equals(tSchema.getOptionId()) ? "Y" : "2".equals(tSchema.getOptionId()) ? "N" : "" : tSchema.getAnswer();
				System.out.println((new StringBuilder("人员类别：")).append(policyType).append("------>核心问题ID：").append(tarId).append(" | MDES问题ID：").append(srcId).append("--->问题类型：").append(tSchema.getQuestionType()).append("--->问题答案：").append(answer).toString());
			}
		}
		catch (RuntimeException e)
		{
			System.out.println("erro------------->核心系统xml中问题id");
			e.printStackTrace();
		}
		return answer;
	}

	public boolean isValiPassFlag()
	{
		return valiPassFlag;
	}

	public void setValiPassFlag(boolean valiPassFlag)
	{
		this.valiPassFlag = valiPassFlag;
	}

	public String combAddress(LNPAddressSchema tAddressSchema, String type)
	{
		String str = "";
		String province = "";
		String city = "";
		String county = "";
		String road = "";
		String village = "";
		if ("1".equals(type))
		{
			province = tAddressSchema.getHomeFax();
			city = tAddressSchema.getBP();
			county = tAddressSchema.getHomePhone();
			road = tAddressSchema.getHomeAddress();
			village = tAddressSchema.getEMail();
			str = tAddressSchema.getHomeAddress();
		} else
		if ("2".equals(type))
		{
			province = tAddressSchema.getCompanyFax();
			city = tAddressSchema.getBP2();
			county = tAddressSchema.getMobile2();
			road = tAddressSchema.getCompanyAddress();
			village = tAddressSchema.getEMail2();
			str = tAddressSchema.getCompanyAddress();
		}
		if (province != null && !"".equals(province) && !"-1".equals(province) && city != null && !"".equals(city) && !"-1".equals(city) && county != null && !"".equals(county) && !"-1".equals(county))
		{
			String provName = getAddressName(province);
			String cityName = getAddressName(city);
			if (provName.equals(cityName))
				str = (new StringBuilder(String.valueOf(provName))).append(getAddressName(county)).append(road).append(village).toString();
			else
				str = (new StringBuilder(String.valueOf(provName))).append(cityName).append(getAddressName(county)).append(road).append(village).toString();
		}
		return str;
	}

	private String getAddressName(String code)
	{
		String str = "";
		String sql = (new StringBuilder("select codename from lnpcode where codetype='provinceCity' and code='")).append(code).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS.MaxRow > 0)
			str = tSSRS.GetText(1, 1);
		if ("--".equals(str))
			str = "";
		return str;
	}

	public String combPhone(String areaCode, String phone)
	{
		String str = phone;
		if (areaCode == null || "".equals(areaCode) || "-1".equals(areaCode) || "null".equals(areaCode) || phone == null || "".equals(phone))
		{
			return str;
		} else
		{
			str = (new StringBuilder(String.valueOf(areaCode))).append("-").append(phone).toString();
			return str;
		}
	}

	protected String turnToCode(String channel)
	{
		String code = "3";
		if ("AGY".equals(channel))
			code = "1";
		else
		if ("TM".equals(channel))
			code = "2";
		else
		if ("BXS".equals(channel))
			code = "3";
		return code;
	}

	public String getDecryptAccount(String contno)
	{
		String rStr = "";
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("OPEN SYMMETRIC KEY key_encryption DECRYPTION BY CERTIFICATE cert_keyProtection;  SELECT convert(nvarchar(500),DecryptByKey(account)) from lnppayment where contno='")).append(contno).append("' ").append(" CLOSE SYMMETRIC KEY key_encryption").toString();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			rStr = tSSRS.GetText(1, 1);
		return rStr;
	}

}
