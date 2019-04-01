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
			System.out.println("��ֵ������󣬿��԰�����Ӣ�ģ����ּ���-����_����#�����ַ�");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "��ֵ������󣬿��԰�����Ӣ�ģ����ּ���-����_����#�����ַ�", "��ֵ������󣬿��԰�����Ӣ�ģ����ּ���-����_����#�����ַ�");
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
			System.out.println("�ͻ�����С��18");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�ͻ�����С��18", "�ͻ����䲻��С��18");
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
			System.out.println("�������Ч���ڴ��ڵ�ǰ��ʱ��");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�������Ч���ڴ��ڵ�ǰ��ʱ��", "�������Ч���ڴ��ڵ�ǰ��ʱ��");
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
			System.out.println("�ַ�����Ӣ�ģ����ĺ����ּ�-_#.���");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�ַ�����Ӣ�ģ����ĺ����ּ�-_#.���", "�ַ�����Ӣ�ģ����ĺ����ּ�-_#.���");
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
			System.out.println("�ַ�����Ӣ�ĺ��������");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�ַ�����Ӣ�ĺ��������", "�ַ�����Ӣ�ĺ��������");
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
			System.out.println("E-mail��ַ������ȷ��***@***.***");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail��ַ������ȷ��***@***.***", "E-mail��ַ������ȷ��***@***.***");
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
			System.out.println("�绰���볤��Ϊ7-18λ����");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�绰���볤��Ϊ7-18λ����", "�绰���볤��Ϊ7-18λ����");
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
			System.out.println("�ͻ�������¼�����,ֻ��Ϊ����");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�ͻ�������¼�����,ֻ��Ϊ����", "�ͻ�������¼�����,ֻ��Ϊ����");
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
			System.out.println("�ʱ�����Ӧ��Ϊ6λ����");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�ʱ�����Ӧ��Ϊ6λ����", "�ʱ�����Ӧ��Ϊ6λ����");
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
			System.out.println("�ƶ��绰Ӧ��Ϊ11λ����");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "�ƶ��绰Ӧ��Ϊ11λ����", "�ƶ��绰Ӧ��Ϊ11λ����");
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
