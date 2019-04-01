// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysLoginValidator.java

package com.sinosoft.map.common.validators;

import com.sinosoft.map.common.WebVisitor;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.map.common.validators:
//			ValidatorConfig

public class SysLoginValidator extends ValidatorConfig
	implements Validator
{

	public SysLoginValidator()
	{
	}

	public void validate(FacesContext context, UIComponent arg1, Object arg2)
		throws ValidatorException
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
		if (visitor != null && visitor.isHalfLogin())
			visitor.setHalfLogin(false);
		else
		if ("sysloginvalidate".equals(arg1.getId()))
			validateCode(context, arg1, arg2);
	}

	public void validateCode(FacesContext context, UIComponent arg1, Object arg2)
	{
		String tInputStr = (String)arg2;
		FacesContext tFacesContext = getFacesContext();
		HttpServletRequest tHttpServletRequest = getHttpServletRequest();
		HttpSession tHttpSession = tHttpServletRequest.getSession();
		String tSessionCheckCode = (String)tHttpSession.getAttribute("validateCode");
		if (!tSessionCheckCode.equalsIgnoreCase(tInputStr))
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, getStringByID("Error", null), getStringByID("login_validateCodeError", null));
			tFacesContext.addMessage(null, msg);
			throw new ValidatorException(msg);
		} else
		{
			return;
		}
	}
}
