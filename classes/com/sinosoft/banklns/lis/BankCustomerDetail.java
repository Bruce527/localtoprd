// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankCustomerDetail.java

package com.sinosoft.banklns.lis;

import com.sinosoft.banklns.lis.bean.BankLNPAddressBean;
import com.sinosoft.banklns.lis.bean.BankLNPAppntBean;
import com.sinosoft.banklns.lis.bean.BankLNPBnfBean;
import com.sinosoft.banklns.lis.bean.BankLNPContBean;
import com.sinosoft.banklns.lis.bean.BankLNPInusredBean;
import com.sinosoft.banklns.lis.bean.BankLNPPersonBean;
import com.sinosoft.banklns.lis.bean.CRSInfoBean;
import com.sinosoft.banklns.lis.db.CRSInfoDB;
import com.sinosoft.banklns.lis.db.LNPAddressDB;
import com.sinosoft.banklns.lis.db.LNPAppntDB;
import com.sinosoft.banklns.lis.db.LNPBnfDB;
import com.sinosoft.banklns.lis.db.LNPInsuredDB;
import com.sinosoft.banklns.lis.db.LNPPersonDB;
import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
import com.sinosoft.banklns.lis.pubfun.MMap;
import com.sinosoft.banklns.lis.pubfun.PubSubmit;
import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
import com.sinosoft.banklns.lis.schema.LNPContSchema;
import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
import com.sinosoft.banklns.lnsmodel.*;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.Pattern;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lis:
//			BankBasicBL

public class BankCustomerDetail extends BankBasicBL
{

	int i;
	private boolean editFlag;
	private String message;
	private boolean appntCompelte;
	private boolean insurCompelte;
	private boolean bnfCompelte;
	private boolean crsComplete;
	private boolean allCompelte;
	private boolean operateResult;
	private boolean appntHasFlag;
	private boolean insurHasFlag;
	private boolean bnfHasFlag;
	private boolean crsHasFlag;
	private IGlobalInput GI;
	private String ContNo;
	public static Map genderMap = new HashMap();
	public static Map idTypeMap = new HashMap();
	public static Map relationToInsuredMap = new HashMap();
	public static Map occNameMap = new HashMap();
	private BankLNPContBean contBean;
	private BankLNPAppntBean appntBean;
	private BankLNPInusredBean insuredBean;
	private BankLNPPersonBean insurPersonBean;
	private BankLNPAddressBean insuraddressBean;
	private BankLNPPersonBean appntPersonBean;
	private BankLNPAddressBean appntaddressBean;
	private CRSInfoBean crsBean;
	private CRSInfoBean crsBeanBackup;
	private BankLNPContBean contBeanBackup;
	private BankLNPAppntBean appntBeanBackup;
	private BankLNPPersonBean appntPersonBeanBackup;
	private BankLNPAddressBean appntaddressBeanBackup;
	private BankLNPInusredBean insurBeanBackup;
	private BankLNPPersonBean insurPersonBeanBackup;
	private BankLNPAddressBean insuraddressBeanBackup;
	private String AIRealation;
	private String AppntVIP;
	private String AppntName;
	private String AppntSex;
	private String AppntBirthDay;
	private String AppntAge;
	private String AppntIDType;
	private String AppntID;
	private String AppntIDVailityType;
	private String AppntIDVaility;
	private String AppntNative;
	private String AppntIDView;
	private String AppntGrpName;
	private String AOccupationCode;
	private String AOccupationName;
	private String AppntCompanyAddr;
	private String AppntCompanyPhone;
	private String AppntCompanyZipCode;
	private String AppntIPhone;
	private String AppntCompanyMail;
	private String AppntSalary;
	private String AppntLinkAdr;
	private String AppntHomeZipCode;
	private String AppntHomeAddr;
	private String appntAreaCode;
	private String appntHomeProvince;
	private String appntHomeCity;
	private String appntHomeCounty;
	private String appntHomeRoad;
	private String appntHomeVillage;
	private String appntCompanyProvince;
	private String appntCompanyCity;
	private String appntCompanyCounty;
	private String appntCompanyRoad;
	private String appntCompanyVillage;
	private List appntHomeProvinceList;
	private List appntHomeCityList;
	private List appntHomeCountyList;
	private List appntCompanyProvinceList;
	private List appntCompanyCityList;
	private List appntCompanyCountyList;
	private List crsBirthProvinceList;
	private List crsBirthCityList;
	private String InsurName;
	private String InsurSex;
	private String InsurBirthDay;
	private String InsurAge;
	private String InsurIDType;
	private String InsurID;
	private String InsurIDVailityType;
	private String InsurIDVaility;
	private String InsurNative;
	private String InsurIDView;
	private String InsurGrpName;
	private String IOccupationCode;
	private String IOccupationName;
	private String InsurCompanyAddr;
	private String InsurCompanyPhone;
	private String InsurCompanyZipCode;
	private String InsurIPhone;
	private String InsurCompanyMail;
	private String InsurSalary;
	private String InsurLinkAdr;
	private String InsurHomeZipCode;
	private String InsurHomeAddr;
	private String insuAreaCode;
	private String insurHomeProvince;
	private String insurHomeCity;
	private String insurHomeCounty;
	private String insurHomeRoad;
	private String insurHomeVillage;
	private String insurCompanyProvince;
	private String insurCompanyCity;
	private String insurCompanyCounty;
	private String insurCompanyRoad;
	private String insurCompanyVillage;
	private List insurHomeProvinceList;
	private List insurHomeCityList;
	private List insurHomeCountyList;
	private List insurCompanyProvinceList;
	private List insurCompanyCityList;
	private List insurCompanyCountyList;
	private String BnfIsExist;
	private String BnfRecType;
	private List bnfList;
	private List bnfListBackup;
	private List delBnfList;
	private List bnfValiList;
	private String contNo;
	private String customerName;
	private String taxResidentType;
	private String firstName;
	private String lastName;
	private String birthday;
	private String currentAddress_Country;
	private String currentAddress_Province;
	private String currentAddress_City;
	private String currentAddress_Detail;
	private String currentAddress_Country_en;
	private String currentAddress_Province_en;
	private String currentAddress_City_en;
	private String currentAddress_Detail_en;
	private String birthAddress_Country;
	private String birthAddress_Province;
	private String birthAddress_City;
	private String birthAddress_Detail;
	private String birthAddress_Country_en;
	private String birthAddress_Province_en;
	private String birthAddress_City_en;
	private String birthAddress_Detail_en;
	private String taxResidentCountry1;
	private String taxpayerCode1;
	private String taxResidentCountry2;
	private String taxpayerCode2;
	private String taxResidentCountry3;
	private String taxpayerCode3;
	private String noTaxpayercodeReason;
	private String reasonDescription;
	private int BnfMinSize;
	private int BnfMaxSize;
	private int BnfSize;
	private String valiDate;
	private BankOperateDeal stateOperate;
	private BankPolicyState policyState;
	private String curBnfId;
	private int curIdx;
	private String OccType;
	private String OccCode;
	private String CAge;
	private String CType;
	private String CBirth;

	public BankCustomerDetail()
	{
		i = 0;
		editFlag = true;
		message = "";
		appntCompelte = false;
		insurCompelte = false;
		bnfCompelte = false;
		crsComplete = false;
		allCompelte = false;
		operateResult = true;
		appntHasFlag = false;
		insurHasFlag = false;
		bnfHasFlag = false;
		crsHasFlag = false;
		ContNo = "";
		appntHomeProvinceList = new ArrayList();
		appntHomeCityList = new ArrayList();
		appntHomeCountyList = new ArrayList();
		appntCompanyProvinceList = new ArrayList();
		appntCompanyCityList = new ArrayList();
		appntCompanyCountyList = new ArrayList();
		crsBirthProvinceList = new ArrayList();
		crsBirthCityList = new ArrayList();
		insurHomeProvinceList = new ArrayList();
		insurHomeCityList = new ArrayList();
		insurHomeCountyList = new ArrayList();
		insurCompanyProvinceList = new ArrayList();
		insurCompanyCityList = new ArrayList();
		insurCompanyCountyList = new ArrayList();
		bnfList = new ArrayList();
		bnfListBackup = new ArrayList();
		delBnfList = new ArrayList();
		bnfValiList = new ArrayList();
		BnfMinSize = 4;
		BnfMaxSize = 10;
	}

	public static void main(String args[])
	{
		BankCustomerDetail t = new BankCustomerDetail();
		String object = "";
		System.out.println(t.turnNullToString(object));
		object = null;
		System.out.println(t.turnNullToString(object));
		double obj = 0.90000000000000002D;
		System.out.println(t.turnNullToString(Double.valueOf(obj)));
		t.saveCustomerMsg();
	}

	public boolean insertCRScontNo(CRSInfoBean crsBean, String contNo)
	{
		crsBean.getSchema().setContNo(contNo);
		System.out.println((new StringBuilder("insertCRScontNo查到的CRS信息")).append(contNo).append(crsBean.getSchema().toString()).toString());
		initCRSInfoMsg(crsBean, null);
		MMap insertMap = new MMap();
		if (recOneCRSInfo(contNo).getSchema().getContNo() == null || "".equals(recOneCRSInfo(contNo).getSchema().getContNo()))
			insertMap.put(crsBean.getSchema(), "INSERT");
		VData crsInputData = new VData();
		crsInputData.add(insertMap);
		PubSubmit crsSubmit = new PubSubmit();
		if (!crsSubmit.submitData(crsInputData, ""))
		{
			buildError("crs信息保存失败!");
			return false;
		} else
		{
			return true;
		}
	}

	public void initData()
	{
		System.out.println("------------start BankCustomerDetail initData()---------------------");
		try
		{
			editFlag = true;
			message = "";
			allCompelte = false;
			operateResult = true;
			appntHasFlag = false;
			insurHasFlag = false;
			bnfHasFlag = false;
			crsHasFlag = false;
			ContNo = "";
			appntBean = new BankLNPAppntBean();
			appntBean.getSchema().setSalary("-1");
			appntPersonBean = new BankLNPPersonBean();
			appntaddressBean = new BankLNPAddressBean();
			insuredBean = new BankLNPInusredBean();
			insuredBean.getSchema().setSalary("-1");
			insurPersonBean = new BankLNPPersonBean();
			insuraddressBean = new BankLNPAddressBean();
			crsBean = new CRSInfoBean();
			initCRSInfoMsg(crsBean, appntaddressBean);
			initAppntMsg(appntBean, appntPersonBean, appntaddressBean);
			initInsuredMsg(insuredBean, insurPersonBean, insuraddressBean);
			BnfIsExist = "";
			BnfRecType = "";
			if (getInfoFromSession())
			{
				contBean = recOneContInfo(ContNo);
				if (!"".equals(contBean.getSchema().getContNo()))
				{
					String contNo = contBean.getSchema().getContNo();
					if (crsBean.getSchema().getContNo() == null)
						insertCRScontNo(crsBean, contNo);
					if (contBean.getSchema().getAppntId() == null || "".equals(contBean.getSchema().getAppntId()))
					{
						String contAppntId = getAppntIDByContno(contNo);
						contBean.getSchema().setAppntId(contAppntId);
					}
					System.out.println((new StringBuilder("执行到contBean")).append(contBean.getSchema().getAppntId()).toString());
					if (contBean.getSchema().getAppntId() != null && !"".equals(contBean.getSchema().getAppntId()))
					{
						String AppntId = contBean.getSchema().getAppntId();
						appntBean = recOneAppntPersonInfo(contNo, AppntId);
						appntPersonBean = recOnePersonInfo(contBean.getSchema().getAppntId());
						appntaddressBean = recOneAddressInfo(contBean.getSchema().getAppntId());
						crsBean = recOneCRSInfo(contNo);
						System.out.println((new StringBuilder("CRS信息是否null====")).append(crsBean.getSchema().getContNo()).toString());
						if (crsBean.getSchema().getContNo() != null)
						{
							System.out.println("CRS信息if");
							if (!updateCRS(crsBean, contNo, appntBean, appntaddressBean))
								System.out.println("CRS信息更新失败");
						}
						valiDate = contBean.getSchema().getPValiDate();
						initCRSInfoMsg(crsBean, appntaddressBean);
						crsHasFlag = true;
						initAppntMsg(appntBean, appntPersonBean, appntaddressBean);
						appntHasFlag = true;
						System.out.println((new StringBuilder(String.valueOf(appntBean.getSchema().getAppntName()))).append("----------initAppntMsg-------------").append(AppntName).toString());
					}
					System.out.println("执行到这里了");
					if (contBean.getSchema().getInsuredId() != null && !"".equals(contBean.getSchema().getInsuredId()))
					{
						String insuredId = contBean.getSchema().getInsuredId();
						insuredBean = recOneInsuredPersonInfo(contNo, insuredId);
						insurPersonBean = recOnePersonInfo(contBean.getSchema().getInsuredId());
						insuraddressBean = recOneAddressInfo(contBean.getSchema().getInsuredId());
						initInsuredMsg(insuredBean, insurPersonBean, insuraddressBean);
						insurHasFlag = true;
					}
					bnfList = recBnfList(contBean.getSchema().getContNo());
					if (bnfList != null && bnfList.size() > 0)
					{
						bnfHasFlag = true;
						for (int i = bnfList.size(); BnfMinSize - i > 0; i++)
						{
							BankLNPBnfBean bnfBean = new BankLNPBnfBean();
							bnfBean.getSchema().setBnfOrder((new StringBuilder(String.valueOf(i))).toString());
							bnfList.add(bnfBean);
						}

					} else
					{
						bnfList = new ArrayList();
						for (int i = bnfList.size(); BnfMinSize - i > 0; i++)
						{
							BankLNPBnfBean bnfBean = new BankLNPBnfBean();
							bnfBean.getSchema().setBnfOrder((new StringBuilder(String.valueOf(i))).toString());
							bnfList.add(bnfBean);
						}

					}
					BnfSize = bnfList.size();
					stateOperate = new BankOperateDeal();
					boolean tEditFlag = stateOperate.isEidtSheet(contBean.getSchema().getState(), "03", GI.LNPRole, contNo);
					HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
					Boolean tQueyEditFlag = (Boolean)session.getAttribute("Queryflag");
					if (tQueyEditFlag == null)
						tQueyEditFlag = Boolean.valueOf(true);
					editFlag = tEditFlag && tQueyEditFlag.booleanValue();
				}
			} else
			{
				buildError("全局投保书信息缺失!");
			}
		}
		catch (Exception e)
		{
			turnCurrPolicyLockFlag(null, ContNo, "unlock");
			e.printStackTrace();
			buildError(e.getMessage());
		}
	}

	public boolean updateCRS(CRSInfoBean crsBean, String contNo, BankLNPAppntBean appntBean, BankLNPAddressBean addressBean)
	{
		crsBean.getSchema().setContNo(contNo);
		crsBean.getSchema().setCustomerName(appntBean.getSchema().getAppntName());
		crsBean.getSchema().setBirthday(appntBean.getSchema().getAppntBirthday());
		crsBean.getSchema().setCurrentAddress_City(getAddressName(addressBean.getSchema().getBP()));
		crsBean.getSchema().setCurrentAddress_Province(getAddressName(addressBean.getSchema().getHomeFax()));
		crsBean.getSchema().setCurrentAddress_Country("中国");
		System.out.println((new StringBuilder("省市")).append(addressBean.getSchema().getHomeFax()).append(addressBean.getSchema().getBP()).toString());
		System.out.println((new StringBuilder("查到的CRS信息")).append(contNo).append(crsBean.getSchema().toString()).toString());
		initCRSInfoMsg(crsBean, addressBean);
		MMap insertMap = new MMap();
		insertMap.put(crsBean.getSchema(), "UPDATE");
		VData crsInputData = new VData();
		crsInputData.add(insertMap);
		PubSubmit crsSubmit = new PubSubmit();
		if (!crsSubmit.submitData(crsInputData, ""))
		{
			buildError("CRS信息更新失败!");
			return false;
		} else
		{
			return true;
		}
	}

