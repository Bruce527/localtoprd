// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Rest.java

package com.sinosoft.banklns.lnsmodel.webservice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.vschema.LNPContSet;
import java.io.PrintStream;

public class Rest
{

	public Rest()
	{
	}

	public String getPolicyNo(String json)
	{
		JSONObject returnJson = new JSONObject();
		JSONObject jsonObject = JSONObject.parseObject(json);
		JSONArray RequestBody = (JSONArray)jsonObject.get("REQUESTBODY");
		int status = 0;
		String describtionString = "";
		String contNo = "";
		String policyNo = "";
		try
		{
			if (RequestBody != null)
			{
				JSONObject contnojson = RequestBody.getJSONObject(0);
				contNo = contnojson.getString("CONTNO");
				if (contNo != null)
				{
					System.out.println((new StringBuilder("输入报文：")).append(jsonObject).toString());
					System.out.println((new StringBuilder("---------同步投保单：")).append(contNo).toString());
					if (!"".equals(contNo))
					{
						policyNo = getPlicyNoByCont(contNo);
						if ("".equals(policyNo) || policyNo == null)
						{
							status = -1;
							describtionString = (new StringBuilder(String.valueOf(contNo))).append("未查询到保单号！").toString();
						} else
						{
							status = 0;
						}
					} else
					{
						status = -2;
						describtionString = "投保单号为空！";
					}
				} else
				{
					status = -3;
					describtionString = "输入报文格式有误！";
				}
			} else
			{
				status = -3;
				describtionString = "输入报文格式有误！";
			}
			returnJson.put("MDES_RETURN_STATUS", Integer.valueOf(status));
			if (status != 0)
			{
				returnJson.put("DESCRIBTION", describtionString);
			} else
			{
				returnJson.put("CONTNO", contNo);
				returnJson.put("POLICY_NO", policyNo);
			}
		}
		catch (Exception e)
		{
			System.out.println("文件错误！");
			e.printStackTrace();
		}
		System.out.println((new StringBuilder("返回报文")).append(returnJson.toJSONString()).toString());
		return returnJson.toJSONString();
	}

	private String getPlicyNoByCont(String contNo)
	{
		LNPContDB tContBDB = new LNPContDB();
		tContBDB.setContNo(contNo);
		LNPContSet tcontDBSet = tContBDB.query();
		String mainPolNo = "";
		if (tcontDBSet.size() > 0)
			mainPolNo = tcontDBSet.get(1).getMainPolNo();
		return mainPolNo;
	}

	public static void main(String args[])
	{
		Rest rest = new Rest();
		String mainpolNoString = rest.getPlicyNoByCont("201711220922");
		System.out.println(mainpolNoString);
	}
}
