// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.lnsmodel.riskinfo.RiskInfoImpl;
import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
import com.sinosoft.banklns.utility.*;
import java.text.DecimalFormat;
import java.util.*;

public class RiskImpl
{

	public RiskImpl()
	{
	}

	public LNPRiskSchema getRiskInfo(String riskCode)
	{
		LNPRiskDB reLNPRiskDB = new LNPRiskDB();
		reLNPRiskDB.setRiskCode(riskCode);
		if (reLNPRiskDB.getInfo())
			return reLNPRiskDB.getSchema();
		else
			return null;
	}

	public String getURLForRisk(String riskcode, String type)
	{
		String url = null;
		if ("S".equals(type))
		{
			LNPRiskParamDB tLNPRiskParamDB = new LNPRiskParamDB();
			tLNPRiskParamDB.setType("URL");
			tLNPRiskParamDB.setRiskCode(riskcode);
			tLNPRiskParamDB.setParam("elementURL");
			if (tLNPRiskParamDB.getInfo())
			{
				url = tLNPRiskParamDB.getExpression();
			} else
			{
				tLNPRiskParamDB = new LNPRiskParamDB();
				tLNPRiskParamDB.setType("URL");
				tLNPRiskParamDB.setRiskCode("000000");
				tLNPRiskParamDB.setParam("elementURL");
				tLNPRiskParamDB.getInfo();
				url = tLNPRiskParamDB.getExpression();
			}
		} else
		{
			RiskInfoImpl riskInfoImpl = new RiskInfoImpl();
			url = riskInfoImpl.getDocument(riskcode, type);
			if (url != null)
			{
				int end = url.indexOf("=");
				url = url.substring(0, end);
			}
		}
		return url;
	}

	public List getBackShowPolUI(String polNo, IGlobalInput tIGlobalInput)
	{
		return null;
	}

	public List getRiskUIRelaControl(PolElementSchema inPolElementSchema, String controlCode, String conttrolValue, IGlobalInput iglobalinput)
	{
		return null;
	}

	public List getRiskInitUIData(String riskCode, String contNo, String insuredNo, String s, IGlobalInput iglobalinput)
	{
		return null;
	}

	public List getRiskListForType(String riskType, String riskType1, IGlobalInput tIGlobalInput, String insuredNo, String contNo)
	{
		String polManageCom = contNo.substring(0, 2);
		LNPComDB tLNPComDB = new LNPComDB();
		tLNPComDB.setValidCode(polManageCom);
		LNPComSet tLNPComSet = tLNPComDB.query();
		if (tLNPComSet.get(1) != null)
			polManageCom = tLNPComSet.get(1).getComCode();
		else
			polManageCom = "";
		List list = new ArrayList();
		Set set = new HashSet();
		Set set_1 = getMainRiskForTypeExclude(insuredNo, contNo);
		Set set_2 = getRiskForChnlAreaAge(tIGlobalInput, contNo, insuredNo);
		Set set_3 = getRiskForRiskType(riskType, riskType1);
		Set set_4 = getRiskForRiskSaleGroup(tIGlobalInput, polManageCom);
		Set set_5 = getMainRiskForExist(insuredNo, contNo);
		Set set_6 = getOneMainRisk(insuredNo, contNo);
		if (set_2 != null && set_2.size() > 0)
		{
			for (Iterator iterator = set_2.iterator(); iterator.hasNext();)
			{
				String riskcode = iterator.next().toString();
				if (set_1 != null && set_1.contains(riskcode) && set_3 != null && set_3.contains(riskcode) && set_4 != null && set_4.contains(riskcode) && set_5 != null && set_5.contains(riskcode) && set_6 != null && set_6.contains(riskcode))
					set.add(riskcode);
			}

		}
		if (set.size() > 0)
		{
			String sql = "select * from lnprisk where riskcode in (''";
			for (Iterator iterator = set.iterator(); iterator.hasNext();)
				sql = (new StringBuilder(String.valueOf(sql))).append(",'").append(iterator.next().toString()).append("'").toString();

			sql = (new StringBuilder(String.valueOf(sql))).append(") order by riskcode").toString();
			LNPRiskDB reLNPRiskDB = new LNPRiskDB();
			LNPRiskSet reLNPRiskSet = reLNPRiskDB.executeQuery(sql);
			for (int i = 1; reLNPRiskSet != null && i <= reLNPRiskSet.size(); i++)
				list.add(reLNPRiskSet.get(i));

		}
		return list;
	}

