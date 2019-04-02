// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   NBContNoSynServlet.java

package com.sinosoft.banklns.lnsmodel.webservice;

import com.sinosoft.banklns.lis.db.LNPContDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.schema.LNPOperationRecordSchema;
import com.sinosoft.banklns.lnsmodel.LNPContBean;
import com.sinosoft.banklns.lnsmodel.PolicyMainInfo;
import com.sinosoft.banklns.lnsmodel.interfaces.FinalSubmissionBean;
import com.sinosoft.banklns.lnsmodel.interfaces.XMLSaveThread;
import com.sinosoft.banklns.utility.VData;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

// Referenced classes of package com.sinosoft.banklns.lnsmodel.webservice:
//			NBConversion

public class NBContNoSynServlet extends HttpServlet
{

	public NBContNoSynServlet()
	{
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
		String respStr = dealRequest(req.getParameter("contStr"));
		resp.setContentType("application/json;charset=utf-8");
		OutputStream os = resp.getOutputStream();
		os.write(respStr.getBytes("UTF-8"));
		os.flush();
		os.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
		StringBuffer strBuffer = new StringBuffer();
		String readLine = null;
		BufferedReader reader = req.getReader();
		while ((readLine = reader.readLine()) != null) 
			strBuffer.append(readLine);
		String respStr = dealRequest(strBuffer.toString());
		resp.setContentType("application/json;charset=utf-8");
		OutputStream os = resp.getOutputStream();
		os.write(respStr.getBytes("UTF-8"));
		os.flush();
		os.close();
	}

