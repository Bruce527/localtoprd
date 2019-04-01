// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RiskPolImpl.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vdb.LNPPolDBSet;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
import com.sinosoft.banklns.lnsmodel.util.SugError;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			RiskImpl, InsuCoreImpl, RiskCheckCenterImpl, PolicyMainInfo

public class RiskPolImpl
{

	public RiskPolImpl()
	{
	}

	public SugError addRisk(PolElementSchema inPolElementSchema, IGlobalInput tGlobalInput)
	{
		RiskImpl riskImpl = new RiskImpl();
		PubFun tPubFun = new PubFun();
		String currentDate = PubFun.getCurrentDate();
		String currentTime = PubFun.getCurrentTime();
		List result = new ArrayList();
		List polElementSchemaList = new ArrayList();
		inPolElementSchema = initPolElementInfo(inPolElementSchema, tGlobalInput);
		PolElementSchema mainPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
		mainPolElementSchema.setMakeDate(currentDate);
		mainPolElementSchema.setMakeTime(currentTime);
		InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
		PolElementSchema outPolElementSchema = insuCoreImpl.calcutePol(mainPolElementSchema);
		polElementSchemaList.add(outPolElementSchema);
		String subriskcode = riskImpl.getSubRiskOfRiskGroup(outPolElementSchema.getRiskCode(), tGlobalInput, inPolElementSchema.getAppAge(), inPolElementSchema.getAppntAge());
		if (subriskcode != null && subriskcode.length() > 0)
		{
			PolElementSchema subPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
			subPolElementSchema.setSubRiskFlag("S");
			subPolElementSchema.setRiskCode(subriskcode);
			subPolElementSchema.setMasterPolNo(outPolElementSchema.getPolNo());
			subPolElementSchema.setMakeDate(currentDate);
			subPolElementSchema.setMakeTime(currentTime);
			PolElementSchema outsubPolElementSchema = insuCoreImpl.calcutePol(subPolElementSchema);
			polElementSchemaList.add(outsubPolElementSchema);
		}
		String masterPolno = getTopPolNo(outPolElementSchema.getPolNo());
		dealWithExemptRisk(masterPolno);
		RiskCheckCenterImpl riskCheckCenterImpl = new RiskCheckCenterImpl();
		SugError sugError = riskCheckCenterImpl.checkForOnePol(outPolElementSchema.getPolNo(), tGlobalInput, "");
		if (sugError.hasError())
		{
			String sql = "delete from lnppol where polno in (''";
			for (int i = 0; i < polElementSchemaList.size(); i++)
				sql = (new StringBuilder(String.valueOf(sql))).append(",'").append(((PolElementSchema)polElementSchemaList.get(i)).getPolNo()).append("'").toString();

			sql = (new StringBuilder(String.valueOf(sql))).append(")").toString();
			ExeSQL reExeSQL = new ExeSQL();
			reExeSQL.execUpdateSQL(sql);
			dealWithExemptRisk(masterPolno);
		} else
		{
			afterupdateRisk(inPolElementSchema.getContNo());
		}
		return sugError;
	}