	public void saveCustomerMsg()
	{
		operateResult = true;
		VData cInputData;
		MMap map;
		String curDate;
		String curTime;
		if (!editFlag)
			break MISSING_BLOCK_LABEL_992;
		cInputData = new VData();
		map = new MMap();
		curDate = PubFun.getCurrentDate();
		curTime = PubFun.getCurrentTime();
		System.out.println("数据保存开始...");
		boolean isSave = saveCRSInfo(map, crsBean, crsHasFlag);
		System.out.println((new StringBuilder("CRS信息保存在map中结果为")).append(isSave).toString());
		if (saveAppntMsg(map, appntHasFlag, contBean, appntBean, appntPersonBean, appntaddressBean, curDate, curTime) && isSave && saveInusredMsg(map, insurHasFlag, contBean, insuredBean, insurPersonBean, insuraddressBean, curDate, curTime) && saveBnfMsg(map, bnfHasFlag, contBean, bnfList, delBnfList, curDate, curTime))
			break MISSING_BLOCK_LABEL_270;
		if (!operateResult)
		{
			System.out.println();
			System.out.println((new StringBuilder("存在错误：------------------")).append(message).toString());
		}
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		if (!operateResult)
		{
			System.out.println();
			System.out.println((new StringBuilder("存在错误：------------------")).append(message).toString());
		}
		return;
		try
		{
			System.out.println("数据正确，已保存");
			dealAddrMsg(appntaddressBean, insuraddressBean);
			allCompelte = appntCompelte && insurCompelte && bnfCompelte && crsComplete;
			System.out.println((new StringBuilder(" this.crsComplete=")).append(crsComplete).append("||this.allCompelte=").append(allCompelte).toString());
			stateOperate = new BankOperateDeal();
			boolean isChangeToCustomerMsg = false;
			System.out.println((new StringBuilder("本次必录项状态：appntCompelte-")).append(appntCompelte).append(" |insurCompelte-").append(insurCompelte).append("|bnfCompelte+").append(bnfCompelte).append("| 修改之前：state--》").append(contBean.getSchema().getState()).append("editstate---》").append(contBean.getSchema().getEditstate()).toString());
			List stateList;
			if (allCompelte)
			{
				stateList = stateOperate.infoOprate(contBean.getSchema().getState(), contBean.getSchema().getEditstate(), "modify", "03");
				contBean.getSchema().setState((String)stateList.get(0));
				contBean.getSchema().setEditstate((String)stateList.get(1));
			} else
			if ("01".equals(contBean.getSchema().getState()))
			{
				String editState = stateOperate.updateEditStateUNDone(contBean.getSchema().getEditstate(), 3);
				contBean.getSchema().setEditstate(editState);
			}
			boolean isModifyfFlag = appntHasFlag && insurHasFlag && allCompelte;
			stateList = dealRefcOtherMsgBySuc(isModifyfFlag, appntBeanBackup, appntPersonBean, appntaddressBean, insurBeanBackup, insurPersonBean, insuraddressBeanBackup, curDate, curTime);
			if (stateList.size() > 0)
			{
				isChangeToCustomerMsg = true;
				contBean.getSchema().setState((String)stateList.get(0));
				contBean.getSchema().setEditstate((String)stateList.get(1));
			}
			map.put(contBean.getSchema(), "UPDATE");
			cInputData.add(map);
			System.out.println((new StringBuilder("crs")).append(crsBean.getSchema()).toString());
			PubSubmit pubSubmit = new PubSubmit();
			if (!pubSubmit.submitData(cInputData, ""))
				buildError("客户信息保存失败!");
			else
				try
				{
					policyState = new BankPolicyState();
					if (isChangeToCustomerMsg)
						policyState.savePolicyState(ContNo, contBean.getSchema().getState(), "3", curDate, curTime);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					buildError("~~~~~~~~~~~~~~~~~~~~~保单状态记录接口报错!");
				}
			break MISSING_BLOCK_LABEL_992;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError("客户信息保存失败!");
		}
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		if (!operateResult)
		{
			System.out.println();
			System.out.println((new StringBuilder("存在错误：------------------")).append(message).toString());
		}
		break MISSING_BLOCK_LABEL_1043;
		Exception exception;
		exception;
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		if (!operateResult)
		{
			System.out.println();
			System.out.println((new StringBuilder("存在错误：------------------")).append(message).toString());
		}
		throw exception;
		turnCurrPolicyLockFlag(null, ContNo, "unlock");
		if (!operateResult)
		{
			System.out.println();
			System.out.println((new StringBuilder("存在错误：------------------")).append(message).toString());
		}
	}