	private String dealRequest(String jsonReq)
	{
		String respCode = "000000";
		String respInfo = "交易成功";
		String transMsg = "保单号回传成功";
		JSONObject errorObj = new JSONObject();
		JSONArray failContList = new JSONArray();
		int error = 0;
		System.out.println((new StringBuilder("请求信息: ")).append(jsonReq).toString());
		JSONObject reqJson = JSONObject.fromObject(jsonReq);
		JSONObject nbUCRTO_REC = reqJson.getJSONObject("NBUCRTO_REC");
		String system = nbUCRTO_REC.getString("System");
		String reqTime = nbUCRTO_REC.getString("ReqTime");
		String transNo = nbUCRTO_REC.getString("TransNo");
		String transCode = nbUCRTO_REC.getString("TransCode");
		JSONObject pOLICYLIST = nbUCRTO_REC.getJSONObject("POLICYLIST");
		JSONObject policy = pOLICYLIST.getJSONObject("POLICY");
		String contNo = policy.getString("TTMPRCNO");
		String mainpolNo = policy.getString("CHDRNUM");
		String errCode = policy.getString("ERRCODE");
		String pdesc = policy.getString("PDESC");
		System.out.println((new StringBuilder("交易发起系统: ")).append(system).append(" 交易流水号: ").append(transNo).append(" 交易类型: ").append(transCode).append(" 交易时间: ").append(reqTime).toString());
		LNPContDB ld = new LNPContDB();
		ld.setContNo(contNo);
		boolean info = ld.getInfo();
		if (contNo == null || "".equals(contNo))
		{
			respCode = "11111";
			transMsg = "投保单号不能为空，请检查";
			errorObj.put("PrtNo", contNo);
			errorObj.put("ContNo", mainpolNo);
			errorObj.put("FailDesc", "投保单号不能为空，请检查");
			failContList.add(errorObj);
			error = 1;
		} else
		if (!info)
		{
			respCode = "11111";
			transMsg = "此投保单号在MDES系统中不存在，请检查";
			errorObj.put("PrtNo", contNo);
			errorObj.put("ContNo", mainpolNo);
			errorObj.put("FailDesc", "此投保单号在MDES系统中不存在，请检查");
			failContList.add(errorObj);
			error = 1;
		} else
		if ("".equals(mainpolNo) && "0".equals(errCode))
		{
			respCode = "11111";
			transMsg = "交易成功时保单号不能为空，请检查";
			errorObj.put("PrtNo", contNo);
			errorObj.put("ContNo", mainpolNo);
			errorObj.put("FailDesc", "交易成功时保单号不能为空，请检查");
			failContList.add(errorObj);
			error = 1;
		} else
		{
			String issue = NBConversion.convertJSON2XML(jsonReq);
			StringReader sr = new StringReader(issue);
			InputSource iss = new InputSource(sr);
			Document doc = null;
			try
			{
				doc = (new SAXBuilder()).build(iss);
			}
			catch (JDOMException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			boolean flag = true;
			FinalSubmissionBean fb = new FinalSubmissionBean();
			fb.returnDoc = doc;
			fb.tContNo = contNo;
			fb.initObject();
			saveXML(contNo, doc, "issue_out");
			flag = fb.getInputData(contNo);
			flag = flag && fb.dealReturn();
			flag = fb.saveData() && flag;
			System.out.println(issue);
			if (!flag || !"0".equals(errCode))
			{
				respCode = "11111";
				transMsg = pdesc;
				errorObj.put("PrtNo", contNo);
				errorObj.put("ContNo", mainpolNo);
				errorObj.put("FailDesc", pdesc);
				failContList.add(errorObj);
				error = 1;
				fb.rollbakData();
				savePolicyState(contNo, "07", "1", PubFun.getCurrentDate(), PubFun.getCurrentTime(), transMsg);
				VData vData = new VData();
				MMap mMap = new MMap();
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContBean contBean = new LNPContBean();
				contBean.setSchema(mainInfo.getContByContNo(contNo));
				contBean.getSchema().setState("07");
				contBean.getSchema().setEditstate("1111001120");
				contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
				contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
				contBean.getSchema().setInputOperator("NB");
				mMap.put(contBean.getSchema(), "UPDATE");
				vData = new VData();
				vData.add(mMap);
				PubSubmit pubSubmit = new PubSubmit();
				pubSubmit.submitData(vData, "");
			}
		}
		JSONObject respObj = new JSONObject();
		respObj.put("System", system);
		respObj.put("ReqTime", reqTime);
		respObj.put("TransNo", transNo);
		respObj.put("TransCode", transCode);
		respObj.put("RespTime", (new StringBuilder(String.valueOf(PubFun.getCurrentDate()))).append(" ").append(PubFun.getCurrentTime()).toString());
		respObj.put("TransMsg", transMsg);
		respObj.put("RespCode", respCode);
		respObj.put("RespInfo", respInfo);
		JSONObject respFailObj = new JSONObject();
		respFailObj.put("ContNum", String.valueOf(error));
		respFailObj.put("ContInfo", failContList);
		respObj.put("FailContInfos", respFailObj);
		return respObj.toString();
	}

	public boolean savePolicyState(String contNo, String state, String recordFlag, String date, String time, String rstMsg)
	{
		LNPOperationRecordSchema operRecordSchema;
		System.out.println("saveOperRecord---start");
		operRecordSchema = new LNPOperationRecordSchema();
		if (date == null || date.equals("") || time == null || time.equals("") || recordFlag == null || recordFlag.equals(""))
			break MISSING_BLOCK_LABEL_299;
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		operRecordSchema.setID(maxNoMap.CreateMaxNo("CustomerNo", ""));
		operRecordSchema.setContNo(contNo);
		operRecordSchema.setOperatorCode("NB");
		operRecordSchema.setOperatorName("NB");
		operRecordSchema.setOperatorType("2");
		operRecordSchema.setOperationDate(date);
		operRecordSchema.setOperationTime(time);
		operRecordSchema.setOperation(recordFlag);
		operRecordSchema.setVarc3("已审核-发送失败");
		operRecordSchema.setVarc1((new StringBuilder(String.valueOf(date))).append(' ').append(time).toString());
		System.out.println((new StringBuilder(String.valueOf(state))).append("<--->").append(operRecordSchema.getVarc3()).toString());
		operRecordSchema.setVarc4(rstMsg);
		operRecordSchema.setVarc2(state);
		MMap map = new MMap();
		VData vd = new VData();
		PubSubmit ps = new PubSubmit();
		map.put(operRecordSchema, "INSERT");
		vd.add(map);
		if (ps.submitData(vd, ""))
			break MISSING_BLOCK_LABEL_288;
		System.out.println("saveOperRecord error");
		return false;
		try
		{
			System.out.println("saveOperRecord success");
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		return false;
	}

	private boolean saveXML(String contNo, Document returnDoc, String fileName)
	{
		try
		{
			saveCreatedXMLFile(returnDoc, fileName, contNo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void saveCreatedXMLFile(Document doc2, String string, String tContNo2)
	{
		(new XMLSaveThread(doc2, string, tContNo2)).start();
	}
}
