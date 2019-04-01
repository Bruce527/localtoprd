// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BenefitPersonInfo.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.db.LNPBnfDB;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
import com.sinosoft.banklns.lnsmodel.entity.LNPBnfBean;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			PolicyMainInfo, StateOperatorDeal, PersonFunction

public class BenefitPersonInfo
{

	private boolean operateResult;
	private String message;
	private String infoSource;
	private String contNo;
	private List lnpBnfList;
	private String operatorBnfId;
	private boolean editFlag;
	private boolean scEditFlag;
	private IGlobalInput tempGI;
	private String bnfremoveid;
	private LNPContSchema contSch;
	Map genderMap;
	Map idTypeMap;
	Map relationToInsuredMap;
	private boolean modifyFLag;
	private LNPBnfSchema bnfSgSchema;
	private String sex;
	private String idType;
	private String idPerpetual;
	private int bnfRate;
	private int bnfOrder;
	private List idPerpetualList;
	private String connectionWithInsurance_sc;
	private String connectionWithInsurance_sg;
	private boolean showMessageFlag;

	public BenefitPersonInfo()
	{
		operateResult = true;
		lnpBnfList = new ArrayList();
		genderMap = new HashMap();
		idTypeMap = new HashMap();
		relationToInsuredMap = new HashMap();
		modifyFLag = false;
		idPerpetualList = new ArrayList();
	}

