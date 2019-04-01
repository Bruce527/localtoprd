// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EncryptURL.java

package com.sinosoft.map.utility;

import com.sinosoft.map.lis.encrypt.LisIDEA;

public class EncryptURL
{

	private String url;

	public EncryptURL()
	{
		url = "";
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		try
		{
			this.url = url;
			if (url != null && !"".equals(url))
			{
				int splitIndex = url.indexOf("?");
				if (splitIndex > 0)
				{
					String urlArr[] = new String[2];
					urlArr[0] = url.substring(0, splitIndex);
					urlArr[1] = url.substring(splitIndex + 1);
					LisIDEA tLisIDEA = new LisIDEA();
					this.url = (new StringBuilder(String.valueOf(urlArr[0]))).append("?arg=").append(tLisIDEA.encryptString(urlArr[1])).toString();
				} else
				{
					this.url = "";
				}
			} else
			{
				this.url = "";
			}
		}
		catch (Exception ex)
		{
			this.url = "";
		}
	}
}
