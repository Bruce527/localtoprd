// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EAIProxy.java

package com.sinosoft.banklns.lnsmodel.webservice;

import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelope;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeESBHeader;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeMsgBody;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResult;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResultESBHeader;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResultMsgBody;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntry;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntryLocator;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntrySoap_PortType;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import com.sinosoft.map.common.WebApplication;
import java.io.File;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.rpc.ServiceException;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.Time;
import org.apache.soap.rpc.Call;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.Document;

public class EAIProxy
{

	private Call call;
	private String returnFileName;

	public void setFlag(String flag)
	{
		returnFileName = flag;
	}

	public EAIProxy()
	{
		call = new Call();
	}

	public static void main(String args[])
		throws Exception
	{
		EAIProxy tma = new EAIProxy();
		SAXBuilder builder = new SAXBuilder();
		org.jdom.Document doc = builder.build(new File("src/issue_in11800124652720190221165937.xml"));
		try
		{
			Date tSrvDate = new Date();
			Time srvTime = new Time(new GregorianCalendar());
			DOMOutputter converter11 = new DOMOutputter();
			Document domDocument = converter11.output(doc);
			ESBEnvelopeESBHeader tESBEnvelopeESBHeader = new ESBEnvelopeESBHeader();
			tESBEnvelopeESBHeader.setSenderID("MDES");
			tESBEnvelopeESBHeader.setSrvDate(tSrvDate);
			tESBEnvelopeESBHeader.setSrvTime(srvTime);
			tESBEnvelopeESBHeader.setReceiverID("LA");
			tESBEnvelopeESBHeader.setSrvOpVer("");
			tESBEnvelopeESBHeader.setSrvOpName("NBUPLService");
			System.out.println((new StringBuilder(String.valueOf(tESBEnvelopeESBHeader.getESBRspDec()))).append("head msg~~~~~~~~~~~~~~~~~~~").toString());
			ESBEnvelopeMsgBody yESBEnvelopeMsgBody = new ESBEnvelopeMsgBody();
			org.w3c.dom.Element root = domDocument.getDocumentElement();
			MessageElement thh = new MessageElement(root);
			MessageElement _any[] = {
				thh
			};
			yESBEnvelopeMsgBody.set_any(_any);
			ESBEnvelope tESBEnvelope = new ESBEnvelope();
			tESBEnvelope.setESBHeader(tESBEnvelopeESBHeader);
			tESBEnvelope.setMsgBody(yESBEnvelopeMsgBody);
			ESBWebEntry trESBWebEntry = new ESBWebEntryLocator();
			ESBWebEntrySoap_PortType soap = trESBWebEntry.getESBWebEntrySoap();
			ESBEnvelopeResult gESBEnvelopeResult = soap.processMessage(tESBEnvelope);
			System.out.println(gESBEnvelopeResult.getESBHeader().getESBRspDec());
			MessageElement tResult[] = gESBEnvelopeResult.getMsgBody().get_any();
			MessageElement tResult1 = tResult[0];
			System.out.println(tResult1);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (JDOMException e)
		{
			e.printStackTrace();
		}
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public synchronized String doProcess(org.jdom.Document doc)
		throws Exception
	{
		String returnXml = null;
		String flagSql = null;
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = null;
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			if ("test".equals(tSSRS.GetText(1, 1)))
			{
				returnXml = doProcessTest(doc);
				System.out.println("接口返回报文：");
				System.out.println(returnXml);
			} else
			if ("interface".equals(tSSRS.GetText(1, 1)))
				returnXml = doProcessByAxis(doc);
			else
			if ("interface2".equals(tSSRS.GetText(1, 1)))
				returnXml = doProcessByStream(doc);
		} else
		{
			System.out.println("fail to read the interfaceflag...");
		}
		if ("prem_out".equals(returnFileName))
			flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Prem'";
		else
		if ("dupli_out".equals(returnFileName))
			flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Dupli'";
		else
		if ("aura_out".equals(returnFileName))
			flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Aura'";
		else
		if ("issue_out".equals(returnFileName))
			flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Issue'";
		else
		if ("appnt_out".equals(returnFileName))
			flagSql = "select sysvarvalue from lnpsysvar where sysvar ='interfaceflag_Appnt'";
		tSSRS = tExeSQL.execSQL(flagSql);
		if ("test".equals(tSSRS.GetText(1, 1)))
		{
			returnXml = doProcessTest(doc);
			System.out.println("接口返回报文：");
			System.out.println(returnXml);
		} else
		if ("interface".equals(tSSRS.GetText(1, 1)))
			returnXml = doProcessByAxis(doc);
		return returnXml;
	}

	private String doProcessTest(org.jdom.Document doc)
		throws Exception
	{
		System.out.println("进入接口交互测试方法");
		System.out.println("传入xml的值：");
		System.out.println(doc);
		XMLByJDOM tXMLByJDOM = new XMLByJDOM();
		String rootPath = WebApplication.getInstance().getServletContextPath();
		String returnStr = tXMLByJDOM.transformXMLToString(tXMLByJDOM.loadXMLFileByJDOM((new StringBuilder(String.valueOf(rootPath != null ? ((Object) (rootPath)) : ""))).append("returnfile").append(File.separator).append(returnFileName).append(".xml").toString()));
		System.out.println("接口返回值：");
		System.out.println(returnStr);
		return returnStr;
	}

	private String doProcessByAxis(org.jdom.Document doc)
	{
		MessageElement tResult1;
		Date tSrvDate = new Date();
		Time srvTime = new Time(new GregorianCalendar());
		DOMOutputter converter = new DOMOutputter();
		Document domDocument = converter.output(doc);
		ESBEnvelopeESBHeader tESBEnvelopeESBHeader = new ESBEnvelopeESBHeader();
		tESBEnvelopeESBHeader.setSenderID("MDES");
		tESBEnvelopeESBHeader.setSrvDate(tSrvDate);
		tESBEnvelopeESBHeader.setSrvTime(srvTime);
		tESBEnvelopeESBHeader.setReceiverID("LA");
		tESBEnvelopeESBHeader.setSrvOpVer("");
		if ("prem_out".equals(returnFileName))
			tESBEnvelopeESBHeader.setSrvOpName("PRMService");
		else
		if ("dupli_out".equals(returnFileName))
			tESBEnvelopeESBHeader.setSrvOpName("CLTService");
		else
		if ("aura_out".equals(returnFileName) || "appnt_out".equals(returnFileName))
		{
			tESBEnvelopeESBHeader.setSrvOpName("ValidationPolicy");
			tESBEnvelopeESBHeader.setReceiverID("AURA");
		} else
		if ("issue_out".equals(returnFileName))
			tESBEnvelopeESBHeader.setSrvOpName("NBUPLService");
		System.out.println((new StringBuilder(String.valueOf(tESBEnvelopeESBHeader.getESBRspDec()))).append("head msg~~~~~~~~~~~~~~~~~~~").toString());
		ESBEnvelopeMsgBody yESBEnvelopeMsgBody = new ESBEnvelopeMsgBody();
		org.w3c.dom.Element root = domDocument.getDocumentElement();
		MessageElement thh = new MessageElement(root);
		MessageElement _any[] = {
			thh
		};
		yESBEnvelopeMsgBody.set_any(_any);
		ESBEnvelope tESBEnvelope = new ESBEnvelope();
		tESBEnvelope.setESBHeader(tESBEnvelopeESBHeader);
		tESBEnvelope.setMsgBody(yESBEnvelopeMsgBody);
		System.out.println((new StringBuilder("-------------Soap--ESBHeader ")).append(tESBEnvelope.getESBHeader()).toString());
		System.out.println((new StringBuilder("-------------Soap--MsgBody ")).append(tESBEnvelope.getMsgBody()).toString());
		System.out.println((new StringBuilder("-------------Soap--")).append(tESBEnvelope.toString()).toString());
		ESBWebEntry trESBWebEntry = new ESBWebEntryLocator();
		ESBWebEntrySoap_PortType soap = trESBWebEntry.getESBWebEntrySoap();
		ESBEnvelopeResult gESBEnvelopeResult = soap.processMessage(tESBEnvelope);
		System.out.println(gESBEnvelopeResult.getESBHeader().getESBRspDec());
		MessageElement tResult[] = gESBEnvelopeResult.getMsgBody().get_any();
		tResult1 = tResult[0];
		System.out.println(tResult1);
		return tResult1.getAsString();
		RemoteException e;
		e;
		e.printStackTrace();
		break MISSING_BLOCK_LABEL_477;
		e;
		e.printStackTrace();
		break MISSING_BLOCK_LABEL_477;
		e;
		e.printStackTrace();
		break MISSING_BLOCK_LABEL_477;
		e;
		e.printStackTrace();
		return null;
	}

	private String doProcessByStream(org.jdom.Document doc)
	{
		return null;
	}
}
