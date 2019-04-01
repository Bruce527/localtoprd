// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   EmailValidator.java

package com.sinosoft.map.common.validators;

import com.sinosoft.map.ec.utility.ECPubFun;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

// Referenced classes of package com.sinosoft.map.common.validators:
//			ValidatorConfig

public class EmailValidator extends ValidatorConfig
	implements Validator
{

	public EmailValidator()
	{
	}

	public void validate(FacesContext context, UIComponent component, Object pvalue)
		throws ValidatorException
	{
		String value = (String)pvalue;
		String emailPattern = "^[a-zA-Z0-9_\\.]+@[a-zA-Z0-9-]+[\\.a-zA-Z]+$";
		Pattern mask = Pattern.compile(emailPattern);
		Matcher matcher = mask.matcher(value);
		if (!matcher.find())
		{
			FacesMessage message = new FacesMessage();
			message.setSummary(ECPubFun.getDisplayString("com.sinosoft.map.international.resource.programresource", "Valitator_EmailInvalid", null));
			message.setDetail(ECPubFun.getDisplayString("com.sinosoft.map.international.resource.programresource", "Valitator_EmailInvalid", null));
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}
}
