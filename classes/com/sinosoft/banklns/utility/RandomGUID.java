// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RandomGUID.java

package com.sinosoft.banklns.utility;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.*;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RandomGUID
{

	protected final Log logger;
	public String valueBeforeMD5;
	public String valueAfterMD5;
	private static Random myRand;
	private static SecureRandom mySecureRand;
	private static String s_id;
	private static final int PAD_BELOW = 16;
	private static final int TWO_BYTES = 255;

	public RandomGUID()
	{
		logger = LogFactory.getLog(getClass());
		valueBeforeMD5 = "";
		valueAfterMD5 = "";
		getRandomGUID(false);
	}

	public RandomGUID(boolean secure)
	{
		logger = LogFactory.getLog(getClass());
		valueBeforeMD5 = "";
		valueAfterMD5 = "";
		getRandomGUID(secure);
	}

	private void getRandomGUID(boolean secure)
	{
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
		try
		{
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e)
		{
			logger.error((new StringBuilder("Error: ")).append(e).toString());
		}
		try
		{
			long time = System.currentTimeMillis();
			long rand = 0L;
			if (secure)
				rand = mySecureRand.nextLong();
			else
				rand = myRand.nextLong();
			sbValueBeforeMD5.append(s_id);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));
			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());
			byte array[] = md5.digest();
			StringBuffer sb = new StringBuffer(32);
			for (int j = 0; j < array.length; j++)
			{
				int b = array[j] & 0xff;
				if (b < 16)
					sb.append('0');
				sb.append(Integer.toHexString(b));
			}

			valueAfterMD5 = sb.toString();
		}
		catch (Exception e)
		{
			logger.error((new StringBuilder("Error:")).append(e).toString());
		}
	}

	public String toString()
	{
		String raw = valueAfterMD5.toUpperCase();
		StringBuffer sb = new StringBuffer(64);
		sb.append(raw.substring(0, 8));
		sb.append("-");
		sb.append(raw.substring(8, 12));
		sb.append("-");
		sb.append(raw.substring(12, 16));
		sb.append("-");
		sb.append(raw.substring(16, 20));
		sb.append("-");
		sb.append(raw.substring(20));
		return sb.toString();
	}

	public static void main(String args[])
	{
		for (int i = 0; i < 1; i++)
		{
			RandomGUID myGUID = new RandomGUID();
			System.out.println((new StringBuilder("RandomGUID=")).append(myGUID.toString()).toString());
		}

	}

	static 
	{
		mySecureRand = new SecureRandom();
		long secureInitializer = mySecureRand.nextLong();
		myRand = new Random(secureInitializer);
		try
		{
			s_id = InetAddress.getLocalHost().toString();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}
}