	public void initData()
	{
		System.out.println("-- BenefitPersonInfo initData --");
		connectionWithInsurance_sg = "";
		sex = "";
		idType = "";
		idPerpetual = "";
		initGenderMap();
		initIdTypeMap();
		initRelationToInsuredMap();
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
			if (getEditFlag != null && !getEditFlag.booleanValue())
			{
				infoSource = "undo";
				editFlag = false;
			} else
			{
				editFlag = true;
			}
			bnfSgSchema = new LNPBnfSchema();
			bnfRate = 0;
			bnfOrder = 1;
			tempGI = (IGlobalInput)session.getValue("NPGI");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contNo = (String)session.getAttribute("ContNo");
				PolicyMainInfo mainInfo = new PolicyMainInfo();
				contSch = mainInfo.getContByContNo(contNo);
				lnpBnfList = getLnpBnfList(contNo);
				scEditFlag = !checkScBnfExist(contNo);
				contOrder();
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	public void savebnfSgPeople()
	{
		message = null;
		operateResult = true;
		if (!checkScBnfExist(contNo))
		{
			message = "请先填写生存受益人信息";
			operateResult = false;
			return;
		}
		System.out.println("----  savebnfSgPeople start ------");
		if (!checkconnectionWithInsuranceSelf())
		{
			operateResult = false;
			return;
		}
		bnfSgSchema.setBnfSex(sex);
		bnfSgSchema.setIDType(idType);
		bnfSgSchema.setRelationToInsured(connectionWithInsurance_sg);
		bnfSgSchema.setBenefitRate(bnfRate);
		bnfSgSchema.setBenefitOrder(Integer.toString(bnfOrder));
		bnfSgSchema.setIDPerpetual(idPerpetual);
		if ("0".equals(bnfSgSchema.getIDPerpetual().trim()) && bnfSgSchema.getIDValidity() != null)
			bnfSgSchema.setIDValidity(bnfSgSchema.getIDValidity());
		else
			bnfSgSchema.setIDValidity("");
		if (!validate())
		{
			operateResult = false;
			return;
		}
		if (modifyFLag)
		{
			infoSource = "modify";
			if (modifySgBnf())
			{
				message = "身故受益人更新成功！";
				contOrder();
			} else
			{
				operateResult = false;
				return;
			}
			break MISSING_BLOCK_LABEL_265;
		}
		try
		{
			infoSource = "add";
			if (addSgBnf())
			{
				message = "身故受益人保存成功！";
				contOrder();
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		System.out.println("----  savebnfSgPeople end ------");
		return;
	}

	public void modifyBnf()
	{
		operateResult = true;
		message = "";
		try
		{
			System.out.println(" -- modifyBnf -- ");
			Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String bnfId = (String)requestMap.get("bnfId");
			operatorBnfId = bnfId;
			modifyFLag = true;
			bnfSgSchema = getBnfSgSchByBnfId(contNo, bnfId, "2");
			bnfOrder = Integer.parseInt(bnfSgSchema.getBenefitOrder());
			sex = bnfSgSchema.getBnfSex();
			idType = bnfSgSchema.getIDType();
			idPerpetual = bnfSgSchema.getIDPerpetual();
			connectionWithInsurance_sg = bnfSgSchema.getRelationToInsured();
			DecimalFormat df = new DecimalFormat("0");
			bnfRate = Integer.parseInt(df.format(bnfSgSchema.getBenefitRate()));
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteBnf()
	{
		bnfSgSchema = new LNPBnfSchema();
		sex = null;
		idType = null;
		connectionWithInsurance_sg = null;
		bnfRate = 0;
		operateResult = true;
		message = "";
		System.out.println(" -- deleteBnf -- ");
		try
		{
			LNPBnfSchema deleteBnf = getBnfSgSchByBnfId(contNo, bnfremoveid, "2");
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(deleteBnf, "DELETE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				System.out.println("-BenefitPersonInfo-删除错误");
				message = "身故受益人信息删除失败！";
				operateResult = false;
			} else
			{
				message = "身故受益人信息删除成功！";
				operateResult = true;
				removeNodeFromList(bnfremoveid);
				contOrder();
				String sql = (new StringBuilder("select count(*) from lnpbnf where contno='")).append(deleteBnf.getContNo()).append("' and benefittype='2' ").toString();
				ExeSQL tExeSQL = new ExeSQL();
				SSRS tSSRS = tExeSQL.execSQL(sql);
				int i = Integer.parseInt(tSSRS.GetText(1, 1));
				if (i == 0)
				{
					String date = PubFun.getCurrentDate();
					String time = PubFun.getCurrentTime();
					StateOperatorDeal operatorDeal = new StateOperatorDeal();
					List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delate", "06");
					contSch.setState((String)stateList.get(0));
					contSch.setEditstate((String)stateList.get(1));
					if ("2".equals(contSch.getUWFlag()))
						contSch.setUWFlag("1");
					contSch.setModifyDate(date);
					contSch.setModifyTime(time);
					map = new MMap();
					map.put(contSch, "UPDATE");
					vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
					{
						message = "投保书资料维护失败！";
						operateResult = false;
					}
				}
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			operateResult = false;
		}
		System.out.println((new StringBuilder("message : ")).append(message).toString());
	}

	private boolean addSgBnf()
	{
		int sum = getBnfRateSumFun(bnfOrder);
		if (sum != -1 && sum + bnfRate > 100)
		{
			message = "同一受益顺序受益比例之和不能大于100";
			operateResult = false;
			return false;
		}
		if (lnpBnfList == null)
			lnpBnfList = new ArrayList();
		LNPBnfSchema getReBnf = addBnfOfNewCutomer();
		if (getReBnf != null)
		{
			LNPBnfBean bean = new LNPBnfBean();
			bean.setSchema(getReBnf);
			lnpBnfList.add(bean);
			reSetSgInfo();
			return true;
		} else
		{
			return false;
		}
	}

	private LNPBnfSchema addBnfOfNewCutomer()
	{
		String date;
		String time;
		date = PubFun.getCurrentDate();
		time = PubFun.getCurrentTime();
		SysMaxNoMAPNP maxNoMap;
		maxNoMap = new SysMaxNoMAPNP();
		bnfSgSchema.setContNo(contNo);
		if (contSch != null && contSch.getInsuredId() != null && !contSch.getInsuredId().equals(""))
		{
			bnfSgSchema.setInsuredId(contSch.getInsuredId());
			break MISSING_BLOCK_LABEL_85;
		}
		message = "??????????????";
		return null;
		try
		{
			bnfSgSchema.setBenefitType("2");
			bnfSgSchema.setBenefitRate(getBnfRate());
			System.out.println((new StringBuilder(" -- bnfSgSchema.getBenefitOrder -- ")).append(bnfSgSchema.getBenefitOrder()).toString());
			bnfSgSchema.setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
			bnfSgSchema.setRelationToInsured(getConnectionWithInsurance_sg());
			bnfSgSchema.setOperator(tempGI.Operator);
			bnfSgSchema.setManageCom(tempGI.ComCode);
			bnfSgSchema.setMakeDate(date);
			bnfSgSchema.setMakeTime(time);
			bnfSgSchema.setModifyDate(date);
			bnfSgSchema.setModifyTime(time);
			StateOperatorDeal operatorDeal = new StateOperatorDeal();
			List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), infoSource, "06");
			contSch.setState((String)stateList.get(0));
			contSch.setEditstate((String)stateList.get(1));
			if ("2".equals(contSch.getUWFlag()))
				contSch.setUWFlag("1");
			contSch.setModifyDate(date);
			contSch.setModifyTime(time);
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(bnfSgSchema, "INSERT");
			map.put(contSch, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				System.out.println("-BenefitPersonInfo-???????");
				message = "???????????????????";
				operateResult = false;
			} else
			{
				message = "????????????????????";
				operateResult = true;
			}
		}
		catch (RuntimeException e)
		{
			message = "???????????????????";
			operateResult = false;
			e.printStackTrace();
		}
		return bnfSgSchema;
	}

	private boolean modifySgBnf()
	{
		boolean flag = false;
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		LNPBnfSchema modifySch = new LNPBnfSchema();
		modifySch = getBnfSgSchByBnfId(contNo, operatorBnfId, "2");
		if (modifySch != null)
		{
			int sum = getBnfRateSumFun(bnfOrder);
			if (sum != -1 && (double)(sum + bnfRate) - modifySch.getBenefitRate() > 100D)
			{
				message = "?????????????????????????100";
				operateResult = false;
				return false;
			}
			modifySch = bnfSgSchema;
			StateOperatorDeal operatorDeal = new StateOperatorDeal();
			List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), infoSource, "06");
			contSch.setState((String)stateList.get(0));
			contSch.setEditstate((String)stateList.get(1));
			contSch.setModifyDate(date);
			contSch.setModifyTime(time);
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(modifySch, "UPDATE");
			map.put(contSch, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "????????????????";
			} else
			{
				message = "???????????\263????";
				modifyFLag = false;
				reSetSgInfo();
				flag = true;
				replaceNodeFromList(modifySch.getBnfId(), modifySch);
				contOrder();
			}
		} else
		{
			message = "?????в?????????????";
		}
		System.out.println((new StringBuilder("message : ")).append(message).toString());
		initData();
		return flag;
	}

	private void contOrder()
	{
		ExeSQL exeSQL = new ExeSQL();
		String sql = (new StringBuilder("select distinct cast(benefitorder as int) from lnpbnf where contno='")).append(contNo).append("'  order by cast(benefitorder as int)").toString();
		SSRS tSSRS = exeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.getMaxRow() > 0)
		{
			if (tSSRS.getMaxRow() != Integer.parseInt(tSSRS.GetText(tSSRS.MaxRow, 1)))
			{
				for (int k = 1; k <= tSSRS.getMaxRow() - 1; k++)
				{
					int cur = Integer.parseInt(tSSRS.GetText(k, 1));
					int aft = Integer.parseInt(tSSRS.GetText(k + 1, 1));
					int sum = getBnfRateSumFun(cur);
					if (sum < 100)
					{
						bnfOrder = cur;
						return;
					}
					if (cur - aft < -1)
					{
						bnfOrder = cur + 1;
						return;
					}
				}

			} else
			{
				int maxOrder = Integer.parseInt(tSSRS.GetText(tSSRS.MaxRow, 1));
				for (int i = 1; i <= maxOrder; i++)
				{
					int tempOrder = Integer.parseInt(tSSRS.GetText(i, 1));
					int sum = getBnfRateSumFun(tempOrder);
					if (sum < 100)
					{
						bnfOrder = tempOrder;
						return;
					}
					if (sum == 100)
						bnfOrder = tempOrder + 1;
				}

			}
		} else
		{
			bnfOrder = 1;
		}
	}

	public int existUnFinishOrder(String contno)
	{
		int temporder = -1;
		ExeSQL exeSQL = new ExeSQL();
		String sql = (new StringBuilder("select top 1 cast(benefitorder as int) from (select cast(benefitorder as int),sum(benefitrate) benefitrate from lnpbnf where benefittype='2' and contno='")).append(contno).append("'  group by cast(benefitorder as int)) a where casta.benefitorder as int)<100;").toString();
		SSRS tSSRS = exeSQL.execSQL(sql);
		if (tSSRS.getMaxRow() > 0)
			temporder = Integer.parseInt(tSSRS.GetText(1, 1));
		return temporder;
	}

	public int existFinishOrder(String contno)
	{
		int temporder = -1;
		ExeSQL exeSQL = new ExeSQL();
		String sql = (new StringBuilder("select max(cast(benefitorder as int))  from (select cast(benefitorder as int),sum(benefitrate) benefitrate from lnpbnf where benefittype='2' and contno='")).append(contno).append("'  group by cast(benefitorder as int)) a where cast(a.benefitorder as int)=100;").toString();
		SSRS tSSRS = exeSQL.execSQL(sql);
		if (tSSRS.getMaxRow() > 0)
			temporder = Integer.parseInt(tSSRS.GetText(1, 1));
		return temporder;
	}

	private int getBnfRateSumFun(int order)
	{
		int rateSum = -1;
		ExeSQL exeSQL = new ExeSQL();
		String sql = (new StringBuilder("select  case when sum(benefitrate) is null then -1 else sum(benefitrate) end from lnpbnf where benefittype='2' and contno='")).append(contNo).append("' and benefitorder ='").append(order).append("'").toString();
		SSRS tSSRS = exeSQL.execSQL(sql);
		if (tSSRS.MaxRow > 0)
			rateSum = Integer.parseInt(tSSRS.GetText(1, 1));
		return rateSum;
	}

	private List getLnpBnfList(String contNo)
	{
		List relist = new ArrayList();
		LNPBnfDB db = new LNPBnfDB();
		try
		{
			String sqlBnf = (new StringBuilder("select * from lnpbnf where benefittype='2' and contno = '")).append(contNo).append("' order by cast(benefitorder as int)").toString();
			LNPBnfSet set = db.executeQuery(sqlBnf);
			if (set != null && set.size() > 0)
			{
				for (int i = 1; i <= set.size(); i++)
				{
					LNPBnfBean tempBean = new LNPBnfBean();
					tempBean.setSchema(set.get(i));
					tempBean.setGender((String)genderMap.get(tempBean.getSchema().getBnfSex()));
					tempBean.setIdType((String)idTypeMap.get(tempBean.getSchema().getIDType()));
					tempBean.setRelationToInsured((String)relationToInsuredMap.get(tempBean.getSchema().getRelationToInsured()));
					tempBean.setBenefitRate((new StringBuilder(String.valueOf(tempBean.getSchema().getBenefitRate()))).append("%").toString());
					if (editFlag)
						tempBean.setListEditFlag("inline-block");
					else
						tempBean.setListEditFlag("none");
					relist.add(tempBean);
				}

			} else
			{
				relist = null;
			}
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return relist;
	}

	public boolean checkconnectionWithInsuranceSelf()
	{
		System.out.println((new StringBuilder("-- setconnectionWithInsuranceSelf --")).append(getConnectionWithInsurance_sg()).toString());
		if (getConnectionWithInsurance_sg() == null)
			break MISSING_BLOCK_LABEL_176;
		if (getConnectionWithInsurance_sg().equals("0"))
			break MISSING_BLOCK_LABEL_153;
		PersonFunction pf = new PersonFunction();
		LNPPersonSchema lnpPerson = pf.getLnpPersonByCustomerId(contSch.getInsuredId());
		if (!sex.equals(lnpPerson.getSex()) || !idType.equals(lnpPerson.getIDType()) || !bnfSgSchema.getIDNo().equals(lnpPerson.getIDNo()) || !bnfSgSchema.getBnfName().equals(lnpPerson.getName()) || !bnfSgSchema.getBnfBirthday().equals(lnpPerson.getBirthday()))
			break MISSING_BLOCK_LABEL_176;
		message = "????????????????????????";
		return false;
		try
		{
			message = "????????????????????????";
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			message = "????????????????????";
			return false;
		}
		return false;
		return true;
	}

	private void initBnfByCustomerId(String customerId)
	{
		try
		{
			System.out.println(" -- initAppntByInsuredId --");
			PersonFunction pf = new PersonFunction();
			LNPPersonSchema lnpPersonTemp = pf.getLnpPersonByCustomerId(customerId);
			if (lnpPersonTemp != null)
			{
				bnfSgSchema.setBnfId(lnpPersonTemp.getCustomerId());
				bnfSgSchema.setBnfName(lnpPersonTemp.getName());
				bnfSgSchema.setBnfSex(lnpPersonTemp.getSex());
				bnfSgSchema.setBnfBirthday(lnpPersonTemp.getBirthday());
				bnfSgSchema.setIDType(lnpPersonTemp.getIDType());
				bnfSgSchema.setIDNo(lnpPersonTemp.getIDNo());
			}
			System.out.println(" -- initAppntByInsuredId end--");
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	public boolean checkScBnfExist(String contno)
	{
		boolean flag = false;
		LNPBnfDB db = new LNPBnfDB();
		db.setContNo(contno);
		db.setBenefitType("1");
		LNPBnfSet set = db.query();
		if (set.size() > 0)
			flag = true;
		else
			flag = false;
		return flag;
	}

	private boolean checkSgBnfExist(LNPBnfSchema bnfSgSchema2)
	{
		boolean flag = false;
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select * from lnpbnf where contno='")).append(contNo).append("' ").append(" and benefittype='2' and bnfname='").append(bnfSgSchema2.getBnfName()).append("' and bnfsex='").append(bnfSgSchema2.getBnfSex()).append("' ").append(" and bnfbirthday='").append(bnfSgSchema2.getBnfBirthday()).append("' ").toString();
		SSRS tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS.MaxRow > 0)
			flag = true;
		return flag;
	}

	private void reSetSgInfo()
	{
		bnfSgSchema = new LNPBnfSchema();
		connectionWithInsurance_sg = "-1";
		bnfRate = 0;
		sex = "-1";
		idType = "-1";
	}

	public LNPBnfSchema getBnfSgSchByBnfId(String contno, String bnfId, String bnfType)
	{
		LNPBnfSchema relnpBnf = new LNPBnfSchema();
		LNPBnfDB db = new LNPBnfDB();
		try
		{
			db.setContNo(contno);
			db.setBenefitType(bnfType);
			if (bnfType.equals("2"))
				db.setBnfId(bnfId);
			LNPBnfSet set = db.query();
			if (set.size() > 0)
				relnpBnf = set.get(1);
			else
				relnpBnf = null;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
			relnpBnf = null;
		}
		return relnpBnf;
	}

	private void removeNodeFromList(String bnfId)
	{
		for (int i = 0; i < lnpBnfList.size(); i++)
		{
			if (!((LNPBnfBean)lnpBnfList.get(i)).getSchema().getBnfId().equals(bnfId))
				continue;
			lnpBnfList.remove(i);
			break;
		}

	}

	private void replaceNodeFromList(String bnfId, LNPBnfSchema temp)
	{
		for (int i = 0; i < lnpBnfList.size(); i++)
		{
			if (!((LNPBnfBean)lnpBnfList.get(i)).getSchema().getBnfId().equals(bnfId))
				continue;
			LNPBnfBean bean = new LNPBnfBean();
			bean.setSchema(temp);
			lnpBnfList.set(i, bean);
			break;
		}

	}

	private void initGenderMap()
	{
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='sex' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			genderMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private void initIdTypeMap()
	{
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='insuredidtype' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			idTypeMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private void initRelationToInsuredMap()
	{
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='bnfrelationtoinsured' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			relationToInsuredMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private boolean validate()
	{
		message = "";
		if (bnfSgSchema.getBnfName() == null || bnfSgSchema.getBnfName().trim().equals(""))
		{
			message = "????????????????";
			return false;
		}
		if (!ValidateTools.isValidString1(bnfSgSchema.getBnfName()))
		{
			message = (new StringBuilder("??????????")).append(ValidateTools.validString1ErrorMessage).toString();
			return false;
		}
		if (bnfSgSchema.getBnfSex() == null || bnfSgSchema.getBnfSex().equals("") || bnfSgSchema.getBnfSex().equals("-1"))
		{
			message = "?????????";
			return false;
		}
		if (bnfSgSchema.getBnfBirthday() == null || bnfSgSchema.getBnfBirthday().trim().equals(""))
		{
			message = "???????????????";
			return false;
		}
		if (!ValidateTools.isValidString1(bnfSgSchema.getBnfBirthday()))
			return false;
		if (bnfSgSchema.getIDType() == null || bnfSgSchema.getIDType().equals("") || bnfSgSchema.getIDType().equals("-1"))
		{
			message = "??????????????";
			return false;
		}
		if (bnfSgSchema.getIDNo() == null || bnfSgSchema.getIDNo().trim().equals(""))
		{
			message = "?????????????";
			return false;
		}
		if (bnfSgSchema.getIDType().equals("1"))
		{
			String returnString = ValidateTools.isValidIDNo(bnfSgSchema.getIDNo(), bnfSgSchema.getBnfBirthday(), bnfSgSchema.getBnfSex());
			if (!returnString.equals(""))
			{
				message = returnString;
				return false;
			}
		}
		if ("0".equals(bnfSgSchema.getIDPerpetual().trim()))
		{
			if (bnfSgSchema.getIDValidity() == null || "".equals(bnfSgSchema.getIDValidity().trim()))
			{
				message = "?????Ч???????????";
				return false;
			}
			if (!ValidateTools.isValidString1(bnfSgSchema.getIDValidity()))
				return false;
		}
		if (bnfSgSchema.getBenefitRate() < 0.0D || bnfSgSchema.getBenefitRate() > 100D)
		{
			message = "?????????д??Χ?1-100";
			return false;
		} else
		{
			return true;
		}
	}

	public void reSetIdPerpetual()
	{
		idPerpetualList = getIdPerpetualListFromDB();
	}

	private List getIdPerpetualListFromDB()
	{
		List reList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='idPerpetualType' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return reList;
	}

	public void validateConnection()
	{
		showMessageFlag = false;
		if (!checkConn(connectionWithInsurance_sg))
		{
			showMessageFlag = true;
			message = "???????????";
		}
	}

	public boolean isShowMessageFlag()
	{
		return showMessageFlag;
	}

	public void setShowMessageFlag(boolean showMessageFlag)
	{
		this.showMessageFlag = showMessageFlag;
	}

	private boolean checkConn(String connectionWithInsurance_sg)
	{
		boolean reflag = false;
		String sql = (new StringBuilder("select * from lnpcode where codetype='bnfrelationtoinsured' and othersign='1'and code ='")).append(connectionWithInsurance_sg).append("';").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = null;
		tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
			reflag = true;
		return reflag;
	}

	public List getIdPerpetualList()
	{
		if (idPerpetualList != null)
			idPerpetualList.clear();
		idPerpetualList = getIdPerpetualListFromDB();
		return idPerpetualList;
	}

	public void setIdPerpetualList(List idPerpetualList)
	{
		this.idPerpetualList = idPerpetualList;
	}

	public LNPBnfSchema getBnfSgSchema()
	{
		return bnfSgSchema;
	}

	public void setBnfSgSchema(LNPBnfSchema bnfSgSchema)
	{
		this.bnfSgSchema = bnfSgSchema;
	}

	public String getConnectionWithInsurance_sc()
	{
		return connectionWithInsurance_sc;
	}

	public void setConnectionWithInsurance_sc(String connectionWithInsurance_sc)
	{
		this.connectionWithInsurance_sc = connectionWithInsurance_sc;
	}

	public String getConnectionWithInsurance_sg()
	{
		return connectionWithInsurance_sg;
	}

	public void setConnectionWithInsurance_sg(String connectionWithInsurance_sg)
	{
		this.connectionWithInsurance_sg = connectionWithInsurance_sg;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public List getLnpBnfList()
	{
		return lnpBnfList;
	}

	public void setLnpBnfList(List lnpBnfList)
	{
		this.lnpBnfList = lnpBnfList;
	}

	public boolean isOperateResult()
	{
		return operateResult;
	}

	public void setOperateResult(boolean operateResult)
	{
		this.operateResult = operateResult;
	}

	public int getBnfRate()
	{
		return bnfRate;
	}

	public void setBnfRate(int bnfRate)
	{
		this.bnfRate = bnfRate;
	}

	public String getOperatorBnfId()
	{
		return operatorBnfId;
	}

	public void setOperatorBnfId(String c)
	{
		System.out.println((new StringBuilder("-- operatorBnfId -- ")).append(operatorBnfId).toString());
		operatorBnfId = operatorBnfId;
	}

	public int getBnfOrder()
	{
		return bnfOrder;
	}

	public void setBnfOrder(int bnfOrder)
	{
		this.bnfOrder = bnfOrder;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public boolean isScEditFlag()
	{
		return scEditFlag;
	}

	public void setScEditFlag(boolean scEditFlag)
	{
		this.scEditFlag = scEditFlag;
	}

	public String getIdPerpetual()
	{
		return idPerpetual;
	}

	public void setIdPerpetual(String idPerpetual)
	{
		this.idPerpetual = idPerpetual;
	}

	public String getBnfremoveid()
	{
		return bnfremoveid;
	}

	public void setBnfremoveid(String bnfremoveid)
	{
		this.bnfremoveid = bnfremoveid;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}
}
