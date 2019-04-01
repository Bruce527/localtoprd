// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MathCalTool.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.pubfun.Arith;
import java.io.PrintStream;
import java.util.*;

public class MathCalTool
{

	private String expStr;
	private String errorStr;

	public MathCalTool()
	{
		errorStr = "";
	}

	public void setExpress(String strExpress)
	{
		expStr = (new StringBuilder(String.valueOf(strExpress))).append("+0").toString();
	}

	public double getResult()
	{
		errorStr = "";
		String postfix = TranslateExpress(expStr);
		if (errorStr != null && errorStr.length() > 0)
			return 0.0D;
		Stack stk = new Stack();
		String parts[] = postfix.split("   +");
		double result = 0.0D;
		for (int i = 0; i < parts.length; i++)
		{
			char tmp = parts[i].charAt(0);
			if (!isOperator(tmp))
			{
				if (errorStr != null && errorStr.length() > 0)
					return 0.0D;
				stk.push(parts[i]);
			} else
			{
				double a = Double.parseDouble((new StringBuilder()).append(stk.pop()).toString());
				double b = Double.parseDouble((new StringBuilder()).append(stk.pop()).toString());
				result = calculate(b, a, tmp);
				if (errorStr != null && errorStr.length() > 0)
					return 0.0D;
				stk.push(String.valueOf(result));
			}
		}

		return result;
	}

	private boolean isOperator(char op)
	{
		return op == '+' || op == '-' || op == '*' || op == '/' || op == '%' || op == '^' || op == '~';
	}

	public double calculate(double a, double b, char op)
	{
		switch (op)
		{
		case 43: // '+'
			return Arith.add(a, b);

		case 45: // '-'
			return Arith.sub(a, b);

		case 42: // '*'
			return Arith.mul(a, b);

		case 47: // '/'
			if (b == 0.0D)
			{
				errorStr = (new StringBuilder("����[")).append(b).append("]Ϊ��").toString();
				return 0.0D;
			} else
			{
				return Arith.div(a, b);
			}

		case 37: // '%'
			return a % b;

		case 94: // '^'
			return Math.pow(a, b);

		case 126: // '~'
			return Math.sqrt(a);
		}
		errorStr = "�����Ų�֧��";
		return -1D;
	}

	private String TranslateExpress(String expressStr)
	{
		Stack stk = new Stack();
		String postfix = new String();
		char op;
		for (int i = 0; i < expressStr.length();)
			if (Character.isDigit(expressStr.charAt(i)) || expressStr.charAt(i) == '.')
			{
				postfix = (new StringBuilder(String.valueOf(postfix))).append("   ").toString();
				do
					postfix = (new StringBuilder(String.valueOf(postfix))).append(expressStr.charAt(i++)).toString();
				while (i < expressStr.length() && Character.isDigit(expressStr.charAt(i)));
				postfix = (new StringBuilder(String.valueOf(postfix))).append("   ").toString();
			} else
			{
				switch (op = expressStr.charAt(i++))
				{
				case 40: // '('
					stk.push("(");
					break;

				case 41: // ')'
					while (stk.peek() != "(") 
					{
						String tmp = (new StringBuilder()).append(stk.pop()).toString();
						postfix = (new StringBuilder(String.valueOf(postfix))).append(tmp).toString();
						if (tmp.length() == 1 && isOperator(tmp.charAt(0)))
							postfix = (new StringBuilder(String.valueOf(postfix))).append("   ").toString();
					}
					stk.pop();
					postfix = (new StringBuilder(String.valueOf(postfix))).append("   ").toString();
					break;

				case 37: // '%'
				case 42: // '*'
				case 43: // '+'
				case 45: // '-'
				case 47: // '/'
				case 94: // '^'
					while (!stk.empty() && stk.peek() != "(" && checkPrecedence(stk.peek().toString(), (new Character(op)).toString())) 
						postfix = (new StringBuilder(String.valueOf(postfix))).append(stk.pop()).append("   ").toString();
					stk.push((new Character(op)).toString());
					break;

				case 126: // '~'
					postfix = (new StringBuilder(String.valueOf(postfix))).append("   2   ~    ").toString();
					break;

				default:
					errorStr = (new StringBuilder("���ڲ�֧�ֵ�������[")).append(op).append("]").toString();
					return null;
				}
			}

		for (ListIterator it = stk.listIterator(stk.size()); it.hasPrevious();)
			postfix = (new StringBuilder(String.valueOf(postfix))).append(it.previous()).append("   ").toString();

		return postfix.trim().replaceAll("   +\\.", ".");
	}

	private boolean checkPrecedence(String op1, String op2)
	{
		int op1value = 0;
		int op2value = 0;
		if (op1.equals("+") || op1.equals("-"))
			op1value = 1;
		else
		if (op1.equals("*") || op1.equals("/"))
			op1value = 2;
		else
		if (op1.equals("%"))
			op1value = 3;
		else
		if (op1.equals("^") || op1.equals("~"))
			op1value = 4;
		if (op2.equals("+") || op2.equals("-"))
			op2value = 1;
		else
		if (op2.equals("*") || op2.equals("/"))
			op2value = 2;
		else
		if (op2.equals("%"))
			op2value = 3;
		else
		if (op2.equals("^") || op2.equals("~"))
			op2value = 4;
		return op1value >= op2value;
	}

	public String getErrorStr()
	{
		return errorStr;
	}

	public static void main(String args[])
	{
		MathCalTool ttCalStr = new MathCalTool();
		String str = "34*100/10*(65*98)/23";
		str = "98*1000-(230^5)~/76*(1-3~+230*23^3-10/34*10*78/56*100)";
		System.out.println((new StringBuilder("����ʽ��")).append(str).toString());
		ttCalStr.setExpress(str);
		long data = (new Date()).getTime();
		System.out.println((new StringBuilder("������")).append(ttCalStr.getResult()).toString());
		long data2 = (new Date()).getTime();
		System.out.println((new StringBuilder("����ʱ��:")).append(data2 - data).toString());
	}
}
