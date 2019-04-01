// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   AgentLogin.java

package com.sinosoft.map.user;

import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.map.common.*;
import com.sinosoft.map.common.validators.ValidatorConfig;
import com.sinosoft.map.ec.utility.BaseMapping;
import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.lis.encrypt.LisCompIDEA;
import com.sinosoft.map.lis.pubfun.PubFun;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import com.sinosoft.sug.lis.pubfun.GlobalInput;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.map.user:
//			LoginModel, UserModel

public class AgentLogin extends ValidatorConfig
{

	private static final long serialVersionUID = 0xd99acc871fe47aa2L;
	private String userCode;
	private String password;
	private String ManageCom;
	private String loginStr;
	private String loginAfterStr;
	private HttpSession session;
	private BaseMapping mBaseMapping;
	private String tempAgent;
	private String resTempAgent;
	private boolean hidden;
	private String validateCode;
	private String transNotice;
	private String isSuccess;
	private String isUserValidateCode;

	public AgentLogin()
	{
		mBaseMapping = new BaseMapping();
		tempAgent = "";
		resTempAgent = "";
		isSuccess = "false";
		isUserValidateCode = "true";
	}

	public String getResTempAgent()
	{
		return resTempAgent;
	}

	public void setResTempAgent(String resTempAgent)
	{
		this.resTempAgent = resTempAgent;
	}

	public String getTempAgent()
	{
		return tempAgent;
	}

	public void setTempAgent(String tempAgent)
	{
		this.tempAgent = tempAgent;
	}

	public String getLoginStr()
	{
		return loginStr;
	}

	public void setLoginStr(String loginStr)
	{
		login();
	}

	public String getLoginAfterStr()
	{
		return loginAfterStr;
	}

	public void setLoginAfterStr(String loginAfterStr)
	{
		this.loginAfterStr = loginAfterStr;
	}

	public String getManageCom()
	{
		return ManageCom;
	}

	public void setManageCom(String manageCom)
	{
		ManageCom = manageCom;
	}

	public String login()
	{
		isUserValidateCode = "false";
		tempAgent = mBaseMapping.agentMapping(userCode);
		userCode = tempAgent;
		resTempAgent = mBaseMapping.resAgentMapping(userCode);
		System.out.println((new StringBuilder("username=")).append(userCode).toString());
		if (userCode == null || "".equals(userCode))
		{
			ECPubFun.addInfoMessage(getBundle(), "login_userCodeNotice");
			return "failure";
		}
		if (password == null || "".equals(password))
		{
			userCode = resTempAgent;
			ECPubFun.addInfoMessage(getBundle(), "login_passwordNotice");
			return "failure";
		}
		if ("true".equals(isUserValidateCode) && (validateCode == null || "".equals(validateCode)))
		{
			userCode = resTempAgent;
			ECPubFun.addInfoMessage(getBundle(), "login_validCodeNotice");
			return "failure";
		}
		LoginModel user = existsUser();
		if (user == null || !user.isVerifyResult())
		{
			userCode = resTempAgent;
			ECPubFun.addErrorMessage(getBundle(), "login_userNotExists");
			return "failure";
		}
		user = existsPwd(user);
		if (!user.isVerifyResult())
		{
			userCode = resTempAgent;
			ECPubFun.addErrorMessage(getBundle(), "login_failure");
			return "failure";
		} else
		{
			setLogin(null, false);
			isSuccess = "true";
			return "failure";
		}
	}

	public void disagree()
	{
		Application app = getApplication();
		javax.el.ELContext elc = getELContext();
		ExpressionFactory ef = app.getExpressionFactory();
		ValueExpression ve = ef.createValueExpression(elc, "#{webVisitor}", com/sinosoft/map/common/WebVisitor);
		WebVisitor visitor = null;
		try
		{
			visitor = (WebVisitor)ve.getValue(elc);
		}
		catch (Exception exception) { }
		visitor.setHalfLogin(false);
		isSuccess = "false";
	}

