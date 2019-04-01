// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WebConfig.java

package com.sinosoft.map.common.config;


// Referenced classes of package com.sinosoft.map.common.config:
//			Configurator

public class WebConfig
{

	private String _webname;
	private String _logo;
	private String _banner;
	private String _icp;
	private String _comment;

	public WebConfig()
	{
	}

	public void setWebname(String webname)
	{
		_webname = webname;
	}

	public String getWebname()
	{
		return _webname;
	}

	public void setLogo(String logo)
	{
		_logo = logo;
	}

	public String getLogo()
	{
		return _logo;
	}

	public void setBanner(String banner)
	{
		_banner = banner;
	}

	public String getBanner()
	{
		return _banner;
	}

	public void setIcp(String icp)
	{
		_icp = icp;
	}

	public String getIcp()
	{
		return _icp;
	}

	public void setComment(String comment)
	{
		_comment = comment;
	}

	public String getComment()
	{
		return _comment;
	}

	public void loadWebConfig()
	{
		Configurator conf = new Configurator();
		conf.loadWebConfig(this);
	}

	public void updateWebConfig()
	{
		Configurator conf = new Configurator();
		conf.updateWebConfig(this);
	}
}
