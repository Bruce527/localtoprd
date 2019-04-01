// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAIndexInfoSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.LAIndexInfoDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LAIndexInfoSchema
	implements Schema, Cloneable
{

	private String indexCalNo;
	private String indexType;
	private String agentCode;
	private String agentGroup;
	private String manageCom;
	private Date startDate;
	private Date startEnd;
	private int quaBgnMark;
	private int serverMonths;
	private int postMonths;
	private double indMonthFYC;
	private double indMonthSYC;
	private double indMonSignFYC;
	private double indMonSignAFYC;
	private double indMonSignNAFYC;
	private double grpMonSignNAFYC;
	private double monPolCnt;
	private double montCustCnt;
	private double indMonPCount;
	private double sMmonPolContin;
	private double sMmonProduct;
	private double sMworkMon;
	private double monPCount;
	private double wSMMonPCount;
	private double lPMonForSMMP;
	private double lPMonForAMMP;
	private double lPpolContinute;
	private double monEligFLPCnt;
	private double tSRmonAFYP;
	private double tSRmonDedAFYP;
	private double tSRmonCompAFYP;
	private double tSRMonWorkDays;
	private double monManPower;
	private double monManCount;
	private double monSAFYPSum;
	private double monTLGrpSAFYPSum;
	private double indYearNAFYC;
	private double b12IndEffectAFYC;
	private double b12IndAllAFYC;
	private double b24IndEffectAFYC;
	private double b24IndAllAFYC;
	private double indQutFYC;
	private double lPproductivity;
	private double lPPPRate;
	private double lPPPBonus;
	private double lPFincSubsidy;
	private double subsidyRate;
	private double b12TeamNAFYC;
	private double sMOverride;
	private double teamMonAvgPCount;
	private double sMBasicSalary;
	private double sMproductivity;
	private double sMpolContinute;
	private double sMPPRate;
	private double sMPPBonus;
	private double b24TeamEffectAFYC;
	private double b24TeamAllAFYC;
	private double teamQutPremSum;
	private double sMRRBonus;
	private double sMManPowerDBonus;
	private double lPB12ForMPDBonus;
	private double sMUsualALLCSum;
	private double aMBasicSalary;
	private double aMproductivity;
	private double aMpolContinute;
	private double aMPPRate;
	private double aMPPBonus;
	private double b12DepNAFYC;
	private double aMOverride;
	private double depMonAvgPCount;
	private double depQutPremSum;
	private double aMRRBonus;
	private double aMManPowerDBonus;
	private double productGrowth;
	private double depQuaFYCSum;
	private double aMLiability;
	private double reviOpen;
	private double t1;
	private double t2;
	private double t3;
	private double t4;
	private double t5;
	private double t6;
	private double t7;
	private double t8;
	private double t9;
	private double t10;
	private double t11;
	private double t12;
	private double t13;
	private double t14;
	private double t15;
	private double t16;
	private double t17;
	private double t18;
	private double t20;
	private double t19;
	private double monthIndex;
	private double tMonthIndex;
	private double aSumIndex;
	private double wSMMonthEligible;
	private double lPQuaPCount;
	private double lPQuaFYCSum;
	private double b12LPPCount;
	private double b12LPNAFYCSum;
	private double wSMMonAFYC;
	private double wSMTwoMonAFYC;
	private double wSMB6AFYC;
	private double wSMB6PCount;
	private double netLiveLPCount;
	private double netComLPCount;
	private double wSMTwoMonPCount;
	private double lPAllNAFYC;
	private double lPAllPCount;
	private double monPerSAFYP;
	private double tSRThrMonSAFYP;
	private double tLThrMonPerSAFYP;
	private double monSubsistCnt;
	private double thrMonSubsistCnt;
	private String state;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private String assessMonth;
	private String branchAttr;
	private String agentGrade;
	private double clubPromBonus;
	private double clubGradeBonus;
	private double clubAssisBonus;
	private double clubSpecBonus;
	private double adddedMoney;
	private double lastMoney;
	private double shouldMoney;
	private double businessTax;
	private double eduTax;
	private double buildTax;
	private double busiCharge;
	private double incomeTax;
	private double sumMoney;
	private double afterTaxMoney;
	private double operInCome;
	private double t21;
	private double t22;
	private double t23;
	private double t24;
	private double t25;
	public static final int FIELDNUM = 148;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LAIndexInfoSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "IndexCalNo";
		pk[1] = "IndexType";
		pk[2] = "AgentCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		LAIndexInfoSchema cloned = (LAIndexInfoSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getIndexCalNo()
	{
		return indexCalNo;
	}

	public void setIndexCalNo(String aIndexCalNo)
	{
		indexCalNo = aIndexCalNo;
	}

	public String getIndexType()
	{
		return indexType;
	}

	public void setIndexType(String aIndexType)
	{
		indexType = aIndexType;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getAgentGroup()
	{
		return agentGroup;
	}

	public void setAgentGroup(String aAgentGroup)
	{
		agentGroup = aAgentGroup;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getStartDate()
	{
		if (startDate != null)
			return fDate.getString(startDate);
		else
			return null;
	}

	public void setStartDate(Date aStartDate)
	{
		startDate = aStartDate;
	}

	public void setStartDate(String aStartDate)
	{
		if (aStartDate != null && !aStartDate.equals(""))
			startDate = fDate.getDate(aStartDate);
		else
			startDate = null;
	}

	public String getStartEnd()
	{
		if (startEnd != null)
			return fDate.getString(startEnd);
		else
			return null;
	}

	public void setStartEnd(Date aStartEnd)
	{
		startEnd = aStartEnd;
	}

	public void setStartEnd(String aStartEnd)
	{
		if (aStartEnd != null && !aStartEnd.equals(""))
			startEnd = fDate.getDate(aStartEnd);
		else
			startEnd = null;
	}

	public int getQuaBgnMark()
	{
		return quaBgnMark;
	}

	public void setQuaBgnMark(int aQuaBgnMark)
	{
		quaBgnMark = aQuaBgnMark;
	}

	public void setQuaBgnMark(String aQuaBgnMark)
	{
		if (aQuaBgnMark != null && !aQuaBgnMark.equals(""))
		{
			Integer tInteger = new Integer(aQuaBgnMark);
			int i = tInteger.intValue();
			quaBgnMark = i;
		}
	}

	public int getServerMonths()
	{
		return serverMonths;
	}

	public void setServerMonths(int aServerMonths)
	{
		serverMonths = aServerMonths;
	}

	public void setServerMonths(String aServerMonths)
	{
		if (aServerMonths != null && !aServerMonths.equals(""))
		{
			Integer tInteger = new Integer(aServerMonths);
			int i = tInteger.intValue();
			serverMonths = i;
		}
	}

	public int getPostMonths()
	{
		return postMonths;
	}

	public void setPostMonths(int aPostMonths)
	{
		postMonths = aPostMonths;
	}

	public void setPostMonths(String aPostMonths)
	{
		if (aPostMonths != null && !aPostMonths.equals(""))
		{
			Integer tInteger = new Integer(aPostMonths);
			int i = tInteger.intValue();
			postMonths = i;
		}
	}

	public double getIndMonthFYC()
	{
		return indMonthFYC;
	}

	public void setIndMonthFYC(double aIndMonthFYC)
	{
		indMonthFYC = aIndMonthFYC;
	}

	public void setIndMonthFYC(String aIndMonthFYC)
	{
		if (aIndMonthFYC != null && !aIndMonthFYC.equals(""))
		{
			Double tDouble = new Double(aIndMonthFYC);
			double d = tDouble.doubleValue();
			indMonthFYC = d;
		}
	}

	public double getIndMonthSYC()
	{
		return indMonthSYC;
	}

	public void setIndMonthSYC(double aIndMonthSYC)
	{
		indMonthSYC = aIndMonthSYC;
	}

	public void setIndMonthSYC(String aIndMonthSYC)
	{
		if (aIndMonthSYC != null && !aIndMonthSYC.equals(""))
		{
			Double tDouble = new Double(aIndMonthSYC);
			double d = tDouble.doubleValue();
			indMonthSYC = d;
		}
	}

	public double getIndMonSignFYC()
	{
		return indMonSignFYC;
	}

	public void setIndMonSignFYC(double aIndMonSignFYC)
	{
		indMonSignFYC = aIndMonSignFYC;
	}

	public void setIndMonSignFYC(String aIndMonSignFYC)
	{
		if (aIndMonSignFYC != null && !aIndMonSignFYC.equals(""))
		{
			Double tDouble = new Double(aIndMonSignFYC);
			double d = tDouble.doubleValue();
			indMonSignFYC = d;
		}
	}

	public double getIndMonSignAFYC()
	{
		return indMonSignAFYC;
	}

	public void setIndMonSignAFYC(double aIndMonSignAFYC)
	{
		indMonSignAFYC = aIndMonSignAFYC;
	}

	public void setIndMonSignAFYC(String aIndMonSignAFYC)
	{
		if (aIndMonSignAFYC != null && !aIndMonSignAFYC.equals(""))
		{
			Double tDouble = new Double(aIndMonSignAFYC);
			double d = tDouble.doubleValue();
			indMonSignAFYC = d;
		}
	}

	public double getIndMonSignNAFYC()
	{
		return indMonSignNAFYC;
	}

	public void setIndMonSignNAFYC(double aIndMonSignNAFYC)
	{
		indMonSignNAFYC = aIndMonSignNAFYC;
	}

	public void setIndMonSignNAFYC(String aIndMonSignNAFYC)
	{
		if (aIndMonSignNAFYC != null && !aIndMonSignNAFYC.equals(""))
		{
			Double tDouble = new Double(aIndMonSignNAFYC);
			double d = tDouble.doubleValue();
			indMonSignNAFYC = d;
		}
	}

	public double getGrpMonSignNAFYC()
	{
		return grpMonSignNAFYC;
	}

	public void setGrpMonSignNAFYC(double aGrpMonSignNAFYC)
	{
		grpMonSignNAFYC = aGrpMonSignNAFYC;
	}

	public void setGrpMonSignNAFYC(String aGrpMonSignNAFYC)
	{
		if (aGrpMonSignNAFYC != null && !aGrpMonSignNAFYC.equals(""))
		{
			Double tDouble = new Double(aGrpMonSignNAFYC);
			double d = tDouble.doubleValue();
			grpMonSignNAFYC = d;
		}
	}

	public double getMonPolCnt()
	{
		return monPolCnt;
	}

	public void setMonPolCnt(double aMonPolCnt)
	{
		monPolCnt = aMonPolCnt;
	}

	public void setMonPolCnt(String aMonPolCnt)
	{
		if (aMonPolCnt != null && !aMonPolCnt.equals(""))
		{
			Double tDouble = new Double(aMonPolCnt);
			double d = tDouble.doubleValue();
			monPolCnt = d;
		}
	}

	public double getMontCustCnt()
	{
		return montCustCnt;
	}

	public void setMontCustCnt(double aMontCustCnt)
	{
		montCustCnt = aMontCustCnt;
	}

	public void setMontCustCnt(String aMontCustCnt)
	{
		if (aMontCustCnt != null && !aMontCustCnt.equals(""))
		{
			Double tDouble = new Double(aMontCustCnt);
			double d = tDouble.doubleValue();
			montCustCnt = d;
		}
	}

	public double getIndMonPCount()
	{
		return indMonPCount;
	}

	public void setIndMonPCount(double aIndMonPCount)
	{
		indMonPCount = aIndMonPCount;
	}

	public void setIndMonPCount(String aIndMonPCount)
	{
		if (aIndMonPCount != null && !aIndMonPCount.equals(""))
		{
			Double tDouble = new Double(aIndMonPCount);
			double d = tDouble.doubleValue();
			indMonPCount = d;
		}
	}

	public double getSMmonPolContin()
	{
		return sMmonPolContin;
	}

	public void setSMmonPolContin(double aSMmonPolContin)
	{
		sMmonPolContin = aSMmonPolContin;
	}

	public void setSMmonPolContin(String aSMmonPolContin)
	{
		if (aSMmonPolContin != null && !aSMmonPolContin.equals(""))
		{
			Double tDouble = new Double(aSMmonPolContin);
			double d = tDouble.doubleValue();
			sMmonPolContin = d;
		}
	}

	public double getSMmonProduct()
	{
		return sMmonProduct;
	}

	public void setSMmonProduct(double aSMmonProduct)
	{
		sMmonProduct = aSMmonProduct;
	}

	public void setSMmonProduct(String aSMmonProduct)
	{
		if (aSMmonProduct != null && !aSMmonProduct.equals(""))
		{
			Double tDouble = new Double(aSMmonProduct);
			double d = tDouble.doubleValue();
			sMmonProduct = d;
		}
	}

	public double getSMworkMon()
	{
		return sMworkMon;
	}

	public void setSMworkMon(double aSMworkMon)
	{
		sMworkMon = aSMworkMon;
	}

	public void setSMworkMon(String aSMworkMon)
	{
		if (aSMworkMon != null && !aSMworkMon.equals(""))
		{
			Double tDouble = new Double(aSMworkMon);
			double d = tDouble.doubleValue();
			sMworkMon = d;
		}
	}

	public double getMonPCount()
	{
		return monPCount;
	}

	public void setMonPCount(double aMonPCount)
	{
		monPCount = aMonPCount;
	}

	public void setMonPCount(String aMonPCount)
	{
		if (aMonPCount != null && !aMonPCount.equals(""))
		{
			Double tDouble = new Double(aMonPCount);
			double d = tDouble.doubleValue();
			monPCount = d;
		}
	}

	public double getWSMMonPCount()
	{
		return wSMMonPCount;
	}

	public void setWSMMonPCount(double aWSMMonPCount)
	{
		wSMMonPCount = aWSMMonPCount;
	}

	public void setWSMMonPCount(String aWSMMonPCount)
	{
		if (aWSMMonPCount != null && !aWSMMonPCount.equals(""))
		{
			Double tDouble = new Double(aWSMMonPCount);
			double d = tDouble.doubleValue();
			wSMMonPCount = d;
		}
	}

	public double getLPMonForSMMP()
	{
		return lPMonForSMMP;
	}

	public void setLPMonForSMMP(double aLPMonForSMMP)
	{
		lPMonForSMMP = aLPMonForSMMP;
	}

	public void setLPMonForSMMP(String aLPMonForSMMP)
	{
		if (aLPMonForSMMP != null && !aLPMonForSMMP.equals(""))
		{
			Double tDouble = new Double(aLPMonForSMMP);
			double d = tDouble.doubleValue();
			lPMonForSMMP = d;
		}
	}

	public double getLPMonForAMMP()
	{
		return lPMonForAMMP;
	}

	public void setLPMonForAMMP(double aLPMonForAMMP)
	{
		lPMonForAMMP = aLPMonForAMMP;
	}

	public void setLPMonForAMMP(String aLPMonForAMMP)
	{
		if (aLPMonForAMMP != null && !aLPMonForAMMP.equals(""))
		{
			Double tDouble = new Double(aLPMonForAMMP);
			double d = tDouble.doubleValue();
			lPMonForAMMP = d;
		}
	}

	public double getLPpolContinute()
	{
		return lPpolContinute;
	}

	public void setLPpolContinute(double aLPpolContinute)
	{
		lPpolContinute = aLPpolContinute;
	}

	public void setLPpolContinute(String aLPpolContinute)
	{
		if (aLPpolContinute != null && !aLPpolContinute.equals(""))
		{
			Double tDouble = new Double(aLPpolContinute);
			double d = tDouble.doubleValue();
			lPpolContinute = d;
		}
	}

	public double getMonEligFLPCnt()
	{
		return monEligFLPCnt;
	}

	public void setMonEligFLPCnt(double aMonEligFLPCnt)
	{
		monEligFLPCnt = aMonEligFLPCnt;
	}

	public void setMonEligFLPCnt(String aMonEligFLPCnt)
	{
		if (aMonEligFLPCnt != null && !aMonEligFLPCnt.equals(""))
		{
			Double tDouble = new Double(aMonEligFLPCnt);
			double d = tDouble.doubleValue();
			monEligFLPCnt = d;
		}
	}

	public double getTSRmonAFYP()
	{
		return tSRmonAFYP;
	}

	public void setTSRmonAFYP(double aTSRmonAFYP)
	{
		tSRmonAFYP = aTSRmonAFYP;
	}

	public void setTSRmonAFYP(String aTSRmonAFYP)
	{
		if (aTSRmonAFYP != null && !aTSRmonAFYP.equals(""))
		{
			Double tDouble = new Double(aTSRmonAFYP);
			double d = tDouble.doubleValue();
			tSRmonAFYP = d;
		}
	}

	public double getTSRmonDedAFYP()
	{
		return tSRmonDedAFYP;
	}

	public void setTSRmonDedAFYP(double aTSRmonDedAFYP)
	{
		tSRmonDedAFYP = aTSRmonDedAFYP;
	}

	public void setTSRmonDedAFYP(String aTSRmonDedAFYP)
	{
		if (aTSRmonDedAFYP != null && !aTSRmonDedAFYP.equals(""))
		{
			Double tDouble = new Double(aTSRmonDedAFYP);
			double d = tDouble.doubleValue();
			tSRmonDedAFYP = d;
		}
	}

	public double getTSRmonCompAFYP()
	{
		return tSRmonCompAFYP;
	}

	public void setTSRmonCompAFYP(double aTSRmonCompAFYP)
	{
		tSRmonCompAFYP = aTSRmonCompAFYP;
	}

	public void setTSRmonCompAFYP(String aTSRmonCompAFYP)
	{
		if (aTSRmonCompAFYP != null && !aTSRmonCompAFYP.equals(""))
		{
			Double tDouble = new Double(aTSRmonCompAFYP);
			double d = tDouble.doubleValue();
			tSRmonCompAFYP = d;
		}
	}

	public double getTSRMonWorkDays()
	{
		return tSRMonWorkDays;
	}

	public void setTSRMonWorkDays(double aTSRMonWorkDays)
	{
		tSRMonWorkDays = aTSRMonWorkDays;
	}

	public void setTSRMonWorkDays(String aTSRMonWorkDays)
	{
		if (aTSRMonWorkDays != null && !aTSRMonWorkDays.equals(""))
		{
			Double tDouble = new Double(aTSRMonWorkDays);
			double d = tDouble.doubleValue();
			tSRMonWorkDays = d;
		}
	}

	public double getMonManPower()
	{
		return monManPower;
	}

	public void setMonManPower(double aMonManPower)
	{
		monManPower = aMonManPower;
	}

	public void setMonManPower(String aMonManPower)
	{
		if (aMonManPower != null && !aMonManPower.equals(""))
		{
			Double tDouble = new Double(aMonManPower);
			double d = tDouble.doubleValue();
			monManPower = d;
		}
	}

	public double getMonManCount()
	{
		return monManCount;
	}

	public void setMonManCount(double aMonManCount)
	{
		monManCount = aMonManCount;
	}

	public void setMonManCount(String aMonManCount)
	{
		if (aMonManCount != null && !aMonManCount.equals(""))
		{
			Double tDouble = new Double(aMonManCount);
			double d = tDouble.doubleValue();
			monManCount = d;
		}
	}

	public double getMonSAFYPSum()
	{
		return monSAFYPSum;
	}

	public void setMonSAFYPSum(double aMonSAFYPSum)
	{
		monSAFYPSum = aMonSAFYPSum;
	}

	public void setMonSAFYPSum(String aMonSAFYPSum)
	{
		if (aMonSAFYPSum != null && !aMonSAFYPSum.equals(""))
		{
			Double tDouble = new Double(aMonSAFYPSum);
			double d = tDouble.doubleValue();
			monSAFYPSum = d;
		}
	}

	public double getMonTLGrpSAFYPSum()
	{
		return monTLGrpSAFYPSum;
	}

	public void setMonTLGrpSAFYPSum(double aMonTLGrpSAFYPSum)
	{
		monTLGrpSAFYPSum = aMonTLGrpSAFYPSum;
	}

	public void setMonTLGrpSAFYPSum(String aMonTLGrpSAFYPSum)
	{
		if (aMonTLGrpSAFYPSum != null && !aMonTLGrpSAFYPSum.equals(""))
		{
			Double tDouble = new Double(aMonTLGrpSAFYPSum);
			double d = tDouble.doubleValue();
			monTLGrpSAFYPSum = d;
		}
	}

	public double getIndYearNAFYC()
	{
		return indYearNAFYC;
	}

	public void setIndYearNAFYC(double aIndYearNAFYC)
	{
		indYearNAFYC = aIndYearNAFYC;
	}

	public void setIndYearNAFYC(String aIndYearNAFYC)
	{
		if (aIndYearNAFYC != null && !aIndYearNAFYC.equals(""))
		{
			Double tDouble = new Double(aIndYearNAFYC);
			double d = tDouble.doubleValue();
			indYearNAFYC = d;
		}
	}

	public double getB12IndEffectAFYC()
	{
		return b12IndEffectAFYC;
	}

	public void setB12IndEffectAFYC(double aB12IndEffectAFYC)
	{
		b12IndEffectAFYC = aB12IndEffectAFYC;
	}

	public void setB12IndEffectAFYC(String aB12IndEffectAFYC)
	{
		if (aB12IndEffectAFYC != null && !aB12IndEffectAFYC.equals(""))
		{
			Double tDouble = new Double(aB12IndEffectAFYC);
			double d = tDouble.doubleValue();
			b12IndEffectAFYC = d;
		}
	}

	public double getB12IndAllAFYC()
	{
		return b12IndAllAFYC;
	}

	public void setB12IndAllAFYC(double aB12IndAllAFYC)
	{
		b12IndAllAFYC = aB12IndAllAFYC;
	}

	public void setB12IndAllAFYC(String aB12IndAllAFYC)
	{
		if (aB12IndAllAFYC != null && !aB12IndAllAFYC.equals(""))
		{
			Double tDouble = new Double(aB12IndAllAFYC);
			double d = tDouble.doubleValue();
			b12IndAllAFYC = d;
		}
	}

	public double getB24IndEffectAFYC()
	{
		return b24IndEffectAFYC;
	}

	public void setB24IndEffectAFYC(double aB24IndEffectAFYC)
	{
		b24IndEffectAFYC = aB24IndEffectAFYC;
	}

	public void setB24IndEffectAFYC(String aB24IndEffectAFYC)
	{
		if (aB24IndEffectAFYC != null && !aB24IndEffectAFYC.equals(""))
		{
			Double tDouble = new Double(aB24IndEffectAFYC);
			double d = tDouble.doubleValue();
			b24IndEffectAFYC = d;
		}
	}

	public double getB24IndAllAFYC()
	{
		return b24IndAllAFYC;
	}

	public void setB24IndAllAFYC(double aB24IndAllAFYC)
	{
		b24IndAllAFYC = aB24IndAllAFYC;
	}

	public void setB24IndAllAFYC(String aB24IndAllAFYC)
	{
		if (aB24IndAllAFYC != null && !aB24IndAllAFYC.equals(""))
		{
			Double tDouble = new Double(aB24IndAllAFYC);
			double d = tDouble.doubleValue();
			b24IndAllAFYC = d;
		}
	}

	public double getIndQutFYC()
	{
		return indQutFYC;
	}

	public void setIndQutFYC(double aIndQutFYC)
	{
		indQutFYC = aIndQutFYC;
	}

	public void setIndQutFYC(String aIndQutFYC)
	{
		if (aIndQutFYC != null && !aIndQutFYC.equals(""))
		{
			Double tDouble = new Double(aIndQutFYC);
			double d = tDouble.doubleValue();
			indQutFYC = d;
		}
	}

	public double getLPproductivity()
	{
		return lPproductivity;
	}

	public void setLPproductivity(double aLPproductivity)
	{
		lPproductivity = aLPproductivity;
	}

	public void setLPproductivity(String aLPproductivity)
	{
		if (aLPproductivity != null && !aLPproductivity.equals(""))
		{
			Double tDouble = new Double(aLPproductivity);
			double d = tDouble.doubleValue();
			lPproductivity = d;
		}
	}

	public double getLPPPRate()
	{
		return lPPPRate;
	}

	public void setLPPPRate(double aLPPPRate)
	{
		lPPPRate = aLPPPRate;
	}

	public void setLPPPRate(String aLPPPRate)
	{
		if (aLPPPRate != null && !aLPPPRate.equals(""))
		{
			Double tDouble = new Double(aLPPPRate);
			double d = tDouble.doubleValue();
			lPPPRate = d;
		}
	}

	public double getLPPPBonus()
	{
		return lPPPBonus;
	}

	public void setLPPPBonus(double aLPPPBonus)
	{
		lPPPBonus = aLPPPBonus;
	}

	public void setLPPPBonus(String aLPPPBonus)
	{
		if (aLPPPBonus != null && !aLPPPBonus.equals(""))
		{
			Double tDouble = new Double(aLPPPBonus);
			double d = tDouble.doubleValue();
			lPPPBonus = d;
		}
	}

	public double getLPFincSubsidy()
	{
		return lPFincSubsidy;
	}

	public void setLPFincSubsidy(double aLPFincSubsidy)
	{
		lPFincSubsidy = aLPFincSubsidy;
	}

	public void setLPFincSubsidy(String aLPFincSubsidy)
	{
		if (aLPFincSubsidy != null && !aLPFincSubsidy.equals(""))
		{
			Double tDouble = new Double(aLPFincSubsidy);
			double d = tDouble.doubleValue();
			lPFincSubsidy = d;
		}
	}

	public double getSubsidyRate()
	{
		return subsidyRate;
	}

	public void setSubsidyRate(double aSubsidyRate)
	{
		subsidyRate = aSubsidyRate;
	}

	public void setSubsidyRate(String aSubsidyRate)
	{
		if (aSubsidyRate != null && !aSubsidyRate.equals(""))
		{
			Double tDouble = new Double(aSubsidyRate);
			double d = tDouble.doubleValue();
			subsidyRate = d;
		}
	}

	public double getB12TeamNAFYC()
	{
		return b12TeamNAFYC;
	}

	public void setB12TeamNAFYC(double aB12TeamNAFYC)
	{
		b12TeamNAFYC = aB12TeamNAFYC;
	}

	public void setB12TeamNAFYC(String aB12TeamNAFYC)
	{
		if (aB12TeamNAFYC != null && !aB12TeamNAFYC.equals(""))
		{
			Double tDouble = new Double(aB12TeamNAFYC);
			double d = tDouble.doubleValue();
			b12TeamNAFYC = d;
		}
	}

	public double getSMOverride()
	{
		return sMOverride;
	}

	public void setSMOverride(double aSMOverride)
	{
		sMOverride = aSMOverride;
	}

	public void setSMOverride(String aSMOverride)
	{
		if (aSMOverride != null && !aSMOverride.equals(""))
		{
			Double tDouble = new Double(aSMOverride);
			double d = tDouble.doubleValue();
			sMOverride = d;
		}
	}

	public double getTeamMonAvgPCount()
	{
		return teamMonAvgPCount;
	}

	public void setTeamMonAvgPCount(double aTeamMonAvgPCount)
	{
		teamMonAvgPCount = aTeamMonAvgPCount;
	}

	public void setTeamMonAvgPCount(String aTeamMonAvgPCount)
	{
		if (aTeamMonAvgPCount != null && !aTeamMonAvgPCount.equals(""))
		{
			Double tDouble = new Double(aTeamMonAvgPCount);
			double d = tDouble.doubleValue();
			teamMonAvgPCount = d;
		}
	}

	public double getSMBasicSalary()
	{
		return sMBasicSalary;
	}

	public void setSMBasicSalary(double aSMBasicSalary)
	{
		sMBasicSalary = aSMBasicSalary;
	}

	public void setSMBasicSalary(String aSMBasicSalary)
	{
		if (aSMBasicSalary != null && !aSMBasicSalary.equals(""))
		{
			Double tDouble = new Double(aSMBasicSalary);
			double d = tDouble.doubleValue();
			sMBasicSalary = d;
		}
	}

	public double getSMproductivity()
	{
		return sMproductivity;
	}

	public void setSMproductivity(double aSMproductivity)
	{
		sMproductivity = aSMproductivity;
	}

	public void setSMproductivity(String aSMproductivity)
	{
		if (aSMproductivity != null && !aSMproductivity.equals(""))
		{
			Double tDouble = new Double(aSMproductivity);
			double d = tDouble.doubleValue();
			sMproductivity = d;
		}
	}

	public double getSMpolContinute()
	{
		return sMpolContinute;
	}

	public void setSMpolContinute(double aSMpolContinute)
	{
		sMpolContinute = aSMpolContinute;
	}

	public void setSMpolContinute(String aSMpolContinute)
	{
		if (aSMpolContinute != null && !aSMpolContinute.equals(""))
		{
			Double tDouble = new Double(aSMpolContinute);
			double d = tDouble.doubleValue();
			sMpolContinute = d;
		}
	}

	public double getSMPPRate()
	{
		return sMPPRate;
	}

	public void setSMPPRate(double aSMPPRate)
	{
		sMPPRate = aSMPPRate;
	}

	public void setSMPPRate(String aSMPPRate)
	{
		if (aSMPPRate != null && !aSMPPRate.equals(""))
		{
			Double tDouble = new Double(aSMPPRate);
			double d = tDouble.doubleValue();
			sMPPRate = d;
		}
	}

	public double getSMPPBonus()
	{
		return sMPPBonus;
	}

	public void setSMPPBonus(double aSMPPBonus)
	{
		sMPPBonus = aSMPPBonus;
	}

	public void setSMPPBonus(String aSMPPBonus)
	{
		if (aSMPPBonus != null && !aSMPPBonus.equals(""))
		{
			Double tDouble = new Double(aSMPPBonus);
			double d = tDouble.doubleValue();
			sMPPBonus = d;
		}
	}

	public double getB24TeamEffectAFYC()
	{
		return b24TeamEffectAFYC;
	}

	public void setB24TeamEffectAFYC(double aB24TeamEffectAFYC)
	{
		b24TeamEffectAFYC = aB24TeamEffectAFYC;
	}

	public void setB24TeamEffectAFYC(String aB24TeamEffectAFYC)
	{
		if (aB24TeamEffectAFYC != null && !aB24TeamEffectAFYC.equals(""))
		{
			Double tDouble = new Double(aB24TeamEffectAFYC);
			double d = tDouble.doubleValue();
			b24TeamEffectAFYC = d;
		}
	}

	public double getB24TeamAllAFYC()
	{
		return b24TeamAllAFYC;
	}

	public void setB24TeamAllAFYC(double aB24TeamAllAFYC)
	{
		b24TeamAllAFYC = aB24TeamAllAFYC;
	}

	public void setB24TeamAllAFYC(String aB24TeamAllAFYC)
	{
		if (aB24TeamAllAFYC != null && !aB24TeamAllAFYC.equals(""))
		{
			Double tDouble = new Double(aB24TeamAllAFYC);
			double d = tDouble.doubleValue();
			b24TeamAllAFYC = d;
		}
	}

	public double getTeamQutPremSum()
	{
		return teamQutPremSum;
	}

	public void setTeamQutPremSum(double aTeamQutPremSum)
	{
		teamQutPremSum = aTeamQutPremSum;
	}

	public void setTeamQutPremSum(String aTeamQutPremSum)
	{
		if (aTeamQutPremSum != null && !aTeamQutPremSum.equals(""))
		{
			Double tDouble = new Double(aTeamQutPremSum);
			double d = tDouble.doubleValue();
			teamQutPremSum = d;
		}
	}

	public double getSMRRBonus()
	{
		return sMRRBonus;
	}

	public void setSMRRBonus(double aSMRRBonus)
	{
		sMRRBonus = aSMRRBonus;
	}

	public void setSMRRBonus(String aSMRRBonus)
	{
		if (aSMRRBonus != null && !aSMRRBonus.equals(""))
		{
			Double tDouble = new Double(aSMRRBonus);
			double d = tDouble.doubleValue();
			sMRRBonus = d;
		}
	}

	public double getSMManPowerDBonus()
	{
		return sMManPowerDBonus;
	}

	public void setSMManPowerDBonus(double aSMManPowerDBonus)
	{
		sMManPowerDBonus = aSMManPowerDBonus;
	}

	public void setSMManPowerDBonus(String aSMManPowerDBonus)
	{
		if (aSMManPowerDBonus != null && !aSMManPowerDBonus.equals(""))
		{
			Double tDouble = new Double(aSMManPowerDBonus);
			double d = tDouble.doubleValue();
			sMManPowerDBonus = d;
		}
	}

	public double getLPB12ForMPDBonus()
	{
		return lPB12ForMPDBonus;
	}

	public void setLPB12ForMPDBonus(double aLPB12ForMPDBonus)
	{
		lPB12ForMPDBonus = aLPB12ForMPDBonus;
	}

	public void setLPB12ForMPDBonus(String aLPB12ForMPDBonus)
	{
		if (aLPB12ForMPDBonus != null && !aLPB12ForMPDBonus.equals(""))
		{
			Double tDouble = new Double(aLPB12ForMPDBonus);
			double d = tDouble.doubleValue();
			lPB12ForMPDBonus = d;
		}
	}

	public double getSMUsualALLCSum()
	{
		return sMUsualALLCSum;
	}

	public void setSMUsualALLCSum(double aSMUsualALLCSum)
	{
		sMUsualALLCSum = aSMUsualALLCSum;
	}

	public void setSMUsualALLCSum(String aSMUsualALLCSum)
	{
		if (aSMUsualALLCSum != null && !aSMUsualALLCSum.equals(""))
		{
			Double tDouble = new Double(aSMUsualALLCSum);
			double d = tDouble.doubleValue();
			sMUsualALLCSum = d;
		}
	}

	public double getAMBasicSalary()
	{
		return aMBasicSalary;
	}

	public void setAMBasicSalary(double aAMBasicSalary)
	{
		aMBasicSalary = aAMBasicSalary;
	}

	public void setAMBasicSalary(String aAMBasicSalary)
	{
		if (aAMBasicSalary != null && !aAMBasicSalary.equals(""))
		{
			Double tDouble = new Double(aAMBasicSalary);
			double d = tDouble.doubleValue();
			aMBasicSalary = d;
		}
	}

	public double getAMproductivity()
	{
		return aMproductivity;
	}

	public void setAMproductivity(double aAMproductivity)
	{
		aMproductivity = aAMproductivity;
	}

	public void setAMproductivity(String aAMproductivity)
	{
		if (aAMproductivity != null && !aAMproductivity.equals(""))
		{
			Double tDouble = new Double(aAMproductivity);
			double d = tDouble.doubleValue();
			aMproductivity = d;
		}
	}

	public double getAMpolContinute()
	{
		return aMpolContinute;
	}

	public void setAMpolContinute(double aAMpolContinute)
	{
		aMpolContinute = aAMpolContinute;
	}

	public void setAMpolContinute(String aAMpolContinute)
	{
		if (aAMpolContinute != null && !aAMpolContinute.equals(""))
		{
			Double tDouble = new Double(aAMpolContinute);
			double d = tDouble.doubleValue();
			aMpolContinute = d;
		}
	}

	public double getAMPPRate()
	{
		return aMPPRate;
	}

	public void setAMPPRate(double aAMPPRate)
	{
		aMPPRate = aAMPPRate;
	}

	public void setAMPPRate(String aAMPPRate)
	{
		if (aAMPPRate != null && !aAMPPRate.equals(""))
		{
			Double tDouble = new Double(aAMPPRate);
			double d = tDouble.doubleValue();
			aMPPRate = d;
		}
	}

	public double getAMPPBonus()
	{
		return aMPPBonus;
	}

	public void setAMPPBonus(double aAMPPBonus)
	{
		aMPPBonus = aAMPPBonus;
	}

	public void setAMPPBonus(String aAMPPBonus)
	{
		if (aAMPPBonus != null && !aAMPPBonus.equals(""))
		{
			Double tDouble = new Double(aAMPPBonus);
			double d = tDouble.doubleValue();
			aMPPBonus = d;
		}
	}

	public double getB12DepNAFYC()
	{
		return b12DepNAFYC;
	}

	public void setB12DepNAFYC(double aB12DepNAFYC)
	{
		b12DepNAFYC = aB12DepNAFYC;
	}

	public void setB12DepNAFYC(String aB12DepNAFYC)
	{
		if (aB12DepNAFYC != null && !aB12DepNAFYC.equals(""))
		{
			Double tDouble = new Double(aB12DepNAFYC);
			double d = tDouble.doubleValue();
			b12DepNAFYC = d;
		}
	}

	public double getAMOverride()
	{
		return aMOverride;
	}

	public void setAMOverride(double aAMOverride)
	{
		aMOverride = aAMOverride;
	}

	public void setAMOverride(String aAMOverride)
	{
		if (aAMOverride != null && !aAMOverride.equals(""))
		{
			Double tDouble = new Double(aAMOverride);
			double d = tDouble.doubleValue();
			aMOverride = d;
		}
	}

	public double getDepMonAvgPCount()
	{
		return depMonAvgPCount;
	}

	public void setDepMonAvgPCount(double aDepMonAvgPCount)
	{
		depMonAvgPCount = aDepMonAvgPCount;
	}

	public void setDepMonAvgPCount(String aDepMonAvgPCount)
	{
		if (aDepMonAvgPCount != null && !aDepMonAvgPCount.equals(""))
		{
			Double tDouble = new Double(aDepMonAvgPCount);
			double d = tDouble.doubleValue();
			depMonAvgPCount = d;
		}
	}

	public double getDepQutPremSum()
	{
		return depQutPremSum;
	}

	public void setDepQutPremSum(double aDepQutPremSum)
	{
		depQutPremSum = aDepQutPremSum;
	}

	public void setDepQutPremSum(String aDepQutPremSum)
	{
		if (aDepQutPremSum != null && !aDepQutPremSum.equals(""))
		{
			Double tDouble = new Double(aDepQutPremSum);
			double d = tDouble.doubleValue();
			depQutPremSum = d;
		}
	}

	public double getAMRRBonus()
	{
		return aMRRBonus;
	}

	public void setAMRRBonus(double aAMRRBonus)
	{
		aMRRBonus = aAMRRBonus;
	}

	public void setAMRRBonus(String aAMRRBonus)
	{
		if (aAMRRBonus != null && !aAMRRBonus.equals(""))
		{
			Double tDouble = new Double(aAMRRBonus);
			double d = tDouble.doubleValue();
			aMRRBonus = d;
		}
	}

	public double getAMManPowerDBonus()
	{
		return aMManPowerDBonus;
	}

	public void setAMManPowerDBonus(double aAMManPowerDBonus)
	{
		aMManPowerDBonus = aAMManPowerDBonus;
	}

	public void setAMManPowerDBonus(String aAMManPowerDBonus)
	{
		if (aAMManPowerDBonus != null && !aAMManPowerDBonus.equals(""))
		{
			Double tDouble = new Double(aAMManPowerDBonus);
			double d = tDouble.doubleValue();
			aMManPowerDBonus = d;
		}
	}

	public double getProductGrowth()
	{
		return productGrowth;
	}

	public void setProductGrowth(double aProductGrowth)
	{
		productGrowth = aProductGrowth;
	}

	public void setProductGrowth(String aProductGrowth)
	{
		if (aProductGrowth != null && !aProductGrowth.equals(""))
		{
			Double tDouble = new Double(aProductGrowth);
			double d = tDouble.doubleValue();
			productGrowth = d;
		}
	}

	public double getDepQuaFYCSum()
	{
		return depQuaFYCSum;
	}

	public void setDepQuaFYCSum(double aDepQuaFYCSum)
	{
		depQuaFYCSum = aDepQuaFYCSum;
	}

	public void setDepQuaFYCSum(String aDepQuaFYCSum)
	{
		if (aDepQuaFYCSum != null && !aDepQuaFYCSum.equals(""))
		{
			Double tDouble = new Double(aDepQuaFYCSum);
			double d = tDouble.doubleValue();
			depQuaFYCSum = d;
		}
	}

	public double getAMLiability()
	{
		return aMLiability;
	}

	public void setAMLiability(double aAMLiability)
	{
		aMLiability = aAMLiability;
	}

	public void setAMLiability(String aAMLiability)
	{
		if (aAMLiability != null && !aAMLiability.equals(""))
		{
			Double tDouble = new Double(aAMLiability);
			double d = tDouble.doubleValue();
			aMLiability = d;
		}
	}

	public double getReviOpen()
	{
		return reviOpen;
	}

	public void setReviOpen(double aReviOpen)
	{
		reviOpen = aReviOpen;
	}

	public void setReviOpen(String aReviOpen)
	{
		if (aReviOpen != null && !aReviOpen.equals(""))
		{
			Double tDouble = new Double(aReviOpen);
			double d = tDouble.doubleValue();
			reviOpen = d;
		}
	}

	public double getT1()
	{
		return t1;
	}

	public void setT1(double aT1)
	{
		t1 = aT1;
	}

	public void setT1(String aT1)
	{
		if (aT1 != null && !aT1.equals(""))
		{
			Double tDouble = new Double(aT1);
			double d = tDouble.doubleValue();
			t1 = d;
		}
	}

	public double getT2()
	{
		return t2;
	}

	public void setT2(double aT2)
	{
		t2 = aT2;
	}

	public void setT2(String aT2)
	{
		if (aT2 != null && !aT2.equals(""))
		{
			Double tDouble = new Double(aT2);
			double d = tDouble.doubleValue();
			t2 = d;
		}
	}

	public double getT3()
	{
		return t3;
	}

	public void setT3(double aT3)
	{
		t3 = aT3;
	}

	public void setT3(String aT3)
	{
		if (aT3 != null && !aT3.equals(""))
		{
			Double tDouble = new Double(aT3);
			double d = tDouble.doubleValue();
			t3 = d;
		}
	}

	public double getT4()
	{
		return t4;
	}

	public void setT4(double aT4)
	{
		t4 = aT4;
	}

	public void setT4(String aT4)
	{
		if (aT4 != null && !aT4.equals(""))
		{
			Double tDouble = new Double(aT4);
			double d = tDouble.doubleValue();
			t4 = d;
		}
	}

	public double getT5()
	{
		return t5;
	}

	public void setT5(double aT5)
	{
		t5 = aT5;
	}

	public void setT5(String aT5)
	{
		if (aT5 != null && !aT5.equals(""))
		{
			Double tDouble = new Double(aT5);
			double d = tDouble.doubleValue();
			t5 = d;
		}
	}

	public double getT6()
	{
		return t6;
	}

	public void setT6(double aT6)
	{
		t6 = aT6;
	}

	public void setT6(String aT6)
	{
		if (aT6 != null && !aT6.equals(""))
		{
			Double tDouble = new Double(aT6);
			double d = tDouble.doubleValue();
			t6 = d;
		}
	}

	public double getT7()
	{
		return t7;
	}

	public void setT7(double aT7)
	{
		t7 = aT7;
	}

	public void setT7(String aT7)
	{
		if (aT7 != null && !aT7.equals(""))
		{
			Double tDouble = new Double(aT7);
			double d = tDouble.doubleValue();
			t7 = d;
		}
	}

	public double getT8()
	{
		return t8;
	}

	public void setT8(double aT8)
	{
		t8 = aT8;
	}

	public void setT8(String aT8)
	{
		if (aT8 != null && !aT8.equals(""))
		{
			Double tDouble = new Double(aT8);
			double d = tDouble.doubleValue();
			t8 = d;
		}
	}

	public double getT9()
	{
		return t9;
	}

	public void setT9(double aT9)
	{
		t9 = aT9;
	}

	public void setT9(String aT9)
	{
		if (aT9 != null && !aT9.equals(""))
		{
			Double tDouble = new Double(aT9);
			double d = tDouble.doubleValue();
			t9 = d;
		}
	}

	public double getT10()
	{
		return t10;
	}

	public void setT10(double aT10)
	{
		t10 = aT10;
	}

	public void setT10(String aT10)
	{
		if (aT10 != null && !aT10.equals(""))
		{
			Double tDouble = new Double(aT10);
			double d = tDouble.doubleValue();
			t10 = d;
		}
	}

	public double getT11()
	{
		return t11;
	}

	public void setT11(double aT11)
	{
		t11 = aT11;
	}

	public void setT11(String aT11)
	{
		if (aT11 != null && !aT11.equals(""))
		{
			Double tDouble = new Double(aT11);
			double d = tDouble.doubleValue();
			t11 = d;
		}
	}

	public double getT12()
	{
		return t12;
	}

	public void setT12(double aT12)
	{
		t12 = aT12;
	}

	public void setT12(String aT12)
	{
		if (aT12 != null && !aT12.equals(""))
		{
			Double tDouble = new Double(aT12);
			double d = tDouble.doubleValue();
			t12 = d;
		}
	}

	public double getT13()
	{
		return t13;
	}

	public void setT13(double aT13)
	{
		t13 = aT13;
	}

	public void setT13(String aT13)
	{
		if (aT13 != null && !aT13.equals(""))
		{
			Double tDouble = new Double(aT13);
			double d = tDouble.doubleValue();
			t13 = d;
		}
	}

	public double getT14()
	{
		return t14;
	}

	public void setT14(double aT14)
	{
		t14 = aT14;
	}

	public void setT14(String aT14)
	{
		if (aT14 != null && !aT14.equals(""))
		{
			Double tDouble = new Double(aT14);
			double d = tDouble.doubleValue();
			t14 = d;
		}
	}

	public double getT15()
	{
		return t15;
	}

	public void setT15(double aT15)
	{
		t15 = aT15;
	}

	public void setT15(String aT15)
	{
		if (aT15 != null && !aT15.equals(""))
		{
			Double tDouble = new Double(aT15);
			double d = tDouble.doubleValue();
			t15 = d;
		}
	}

	public double getT16()
	{
		return t16;
	}

	public void setT16(double aT16)
	{
		t16 = aT16;
	}

	public void setT16(String aT16)
	{
		if (aT16 != null && !aT16.equals(""))
		{
			Double tDouble = new Double(aT16);
			double d = tDouble.doubleValue();
			t16 = d;
		}
	}

	public double getT17()
	{
		return t17;
	}

	public void setT17(double aT17)
	{
		t17 = aT17;
	}

	public void setT17(String aT17)
	{
		if (aT17 != null && !aT17.equals(""))
		{
			Double tDouble = new Double(aT17);
			double d = tDouble.doubleValue();
			t17 = d;
		}
	}

	public double getT18()
	{
		return t18;
	}

	public void setT18(double aT18)
	{
		t18 = aT18;
	}

	public void setT18(String aT18)
	{
		if (aT18 != null && !aT18.equals(""))
		{
			Double tDouble = new Double(aT18);
			double d = tDouble.doubleValue();
			t18 = d;
		}
	}

	public double getT20()
	{
		return t20;
	}

	public void setT20(double aT20)
	{
		t20 = aT20;
	}

	public void setT20(String aT20)
	{
		if (aT20 != null && !aT20.equals(""))
		{
			Double tDouble = new Double(aT20);
			double d = tDouble.doubleValue();
			t20 = d;
		}
	}

	public double getT19()
	{
		return t19;
	}

	public void setT19(double aT19)
	{
		t19 = aT19;
	}

	public void setT19(String aT19)
	{
		if (aT19 != null && !aT19.equals(""))
		{
			Double tDouble = new Double(aT19);
			double d = tDouble.doubleValue();
			t19 = d;
		}
	}

	public double getMonthIndex()
	{
		return monthIndex;
	}

	public void setMonthIndex(double aMonthIndex)
	{
		monthIndex = aMonthIndex;
	}

	public void setMonthIndex(String aMonthIndex)
	{
		if (aMonthIndex != null && !aMonthIndex.equals(""))
		{
			Double tDouble = new Double(aMonthIndex);
			double d = tDouble.doubleValue();
			monthIndex = d;
		}
	}

	public double getTMonthIndex()
	{
		return tMonthIndex;
	}

	public void setTMonthIndex(double aTMonthIndex)
	{
		tMonthIndex = aTMonthIndex;
	}

	public void setTMonthIndex(String aTMonthIndex)
	{
		if (aTMonthIndex != null && !aTMonthIndex.equals(""))
		{
			Double tDouble = new Double(aTMonthIndex);
			double d = tDouble.doubleValue();
			tMonthIndex = d;
		}
	}

	public double getASumIndex()
	{
		return aSumIndex;
	}

	public void setASumIndex(double aASumIndex)
	{
		aSumIndex = aASumIndex;
	}

	public void setASumIndex(String aASumIndex)
	{
		if (aASumIndex != null && !aASumIndex.equals(""))
		{
			Double tDouble = new Double(aASumIndex);
			double d = tDouble.doubleValue();
			aSumIndex = d;
		}
	}

	public double getWSMMonthEligible()
	{
		return wSMMonthEligible;
	}

	public void setWSMMonthEligible(double aWSMMonthEligible)
	{
		wSMMonthEligible = aWSMMonthEligible;
	}

	public void setWSMMonthEligible(String aWSMMonthEligible)
	{
		if (aWSMMonthEligible != null && !aWSMMonthEligible.equals(""))
		{
			Double tDouble = new Double(aWSMMonthEligible);
			double d = tDouble.doubleValue();
			wSMMonthEligible = d;
		}
	}

	public double getLPQuaPCount()
	{
		return lPQuaPCount;
	}

	public void setLPQuaPCount(double aLPQuaPCount)
	{
		lPQuaPCount = aLPQuaPCount;
	}

	public void setLPQuaPCount(String aLPQuaPCount)
	{
		if (aLPQuaPCount != null && !aLPQuaPCount.equals(""))
		{
			Double tDouble = new Double(aLPQuaPCount);
			double d = tDouble.doubleValue();
			lPQuaPCount = d;
		}
	}

	public double getLPQuaFYCSum()
	{
		return lPQuaFYCSum;
	}

	public void setLPQuaFYCSum(double aLPQuaFYCSum)
	{
		lPQuaFYCSum = aLPQuaFYCSum;
	}

	public void setLPQuaFYCSum(String aLPQuaFYCSum)
	{
		if (aLPQuaFYCSum != null && !aLPQuaFYCSum.equals(""))
		{
			Double tDouble = new Double(aLPQuaFYCSum);
			double d = tDouble.doubleValue();
			lPQuaFYCSum = d;
		}
	}

	public double getB12LPPCount()
	{
		return b12LPPCount;
	}

	public void setB12LPPCount(double aB12LPPCount)
	{
		b12LPPCount = aB12LPPCount;
	}

	public void setB12LPPCount(String aB12LPPCount)
	{
		if (aB12LPPCount != null && !aB12LPPCount.equals(""))
		{
			Double tDouble = new Double(aB12LPPCount);
			double d = tDouble.doubleValue();
			b12LPPCount = d;
		}
	}

	public double getB12LPNAFYCSum()
	{
		return b12LPNAFYCSum;
	}

	public void setB12LPNAFYCSum(double aB12LPNAFYCSum)
	{
		b12LPNAFYCSum = aB12LPNAFYCSum;
	}

	public void setB12LPNAFYCSum(String aB12LPNAFYCSum)
	{
		if (aB12LPNAFYCSum != null && !aB12LPNAFYCSum.equals(""))
		{
			Double tDouble = new Double(aB12LPNAFYCSum);
			double d = tDouble.doubleValue();
			b12LPNAFYCSum = d;
		}
	}

	public double getWSMMonAFYC()
	{
		return wSMMonAFYC;
	}

	public void setWSMMonAFYC(double aWSMMonAFYC)
	{
		wSMMonAFYC = aWSMMonAFYC;
	}

	public void setWSMMonAFYC(String aWSMMonAFYC)
	{
		if (aWSMMonAFYC != null && !aWSMMonAFYC.equals(""))
		{
			Double tDouble = new Double(aWSMMonAFYC);
			double d = tDouble.doubleValue();
			wSMMonAFYC = d;
		}
	}

	public double getWSMTwoMonAFYC()
	{
		return wSMTwoMonAFYC;
	}

	public void setWSMTwoMonAFYC(double aWSMTwoMonAFYC)
	{
		wSMTwoMonAFYC = aWSMTwoMonAFYC;
	}

	public void setWSMTwoMonAFYC(String aWSMTwoMonAFYC)
	{
		if (aWSMTwoMonAFYC != null && !aWSMTwoMonAFYC.equals(""))
		{
			Double tDouble = new Double(aWSMTwoMonAFYC);
			double d = tDouble.doubleValue();
			wSMTwoMonAFYC = d;
		}
	}

	public double getWSMB6AFYC()
	{
		return wSMB6AFYC;
	}

	public void setWSMB6AFYC(double aWSMB6AFYC)
	{
		wSMB6AFYC = aWSMB6AFYC;
	}

	public void setWSMB6AFYC(String aWSMB6AFYC)
	{
		if (aWSMB6AFYC != null && !aWSMB6AFYC.equals(""))
		{
			Double tDouble = new Double(aWSMB6AFYC);
			double d = tDouble.doubleValue();
			wSMB6AFYC = d;
		}
	}

	public double getWSMB6PCount()
	{
		return wSMB6PCount;
	}

	public void setWSMB6PCount(double aWSMB6PCount)
	{
		wSMB6PCount = aWSMB6PCount;
	}

	public void setWSMB6PCount(String aWSMB6PCount)
	{
		if (aWSMB6PCount != null && !aWSMB6PCount.equals(""))
		{
			Double tDouble = new Double(aWSMB6PCount);
			double d = tDouble.doubleValue();
			wSMB6PCount = d;
		}
	}

	public double getNetLiveLPCount()
	{
		return netLiveLPCount;
	}

	public void setNetLiveLPCount(double aNetLiveLPCount)
	{
		netLiveLPCount = aNetLiveLPCount;
	}

	public void setNetLiveLPCount(String aNetLiveLPCount)
	{
		if (aNetLiveLPCount != null && !aNetLiveLPCount.equals(""))
		{
			Double tDouble = new Double(aNetLiveLPCount);
			double d = tDouble.doubleValue();
			netLiveLPCount = d;
		}
	}

	public double getNetComLPCount()
	{
		return netComLPCount;
	}

	public void setNetComLPCount(double aNetComLPCount)
	{
		netComLPCount = aNetComLPCount;
	}

	public void setNetComLPCount(String aNetComLPCount)
	{
		if (aNetComLPCount != null && !aNetComLPCount.equals(""))
		{
			Double tDouble = new Double(aNetComLPCount);
			double d = tDouble.doubleValue();
			netComLPCount = d;
		}
	}

	public double getWSMTwoMonPCount()
	{
		return wSMTwoMonPCount;
	}

	public void setWSMTwoMonPCount(double aWSMTwoMonPCount)
	{
		wSMTwoMonPCount = aWSMTwoMonPCount;
	}

	public void setWSMTwoMonPCount(String aWSMTwoMonPCount)
	{
		if (aWSMTwoMonPCount != null && !aWSMTwoMonPCount.equals(""))
		{
			Double tDouble = new Double(aWSMTwoMonPCount);
			double d = tDouble.doubleValue();
			wSMTwoMonPCount = d;
		}
	}

	public double getLPAllNAFYC()
	{
		return lPAllNAFYC;
	}

	public void setLPAllNAFYC(double aLPAllNAFYC)
	{
		lPAllNAFYC = aLPAllNAFYC;
	}

	public void setLPAllNAFYC(String aLPAllNAFYC)
	{
		if (aLPAllNAFYC != null && !aLPAllNAFYC.equals(""))
		{
			Double tDouble = new Double(aLPAllNAFYC);
			double d = tDouble.doubleValue();
			lPAllNAFYC = d;
		}
	}

	public double getLPAllPCount()
	{
		return lPAllPCount;
	}

	public void setLPAllPCount(double aLPAllPCount)
	{
		lPAllPCount = aLPAllPCount;
	}

	public void setLPAllPCount(String aLPAllPCount)
	{
		if (aLPAllPCount != null && !aLPAllPCount.equals(""))
		{
			Double tDouble = new Double(aLPAllPCount);
			double d = tDouble.doubleValue();
			lPAllPCount = d;
		}
	}

	public double getMonPerSAFYP()
	{
		return monPerSAFYP;
	}

	public void setMonPerSAFYP(double aMonPerSAFYP)
	{
		monPerSAFYP = aMonPerSAFYP;
	}

	public void setMonPerSAFYP(String aMonPerSAFYP)
	{
		if (aMonPerSAFYP != null && !aMonPerSAFYP.equals(""))
		{
			Double tDouble = new Double(aMonPerSAFYP);
			double d = tDouble.doubleValue();
			monPerSAFYP = d;
		}
	}

	public double getTSRThrMonSAFYP()
	{
		return tSRThrMonSAFYP;
	}

	public void setTSRThrMonSAFYP(double aTSRThrMonSAFYP)
	{
		tSRThrMonSAFYP = aTSRThrMonSAFYP;
	}

	public void setTSRThrMonSAFYP(String aTSRThrMonSAFYP)
	{
		if (aTSRThrMonSAFYP != null && !aTSRThrMonSAFYP.equals(""))
		{
			Double tDouble = new Double(aTSRThrMonSAFYP);
			double d = tDouble.doubleValue();
			tSRThrMonSAFYP = d;
		}
	}

	public double getTLThrMonPerSAFYP()
	{
		return tLThrMonPerSAFYP;
	}

	public void setTLThrMonPerSAFYP(double aTLThrMonPerSAFYP)
	{
		tLThrMonPerSAFYP = aTLThrMonPerSAFYP;
	}

	public void setTLThrMonPerSAFYP(String aTLThrMonPerSAFYP)
	{
		if (aTLThrMonPerSAFYP != null && !aTLThrMonPerSAFYP.equals(""))
		{
			Double tDouble = new Double(aTLThrMonPerSAFYP);
			double d = tDouble.doubleValue();
			tLThrMonPerSAFYP = d;
		}
	}

	public double getMonSubsistCnt()
	{
		return monSubsistCnt;
	}

	public void setMonSubsistCnt(double aMonSubsistCnt)
	{
		monSubsistCnt = aMonSubsistCnt;
	}

	public void setMonSubsistCnt(String aMonSubsistCnt)
	{
		if (aMonSubsistCnt != null && !aMonSubsistCnt.equals(""))
		{
			Double tDouble = new Double(aMonSubsistCnt);
			double d = tDouble.doubleValue();
			monSubsistCnt = d;
		}
	}

	public double getThrMonSubsistCnt()
	{
		return thrMonSubsistCnt;
	}

	public void setThrMonSubsistCnt(double aThrMonSubsistCnt)
	{
		thrMonSubsistCnt = aThrMonSubsistCnt;
	}

	public void setThrMonSubsistCnt(String aThrMonSubsistCnt)
	{
		if (aThrMonSubsistCnt != null && !aThrMonSubsistCnt.equals(""))
		{
			Double tDouble = new Double(aThrMonSubsistCnt);
			double d = tDouble.doubleValue();
			thrMonSubsistCnt = d;
		}
	}

	public String getState()
	{
		return state;
	}

	public void setState(String aState)
	{
		state = aState;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String aOperator)
	{
		operator = aOperator;
	}

	public String getMakeDate()
	{
		if (makeDate != null)
			return fDate.getString(makeDate);
		else
			return null;
	}

	public void setMakeDate(Date aMakeDate)
	{
		makeDate = aMakeDate;
	}

	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals(""))
			makeDate = fDate.getDate(aMakeDate);
		else
			makeDate = null;
	}

	public String getMakeTime()
	{
		return makeTime;
	}

	public void setMakeTime(String aMakeTime)
	{
		makeTime = aMakeTime;
	}

	public String getModifyDate()
	{
		if (modifyDate != null)
			return fDate.getString(modifyDate);
		else
			return null;
	}

	public void setModifyDate(Date aModifyDate)
	{
		modifyDate = aModifyDate;
	}

	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals(""))
			modifyDate = fDate.getDate(aModifyDate);
		else
			modifyDate = null;
	}

	public String getModifyTime()
	{
		return modifyTime;
	}

	public void setModifyTime(String aModifyTime)
	{
		modifyTime = aModifyTime;
	}

	public String getAssessMonth()
	{
		return assessMonth;
	}

	public void setAssessMonth(String aAssessMonth)
	{
		assessMonth = aAssessMonth;
	}

	public String getBranchAttr()
	{
		return branchAttr;
	}

	public void setBranchAttr(String aBranchAttr)
	{
		branchAttr = aBranchAttr;
	}

	public String getAgentGrade()
	{
		return agentGrade;
	}

	public void setAgentGrade(String aAgentGrade)
	{
		agentGrade = aAgentGrade;
	}

	public double getClubPromBonus()
	{
		return clubPromBonus;
	}

	public void setClubPromBonus(double aClubPromBonus)
	{
		clubPromBonus = aClubPromBonus;
	}

	public void setClubPromBonus(String aClubPromBonus)
	{
		if (aClubPromBonus != null && !aClubPromBonus.equals(""))
		{
			Double tDouble = new Double(aClubPromBonus);
			double d = tDouble.doubleValue();
			clubPromBonus = d;
		}
	}

	public double getClubGradeBonus()
	{
		return clubGradeBonus;
	}

	public void setClubGradeBonus(double aClubGradeBonus)
	{
		clubGradeBonus = aClubGradeBonus;
	}

	public void setClubGradeBonus(String aClubGradeBonus)
	{
		if (aClubGradeBonus != null && !aClubGradeBonus.equals(""))
		{
			Double tDouble = new Double(aClubGradeBonus);
			double d = tDouble.doubleValue();
			clubGradeBonus = d;
		}
	}

	public double getClubAssisBonus()
	{
		return clubAssisBonus;
	}

	public void setClubAssisBonus(double aClubAssisBonus)
	{
		clubAssisBonus = aClubAssisBonus;
	}

	public void setClubAssisBonus(String aClubAssisBonus)
	{
		if (aClubAssisBonus != null && !aClubAssisBonus.equals(""))
		{
			Double tDouble = new Double(aClubAssisBonus);
			double d = tDouble.doubleValue();
			clubAssisBonus = d;
		}
	}

	public double getClubSpecBonus()
	{
		return clubSpecBonus;
	}

	public void setClubSpecBonus(double aClubSpecBonus)
	{
		clubSpecBonus = aClubSpecBonus;
	}

	public void setClubSpecBonus(String aClubSpecBonus)
	{
		if (aClubSpecBonus != null && !aClubSpecBonus.equals(""))
		{
			Double tDouble = new Double(aClubSpecBonus);
			double d = tDouble.doubleValue();
			clubSpecBonus = d;
		}
	}

	public double getAdddedMoney()
	{
		return adddedMoney;
	}

	public void setAdddedMoney(double aAdddedMoney)
	{
		adddedMoney = aAdddedMoney;
	}

	public void setAdddedMoney(String aAdddedMoney)
	{
		if (aAdddedMoney != null && !aAdddedMoney.equals(""))
		{
			Double tDouble = new Double(aAdddedMoney);
			double d = tDouble.doubleValue();
			adddedMoney = d;
		}
	}

	public double getLastMoney()
	{
		return lastMoney;
	}

	public void setLastMoney(double aLastMoney)
	{
		lastMoney = aLastMoney;
	}

	public void setLastMoney(String aLastMoney)
	{
		if (aLastMoney != null && !aLastMoney.equals(""))
		{
			Double tDouble = new Double(aLastMoney);
			double d = tDouble.doubleValue();
			lastMoney = d;
		}
	}

	public double getShouldMoney()
	{
		return shouldMoney;
	}

	public void setShouldMoney(double aShouldMoney)
	{
		shouldMoney = aShouldMoney;
	}

	public void setShouldMoney(String aShouldMoney)
	{
		if (aShouldMoney != null && !aShouldMoney.equals(""))
		{
			Double tDouble = new Double(aShouldMoney);
			double d = tDouble.doubleValue();
			shouldMoney = d;
		}
	}

	public double getBusinessTax()
	{
		return businessTax;
	}

	public void setBusinessTax(double aBusinessTax)
	{
		businessTax = aBusinessTax;
	}

	public void setBusinessTax(String aBusinessTax)
	{
		if (aBusinessTax != null && !aBusinessTax.equals(""))
		{
			Double tDouble = new Double(aBusinessTax);
			double d = tDouble.doubleValue();
			businessTax = d;
		}
	}

	public double getEduTax()
	{
		return eduTax;
	}

	public void setEduTax(double aEduTax)
	{
		eduTax = aEduTax;
	}

	public void setEduTax(String aEduTax)
	{
		if (aEduTax != null && !aEduTax.equals(""))
		{
			Double tDouble = new Double(aEduTax);
			double d = tDouble.doubleValue();
			eduTax = d;
		}
	}

	public double getBuildTax()
	{
		return buildTax;
	}

	public void setBuildTax(double aBuildTax)
	{
		buildTax = aBuildTax;
	}

	public void setBuildTax(String aBuildTax)
	{
		if (aBuildTax != null && !aBuildTax.equals(""))
		{
			Double tDouble = new Double(aBuildTax);
			double d = tDouble.doubleValue();
			buildTax = d;
		}
	}

	public double getBusiCharge()
	{
		return busiCharge;
	}

	public void setBusiCharge(double aBusiCharge)
	{
		busiCharge = aBusiCharge;
	}

	public void setBusiCharge(String aBusiCharge)
	{
		if (aBusiCharge != null && !aBusiCharge.equals(""))
		{
			Double tDouble = new Double(aBusiCharge);
			double d = tDouble.doubleValue();
			busiCharge = d;
		}
	}

	public double getIncomeTax()
	{
		return incomeTax;
	}

	public void setIncomeTax(double aIncomeTax)
	{
		incomeTax = aIncomeTax;
	}

	public void setIncomeTax(String aIncomeTax)
	{
		if (aIncomeTax != null && !aIncomeTax.equals(""))
		{
			Double tDouble = new Double(aIncomeTax);
			double d = tDouble.doubleValue();
			incomeTax = d;
		}
	}

	public double getSumMoney()
	{
		return sumMoney;
	}

	public void setSumMoney(double aSumMoney)
	{
		sumMoney = aSumMoney;
	}

	public void setSumMoney(String aSumMoney)
	{
		if (aSumMoney != null && !aSumMoney.equals(""))
		{
			Double tDouble = new Double(aSumMoney);
			double d = tDouble.doubleValue();
			sumMoney = d;
		}
	}

	public double getAfterTaxMoney()
	{
		return afterTaxMoney;
	}

	public void setAfterTaxMoney(double aAfterTaxMoney)
	{
		afterTaxMoney = aAfterTaxMoney;
	}

	public void setAfterTaxMoney(String aAfterTaxMoney)
	{
		if (aAfterTaxMoney != null && !aAfterTaxMoney.equals(""))
		{
			Double tDouble = new Double(aAfterTaxMoney);
			double d = tDouble.doubleValue();
			afterTaxMoney = d;
		}
	}

	public double getOperInCome()
	{
		return operInCome;
	}

	public void setOperInCome(double aOperInCome)
	{
		operInCome = aOperInCome;
	}

	public void setOperInCome(String aOperInCome)
	{
		if (aOperInCome != null && !aOperInCome.equals(""))
		{
			Double tDouble = new Double(aOperInCome);
			double d = tDouble.doubleValue();
			operInCome = d;
		}
	}

	public double getT21()
	{
		return t21;
	}

	public void setT21(double aT21)
	{
		t21 = aT21;
	}

	public void setT21(String aT21)
	{
		if (aT21 != null && !aT21.equals(""))
		{
			Double tDouble = new Double(aT21);
			double d = tDouble.doubleValue();
			t21 = d;
		}
	}

	public double getT22()
	{
		return t22;
	}

	public void setT22(double aT22)
	{
		t22 = aT22;
	}

	public void setT22(String aT22)
	{
		if (aT22 != null && !aT22.equals(""))
		{
			Double tDouble = new Double(aT22);
			double d = tDouble.doubleValue();
			t22 = d;
		}
	}

	public double getT23()
	{
		return t23;
	}

	public void setT23(double aT23)
	{
		t23 = aT23;
	}

	public void setT23(String aT23)
	{
		if (aT23 != null && !aT23.equals(""))
		{
			Double tDouble = new Double(aT23);
			double d = tDouble.doubleValue();
			t23 = d;
		}
	}

	public double getT24()
	{
		return t24;
	}

	public void setT24(double aT24)
	{
		t24 = aT24;
	}

	public void setT24(String aT24)
	{
		if (aT24 != null && !aT24.equals(""))
		{
			Double tDouble = new Double(aT24);
			double d = tDouble.doubleValue();
			t24 = d;
		}
	}

	public double getT25()
	{
		return t25;
	}

	public void setT25(double aT25)
	{
		t25 = aT25;
	}

	public void setT25(String aT25)
	{
		if (aT25 != null && !aT25.equals(""))
		{
			Double tDouble = new Double(aT25);
			double d = tDouble.doubleValue();
			t25 = d;
		}
	}

	public void setSchema(LAIndexInfoSchema aLAIndexInfoSchema)
	{
		indexCalNo = aLAIndexInfoSchema.getIndexCalNo();
		indexType = aLAIndexInfoSchema.getIndexType();
		agentCode = aLAIndexInfoSchema.getAgentCode();
		agentGroup = aLAIndexInfoSchema.getAgentGroup();
		manageCom = aLAIndexInfoSchema.getManageCom();
		startDate = fDate.getDate(aLAIndexInfoSchema.getStartDate());
		startEnd = fDate.getDate(aLAIndexInfoSchema.getStartEnd());
		quaBgnMark = aLAIndexInfoSchema.getQuaBgnMark();
		serverMonths = aLAIndexInfoSchema.getServerMonths();
		postMonths = aLAIndexInfoSchema.getPostMonths();
		indMonthFYC = aLAIndexInfoSchema.getIndMonthFYC();
		indMonthSYC = aLAIndexInfoSchema.getIndMonthSYC();
		indMonSignFYC = aLAIndexInfoSchema.getIndMonSignFYC();
		indMonSignAFYC = aLAIndexInfoSchema.getIndMonSignAFYC();
		indMonSignNAFYC = aLAIndexInfoSchema.getIndMonSignNAFYC();
		grpMonSignNAFYC = aLAIndexInfoSchema.getGrpMonSignNAFYC();
		monPolCnt = aLAIndexInfoSchema.getMonPolCnt();
		montCustCnt = aLAIndexInfoSchema.getMontCustCnt();
		indMonPCount = aLAIndexInfoSchema.getIndMonPCount();
		sMmonPolContin = aLAIndexInfoSchema.getSMmonPolContin();
		sMmonProduct = aLAIndexInfoSchema.getSMmonProduct();
		sMworkMon = aLAIndexInfoSchema.getSMworkMon();
		monPCount = aLAIndexInfoSchema.getMonPCount();
		wSMMonPCount = aLAIndexInfoSchema.getWSMMonPCount();
		lPMonForSMMP = aLAIndexInfoSchema.getLPMonForSMMP();
		lPMonForAMMP = aLAIndexInfoSchema.getLPMonForAMMP();
		lPpolContinute = aLAIndexInfoSchema.getLPpolContinute();
		monEligFLPCnt = aLAIndexInfoSchema.getMonEligFLPCnt();
		tSRmonAFYP = aLAIndexInfoSchema.getTSRmonAFYP();
		tSRmonDedAFYP = aLAIndexInfoSchema.getTSRmonDedAFYP();
		tSRmonCompAFYP = aLAIndexInfoSchema.getTSRmonCompAFYP();
		tSRMonWorkDays = aLAIndexInfoSchema.getTSRMonWorkDays();
		monManPower = aLAIndexInfoSchema.getMonManPower();
		monManCount = aLAIndexInfoSchema.getMonManCount();
		monSAFYPSum = aLAIndexInfoSchema.getMonSAFYPSum();
		monTLGrpSAFYPSum = aLAIndexInfoSchema.getMonTLGrpSAFYPSum();
		indYearNAFYC = aLAIndexInfoSchema.getIndYearNAFYC();
		b12IndEffectAFYC = aLAIndexInfoSchema.getB12IndEffectAFYC();
		b12IndAllAFYC = aLAIndexInfoSchema.getB12IndAllAFYC();
		b24IndEffectAFYC = aLAIndexInfoSchema.getB24IndEffectAFYC();
		b24IndAllAFYC = aLAIndexInfoSchema.getB24IndAllAFYC();
		indQutFYC = aLAIndexInfoSchema.getIndQutFYC();
		lPproductivity = aLAIndexInfoSchema.getLPproductivity();
		lPPPRate = aLAIndexInfoSchema.getLPPPRate();
		lPPPBonus = aLAIndexInfoSchema.getLPPPBonus();
		lPFincSubsidy = aLAIndexInfoSchema.getLPFincSubsidy();
		subsidyRate = aLAIndexInfoSchema.getSubsidyRate();
		b12TeamNAFYC = aLAIndexInfoSchema.getB12TeamNAFYC();
		sMOverride = aLAIndexInfoSchema.getSMOverride();
		teamMonAvgPCount = aLAIndexInfoSchema.getTeamMonAvgPCount();
		sMBasicSalary = aLAIndexInfoSchema.getSMBasicSalary();
		sMproductivity = aLAIndexInfoSchema.getSMproductivity();
		sMpolContinute = aLAIndexInfoSchema.getSMpolContinute();
		sMPPRate = aLAIndexInfoSchema.getSMPPRate();
		sMPPBonus = aLAIndexInfoSchema.getSMPPBonus();
		b24TeamEffectAFYC = aLAIndexInfoSchema.getB24TeamEffectAFYC();
		b24TeamAllAFYC = aLAIndexInfoSchema.getB24TeamAllAFYC();
		teamQutPremSum = aLAIndexInfoSchema.getTeamQutPremSum();
		sMRRBonus = aLAIndexInfoSchema.getSMRRBonus();
		sMManPowerDBonus = aLAIndexInfoSchema.getSMManPowerDBonus();
		lPB12ForMPDBonus = aLAIndexInfoSchema.getLPB12ForMPDBonus();
		sMUsualALLCSum = aLAIndexInfoSchema.getSMUsualALLCSum();
		aMBasicSalary = aLAIndexInfoSchema.getAMBasicSalary();
		aMproductivity = aLAIndexInfoSchema.getAMproductivity();
		aMpolContinute = aLAIndexInfoSchema.getAMpolContinute();
		aMPPRate = aLAIndexInfoSchema.getAMPPRate();
		aMPPBonus = aLAIndexInfoSchema.getAMPPBonus();
		b12DepNAFYC = aLAIndexInfoSchema.getB12DepNAFYC();
		aMOverride = aLAIndexInfoSchema.getAMOverride();
		depMonAvgPCount = aLAIndexInfoSchema.getDepMonAvgPCount();
		depQutPremSum = aLAIndexInfoSchema.getDepQutPremSum();
		aMRRBonus = aLAIndexInfoSchema.getAMRRBonus();
		aMManPowerDBonus = aLAIndexInfoSchema.getAMManPowerDBonus();
		productGrowth = aLAIndexInfoSchema.getProductGrowth();
		depQuaFYCSum = aLAIndexInfoSchema.getDepQuaFYCSum();
		aMLiability = aLAIndexInfoSchema.getAMLiability();
		reviOpen = aLAIndexInfoSchema.getReviOpen();
		t1 = aLAIndexInfoSchema.getT1();
		t2 = aLAIndexInfoSchema.getT2();
		t3 = aLAIndexInfoSchema.getT3();
		t4 = aLAIndexInfoSchema.getT4();
		t5 = aLAIndexInfoSchema.getT5();
		t6 = aLAIndexInfoSchema.getT6();
		t7 = aLAIndexInfoSchema.getT7();
		t8 = aLAIndexInfoSchema.getT8();
		t9 = aLAIndexInfoSchema.getT9();
		t10 = aLAIndexInfoSchema.getT10();
		t11 = aLAIndexInfoSchema.getT11();
		t12 = aLAIndexInfoSchema.getT12();
		t13 = aLAIndexInfoSchema.getT13();
		t14 = aLAIndexInfoSchema.getT14();
		t15 = aLAIndexInfoSchema.getT15();
		t16 = aLAIndexInfoSchema.getT16();
		t17 = aLAIndexInfoSchema.getT17();
		t18 = aLAIndexInfoSchema.getT18();
		t20 = aLAIndexInfoSchema.getT20();
		t19 = aLAIndexInfoSchema.getT19();
		monthIndex = aLAIndexInfoSchema.getMonthIndex();
		tMonthIndex = aLAIndexInfoSchema.getTMonthIndex();
		aSumIndex = aLAIndexInfoSchema.getASumIndex();
		wSMMonthEligible = aLAIndexInfoSchema.getWSMMonthEligible();
		lPQuaPCount = aLAIndexInfoSchema.getLPQuaPCount();
		lPQuaFYCSum = aLAIndexInfoSchema.getLPQuaFYCSum();
		b12LPPCount = aLAIndexInfoSchema.getB12LPPCount();
		b12LPNAFYCSum = aLAIndexInfoSchema.getB12LPNAFYCSum();
		wSMMonAFYC = aLAIndexInfoSchema.getWSMMonAFYC();
		wSMTwoMonAFYC = aLAIndexInfoSchema.getWSMTwoMonAFYC();
		wSMB6AFYC = aLAIndexInfoSchema.getWSMB6AFYC();
		wSMB6PCount = aLAIndexInfoSchema.getWSMB6PCount();
		netLiveLPCount = aLAIndexInfoSchema.getNetLiveLPCount();
		netComLPCount = aLAIndexInfoSchema.getNetComLPCount();
		wSMTwoMonPCount = aLAIndexInfoSchema.getWSMTwoMonPCount();
		lPAllNAFYC = aLAIndexInfoSchema.getLPAllNAFYC();
		lPAllPCount = aLAIndexInfoSchema.getLPAllPCount();
		monPerSAFYP = aLAIndexInfoSchema.getMonPerSAFYP();
		tSRThrMonSAFYP = aLAIndexInfoSchema.getTSRThrMonSAFYP();
		tLThrMonPerSAFYP = aLAIndexInfoSchema.getTLThrMonPerSAFYP();
		monSubsistCnt = aLAIndexInfoSchema.getMonSubsistCnt();
		thrMonSubsistCnt = aLAIndexInfoSchema.getThrMonSubsistCnt();
		state = aLAIndexInfoSchema.getState();
		operator = aLAIndexInfoSchema.getOperator();
		makeDate = fDate.getDate(aLAIndexInfoSchema.getMakeDate());
		makeTime = aLAIndexInfoSchema.getMakeTime();
		modifyDate = fDate.getDate(aLAIndexInfoSchema.getModifyDate());
		modifyTime = aLAIndexInfoSchema.getModifyTime();
		assessMonth = aLAIndexInfoSchema.getAssessMonth();
		branchAttr = aLAIndexInfoSchema.getBranchAttr();
		agentGrade = aLAIndexInfoSchema.getAgentGrade();
		clubPromBonus = aLAIndexInfoSchema.getClubPromBonus();
		clubGradeBonus = aLAIndexInfoSchema.getClubGradeBonus();
		clubAssisBonus = aLAIndexInfoSchema.getClubAssisBonus();
		clubSpecBonus = aLAIndexInfoSchema.getClubSpecBonus();
		adddedMoney = aLAIndexInfoSchema.getAdddedMoney();
		lastMoney = aLAIndexInfoSchema.getLastMoney();
		shouldMoney = aLAIndexInfoSchema.getShouldMoney();
		businessTax = aLAIndexInfoSchema.getBusinessTax();
		eduTax = aLAIndexInfoSchema.getEduTax();
		buildTax = aLAIndexInfoSchema.getBuildTax();
		busiCharge = aLAIndexInfoSchema.getBusiCharge();
		incomeTax = aLAIndexInfoSchema.getIncomeTax();
		sumMoney = aLAIndexInfoSchema.getSumMoney();
		afterTaxMoney = aLAIndexInfoSchema.getAfterTaxMoney();
		operInCome = aLAIndexInfoSchema.getOperInCome();
		t21 = aLAIndexInfoSchema.getT21();
		t22 = aLAIndexInfoSchema.getT22();
		t23 = aLAIndexInfoSchema.getT23();
		t24 = aLAIndexInfoSchema.getT24();
		t25 = aLAIndexInfoSchema.getT25();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("IndexCalNo") == null)
				indexCalNo = null;
			else
				indexCalNo = rs.getString("IndexCalNo").trim();
			if (rs.getString("IndexType") == null)
				indexType = null;
			else
				indexType = rs.getString("IndexType").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("AgentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("AgentGroup").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			startDate = rs.getDate("StartDate");
			startEnd = rs.getDate("StartEnd");
			quaBgnMark = rs.getInt("QuaBgnMark");
			serverMonths = rs.getInt("ServerMonths");
			postMonths = rs.getInt("PostMonths");
			indMonthFYC = rs.getDouble("IndMonthFYC");
			indMonthSYC = rs.getDouble("IndMonthSYC");
			indMonSignFYC = rs.getDouble("IndMonSignFYC");
			indMonSignAFYC = rs.getDouble("IndMonSignAFYC");
			indMonSignNAFYC = rs.getDouble("IndMonSignNAFYC");
			grpMonSignNAFYC = rs.getDouble("GrpMonSignNAFYC");
			monPolCnt = rs.getDouble("MonPolCnt");
			montCustCnt = rs.getDouble("MontCustCnt");
			indMonPCount = rs.getDouble("IndMonPCount");
			sMmonPolContin = rs.getDouble("SMmonPolContin");
			sMmonProduct = rs.getDouble("SMmonProduct");
			sMworkMon = rs.getDouble("SMworkMon");
			monPCount = rs.getDouble("MonPCount");
			wSMMonPCount = rs.getDouble("WSMMonPCount");
			lPMonForSMMP = rs.getDouble("LPMonForSMMP");
			lPMonForAMMP = rs.getDouble("LPMonForAMMP");
			lPpolContinute = rs.getDouble("LPpolContinute");
			monEligFLPCnt = rs.getDouble("MonEligFLPCnt");
			tSRmonAFYP = rs.getDouble("TSRmonAFYP");
			tSRmonDedAFYP = rs.getDouble("TSRmonDedAFYP");
			tSRmonCompAFYP = rs.getDouble("TSRmonCompAFYP");
			tSRMonWorkDays = rs.getDouble("TSRMonWorkDays");
			monManPower = rs.getDouble("MonManPower");
			monManCount = rs.getDouble("MonManCount");
			monSAFYPSum = rs.getDouble("MonSAFYPSum");
			monTLGrpSAFYPSum = rs.getDouble("MonTLGrpSAFYPSum");
			indYearNAFYC = rs.getDouble("IndYearNAFYC");
			b12IndEffectAFYC = rs.getDouble("B12IndEffectAFYC");
			b12IndAllAFYC = rs.getDouble("B12IndAllAFYC");
			b24IndEffectAFYC = rs.getDouble("B24IndEffectAFYC");
			b24IndAllAFYC = rs.getDouble("B24IndAllAFYC");
			indQutFYC = rs.getDouble("IndQutFYC");
			lPproductivity = rs.getDouble("LPproductivity");
			lPPPRate = rs.getDouble("LPPPRate");
			lPPPBonus = rs.getDouble("LPPPBonus");
			lPFincSubsidy = rs.getDouble("LPFincSubsidy");
			subsidyRate = rs.getDouble("SubsidyRate");
			b12TeamNAFYC = rs.getDouble("B12TeamNAFYC");
			sMOverride = rs.getDouble("SMOverride");
			teamMonAvgPCount = rs.getDouble("TeamMonAvgPCount");
			sMBasicSalary = rs.getDouble("SMBasicSalary");
			sMproductivity = rs.getDouble("SMproductivity");
			sMpolContinute = rs.getDouble("SMpolContinute");
			sMPPRate = rs.getDouble("SMPPRate");
			sMPPBonus = rs.getDouble("SMPPBonus");
			b24TeamEffectAFYC = rs.getDouble("B24TeamEffectAFYC");
			b24TeamAllAFYC = rs.getDouble("B24TeamAllAFYC");
			teamQutPremSum = rs.getDouble("TeamQutPremSum");
			sMRRBonus = rs.getDouble("SMRRBonus");
			sMManPowerDBonus = rs.getDouble("SMManPowerDBonus");
			lPB12ForMPDBonus = rs.getDouble("LPB12ForMPDBonus");
			sMUsualALLCSum = rs.getDouble("SMUsualALLCSum");
			aMBasicSalary = rs.getDouble("AMBasicSalary");
			aMproductivity = rs.getDouble("AMproductivity");
			aMpolContinute = rs.getDouble("AMpolContinute");
			aMPPRate = rs.getDouble("AMPPRate");
			aMPPBonus = rs.getDouble("AMPPBonus");
			b12DepNAFYC = rs.getDouble("B12DepNAFYC");
			aMOverride = rs.getDouble("AMOverride");
			depMonAvgPCount = rs.getDouble("DepMonAvgPCount");
			depQutPremSum = rs.getDouble("DepQutPremSum");
			aMRRBonus = rs.getDouble("AMRRBonus");
			aMManPowerDBonus = rs.getDouble("AMManPowerDBonus");
			productGrowth = rs.getDouble("ProductGrowth");
			depQuaFYCSum = rs.getDouble("DepQuaFYCSum");
			aMLiability = rs.getDouble("AMLiability");
			reviOpen = rs.getDouble("ReviOpen");
			t1 = rs.getDouble("T1");
			t2 = rs.getDouble("T2");
			t3 = rs.getDouble("T3");
			t4 = rs.getDouble("T4");
			t5 = rs.getDouble("T5");
			t6 = rs.getDouble("T6");
			t7 = rs.getDouble("T7");
			t8 = rs.getDouble("T8");
			t9 = rs.getDouble("T9");
			t10 = rs.getDouble("T10");
			t11 = rs.getDouble("T11");
			t12 = rs.getDouble("T12");
			t13 = rs.getDouble("T13");
			t14 = rs.getDouble("T14");
			t15 = rs.getDouble("T15");
			t16 = rs.getDouble("T16");
			t17 = rs.getDouble("T17");
			t18 = rs.getDouble("T18");
			t20 = rs.getDouble("T20");
			t19 = rs.getDouble("T19");
			monthIndex = rs.getDouble("MonthIndex");
			tMonthIndex = rs.getDouble("TMonthIndex");
			aSumIndex = rs.getDouble("ASumIndex");
			wSMMonthEligible = rs.getDouble("WSMMonthEligible");
			lPQuaPCount = rs.getDouble("LPQuaPCount");
			lPQuaFYCSum = rs.getDouble("LPQuaFYCSum");
			b12LPPCount = rs.getDouble("B12LPPCount");
			b12LPNAFYCSum = rs.getDouble("B12LPNAFYCSum");
			wSMMonAFYC = rs.getDouble("WSMMonAFYC");
			wSMTwoMonAFYC = rs.getDouble("WSMTwoMonAFYC");
			wSMB6AFYC = rs.getDouble("WSMB6AFYC");
			wSMB6PCount = rs.getDouble("WSMB6PCount");
			netLiveLPCount = rs.getDouble("NetLiveLPCount");
			netComLPCount = rs.getDouble("NetComLPCount");
			wSMTwoMonPCount = rs.getDouble("WSMTwoMonPCount");
			lPAllNAFYC = rs.getDouble("LPAllNAFYC");
			lPAllPCount = rs.getDouble("LPAllPCount");
			monPerSAFYP = rs.getDouble("MonPerSAFYP");
			tSRThrMonSAFYP = rs.getDouble("TSRThrMonSAFYP");
			tLThrMonPerSAFYP = rs.getDouble("TLThrMonPerSAFYP");
			monSubsistCnt = rs.getDouble("MonSubsistCnt");
			thrMonSubsistCnt = rs.getDouble("ThrMonSubsistCnt");
			if (rs.getString("State") == null)
				state = null;
			else
				state = rs.getString("State").trim();
			if (rs.getString("Operator") == null)
				operator = null;
			else
				operator = rs.getString("Operator").trim();
			makeDate = rs.getDate("MakeDate");
			if (rs.getString("MakeTime") == null)
				makeTime = null;
			else
				makeTime = rs.getString("MakeTime").trim();
			modifyDate = rs.getDate("ModifyDate");
			if (rs.getString("ModifyTime") == null)
				modifyTime = null;
			else
				modifyTime = rs.getString("ModifyTime").trim();
			if (rs.getString("AssessMonth") == null)
				assessMonth = null;
			else
				assessMonth = rs.getString("AssessMonth").trim();
			if (rs.getString("BranchAttr") == null)
				branchAttr = null;
			else
				branchAttr = rs.getString("BranchAttr").trim();
			if (rs.getString("AgentGrade") == null)
				agentGrade = null;
			else
				agentGrade = rs.getString("AgentGrade").trim();
			clubPromBonus = rs.getDouble("ClubPromBonus");
			clubGradeBonus = rs.getDouble("ClubGradeBonus");
			clubAssisBonus = rs.getDouble("ClubAssisBonus");
			clubSpecBonus = rs.getDouble("ClubSpecBonus");
			adddedMoney = rs.getDouble("AdddedMoney");
			lastMoney = rs.getDouble("LastMoney");
			shouldMoney = rs.getDouble("ShouldMoney");
			businessTax = rs.getDouble("BusinessTax");
			eduTax = rs.getDouble("EduTax");
			buildTax = rs.getDouble("BuildTax");
			busiCharge = rs.getDouble("BusiCharge");
			incomeTax = rs.getDouble("IncomeTax");
			sumMoney = rs.getDouble("SumMoney");
			afterTaxMoney = rs.getDouble("AfterTaxMoney");
			operInCome = rs.getDouble("OperInCome");
			t21 = rs.getDouble("T21");
			t22 = rs.getDouble("T22");
			t23 = rs.getDouble("T23");
			t24 = rs.getDouble("T24");
			t25 = rs.getDouble("T25");
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LAIndexInfo表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LAIndexInfoSchema getSchema()
	{
		LAIndexInfoSchema aLAIndexInfoSchema = new LAIndexInfoSchema();
		aLAIndexInfoSchema.setSchema(this);
		return aLAIndexInfoSchema;
	}

	public LAIndexInfoDB getDB()
	{
		LAIndexInfoDB aDBOper = new LAIndexInfoDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(indexCalNo));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(indexType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startEnd)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(quaBgnMark));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(serverMonths));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(postMonths));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indMonthFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indMonthSYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indMonSignFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indMonSignAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indMonSignNAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(grpMonSignNAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monPolCnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(montCustCnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indMonPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMmonPolContin));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMmonProduct));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMworkMon));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMMonPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPMonForSMMP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPMonForAMMP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPpolContinute));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monEligFLPCnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tSRmonAFYP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tSRmonDedAFYP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tSRmonCompAFYP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tSRMonWorkDays));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monManPower));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monManCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monSAFYPSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monTLGrpSAFYPSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indYearNAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b12IndEffectAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b12IndAllAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b24IndEffectAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b24IndAllAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(indQutFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPproductivity));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPPPRate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPPPBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPFincSubsidy));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(subsidyRate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b12TeamNAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMOverride));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(teamMonAvgPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMBasicSalary));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMproductivity));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMpolContinute));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMPPRate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMPPBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b24TeamEffectAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b24TeamAllAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(teamQutPremSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMRRBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMManPowerDBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPB12ForMPDBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sMUsualALLCSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMBasicSalary));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMproductivity));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMpolContinute));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMPPRate));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMPPBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b12DepNAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMOverride));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(depMonAvgPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(depQutPremSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMRRBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMManPowerDBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(productGrowth));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(depQuaFYCSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aMLiability));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(reviOpen));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t1));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t2));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t3));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t4));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t5));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t6));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t7));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t8));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t9));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t10));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t11));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t12));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t13));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t14));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t15));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t16));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t17));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t18));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t20));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t19));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monthIndex));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tMonthIndex));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(aSumIndex));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMMonthEligible));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPQuaPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPQuaFYCSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b12LPPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(b12LPNAFYCSum));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMMonAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMTwoMonAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMB6AFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMB6PCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(netLiveLPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(netComLPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(wSMTwoMonPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPAllNAFYC));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lPAllPCount));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monPerSAFYP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tSRThrMonSAFYP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(tLThrMonPerSAFYP));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(monSubsistCnt));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(thrMonSubsistCnt));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(state));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(operator));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(makeDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(makeTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(modifyDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyTime));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(assessMonth));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchAttr));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(clubPromBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(clubGradeBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(clubAssisBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(clubSpecBonus));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(adddedMoney));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(lastMoney));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(shouldMoney));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(businessTax));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(eduTax));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(buildTax));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(busiCharge));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(incomeTax));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(sumMoney));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(afterTaxMoney));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(operInCome));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t21));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t22));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t23));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t24));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t25));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			indexCalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			indexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			startEnd = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			quaBgnMark = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|")))).intValue();
			serverMonths = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
			postMonths = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			indMonthFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|")))).doubleValue();
			indMonthSYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 12, "|")))).doubleValue();
			indMonSignFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 13, "|")))).doubleValue();
			indMonSignAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 14, "|")))).doubleValue();
			indMonSignNAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).doubleValue();
			grpMonSignNAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|")))).doubleValue();
			monPolCnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|")))).doubleValue();
			montCustCnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).doubleValue();
			indMonPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|")))).doubleValue();
			sMmonPolContin = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).doubleValue();
			sMmonProduct = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 21, "|")))).doubleValue();
			sMworkMon = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 22, "|")))).doubleValue();
			monPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 23, "|")))).doubleValue();
			wSMMonPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|")))).doubleValue();
			lPMonForSMMP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 25, "|")))).doubleValue();
			lPMonForAMMP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 26, "|")))).doubleValue();
			lPpolContinute = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 27, "|")))).doubleValue();
			monEligFLPCnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|")))).doubleValue();
			tSRmonAFYP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|")))).doubleValue();
			tSRmonDedAFYP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|")))).doubleValue();
			tSRmonCompAFYP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|")))).doubleValue();
			tSRMonWorkDays = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).doubleValue();
			monManPower = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|")))).doubleValue();
			monManCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|")))).doubleValue();
			monSAFYPSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|")))).doubleValue();
			monTLGrpSAFYPSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|")))).doubleValue();
			indYearNAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|")))).doubleValue();
			b12IndEffectAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|")))).doubleValue();
			b12IndAllAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|")))).doubleValue();
			b24IndEffectAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 40, "|")))).doubleValue();
			b24IndAllAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 41, "|")))).doubleValue();
			indQutFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 42, "|")))).doubleValue();
			lPproductivity = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 43, "|")))).doubleValue();
			lPPPRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 44, "|")))).doubleValue();
			lPPPBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|")))).doubleValue();
			lPFincSubsidy = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 46, "|")))).doubleValue();
			subsidyRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|")))).doubleValue();
			b12TeamNAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 48, "|")))).doubleValue();
			sMOverride = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|")))).doubleValue();
			teamMonAvgPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 50, "|")))).doubleValue();
			sMBasicSalary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|")))).doubleValue();
			sMproductivity = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 52, "|")))).doubleValue();
			sMpolContinute = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|")))).doubleValue();
			sMPPRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 54, "|")))).doubleValue();
			sMPPBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|")))).doubleValue();
			b24TeamEffectAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|")))).doubleValue();
			b24TeamAllAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).doubleValue();
			teamQutPremSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).doubleValue();
			sMRRBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).doubleValue();
			sMManPowerDBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).doubleValue();
			lPB12ForMPDBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|")))).doubleValue();
			sMUsualALLCSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|")))).doubleValue();
			aMBasicSalary = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|")))).doubleValue();
			aMproductivity = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 64, "|")))).doubleValue();
			aMpolContinute = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|")))).doubleValue();
			aMPPRate = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|")))).doubleValue();
			aMPPBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|")))).doubleValue();
			b12DepNAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|")))).doubleValue();
			aMOverride = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|")))).doubleValue();
			depMonAvgPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|")))).doubleValue();
			depQutPremSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|")))).doubleValue();
			aMRRBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|")))).doubleValue();
			aMManPowerDBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|")))).doubleValue();
			productGrowth = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 74, "|")))).doubleValue();
			depQuaFYCSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 75, "|")))).doubleValue();
			aMLiability = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 76, "|")))).doubleValue();
			reviOpen = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 77, "|")))).doubleValue();
			t1 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 78, "|")))).doubleValue();
			t2 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 79, "|")))).doubleValue();
			t3 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 80, "|")))).doubleValue();
			t4 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 81, "|")))).doubleValue();
			t5 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 82, "|")))).doubleValue();
			t6 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 83, "|")))).doubleValue();
			t7 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 84, "|")))).doubleValue();
			t8 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 85, "|")))).doubleValue();
			t9 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 86, "|")))).doubleValue();
			t10 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 87, "|")))).doubleValue();
			t11 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 88, "|")))).doubleValue();
			t12 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 89, "|")))).doubleValue();
			t13 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 90, "|")))).doubleValue();
			t14 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 91, "|")))).doubleValue();
			t15 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 92, "|")))).doubleValue();
			t16 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 93, "|")))).doubleValue();
			t17 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 94, "|")))).doubleValue();
			t18 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 95, "|")))).doubleValue();
			t20 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 96, "|")))).doubleValue();
			t19 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 97, "|")))).doubleValue();
			monthIndex = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 98, "|")))).doubleValue();
			tMonthIndex = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 99, "|")))).doubleValue();
			aSumIndex = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 100, "|")))).doubleValue();
			wSMMonthEligible = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 101, "|")))).doubleValue();
			lPQuaPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 102, "|")))).doubleValue();
			lPQuaFYCSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 103, "|")))).doubleValue();
			b12LPPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 104, "|")))).doubleValue();
			b12LPNAFYCSum = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 105, "|")))).doubleValue();
			wSMMonAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 106, "|")))).doubleValue();
			wSMTwoMonAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 107, "|")))).doubleValue();
			wSMB6AFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 108, "|")))).doubleValue();
			wSMB6PCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 109, "|")))).doubleValue();
			netLiveLPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 110, "|")))).doubleValue();
			netComLPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 111, "|")))).doubleValue();
			wSMTwoMonPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 112, "|")))).doubleValue();
			lPAllNAFYC = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 113, "|")))).doubleValue();
			lPAllPCount = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 114, "|")))).doubleValue();
			monPerSAFYP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 115, "|")))).doubleValue();
			tSRThrMonSAFYP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 116, "|")))).doubleValue();
			tLThrMonPerSAFYP = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 117, "|")))).doubleValue();
			monSubsistCnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 118, "|")))).doubleValue();
			thrMonSubsistCnt = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 119, "|")))).doubleValue();
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 120, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 121, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 122, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 123, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 124, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 125, "|");
			assessMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 126, "|");
			branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 127, "|");
			agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 128, "|");
			clubPromBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 129, "|")))).doubleValue();
			clubGradeBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 130, "|")))).doubleValue();
			clubAssisBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 131, "|")))).doubleValue();
			clubSpecBonus = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 132, "|")))).doubleValue();
			adddedMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 133, "|")))).doubleValue();
			lastMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 134, "|")))).doubleValue();
			shouldMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 135, "|")))).doubleValue();
			businessTax = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 136, "|")))).doubleValue();
			eduTax = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 137, "|")))).doubleValue();
			buildTax = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 138, "|")))).doubleValue();
			busiCharge = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 139, "|")))).doubleValue();
			incomeTax = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 140, "|")))).doubleValue();
			sumMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 141, "|")))).doubleValue();
			afterTaxMoney = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 142, "|")))).doubleValue();
			operInCome = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 143, "|")))).doubleValue();
			t21 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 144, "|")))).doubleValue();
			t22 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 145, "|")))).doubleValue();
			t23 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 146, "|")))).doubleValue();
			t24 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 147, "|")))).doubleValue();
			t25 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 148, "|")))).doubleValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("indexCalNo"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indexCalNo));
		if (FCode.equalsIgnoreCase("indexType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indexType));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("startEnd"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
		if (FCode.equalsIgnoreCase("quaBgnMark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(quaBgnMark));
		if (FCode.equalsIgnoreCase("serverMonths"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serverMonths));
		if (FCode.equalsIgnoreCase("postMonths"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(postMonths));
		if (FCode.equalsIgnoreCase("indMonthFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indMonthFYC));
		if (FCode.equalsIgnoreCase("indMonthSYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indMonthSYC));
		if (FCode.equalsIgnoreCase("indMonSignFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indMonSignFYC));
		if (FCode.equalsIgnoreCase("indMonSignAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indMonSignAFYC));
		if (FCode.equalsIgnoreCase("indMonSignNAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indMonSignNAFYC));
		if (FCode.equalsIgnoreCase("grpMonSignNAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(grpMonSignNAFYC));
		if (FCode.equalsIgnoreCase("monPolCnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monPolCnt));
		if (FCode.equalsIgnoreCase("montCustCnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(montCustCnt));
		if (FCode.equalsIgnoreCase("indMonPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indMonPCount));
		if (FCode.equalsIgnoreCase("sMmonPolContin"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMmonPolContin));
		if (FCode.equalsIgnoreCase("sMmonProduct"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMmonProduct));
		if (FCode.equalsIgnoreCase("sMworkMon"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMworkMon));
		if (FCode.equalsIgnoreCase("monPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monPCount));
		if (FCode.equalsIgnoreCase("wSMMonPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMMonPCount));
		if (FCode.equalsIgnoreCase("lPMonForSMMP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPMonForSMMP));
		if (FCode.equalsIgnoreCase("lPMonForAMMP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPMonForAMMP));
		if (FCode.equalsIgnoreCase("lPpolContinute"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPpolContinute));
		if (FCode.equalsIgnoreCase("monEligFLPCnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monEligFLPCnt));
		if (FCode.equalsIgnoreCase("tSRmonAFYP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tSRmonAFYP));
		if (FCode.equalsIgnoreCase("tSRmonDedAFYP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tSRmonDedAFYP));
		if (FCode.equalsIgnoreCase("tSRmonCompAFYP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tSRmonCompAFYP));
		if (FCode.equalsIgnoreCase("tSRMonWorkDays"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tSRMonWorkDays));
		if (FCode.equalsIgnoreCase("monManPower"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monManPower));
		if (FCode.equalsIgnoreCase("monManCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monManCount));
		if (FCode.equalsIgnoreCase("monSAFYPSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monSAFYPSum));
		if (FCode.equalsIgnoreCase("monTLGrpSAFYPSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monTLGrpSAFYPSum));
		if (FCode.equalsIgnoreCase("indYearNAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indYearNAFYC));
		if (FCode.equalsIgnoreCase("b12IndEffectAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b12IndEffectAFYC));
		if (FCode.equalsIgnoreCase("b12IndAllAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b12IndAllAFYC));
		if (FCode.equalsIgnoreCase("b24IndEffectAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b24IndEffectAFYC));
		if (FCode.equalsIgnoreCase("b24IndAllAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b24IndAllAFYC));
		if (FCode.equalsIgnoreCase("indQutFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(indQutFYC));
		if (FCode.equalsIgnoreCase("lPproductivity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPproductivity));
		if (FCode.equalsIgnoreCase("lPPPRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPPPRate));
		if (FCode.equalsIgnoreCase("lPPPBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPPPBonus));
		if (FCode.equalsIgnoreCase("lPFincSubsidy"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPFincSubsidy));
		if (FCode.equalsIgnoreCase("subsidyRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(subsidyRate));
		if (FCode.equalsIgnoreCase("b12TeamNAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b12TeamNAFYC));
		if (FCode.equalsIgnoreCase("sMOverride"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMOverride));
		if (FCode.equalsIgnoreCase("teamMonAvgPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(teamMonAvgPCount));
		if (FCode.equalsIgnoreCase("sMBasicSalary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMBasicSalary));
		if (FCode.equalsIgnoreCase("sMproductivity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMproductivity));
		if (FCode.equalsIgnoreCase("sMpolContinute"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMpolContinute));
		if (FCode.equalsIgnoreCase("sMPPRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMPPRate));
		if (FCode.equalsIgnoreCase("sMPPBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMPPBonus));
		if (FCode.equalsIgnoreCase("b24TeamEffectAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b24TeamEffectAFYC));
		if (FCode.equalsIgnoreCase("b24TeamAllAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b24TeamAllAFYC));
		if (FCode.equalsIgnoreCase("teamQutPremSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(teamQutPremSum));
		if (FCode.equalsIgnoreCase("sMRRBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMRRBonus));
		if (FCode.equalsIgnoreCase("sMManPowerDBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMManPowerDBonus));
		if (FCode.equalsIgnoreCase("lPB12ForMPDBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPB12ForMPDBonus));
		if (FCode.equalsIgnoreCase("sMUsualALLCSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMUsualALLCSum));
		if (FCode.equalsIgnoreCase("aMBasicSalary"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMBasicSalary));
		if (FCode.equalsIgnoreCase("aMproductivity"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMproductivity));
		if (FCode.equalsIgnoreCase("aMpolContinute"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMpolContinute));
		if (FCode.equalsIgnoreCase("aMPPRate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMPPRate));
		if (FCode.equalsIgnoreCase("aMPPBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMPPBonus));
		if (FCode.equalsIgnoreCase("b12DepNAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b12DepNAFYC));
		if (FCode.equalsIgnoreCase("aMOverride"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMOverride));
		if (FCode.equalsIgnoreCase("depMonAvgPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(depMonAvgPCount));
		if (FCode.equalsIgnoreCase("depQutPremSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(depQutPremSum));
		if (FCode.equalsIgnoreCase("aMRRBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMRRBonus));
		if (FCode.equalsIgnoreCase("aMManPowerDBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMManPowerDBonus));
		if (FCode.equalsIgnoreCase("productGrowth"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(productGrowth));
		if (FCode.equalsIgnoreCase("depQuaFYCSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(depQuaFYCSum));
		if (FCode.equalsIgnoreCase("aMLiability"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMLiability));
		if (FCode.equalsIgnoreCase("reviOpen"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(reviOpen));
		if (FCode.equalsIgnoreCase("t1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t1));
		if (FCode.equalsIgnoreCase("t2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t2));
		if (FCode.equalsIgnoreCase("t3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t3));
		if (FCode.equalsIgnoreCase("t4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t4));
		if (FCode.equalsIgnoreCase("t5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t5));
		if (FCode.equalsIgnoreCase("t6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t6));
		if (FCode.equalsIgnoreCase("t7"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t7));
		if (FCode.equalsIgnoreCase("t8"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t8));
		if (FCode.equalsIgnoreCase("t9"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t9));
		if (FCode.equalsIgnoreCase("t10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t10));
		if (FCode.equalsIgnoreCase("t11"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t11));
		if (FCode.equalsIgnoreCase("t12"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t12));
		if (FCode.equalsIgnoreCase("t13"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t13));
		if (FCode.equalsIgnoreCase("t14"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t14));
		if (FCode.equalsIgnoreCase("t15"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t15));
		if (FCode.equalsIgnoreCase("t16"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t16));
		if (FCode.equalsIgnoreCase("t17"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t17));
		if (FCode.equalsIgnoreCase("t18"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t18));
		if (FCode.equalsIgnoreCase("t20"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t20));
		if (FCode.equalsIgnoreCase("t19"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t19));
		if (FCode.equalsIgnoreCase("monthIndex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monthIndex));
		if (FCode.equalsIgnoreCase("tMonthIndex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tMonthIndex));
		if (FCode.equalsIgnoreCase("aSumIndex"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aSumIndex));
		if (FCode.equalsIgnoreCase("wSMMonthEligible"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMMonthEligible));
		if (FCode.equalsIgnoreCase("lPQuaPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPQuaPCount));
		if (FCode.equalsIgnoreCase("lPQuaFYCSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPQuaFYCSum));
		if (FCode.equalsIgnoreCase("b12LPPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b12LPPCount));
		if (FCode.equalsIgnoreCase("b12LPNAFYCSum"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(b12LPNAFYCSum));
		if (FCode.equalsIgnoreCase("wSMMonAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMMonAFYC));
		if (FCode.equalsIgnoreCase("wSMTwoMonAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMTwoMonAFYC));
		if (FCode.equalsIgnoreCase("wSMB6AFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMB6AFYC));
		if (FCode.equalsIgnoreCase("wSMB6PCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMB6PCount));
		if (FCode.equalsIgnoreCase("netLiveLPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(netLiveLPCount));
		if (FCode.equalsIgnoreCase("netComLPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(netComLPCount));
		if (FCode.equalsIgnoreCase("wSMTwoMonPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(wSMTwoMonPCount));
		if (FCode.equalsIgnoreCase("lPAllNAFYC"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPAllNAFYC));
		if (FCode.equalsIgnoreCase("lPAllPCount"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lPAllPCount));
		if (FCode.equalsIgnoreCase("monPerSAFYP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monPerSAFYP));
		if (FCode.equalsIgnoreCase("tSRThrMonSAFYP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tSRThrMonSAFYP));
		if (FCode.equalsIgnoreCase("tLThrMonPerSAFYP"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(tLThrMonPerSAFYP));
		if (FCode.equalsIgnoreCase("monSubsistCnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(monSubsistCnt));
		if (FCode.equalsIgnoreCase("thrMonSubsistCnt"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(thrMonSubsistCnt));
		if (FCode.equalsIgnoreCase("state"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(state));
		if (FCode.equalsIgnoreCase("operator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operator));
		if (FCode.equalsIgnoreCase("makeDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
		if (FCode.equalsIgnoreCase("makeTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(makeTime));
		if (FCode.equalsIgnoreCase("modifyDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
		if (FCode.equalsIgnoreCase("modifyTime"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyTime));
		if (FCode.equalsIgnoreCase("assessMonth"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(assessMonth));
		if (FCode.equalsIgnoreCase("branchAttr"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchAttr));
		if (FCode.equalsIgnoreCase("agentGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade));
		if (FCode.equalsIgnoreCase("clubPromBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clubPromBonus));
		if (FCode.equalsIgnoreCase("clubGradeBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clubGradeBonus));
		if (FCode.equalsIgnoreCase("clubAssisBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clubAssisBonus));
		if (FCode.equalsIgnoreCase("clubSpecBonus"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(clubSpecBonus));
		if (FCode.equalsIgnoreCase("adddedMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(adddedMoney));
		if (FCode.equalsIgnoreCase("lastMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(lastMoney));
		if (FCode.equalsIgnoreCase("shouldMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(shouldMoney));
		if (FCode.equalsIgnoreCase("businessTax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(businessTax));
		if (FCode.equalsIgnoreCase("eduTax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(eduTax));
		if (FCode.equalsIgnoreCase("buildTax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(buildTax));
		if (FCode.equalsIgnoreCase("busiCharge"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(busiCharge));
		if (FCode.equalsIgnoreCase("incomeTax"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(incomeTax));
		if (FCode.equalsIgnoreCase("sumMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sumMoney));
		if (FCode.equalsIgnoreCase("afterTaxMoney"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(afterTaxMoney));
		if (FCode.equalsIgnoreCase("operInCome"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(operInCome));
		if (FCode.equalsIgnoreCase("t21"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t21));
		if (FCode.equalsIgnoreCase("t22"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t22));
		if (FCode.equalsIgnoreCase("t23"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t23));
		if (FCode.equalsIgnoreCase("t24"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t24));
		if (FCode.equalsIgnoreCase("t25"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t25));
		if (strReturn.equals(""))
			strReturn = "null";
		return strReturn;
	}

	public String getV(int nFieldIndex)
	{
		String strFieldValue = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldValue = StrTool.GBKToUnicode(indexCalNo);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(indexType);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
			break;

		case 7: // '\007'
			strFieldValue = String.valueOf(quaBgnMark);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(serverMonths);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(postMonths);
			break;

		case 10: // '\n'
			strFieldValue = String.valueOf(indMonthFYC);
			break;

		case 11: // '\013'
			strFieldValue = String.valueOf(indMonthSYC);
			break;

		case 12: // '\f'
			strFieldValue = String.valueOf(indMonSignFYC);
			break;

		case 13: // '\r'
			strFieldValue = String.valueOf(indMonSignAFYC);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(indMonSignNAFYC);
			break;

		case 15: // '\017'
			strFieldValue = String.valueOf(grpMonSignNAFYC);
			break;

		case 16: // '\020'
			strFieldValue = String.valueOf(monPolCnt);
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(montCustCnt);
			break;

		case 18: // '\022'
			strFieldValue = String.valueOf(indMonPCount);
			break;

		case 19: // '\023'
			strFieldValue = String.valueOf(sMmonPolContin);
			break;

		case 20: // '\024'
			strFieldValue = String.valueOf(sMmonProduct);
			break;

		case 21: // '\025'
			strFieldValue = String.valueOf(sMworkMon);
			break;

		case 22: // '\026'
			strFieldValue = String.valueOf(monPCount);
			break;

		case 23: // '\027'
			strFieldValue = String.valueOf(wSMMonPCount);
			break;

		case 24: // '\030'
			strFieldValue = String.valueOf(lPMonForSMMP);
			break;

		case 25: // '\031'
			strFieldValue = String.valueOf(lPMonForAMMP);
			break;

		case 26: // '\032'
			strFieldValue = String.valueOf(lPpolContinute);
			break;

		case 27: // '\033'
			strFieldValue = String.valueOf(monEligFLPCnt);
			break;

		case 28: // '\034'
			strFieldValue = String.valueOf(tSRmonAFYP);
			break;

		case 29: // '\035'
			strFieldValue = String.valueOf(tSRmonDedAFYP);
			break;

		case 30: // '\036'
			strFieldValue = String.valueOf(tSRmonCompAFYP);
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(tSRMonWorkDays);
			break;

		case 32: // ' '
			strFieldValue = String.valueOf(monManPower);
			break;

		case 33: // '!'
			strFieldValue = String.valueOf(monManCount);
			break;

		case 34: // '"'
			strFieldValue = String.valueOf(monSAFYPSum);
			break;

		case 35: // '#'
			strFieldValue = String.valueOf(monTLGrpSAFYPSum);
			break;

		case 36: // '$'
			strFieldValue = String.valueOf(indYearNAFYC);
			break;

		case 37: // '%'
			strFieldValue = String.valueOf(b12IndEffectAFYC);
			break;

		case 38: // '&'
			strFieldValue = String.valueOf(b12IndAllAFYC);
			break;

		case 39: // '\''
			strFieldValue = String.valueOf(b24IndEffectAFYC);
			break;

		case 40: // '('
			strFieldValue = String.valueOf(b24IndAllAFYC);
			break;

		case 41: // ')'
			strFieldValue = String.valueOf(indQutFYC);
			break;

		case 42: // '*'
			strFieldValue = String.valueOf(lPproductivity);
			break;

		case 43: // '+'
			strFieldValue = String.valueOf(lPPPRate);
			break;

		case 44: // ','
			strFieldValue = String.valueOf(lPPPBonus);
			break;

		case 45: // '-'
			strFieldValue = String.valueOf(lPFincSubsidy);
			break;

		case 46: // '.'
			strFieldValue = String.valueOf(subsidyRate);
			break;

		case 47: // '/'
			strFieldValue = String.valueOf(b12TeamNAFYC);
			break;

		case 48: // '0'
			strFieldValue = String.valueOf(sMOverride);
			break;

		case 49: // '1'
			strFieldValue = String.valueOf(teamMonAvgPCount);
			break;

		case 50: // '2'
			strFieldValue = String.valueOf(sMBasicSalary);
			break;

		case 51: // '3'
			strFieldValue = String.valueOf(sMproductivity);
			break;

		case 52: // '4'
			strFieldValue = String.valueOf(sMpolContinute);
			break;

		case 53: // '5'
			strFieldValue = String.valueOf(sMPPRate);
			break;

		case 54: // '6'
			strFieldValue = String.valueOf(sMPPBonus);
			break;

		case 55: // '7'
			strFieldValue = String.valueOf(b24TeamEffectAFYC);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(b24TeamAllAFYC);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(teamQutPremSum);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(sMRRBonus);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(sMManPowerDBonus);
			break;

		case 60: // '<'
			strFieldValue = String.valueOf(lPB12ForMPDBonus);
			break;

		case 61: // '='
			strFieldValue = String.valueOf(sMUsualALLCSum);
			break;

		case 62: // '>'
			strFieldValue = String.valueOf(aMBasicSalary);
			break;

		case 63: // '?'
			strFieldValue = String.valueOf(aMproductivity);
			break;

		case 64: // '@'
			strFieldValue = String.valueOf(aMpolContinute);
			break;

		case 65: // 'A'
			strFieldValue = String.valueOf(aMPPRate);
			break;

		case 66: // 'B'
			strFieldValue = String.valueOf(aMPPBonus);
			break;

		case 67: // 'C'
			strFieldValue = String.valueOf(b12DepNAFYC);
			break;

		case 68: // 'D'
			strFieldValue = String.valueOf(aMOverride);
			break;

		case 69: // 'E'
			strFieldValue = String.valueOf(depMonAvgPCount);
			break;

		case 70: // 'F'
			strFieldValue = String.valueOf(depQutPremSum);
			break;

		case 71: // 'G'
			strFieldValue = String.valueOf(aMRRBonus);
			break;

		case 72: // 'H'
			strFieldValue = String.valueOf(aMManPowerDBonus);
			break;

		case 73: // 'I'
			strFieldValue = String.valueOf(productGrowth);
			break;

		case 74: // 'J'
			strFieldValue = String.valueOf(depQuaFYCSum);
			break;

		case 75: // 'K'
			strFieldValue = String.valueOf(aMLiability);
			break;

		case 76: // 'L'
			strFieldValue = String.valueOf(reviOpen);
			break;

		case 77: // 'M'
			strFieldValue = String.valueOf(t1);
			break;

		case 78: // 'N'
			strFieldValue = String.valueOf(t2);
			break;

		case 79: // 'O'
			strFieldValue = String.valueOf(t3);
			break;

		case 80: // 'P'
			strFieldValue = String.valueOf(t4);
			break;

		case 81: // 'Q'
			strFieldValue = String.valueOf(t5);
			break;

		case 82: // 'R'
			strFieldValue = String.valueOf(t6);
			break;

		case 83: // 'S'
			strFieldValue = String.valueOf(t7);
			break;

		case 84: // 'T'
			strFieldValue = String.valueOf(t8);
			break;

		case 85: // 'U'
			strFieldValue = String.valueOf(t9);
			break;

		case 86: // 'V'
			strFieldValue = String.valueOf(t10);
			break;

		case 87: // 'W'
			strFieldValue = String.valueOf(t11);
			break;

		case 88: // 'X'
			strFieldValue = String.valueOf(t12);
			break;

		case 89: // 'Y'
			strFieldValue = String.valueOf(t13);
			break;

		case 90: // 'Z'
			strFieldValue = String.valueOf(t14);
			break;

		case 91: // '['
			strFieldValue = String.valueOf(t15);
			break;

		case 92: // '\\'
			strFieldValue = String.valueOf(t16);
			break;

		case 93: // ']'
			strFieldValue = String.valueOf(t17);
			break;

		case 94: // '^'
			strFieldValue = String.valueOf(t18);
			break;

		case 95: // '_'
			strFieldValue = String.valueOf(t20);
			break;

		case 96: // '`'
			strFieldValue = String.valueOf(t19);
			break;

		case 97: // 'a'
			strFieldValue = String.valueOf(monthIndex);
			break;

		case 98: // 'b'
			strFieldValue = String.valueOf(tMonthIndex);
			break;

		case 99: // 'c'
			strFieldValue = String.valueOf(aSumIndex);
			break;

		case 100: // 'd'
			strFieldValue = String.valueOf(wSMMonthEligible);
			break;

		case 101: // 'e'
			strFieldValue = String.valueOf(lPQuaPCount);
			break;

		case 102: // 'f'
			strFieldValue = String.valueOf(lPQuaFYCSum);
			break;

		case 103: // 'g'
			strFieldValue = String.valueOf(b12LPPCount);
			break;

		case 104: // 'h'
			strFieldValue = String.valueOf(b12LPNAFYCSum);
			break;

		case 105: // 'i'
			strFieldValue = String.valueOf(wSMMonAFYC);
			break;

		case 106: // 'j'
			strFieldValue = String.valueOf(wSMTwoMonAFYC);
			break;

		case 107: // 'k'
			strFieldValue = String.valueOf(wSMB6AFYC);
			break;

		case 108: // 'l'
			strFieldValue = String.valueOf(wSMB6PCount);
			break;

		case 109: // 'm'
			strFieldValue = String.valueOf(netLiveLPCount);
			break;

		case 110: // 'n'
			strFieldValue = String.valueOf(netComLPCount);
			break;

		case 111: // 'o'
			strFieldValue = String.valueOf(wSMTwoMonPCount);
			break;

		case 112: // 'p'
			strFieldValue = String.valueOf(lPAllNAFYC);
			break;

		case 113: // 'q'
			strFieldValue = String.valueOf(lPAllPCount);
			break;

		case 114: // 'r'
			strFieldValue = String.valueOf(monPerSAFYP);
			break;

		case 115: // 's'
			strFieldValue = String.valueOf(tSRThrMonSAFYP);
			break;

		case 116: // 't'
			strFieldValue = String.valueOf(tLThrMonPerSAFYP);
			break;

		case 117: // 'u'
			strFieldValue = String.valueOf(monSubsistCnt);
			break;

		case 118: // 'v'
			strFieldValue = String.valueOf(thrMonSubsistCnt);
			break;

		case 119: // 'w'
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 120: // 'x'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 121: // 'y'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 122: // 'z'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 123: // '{'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 124: // '|'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 125: // '}'
			strFieldValue = StrTool.GBKToUnicode(assessMonth);
			break;

		case 126: // '~'
			strFieldValue = StrTool.GBKToUnicode(branchAttr);
			break;

		case 127: // '\177'
			strFieldValue = StrTool.GBKToUnicode(agentGrade);
			break;

		case 128: 
			strFieldValue = String.valueOf(clubPromBonus);
			break;

		case 129: 
			strFieldValue = String.valueOf(clubGradeBonus);
			break;

		case 130: 
			strFieldValue = String.valueOf(clubAssisBonus);
			break;

		case 131: 
			strFieldValue = String.valueOf(clubSpecBonus);
			break;

		case 132: 
			strFieldValue = String.valueOf(adddedMoney);
			break;

		case 133: 
			strFieldValue = String.valueOf(lastMoney);
			break;

		case 134: 
			strFieldValue = String.valueOf(shouldMoney);
			break;

		case 135: 
			strFieldValue = String.valueOf(businessTax);
			break;

		case 136: 
			strFieldValue = String.valueOf(eduTax);
			break;

		case 137: 
			strFieldValue = String.valueOf(buildTax);
			break;

		case 138: 
			strFieldValue = String.valueOf(busiCharge);
			break;

		case 139: 
			strFieldValue = String.valueOf(incomeTax);
			break;

		case 140: 
			strFieldValue = String.valueOf(sumMoney);
			break;

		case 141: 
			strFieldValue = String.valueOf(afterTaxMoney);
			break;

		case 142: 
			strFieldValue = String.valueOf(operInCome);
			break;

		case 143: 
			strFieldValue = String.valueOf(t21);
			break;

		case 144: 
			strFieldValue = String.valueOf(t22);
			break;

		case 145: 
			strFieldValue = String.valueOf(t23);
			break;

		case 146: 
			strFieldValue = String.valueOf(t24);
			break;

		case 147: 
			strFieldValue = String.valueOf(t25);
			break;

		default:
			strFieldValue = "";
			break;
		}
		if (strFieldValue.equals(""))
			strFieldValue = "null";
		return strFieldValue;
	}

	public boolean setV(String FCode, String FValue)
	{
		if (StrTool.cTrim(FCode).equals(""))
			return false;
		if (FCode.equalsIgnoreCase("indexCalNo"))
			if (FValue != null && !FValue.equals(""))
				indexCalNo = FValue.trim();
			else
				indexCalNo = null;
		if (FCode.equalsIgnoreCase("indexType"))
			if (FValue != null && !FValue.equals(""))
				indexType = FValue.trim();
			else
				indexType = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("agentGroup"))
			if (FValue != null && !FValue.equals(""))
				agentGroup = FValue.trim();
			else
				agentGroup = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("startDate"))
			if (FValue != null && !FValue.equals(""))
				startDate = fDate.getDate(FValue);
			else
				startDate = null;
		if (FCode.equalsIgnoreCase("startEnd"))
			if (FValue != null && !FValue.equals(""))
				startEnd = fDate.getDate(FValue);
			else
				startEnd = null;
		if (FCode.equalsIgnoreCase("quaBgnMark") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			quaBgnMark = i;
		}
		if (FCode.equalsIgnoreCase("serverMonths") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			serverMonths = i;
		}
		if (FCode.equalsIgnoreCase("postMonths") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			postMonths = i;
		}
		if (FCode.equalsIgnoreCase("indMonthFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indMonthFYC = d;
		}
		if (FCode.equalsIgnoreCase("indMonthSYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indMonthSYC = d;
		}
		if (FCode.equalsIgnoreCase("indMonSignFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indMonSignFYC = d;
		}
		if (FCode.equalsIgnoreCase("indMonSignAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indMonSignAFYC = d;
		}
		if (FCode.equalsIgnoreCase("indMonSignNAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indMonSignNAFYC = d;
		}
		if (FCode.equalsIgnoreCase("grpMonSignNAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			grpMonSignNAFYC = d;
		}
		if (FCode.equalsIgnoreCase("monPolCnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monPolCnt = d;
		}
		if (FCode.equalsIgnoreCase("montCustCnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			montCustCnt = d;
		}
		if (FCode.equalsIgnoreCase("indMonPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indMonPCount = d;
		}
		if (FCode.equalsIgnoreCase("sMmonPolContin") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMmonPolContin = d;
		}
		if (FCode.equalsIgnoreCase("sMmonProduct") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMmonProduct = d;
		}
		if (FCode.equalsIgnoreCase("sMworkMon") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMworkMon = d;
		}
		if (FCode.equalsIgnoreCase("monPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monPCount = d;
		}
		if (FCode.equalsIgnoreCase("wSMMonPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMMonPCount = d;
		}
		if (FCode.equalsIgnoreCase("lPMonForSMMP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPMonForSMMP = d;
		}
		if (FCode.equalsIgnoreCase("lPMonForAMMP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPMonForAMMP = d;
		}
		if (FCode.equalsIgnoreCase("lPpolContinute") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPpolContinute = d;
		}
		if (FCode.equalsIgnoreCase("monEligFLPCnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monEligFLPCnt = d;
		}
		if (FCode.equalsIgnoreCase("tSRmonAFYP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tSRmonAFYP = d;
		}
		if (FCode.equalsIgnoreCase("tSRmonDedAFYP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tSRmonDedAFYP = d;
		}
		if (FCode.equalsIgnoreCase("tSRmonCompAFYP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tSRmonCompAFYP = d;
		}
		if (FCode.equalsIgnoreCase("tSRMonWorkDays") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tSRMonWorkDays = d;
		}
		if (FCode.equalsIgnoreCase("monManPower") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monManPower = d;
		}
		if (FCode.equalsIgnoreCase("monManCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monManCount = d;
		}
		if (FCode.equalsIgnoreCase("monSAFYPSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monSAFYPSum = d;
		}
		if (FCode.equalsIgnoreCase("monTLGrpSAFYPSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monTLGrpSAFYPSum = d;
		}
		if (FCode.equalsIgnoreCase("indYearNAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indYearNAFYC = d;
		}
		if (FCode.equalsIgnoreCase("b12IndEffectAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b12IndEffectAFYC = d;
		}
		if (FCode.equalsIgnoreCase("b12IndAllAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b12IndAllAFYC = d;
		}
		if (FCode.equalsIgnoreCase("b24IndEffectAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b24IndEffectAFYC = d;
		}
		if (FCode.equalsIgnoreCase("b24IndAllAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b24IndAllAFYC = d;
		}
		if (FCode.equalsIgnoreCase("indQutFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			indQutFYC = d;
		}
		if (FCode.equalsIgnoreCase("lPproductivity") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPproductivity = d;
		}
		if (FCode.equalsIgnoreCase("lPPPRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPPPRate = d;
		}
		if (FCode.equalsIgnoreCase("lPPPBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPPPBonus = d;
		}
		if (FCode.equalsIgnoreCase("lPFincSubsidy") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPFincSubsidy = d;
		}
		if (FCode.equalsIgnoreCase("subsidyRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			subsidyRate = d;
		}
		if (FCode.equalsIgnoreCase("b12TeamNAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b12TeamNAFYC = d;
		}
		if (FCode.equalsIgnoreCase("sMOverride") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMOverride = d;
		}
		if (FCode.equalsIgnoreCase("teamMonAvgPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			teamMonAvgPCount = d;
		}
		if (FCode.equalsIgnoreCase("sMBasicSalary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMBasicSalary = d;
		}
		if (FCode.equalsIgnoreCase("sMproductivity") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMproductivity = d;
		}
		if (FCode.equalsIgnoreCase("sMpolContinute") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMpolContinute = d;
		}
		if (FCode.equalsIgnoreCase("sMPPRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMPPRate = d;
		}
		if (FCode.equalsIgnoreCase("sMPPBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMPPBonus = d;
		}
		if (FCode.equalsIgnoreCase("b24TeamEffectAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b24TeamEffectAFYC = d;
		}
		if (FCode.equalsIgnoreCase("b24TeamAllAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b24TeamAllAFYC = d;
		}
		if (FCode.equalsIgnoreCase("teamQutPremSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			teamQutPremSum = d;
		}
		if (FCode.equalsIgnoreCase("sMRRBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMRRBonus = d;
		}
		if (FCode.equalsIgnoreCase("sMManPowerDBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMManPowerDBonus = d;
		}
		if (FCode.equalsIgnoreCase("lPB12ForMPDBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPB12ForMPDBonus = d;
		}
		if (FCode.equalsIgnoreCase("sMUsualALLCSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sMUsualALLCSum = d;
		}
		if (FCode.equalsIgnoreCase("aMBasicSalary") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMBasicSalary = d;
		}
		if (FCode.equalsIgnoreCase("aMproductivity") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMproductivity = d;
		}
		if (FCode.equalsIgnoreCase("aMpolContinute") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMpolContinute = d;
		}
		if (FCode.equalsIgnoreCase("aMPPRate") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMPPRate = d;
		}
		if (FCode.equalsIgnoreCase("aMPPBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMPPBonus = d;
		}
		if (FCode.equalsIgnoreCase("b12DepNAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b12DepNAFYC = d;
		}
		if (FCode.equalsIgnoreCase("aMOverride") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMOverride = d;
		}
		if (FCode.equalsIgnoreCase("depMonAvgPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			depMonAvgPCount = d;
		}
		if (FCode.equalsIgnoreCase("depQutPremSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			depQutPremSum = d;
		}
		if (FCode.equalsIgnoreCase("aMRRBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMRRBonus = d;
		}
		if (FCode.equalsIgnoreCase("aMManPowerDBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMManPowerDBonus = d;
		}
		if (FCode.equalsIgnoreCase("productGrowth") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			productGrowth = d;
		}
		if (FCode.equalsIgnoreCase("depQuaFYCSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			depQuaFYCSum = d;
		}
		if (FCode.equalsIgnoreCase("aMLiability") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aMLiability = d;
		}
		if (FCode.equalsIgnoreCase("reviOpen") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			reviOpen = d;
		}
		if (FCode.equalsIgnoreCase("t1") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t1 = d;
		}
		if (FCode.equalsIgnoreCase("t2") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t2 = d;
		}
		if (FCode.equalsIgnoreCase("t3") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t3 = d;
		}
		if (FCode.equalsIgnoreCase("t4") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t4 = d;
		}
		if (FCode.equalsIgnoreCase("t5") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t5 = d;
		}
		if (FCode.equalsIgnoreCase("t6") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t6 = d;
		}
		if (FCode.equalsIgnoreCase("t7") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t7 = d;
		}
		if (FCode.equalsIgnoreCase("t8") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t8 = d;
		}
		if (FCode.equalsIgnoreCase("t9") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t9 = d;
		}
		if (FCode.equalsIgnoreCase("t10") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t10 = d;
		}
		if (FCode.equalsIgnoreCase("t11") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t11 = d;
		}
		if (FCode.equalsIgnoreCase("t12") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t12 = d;
		}
		if (FCode.equalsIgnoreCase("t13") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t13 = d;
		}
		if (FCode.equalsIgnoreCase("t14") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t14 = d;
		}
		if (FCode.equalsIgnoreCase("t15") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t15 = d;
		}
		if (FCode.equalsIgnoreCase("t16") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t16 = d;
		}
		if (FCode.equalsIgnoreCase("t17") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t17 = d;
		}
		if (FCode.equalsIgnoreCase("t18") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t18 = d;
		}
		if (FCode.equalsIgnoreCase("t20") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t20 = d;
		}
		if (FCode.equalsIgnoreCase("t19") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t19 = d;
		}
		if (FCode.equalsIgnoreCase("monthIndex") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monthIndex = d;
		}
		if (FCode.equalsIgnoreCase("tMonthIndex") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tMonthIndex = d;
		}
		if (FCode.equalsIgnoreCase("aSumIndex") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			aSumIndex = d;
		}
		if (FCode.equalsIgnoreCase("wSMMonthEligible") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMMonthEligible = d;
		}
		if (FCode.equalsIgnoreCase("lPQuaPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPQuaPCount = d;
		}
		if (FCode.equalsIgnoreCase("lPQuaFYCSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPQuaFYCSum = d;
		}
		if (FCode.equalsIgnoreCase("b12LPPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b12LPPCount = d;
		}
		if (FCode.equalsIgnoreCase("b12LPNAFYCSum") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			b12LPNAFYCSum = d;
		}
		if (FCode.equalsIgnoreCase("wSMMonAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMMonAFYC = d;
		}
		if (FCode.equalsIgnoreCase("wSMTwoMonAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMTwoMonAFYC = d;
		}
		if (FCode.equalsIgnoreCase("wSMB6AFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMB6AFYC = d;
		}
		if (FCode.equalsIgnoreCase("wSMB6PCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMB6PCount = d;
		}
		if (FCode.equalsIgnoreCase("netLiveLPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			netLiveLPCount = d;
		}
		if (FCode.equalsIgnoreCase("netComLPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			netComLPCount = d;
		}
		if (FCode.equalsIgnoreCase("wSMTwoMonPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			wSMTwoMonPCount = d;
		}
		if (FCode.equalsIgnoreCase("lPAllNAFYC") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPAllNAFYC = d;
		}
		if (FCode.equalsIgnoreCase("lPAllPCount") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lPAllPCount = d;
		}
		if (FCode.equalsIgnoreCase("monPerSAFYP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monPerSAFYP = d;
		}
		if (FCode.equalsIgnoreCase("tSRThrMonSAFYP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tSRThrMonSAFYP = d;
		}
		if (FCode.equalsIgnoreCase("tLThrMonPerSAFYP") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			tLThrMonPerSAFYP = d;
		}
		if (FCode.equalsIgnoreCase("monSubsistCnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			monSubsistCnt = d;
		}
		if (FCode.equalsIgnoreCase("thrMonSubsistCnt") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			thrMonSubsistCnt = d;
		}
		if (FCode.equalsIgnoreCase("state"))
			if (FValue != null && !FValue.equals(""))
				state = FValue.trim();
			else
				state = null;
		if (FCode.equalsIgnoreCase("operator"))
			if (FValue != null && !FValue.equals(""))
				operator = FValue.trim();
			else
				operator = null;
		if (FCode.equalsIgnoreCase("makeDate"))
			if (FValue != null && !FValue.equals(""))
				makeDate = fDate.getDate(FValue);
			else
				makeDate = null;
		if (FCode.equalsIgnoreCase("makeTime"))
			if (FValue != null && !FValue.equals(""))
				makeTime = FValue.trim();
			else
				makeTime = null;
		if (FCode.equalsIgnoreCase("modifyDate"))
			if (FValue != null && !FValue.equals(""))
				modifyDate = fDate.getDate(FValue);
			else
				modifyDate = null;
		if (FCode.equalsIgnoreCase("modifyTime"))
			if (FValue != null && !FValue.equals(""))
				modifyTime = FValue.trim();
			else
				modifyTime = null;
		if (FCode.equalsIgnoreCase("assessMonth"))
			if (FValue != null && !FValue.equals(""))
				assessMonth = FValue.trim();
			else
				assessMonth = null;
		if (FCode.equalsIgnoreCase("branchAttr"))
			if (FValue != null && !FValue.equals(""))
				branchAttr = FValue.trim();
			else
				branchAttr = null;
		if (FCode.equalsIgnoreCase("agentGrade"))
			if (FValue != null && !FValue.equals(""))
				agentGrade = FValue.trim();
			else
				agentGrade = null;
		if (FCode.equalsIgnoreCase("clubPromBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			clubPromBonus = d;
		}
		if (FCode.equalsIgnoreCase("clubGradeBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			clubGradeBonus = d;
		}
		if (FCode.equalsIgnoreCase("clubAssisBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			clubAssisBonus = d;
		}
		if (FCode.equalsIgnoreCase("clubSpecBonus") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			clubSpecBonus = d;
		}
		if (FCode.equalsIgnoreCase("adddedMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			adddedMoney = d;
		}
		if (FCode.equalsIgnoreCase("lastMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			lastMoney = d;
		}
		if (FCode.equalsIgnoreCase("shouldMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			shouldMoney = d;
		}
		if (FCode.equalsIgnoreCase("businessTax") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			businessTax = d;
		}
		if (FCode.equalsIgnoreCase("eduTax") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			eduTax = d;
		}
		if (FCode.equalsIgnoreCase("buildTax") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			buildTax = d;
		}
		if (FCode.equalsIgnoreCase("busiCharge") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			busiCharge = d;
		}
		if (FCode.equalsIgnoreCase("incomeTax") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			incomeTax = d;
		}
		if (FCode.equalsIgnoreCase("sumMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			sumMoney = d;
		}
		if (FCode.equalsIgnoreCase("afterTaxMoney") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			afterTaxMoney = d;
		}
		if (FCode.equalsIgnoreCase("operInCome") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			operInCome = d;
		}
		if (FCode.equalsIgnoreCase("t21") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t21 = d;
		}
		if (FCode.equalsIgnoreCase("t22") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t22 = d;
		}
		if (FCode.equalsIgnoreCase("t23") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t23 = d;
		}
		if (FCode.equalsIgnoreCase("t24") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t24 = d;
		}
		if (FCode.equalsIgnoreCase("t25") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t25 = d;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		if (this == otherObject)
			return true;
		if (getClass() != otherObject.getClass())
			return false;
		LAIndexInfoSchema other = (LAIndexInfoSchema)otherObject;
		if (indexCalNo == null && other.getIndexCalNo() != null)
			return false;
		if (indexCalNo != null && !indexCalNo.equals(other.getIndexCalNo()))
			return false;
		if (indexType == null && other.getIndexType() != null)
			return false;
		if (indexType != null && !indexType.equals(other.getIndexType()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (agentGroup == null && other.getAgentGroup() != null)
			return false;
		if (agentGroup != null && !agentGroup.equals(other.getAgentGroup()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (startEnd == null && other.getStartEnd() != null)
			return false;
		if (startEnd != null && !fDate.getString(startEnd).equals(other.getStartEnd()))
			return false;
		if (quaBgnMark != other.getQuaBgnMark())
			return false;
		if (serverMonths != other.getServerMonths())
			return false;
		if (postMonths != other.getPostMonths())
			return false;
		if (Double.doubleToLongBits(indMonthFYC) != Double.doubleToLongBits(other.getIndMonthFYC()))
			return false;
		if (Double.doubleToLongBits(indMonthSYC) != Double.doubleToLongBits(other.getIndMonthSYC()))
			return false;
		if (Double.doubleToLongBits(indMonSignFYC) != Double.doubleToLongBits(other.getIndMonSignFYC()))
			return false;
		if (Double.doubleToLongBits(indMonSignAFYC) != Double.doubleToLongBits(other.getIndMonSignAFYC()))
			return false;
		if (Double.doubleToLongBits(indMonSignNAFYC) != Double.doubleToLongBits(other.getIndMonSignNAFYC()))
			return false;
		if (Double.doubleToLongBits(grpMonSignNAFYC) != Double.doubleToLongBits(other.getGrpMonSignNAFYC()))
			return false;
		if (Double.doubleToLongBits(monPolCnt) != Double.doubleToLongBits(other.getMonPolCnt()))
			return false;
		if (Double.doubleToLongBits(montCustCnt) != Double.doubleToLongBits(other.getMontCustCnt()))
			return false;
		if (Double.doubleToLongBits(indMonPCount) != Double.doubleToLongBits(other.getIndMonPCount()))
			return false;
		if (Double.doubleToLongBits(sMmonPolContin) != Double.doubleToLongBits(other.getSMmonPolContin()))
			return false;
		if (Double.doubleToLongBits(sMmonProduct) != Double.doubleToLongBits(other.getSMmonProduct()))
			return false;
		if (Double.doubleToLongBits(sMworkMon) != Double.doubleToLongBits(other.getSMworkMon()))
			return false;
		if (Double.doubleToLongBits(monPCount) != Double.doubleToLongBits(other.getMonPCount()))
			return false;
		if (Double.doubleToLongBits(wSMMonPCount) != Double.doubleToLongBits(other.getWSMMonPCount()))
			return false;
		if (Double.doubleToLongBits(lPMonForSMMP) != Double.doubleToLongBits(other.getLPMonForSMMP()))
			return false;
		if (Double.doubleToLongBits(lPMonForAMMP) != Double.doubleToLongBits(other.getLPMonForAMMP()))
			return false;
		if (Double.doubleToLongBits(lPpolContinute) != Double.doubleToLongBits(other.getLPpolContinute()))
			return false;
		if (Double.doubleToLongBits(monEligFLPCnt) != Double.doubleToLongBits(other.getMonEligFLPCnt()))
			return false;
		if (Double.doubleToLongBits(tSRmonAFYP) != Double.doubleToLongBits(other.getTSRmonAFYP()))
			return false;
		if (Double.doubleToLongBits(tSRmonDedAFYP) != Double.doubleToLongBits(other.getTSRmonDedAFYP()))
			return false;
		if (Double.doubleToLongBits(tSRmonCompAFYP) != Double.doubleToLongBits(other.getTSRmonCompAFYP()))
			return false;
		if (Double.doubleToLongBits(tSRMonWorkDays) != Double.doubleToLongBits(other.getTSRMonWorkDays()))
			return false;
		if (Double.doubleToLongBits(monManPower) != Double.doubleToLongBits(other.getMonManPower()))
			return false;
		if (Double.doubleToLongBits(monManCount) != Double.doubleToLongBits(other.getMonManCount()))
			return false;
		if (Double.doubleToLongBits(monSAFYPSum) != Double.doubleToLongBits(other.getMonSAFYPSum()))
			return false;
		if (Double.doubleToLongBits(monTLGrpSAFYPSum) != Double.doubleToLongBits(other.getMonTLGrpSAFYPSum()))
			return false;
		if (Double.doubleToLongBits(indYearNAFYC) != Double.doubleToLongBits(other.getIndYearNAFYC()))
			return false;
		if (Double.doubleToLongBits(b12IndEffectAFYC) != Double.doubleToLongBits(other.getB12IndEffectAFYC()))
			return false;
		if (Double.doubleToLongBits(b12IndAllAFYC) != Double.doubleToLongBits(other.getB12IndAllAFYC()))
			return false;
		if (Double.doubleToLongBits(b24IndEffectAFYC) != Double.doubleToLongBits(other.getB24IndEffectAFYC()))
			return false;
		if (Double.doubleToLongBits(b24IndAllAFYC) != Double.doubleToLongBits(other.getB24IndAllAFYC()))
			return false;
		if (Double.doubleToLongBits(indQutFYC) != Double.doubleToLongBits(other.getIndQutFYC()))
			return false;
		if (Double.doubleToLongBits(lPproductivity) != Double.doubleToLongBits(other.getLPproductivity()))
			return false;
		if (Double.doubleToLongBits(lPPPRate) != Double.doubleToLongBits(other.getLPPPRate()))
			return false;
		if (Double.doubleToLongBits(lPPPBonus) != Double.doubleToLongBits(other.getLPPPBonus()))
			return false;
		if (Double.doubleToLongBits(lPFincSubsidy) != Double.doubleToLongBits(other.getLPFincSubsidy()))
			return false;
		if (Double.doubleToLongBits(subsidyRate) != Double.doubleToLongBits(other.getSubsidyRate()))
			return false;
		if (Double.doubleToLongBits(b12TeamNAFYC) != Double.doubleToLongBits(other.getB12TeamNAFYC()))
			return false;
		if (Double.doubleToLongBits(sMOverride) != Double.doubleToLongBits(other.getSMOverride()))
			return false;
		if (Double.doubleToLongBits(teamMonAvgPCount) != Double.doubleToLongBits(other.getTeamMonAvgPCount()))
			return false;
		if (Double.doubleToLongBits(sMBasicSalary) != Double.doubleToLongBits(other.getSMBasicSalary()))
			return false;
		if (Double.doubleToLongBits(sMproductivity) != Double.doubleToLongBits(other.getSMproductivity()))
			return false;
		if (Double.doubleToLongBits(sMpolContinute) != Double.doubleToLongBits(other.getSMpolContinute()))
			return false;
		if (Double.doubleToLongBits(sMPPRate) != Double.doubleToLongBits(other.getSMPPRate()))
			return false;
		if (Double.doubleToLongBits(sMPPBonus) != Double.doubleToLongBits(other.getSMPPBonus()))
			return false;
		if (Double.doubleToLongBits(b24TeamEffectAFYC) != Double.doubleToLongBits(other.getB24TeamEffectAFYC()))
			return false;
		if (Double.doubleToLongBits(b24TeamAllAFYC) != Double.doubleToLongBits(other.getB24TeamAllAFYC()))
			return false;
		if (Double.doubleToLongBits(teamQutPremSum) != Double.doubleToLongBits(other.getTeamQutPremSum()))
			return false;
		if (Double.doubleToLongBits(sMRRBonus) != Double.doubleToLongBits(other.getSMRRBonus()))
			return false;
		if (Double.doubleToLongBits(sMManPowerDBonus) != Double.doubleToLongBits(other.getSMManPowerDBonus()))
			return false;
		if (Double.doubleToLongBits(lPB12ForMPDBonus) != Double.doubleToLongBits(other.getLPB12ForMPDBonus()))
			return false;
		if (Double.doubleToLongBits(sMUsualALLCSum) != Double.doubleToLongBits(other.getSMUsualALLCSum()))
			return false;
		if (Double.doubleToLongBits(aMBasicSalary) != Double.doubleToLongBits(other.getAMBasicSalary()))
			return false;
		if (Double.doubleToLongBits(aMproductivity) != Double.doubleToLongBits(other.getAMproductivity()))
			return false;
		if (Double.doubleToLongBits(aMpolContinute) != Double.doubleToLongBits(other.getAMpolContinute()))
			return false;
		if (Double.doubleToLongBits(aMPPRate) != Double.doubleToLongBits(other.getAMPPRate()))
			return false;
		if (Double.doubleToLongBits(aMPPBonus) != Double.doubleToLongBits(other.getAMPPBonus()))
			return false;
		if (Double.doubleToLongBits(b12DepNAFYC) != Double.doubleToLongBits(other.getB12DepNAFYC()))
			return false;
		if (Double.doubleToLongBits(aMOverride) != Double.doubleToLongBits(other.getAMOverride()))
			return false;
		if (Double.doubleToLongBits(depMonAvgPCount) != Double.doubleToLongBits(other.getDepMonAvgPCount()))
			return false;
		if (Double.doubleToLongBits(depQutPremSum) != Double.doubleToLongBits(other.getDepQutPremSum()))
			return false;
		if (Double.doubleToLongBits(aMRRBonus) != Double.doubleToLongBits(other.getAMRRBonus()))
			return false;
		if (Double.doubleToLongBits(aMManPowerDBonus) != Double.doubleToLongBits(other.getAMManPowerDBonus()))
			return false;
		if (Double.doubleToLongBits(productGrowth) != Double.doubleToLongBits(other.getProductGrowth()))
			return false;
		if (Double.doubleToLongBits(depQuaFYCSum) != Double.doubleToLongBits(other.getDepQuaFYCSum()))
			return false;
		if (Double.doubleToLongBits(aMLiability) != Double.doubleToLongBits(other.getAMLiability()))
			return false;
		if (Double.doubleToLongBits(reviOpen) != Double.doubleToLongBits(other.getReviOpen()))
			return false;
		if (Double.doubleToLongBits(t1) != Double.doubleToLongBits(other.getT1()))
			return false;
		if (Double.doubleToLongBits(t2) != Double.doubleToLongBits(other.getT2()))
			return false;
		if (Double.doubleToLongBits(t3) != Double.doubleToLongBits(other.getT3()))
			return false;
		if (Double.doubleToLongBits(t4) != Double.doubleToLongBits(other.getT4()))
			return false;
		if (Double.doubleToLongBits(t5) != Double.doubleToLongBits(other.getT5()))
			return false;
		if (Double.doubleToLongBits(t6) != Double.doubleToLongBits(other.getT6()))
			return false;
		if (Double.doubleToLongBits(t7) != Double.doubleToLongBits(other.getT7()))
			return false;
		if (Double.doubleToLongBits(t8) != Double.doubleToLongBits(other.getT8()))
			return false;
		if (Double.doubleToLongBits(t9) != Double.doubleToLongBits(other.getT9()))
			return false;
		if (Double.doubleToLongBits(t10) != Double.doubleToLongBits(other.getT10()))
			return false;
		if (Double.doubleToLongBits(t11) != Double.doubleToLongBits(other.getT11()))
			return false;
		if (Double.doubleToLongBits(t12) != Double.doubleToLongBits(other.getT12()))
			return false;
		if (Double.doubleToLongBits(t13) != Double.doubleToLongBits(other.getT13()))
			return false;
		if (Double.doubleToLongBits(t14) != Double.doubleToLongBits(other.getT14()))
			return false;
		if (Double.doubleToLongBits(t15) != Double.doubleToLongBits(other.getT15()))
			return false;
		if (Double.doubleToLongBits(t16) != Double.doubleToLongBits(other.getT16()))
			return false;
		if (Double.doubleToLongBits(t17) != Double.doubleToLongBits(other.getT17()))
			return false;
		if (Double.doubleToLongBits(t18) != Double.doubleToLongBits(other.getT18()))
			return false;
		if (Double.doubleToLongBits(t20) != Double.doubleToLongBits(other.getT20()))
			return false;
		if (Double.doubleToLongBits(t19) != Double.doubleToLongBits(other.getT19()))
			return false;
		if (Double.doubleToLongBits(monthIndex) != Double.doubleToLongBits(other.getMonthIndex()))
			return false;
		if (Double.doubleToLongBits(tMonthIndex) != Double.doubleToLongBits(other.getTMonthIndex()))
			return false;
		if (Double.doubleToLongBits(aSumIndex) != Double.doubleToLongBits(other.getASumIndex()))
			return false;
		if (Double.doubleToLongBits(wSMMonthEligible) != Double.doubleToLongBits(other.getWSMMonthEligible()))
			return false;
		if (Double.doubleToLongBits(lPQuaPCount) != Double.doubleToLongBits(other.getLPQuaPCount()))
			return false;
		if (Double.doubleToLongBits(lPQuaFYCSum) != Double.doubleToLongBits(other.getLPQuaFYCSum()))
			return false;
		if (Double.doubleToLongBits(b12LPPCount) != Double.doubleToLongBits(other.getB12LPPCount()))
			return false;
		if (Double.doubleToLongBits(b12LPNAFYCSum) != Double.doubleToLongBits(other.getB12LPNAFYCSum()))
			return false;
		if (Double.doubleToLongBits(wSMMonAFYC) != Double.doubleToLongBits(other.getWSMMonAFYC()))
			return false;
		if (Double.doubleToLongBits(wSMTwoMonAFYC) != Double.doubleToLongBits(other.getWSMTwoMonAFYC()))
			return false;
		if (Double.doubleToLongBits(wSMB6AFYC) != Double.doubleToLongBits(other.getWSMB6AFYC()))
			return false;
		if (Double.doubleToLongBits(wSMB6PCount) != Double.doubleToLongBits(other.getWSMB6PCount()))
			return false;
		if (Double.doubleToLongBits(netLiveLPCount) != Double.doubleToLongBits(other.getNetLiveLPCount()))
			return false;
		if (Double.doubleToLongBits(netComLPCount) != Double.doubleToLongBits(other.getNetComLPCount()))
			return false;
		if (Double.doubleToLongBits(wSMTwoMonPCount) != Double.doubleToLongBits(other.getWSMTwoMonPCount()))
			return false;
		if (Double.doubleToLongBits(lPAllNAFYC) != Double.doubleToLongBits(other.getLPAllNAFYC()))
			return false;
		if (Double.doubleToLongBits(lPAllPCount) != Double.doubleToLongBits(other.getLPAllPCount()))
			return false;
		if (Double.doubleToLongBits(monPerSAFYP) != Double.doubleToLongBits(other.getMonPerSAFYP()))
			return false;
		if (Double.doubleToLongBits(tSRThrMonSAFYP) != Double.doubleToLongBits(other.getTSRThrMonSAFYP()))
			return false;
		if (Double.doubleToLongBits(tLThrMonPerSAFYP) != Double.doubleToLongBits(other.getTLThrMonPerSAFYP()))
			return false;
		if (Double.doubleToLongBits(monSubsistCnt) != Double.doubleToLongBits(other.getMonSubsistCnt()))
			return false;
		if (Double.doubleToLongBits(thrMonSubsistCnt) != Double.doubleToLongBits(other.getThrMonSubsistCnt()))
			return false;
		if (state == null && other.getState() != null)
			return false;
		if (state != null && !state.equals(other.getState()))
			return false;
		if (operator == null && other.getOperator() != null)
			return false;
		if (operator != null && !operator.equals(other.getOperator()))
			return false;
		if (makeDate == null && other.getMakeDate() != null)
			return false;
		if (makeDate != null && !fDate.getString(makeDate).equals(other.getMakeDate()))
			return false;
		if (makeTime == null && other.getMakeTime() != null)
			return false;
		if (makeTime != null && !makeTime.equals(other.getMakeTime()))
			return false;
		if (modifyDate == null && other.getModifyDate() != null)
			return false;
		if (modifyDate != null && !fDate.getString(modifyDate).equals(other.getModifyDate()))
			return false;
		if (modifyTime == null && other.getModifyTime() != null)
			return false;
		if (modifyTime != null && !modifyTime.equals(other.getModifyTime()))
			return false;
		if (assessMonth == null && other.getAssessMonth() != null)
			return false;
		if (assessMonth != null && !assessMonth.equals(other.getAssessMonth()))
			return false;
		if (branchAttr == null && other.getBranchAttr() != null)
			return false;
		if (branchAttr != null && !branchAttr.equals(other.getBranchAttr()))
			return false;
		if (agentGrade == null && other.getAgentGrade() != null)
			return false;
		if (agentGrade != null && !agentGrade.equals(other.getAgentGrade()))
			return false;
		if (Double.doubleToLongBits(clubPromBonus) != Double.doubleToLongBits(other.getClubPromBonus()))
			return false;
		if (Double.doubleToLongBits(clubGradeBonus) != Double.doubleToLongBits(other.getClubGradeBonus()))
			return false;
		if (Double.doubleToLongBits(clubAssisBonus) != Double.doubleToLongBits(other.getClubAssisBonus()))
			return false;
		if (Double.doubleToLongBits(clubSpecBonus) != Double.doubleToLongBits(other.getClubSpecBonus()))
			return false;
		if (Double.doubleToLongBits(adddedMoney) != Double.doubleToLongBits(other.getAdddedMoney()))
			return false;
		if (Double.doubleToLongBits(lastMoney) != Double.doubleToLongBits(other.getLastMoney()))
			return false;
		if (Double.doubleToLongBits(shouldMoney) != Double.doubleToLongBits(other.getShouldMoney()))
			return false;
		if (Double.doubleToLongBits(businessTax) != Double.doubleToLongBits(other.getBusinessTax()))
			return false;
		if (Double.doubleToLongBits(eduTax) != Double.doubleToLongBits(other.getEduTax()))
			return false;
		if (Double.doubleToLongBits(buildTax) != Double.doubleToLongBits(other.getBuildTax()))
			return false;
		if (Double.doubleToLongBits(busiCharge) != Double.doubleToLongBits(other.getBusiCharge()))
			return false;
		if (Double.doubleToLongBits(incomeTax) != Double.doubleToLongBits(other.getIncomeTax()))
			return false;
		if (Double.doubleToLongBits(sumMoney) != Double.doubleToLongBits(other.getSumMoney()))
			return false;
		if (Double.doubleToLongBits(afterTaxMoney) != Double.doubleToLongBits(other.getAfterTaxMoney()))
			return false;
		if (Double.doubleToLongBits(operInCome) != Double.doubleToLongBits(other.getOperInCome()))
			return false;
		if (Double.doubleToLongBits(t21) != Double.doubleToLongBits(other.getT21()))
			return false;
		if (Double.doubleToLongBits(t22) != Double.doubleToLongBits(other.getT22()))
			return false;
		if (Double.doubleToLongBits(t23) != Double.doubleToLongBits(other.getT23()))
			return false;
		if (Double.doubleToLongBits(t24) != Double.doubleToLongBits(other.getT24()))
			return false;
		return Double.doubleToLongBits(t25) == Double.doubleToLongBits(other.getT25());
	}

	public int getFieldCount()
	{
		return 148;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("indexCalNo"))
			return 0;
		if (strFieldName.equals("indexType"))
			return 1;
		if (strFieldName.equals("agentCode"))
			return 2;
		if (strFieldName.equals("agentGroup"))
			return 3;
		if (strFieldName.equals("manageCom"))
			return 4;
		if (strFieldName.equals("startDate"))
			return 5;
		if (strFieldName.equals("startEnd"))
			return 6;
		if (strFieldName.equals("quaBgnMark"))
			return 7;
		if (strFieldName.equals("serverMonths"))
			return 8;
		if (strFieldName.equals("postMonths"))
			return 9;
		if (strFieldName.equals("indMonthFYC"))
			return 10;
		if (strFieldName.equals("indMonthSYC"))
			return 11;
		if (strFieldName.equals("indMonSignFYC"))
			return 12;
		if (strFieldName.equals("indMonSignAFYC"))
			return 13;
		if (strFieldName.equals("indMonSignNAFYC"))
			return 14;
		if (strFieldName.equals("grpMonSignNAFYC"))
			return 15;
		if (strFieldName.equals("monPolCnt"))
			return 16;
		if (strFieldName.equals("montCustCnt"))
			return 17;
		if (strFieldName.equals("indMonPCount"))
			return 18;
		if (strFieldName.equals("sMmonPolContin"))
			return 19;
		if (strFieldName.equals("sMmonProduct"))
			return 20;
		if (strFieldName.equals("sMworkMon"))
			return 21;
		if (strFieldName.equals("monPCount"))
			return 22;
		if (strFieldName.equals("wSMMonPCount"))
			return 23;
		if (strFieldName.equals("lPMonForSMMP"))
			return 24;
		if (strFieldName.equals("lPMonForAMMP"))
			return 25;
		if (strFieldName.equals("lPpolContinute"))
			return 26;
		if (strFieldName.equals("monEligFLPCnt"))
			return 27;
		if (strFieldName.equals("tSRmonAFYP"))
			return 28;
		if (strFieldName.equals("tSRmonDedAFYP"))
			return 29;
		if (strFieldName.equals("tSRmonCompAFYP"))
			return 30;
		if (strFieldName.equals("tSRMonWorkDays"))
			return 31;
		if (strFieldName.equals("monManPower"))
			return 32;
		if (strFieldName.equals("monManCount"))
			return 33;
		if (strFieldName.equals("monSAFYPSum"))
			return 34;
		if (strFieldName.equals("monTLGrpSAFYPSum"))
			return 35;
		if (strFieldName.equals("indYearNAFYC"))
			return 36;
		if (strFieldName.equals("b12IndEffectAFYC"))
			return 37;
		if (strFieldName.equals("b12IndAllAFYC"))
			return 38;
		if (strFieldName.equals("b24IndEffectAFYC"))
			return 39;
		if (strFieldName.equals("b24IndAllAFYC"))
			return 40;
		if (strFieldName.equals("indQutFYC"))
			return 41;
		if (strFieldName.equals("lPproductivity"))
			return 42;
		if (strFieldName.equals("lPPPRate"))
			return 43;
		if (strFieldName.equals("lPPPBonus"))
			return 44;
		if (strFieldName.equals("lPFincSubsidy"))
			return 45;
		if (strFieldName.equals("subsidyRate"))
			return 46;
		if (strFieldName.equals("b12TeamNAFYC"))
			return 47;
		if (strFieldName.equals("sMOverride"))
			return 48;
		if (strFieldName.equals("teamMonAvgPCount"))
			return 49;
		if (strFieldName.equals("sMBasicSalary"))
			return 50;
		if (strFieldName.equals("sMproductivity"))
			return 51;
		if (strFieldName.equals("sMpolContinute"))
			return 52;
		if (strFieldName.equals("sMPPRate"))
			return 53;
		if (strFieldName.equals("sMPPBonus"))
			return 54;
		if (strFieldName.equals("b24TeamEffectAFYC"))
			return 55;
		if (strFieldName.equals("b24TeamAllAFYC"))
			return 56;
		if (strFieldName.equals("teamQutPremSum"))
			return 57;
		if (strFieldName.equals("sMRRBonus"))
			return 58;
		if (strFieldName.equals("sMManPowerDBonus"))
			return 59;
		if (strFieldName.equals("lPB12ForMPDBonus"))
			return 60;
		if (strFieldName.equals("sMUsualALLCSum"))
			return 61;
		if (strFieldName.equals("aMBasicSalary"))
			return 62;
		if (strFieldName.equals("aMproductivity"))
			return 63;
		if (strFieldName.equals("aMpolContinute"))
			return 64;
		if (strFieldName.equals("aMPPRate"))
			return 65;
		if (strFieldName.equals("aMPPBonus"))
			return 66;
		if (strFieldName.equals("b12DepNAFYC"))
			return 67;
		if (strFieldName.equals("aMOverride"))
			return 68;
		if (strFieldName.equals("depMonAvgPCount"))
			return 69;
		if (strFieldName.equals("depQutPremSum"))
			return 70;
		if (strFieldName.equals("aMRRBonus"))
			return 71;
		if (strFieldName.equals("aMManPowerDBonus"))
			return 72;
		if (strFieldName.equals("productGrowth"))
			return 73;
		if (strFieldName.equals("depQuaFYCSum"))
			return 74;
		if (strFieldName.equals("aMLiability"))
			return 75;
		if (strFieldName.equals("reviOpen"))
			return 76;
		if (strFieldName.equals("t1"))
			return 77;
		if (strFieldName.equals("t2"))
			return 78;
		if (strFieldName.equals("t3"))
			return 79;
		if (strFieldName.equals("t4"))
			return 80;
		if (strFieldName.equals("t5"))
			return 81;
		if (strFieldName.equals("t6"))
			return 82;
		if (strFieldName.equals("t7"))
			return 83;
		if (strFieldName.equals("t8"))
			return 84;
		if (strFieldName.equals("t9"))
			return 85;
		if (strFieldName.equals("t10"))
			return 86;
		if (strFieldName.equals("t11"))
			return 87;
		if (strFieldName.equals("t12"))
			return 88;
		if (strFieldName.equals("t13"))
			return 89;
		if (strFieldName.equals("t14"))
			return 90;
		if (strFieldName.equals("t15"))
			return 91;
		if (strFieldName.equals("t16"))
			return 92;
		if (strFieldName.equals("t17"))
			return 93;
		if (strFieldName.equals("t18"))
			return 94;
		if (strFieldName.equals("t20"))
			return 95;
		if (strFieldName.equals("t19"))
			return 96;
		if (strFieldName.equals("monthIndex"))
			return 97;
		if (strFieldName.equals("tMonthIndex"))
			return 98;
		if (strFieldName.equals("aSumIndex"))
			return 99;
		if (strFieldName.equals("wSMMonthEligible"))
			return 100;
		if (strFieldName.equals("lPQuaPCount"))
			return 101;
		if (strFieldName.equals("lPQuaFYCSum"))
			return 102;
		if (strFieldName.equals("b12LPPCount"))
			return 103;
		if (strFieldName.equals("b12LPNAFYCSum"))
			return 104;
		if (strFieldName.equals("wSMMonAFYC"))
			return 105;
		if (strFieldName.equals("wSMTwoMonAFYC"))
			return 106;
		if (strFieldName.equals("wSMB6AFYC"))
			return 107;
		if (strFieldName.equals("wSMB6PCount"))
			return 108;
		if (strFieldName.equals("netLiveLPCount"))
			return 109;
		if (strFieldName.equals("netComLPCount"))
			return 110;
		if (strFieldName.equals("wSMTwoMonPCount"))
			return 111;
		if (strFieldName.equals("lPAllNAFYC"))
			return 112;
		if (strFieldName.equals("lPAllPCount"))
			return 113;
		if (strFieldName.equals("monPerSAFYP"))
			return 114;
		if (strFieldName.equals("tSRThrMonSAFYP"))
			return 115;
		if (strFieldName.equals("tLThrMonPerSAFYP"))
			return 116;
		if (strFieldName.equals("monSubsistCnt"))
			return 117;
		if (strFieldName.equals("thrMonSubsistCnt"))
			return 118;
		if (strFieldName.equals("state"))
			return 119;
		if (strFieldName.equals("operator"))
			return 120;
		if (strFieldName.equals("makeDate"))
			return 121;
		if (strFieldName.equals("makeTime"))
			return 122;
		if (strFieldName.equals("modifyDate"))
			return 123;
		if (strFieldName.equals("modifyTime"))
			return 124;
		if (strFieldName.equals("assessMonth"))
			return 125;
		if (strFieldName.equals("branchAttr"))
			return 126;
		if (strFieldName.equals("agentGrade"))
			return 127;
		if (strFieldName.equals("clubPromBonus"))
			return 128;
		if (strFieldName.equals("clubGradeBonus"))
			return 129;
		if (strFieldName.equals("clubAssisBonus"))
			return 130;
		if (strFieldName.equals("clubSpecBonus"))
			return 131;
		if (strFieldName.equals("adddedMoney"))
			return 132;
		if (strFieldName.equals("lastMoney"))
			return 133;
		if (strFieldName.equals("shouldMoney"))
			return 134;
		if (strFieldName.equals("businessTax"))
			return 135;
		if (strFieldName.equals("eduTax"))
			return 136;
		if (strFieldName.equals("buildTax"))
			return 137;
		if (strFieldName.equals("busiCharge"))
			return 138;
		if (strFieldName.equals("incomeTax"))
			return 139;
		if (strFieldName.equals("sumMoney"))
			return 140;
		if (strFieldName.equals("afterTaxMoney"))
			return 141;
		if (strFieldName.equals("operInCome"))
			return 142;
		if (strFieldName.equals("t21"))
			return 143;
		if (strFieldName.equals("t22"))
			return 144;
		if (strFieldName.equals("t23"))
			return 145;
		if (strFieldName.equals("t24"))
			return 146;
		return !strFieldName.equals("t25") ? -1 : 147;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "indexCalNo";
			break;

		case 1: // '\001'
			strFieldName = "indexType";
			break;

		case 2: // '\002'
			strFieldName = "agentCode";
			break;

		case 3: // '\003'
			strFieldName = "agentGroup";
			break;

		case 4: // '\004'
			strFieldName = "manageCom";
			break;

		case 5: // '\005'
			strFieldName = "startDate";
			break;

		case 6: // '\006'
			strFieldName = "startEnd";
			break;

		case 7: // '\007'
			strFieldName = "quaBgnMark";
			break;

		case 8: // '\b'
			strFieldName = "serverMonths";
			break;

		case 9: // '\t'
			strFieldName = "postMonths";
			break;

		case 10: // '\n'
			strFieldName = "indMonthFYC";
			break;

		case 11: // '\013'
			strFieldName = "indMonthSYC";
			break;

		case 12: // '\f'
			strFieldName = "indMonSignFYC";
			break;

		case 13: // '\r'
			strFieldName = "indMonSignAFYC";
			break;

		case 14: // '\016'
			strFieldName = "indMonSignNAFYC";
			break;

		case 15: // '\017'
			strFieldName = "grpMonSignNAFYC";
			break;

		case 16: // '\020'
			strFieldName = "monPolCnt";
			break;

		case 17: // '\021'
			strFieldName = "montCustCnt";
			break;

		case 18: // '\022'
			strFieldName = "indMonPCount";
			break;

		case 19: // '\023'
			strFieldName = "sMmonPolContin";
			break;

		case 20: // '\024'
			strFieldName = "sMmonProduct";
			break;

		case 21: // '\025'
			strFieldName = "sMworkMon";
			break;

		case 22: // '\026'
			strFieldName = "monPCount";
			break;

		case 23: // '\027'
			strFieldName = "wSMMonPCount";
			break;

		case 24: // '\030'
			strFieldName = "lPMonForSMMP";
			break;

		case 25: // '\031'
			strFieldName = "lPMonForAMMP";
			break;

		case 26: // '\032'
			strFieldName = "lPpolContinute";
			break;

		case 27: // '\033'
			strFieldName = "monEligFLPCnt";
			break;

		case 28: // '\034'
			strFieldName = "tSRmonAFYP";
			break;

		case 29: // '\035'
			strFieldName = "tSRmonDedAFYP";
			break;

		case 30: // '\036'
			strFieldName = "tSRmonCompAFYP";
			break;

		case 31: // '\037'
			strFieldName = "tSRMonWorkDays";
			break;

		case 32: // ' '
			strFieldName = "monManPower";
			break;

		case 33: // '!'
			strFieldName = "monManCount";
			break;

		case 34: // '"'
			strFieldName = "monSAFYPSum";
			break;

		case 35: // '#'
			strFieldName = "monTLGrpSAFYPSum";
			break;

		case 36: // '$'
			strFieldName = "indYearNAFYC";
			break;

		case 37: // '%'
			strFieldName = "b12IndEffectAFYC";
			break;

		case 38: // '&'
			strFieldName = "b12IndAllAFYC";
			break;

		case 39: // '\''
			strFieldName = "b24IndEffectAFYC";
			break;

		case 40: // '('
			strFieldName = "b24IndAllAFYC";
			break;

		case 41: // ')'
			strFieldName = "indQutFYC";
			break;

		case 42: // '*'
			strFieldName = "lPproductivity";
			break;

		case 43: // '+'
			strFieldName = "lPPPRate";
			break;

		case 44: // ','
			strFieldName = "lPPPBonus";
			break;

		case 45: // '-'
			strFieldName = "lPFincSubsidy";
			break;

		case 46: // '.'
			strFieldName = "subsidyRate";
			break;

		case 47: // '/'
			strFieldName = "b12TeamNAFYC";
			break;

		case 48: // '0'
			strFieldName = "sMOverride";
			break;

		case 49: // '1'
			strFieldName = "teamMonAvgPCount";
			break;

		case 50: // '2'
			strFieldName = "sMBasicSalary";
			break;

		case 51: // '3'
			strFieldName = "sMproductivity";
			break;

		case 52: // '4'
			strFieldName = "sMpolContinute";
			break;

		case 53: // '5'
			strFieldName = "sMPPRate";
			break;

		case 54: // '6'
			strFieldName = "sMPPBonus";
			break;

		case 55: // '7'
			strFieldName = "b24TeamEffectAFYC";
			break;

		case 56: // '8'
			strFieldName = "b24TeamAllAFYC";
			break;

		case 57: // '9'
			strFieldName = "teamQutPremSum";
			break;

		case 58: // ':'
			strFieldName = "sMRRBonus";
			break;

		case 59: // ';'
			strFieldName = "sMManPowerDBonus";
			break;

		case 60: // '<'
			strFieldName = "lPB12ForMPDBonus";
			break;

		case 61: // '='
			strFieldName = "sMUsualALLCSum";
			break;

		case 62: // '>'
			strFieldName = "aMBasicSalary";
			break;

		case 63: // '?'
			strFieldName = "aMproductivity";
			break;

		case 64: // '@'
			strFieldName = "aMpolContinute";
			break;

		case 65: // 'A'
			strFieldName = "aMPPRate";
			break;

		case 66: // 'B'
			strFieldName = "aMPPBonus";
			break;

		case 67: // 'C'
			strFieldName = "b12DepNAFYC";
			break;

		case 68: // 'D'
			strFieldName = "aMOverride";
			break;

		case 69: // 'E'
			strFieldName = "depMonAvgPCount";
			break;

		case 70: // 'F'
			strFieldName = "depQutPremSum";
			break;

		case 71: // 'G'
			strFieldName = "aMRRBonus";
			break;

		case 72: // 'H'
			strFieldName = "aMManPowerDBonus";
			break;

		case 73: // 'I'
			strFieldName = "productGrowth";
			break;

		case 74: // 'J'
			strFieldName = "depQuaFYCSum";
			break;

		case 75: // 'K'
			strFieldName = "aMLiability";
			break;

		case 76: // 'L'
			strFieldName = "reviOpen";
			break;

		case 77: // 'M'
			strFieldName = "t1";
			break;

		case 78: // 'N'
			strFieldName = "t2";
			break;

		case 79: // 'O'
			strFieldName = "t3";
			break;

		case 80: // 'P'
			strFieldName = "t4";
			break;

		case 81: // 'Q'
			strFieldName = "t5";
			break;

		case 82: // 'R'
			strFieldName = "t6";
			break;

		case 83: // 'S'
			strFieldName = "t7";
			break;

		case 84: // 'T'
			strFieldName = "t8";
			break;

		case 85: // 'U'
			strFieldName = "t9";
			break;

		case 86: // 'V'
			strFieldName = "t10";
			break;

		case 87: // 'W'
			strFieldName = "t11";
			break;

		case 88: // 'X'
			strFieldName = "t12";
			break;

		case 89: // 'Y'
			strFieldName = "t13";
			break;

		case 90: // 'Z'
			strFieldName = "t14";
			break;

		case 91: // '['
			strFieldName = "t15";
			break;

		case 92: // '\\'
			strFieldName = "t16";
			break;

		case 93: // ']'
			strFieldName = "t17";
			break;

		case 94: // '^'
			strFieldName = "t18";
			break;

		case 95: // '_'
			strFieldName = "t20";
			break;

		case 96: // '`'
			strFieldName = "t19";
			break;

		case 97: // 'a'
			strFieldName = "monthIndex";
			break;

		case 98: // 'b'
			strFieldName = "tMonthIndex";
			break;

		case 99: // 'c'
			strFieldName = "aSumIndex";
			break;

		case 100: // 'd'
			strFieldName = "wSMMonthEligible";
			break;

		case 101: // 'e'
			strFieldName = "lPQuaPCount";
			break;

		case 102: // 'f'
			strFieldName = "lPQuaFYCSum";
			break;

		case 103: // 'g'
			strFieldName = "b12LPPCount";
			break;

		case 104: // 'h'
			strFieldName = "b12LPNAFYCSum";
			break;

		case 105: // 'i'
			strFieldName = "wSMMonAFYC";
			break;

		case 106: // 'j'
			strFieldName = "wSMTwoMonAFYC";
			break;

		case 107: // 'k'
			strFieldName = "wSMB6AFYC";
			break;

		case 108: // 'l'
			strFieldName = "wSMB6PCount";
			break;

		case 109: // 'm'
			strFieldName = "netLiveLPCount";
			break;

		case 110: // 'n'
			strFieldName = "netComLPCount";
			break;

		case 111: // 'o'
			strFieldName = "wSMTwoMonPCount";
			break;

		case 112: // 'p'
			strFieldName = "lPAllNAFYC";
			break;

		case 113: // 'q'
			strFieldName = "lPAllPCount";
			break;

		case 114: // 'r'
			strFieldName = "monPerSAFYP";
			break;

		case 115: // 's'
			strFieldName = "tSRThrMonSAFYP";
			break;

		case 116: // 't'
			strFieldName = "tLThrMonPerSAFYP";
			break;

		case 117: // 'u'
			strFieldName = "monSubsistCnt";
			break;

		case 118: // 'v'
			strFieldName = "thrMonSubsistCnt";
			break;

		case 119: // 'w'
			strFieldName = "state";
			break;

		case 120: // 'x'
			strFieldName = "operator";
			break;

		case 121: // 'y'
			strFieldName = "makeDate";
			break;

		case 122: // 'z'
			strFieldName = "makeTime";
			break;

		case 123: // '{'
			strFieldName = "modifyDate";
			break;

		case 124: // '|'
			strFieldName = "modifyTime";
			break;

		case 125: // '}'
			strFieldName = "assessMonth";
			break;

		case 126: // '~'
			strFieldName = "branchAttr";
			break;

		case 127: // '\177'
			strFieldName = "agentGrade";
			break;

		case 128: 
			strFieldName = "clubPromBonus";
			break;

		case 129: 
			strFieldName = "clubGradeBonus";
			break;

		case 130: 
			strFieldName = "clubAssisBonus";
			break;

		case 131: 
			strFieldName = "clubSpecBonus";
			break;

		case 132: 
			strFieldName = "adddedMoney";
			break;

		case 133: 
			strFieldName = "lastMoney";
			break;

		case 134: 
			strFieldName = "shouldMoney";
			break;

		case 135: 
			strFieldName = "businessTax";
			break;

		case 136: 
			strFieldName = "eduTax";
			break;

		case 137: 
			strFieldName = "buildTax";
			break;

		case 138: 
			strFieldName = "busiCharge";
			break;

		case 139: 
			strFieldName = "incomeTax";
			break;

		case 140: 
			strFieldName = "sumMoney";
			break;

		case 141: 
			strFieldName = "afterTaxMoney";
			break;

		case 142: 
			strFieldName = "operInCome";
			break;

		case 143: 
			strFieldName = "t21";
			break;

		case 144: 
			strFieldName = "t22";
			break;

		case 145: 
			strFieldName = "t23";
			break;

		case 146: 
			strFieldName = "t24";
			break;

		case 147: 
			strFieldName = "t25";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("indexCalNo"))
			return 0;
		if (strFieldName.equals("indexType"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("agentGroup"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("startEnd"))
			return 1;
		if (strFieldName.equals("quaBgnMark"))
			return 3;
		if (strFieldName.equals("serverMonths"))
			return 3;
		if (strFieldName.equals("postMonths"))
			return 3;
		if (strFieldName.equals("indMonthFYC"))
			return 4;
		if (strFieldName.equals("indMonthSYC"))
			return 4;
		if (strFieldName.equals("indMonSignFYC"))
			return 4;
		if (strFieldName.equals("indMonSignAFYC"))
			return 4;
		if (strFieldName.equals("indMonSignNAFYC"))
			return 4;
		if (strFieldName.equals("grpMonSignNAFYC"))
			return 4;
		if (strFieldName.equals("monPolCnt"))
			return 4;
		if (strFieldName.equals("montCustCnt"))
			return 4;
		if (strFieldName.equals("indMonPCount"))
			return 4;
		if (strFieldName.equals("sMmonPolContin"))
			return 4;
		if (strFieldName.equals("sMmonProduct"))
			return 4;
		if (strFieldName.equals("sMworkMon"))
			return 4;
		if (strFieldName.equals("monPCount"))
			return 4;
		if (strFieldName.equals("wSMMonPCount"))
			return 4;
		if (strFieldName.equals("lPMonForSMMP"))
			return 4;
		if (strFieldName.equals("lPMonForAMMP"))
			return 4;
		if (strFieldName.equals("lPpolContinute"))
			return 4;
		if (strFieldName.equals("monEligFLPCnt"))
			return 4;
		if (strFieldName.equals("tSRmonAFYP"))
			return 4;
		if (strFieldName.equals("tSRmonDedAFYP"))
			return 4;
		if (strFieldName.equals("tSRmonCompAFYP"))
			return 4;
		if (strFieldName.equals("tSRMonWorkDays"))
			return 4;
		if (strFieldName.equals("monManPower"))
			return 4;
		if (strFieldName.equals("monManCount"))
			return 4;
		if (strFieldName.equals("monSAFYPSum"))
			return 4;
		if (strFieldName.equals("monTLGrpSAFYPSum"))
			return 4;
		if (strFieldName.equals("indYearNAFYC"))
			return 4;
		if (strFieldName.equals("b12IndEffectAFYC"))
			return 4;
		if (strFieldName.equals("b12IndAllAFYC"))
			return 4;
		if (strFieldName.equals("b24IndEffectAFYC"))
			return 4;
		if (strFieldName.equals("b24IndAllAFYC"))
			return 4;
		if (strFieldName.equals("indQutFYC"))
			return 4;
		if (strFieldName.equals("lPproductivity"))
			return 4;
		if (strFieldName.equals("lPPPRate"))
			return 4;
		if (strFieldName.equals("lPPPBonus"))
			return 4;
		if (strFieldName.equals("lPFincSubsidy"))
			return 4;
		if (strFieldName.equals("subsidyRate"))
			return 4;
		if (strFieldName.equals("b12TeamNAFYC"))
			return 4;
		if (strFieldName.equals("sMOverride"))
			return 4;
		if (strFieldName.equals("teamMonAvgPCount"))
			return 4;
		if (strFieldName.equals("sMBasicSalary"))
			return 4;
		if (strFieldName.equals("sMproductivity"))
			return 4;
		if (strFieldName.equals("sMpolContinute"))
			return 4;
		if (strFieldName.equals("sMPPRate"))
			return 4;
		if (strFieldName.equals("sMPPBonus"))
			return 4;
		if (strFieldName.equals("b24TeamEffectAFYC"))
			return 4;
		if (strFieldName.equals("b24TeamAllAFYC"))
			return 4;
		if (strFieldName.equals("teamQutPremSum"))
			return 4;
		if (strFieldName.equals("sMRRBonus"))
			return 4;
		if (strFieldName.equals("sMManPowerDBonus"))
			return 4;
		if (strFieldName.equals("lPB12ForMPDBonus"))
			return 4;
		if (strFieldName.equals("sMUsualALLCSum"))
			return 4;
		if (strFieldName.equals("aMBasicSalary"))
			return 4;
		if (strFieldName.equals("aMproductivity"))
			return 4;
		if (strFieldName.equals("aMpolContinute"))
			return 4;
		if (strFieldName.equals("aMPPRate"))
			return 4;
		if (strFieldName.equals("aMPPBonus"))
			return 4;
		if (strFieldName.equals("b12DepNAFYC"))
			return 4;
		if (strFieldName.equals("aMOverride"))
			return 4;
		if (strFieldName.equals("depMonAvgPCount"))
			return 4;
		if (strFieldName.equals("depQutPremSum"))
			return 4;
		if (strFieldName.equals("aMRRBonus"))
			return 4;
		if (strFieldName.equals("aMManPowerDBonus"))
			return 4;
		if (strFieldName.equals("productGrowth"))
			return 4;
		if (strFieldName.equals("depQuaFYCSum"))
			return 4;
		if (strFieldName.equals("aMLiability"))
			return 4;
		if (strFieldName.equals("reviOpen"))
			return 4;
		if (strFieldName.equals("t1"))
			return 4;
		if (strFieldName.equals("t2"))
			return 4;
		if (strFieldName.equals("t3"))
			return 4;
		if (strFieldName.equals("t4"))
			return 4;
		if (strFieldName.equals("t5"))
			return 4;
		if (strFieldName.equals("t6"))
			return 4;
		if (strFieldName.equals("t7"))
			return 4;
		if (strFieldName.equals("t8"))
			return 4;
		if (strFieldName.equals("t9"))
			return 4;
		if (strFieldName.equals("t10"))
			return 4;
		if (strFieldName.equals("t11"))
			return 4;
		if (strFieldName.equals("t12"))
			return 4;
		if (strFieldName.equals("t13"))
			return 4;
		if (strFieldName.equals("t14"))
			return 4;
		if (strFieldName.equals("t15"))
			return 4;
		if (strFieldName.equals("t16"))
			return 4;
		if (strFieldName.equals("t17"))
			return 4;
		if (strFieldName.equals("t18"))
			return 4;
		if (strFieldName.equals("t20"))
			return 4;
		if (strFieldName.equals("t19"))
			return 4;
		if (strFieldName.equals("monthIndex"))
			return 4;
		if (strFieldName.equals("tMonthIndex"))
			return 4;
		if (strFieldName.equals("aSumIndex"))
			return 4;
		if (strFieldName.equals("wSMMonthEligible"))
			return 4;
		if (strFieldName.equals("lPQuaPCount"))
			return 4;
		if (strFieldName.equals("lPQuaFYCSum"))
			return 4;
		if (strFieldName.equals("b12LPPCount"))
			return 4;
		if (strFieldName.equals("b12LPNAFYCSum"))
			return 4;
		if (strFieldName.equals("wSMMonAFYC"))
			return 4;
		if (strFieldName.equals("wSMTwoMonAFYC"))
			return 4;
		if (strFieldName.equals("wSMB6AFYC"))
			return 4;
		if (strFieldName.equals("wSMB6PCount"))
			return 4;
		if (strFieldName.equals("netLiveLPCount"))
			return 4;
		if (strFieldName.equals("netComLPCount"))
			return 4;
		if (strFieldName.equals("wSMTwoMonPCount"))
			return 4;
		if (strFieldName.equals("lPAllNAFYC"))
			return 4;
		if (strFieldName.equals("lPAllPCount"))
			return 4;
		if (strFieldName.equals("monPerSAFYP"))
			return 4;
		if (strFieldName.equals("tSRThrMonSAFYP"))
			return 4;
		if (strFieldName.equals("tLThrMonPerSAFYP"))
			return 4;
		if (strFieldName.equals("monSubsistCnt"))
			return 4;
		if (strFieldName.equals("thrMonSubsistCnt"))
			return 4;
		if (strFieldName.equals("state"))
			return 0;
		if (strFieldName.equals("operator"))
			return 0;
		if (strFieldName.equals("makeDate"))
			return 1;
		if (strFieldName.equals("makeTime"))
			return 0;
		if (strFieldName.equals("modifyDate"))
			return 1;
		if (strFieldName.equals("modifyTime"))
			return 0;
		if (strFieldName.equals("assessMonth"))
			return 0;
		if (strFieldName.equals("branchAttr"))
			return 0;
		if (strFieldName.equals("agentGrade"))
			return 0;
		if (strFieldName.equals("clubPromBonus"))
			return 4;
		if (strFieldName.equals("clubGradeBonus"))
			return 4;
		if (strFieldName.equals("clubAssisBonus"))
			return 4;
		if (strFieldName.equals("clubSpecBonus"))
			return 4;
		if (strFieldName.equals("adddedMoney"))
			return 4;
		if (strFieldName.equals("lastMoney"))
			return 4;
		if (strFieldName.equals("shouldMoney"))
			return 4;
		if (strFieldName.equals("businessTax"))
			return 4;
		if (strFieldName.equals("eduTax"))
			return 4;
		if (strFieldName.equals("buildTax"))
			return 4;
		if (strFieldName.equals("busiCharge"))
			return 4;
		if (strFieldName.equals("incomeTax"))
			return 4;
		if (strFieldName.equals("sumMoney"))
			return 4;
		if (strFieldName.equals("afterTaxMoney"))
			return 4;
		if (strFieldName.equals("operInCome"))
			return 4;
		if (strFieldName.equals("t21"))
			return 4;
		if (strFieldName.equals("t22"))
			return 4;
		if (strFieldName.equals("t23"))
			return 4;
		if (strFieldName.equals("t24"))
			return 4;
		return !strFieldName.equals("t25") ? -1 : 4;
	}

	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = -1;
		switch (nFieldIndex)
		{
		case 0: // '\0'
			nFieldType = 0;
			break;

		case 1: // '\001'
			nFieldType = 0;
			break;

		case 2: // '\002'
			nFieldType = 0;
			break;

		case 3: // '\003'
			nFieldType = 0;
			break;

		case 4: // '\004'
			nFieldType = 0;
			break;

		case 5: // '\005'
			nFieldType = 1;
			break;

		case 6: // '\006'
			nFieldType = 1;
			break;

		case 7: // '\007'
			nFieldType = 3;
			break;

		case 8: // '\b'
			nFieldType = 3;
			break;

		case 9: // '\t'
			nFieldType = 3;
			break;

		case 10: // '\n'
			nFieldType = 4;
			break;

		case 11: // '\013'
			nFieldType = 4;
			break;

		case 12: // '\f'
			nFieldType = 4;
			break;

		case 13: // '\r'
			nFieldType = 4;
			break;

		case 14: // '\016'
			nFieldType = 4;
			break;

		case 15: // '\017'
			nFieldType = 4;
			break;

		case 16: // '\020'
			nFieldType = 4;
			break;

		case 17: // '\021'
			nFieldType = 4;
			break;

		case 18: // '\022'
			nFieldType = 4;
			break;

		case 19: // '\023'
			nFieldType = 4;
			break;

		case 20: // '\024'
			nFieldType = 4;
			break;

		case 21: // '\025'
			nFieldType = 4;
			break;

		case 22: // '\026'
			nFieldType = 4;
			break;

		case 23: // '\027'
			nFieldType = 4;
			break;

		case 24: // '\030'
			nFieldType = 4;
			break;

		case 25: // '\031'
			nFieldType = 4;
			break;

		case 26: // '\032'
			nFieldType = 4;
			break;

		case 27: // '\033'
			nFieldType = 4;
			break;

		case 28: // '\034'
			nFieldType = 4;
			break;

		case 29: // '\035'
			nFieldType = 4;
			break;

		case 30: // '\036'
			nFieldType = 4;
			break;

		case 31: // '\037'
			nFieldType = 4;
			break;

		case 32: // ' '
			nFieldType = 4;
			break;

		case 33: // '!'
			nFieldType = 4;
			break;

		case 34: // '"'
			nFieldType = 4;
			break;

		case 35: // '#'
			nFieldType = 4;
			break;

		case 36: // '$'
			nFieldType = 4;
			break;

		case 37: // '%'
			nFieldType = 4;
			break;

		case 38: // '&'
			nFieldType = 4;
			break;

		case 39: // '\''
			nFieldType = 4;
			break;

		case 40: // '('
			nFieldType = 4;
			break;

		case 41: // ')'
			nFieldType = 4;
			break;

		case 42: // '*'
			nFieldType = 4;
			break;

		case 43: // '+'
			nFieldType = 4;
			break;

		case 44: // ','
			nFieldType = 4;
			break;

		case 45: // '-'
			nFieldType = 4;
			break;

		case 46: // '.'
			nFieldType = 4;
			break;

		case 47: // '/'
			nFieldType = 4;
			break;

		case 48: // '0'
			nFieldType = 4;
			break;

		case 49: // '1'
			nFieldType = 4;
			break;

		case 50: // '2'
			nFieldType = 4;
			break;

		case 51: // '3'
			nFieldType = 4;
			break;

		case 52: // '4'
			nFieldType = 4;
			break;

		case 53: // '5'
			nFieldType = 4;
			break;

		case 54: // '6'
			nFieldType = 4;
			break;

		case 55: // '7'
			nFieldType = 4;
			break;

		case 56: // '8'
			nFieldType = 4;
			break;

		case 57: // '9'
			nFieldType = 4;
			break;

		case 58: // ':'
			nFieldType = 4;
			break;

		case 59: // ';'
			nFieldType = 4;
			break;

		case 60: // '<'
			nFieldType = 4;
			break;

		case 61: // '='
			nFieldType = 4;
			break;

		case 62: // '>'
			nFieldType = 4;
			break;

		case 63: // '?'
			nFieldType = 4;
			break;

		case 64: // '@'
			nFieldType = 4;
			break;

		case 65: // 'A'
			nFieldType = 4;
			break;

		case 66: // 'B'
			nFieldType = 4;
			break;

		case 67: // 'C'
			nFieldType = 4;
			break;

		case 68: // 'D'
			nFieldType = 4;
			break;

		case 69: // 'E'
			nFieldType = 4;
			break;

		case 70: // 'F'
			nFieldType = 4;
			break;

		case 71: // 'G'
			nFieldType = 4;
			break;

		case 72: // 'H'
			nFieldType = 4;
			break;

		case 73: // 'I'
			nFieldType = 4;
			break;

		case 74: // 'J'
			nFieldType = 4;
			break;

		case 75: // 'K'
			nFieldType = 4;
			break;

		case 76: // 'L'
			nFieldType = 4;
			break;

		case 77: // 'M'
			nFieldType = 4;
			break;

		case 78: // 'N'
			nFieldType = 4;
			break;

		case 79: // 'O'
			nFieldType = 4;
			break;

		case 80: // 'P'
			nFieldType = 4;
			break;

		case 81: // 'Q'
			nFieldType = 4;
			break;

		case 82: // 'R'
			nFieldType = 4;
			break;

		case 83: // 'S'
			nFieldType = 4;
			break;

		case 84: // 'T'
			nFieldType = 4;
			break;

		case 85: // 'U'
			nFieldType = 4;
			break;

		case 86: // 'V'
			nFieldType = 4;
			break;

		case 87: // 'W'
			nFieldType = 4;
			break;

		case 88: // 'X'
			nFieldType = 4;
			break;

		case 89: // 'Y'
			nFieldType = 4;
			break;

		case 90: // 'Z'
			nFieldType = 4;
			break;

		case 91: // '['
			nFieldType = 4;
			break;

		case 92: // '\\'
			nFieldType = 4;
			break;

		case 93: // ']'
			nFieldType = 4;
			break;

		case 94: // '^'
			nFieldType = 4;
			break;

		case 95: // '_'
			nFieldType = 4;
			break;

		case 96: // '`'
			nFieldType = 4;
			break;

		case 97: // 'a'
			nFieldType = 4;
			break;

		case 98: // 'b'
			nFieldType = 4;
			break;

		case 99: // 'c'
			nFieldType = 4;
			break;

		case 100: // 'd'
			nFieldType = 4;
			break;

		case 101: // 'e'
			nFieldType = 4;
			break;

		case 102: // 'f'
			nFieldType = 4;
			break;

		case 103: // 'g'
			nFieldType = 4;
			break;

		case 104: // 'h'
			nFieldType = 4;
			break;

		case 105: // 'i'
			nFieldType = 4;
			break;

		case 106: // 'j'
			nFieldType = 4;
			break;

		case 107: // 'k'
			nFieldType = 4;
			break;

		case 108: // 'l'
			nFieldType = 4;
			break;

		case 109: // 'm'
			nFieldType = 4;
			break;

		case 110: // 'n'
			nFieldType = 4;
			break;

		case 111: // 'o'
			nFieldType = 4;
			break;

		case 112: // 'p'
			nFieldType = 4;
			break;

		case 113: // 'q'
			nFieldType = 4;
			break;

		case 114: // 'r'
			nFieldType = 4;
			break;

		case 115: // 's'
			nFieldType = 4;
			break;

		case 116: // 't'
			nFieldType = 4;
			break;

		case 117: // 'u'
			nFieldType = 4;
			break;

		case 118: // 'v'
			nFieldType = 4;
			break;

		case 119: // 'w'
			nFieldType = 0;
			break;

		case 120: // 'x'
			nFieldType = 0;
			break;

		case 121: // 'y'
			nFieldType = 1;
			break;

		case 122: // 'z'
			nFieldType = 0;
			break;

		case 123: // '{'
			nFieldType = 1;
			break;

		case 124: // '|'
			nFieldType = 0;
			break;

		case 125: // '}'
			nFieldType = 0;
			break;

		case 126: // '~'
			nFieldType = 0;
			break;

		case 127: // '\177'
			nFieldType = 0;
			break;

		case 128: 
			nFieldType = 4;
			break;

		case 129: 
			nFieldType = 4;
			break;

		case 130: 
			nFieldType = 4;
			break;

		case 131: 
			nFieldType = 4;
			break;

		case 132: 
			nFieldType = 4;
			break;

		case 133: 
			nFieldType = 4;
			break;

		case 134: 
			nFieldType = 4;
			break;

		case 135: 
			nFieldType = 4;
			break;

		case 136: 
			nFieldType = 4;
			break;

		case 137: 
			nFieldType = 4;
			break;

		case 138: 
			nFieldType = 4;
			break;

		case 139: 
			nFieldType = 4;
			break;

		case 140: 
			nFieldType = 4;
			break;

		case 141: 
			nFieldType = 4;
			break;

		case 142: 
			nFieldType = 4;
			break;

		case 143: 
			nFieldType = 4;
			break;

		case 144: 
			nFieldType = 4;
			break;

		case 145: 
			nFieldType = 4;
			break;

		case 146: 
			nFieldType = 4;
			break;

		case 147: 
			nFieldType = 4;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