	private List dealRefcOtherMsgBySuc(boolean isModify, BankLNPAppntBean appntBean, BankLNPPersonBean appntPersonBean, BankLNPAddressBean appntAddresBean, BankLNPInusredBean insurBean, BankLNPPersonBean insurPersonBean, BankLNPAddressBean insurAddresBean, 
			String curDate, String curTime)
	{
		List list = new ArrayList();
		try
		{
			contBeanBackup = recOneContInfo(ContNo);
			if (isModify)
			{
				boolean isChangeToCustomerMsg = false;
				appntBeanBackup = recOneAppntPersonInfo(ContNo, contBean.getSchema().getAppntId());
				appntPersonBeanBackup = recOnePersonInfo(contBean.getSchema().getAppntId());
				appntaddressBeanBackup = recOneAddressInfo(contBean.getSchema().getAppntId());
				System.out.println((new StringBuilder("cur:")).append(this.appntBean.getSchema().getAppntName()).append("init:").append(appntBeanBackup.getSchema().getAppntName()).append("this.AppntName:").append(AppntName).toString());
				if (!turnNullToString(this.appntBean.getSchema().getAppntName()).equals(turnNullToString(appntBeanBackup.getSchema().getAppntName())) || !turnNullToString(this.appntBean.getSchema().getAppntSex()).equals(turnNullToString(appntBeanBackup.getSchema().getAppntSex())) || !turnNullToString(this.appntBean.getSchema().getAppntBirthday()).equals(turnNullToString(appntBeanBackup.getSchema().getAppntBirthday())) || !turnNullToString(Integer.valueOf(this.appntBean.getSchema().getAppntAge())).equals(turnNullToString(Integer.valueOf(appntBeanBackup.getSchema().getAppntAge()))) || !turnNullToString(this.appntBean.getSchema().getAppntAgeType()).equals(turnNullToString(appntBeanBackup.getSchema().getAppntAgeType())) || !turnNullToString(this.appntBean.getSchema().getIDType()).equals(turnNullToString(appntBeanBackup.getSchema().getIDType())) || !turnNullToString(this.appntBean.getSchema().getIDNo()).equals(turnNullToString(appntBeanBackup.getSchema().getIDNo())) || !turnNullToString(this.appntBean.getSchema().getIDPerpetual()).equals(turnNullToString(appntBeanBackup.getSchema().getIDPerpetual())) || !turnNullToString(this.appntBean.getSchema().getIDValidity()).equals(turnNullToString(appntBeanBackup.getSchema().getIDValidity())) || !turnNullToString(this.appntBean.getSchema().getNativePlace()).equals(turnNullToString(appntBeanBackup.getSchema().getNativePlace())) || !turnNullToString(this.appntBean.getSchema().getHealth()).equals(turnNullToString(appntBeanBackup.getSchema().getHealth())) || !turnNullToString(appntaddressBean.getSchema().getGrpName()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getGrpName())) || !turnNullToString(this.appntBean.getSchema().getOccupationCode()).equals(turnNullToString(appntBeanBackup.getSchema().getOccupationCode())) || !turnNullToString(appntaddressBean.getSchema().getCompanyFax()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getCompanyFax())) || !turnNullToString(appntaddressBean.getSchema().getBP2()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getBP2())) || !turnNullToString(appntaddressBean.getSchema().getCompanyAddress()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getCompanyAddress())) || !turnNullToString(appntaddressBean.getSchema().getMobileChs2()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getMobileChs2())) || !turnNullToString(appntaddressBean.getSchema().getCompanyPhone()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getCompanyPhone())) || !turnNullToString(appntaddressBean.getSchema().getCompanyZipCode()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getCompanyZipCode())) || !turnNullToString(appntaddressBean.getSchema().getPhone()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getPhone())) || !turnNullToString(appntaddressBean.getSchema().getCompanyMail()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getCompanyMail())) || !turnNullToString(Double.valueOf(this.appntBean.getSchema().getSalary())).equals(turnNullToString(Double.valueOf(appntBeanBackup.getSchema().getSalary()))) || !turnNullToString(appntaddressBean.getSchema().getPostalAddress()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getPostalAddress())) || !turnNullToString(appntaddressBean.getSchema().getHomeZipCode()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getHomeZipCode())) || !turnNullToString(appntaddressBean.getSchema().getHomeAddress()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getHomeAddress())) || !turnNullToString(appntaddressBean.getSchema().getHomeFax()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getHomeFax())) || !turnNullToString(appntaddressBean.getSchema().getBP()).equals(turnNullToString(appntaddressBeanBackup.getSchema().getBP())) || !turnNullToString(this.appntBean.getSchema().getRelationToInsured()).equals(turnNullToString(appntBeanBackup.getSchema().getRelationToInsured())) || !turnNullToString(this.appntBean.getSchema().getAppntGrade()).equals(turnNullToString(appntBeanBackup.getSchema().getAppntGrade())))
					isChangeToCustomerMsg = true;
				insurBeanBackup = recOneInsuredPersonInfo(ContNo, contBean.getSchema().getInsuredId());
				insurPersonBeanBackup = recOnePersonInfo(contBean.getSchema().getInsuredId());
				insuraddressBeanBackup = recOneAddressInfo(contBean.getSchema().getInsuredId());
				if (!turnNullToString(insuredBean.getSchema().getName()).equals(turnNullToString(insurBeanBackup.getSchema().getName())) || !turnNullToString(insuredBean.getSchema().getSex()).equals(turnNullToString(insurBeanBackup.getSchema().getSex())) || !turnNullToString(insuredBean.getSchema().getBirthday()).equals(turnNullToString(insurBeanBackup.getSchema().getBirthday())) || !turnNullToString(Integer.valueOf(insuredBean.getSchema().getAppAge())).equals(turnNullToString(Integer.valueOf(insurBeanBackup.getSchema().getAppAge()))) || !turnNullToString(insuredBean.getSchema().getAppAgeType()).equals(turnNullToString(insurBeanBackup.getSchema().getAppAgeType())) || !turnNullToString(insuredBean.getSchema().getIDType()).equals(turnNullToString(insurBeanBackup.getSchema().getIDType())) || !turnNullToString(insuredBean.getSchema().getIDNo()).equals(turnNullToString(insurBeanBackup.getSchema().getIDNo())) || !turnNullToString(insuredBean.getSchema().getIDPerpetual()).equals(turnNullToString(insurBeanBackup.getSchema().getIDPerpetual())) || !turnNullToString(insuredBean.getSchema().getIDValidity()).equals(turnNullToString(insurBeanBackup.getSchema().getIDValidity())) || !turnNullToString(insuredBean.getSchema().getNativePlace()).equals(turnNullToString(insurBeanBackup.getSchema().getNativePlace())) || !turnNullToString(insuredBean.getSchema().getHealth()).equals(turnNullToString(insurBeanBackup.getSchema().getHealth())) || !turnNullToString(insuraddressBean.getSchema().getGrpName()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getGrpName())) || !turnNullToString(insuredBean.getSchema().getOccupationCode()).equals(turnNullToString(insurBeanBackup.getSchema().getOccupationCode())) || !turnNullToString(insuraddressBean.getSchema().getCompanyFax()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getCompanyFax())) || !turnNullToString(insuraddressBean.getSchema().getBP2()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getBP2())) || !turnNullToString(insuraddressBean.getSchema().getMobile2()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getMobile2())) || !turnNullToString(insuraddressBean.getSchema().getCompanyAddress()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getCompanyAddress())) || !turnNullToString(insuraddressBean.getSchema().getEMail2()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getEMail2())) || !turnNullToString(insuraddressBean.getSchema().getMobileChs2()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getMobileChs2())) || !turnNullToString(insuraddressBean.getSchema().getCompanyPhone()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getCompanyPhone())) || !turnNullToString(insuraddressBean.getSchema().getCompanyZipCode()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getCompanyZipCode())) || !turnNullToString(insuraddressBean.getSchema().getPhone()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getPhone())) || !turnNullToString(insuraddressBean.getSchema().getCompanyMail()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getCompanyMail())) || !turnNullToString(Double.valueOf(insuredBean.getSchema().getSalary())).equals(turnNullToString(Double.valueOf(insurBeanBackup.getSchema().getSalary()))) || !turnNullToString(insuraddressBean.getSchema().getPostalAddress()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getPostalAddress())) || !turnNullToString(insuraddressBean.getSchema().getHomeZipCode()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getHomeZipCode())) || !turnNullToString(insuraddressBean.getSchema().getHomeAddress()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getHomeAddress())) || !turnNullToString(insuraddressBean.getSchema().getHomeFax()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getHomeFax())) || !turnNullToString(insuraddressBean.getSchema().getBP()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getBP())) || !turnNullToString(insuraddressBean.getSchema().getHomePhone()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getHomePhone())) || !turnNullToString(insuraddressBean.getSchema().getEMail()).equals(turnNullToString(insuraddressBeanBackup.getSchema().getEMail())) || !turnNullToString(Integer.valueOf(insuredBean.getSchema().getInsuredPeoples())).equals(turnNullToString(Integer.valueOf(insurBeanBackup.getSchema().getInsuredPeoples()))) || !turnNullToString(insuredBean.getSchema().getCreditGrade()).equals(turnNullToString(insurBeanBackup.getSchema().getCreditGrade())))
					isChangeToCustomerMsg = true;
				bnfListBackup = recBnfList(ContNo);
				System.out.println((new StringBuilder("new?=old--->")).append(bnfValiList.size()).append("?=").append(bnfListBackup.size()).toString());
				if (bnfValiList.size() != bnfListBackup.size())
				{
					isChangeToCustomerMsg = true;
				} else
				{
					boolean tFlag = false;
					for (int i = 0; i < bnfValiList.size(); i++)
					{
						if (tFlag)
							break;
						BankLNPBnfBean bnfBean = (BankLNPBnfBean)bnfValiList.get(i);
						for (int j = 0; j < bnfListBackup.size(); j++)
						{
							BankLNPBnfBean bnfBeanBak = (BankLNPBnfBean)bnfListBackup.get(j);
							if (!turnNullToString(bnfBean.getSchema().getBnfId()).equals(bnfBeanBak.getSchema().getBnfId()))
								continue;
							if (bnfBean.isValidate() && bnfBeanBak.isValidate())
							{
								if (turnNullToString(bnfBean.getSchema().getBnfName()).equals(turnNullToString(bnfBeanBak.getSchema().getBnfName())) && turnNullToString(bnfBean.getSchema().getRelationToInsured()).equals(turnNullToString(bnfBeanBak.getSchema().getRelationToInsured())) && turnNullToString(bnfBean.getSchema().getBenefitOrder()).equals(turnNullToString(bnfBeanBak.getSchema().getBenefitOrder())) && turnNullToString(Double.valueOf(bnfBean.getSchema().getBenefitRate())).equals(turnNullToString(Double.valueOf(bnfBeanBak.getSchema().getBenefitRate()))) && turnNullToString(bnfBean.getSchema().getIDType()).equals(turnNullToString(bnfBeanBak.getSchema().getIDType())) && turnNullToString(bnfBean.getSchema().getIDNo()).equals(turnNullToString(bnfBeanBak.getSchema().getIDNo())) && turnNullToString(bnfBean.getSchema().getIDPerpetual()).equals(turnNullToString(bnfBeanBak.getSchema().getIDPerpetual())) && turnNullToString(bnfBean.getIDVaility()).equals(turnNullToString(bnfBeanBak.getIDVaility())))
									continue;
								tFlag = isChangeToCustomerMsg = true;
							} else
							{
								tFlag = isChangeToCustomerMsg = true;
							}
							break;
						}

					}

				}
				if (isChangeToCustomerMsg)
					list = stateOperate.changeMsgToModify(contBean.getSchema().getState(), contBean.getSchema().getEditstate(), GI.LNPRole);
			}
			copyMsg(contBeanBackup, appntBeanBackup, appntPersonBeanBackup, appntaddressBeanBackup, insurBeanBackup, insurPersonBeanBackup, insuraddressBeanBackup);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	private String turnNullToString(Object object)
	{
		System.out.println("进入turnNullToString");
		String rst = "";
		try
		{
			rst = object != null ? (new StringBuilder()).append(object).toString() : "";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
		return rst.trim();
	}

	private void copyMsg(BankLNPContBean oriContBean, BankLNPAppntBean oriAppntBean, BankLNPPersonBean oriAppntPersonBean, BankLNPAddressBean oriAppntAddresBean, BankLNPInusredBean oriInsurBean, BankLNPPersonBean oriInsurPersonBean, BankLNPAddressBean oriInsurAddresBean)
	{
		contBean.getSchema().setConsignNo(oriContBean.getSchema().getConsignNo());
	}

	private boolean validateCRS(String valiType, CRSInfoBean crsBean)
	{
		boolean flag = true;
		if ("crs".equals(valiType))
		{
			crsComplete = true;
			System.out.println((new StringBuilder("校验必录项")).append(AppntIDType).toString());
			if ("01".equals(AppntIDType.trim()) || "02".equals(AppntIDType.trim()) || "04".equals(AppntIDType.trim()) || "05".equals(AppntIDType.trim()) || "06".equals(AppntIDType.trim()))
			{
				System.out.println("校验必录项非军人证");
				if (taxResidentType == null || "".equals(taxResidentType.trim()))
					crsComplete = false;
				else
				if (!"1".equals(taxResidentType.trim()))
				{
					System.out.println("校验必录项类型2、3");
					if (firstName == null || "".equals(firstName.trim()))
						crsComplete = false;
					if (lastName == null || "".equals(lastName.trim()))
						crsComplete = false;
					if (currentAddress_Country_en == null || "".equals(currentAddress_Country_en.trim()))
						crsComplete = false;
					if ("ZhongGuo".equals(currentAddress_Country_en.trim()))
					{
						if (currentAddress_Province_en == null || "".equals(currentAddress_Province_en.trim()))
							crsComplete = false;
						if (currentAddress_City_en == null || "".equals(currentAddress_City_en.trim()))
							crsComplete = false;
					}
					if (currentAddress_Detail_en == null || "".equals(currentAddress_Detail_en.trim()))
						crsComplete = false;
					if (birthAddress_Country_en == null || "".equals(birthAddress_Country_en.trim()))
						crsComplete = false;
					if ("ZhongGuo".equals(birthAddress_Country_en.trim()))
					{
						if (birthAddress_Province_en == null || "".equals(birthAddress_Province_en.trim()))
							crsComplete = false;
						if (birthAddress_City_en == null || "".equals(birthAddress_City_en.trim()))
							crsComplete = false;
					}
					if (birthAddress_Detail != null && !"".equals(birthAddress_Detail.trim()) && (birthAddress_Detail_en == null || "".equals(birthAddress_Detail_en.trim())))
						crsComplete = false;
					if ((taxpayerCode1 == null || "".equals(taxpayerCode1.trim())) && (taxpayerCode2 == null || "".equals(taxpayerCode2.trim())) && (taxpayerCode3 == null || "".equals(taxpayerCode3.trim())))
					{
						System.out.println("校验必录项未填写识别号，则原因必填");
						if (noTaxpayercodeReason == null || "".equals(noTaxpayercodeReason.trim()) || "2".equals(noTaxpayercodeReason.trim()))
							crsComplete = false;
					}
					if ("2".equals(noTaxpayercodeReason.trim()) && (taxpayerCode1 == null || "".equals(taxpayerCode1.trim())) && (taxpayerCode2 == null || "".equals(taxpayerCode2.trim())) && (taxpayerCode3 == null || "".equals(taxpayerCode3.trim())))
						crsComplete = false;
					if ((taxResidentCountry1 == null || "".equals(taxResidentCountry1.trim())) && (taxResidentCountry2 == null || "".equals(taxResidentCountry2.trim())) && (taxResidentCountry3 == null || "".equals(taxResidentCountry3.trim())))
						crsComplete = false;
					if ("1".equals(noTaxpayercodeReason.trim()))
					{
						System.out.println("校验必录项填写了原因为1,校验原因描述");
						if (reasonDescription == null || "".equals(reasonDescription.trim()))
							crsComplete = false;
					} else
					{
						System.out.println("校验必录项填写了原因为0或2,不校验");
					}
				} else
				{
					System.out.println("校验必录项taxType=1，不校验居民信息");
					crsComplete = true;
				}
			} else
			if ("03".equals(AppntIDType.trim()))
			{
				System.out.println("校验必录项ID为军人证，不校验CRS信息");
				crsComplete = true;
			}
		}
		return flag;
	}

	private boolean saveCRSInfo(MMap tmap, CRSInfoBean crsBean, boolean hasFlag)
	{
		boolean flag = true;
		validateCRS("crs", crsBean);
		System.out.println((new StringBuilder("this.crsComplete=")).append(crsComplete).toString());
		try
		{
			crsBean.getSchema().setContNo(ContNo);
			crsBean.getSchema().setCustomerName(AppntName);
			if ("03".equals(AppntIDType.trim()))
				crsBean.getSchema().setTaxResidentType("");
			else
				crsBean.getSchema().setTaxResidentType(taxResidentType);
			crsBean.getSchema().setFirstName(firstName);
			crsBean.getSchema().setLastName(lastName);
			crsBean.getSchema().setBirthday(AppntBirthDay);
			crsBean.getSchema().setCurrentAddress_Country("中国");
			crsBean.getSchema().setCurrentAddress_Province(getAddressName(appntCompanyProvince));
			crsBean.getSchema().setCurrentAddress_City(getAddressName(appntCompanyCity));
			crsBean.getSchema().setCurrentAddress_Detail(currentAddress_Detail);
			crsBean.getSchema().setCurrentAddress_Country_en("CN");
			crsBean.getSchema().setCurrentAddress_Province_en(currentAddress_Province_en);
			crsBean.getSchema().setCurrentAddress_City_en(currentAddress_City_en);
			crsBean.getSchema().setCurrentAddress_Detail_en(currentAddress_Detail_en);
			crsBean.getSchema().setBirthAddress_Country(getCName(birthAddress_Country, ""));
			crsBean.getSchema().setBirthAddress_Country_en(getCName(birthAddress_Country_en, "e"));
			crsBean.getSchema().setBirthAddress_Province(getAddressName(birthAddress_Province));
			crsBean.getSchema().setBirthAddress_Province_en(birthAddress_Province_en);
			crsBean.getSchema().setBirthAddress_City(getAddressName(birthAddress_City));
			crsBean.getSchema().setBirthAddress_City_en(birthAddress_City_en);
			crsBean.getSchema().setBirthAddress_Detail(birthAddress_Detail);
			crsBean.getSchema().setBirthAddress_Detail_en(birthAddress_Detail_en);
			crsBean.getSchema().setTaxpayerCode1(taxpayerCode1);
			crsBean.getSchema().setTaxpayerCode2(taxpayerCode2);
			crsBean.getSchema().setTaxpayerCode3(taxpayerCode3);
			crsBean.getSchema().setTaxResidentCountry1(taxResidentCountry1);
			crsBean.getSchema().setTaxResidentCountry2(taxResidentCountry2);
			crsBean.getSchema().setTaxResidentCountry3(taxResidentCountry3);
			if (taxpayerCode1 != null && !"".equals(taxpayerCode1.trim()) || taxpayerCode2 != null && !"".equals(taxpayerCode2.trim()) || taxpayerCode3 != null && !"".equals(taxpayerCode3.trim()))
				noTaxpayercodeReason = "2";
			crsBean.getSchema().setNoTaxpayercodeReason(noTaxpayercodeReason);
			crsBean.getSchema().setReasonDescription(reasonDescription);
			crsBean.getSchema().setSourceType("ONBOARDING");
			System.out.println("把Bean中字段数据赋值为页面输入数据");
			System.out.println((new StringBuilder("将CRS Schema作为key，操作作为value存储在Map中=")).append(crsBean.getSchema().toString()).toString());
			tmap.put(crsBean.getSchema(), "UPDATE");
			System.out.println("执行crs更新操作");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
		return flag;
	}

	private boolean saveAppntMsg(MMap tmap, boolean hasFlag, BankLNPContBean contBean, BankLNPAppntBean appntBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean, String curDate, 
			String curTime)
	{
		boolean flag = true;
		if (!validate("appnt", contBean, appntBean, null, null, personBean, addressBean))
			return false;
		try
		{
			appntBean.getSchema().setRelationToInsured(AIRealation);
			if ("01".equals(AIRealation))
				copyAppntMsgToInsurMsg();
			appntBean.getSchema().setAppntGrade(AppntVIP);
			appntBean.getSchema().setAppntName(AppntName);
			appntBean.getSchema().setAppntSex(AppntSex);
			appntBean.getSchema().setAppntBirthday(AppntBirthDay);
			String ageType = "";
			String agePer = AppntAge;
			if (agePer != null && !"".equals(agePer))
				if (agePer.indexOf("天") > -1)
				{
					ageType = "D";
					agePer = agePer.substring(0, agePer.indexOf("（"));
				} else
				{
					ageType = "Y";
					agePer = agePer.substring(0, agePer.indexOf("（"));
				}
			appntBean.getSchema().setAppntAge(agePer);
			appntBean.getSchema().setAppntAgeType(ageType);
			appntBean.getSchema().setIDType(AppntIDType);
			appntBean.getSchema().setIDNo(AppntID);
			appntBean.getSchema().setIDPerpetual(AppntIDVailityType);
			if ("0".equals(AppntIDVailityType))
				appntBean.getSchema().setIDValidity("99991231");
			else
				appntBean.getSchema().setIDValidity(AppntIDVaility);
			appntBean.getSchema().setNativePlace(AppntNative);
			appntBean.getSchema().setHealth(AppntIDView);
			addressBean.getSchema().setGrpName(AppntGrpName);
			appntBean.getSchema().setOccupationCode(AOccupationCode);
			addressBean.getSchema().setCompanyPhone(AppntCompanyPhone);
			addressBean.getSchema().setCompanyZipCode(AppntCompanyZipCode);
			addressBean.getSchema().setPhone(AppntIPhone);
			addressBean.getSchema().setCompanyMail(AppntCompanyMail);
			appntBean.getSchema().setSalary(turnNullToString(AppntSalary).trim().equals("") ? "-1" : AppntSalary);
			addressBean.getSchema().setPostalAddress(AppntLinkAdr);
			addressBean.getSchema().setHomeZipCode(AppntHomeZipCode);
			addressBean.getSchema().setMobileChs2(appntAreaCode);
			addressBean.getSchema().setCompanyFax(appntCompanyProvince);
			addressBean.getSchema().setBP2(appntCompanyCity);
			addressBean.getSchema().setMobile2(appntCompanyCounty);
			addressBean.getSchema().setCompanyAddress(appntCompanyRoad);
			addressBean.getSchema().setEMail2(appntCompanyVillage);
			addressBean.getSchema().setHomeFax(appntHomeProvince);
			addressBean.getSchema().setBP(appntHomeCity);
			addressBean.getSchema().setHomePhone(appntHomeCounty);
			addressBean.getSchema().setHomeAddress(appntHomeRoad);
			addressBean.getSchema().setEMail(appntHomeVillage);
			if (hasFlag)
			{
				addressBean.getSchema().setOperator(GI.Operator);
				addressBean.getSchema().setModifyDate(curDate);
				addressBean.getSchema().setModifyTime(curTime);
				appntBean.getSchema().setOperator(GI.Operator);
				appntBean.getSchema().setModifyDate(curDate);
				appntBean.getSchema().setModifyTime(curTime);
				personBean.getSchema().setOperator(GI.Operator);
				personBean.getSchema().setModifyDate(curDate);
				personBean.getSchema().setModifyTime(curTime);
				contBean.getSchema().setModifyDate(curDate);
				contBean.getSchema().setModifyTime(curTime);
			} else
			{
				SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
				appntBean.getSchema().setAppntId(maxNoMap.CreateMaxNo("CustomerNo", ""));
				addressBean.getSchema().setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
				appntBean.getSchema().setAddressNo(addressBean.getSchema().getAddressNo());
				contBean.getSchema().setModifyDate(curDate);
				contBean.getSchema().setModifyTime(curTime);
				addressBean.getSchema().setOperator(GI.Operator);
				addressBean.getSchema().setModifyDate(curDate);
				addressBean.getSchema().setModifyTime(curTime);
				addressBean.getSchema().setMakeDate(curDate);
				addressBean.getSchema().setMakeTime(curTime);
				appntBean.getSchema().setOperator(GI.Operator);
				appntBean.getSchema().setModifyDate(curDate);
				appntBean.getSchema().setModifyTime(curTime);
				appntBean.getSchema().setMakeDate(curDate);
				appntBean.getSchema().setMakeTime(curTime);
				personBean.getSchema().setOperator(GI.Operator);
				personBean.getSchema().setModifyDate(curDate);
				personBean.getSchema().setModifyTime(curTime);
				personBean.getSchema().setMakeDate(curDate);
				personBean.getSchema().setMakeTime(curTime);
			}
			appntBean.getSchema().setGrpContNo(contBean.getSchema().getGrpContNo());
			appntBean.getSchema().setPrtNo(contBean.getSchema().getPrtNo());
			appntBean.getSchema().setContNo(contBean.getSchema().getContNo());
			appntBean.getSchema().setProposalContNo(contBean.getSchema().getProposalContNo());
			personBean.getSchema().setAgentCode(appntBean.getSchema().getOperator());
			personBean.getSchema().setCustomerId(appntBean.getSchema().getAppntId());
			personBean.getSchema().setName(appntBean.getSchema().getAppntName());
			personBean.getSchema().setSex(appntBean.getSchema().getAppntSex());
			personBean.getSchema().setBirthday(appntBean.getSchema().getAppntBirthday());
			personBean.getSchema().setIDType(appntBean.getSchema().getIDType());
			personBean.getSchema().setIDNo(appntBean.getSchema().getIDNo());
			personBean.getSchema().setNativePlace(appntBean.getSchema().getNativePlace());
			personBean.getSchema().setOccupationCode(appntBean.getSchema().getOccupationCode());
			personBean.getSchema().setAge(appntBean.getSchema().getAppntAge());
			personBean.getSchema().setAgeType(appntBean.getSchema().getAppntAgeType());
			personBean.getSchema().setIDPerpetual(appntBean.getSchema().getIDPerpetual());
			personBean.getSchema().setIDValidity(appntBean.getSchema().getIDValidity());
			addressBean.getSchema().setCustomerId(appntBean.getSchema().getAppntId());
			contBean.getSchema().setAppntId(appntBean.getSchema().getAppntId());
			contBean.getSchema().setAppntNo(appntBean.getSchema().getAppntNo());
			contBean.getSchema().setAppntName(appntBean.getSchema().getAppntName());
			contBean.getSchema().setAppntBirthday(appntBean.getSchema().getAppntBirthday());
			contBean.getSchema().setAppntIDType(appntBean.getSchema().getIDType());
			contBean.getSchema().setAppntIDNo(appntBean.getSchema().getIDNo());
			contBean.getSchema().setAppntSex(appntBean.getSchema().getAppntSex());
			contBean.getSchema().setInputOperator(GI.Operator);
			if (hasFlag)
			{
				tmap.put(appntBean.getSchema(), "UPDATE");
				tmap.put(personBean.getSchema(), "UPDATE");
				tmap.put(addressBean.getSchema(), "UPDATE");
			} else
			{
				tmap.put(appntBean.getSchema(), "INSERT");
				tmap.put(personBean.getSchema(), "INSERT");
				tmap.put(addressBean.getSchema(), "INSERT");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
		return flag;
	}

	private boolean saveInusredMsg(MMap tmap, boolean hasFlag, BankLNPContBean contBean, BankLNPInusredBean insuredBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean, String curDate, 
			String curTime)
	{
		boolean flag = true;
		if (!validate("insured", contBean, null, insuredBean, null, personBean, addressBean))
			return false;
		try
		{
			insuredBean.getSchema().setName(InsurName);
			insuredBean.getSchema().setSex(InsurSex);
			insuredBean.getSchema().setBirthday(InsurBirthDay);
			String ageType = "";
			String agePer = InsurAge;
			if (agePer != null && !"".equals(agePer))
				if (agePer.indexOf("天") > -1)
				{
					ageType = "D";
					agePer = agePer.substring(0, agePer.indexOf("（"));
				} else
				{
					ageType = "Y";
					agePer = agePer.substring(0, agePer.indexOf("（"));
				}
			insuredBean.getSchema().setAppAge(agePer);
			insuredBean.getSchema().setAppAgeType(ageType);
			insuredBean.getSchema().setIDType(InsurIDType);
			insuredBean.getSchema().setIDNo(InsurID);
			insuredBean.getSchema().setIDPerpetual(InsurIDVailityType);
			if ("0".equals(InsurIDVailityType))
				insuredBean.getSchema().setIDValidity("99991231");
			else
				insuredBean.getSchema().setIDValidity(InsurIDVaility);
			insuredBean.getSchema().setNativePlace(InsurNative);
			insuredBean.getSchema().setHealth(InsurIDView);
			addressBean.getSchema().setGrpName(InsurGrpName);
			insuredBean.getSchema().setOccupationCode(IOccupationCode);
			addressBean.getSchema().setCompanyPhone(InsurCompanyPhone);
			addressBean.getSchema().setCompanyZipCode(InsurCompanyZipCode);
			addressBean.getSchema().setPhone(InsurIPhone);
			addressBean.getSchema().setCompanyMail(InsurCompanyMail);
			insuredBean.getSchema().setSalary(turnNullToString(InsurSalary).trim().equals("") ? "-1" : InsurSalary);
			addressBean.getSchema().setPostalAddress(InsurLinkAdr);
			addressBean.getSchema().setHomeZipCode(InsurHomeZipCode);
			insuredBean.getSchema().setInsuredPeoples(BnfIsExist);
			insuredBean.getSchema().setCreditGrade(BnfRecType);
			addressBean.getSchema().setMobileChs2(insuAreaCode);
			addressBean.getSchema().setCompanyFax(insurCompanyProvince);
			addressBean.getSchema().setBP2(insurCompanyCity);
			addressBean.getSchema().setMobile2(insurCompanyCounty);
			addressBean.getSchema().setCompanyAddress(insurCompanyRoad);
			addressBean.getSchema().setEMail2(insurCompanyVillage);
			addressBean.getSchema().setHomeFax(insurHomeProvince);
			addressBean.getSchema().setBP(insurHomeCity);
			addressBean.getSchema().setHomePhone(insurHomeCounty);
			addressBean.getSchema().setHomeAddress(insurHomeRoad);
			addressBean.getSchema().setEMail(insurHomeVillage);
			if (hasFlag)
			{
				addressBean.getSchema().setOperator(GI.Operator);
				addressBean.getSchema().setModifyDate(curDate);
				addressBean.getSchema().setModifyTime(curTime);
				insuredBean.getSchema().setOperator(GI.Operator);
				insuredBean.getSchema().setModifyDate(curDate);
				insuredBean.getSchema().setModifyTime(curTime);
				personBean.getSchema().setOperator(GI.Operator);
				personBean.getSchema().setModifyDate(curDate);
				personBean.getSchema().setModifyTime(curTime);
				contBean.getSchema().setModifyDate(curDate);
				contBean.getSchema().setModifyTime(curTime);
			} else
			{
				SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
				insuredBean.getSchema().setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
				insuredBean.getSchema().setAppntId(contBean.getSchema().getAppntId());
				addressBean.getSchema().setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
				insuredBean.getSchema().setAddressNo(addressBean.getSchema().getAddressNo());
				contBean.getSchema().setModifyDate(curDate);
				contBean.getSchema().setModifyTime(curTime);
				addressBean.getSchema().setOperator(GI.Operator);
				addressBean.getSchema().setModifyDate(curDate);
				addressBean.getSchema().setModifyTime(curTime);
				addressBean.getSchema().setMakeDate(curDate);
				addressBean.getSchema().setMakeTime(curTime);
				insuredBean.getSchema().setOperator(GI.Operator);
				insuredBean.getSchema().setModifyDate(curDate);
				insuredBean.getSchema().setModifyTime(curTime);
				insuredBean.getSchema().setMakeDate(curDate);
				insuredBean.getSchema().setMakeTime(curTime);
				personBean.getSchema().setOperator(GI.Operator);
				personBean.getSchema().setModifyDate(curDate);
				personBean.getSchema().setModifyTime(curTime);
				personBean.getSchema().setMakeDate(curDate);
				personBean.getSchema().setMakeTime(curTime);
			}
			insuredBean.getSchema().setGrpContNo(contBean.getSchema().getGrpContNo());
			insuredBean.getSchema().setPrtNo(contBean.getSchema().getPrtNo());
			insuredBean.getSchema().setContNo(contBean.getSchema().getContNo());
			insuredBean.getSchema().setProposalContNo(contBean.getSchema().getProposalContNo());
			personBean.getSchema().setAgentCode(insuredBean.getSchema().getOperator());
			personBean.getSchema().setCustomerId(insuredBean.getSchema().getInsuredId());
			personBean.getSchema().setName(insuredBean.getSchema().getName());
			personBean.getSchema().setSex(insuredBean.getSchema().getSex());
			personBean.getSchema().setBirthday(insuredBean.getSchema().getBirthday());
			personBean.getSchema().setIDType(insuredBean.getSchema().getIDType());
			personBean.getSchema().setIDNo(insuredBean.getSchema().getIDNo());
			personBean.getSchema().setNativePlace(insuredBean.getSchema().getNativePlace());
			personBean.getSchema().setOccupationCode(insuredBean.getSchema().getOccupationCode());
			personBean.getSchema().setAge(insuredBean.getSchema().getAppAge());
			personBean.getSchema().setAgeType(insuredBean.getSchema().getAppAgeType());
			personBean.getSchema().setIDPerpetual(insuredBean.getSchema().getIDPerpetual());
			personBean.getSchema().setIDValidity(insuredBean.getSchema().getIDValidity());
			addressBean.getSchema().setCustomerId(insuredBean.getSchema().getInsuredId());
			contBean.getSchema().setInsuredId(insuredBean.getSchema().getInsuredId());
			contBean.getSchema().setInsuredNo(insuredBean.getSchema().getInsuredNo());
			contBean.getSchema().setInsuredName(insuredBean.getSchema().getName());
			contBean.getSchema().setInsuredBirthday(insuredBean.getSchema().getBirthday());
			contBean.getSchema().setInsuredIDType(insuredBean.getSchema().getIDType());
			contBean.getSchema().setInsuredIDNo(insuredBean.getSchema().getIDNo());
			contBean.getSchema().setInsuredSex(insuredBean.getSchema().getSex());
			contBean.getSchema().setInputOperator(GI.Operator);
			if (hasFlag)
			{
				tmap.put(insuredBean.getSchema(), "UPDATE");
				tmap.put(addressBean.getSchema(), "UPDATE");
				tmap.put(personBean.getSchema(), "UPDATE");
			} else
			{
				tmap.put(insuredBean.getSchema(), "INSERT");
				tmap.put(addressBean.getSchema(), "INSERT");
				tmap.put(personBean.getSchema(), "INSERT");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
		return flag;
	}

	private boolean saveBnfMsg(MMap tmap, boolean hasFlag, BankLNPContBean contBean, List bnfList, List delBnfList, String curDate, String curTime)
	{
		boolean flag = true;
		if (!validate("bnf", contBean, null, null, bnfList, null, null))
			return false;
		try
		{
			bnfValiList.clear();
			if (insuredBean.getSchema().getInsuredPeoples() == 1 && bnfList != null && bnfList.size() > 0)
			{
				ExeSQL execSql = new ExeSQL();
				SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
				LNPBnfSet bnfSchemaSet = new LNPBnfSet();
				for (int i = 0; i < bnfList.size(); i++)
				{
					BankLNPBnfBean curBnfBean = (BankLNPBnfBean)bnfList.get(i);
					if (curBnfBean.isValidate())
					{
						if (hasFlag)
						{
							boolean existsflag = bnfExists(contBean.getSchema().getContNo(), curBnfBean.getSchema().getBnfId(), execSql);
							if (existsflag)
							{
								curBnfBean.getSchema().setOperator(GI.Operator);
								curBnfBean.getSchema().setManageCom(contBean.getSchema().getSignCom());
								curBnfBean.getSchema().setModifyDate(curDate);
								curBnfBean.getSchema().setModifyTime(curTime);
							} else
							{
								curBnfBean.getSchema().setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
								curBnfBean.getSchema().setOperator(GI.Operator);
								curBnfBean.getSchema().setManageCom(contBean.getSchema().getSignCom());
								curBnfBean.getSchema().setMakeDate(curDate);
								curBnfBean.getSchema().setMakeTime(curTime);
								curBnfBean.getSchema().setModifyDate(curDate);
								curBnfBean.getSchema().setModifyTime(curTime);
							}
						} else
						{
							curBnfBean.getSchema().setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
							curBnfBean.getSchema().setOperator(GI.Operator);
							curBnfBean.getSchema().setManageCom(contBean.getSchema().getSignCom());
							curBnfBean.getSchema().setMakeDate(curDate);
							curBnfBean.getSchema().setMakeTime(curTime);
							curBnfBean.getSchema().setModifyDate(curDate);
							curBnfBean.getSchema().setModifyTime(curTime);
						}
						curBnfBean.getSchema().setBenefitType("2");
						curBnfBean.getSchema().setCreditGrade(insuredBean.getSchema().getCreditGrade());
						curBnfBean.getSchema().setContNo(contBean.getSchema().getContNo());
						curBnfBean.getSchema().setInsuredId(contBean.getSchema().getInsuredId());
						if ("0".equals(curBnfBean.getSchema().getIDPerpetual()))
							curBnfBean.setIDVaility("99991231");
						bnfSchemaSet.add(curBnfBean.getSchema());
						bnfValiList.add(curBnfBean);
					}
				}

				if (hasFlag)
					tmap.put(bnfSchemaSet, "DELETE&INSERT");
				else
					tmap.put(bnfSchemaSet, "INSERT");
				if (delBnfList.size() > 0)
				{
					LNPBnfSet delBnfSchemaSet = new LNPBnfSet();
					for (int i = 0; i < delBnfList.size(); i++)
					{
						BankLNPBnfBean curBnfBean = (BankLNPBnfBean)delBnfList.get(i);
						curBnfBean.getSchema().setHealth("delete");
						delBnfSchemaSet.add(curBnfBean.getSchema());
					}

					tmap.put(delBnfSchemaSet, "UPDATE");
					this.delBnfList = new ArrayList();
				}
			} else
			{
				LNPBnfDB db = new LNPBnfDB();
				db.setContNo(ContNo);
				LNPBnfSet delBnfSchemaSet = db.query();
				for (int i = 1; i <= delBnfSchemaSet.size(); i++)
				{
					delBnfSchemaSet.get(i).setHealth("delete");
					delBnfSchemaSet.get(i).setModifyDate(curDate);
					delBnfSchemaSet.get(i).setModifyTime(curTime);
					delBnfSchemaSet.get(i).setOperator(GI.Operator);
				}

				tmap.put(delBnfSchemaSet, "UPDATE");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
		return flag;
	}

	private void dealAddrMsg(BankLNPAddressBean appntAddressBean, BankLNPAddressBean insurAddressBean)
	{
		try
		{
			String tAIRelation = appntBean.getSchema().getRelationToInsured();
			if ("".equals(tAIRelation.trim()))
			{
				String appntLinkAdrType = appntAddressBean.getSchema().getPostalAddress();
				if ("0".equals(appntLinkAdrType))
				{
					appntAddressBean.getSchema().setHomeZipCode(AppntCompanyZipCode);
					appntAddressBean.getSchema().setHomeFax(appntCompanyProvince);
					appntAddressBean.getSchema().setBP(appntCompanyCity);
					appntAddressBean.getSchema().setHomePhone(appntCompanyCounty);
					appntAddressBean.getSchema().setHomeAddress(appntCompanyRoad);
					appntAddressBean.getSchema().setEMail(appntCompanyVillage);
				} else
				if ("1".equals(appntLinkAdrType))
				{
					appntAddressBean.getSchema().setHomeZipCode(InsurCompanyZipCode);
					appntAddressBean.getSchema().setHomeFax(insurCompanyProvince);
					appntAddressBean.getSchema().setBP(insurCompanyCity);
					appntAddressBean.getSchema().setHomePhone(insurCompanyCounty);
					appntAddressBean.getSchema().setHomeAddress(insurCompanyRoad);
					appntAddressBean.getSchema().setEMail(insurCompanyVillage);
				}
				String insurLinkAdrType = insurAddressBean.getSchema().getPostalAddress();
				if ("0".equals(insurLinkAdrType))
				{
					insurAddressBean.getSchema().setHomeZipCode(AppntCompanyZipCode);
					insurAddressBean.getSchema().setHomeFax(appntCompanyProvince);
					insurAddressBean.getSchema().setBP(appntCompanyCity);
					insurAddressBean.getSchema().setHomePhone(appntCompanyCounty);
					insurAddressBean.getSchema().setHomeAddress(appntCompanyRoad);
					insurAddressBean.getSchema().setEMail(appntCompanyVillage);
				} else
				if ("1".equals(insurLinkAdrType))
				{
					insurAddressBean.getSchema().setHomeZipCode(InsurCompanyZipCode);
					insurAddressBean.getSchema().setHomeFax(insurCompanyProvince);
					insurAddressBean.getSchema().setBP(insurCompanyCity);
					insurAddressBean.getSchema().setHomePhone(insurCompanyCounty);
					insurAddressBean.getSchema().setHomeAddress(insurCompanyRoad);
					insurAddressBean.getSchema().setEMail(insurCompanyVillage);
				}
			} else
			if ("01".equals(tAIRelation))
			{
				String tLinkAdrType = appntAddressBean.getSchema().getPostalAddress();
				if ("0".equals(tLinkAdrType))
				{
					appntAddressBean.getSchema().setHomeZipCode(AppntCompanyZipCode);
					appntAddressBean.getSchema().setHomeFax(appntCompanyProvince);
					appntAddressBean.getSchema().setBP(appntCompanyCity);
					appntAddressBean.getSchema().setHomePhone(appntCompanyCounty);
					appntAddressBean.getSchema().setHomeAddress(appntCompanyRoad);
					appntAddressBean.getSchema().setEMail(appntCompanyVillage);
				} else
				if ("1".equals(tLinkAdrType))
				{
					appntAddressBean.getSchema().setHomeZipCode(InsurCompanyZipCode);
					appntAddressBean.getSchema().setHomeFax(insurCompanyProvince);
					appntAddressBean.getSchema().setBP(insurCompanyCity);
					appntAddressBean.getSchema().setHomePhone(insurCompanyCounty);
					appntAddressBean.getSchema().setHomeAddress(insurCompanyRoad);
					appntAddressBean.getSchema().setEMail(insurCompanyVillage);
				}
				insurAddressBean.getSchema().setHomeZipCode(appntAddressBean.getSchema().getHomeZipCode());
				insurAddressBean.getSchema().setHomeFax(appntAddressBean.getSchema().getHomeFax());
				insurAddressBean.getSchema().setBP(appntAddressBean.getSchema().getBP());
				insurAddressBean.getSchema().setHomePhone(appntAddressBean.getSchema().getHomePhone());
				insurAddressBean.getSchema().setHomeAddress(appntAddressBean.getSchema().getHomeAddress());
				insurAddressBean.getSchema().setEMail(appntAddressBean.getSchema().getEMail());
			} else
			{
				String tLinkAdrType = insurAddressBean.getSchema().getPostalAddress();
				if ("0".equals(tLinkAdrType))
				{
					insurAddressBean.getSchema().setHomeZipCode(AppntCompanyZipCode);
					insurAddressBean.getSchema().setHomeFax(appntCompanyProvince);
					insurAddressBean.getSchema().setBP(appntCompanyCity);
					insurAddressBean.getSchema().setHomePhone(appntCompanyCounty);
					insurAddressBean.getSchema().setHomeAddress(appntCompanyRoad);
					insurAddressBean.getSchema().setEMail(appntCompanyVillage);
				} else
				if ("1".equals(tLinkAdrType))
				{
					insurAddressBean.getSchema().setHomeZipCode(InsurCompanyZipCode);
					insurAddressBean.getSchema().setHomeFax(insurCompanyProvince);
					insurAddressBean.getSchema().setBP(insurCompanyCity);
					insurAddressBean.getSchema().setHomePhone(insurCompanyCounty);
					insurAddressBean.getSchema().setHomeAddress(insurCompanyRoad);
					insurAddressBean.getSchema().setEMail(insurCompanyVillage);
				}
				appntAddressBean.getSchema().setHomeZipCode(insurAddressBean.getSchema().getHomeZipCode());
				appntAddressBean.getSchema().setHomeFax(insurAddressBean.getSchema().getHomeFax());
				appntAddressBean.getSchema().setBP(insurAddressBean.getSchema().getBP());
				appntAddressBean.getSchema().setHomePhone(insurAddressBean.getSchema().getHomePhone());
				appntAddressBean.getSchema().setHomeAddress(insurAddressBean.getSchema().getHomeAddress());
				appntAddressBean.getSchema().setEMail(insurAddressBean.getSchema().getEMail());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
	}

	private void copyAppntMsgToInsurMsg()
	{
		InsurName = AppntName;
		InsurSex = AppntSex;
		InsurBirthDay = AppntBirthDay;
		InsurAge = AppntAge;
		InsurIDType = AppntIDType;
		InsurID = AppntID;
		InsurIDVailityType = AppntIDVailityType;
		InsurIDVaility = AppntIDVaility;
		InsurNative = AppntNative;
		InsurIDView = AppntIDView;
		InsurGrpName = AppntGrpName;
		IOccupationCode = AOccupationCode;
		IOccupationName = AOccupationName;
		InsurCompanyPhone = AppntCompanyPhone;
		InsurCompanyZipCode = AppntCompanyZipCode;
		InsurIPhone = AppntIPhone;
		InsurCompanyMail = AppntCompanyMail;
		InsurSalary = AppntSalary;
		InsurLinkAdr = AppntLinkAdr;
		InsurHomeZipCode = AppntHomeZipCode;
		insuAreaCode = appntAreaCode;
		insurCompanyProvince = appntCompanyProvince;
		insurCompanyCity = appntCompanyCity;
		insurCompanyCounty = appntCompanyCounty;
		insurCompanyRoad = appntCompanyRoad;
		insurCompanyVillage = appntCompanyVillage;
		insurHomeProvince = appntHomeProvince;
		insurHomeCity = appntHomeCity;
		insurHomeCounty = appntHomeCounty;
		insurHomeRoad = appntHomeRoad;
		insurHomeVillage = appntHomeVillage;
	}

	public void addOneBnf()
	{
		operateResult = true;
		if (bnfList.size() < BnfMaxSize)
		{
			BankLNPBnfBean bnfBean = new BankLNPBnfBean();
			bnfBean.getSchema().setBnfOrder((new StringBuilder(String.valueOf(bnfList.size()))).toString());
			bnfList.add(bnfBean);
			BnfSize = bnfList.size();
		} else
		{
			buildError("受益人人数已达上限，不能再进行添加操作");
		}
		System.out.println((new StringBuilder(String.valueOf(bnfList.size()))).append("--------addOneBnf------").toString());
	}

	public void delBnfById()
	{
		operateResult = true;
		if (bnfList.size() > 0)
		{
			BankLNPBnfBean bnfBean = (BankLNPBnfBean)bnfList.remove(getBnfIdx(bnfList));
			if (bnfBean != null && bnfBean.isValidate() && bnfBean.getSchema().getBnfId() != null && !"".equals(bnfBean.getSchema().getBnfId()))
				delBnfList.add(bnfBean);
			BnfSize = bnfList.size();
		} else
		{
			buildError("受益人初始人数已达下限，不能再进行删除操作");
		}
		System.out.println((new StringBuilder(String.valueOf(bnfList.size()))).append("--------delOneBnf------").append(delBnfList.size()).toString());
	}

	private int getBnfIdx(List bnfList)
	{
		int idx = 0;
		try
		{
			if (bnfList != null && bnfList.size() > 0)
				if (!"".equals(curBnfId))
				{
					idx = bnfList.size() - 1;
					for (int i = 0; i < bnfList.size(); i++)
					{
						idx = i;
						BankLNPBnfBean tBnfBean = (BankLNPBnfBean)bnfList.get(i);
						if (turnNullToString(tBnfBean.getSchema().getBnfId()).equals(curBnfId))
							break;
					}

				} else
				{
					idx = curIdx;
				}
		}
		catch (Exception exception) { }
		System.out.println((new StringBuilder("--input bnfid:")).append(curBnfId).append("idx:").append(curIdx).append("----- current idx:").append(idx).append(" bnf will be delete------------------").toString());
		return idx;
	}

	private String getCurBenefitOrder(List bnfList, int curOrder)
	{
		String idx = "1";
		if (bnfList != null && bnfList.size() > 0)
		{
			double rateSum = 0.0D;
			for (int i = 0; i < curOrder; i++)
			{
				BankLNPBnfBean bnfBean = (BankLNPBnfBean)bnfList.get(i);
				if (i > 0)
				{
					if (bnfBean.getSchema().getBenefitOrder().equals(((BankLNPBnfBean)bnfList.get(i - 1)).getSchema().getBenefitOrder()) || bnfBean.getSchema().getBenefitOrder() == null)
					{
						rateSum += bnfBean.getSchema().getBenefitRate();
					} else
					{
						rateSum = 0.0D;
						rateSum += bnfBean.getSchema().getBenefitRate();
					}
				} else
				{
					rateSum += bnfBean.getSchema().getBenefitRate();
				}
			}

			int tIdx = Integer.parseInt(((BankLNPBnfBean)bnfList.get(curOrder - 1)).getSchema().getBenefitOrder());
			if (rateSum < 100D)
				idx = (new StringBuilder(String.valueOf(tIdx))).toString();
			else
				idx = (new StringBuilder(String.valueOf(tIdx + 1))).toString();
		}
		for (int i = curOrder; i < bnfList.size(); i++)
			((BankLNPBnfBean)bnfList.get(i)).getSchema().setBenefitOrder(idx);

		return idx;
	}

	private boolean bnfExists(String contNo, String bnfId, ExeSQL execSql)
	{
		boolean flag = false;
		SSRS ssrs = execSql.execSQL((new StringBuilder("select 1 from lnpbnf where contno=rtrim('")).append(contNo).append("') and bnfId = rtrim('").append(bnfId).append("'); ").toString());
		if (ssrs != null && ssrs.getMaxRow() > 0)
			flag = true;
		return flag;
	}

	private boolean validate(String valiType, BankLNPContBean contBean, BankLNPAppntBean appntBean, BankLNPInusredBean insuredBean, List bnfList, BankLNPPersonBean personBean, BankLNPAddressBean addressBean)
	{
		boolean flag = true;
		if ("appnt".equals(valiType))
		{
			appntCompelte = true;
			if (AIRealation == null || "".equals(AIRealation.trim()))
				appntCompelte = false;
			if (AppntName == null || "".equals(AppntName.trim()))
				appntCompelte = false;
			if (AppntSex == null || "".equals(AppntSex.trim()))
				appntCompelte = false;
			if (AppntBirthDay == null || "".equals(AppntBirthDay.trim()))
				appntCompelte = false;
			if (AppntAge == null || "".equals(AppntAge.trim()))
				appntCompelte = false;
			if (AppntIDType == null || "".equals(AppntIDType.trim()))
				appntCompelte = false;
			if (AppntID == null || "".equals(AppntID.trim()))
				appntCompelte = false;
			if (AppntNative == null || "".equals(AppntNative.trim()))
				appntCompelte = false;
			if (AppntIDView == null || "".equals(AppntIDView.trim()))
				appntCompelte = false;
			if (AppntGrpName == null || "".equals(AppntGrpName.trim()))
				appntCompelte = false;
			if (AOccupationCode == null || "".equals(AOccupationCode.trim()))
				appntCompelte = false;
			if (AppntCompanyZipCode == null || "".equals(AppntCompanyZipCode.trim()))
				appntCompelte = false;
			if (appntAreaCode != null && !"".equals(appntAreaCode) && !"-1".equals(appntAreaCode) && (AppntCompanyPhone == null || "".equals(AppntCompanyPhone.trim())) || (appntAreaCode == null || "".equals(appntAreaCode) || "-1".equals(appntAreaCode)) && AppntCompanyPhone != null && !"".equals(AppntCompanyPhone.trim()))
				appntCompelte = false;
			if (AppntIPhone == null || "".equals(AppntIPhone.trim()))
				appntCompelte = false;
			if (AppntCompanyMail == null || "".equals(AppntCompanyMail.trim()))
				appntCompelte = false;
			if (AppntSalary == null || "".equals(AppntSalary.trim()) || Double.parseDouble(AppntSalary) < 0.0D)
				appntCompelte = false;
			if (AppntLinkAdr == null || "".equals(AppntLinkAdr.trim()))
				appntCompelte = false;
			if (appntCompanyProvince == null || "".equals(appntCompanyProvince.trim()) || "-1".equals(appntCompanyProvince.trim()))
				appntCompelte = false;
			if (appntCompanyCity == null || "".equals(appntCompanyCity.trim()) || "-1".equals(appntCompanyCity.trim()))
				appntCompelte = false;
			if (appntCompanyCounty == null || "".equals(appntCompanyCounty.trim()) || "-1".equals(appntCompanyCounty.trim()))
				appntCompelte = false;
			if (appntCompanyRoad == null || "".equals(appntCompanyRoad.trim()))
				appntCompelte = false;
			if (appntCompanyVillage == null || "".equals(appntCompanyVillage.trim()))
				appntCompelte = false;
			if ("2".equals(AppntLinkAdr))
			{
				if (AppntHomeZipCode == null || "".equals(AppntHomeZipCode.trim()))
					appntCompelte = false;
				if (appntHomeProvince == null || "".equals(appntHomeProvince.trim()) || "-1".equals(appntHomeProvince.trim()))
					appntCompelte = false;
				if (appntHomeCity == null || "".equals(appntHomeCity.trim()) || "-1".equals(appntHomeCity.trim()))
					appntCompelte = false;
				if (appntHomeCounty == null || "".equals(appntHomeCounty.trim()) || "-1".equals(appntHomeCounty.trim()))
					appntCompelte = false;
				if (appntHomeRoad == null || "".equals(appntHomeRoad.trim()))
					appntCompelte = false;
				if (appntHomeVillage == null || "".equals(appntHomeVillage.trim()))
					appntCompelte = false;
			}
		} else
		if ("insured".equals(valiType))
		{
			insurCompelte = true;
			if (InsurName == null || "".equals(InsurName.trim()))
				appntCompelte = false;
			if (InsurSex == null || "".equals(InsurSex.trim()))
				insurCompelte = false;
			if (InsurBirthDay == null || "".equals(InsurBirthDay.trim()))
				insurCompelte = false;
			if (InsurAge == null || "".equals(InsurAge.trim()))
				insurCompelte = false;
			if (InsurIDType == null || "".equals(InsurIDType.trim()))
				insurCompelte = false;
			if (InsurID == null || "".equals(InsurID.trim()))
				insurCompelte = false;
			if (InsurNative == null || "".equals(InsurNative.trim()))
				insurCompelte = false;
			if (InsurIDView == null || "".equals(InsurIDView.trim()))
				insurCompelte = false;
			if (InsurGrpName == null || "".equals(InsurGrpName.trim()))
				insurCompelte = false;
			if (IOccupationCode == null || "".equals(IOccupationCode.trim()))
				insurCompelte = false;
			if (InsurCompanyZipCode == null || "".equals(InsurCompanyZipCode.trim()))
				insurCompelte = false;
			if (insuAreaCode != null && !"".equals(insuAreaCode) && !"-1".equals(insuAreaCode) && (InsurCompanyPhone == null || "".equals(InsurCompanyPhone.trim())) || (insuAreaCode == null || "".equals(insuAreaCode) || "-1".equals(insuAreaCode)) && InsurCompanyPhone != null && !"".equals(InsurCompanyPhone.trim()))
				insurCompelte = false;
			if (InsurCompanyMail == null || "".equals(InsurCompanyMail.trim()))
				insurCompelte = false;
			if (InsurSalary == null || "".equals(InsurSalary.trim()) || Double.parseDouble(InsurSalary) < 0.0D)
				insurCompelte = false;
			if (InsurLinkAdr == null || "".equals(InsurLinkAdr.trim()))
				insurCompelte = false;
			if (insurCompanyProvince == null || "".equals(insurCompanyProvince.trim()) || "-1".equals(insurCompanyProvince.trim()))
				insurCompelte = false;
			if (insurCompanyCity == null || "".equals(insurCompanyCity.trim()) || "-1".equals(insurCompanyCity.trim()))
				insurCompelte = false;
			if (insurCompanyCounty == null || "".equals(insurCompanyCounty.trim()) || "-1".equals(insurCompanyCounty.trim()))
				insurCompelte = false;
			if (insurCompanyRoad == null || "".equals(insurCompanyRoad.trim()))
				insurCompelte = false;
			if (insurCompanyVillage == null || "".equals(insurCompanyVillage.trim()))
				insurCompelte = false;
			if ("2".equals(InsurLinkAdr))
			{
				if (InsurHomeZipCode == null || "".equals(InsurHomeZipCode.trim()))
					insurCompelte = false;
				if (insurHomeProvince == null || "".equals(insurHomeProvince.trim()) || "-1".equals(insurHomeProvince.trim()))
					insurCompelte = false;
				if (insurHomeCity == null || "".equals(insurHomeCity.trim()) || "-1".equals(insurHomeCity.trim()))
					insurCompelte = false;
				if (insurHomeCounty == null || "".equals(insurHomeCounty.trim()) || "-1".equals(insurHomeCounty.trim()))
					insurCompelte = false;
				if (insurHomeRoad == null || "".equals(insurHomeRoad.trim()))
					insurCompelte = false;
				if (insurHomeVillage == null || "".equals(insurHomeVillage.trim()))
					insurCompelte = false;
			}
		} else
		if ("bnf".equals(valiType))
		{
			System.out.println("1".equals(BnfIsExist));
			bnfCompelte = true;
			if ("1".equals(BnfIsExist))
			{
				if (bnfList != null && bnfList.size() > 0)
				{
					for (int i = 0; i < bnfList.size(); i++)
					{
						BankLNPBnfBean bnfBean = (BankLNPBnfBean)bnfList.get(i);
						LNPBnfSchema bnfSchema = bnfBean.getSchema();
						if (bnfBean.isValidate() && !"delete".equals(bnfSchema.getHealth()))
						{
							if (bnfSchema.getBnfName() == null || "".equals(bnfSchema.getBnfName().trim()))
								bnfCompelte = false;
							if (bnfSchema.getRelationToInsured() == null || "".equals(bnfSchema.getRelationToInsured().trim()))
								bnfCompelte = false;
							if (bnfSchema.getBenefitOrder() == null || "".equals(bnfSchema.getBenefitOrder().trim()))
								bnfCompelte = false;
							if (bnfSchema.getBenefitRate() == 0.0D)
							{
								bnfCompelte = false;
								System.out.println((new StringBuilder("第")).append(bnfSchema.getBenefitOrder()).append("受益人:").append(bnfSchema.getBnfName()).append(",受益比例需要大于0").toString());
							}
							if ("1".equals(bnfSchema.getIDPerpetual()) && bnfSchema.getIDValidity() != null && "".equals(bnfSchema.getIDValidity().trim()))
								System.out.println((new StringBuilder("第")).append(bnfSchema.getBenefitOrder()).append("受益人:").append(bnfSchema.getBnfName()).append(",证件为非终生有效,证件有效期应不为空").toString());
						}
					}

				}
			} else
			{
				bnfCompelte = true;
			}
		}
		return flag;
	}

	private void initCRSInfoMsg(CRSInfoBean crsBean, BankLNPAddressBean addressBean)
	{
		try
		{
			CRSInfoSchema crsSchema = crsBean.getSchema();
			contNo = crsSchema.getContNo();
			System.out.println((new StringBuilder("从Schema中获取信息")).append(crsSchema).toString());
			birthAddress_City = getAddressCode(crsSchema.getBirthAddress_City(), 4);
			birthAddress_City_en = getAddressCode(crsSchema.getBirthAddress_City_en(), 4);
			birthAddress_Country = getCode(crsSchema.getBirthAddress_Country(), "");
			birthAddress_Detail = crsSchema.getBirthAddress_Detail();
			birthAddress_Detail_en = crsSchema.getBirthAddress_Detail_en();
			birthAddress_Province = getAddressCode(crsSchema.getBirthAddress_Province(), 2);
			birthAddress_Province_en = getAddressCode(crsSchema.getBirthAddress_Province_en(), 2);
			birthday = crsSchema.getBirthday();
			currentAddress_City = getAddressCode(addressBean.getSchema().getBP(), 4);
			currentAddress_City_en = getAddressCode(crsSchema.getCurrentAddress_City_en(), 4);
			currentAddress_Country = getCode(crsSchema.getCurrentAddress_Country(), "");
			currentAddress_Detail = crsSchema.getCurrentAddress_Detail();
			currentAddress_Detail_en = crsSchema.getCurrentAddress_Detail_en();
			currentAddress_Province = getAddressCode(addressBean.getSchema().getHomeFax(), 2);
			currentAddress_Province_en = getAddressCode(crsSchema.getCurrentAddress_Province_en(), 2);
			customerName = crsSchema.getCustomerName();
			firstName = crsSchema.getFirstName();
			lastName = crsSchema.getLastName();
			noTaxpayercodeReason = crsSchema.getNoTaxpayercodeReason();
			taxpayerCode1 = crsSchema.getTaxpayerCode1();
			taxpayerCode2 = crsSchema.getTaxpayerCode2();
			taxpayerCode3 = crsSchema.getTaxpayerCode3();
			taxResidentCountry1 = crsSchema.getTaxResidentCountry1();
			taxResidentCountry2 = crsSchema.getTaxResidentCountry2();
			taxResidentCountry3 = crsSchema.getTaxResidentCountry3();
			taxResidentType = crsSchema.getTaxResidentType();
			currentAddress_Country_en = getCode(crsSchema.getCurrentAddress_Country_en(), "e");
			birthAddress_Country_en = getCode(crsSchema.getBirthAddress_Country_en(), "e");
			reasonDescription = crsSchema.getReasonDescription();
		}
		catch (Exception e)
		{
			buildError(e.getMessage());
		}
	}

	private void initAppntMsg(BankLNPAppntBean appntBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean)
	{
		try
		{
			LNPAppntSchema appntSchema = appntBean.getSchema();
			LNPPersonSchema personSchema = personBean.getSchema();
			LNPAddressSchema addrSchema = addressBean.getSchema();
			AIRealation = appntSchema.getRelationToInsured();
			AppntVIP = appntSchema.getAppntGrade();
			AppntName = appntSchema.getAppntName();
			AppntSex = appntSchema.getAppntSex();
			AppntBirthDay = appntSchema.getAppntBirthday();
			if (appntSchema.getAppntBirthday() != null && !appntSchema.getAppntBirthday().equals(""))
				AppntAge = LNPPubFun.getAgeByBirthdayNew(appntSchema.getAppntBirthday(), contBean.getSchema().getPValiDate());
			else
				AppntAge = "";
			AppntIDType = appntSchema.getIDType();
			AppntID = appntSchema.getIDNo();
			AppntIDVailityType = appntSchema.getIDPerpetual();
			AppntIDVaility = appntSchema.getIDValidity();
			AppntNative = appntSchema.getNativePlace();
			AppntIDView = appntSchema.getHealth();
			AppntGrpName = addrSchema.getGrpName();
			AOccupationCode = appntSchema.getOccupationCode();
			AOccupationName = (String)occNameMap.get(appntSchema.getOccupationCode());
			AppntCompanyPhone = addrSchema.getCompanyPhone();
			AppntCompanyZipCode = addrSchema.getCompanyZipCode();
			AppntIPhone = addrSchema.getPhone();
			AppntCompanyMail = addrSchema.getCompanyMail();
			System.out.println((new StringBuilder("---------------------------------------")).append(appntSchema.getSalary()).toString());
			AppntSalary = (appntSchema.getSalary() >= 0.0D ? (new StringBuilder(String.valueOf(appntSchema.getSalary()))).toString() : "").trim();
			AppntLinkAdr = addrSchema.getPostalAddress();
			AppntHomeZipCode = addrSchema.getHomeZipCode();
			appntCompanyProvince = addrSchema.getCompanyFax();
			appntCompanyCity = addrSchema.getBP2();
			appntCompanyCounty = addrSchema.getMobile2();
			appntCompanyRoad = addrSchema.getCompanyAddress();
			appntCompanyVillage = addrSchema.getEMail2();
			appntAreaCode = addrSchema.getMobileChs2();
			appntHomeProvince = addrSchema.getHomeFax();
			appntHomeCity = addrSchema.getBP();
			appntHomeCounty = addrSchema.getHomePhone();
			appntHomeRoad = addrSchema.getHomeAddress();
			appntHomeVillage = addrSchema.getEMail();
			System.out.println((new StringBuilder("&&&&&&&&&&&初始化投保人信息完成：appntBean：")).append(this.appntBean.getSchema().getAppntName()).toString());
		}
		catch (Exception e)
		{
			buildError(e.getMessage());
		}
	}

	private void initInsuredMsg(BankLNPInusredBean insuredBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean)
	{
		try
		{
			LNPInsuredSchema inusredSchema = insuredBean.getSchema();
			LNPPersonSchema personSchema = personBean.getSchema();
			LNPAddressSchema addrSchema = addressBean.getSchema();
			InsurName = inusredSchema.getName();
			InsurSex = inusredSchema.getSex();
			InsurBirthDay = inusredSchema.getBirthday();
			if (inusredSchema.getBirthday() != null && !inusredSchema.getBirthday().equals(""))
				InsurAge = LNPPubFun.getAgeByBirthdayNew(inusredSchema.getBirthday(), contBean.getSchema().getPValiDate());
			else
				InsurAge = "";
			InsurIDType = inusredSchema.getIDType();
			InsurID = inusredSchema.getIDNo();
			InsurIDVailityType = inusredSchema.getIDPerpetual();
			InsurIDVaility = inusredSchema.getIDValidity();
			InsurNative = inusredSchema.getNativePlace();
			InsurIDView = inusredSchema.getHealth();
			InsurGrpName = addrSchema.getGrpName();
			IOccupationCode = inusredSchema.getOccupationCode();
			IOccupationName = (String)occNameMap.get(inusredSchema.getOccupationCode());
			InsurCompanyPhone = addrSchema.getCompanyPhone();
			InsurCompanyZipCode = addrSchema.getCompanyZipCode();
			InsurIPhone = addrSchema.getPhone();
			InsurCompanyMail = addrSchema.getCompanyMail();
			InsurSalary = (inusredSchema.getSalary() >= 0.0D ? (new StringBuilder(String.valueOf(inusredSchema.getSalary()))).toString() : "").trim();
			InsurLinkAdr = addrSchema.getPostalAddress();
			InsurHomeZipCode = addrSchema.getHomeZipCode();
			BnfIsExist = (new StringBuilder(String.valueOf(inusredSchema.getInsuredPeoples()))).toString();
			BnfRecType = inusredSchema.getCreditGrade();
			insurCompanyProvince = addrSchema.getCompanyFax();
			insurCompanyCity = addrSchema.getBP2();
			insurCompanyCounty = addrSchema.getMobile2();
			insurCompanyRoad = addrSchema.getCompanyAddress();
			insurCompanyVillage = addrSchema.getEMail2();
			insuAreaCode = addrSchema.getMobileChs2();
			insurHomeProvince = addrSchema.getHomeFax();
			insurHomeCity = addrSchema.getBP();
			insurHomeCounty = addrSchema.getHomePhone();
			insurHomeRoad = addrSchema.getHomeAddress();
			insurHomeVillage = addrSchema.getEMail();
		}
		catch (Exception e)
		{
			buildError(e.getMessage());
		}
	}

	private BankLNPContBean recOneContInfo(String contNo)
	{
		BankLNPContBean bean = new BankLNPContBean();
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema tSchema = mainInfo.getContByContNo(contNo);
		if (tSchema != null)
			bean.setSchema(tSchema);
		return bean;
	}

	private BankLNPAppntBean recOneAppntPersonInfo(String contNo, String AppntId)
	{
		BankLNPAppntBean bean = new BankLNPAppntBean();
		LNPAppntDB db = new LNPAppntDB();
		db.setContNo(contNo);
		db.setAppntId(AppntId);
		LNPAppntSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		System.out.println((new StringBuilder("&&&&&&&&&投保单号")).append(contNo).append("--appntID").append(AppntId).append("--bean").append(bean.getSchema().getAppntName()).toString());
		return bean;
	}

	private String getAppntIDByContno(String contNo)
	{
		BankLNPAppntBean bean = new BankLNPAppntBean();
		LNPAppntDB db = new LNPAppntDB();
		db.setContNo(contNo);
		LNPAppntSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean.getSchema().getAppntId();
	}

	private CRSInfoBean recOneCRSInfo(String contNo)
	{
		CRSInfoBean bean = new CRSInfoBean();
		CRSInfoDB db = new CRSInfoDB();
		db.setContNo(contNo);
		CRSInfoSet set = db.query();
		System.out.println((new StringBuilder("SSSSSSSSSSSSSSSSSSSSSSSSSSS")).append(contNo).append(set.size()).toString());
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean;
	}

	private BankLNPInusredBean recOneInsuredPersonInfo(String contNo, String insuredId)
	{
		BankLNPInusredBean bean = new BankLNPInusredBean();
		LNPInsuredDB db = new LNPInsuredDB();
		db.setContNo(contNo);
		db.setInsuredId(insuredId);
		LNPInsuredSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean;
	}

	private List recBnfList(String contNo)
	{
		List tempList = new ArrayList();
		String execSQL = (new StringBuilder("select * from lnpbnf where benefittype='2' and (health is null or health<>'delete') and contno = '")).append(contNo).append("' order by bnforder").toString();
		LNPBnfDB db = new LNPBnfDB();
		LNPBnfSet set = db.executeQuery(execSQL);
		if (set != null && set.size() > 0)
		{
			for (int i = 1; i <= set.size(); i++)
			{
				BankLNPBnfBean bean = new BankLNPBnfBean();
				bean.setSchema(set.get(i));
				bean.setGender((String)genderMap.get(set.get(i).getSchema().getBnfSex()));
				bean.setIdType((String)idTypeMap.get(set.get(i).getSchema().getIDType()));
				bean.setRelationToInsured((String)relationToInsuredMap.get(set.get(i).getSchema().getRelationToInsured()));
				tempList.add(bean);
			}

		}
		return tempList;
	}

	private BankLNPPersonBean recOnePersonInfo(String customerId)
	{
		BankLNPPersonBean bean = new BankLNPPersonBean();
		LNPPersonDB db = new LNPPersonDB();
		db.setCustomerId(customerId);
		LNPPersonSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean;
	}

	private BankLNPAddressBean recOneAddressInfo(String customerId)
	{
		BankLNPAddressBean bean = new BankLNPAddressBean();
		LNPAddressDB db = new LNPAddressDB();
		db.setCustomerId(customerId);
		LNPAddressSet set = db.query();
		if (set.size() > 0)
			bean.setSchema(set.get(1));
		return bean;
	}

	private boolean getInfoFromSession()
	{
		boolean flag = false;
		HttpSession session = null;
		try
		{
			session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			GI = (IGlobalInput)session.getAttribute("NPGI");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				ContNo = (String)session.getAttribute("ContNo");
				waitPolicyCommited(session, ContNo);
				turnCurrPolicyLockFlag(session, ContNo, "lock");
				flag = true;
			}
		}
		catch (Exception e)
		{
			turnCurrPolicyLockFlag(session, ContNo, "unlock");
			flag = false;
			buildError(e.getMessage());
		}
		return flag;
	}

	private void buildError(String msgErr)
	{
		System.out.println((new StringBuilder("buildError:---------------")).append(msgErr).toString());
		message = msgErr;
		operateResult = false;
		System.out.println((new StringBuilder("buildError:--after-------------")).append(message).toString());
	}

	public void cancleOccupSession()
	{
		System.out.println((new StringBuilder("----- -----")).append(OccType).toString());
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String occupationName = (String)session.getAttribute("occupationName");
		String occupationCode = (String)session.getAttribute("occupationCode");
		System.out.println((new StringBuilder("session inner-----")).append(occupationCode).append(":").append(occupationName).toString());
		if (occupationName != null && !occupationName.equals(""))
		{
			if ("appnt".equals(OccType))
				AOccupationName = occupationName;
			else
				IOccupationName = occupationName;
		} else
		if ("appnt".equals(OccType))
			AOccupationName = "";
		else
			IOccupationName = "";
		if (occupationCode != null && !occupationCode.equals(""))
		{
			if ("appnt".equals(OccType))
				AOccupationCode = occupationCode;
			else
				IOccupationCode = occupationCode;
		} else
		if ("appnt".equals(OccType))
			AOccupationCode = "";
		else
			IOccupationCode = "";
		session.removeAttribute("occupationName");
		session.removeAttribute("occupationCode");
	}

	public void getOccNameByCode()
	{
		try
		{
			String occName = (String)occNameMap.get(OccCode);
			if (occName != null && !"".equals(occName))
			{
				if ("appnt".equals(OccType))
				{
					AOccupationCode = OccCode;
					AOccupationName = occName;
				} else
				{
					IOccupationCode = OccCode;
					IOccupationName = occName;
				}
			} else
			if ("appnt".equals(OccType))
			{
				AOccupationCode = "";
				AOccupationName = "";
			} else
			{
				IOccupationCode = "";
				IOccupationName = "";
			}
			System.out.println((new StringBuilder("in-->")).append(OccCode).append("|IOccupationCode:").append(IOccupationCode).append("|IOccupationName:").append(IOccupationName).append("|AOccupationCode:").append(AOccupationCode).append("|AOccupationName:").append(AOccupationName).toString());
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}

	public void recAgeByBirthDay()
	{
		CAge = "-1";
		try
		{
			System.out.println((new StringBuilder(String.valueOf(CBirth))).append("------------").append(contBean.getSchema().getPValiDate()).toString());
			String regex = "^(?:(?:(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))0229)|(?:(?:(?:1[6-9]|[2-9]\\d)\\d{2})(?:(?:(?:0[13578]|1[02])31)|(?:(?:0[13-9]|1[0-2])(?:29|30))|(?:0[1-9]|1[0-2])(?:0[1-9]|1\\d|2[0-8]))))$";
			if (Pattern.matches(regex, CBirth))
			{
				CAge = getAgeByBirthdayNew(CBirth, contBean.getSchema().getPValiDate());
				if ("appnt".equals(CType))
					AppntAge = CAge;
				else
					InsurAge = CAge;
			} else
			{
				CAge = "";
			}
			System.out.println((new StringBuilder(String.valueOf(CType))).append("-----------recAgeByBirthDay-------------").append(CAge).toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			buildError(e.getMessage());
		}
	}

	private String getAgeByBirthdayNew(String birth, String applyDate)
	{
		String age = "-1";
		String tBirth = birth.replaceAll("-", "");
		String tApplyDate = applyDate.replaceAll("-", "");
		if (Integer.parseInt(tBirth.trim()) > Integer.parseInt(tApplyDate.trim()))
			return age;
		String args[] = LNPPubFun.getAppAge(tBirth, tApplyDate);
		if (args[0].equals("Y"))
			age = (new StringBuilder(String.valueOf(args[1]))).append("（周岁）").toString();
		else
			age = (new StringBuilder(String.valueOf(args[1]))).append("（天）").toString();
		return age;
	}

	private String formatDate(String srcDate, String formate)
	{
		String tDate = srcDate;
		if (srcDate != null && !"".equals(srcDate.trim()))
			if (formate.indexOf("-") > 0)
				tDate = (new StringBuilder(String.valueOf(srcDate.substring(0, 4)))).append("-").append(srcDate.substring(4, 6)).append("-").append(srcDate.substring(6, 8)).toString();
			else
				tDate = srcDate.replaceAll("-", "");
		return tDate;
	}

	private static void initGenderMap()
	{
		genderMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='sex' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			genderMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private static void initIdTypeMap()
	{
		idTypeMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='insuredidtype' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			idTypeMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private static void initRelationToInsuredMap()
	{
		relationToInsuredMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select code,codename from lnpcode where codetype='bnfrelationtoinsured' order by code";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			relationToInsuredMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	private static void initOccNameMap()
	{
		occNameMap.clear();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = "select occupationcode,occupationname from lnpoccupation a where exists(select b.occupationcode from lnpoccupation b where b.relacode is not null and a.RELACODE=b.RELACODE)";
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			occNameMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));

	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public BankLNPContBean getContBean()
	{
		return contBean;
	}

	public void setContBean(BankLNPContBean contBean)
	{
		this.contBean = contBean;
	}

	public BankLNPAppntBean getAppntBean()
	{
		return appntBean;
	}

	public void setAppntBean(BankLNPAppntBean appntBean)
	{
		this.appntBean = appntBean;
	}

	public BankLNPInusredBean getInusredBean()
	{
		return insuredBean;
	}

	public void setInusredBean(BankLNPInusredBean inusredBean)
	{
		insuredBean = inusredBean;
	}

	public BankLNPPersonBean getInsurPersonBean()
	{
		return insurPersonBean;
	}

	public void setInsurPersonBean(BankLNPPersonBean insurPersonBean)
	{
		this.insurPersonBean = insurPersonBean;
	}

	public BankLNPAddressBean getInsuraddressBean()
	{
		return insuraddressBean;
	}

	public void setInsuraddressBean(BankLNPAddressBean insuraddressBean)
	{
		this.insuraddressBean = insuraddressBean;
	}

	public BankLNPPersonBean getAppntPersonBean()
	{
		return appntPersonBean;
	}

	public void setAppntPersonBean(BankLNPPersonBean appntPersonBean)
	{
		this.appntPersonBean = appntPersonBean;
	}

	public BankLNPAddressBean getAppntaddressBean()
	{
		return appntaddressBean;
	}

	public void setAppntaddressBean(BankLNPAddressBean appntaddressBean)
	{
		this.appntaddressBean = appntaddressBean;
	}

	public List getBnfList()
	{
		return bnfList;
	}

	public void setBnfList(List bnfList)
	{
		this.bnfList = bnfList;
	}

	public String getAIRealation()
	{
		return AIRealation;
	}

	public void setAIRealation(String aIRealation)
	{
		AIRealation = aIRealation;
	}

	public String getAppntVIP()
	{
		return AppntVIP;
	}

	public void setAppntVIP(String appntVIP)
	{
		AppntVIP = appntVIP;
	}

	public String getAppntName()
	{
		return AppntName;
	}

	public void setAppntName(String appntName)
	{
		AppntName = appntName;
	}

	public String getAppntSex()
	{
		return AppntSex;
	}

	public void setAppntSex(String appntSex)
	{
		AppntSex = appntSex;
	}

	public String getAppntBirthDay()
	{
		return formatDate(AppntBirthDay, "YYYYMMDD");
	}

	public void setAppntBirthDay(String appntBirthDay)
	{
		AppntBirthDay = formatDate(appntBirthDay, "YYYY-MM-DD");
	}

	public String getAppntAge()
	{
		return AppntAge;
	}

	public void setAppntAge(String appntAge)
	{
		AppntAge = appntAge;
	}

	public String getAppntIDType()
	{
		return AppntIDType;
	}

	public void setAppntIDType(String appntIDType)
	{
		AppntIDType = appntIDType;
	}

	public String getAppntID()
	{
		return AppntID;
	}

	public void setAppntID(String appntID)
	{
		AppntID = appntID;
	}

	public String getAppntIDVailityType()
	{
		return AppntIDVailityType;
	}

	public void setAppntIDVailityType(String appntIDVailityType)
	{
		AppntIDVailityType = appntIDVailityType;
	}

	public String getAppntIDVaility()
	{
		return formatDate(AppntIDVaility, "YYYMMDD");
	}

	public void setAppntIDVaility(String appntIDVaility)
	{
		AppntIDVaility = formatDate(appntIDVaility, "YYYY-MM-DD");
	}

	public String getAppntNative()
	{
		return AppntNative;
	}

	public void setAppntNative(String appntNative)
	{
		AppntNative = appntNative;
	}

	public String getAppntIDView()
	{
		return AppntIDView;
	}

	public void setAppntIDView(String appntIDView)
	{
		AppntIDView = appntIDView;
	}

	public String getAppntGrpName()
	{
		return AppntGrpName;
	}

	public void setAppntGrpName(String appntGrpName)
	{
		AppntGrpName = appntGrpName;
	}

	public String getOccType()
	{
		return OccType;
	}

	public void setOccType(String occType)
	{
		OccType = occType;
	}

	public String getAOccupationCode()
	{
		return AOccupationCode;
	}

	public void setAOccupationCode(String aOccupationCode)
	{
		AOccupationCode = aOccupationCode;
	}

	public String getAOccupationName()
	{
		return AOccupationName;
	}

	public void setAOccupationName(String aOccupationName)
	{
		AOccupationName = aOccupationName;
	}

	public String getAppntCompanyAddr()
	{
		return AppntCompanyAddr;
	}

	public void setAppntCompanyAddr(String appntCompanyAddr)
	{
		AppntCompanyAddr = appntCompanyAddr;
	}

	public String getAppntCompanyPhone()
	{
		return AppntCompanyPhone;
	}

	public void setAppntCompanyPhone(String appntCompanyPhone)
	{
		AppntCompanyPhone = appntCompanyPhone;
	}

	public String getAppntCompanyZipCode()
	{
		return AppntCompanyZipCode;
	}

	public void setAppntCompanyZipCode(String appntCompanyZipCode)
	{
		AppntCompanyZipCode = appntCompanyZipCode;
	}

	public String getAppntIPhone()
	{
		return AppntIPhone;
	}

	public void setAppntIPhone(String appntIPhone)
	{
		AppntIPhone = appntIPhone;
	}

	public String getAppntCompanyMail()
	{
		return AppntCompanyMail;
	}

	public void setAppntCompanyMail(String appntCompanyMail)
	{
		AppntCompanyMail = appntCompanyMail;
	}

	public String getAppntSalary()
	{
		return AppntSalary;
	}

	public void setAppntSalary(String appntSalary)
	{
		AppntSalary = appntSalary;
	}

	public String getAppntLinkAdr()
	{
		return AppntLinkAdr;
	}

	public void setAppntLinkAdr(String appntLinkAdr)
	{
		AppntLinkAdr = appntLinkAdr;
	}

	public String getAppntHomeZipCode()
	{
		return AppntHomeZipCode;
	}

	public void setAppntHomeZipCode(String appntHomeZipCode)
	{
		AppntHomeZipCode = appntHomeZipCode;
	}

	public String getAppntHomeAddr()
	{
		return AppntHomeAddr;
	}

	public void setAppntHomeAddr(String appntHomeAddr)
	{
		AppntHomeAddr = appntHomeAddr;
	}

	public String getInsurName()
	{
		return InsurName;
	}

	public void setInsurName(String insurName)
	{
		InsurName = insurName;
	}

	public String getInsurSex()
	{
		return InsurSex;
	}

	public void setInsurSex(String insurSex)
	{
		InsurSex = insurSex;
	}

	public String getInsurBirthDay()
	{
		return formatDate(InsurBirthDay, "YYYYMMDD");
	}

	public void setInsurBirthDay(String insurBirthDay)
	{
		InsurBirthDay = formatDate(insurBirthDay, "YYYY-MM-DD");
	}

	public String getInsurAge()
	{
		return InsurAge;
	}

	public void setInsurAge(String insurAge)
	{
		InsurAge = insurAge;
	}

	public String getInsurIDType()
	{
		return InsurIDType;
	}

	public void setInsurIDType(String insurIDType)
	{
		InsurIDType = insurIDType;
	}

	public String getInsurID()
	{
		return InsurID;
	}

	public void setInsurID(String insurID)
	{
		InsurID = insurID;
	}

	public String getInsurIDVailityType()
	{
		return InsurIDVailityType;
	}

	public void setInsurIDVailityType(String insurIDVailityType)
	{
		InsurIDVailityType = insurIDVailityType;
	}

	public String getInsurIDVaility()
	{
		return formatDate(InsurIDVaility, "YYYYMMDD");
	}

	public void setInsurIDVaility(String insurIDVaility)
	{
		InsurIDVaility = formatDate(insurIDVaility, "YYYY-MM-DD");
	}

	public String getInsurNative()
	{
		return InsurNative;
	}

	public void setInsurNative(String insurNative)
	{
		InsurNative = insurNative;
	}

	public String getInsurIDView()
	{
		return InsurIDView;
	}

	public void setInsurIDView(String insurIDView)
	{
		InsurIDView = insurIDView;
	}

	public String getInsurGrpName()
	{
		return InsurGrpName;
	}

	public void setInsurGrpName(String insurGrpName)
	{
		InsurGrpName = insurGrpName;
	}

	public String getIOccupationCode()
	{
		return IOccupationCode;
	}

	public void setIOccupationCode(String iOccupationCode)
	{
		IOccupationCode = iOccupationCode;
	}

	public String getIOccupationName()
	{
		return IOccupationName;
	}

	public void setIOccupationName(String iOccupationName)
	{
		IOccupationName = iOccupationName;
	}

	public String getInsurCompanyAddr()
	{
		return InsurCompanyAddr;
	}

	public void setInsurCompanyAddr(String insurCompanyAddr)
	{
		InsurCompanyAddr = insurCompanyAddr;
	}

	public String getInsurCompanyPhone()
	{
		return InsurCompanyPhone;
	}

	public void setInsurCompanyPhone(String insurCompanyPhone)
	{
		InsurCompanyPhone = insurCompanyPhone;
	}

	public String getInsurCompanyZipCode()
	{
		return InsurCompanyZipCode;
	}

	public void setInsurCompanyZipCode(String insurCompanyZipCode)
	{
		InsurCompanyZipCode = insurCompanyZipCode;
	}

	public String getInsurIPhone()
	{
		return InsurIPhone;
	}

	public void setInsurIPhone(String insurIPhone)
	{
		InsurIPhone = insurIPhone;
	}

	public String getInsurCompanyMail()
	{
		return InsurCompanyMail;
	}

	public void setInsurCompanyMail(String insurCompanyMail)
	{
		InsurCompanyMail = insurCompanyMail;
	}

	public String getInsurSalary()
	{
		return InsurSalary;
	}

	public void setInsurSalary(String insurSalary)
	{
		InsurSalary = insurSalary;
	}

	public String getInsurLinkAdr()
	{
		return InsurLinkAdr;
	}

	public void setInsurLinkAdr(String insurLinkAdr)
	{
		InsurLinkAdr = insurLinkAdr;
	}

	public String getInsurHomeZipCode()
	{
		return InsurHomeZipCode;
	}

	public void setInsurHomeZipCode(String insurHomeZipCode)
	{
		InsurHomeZipCode = insurHomeZipCode;
	}

	public String getInsurHomeAddr()
	{
		return InsurHomeAddr;
	}

	public void setInsurHomeAddr(String insurHomeAddr)
	{
		InsurHomeAddr = insurHomeAddr;
	}

	public String getMessage()
	{
		System.out.println((new StringBuilder("get--------------")).append(message).toString());
		return message;
	}

	public void setMessage(String message)
	{
		System.out.println((new StringBuilder("set--------------")).append(message).toString());
		this.message = message;
	}

	public boolean isAppntHasFlag()
	{
		return appntHasFlag;
	}

	public void setAppntHasFlag(boolean appntHasFlag)
	{
		this.appntHasFlag = appntHasFlag;
	}

	public boolean isInsurHasFlag()
	{
		return insurHasFlag;
	}

	public void setInsurHasFlag(boolean insurHasFlag)
	{
		this.insurHasFlag = insurHasFlag;
	}

	public boolean isBnfHasFlag()
	{
		return bnfHasFlag;
	}

	public void setBnfHasFlag(boolean bnfHasFlag)
	{
		this.bnfHasFlag = bnfHasFlag;
	}

	public IGlobalInput getGI()
	{
		return GI;
	}

	public void setGI(IGlobalInput gI)
	{
		GI = gI;
	}

	public String getBnfIsExist()
	{
		return BnfIsExist;
	}

	public void setBnfIsExist(String bnfIsExist)
	{
		BnfIsExist = bnfIsExist;
	}

	public String getBnfRecType()
	{
		return BnfRecType;
	}

	public void setBnfRecType(String bnfRecType)
	{
		BnfRecType = bnfRecType;
	}

	public boolean isOperateResult()
	{
		return operateResult;
	}

	public void setOperateResult(boolean operateResult)
	{
		this.operateResult = operateResult;
	}

	public List getDelBnfList()
	{
		return delBnfList;
	}

	public void setDelBnfList(List delBnfList)
	{
		this.delBnfList = delBnfList;
	}

	public int getBnfMinSize()
	{
		return BnfMinSize;
	}

	public void setBnfMinSize(int bnfMinSize)
	{
		BnfMinSize = bnfMinSize;
	}

	public int getBnfSize()
	{
		return BnfSize;
	}

	public void setBnfSize(int bnfSize)
	{
		BnfSize = bnfSize;
	}

	public String getCAge()
	{
		return CAge;
	}

	public void setCAge(String cAge)
	{
		CAge = cAge;
	}

	public String getCType()
	{
		return CType;
	}

	public void setCType(String cType)
	{
		CType = cType;
	}

	public String getCBirth()
	{
		return CBirth;
	}

	public void setCBirth(String cBirth)
	{
		CBirth = cBirth;
	}

	public boolean isAllCompelte()
	{
		return allCompelte;
	}

	public void setAllCompelte(boolean allCompelte)
	{
		this.allCompelte = allCompelte;
	}

	public String getOccCode()
	{
		return OccCode;
	}

	public void setOccCode(String occCode)
	{
		OccCode = occCode;
	}

	public String getCurBnfId()
	{
		return curBnfId;
	}

	public void setCurBnfId(String curBnfId)
	{
		this.curBnfId = curBnfId;
	}

	public int getCurIdx()
	{
		return curIdx;
	}

	public void setCurIdx(int curIdx)
	{
		this.curIdx = curIdx;
	}

	public String getAppntAreaCode()
	{
		return appntAreaCode;
	}

	public void setAppntAreaCode(String appntAreaCode)
	{
		this.appntAreaCode = appntAreaCode;
	}

	public String getAppntHomeProvince()
	{
		return appntHomeProvince;
	}

	public void setAppntHomeProvince(String appntHomeProvince)
	{
		this.appntHomeProvince = appntHomeProvince;
	}

	public String getAppntHomeCity()
	{
		return appntHomeCity;
	}

	public void setAppntHomeCity(String appntHomeCity)
	{
		this.appntHomeCity = appntHomeCity;
	}

	public String getAppntCompanyProvince()
	{
		return appntCompanyProvince;
	}

	public void setAppntCompanyProvince(String appntCompanyProvince)
	{
		this.appntCompanyProvince = appntCompanyProvince;
	}

	public String getAppntCompanyCity()
	{
		return appntCompanyCity;
	}

	public void setAppntCompanyCity(String appntCompanyCity)
	{
		this.appntCompanyCity = appntCompanyCity;
	}

	public List getAppntHomeProvinceList()
	{
		if (appntHomeProvinceList != null)
			appntHomeProvinceList.clear();
		appntHomeProvinceList = getProvinceCityList("provinceCity", 2, "", "home");
		return appntHomeProvinceList;
	}

	public List getCrsBirthProvinceList()
	{
		if (crsBirthProvinceList != null)
			crsBirthProvinceList.clear();
		crsBirthProvinceList = getProvinceCityList("provinceCity", 2, "", "home");
		return crsBirthProvinceList;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getTaxResidentType()
	{
		return taxResidentType;
	}

	public void setTaxResidentType(String taxResidentType)
	{
		this.taxResidentType = taxResidentType;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getCurrentAddress_Country()
	{
		return currentAddress_Country;
	}

	public void setCurrentAddress_Country(String currentAddress_Country)
	{
		this.currentAddress_Country = currentAddress_Country;
	}

	public String getCurrentAddress_Province()
	{
		return currentAddress_Province;
	}

	public void setCurrentAddress_Province(String currentAddress_Province)
	{
		this.currentAddress_Province = currentAddress_Province;
	}

	public String getCurrentAddress_City()
	{
		return currentAddress_City;
	}

	public void setCurrentAddress_City(String currentAddress_City)
	{
		this.currentAddress_City = currentAddress_City;
	}

	public String getCurrentAddress_Detail()
	{
		return currentAddress_Detail;
	}

	public void setCurrentAddress_Detail(String currentAddress_Detail)
	{
		this.currentAddress_Detail = currentAddress_Detail;
	}

	public String getCurrentAddress_Country_en()
	{
		return currentAddress_Country_en;
	}

	public void setCurrentAddress_Country_en(String currentAddress_Country_en)
	{
		this.currentAddress_Country_en = currentAddress_Country_en;
	}

	public String getCurrentAddress_Province_en()
	{
		return currentAddress_Province_en;
	}

	public void setCurrentAddress_Province_en(String currentAddress_Province_en)
	{
		this.currentAddress_Province_en = currentAddress_Province_en;
	}

	public String getCurrentAddress_City_en()
	{
		return currentAddress_City_en;
	}

	public void setCurrentAddress_City_en(String currentAddress_City_en)
	{
		this.currentAddress_City_en = currentAddress_City_en;
	}

	public String getCurrentAddress_Detail_en()
	{
		return currentAddress_Detail_en;
	}

	public void setCurrentAddress_Detail_en(String currentAddress_Detail_en)
	{
		this.currentAddress_Detail_en = currentAddress_Detail_en;
	}

	public String getBirthAddress_Country()
	{
		return birthAddress_Country;
	}

	public void setBirthAddress_Country(String birthAddress_Country)
	{
		this.birthAddress_Country = birthAddress_Country;
	}

	public String getBirthAddress_Province()
	{
		return birthAddress_Province;
	}

	public void setBirthAddress_Province(String birthAddress_Province)
	{
		this.birthAddress_Province = birthAddress_Province;
	}

	public String getBirthAddress_City()
	{
		return birthAddress_City;
	}

	public void setBirthAddress_City(String birthAddress_City)
	{
		this.birthAddress_City = birthAddress_City;
	}

	public String getBirthAddress_Detail()
	{
		return birthAddress_Detail;
	}

	public void setBirthAddress_Detail(String birthAddress_Detail)
	{
		this.birthAddress_Detail = birthAddress_Detail;
	}

	public String getBirthAddress_Country_en()
	{
		return birthAddress_Country_en;
	}

	public void setBirthAddress_Country_en(String birthAddress_Country_en)
	{
		this.birthAddress_Country_en = birthAddress_Country_en;
	}

	public String getBirthAddress_Province_en()
	{
		return birthAddress_Province_en;
	}

	public void setBirthAddress_Province_en(String birthAddress_Province_en)
	{
		this.birthAddress_Province_en = birthAddress_Province_en;
	}

	public String getBirthAddress_City_en()
	{
		return birthAddress_City_en;
	}

	public void setBirthAddress_City_en(String birthAddress_City_en)
	{
		this.birthAddress_City_en = birthAddress_City_en;
	}

	public String getBirthAddress_Detail_en()
	{
		return birthAddress_Detail_en;
	}

	public void setBirthAddress_Detail_en(String birthAddress_Detail_en)
	{
		this.birthAddress_Detail_en = birthAddress_Detail_en;
	}

	public String getTaxResidentCountry1()
	{
		return taxResidentCountry1;
	}

	public void setTaxResidentCountry1(String taxResidentCountry1)
	{
		this.taxResidentCountry1 = taxResidentCountry1;
	}

	public String getTaxpayerCode1()
	{
		return taxpayerCode1;
	}

	public void setTaxpayerCode1(String taxpayerCode1)
	{
		this.taxpayerCode1 = taxpayerCode1;
	}

	public String getTaxResidentCountry2()
	{
		return taxResidentCountry2;
	}

	public void setTaxResidentCountry2(String taxResidentCountry2)
	{
		this.taxResidentCountry2 = taxResidentCountry2;
	}

	public String getTaxpayerCode2()
	{
		return taxpayerCode2;
	}

	public void setTaxpayerCode2(String taxpayerCode2)
	{
		this.taxpayerCode2 = taxpayerCode2;
	}

	public String getTaxResidentCountry3()
	{
		return taxResidentCountry3;
	}

	public void setTaxResidentCountry3(String taxResidentCountry3)
	{
		this.taxResidentCountry3 = taxResidentCountry3;
	}

	public String getTaxpayerCode3()
	{
		return taxpayerCode3;
	}

	public void setTaxpayerCode3(String taxpayerCode3)
	{
		this.taxpayerCode3 = taxpayerCode3;
	}

	public String getNoTaxpayercodeReason()
	{
		return noTaxpayercodeReason;
	}

	public void setNoTaxpayercodeReason(String noTaxpayercodeReason)
	{
		this.noTaxpayercodeReason = noTaxpayercodeReason;
	}

	public String getReasonDescription()
	{
		return reasonDescription;
	}

	public void setReasonDescription(String reasonDescription)
	{
		this.reasonDescription = reasonDescription;
	}

	public void setAppntHomeProvinceList(List appntHomeProvinceList)
	{
		this.appntHomeProvinceList = appntHomeProvinceList;
	}

	public void setCrsBirthProvinceList(List crsBirthProvinceList)
	{
		this.crsBirthProvinceList = crsBirthProvinceList;
	}

	public List getCrsBirthCityList()
	{
		if (crsBirthCityList == null || "".equals(birthAddress_Province) || "-1".equals(birthAddress_Province))
		{
			if (crsBirthCityList != null)
				crsBirthCityList.clear();
		} else
		{
			crsBirthCityList = getProvinceCityList("provinceCity", 4, birthAddress_Province, "home");
		}
		return crsBirthCityList;
	}

	public void setCrsBirthCityList(List crsBirthCityList)
	{
		this.crsBirthCityList = crsBirthCityList;
	}

	public List getAppntHomeCityList()
	{
		if (appntHomeProvince == null || "".equals(appntHomeProvince) || "-1".equals(appntHomeProvince))
		{
			if (appntHomeCityList != null)
				appntHomeCityList.clear();
		} else
		{
			appntHomeCityList = getProvinceCityList("provinceCity", 4, appntHomeProvince, "home");
		}
		return appntHomeCityList;
	}

	public void setAppntHomeCityList(List appntHomeCityList)
	{
		this.appntHomeCityList = appntHomeCityList;
	}

	public List getAppntHomeCountyList()
	{
		if (appntHomeCity == null || "".equals(appntHomeCity) || "-1".equals(appntHomeCity))
		{
			if (appntHomeCountyList != null)
				appntHomeCountyList.clear();
		} else
		{
			appntHomeCountyList = getProvinceCityList("provinceCity", 6, appntHomeCity, "home");
		}
		return appntHomeCountyList;
	}

	public void setAppntHomeCountyList(List appntHomeCountyList)
	{
		this.appntHomeCountyList = appntHomeCountyList;
	}

	public List getAppntCompanyProvinceList()
	{
		if (appntCompanyProvinceList != null)
			appntCompanyProvinceList.clear();
		appntCompanyProvinceList = getProvinceCityList("provinceCity", 2, "", "company");
		return appntCompanyProvinceList;
	}

	public void setAppntCompanyProvinceList(List appntCompanyProvinceList)
	{
		this.appntCompanyProvinceList = appntCompanyProvinceList;
	}

	public List getAppntCompanyCityList()
	{
		if (appntCompanyProvince == null || "".equals(appntCompanyProvince) || "-1".equals(appntCompanyProvince))
		{
			if (appntCompanyCityList != null)
				appntCompanyCityList.clear();
		} else
		{
			appntCompanyCityList = getProvinceCityList("provinceCity", 4, appntCompanyProvince, "company");
		}
		return appntCompanyCityList;
	}

	public void setAppntCompanyCityList(List appntCompanyCityList)
	{
		this.appntCompanyCityList = appntCompanyCityList;
	}

	public List getAppntCompanyCountyList()
	{
		if (appntCompanyCity == null || "".equals(appntCompanyCity) || "-1".equals(appntCompanyCity))
		{
			if (appntCompanyCountyList != null)
				appntCompanyCountyList.clear();
		} else
		{
			appntCompanyCountyList = getProvinceCityList("provinceCity", 6, appntCompanyCity, "company");
		}
		return appntCompanyCountyList;
	}

	public void setAppntCompanyCountyList(List appntCompanyCountyList)
	{
		this.appntCompanyCountyList = appntCompanyCountyList;
	}

	public String getInsuAreaCode()
	{
		return insuAreaCode;
	}

	public void setInsuAreaCode(String insuAreaCode)
	{
		this.insuAreaCode = insuAreaCode;
	}

	public String getInsurHomeProvince()
	{
		return insurHomeProvince;
	}

	public void setInsurHomeProvince(String insurHomeProvince)
	{
		this.insurHomeProvince = insurHomeProvince;
	}

	public String getInsurHomeCity()
	{
		return insurHomeCity;
	}

	public void setInsurHomeCity(String insurHomeCity)
	{
		this.insurHomeCity = insurHomeCity;
	}

	public String getInsurCompanyProvince()
	{
		return insurCompanyProvince;
	}

	public void setInsurCompanyProvince(String insurCompanyProvince)
	{
		this.insurCompanyProvince = insurCompanyProvince;
	}

	public String getInsurCompanyCity()
	{
		return insurCompanyCity;
	}

	public void setInsurCompanyCity(String insurCompanyCity)
	{
		this.insurCompanyCity = insurCompanyCity;
	}

	public String getAppntHomeCounty()
	{
		return appntHomeCounty;
	}

	public void setAppntHomeCounty(String appntHomeCounty)
	{
		this.appntHomeCounty = appntHomeCounty;
	}

	public String getAppntHomeRoad()
	{
		return appntHomeRoad;
	}

	public void setAppntHomeRoad(String appntHomeRoad)
	{
		this.appntHomeRoad = appntHomeRoad;
	}

	public String getAppntHomeVillage()
	{
		return appntHomeVillage;
	}

	public void setAppntHomeVillage(String appntHomeVillage)
	{
		this.appntHomeVillage = appntHomeVillage;
	}

	public String getAppntCompanyCounty()
	{
		return appntCompanyCounty;
	}

	public void setAppntCompanyCounty(String appntCompanyCounty)
	{
		this.appntCompanyCounty = appntCompanyCounty;
	}

	public String getAppntCompanyRoad()
	{
		return appntCompanyRoad;
	}

	public void setAppntCompanyRoad(String appntCompanyRoad)
	{
		this.appntCompanyRoad = appntCompanyRoad;
	}

	public String getAppntCompanyVillage()
	{
		return appntCompanyVillage;
	}

	public void setAppntCompanyVillage(String appntCompanyVillage)
	{
		this.appntCompanyVillage = appntCompanyVillage;
	}

	public String getInsurHomeCounty()
	{
		return insurHomeCounty;
	}

	public void setInsurHomeCounty(String insurHomeCounty)
	{
		this.insurHomeCounty = insurHomeCounty;
	}

	public String getInsurHomeRoad()
	{
		return insurHomeRoad;
	}

	public void setInsurHomeRoad(String insurHomeRoad)
	{
		this.insurHomeRoad = insurHomeRoad;
	}

	public String getInsurHomeVillage()
	{
		return insurHomeVillage;
	}

	public void setInsurHomeVillage(String insurHomeVillage)
	{
		this.insurHomeVillage = insurHomeVillage;
	}

	public String getInsurCompanyCounty()
	{
		return insurCompanyCounty;
	}

	public void setInsurCompanyCounty(String insurCompanyCounty)
	{
		this.insurCompanyCounty = insurCompanyCounty;
	}

	public String getInsurCompanyRoad()
	{
		return insurCompanyRoad;
	}

	public void setInsurCompanyRoad(String insurCompanyRoad)
	{
		this.insurCompanyRoad = insurCompanyRoad;
	}

	public String getInsurCompanyVillage()
	{
		return insurCompanyVillage;
	}

	public void setInsurCompanyVillage(String insurCompanyVillage)
	{
		this.insurCompanyVillage = insurCompanyVillage;
	}

	public List getInsurHomeProvinceList()
	{
		if (insurHomeProvinceList != null)
			insurHomeProvinceList.clear();
		insurHomeProvinceList = getProvinceCityList("provinceCity", 2, "", "home");
		return insurHomeProvinceList;
	}

	public void setInsurHomeProvinceList(List insurHomeProvinceList)
	{
		this.insurHomeProvinceList = insurHomeProvinceList;
	}

	public List getInsurHomeCityList()
	{
		if (insurHomeProvince == null || "".equals(insurHomeProvince) || "-1".equals(insurHomeProvince))
		{
			if (insurHomeCityList != null)
				insurHomeCityList.clear();
		} else
		{
			insurHomeCityList = getProvinceCityList("provinceCity", 4, insurHomeProvince, "home");
		}
		return insurHomeCityList;
	}

	public void setInsurHomeCityList(List insurHomeCityList)
	{
		this.insurHomeCityList = insurHomeCityList;
	}

	public List getInsurHomeCountyList()
	{
		if (insurHomeCity == null || "".equals(insurHomeCity) || "-1".equals(insurHomeCity))
		{
			if (insurHomeCountyList != null)
				insurHomeCountyList.clear();
		} else
		{
			insurHomeCountyList = getProvinceCityList("provinceCity", 6, insurHomeCity, "home");
		}
		return insurHomeCountyList;
	}

	public void setInsurHomeCountyList(List insurHomeCountyList)
	{
		this.insurHomeCountyList = insurHomeCountyList;
	}

	public List getInsurCompanyProvinceList()
	{
		if (insurCompanyProvinceList != null)
			insurCompanyProvinceList.clear();
		insurCompanyProvinceList = getProvinceCityList("provinceCity", 2, "", "company");
		return insurCompanyProvinceList;
	}

	public void setInsurCompanyProvinceList(List insurCompanyProvinceList)
	{
		this.insurCompanyProvinceList = insurCompanyProvinceList;
	}

	public List getInsurCompanyCityList()
	{
		if (insurCompanyProvince == null || "".equals(insurCompanyProvince) || "-1".equals(insurCompanyProvince))
		{
			if (insurCompanyCityList != null)
				insurCompanyCityList.clear();
		} else
		{
			insurCompanyCityList = getProvinceCityList("provinceCity", 4, insurCompanyProvince, "company");
		}
		return insurCompanyCityList;
	}

	public void setInsurCompanyCityList(List insurCompanyCityList)
	{
		this.insurCompanyCityList = insurCompanyCityList;
	}

	public List getInsurCompanyCountyList()
	{
		if (insurCompanyCity == null || "".equals(insurCompanyCity) || "-1".equals(insurCompanyCity))
		{
			if (insurCompanyCountyList != null)
				insurCompanyCountyList.clear();
		} else
		{
			insurCompanyCountyList = getProvinceCityList("provinceCity", 6, insurCompanyCity, "company");
		}
		return insurCompanyCountyList;
	}

	public void setInsurCompanyCountyList(List insurCompanyCountyList)
	{
		this.insurCompanyCountyList = insurCompanyCountyList;
	}

	private List getProvinceCityList(String typename, int codeLen, String codeFirstNum, String addrType)
	{
		List reList = new ArrayList();
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select code,codename from lnpcode where codetype='")).append(typename).append("' and len(code)=").append(codeLen).toString();
		if (codeFirstNum != null && !"".equals(codeFirstNum))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and code like '").append(codeFirstNum).append("%'").toString();
		if ("company".equals(addrType))
			sql = (new StringBuilder(String.valueOf(sql))).append(" and codealias='1'").toString();
		sql = (new StringBuilder(String.valueOf(sql))).append(" order by codeName").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSRS.MaxRow; i++)
			reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));

		return reList;
	}

	public String getValiDate()
	{
		return valiDate;
	}

	public void setValiDate(String valiDate)
	{
		this.valiDate = valiDate;
	}

	private static String getCode(String name, String type)
	{
		String code = "";
		String sql = "";
		ExeSQL tExeSQL = new ExeSQL();
		if ("e".equals(type))
			sql = (new StringBuilder("select code from crscode where  codetype='country' and codenameen='")).append(name).append("'").toString();
		else
			sql = (new StringBuilder("select code from crscode where  codetype='country' and codename='")).append(name).append("'").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.getMaxRow() > 0)
			code = tSRS.GetText(1, 1);
		return code;
	}

	private static String getAddressCode(String name, int len)
	{
		String code = "";
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select code from lnpcode where  codetype='provinceCity' and codename='")).append(name).append("' and len(code)=").append(len).toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.getMaxRow() > 0)
			code = tSRS.GetText(1, 1);
		return code;
	}

	private static String getAddressName(String code)
	{
		String addr = "";
		ExeSQL tExeSQL = new ExeSQL();
		String sql = (new StringBuilder("select CodeName from lnpcode where  codetype='provinceCity' and code='")).append(code).append("'").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.getMaxRow() > 0)
			addr = tSRS.GetText(1, 1);
		return addr;
	}

	private static String getCName(String code, String type)
	{
		String cname = "";
		String sql = "";
		ExeSQL tExeSQL = new ExeSQL();
		if ("e".equals(type))
			sql = (new StringBuilder("select codenameen from crscode where  codetype='country' and code='")).append(code).append("'").toString();
		else
			sql = (new StringBuilder("select codename from crscode where  codetype='country' and code='")).append(code).append("'").toString();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.getMaxRow() > 0)
			cname = tSRS.GetText(1, 1);
		return cname;
	}

	static 
	{
		initGenderMap();
		initIdTypeMap();
		initRelationToInsuredMap();
		initOccNameMap();
	}
}
