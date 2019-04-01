// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ESBEnvelopeResult.java

package com.sinosoft.banklns.lnsmodel.webservice.eai;

import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.webservice.eai:
//			ESBEnvelopeResultESBHeader, ESBEnvelopeResultMsgBody

public class ESBEnvelopeResult
	implements Serializable
{

	private ESBEnvelopeResultESBHeader ESBHeader;
	private ESBEnvelopeResultMsgBody msgBody;
	private Object __equalsCalc;
	private boolean __hashCodeCalc;
	private static TypeDesc typeDesc;

	public ESBEnvelopeResult()
	{
		__equalsCalc = null;
		__hashCodeCalc = false;
	}

	public ESBEnvelopeResult(ESBEnvelopeResultESBHeader ESBHeader, ESBEnvelopeResultMsgBody msgBody)
	{
		__equalsCalc = null;
		__hashCodeCalc = false;
		this.ESBHeader = ESBHeader;
		this.msgBody = msgBody;
	}

	public ESBEnvelopeResultESBHeader getESBHeader()
	{
		return ESBHeader;
	}

	public void setESBHeader(ESBEnvelopeResultESBHeader ESBHeader)
	{
		this.ESBHeader = ESBHeader;
	}

	public ESBEnvelopeResultMsgBody getMsgBody()
	{
		return msgBody;
	}

	public void setMsgBody(ESBEnvelopeResultMsgBody msgBody)
	{
		this.msgBody = msgBody;
	}

	public synchronized boolean equals(Object obj)
	{
		if (!(obj instanceof ESBEnvelopeResult))
			return false;
		ESBEnvelopeResult other = (ESBEnvelopeResult)obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null)
		{
			return __equalsCalc == obj;
		} else
		{
			__equalsCalc = obj;
			boolean _equals = (ESBHeader == null && other.getESBHeader() == null || ESBHeader != null && ESBHeader.equals(other.getESBHeader())) && (msgBody == null && other.getMsgBody() == null || msgBody != null && msgBody.equals(other.getMsgBody()));
			__equalsCalc = null;
			return _equals;
		}
	}

	public synchronized int hashCode()
	{
		if (__hashCodeCalc)
			return 0;
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getESBHeader() != null)
			_hashCode += getESBHeader().hashCode();
		if (getMsgBody() != null)
			_hashCode += getMsgBody().hashCode();
		__hashCodeCalc = false;
		return _hashCode;
	}

	public static TypeDesc getTypeDesc()
	{
		return typeDesc;
	}

	public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
	{
		return new BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
	{
		return new BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

	static 
	{
		typeDesc = new TypeDesc(com/sinosoft/banklns/lnsmodel/webservice/eai/ESBEnvelopeResult, true);
		typeDesc.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">ESBEnvelopeResult"));
		ElementDesc elemField = new ElementDesc();
		elemField.setFieldName("ESBHeader");
		elemField.setXmlName(new QName("", "ESBHeader"));
		elemField.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">>ESBEnvelopeResult>ESBHeader"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new ElementDesc();
		elemField.setFieldName("msgBody");
		elemField.setXmlName(new QName("", "MsgBody"));
		elemField.setXmlType(new QName(EAIPropertiesFromDB.ESBEnvelope_ns, ">>ESBEnvelopeResult>MsgBody"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}
}
