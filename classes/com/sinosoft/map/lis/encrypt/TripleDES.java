// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TripleDES.java

package com.sinosoft.map.lis.encrypt;

import com.sinosoft.map.common.Constants;
import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;

public class TripleDES
{

	private String filePath;
	private File keyFile;
	private SecretKey key;

	public TripleDES()
	{
		filePath = PubFun.getRealPath();
		keyFile = new File((new StringBuilder(String.valueOf(filePath))).append("/sysmanage/sinosoft_metlife_secretKey").toString());
		key = null;
		try
		{
			key = Constants.key;
			if (key == null)
				key = readKey();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeySpecException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
	}

	private SecretKey generateKey()
		throws NoSuchAlgorithmException
	{
		KeyGenerator keygen = KeyGenerator.getInstance("DESede");
		keygen.init(112);
		return keygen.generateKey();
	}

	private SecretKey readKey()
		throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException
	{
		DataInputStream in = new DataInputStream(new FileInputStream(keyFile));
		byte rawkey[] = new byte[(int)keyFile.length()];
		in.readFully(rawkey);
		in.close();
		DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}

	public String encryptString(String password)
	{
		String encodedPassword = password;
		try
		{
			if (password != null && !"".equals(password.trim()) && key != null)
			{
				Cipher cipher = Cipher.getInstance("DESede");
				cipher.init(1, key);
				byte cleartext[] = password.getBytes();
				byte ciphertext[] = cipher.doFinal(cleartext);
				StringBuffer buf = new StringBuffer();
				for (int i = 0; i < ciphertext.length; i++)
					buf.append((new StringBuilder(String.valueOf(Byte.toString(ciphertext[i])))).append("%").toString());

				encodedPassword = buf.toString().replace("-", "$");
			}
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch (IllegalBlockSizeException e)
		{
			e.printStackTrace();
		}
		catch (BadPaddingException e)
		{
			e.printStackTrace();
		}
		return encodedPassword;
	}

	public String decryptString_pre(String password)
	{
		String decodedPassword = null;
		if (password != null && !"".equals(password.trim()) && key != null)
		{
			password = password.replace("$", "-");
			ArrayList list = new ArrayList();
			for (StringTokenizer toker = new StringTokenizer(password, "%"); toker.hasMoreElements(); list.add(toker.nextToken()));
			byte cleartext[] = new byte[list.size()];
			int i = 0;
			for (Iterator iter = list.iterator(); iter.hasNext();)
			{
				String element = (String)iter.next();
				cleartext[i] = Byte.parseByte(element);
				i++;
			}

			try
			{
				Cipher cipher = Cipher.getInstance("DESede");
				cipher.init(2, key);
				byte ciphertext[] = cipher.doFinal(cleartext);
				decodedPassword = new String(ciphertext);
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			catch (NoSuchPaddingException e)
			{
				e.printStackTrace();
			}
			catch (InvalidKeyException e)
			{
				e.printStackTrace();
			}
			catch (IllegalBlockSizeException e)
			{
				e.printStackTrace();
			}
			catch (BadPaddingException e)
			{
				e.printStackTrace();
			}
		}
		return decodedPassword;
	}

	public static void main(String args[])
	{
		TripleDES tTripleDES = new TripleDES();
	}
}
