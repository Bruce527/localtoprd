// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BankInsuredItem.java

package com.sinosoft.banklns.lnsmodel;

import com.sinosoft.banklns.lis.BankBasicBL;
import com.sinosoft.banklns.lis.db.*;
import com.sinosoft.banklns.lis.pubfun.*;
import com.sinosoft.banklns.lis.schema.*;
import com.sinosoft.banklns.lis.vschema.*;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.sinosoft.banklns.lnsmodel:
//			BankRelationContNo, BankOperateDeal, SpecialProductFun, LNPPolBean, 
//			LNPVulBean, PolicyMainInfo, BankPolicyState

public class BankInsuredItem extends BankBasicBL
{

	private boolean editFlag;
	private boolean operateResult;
	private BankPolicyState policyState;
	private IGlobalInput tempGI;
	private String radiotype;
	private boolean allCompelte;
	private LNPContSchema contSchema;
	private String message;
	private String infoSource;
	private String contNo;
	private LNPPolSchema polSchema;
	private LNPBonusInfoSchema bonusInfoSchema;
	private LNPInvestmentInfoSchema investSchema;
	private String poltype;
	private String sumprem;
	private String riskcode[];
	private String years[];
	private String payyears[];
	private String type[];
	private String money[];
	private String getyear;
	private List lnpList;
	private String vulriskcode;
	private String vulprem;
	private String vulmonthplus;
	private String vulyear;
	private String vulinvestment;
	private List vulinvestmentList;
	private int vulsize;
	private boolean vullistflag;
	private boolean vulrateflag;
	private String combinationriskcode[];
	private String combinationyears[];
	private String combinationpayyears[];
	private String combinationtype[];
	private String combinationmoney[];
	private List cbtlnpList;
	private String salechannel;
	private String yearmoneychangeriskcode;
	private String yearmoneychangeyears;
	private String yearmoneychangepayyears;
	private String yearmoneychangemoney;
	private String yearmoneychangegetyear;
	private List ymclnpList;
	private Integer payintv;
	private String overflowpremium;
	private String overduepremium;
	private String deadgetmode;
	private String bonusgetmode;
	private String annuityfrequency;
	BankRelationContNo relationDeal;
	private String operType;
	private String manageCom;
	private boolean alertFlag;
	private static DecimalFormat decimalFormat = new DecimalFormat("#0.00");

	public BankInsuredItem()
	{
		operateResult = true;
		allCompelte = false;
		polSchema = new LNPPolSchema();
		bonusInfoSchema = new LNPBonusInfoSchema();
		investSchema = new LNPInvestmentInfoSchema();
		riskcode = new String[30];
		years = new String[30];
		payyears = new String[30];
		type = new String[30];
		money = new String[30];
		vullistflag = true;
		vulrateflag = false;
		combinationriskcode = new String[6];
		combinationyears = new String[6];
		combinationpayyears = new String[6];
		combinationtype = new String[6];
		combinationmoney = new String[6];
		relationDeal = new BankRelationContNo();
	}