	public String loginAfter()
	{
		LoginModel user = existsUser();
		if (user == null || !user.isVerifyResult())
		{
			userCode = resTempAgent;
			ECPubFun.addErrorMessage(getBundle(), "login_userNotExists");
			return "failure";
		}
		user = existsPwd(user);
		if (user == null || !user.isVerifyResult())
		{
			userCode = resTempAgent;
			ECPubFun.addErrorMessage(getBundle(), "login_failure");
			return "failure";
		}
		UserModel loginUser = getUser(user.getUserType(), user.getPwdLastSetDate());
		setLogin(loginUser, false);
		isSuccess = "true";
		GlobalInput eGlobalInput = new GlobalInput();
		eGlobalInput.Operator = loginUser.getUserCode();
		eGlobalInput.ManageCom = loginUser.getManageCom();
		eGlobalInput.ComCode = loginUser.getManageCom();
		eGlobalInput.PwdErrCount = 0;
		eGlobalInput.LastLogoTime = (new Date()).getTime();
		eGlobalInput.chanlesign = "I";
		eGlobalInput.riskSaleGroup = "000000";
		eGlobalInput.logoflag = true;
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("GI", eGlobalInput);
		String ContNo = "";
		String SugState = "add";
		session.setAttribute("ContNo", ContNo);
		session.setAttribute("SugState", SugState);
		IGlobalInput npGlobalInput = new IGlobalInput();
		System.out.println("ddddddddddddddddddddnew");
		npGlobalInput.Operator = loginUser.getUserCode();
		npGlobalInput.ManageCom = loginUser.getManageCom();
		npGlobalInput.ComCode = loginUser.getManageCom();
		npGlobalInput.BranchType = loginUser.getBranchType();
		if (loginUser.getUserType().equals("LP"))
		{
			npGlobalInput.OperType = "1";
			npGlobalInput.LNPEntry = true;
			npGlobalInput.LNPAudit = false;
			npGlobalInput.LNPQuery = false;
			npGlobalInput.LNPCancel = false;
			npGlobalInput.LNPRole = "0";
		} else
		if (loginUser.getUserType().equals("SysUser"))
		{
			ExeSQL exeSQL = new ExeSQL();
			String sql = (new StringBuilder("select rolecode,varc1,varc2,varc3 from lnpuserrolemap where usercode ='")).append(loginUser.getUserCode()).append("';").toString();
			SSRS tSSRS = exeSQL.execSQL(sql);
			if (tSSRS.getMaxRow() > 0)
			{
				if (tSSRS.GetText(1, 1).toLowerCase().equals("norsysuser"))
				{
					npGlobalInput.OperType = "2";
					npGlobalInput.LNPEntry = true;
					npGlobalInput.LNPRole = "0";
				} else
				if (tSSRS.GetText(1, 1).toLowerCase().equals("spesysuser"))
				{
					npGlobalInput.OperType = "3";
					npGlobalInput.LNPEntry = true;
					npGlobalInput.LNPRole = "0";
				} else
				{
					npGlobalInput.OperType = "";
					npGlobalInput.LNPEntry = false;
				}
				if (tSSRS.GetText(1, 2).toLowerCase().endsWith("true"))
				{
					npGlobalInput.LNPAudit = true;
					npGlobalInput.LNPRole = "1";
				} else
				{
					npGlobalInput.LNPAudit = false;
				}
				if ((tSSRS.GetText(1, 1).toLowerCase().equals("norsysuser") || tSSRS.GetText(1, 1).toLowerCase().equals("spesysuser")) && tSSRS.GetText(1, 2).toLowerCase().endsWith("true"))
					npGlobalInput.LNPRole = "2";
				if (tSSRS.GetText(1, 3).toLowerCase().endsWith("true"))
					npGlobalInput.LNPQuery = true;
				else
					npGlobalInput.LNPQuery = false;
				if (tSSRS.GetText(1, 4).toLowerCase().endsWith("true"))
					npGlobalInput.LNPCancel = true;
				else
					npGlobalInput.LNPCancel = false;
			} else
			{
				npGlobalInput.OperType = null;
				npGlobalInput.LNPEntry = false;
				npGlobalInput.LNPAudit = false;
				npGlobalInput.LNPQuery = false;
			}
		}
		npGlobalInput.OperType = "TEST_CH";
		System.out.println((new StringBuilder("-------银保用不到OperType，赋值''-------------")).append(npGlobalInput.OperType).toString());
		System.out.println((new StringBuilder("------------------银保当前登陆人:")).append(npGlobalInput.Operator).append("|录入权限：").append(npGlobalInput.LNPEntry).append("|审核权限：").append(npGlobalInput.LNPAudit).append("|报表权限：").append(npGlobalInput.LNPQuery).append("|").append("|删除权限：").append(npGlobalInput.LNPCancel).append("|LNPRole:").append(npGlobalInput.LNPRole).toString());
		npGlobalInput.PwdErrCount = 0;
		npGlobalInput.LastLogoTime = (new Date()).getTime();
		npGlobalInput.chanlesign = loginUser.getBranchType();
		npGlobalInput.riskSaleGroup = "000000";
		npGlobalInput.logoflag = true;
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String NpContNo = "";
		String NpState = "add";
		session.setAttribute("ContNo", NpContNo);
		session.setAttribute("NpState", NpState);
		session.setAttribute("NPGI", npGlobalInput);
		return "success";
	}

