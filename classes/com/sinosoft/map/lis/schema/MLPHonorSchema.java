// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLPHonorSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.MLPHonorDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MLPHonorSchema
	implements Schema, Cloneable
{

	private String statYear;
	private String statBatch;
	private String agentCode;
	private String manageCom;
	private String branchType;
	private Date startDate;
	private Date endDate;
	private String name;
	private Date employDate;
	private String branchAttr;
	private String agentGrade;
	private String sMManagerName;
	private String aMManagerName;
	private String rMManagerName;
	private double t1;
	private double t2;
	private double t3;
	private double t4;
	private double t5;
	private double t6;
	private String t7;
	private String t8;
	private String t9;
	private double t10;
	private double t11;
	private double t12;
	private String aMManager;
	private String rMManager;
	private String sMManager;
	private String t13;
	private String t14;
	private double t15;
	private Date outWorkDate;
	private double t16;
	private double t17;
	private double t18;
	private String t19;
	private double t20;
	private double t21;
	private String t22;
	private String sMManager2;
	private String rMManager2;
	private String vF01;
	private String nF01;
	private int iF01;
	private double dF02;
	private Date date01;
	private String modifyOperator;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	private double c1;
	private double c2;
	private double c3;
	private double c4;
	private double c5;
	private double c6;
	private double c7;
	private double c8;
	private double c9;
	private double c10;
	public static final int FIELDNUM = 63;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public MLPHonorSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[3];
		pk[0] = "StatYear";
		pk[1] = "StatBatch";
		pk[2] = "AgentCode";
		PK = pk;
	}

	public Object clone()
		throws CloneNotSupportedException
	{
		MLPHonorSchema cloned = (MLPHonorSchema)super.clone();
		cloned.fDate = (FDate)fDate.clone();
		cloned.mErrors = (CErrors)mErrors.clone();
		return cloned;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getStatYear()
	{
		return statYear;
	}

	public void setStatYear(String aStatYear)
	{
		statYear = aStatYear;
	}

	public String getStatBatch()
	{
		return statBatch;
	}

	public void setStatBatch(String aStatBatch)
	{
		statBatch = aStatBatch;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getBranchType()
	{
		return branchType;
	}

	public void setBranchType(String aBranchType)
	{
		branchType = aBranchType;
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

	public String getEndDate()
	{
		if (endDate != null)
			return fDate.getString(endDate);
		else
			return null;
	}

	public void setEndDate(Date aEndDate)
	{
		endDate = aEndDate;
	}

	public void setEndDate(String aEndDate)
	{
		if (aEndDate != null && !aEndDate.equals(""))
			endDate = fDate.getDate(aEndDate);
		else
			endDate = null;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		name = aName;
	}

	public String getEmployDate()
	{
		if (employDate != null)
			return fDate.getString(employDate);
		else
			return null;
	}

	public void setEmployDate(Date aEmployDate)
	{
		employDate = aEmployDate;
	}

	public void setEmployDate(String aEmployDate)
	{
		if (aEmployDate != null && !aEmployDate.equals(""))
			employDate = fDate.getDate(aEmployDate);
		else
			employDate = null;
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

	public String getSMManagerName()
	{
		return sMManagerName;
	}

	public void setSMManagerName(String aSMManagerName)
	{
		sMManagerName = aSMManagerName;
	}

	public String getAMManagerName()
	{
		return aMManagerName;
	}

	public void setAMManagerName(String aAMManagerName)
	{
		aMManagerName = aAMManagerName;
	}

	public String getRMManagerName()
	{
		return rMManagerName;
	}

	public void setRMManagerName(String aRMManagerName)
	{
		rMManagerName = aRMManagerName;
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

	public String getT7()
	{
		return t7;
	}

	public void setT7(String aT7)
	{
		t7 = aT7;
	}

	public String getT8()
	{
		return t8;
	}

	public void setT8(String aT8)
	{
		t8 = aT8;
	}

	public String getT9()
	{
		return t9;
	}

	public void setT9(String aT9)
	{
		t9 = aT9;
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

	public String getAMManager()
	{
		return aMManager;
	}

	public void setAMManager(String aAMManager)
	{
		aMManager = aAMManager;
	}

	public String getRMManager()
	{
		return rMManager;
	}

	public void setRMManager(String aRMManager)
	{
		rMManager = aRMManager;
	}

	public String getSMManager()
	{
		return sMManager;
	}

	public void setSMManager(String aSMManager)
	{
		sMManager = aSMManager;
	}

	public String getT13()
	{
		return t13;
	}

	public void setT13(String aT13)
	{
		t13 = aT13;
	}

	public String getT14()
	{
		return t14;
	}

	public void setT14(String aT14)
	{
		t14 = aT14;
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

	public String getOutWorkDate()
	{
		if (outWorkDate != null)
			return fDate.getString(outWorkDate);
		else
			return null;
	}

	public void setOutWorkDate(Date aOutWorkDate)
	{
		outWorkDate = aOutWorkDate;
	}

	public void setOutWorkDate(String aOutWorkDate)
	{
		if (aOutWorkDate != null && !aOutWorkDate.equals(""))
			outWorkDate = fDate.getDate(aOutWorkDate);
		else
			outWorkDate = null;
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

	public String getT19()
	{
		return t19;
	}

	public void setT19(String aT19)
	{
		t19 = aT19;
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

	public String getT22()
	{
		return t22;
	}

	public void setT22(String aT22)
	{
		t22 = aT22;
	}

	public String getSMManager2()
	{
		return sMManager2;
	}

	public void setSMManager2(String aSMManager2)
	{
		sMManager2 = aSMManager2;
	}

	public String getRMManager2()
	{
		return rMManager2;
	}

	public void setRMManager2(String aRMManager2)
	{
		rMManager2 = aRMManager2;
	}

	public String getVF01()
	{
		return vF01;
	}

	public void setVF01(String aVF01)
	{
		vF01 = aVF01;
	}

	public String getNF01()
	{
		return nF01;
	}

	public void setNF01(String aNF01)
	{
		nF01 = aNF01;
	}

	public int getIF01()
	{
		return iF01;
	}

	public void setIF01(int aIF01)
	{
		iF01 = aIF01;
	}

	public void setIF01(String aIF01)
	{
		if (aIF01 != null && !aIF01.equals(""))
		{
			Integer tInteger = new Integer(aIF01);
			int i = tInteger.intValue();
			iF01 = i;
		}
	}

	public double getDF02()
	{
		return dF02;
	}

	public void setDF02(double aDF02)
	{
		dF02 = aDF02;
	}

	public void setDF02(String aDF02)
	{
		if (aDF02 != null && !aDF02.equals(""))
		{
			Double tDouble = new Double(aDF02);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
	}

	public String getDate01()
	{
		if (date01 != null)
			return fDate.getString(date01);
		else
			return null;
	}

	public void setDate01(Date aDate01)
	{
		date01 = aDate01;
	}

	public void setDate01(String aDate01)
	{
		if (aDate01 != null && !aDate01.equals(""))
			date01 = fDate.getDate(aDate01);
		else
			date01 = null;
	}

	public String getModifyOperator()
	{
		return modifyOperator;
	}

	public void setModifyOperator(String aModifyOperator)
	{
		modifyOperator = aModifyOperator;
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

	public double getC1()
	{
		return c1;
	}

	public void setC1(double aC1)
	{
		c1 = aC1;
	}

	public void setC1(String aC1)
	{
		if (aC1 != null && !aC1.equals(""))
		{
			Double tDouble = new Double(aC1);
			double d = tDouble.doubleValue();
			c1 = d;
		}
	}

	public double getC2()
	{
		return c2;
	}

	public void setC2(double aC2)
	{
		c2 = aC2;
	}

	public void setC2(String aC2)
	{
		if (aC2 != null && !aC2.equals(""))
		{
			Double tDouble = new Double(aC2);
			double d = tDouble.doubleValue();
			c2 = d;
		}
	}

	public double getC3()
	{
		return c3;
	}

	public void setC3(double aC3)
	{
		c3 = aC3;
	}

	public void setC3(String aC3)
	{
		if (aC3 != null && !aC3.equals(""))
		{
			Double tDouble = new Double(aC3);
			double d = tDouble.doubleValue();
			c3 = d;
		}
	}

	public double getC4()
	{
		return c4;
	}

	public void setC4(double aC4)
	{
		c4 = aC4;
	}

	public void setC4(String aC4)
	{
		if (aC4 != null && !aC4.equals(""))
		{
			Double tDouble = new Double(aC4);
			double d = tDouble.doubleValue();
			c4 = d;
		}
	}

	public double getC5()
	{
		return c5;
	}

	public void setC5(double aC5)
	{
		c5 = aC5;
	}

	public void setC5(String aC5)
	{
		if (aC5 != null && !aC5.equals(""))
		{
			Double tDouble = new Double(aC5);
			double d = tDouble.doubleValue();
			c5 = d;
		}
	}

	public double getC6()
	{
		return c6;
	}

	public void setC6(double aC6)
	{
		c6 = aC6;
	}

	public void setC6(String aC6)
	{
		if (aC6 != null && !aC6.equals(""))
		{
			Double tDouble = new Double(aC6);
			double d = tDouble.doubleValue();
			c6 = d;
		}
	}

	public double getC7()
	{
		return c7;
	}

	public void setC7(double aC7)
	{
		c7 = aC7;
	}

	public void setC7(String aC7)
	{
		if (aC7 != null && !aC7.equals(""))
		{
			Double tDouble = new Double(aC7);
			double d = tDouble.doubleValue();
			c7 = d;
		}
	}

	public double getC8()
	{
		return c8;
	}

	public void setC8(double aC8)
	{
		c8 = aC8;
	}

	public void setC8(String aC8)
	{
		if (aC8 != null && !aC8.equals(""))
		{
			Double tDouble = new Double(aC8);
			double d = tDouble.doubleValue();
			c8 = d;
		}
	}

	public double getC9()
	{
		return c9;
	}

	public void setC9(double aC9)
	{
		c9 = aC9;
	}

	public void setC9(String aC9)
	{
		if (aC9 != null && !aC9.equals(""))
		{
			Double tDouble = new Double(aC9);
			double d = tDouble.doubleValue();
			c9 = d;
		}
	}

	public double getC10()
	{
		return c10;
	}

	public void setC10(double aC10)
	{
		c10 = aC10;
	}

	public void setC10(String aC10)
	{
		if (aC10 != null && !aC10.equals(""))
		{
			Double tDouble = new Double(aC10);
			double d = tDouble.doubleValue();
			c10 = d;
		}
	}

	public void setSchema(MLPHonorSchema aMLPHonorSchema)
	{
		statYear = aMLPHonorSchema.getStatYear();
		statBatch = aMLPHonorSchema.getStatBatch();
		agentCode = aMLPHonorSchema.getAgentCode();
		manageCom = aMLPHonorSchema.getManageCom();
		branchType = aMLPHonorSchema.getBranchType();
		startDate = fDate.getDate(aMLPHonorSchema.getStartDate());
		endDate = fDate.getDate(aMLPHonorSchema.getEndDate());
		name = aMLPHonorSchema.getName();
		employDate = fDate.getDate(aMLPHonorSchema.getEmployDate());
		branchAttr = aMLPHonorSchema.getBranchAttr();
		agentGrade = aMLPHonorSchema.getAgentGrade();
		sMManagerName = aMLPHonorSchema.getSMManagerName();
		aMManagerName = aMLPHonorSchema.getAMManagerName();
		rMManagerName = aMLPHonorSchema.getRMManagerName();
		t1 = aMLPHonorSchema.getT1();
		t2 = aMLPHonorSchema.getT2();
		t3 = aMLPHonorSchema.getT3();
		t4 = aMLPHonorSchema.getT4();
		t5 = aMLPHonorSchema.getT5();
		t6 = aMLPHonorSchema.getT6();
		t7 = aMLPHonorSchema.getT7();
		t8 = aMLPHonorSchema.getT8();
		t9 = aMLPHonorSchema.getT9();
		t10 = aMLPHonorSchema.getT10();
		t11 = aMLPHonorSchema.getT11();
		t12 = aMLPHonorSchema.getT12();
		aMManager = aMLPHonorSchema.getAMManager();
		rMManager = aMLPHonorSchema.getRMManager();
		sMManager = aMLPHonorSchema.getSMManager();
		t13 = aMLPHonorSchema.getT13();
		t14 = aMLPHonorSchema.getT14();
		t15 = aMLPHonorSchema.getT15();
		outWorkDate = fDate.getDate(aMLPHonorSchema.getOutWorkDate());
		t16 = aMLPHonorSchema.getT16();
		t17 = aMLPHonorSchema.getT17();
		t18 = aMLPHonorSchema.getT18();
		t19 = aMLPHonorSchema.getT19();
		t20 = aMLPHonorSchema.getT20();
		t21 = aMLPHonorSchema.getT21();
		t22 = aMLPHonorSchema.getT22();
		sMManager2 = aMLPHonorSchema.getSMManager2();
		rMManager2 = aMLPHonorSchema.getRMManager2();
		vF01 = aMLPHonorSchema.getVF01();
		nF01 = aMLPHonorSchema.getNF01();
		iF01 = aMLPHonorSchema.getIF01();
		dF02 = aMLPHonorSchema.getDF02();
		date01 = fDate.getDate(aMLPHonorSchema.getDate01());
		modifyOperator = aMLPHonorSchema.getModifyOperator();
		operator = aMLPHonorSchema.getOperator();
		makeDate = fDate.getDate(aMLPHonorSchema.getMakeDate());
		makeTime = aMLPHonorSchema.getMakeTime();
		modifyDate = fDate.getDate(aMLPHonorSchema.getModifyDate());
		modifyTime = aMLPHonorSchema.getModifyTime();
		c1 = aMLPHonorSchema.getC1();
		c2 = aMLPHonorSchema.getC2();
		c3 = aMLPHonorSchema.getC3();
		c4 = aMLPHonorSchema.getC4();
		c5 = aMLPHonorSchema.getC5();
		c6 = aMLPHonorSchema.getC6();
		c7 = aMLPHonorSchema.getC7();
		c8 = aMLPHonorSchema.getC8();
		c9 = aMLPHonorSchema.getC9();
		c10 = aMLPHonorSchema.getC10();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("StatYear") == null)
				statYear = null;
			else
				statYear = rs.getString("StatYear").trim();
			if (rs.getString("StatBatch") == null)
				statBatch = null;
			else
				statBatch = rs.getString("StatBatch").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("BranchType") == null)
				branchType = null;
			else
				branchType = rs.getString("BranchType").trim();
			startDate = rs.getDate("StartDate");
			endDate = rs.getDate("EndDate");
			if (rs.getString("Name") == null)
				name = null;
			else
				name = rs.getString("Name").trim();
			employDate = rs.getDate("EmployDate");
			if (rs.getString("BranchAttr") == null)
				branchAttr = null;
			else
				branchAttr = rs.getString("BranchAttr").trim();
			if (rs.getString("AgentGrade") == null)
				agentGrade = null;
			else
				agentGrade = rs.getString("AgentGrade").trim();
			if (rs.getString("SMManagerName") == null)
				sMManagerName = null;
			else
				sMManagerName = rs.getString("SMManagerName").trim();
			if (rs.getString("AMManagerName") == null)
				aMManagerName = null;
			else
				aMManagerName = rs.getString("AMManagerName").trim();
			if (rs.getString("RMManagerName") == null)
				rMManagerName = null;
			else
				rMManagerName = rs.getString("RMManagerName").trim();
			t1 = rs.getDouble("T1");
			t2 = rs.getDouble("T2");
			t3 = rs.getDouble("T3");
			t4 = rs.getDouble("T4");
			t5 = rs.getDouble("T5");
			t6 = rs.getDouble("T6");
			if (rs.getString("T7") == null)
				t7 = null;
			else
				t7 = rs.getString("T7").trim();
			if (rs.getString("T8") == null)
				t8 = null;
			else
				t8 = rs.getString("T8").trim();
			if (rs.getString("T9") == null)
				t9 = null;
			else
				t9 = rs.getString("T9").trim();
			t10 = rs.getDouble("T10");
			t11 = rs.getDouble("T11");
			t12 = rs.getDouble("T12");
			if (rs.getString("AMManager") == null)
				aMManager = null;
			else
				aMManager = rs.getString("AMManager").trim();
			if (rs.getString("RMManager") == null)
				rMManager = null;
			else
				rMManager = rs.getString("RMManager").trim();
			if (rs.getString("SMManager") == null)
				sMManager = null;
			else
				sMManager = rs.getString("SMManager").trim();
			if (rs.getString("T13") == null)
				t13 = null;
			else
				t13 = rs.getString("T13").trim();
			if (rs.getString("T14") == null)
				t14 = null;
			else
				t14 = rs.getString("T14").trim();
			t15 = rs.getDouble("T15");
			outWorkDate = rs.getDate("OutWorkDate");
			t16 = rs.getDouble("T16");
			t17 = rs.getDouble("T17");
			t18 = rs.getDouble("T18");
			if (rs.getString("T19") == null)
				t19 = null;
			else
				t19 = rs.getString("T19").trim();
			t20 = rs.getDouble("T20");
			t21 = rs.getDouble("T21");
			if (rs.getString("T22") == null)
				t22 = null;
			else
				t22 = rs.getString("T22").trim();
			if (rs.getString("SMManager2") == null)
				sMManager2 = null;
			else
				sMManager2 = rs.getString("SMManager2").trim();
			if (rs.getString("RMManager2") == null)
				rMManager2 = null;
			else
				rMManager2 = rs.getString("RMManager2").trim();
			if (rs.getString("VF01") == null)
				vF01 = null;
			else
				vF01 = rs.getString("VF01").trim();
			if (rs.getString("NF01") == null)
				nF01 = null;
			else
				nF01 = rs.getString("NF01").trim();
			iF01 = rs.getInt("IF01");
			dF02 = rs.getDouble("DF02");
			date01 = rs.getDate("Date01");
			if (rs.getString("ModifyOperator") == null)
				modifyOperator = null;
			else
				modifyOperator = rs.getString("ModifyOperator").trim();
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
			c1 = rs.getDouble("C1");
			c2 = rs.getDouble("C2");
			c3 = rs.getDouble("C3");
			c4 = rs.getDouble("C4");
			c5 = rs.getDouble("C5");
			c6 = rs.getDouble("C6");
			c7 = rs.getDouble("C7");
			c8 = rs.getDouble("C8");
			c9 = rs.getDouble("C9");
			c10 = rs.getDouble("C10");
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的MLPHonor表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "MLPHonorSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public MLPHonorSchema getSchema()
	{
		MLPHonorSchema aMLPHonorSchema = new MLPHonorSchema();
		aMLPHonorSchema.setSchema(this);
		return aMLPHonorSchema;
	}

	public MLPHonorDB getDB()
	{
		MLPHonorDB aDBOper = new MLPHonorDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(statYear));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(statBatch));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchType));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(endDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(name));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(employDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchAttr));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sMManagerName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(aMManagerName));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rMManagerName));
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
		strReturn.append(StrTool.cTrim(t7));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(t8));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(t9));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t10));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t11));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t12));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(aMManager));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rMManager));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sMManager));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(t13));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(t14));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t15));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(outWorkDate)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t16));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t17));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t18));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(t19));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t20));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(t21));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(t22));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(sMManager2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(rMManager2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vF01));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(nF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(dF02));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(date01)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(modifyOperator));
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
		strReturn.append(ChgData.chgData(c1));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c2));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c3));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c4));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c5));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c6));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c7));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c8));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c9));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(c10));
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			statYear = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			statBatch = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			branchType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|"));
			endDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
			name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			employDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
			branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			sMManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			aMManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			rMManagerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			t1 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 15, "|")))).doubleValue();
			t2 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 16, "|")))).doubleValue();
			t3 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 17, "|")))).doubleValue();
			t4 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 18, "|")))).doubleValue();
			t5 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 19, "|")))).doubleValue();
			t6 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 20, "|")))).doubleValue();
			t7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			t8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			t9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			t10 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 24, "|")))).doubleValue();
			t11 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 25, "|")))).doubleValue();
			t12 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 26, "|")))).doubleValue();
			aMManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			rMManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			sMManager = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			t13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			t14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			t15 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).doubleValue();
			outWorkDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|"));
			t16 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|")))).doubleValue();
			t17 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|")))).doubleValue();
			t18 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|")))).doubleValue();
			t19 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			t20 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|")))).doubleValue();
			t21 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|")))).doubleValue();
			t22 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			sMManager2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			rMManager2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			vF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			nF01 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			iF01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|")))).intValue();
			dF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 46, "|")))).doubleValue();
			date01 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 47, "|"));
			modifyOperator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 48, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 49, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 50, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 51, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 52, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 53, "|");
			c1 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 54, "|")))).doubleValue();
			c2 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|")))).doubleValue();
			c3 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|")))).doubleValue();
			c4 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).doubleValue();
			c5 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).doubleValue();
			c6 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).doubleValue();
			c7 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).doubleValue();
			c8 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|")))).doubleValue();
			c9 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|")))).doubleValue();
			c10 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|")))).doubleValue();
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLPHonorSchema";
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
		if (FCode.equalsIgnoreCase("statYear"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(statYear));
		if (FCode.equalsIgnoreCase("statBatch"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(statBatch));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("branchType"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchType));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("endDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
		if (FCode.equalsIgnoreCase("name"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(name));
		if (FCode.equalsIgnoreCase("employDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getEmployDate()));
		if (FCode.equalsIgnoreCase("branchAttr"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchAttr));
		if (FCode.equalsIgnoreCase("agentGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade));
		if (FCode.equalsIgnoreCase("sMManagerName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMManagerName));
		if (FCode.equalsIgnoreCase("aMManagerName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMManagerName));
		if (FCode.equalsIgnoreCase("rMManagerName"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rMManagerName));
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
		if (FCode.equalsIgnoreCase("aMManager"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(aMManager));
		if (FCode.equalsIgnoreCase("rMManager"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rMManager));
		if (FCode.equalsIgnoreCase("sMManager"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMManager));
		if (FCode.equalsIgnoreCase("t13"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t13));
		if (FCode.equalsIgnoreCase("t14"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t14));
		if (FCode.equalsIgnoreCase("t15"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t15));
		if (FCode.equalsIgnoreCase("outWorkDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getOutWorkDate()));
		if (FCode.equalsIgnoreCase("t16"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t16));
		if (FCode.equalsIgnoreCase("t17"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t17));
		if (FCode.equalsIgnoreCase("t18"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t18));
		if (FCode.equalsIgnoreCase("t19"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t19));
		if (FCode.equalsIgnoreCase("t20"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t20));
		if (FCode.equalsIgnoreCase("t21"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t21));
		if (FCode.equalsIgnoreCase("t22"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(t22));
		if (FCode.equalsIgnoreCase("sMManager2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(sMManager2));
		if (FCode.equalsIgnoreCase("rMManager2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(rMManager2));
		if (FCode.equalsIgnoreCase("vF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vF01));
		if (FCode.equalsIgnoreCase("nF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF01));
		if (FCode.equalsIgnoreCase("iF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iF01));
		if (FCode.equalsIgnoreCase("dF02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(dF02));
		if (FCode.equalsIgnoreCase("date01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getDate01()));
		if (FCode.equalsIgnoreCase("modifyOperator"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(modifyOperator));
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
		if (FCode.equalsIgnoreCase("c1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c1));
		if (FCode.equalsIgnoreCase("c2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c2));
		if (FCode.equalsIgnoreCase("c3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c3));
		if (FCode.equalsIgnoreCase("c4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c4));
		if (FCode.equalsIgnoreCase("c5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c5));
		if (FCode.equalsIgnoreCase("c6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c6));
		if (FCode.equalsIgnoreCase("c7"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c7));
		if (FCode.equalsIgnoreCase("c8"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c8));
		if (FCode.equalsIgnoreCase("c9"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c9));
		if (FCode.equalsIgnoreCase("c10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(c10));
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
			strFieldValue = StrTool.GBKToUnicode(statYear);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(statBatch);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(branchType);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(name);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEmployDate()));
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(branchAttr);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(agentGrade);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(sMManagerName);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(aMManagerName);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(rMManagerName);
			break;

		case 14: // '\016'
			strFieldValue = String.valueOf(t1);
			break;

		case 15: // '\017'
			strFieldValue = String.valueOf(t2);
			break;

		case 16: // '\020'
			strFieldValue = String.valueOf(t3);
			break;

		case 17: // '\021'
			strFieldValue = String.valueOf(t4);
			break;

		case 18: // '\022'
			strFieldValue = String.valueOf(t5);
			break;

		case 19: // '\023'
			strFieldValue = String.valueOf(t6);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(t7);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(t8);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(t9);
			break;

		case 23: // '\027'
			strFieldValue = String.valueOf(t10);
			break;

		case 24: // '\030'
			strFieldValue = String.valueOf(t11);
			break;

		case 25: // '\031'
			strFieldValue = String.valueOf(t12);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(aMManager);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(rMManager);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(sMManager);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(t13);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(t14);
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(t15);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getOutWorkDate()));
			break;

		case 33: // '!'
			strFieldValue = String.valueOf(t16);
			break;

		case 34: // '"'
			strFieldValue = String.valueOf(t17);
			break;

		case 35: // '#'
			strFieldValue = String.valueOf(t18);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(t19);
			break;

		case 37: // '%'
			strFieldValue = String.valueOf(t20);
			break;

		case 38: // '&'
			strFieldValue = String.valueOf(t21);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(t22);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(sMManager2);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(rMManager2);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(vF01);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(nF01);
			break;

		case 44: // ','
			strFieldValue = String.valueOf(iF01);
			break;

		case 45: // '-'
			strFieldValue = String.valueOf(dF02);
			break;

		case 46: // '.'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getDate01()));
			break;

		case 47: // '/'
			strFieldValue = StrTool.GBKToUnicode(modifyOperator);
			break;

		case 48: // '0'
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 49: // '1'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 50: // '2'
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 51: // '3'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 52: // '4'
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
			break;

		case 53: // '5'
			strFieldValue = String.valueOf(c1);
			break;

		case 54: // '6'
			strFieldValue = String.valueOf(c2);
			break;

		case 55: // '7'
			strFieldValue = String.valueOf(c3);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(c4);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(c5);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(c6);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(c7);
			break;

		case 60: // '<'
			strFieldValue = String.valueOf(c8);
			break;

		case 61: // '='
			strFieldValue = String.valueOf(c9);
			break;

		case 62: // '>'
			strFieldValue = String.valueOf(c10);
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
		if (FCode.equalsIgnoreCase("statYear"))
			if (FValue != null && !FValue.equals(""))
				statYear = FValue.trim();
			else
				statYear = null;
		if (FCode.equalsIgnoreCase("statBatch"))
			if (FValue != null && !FValue.equals(""))
				statBatch = FValue.trim();
			else
				statBatch = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("branchType"))
			if (FValue != null && !FValue.equals(""))
				branchType = FValue.trim();
			else
				branchType = null;
		if (FCode.equalsIgnoreCase("startDate"))
			if (FValue != null && !FValue.equals(""))
				startDate = fDate.getDate(FValue);
			else
				startDate = null;
		if (FCode.equalsIgnoreCase("endDate"))
			if (FValue != null && !FValue.equals(""))
				endDate = fDate.getDate(FValue);
			else
				endDate = null;
		if (FCode.equalsIgnoreCase("name"))
			if (FValue != null && !FValue.equals(""))
				name = FValue.trim();
			else
				name = null;
		if (FCode.equalsIgnoreCase("employDate"))
			if (FValue != null && !FValue.equals(""))
				employDate = fDate.getDate(FValue);
			else
				employDate = null;
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
		if (FCode.equalsIgnoreCase("sMManagerName"))
			if (FValue != null && !FValue.equals(""))
				sMManagerName = FValue.trim();
			else
				sMManagerName = null;
		if (FCode.equalsIgnoreCase("aMManagerName"))
			if (FValue != null && !FValue.equals(""))
				aMManagerName = FValue.trim();
			else
				aMManagerName = null;
		if (FCode.equalsIgnoreCase("rMManagerName"))
			if (FValue != null && !FValue.equals(""))
				rMManagerName = FValue.trim();
			else
				rMManagerName = null;
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
		if (FCode.equalsIgnoreCase("t7"))
			if (FValue != null && !FValue.equals(""))
				t7 = FValue.trim();
			else
				t7 = null;
		if (FCode.equalsIgnoreCase("t8"))
			if (FValue != null && !FValue.equals(""))
				t8 = FValue.trim();
			else
				t8 = null;
		if (FCode.equalsIgnoreCase("t9"))
			if (FValue != null && !FValue.equals(""))
				t9 = FValue.trim();
			else
				t9 = null;
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
		if (FCode.equalsIgnoreCase("aMManager"))
			if (FValue != null && !FValue.equals(""))
				aMManager = FValue.trim();
			else
				aMManager = null;
		if (FCode.equalsIgnoreCase("rMManager"))
			if (FValue != null && !FValue.equals(""))
				rMManager = FValue.trim();
			else
				rMManager = null;
		if (FCode.equalsIgnoreCase("sMManager"))
			if (FValue != null && !FValue.equals(""))
				sMManager = FValue.trim();
			else
				sMManager = null;
		if (FCode.equalsIgnoreCase("t13"))
			if (FValue != null && !FValue.equals(""))
				t13 = FValue.trim();
			else
				t13 = null;
		if (FCode.equalsIgnoreCase("t14"))
			if (FValue != null && !FValue.equals(""))
				t14 = FValue.trim();
			else
				t14 = null;
		if (FCode.equalsIgnoreCase("t15") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t15 = d;
		}
		if (FCode.equalsIgnoreCase("outWorkDate"))
			if (FValue != null && !FValue.equals(""))
				outWorkDate = fDate.getDate(FValue);
			else
				outWorkDate = null;
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
		if (FCode.equalsIgnoreCase("t19"))
			if (FValue != null && !FValue.equals(""))
				t19 = FValue.trim();
			else
				t19 = null;
		if (FCode.equalsIgnoreCase("t20") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t20 = d;
		}
		if (FCode.equalsIgnoreCase("t21") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			t21 = d;
		}
		if (FCode.equalsIgnoreCase("t22"))
			if (FValue != null && !FValue.equals(""))
				t22 = FValue.trim();
			else
				t22 = null;
		if (FCode.equalsIgnoreCase("sMManager2"))
			if (FValue != null && !FValue.equals(""))
				sMManager2 = FValue.trim();
			else
				sMManager2 = null;
		if (FCode.equalsIgnoreCase("rMManager2"))
			if (FValue != null && !FValue.equals(""))
				rMManager2 = FValue.trim();
			else
				rMManager2 = null;
		if (FCode.equalsIgnoreCase("vF01"))
			if (FValue != null && !FValue.equals(""))
				vF01 = FValue.trim();
			else
				vF01 = null;
		if (FCode.equalsIgnoreCase("nF01"))
			if (FValue != null && !FValue.equals(""))
				nF01 = FValue.trim();
			else
				nF01 = null;
		if (FCode.equalsIgnoreCase("iF01") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iF01 = i;
		}
		if (FCode.equalsIgnoreCase("dF02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			dF02 = d;
		}
		if (FCode.equalsIgnoreCase("date01"))
			if (FValue != null && !FValue.equals(""))
				date01 = fDate.getDate(FValue);
			else
				date01 = null;
		if (FCode.equalsIgnoreCase("modifyOperator"))
			if (FValue != null && !FValue.equals(""))
				modifyOperator = FValue.trim();
			else
				modifyOperator = null;
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
		if (FCode.equalsIgnoreCase("c1") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c1 = d;
		}
		if (FCode.equalsIgnoreCase("c2") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c2 = d;
		}
		if (FCode.equalsIgnoreCase("c3") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c3 = d;
		}
		if (FCode.equalsIgnoreCase("c4") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c4 = d;
		}
		if (FCode.equalsIgnoreCase("c5") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c5 = d;
		}
		if (FCode.equalsIgnoreCase("c6") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c6 = d;
		}
		if (FCode.equalsIgnoreCase("c7") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c7 = d;
		}
		if (FCode.equalsIgnoreCase("c8") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c8 = d;
		}
		if (FCode.equalsIgnoreCase("c9") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c9 = d;
		}
		if (FCode.equalsIgnoreCase("c10") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			c10 = d;
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
		MLPHonorSchema other = (MLPHonorSchema)otherObject;
		if (statYear == null && other.getStatYear() != null)
			return false;
		if (statYear != null && !statYear.equals(other.getStatYear()))
			return false;
		if (statBatch == null && other.getStatBatch() != null)
			return false;
		if (statBatch != null && !statBatch.equals(other.getStatBatch()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (branchType == null && other.getBranchType() != null)
			return false;
		if (branchType != null && !branchType.equals(other.getBranchType()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (endDate == null && other.getEndDate() != null)
			return false;
		if (endDate != null && !fDate.getString(endDate).equals(other.getEndDate()))
			return false;
		if (name == null && other.getName() != null)
			return false;
		if (name != null && !name.equals(other.getName()))
			return false;
		if (employDate == null && other.getEmployDate() != null)
			return false;
		if (employDate != null && !fDate.getString(employDate).equals(other.getEmployDate()))
			return false;
		if (branchAttr == null && other.getBranchAttr() != null)
			return false;
		if (branchAttr != null && !branchAttr.equals(other.getBranchAttr()))
			return false;
		if (agentGrade == null && other.getAgentGrade() != null)
			return false;
		if (agentGrade != null && !agentGrade.equals(other.getAgentGrade()))
			return false;
		if (sMManagerName == null && other.getSMManagerName() != null)
			return false;
		if (sMManagerName != null && !sMManagerName.equals(other.getSMManagerName()))
			return false;
		if (aMManagerName == null && other.getAMManagerName() != null)
			return false;
		if (aMManagerName != null && !aMManagerName.equals(other.getAMManagerName()))
			return false;
		if (rMManagerName == null && other.getRMManagerName() != null)
			return false;
		if (rMManagerName != null && !rMManagerName.equals(other.getRMManagerName()))
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
		if (t7 == null && other.getT7() != null)
			return false;
		if (t7 != null && !t7.equals(other.getT7()))
			return false;
		if (t8 == null && other.getT8() != null)
			return false;
		if (t8 != null && !t8.equals(other.getT8()))
			return false;
		if (t9 == null && other.getT9() != null)
			return false;
		if (t9 != null && !t9.equals(other.getT9()))
			return false;
		if (Double.doubleToLongBits(t10) != Double.doubleToLongBits(other.getT10()))
			return false;
		if (Double.doubleToLongBits(t11) != Double.doubleToLongBits(other.getT11()))
			return false;
		if (Double.doubleToLongBits(t12) != Double.doubleToLongBits(other.getT12()))
			return false;
		if (aMManager == null && other.getAMManager() != null)
			return false;
		if (aMManager != null && !aMManager.equals(other.getAMManager()))
			return false;
		if (rMManager == null && other.getRMManager() != null)
			return false;
		if (rMManager != null && !rMManager.equals(other.getRMManager()))
			return false;
		if (sMManager == null && other.getSMManager() != null)
			return false;
		if (sMManager != null && !sMManager.equals(other.getSMManager()))
			return false;
		if (t13 == null && other.getT13() != null)
			return false;
		if (t13 != null && !t13.equals(other.getT13()))
			return false;
		if (t14 == null && other.getT14() != null)
			return false;
		if (t14 != null && !t14.equals(other.getT14()))
			return false;
		if (Double.doubleToLongBits(t15) != Double.doubleToLongBits(other.getT15()))
			return false;
		if (outWorkDate == null && other.getOutWorkDate() != null)
			return false;
		if (outWorkDate != null && !fDate.getString(outWorkDate).equals(other.getOutWorkDate()))
			return false;
		if (Double.doubleToLongBits(t16) != Double.doubleToLongBits(other.getT16()))
			return false;
		if (Double.doubleToLongBits(t17) != Double.doubleToLongBits(other.getT17()))
			return false;
		if (Double.doubleToLongBits(t18) != Double.doubleToLongBits(other.getT18()))
			return false;
		if (t19 == null && other.getT19() != null)
			return false;
		if (t19 != null && !t19.equals(other.getT19()))
			return false;
		if (Double.doubleToLongBits(t20) != Double.doubleToLongBits(other.getT20()))
			return false;
		if (Double.doubleToLongBits(t21) != Double.doubleToLongBits(other.getT21()))
			return false;
		if (t22 == null && other.getT22() != null)
			return false;
		if (t22 != null && !t22.equals(other.getT22()))
			return false;
		if (sMManager2 == null && other.getSMManager2() != null)
			return false;
		if (sMManager2 != null && !sMManager2.equals(other.getSMManager2()))
			return false;
		if (rMManager2 == null && other.getRMManager2() != null)
			return false;
		if (rMManager2 != null && !rMManager2.equals(other.getRMManager2()))
			return false;
		if (vF01 == null && other.getVF01() != null)
			return false;
		if (vF01 != null && !vF01.equals(other.getVF01()))
			return false;
		if (nF01 == null && other.getNF01() != null)
			return false;
		if (nF01 != null && !nF01.equals(other.getNF01()))
			return false;
		if (iF01 != other.getIF01())
			return false;
		if (Double.doubleToLongBits(dF02) != Double.doubleToLongBits(other.getDF02()))
			return false;
		if (date01 == null && other.getDate01() != null)
			return false;
		if (date01 != null && !fDate.getString(date01).equals(other.getDate01()))
			return false;
		if (modifyOperator == null && other.getModifyOperator() != null)
			return false;
		if (modifyOperator != null && !modifyOperator.equals(other.getModifyOperator()))
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
		if (Double.doubleToLongBits(c1) != Double.doubleToLongBits(other.getC1()))
			return false;
		if (Double.doubleToLongBits(c2) != Double.doubleToLongBits(other.getC2()))
			return false;
		if (Double.doubleToLongBits(c3) != Double.doubleToLongBits(other.getC3()))
			return false;
		if (Double.doubleToLongBits(c4) != Double.doubleToLongBits(other.getC4()))
			return false;
		if (Double.doubleToLongBits(c5) != Double.doubleToLongBits(other.getC5()))
			return false;
		if (Double.doubleToLongBits(c6) != Double.doubleToLongBits(other.getC6()))
			return false;
		if (Double.doubleToLongBits(c7) != Double.doubleToLongBits(other.getC7()))
			return false;
		if (Double.doubleToLongBits(c8) != Double.doubleToLongBits(other.getC8()))
			return false;
		if (Double.doubleToLongBits(c9) != Double.doubleToLongBits(other.getC9()))
			return false;
		return Double.doubleToLongBits(c10) == Double.doubleToLongBits(other.getC10());
	}

	public int getFieldCount()
	{
		return 63;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("statYear"))
			return 0;
		if (strFieldName.equals("statBatch"))
			return 1;
		if (strFieldName.equals("agentCode"))
			return 2;
		if (strFieldName.equals("manageCom"))
			return 3;
		if (strFieldName.equals("branchType"))
			return 4;
		if (strFieldName.equals("startDate"))
			return 5;
		if (strFieldName.equals("endDate"))
			return 6;
		if (strFieldName.equals("name"))
			return 7;
		if (strFieldName.equals("employDate"))
			return 8;
		if (strFieldName.equals("branchAttr"))
			return 9;
		if (strFieldName.equals("agentGrade"))
			return 10;
		if (strFieldName.equals("sMManagerName"))
			return 11;
		if (strFieldName.equals("aMManagerName"))
			return 12;
		if (strFieldName.equals("rMManagerName"))
			return 13;
		if (strFieldName.equals("t1"))
			return 14;
		if (strFieldName.equals("t2"))
			return 15;
		if (strFieldName.equals("t3"))
			return 16;
		if (strFieldName.equals("t4"))
			return 17;
		if (strFieldName.equals("t5"))
			return 18;
		if (strFieldName.equals("t6"))
			return 19;
		if (strFieldName.equals("t7"))
			return 20;
		if (strFieldName.equals("t8"))
			return 21;
		if (strFieldName.equals("t9"))
			return 22;
		if (strFieldName.equals("t10"))
			return 23;
		if (strFieldName.equals("t11"))
			return 24;
		if (strFieldName.equals("t12"))
			return 25;
		if (strFieldName.equals("aMManager"))
			return 26;
		if (strFieldName.equals("rMManager"))
			return 27;
		if (strFieldName.equals("sMManager"))
			return 28;
		if (strFieldName.equals("t13"))
			return 29;
		if (strFieldName.equals("t14"))
			return 30;
		if (strFieldName.equals("t15"))
			return 31;
		if (strFieldName.equals("outWorkDate"))
			return 32;
		if (strFieldName.equals("t16"))
			return 33;
		if (strFieldName.equals("t17"))
			return 34;
		if (strFieldName.equals("t18"))
			return 35;
		if (strFieldName.equals("t19"))
			return 36;
		if (strFieldName.equals("t20"))
			return 37;
		if (strFieldName.equals("t21"))
			return 38;
		if (strFieldName.equals("t22"))
			return 39;
		if (strFieldName.equals("sMManager2"))
			return 40;
		if (strFieldName.equals("rMManager2"))
			return 41;
		if (strFieldName.equals("vF01"))
			return 42;
		if (strFieldName.equals("nF01"))
			return 43;
		if (strFieldName.equals("iF01"))
			return 44;
		if (strFieldName.equals("dF02"))
			return 45;
		if (strFieldName.equals("date01"))
			return 46;
		if (strFieldName.equals("modifyOperator"))
			return 47;
		if (strFieldName.equals("operator"))
			return 48;
		if (strFieldName.equals("makeDate"))
			return 49;
		if (strFieldName.equals("makeTime"))
			return 50;
		if (strFieldName.equals("modifyDate"))
			return 51;
		if (strFieldName.equals("modifyTime"))
			return 52;
		if (strFieldName.equals("c1"))
			return 53;
		if (strFieldName.equals("c2"))
			return 54;
		if (strFieldName.equals("c3"))
			return 55;
		if (strFieldName.equals("c4"))
			return 56;
		if (strFieldName.equals("c5"))
			return 57;
		if (strFieldName.equals("c6"))
			return 58;
		if (strFieldName.equals("c7"))
			return 59;
		if (strFieldName.equals("c8"))
			return 60;
		if (strFieldName.equals("c9"))
			return 61;
		return !strFieldName.equals("c10") ? -1 : 62;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "statYear";
			break;

		case 1: // '\001'
			strFieldName = "statBatch";
			break;

		case 2: // '\002'
			strFieldName = "agentCode";
			break;

		case 3: // '\003'
			strFieldName = "manageCom";
			break;

		case 4: // '\004'
			strFieldName = "branchType";
			break;

		case 5: // '\005'
			strFieldName = "startDate";
			break;

		case 6: // '\006'
			strFieldName = "endDate";
			break;

		case 7: // '\007'
			strFieldName = "name";
			break;

		case 8: // '\b'
			strFieldName = "employDate";
			break;

		case 9: // '\t'
			strFieldName = "branchAttr";
			break;

		case 10: // '\n'
			strFieldName = "agentGrade";
			break;

		case 11: // '\013'
			strFieldName = "sMManagerName";
			break;

		case 12: // '\f'
			strFieldName = "aMManagerName";
			break;

		case 13: // '\r'
			strFieldName = "rMManagerName";
			break;

		case 14: // '\016'
			strFieldName = "t1";
			break;

		case 15: // '\017'
			strFieldName = "t2";
			break;

		case 16: // '\020'
			strFieldName = "t3";
			break;

		case 17: // '\021'
			strFieldName = "t4";
			break;

		case 18: // '\022'
			strFieldName = "t5";
			break;

		case 19: // '\023'
			strFieldName = "t6";
			break;

		case 20: // '\024'
			strFieldName = "t7";
			break;

		case 21: // '\025'
			strFieldName = "t8";
			break;

		case 22: // '\026'
			strFieldName = "t9";
			break;

		case 23: // '\027'
			strFieldName = "t10";
			break;

		case 24: // '\030'
			strFieldName = "t11";
			break;

		case 25: // '\031'
			strFieldName = "t12";
			break;

		case 26: // '\032'
			strFieldName = "aMManager";
			break;

		case 27: // '\033'
			strFieldName = "rMManager";
			break;

		case 28: // '\034'
			strFieldName = "sMManager";
			break;

		case 29: // '\035'
			strFieldName = "t13";
			break;

		case 30: // '\036'
			strFieldName = "t14";
			break;

		case 31: // '\037'
			strFieldName = "t15";
			break;

		case 32: // ' '
			strFieldName = "outWorkDate";
			break;

		case 33: // '!'
			strFieldName = "t16";
			break;

		case 34: // '"'
			strFieldName = "t17";
			break;

		case 35: // '#'
			strFieldName = "t18";
			break;

		case 36: // '$'
			strFieldName = "t19";
			break;

		case 37: // '%'
			strFieldName = "t20";
			break;

		case 38: // '&'
			strFieldName = "t21";
			break;

		case 39: // '\''
			strFieldName = "t22";
			break;

		case 40: // '('
			strFieldName = "sMManager2";
			break;

		case 41: // ')'
			strFieldName = "rMManager2";
			break;

		case 42: // '*'
			strFieldName = "vF01";
			break;

		case 43: // '+'
			strFieldName = "nF01";
			break;

		case 44: // ','
			strFieldName = "iF01";
			break;

		case 45: // '-'
			strFieldName = "dF02";
			break;

		case 46: // '.'
			strFieldName = "date01";
			break;

		case 47: // '/'
			strFieldName = "modifyOperator";
			break;

		case 48: // '0'
			strFieldName = "operator";
			break;

		case 49: // '1'
			strFieldName = "makeDate";
			break;

		case 50: // '2'
			strFieldName = "makeTime";
			break;

		case 51: // '3'
			strFieldName = "modifyDate";
			break;

		case 52: // '4'
			strFieldName = "modifyTime";
			break;

		case 53: // '5'
			strFieldName = "c1";
			break;

		case 54: // '6'
			strFieldName = "c2";
			break;

		case 55: // '7'
			strFieldName = "c3";
			break;

		case 56: // '8'
			strFieldName = "c4";
			break;

		case 57: // '9'
			strFieldName = "c5";
			break;

		case 58: // ':'
			strFieldName = "c6";
			break;

		case 59: // ';'
			strFieldName = "c7";
			break;

		case 60: // '<'
			strFieldName = "c8";
			break;

		case 61: // '='
			strFieldName = "c9";
			break;

		case 62: // '>'
			strFieldName = "c10";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("statYear"))
			return 0;
		if (strFieldName.equals("statBatch"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("branchType"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("endDate"))
			return 1;
		if (strFieldName.equals("name"))
			return 0;
		if (strFieldName.equals("employDate"))
			return 1;
		if (strFieldName.equals("branchAttr"))
			return 0;
		if (strFieldName.equals("agentGrade"))
			return 0;
		if (strFieldName.equals("sMManagerName"))
			return 0;
		if (strFieldName.equals("aMManagerName"))
			return 0;
		if (strFieldName.equals("rMManagerName"))
			return 0;
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
			return 0;
		if (strFieldName.equals("t8"))
			return 0;
		if (strFieldName.equals("t9"))
			return 0;
		if (strFieldName.equals("t10"))
			return 4;
		if (strFieldName.equals("t11"))
			return 4;
		if (strFieldName.equals("t12"))
			return 4;
		if (strFieldName.equals("aMManager"))
			return 0;
		if (strFieldName.equals("rMManager"))
			return 0;
		if (strFieldName.equals("sMManager"))
			return 0;
		if (strFieldName.equals("t13"))
			return 0;
		if (strFieldName.equals("t14"))
			return 0;
		if (strFieldName.equals("t15"))
			return 4;
		if (strFieldName.equals("outWorkDate"))
			return 1;
		if (strFieldName.equals("t16"))
			return 4;
		if (strFieldName.equals("t17"))
			return 4;
		if (strFieldName.equals("t18"))
			return 4;
		if (strFieldName.equals("t19"))
			return 0;
		if (strFieldName.equals("t20"))
			return 4;
		if (strFieldName.equals("t21"))
			return 4;
		if (strFieldName.equals("t22"))
			return 0;
		if (strFieldName.equals("sMManager2"))
			return 0;
		if (strFieldName.equals("rMManager2"))
			return 0;
		if (strFieldName.equals("vF01"))
			return 0;
		if (strFieldName.equals("nF01"))
			return 0;
		if (strFieldName.equals("iF01"))
			return 3;
		if (strFieldName.equals("dF02"))
			return 4;
		if (strFieldName.equals("date01"))
			return 1;
		if (strFieldName.equals("modifyOperator"))
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
		if (strFieldName.equals("c1"))
			return 4;
		if (strFieldName.equals("c2"))
			return 4;
		if (strFieldName.equals("c3"))
			return 4;
		if (strFieldName.equals("c4"))
			return 4;
		if (strFieldName.equals("c5"))
			return 4;
		if (strFieldName.equals("c6"))
			return 4;
		if (strFieldName.equals("c7"))
			return 4;
		if (strFieldName.equals("c8"))
			return 4;
		if (strFieldName.equals("c9"))
			return 4;
		return !strFieldName.equals("c10") ? -1 : 4;
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
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 1;
			break;

		case 9: // '\t'
			nFieldType = 0;
			break;

		case 10: // '\n'
			nFieldType = 0;
			break;

		case 11: // '\013'
			nFieldType = 0;
			break;

		case 12: // '\f'
			nFieldType = 0;
			break;

		case 13: // '\r'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 21: // '\025'
			nFieldType = 0;
			break;

		case 22: // '\026'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 27: // '\033'
			nFieldType = 0;
			break;

		case 28: // '\034'
			nFieldType = 0;
			break;

		case 29: // '\035'
			nFieldType = 0;
			break;

		case 30: // '\036'
			nFieldType = 0;
			break;

		case 31: // '\037'
			nFieldType = 4;
			break;

		case 32: // ' '
			nFieldType = 1;
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
			nFieldType = 0;
			break;

		case 37: // '%'
			nFieldType = 4;
			break;

		case 38: // '&'
			nFieldType = 4;
			break;

		case 39: // '\''
			nFieldType = 0;
			break;

		case 40: // '('
			nFieldType = 0;
			break;

		case 41: // ')'
			nFieldType = 0;
			break;

		case 42: // '*'
			nFieldType = 0;
			break;

		case 43: // '+'
			nFieldType = 0;
			break;

		case 44: // ','
			nFieldType = 3;
			break;

		case 45: // '-'
			nFieldType = 4;
			break;

		case 46: // '.'
			nFieldType = 1;
			break;

		case 47: // '/'
			nFieldType = 0;
			break;

		case 48: // '0'
			nFieldType = 0;
			break;

		case 49: // '1'
			nFieldType = 1;
			break;

		case 50: // '2'
			nFieldType = 0;
			break;

		case 51: // '3'
			nFieldType = 1;
			break;

		case 52: // '4'
			nFieldType = 0;
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

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
