// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PersonFunction.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPAddressDB;
import com.sinosoft.banklns.lis.db.LNPPersonDB;
import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
import com.sinosoft.banklns.lis.vschema.LNPPersonSet;

public class PersonFunction
{

	public PersonFunction()
	{
	}

	public LNPPersonSchema getLnpPersonByCustomerId(String customerid)
	{
		LNPPersonSchema aLNPPersonSchema = new LNPPersonSchema();
		try
		{
			LNPPersonDB lnpPersonDB = new LNPPersonDB();
			aLNPPersonSchema = new LNPPersonSchema();
			lnpPersonDB.setCustomerId(customerid);
			LNPPersonSet personSet = lnpPersonDB.query();
			if (personSet.size() > 0)
				aLNPPersonSchema = personSet.get(1);
			else
				aLNPPersonSchema = null;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			aLNPPersonSchema = null;
		}
		return aLNPPersonSchema;
	}

	public LNPAddressSchema getLnpAddrByCustomerId(String customerid)
	{
		LNPAddressDB lnpAddressDB = new LNPAddressDB();
		LNPAddressSchema aLNPAddressSchema = new LNPAddressSchema();
		lnpAddressDB.setCustomerId(customerid);
		LNPAddressSet addressSet = lnpAddressDB.query();
		if (addressSet.size() > 0)
			aLNPAddressSchema = addressSet.get(1);
		else
			aLNPAddressSchema = null;
		return aLNPAddressSchema;
	}

	public LNPPersonSchema getCustomerExist(String name, String sex, String birthday, String idtype, String idno)
	{
		LNPPersonSchema rePersonSch = new LNPPersonSchema();
		try
		{
			LNPPersonDB db = new LNPPersonDB();
			db.setName(name);
			db.setSex(sex);
			db.setBirthday(birthday);
			db.setIDType(idtype);
			db.setIDNo(idno);
			LNPPersonSet set = db.query();
			if (set.size() > 0)
				rePersonSch = set.get(1);
			else
				rePersonSch = null;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			rePersonSch = null;
		}
		return rePersonSch;
	}
}