	private boolean afterupdateRisk(String contno)
	{
		System.out.println("----- ????????????? ???????????????? ----");
		boolean flag = false;
		try
		{
			PubSubmit ps = new PubSubmit();
			MMap mmap = new MMap();
			LNPUWQuestionDB queDB = new LNPUWQuestionDB();
			String sql = (new StringBuilder("select * from LNPUWQuestion where contno='")).append(contno).append("'").toString();
			LNPUWQuestionSet queSet = queDB.executeQuery(sql);
			if (queSet != null && queSet.size() > 0)
				mmap.put(queSet, "DELETE");
			PolicyMainInfo mainInfo = new PolicyMainInfo();
			LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
			if ("2".equals(tLNPContSchema.getUWFlag()))
				tLNPContSchema.setUWFlag("1");
			tLNPContSchema.setApproveFlag("0");
			mmap.put(tLNPContSchema, "UPDATE");
			VData vd = new VData();
			vd.add(mmap);
			if (!ps.submitData(vd, ""))
				flag = false;
			else
				flag = true;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	private PolElementSchema initPolElementInfo(PolElementSchema inPolElementSchema, IGlobalInput tGlobalInput)
	{
		if (inPolElementSchema != null && !"".equals(inPolElementSchema))
		{
			String com = inPolElementSchema.getContNo().substring(0, 2);
			LNPComDB tLNPComDB = new LNPComDB();
			tLNPComDB.setValidCode(com);
			LNPComSet tLNPComSet = tLNPComDB.query();
			if (tLNPComSet.get(1) != null)
				inPolElementSchema.setManageCom(tLNPComSet.get(1).getComCode());
			else
				inPolElementSchema.setManageCom(tGlobalInput.ComCode);
		} else
		{
			inPolElementSchema.setManageCom(tGlobalInput.ComCode);
		}
		inPolElementSchema.setRiskChannel(tGlobalInput.chanlesign);
		inPolElementSchema.setAgentCode(tGlobalInput.Operator);
		inPolElementSchema.setBranchType(tGlobalInput.BranchType);
		LNPAppntDB reLNPAppntDB = new LNPAppntDB();
		reLNPAppntDB.setContNo(inPolElementSchema.getContNo());
		if (reLNPAppntDB.getInfo())
		{
			inPolElementSchema.setAppntAge(reLNPAppntDB.getAppntAge());
			inPolElementSchema.setAppntAgeType(reLNPAppntDB.getAppntAgeType());
			inPolElementSchema.setAppntNo(reLNPAppntDB.getAppntNo());
			inPolElementSchema.setAppntId(reLNPAppntDB.getAppntId());
			inPolElementSchema.setAppntSex(reLNPAppntDB.getAppntSex());
			inPolElementSchema.setAppntOccupationCode(reLNPAppntDB.getOccupationCode());
			inPolElementSchema.setAppntNativePlace(reLNPAppntDB.getNativePlace());
		}
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(inPolElementSchema.getContNo());
		reLNPInsuredDB.setInsuredId(inPolElementSchema.getInsuredId());
		if (reLNPInsuredDB.getInfo())
		{
			inPolElementSchema.setInsuredId(reLNPInsuredDB.getInsuredId());
			inPolElementSchema.setName(reLNPInsuredDB.getName());
			inPolElementSchema.setAppAge(reLNPInsuredDB.getAppAge());
			inPolElementSchema.setAppAgeType(reLNPInsuredDB.getAppAgeType());
			inPolElementSchema.setSex(reLNPInsuredDB.getSex());
			inPolElementSchema.setBirthday(reLNPInsuredDB.getBirthday());
			inPolElementSchema.setOccupationCode(reLNPInsuredDB.getOccupationCode());
			inPolElementSchema.setInsuredNativePlace(reLNPInsuredDB.getNationality());
			inPolElementSchema.setRelationToAppnt(reLNPInsuredDB.getRelationToAppnt());
		}
		return inPolElementSchema;
	}

	private PolElementSchema getInfoFromPol(PolElementSchema inPolElementSchema, LNPPolSchema backLNPPolSchema)
	{
		inPolElementSchema.setRiskCode(backLNPPolSchema.getRiskCode());
		inPolElementSchema.setAmnt(backLNPPolSchema.getAmnt());
		inPolElementSchema.setPrem(backLNPPolSchema.getPrem());
		inPolElementSchema.setDeadAmntType(backLNPPolSchema.getDeadAmntType());
		inPolElementSchema.setTopUpPrem(backLNPPolSchema.getTopUpPrem());
		inPolElementSchema.setMult(backLNPPolSchema.getMult());
		inPolElementSchema.setBonusGetMode(backLNPPolSchema.getBonusGetMode());
		inPolElementSchema.setGet(backLNPPolSchema.getAmnt());
		inPolElementSchema.setLiveGetMode(backLNPPolSchema.getLiveGetMode());
		inPolElementSchema.setGetYear(backLNPPolSchema.getGetYear());
		inPolElementSchema.setGetYearFlag(backLNPPolSchema.getGetYearFlag());
		inPolElementSchema.setInsuYear(backLNPPolSchema.getInsuYear());
		inPolElementSchema.setInsuYearFlag(backLNPPolSchema.getInsuYearFlag());
		inPolElementSchema.setPayEndYear(backLNPPolSchema.getPayEndYear());
		inPolElementSchema.setPayEndYearFlag(backLNPPolSchema.getPayEndYearFlag());
		inPolElementSchema.setPayIntv(backLNPPolSchema.getPayIntv());
		inPolElementSchema.setStandbyFlag1(backLNPPolSchema.getStandbyFlag1());
		inPolElementSchema.setStandbyFlag2(backLNPPolSchema.getStandbyFlag2());
		inPolElementSchema.setStandbyFlag3(backLNPPolSchema.getStandbyFlag3());
		inPolElementSchema.setSubRiskFlag(backLNPPolSchema.getSubFlag());
		inPolElementSchema.setPolNo(backLNPPolSchema.getPolNo());
		inPolElementSchema.setMasterPolNo(backLNPPolSchema.getMasterPolNo());
		inPolElementSchema.setYears(backLNPPolSchema.getYears());
		inPolElementSchema.setPayYears(backLNPPolSchema.getPayYears());
		inPolElementSchema.setMakeDate(backLNPPolSchema.getMakeDate());
		inPolElementSchema.setMakeTime(backLNPPolSchema.getMakeTime());
		return inPolElementSchema;
	}

	public SugError atvUpdateRisk(PolElementSchema inPolElementSchema, IGlobalInput tGlobalInput)
	{
		if (tGlobalInput == null)
			return null;
		inPolElementSchema = initPolElementInfo(inPolElementSchema, tGlobalInput);
		RiskImpl riskImpl = new RiskImpl();
		String subriskcode = riskImpl.getSubRiskOfRiskGroup(inPolElementSchema.getRiskCode(), tGlobalInput, inPolElementSchema.getAppAge(), inPolElementSchema.getAppntAge());
		List list = getPolList(inPolElementSchema.getPolNo(), 1);
		List polListBack = (List)list.get(1);
		String delSql = " (''";
		for (int f = 0; polListBack != null && f < polListBack.size(); f++)
		{
			LNPPolSchema reLNPPolSchema = (LNPPolSchema)polListBack.get(f);
			delSql = (new StringBuilder(String.valueOf(delSql))).append(",'").append(reLNPPolSchema.getPolNo()).append("'").toString();
		}

		delSql = (new StringBuilder(String.valueOf(delSql))).append(") ").toString();
		PubSubmit ps1 = new PubSubmit();
		LNPPolDB poldb = new LNPPolDB();
		MMap mmap1 = new MMap();
		LNPPolSet deLNPPolSet1 = poldb.executeQuery((new StringBuilder("select * from lnppol where polno in ")).append(delSql).toString());
		mmap1.put(deLNPPolSet1, "DELETE");
		VData vd1 = new VData();
		vd1.add(mmap1);
		boolean reflag1 = ps1.submitData(vd1, "");
		List newPolData = new ArrayList();
		String subGroupPolNo = "";
		for (int f = 0; polListBack != null && f < polListBack.size(); f++)
		{
			LNPPolSchema reLNPPolSchema = (LNPPolSchema)polListBack.get(f);
			if (f == 0)
			{
				PolElementSchema mainPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
				mainPolElementSchema.setPolNo(reLNPPolSchema.getPolNo());
				mainPolElementSchema.setMakeDate(reLNPPolSchema.getMakeDate());
				mainPolElementSchema.setMakeTime(reLNPPolSchema.getMakeTime());
				InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
				PolElementSchema outPolElementSchema = insuCoreImpl.calcutePol(mainPolElementSchema);
				newPolData.add(outPolElementSchema);
				if (subriskcode != null && subriskcode.length() > 0)
				{
					for (int s = 0; s < polListBack.size(); s++)
					{
						LNPPolSchema ressLNPPolSchema = (LNPPolSchema)polListBack.get(s);
						if (!ressLNPPolSchema.getMasterPolNo().equals(reLNPPolSchema.getPolNo()) || !ressLNPPolSchema.getRiskCode().equals(subriskcode))
							continue;
						subGroupPolNo = ressLNPPolSchema.getPolNo();
						break;
					}

					PolElementSchema subPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
					subPolElementSchema.setSubRiskFlag("S");
					subPolElementSchema.setRiskCode(subriskcode);
					subPolElementSchema.setMasterPolNo(outPolElementSchema.getPolNo());
					subPolElementSchema.setPolNo(subGroupPolNo);
					subPolElementSchema.setMakeDate(reLNPPolSchema.getMakeDate());
					subPolElementSchema.setMakeTime(reLNPPolSchema.getMakeTime());
					PolElementSchema outsubPolElementSchema = insuCoreImpl.calcutePol(subPolElementSchema);
					newPolData.add(outsubPolElementSchema);
				}
			} else
			if (!subGroupPolNo.equals(reLNPPolSchema.getPolNo()))
			{
				PolElementSchema tempPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
				tempPolElementSchema = getInfoFromPol(tempPolElementSchema, reLNPPolSchema);
				InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
				PolElementSchema outsubPolElementSchema = insuCoreImpl.calcutePol(tempPolElementSchema);
				newPolData.add(outsubPolElementSchema);
			}
		}

		String mainPolno = getTopPolNo(inPolElementSchema.getPolNo());
		dealWithExemptRisk(mainPolno);
		List result = new ArrayList();
		List polList = getPolList(inPolElementSchema.getPolNo(), 1);
		List noList = (List)polList.get(0);
		List polschemaList = (List)polList.get(1);
		LNPPolSet reset = new LNPPolSet();
		boolean flag1 = inPolElementSchema.getPayIntv() == 0 || 1000 == inPolElementSchema.getPayIntv();
		boolean flag = inPolElementSchema.getMasterPolNo().equals(inPolElementSchema.getPolNo()) && flag1;
		if (flag)
		{
			PubSubmit ps = new PubSubmit();
			MMap mmap = new MMap();
			LNPPolDB db = new LNPPolDB();
			String sql = (new StringBuilder("select * from lnppol where masterpolno='")).append(inPolElementSchema.getMasterPolNo()).append("' and masterpolno <>polno ").append("and riskcode not in (select code from lnpcode where codetype='SRiskPayIntv100');").toString();
			LNPPolSet set = db.executeQuery(sql);
			if (set != null && set.size() > 0)
			{
				for (int i = 1; i <= set.size(); i++)
					if (subriskcode == null || subriskcode.length() <= 0 || !subriskcode.equals(set.get(i).getRiskCode()))
					{
						mmap.put(set.get(i), "DELETE");
						reset.add(set.get(i));
					}

			}
			VData vd = new VData();
			vd.add(mmap);
			ps.submitData(vd, "");
		}
		RiskCheckCenterImpl riskCheckCenterImpl = new RiskCheckCenterImpl();
		SugError tempSugError = riskCheckCenterImpl.checkForOnePol(inPolElementSchema.getPolNo(), tGlobalInput, "");
		if (tempSugError.hasError())
		{
			PubSubmit ps = new PubSubmit();
			LNPPolDB poldb2 = new LNPPolDB();
			MMap mmap = new MMap();
			LNPPolSet deLNPPolSet = poldb2.executeQuery((new StringBuilder("select * from lnppol where polno in ")).append(delSql).toString());
			mmap.put(deLNPPolSet, "DELETE");
			VData vd = new VData();
			vd.add(mmap);
			boolean reflag = ps.submitData(vd, "");
			LNPPolDBSet recoverLNPPolDBSet = new LNPPolDBSet();
			for (int f = 0; polListBack != null && f < polListBack.size(); f++)
			{
				LNPPolSchema reLNPPolSchema = (LNPPolSchema)polListBack.get(f);
				if (reLNPPolSchema.getStandbyFlag3() != null && !reLNPPolSchema.getStandbyFlag3().equals("") && !reLNPPolSchema.getRiskCode().equals("CIR(B)") && !reLNPPolSchema.getRiskCode().equals("IAA") && !reLNPPolSchema.getRiskCode().equals("PEN102") && !reLNPPolSchema.getRiskCode().equals("PEN104") && !reLNPPolSchema.getRiskCode().equals("ACI103") && reLNPPolSchema.getStandbyFlag3() != inPolElementSchema.getStandbyFlag3())
					reLNPPolSchema.setStandbyFlag3(inPolElementSchema.getStandbyFlag3());
				recoverLNPPolDBSet.add(reLNPPolSchema);
			}

			recoverLNPPolDBSet.insert();
		} else
		{
			afterupdateRisk(inPolElementSchema.getContNo());
		}
		return tempSugError;
	}

	public void psvUpdateRisk(PolElementSchema inPolElementSchema, List oldPolList, IGlobalInput tGlobalInput)
	{
		InsuCoreImpl insuCoreImpl = new InsuCoreImpl();
		RiskImpl riskImpl = new RiskImpl();
		List inputpolschemaList = (List)oldPolList.get(1);
		inPolElementSchema = initPolElementInfo(inPolElementSchema, tGlobalInput);
		String subGroupPolNo = "";
		String subriskcode = "";
		String mainpolno = "";
		for (int f = 0; inputpolschemaList != null && f < inputpolschemaList.size(); f++)
		{
			LNPPolSchema reLNPPolSchema = (LNPPolSchema)inputpolschemaList.get(f);
			if (f == 0)
			{
				PolElementSchema mainPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
				mainPolElementSchema = getInfoFromPol(mainPolElementSchema, reLNPPolSchema);
				mainpolno = mainPolElementSchema.getPolNo();
				PolElementSchema outPolElementSchema = insuCoreImpl.calcutePol(mainPolElementSchema);
				subriskcode = riskImpl.getSubRiskOfRiskGroup(mainPolElementSchema.getRiskCode(), tGlobalInput, inPolElementSchema.getAppAge(), inPolElementSchema.getAppntAge());
				if (subriskcode != null && subriskcode.length() > 0)
				{
					for (int s = 0; s < inputpolschemaList.size(); s++)
					{
						LNPPolSchema ressLNPPolSchema = (LNPPolSchema)inputpolschemaList.get(s);
						if (!ressLNPPolSchema.getMasterPolNo().equals(reLNPPolSchema.getPolNo()) || !ressLNPPolSchema.getRiskCode().equals(subriskcode))
							continue;
						subGroupPolNo = ressLNPPolSchema.getPolNo();
						break;
					}

					PolElementSchema subPolElementSchema = (PolElementSchema)mainPolElementSchema.clone();
					subPolElementSchema.setSubRiskFlag("S");
					subPolElementSchema.setRiskCode(subriskcode);
					subPolElementSchema.setMasterPolNo(outPolElementSchema.getPolNo());
					subPolElementSchema.setPolNo(subGroupPolNo);
					PolElementSchema polelementschema1 = insuCoreImpl.calcutePol(subPolElementSchema);
				}
				continue;
			}
			if (subGroupPolNo.equals(reLNPPolSchema.getPolNo()))
				continue;
			PolElementSchema tempPolElementSchema = (PolElementSchema)inPolElementSchema.clone();
			tempPolElementSchema = getInfoFromPol(tempPolElementSchema, reLNPPolSchema);
			if (!tempPolElementSchema.getPolNo().equals(tempPolElementSchema.getMasterPolNo()))
			{
				String mainRiskCode = getMainRiskCode(inputpolschemaList, tempPolElementSchema.getMasterPolNo());
				String subRiskCode = tempPolElementSchema.getRiskCode();
				int appage = tempPolElementSchema.getAppAge();
				int appntage = tempPolElementSchema.getAppntAge();
				if (!riskImpl.checkRiskGroup(mainRiskCode, subRiskCode, tGlobalInput, appage, appntage) && !riskImpl.checkSubRisk(mainRiskCode, subRiskCode, tGlobalInput, appage, appntage))
					continue;
			}
			PolElementSchema polelementschema = insuCoreImpl.calcutePol(tempPolElementSchema);
		}

		String exemptsql = (new StringBuilder("select * from lnppol where polno=masterpolno and contNo='")).append(inPolElementSchema.getContNo()).append("' and insuredid='").append(inPolElementSchema.getInsuredId()).append("'").toString();
		LNPPolDB teLNPPolDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = teLNPPolDB.executeQuery(exemptsql);
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
			dealWithExemptRisk(reLNPPolSet.get(i).getPolNo());

	}

	private String getMainRiskCode(List polList, String polno)
	{
		String reuslt = "";
		for (int i = 0; polList != null && i < polList.size(); i++)
		{
			LNPPolSchema tempLNPpolSchema = (LNPPolSchema)polList.get(i);
			if (!polno.equals(tempLNPpolSchema.getPolNo()))
				continue;
			reuslt = tempLNPpolSchema.getRiskCode();
			break;
		}

		return reuslt;
	}

	public List getPolList(String mainpolNo, int serialNo)
	{
		List list = new ArrayList();
		List polList = new ArrayList();
		List noList = new ArrayList();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setPolNo(mainpolNo);
		reLNPPolDB.getInfo();
		polList.add(reLNPPolDB.getSchema());
		noList.add((new StringBuilder()).append(serialNo).toString());
		LNPPolSet rweLNPPolSet = getSubPolInfo(mainpolNo);
		for (int i = 1; rweLNPPolSet != null && i <= rweLNPPolSet.size(); i++)
		{
			LNPPolSchema tempLNPPolSchema = rweLNPPolSet.get(i);
			polList.add(tempLNPPolSchema);
			noList.add((new StringBuilder(String.valueOf(serialNo))).append(".").append(i).toString());
			LNPPolSet subLNPPolSet = getSubPolInfo(tempLNPPolSchema.getPolNo());
			for (int j = 1; subLNPPolSet != null && j <= subLNPPolSet.size(); j++)
			{
				LNPPolSchema tempsubLNPPolSchema = subLNPPolSet.get(i);
				polList.add(tempsubLNPPolSchema);
				noList.add((new StringBuilder(String.valueOf(serialNo))).append(".").append(i).append(".").append(j).toString());
			}

		}

		list.add(noList);
		list.add(polList);
		return list;
	}

	private LNPPolSet getSubPolInfo(String mainpolno)
	{
		LNPPolDB reLNPPolDB = new LNPPolDB();
		String sql = (new StringBuilder("select * from lNPpol where masterpolno<>polno and masterpolno='")).append(mainpolno).append("'  order by MakeDate , MakeTime ASC").toString();
		LNPPolSet teLNPPolSet = reLNPPolDB.executeQuery(sql);
		return teLNPPolSet;
	}

	public boolean checkRiskCanBeDeleted(String polNoArray[], String inusuredNo, String contNo)
	{
		CodeQueryImpl codeQueryImpl = new CodeQueryImpl();
		List polList = new ArrayList();
		for (int i = 0; i < polNoArray.length; i++)
			polList.add(polNoArray[i]);

		boolean flag = true;
		String sql = (new StringBuilder("select * from lnppol where masterpolno<>polno and contNo='")).append(contNo).append("' and insuredid='").append(inusuredNo).append("'").toString();
		LNPPolDB reLNPPolDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
		{
			LNPPolSchema tempLNPPolSchema = reLNPPolSet.get(i);
			if (polList.contains(tempLNPPolSchema.getPolNo()))
				continue;
			try
			{
				List list = codeQueryImpl.getInfoBySql((new StringBuilder("select * from lnpcode where codetype='RiskGroup' and codealias='")).append(tempLNPPolSchema.getRiskCode()).append("'").toString());
				if (list != null && list.size() > 0)
					continue;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			flag = false;
			break;
		}

		return flag;
	}

	public void deletRisk(String polNoArray[], IGlobalInput tGlobalInput)
		throws Exception
	{
		String insuredno = "";
		String contNo = "";
		Set delSet = new HashSet();
		for (int i = 0; polNoArray != null && i < polNoArray.length; i++)
		{
			String polno = transportPolNo(polNoArray[i], tGlobalInput);
			delSet.add(polno);
			if (i == 0)
			{
				LNPPolSchema temp = getPolInfo(polno);
				insuredno = temp.getInsuredId();
				contNo = temp.getContNo();
			}
		}

		if (delSet.size() > 0)
		{
			String fixsql = " (''";
			for (Iterator iterator = delSet.iterator(); iterator.hasNext();)
			{
				String tempStr = iterator.next().toString();
				fixsql = (new StringBuilder(String.valueOf(fixsql))).append(",'").append(tempStr).append("'").toString();
			}

			fixsql = (new StringBuilder(String.valueOf(fixsql))).append(") ").toString();
			String sql = (new StringBuilder("delete from lnppol where polno in ")).append(fixsql).append(" or masterpolno in ").append(fixsql).toString();
			ExeSQL reExeSQL = new ExeSQL();
			reExeSQL.execUpdateSQL(sql);
		}
		String exemptsql = (new StringBuilder("select * from lnppol where polno=masterpolno and contNo='")).append(contNo).append("' and insuredid='").append(insuredno).append("'").toString();
		LNPPolDB teLNPPolDB = new LNPPolDB();
		LNPPolSet reLNPPolSet = teLNPPolDB.executeQuery(exemptsql);
		for (int i = 1; reLNPPolSet != null && i <= reLNPPolSet.size(); i++)
			dealWithExemptRisk(reLNPPolSet.get(i).getPolNo());

	}

	private boolean dealWithSpel_SPA(String contNo, String insuredno)
	{
		boolean flag = false;
		try
		{
			PubSubmit ps = new PubSubmit();
			MMap mmap = new MMap();
			String sql = (new StringBuilder("select * from lnppol where contNo='")).append(contNo).append("' and insuredid='").append(insuredno).append("' and riskcode in ('AMR203','AMR204')").toString();
			LNPPolDB teLNPPolDB = new LNPPolDB();
			LNPPolSet reLNPPolSet = teLNPPolDB.executeQuery(sql);
			sql = (new StringBuilder("select * from lnppol where contNo='")).append(contNo).append("' and insuredid='").append(insuredno).append("' and riskcode = 'SPA'").toString();
			LNPPolSet reSPALNPPolSet = teLNPPolDB.executeQuery(sql);
			if (reLNPPolSet != null && reLNPPolSet.size() > 0 && (reSPALNPPolSet == null || reSPALNPPolSet.size() <= 0))
				mmap.put(reLNPPolSet, "DELETE");
			VData vd = new VData();
			vd.add(mmap);
			if (!ps.submitData(vd, ""))
				flag = false;
			else
				flag = true;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public String transportPolNo(String polNo, IGlobalInput tGlobalInput)
	{
		RiskImpl riskImpl = new RiskImpl();
		String rs_polno = polNo;
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setPolNo(polNo);
		reLNPPolDB.getInfo();
		LNPAppntDB reLNPAppntDB = new LNPAppntDB();
		reLNPAppntDB.setContNo(reLNPPolDB.getContNo());
		reLNPAppntDB.getInfo();
		LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
		reLNPInsuredDB.setContNo(reLNPPolDB.getContNo());
		reLNPInsuredDB.setInsuredId(reLNPPolDB.getInsuredId());
		reLNPInsuredDB.getInfo();
		int appntAge = reLNPAppntDB.getAppntAge();
		int insuredAge = reLNPInsuredDB.getAppAge();
		if (!reLNPPolDB.getPolNo().equals(reLNPPolDB.getMasterPolNo()))
		{
			LNPPolDB mainLNPPolDB = new LNPPolDB();
			mainLNPPolDB.setPolNo(reLNPPolDB.getMasterPolNo());
			mainLNPPolDB.getInfo();
			boolean flag = riskImpl.checkRiskGroup(mainLNPPolDB.getRiskCode(), reLNPPolDB.getRiskCode(), tGlobalInput, insuredAge, appntAge);
			if (flag)
				rs_polno = mainLNPPolDB.getPolNo();
		}
		return rs_polno;
	}

	public LNPPolSchema getPolInfo(String polNo)
	{
		if (polNo == null || polNo.length() == 0)
			return null;
		LNPPolDB reLNPPolDB = new LNPPolDB();
		reLNPPolDB.setPolNo(polNo);
		if (reLNPPolDB.getInfo())
			return reLNPPolDB.getSchema();
		else
			return null;
	}

	public void dealWithExemptRisk(String masterPolno)
	{
		RiskImpl riskImpl = new RiskImpl();
		List list = getPolList(masterPolno, 1);
		List polList = (List)list.get(1);
		List exemptRiskPolList = new ArrayList();
		if (polList != null && polList.size() > 0)
		{
			Set set = riskImpl.getExemptRisk();
			double totalAmnt = 0.0D;
			HashSet hashSet_Exception = new HashSet();
			hashSet_Exception.add("HIA");
			hashSet_Exception.add("HSA");
			hashSet_Exception.add("SBA");
			hashSet_Exception.add("RBA");
			for (int i = 0; i < polList.size(); i++)
			{
				LNPPolSchema tempLNPPolSchema = (LNPPolSchema)polList.get(i);
				String riskcode = tempLNPPolSchema.getRiskCode();
				if (set.contains(riskcode))
					exemptRiskPolList.add(tempLNPPolSchema);
				else
				if (!hashSet_Exception.contains(riskcode))
					totalAmnt += tempLNPPolSchema.getPrem();
			}

			if (exemptRiskPolList.size() > 0)
			{
				for (int i = 0; i < exemptRiskPolList.size(); i++)
				{
					LNPPolSchema tempLNPPolSchema = (LNPPolSchema)exemptRiskPolList.get(i);
					if (tempLNPPolSchema.getAmnt() != 0.0D)
					{
						double prem = (totalAmnt * tempLNPPolSchema.getPrem()) / tempLNPPolSchema.getAmnt();
						tempLNPPolSchema.setPrem(prem);
					}
					tempLNPPolSchema.setAmnt(totalAmnt);
					LNPPolDB reLNPPolDB = new LNPPolDB();
					reLNPPolDB.setSchema(tempLNPPolSchema);
					reLNPPolDB.update();
				}

			}
		}
	}

	public String getTopPolNo(String polno)
	{
		LNPPolSchema MainPoltemp = getPolInfo(polno);
		if (MainPoltemp == null || MainPoltemp.getMasterPolNo().equals(MainPoltemp.getPolNo()))
			return polno;
		else
			return getTopPolNo(MainPoltemp.getMasterPolNo());
	}

	public List getProfitDoc(String polNo, String type)
	{
		return null;
	}

	public List getProfitTbl(String polNo, String type)
	{
		return null;
	}
}