	private Set getMainRiskForTypeExclude(String insuredId, String contNo)
	{
		Set set = null;
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setContNo(contNo);
		reLNPPolDB.setInsuredId(insuredId);
		reLNPPolDB.setSubFlag("M");
		LNPPolSet teLNPPolSet = reLNPPolDB.query();
		String existType = null;
		if (teLNPPolSet != null && teLNPPolSet.size() > 0)
		{
			LNPPolSchema temp = teLNPPolSet.get(1);
			String riskcode = temp.getRiskCode();
			LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
			reLNPRiskAppDB.setRiskCode(riskcode);
			if (reLNPRiskAppDB.getInfo())
				existType = reLNPRiskAppDB.getRiskProp();
		}
		LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
		String sql = "select * from lnpriskapp where SubRiskFlag='M' ";
		if (existType != null)
			if (existType.equals("U"))
				sql = (new StringBuilder(String.valueOf(sql))).append(" and RiskProp='U' ").toString();
			else
			if (existType.equals("I"))
				sql = (new StringBuilder(String.valueOf(sql))).append(" and RiskProp='I' ").toString();
			else
				sql = (new StringBuilder(String.valueOf(sql))).append(" and RiskProp<>'I' and  RiskProp<>'U' ").toString();
		LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.executeQuery(sql);
		if (reLNPRiskAppSet != null && reLNPRiskAppSet.size() > 0)
		{
			set = new HashSet();
			for (int i = 1; i <= reLNPRiskAppSet.size(); i++)
			{
				String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
				set.add(riskcode);
			}

		}
		return set;
	}

	private Set getRiskForRiskType(String riskType, String riskType1)
	{
		Set set = null;
		LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
		if (riskType != null && !riskType.equals("") && riskType.length() > 0)
			reLNPRiskAppDB.setRiskProp(riskType);
		if (riskType1 != null && !riskType1.equals("") && riskType1.length() > 0)
		{
			if ("F".equals(riskType1))
				reLNPRiskAppDB.setRiskType1(riskType1);
			if ("R".equals(riskType1))
				reLNPRiskAppDB.setRiskType2(riskType1);
		}
		LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.query();
		if (reLNPRiskAppSet != null && reLNPRiskAppSet.size() > 0)
		{
			set = new HashSet();
			for (int i = 1; i <= reLNPRiskAppSet.size(); i++)
			{
				String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
				set.add(riskcode);
			}

		}
		return set;
	}

	private Set getMainRiskForExist(String insuredId, String contNo)
	{
		Set set = null;
		String sql = (new StringBuilder("select * from lnpriskapp where SubRiskFlag='M' and riskcode not in (select riskcode from lnppol where contno='")).append(contNo).append("' and insuredid='").append(insuredId).append("' and ").append("SubFlag='M')").toString();
		LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
		LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.executeQuery(sql);
		if (reLNPRiskAppSet != null && reLNPRiskAppSet.size() > 0)
		{
			set = new HashSet();
			for (int i = 1; i <= reLNPRiskAppSet.size(); i++)
			{
				String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
				set.add(riskcode);
			}

		}
		return set;
	}

