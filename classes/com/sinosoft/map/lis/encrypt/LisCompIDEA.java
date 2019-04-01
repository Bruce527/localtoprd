// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LisCompIDEA.java

package com.sinosoft.map.lis.encrypt;

import com.sinosoft.map.lis.encrypt.security.IDEA;
import java.io.PrintStream;

public final class LisCompIDEA
{

	final String mCipherKeyStr = "12dc427f09a81e293d43db3b2378491d";
	final int mStrLen = 8;

	public LisCompIDEA()
	{
		try
		{
			jbInit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public String encryptString(String fullPlainStr)
	{
		int length = fullPlainStr.length();
		int times = length / 8;
		if (length % 8 == 0)
			times--;
		String eightStr = "";
		String tString = "";
		String finalString = "";
		for (int i = 0; i <= times; i++)
		{
			if (i == times)
			{
				eightStr = fullPlainStr.substring(i * 8);
				tString = eightLenEncryptString(eightStr);
				finalString = (new StringBuilder(String.valueOf(finalString))).append(tString).toString();
				return finalString;
			}
			eightStr = fullPlainStr.substring(i * 8, (i + 1) * 8);
			tString = eightLenEncryptString(eightStr);
			finalString = (new StringBuilder(String.valueOf(finalString))).append(tString).toString();
		}

		return "";
	}

	public String encryptStringAES(String plainStr)
	{
		String tplainStr = "";
		int len = plainStr.length();
		if (len <= 8)
		{
			for (int i = 0; i < len; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(plainStr.charAt(i)).toString();

			for (int i = 0; i < 8 - len; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(" ").toString();

		} else
		{
			for (int i = 0; i < 8; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(plainStr.charAt(i)).toString();

		}
		System.out.println((new StringBuilder("tplainStr len:")).append(tplainStr.length()).toString());
		String hexPlainStr = stringToHexString(tplainStr);
		byte key[] = fromString("12dc427f09a81e293d43db3b2378491d");
		byte plain[] = fromString(hexPlainStr);
		IDEA idea = new IDEA(key);
		byte encP[] = new byte[plain.length];
		idea.encrypt(plain, encP);
		String hexEncryptString = toString(encP);
		return hexEncryptString;
	}

	public String eightLenEncryptString(String plainStr)
	{
		String tplainStr = "";
		int len = plainStr.length();
		if (len <= 8)
		{
			for (int i = 0; i < len; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(plainStr.charAt(i)).toString();

			for (int i = 0; i < 8 - len; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(" ").toString();

		} else
		{
			for (int i = 0; i < 8; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(plainStr.charAt(i)).toString();

		}
		String hexPlainStr = stringToHexString(tplainStr);
		byte key[] = fromString("12dc427f09a81e293d43db3b2378491d");
		byte plain[] = fromString(hexPlainStr);
		IDEA idea = new IDEA(key);
		byte encP[] = new byte[plain.length];
		idea.encrypt(plain, encP);
		String hexEncryptString = toString(encP);
		return hexEncryptString;
	}

	public String decryptString_pre(String encryptStr)
	{
		String tencryptStr = "";
		int len = encryptStr.length();
		if (len <= 8)
		{
			for (int i = 0; i < len; i++)
				tencryptStr = (new StringBuilder(String.valueOf(tencryptStr))).append(encryptStr.charAt(i)).toString();

			for (int i = 1; i < 8 - len; i++)
				tencryptStr = (new StringBuilder(String.valueOf(tencryptStr))).append(" ").toString();

		} else
		{
			for (int i = 0; i < 8; i++)
				tencryptStr = (new StringBuilder(String.valueOf(tencryptStr))).append(encryptStr.charAt(i)).toString();

		}
		String hexEncryptStr = stringToHexString(tencryptStr);
		byte key[] = fromString("12dc427f09a81e293d43db3b2378491d");
		IDEA idea = new IDEA(key);
		byte encP[] = fromString(hexEncryptStr);
		byte decC[] = new byte[encP.length];
		idea.decrypt(encP, decC);
		String hexDecryptStr = toString(decC);
		return hexStringToString(hexDecryptStr);
	}

	public String decryptString(String fullEncryptedStr)
	{
		int length = fullEncryptedStr.length();
		int times = length / 16;
		String tString = "";
		String sixteenLenString = "";
		String finalString = "";
		for (int i = 0; i < times; i++)
		{
			sixteenLenString = fullEncryptedStr.substring(i * 16, (i + 1) * 16);
			tString = decryptSixteenLenString(sixteenLenString);
			finalString = (new StringBuilder(String.valueOf(finalString))).append(tString).toString();
		}

		return finalString;
	}

	public String decryptSixteenLenString(String encryptedStr)
	{
		String hexEncryptedStr = encryptedStr;
		byte key[] = fromString("12dc427f09a81e293d43db3b2378491d");
		IDEA idea = new IDEA(key);
		byte encP[] = fromString(hexEncryptedStr);
		byte decC[] = new byte[encP.length];
		idea.decrypt(encP, decC);
		String hexDecryptStr = toString(decC);
		return hexStringToString(hexDecryptStr);
	}

	private static String stringToHexString(String srcString)
	{
		String resultString = "";
		int srcLen = srcString.length();
		for (int pos = 0; pos < srcLen; pos++)
		{
			byte b = (byte)srcString.charAt(pos);
			int hexValue = b & 0xf;
			resultString = (new StringBuilder(String.valueOf(resultString))).append(hexToAscii(hexValue)).toString();
			hexValue = b >> 4 & 0xf;
			resultString = (new StringBuilder(String.valueOf(resultString))).append(hexToAscii(hexValue)).toString();
		}

		return resultString;
	}

	private static String hexStringToString(String hexString)
	{
		String resultString = "";
		int hexLen = hexString.length();
		for (int pos = 0; pos < hexLen; pos += 2)
		{
			char c1 = hexString.charAt(pos);
			char c2 = hexString.charAt(pos + 1);
			int hexvalue1 = asciiToHex(c1);
			int hexvalue2 = asciiToHex(c2);
			char c = (char)(hexvalue1 | hexvalue2 << 4);
			resultString = (new StringBuilder(String.valueOf(resultString))).append(c).toString();
		}

		return resultString.trim();
	}

	private static byte[] fromString(String inHex)
	{
		int len = inHex.length();
		int pos = 0;
		byte buffer[] = new byte[(len + 1) / 2];
		if (len % 2 == 1)
		{
			buffer[0] = (byte)asciiToHex(inHex.charAt(0));
			pos = 1;
			len--;
		}
		int ptr = pos;
		for (; len > 0; len -= 2)
			buffer[pos++] = (byte)(asciiToHex(inHex.charAt(ptr++)) << 4 | asciiToHex(inHex.charAt(ptr++)));

		return buffer;
	}

	private static String toString(byte buffer[])
	{
		StringBuffer returnBuffer = new StringBuffer();
		int pos = 0;
		for (int len = buffer.length; pos < len; pos++)
			returnBuffer.append(hexToAscii(buffer[pos] >>> 4 & 0xf)).append(hexToAscii(buffer[pos] & 0xf));

		return returnBuffer.toString();
	}

	private static int asciiToHex(char c)
	{
		if (c >= 'a' && c <= 'f')
			return (c - 97) + 10;
		if (c >= 'A' && c <= 'F')
			return (c - 65) + 10;
		if (c >= '0' && c <= '9')
			return c - 48;
		else
			throw new Error("ascii to hex failed");
	}

	private static char hexToAscii(int h)
	{
		if (h >= 10 && h <= 15)
			return (char)(65 + (h - 10));
		if (h >= 0 && h <= 9)
			return (char)(48 + h);
		else
			throw new Error("hex to ascii failed");
	}

	public static void main(String args[])
	{
	}

	private void jbInit()
		throws Exception
	{
	}
}
