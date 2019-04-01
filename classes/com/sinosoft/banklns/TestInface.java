// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TestInface.java

package com.sinosoft.banklns;

import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.lis.pubfun.PubFun;
import com.sinosoft.banklns.lis.pubfun.XMLByJDOM;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelope;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeESBHeader;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeMsgBody;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResult;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBEnvelopeResultESBHeader;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntry;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntryLocator;
import com.sinosoft.banklns.lnsmodel.webservice.eai.ESBWebEntrySoap_PortType;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.Time;
import org.jdom.Element;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.Document;

public class TestInface
{

	public TestInface()
	{
	}

	public static void main(String args[])
		throws Exception
	{
		XMLByJDOM tXMLByJDOM = new XMLByJDOM();
		FDate fDate = new FDate();
		java.util.Date tSrvDate = fDate.getDate(PubFun.getCurrentDate());
		Time srvTime = new Time(PubFun.getCurrentTime());
		String filePath = "D:\\";
		String xmlFile = (new StringBuilder(String.valueOf(filePath))).append("requestForQuestion1.xml").toString();
		xmlFile = (new StringBuilder(String.valueOf(filePath))).append("out_test.xml").toString();
		org.jdom.Document doc = tXMLByJDOM.loadXMLFileByJDOM(xmlFile);
		System.out.println(tXMLByJDOM.transformXMLToString(doc));
		DOMOutputter converter = new DOMOutputter();
		Document domDocument = converter.output(doc);
		ESBEnvelopeESBHeader tESBEnvelopeESBHeader = new ESBEnvelopeESBHeader();
		tESBEnvelopeESBHeader.setSenderID("MDES");
		tESBEnvelopeESBHeader.setSrvDate(tSrvDate);
		tESBEnvelopeESBHeader.setSrvTime(srvTime);
		tESBEnvelopeESBHeader.setReceiverID("LA");
		tESBEnvelopeESBHeader.setSrvOpName("calPremiumservice");
		ESBEnvelopeMsgBody yESBEnvelopeMsgBody = new ESBEnvelopeMsgBody();
		MessageElement thh = new MessageElement(domDocument.getDocumentElement());
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
		Element root = doc.getRootElement();
		Element errorN = root.getChild("ERROR");
		Element reasonN = errorN.getChild("item").getChild("REASON");
		List errorItemNList = reasonN.getChildren();
		String message = "";
		for (Iterator iterator = errorItemNList.iterator(); iterator.hasNext();)
		{
			Element e = (Element)iterator.next();
			String valiReason = e.getChild("ERRORDESC").getText();
			message = (new StringBuilder(String.valueOf(message))).append(valiReason).append("</br>").toString();
		}

		System.out.println(message);
	}
}
