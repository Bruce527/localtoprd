// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LisIDEA.java

package com.sinosoft.map.lis.encrypt;

import java.io.PrintStream;
import java.net.URLEncoder;

// Referenced classes of package com.sinosoft.map.lis.encrypt:
//			TripleDES

public class LisIDEA extends TripleDES
{

	public LisIDEA()
	{
	}

	public String encryptString(String arg)
	{
		return URLEncoder.encode(super.encryptString(arg));
		Exception ex;
		ex;
		return "";
	}

	public String encryptDBString(String arg)
		throws Exception
	{
		return super.encryptString(arg);
		Exception ex;
		ex;
		throw ex;
	}

	public String decryptString_pre(String arg)
	{
		String decryptString = super.decryptString_pre(arg);
		return decryptString;
	}

	public static void main(String args[])
	{
		LisIDEA tLisIDEA = new LisIDEA();
		System.out.println((new StringBuilder("http://localhost:2514/MetB2C/product/itemintro.jsf?arg=")).append(URLEncoder.encode("61%30%-102%82%117%-81%127%-59%-123%83%-38%-56%-98%-66%-13%-23%-66%72%-56%109%-56%54%-75%-39%")).toString());
		System.out.println(tLisIDEA.encryptString("111111111111111111"));
		System.out.println(tLisIDEA.decryptString_pre("-40|-81|-99|99|107|-13|38|-125|-40|-81|-49|99|107|-13|38|-125|4|22|119|71|96|-24|36|119|"));
	}
}