	public void initData()
	{
		try
		{
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			System.out.println("---------------- start init policy msg -----------------------------");
			System.out.println((new StringBuilder("投保事项获取的contNo�?--------")).append(contNo).toString());
			lnpList = new ArrayList();
			cbtlnpList = new ArrayList();
			ymclnpList = new ArrayList();
			vulinvestmentList = new ArrayList();
			vulsize = vulinvestmentList.size();
			radiotype = "";
			poltype = "01";
			overflowpremium = "02";
			overduepremium = "03";
			bonusgetmode = "01";
			deadgetmode = "01";
			getyear = "";
			sumprem = "";
			operateResult = true;
			for (int i = 0; i < 30; i++)
			{
				riskcode[i] = "";
				years[i] = null;
				payyears[i] = null;
				type[i] = "";
				money[i] = null;
			}

			vulriskcode = "";
			vulprem = null;
			vulmonthplus = null;
			vulyear = null;
			for (int i = 0; i < 6; i++)
			{
				combinationriskcode[i] = "";
				combinationyears[i] = null;
				combinationpayyears[i] = null;
				combinationtype[i] = "";
				combinationmoney[i] = null;
			}

			yearmoneychangeriskcode = "";
			yearmoneychangeyears = null;
			yearmoneychangepayyears = null;
			yearmoneychangemoney = null;
			yearmoneychangegetyear = "";
			if (getInfoFromSession(session))
			{
				contSchema = getMyLNPContByContNo(contNo);
				Boolean getEditFlag = (Boolean)session.getAttribute("Queryflag");
				BankOperateDeal stateDeal = new BankOperateDeal();
				Boolean operateFlag = Boolean.valueOf(stateDeal.isEidtSheet(contSchema.getState(), "02", tempGI.LNPRole, contNo));
				System.out.println((new StringBuilder("当前的getEditFlag的�?? ====")).append(operateFlag).toString());
				if (getEditFlag == null)
				{
					if (operateFlag.booleanValue())
						editFlag = true;
				} else
				if (getEditFlag.booleanValue() && operateFlag.booleanValue())
					editFlag = true;
				else
					editFlag = false;
				LNPPolSet polsetinfo = getPolByContNo(contNo);
				bonusInfoSchema = getBonusSchemaByContNo(contNo);
				investSchema = getInvestmentSchemaByContNo(contNo);
				if (contSchema != null && polsetinfo != null && polsetinfo.size() > 0)
				{
					System.out.println("此时说明contSchema与polsetinfo已经不为空了");
					if (polsetinfo.get(1).getKindCode().equals("01"))
					{
						System.out.println("传统险种时进�?-------------");
						poltype = "01";
						for (int i = 0; i < polsetinfo.size(); i++)
						{
							if (!polsetinfo.get(i + 1).getRiskCode().equals("") && polsetinfo.get(i + 1).getRiskCode() != null)
							{
								riskcode[i] = polsetinfo.get(i + 1).getRiskCode();
								if (polsetinfo.get(i + 1).getInsuYear() == 0 && turnNullToString(polsetinfo.get(i + 1).getInsuYearFlag()).equals(""))
									years[i] = "0";
								else
								if (turnNullToString(polsetinfo.get(i + 1).getInsuYearFlag()).equals("") || polsetinfo.get(i + 1).getInsuYear() < 0)
									years[i] = "";
								else
								if (polsetinfo.get(i + 1).getInsuYearFlag().equals("A") && polsetinfo.get(i + 1).getInsuYear() != SpecialProductFun.getRiskPro(polsetinfo.get(i + 1).getRiskCode()))
									years[i] = (new StringBuilder("T")).append(polsetinfo.get(i + 1).getInsuYear()).toString();
								else
								if (polsetinfo.get(i + 1).getInsuYearFlag().equals("A") && polsetinfo.get(i + 1).getInsuYear() == SpecialProductFun.getRiskPro(polsetinfo.get(i + 1).getRiskCode()))
									years[i] = "终身";
								else
								if (polsetinfo.get(i + 1).getInsuYearFlag().equals("Y"))
									years[i] = (new StringBuilder(String.valueOf(polsetinfo.get(i + 1).getInsuYear()))).toString();
								System.out.println("结束保障�?");
								if (turnNullToString(polsetinfo.get(i + 1).getPayEndYearFlag()).equals("") || polsetinfo.get(i + 1).getPayEndYear() < 0)
									payyears[i] = "";
								else
								if (polsetinfo.get(i + 1).getPayEndYearFlag().equals("A"))
									payyears[i] = (new StringBuilder("T")).append(polsetinfo.get(i + 1).getPayEndYear()).toString();
								else
								if (polsetinfo.get(i + 1).getPayEndYearFlag().equals("Y") && polsetinfo.get(i + 1).getPayEndYear() == 1000)
									payyears[i] = "0";
								else
								if (polsetinfo.get(i + 1).getPayEndYearFlag().equals("Y") && polsetinfo.get(i + 1).getPayEndYear() != 1000)
									payyears[i] = (new StringBuilder(String.valueOf(polsetinfo.get(i + 1).getPayEndYear()))).toString();
								System.out.println("结束缴费�?");
								type[i] = polsetinfo.get(i + 1).getUWCode();
								if (type[i].equals("01"))
									money[i] = polsetinfo.get(i + 1).getAmnt() >= 0.0D ? decimalFormat.format(polsetinfo.get(i + 1).getAmnt()) : null;
								else
								if (type[i].equals("02"))
									money[i] = polsetinfo.get(i + 1).getPrem() >= 0.0D ? decimalFormat.format(polsetinfo.get(i + 1).getPrem()) : null;
								else
									money[i] = null;
							}
							if ("M".equals(polsetinfo.get(i + 1).getSubFlag()))
								getyear = polsetinfo.get(i + 1).getGetYear() >= 0 ? (new StringBuilder(String.valueOf(polsetinfo.get(i + 1).getGetYear()))).toString() : "";
						}

						System.out.println((new StringBuilder("-------------------xboysongjian-------------------------------")).append(getyear).toString());
						if (contSchema.getState().equals("03") || contSchema.getState().equals("05") || contSchema.getState().equals("06") || contSchema.getState().equals("07"))
						{
							for (int i = 1; i <= polsetinfo.size(); i++)
							{
								LNPPolBean temp = new LNPPolBean();
								LNPPolSchema schema = polsetinfo.get(i);
								temp.setSchema(schema, "");
								lnpList.add(temp);
							}

							sumprem = decimalFormat.format(polsetinfo.get(1).getSumPrem());
						}
						payintv = Integer.valueOf(polsetinfo.get(1).getPayIntv());
						deadgetmode = polsetinfo.get(1).getDeadGetMode();
						annuityfrequency = polsetinfo.get(1).getStandbyFlag3();
						bonusgetmode = bonusInfoSchema.getBonusWay();
						overflowpremium = bonusInfoSchema.getP1();
						overduepremium = bonusInfoSchema.getP2();
					}
					if (polsetinfo.get(1).getKindCode().equals("02"))
					{
						System.out.println("VUL险时进入--------------");
						poltype = "02";
						vulriskcode = polsetinfo.get(1).getRiskCode();
						if (editFlag)
							vulrateflag = false;
						else
							vulrateflag = true;
						List vulbean = getInvestList(vulriskcode, contNo);
						if (vulbean == null)
						{
							System.out.println("当前投资信息表中无数据，调用findAccountCode方法查询riskcode数据");
							findAccountCode();
						} else
						{
							System.out.println("当前投资信息表中有数�?----------");
							vulinvestmentList = vulbean;
							vulsize = vulinvestmentList.size();
						}
						if (polsetinfo.get(1).getPrem() < 0.0D)
							vulprem = null;
						else
							vulprem = decimalFormat.format(polsetinfo.get(1).getPrem());
						if (investSchema.getMonthPlusPrem() < 0.0D)
							vulmonthplus = null;
						else
							vulmonthplus = decimalFormat.format(investSchema.getMonthPlusPrem());
						vulyear = investSchema.getTermInvestment();
						vulinvestment = investSchema.getHesInvestment();
						payintv = Integer.valueOf(5);
						bonusgetmode = "";
						overflowpremium = "02";
						overduepremium = "03";
						annuityfrequency = "";
						deadgetmode = "-1";
					}
					if (polsetinfo.get(1).getKindCode().equals("03"))
					{
						System.out.println("组合险时进入---------------");
						poltype = "03";
						for (int i = 0; i < polsetinfo.size(); i++)
							if (!polsetinfo.get(i + 1).getRiskVersion().equals("") && polsetinfo.get(i + 1).getRiskVersion() != null)
								if ("1".equals(polsetinfo.get(i + 1).getRnewFlag()) && "M".equals(polsetinfo.get(i + 1).getSubFlag()))
								{
									combinationriskcode[i] = polsetinfo.get(i + 1).getRiskVersion();
									if (turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("") && "0".equals(polsetinfo.get(i + 1).getPayLocation()))
										combinationyears[i] = "0";
									else
									if (turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("") || turnNullToString(polsetinfo.get(i + 1).getPayLocation()).equals(""))
									{
										combinationyears[i] = "";
									} else
									{
										if (polsetinfo.get(i + 1).getPremToAmnt().equals("A") && !polsetinfo.get(i + 1).getPayLocation().equals("106"))
											combinationyears[i] = (new StringBuilder("T")).append(polsetinfo.get(i + 1).getPayLocation()).toString();
										if (polsetinfo.get(i + 1).getPremToAmnt().equals("A") && polsetinfo.get(i + 1).getPayLocation().equals("106"))
											combinationyears[i] = "终身";
										if (polsetinfo.get(i + 1).getPremToAmnt().equals("Y"))
											combinationyears[i] = polsetinfo.get(i + 1).getPayLocation();
									}
									if (turnNullToString(polsetinfo.get(i + 1).getAcciYearFlag()).equals("") || turnNullToString(polsetinfo.get(i + 1).getPayMode()).equals(""))
									{
										combinationpayyears[i] = "";
									} else
									{
										if (polsetinfo.get(i + 1).getAcciYearFlag().equals("A"))
											combinationpayyears[i] = (new StringBuilder("T")).append(polsetinfo.get(i + 1).getPayMode()).toString();
										if (polsetinfo.get(i + 1).getAcciYearFlag().equals("Y") && polsetinfo.get(i + 1).getPayMode().equals("1000"))
											combinationpayyears[i] = "0";
										if (polsetinfo.get(i + 1).getAcciYearFlag().equals("Y") && !polsetinfo.get(i + 1).getPayMode().equals("1000"))
											combinationpayyears[i] = polsetinfo.get(i + 1).getPayMode();
									}
									combinationtype[i] = polsetinfo.get(i + 1).getUWCode();
									System.out.println((new StringBuilder("初始化组合险==================保额或�?�保费标志位---------------")).append(combinationtype[i]).toString());
									if (combinationtype[i] == null || "".equals(combinationtype[i]))
									{
										if (polsetinfo.get(i + 1).getRemark() == null || "".equals(polsetinfo.get(i + 1).getRemark()))
											combinationmoney[i] = null;
										else
											combinationmoney[i] = polsetinfo.get(i + 1).getRemark();
									} else
									{
										System.out.println((new StringBuilder("初始化组合险==================保额或�?�保费标志位---------------")).append(combinationtype[i]).toString());
										if (combinationtype[i].equals("01"))
										{
											System.out.println("此时为保额的�?++++++++++");
											combinationmoney[i] = polsetinfo.get(i + 1).getAmnt() >= 0.0D ? decimalFormat.format(polsetinfo.get(i + 1).getAmnt()) : null;
											System.out.println((new StringBuilder("此时保额======")).append(combinationmoney[i]).toString());
										} else
										if (combinationtype[i].equals("02"))
										{
											System.out.println("此时为保费的�?++++++++++");
											combinationmoney[i] = polsetinfo.get(i + 1).getPrem() >= 0.0D ? decimalFormat.format(polsetinfo.get(i + 1).getPrem()) : null;
											System.out.println((new StringBuilder("此时保费======")).append(combinationmoney[i]).toString());
										} else
										{
											System.out.println("取的是现在的money�?--------");
											combinationmoney[i] = null;
										}
										System.out.println((new StringBuilder("初始化组合险==================保额或�?�保�?---------------")).append(combinationmoney[i]).toString());
									}
								} else
								if (i != 1)
								{
									combinationriskcode[i - 1] = polsetinfo.get(i + 1).getRiskCode();
									if (turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("") && "0".equals(polsetinfo.get(i + 1).getPayLocation()))
										combinationyears[i - 1] = "0";
									else
									if (turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("") || turnNullToString(polsetinfo.get(i + 1).getPayLocation()).equals(""))
									{
										combinationyears[i - 1] = "";
									} else
									{
										if (polsetinfo.get(i + 1).getPremToAmnt().equals("A") && !polsetinfo.get(i + 1).getPayLocation().equals("106"))
											combinationyears[i - 1] = (new StringBuilder("T")).append(polsetinfo.get(i + 1).getPayLocation()).toString();
										if (polsetinfo.get(i + 1).getPremToAmnt().equals("A") && polsetinfo.get(i + 1).getPayLocation().equals("106"))
											combinationyears[i - 1] = "终身";
										if (polsetinfo.get(i + 1).getPremToAmnt().equals("Y"))
											combinationyears[i - 1] = polsetinfo.get(i + 1).getPayLocation();
									}
									if (turnNullToString(polsetinfo.get(i + 1).getAcciYearFlag()).equals("") || turnNullToString(polsetinfo.get(i + 1).getPayMode()).equals(""))
									{
										combinationpayyears[i - 1] = "";
									} else
									{
										if (polsetinfo.get(i + 1).getAcciYearFlag().equals("A"))
											combinationpayyears[i - 1] = (new StringBuilder("T")).append(polsetinfo.get(i + 1).getPayMode()).toString();
										if (polsetinfo.get(i + 1).getAcciYearFlag().equals("Y") && polsetinfo.get(i + 1).getPayMode().equals("1000"))
											combinationpayyears[i - 1] = "0";
										if (polsetinfo.get(i + 1).getAcciYearFlag().equals("Y") && !polsetinfo.get(i + 1).getPayMode().equals("1000"))
											combinationpayyears[i - 1] = polsetinfo.get(i + 1).getPayMode();
									}
									combinationtype[i - 1] = polsetinfo.get(i + 1).getUWCode();
									System.out.println((new StringBuilder("初始化组合险附险==================保额或�?�保费标志位---------------")).append(combinationtype[i - 1]).toString());
									if (combinationtype[i - 1] == null || "".equals(combinationtype[i - 1]))
									{
										if (polsetinfo.get(i + 1).getRemark() == null || "".equals(polsetinfo.get(i + 1).getRemark()))
											combinationmoney[i - 1] = null;
									} else
									{
										System.out.println((new StringBuilder("初始化组合险附险==================保额或�?�保费标志位---------------")).append(combinationtype[i - 1]).toString());
										if (combinationtype[i - 1].equals("01"))
										{
											System.out.println("此时为保额的�?++++++++++");
											combinationmoney[i - 1] = polsetinfo.get(i + 1).getAmnt() >= 0.0D ? decimalFormat.format(polsetinfo.get(i + 1).getAmnt()) : null;
											System.out.println((new StringBuilder("此时保额======")).append(combinationmoney[i - 1]).toString());
										} else
										if (combinationtype[i - 1].equals("02"))
										{
											System.out.println("此时为保费的�?++++++++++");
											combinationmoney[i - 1] = polsetinfo.get(i + 1).getPrem() >= 0.0D ? decimalFormat.format(polsetinfo.get(i + 1).getPrem()) : null;
											System.out.println((new StringBuilder("此时保费======")).append(combinationmoney[i - 1]).toString());
										} else
										{
											System.out.println("取的是现在的money�?--------");
											combinationmoney[i - 1] = null;
										}
										System.out.println((new StringBuilder("初始化组合险附险==================保额或�?�保�?---------------")).append(combinationmoney[i - 1]).toString());
									}
								}

						if (contSchema.getState().equals("03") || contSchema.getState().equals("05") || contSchema.getState().equals("06") || contSchema.getState().equals("07"))
						{
							for (int i = 1; i <= polsetinfo.size(); i++)
							{
								LNPPolBean temp = new LNPPolBean();
								LNPPolSchema schema = polsetinfo.get(i);
								temp.setSchema(schema, "Z");
								cbtlnpList.add(temp);
							}

							sumprem = decimalFormat.format(polsetinfo.get(1).getSumPrem());
						}
						payintv = Integer.valueOf(polsetinfo.get(1).getPayIntv());
						bonusgetmode = bonusInfoSchema.getBonusWay();
						overflowpremium = bonusInfoSchema.getP1();
						overduepremium = bonusInfoSchema.getP2();
						annuityfrequency = polsetinfo.get(1).getStandbyFlag3();
						deadgetmode = polsetinfo.get(1).getDeadGetMode();
					} else
					if (polsetinfo.get(1).getKindCode().equals("04"))
					{
						System.out.println("年金转换险时进入---------------");
						poltype = "04";
						session.setAttribute("saleChannel", polsetinfo.get(1).getUWTime());
						for (int i = 1; i <= polsetinfo.size(); i++)
							if ("2".equals(polsetinfo.get(i).getRnewFlag()) && "M".equals(polsetinfo.get(i).getSubFlag()))
							{
								yearmoneychangeriskcode = polsetinfo.get(i).getRiskVersion();
								if (turnNullToString(polsetinfo.get(i).getPremToAmnt()).equals("") && "0".equals(polsetinfo.get(i).getPayLocation()))
									yearmoneychangeyears = "0";
								else
								if (turnNullToString(polsetinfo.get(i).getPremToAmnt()).equals("") || turnNullToString(polsetinfo.get(i).getPayLocation()).equals(""))
									yearmoneychangeyears = "";
								else
								if (polsetinfo.get(i).getPremToAmnt().equals("A") && Integer.parseInt(polsetinfo.get(i).getPayLocation()) != SpecialProductFun.getRiskPro(polsetinfo.get(i).getRiskCode()))
									yearmoneychangeyears = (new StringBuilder("T")).append(polsetinfo.get(i).getPayLocation()).toString();
								else
								if (polsetinfo.get(i).getPremToAmnt().equals("A") && Integer.parseInt(polsetinfo.get(i).getPayLocation()) == SpecialProductFun.getRiskPro(polsetinfo.get(i).getRiskCode()))
									yearmoneychangeyears = "终身";
								else
								if (polsetinfo.get(i).getPremToAmnt().equals("Y"))
									yearmoneychangeyears = (new StringBuilder(String.valueOf(polsetinfo.get(i).getPayLocation()))).toString();
								System.out.println("结束保障�?");
								if (turnNullToString(polsetinfo.get(i).getAcciYearFlag()).equals("") || turnNullToString(polsetinfo.get(i).getPayMode()).equals(""))
									yearmoneychangepayyears = "";
								else
								if (polsetinfo.get(i).getAcciYearFlag().equals("A"))
									yearmoneychangepayyears = (new StringBuilder("T")).append(polsetinfo.get(i).getPayMode()).toString();
								else
								if (polsetinfo.get(i).getAcciYearFlag().equals("Y") && polsetinfo.get(i).getPayMode().equals("1000"))
									yearmoneychangepayyears = "0";
								else
								if (polsetinfo.get(i).getAcciYearFlag().equals("Y") && !polsetinfo.get(i).getPayMode().equals("1000"))
									yearmoneychangepayyears = polsetinfo.get(i).getPayMode();
								System.out.println("结束缴费�?");
								if (polsetinfo.get(i).getRemark() == null || "".equals(polsetinfo.get(i).getRemark()))
									yearmoneychangemoney = null;
								else
									yearmoneychangemoney = polsetinfo.get(i).getRemark();
								if ("M".equals(polsetinfo.get(i).getSubFlag()))
									yearmoneychangegetyear = polsetinfo.get(i).getGetYear() >= 0 ? (new StringBuilder(String.valueOf(polsetinfo.get(i).getGetYear()))).toString() : "";
								salechannel = polsetinfo.get(i).getUWTime();
							}

						if (contSchema.getState().equals("03") || contSchema.getState().equals("05") || contSchema.getState().equals("06") || contSchema.getState().equals("07"))
						{
							for (int i = 1; i <= polsetinfo.size(); i++)
							{
								LNPPolBean temp = new LNPPolBean();
								LNPPolSchema schema = polsetinfo.get(i);
								temp.setSchema(schema, "N");
								ymclnpList.add(temp);
							}

							sumprem = decimalFormat.format(polsetinfo.get(1).getSumPrem());
						}
						payintv = Integer.valueOf(polsetinfo.get(1).getPayIntv());
						bonusgetmode = bonusInfoSchema.getBonusWay();
						overflowpremium = bonusInfoSchema.getP1();
						overduepremium = bonusInfoSchema.getP2();
						annuityfrequency = polsetinfo.get(1).getStandbyFlag3();
						deadgetmode = polsetinfo.get(1).getDeadGetMode();
					}
					infoSource = "modify";
				} else
				{
					infoSource = "add";
				}
				System.out.println((new StringBuilder("当前是否可编辑的状�??======")).append(editFlag).toString());
				session.setAttribute("RelFlag", Boolean.valueOf(editFlag));
				System.out.println("-------------------start init union others policy ------------------------------");
				relationDeal = new BankRelationContNo();
				relationDeal.initData();
			} else
			{
				infoSource = "undo";
				editFlag = false;
				buildError("全局投保书信息缺�?!");
			}
		}
		catch (RuntimeException e)
		{
			turnCurrPolicyLockFlag(null, contNo, "unlock");
			e.printStackTrace();
			message = "投保事项初始化错误！";
			operateResult = false;
		}
	}

	public void getRiskType()
	{
		System.out.println((new StringBuilder("当前risktype的�??=====")).append(poltype).toString());
		poltype = radiotype;
	}

	private boolean getInfoFromSession(HttpSession session)
	{
		boolean flag = false;
		try
		{
			if (session == null)
				session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			tempGI = (IGlobalInput)session.getAttribute("NPGI");
			if ((String)session.getAttribute("ContNo") != null && !((String)session.getAttribute("ContNo")).equals(""))
			{
				contNo = (String)session.getAttribute("ContNo");
				waitPolicyCommited(session, contNo);
				turnCurrPolicyLockFlag(session, contNo, "lock");
				flag = true;
			}
		}
		catch (Exception e)
		{
			turnCurrPolicyLockFlag(session, contNo, "unlock");
			flag = false;
		}
		return flag;
	}