	private Set getOneMainRisk(String insuredId, String contNo)
	{
		Set set = null;
		String sql = (new StringBuilder("select * from lnppol where contno='")).append(contNo).append("' and polno = masterpolno").toString();
		LNPPolDB reLNPPolDBDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = reLNPPolDBDB.executeQuery(sql);
		if (reLNPPolSet != null && reLNPPolSet.size() > 0)
		{
			set = new HashSet();
		} else
		{
			sql = "select * from lnpriskapp where SubRiskFlag='M'";
			LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
			LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.executeQuery(sql);
			if (reLNPRiskAppSet != null && reLNPRiskAppSet.size() > 0)
			{
				set = new HashSet();
				for (int i = 1; i <= reLNPRiskAppSet.size(); i++)
				{
					String riskcode = reLNPRiskAppSet.get(i).getRiskCode();
					set.add(riskcode);
				}

			}
		}
		return set;
	}

	private Set getRiskForChnlAreaAge(IGlobalInput tIGlobalInput, String contNo, String insuredId)
	{
		Set set = new HashSet();
		LNPAppntDB reLNPAppntDB = new LNPAppntDB();
		reLNPAppntDB.setContNo(contNo);
		reLNPAppntDB.getInfo();
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		reLNPInsuredDB.setInsuredId(insuredId);
		reLNPInsuredDB.getInfo();
		int appntAge = reLNPAppntDB.getAppntAge();
		int appAge = reLNPInsuredDB.getAppAge();
		String appAgeType = reLNPInsuredDB.getAppAgeType();
		Set riskappset = null;
		LNPRiskRoleDB tLNPRiskRoleDB = new LNPRiskRoleDB();
		tLNPRiskRoleDB.setRiskRole("01");
		LNPRiskRoleSet tLNPRiskRoleSet = tLNPRiskRoleDB.query();
		if (tLNPRiskRoleSet != null && tLNPRiskRoleSet.size() > 0)
		{
			riskappset = new HashSet();
			for (int i = 1; i <= tLNPRiskRoleSet.size(); i++)
			{
				String riskCode = tLNPRiskRoleSet.get(i).getRiskCode();
				String tempMinAgeType = tLNPRiskRoleSet.get(i).getMinAppAgeFlag();
				int tempMinAge = tLNPRiskRoleSet.get(i).getMinAppAge();
				String tempMaxAgeType = tLNPRiskRoleSet.get(i).getMAXAppAgeFlag();
				int tempMaxAge = tLNPRiskRoleSet.get(i).getMAXAppAge();
				if (appAgeType.equals("D"))
				{
					if (tempMinAgeType.equals("D") && tempMaxAgeType.equals("D") && appAge >= tempMinAge && appAge <= tempMaxAge)
						riskappset.add(riskCode);
					if (tempMinAgeType.equals("D") && tempMaxAgeType.equals("Y") && appAge >= tempMinAge)
						riskappset.add(riskCode);
				} else
				if (appAgeType.equals("Y"))
				{
					if (tempMinAgeType.equals("D") && tempMaxAgeType.equals("Y") && appAge <= tempMaxAge)
						riskappset.add(riskCode);
					if (tempMinAgeType.equals("Y") && tempMaxAgeType.equals("Y") && appAge >= tempMinAge && appAge <= tempMaxAge)
						riskappset.add(riskCode);
				}
			}

		}
		LNPRiskComCtrlDB reLMRiskComCtrl = new LNPRiskComCtrlDB();
		reLMRiskComCtrl.setSaleChnl(tIGlobalInput.chanlesign);
		LNPRiskComCtrlSet teLNPRiskComCtrlSet = reLMRiskComCtrl.query();
		for (int i = 1; teLNPRiskComCtrlSet != null && i <= teLNPRiskComCtrlSet.size(); i++)
		{
			LNPRiskComCtrlSchema reLNPRiskComCtrlSchema = teLNPRiskComCtrlSet.get(i);
			String riskcode = reLNPRiskComCtrlSchema.getRiskCode();
			if (riskappset != null && riskappset.contains(riskcode))
			{
				String comGrp = reLNPRiskComCtrlSchema.getManageComGrp();
				boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
				if (flag)
					set.add(riskcode);
			}
		}

		return set;
	}

