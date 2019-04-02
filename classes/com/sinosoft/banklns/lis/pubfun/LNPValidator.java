// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPValidator.java

package com.sinosoft.banklns.lis.pubfun;

import com.sinosoft.banklns.utility.DateConvert;
import java.io.PrintStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

// Referenced classes of package com.sinosoft.banklns.lis.pubfun:
//			ValidateTools

public class LNPValidator
	implements Validator
{

	public LNPValidator()
	{
	}

	public void validate(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String password = (String)obj;
		System.out.println((new StringBuilder("password=")).append(password).toString());
		if (!ValidateTools.isValidString1(password))
		{
			System.out.println("该�?�输入错误，可以包含中英文，数字及�??-”�?�_”�??#”等字符");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "该�?�输入错误，可以包含中英文，数字及�??-”�?�_”�??#”等字符", "该�?�输入错误，可以包含中英文，数字及�??-”�?�_”�??#”等字符");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void validateNumber(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		int age = ((Integer)obj).intValue();
		if (age < 18)
		{
			System.out.println("客户年龄小于18");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "客户年龄小于18", "客户年龄不得小于18");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void validateDate(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		Date date = (Date)obj;
		String tempDate = DateConvert.dateToStr(date);
		if (!"".equals(tempDate) && !ValidateTools.isValidDate(tempDate))
		{
			System.out.println("输入的有效日期大于当前的时间");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入的有效日期大于当前的时间", "输入的有效日期大于当前的时间");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isValidString1(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String temp = (String)obj;
		if (!"".equals(temp) && !ValidateTools.isValidString1(temp))
		{
			System.out.println("字符串由英文，中文和数字�?-_#.组成");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "字符串由英文，中文和数字�?-_#.组成", "字符串由英文，中文和数字�?-_#.组成");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isValidString2(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String temp = (String)obj;
		if (!"".equals(temp) && !ValidateTools.isValidString2(temp))
		{
			System.out.println("字符串由英文和数字组�?");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "字符串由英文和数字组�?", "字符串由英文和数字组�?");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isValidEMail(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String temp = (String)obj;
		if (!"".equals(temp) && !ValidateTools.isValidEMail(temp))
		{
			System.out.println("E-mail地址错误，正确如***@***.***");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail地址错误，正确如***@***.***", "E-mail地址错误，正确如***@***.***");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isNumeric(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String temp = (String)obj;
		if (!isValidTelCode2(temp))
		{
			System.out.println("电话号码长度�?7-18位数�?");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "电话号码长度�?7-18位数�?", "电话号码长度�?7-18位数�?");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isNumeric2(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		double temp = ((Double)obj).doubleValue();
		if (!ValidateTools.isNumeric(String.valueOf(temp)))
		{
			System.out.println("客户年收入录入错�?,只能为数�?");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "客户年收入录入错�?,只能为数�?", "客户年收入录入错�?,只能为数�?");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isValidZipCode(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String temp = (String)obj;
		if (!ValidateTools.isValidZipCode(temp))
		{
			System.out.println("邮编输入应该�?6位数�?");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "邮编输入应该�?6位数�?", "邮编输入应该�?6位数�?");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public void isValidTelCode(FacesContext context, UIComponent component, Object obj)
		throws ValidatorException
	{
		String temp = (String)obj;
		if (!isValidTelCode1(temp))
		{
			System.out.println("移动电话应该�?11位数�?");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "移动电话应该�?11位数�?", "移动电话应该�?11位数�?");
			throw new ValidatorException(message);
		} else
		{
			return;
		}
	}

	public static boolean isValidTelCode1(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("[1-9]\\d{10}");
			Matcher isZipCode = pattern.matcher(aValue);
			return isZipCode.matches();
		} else
		{
			return true;
		}
	}

	public static boolean isValidTelCode2(String aValue)
	{
		if (aValue == null)
			return false;
		if (!"".equals(aValue))
		{
			Pattern pattern = Pattern.compile("[1-9]\\d{6,19}");
			Matcher isZipCode = pattern.matcher(aValue);
			return isZipCode.matches();
		} else
		{
			return true;
		}
	}
}
