// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MD5Util.java

package com.sinosoft.map.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.sinosoft.map.encrypt:
//			HexUtil

public class MD5Util
{

	private MD5Util()
	{
	}

	static MessageDigest getDigest()
	{
		return MessageDigest.getInstance("MD5");
		NoSuchAlgorithmException e;
		e;
		throw new RuntimeException(e);
	}

	public static byte[] md5(byte data[])
	{
		return getDigest().digest(data);
	}

	public static byte[] md5(String data)
	{
		return md5(data.getBytes());
	}

	public static String md5Hex(byte data[])
	{
		return HexUtil.toHexString(md5(data));
	}

	public static String md5Hex(String data)
	{
		return HexUtil.toHexString(md5(data));
	}
}