	public void deldata()
	{
		message = new String();
		System.out.println("清除列表信息");
		type = new String[30];
		lnpList.clear();
		cbtlnpList.clear();
		vulinvestmentList.clear();
		vulsize = vulinvestmentList.size();
		System.out.println("转换险种，进行数据删除操�?--------------");
		contSchema = getMyLNPContByContNo(contNo);
		LNPPolSet polsetbase = getPolByContNo(contNo);
		investSchema = getInvestmentSchemaByContNo(contNo);
		bonusInfoSchema = getBonusSchemaByContNo(contNo);
		LNPInvestmentAccountInfoSet accountSet = getAccountSetByContNo(contNo);
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		contSchema.setInputOperator(tempGI.Operator);
		contSchema.setModifyDate(date);
		contSchema.setModifyTime(time);
		BankOperateDeal stateOperate = new BankOperateDeal();
		List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
		if (polsetbase.size() > 0 && !polsetbase.get(1).getKindCode().equals(poltype))
			if (stateList.size() > 0)
			{
				System.out.println((new StringBuilder("当前险种类型�?")).append(poltype).append("库中类型:").append(polsetbase.get(1).getKindCode()).toString());
				System.out.println("------------------------------------------------因为险种切换,将回滚保单状态�??02待审核状�?---------");
				contSchema.setState((String)stateList.get(0));
				contSchema.setEditstate((String)stateList.get(1));
			} else
			if ("01".equals(contSchema.getState()))
			{
				String editState = stateOperate.updateEditStateUNDone(contSchema.getEditstate(), 2);
				contSchema.setEditstate(editState);
				System.out.println((new StringBuilder("cureditsate:")).append(editState).append("<------------------------------------------------因为险种切换,state=01 时，editsate=11xxxxxx 时转换险种时�?要editstate=10xxxxxx---------").toString());
			}
		System.out.println((new StringBuilder("单状态state :")).append(contSchema.getState()).append("|代理人权限类型editstate:").append(contSchema.getEditstate()).toString());
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		map.put(contSchema, "UPDATE");
		map.put(polsetbase, "DELETE");
		map.put(bonusInfoSchema, "DELETE");
		map.put(investSchema, "DELETE");
		map.put(accountSet, "DELETE");
		VData vd = new VData();
		vd.add(map);
		if (!ps.submitData(vd, ""))
		{
			message = "转换投保事项险种类型时删除原数据库中的险种信息失败！";
			operateResult = false;
			System.out.println("转换投保事项险种类型时删除原数据库中的险种信息失败！");
		} else
		{
			sumprem = "";
			message = "转换投保事项险种类型时删除原数据库中的险种信息成功！";
			operateResult = true;
			System.out.println("转换投保事项险种类型时删除原数据库中的险种信息成功！");
		}
	}

