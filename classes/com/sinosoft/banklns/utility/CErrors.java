// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CErrors.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.pubfun.PubFun;
import java.io.Serializable;
import java.util.Vector;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CError, VData

public class CErrors
	implements Cloneable, Serializable
{

	private static final long serialVersionUID = 1L;
	private Vector vErrors;
	private int errorCount;
	private String flag;
	private String content;
	private String result;

	public Object clone()
		throws CloneNotSupportedException
	{
		CErrors cloned = (CErrors)super.clone();
		return cloned;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String f)
	{
		flag = f;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String c)
	{
		content = c;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String c)
	{
		result = c;
	}

	public CErrors()
	{
		vErrors = new Vector();
		errorCount = 0;
		flag = "";
		content = "";
		result = "";
	}

	public void addOneError(CError cError)
	{
		vErrors.add(cError);
		errorCount++;
	}

	public void addOneError(String cErrorString)
	{
		CError tError = new CError(cErrorString.trim());
		vErrors.add(tError);
		errorCount++;
	}

	public void removeLastError()
	{
		if (errorCount > 0)
		{
			vErrors.removeElementAt(errorCount - 1);
			errorCount--;
		}
	}

	public void removeError(int pos)
	{
		if (errorCount > 0 && pos < errorCount)
		{
			vErrors.removeElementAt(pos);
			errorCount--;
		}
	}

	public void clearErrors()
	{
		vErrors.clear();
		errorCount = 0;
	}

	public int getErrorCount()
	{
		return errorCount;
	}

	public CError getError(int indexError)
	{
		CError tError = (CError)vErrors.get(indexError);
		return tError;
	}

	public String getFirstError()
	{
		String strMsg;
		CError tError = (CError)vErrors.get(0);
		strMsg = tError.errorMessage;
		strMsg = strMsg.replace('\n', ' ');
		strMsg = strMsg.replace('"', ' ');
		strMsg = strMsg.replace('\'', ' ');
		return strMsg;
		Exception e;
		e;
		return "";
	}

	public String getLastError()
	{
		if (errorCount < 1)
			return "";
		String strMsg;
		CError tError = (CError)vErrors.get(errorCount - 1);
		strMsg = tError.errorMessage;
		strMsg = strMsg.replace('\n', ' ');
		strMsg = strMsg.replace('"', ' ');
		strMsg = strMsg.replace('\'', ' ');
		return strMsg;
		Exception e;
		e;
		return "";
	}

	public boolean needDealError()
	{
		Exception e;
		return getErrorCount() > 0;
		e;
		return false;
	}

	public void copyAllErrors(CErrors cSourceErrors)
	{
		int i = 0;
		int iMax = 0;
		iMax = cSourceErrors.getErrorCount();
		for (i = 0; i < iMax; i++)
			addOneError(cSourceErrors.getError(i));

	}

	public String getErrType()
	{
		int forbitNum = 0;
		int needSelectNum = 0;
		int allowNum = 0;
		int unknowNum = 0;
		for (int i = 0; i < vErrors.size(); i++)
		{
			CError tError = (CError)vErrors.get(i);
			if (tError.errorType.equals("1"))
				forbitNum++;
			else
			if (tError.errorType.equals("3"))
				needSelectNum++;
			else
			if (tError.errorType.equals("2"))
				allowNum++;
			else
				unknowNum++;
		}

		if (forbitNum > 0)
			return "1";
		if (needSelectNum > 0)
			return "3";
		if (allowNum > 0)
			return "2";
		if (unknowNum > 0)
			return "4";
		else
			return "0";
	}

	public String getErrContent()
	{
		content = (new StringBuilder("????????? ")).append(vErrors.size()).append(" ?????\n").toString();
		String forbitContent = "";
		String needSelectContent = "";
		String allowContent = "";
		String unknowContent = "";
		for (int i = 0; i < vErrors.size(); i++)
		{
			CError tError = (CError)vErrors.get(i);
			if (tError.errorType.equals("1"))
				forbitContent = (new StringBuilder(String.valueOf(forbitContent))).append("  ").append("?????????").append(tError.errorNo).append("??").append(tError.errorMessage).append("\n").toString();
			else
			if (tError.errorType.equals("3"))
				needSelectContent = (new StringBuilder(String.valueOf(needSelectContent))).append("  ").append("?????????").append(tError.errorNo).append("??").append(tError.errorMessage).append("\n").toString();
			else
			if (tError.errorType.equals("2"))
				allowContent = (new StringBuilder(String.valueOf(allowContent))).append("  ").append("?????????").append(tError.errorNo).append("??").append(tError.errorMessage).append("\n").toString();
			else
				unknowContent = (new StringBuilder(String.valueOf(unknowContent))).append("  ").append("????????????????").append(tError.errorMessage).append("\n").toString();
		}

		if (!forbitContent.equals(""))
			content = (new StringBuilder(String.valueOf(content))).append("???????????:\n").append(forbitContent).toString();
		if (!needSelectContent.equals(""))
			content = (new StringBuilder(String.valueOf(content))).append("??????????????:\n").append(needSelectContent).toString();
		if (!allowContent.equals(""))
			content = (new StringBuilder(String.valueOf(content))).append("???????????????:\n").append(allowContent).toString();
		if (!unknowContent.equals(""))
			content = (new StringBuilder(String.valueOf(content))).append("???????????:\n").append(unknowContent).toString();
		return content;
	}

	public void checkErrors(CErrors cerrors)
	{
		if (cerrors.getErrType().equals("0"))
		{
			content = "??????";
			flag = "Success";
		} else
		{
			String ErrorContent = cerrors.getErrContent();
			if (cerrors.getErrType().equals("2"))
			{
				content = (new StringBuilder("?????????????")).append(PubFun.changForHTML(ErrorContent)).toString();
				flag = "Success";
			} else
			{
				content = (new StringBuilder("??????????????")).append(PubFun.changForHTML(ErrorContent)).toString();
				flag = "Fail";
			}
		}
	}

	public void checkWSErrors(VData v)
	{
		String type = (String)v.get(0);
		if (type.equals("0"))
		{
			content = "??????";
			flag = "Success";
			if (v.size() > 1)
				result = (String)v.get(1);
		} else
		if (type.equals("2"))
		{
			content = (new StringBuilder("?????????????")).append(PubFun.changForHTML((String)v.get(1))).toString();
			flag = "Success";
		} else
		{
			content = (new StringBuilder("??????????????")).append(PubFun.changForHTML((String)v.get(1))).toString();
			flag = "Fail";
		}
	}

	public static void main(String args1[])
	{
	}
}