	private LoginModel existsUser()
	{
		System.out.println("首先根据用户的UserCode判断是否存在该用户");
		LoginModel user = new LoginModel();
		ExeSQL exeSQL = new ExeSQL();
		String userSQL1 = "select varvalue from msysvar where vartype='loginbranchtype'";
		SSRS ssrs = exeSQL.execSQL(userSQL1);
		String abranchtype[] = ssrs.GetText(1, 1).split(",");
		String branchtype = "";
		for (int i = 0; i < abranchtype.length - 1; i++)
			branchtype = (new StringBuilder(String.valueOf(branchtype))).append("'").append(abranchtype[i]).append("' , ").toString();

		branchtype = (new StringBuilder(String.valueOf(branchtype))).append("'").append(abranchtype[abranchtype.length - 1]).append("' ").toString();
		System.out.println(branchtype);
		String userSQL2 = (new StringBuilder("select usercode from muser where usercode='")).append(userCode).append("' and userState = '1' and branchtype in (").append(branchtype).append(") and ( validstartdate is null or validstartdate <= '").append(ECPubFun.getCurrentDate()).append("' ) and ( validenddate is null or validenddate >= '").append(ECPubFun.getCurrentDate()).append("' )").toString();
		ssrs = exeSQL.execSQL(userSQL2);
		if (ssrs != null && ssrs.MaxRow > 0)
		{
			user.setUserType("SysUser");
			user.setVerifyResult(true);
			return user;
		} else
		{
			user.setVerifyResult(false);
			return user;
		}
	}