	public void findAccountCode()
	{
		System.out.println("�?始查找基金信�?");
		String sql = (new StringBuilder("select FundAccountCode,FundAccountName from MRiskFundAccount where RiskCode='")).append(vulriskcode).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.MaxRow > 0)
		{
			vulinvestmentList = new ArrayList();
			for (int i = 1; i <= tSRS.MaxRow; i++)
			{
				LNPVulBean vulBean = new LNPVulBean();
				vulBean.setAccountCode(tSRS.GetText(i, 1));
				vulBean.setAccountName(tSRS.GetText(i, 2));
				vulBean.setAccountRate("0");
				vulinvestmentList.add(vulBean);
			}

		} else
		{
			System.out.println("当前险种无基金数�?");
			vulinvestmentList.clear();
		}
		vulsize = vulinvestmentList.size();
	}

	public List getInvestList(String code, String conNumber)
	{
		String sql = (new StringBuilder("select InvestAccountCode,Varc1,InvestAccountRate*100 from LNPInvestmentAccountInfo where contno='")).append(conNumber).append("' and riskcode='").append(code).append("'").toString();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSRS = tExeSQL.execSQL(sql);
		if (tSRS.MaxRow > 0)
		{
			List vulBeanList = new ArrayList();
			for (int i = 1; i <= tSRS.MaxRow; i++)
			{
				LNPVulBean vulBean = new LNPVulBean();
				vulBean.setAccountCode(tSRS.GetText(i, 1));
				vulBean.setAccountName(tSRS.GetText(i, 2));
				vulBean.setAccountRate(tSRS.GetText(i, 3));
				vulBeanList.add(vulBean);
			}

			return vulBeanList;
		} else
		{
			System.out.println("投资表中无信息返回null");
			return null;
		}
	}

	public void checkrate()
	{
		System.out.println("�?始校验投资百分比");
		System.out.println((new StringBuilder("vulinvestmentList的size()==========")).append(vulinvestmentList.size()).toString());
		double value = 0.0D;
		for (int i = 0; i < vulinvestmentList.size(); i++)
			value += Double.valueOf(((LNPVulBean)vulinvestmentList.get(i)).getAccountRate()).doubleValue();

		System.out.println((new StringBuilder("value========================")).append(value).toString());
		if (value > 100D)
			vullistflag = false;
		else
			vullistflag = true;
	}

	public void savePol()
	{
		System.out.println("调用 savePol()方法-------");
		System.out.println((new StringBuilder("险种类型  1-传统险，2-VUL�?3-组合险，4-年险===")).append(poltype).toString());
		System.out.println((new StringBuilder("本次投保事项操作动作infoSource====")).append(infoSource).toString());
		operateResult = true;
		contSchema = getMyLNPContByContNo(contNo);
		System.out.println("�?始清除关联组----------");
		if (contSchema != null && contSchema.getAgentCode1() != null && !contSchema.getAgentCode1().equals(""))
		{
			String sql = (new StringBuilder("select count(*) from lnpcont where agentcode1='")).append(contSchema.getAgentCode1()).append("'").toString();
			ExeSQL tExeSQL = new ExeSQL();
			SSRS tSRS = tExeSQL.execSQL(sql);
			String number = tSRS.GetText(1, 1);
			if (number.equals("1"))
			{
				contSchema.setAgentCode1("");
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "清除关联组失败！";
					operateResult = false;
					System.out.println("清除关联组失败！");
				} else
				{
					message = "清除关联组成功！";
					operateResult = true;
					System.out.println("清除关联组成功！");
				}
			}
		} else
		{
			System.out.println("此时不需要清除关联组");
		}
		System.out.println("�?始保存险种信�?");
		if (!editFlag)
			break MISSING_BLOCK_LABEL_451;
		if (!"undo".equals(infoSource) && contSchema != null && infoSource != null && !"".equals(infoSource))
			break MISSING_BLOCK_LABEL_380;
		operateResult = true;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		return;
		if ("add".equals(infoSource))
		{
			System.out.println("进入新增信息接口------------------");
			if (addInsuredItem())
				operateResult = true;
		}
		if ("modify".equals(infoSource))
		{
			System.out.println("进入修改信息接口------------------");
			if (modifyInsuredItem())
				operateResult = true;
		}
		break MISSING_BLOCK_LABEL_512;
		System.out.println("此时保单不可编辑，不对数据库进行操作");
		break MISSING_BLOCK_LABEL_512;
		RuntimeException e;
		e;
		e.printStackTrace();
		message = "投保事项信息保存失败�?";
		operateResult = false;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		break MISSING_BLOCK_LABEL_524;
		Exception exception;
		exception;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
		throw exception;
		turnCurrPolicyLockFlag(null, contNo, "unlock");
	}

	private boolean modifyInsuredItem()
	{
		boolean flag = false;
		if (poltype.equals("01"))
			flag = saveType0ne();
		if (poltype.equals("02"))
			flag = saveTypeTwo();
		if (poltype.equals("03"))
			flag = saveTypeThree();
		if (poltype.equals("04"))
			flag = saveTypeFour();
		return flag;
	}

	private boolean addInsuredItem()
	{
		boolean flag = false;
		if (poltype.equals("01"))
			flag = saveType0ne();
		if (poltype.equals("02"))
			flag = saveTypeTwo();
		if (poltype.equals("03"))
			flag = saveTypeThree();
		if (poltype.equals("04"))
			flag = saveTypeFour();
		if (poltype.equals(""))
		{
			message = "请�?�择险种�?";
			flag = false;
		}
		return flag;
	}

	private LNPContSchema getMyLNPContByContNo(String contNo2)
	{
		System.out.println("�?始初始化lnpcont信息");
		PolicyMainInfo mainInfo = new PolicyMainInfo();
		LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
		return aLNPContSchema;
	}

	public LNPPolSet getPolByContNo(String contNo)
	{
		LNPPolDB db = new LNPPolDB();
		db.setContNo(contNo);
		LNPPolSet polset1 = db.query();
		return polset1;
	}

	private LNPPolSchema getPolSchemaByContNo(String contNo)
	{
		LNPPolDB db = new LNPPolDB();
		db.setContNo(contNo);
		if (db.getInfo())
			return db.getSchema();
		else
			return null;
	}

	private LNPBonusInfoSchema getBonusSchemaByContNo(String contNo)
	{
		System.out.println("�?始获取红利信�?");
		LNPBonusInfoDB db = new LNPBonusInfoDB();
		db.setContNo(contNo);
		LNPBonusInfoSet infoset = db.query();
		System.out.println((new StringBuilder("红利信息的size()===")).append(infoset.size()).toString());
		if (infoset.size() > 0)
		{
			infoset.get(1);
			return infoset.get(1);
		} else
		{
			return null;
		}
	}

	private LNPInvestmentInfoSchema getInvestmentSchemaByContNo(String contNo)
	{
		System.out.println("�?始获取月月加信息");
		LNPInvestmentInfoDB db = new LNPInvestmentInfoDB();
		db.setContNo(contNo);
		LNPInvestmentInfoSet infoset = db.query();
		if (infoset.size() > 0)
		{
			infoset.get(1);
			return infoset.get(1);
		} else
		{
			return null;
		}
	}

	private LNPInvestmentAccountInfoSet getAccountSetByContNo(String contNumber)
	{
		System.out.println("�?始获取投资信�?");
		LNPInvestmentAccountInfoDB db = new LNPInvestmentAccountInfoDB();
		db.setContNo(contNo);
		LNPInvestmentAccountInfoSet accountSet = db.query();
		return accountSet;
	}

	private boolean saveType0ne()
	{
		boolean flagone = false;
		contSchema = getMyLNPContByContNo(contNo);
		bonusInfoSchema = getBonusSchemaByContNo(contNo);
		this.investSchema = getInvestmentSchemaByContNo(contNo);
		LNPPolSet polsetbase = getPolByContNo(contNo);
		LNPPolSet polsetpage = new LNPPolSet();
		LNPBonusInfoSchema infoschema = new LNPBonusInfoSchema();
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		boolean hasMRiskFlag = false;
		String mRiskCode = "";
		for (int i = 0; i < 30; i++)
			if (riskcode[i] != null && !riskcode[i].equals(""))
			{
				polSchema = new LNPPolSchema();
				polSchema.setKindCode(poltype);
				polSchema.setRiskCode(riskcode[i]);
				if (years[i].startsWith("终身"))
				{
					polSchema.setInsuYear(SpecialProductFun.getRiskPro(polSchema.getRiskCode()));
					polSchema.setInsuYearFlag("A");
				}
				if (years[i].startsWith("T") || years[i].startsWith("t"))
				{
					polSchema.setInsuYear(years[i].replaceAll("^[Tt](\\d+)$", "$1"));
					polSchema.setInsuYearFlag("A");
				}
				if (years[i].matches("^[1-9][0-9]*$"))
				{
					polSchema.setInsuYear(years[i].replace("", ""));
					polSchema.setInsuYearFlag("Y");
				}
				if (years[i].equals("") || years[i] == null)
				{
					polSchema.setInsuYear(-1);
					polSchema.setInsuYearFlag("");
				}
				if (years[i].equals("0"))
				{
					polSchema.setInsuYear("0");
					polSchema.setInsuYearFlag("");
				}
				if (payyears[i].equals("0"))
				{
					polSchema.setPayEndYear("1000");
					polSchema.setPayEndYearFlag("Y");
				}
				if (payyears[i].startsWith("T") || payyears[i].startsWith("t"))
				{
					polSchema.setPayEndYear(payyears[i].replaceAll("^[Tt](\\d+)$", "$1"));
					polSchema.setPayEndYearFlag("A");
				}
				if (payyears[i].matches("^[1-9][0-9]*$"))
				{
					polSchema.setPayEndYear(payyears[i].replace("", ""));
					polSchema.setPayEndYearFlag("Y");
				}
				if (payyears[i].equals("") || payyears[i] == null)
				{
					polSchema.setPayEndYear(-1);
					polSchema.setPayEndYearFlag("");
				}
				polSchema.setUWCode(type[i]);
				System.out.println((new StringBuilder("当前的type[i]�?======")).append(type[i]).toString());
				if (type[i].equals("01"))
				{
					if (money[i] == null || money[i].equals(""))
					{
						polSchema.setAmnt(-1D);
						polSchema.setPrem(-1D);
					} else
					{
						polSchema.setAmnt(money[i]);
						polSchema.setPrem(0.0D);
					}
				} else
				if (type[i].equals("02"))
				{
					if (money[i] == null || money[i].equals(""))
					{
						polSchema.setAmnt(-1D);
						polSchema.setPrem(-1D);
					} else
					{
						polSchema.setPrem(money[i]);
						polSchema.setAmnt(0.0D);
					}
				} else
				{
					polSchema.setAmnt(-1D);
					polSchema.setPrem(-1D);
				}
				if (i == 0)
				{
					if (getyear == null || getyear.equals(""))
					{
						polSchema.setGetYear("-1");
					} else
					{
						polSchema.setGetYear(getyear);
						polSchema.setGetYearFlag("A");
					}
					polSchema.setSubFlag("M");
					hasMRiskFlag = true;
					mRiskCode = polSchema.getRiskCode();
				} else
				{
					polSchema.setGetYear("");
					polSchema.setSubFlag("S");
				}
				polSchema.setPayIntv(payintv.intValue());
				contSchema.setPayIntv(polSchema.getPayIntv());
				polSchema.setDeadGetMode(deadgetmode);
				polSchema.setStandbyFlag3(annuityfrequency);
				polSchema.setGrpContNo("00000000000000000000");
				polSchema.setGrpPolNo("00000000000000000000");
				polSchema.setContNo(contNo);
				polSchema.setProposalContNo(contNo);
				String tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
				polSchema.setPolNo(tIndex);
				polSchema.setProposalNo(tIndex);
				polSchema.setPrtNo("00000000000000000000");
				polSchema.setContType("1");
				polSchema.setManageCom(contSchema.getSignCom());
				polSchema.setMakeDate(date);
				polSchema.setMakeTime(time);
				polSchema.setModifyDate(date);
				polSchema.setModifyTime(time);
				polSchema.setOperator(tempGI.Operator);
				polsetpage.add(polSchema);
			} else
			{
				System.out.println((new StringBuilder("riskcode[")).append(i).append("]没有数据").toString());
			}

		LNPInvestmentAccountInfoSet delInvestSet = (new LNPInvestmentAccountInfoDB()).executeQuery((new StringBuilder("select * from LNPInvestmentAccountInfo where ContNo='")).append(contNo).append("'").toString());
		LNPInvestmentAccountInfoSet investSet = new LNPInvestmentAccountInfoSet();
		if (hasMRiskFlag)
		{
			ExeSQL exeSQL = new ExeSQL();
			SSRS ssrs = exeSQL.execSQL((new StringBuilder("select FundAccountCode,FundAccountName,p1 from MRiskFundAccount where RiskCode=ltrim(rtrim('")).append(mRiskCode).append("'))").toString());
			if (ssrs.MaxRow > 0)
			{
				System.out.println("-------------------->当前传统险主险存在对应基金账户信�?<-------------------");
				for (int i = 1; i <= ssrs.MaxRow; i++)
				{
					LNPInvestmentAccountInfoSchema investSchema = new LNPInvestmentAccountInfoSchema();
					investSchema.setRiskCode(mRiskCode);
					investSchema.setInvestAccountCode(ssrs.GetText(i, 1));
					investSchema.setVarc1(ssrs.GetText(i, 2));
					investSchema.setInvestAccountRate(ssrs.GetText(i, 3));
					investSchema.setContNo(contNo);
					investSchema.setOperator(tempGI.Operator);
					investSchema.setMakeDate(date);
					investSchema.setMakeTime(time);
					investSchema.setModifyDate(date);
					investSchema.setModifyTime(time);
					investSet.add(investSchema);
				}

			}
		}
		infoschema.setGrpContNo("00000000000000000000");
		infoschema.setContNo(contNo);
		infoschema.setProposalContNo(contNo);
		infoschema.setPrtNo("00000000000000000000");
		infoschema.setBonusWay(bonusgetmode);
		infoschema.setP1(overflowpremium);
		infoschema.setP2(overduepremium);
		infoschema.setOperator(tempGI.Operator);
		infoschema.setMakeDate(date);
		infoschema.setMakeTime(time);
		infoschema.setModifyDate(date);
		infoschema.setModifyTime(time);
		allCompelte = checkAllCompelte(polsetpage, infoschema, null);
		boolean changeStateflag = false;
		BankOperateDeal stateOperate = new BankOperateDeal();
		if (allCompelte)
		{
			List stateList = stateOperate.infoOprate(contSchema.getState(), contSchema.getEditstate(), "modify", "02");
			contSchema.setState((String)stateList.get(0));
			contSchema.setEditstate((String)stateList.get(1));
		} else
		if ("01".equals(contSchema.getState()))
		{
			String editState = stateOperate.updateEditStateUNDone(contSchema.getEditstate(), 2);
			contSchema.setEditstate(editState);
		}
		System.out.println((new StringBuilder("xboy---------------------------------------------传统险，当前state|editstate�?")).append(contSchema.getState()).append("| ").append(contSchema.getEditstate()).toString());
		if (polsetpage.size() != 0 && !polsetpage.get(1).getRiskCode().equals("") && polsetpage.size() != polsetbase.size())
		{
			List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
			if (stateList.size() > 0)
			{
				System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
				changeStateflag = true;
				contSchema.setState((String)stateList.get(0));
				contSchema.setEditstate((String)stateList.get(1));
			} else
			{
				System.out.println("当前操作不需要进行状态回�?");
			}
			contSchema.setInputOperator(tempGI.Operator);
			contSchema.setModifyDate(date);
			contSchema.setModifyTime(time);
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(delInvestSet, "DELETE");
			map.put(investSet, "DELETE&INSERT");
			map.put(polsetbase, "DELETE");
			map.put(bonusInfoSchema, "DELETE");
			map.put(this.investSchema, "DELETE");
			map.put(polsetpage, "INSERT");
			map.put(infoschema, "INSERT");
			map.put(contSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "投保事项信息保存错误�?";
				System.out.println("投保事项保存失败");
				flagone = false;
			} else
			{
				try
				{
					flagone = true;
					infoSource = "modify";
					policyState = new BankPolicyState();
					if (changeStateflag)
						policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
					message = "投保事项信息保存成功�?";
					System.out.println("保存成功");
				}
				catch (Exception e)
				{
					message = "操作记录接口出问题了";
					System.out.println("操作记录接口出问题了");
					e.printStackTrace();
				}
			}
		}
		if (polsetpage.size() != 0 && polsetbase.size() != 0 && polsetpage.size() == polsetbase.size())
		{
			boolean flags = false;
			for (int i = 1; i <= polsetbase.size(); i++)
			{
				if (turnNullToString(polsetpage.get(i).getRiskCode()).equals(turnNullToString(polsetbase.get(i).getRiskCode())) && turnNullToString(Integer.valueOf(polsetpage.get(i).getInsuYear())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getInsuYear()))) && turnNullToString(polsetpage.get(i).getInsuYearFlag()).equals(turnNullToString(polsetbase.get(i).getInsuYearFlag())) && turnNullToString(Integer.valueOf(polsetpage.get(i).getPayEndYear())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayEndYear()))) && turnNullToString(polsetpage.get(i).getPayEndYearFlag()).equals(turnNullToString(polsetbase.get(i).getPayEndYearFlag())) && turnNullToString(polsetpage.get(i).getUWCode()).equals(turnNullToString(polsetbase.get(i).getUWCode())) && ("01".equals(polsetpage.get(i).getUWCode()) ? turnNullToString(Double.valueOf(polsetpage.get(i).getAmnt())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getAmnt()))) : turnNullToString(Double.valueOf(polsetpage.get(i).getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem())))) && (turnNullToString(Integer.valueOf(polsetpage.get(1).getGetYear())).equals(turnNullToString(Integer.valueOf(polsetbase.get(1).getGetYear()))) && turnNullToString(Integer.valueOf(polsetpage.get(i).getPayIntv())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayIntv()))) && turnNullToString(polsetpage.get(i).getDeadGetMode()).equals(turnNullToString(polsetbase.get(i).getDeadGetMode())) && turnNullToString(polsetpage.get(i).getStandbyFlag3()).equals(turnNullToString(polsetbase.get(i).getStandbyFlag3())) && turnNullToString(infoschema.getBonusWay()).equals(turnNullToString(bonusInfoSchema.getBonusWay())) && turnNullToString(infoschema.getP1()).equals(turnNullToString(bonusInfoSchema.getP1())) && turnNullToString(infoschema.getP2()).equals(turnNullToString(bonusInfoSchema.getP2()))))
				{
					flags = true;
					continue;
				}
				flags = false;
				break;
			}

			System.out.println((new StringBuilder("当前flags的�?�为===")).append(flags).toString());
			if (!flags)
			{
				List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
				if (stateList.size() > 0)
				{
					System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
					changeStateflag = true;
					contSchema.setState((String)stateList.get(0));
					contSchema.setEditstate((String)stateList.get(1));
				} else
				{
					System.out.println("当前操作不需要进行状态回�?");
				}
				contSchema.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(delInvestSet, "DELETE");
				map.put(investSet, "DELETE&INSERT");
				map.put(polsetbase, "DELETE");
				map.put(bonusInfoSchema, "DELETE");
				map.put(this.investSchema, "DELETE");
				map.put(polsetpage, "INSERT");
				map.put(infoschema, "INSERT");
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "投保事项信息保存错误�?";
					System.out.println("投保事项保存失败");
					flagone = false;
				} else
				{
					try
					{
						flagone = true;
						infoSource = "modify";
						policyState = new BankPolicyState();
						if (changeStateflag)
							policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
						message = "投保事项信息保存成功�?";
						System.out.println("保存成功");
					}
					catch (Exception e)
					{
						message = "操作记录接口出问题了";
						System.out.println("操作记录接口出问题了");
						e.printStackTrace();
					}
				}
			} else
			{
				System.out.println("本次操作没有修改数据");
				message = "本次操作没有修改数据，不会进行数据库操作";
				flagone = false;
			}
		}
		if (polsetpage.size() == 0 && polsetbase.size() == 0)
			flagone = true;
		if (polsetpage.size() == 0 && polsetbase.size() != 0)
		{
			List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
			if (stateList.size() > 0)
			{
				System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
				changeStateflag = true;
				contSchema.setState((String)stateList.get(0));
				contSchema.setEditstate((String)stateList.get(1));
			} else
			{
				System.out.println("当前操作不需要进行状态回�?");
			}
			contSchema.setInputOperator(tempGI.Operator);
			contSchema.setModifyDate(date);
			contSchema.setModifyTime(time);
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(delInvestSet, "DELETE");
			map.put(polsetbase, "DELETE");
			map.put(bonusInfoSchema, "DELETE");
			map.put(this.investSchema, "DELETE");
			map.put(contSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "投保事项信息保存错误�?";
				System.out.println("投保事项保存失败");
				flagone = false;
			} else
			{
				try
				{
					flagone = true;
					infoSource = "modify";
					policyState = new BankPolicyState();
					if (changeStateflag)
						policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
					message = "投保事项信息保存成功�?";
					System.out.println("保存成功");
				}
				catch (Exception e)
				{
					message = "操作记录接口出问题了";
					System.out.println("操作记录接口出问题了");
					e.printStackTrace();
				}
			}
		}
		return flagone;
	}

	private boolean saveTypeTwo()
	{
		System.out.println("�?始保存VUL险种------------------");
		boolean flagtwo = false;
		contSchema = getMyLNPContByContNo(contNo);
		bonusInfoSchema = getBonusSchemaByContNo(contNo);
		LNPPolSet polsetbase = getPolByContNo(contNo);
		investSchema = getInvestmentSchemaByContNo(contNo);
		LNPInvestmentAccountInfoSet accountSet = getAccountSetByContNo(contNo);
		LNPPolSet polsetpage = new LNPPolSet();
		LNPBonusInfoSchema bonusSchema = new LNPBonusInfoSchema();
		LNPInvestmentInfoSchema newinvestSchema = new LNPInvestmentInfoSchema();
		polSchema = new LNPPolSchema();
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String tIndex = "";
		if (vulriskcode != null && !vulriskcode.equals(""))
		{
			polSchema.setKindCode("02");
			polSchema.setRiskCode(vulriskcode);
			polSchema.setPrem("".equals(turnNullToString(vulprem).trim()) ? "-1" : vulprem);
			polSchema.setSubFlag("M");
			if (vulriskcode.equals("UL15BA"))
			{
				polSchema.setInsuYear("5");
				polSchema.setInsuYearFlag("Y");
			} else
			{
				polSchema.setInsuYear("106");
				polSchema.setInsuYearFlag("A");
			}
			polSchema.setPayEndYear("1");
			polSchema.setPayEndYearFlag("Y");
			polSchema.setStandbyFlag3("");
			polSchema.setDeadGetMode("");
			polSchema.setPayIntv(payintv.intValue());
			contSchema.setPayIntv(polSchema.getPayIntv());
			polSchema.setGrpContNo("00000000000000000000");
			polSchema.setGrpPolNo("00000000000000000000");
			polSchema.setContNo(contNo);
			polSchema.setProposalContNo(contNo);
			tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
			polSchema.setPolNo(tIndex);
			polSchema.setProposalNo(tIndex);
			polSchema.setPrtNo("00000000000000000000");
			polSchema.setContType("1");
			polSchema.setManageCom(contSchema.getSignCom());
			polSchema.setMakeDate(date);
			polSchema.setMakeTime(time);
			polSchema.setModifyDate(date);
			polSchema.setModifyTime(time);
			polSchema.setOperator(tempGI.Operator);
			polsetpage.add(polSchema);
		} else
		{
			System.out.println("---险种代码未录入，数据不会保存到数据库�?---");
		}
		System.out.println((new StringBuilder("polsetpage.size==================")).append(polsetpage.size()).toString());
		newinvestSchema.setID(tIndex);
		newinvestSchema.setContNo(contNo);
		if ("".equals(turnNullToString(vulmonthplus).trim()))
			newinvestSchema.setMonthPlusPrem(-1D);
		else
			newinvestSchema.setMonthPlusPrem(vulmonthplus);
		newinvestSchema.setTermInvestment(vulyear);
		newinvestSchema.setHesInvestment(vulinvestment);
		newinvestSchema.setOperator(tempGI.Operator);
		newinvestSchema.setMakeDate(date);
		newinvestSchema.setMakeTime(time);
		newinvestSchema.setModifyDate(date);
		newinvestSchema.setModifyTime(time);
		LNPInvestmentAccountInfoSet infoSet = new LNPInvestmentAccountInfoSet();
		for (int i = 0; i < vulinvestmentList.size(); i++)
		{
			LNPInvestmentAccountInfoSchema accountSchema = new LNPInvestmentAccountInfoSchema();
			accountSchema.setContNo(contNo);
			accountSchema.setRiskCode(vulriskcode);
			accountSchema.setInvestAccountCode(((LNPVulBean)vulinvestmentList.get(i)).getAccountCode());
			accountSchema.setInvestAccountRate(Double.valueOf(((LNPVulBean)vulinvestmentList.get(i)).getAccountRate()).doubleValue() / 100D);
			accountSchema.setVarc1(((LNPVulBean)vulinvestmentList.get(i)).getAccountName());
			accountSchema.setOperator(tempGI.Operator);
			accountSchema.setMakeDate(date);
			accountSchema.setMakeTime(time);
			accountSchema.setModifyDate(date);
			accountSchema.setModifyTime(time);
			infoSet.add(accountSchema);
		}

		bonusSchema.setGrpContNo("00000000000000000000");
		bonusSchema.setContNo(contNo);
		bonusSchema.setProposalContNo(contNo);
		bonusSchema.setPrtNo("00000000000000000000");
		bonusSchema.setBonusWay("00");
		bonusSchema.setP1("02");
		bonusSchema.setP2("03");
		bonusSchema.setOperator(tempGI.Operator);
		bonusSchema.setMakeDate(date);
		bonusSchema.setMakeTime(time);
		bonusSchema.setModifyDate(date);
		bonusSchema.setModifyTime(time);
		allCompelte = false;
		allCompelte = checkAllCompelte(polsetpage, null, newinvestSchema);
		boolean changeStateflag = false;
		BankOperateDeal stateOperate = new BankOperateDeal();
		if (allCompelte)
		{
			List stateList = stateOperate.infoOprate(contSchema.getState(), contSchema.getEditstate(), "modify", "02");
			contSchema.setState((String)stateList.get(0));
			contSchema.setEditstate((String)stateList.get(1));
		} else
		if ("01".equals(contSchema.getState()))
		{
			String editState = stateOperate.updateEditStateUNDone(contSchema.getEditstate(), 2);
			contSchema.setEditstate(editState);
		}
		System.out.println("---------------------------------------------");
		if (polsetpage.size() != 0 && polsetpage.size() != polsetbase.size())
		{
			List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
			if (stateList.size() > 0)
			{
				System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
				changeStateflag = true;
				contSchema.setState((String)stateList.get(0));
				contSchema.setEditstate((String)stateList.get(1));
			} else
			{
				System.out.println("当前操作不需要进行状态回�?");
			}
			System.out.println("�?始保存VUL险种数据11111---------------");
			contSchema.setInputOperator(tempGI.Operator);
			contSchema.setModifyDate(date);
			contSchema.setModifyTime(time);
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(polsetbase, "DELETE");
			map.put(bonusInfoSchema, "DELETE");
			map.put(accountSet, "DELETE");
			map.put(investSchema, "DELETE");
			map.put(polSchema, "INSERT");
			map.put(bonusSchema, "INSERT");
			map.put(newinvestSchema, "INSERT");
			map.put(infoSet, "INSERT");
			map.put(contSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "投保事项信息保存错误�?";
				System.out.println("投保事项保存失败");
				flagtwo = false;
			} else
			{
				try
				{
					flagtwo = true;
					infoSource = "modify";
					policyState = new BankPolicyState();
					if (changeStateflag)
						policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
					message = "投保事项信息保存成功�?";
					System.out.println("保存成功");
				}
				catch (Exception e)
				{
					message = "操作记录接口出问题了";
					System.out.println("操作记录接口出问题了");
					e.printStackTrace();
				}
			}
		} else
		if (polsetpage.size() != 0 && polsetpage.size() == polsetbase.size())
		{
			System.out.println("�?始保存VUL险种数据2222222222---------------");
			for (int i = 1; i <= polsetbase.size(); i++)
				if (turnNullToString(polSchema.getRiskCode()).equals(turnNullToString(polsetbase.get(i).getRiskCode())) && turnNullToString(Double.valueOf(polSchema.getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem()))) && turnNullToString(Double.valueOf(newinvestSchema.getMonthPlusPrem())).equals(turnNullToString(Double.valueOf(investSchema.getMonthPlusPrem()))) && turnNullToString(newinvestSchema.getTermInvestment()).equals(turnNullToString(investSchema.getTermInvestment())) && turnNullToString(newinvestSchema.getHesInvestment()).equals(turnNullToString(investSchema.getHesInvestment())) && checkaccount(infoSet, accountSet) && !turnNullToString(polSchema.getRiskCode()).equals(""))
				{
					message = "此时界面险种信息与数据库中信息一致无修改";
					System.out.println("此时界面险种信息与数据库中信息一致无修改");
					flagtwo = false;
				} else
				{
					List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
					if (stateList.size() > 0)
					{
						System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
						changeStateflag = true;
						contSchema.setState((String)stateList.get(0));
						contSchema.setEditstate((String)stateList.get(1));
					} else
					{
						System.out.println("当前操作不需要进行状态回�?");
					}
					contSchema.setInputOperator(tempGI.Operator);
					contSchema.setModifyDate(date);
					contSchema.setModifyTime(time);
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					map.put(polsetbase, "DELETE");
					map.put(bonusInfoSchema, "DELETE");
					map.put(accountSet, "DELETE");
					map.put(investSchema, "DELETE");
					map.put(polSchema, "INSERT");
					map.put(bonusSchema, "INSERT");
					map.put(newinvestSchema, "INSERT");
					map.put(infoSet, "INSERT");
					map.put(contSchema, "UPDATE");
					VData vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
					{
						message = "投保事项信息保存错误�?";
						System.out.println("投保事项保存失败");
						flagtwo = false;
					} else
					{
						try
						{
							flagtwo = true;
							infoSource = "modify";
							policyState = new BankPolicyState();
							if (changeStateflag)
								policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
							message = "投保事项信息保存成功�?";
							System.out.println("保存成功");
						}
						catch (Exception e)
						{
							message = "操作记录接口出问题了";
							System.out.println("操作记录接口出问题了");
							e.printStackTrace();
						}
					}
				}

		} else
		if (polsetpage.size() == 0)
			if (polsetbase.size() != 0)
			{
				List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
				if (stateList.size() > 0)
				{
					System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
					changeStateflag = true;
					contSchema.setState((String)stateList.get(0));
					contSchema.setEditstate((String)stateList.get(1));
				} else
				{
					System.out.println("当前操作不需要进行状态回�?");
				}
				System.out.println("�?始保存VUL险种数据33333333---------------");
				contSchema.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(polsetbase, "DELETE");
				map.put(bonusInfoSchema, "DELETE");
				map.put(accountSet, "DELETE");
				map.put(investSchema, "DELETE");
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "投保事项信息保存错误�?";
					System.out.println("投保事项保存失败");
					flagtwo = false;
				} else
				{
					try
					{
						flagtwo = true;
						infoSource = "modify";
						policyState = new BankPolicyState();
						if (changeStateflag)
							policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
						message = "投保事项信息保存成功�?";
						System.out.println("保存成功");
					}
					catch (Exception e)
					{
						message = "操作记录接口出问题了";
						System.out.println("操作记录接口出问题了");
						e.printStackTrace();
					}
				}
			} else
			{
				System.out.println("数据库中无数据，页面也无数据，此时不对数据库进行操作");
				flagtwo = false;
			}
		return flagtwo;
	}

	public boolean checkaccount(LNPInvestmentAccountInfoSet infoSet, LNPInvestmentAccountInfoSet accountSet)
	{
		boolean accountflag = true;
		if (infoSet.size() != accountSet.size())
		{
			accountflag = false;
		} else
		{
			accountflag = true;
			for (int i = 1; i <= infoSet.size(); i++)
			{
				if (!accountflag)
					break;
				LNPInvestmentAccountInfoSchema infoSchema = infoSet.get(i);
				for (int j = 1; j <= accountSet.size(); j++)
				{
					LNPInvestmentAccountInfoSchema accSchema = accountSet.get(j);
					if (!turnNullToString(infoSchema.getInvestAccountCode()).equals(turnNullToString(accSchema.getInvestAccountCode())))
						continue;
					if (!turnNullToString(Double.valueOf(infoSchema.getInvestAccountRate())).equals(turnNullToString(Double.valueOf(accSchema.getInvestAccountRate()))) || !turnNullToString(infoSchema.getVarc1()).equals(turnNullToString(accSchema.getVarc1())) || !turnNullToString(infoSchema.getRiskCode()).equals(turnNullToString(accSchema.getRiskCode())))
						return accountflag = false;
					break;
				}

			}

		}
		return accountflag;
	}

	private boolean saveTypeThree()
	{
		boolean flagthree = false;
		contSchema = getMyLNPContByContNo(contNo);
		bonusInfoSchema = getBonusSchemaByContNo(contNo);
		LNPPolSet polsetbase = getPolByContNo(contNo);
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		polSchema = new LNPPolSchema();
		LNPPolSet polsetpage = new LNPPolSet();
		LNPBonusInfoSchema newbonusschema = new LNPBonusInfoSchema();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String tIndex = "";
		System.out.println("---保存组合�?----------------------------------------------------?");
		for (int i = 0; i < 6; i++)
		{
			System.out.println((new StringBuilder("---保存组合�?----------------------------------------------------1")).append(combinationriskcode[i]).toString());
			if (combinationriskcode[i] != null && !combinationriskcode[i].equals(""))
			{
				polSchema = new LNPPolSchema();
				polSchema.setKindCode(poltype);
				polSchema.setRiskVersion(combinationriskcode[i]);
				polSchema.setSubFlag("M");
				if (combinationyears[i].startsWith("终身"))
				{
					polSchema.setPayLocation("106");
					polSchema.setPremToAmnt("A");
				}
				if (combinationyears[i].startsWith("T") || combinationyears[i].startsWith("t"))
				{
					polSchema.setPayLocation(combinationyears[i].replaceAll("^[Tt](\\d+)$", "$1"));
					polSchema.setPremToAmnt("A");
				}
				if (combinationyears[i].matches("^[1-9][0-9]*$"))
				{
					polSchema.setPayLocation(combinationyears[i].replace("", ""));
					polSchema.setPremToAmnt("Y");
				}
				if (combinationyears[i] == null || combinationyears[i].equals(""))
				{
					polSchema.setPayLocation("");
					polSchema.setPremToAmnt("");
				}
				if (combinationyears[i].equals("0"))
				{
					polSchema.setPayLocation("0");
					polSchema.setPremToAmnt("");
				}
				if (combinationpayyears[i].equals("0"))
				{
					polSchema.setPayMode("1000");
					polSchema.setAcciYearFlag("Y");
				}
				if (combinationpayyears[i].startsWith("T") || combinationpayyears[i].startsWith("t"))
				{
					polSchema.setPayMode(combinationpayyears[i].replaceAll("^[Tt](\\d+)$", "$1"));
					polSchema.setAcciYearFlag("A");
				}
				if (combinationpayyears[i].matches("^[1-9][0-9]*$"))
				{
					polSchema.setPayMode(combinationpayyears[i].replace("", ""));
					polSchema.setAcciYearFlag("Y");
				}
				if (combinationpayyears[i] == null || combinationpayyears[i].equals(""))
				{
					polSchema.setPayMode("");
					polSchema.setAcciYearFlag("");
				}
				if (i == 0)
				{
					if ("".equals(turnNullToString(combinationmoney[i]).trim()))
						polSchema.setRemark("");
					else
						polSchema.setRemark(decimalFormat.format(Double.valueOf(combinationmoney[i])).toString());
				} else
				{
					polSchema.setUWCode(combinationtype[i]);
					System.out.println((new StringBuilder("---保存组合�?----------------------------------------------------2")).append(combinationtype[i]).toString());
					System.out.println((new StringBuilder("combinationmoney[i]")).append(combinationmoney[i]).toString());
					if (combinationtype[i].equals("01"))
					{
						if (combinationmoney[i] == null || combinationmoney[i].equals(""))
						{
							polSchema.setAmnt(-1D);
							polSchema.setPrem(-1D);
						} else
						{
							polSchema.setAmnt(combinationmoney[i]);
							polSchema.setPrem(0.0D);
						}
					} else
					if (combinationtype[i].equals("02"))
					{
						System.out.println((new StringBuilder("---保存组合�?----------------------------------------------------保费")).append(combinationtype[i]).toString());
						if (combinationmoney[i] == null || combinationmoney[i].equals(""))
						{
							polSchema.setAmnt(-1D);
							polSchema.setPrem(-1D);
						} else
						{
							polSchema.setPrem(combinationmoney[i]);
							polSchema.setAmnt(0.0D);
						}
					} else
					{
						polSchema.setAmnt(-1D);
						polSchema.setPrem(-1D);
					}
				}
				polSchema.setRnewFlag("1");
				polSchema.setPayIntv(payintv.intValue());
				contSchema.setPayIntv(polSchema.getPayIntv());
				polSchema.setDeadGetMode(deadgetmode);
				polSchema.setStandbyFlag3(annuityfrequency);
				polSchema.setGrpContNo("00000000000000000000");
				polSchema.setGrpPolNo("00000000000000000000");
				polSchema.setContNo(contNo);
				polSchema.setProposalContNo(contNo);
				tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
				polSchema.setPolNo(tIndex);
				polSchema.setRiskCode("");
				polSchema.setProposalNo(tIndex);
				polSchema.setPrtNo("00000000000000000000");
				polSchema.setContType("1");
				polSchema.setManageCom(contSchema.getSignCom());
				polSchema.setMakeDate(date);
				polSchema.setMakeTime(time);
				polSchema.setModifyDate(date);
				polSchema.setModifyTime(time);
				polSchema.setOperator(tempGI.Operator);
				polsetpage.add(polSchema);
			} else
			{
				System.out.println("---组合�?---险种代码未录入，数据不会保存到数据库�?---");
			}
			System.out.println((new StringBuilder("---保存组合�?------------------------------------polsetpage.size=")).append(polsetpage.size()).toString());
		}

		newbonusschema.setGrpContNo("00000000000000000000");
		newbonusschema.setContNo(contNo);
		newbonusschema.setProposalContNo(contNo);
		newbonusschema.setPrtNo("00000000000000000000");
		newbonusschema.setBonusWay(bonusgetmode);
		newbonusschema.setP1(overflowpremium);
		newbonusschema.setP2(overduepremium);
		newbonusschema.setOperator(tempGI.Operator);
		newbonusschema.setMakeDate(date);
		newbonusschema.setMakeTime(time);
		newbonusschema.setModifyDate(date);
		newbonusschema.setModifyTime(time);
		allCompelte = false;
		allCompelte = checkAllCompelte(polsetpage, newbonusschema, null);
		boolean changeStateflag = false;
		BankOperateDeal stateOperate = new BankOperateDeal();
		if (allCompelte)
		{
			List stateList = stateOperate.infoOprate(contSchema.getState(), contSchema.getEditstate(), "modify", "02");
			contSchema.setState((String)stateList.get(0));
			contSchema.setEditstate((String)stateList.get(1));
		} else
		if ("01".equals(contSchema.getState()))
		{
			String editState = stateOperate.updateEditStateUNDone(contSchema.getEditstate(), 2);
			contSchema.setEditstate(editState);
		}
		System.out.println((new StringBuilder("---保存组合�?------------------------------------3")).append(contSchema.getEditstate()).toString());
		System.out.println((new StringBuilder("---保存组合�?------------------------------------polsetpage.size()")).append(polsetpage.size()).toString());
		System.out.println((new StringBuilder("---保存组合�?------------------------------------polsetpage.get(1).getRiskCode()")).append(polsetpage.get(1).getRiskCode()).toString());
		System.out.println((new StringBuilder("---保存组合�?------------------------------------polsetpage.size()")).append(polsetpage.size()).toString());
		if (polsetpage.size() != 0 && !polsetpage.get(1).getRiskVersion().equals("") && (polsetpage.size() != polsetbase.size() && (contSchema.getState().equals("01") || contSchema.getState().equals("02") || contSchema.getState().equals("04")) || polsetpage.size() + 1 != polsetbase.size() && !contSchema.getState().equals("01") && !contSchema.getState().equals("02") && !contSchema.getState().equals("04")))
		{
			System.out.println("--------�?始保存组合险111111---------");
			System.out.println((new StringBuilder("--------数据库中的数据与页面获取的数据条数不�? insert---------")).append(polsetpage.size()).toString());
			System.out.println((new StringBuilder("gelic1:contSchema.getState()")).append(contSchema.getState()).toString());
			List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
			if (stateList.size() > 0)
			{
				System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
				changeStateflag = true;
				contSchema.setState((String)stateList.get(0));
				contSchema.setEditstate((String)stateList.get(1));
			} else
			{
				System.out.println("当前操作不需要进行状态回�?");
			}
			System.out.println((new StringBuilder("gelic2:contSchema.getState()")).append(contSchema.getState()).toString());
			contSchema.setInputOperator(tempGI.Operator);
			contSchema.setModifyDate(date);
			contSchema.setModifyTime(time);
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(polsetbase, "DELETE");
			map.put(bonusInfoSchema, "DELETE");
			map.put(polsetpage, "INSERT");
			map.put(newbonusschema, "INSERT");
			map.put(contSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
			{
				message = "投保事项信息保存错误�?";
				System.out.println("投保事项保存失败");
				flagthree = false;
			} else
			{
				try
				{
					flagthree = true;
					infoSource = "modify";
					policyState = new BankPolicyState();
					if (changeStateflag)
						policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
					message = "投保事项信息保存成功�?";
					System.out.println("保存成功");
				}
				catch (Exception e)
				{
					message = "操作记录接口出问题了";
					System.out.println("操作记录接口出问题了");
					e.printStackTrace();
				}
			}
		}
		if (polsetpage.size() != 0 && polsetbase.size() != 0 && (polsetpage.size() == polsetbase.size() && (contSchema.getState().equals("01") || contSchema.getState().equals("02") || contSchema.getState().equals("04")) || polsetpage.size() + 1 == polsetbase.size() && !contSchema.getState().equals("01") && !contSchema.getState().equals("02") && !contSchema.getState().equals("04")))
		{
			boolean MPolFlag = false;
			LNPPolSchema polbaseschema = new LNPPolSchema();
			for (int i = 1; i <= polsetbase.size(); i++)
			{
				if (!polsetbase.get(i).getRnewFlag().equals("1"))
					continue;
				polbaseschema = polsetbase.get(i);
				MPolFlag = true;
				break;
			}

			if (!MPolFlag)
			{
				System.out.println("--ZH------------------>未找到主�?");
				return flagthree = false;
			}
			boolean flags = false;
			if (contSchema.getState().equals("01") || contSchema.getState().equals("02") || contSchema.getState().equals("04"))
			{
				System.out.println("-------------------->页面获取的数据与数据库的条数相同 update");
				for (int i = 1; i <= polsetbase.size(); i++)
				{
					if (turnNullToString(polsetpage.get(i).getRiskVersion()).equals(turnNullToString(polsetbase.get(i).getRiskVersion())) && turnNullToString(polsetpage.get(i).getPayLocation()).equals(turnNullToString(polsetbase.get(i).getPayLocation())) && turnNullToString(polsetpage.get(i).getPremToAmnt()).equals(turnNullToString(polsetbase.get(i).getPremToAmnt())) && turnNullToString(polsetpage.get(i).getPayMode()).equals(turnNullToString(polsetbase.get(i).getPayMode())) && turnNullToString(polsetpage.get(i).getAcciYearFlag()).equals(turnNullToString(polsetbase.get(i).getAcciYearFlag())) && turnNullToString(polsetpage.get(i).getRemark()).equals(turnNullToString(polsetbase.get(i).getRemark())) && turnNullToString(Double.valueOf(polsetpage.get(i).getAmnt())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getAmnt()))) && turnNullToString(Double.valueOf(polsetpage.get(i).getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem()))) && turnNullToString(Integer.valueOf(polsetpage.get(i).getPayIntv())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayIntv()))) && turnNullToString(polsetpage.get(i).getDeadGetMode()).equals(turnNullToString(polsetbase.get(i).getDeadGetMode())) && turnNullToString(polsetpage.get(i).getStandbyFlag3()).equals(turnNullToString(polsetbase.get(i).getStandbyFlag3())) && turnNullToString(newbonusschema.getBonusWay()).equals(turnNullToString(bonusInfoSchema.getBonusWay())) && turnNullToString(newbonusschema.getP1()).equals(turnNullToString(bonusInfoSchema.getP1())) && turnNullToString(newbonusschema.getP2()).equals(turnNullToString(bonusInfoSchema.getP2())))
					{
						message = "此时界面险种信息与数据库中信息一致无修改";
						System.out.println("此时界面险种信息与数据库中信息一致无修改");
						flagthree = true;
						continue;
					}
					flagthree = false;
					break;
				}

			} else
			{
				System.out.println("-------------------->页面获取的数据与数据库的条数不相�? update");
				int i = 1;
				for (int j = i; i <= polsetbase.size(); j++)
				{
					if (i == 2)
						i++;
					if (turnNullToString(polsetpage.get(j).getRiskVersion()).equals(turnNullToString(polsetbase.get(i).getRiskVersion())) && turnNullToString(polsetpage.get(j).getPayLocation()).equals(turnNullToString(polsetbase.get(i).getPayLocation())) && turnNullToString(polsetpage.get(j).getPremToAmnt()).equals(turnNullToString(polsetbase.get(i).getPremToAmnt())) && turnNullToString(polsetpage.get(j).getPayMode()).equals(turnNullToString(polsetbase.get(i).getPayMode())) && turnNullToString(polsetpage.get(j).getAcciYearFlag()).equals(turnNullToString(polsetbase.get(i).getAcciYearFlag())) && turnNullToString(polsetpage.get(j).getRemark()).equals(turnNullToString(polsetbase.get(i).getRemark())) && turnNullToString(polsetpage.get(j).getUWCode()).equals(turnNullToString(polsetbase.get(i).getUWCode())) && turnNullToString(Integer.valueOf(polsetpage.get(j).getPayIntv())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayIntv()))) && turnNullToString(polsetpage.get(j).getDeadGetMode()).equals(turnNullToString(polsetbase.get(i).getDeadGetMode())) && turnNullToString(polsetpage.get(j).getStandbyFlag3()).equals(turnNullToString(polsetbase.get(i).getStandbyFlag3())) && turnNullToString(newbonusschema.getBonusWay()).equals(turnNullToString(bonusInfoSchema.getBonusWay())) && turnNullToString(newbonusschema.getP1()).equals(turnNullToString(bonusInfoSchema.getP1())) && turnNullToString(newbonusschema.getP2()).equals(turnNullToString(bonusInfoSchema.getP2())))
					{
						if ("02".equals(polsetpage.get(j).getUWCode()) && !turnNullToString(Double.valueOf(polsetpage.get(j).getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem()))) || "01".equals(polsetpage.get(j).getUWCode()) && !turnNullToString(Double.valueOf(polsetpage.get(j).getAmnt())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getAmnt()))))
						{
							flagthree = false;
							break;
						}
						message = "此时界面副险种信息与数据库中信息�?致无修改";
						System.out.println("此时界面副险种信息与数据库中信息�?致无修改");
						flagthree = true;
					} else
					{
						flagthree = false;
						break;
					}
					i++;
				}

			}
			System.out.println((new StringBuilder("当前flagthree的�?�为===")).append(flags).toString());
			if (!flagthree)
			{
				List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
				if (stateList.size() > 0)
				{
					System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
					changeStateflag = true;
					contSchema.setState((String)stateList.get(0));
					contSchema.setEditstate((String)stateList.get(1));
				} else
				{
					System.out.println("当前操作不需要进行状态回�?");
				}
				contSchema.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(polsetbase, "DELETE");
				map.put(bonusInfoSchema, "DELETE");
				map.put(investSchema, "DELETE");
				map.put(polsetpage, "INSERT");
				map.put(newbonusschema, "INSERT");
				map.put(contSchema, "UPDATE");
				System.out.println("update ok");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "投保事项信息保存错误�?";
					System.out.println("投保事项保存失败");
					flagthree = false;
				} else
				{
					try
					{
						flagthree = true;
						infoSource = "modify";
						policyState = new BankPolicyState();
						if (changeStateflag)
							policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
						message = "投保事项信息保存成功�?";
						System.out.println("保存成功");
					}
					catch (Exception e)
					{
						message = "操作记录接口出问题了";
						System.out.println("操作记录接口出问题了");
						e.printStackTrace();
					}
				}
			}
		}
		if (polsetpage.size() == 0 && polsetbase.size() == 0)
			flagthree = true;
		if (polsetpage.size() == 0)
			if (polsetbase.size() != 0)
			{
				List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
				if (stateList.size() > 0)
				{
					System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
					changeStateflag = true;
					contSchema.setState((String)stateList.get(0));
					contSchema.setEditstate((String)stateList.get(1));
				} else
				{
					System.out.println("当前操作不需要进行状态回�?");
				}
				System.out.println("�?始保存组合险种数�?33333333---------------");
				contSchema.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(polsetbase, "DELETE");
				map.put(bonusInfoSchema, "DELETE");
				map.put(investSchema, "DELETE");
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "投保事项信息保存错误�?";
					System.out.println("投保事项保存失败");
					flagthree = false;
				} else
				{
					try
					{
						flagthree = true;
						infoSource = "modify";
						policyState = new BankPolicyState();
						if (changeStateflag)
							policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
						message = "投保事项信息保存成功�?";
						System.out.println("保存成功");
					}
					catch (Exception e)
					{
						message = "操作记录接口出问题了";
						System.out.println("操作记录接口出问题了");
						e.printStackTrace();
					}
				}
			} else
			{
				System.out.println("数据库中无数据，页面也无数据，此时不对数据库进行操作");
				flagthree = false;
			}
		return flagthree;
	}

	private boolean saveTypeFour()
	{
		boolean flagFour = false;
		contSchema = getMyLNPContByContNo(contNo);
		bonusInfoSchema = getBonusSchemaByContNo(contNo);
		LNPPolSet polsetbase = getPolByContNo(contNo);
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		polSchema = new LNPPolSchema();
		LNPPolSet polsetpage = new LNPPolSet();
		LNPBonusInfoSchema newbonusschema = new LNPBonusInfoSchema();
		SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
		String tIndex = "";
		if (yearmoneychangeriskcode != null && !yearmoneychangeriskcode.equals(""))
		{
			polSchema.setKindCode(poltype);
			polSchema.setRiskVersion(yearmoneychangeriskcode);
			polSchema.setSubFlag("M");
			if (yearmoneychangeyears.startsWith("终身"))
			{
				polSchema.setPayLocation(String.valueOf(SpecialProductFun.getRiskPro(polSchema.getRiskCode())));
				polSchema.setPremToAmnt("A");
			}
			if (yearmoneychangeyears.startsWith("T") || yearmoneychangeyears.startsWith("t"))
			{
				polSchema.setPayLocation(yearmoneychangeyears.replaceAll("^[Tt](\\d+)$", "$1"));
				polSchema.setPremToAmnt("A");
			}
			if (yearmoneychangeyears.matches("^[1-9][0-9]*$"))
			{
				polSchema.setPayLocation(yearmoneychangeyears.replace("", ""));
				polSchema.setPremToAmnt("Y");
			}
			if (yearmoneychangeyears == null || yearmoneychangeyears.equals(""))
			{
				polSchema.setPayLocation("");
				polSchema.setPremToAmnt("");
			}
			if (yearmoneychangeyears.equals("0"))
			{
				polSchema.setPayLocation("0");
				polSchema.setPremToAmnt("");
			}
			if (yearmoneychangepayyears.equals("0"))
			{
				polSchema.setPayMode("1000");
				polSchema.setAcciYearFlag("Y");
			}
			if (yearmoneychangepayyears.startsWith("T") || yearmoneychangepayyears.startsWith("t"))
			{
				polSchema.setPayMode(yearmoneychangepayyears.replaceAll("^[Tt](\\d+)$", "$1"));
				polSchema.setAcciYearFlag("A");
			}
			if (yearmoneychangepayyears.matches("^[1-9][0-9]*$"))
			{
				polSchema.setPayMode(yearmoneychangepayyears.replace("", ""));
				polSchema.setAcciYearFlag("Y");
			}
			if (yearmoneychangepayyears == null || yearmoneychangepayyears.equals(""))
			{
				polSchema.setPayMode("");
				polSchema.setAcciYearFlag("");
			}
			if ("".equals(turnNullToString(yearmoneychangemoney).trim()))
				polSchema.setRemark("");
			else
				polSchema.setRemark(decimalFormat.format(Double.valueOf(yearmoneychangemoney)).toString());
			if (yearmoneychangegetyear == null || yearmoneychangegetyear.equals(""))
			{
				polSchema.setGetYear("-1");
			} else
			{
				polSchema.setGetYear(getyear);
				polSchema.setGetYearFlag("A");
			}
			polSchema.setRnewFlag("2");
			polSchema.setPayIntv(payintv.intValue());
			contSchema.setPayIntv(polSchema.getPayIntv());
			polSchema.setDeadGetMode(deadgetmode);
			polSchema.setStandbyFlag3(annuityfrequency);
			polSchema.setGrpContNo("00000000000000000000");
			polSchema.setGrpPolNo("00000000000000000000");
			polSchema.setContNo(contNo);
			polSchema.setProposalContNo(contNo);
			tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
			polSchema.setPolNo(tIndex);
			polSchema.setRiskCode("");
			polSchema.setProposalNo(tIndex);
			polSchema.setPrtNo("00000000000000000000");
			polSchema.setContType("1");
			polSchema.setManageCom(contSchema.getSignCom());
			polSchema.setMakeDate(date);
			polSchema.setMakeTime(time);
			polSchema.setModifyDate(date);
			polSchema.setModifyTime(time);
			polSchema.setOperator(tempGI.Operator);
			polSchema.setGetYear(yearmoneychangegetyear);
			polSchema.setUWTime(salechannel);
			polsetpage.add(polSchema);
		} else
		{
			System.out.println("---年金转换险种---险种代码未录入，数据不会保存到数据库�?---");
		}
		System.out.println((new StringBuilder("polsetpage.size==================")).append(polsetpage.size()).toString());
		newbonusschema.setGrpContNo("00000000000000000000");
		newbonusschema.setContNo(contNo);
		newbonusschema.setProposalContNo(contNo);
		newbonusschema.setPrtNo("00000000000000000000");
		newbonusschema.setBonusWay(bonusgetmode);
		newbonusschema.setP1(overflowpremium);
		newbonusschema.setP2(overduepremium);
		newbonusschema.setOperator(tempGI.Operator);
		newbonusschema.setMakeDate(date);
		newbonusschema.setMakeTime(time);
		newbonusschema.setModifyDate(date);
		newbonusschema.setModifyTime(time);
		allCompelte = false;
		allCompelte = checkAllCompelte(polsetpage, newbonusschema, null);
		boolean changeStateflag = false;
		BankOperateDeal stateOperate = new BankOperateDeal();
		if (allCompelte)
		{
			List stateList = stateOperate.infoOprate(contSchema.getState(), contSchema.getEditstate(), "modify", "02");
			contSchema.setState((String)stateList.get(0));
			contSchema.setEditstate((String)stateList.get(1));
		} else
		if ("01".equals(contSchema.getState()))
		{
			String editState = stateOperate.updateEditStateUNDone(contSchema.getEditstate(), 2);
			contSchema.setEditstate(editState);
		}
		System.out.println((new StringBuilder("---------------------------------------------")).append(contSchema.getEditstate()).toString());
		if (polsetpage.size() != 0)
		{
			if (polsetbase.size() == 0)
			{
				System.out.println("--------�?始保存年金转换险�?---------");
				contSchema.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(polSchema, "INSERT");
				map.put(newbonusschema, "INSERT");
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "投保事项信息保存错误�?";
					System.out.println("投保事项保存失败");
					flagFour = false;
				} else
				{
					try
					{
						flagFour = true;
						infoSource = "modify";
						policyState = new BankPolicyState();
						if (changeStateflag)
							policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
						message = "投保事项信息保存成功�?";
						System.out.println("保存成功");
					}
					catch (Exception e)
					{
						message = "操作记录接口出问题了";
						System.out.println("操作记录接口出问题了");
						e.printStackTrace();
					}
				}
			} else
			{
				boolean MPolFlag = false;
				LNPPolSchema polbaseschema = new LNPPolSchema();
				for (int i = 1; i <= polsetbase.size(); i++)
				{
					if (!polsetbase.get(i).getRnewFlag().equals("2"))
						continue;
					polbaseschema = polsetbase.get(i);
					MPolFlag = true;
					break;
				}

				if (!MPolFlag)
				{
					System.out.println("--ZH------------------>未找到主�?");
					return flagFour = false;
				}
				if (turnNullToString(polSchema.getUWTime()).equals(turnNullToString(polbaseschema.getUWTime())) && turnNullToString(polSchema.getRiskVersion()).equals(turnNullToString(polbaseschema.getRiskVersion())) && turnNullToString(polSchema.getPayLocation()).equals(turnNullToString(polbaseschema.getPayLocation())) && turnNullToString(polSchema.getPremToAmnt()).equals(turnNullToString(polbaseschema.getPremToAmnt())) && turnNullToString(polSchema.getPayMode()).equals(turnNullToString(polbaseschema.getPayMode())) && turnNullToString(polSchema.getAcciYearFlag()).equals(turnNullToString(polbaseschema.getAcciYearFlag())) && turnNullToString(polSchema.getRemark()).equals(turnNullToString(polbaseschema.getRemark())) && turnNullToString(Integer.valueOf(polSchema.getGetYear())).equals(turnNullToString(Integer.valueOf(polbaseschema.getGetYear()))) && turnNullToString(polSchema.getGetYearFlag()).equals(turnNullToString(polbaseschema.getGetYearFlag())) && turnNullToString(Integer.valueOf(polSchema.getPayIntv())).equals(turnNullToString(Integer.valueOf(polbaseschema.getPayIntv()))) && turnNullToString(polSchema.getDeadGetMode()).equals(turnNullToString(polbaseschema.getDeadGetMode())) && turnNullToString(polSchema.getStandbyFlag3()).equals(turnNullToString(polbaseschema.getStandbyFlag3())) && turnNullToString(newbonusschema.getBonusWay()).equals(turnNullToString(bonusInfoSchema.getBonusWay())) && turnNullToString(newbonusschema.getP1()).equals(turnNullToString(bonusInfoSchema.getP1())) && turnNullToString(newbonusschema.getP2()).equals(turnNullToString(bonusInfoSchema.getP2())))
				{
					message = "此时界面险种信息与数据库中信息一致无修改";
					System.out.println("此时界面险种信息与数据库中信息一致无修改");
					flagFour = true;
				} else
				{
					flagFour = false;
				}
				if (!flagFour)
				{
					String oldUWTime = turnNullToString(polbaseschema.getUWTime());
					String newUWTime = turnNullToString(polSchema.getUWTime());
					LNPAgentInfoSchema agentInfoSchema = null;
					LNPAgentInfoDB agentInfoDB = new LNPAgentInfoDB();
					agentInfoDB.setContNo(contNo);
					LNPAgentInfoSet agentInfoSet = agentInfoDB.query();
					if (agentInfoSet.size() > 0)
					{
						agentInfoSchema = agentInfoSet.get(1);
						if (oldUWTime.equals("BXS") && (newUWTime.equals("AGY") || newUWTime.equals("TM")))
						{
							agentInfoSchema.setP2("");
							agentInfoSchema.setAgentCode("");
							agentInfoSchema.setOperator(tempGI.Operator);
							agentInfoSchema.setModifyDate(date);
							agentInfoSchema.setModifyTime(time);
						}
					}
					LNPCustImpResultDB resultDB = new LNPCustImpResultDB();
					resultDB.setContNo(contNo);
					LNPCustImpResultSet resultSet = resultDB.query();
					if (!oldUWTime.equals(newUWTime) && resultSet.size() > 0)
					{
						String editstate = stateOperate.updateEditStateDone(contSchema.getEditstate(), 4);
						contSchema.setEditstate(editstate);
					}
					List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
					if (stateList.size() > 0)
					{
						System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
						changeStateflag = true;
						contSchema.setState((String)stateList.get(0));
						contSchema.setEditstate((String)stateList.get(1));
					} else
					{
						System.out.println("当前操作不需要进行状态回�?");
					}
					contSchema.setInputOperator(tempGI.Operator);
					contSchema.setModifyDate(date);
					contSchema.setModifyTime(time);
					PubSubmit ps = new PubSubmit();
					MMap map = new MMap();
					map.put(polsetbase, "DELETE");
					map.put(bonusInfoSchema, "DELETE");
					map.put(investSchema, "DELETE");
					map.put(polSchema, "INSERT");
					map.put(newbonusschema, "INSERT");
					map.put(contSchema, "UPDATE");
					map.put(agentInfoSchema, "UPDATE");
					map.put(resultSet, "DELETE");
					VData vd = new VData();
					vd.add(map);
					if (!ps.submitData(vd, ""))
					{
						message = "投保事项信息保存错误�?";
						System.out.println("投保事项保存失败");
						flagFour = false;
					} else
					{
						try
						{
							flagFour = true;
							infoSource = "modify";
							policyState = new BankPolicyState();
							if (changeStateflag)
								policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
							message = "投保事项信息保存成功�?";
							System.out.println("保存成功");
						}
						catch (Exception e)
						{
							message = "操作记录接口出问题了";
							System.out.println("操作记录接口出问题了");
							e.printStackTrace();
						}
					}
				}
			}
		} else
		if (polsetpage.size() == 0)
			if (polsetbase.size() != 0)
			{
				List stateList = stateOperate.changeMsgToModify(contSchema.getState(), contSchema.getEditstate(), tempGI.LNPRole);
				if (stateList.size() > 0)
				{
					System.out.println("-------因为有保单信息被修改,将回滚保单状态�??02待审核状�?---------");
					changeStateflag = true;
					contSchema.setState((String)stateList.get(0));
					contSchema.setEditstate((String)stateList.get(1));
				} else
				{
					System.out.println("当前操作不需要进行状态回�?");
				}
				System.out.println("�?始保存年金转换险�?---------------");
				contSchema.setInputOperator(tempGI.Operator);
				contSchema.setModifyDate(date);
				contSchema.setModifyTime(time);
				PubSubmit ps = new PubSubmit();
				MMap map = new MMap();
				map.put(polsetbase, "DELETE");
				map.put(bonusInfoSchema, "DELETE");
				map.put(investSchema, "DELETE");
				map.put(contSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!ps.submitData(vd, ""))
				{
					message = "投保事项信息保存错误�?";
					System.out.println("投保事项保存失败");
					flagFour = false;
				} else
				{
					try
					{
						flagFour = true;
						infoSource = "modify";
						policyState = new BankPolicyState();
						if (changeStateflag)
							policyState.savePolicyState(contSchema.getContNo(), contSchema.getState(), "3", date, time);
						message = "投保事项信息保存成功�?";
						System.out.println("保存成功");
					}
					catch (Exception e)
					{
						message = "操作记录接口出问题了";
						System.out.println("操作记录接口出问题了");
						e.printStackTrace();
					}
				}
			} else
			{
				System.out.println("数据库中无数据，页面也无数据，此时不对数据库进行操作");
				flagFour = false;
			}
		return flagFour;
	}

	private boolean checkAllCompelte(LNPPolSet polsetpage, LNPBonusInfoSchema infoschema, LNPInvestmentInfoSchema newinvestSchema)
	{
		boolean checkflag;
		System.out.println("-----�?始调用必录项校验-------");
		checkflag = false;
		if (polsetpage == null || polsetpage.size() == 0)
			checkflag = false;
		else
		if (polsetpage.get(1).getKindCode().equals("01"))
		{
			System.out.println("------传统�?(01)必录项校�?------");
			for (int i = 1; i <= polsetpage.size(); i++)
			{
				if (!polsetpage.get(i).getRiskCode().equals("") && polsetpage.get(i).getGetYear() >= 0 && polsetpage.get(i).getPayIntv() != -1 && !infoschema.getP1().equals("") && infoschema.getP1() != null && !infoschema.getP2().equals(""))
				{
					checkflag = true;
					continue;
				}
				checkflag = false;
				break;
			}

		} else
		if (polsetpage.get(1).getKindCode().equals("02"))
		{
			System.out.println("------VUL�?(02)必录项校�?------");
			for (int i = 1; i <= polsetpage.size(); i++)
			{
				if (!polsetpage.get(i).getRiskCode().equals("") && polsetpage.get(i).getPrem() != 0.0D)
				{
					checkflag = true;
					continue;
				}
				checkflag = false;
				break;
			}

		} else
		if (polsetpage.get(1).getKindCode().equals("03"))
		{
			System.out.println((new StringBuilder("------组合�?(03)必录项校�?------==")).append(polsetpage.size()).toString());
			for (int i = 1; i <= polsetpage.size(); i++)
			{
				System.out.println((new StringBuilder("------组合�?(03)必录项校�?------==�?")).append(i).append("==>").append(polsetpage.get(i).getRnewFlag()).toString());
				System.out.println((new StringBuilder("polsetpage.get(i)====")).append(polsetpage.get(i).getRnewFlag().equals("1")).toString());
				if (polsetpage.get(i).getRnewFlag() == null || polsetpage.get(i).getRnewFlag().equals("") || !polsetpage.get(i).getRnewFlag().equals("1") || i != 1)
					continue;
				System.out.println("==================�?始校�?=================================");
				System.out.println((new StringBuilder("polsetpage.get(i).getRiskVersion()结果�?")).append(polsetpage.get(i).getRiskVersion()).toString());
				System.out.println((new StringBuilder("polsetpage.get(i).getRemark()结果�?")).append(polsetpage.get(i).getRemark()).toString());
				System.out.println((new StringBuilder("polsetpage.get(i).getPayIntv()结果�?")).append(polsetpage.get(i).getPayIntv()).toString());
				System.out.println((new StringBuilder("polsetpage.get(i).getP1()结果�?")).append(infoschema.getP1()).toString());
				System.out.println((new StringBuilder("polsetpage.get(i).getP2()结果�?")).append(infoschema.getP2()).toString());
				if (!polsetpage.get(i).getRiskVersion().equals("") && !polsetpage.get(i).getRemark().equals("") && polsetpage.get(i).getPayIntv() != -1 && !infoschema.getP1().equals("") && infoschema.getP1() != null && !infoschema.getP2().equals(""))
				{
					checkflag = true;
				} else
				{
					checkflag = false;
					break;
				}
				System.out.println((new StringBuilder("------组合�?(03)必录项校�?------1结果")).append(checkflag).toString());
			}

		} else
		if (polsetpage.get(1).getKindCode().equals("04"))
		{
			System.out.println("------年金转换(04)必录项校�?------");
			for (int i = 1; i <= polsetpage.size(); i++)
			{
				if (polsetpage.get(i).getRnewFlag() == null || polsetpage.get(i).getRnewFlag().equals("") || !polsetpage.get(i).getRnewFlag().equals("2"))
					continue;
				if (polsetpage.get(i).getUWTime() != null && !polsetpage.get(i).getUWTime().equals("-1") && !polsetpage.get(i).getUWTime().equals("") && !polsetpage.get(i).getRiskVersion().equals("") && !polsetpage.get(i).getPayLocation().equals("") && !polsetpage.get(i).getPremToAmnt().equals("") && !polsetpage.get(i).getPayMode().equals("") && !polsetpage.get(i).getAcciYearFlag().equals("") && !polsetpage.get(i).getRemark().equals("") && polsetpage.get(i).getGetYear() >= 0 && polsetpage.get(i).getPayIntv() != -1 && !infoschema.getP1().equals("") && infoschema.getP1() != null && !infoschema.getP2().equals("") && !polsetpage.get(i).getDeadGetMode().equals("") && !polsetpage.get(i).getDeadGetMode().equals("-1") && !polsetpage.get(i).getStandbyFlag3().equals("") && !polsetpage.get(i).getStandbyFlag3().equals("-1"))
				{
					checkflag = true;
					continue;
				}
				checkflag = false;
				break;
			}

		}
		System.out.println((new StringBuilder("----校验结束-----checkflag====")).append(checkflag).toString());
		return checkflag;
		RuntimeException e;
		e;
		e.printStackTrace();
		System.out.println("进行了保存操作但是没有录入数�?");
		return false;
	}

	private boolean checkMoney(LNPPolSchema lnpPolSchema)
	{
		return lnpPolSchema.getPrem() != 0.0D || lnpPolSchema.getAmnt() != 0.0D;
	}

	private String turnNullToString(Object object)
	{
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

	private void buildError(String msgErr)
	{
		message = msgErr;
		operateResult = false;
	}

	public boolean isEditFlag()
	{
		return editFlag;
	}

	public void setEditFlag(boolean editFlag)
	{
		this.editFlag = editFlag;
	}

	public boolean isOperateResult()
	{
		return operateResult;
	}

	public void setOperateResult(boolean operateResult)
	{
		this.operateResult = operateResult;
	}

	public IGlobalInput getTempGI()
	{
		return tempGI;
	}

	public void setTempGI(IGlobalInput tempGI)
	{
		this.tempGI = tempGI;
	}

	public LNPContSchema getContSchema()
	{
		return contSchema;
	}

	public void setContSchema(LNPContSchema contSchema)
	{
		this.contSchema = contSchema;
	}

	public LNPInvestmentInfoSchema getInvestSchema()
	{
		return investSchema;
	}

	public void setInvestSchema(LNPInvestmentInfoSchema investSchema)
	{
		this.investSchema = investSchema;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getInfoSource()
	{
		return infoSource;
	}

	public void setInfoSource(String infoSource)
	{
		this.infoSource = infoSource;
	}

	public String getContNo()
	{
		return contNo;
	}

	public void setContNo(String contNo)
	{
		this.contNo = contNo;
	}

	public LNPPolSchema getPolSchema()
	{
		return polSchema;
	}

	public void setPolSchema(LNPPolSchema polSchema)
	{
		this.polSchema = polSchema;
	}

	public String[] getMoney()
	{
		return money;
	}

	public void setMoney(String money[])
	{
		this.money = money;
	}

	public String getPoltype()
	{
		return poltype;
	}

	public void setPoltype(String poltype)
	{
		this.poltype = poltype;
	}

	public String[] getRiskcode()
	{
		return riskcode;
	}

	public String[] getType()
	{
		return type;
	}

	public void setType(String type[])
	{
		this.type = type;
	}

	public void setRiskcode(String riskcode[])
	{
		this.riskcode = riskcode;
	}

	public String[] getYears()
	{
		return years;
	}

	public void setYears(String years[])
	{
		this.years = years;
	}

	public String[] getPayyears()
	{
		return payyears;
	}

	public void setPayyears(String payyears[])
	{
		this.payyears = payyears;
	}

	public String getGetyear()
	{
		return getyear;
	}

	public void setGetyear(String getyear)
	{
		this.getyear = getyear;
	}

	public Integer getPayintv()
	{
		return payintv;
	}

	public void setPayintv(Integer payintv)
	{
		this.payintv = payintv;
	}

	public String getDeadgetmode()
	{
		return deadgetmode;
	}

	public void setDeadgetmode(String deadgetmode)
	{
		this.deadgetmode = deadgetmode;
	}

	public String getBonusgetmode()
	{
		return bonusgetmode;
	}

	public void setBonusgetmode(String bonusgetmode)
	{
		this.bonusgetmode = bonusgetmode;
	}

	public String getOverflowpremium()
	{
		return overflowpremium;
	}

	public void setOverflowpremium(String overflowpremium)
	{
		this.overflowpremium = overflowpremium;
	}

	public String getOverduepremium()
	{
		return overduepremium;
	}

	public void setOverduepremium(String overduepremium)
	{
		this.overduepremium = overduepremium;
	}

	public String getAnnuityfrequency()
	{
		return annuityfrequency;
	}

	public void setAnnuityfrequency(String annuityfrequency)
	{
		this.annuityfrequency = annuityfrequency;
	}

	public boolean isAlertFlag()
	{
		return alertFlag;
	}

	public void setAlertFlag(boolean alertFlag)
	{
		this.alertFlag = alertFlag;
	}

	public String getOperType()
	{
		return operType;
	}

	public void setOperType(String operType)
	{
		this.operType = operType;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String manageCom)
	{
		this.manageCom = manageCom;
	}

	public String getVulriskcode()
	{
		return vulriskcode;
	}

	public void setVulriskcode(String vulriskcode)
	{
		this.vulriskcode = vulriskcode;
	}

	public String getSumprem()
	{
		return sumprem;
	}

	public void setSumprem(String sumprem)
	{
		this.sumprem = sumprem;
	}

	public String getVulprem()
	{
		return vulprem;
	}

	public void setVulprem(String vulprem)
	{
		this.vulprem = vulprem;
	}

	public String getVulmonthplus()
	{
		return vulmonthplus;
	}

	public void setVulmonthplus(String vulmonthplus)
	{
		this.vulmonthplus = vulmonthplus;
	}

	public String getVulyear()
	{
		return vulyear;
	}

	public void setVulyear(String vulyear)
	{
		this.vulyear = vulyear;
	}

	public String getVulinvestment()
	{
		return vulinvestment;
	}

	public void setVulinvestment(String vulinvestment)
	{
		this.vulinvestment = vulinvestment;
	}

	public String[] getCombinationriskcode()
	{
		return combinationriskcode;
	}

	public void setCombinationriskcode(String combinationriskcode[])
	{
		this.combinationriskcode = combinationriskcode;
	}

	public String[] getCombinationyears()
	{
		return combinationyears;
	}

	public void setCombinationyears(String combinationyears[])
	{
		this.combinationyears = combinationyears;
	}

	public String[] getCombinationpayyears()
	{
		return combinationpayyears;
	}

	public void setCombinationpayyears(String combinationpayyears[])
	{
		this.combinationpayyears = combinationpayyears;
	}

	public List getLnpList()
	{
		return lnpList;
	}

	public void setLnpList(List lnpList)
	{
		this.lnpList = lnpList;
	}

	public String[] getCombinationmoney()
	{
		return combinationmoney;
	}

	public void setCombinationmoney(String combinationmoney[])
	{
		this.combinationmoney = combinationmoney;
	}

	public LNPBonusInfoSchema getBonusInfoSchema()
	{
		return bonusInfoSchema;
	}

	public void setBonusInfoSchema(LNPBonusInfoSchema bonusInfoSchema)
	{
		this.bonusInfoSchema = bonusInfoSchema;
	}

	public String getRadiotype()
	{
		return radiotype;
	}

	public void setRadiotype(String radiotype)
	{
		this.radiotype = radiotype;
	}

	public List getCbtlnpList()
	{
		return cbtlnpList;
	}

	public void setCbtlnpList(List cbtlnpList)
	{
		this.cbtlnpList = cbtlnpList;
	}

	public List getVulinvestmentList()
	{
		return vulinvestmentList;
	}

	public void setVulinvestmentList(List vulinvestmentList)
	{
		this.vulinvestmentList = vulinvestmentList;
	}

	public int getVulsize()
	{
		return vulsize;
	}

	public void setVulsize(int vulsize)
	{
		this.vulsize = vulsize;
	}

	public boolean isVullistflag()
	{
		return vullistflag;
	}

	public void setVullistflag(boolean vullistflag)
	{
		this.vullistflag = vullistflag;
	}

	public boolean isVulrateflag()
	{
		return vulrateflag;
	}

	public void setVulrateflag(boolean vulrateflag)
	{
		this.vulrateflag = vulrateflag;
	}

	public BankRelationContNo getRelationDeal()
	{
		return relationDeal;
	}

	public void setRelationDeal(BankRelationContNo relationDeal)
	{
		this.relationDeal = relationDeal;
	}

	public String getSalechannel()
	{
		return salechannel;
	}

	public void setSalechannel(String salechannel)
	{
		this.salechannel = salechannel;
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("saleChannel", salechannel);
	}

	public String getYearmoneychangeriskcode()
	{
		return yearmoneychangeriskcode;
	}

	public void setYearmoneychangeriskcode(String yearmoneychangeriskcode)
	{
		this.yearmoneychangeriskcode = yearmoneychangeriskcode;
	}

	public String getYearmoneychangeyears()
	{
		return yearmoneychangeyears;
	}

	public void setYearmoneychangeyears(String yearmoneychangeyears)
	{
		this.yearmoneychangeyears = yearmoneychangeyears;
	}

	public String getYearmoneychangepayyears()
	{
		return yearmoneychangepayyears;
	}

	public void setYearmoneychangepayyears(String yearmoneychangepayyears)
	{
		this.yearmoneychangepayyears = yearmoneychangepayyears;
	}

	public String getYearmoneychangemoney()
	{
		return yearmoneychangemoney;
	}

	public void setYearmoneychangemoney(String yearmoneychangemoney)
	{
		this.yearmoneychangemoney = yearmoneychangemoney;
	}

	public String getYearmoneychangegetyear()
	{
		return yearmoneychangegetyear;
	}

	public void setYearmoneychangegetyear(String yearmoneychangegetyear)
	{
		this.yearmoneychangegetyear = yearmoneychangegetyear;
	}

	public List getYmclnpList()
	{
		return ymclnpList;
	}

	public void setYmclnpList(List ymclnpList)
	{
		this.ymclnpList = ymclnpList;
	}

	public String[] getCombinationtype()
	{
		return combinationtype;
	}

	public void setCombinationtype(String combinationtype[])
	{
		this.combinationtype = combinationtype;
	}

}
