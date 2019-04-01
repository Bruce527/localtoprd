// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UWResultTableBean.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.utility.ExeSQL;
import com.sinosoft.banklns.utility.SSRS;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo

public class UWResultTableBean
{

	List uwResultMainList;
	List uwResultList;
	int listlength;
	String contno;

	public UWResultTableBean()
	{
	}

	public void init()
	{
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contno = (String)session.getAttribute("ContNo");
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				LNPContSchema mainSch = mainInfo.getContByContNo(contno);
				uwResultMainList = new ArrayList();
				uwResultList = new ArrayList();
				listlength = 0;
				String sql = (new StringBuilder("select AppDecision,UWMessages from LNPCUWMaster where contno='")).append(contno).append("' ;").toString();
				ExeSQL tExeSQL = new ExeSQL();
				SSRS tSSRS = tExeSQL.execSQL(sql);
				if (mainSch != null && tSSRS != null && tSSRS.MaxRow > 0)
				{
					if (tSSRS.GetText(1, 1) != null)
						uwResultList.add(new String[] {
							"Overall Decision", tSSRS.GetText(1, 1)
						});
					if (tSSRS.GetText(1, 2) != null && !"".equals(tSSRS.GetText(1, 2).trim()))
					{
						String mainmsg[] = tSSRS.GetText(1, 2).split("\\^");
						for (int i = 0; i < mainmsg.length; i++)
							uwResultList.add(new String[] {
								"Message", mainmsg[i]
							});

					}
					sql = (new StringBuilder("select uwmessages from  LNPIndUWMaster where contno='")).append(contno).append("'").toString();
					SSRS tinsuSSRS = tExeSQL.execSQL(sql);
					if (tinsuSSRS != null && tinsuSSRS != null && tinsuSSRS.MaxRow > 0)
					{
						for (int i = 1; i <= tinsuSSRS.MaxRow; i++)
							if (tinsuSSRS.GetText(i, 1) != null && !"".equals(tinsuSSRS.GetText(i, 1).trim()))
							{
								String mainmsg[] = tinsuSSRS.GetText(i, 1).split("\\^");
								for (int j = 0; j < mainmsg.length; j++)
									uwResultList.add(new String[] {
										"Message", mainmsg[j]
									});

							}

					}
					String lnpuwmasterSQL = (new StringBuilder("select  ridercode,ridername,uwdid,faceamount,healthdeb,healthfe,healthfed,OccupationFactor,OccupationFe,OccupationFed,exclusions,DeclinedCode,DeclinedReason from LNPUWMaster where contno='")).append(contno).append("' and plancode=ridercode ").append("union  all ").append("select  ridercode,ridername,uwdid,faceamount,healthdeb,healthfe").append(",healthfed,OccupationFactor,OccupationFe,OccupationFed,exclusions,").append("DeclinedCode,DeclinedReason from LNPUWMaster where contno='").append(contno).append("' and plancode<>ridercode ").toString();
					SSRS tSSRS2 = tExeSQL.execSQL(lnpuwmasterSQL);
					if (tSSRS2 != null && tSSRS2.MaxRow > 0)
					{
						for (int i = 1; i <= tSSRS2.MaxRow; i++)
						{
							uwResultList.add(new String[] {
								"Product Code", tSSRS2.GetText(i, 1)
							});
							uwResultList.add(new String[] {
								"Product Name", tSSRS2.GetText(i, 2)
							});
							uwResultList.add(new String[] {
								"UWID", tSSRS2.GetText(i, 3)
							});
							uwResultList.add(new String[] {
								"FaceAmount", tSSRS2.GetText(i, 4)
							});
							uwResultList.add(new String[] {
								"health debit", tSSRS2.GetText(i, 5)
							});
							uwResultList.add(new String[] {
								"health flat extra", tSSRS2.GetText(i, 6)
							});
							uwResultList.add(new String[] {
								"health flat extra debit", tSSRS2.GetText(i, 7)
							});
							uwResultList.add(new String[] {
								"occupation factor", tSSRS2.GetText(i, 8)
							});
							uwResultList.add(new String[] {
								"occupation flat extra", tSSRS2.GetText(i, 9)
							});
							uwResultList.add(new String[] {
								"occupation flat extra debit", tSSRS2.GetText(i, 10)
							});
							String ExclusionNameString = tSSRS2.GetText(i, 11).replace("\\^", ",");
							uwResultList.add(new String[] {
								"Exclusion Name", ExclusionNameString
							});
							uwResultList.add(new String[] {
								"Exclusion Duration", ""
							});
							uwResultList.add(new String[] {
								"Declined Code", tSSRS2.GetText(i, 12)
							});
							uwResultList.add(new String[] {
								"Declined Reason", tSSRS2.GetText(i, 13)
							});
						}

					}
					String testSQL = (new StringBuilder("select PEName from LNPIndUWPEMaster where ContNo = '")).append(contno).append("'  ").append("and InsuredId='").append(mainSch.getInsuredId()).append("' order by UWPENo;").toString();
					SSRS tSSRS3 = tExeSQL.execSQL(testSQL);
					String testStr = "";
					if (tSSRS3 != null && tSSRS3.MaxRow > 0)
					{
						testStr = tSSRS3.GetText(1, 1);
						for (int i = 2; i <= tSSRS3.MaxRow; i++)
							testStr = (new StringBuilder(String.valueOf(testStr))).append(",").append(tSSRS3.GetText(i, 1)).toString();

					}
					uwResultList.add(new String[] {
						"Test Reports Required", testStr
					});
				}
				listlength = uwResultList.size();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public List getUwResultList()
	{
		return uwResultList;
	}

	public void setUwResultList(List uwResultList)
	{
		this.uwResultList = uwResultList;
	}

	public int getListlength()
	{
		return listlength;
	}

	public void setListlength(int listlength)
	{
		this.listlength = listlength;
	}

	public List getUwResultMainList()
	{
		return uwResultMainList;
	}

	public void setUwResultMainList(List uwResultMainList)
	{
		this.uwResultMainList = uwResultMainList;
	}
}