	private UserModel getUser(String type, String tDate)
	{
		UserModel loginUser = null;
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs = new SSRS();
		String week = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(calendar.getTime());
		Date date = null;
		try
		{
			date = sdf.parse(d);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		calendar.setTime(date);
		int dayOfWeek = calendar.get(7);
		if (dayOfWeek == 2)
			week = "星期一";
		if (dayOfWeek == 3)
			week = "星期二";
		if (dayOfWeek == 4)
			week = "星期三";
		if (dayOfWeek == 5)
			week = "星期四";
		if (dayOfWeek == 6)
			week = "星期五";
		if (dayOfWeek == 7)
			week = "星期六";
		if (dayOfWeek == 1)
			week = "星期日";
		if (type != "" && type.equals("LP"))
		{
			String branchType = "";
			String showAgentcode = "";
			String showBranchattr = "";
			String sql = (new StringBuilder("select a.agentcode,a.managecom,a.agentState,a.branchType,a.name from LAAgent a where 1=1 and a.agentcode = '")).append(userCode).append("'").toString();
			ssrs = exeSQL.execSQL(sql);
			if (ssrs.MaxRow > 0)
			{
				loginUser = new UserModel();
				loginUser.setUserCode(ssrs.GetText(1, 1));
				loginUser.setManageCom(ssrs.GetText(1, 2));
				loginUser.setUserState(ssrs.GetText(1, 3));
				branchType = ssrs.GetText(1, 4);
				if (branchType == null || branchType.equals(""))
					branchType = "1";
				loginUser.setBranchType(branchType);
				loginUser.setLogin(true);
				loginUser.setName(ssrs.GetText(1, 5));
				showAgentcode = mBaseMapping.resAgentMapping(ssrs.GetText(1, 1));
				loginUser.setShowUserCode(showAgentcode);
				loginUser.setUserType("LP");
				loginUser.setCalDate(PubFun.getCurrentDate());
				loginUser.setCalWeek(week);
				loginUser.setLoginDate(PubFun.getCurrentDate());
				loginUser.setLoginTime(PubFun.getCurrentTime());
				loginUser.setPwdLastSetDate(tDate);
				sql = (new StringBuilder("select b.agentGrade,b.ecgrade,a.branchattr from labranchgroup a,latree b where 1=1 and a.agentgroup = b.agentgroup and b.agentcode = '")).append(userCode).append("'").toString();
				SSRS ssrs1 = new SSRS();
				ssrs1 = exeSQL.execSQL(sql);
				if (ssrs1.MaxRow > 0)
				{
					loginUser.setAgentGrade(ssrs1.GetText(1, 1));
					if (!"".equals(ssrs1.GetText(1, 1)) && ssrs1.GetText(1, 1).compareTo("A30") > 0)
						loginUser.setEcGrade("AM");
					else
					if (!"".equals(ssrs1.GetText(1, 1)) && ssrs1.GetText(1, 1).compareTo("A20") > 0)
						loginUser.setEcGrade("SM");
					else
						loginUser.setEcGrade(ssrs1.GetText(1, 2));
					loginUser.setBranchAttr(ssrs1.GetText(1, 3));
					showBranchattr = mBaseMapping.resBranchMapping(ssrs1.GetText(1, 3));
					loginUser.setShowBranchattr(showBranchattr);
				} else
				{
					loginUser.setAgentGrade("");
					loginUser.setEcGrade("");
					loginUser.setBranchAttr("");
					loginUser.setShowBranchattr("");
				}
				sql = (new StringBuilder("select magl.LoginDate,magl.LoginTime from MWebLoginLog magl where 1=1 and magl.usercode = '")).append(userCode).append("' order by magl.LoginDate desc").toString();
				ssrs1 = exeSQL.execSQL(sql);
				if (ssrs1.MaxRow > 0)
				{
					loginUser.setLastLoginDate(ssrs1.GetText(1, 1));
					loginUser.setLastLoginTime(ssrs1.GetText(1, 2));
				} else
				{
					loginUser.setLastLoginDate("");
					loginUser.setLastLoginTime("");
				}
				sql = "select menuid from Mwebmenuctrl where 1=1  ";
				ssrs1 = exeSQL.execSQL(sql);
				if (ssrs1.MaxRow > 0)
				{
					String menus[] = new String[ssrs1.getMaxRow()];
					for (int i = 0; i < ssrs1.getMaxRow(); i++)
						menus[i] = ssrs1.GetText(i + 1, 1);

					loginUser.setMenus(menus);
				} else
				{
					String menus1[] = {
						"1"
					};
					loginUser.setMenus(menus1);
				}
			}
		} else
		if (type != "" && type.equals("SysUser"))
		{
			String branchType = "";
			String sql = (new StringBuilder("select a.usercode,a.managecom,a.userState,a.branchType,a.username from muser a where 1=1 and a.usercode = '")).append(userCode).append("'").toString();
			ssrs = exeSQL.execSQL(sql);
			if (ssrs.MaxRow > 0)
			{
				loginUser = new UserModel();
				loginUser.setUserCode(ssrs.GetText(1, 1));
				loginUser.setManageCom(ssrs.GetText(1, 2));
				loginUser.setUserState(ssrs.GetText(1, 3));
				branchType = ssrs.GetText(1, 4);
				if (branchType == null || branchType.equals(""))
					branchType = "1";
				loginUser.setBranchType(branchType);
				loginUser.setLogin(true);
				loginUser.setName(ssrs.GetText(1, 5));
				loginUser.setUserType("SysUser");
				loginUser.setCalDate(PubFun.getCurrentDate());
				loginUser.setCalWeek(week);
				loginUser.setLoginDate(PubFun.getCurrentDate());
				loginUser.setLoginTime(PubFun.getCurrentTime());
				loginUser.setPwdLastSetDate(tDate);
				loginUser.setAgentGrade("A99");
				loginUser.setEcGrade("");
				SSRS ssrs1 = new SSRS();
				sql = (new StringBuilder("select mugl.LoginDate,mugl.LoginTime from MWebLoginLog mugl where 1=1 and mugl.usercode = '")).append(userCode).append("' order by mugl.LoginDate desc").toString();
				ssrs1 = exeSQL.execSQL(sql);
				if (ssrs1.MaxRow > 0)
				{
					loginUser.setLastLoginDate(ssrs1.GetText(1, 1));
					loginUser.setLastLoginTime(ssrs1.GetText(1, 2));
				} else
				{
					loginUser.setLastLoginDate("");
					loginUser.setLastLoginTime("");
				}
				sql = "select menuid from Mwebmenuctrl  ";
				ssrs1 = exeSQL.execSQL(sql);
				if (ssrs1.MaxRow > 0)
				{
					String menus[] = new String[ssrs1.getMaxRow()];
					for (int i = 0; i < ssrs1.getMaxRow(); i++)
						menus[i] = ssrs1.GetText(i + 1, 1);

					loginUser.setMenus(menus);
				} else
				{
					String menus1[] = {
						"1"
					};
					loginUser.setMenus(menus1);
				}
			}
		}
		return loginUser;
	}

	private LoginModel existsPwd(LoginModel user)
	{
		String username = userCode;
		String password = this.password;
		System.out.println((new StringBuilder("域账号=")).append(username).append("===域密码=").append(password).toString());
		if (!"dadmin".equalsIgnoreCase(userCode))
		{
			if (!checkADLogin(username, password))
				user.setVerifyResult(false);
			else
				user.setVerifyResult(true);
		} else
		{
			System.out.println("&&&&管理员账号");
			LisCompIDEA tLisCompIDEA = new LisCompIDEA();
			String pass = tLisCompIDEA.encryptString(password);
			String sql = (new StringBuilder("select usercode,pwdmodifydate from muser a where 1=1 and a.usercode = '")).append(userCode).append("' and a.password = '").append(pass).append("'").toString();
			ExeSQL exeSQL = new ExeSQL();
			SSRS ssrs = new SSRS();
			ssrs = exeSQL.execSQL(sql);
			if (ssrs != null && ssrs.MaxRow > 0)
			{
				user.setVerifyResult(true);
				user.setPwdLastSetDate(ssrs.GetText(1, 2));
			} else
			{
				user.setVerifyResult(false);
			}
		}
		return user;
	}

	private void redirect()
	{
		FacesContext fc = getFacesContext();
		Application app = getApplication();
		javax.faces.component.UIViewRoot view = app.getViewHandler().createView(fc, "/common/user/resendEmail.jsp");
		fc.setViewRoot(view);
		fc.renderResponse();
	}

	public void setLogin(UserModel user, boolean hidden)
	{
		getWebApplication().getVisitorsOper().login(user, hidden);
	}

	public void logout()
	{
		WebVisitor visitor = getVisitor();
		getWebApplication().getVisitorsOper().logout(visitor);
		ECPubFun.redirect2("/login.jsf");
	}

	public String goToRegister()
	{
		return "register";
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}

	public String getValidateCode()
	{
		return validateCode;
	}

	public void setValidateCode(String validateCode)
	{
		this.validateCode = validateCode;
	}

	public String getTransNotice()
	{
		return transNotice;
	}

	public void setTransNotice(String transNotice)
	{
		this.transNotice = transNotice;
	}

	public String getIsSuccess()
	{
		return isSuccess;
	}

	public void setIsUserValidateCode(String isUserValidateCode)
	{
		this.isUserValidateCode = isUserValidateCode;
	}

	public String getIsUserValidateCode()
	{
		return isUserValidateCode;
	}

	public String changePassword()
	{
		tempAgent = mBaseMapping.agentMapping(userCode);
		return tempAgent;
	}

	public String resetPassword()
	{
		tempAgent = mBaseMapping.agentMapping(userCode);
		return tempAgent;
	}

	private boolean checkADLogin(String username, String password)
	{
		boolean loginflag;
		Hashtable env;
		DirContext ctx;
		loginflag = false;
		ExeSQL exeSQL = new ExeSQL();
		SSRS ssrs1 = new SSRS();
		String ldaphostSql = "select varvalue from msysvar where vartype = 'ldap_host'";
		String ldapdomainSql = "select varvalue from msysvar where vartype = 'ldap_domain'";
		String ldapportSql = "select varvalue from msysvar where vartype = 'ldap_port'";
		ssrs1 = exeSQL.execSQL(ldaphostSql);
		String ldap_host = ssrs1.GetText(1, 1);
		ssrs1 = exeSQL.execSQL(ldapdomainSql);
		String ldap_domain = ssrs1.GetText(1, 1);
		ssrs1 = exeSQL.execSQL(ldapportSql);
		String ldap_port = ssrs1.GetText(1, 1);
		String ldap_url = new String((new StringBuilder("ldap://")).append(ldap_host).append(":").append(ldap_port).toString());
		String user = (new StringBuilder(String.valueOf(ldap_domain))).append("\\").append(username).toString();
		System.out.println((new StringBuilder("ldap_url--------")).append(ldap_url).toString());
		env = new Hashtable();
		ctx = null;
		env.put("java.naming.security.authentication", "simple");
		env.put("java.naming.security.principal", user);
		env.put("java.naming.security.credentials", password);
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		env.put("java.naming.provider.url", ldap_url);
		ctx = new InitialDirContext(env);
		System.out.println("身份验证成功!");
		loginflag = true;
		break MISSING_BLOCK_LABEL_433;
		AuthenticationException e;
		e;
		System.out.println("身份验证失败!");
		e.printStackTrace();
		if (ctx != null)
			try
			{
				ctx.close();
				ctx = null;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		break MISSING_BLOCK_LABEL_458;
		e;
		System.out.println("AD域连接失败!");
		e.printStackTrace();
		if (ctx != null)
			try
			{
				ctx.close();
				ctx = null;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		break MISSING_BLOCK_LABEL_458;
		e;
		System.out.println("身份验证未知异常!");
		e.printStackTrace();
		if (ctx != null)
			try
			{
				ctx.close();
				ctx = null;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		break MISSING_BLOCK_LABEL_458;
		Exception exception;
		exception;
		if (ctx != null)
			try
			{
				ctx.close();
				ctx = null;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		throw exception;
		if (ctx != null)
			try
			{
				ctx.close();
				ctx = null;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return loginflag;
	}
}
