// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EncoderMD5.java

package com.sinosoft.map.ec.utility;

import com.sinosoft.map.common.logs.ErrorsLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncoderMD5
{

	public EncoderMD5()
	{
	}

	public static String encodeByMD5(String str)
	{
		String securityStr = "";
		try
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("utf-8"));
			byte b[] = md5.digest();
			StringBuffer buff = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++)
			{
				int i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buff.append("0");
				buff.append(Integer.toHexString(i));
			}

			securityStr = buff.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			ErrorsLog.log((new StringBuilder("Encoder:encodeByMD5:")).append(e.getMessage()).toString());
		}
		catch (UnsupportedEncodingException ex)
		{
			ErrorsLog.log((new StringBuilder("Encoder:encodeByMD5:")).append(ex.getMessage()).toString());
		}
		return securityStr;
	}
}