	private Set getRiskForRiskSaleGroup(IGlobalInput tIGlobalInput, String polManageCom)
	{
		Set set = null;
		set = new HashSet();
		LNPRiskSaleGroupToRiskDB reLNPRiskSaleGroupToRiskDB = new LNPRiskSaleGroupToRiskDB();
		if ("000000".equals(tIGlobalInput.riskSaleGroup))
		{
			reLNPRiskSaleGroupToRiskDB.setGroupCode(tIGlobalInput.riskSaleGroup);
			LNPRiskSaleGroupToRiskSet teLNPRiskSaleGroupToRiskSet = reLNPRiskSaleGroupToRiskDB.query();
			for (int i = 1; teLNPRiskSaleGroupToRiskSet != null && i <= teLNPRiskSaleGroupToRiskSet.size(); i++)
				set.add(teLNPRiskSaleGroupToRiskSet.get(i).getRiskCode());

		} else
		{
			reLNPRiskSaleGroupToRiskDB.setGroupCode(tIGlobalInput.riskSaleGroup);
			LNPRiskSaleGroupToRiskSet teLNPRiskSaleGroupToRiskSet = reLNPRiskSaleGroupToRiskDB.query();
			for (int i = 1; teLNPRiskSaleGroupToRiskSet != null && i <= teLNPRiskSaleGroupToRiskSet.size(); i++)
				set.add(teLNPRiskSaleGroupToRiskSet.get(i).getRiskCode());

		}
		String reRiskSaleGroup = polManageCom;
		if (reRiskSaleGroup != null && !"".equals(reRiskSaleGroup))
		{
			reLNPRiskSaleGroupToRiskDB.setGroupCode(reRiskSaleGroup);
			LNPRiskSaleGroupToRiskSet teLNPRiskSaleGroupToRiskSet = reLNPRiskSaleGroupToRiskDB.query();
			for (int i = 1; teLNPRiskSaleGroupToRiskSet != null && i <= teLNPRiskSaleGroupToRiskSet.size(); i++)
				set.add(teLNPRiskSaleGroupToRiskSet.get(i).getRiskCode());

		}
		return set;
	}

