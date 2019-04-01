// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SinoSoftLisIDEA.java

package com.sinosoft.map.lis.encrypt;

import com.sinosoft.map.lis.encrypt.security.IDEA;
import java.util.ArrayList;

public class SinoSoftLisIDEA
{

	String mCipherKeyStr;
	int mStrLen;

	public SinoSoftLisIDEA()
	{
		mCipherKeyStr = "12dc427f09a81e293d43db3b2378491d";
		mStrLen = 8;
	}

	public String encryptString(String plainStr)
	{
		String tplainStr = "";
		int len = plainStr.length();
		ArrayList arrStr = new ArrayList();
		if (len <= mStrLen)
		{
			for (int i = 0; i < len; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(plainStr.charAt(i)).toString();

			for (int i = 0; i < mStrLen - len; i++)
				tplainStr = (new StringBuilder(String.valueOf(tplainStr))).append(" ").toString();

			arrStr.add(0, tplainStr);
		} else
		{
			int groupCount = 0;
			int modValue = 0;
			modValue = len % mStrLen;
			if (modValue != 0)
				groupCount = len / mStrLen + 1;
			else
				groupCount = len / mStrLen;
			for (int iLoop = 0; iLoop < groupCount; iLoop++)
			{
				String temp_plainStr = "";
				if (iLoop < groupCount - 1)
				{
					for (int i = iLoop * mStrLen; i < (iLoop + 1) * mStrLen; i++)
						temp_plainStr = (new StringBuilder(String.valueOf(temp_plainStr))).append(plainStr.charAt(i)).toString();

				} else
				{
					temp_plainStr = plainStr.substring(iLoop * mStrLen);
					if (modValue != 0)
					{
						for (int jLoop = modValue + 1; jLoop <= mStrLen; jLoop++)
							temp_plainStr = (new StringBuilder(String.valueOf(temp_plainStr))).append(" ").toString();

					}
				}
				arrStr.add(iLoop, temp_plainStr);
			}

		}
		String hexEncryptString = "";
		byte key[] = fromString(mCipherKeyStr);
		IDEA idea = new IDEA(key);
		for (int kLoop = 0; kLoop < arrStr.size(); kLoop++)
		{
			String enceyptStr = (String)arrStr.get(kLoop);
			String hexPlainStr = stringToHexString(enceyptStr);
			byte plain[] = fromString(hexPlainStr);
			byte encP[] = new byte[plain.length];
			idea.encrypt(plain, encP);
			hexEncryptString = (new StringBuilder(String.valueOf(hexEncryptString))).append(toString(encP)).toString();
		}

		return hexEncryptString;
	}

	public String decryptString_pre(String encryptStr)
	{
		int len = encryptStr.length();
		ArrayList arrStr = new ArrayList();
		if (len <= mStrLen * 2)
		{
			String tencryptStr = "";
			for (int i = 0; i < len; i++)
				tencryptStr = (new StringBuilder(String.valueOf(tencryptStr))).append(encryptStr.charAt(i)).toString();

			for (int i = 0; i < mStrLen * 2 - len; i++)
				tencryptStr = (new StringBuilder(String.valueOf(tencryptStr))).append(" ").toString();

			arrStr.add(0, tencryptStr);
		} else
		{
			int groupCount = 0;
			int modValue = 0;
			modValue = len % (mStrLen * 2);
			if (modValue != 0)
				groupCount = len / (mStrLen * 2) + 1;
			else
				groupCount = len / (mStrLen * 2);
			for (int iLoop = 0; iLoop < groupCount; iLoop++)
			{
				String temp_tencryptStr = "";
				if (iLoop < groupCount - 1)
				{
					for (int i = iLoop * (mStrLen * 2); i < (iLoop + 1) * (mStrLen * 2); i++)
						temp_tencryptStr = (new StringBuilder(String.valueOf(temp_tencryptStr))).append(encryptStr.charAt(i)).toString();

				} else
				{
					temp_tencryptStr = encryptStr.substring(iLoop * (mStrLen * 2));
					if (modValue != 0)
					{
						for (int jLoop = modValue + 1; jLoop <= mStrLen * 2; jLoop++)
							temp_tencryptStr = (new StringBuilder(String.valueOf(temp_tencryptStr))).append(" ").toString();

					}
				}
				arrStr.add(iLoop, temp_tencryptStr);
			}

		}
		byte key[] = fromString(mCipherKeyStr);
		IDEA idea = new IDEA(key);
		String hexDecryptStr = "";
		for (int kLoop = 0; kLoop < arrStr.size(); kLoop++)
		{
			String denceyptStr = (String)arrStr.get(kLoop);
			byte encP[] = fromString(denceyptStr);
			byte decC[] = new byte[encP.length];
			idea.decrypt(encP, decC);
			hexDecryptStr = (new StringBuilder(String.valueOf(hexDecryptStr))).append(toString(decC)).toString();
		}

		return hexStringToString(hexDecryptStr);
	}

	public String decryptString(String encryptStr)
	{
		String hexEncryptStr = encryptStr;
		byte key[] = fromString(mCipherKeyStr);
		IDEA idea = new IDEA(key);
		byte encP[] = fromString(hexEncryptStr);
		byte decC[] = new byte[encP.length];
		idea.decrypt(encP, decC);
		String hexDecryptStr = toString(decC);
		return hexStringToString(hexDecryptStr);
	}

	private String stringToHexString(String srcString)
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

	private String hexStringToString(String hexString)
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

	private byte[] fromString(String inHex)
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

	private String toString(byte buffer[])
	{
		StringBuffer returnBuffer = new StringBuffer();
		int pos = 0;
		for (int len = buffer.length; pos < len; pos++)
			returnBuffer.append(hexToAscii(buffer[pos] >>> 4 & 0xf)).append(hexToAscii(buffer[pos] & 0xf));

		return returnBuffer.toString();
	}

	private int asciiToHex(char c)
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

	private char hexToAscii(int h)
	{
		if (h >= 10 && h <= 15)
			return (char)(65 + (h - 10));
		if (h >= 0 && h <= 9)
			return (char)(48 + h);
		else
			throw new Error("hex to ascii failed");
	}
}
