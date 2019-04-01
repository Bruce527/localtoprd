// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Configurator.java

package com.sinosoft.map.common.config;

import com.sinosoft.map.common.WebApplication;
import com.sinosoft.map.common.logs.ErrorsLog;
import com.sinosoft.map.ec.datamodel.DisaccessIP;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.ec.utility.XmlParser;
import java.io.PrintStream;
import java.util.*;
import org.w3c.dom.*;

// Referenced classes of package com.sinosoft.map.common.config:
//			WebConfig

public class Configurator
{

	public Configurator()
	{
	}

	public Map loadDisplay()
	{
		Map displays = new HashMap(7);
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element display = (Element)root.getElementsByTagName("display").item(0);
			Boolean register = Boolean.valueOf(display.getElementsByTagName("register").item(0).getTextContent().trim());
			Boolean login = Boolean.valueOf(display.getElementsByTagName("login").item(0).getTextContent().trim());
			Boolean emailRegister = Boolean.valueOf(display.getElementsByTagName("email-register").item(0).getTextContent().trim());
			Boolean validateRegister = Boolean.valueOf(display.getElementsByTagName("validate-register").item(0).getTextContent().trim());
			Boolean validateLogin = Boolean.valueOf(display.getElementsByTagName("validate-login").item(0).getTextContent().trim());
			Boolean upload = Boolean.valueOf(display.getElementsByTagName("upload").item(0).getTextContent().trim());
			Boolean webStatistics = Boolean.valueOf(display.getElementsByTagName("webStatistics").item(0).getTextContent().trim());
			displays.put("register", register);
			System.out.println((new StringBuilder()).append(login).append("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk").toString());
			displays.put("login", login);
			displays.put("emailRegister", emailRegister);
			displays.put("validateRegister", validateRegister);
			displays.put("validateLogin", validateLogin);
			displays.put("upload", upload);
			displays.put("webStatistics", webStatistics);
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadDisplay:")).append(e.getMessage()).toString());
		}
		return displays;
	}

	public void updateDisplay(Map displays)
	{
		Boolean register = (Boolean)displays.get("register");
		Boolean login = (Boolean)displays.get("login");
		Boolean emailRegister = (Boolean)displays.get("emailRegister");
		Boolean validateRegister = (Boolean)displays.get("validateRegister");
		Boolean validateLogin = (Boolean)displays.get("validateLogin");
		Boolean upload = (Boolean)displays.get("upload");
		Boolean webStatistics = (Boolean)displays.get("webStatistics");
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element dis = (Element)root.getElementsByTagName("display").item(0);
			if (register != null)
				dis.getElementsByTagName("register").item(0).setTextContent(String.valueOf(register));
			if (login != null)
				dis.getElementsByTagName("login").item(0).setTextContent(String.valueOf(login));
			if (emailRegister != null)
				dis.getElementsByTagName("email-register").item(0).setTextContent(String.valueOf(emailRegister));
			if (validateRegister != null)
				dis.getElementsByTagName("validate-register").item(0).setTextContent(String.valueOf(validateRegister));
			if (validateLogin != null)
				dis.getElementsByTagName("validate-login").item(0).setTextContent(String.valueOf(validateLogin));
			if (upload != null)
				dis.getElementsByTagName("upload").item(0).setTextContent(String.valueOf(upload));
			if (webStatistics != null)
				dis.getElementsByTagName("webStatistics").item(0).setTextContent(String.valueOf(webStatistics));
			XmlParser.saveDocument(doc, getAppConfig());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ErrorsLog.log((new StringBuilder("Exception:Configurator:updateDisplay:")).append(e.getMessage()).toString());
		}
	}

	public Map loadEmailConfig()
	{
		Map emailConfig = new HashMap(12);
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element email = (Element)root.getElementsByTagName("email-config").item(0);
			String serverType = email.getElementsByTagName("server-type").item(0).getTextContent().trim();
			String serverSend = email.getElementsByTagName("server-send").item(0).getTextContent().trim();
			String serverReceive = email.getElementsByTagName("server-receive").item(0).getTextContent().trim();
			String portSmtp = email.getElementsByTagName("port-smtp").item(0).getTextContent().trim();
			String portPop = email.getElementsByTagName("port-pop").item(0).getTextContent().trim();
			String isSSLSmtp = email.getElementsByTagName("is-ssl-smtp").item(0).getTextContent().trim();
			String isSSLPop = email.getElementsByTagName("is-ssl-pop").item(0).getTextContent().trim();
			String portSSLSmtp = email.getElementsByTagName("port-ssl-smtp").item(0).getTextContent().trim();
			String portSSLPop = email.getElementsByTagName("port-ssl-pop").item(0).getTextContent().trim();
			String address = email.getElementsByTagName("address").item(0).getTextContent().trim();
			String user = email.getElementsByTagName("user").item(0).getTextContent().trim();
			String password = email.getElementsByTagName("password").item(0).getTextContent().trim();
			emailConfig.put("serverType", serverType);
			emailConfig.put("serverSend", serverSend);
			emailConfig.put("serverReceive", serverReceive);
			emailConfig.put("portSmtp", portSmtp);
			emailConfig.put("portPop", portPop);
			emailConfig.put("isSSLSmtp", isSSLSmtp);
			emailConfig.put("isSSLPop", isSSLPop);
			emailConfig.put("portSSLSmtp", portSSLSmtp);
			emailConfig.put("portSSLPop", portSSLPop);
			emailConfig.put("address", address);
			emailConfig.put("user", user);
			emailConfig.put("password", password);
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadEmailConfig:")).append(e.getMessage()).toString());
		}
		return emailConfig;
	}

	public void updateEmailConfig(Map configs)
	{
		String serverType = (String)configs.get("serverType");
		String serverSend = (String)configs.get("serverSend");
		String serverReceive = (String)configs.get("serverReceive");
		String portSmtp = (String)configs.get("portSmtp");
		String portPop = (String)configs.get("portPop");
		String isSSLSmtp = (String)configs.get("isSSLSmtp");
		String isSSLPop = (String)configs.get("isSSLPop");
		String portSSLSmtp = (String)configs.get("portSSLSmtp");
		String portSSLPop = (String)configs.get("portSSLPop");
		String address = (String)configs.get("address");
		String user = (String)configs.get("user");
		String password = (String)configs.get("password");
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element email = (Element)root.getElementsByTagName("email-config").item(0);
			if (serverType != null)
				email.getElementsByTagName("server-type").item(0).setTextContent(serverType);
			if (serverSend != null)
				email.getElementsByTagName("server-send").item(0).setTextContent(serverSend);
			if (serverReceive != null)
				email.getElementsByTagName("server-receive").item(0).setTextContent(serverReceive);
			if (portSmtp != null)
				email.getElementsByTagName("port-smtp").item(0).setTextContent(portSmtp);
			if (portPop != null)
				email.getElementsByTagName("port-pop").item(0).setTextContent(portPop);
			if (isSSLSmtp != null)
				email.getElementsByTagName("is-ssl-smtp").item(0).setTextContent(isSSLSmtp);
			if (isSSLPop != null)
				email.getElementsByTagName("is-ssl-pop").item(0).setTextContent(isSSLPop);
			if (portSSLSmtp != null)
				email.getElementsByTagName("port-ssl-smtp").item(0).setTextContent(portSSLSmtp);
			if (portSSLPop != null)
				email.getElementsByTagName("port-ssl-pop").item(0).setTextContent(portSSLPop);
			if (address != null)
				email.getElementsByTagName("address").item(0).setTextContent(address);
			if (user != null)
				email.getElementsByTagName("user").item(0).setTextContent(user);
			if (password != null)
				email.getElementsByTagName("password").item(0).setTextContent(password);
			XmlParser.saveDocument(doc, getAppConfig());
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:updateEmailConfig:")).append(e.getMessage()).toString());
		}
	}

	public List loadAdmins()
	{
		List admins = new ArrayList(2);
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element adminList = (Element)root.getElementsByTagName("admin-list").item(0);
			NodeList ads = adminList.getElementsByTagName("id");
			for (int i = 0; i < ads.getLength(); i++)
			{
				String admin = ads.item(i).getTextContent().trim();
				admins.add(admin);
			}

		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadAdmins:")).append(e.getMessage()).toString());
		}
		return admins;
	}

	public String loadURIPrefix()
	{
		String uriPrefix = "";
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element uriList = (Element)root.getElementsByTagName("init-uri").item(0);
			NodeList nl = uriList.getElementsByTagName("context");
			uriPrefix = nl.item(0).getTextContent().trim();
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:ConfigOper:loadAdmins:")).append(e.getMessage()).toString());
		}
		return uriPrefix.trim();
	}

	public void loadWebConfig(WebConfig tWebConfig)
	{
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element setting = (Element)root.getElementsByTagName("webconfig").item(0);
			String webname = setting.getElementsByTagName("webname").item(0).getTextContent().trim();
			String logo = setting.getElementsByTagName("logo").item(0).getTextContent().trim();
			String banner = setting.getElementsByTagName("banner").item(0).getTextContent().trim();
			String icp = setting.getElementsByTagName("icp").item(0).getTextContent().trim();
			String comment = setting.getElementsByTagName("comment").item(0).getTextContent().trim();
			tWebConfig.setBanner(banner);
			tWebConfig.setComment(comment);
			tWebConfig.setIcp(icp);
			tWebConfig.setLogo(logo);
			tWebConfig.setWebname(webname);
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadWebConfig:")).append(e.getMessage()).toString());
		}
	}

	public void updateWebConfig(WebConfig tWebConfig)
	{
		try
		{
			String webname = tWebConfig.getWebname();
			String logo = tWebConfig.getLogo();
			String banner = tWebConfig.getBanner();
			String icp = tWebConfig.getIcp();
			String comment = tWebConfig.getComment();
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element mysetting = (Element)root.getElementsByTagName("mysetting").item(0);
			if (webname != null && !webname.equals(""))
				mysetting.getElementsByTagName("webname").item(0).setTextContent(webname.trim());
			if (logo != null && !logo.equals(""))
				mysetting.getElementsByTagName("logo").item(0).setTextContent(logo.trim());
			if (banner != null)
				mysetting.getElementsByTagName("banner").item(0).setTextContent(banner.trim());
			if (icp != null && !icp.equals(""))
				mysetting.getElementsByTagName("icp").item(0).setTextContent(icp.trim());
			if (comment != null && !comment.equals(""))
				mysetting.getElementsByTagName("comment").item(0).setTextContent(comment.trim());
			XmlParser.saveDocument(doc, getAppConfig());
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:updateWebConfig:")).append(e.getMessage()).toString());
		}
	}

	public Map loadRelease()
	{
		Map release = new HashMap(5);
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element rel = (Element)root.getElementsByTagName("release").item(0);
			String version = rel.getElementsByTagName("version").item(0).getTextContent().trim();
			String date = rel.getElementsByTagName("date").item(0).getTextContent().trim();
			String author = rel.getElementsByTagName("author").item(0).getTextContent().trim();
			String msn = rel.getElementsByTagName("msn").item(0).getTextContent().trim();
			String homepage = rel.getElementsByTagName("homepage").item(0).getTextContent().trim();
			release.put("version", version);
			release.put("date", date);
			release.put("author", author);
			release.put("msn", msn);
			release.put("homepage", homepage);
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadRelease:")).append(e.getMessage()).toString());
		}
		return release;
	}

	public List loadDisaccess()
	{
		List disallows = new ArrayList();
		try
		{
			String filePath = (new StringBuilder(String.valueOf(WebApplication.getInstance().getServletContextPath()))).append("/WEB-INF/config/common/disaccess.xml").toString();
			Document doc = XmlParser.getDocument(filePath);
			Element root = doc.getDocumentElement();
			NodeList ips = root.getElementsByTagName("ip");
			for (int i = 0; i < ips.getLength(); i++)
			{
				String ip = ips.item(i).getTextContent().trim();
				NamedNodeMap attributes = ips.item(i).getAttributes();
				Node timeNode = attributes.getNamedItem("time");
				String time = timeNode.getTextContent();
				System.out.println((new StringBuilder("ip=")).append(ip).append(",time=").append(time).toString());
				DisaccessIP tDisaccessIP = new DisaccessIP();
				tDisaccessIP.setIp(ip);
				tDisaccessIP.setTime(time);
				disallows.add(tDisaccessIP);
			}

		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadDisaccesss:")).append(e.getMessage()).toString());
		}
		return disallows;
	}

	public static synchronized void addDisaccess(String ip)
	{
		String filePath;
		Document doc;
		Element root;
		NodeList ips;
		int i;
		filePath = (new StringBuilder(String.valueOf(WebApplication.getInstance().getServletContextPath()))).append("/WEB-INF/config/common/disaccess.xml").toString();
		doc = XmlParser.getDocument(filePath);
		root = doc.getDocumentElement();
		ips = root.getElementsByTagName("ip");
		i = 0;
		  goto _L1
_L3:
		Element temp = (Element)ips.item(i);
		if (temp.getTextContent().trim().equals(ip))
			return;
		i++;
_L1:
		if (i < ips.getLength()) goto _L3; else goto _L2
_L2:
		Element eIP = doc.createElement("ip");
		org.w3c.dom.Text eIP_text = doc.createTextNode(ip);
		eIP.appendChild(eIP_text);
		eIP.setAttribute("time", (new StringBuilder(String.valueOf(ECPubFun.getCurrentDate()))).append(" ").append(ECPubFun.getCurrentTime()).toString());
		root.appendChild(eIP);
		XmlParser.saveDocument(doc, filePath);
		break MISSING_BLOCK_LABEL_211;
		Exception e;
		e;
		ErrorsLog.log((new StringBuilder("Exception:addDisaccess::")).append(e.getMessage()).toString());
	}

	public void removeDisaccess(String ip)
	{
		try
		{
			String filePath = (new StringBuilder(String.valueOf(WebApplication.getInstance().getServletContextPath()))).append("/WEB-INF/config/common/disaccess.xml").toString();
			Document doc = XmlParser.getDocument(filePath);
			Element root = doc.getDocumentElement();
			NodeList ips = root.getElementsByTagName("ip");
			for (int i = 0; i < ips.getLength(); i++)
			{
				Element temp = (Element)ips.item(i);
				if (!temp.getTextContent().trim().equals(ip))
					continue;
				root.removeChild(temp);
				break;
			}

			XmlParser.saveDocument(doc, filePath);
		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:removeDisaccess:")).append(e.getMessage()).toString());
		}
	}

	public List getConnectionConfig()
	{
		List conns = new ArrayList(2);
		try
		{
			String filePath = (new StringBuilder(String.valueOf(WebApplication.getInstance().getServletContextPath()))).append("/WEB-INF/config/dbconn/dbconnection.xml").toString();
			filePath = "C:\\Kevin_File\\Java\\workspace\\MDES\\WebContent\\WEB-INF\\config\\dbconn\\dbconnection.xml";
			Document doc = XmlParser.getDocument(filePath);
			Element root = doc.getDocumentElement();
			NodeList dbs = root.getElementsByTagName("database");
			for (int i = 0; i < dbs.getLength(); i++)
			{
				Element db = (Element)dbs.item(i);
				String useto = db.getElementsByTagName("Useto").item(0).getTextContent().trim();
				String DBType = db.getElementsByTagName("DBType").item(0).getTextContent().trim();
				String IP = db.getElementsByTagName("IP").item(0).getTextContent().trim();
				String port = db.getElementsByTagName("Port").item(0).getTextContent().trim();
				String DBName = db.getElementsByTagName("DBName").item(0).getTextContent().trim();
				String userName = db.getElementsByTagName("UserName").item(0).getTextContent().trim();
				String passWord = db.getElementsByTagName("PassWord").item(0).getTextContent().trim();
				Map dbm = new HashMap(5);
				dbm.put("useto", useto);
				dbm.put("DBType", DBType);
				dbm.put("IP", IP);
				dbm.put("port", port);
				dbm.put("DBName", DBName);
				dbm.put("userName", userName);
				dbm.put("passWord", passWord);
				conns.add(dbm);
			}

		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("Exception:ConfigOper:getConnection:")).append(e.getMessage()).toString());
		}
		return conns;
	}

	private String getAppConfig()
	{
		return (new StringBuilder(String.valueOf(WebApplication.getInstance().getServletContextPath()))).append("/WEB-INF/config/app-config.xml").toString();
	}

	public Map loadDefaultPassword()
	{
		Map pwdConfig = new HashMap(2);
		try
		{
			Document doc = XmlParser.getDocument(getAppConfig());
			Element root = doc.getDocumentElement();
			Element topNode = (Element)root.getElementsByTagName("default-password").item(0);
			String SysUserDefaultPwd = topNode.getElementsByTagName("SysUser").item(0).getTextContent().trim();
			String CommonUserDefaultPwd = topNode.getElementsByTagName("CommonUser").item(0).getTextContent().trim();
			pwdConfig.put("SysUserDefaultPwd", SysUserDefaultPwd);
			pwdConfig.put("CommonUserDefaultPwd", CommonUserDefaultPwd);
		}
		catch (Exception ex)
		{
			ErrorsLog.log((new StringBuilder("Exception:Configurator:loadDefaultPassword:")).append(ex.getMessage()).toString());
		}
		return pwdConfig;
	}
}