	public List getRiskTypeList(IGlobalInput tIGlobalInput, String contNo, String insuredNo)
	{
		if (tIGlobalInput == null)
			return null;
		String sql = (new StringBuilder("select * from lnpcode where codetype='RiskType' and code in ( select distinct riskprop from lnpriskapp where riskcode in( select riskcode from lnpriskcomctrl where salechnl='")).append(tIGlobalInput.chanlesign).append("')").append(" and subriskflag='M') order by OTHERSIGN").toString();
		List list = null;
		try
		{
			CodeQueryImpl codeQueryImpl = new CodeQueryImpl();
			list = codeQueryImpl.getInfoBySql(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		List result = new ArrayList();
		LNPCodeSchema temp = new LNPCodeSchema();
		temp.setCode("");
		temp.setCodeName("????????");
		result.add(temp);
		result.addAll(list);
		return result;
	}

	private Set getAllPossibleSubRisk(IGlobalInput tIGlobalInput, String contNo, String insuredId, String flag)
	{
		Set set = null;
		LNPAppntDB reLNPAppntDB = new LNPAppntDB();
		reLNPAppntDB.setContNo(contNo);
		reLNPAppntDB.getInfo();
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(contNo);
		reLNPInsuredDB.setInsuredId(insuredId);
		reLNPInsuredDB.getInfo();
		int appntAge = reLNPAppntDB.getAppntAge();
		int insuredAge = reLNPInsuredDB.getAppAge();
		LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
		reLNPRiskRelaDB.setRelaCode("01");
		reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
		LNPRiskRelaSet reLNPRiskRelaSet = reLNPRiskRelaDB.query();
		if (reLNPRiskRelaSet != null && reLNPRiskRelaSet.size() > 0)
		{
			set = new HashSet();
			for (int i = 1; i <= reLNPRiskRelaSet.size(); i++)
			{
				String riskcode = null;
				if ("S".equals(flag))
					riskcode = reLNPRiskRelaSet.get(i).getRelaRiskCode();
				else
					riskcode = reLNPRiskRelaSet.get(i).getRiskCode();
				int mininsuage = reLNPRiskRelaSet.get(i).getMinInsuredAge();
				int maxinsuage = reLNPRiskRelaSet.get(i).getMaxInsuredAge();
				int minappage = reLNPRiskRelaSet.get(i).getMinAppntAge();
				int maxappage = reLNPRiskRelaSet.get(i).getMaxAppntAge();
				if (mininsuage <= insuredAge && minappage <= appntAge && (maxinsuage <= 0 || maxinsuage >= insuredAge) && (maxappage <= 0 || maxappage >= appntAge))
				{
					String comGrp = reLNPRiskRelaSet.get(i).getManageComGrp();
					boolean dealflag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
					if (dealflag)
						set.add(riskcode);
				}
			}

		}
		return set;
	}

	private Set getSubRiskForCurrentCondition(String contNo, String insuredId, IGlobalInput tIGlobalInput)
	{
		Set set = new HashSet();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setContNo(contNo);
		reLNPPolDB.setInsuredId(insuredId);
		LNPPolSet reLNPPolSet = reLNPPolDB.query();
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
		{
			LNPPolSchema tempLNPPolSchema = reLNPPolSet.get(i);
			String riskcode = tempLNPPolSchema.getRiskCode();
			int PayEndYear = tempLNPPolSchema.getPayEndYear();
			String PayEndYearFlag = tempLNPPolSchema.getPayEndYearFlag();
			String tsql = "";
			ExeSQL query = new ExeSQL();
			SSRS agentSSRS = null;
			if (PayEndYear == 1000)
			{
				tsql = "select code from lnpcode where codetype='SRiskPayIntv100'";
				agentSSRS = query.execSQL(tsql);
			}
			String polno = tempLNPPolSchema.getPolNo();
			Set tempSet = new HashSet();
			for (int j = 1; j <= reLNPPolSet.size(); j++)
			{
				LNPPolSchema tempSubLNPPolSchema = reLNPPolSet.get(j);
				String subriskcode = tempSubLNPPolSchema.getRiskCode();
				String masterpolno = tempSubLNPPolSchema.getMasterPolNo();
				String subpolno = tempSubLNPPolSchema.getPolNo();
				if (!masterpolno.equals(subpolno) && polno.equals(masterpolno))
					tempSet.add(subriskcode);
			}

			LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
			reLNPRiskRelaDB.setRiskCode(riskcode);
			reLNPRiskRelaDB.setRelaCode("01");
			reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
			LNPRiskRelaSet teLNPRiskRelaSet = reLNPRiskRelaDB.query();
			for (int k = 1; teLNPRiskRelaSet != null && k <= teLNPRiskRelaSet.size(); k++)
			{
				String releriskcode = teLNPRiskRelaSet.get(k).getRelaRiskCode();
				boolean sflag = false;
				if (agentSSRS != null && agentSSRS.MaxRow > 0)
				{
					for (int j = 1; j <= agentSSRS.MaxRow; j++)
						if (releriskcode.equals(agentSSRS.GetText(j, 1).trim()))
							sflag = true;

				} else
				{
					SSRS subSSRS = null;
					String tsql1 = (new StringBuilder("select 1 from LNPRiskScreen where riskcode='")).append(releriskcode).append("' and CtrlType='PayEndYear' and CtrlProperty1='02'").toString();
					subSSRS = query.execSQL(tsql1);
					if (subSSRS != null && subSSRS.MaxRow > 0)
					{
						String tsql2 = (new StringBuilder("select * from lnpcode where codetype like '%")).append(releriskcode).append("' and codealias is not null and comcode='RE'").toString();
						subSSRS = query.execSQL(tsql2);
						if (subSSRS != null && subSSRS.MaxRow > 0)
						{
							for (int j = 1; j <= subSSRS.MaxRow; j++)
							{
								if (PayEndYear != Integer.parseInt(subSSRS.GetText(j, 2)) || !PayEndYearFlag.equals(subSSRS.GetText(j, 4)))
									continue;
								sflag = true;
								break;
							}

						}
					} else
					{
						sflag = true;
					}
				}
				if (!tempSet.contains(releriskcode) && sflag)
					set.add(releriskcode);
			}

		}

		return set;
	}

	private boolean checkComCodeGrp(String comGrp, String comcode)
	{
		boolean flag = false;
		if ("000000".equals(comGrp))
		{
			flag = true;
		} else
		{
			LNPComGrpToComDB rerLNPComGrpToCom = new LNPComGrpToComDB();
			rerLNPComGrpToCom.setComGrpCode(comGrp);
			LNPComGrpToComSet teLNPComGrpToComSet = rerLNPComGrpToCom.query();
			for (int j = 1; teLNPComGrpToComSet != null && j <= teLNPComGrpToComSet.size(); j++)
			{
				LNPComGrpToComSchema temp = teLNPComGrpToComSet.get(j);
				if (comcode == null || comcode.indexOf(temp.getComCode()) != 0)
					continue;
				flag = true;
				break;
			}

		}
		return flag;
	}

	public List getSubRiskList(IGlobalInput tIGlobalInput, String insuredNo, String contNo)
	{
		String polManageCom = contNo.substring(0, 2);
		LNPComDB tLNPComDB = new LNPComDB();
		tLNPComDB.setValidCode(polManageCom);
		LNPComSet tLNPComSet = tLNPComDB.query();
		if (tLNPComSet.get(1) != null)
			polManageCom = tLNPComSet.get(1).getComCode();
		else
			polManageCom = "";
		List list = new ArrayList();
		Set set = new HashSet();
		Set set_1 = getRiskForChnlAreaAge(tIGlobalInput, contNo, insuredNo);
		Set set_2 = getRiskForRiskSaleGroup(tIGlobalInput, polManageCom);
		Set set_3 = getAllPossibleSubRisk(tIGlobalInput, contNo, insuredNo, "S");
		Set set_4 = getSubRiskForCurrentCondition(contNo, insuredNo, tIGlobalInput);
		if (set_4 != null && set_4.size() > 0)
		{
			for (Iterator iterator = set_4.iterator(); iterator.hasNext();)
			{
				String riskcode = iterator.next().toString();
				if (set_1 != null && set_1.contains(riskcode) && set_3 != null && set_3.contains(riskcode) && set_2 != null && set_2.contains(riskcode))
					set.add(riskcode);
			}

		}
		if (set.size() > 0)
		{
			String sql = "select * from lnprisk where riskcode in (''";
			for (Iterator iterator = set.iterator(); iterator.hasNext();)
				sql = (new StringBuilder(String.valueOf(sql))).append(",'").append(iterator.next().toString()).append("'").toString();

			sql = (new StringBuilder(String.valueOf(sql))).append(") order by riskcode").toString();
			LNPRiskDB reLNPRiskDB = new LNPRiskDB();
			LNPRiskSet reLNPRiskSet = reLNPRiskDB.executeQuery(sql);
			for (int i = 1; reLNPRiskSet != null && i <= reLNPRiskSet.size(); i++)
				list.add(reLNPRiskSet.get(i));

		}
		return list;
	}

	public List getMainRiskInfoList(String subRiskCode, IGlobalInput tIGlobalInput, String insuredNo, String contNo)
	{
		String polManageCom = contNo.substring(0, 2);
		LNPComDB tLNPComDB = new LNPComDB();
		tLNPComDB.setValidCode(polManageCom);
		LNPComSet tLNPComSet = tLNPComDB.query();
		if (tLNPComSet.get(1) != null)
			polManageCom = tLNPComSet.get(1).getComCode();
		else
			polManageCom = "";
		List list = new ArrayList();
		Set set = new HashSet();
		Set set_1 = getRiskForChnlAreaAge(tIGlobalInput, contNo, insuredNo);
		Set set_2 = getRiskForRiskSaleGroup(tIGlobalInput, polManageCom);
		Set set_3 = getAllPossibleSubRisk(tIGlobalInput, contNo, insuredNo, "M");
		if (set_3 != null && set_3.size() > 0)
		{
			for (Iterator iterator = set_3.iterator(); iterator.hasNext();)
			{
				String riskcode = iterator.next().toString();
				if (set_1 != null && set_1.contains(riskcode) && set_2 != null && set_2.contains(riskcode))
					set.add(riskcode);
			}

			LNPPolDB reLNPPolDB = new LNPPolDB();
			reLNPPolDB.setContNo(contNo);
			reLNPPolDB.setInsuredId(insuredNo);
			LNPPolSet reLNPPolSet = reLNPPolDB.query();
			String sql = (new StringBuilder("select * from lnppol where contno='")).append(contNo).append("' and insuredid='").append(insuredNo).append("' and ").append("riskcode in (select riskcode from LnpRiskRela where relacode='01' ").append("and relariskcode='").append(subRiskCode).append("')").toString();
			LNPPolSet mainLNPPolSet = reLNPPolDB.executeQuery(sql);
			ExeSQL query = new ExeSQL();
			String tsql = (new StringBuilder("select code from lnpcode where codetype='SRiskPayIntv100' and code = '")).append(subRiskCode).append("'").toString();
			SSRS agentSSRS = query.execSQL(tsql);
			for (int i = 1; mainLNPPolSet != null && i <= mainLNPPolSet.size(); i++)
			{
				LNPPolSchema tempLNPPolSchema = mainLNPPolSet.get(i);
				if (set != null && set.contains(tempLNPPolSchema.getRiskCode()))
				{
					boolean sign = false;
					for (int j = 1; j <= reLNPPolSet.size(); j++)
					{
						if (reLNPPolSet.get(j).getMasterPolNo().equals(reLNPPolSet.get(j).getPolNo()) || !reLNPPolSet.get(j).getMasterPolNo().equals(tempLNPPolSchema.getPolNo()) || !reLNPPolSet.get(j).getRiskCode().equals(subRiskCode))
							continue;
						sign = true;
						break;
					}

					if (tempLNPPolSchema.getPayEndYear() == 1000 && agentSSRS.MaxRow == 0)
						sign = true;
					if (!sign)
						list.add(tempLNPPolSchema);
				}
			}

		}
		return list;
	}

	public boolean checkRiskGroup(String mainRiskCode, String subRiskCode, IGlobalInput tIGlobalInput, int insuAge, int appntAge)
	{
		boolean result = false;
		LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
		reLNPRiskRelaDB.setRiskCode(mainRiskCode);
		reLNPRiskRelaDB.setRelaRiskCode(subRiskCode);
		reLNPRiskRelaDB.setRelaCode("02");
		reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
		LNPRiskRelaSet etLNPRiskRelaSet = reLNPRiskRelaDB.query();
		for (int i = 1; etLNPRiskRelaSet != null && i <= etLNPRiskRelaSet.size(); i++)
		{
			LNPRiskRelaSchema temLNPRiskRelaSchema = etLNPRiskRelaSet.get(i);
			String comGrp = temLNPRiskRelaSchema.getManageComGrp();
			int mininsuage = temLNPRiskRelaSchema.getMinInsuredAge();
			int maxinsuage = temLNPRiskRelaSchema.getMaxInsuredAge();
			int minappage = temLNPRiskRelaSchema.getMinAppntAge();
			int maxappage = temLNPRiskRelaSchema.getMaxAppntAge();
			if (mininsuage > insuAge || minappage > appntAge || maxinsuage > 0 && maxinsuage < insuAge || maxappage > 0 && maxappage < appntAge)
				continue;
			boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
			if (!flag)
				continue;
			result = true;
			break;
		}

		return result;
	}

	public String getSubRiskOfRiskGroup(String mainRiskCode, IGlobalInput tIGlobalInput, int insuAge, int appntAge)
	{
		String subRiskCode = null;
		LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
		reLNPRiskRelaDB.setRiskCode(mainRiskCode);
		reLNPRiskRelaDB.setRelaCode("02");
		reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
		LNPRiskRelaSet etLNPRiskRelaSet = reLNPRiskRelaDB.query();
		for (int i = 1; etLNPRiskRelaSet != null && i <= etLNPRiskRelaSet.size(); i++)
		{
			LNPRiskRelaSchema temLNPRiskRelaSchema = etLNPRiskRelaSet.get(i);
			String comGrp = temLNPRiskRelaSchema.getManageComGrp();
			int mininsuage = temLNPRiskRelaSchema.getMinInsuredAge();
			int maxinsuage = temLNPRiskRelaSchema.getMaxInsuredAge();
			int minappage = temLNPRiskRelaSchema.getMinAppntAge();
			int maxappage = temLNPRiskRelaSchema.getMaxAppntAge();
			if (mininsuage > insuAge || minappage > appntAge || maxinsuage > 0 && maxinsuage < insuAge || maxappage > 0 && maxappage < appntAge)
				continue;
			boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
			if (!flag)
				continue;
			subRiskCode = temLNPRiskRelaSchema.getRelaRiskCode();
			break;
		}

		return subRiskCode;
	}

	public boolean checkSubRisk(String mainRiskCode, String subRiskCode, IGlobalInput tIGlobalInput, int insuAge, int appntAge)
	{
		boolean result = false;
		LNPRiskRelaDB reLNPRiskRelaDB = new LNPRiskRelaDB();
		reLNPRiskRelaDB.setRiskCode(mainRiskCode);
		reLNPRiskRelaDB.setRelaRiskCode(subRiskCode);
		reLNPRiskRelaDB.setRelaCode("01");
		reLNPRiskRelaDB.setSaleChnl(tIGlobalInput.chanlesign);
		LNPRiskRelaSet etLNPRiskRelaSet = reLNPRiskRelaDB.query();
		for (int i = 1; etLNPRiskRelaSet != null && i <= etLNPRiskRelaSet.size(); i++)
		{
			LNPRiskRelaSchema temLNPRiskRelaSchema = etLNPRiskRelaSet.get(i);
			String comGrp = temLNPRiskRelaSchema.getManageComGrp();
			int mininsuage = temLNPRiskRelaSchema.getMinInsuredAge();
			int maxinsuage = temLNPRiskRelaSchema.getMaxInsuredAge();
			int minappage = temLNPRiskRelaSchema.getMinAppntAge();
			int maxappage = temLNPRiskRelaSchema.getMaxAppntAge();
			if (mininsuage > insuAge || minappage > appntAge || maxinsuage > 0 && maxinsuage < insuAge || maxappage > 0 && maxappage < appntAge)
				continue;
			boolean flag = checkComCodeGrp(comGrp, tIGlobalInput.ComCode);
			if (!flag)
				continue;
			result = true;
			break;
		}

		return result;
	}

	public Set getExemptRisk()
	{
		LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
		reLNPRiskAppDB.setRiskProp("R");
		LNPRiskAppSet reLNPRiskAppSet = reLNPRiskAppDB.query();
		Set set = new HashSet();
		for (int i = 1; reLNPRiskAppSet != null && i <= reLNPRiskAppSet.size(); i++)
			set.add(reLNPRiskAppSet.get(i).getRiskCode());

		return set;
	}

	public String getTotalOfSuggest(String contNo)
	{
		DecimalFormat myformat = new DecimalFormat("#,##0");
		DecimalFormat myformatdo = new DecimalFormat("#,##0.00");
		String resultStr = null;
		double result = 0.0D;
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setContNo(contNo);
		LNPPolSet reLNPPolSet = reLNPPolDB.query();
		if (reLNPPolSet != null && reLNPPolSet.size() > 0)
		{
			for (int i = 1; i <= reLNPPolSet.size(); i++)
				result += reLNPPolSet.get(i).getSumPrem();

			double check = (int)result;
			if (check == result)
				resultStr = myformatdo.format(result);
			else
				resultStr = myformatdo.format(result);
		}
		return resultStr;
	}
}
