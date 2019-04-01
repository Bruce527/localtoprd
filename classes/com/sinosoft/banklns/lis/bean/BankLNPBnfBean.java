// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankLNPBnfBean.java

package com.sinosoft.banklns.lis.bean;

import com.sinosoft.banklns.lis.db.LNPBnfDB;
import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
import java.io.PrintStream;

// Referenced classes of package com.sinosoft.banklns.lis.bean:
//			BankBeanBasic

public class BankLNPBnfBean extends BankBeanBasic
{

	private LNPBnfSchema schema;
	private String gender;
	private String idType;
	private String relationToInsured;
	private String benefitRate;
	private String IDVaility;
	private String birthday;
	private String bnfNative;
	private boolean isValidate;

	public BankLNPBnfBean()
	{
		schema = new LNPBnfSchema();
	}

	public static void main(String args[])
	{
		BankLNPBnfBean bean = new BankLNPBnfBean();
		LNPBnfDB db = new LNPBnfDB();
		db.setBnfId("00000000000000000300");
		bean.schema = db.query().get(1);
		System.out.println(bean.isValidate());
	}

	public boolean isValidate()
	{
		System.out.println(schema.getBnfName() != null && !"".equals(schema.getBnfName().trim()));
		System.out.println(schema.getRelationToInsured() != null && !"".equals(schema.getRelationToInsured().trim()) && !"-1".equals(schema.getRelationToInsured().trim()));
		System.out.println(schema.getBenefitRate() > 0.0D);
		if (schema.getBnfName() != null && !"".equals(schema.getBnfName().trim()) || schema.getRelationToInsured() != null && !"".equals(schema.getRelationToInsured().trim()) && !"-1".equals(schema.getRelationToInsured().trim()) || schema.getBenefitRate() > 0.0D)
			isValidate = true;
		else
			isValidate = false;
		return isValidate;
	}

	public void setValidate(boolean isValidate)
	{
		this.isValidate = isValidate;
	}

	public LNPBnfSchema getSchema()
	{
		return schema;
	}

	public void setSchema(LNPBnfSchema schema)
	{
		this.schema = schema;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
	}

	public String getRelationToInsured()
	{
		return relationToInsured;
	}

	public void setRelationToInsured(String relationToInsured)
	{
		this.relationToInsured = relationToInsured;
	}

	public String getBenefitRate()
	{
		return benefitRate;
	}

	public void setBenefitRate(String benefitRate)
	{
		this.benefitRate = benefitRate;
	}

	public String getIDVaility()
	{
		return formatDate(schema.getIDValidity(), "YYYYMMDD");
	}

	public void setIDVaility(String iDVaility)
	{
		IDVaility = formatDate(iDVaility, "YYYY-MM-DD");
		schema.setIDValidity(IDVaility);
	}

	public String getBirthday()
	{
		return formatDate(schema.getBnfBirthday(), "YYYYMMDD");
	}

	public void setBirthday(String birthday)
	{
		this.birthday = formatDate(birthday, "YYYY-MM-DD");
		schema.setBnfBirthday(this.birthday);
	}

	private String formatDate(String srcDate, String formate)
	{
		String tDate = srcDate;
		if (srcDate != null && !"".equals(srcDate.trim()))
			if (formate.indexOf("-") > 0)
				tDate = (new StringBuilder(String.valueOf(srcDate.substring(0, 4)))).append("-").append(srcDate.substring(4, 6)).append("-").append(srcDate.substring(6, 8)).toString();
			else
				tDate = srcDate.replaceAll("-", "");
		return tDate;
	}

	public String getBnfNative()
	{
		return schema.getNativePlace();
	}

	public void setBnfNative(String bnfNative)
	{
		this.bnfNative = bnfNative;
		schema.setNativePlace(bnfNative);
	}
}
