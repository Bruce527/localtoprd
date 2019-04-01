// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WebApplication.java

package com.sinosoft.map.common;

import com.sinosoft.map.common.config.AccessauthConfig;
import com.sinosoft.map.common.config.Configurator;
import com.sinosoft.map.common.config.WebConfig;
import com.sinosoft.map.common.logs.ErrorsLog;
import com.sinosoft.map.ec.datamodel.DisaccessIP;
import com.sinosoft.map.user.UserModel;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

// Referenced classes of package com.sinosoft.map.common:
//			WebVisitorEngine

public class WebApplication
	implements Serializable
{

	private static WebApplication _webApplication = null;
	private String _servletContextPath;
	private boolean _register;
	private boolean _login;
	private boolean _emailRegister;
	private boolean _validateRegister;
	private boolean _validateLogin;
	private boolean _upload;
	private boolean _webStatistics;
	private String _sysUserDefultPwd;
	private String _commonUserDefultPwd;
	private Map _conEmail;
	private List _admins;
	private String adminList;
	private WebConfig _webConfig;
	private static Map _release;
	private WebVisitorEngine _webVisitorEngine;
	private AccessauthConfig _authConf;
	private List _disaccess;
	private Map _disaccessHashMap;
	private Map jdbcurl;
	private Map jdbcurlbackup;
	private String _URIPrefix;
	private Map _defaultPassword;
	private int _totalUser;
	private UserModel _lastRegister;

	private WebApplication()
	{
	}

	public static WebApplication getInstance()
	{
		if (_webApplication == null)
			_webApplication = new WebApplication();
		return _webApplication;
	}

	public String getServletContextPath()
	{
		return _servletContextPath;
	}

	public String getHttpContextPath()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		String host = (String)ec.getRequestHeaderMap().get("host");
		String cPath = ec.getRequestContextPath();
		return (new StringBuilder("http://")).append(host).append(cPath).toString();
	}

	private void out(Object obj)
	{
		System.out.println(obj);
	}

	public void init(String servletContextPath)
	{
		System.out.println("====================初始化配置信息=================");
		_servletContextPath = servletContextPath;
		initConnection();
		initURIPrefix();
		initConfigs();
		initAdmins();
		initWebConfig();
		initRelease();
		initVisitors();
		initAccessauths();
		initDisaccess();
		initDisaccessHashMap();
		initDefaultPassword();
	}

	public void initConnection()
	{
		try
		{
			out("---------------读取数据库连接配置---------------");
			Configurator conf = new Configurator();
			List dbconninfos = conf.getConnectionConfig();
			for (Iterator iterator = dbconninfos.iterator(); iterator.hasNext();)
			{
				Map db = (Map)iterator.next();
				String dbType = (String)db.get("DBType");
				out((new StringBuilder("===")).append(dbType).toString());
				String dbIP = (String)db.get("IP");
				out((new StringBuilder("IP=")).append(dbIP).toString());
				String dbPort = (String)db.get("port");
				String dbName = (String)db.get("DBName");
				String dbUserName = (String)db.get("userName");
				out((new StringBuilder("dbUserName=")).append(dbIP).toString());
				String dbPassword = (String)db.get("passWord");
				if (((String)db.get("useto")).equals("default"))
				{
					jdbcurl = new HashMap(6);
					jdbcurl.put("dbType", dbType);
					jdbcurl.put("dbIP", dbIP);
					jdbcurl.put("dbPort", dbPort);
					jdbcurl.put("dbName", dbName);
					jdbcurl.put("dbUserName", dbUserName);
					jdbcurl.put("dbPassword", dbPassword);
				} else
				if (((String)db.get("useto")).equals("bak"))
				{
					jdbcurlbackup = new HashMap(6);
					jdbcurlbackup.put("dbType", dbType);
					jdbcurlbackup.put("dbIP", dbIP);
					jdbcurlbackup.put("dbPort", dbPort);
					jdbcurlbackup.put("dbName", dbName);
					jdbcurlbackup.put("dbUserName", dbUserName);
					jdbcurlbackup.put("dbPassword", dbPassword);
					out("dllllllllllllllllllll");
				} else
				{
					ErrorsLog.log("WebApplicaiton:initConnection:dbconneciton.xml配置错误!");
				}
			}

		}
		catch (Exception e)
		{
			ErrorsLog.log((new StringBuilder("连接池创建过程中出现错误")).append(e.getMessage()).toString());
		}
	}

	private void initConfigs()
	{
		out("---------------加载系统全局“开关”---------------");
		Configurator conf = new Configurator();
		Map displays = conf.loadDisplay();
		_register = ((Boolean)displays.get("register")).booleanValue();
		_login = ((Boolean)displays.get("login")).booleanValue();
		_emailRegister = ((Boolean)displays.get("emailRegister")).booleanValue();
		_validateRegister = ((Boolean)displays.get("validateRegister")).booleanValue();
		_validateLogin = ((Boolean)displays.get("validateLogin")).booleanValue();
		_upload = ((Boolean)displays.get("upload")).booleanValue();
		_webStatistics = ((Boolean)displays.get("webStatistics")).booleanValue();
		out((new StringBuilder("register:")).append(_register).toString());
		out((new StringBuilder("login:")).append(_login).toString());
		out((new StringBuilder("emailRegister:")).append(_emailRegister).toString());
		out((new StringBuilder("validateRegister:")).append(_validateRegister).toString());
		out((new StringBuilder("validateLogin:")).append(_validateLogin).toString());
		out((new StringBuilder("upload:")).append(_upload).toString());
		out((new StringBuilder("webStatistics:")).append(_webStatistics).toString());
	}

	public void reloadConfigs()
	{
		initConfigs();
	}

	public boolean isRegister()
	{
		return _register;
	}

	public boolean isLogin()
	{
		return _login;
	}

	public boolean isEmailRegister()
	{
		return _emailRegister;
	}

	public boolean isValidateRegister()
	{
		return _validateRegister;
	}

	public boolean isValidateLogin()
	{
		return _validateLogin;
	}

	public boolean isWebStatistics()
	{
		return _webStatistics;
	}

	public boolean isUpload()
	{
		return _upload;
	}

	public Map getConEmail()
	{
		return _conEmail;
	}

	private void initEmail()
	{
		out("---------------初始化email配置---------------");
		Configurator conf = new Configurator();
		_conEmail = new HashMap(12);
		_conEmail = conf.loadEmailConfig();
		Set keys = _conEmail.keySet();
		String key;
		for (Iterator iterator = keys.iterator(); iterator.hasNext(); out((new StringBuilder(String.valueOf(key))).append(":").append((String)_conEmail.get(key)).toString()))
			key = (String)iterator.next();

	}

	public void reloadEmail()
	{
		initEmail();
	}

	public List getAdmins()
	{
		return _admins;
	}

	public String getAdminList()
	{
		Iterator iterator;
		adminList = "";
		iterator = _admins.iterator();
		  goto _L1
_L3:
		String admin = (String)iterator.next();
		this;
		adminList;
		JVM INSTR new #95  <Class StringBuilder>;
		JVM INSTR dup_x1 ;
		JVM INSTR swap ;
		String.valueOf();
		StringBuilder();
		admin;
		append();
		" ";
		append();
		toString();
		adminList;
_L1:
		if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
		return adminList;
	}

	private void initAdmins()
	{
		out("---------------初始化管理员列表---------------");
		Configurator conf = new Configurator();
		_admins = conf.loadAdmins();
		String admin;
		for (Iterator iterator = _admins.iterator(); iterator.hasNext(); out((new StringBuilder("admin:")).append(admin).toString()))
			admin = (String)iterator.next();

	}

	private void initURIPrefix()
	{
		out("---------------加载应用发布时的URI前缀---------------");
		Configurator conf = new Configurator();
		_URIPrefix = conf.loadURIPrefix();
		out((new StringBuilder("URIPrefix:")).append(_URIPrefix).toString());
	}

	public void reloadAdmins()
	{
		initAdmins();
	}

	public boolean isAdmin(String userId)
	{
		if (!_admins.isEmpty())
			return _admins.contains(userId);
		else
			return false;
	}

	private void initWebConfig()
	{
		out("--------------- 初始化系统的个性设置---------------");
		_webConfig = new WebConfig();
		_webConfig.loadWebConfig();
		out((new StringBuilder("webname:")).append(_webConfig.getWebname()).toString());
		out((new StringBuilder("logo:")).append(_webConfig.getLogo()).toString());
		out((new StringBuilder("banner:")).append(_webConfig.getBanner()).toString());
		out((new StringBuilder("icp:")).append(_webConfig.getIcp()).toString());
		out((new StringBuilder("comment:")).append(_webConfig.getComment()).toString());
	}

	public void reloadWebConfig()
	{
		initWebConfig();
	}

	public WebConfig getWebConfig()
	{
		return _webConfig;
	}

	private void initRelease()
	{
		out("---------------载入网站系统版本信息---------------");
		Configurator conf = new Configurator();
		_release = new HashMap(5);
		_release = conf.loadRelease();
		out((new StringBuilder("version:")).append((String)_release.get("version")).toString());
		out((new StringBuilder("date:")).append((String)_release.get("date")).toString());
		out((new StringBuilder("author:")).append((String)_release.get("author")).toString());
		out((new StringBuilder("msn:")).append((String)_release.get("msn")).toString());
		out((new StringBuilder("homepage:")).append((String)_release.get("homepage")).toString());
	}

	public Map getRelease()
	{
		return _release;
	}

	private void initVisitors()
	{
		_webVisitorEngine = new WebVisitorEngine();
		_webVisitorEngine.start();
	}

	public WebVisitorEngine getVisitorsOper()
	{
		return _webVisitorEngine;
	}

	private void initAccessauths()
	{
		out("---------------初始化目录及文件访问权限配置---------------");
		String authPath = (new StringBuilder(String.valueOf(_servletContextPath))).append("/WEB-INF/config/common/accessauth.xml").toString();
		_authConf = new AccessauthConfig(authPath);
		_authConf.showState();
	}

	public AccessauthConfig getAuthConf()
	{
		return _authConf;
	}

	private void initDisaccess()
	{
		out("---------------载入被禁止访问网站的IP地址---------------");
		Configurator conf = new Configurator();
		_disaccess = conf.loadDisaccess();
		initDisaccessHashMap();
	}

	private void initDisaccessHashMap()
	{
		out("---------------载入被禁止访问网站的IP地址---------------");
		Configurator conf = new Configurator();
		Iterator tDisaccess = conf.loadDisaccess().iterator();
		_disaccessHashMap = new HashMap(conf.loadDisaccess().size());
		DisaccessIP t;
		for (; tDisaccess.hasNext(); _disaccessHashMap.put(t.getIp(), t.getIp()))
			t = (DisaccessIP)tDisaccess.next();

	}

	public void reloadDisaccess()
	{
		initDisaccess();
	}

	public List getDisaccess()
	{
		return _disaccess;
	}

	public Map getDisaccessHashMap()
	{
		return _disaccessHashMap;
	}

	public int getTotalUser()
	{
		return _totalUser;
	}

	public UserModel getLastRegister()
	{
		return _lastRegister;
	}

	public void release()
	{
		try
		{
			_servletContextPath = null;
			_URIPrefix = null;
			_conEmail = null;
			_register = false;
			_login = false;
			_emailRegister = false;
			_validateRegister = false;
			_validateLogin = false;
			_webStatistics = false;
			_upload = false;
			_conEmail = null;
			_admins = null;
			_webConfig = null;
			_release = null;
			_webVisitorEngine.release();
			_webVisitorEngine = null;
			_authConf = null;
			_disaccess = null;
			_disaccessHashMap = null;
		}
		catch (Exception e)
		{
			ErrorsLog.log("Exception:on release WebApplication");
		}
	}

	public Map get_jdbcurl()
	{
		return jdbcurl;
	}

	public Map get_jdbcurlbackup()
	{
		return jdbcurlbackup;
	}

	public String get_URIPrefix()
	{
		return _URIPrefix;
	}

	public WebVisitorEngine get_webVisitorEngine()
	{
		return _webVisitorEngine;
	}

	private void initDefaultPassword()
	{
		out("---------------载入系统默认密码---------------");
		Configurator conf = new Configurator();
		_defaultPassword = new HashMap(2);
		_defaultPassword = conf.loadDefaultPassword();
		_sysUserDefultPwd = (String)_defaultPassword.get("SysUserDefaultPwd");
		_commonUserDefultPwd = (String)_defaultPassword.get("CommonUserDefaultPwd");
	}

	public String get_sysUserDefultPwd()
	{
		return _sysUserDefultPwd;
	}

	public String get_commonUserDefultPwd()
	{
		return _commonUserDefultPwd;
	}

}
