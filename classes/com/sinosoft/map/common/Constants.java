// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Constants.java

package com.sinosoft.map.common;

import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.*;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Constants
	implements Serializable
{

	public static final String OUT_SUCCESS = "success";
	public static final String OUT_FAILURE = "failure";
	public static final String OUT_ERROR = "error";
	public static final String OUT_FATAL = "fatal";
	public static final String PATH_CONNECTION = "/WEB-INF/config/dbconn/dbconnection.xml";
	public static final String DATABASE_SYSFRAME = "hasl";
	public static final String BUNDLE_PROGRAM = "com.sinosoft.map.international.resource.programresource";
	public static final String BUNDLE_INNER = "com.sinosoft.map.international.resource.innerresource";
	public static final String BUNDLE_OUTER = "com.sinosoft.map.international.resource.outerresource";
	public static final String BUNDLE_INNERMESSAGE = "com.sinosoft.map.international.message.innermessage";
	public static final String BUNDLE_OUTERMESSAGE = "com.sinosoft.map.international.message.outermessage";
	public static final String VISITOR_KEY = "webVisitor";
	public static final String GROUP_ADMIN = "admin";
	public static final String GROUP_USER = "user";
	public static final String PATH_ERRORSLOG = "/logs/errorslog";
	public static final String PATH_VISITORLOG = "/logs/visitorlog";
	public static final String PATH_WEBVISITORLOG = "/logs/webvisitorlog";
	public static final String PATH_VISITLOG = "/logs/visitlog";
	public static final String PATH_APPCONFIG = "/WEB-INF/config/app-config.xml";
	public static final String PATH_ACCESSAUTH = "/WEB-INF/config/common/accessauth.xml";
	public static final String PATH_DISACCESS = "/WEB-INF/config/common/disaccess.xml";
	public static final String PATH_TRAN28a_XML = "/templete/tran28a.xml";
	public static final String PATH_TRAN28b_XML = "/templete/tran28b.xml";
	public static final String PATH_TRAN28f_XML = "/templete/tran28f.xml";
	public static final String PATH_TRAN28g_XML = "/templete/tran28g.xml";
	private static final File keyFile = new File((new StringBuilder(String.valueOf(PubFun.getRealPath()))).append("/sysmanage/sinosoft_metlife_secretKey").toString());
	public static SecretKey key = readKey();

	public Constants()
	{
	}

	private static SecretKey readKey()
	{
		System.out.println("��ȡkey");
		if (key != null)
			return key;
		DataInputStream in = new DataInputStream(new FileInputStream(keyFile));
		byte rawkey[] = new byte[(int)keyFile.length()];
		in.readFully(rawkey);
		in.close();
		DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		key = keyfactory.generateSecret(keyspec);
		return key;
		Exception ex;
		ex;
		return null;
	}

}
