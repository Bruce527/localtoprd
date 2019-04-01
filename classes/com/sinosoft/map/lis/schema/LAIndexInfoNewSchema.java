// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAIndexInfoNewSchema.java

package com.sinosoft.map.lis.schema;

import com.sinosoft.map.lis.db.LAIndexInfoNewDB;
import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LAIndexInfoNewSchema
	implements Schema, Cloneable
{

	private String indexCalNo;
	private String indexType;
	private String manageCom;
	private String agentGroup;
	private String branchAttr;
	private String agentCode;
	private String agentGrade;
	private String agentTitle;
	private int quaBgnMark;
	private int postMonths;
	private String assessMonth;
	private String agentGrade1;
	private String agentTitle1;
	private String agentGrade2;
	private String agentTitle2;
	private String agentGrade3;
	private String agentTitle3;
	private Date startDate;
	private Date startEnd;
	private Date startDate1;
	private Date startEnd1;
	private Date startDate2;
	private Date startEnd2;
	private Date startDate3;
	private Date startEnd3;
	private Date startEnd4;
	private Date startDate4;
	private int serverMonths;
	private double nT01;
	private double nT02;
	private double nT03;
	private double nT04;
	private double nT05;
	private double nT06;
	private double nT07;
	private double nT08;
	private double nT09;
	private double nT10;
	private double nT11;
	private double nT12;
	private double nT13;
	private double nT14;
	private double nT15;
	private double nT16;
	private double nT17;
	private double nT18;
	private double nT19;
	private double nT20;
	private double nT21;
	private double nT22;
	private double nT23;
	private double nT24;
	private double nT25;
	private double nT26;
	private double nT27;
	private double nT28;
	private double nT29;
	private double nT30;
	private double nT31;
	private double nT32;
	private double nT33;
	private double nT34;
	private double nT35;
	private double nT36;
	private double nT37;
	private double nT38;
	private double nT39;
	private double nT40;
	private double nT41;
	private double nT42;
	private double nT43;
	private double nT44;
	private double nT45;
	private double nT46;
	private double nT47;
	private double nT48;
	private double nT49;
	private double nT50;
	private double nT51;
	private double nT52;
	private double nT53;
	private double nT54;
	private double nT55;
	private double nT56;
	private double nT57;
	private double nT58;
	private double nT59;
	private double nT60;
	private double nT61;
	private double nT62;
	private double nT63;
	private double nT64;
	private double nT65;
	private double nT66;
	private double nT67;
	private double nT68;
	private double nT69;
	private double nT70;
	private double nT71;
	private double nT72;
	private double nT73;
	private double nT74;
	private double nT75;
	private double nT76;
	private double nT77;
	private double nT78;
	private double nT79;
	private double nT80;
	private double nF01;
	private double nF02;
	private double nF03;
	private double nF04;
	private double nF05;
	private double nF06;
	private double nF07;
	private double nF08;
	private double nF09;
	private double nF10;
	private double nS01;
	private double nS02;
	private double nS03;
	private double nS04;
	private double nS05;
	private double nS06;
	private double nS07;
	private double nS08;
	private double nS09;
	private double nS10;
	private int iNT01;
	private int iNT02;
	private int iNT03;
	private int iNT04;
	private int iNT05;
	private int iNT06;
	private int iNT07;
	private int iNT08;
	private int iNT09;
	private int iNT10;
	private int iNT11;
	private int iNT12;
	private int iNT13;
	private int iNT14;
	private int iNT15;
	private int iNT16;
	private int iNT17;
	private int iNT18;
	private int iNT19;
	private int iNT20;
	private int iNT21;
	private int iNT22;
	private int iNT23;
	private int iNT24;
	private int iNT25;
	private String v1;
	private String v2;
	private String v3;
	private String v4;
	private String v5;
	private String v6;
	private String v7;
	private String v8;
	private String v9;
	private String v10;
	private String v11;
	private String v12;
	private String v13;
	private String v14;
	private String v15;
	private String v16;
	private String v17;
	private String v18;
	private String v19;
	private String v20;
	private String vT1;
	private String vT2;
	private String vT3;
	private String vT4;
	private String vT5;
	private String vT6;
	private String vT7;
	private String vT8;
	private String vE1;
	private String vE2;
	private String vE3;
	private String vE4;
	private String vE5;
	private String vE6;
	private String vE7;
	private String vE8;
	private String vE9;
	private String vE10;
	private Date d1;
	private Date d2;
	private Date d3;
	private Date d4;
	private Date d5;
	private Date d6;
	private Date d7;
	private Date d8;
	private Date d9;
	private Date d10;
	private String state;
	private String operator;
	private Date makeDate;
	private String makeTime;
	private Date modifyDate;
	private String modifyTime;
	public static final int FIELDNUM = 207;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LAIndexInfoNewSchema()
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
		LAIndexInfoNewSchema cloned = (LAIndexInfoNewSchema)super.clone();
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

	public String getManageCom()
	{
		return manageCom;
	}

	public void setManageCom(String aManageCom)
	{
		manageCom = aManageCom;
	}

	public String getAgentGroup()
	{
		return agentGroup;
	}

	public void setAgentGroup(String aAgentGroup)
	{
		agentGroup = aAgentGroup;
	}

	public String getBranchAttr()
	{
		return branchAttr;
	}

	public void setBranchAttr(String aBranchAttr)
	{
		branchAttr = aBranchAttr;
	}

	public String getAgentCode()
	{
		return agentCode;
	}

	public void setAgentCode(String aAgentCode)
	{
		agentCode = aAgentCode;
	}

	public String getAgentGrade()
	{
		return agentGrade;
	}

	public void setAgentGrade(String aAgentGrade)
	{
		agentGrade = aAgentGrade;
	}

	public String getAgentTitle()
	{
		return agentTitle;
	}

	public void setAgentTitle(String aAgentTitle)
	{
		agentTitle = aAgentTitle;
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

	public String getAssessMonth()
	{
		return assessMonth;
	}

	public void setAssessMonth(String aAssessMonth)
	{
		assessMonth = aAssessMonth;
	}

	public String getAgentGrade1()
	{
		return agentGrade1;
	}

	public void setAgentGrade1(String aAgentGrade1)
	{
		agentGrade1 = aAgentGrade1;
	}

	public String getAgentTitle1()
	{
		return agentTitle1;
	}

	public void setAgentTitle1(String aAgentTitle1)
	{
		agentTitle1 = aAgentTitle1;
	}

	public String getAgentGrade2()
	{
		return agentGrade2;
	}

	public void setAgentGrade2(String aAgentGrade2)
	{
		agentGrade2 = aAgentGrade2;
	}

	public String getAgentTitle2()
	{
		return agentTitle2;
	}

	public void setAgentTitle2(String aAgentTitle2)
	{
		agentTitle2 = aAgentTitle2;
	}

	public String getAgentGrade3()
	{
		return agentGrade3;
	}

	public void setAgentGrade3(String aAgentGrade3)
	{
		agentGrade3 = aAgentGrade3;
	}

	public String getAgentTitle3()
	{
		return agentTitle3;
	}

	public void setAgentTitle3(String aAgentTitle3)
	{
		agentTitle3 = aAgentTitle3;
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

	public String getStartDate1()
	{
		if (startDate1 != null)
			return fDate.getString(startDate1);
		else
			return null;
	}

	public void setStartDate1(Date aStartDate1)
	{
		startDate1 = aStartDate1;
	}

	public void setStartDate1(String aStartDate1)
	{
		if (aStartDate1 != null && !aStartDate1.equals(""))
			startDate1 = fDate.getDate(aStartDate1);
		else
			startDate1 = null;
	}

	public String getStartEnd1()
	{
		if (startEnd1 != null)
			return fDate.getString(startEnd1);
		else
			return null;
	}

	public void setStartEnd1(Date aStartEnd1)
	{
		startEnd1 = aStartEnd1;
	}

	public void setStartEnd1(String aStartEnd1)
	{
		if (aStartEnd1 != null && !aStartEnd1.equals(""))
			startEnd1 = fDate.getDate(aStartEnd1);
		else
			startEnd1 = null;
	}

	public String getStartDate2()
	{
		if (startDate2 != null)
			return fDate.getString(startDate2);
		else
			return null;
	}

	public void setStartDate2(Date aStartDate2)
	{
		startDate2 = aStartDate2;
	}

	public void setStartDate2(String aStartDate2)
	{
		if (aStartDate2 != null && !aStartDate2.equals(""))
			startDate2 = fDate.getDate(aStartDate2);
		else
			startDate2 = null;
	}

	public String getStartEnd2()
	{
		if (startEnd2 != null)
			return fDate.getString(startEnd2);
		else
			return null;
	}

	public void setStartEnd2(Date aStartEnd2)
	{
		startEnd2 = aStartEnd2;
	}

	public void setStartEnd2(String aStartEnd2)
	{
		if (aStartEnd2 != null && !aStartEnd2.equals(""))
			startEnd2 = fDate.getDate(aStartEnd2);
		else
			startEnd2 = null;
	}

	public String getStartDate3()
	{
		if (startDate3 != null)
			return fDate.getString(startDate3);
		else
			return null;
	}

	public void setStartDate3(Date aStartDate3)
	{
		startDate3 = aStartDate3;
	}

	public void setStartDate3(String aStartDate3)
	{
		if (aStartDate3 != null && !aStartDate3.equals(""))
			startDate3 = fDate.getDate(aStartDate3);
		else
			startDate3 = null;
	}

	public String getStartEnd3()
	{
		if (startEnd3 != null)
			return fDate.getString(startEnd3);
		else
			return null;
	}

	public void setStartEnd3(Date aStartEnd3)
	{
		startEnd3 = aStartEnd3;
	}

	public void setStartEnd3(String aStartEnd3)
	{
		if (aStartEnd3 != null && !aStartEnd3.equals(""))
			startEnd3 = fDate.getDate(aStartEnd3);
		else
			startEnd3 = null;
	}

	public String getStartEnd4()
	{
		if (startEnd4 != null)
			return fDate.getString(startEnd4);
		else
			return null;
	}

	public void setStartEnd4(Date aStartEnd4)
	{
		startEnd4 = aStartEnd4;
	}

	public void setStartEnd4(String aStartEnd4)
	{
		if (aStartEnd4 != null && !aStartEnd4.equals(""))
			startEnd4 = fDate.getDate(aStartEnd4);
		else
			startEnd4 = null;
	}

	public String getStartDate4()
	{
		if (startDate4 != null)
			return fDate.getString(startDate4);
		else
			return null;
	}

	public void setStartDate4(Date aStartDate4)
	{
		startDate4 = aStartDate4;
	}

	public void setStartDate4(String aStartDate4)
	{
		if (aStartDate4 != null && !aStartDate4.equals(""))
			startDate4 = fDate.getDate(aStartDate4);
		else
			startDate4 = null;
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

	public double getNT01()
	{
		return nT01;
	}

	public void setNT01(double aNT01)
	{
		nT01 = aNT01;
	}

	public void setNT01(String aNT01)
	{
		if (aNT01 != null && !aNT01.equals(""))
		{
			Double tDouble = new Double(aNT01);
			double d = tDouble.doubleValue();
			nT01 = d;
		}
	}

	public double getNT02()
	{
		return nT02;
	}

	public void setNT02(double aNT02)
	{
		nT02 = aNT02;
	}

	public void setNT02(String aNT02)
	{
		if (aNT02 != null && !aNT02.equals(""))
		{
			Double tDouble = new Double(aNT02);
			double d = tDouble.doubleValue();
			nT02 = d;
		}
	}

	public double getNT03()
	{
		return nT03;
	}

	public void setNT03(double aNT03)
	{
		nT03 = aNT03;
	}

	public void setNT03(String aNT03)
	{
		if (aNT03 != null && !aNT03.equals(""))
		{
			Double tDouble = new Double(aNT03);
			double d = tDouble.doubleValue();
			nT03 = d;
		}
	}

	public double getNT04()
	{
		return nT04;
	}

	public void setNT04(double aNT04)
	{
		nT04 = aNT04;
	}

	public void setNT04(String aNT04)
	{
		if (aNT04 != null && !aNT04.equals(""))
		{
			Double tDouble = new Double(aNT04);
			double d = tDouble.doubleValue();
			nT04 = d;
		}
	}

	public double getNT05()
	{
		return nT05;
	}

	public void setNT05(double aNT05)
	{
		nT05 = aNT05;
	}

	public void setNT05(String aNT05)
	{
		if (aNT05 != null && !aNT05.equals(""))
		{
			Double tDouble = new Double(aNT05);
			double d = tDouble.doubleValue();
			nT05 = d;
		}
	}

	public double getNT06()
	{
		return nT06;
	}

	public void setNT06(double aNT06)
	{
		nT06 = aNT06;
	}

	public void setNT06(String aNT06)
	{
		if (aNT06 != null && !aNT06.equals(""))
		{
			Double tDouble = new Double(aNT06);
			double d = tDouble.doubleValue();
			nT06 = d;
		}
	}

	public double getNT07()
	{
		return nT07;
	}

	public void setNT07(double aNT07)
	{
		nT07 = aNT07;
	}

	public void setNT07(String aNT07)
	{
		if (aNT07 != null && !aNT07.equals(""))
		{
			Double tDouble = new Double(aNT07);
			double d = tDouble.doubleValue();
			nT07 = d;
		}
	}

	public double getNT08()
	{
		return nT08;
	}

	public void setNT08(double aNT08)
	{
		nT08 = aNT08;
	}

	public void setNT08(String aNT08)
	{
		if (aNT08 != null && !aNT08.equals(""))
		{
			Double tDouble = new Double(aNT08);
			double d = tDouble.doubleValue();
			nT08 = d;
		}
	}

	public double getNT09()
	{
		return nT09;
	}

	public void setNT09(double aNT09)
	{
		nT09 = aNT09;
	}

	public void setNT09(String aNT09)
	{
		if (aNT09 != null && !aNT09.equals(""))
		{
			Double tDouble = new Double(aNT09);
			double d = tDouble.doubleValue();
			nT09 = d;
		}
	}

	public double getNT10()
	{
		return nT10;
	}

	public void setNT10(double aNT10)
	{
		nT10 = aNT10;
	}

	public void setNT10(String aNT10)
	{
		if (aNT10 != null && !aNT10.equals(""))
		{
			Double tDouble = new Double(aNT10);
			double d = tDouble.doubleValue();
			nT10 = d;
		}
	}

	public double getNT11()
	{
		return nT11;
	}

	public void setNT11(double aNT11)
	{
		nT11 = aNT11;
	}

	public void setNT11(String aNT11)
	{
		if (aNT11 != null && !aNT11.equals(""))
		{
			Double tDouble = new Double(aNT11);
			double d = tDouble.doubleValue();
			nT11 = d;
		}
	}

	public double getNT12()
	{
		return nT12;
	}

	public void setNT12(double aNT12)
	{
		nT12 = aNT12;
	}

	public void setNT12(String aNT12)
	{
		if (aNT12 != null && !aNT12.equals(""))
		{
			Double tDouble = new Double(aNT12);
			double d = tDouble.doubleValue();
			nT12 = d;
		}
	}

	public double getNT13()
	{
		return nT13;
	}

	public void setNT13(double aNT13)
	{
		nT13 = aNT13;
	}

	public void setNT13(String aNT13)
	{
		if (aNT13 != null && !aNT13.equals(""))
		{
			Double tDouble = new Double(aNT13);
			double d = tDouble.doubleValue();
			nT13 = d;
		}
	}

	public double getNT14()
	{
		return nT14;
	}

	public void setNT14(double aNT14)
	{
		nT14 = aNT14;
	}

	public void setNT14(String aNT14)
	{
		if (aNT14 != null && !aNT14.equals(""))
		{
			Double tDouble = new Double(aNT14);
			double d = tDouble.doubleValue();
			nT14 = d;
		}
	}

	public double getNT15()
	{
		return nT15;
	}

	public void setNT15(double aNT15)
	{
		nT15 = aNT15;
	}

	public void setNT15(String aNT15)
	{
		if (aNT15 != null && !aNT15.equals(""))
		{
			Double tDouble = new Double(aNT15);
			double d = tDouble.doubleValue();
			nT15 = d;
		}
	}

	public double getNT16()
	{
		return nT16;
	}

	public void setNT16(double aNT16)
	{
		nT16 = aNT16;
	}

	public void setNT16(String aNT16)
	{
		if (aNT16 != null && !aNT16.equals(""))
		{
			Double tDouble = new Double(aNT16);
			double d = tDouble.doubleValue();
			nT16 = d;
		}
	}

	public double getNT17()
	{
		return nT17;
	}

	public void setNT17(double aNT17)
	{
		nT17 = aNT17;
	}

	public void setNT17(String aNT17)
	{
		if (aNT17 != null && !aNT17.equals(""))
		{
			Double tDouble = new Double(aNT17);
			double d = tDouble.doubleValue();
			nT17 = d;
		}
	}

	public double getNT18()
	{
		return nT18;
	}

	public void setNT18(double aNT18)
	{
		nT18 = aNT18;
	}

	public void setNT18(String aNT18)
	{
		if (aNT18 != null && !aNT18.equals(""))
		{
			Double tDouble = new Double(aNT18);
			double d = tDouble.doubleValue();
			nT18 = d;
		}
	}

	public double getNT19()
	{
		return nT19;
	}

	public void setNT19(double aNT19)
	{
		nT19 = aNT19;
	}

	public void setNT19(String aNT19)
	{
		if (aNT19 != null && !aNT19.equals(""))
		{
			Double tDouble = new Double(aNT19);
			double d = tDouble.doubleValue();
			nT19 = d;
		}
	}

	public double getNT20()
	{
		return nT20;
	}

	public void setNT20(double aNT20)
	{
		nT20 = aNT20;
	}

	public void setNT20(String aNT20)
	{
		if (aNT20 != null && !aNT20.equals(""))
		{
			Double tDouble = new Double(aNT20);
			double d = tDouble.doubleValue();
			nT20 = d;
		}
	}

	public double getNT21()
	{
		return nT21;
	}

	public void setNT21(double aNT21)
	{
		nT21 = aNT21;
	}

	public void setNT21(String aNT21)
	{
		if (aNT21 != null && !aNT21.equals(""))
		{
			Double tDouble = new Double(aNT21);
			double d = tDouble.doubleValue();
			nT21 = d;
		}
	}

	public double getNT22()
	{
		return nT22;
	}

	public void setNT22(double aNT22)
	{
		nT22 = aNT22;
	}

	public void setNT22(String aNT22)
	{
		if (aNT22 != null && !aNT22.equals(""))
		{
			Double tDouble = new Double(aNT22);
			double d = tDouble.doubleValue();
			nT22 = d;
		}
	}

	public double getNT23()
	{
		return nT23;
	}

	public void setNT23(double aNT23)
	{
		nT23 = aNT23;
	}

	public void setNT23(String aNT23)
	{
		if (aNT23 != null && !aNT23.equals(""))
		{
			Double tDouble = new Double(aNT23);
			double d = tDouble.doubleValue();
			nT23 = d;
		}
	}

	public double getNT24()
	{
		return nT24;
	}

	public void setNT24(double aNT24)
	{
		nT24 = aNT24;
	}

	public void setNT24(String aNT24)
	{
		if (aNT24 != null && !aNT24.equals(""))
		{
			Double tDouble = new Double(aNT24);
			double d = tDouble.doubleValue();
			nT24 = d;
		}
	}

	public double getNT25()
	{
		return nT25;
	}

	public void setNT25(double aNT25)
	{
		nT25 = aNT25;
	}

	public void setNT25(String aNT25)
	{
		if (aNT25 != null && !aNT25.equals(""))
		{
			Double tDouble = new Double(aNT25);
			double d = tDouble.doubleValue();
			nT25 = d;
		}
	}

	public double getNT26()
	{
		return nT26;
	}

	public void setNT26(double aNT26)
	{
		nT26 = aNT26;
	}

	public void setNT26(String aNT26)
	{
		if (aNT26 != null && !aNT26.equals(""))
		{
			Double tDouble = new Double(aNT26);
			double d = tDouble.doubleValue();
			nT26 = d;
		}
	}

	public double getNT27()
	{
		return nT27;
	}

	public void setNT27(double aNT27)
	{
		nT27 = aNT27;
	}

	public void setNT27(String aNT27)
	{
		if (aNT27 != null && !aNT27.equals(""))
		{
			Double tDouble = new Double(aNT27);
			double d = tDouble.doubleValue();
			nT27 = d;
		}
	}

	public double getNT28()
	{
		return nT28;
	}

	public void setNT28(double aNT28)
	{
		nT28 = aNT28;
	}

	public void setNT28(String aNT28)
	{
		if (aNT28 != null && !aNT28.equals(""))
		{
			Double tDouble = new Double(aNT28);
			double d = tDouble.doubleValue();
			nT28 = d;
		}
	}

	public double getNT29()
	{
		return nT29;
	}

	public void setNT29(double aNT29)
	{
		nT29 = aNT29;
	}

	public void setNT29(String aNT29)
	{
		if (aNT29 != null && !aNT29.equals(""))
		{
			Double tDouble = new Double(aNT29);
			double d = tDouble.doubleValue();
			nT29 = d;
		}
	}

	public double getNT30()
	{
		return nT30;
	}

	public void setNT30(double aNT30)
	{
		nT30 = aNT30;
	}

	public void setNT30(String aNT30)
	{
		if (aNT30 != null && !aNT30.equals(""))
		{
			Double tDouble = new Double(aNT30);
			double d = tDouble.doubleValue();
			nT30 = d;
		}
	}

	public double getNT31()
	{
		return nT31;
	}

	public void setNT31(double aNT31)
	{
		nT31 = aNT31;
	}

	public void setNT31(String aNT31)
	{
		if (aNT31 != null && !aNT31.equals(""))
		{
			Double tDouble = new Double(aNT31);
			double d = tDouble.doubleValue();
			nT31 = d;
		}
	}

	public double getNT32()
	{
		return nT32;
	}

	public void setNT32(double aNT32)
	{
		nT32 = aNT32;
	}

	public void setNT32(String aNT32)
	{
		if (aNT32 != null && !aNT32.equals(""))
		{
			Double tDouble = new Double(aNT32);
			double d = tDouble.doubleValue();
			nT32 = d;
		}
	}

	public double getNT33()
	{
		return nT33;
	}

	public void setNT33(double aNT33)
	{
		nT33 = aNT33;
	}

	public void setNT33(String aNT33)
	{
		if (aNT33 != null && !aNT33.equals(""))
		{
			Double tDouble = new Double(aNT33);
			double d = tDouble.doubleValue();
			nT33 = d;
		}
	}

	public double getNT34()
	{
		return nT34;
	}

	public void setNT34(double aNT34)
	{
		nT34 = aNT34;
	}

	public void setNT34(String aNT34)
	{
		if (aNT34 != null && !aNT34.equals(""))
		{
			Double tDouble = new Double(aNT34);
			double d = tDouble.doubleValue();
			nT34 = d;
		}
	}

	public double getNT35()
	{
		return nT35;
	}

	public void setNT35(double aNT35)
	{
		nT35 = aNT35;
	}

	public void setNT35(String aNT35)
	{
		if (aNT35 != null && !aNT35.equals(""))
		{
			Double tDouble = new Double(aNT35);
			double d = tDouble.doubleValue();
			nT35 = d;
		}
	}

	public double getNT36()
	{
		return nT36;
	}

	public void setNT36(double aNT36)
	{
		nT36 = aNT36;
	}

	public void setNT36(String aNT36)
	{
		if (aNT36 != null && !aNT36.equals(""))
		{
			Double tDouble = new Double(aNT36);
			double d = tDouble.doubleValue();
			nT36 = d;
		}
	}

	public double getNT37()
	{
		return nT37;
	}

	public void setNT37(double aNT37)
	{
		nT37 = aNT37;
	}

	public void setNT37(String aNT37)
	{
		if (aNT37 != null && !aNT37.equals(""))
		{
			Double tDouble = new Double(aNT37);
			double d = tDouble.doubleValue();
			nT37 = d;
		}
	}

	public double getNT38()
	{
		return nT38;
	}

	public void setNT38(double aNT38)
	{
		nT38 = aNT38;
	}

	public void setNT38(String aNT38)
	{
		if (aNT38 != null && !aNT38.equals(""))
		{
			Double tDouble = new Double(aNT38);
			double d = tDouble.doubleValue();
			nT38 = d;
		}
	}

	public double getNT39()
	{
		return nT39;
	}

	public void setNT39(double aNT39)
	{
		nT39 = aNT39;
	}

	public void setNT39(String aNT39)
	{
		if (aNT39 != null && !aNT39.equals(""))
		{
			Double tDouble = new Double(aNT39);
			double d = tDouble.doubleValue();
			nT39 = d;
		}
	}

	public double getNT40()
	{
		return nT40;
	}

	public void setNT40(double aNT40)
	{
		nT40 = aNT40;
	}

	public void setNT40(String aNT40)
	{
		if (aNT40 != null && !aNT40.equals(""))
		{
			Double tDouble = new Double(aNT40);
			double d = tDouble.doubleValue();
			nT40 = d;
		}
	}

	public double getNT41()
	{
		return nT41;
	}

	public void setNT41(double aNT41)
	{
		nT41 = aNT41;
	}

	public void setNT41(String aNT41)
	{
		if (aNT41 != null && !aNT41.equals(""))
		{
			Double tDouble = new Double(aNT41);
			double d = tDouble.doubleValue();
			nT41 = d;
		}
	}

	public double getNT42()
	{
		return nT42;
	}

	public void setNT42(double aNT42)
	{
		nT42 = aNT42;
	}

	public void setNT42(String aNT42)
	{
		if (aNT42 != null && !aNT42.equals(""))
		{
			Double tDouble = new Double(aNT42);
			double d = tDouble.doubleValue();
			nT42 = d;
		}
	}

	public double getNT43()
	{
		return nT43;
	}

	public void setNT43(double aNT43)
	{
		nT43 = aNT43;
	}

	public void setNT43(String aNT43)
	{
		if (aNT43 != null && !aNT43.equals(""))
		{
			Double tDouble = new Double(aNT43);
			double d = tDouble.doubleValue();
			nT43 = d;
		}
	}

	public double getNT44()
	{
		return nT44;
	}

	public void setNT44(double aNT44)
	{
		nT44 = aNT44;
	}

	public void setNT44(String aNT44)
	{
		if (aNT44 != null && !aNT44.equals(""))
		{
			Double tDouble = new Double(aNT44);
			double d = tDouble.doubleValue();
			nT44 = d;
		}
	}

	public double getNT45()
	{
		return nT45;
	}

	public void setNT45(double aNT45)
	{
		nT45 = aNT45;
	}

	public void setNT45(String aNT45)
	{
		if (aNT45 != null && !aNT45.equals(""))
		{
			Double tDouble = new Double(aNT45);
			double d = tDouble.doubleValue();
			nT45 = d;
		}
	}

	public double getNT46()
	{
		return nT46;
	}

	public void setNT46(double aNT46)
	{
		nT46 = aNT46;
	}

	public void setNT46(String aNT46)
	{
		if (aNT46 != null && !aNT46.equals(""))
		{
			Double tDouble = new Double(aNT46);
			double d = tDouble.doubleValue();
			nT46 = d;
		}
	}

	public double getNT47()
	{
		return nT47;
	}

	public void setNT47(double aNT47)
	{
		nT47 = aNT47;
	}

	public void setNT47(String aNT47)
	{
		if (aNT47 != null && !aNT47.equals(""))
		{
			Double tDouble = new Double(aNT47);
			double d = tDouble.doubleValue();
			nT47 = d;
		}
	}

	public double getNT48()
	{
		return nT48;
	}

	public void setNT48(double aNT48)
	{
		nT48 = aNT48;
	}

	public void setNT48(String aNT48)
	{
		if (aNT48 != null && !aNT48.equals(""))
		{
			Double tDouble = new Double(aNT48);
			double d = tDouble.doubleValue();
			nT48 = d;
		}
	}

	public double getNT49()
	{
		return nT49;
	}

	public void setNT49(double aNT49)
	{
		nT49 = aNT49;
	}

	public void setNT49(String aNT49)
	{
		if (aNT49 != null && !aNT49.equals(""))
		{
			Double tDouble = new Double(aNT49);
			double d = tDouble.doubleValue();
			nT49 = d;
		}
	}

	public double getNT50()
	{
		return nT50;
	}

	public void setNT50(double aNT50)
	{
		nT50 = aNT50;
	}

	public void setNT50(String aNT50)
	{
		if (aNT50 != null && !aNT50.equals(""))
		{
			Double tDouble = new Double(aNT50);
			double d = tDouble.doubleValue();
			nT50 = d;
		}
	}

	public double getNT51()
	{
		return nT51;
	}

	public void setNT51(double aNT51)
	{
		nT51 = aNT51;
	}

	public void setNT51(String aNT51)
	{
		if (aNT51 != null && !aNT51.equals(""))
		{
			Double tDouble = new Double(aNT51);
			double d = tDouble.doubleValue();
			nT51 = d;
		}
	}

	public double getNT52()
	{
		return nT52;
	}

	public void setNT52(double aNT52)
	{
		nT52 = aNT52;
	}

	public void setNT52(String aNT52)
	{
		if (aNT52 != null && !aNT52.equals(""))
		{
			Double tDouble = new Double(aNT52);
			double d = tDouble.doubleValue();
			nT52 = d;
		}
	}

	public double getNT53()
	{
		return nT53;
	}

	public void setNT53(double aNT53)
	{
		nT53 = aNT53;
	}

	public void setNT53(String aNT53)
	{
		if (aNT53 != null && !aNT53.equals(""))
		{
			Double tDouble = new Double(aNT53);
			double d = tDouble.doubleValue();
			nT53 = d;
		}
	}

	public double getNT54()
	{
		return nT54;
	}

	public void setNT54(double aNT54)
	{
		nT54 = aNT54;
	}

	public void setNT54(String aNT54)
	{
		if (aNT54 != null && !aNT54.equals(""))
		{
			Double tDouble = new Double(aNT54);
			double d = tDouble.doubleValue();
			nT54 = d;
		}
	}

	public double getNT55()
	{
		return nT55;
	}

	public void setNT55(double aNT55)
	{
		nT55 = aNT55;
	}

	public void setNT55(String aNT55)
	{
		if (aNT55 != null && !aNT55.equals(""))
		{
			Double tDouble = new Double(aNT55);
			double d = tDouble.doubleValue();
			nT55 = d;
		}
	}

	public double getNT56()
	{
		return nT56;
	}

	public void setNT56(double aNT56)
	{
		nT56 = aNT56;
	}

	public void setNT56(String aNT56)
	{
		if (aNT56 != null && !aNT56.equals(""))
		{
			Double tDouble = new Double(aNT56);
			double d = tDouble.doubleValue();
			nT56 = d;
		}
	}

	public double getNT57()
	{
		return nT57;
	}

	public void setNT57(double aNT57)
	{
		nT57 = aNT57;
	}

	public void setNT57(String aNT57)
	{
		if (aNT57 != null && !aNT57.equals(""))
		{
			Double tDouble = new Double(aNT57);
			double d = tDouble.doubleValue();
			nT57 = d;
		}
	}

	public double getNT58()
	{
		return nT58;
	}

	public void setNT58(double aNT58)
	{
		nT58 = aNT58;
	}

	public void setNT58(String aNT58)
	{
		if (aNT58 != null && !aNT58.equals(""))
		{
			Double tDouble = new Double(aNT58);
			double d = tDouble.doubleValue();
			nT58 = d;
		}
	}

	public double getNT59()
	{
		return nT59;
	}

	public void setNT59(double aNT59)
	{
		nT59 = aNT59;
	}

	public void setNT59(String aNT59)
	{
		if (aNT59 != null && !aNT59.equals(""))
		{
			Double tDouble = new Double(aNT59);
			double d = tDouble.doubleValue();
			nT59 = d;
		}
	}

	public double getNT60()
	{
		return nT60;
	}

	public void setNT60(double aNT60)
	{
		nT60 = aNT60;
	}

	public void setNT60(String aNT60)
	{
		if (aNT60 != null && !aNT60.equals(""))
		{
			Double tDouble = new Double(aNT60);
			double d = tDouble.doubleValue();
			nT60 = d;
		}
	}

	public double getNT61()
	{
		return nT61;
	}

	public void setNT61(double aNT61)
	{
		nT61 = aNT61;
	}

	public void setNT61(String aNT61)
	{
		if (aNT61 != null && !aNT61.equals(""))
		{
			Double tDouble = new Double(aNT61);
			double d = tDouble.doubleValue();
			nT61 = d;
		}
	}

	public double getNT62()
	{
		return nT62;
	}

	public void setNT62(double aNT62)
	{
		nT62 = aNT62;
	}

	public void setNT62(String aNT62)
	{
		if (aNT62 != null && !aNT62.equals(""))
		{
			Double tDouble = new Double(aNT62);
			double d = tDouble.doubleValue();
			nT62 = d;
		}
	}

	public double getNT63()
	{
		return nT63;
	}

	public void setNT63(double aNT63)
	{
		nT63 = aNT63;
	}

	public void setNT63(String aNT63)
	{
		if (aNT63 != null && !aNT63.equals(""))
		{
			Double tDouble = new Double(aNT63);
			double d = tDouble.doubleValue();
			nT63 = d;
		}
	}

	public double getNT64()
	{
		return nT64;
	}

	public void setNT64(double aNT64)
	{
		nT64 = aNT64;
	}

	public void setNT64(String aNT64)
	{
		if (aNT64 != null && !aNT64.equals(""))
		{
			Double tDouble = new Double(aNT64);
			double d = tDouble.doubleValue();
			nT64 = d;
		}
	}

	public double getNT65()
	{
		return nT65;
	}

	public void setNT65(double aNT65)
	{
		nT65 = aNT65;
	}

	public void setNT65(String aNT65)
	{
		if (aNT65 != null && !aNT65.equals(""))
		{
			Double tDouble = new Double(aNT65);
			double d = tDouble.doubleValue();
			nT65 = d;
		}
	}

	public double getNT66()
	{
		return nT66;
	}

	public void setNT66(double aNT66)
	{
		nT66 = aNT66;
	}

	public void setNT66(String aNT66)
	{
		if (aNT66 != null && !aNT66.equals(""))
		{
			Double tDouble = new Double(aNT66);
			double d = tDouble.doubleValue();
			nT66 = d;
		}
	}

	public double getNT67()
	{
		return nT67;
	}

	public void setNT67(double aNT67)
	{
		nT67 = aNT67;
	}

	public void setNT67(String aNT67)
	{
		if (aNT67 != null && !aNT67.equals(""))
		{
			Double tDouble = new Double(aNT67);
			double d = tDouble.doubleValue();
			nT67 = d;
		}
	}

	public double getNT68()
	{
		return nT68;
	}

	public void setNT68(double aNT68)
	{
		nT68 = aNT68;
	}

	public void setNT68(String aNT68)
	{
		if (aNT68 != null && !aNT68.equals(""))
		{
			Double tDouble = new Double(aNT68);
			double d = tDouble.doubleValue();
			nT68 = d;
		}
	}

	public double getNT69()
	{
		return nT69;
	}

	public void setNT69(double aNT69)
	{
		nT69 = aNT69;
	}

	public void setNT69(String aNT69)
	{
		if (aNT69 != null && !aNT69.equals(""))
		{
			Double tDouble = new Double(aNT69);
			double d = tDouble.doubleValue();
			nT69 = d;
		}
	}

	public double getNT70()
	{
		return nT70;
	}

	public void setNT70(double aNT70)
	{
		nT70 = aNT70;
	}

	public void setNT70(String aNT70)
	{
		if (aNT70 != null && !aNT70.equals(""))
		{
			Double tDouble = new Double(aNT70);
			double d = tDouble.doubleValue();
			nT70 = d;
		}
	}

	public double getNT71()
	{
		return nT71;
	}

	public void setNT71(double aNT71)
	{
		nT71 = aNT71;
	}

	public void setNT71(String aNT71)
	{
		if (aNT71 != null && !aNT71.equals(""))
		{
			Double tDouble = new Double(aNT71);
			double d = tDouble.doubleValue();
			nT71 = d;
		}
	}

	public double getNT72()
	{
		return nT72;
	}

	public void setNT72(double aNT72)
	{
		nT72 = aNT72;
	}

	public void setNT72(String aNT72)
	{
		if (aNT72 != null && !aNT72.equals(""))
		{
			Double tDouble = new Double(aNT72);
			double d = tDouble.doubleValue();
			nT72 = d;
		}
	}

	public double getNT73()
	{
		return nT73;
	}

	public void setNT73(double aNT73)
	{
		nT73 = aNT73;
	}

	public void setNT73(String aNT73)
	{
		if (aNT73 != null && !aNT73.equals(""))
		{
			Double tDouble = new Double(aNT73);
			double d = tDouble.doubleValue();
			nT73 = d;
		}
	}

	public double getNT74()
	{
		return nT74;
	}

	public void setNT74(double aNT74)
	{
		nT74 = aNT74;
	}

	public void setNT74(String aNT74)
	{
		if (aNT74 != null && !aNT74.equals(""))
		{
			Double tDouble = new Double(aNT74);
			double d = tDouble.doubleValue();
			nT74 = d;
		}
	}

	public double getNT75()
	{
		return nT75;
	}

	public void setNT75(double aNT75)
	{
		nT75 = aNT75;
	}

	public void setNT75(String aNT75)
	{
		if (aNT75 != null && !aNT75.equals(""))
		{
			Double tDouble = new Double(aNT75);
			double d = tDouble.doubleValue();
			nT75 = d;
		}
	}

	public double getNT76()
	{
		return nT76;
	}

	public void setNT76(double aNT76)
	{
		nT76 = aNT76;
	}

	public void setNT76(String aNT76)
	{
		if (aNT76 != null && !aNT76.equals(""))
		{
			Double tDouble = new Double(aNT76);
			double d = tDouble.doubleValue();
			nT76 = d;
		}
	}

	public double getNT77()
	{
		return nT77;
	}

	public void setNT77(double aNT77)
	{
		nT77 = aNT77;
	}

	public void setNT77(String aNT77)
	{
		if (aNT77 != null && !aNT77.equals(""))
		{
			Double tDouble = new Double(aNT77);
			double d = tDouble.doubleValue();
			nT77 = d;
		}
	}

	public double getNT78()
	{
		return nT78;
	}

	public void setNT78(double aNT78)
	{
		nT78 = aNT78;
	}

	public void setNT78(String aNT78)
	{
		if (aNT78 != null && !aNT78.equals(""))
		{
			Double tDouble = new Double(aNT78);
			double d = tDouble.doubleValue();
			nT78 = d;
		}
	}

	public double getNT79()
	{
		return nT79;
	}

	public void setNT79(double aNT79)
	{
		nT79 = aNT79;
	}

	public void setNT79(String aNT79)
	{
		if (aNT79 != null && !aNT79.equals(""))
		{
			Double tDouble = new Double(aNT79);
			double d = tDouble.doubleValue();
			nT79 = d;
		}
	}

	public double getNT80()
	{
		return nT80;
	}

	public void setNT80(double aNT80)
	{
		nT80 = aNT80;
	}

	public void setNT80(String aNT80)
	{
		if (aNT80 != null && !aNT80.equals(""))
		{
			Double tDouble = new Double(aNT80);
			double d = tDouble.doubleValue();
			nT80 = d;
		}
	}

	public double getNF01()
	{
		return nF01;
	}

	public void setNF01(double aNF01)
	{
		nF01 = aNF01;
	}

	public void setNF01(String aNF01)
	{
		if (aNF01 != null && !aNF01.equals(""))
		{
			Double tDouble = new Double(aNF01);
			double d = tDouble.doubleValue();
			nF01 = d;
		}
	}

	public double getNF02()
	{
		return nF02;
	}

	public void setNF02(double aNF02)
	{
		nF02 = aNF02;
	}

	public void setNF02(String aNF02)
	{
		if (aNF02 != null && !aNF02.equals(""))
		{
			Double tDouble = new Double(aNF02);
			double d = tDouble.doubleValue();
			nF02 = d;
		}
	}

	public double getNF03()
	{
		return nF03;
	}

	public void setNF03(double aNF03)
	{
		nF03 = aNF03;
	}

	public void setNF03(String aNF03)
	{
		if (aNF03 != null && !aNF03.equals(""))
		{
			Double tDouble = new Double(aNF03);
			double d = tDouble.doubleValue();
			nF03 = d;
		}
	}

	public double getNF04()
	{
		return nF04;
	}

	public void setNF04(double aNF04)
	{
		nF04 = aNF04;
	}

	public void setNF04(String aNF04)
	{
		if (aNF04 != null && !aNF04.equals(""))
		{
			Double tDouble = new Double(aNF04);
			double d = tDouble.doubleValue();
			nF04 = d;
		}
	}

	public double getNF05()
	{
		return nF05;
	}

	public void setNF05(double aNF05)
	{
		nF05 = aNF05;
	}

	public void setNF05(String aNF05)
	{
		if (aNF05 != null && !aNF05.equals(""))
		{
			Double tDouble = new Double(aNF05);
			double d = tDouble.doubleValue();
			nF05 = d;
		}
	}

	public double getNF06()
	{
		return nF06;
	}

	public void setNF06(double aNF06)
	{
		nF06 = aNF06;
	}

	public void setNF06(String aNF06)
	{
		if (aNF06 != null && !aNF06.equals(""))
		{
			Double tDouble = new Double(aNF06);
			double d = tDouble.doubleValue();
			nF06 = d;
		}
	}

	public double getNF07()
	{
		return nF07;
	}

	public void setNF07(double aNF07)
	{
		nF07 = aNF07;
	}

	public void setNF07(String aNF07)
	{
		if (aNF07 != null && !aNF07.equals(""))
		{
			Double tDouble = new Double(aNF07);
			double d = tDouble.doubleValue();
			nF07 = d;
		}
	}

	public double getNF08()
	{
		return nF08;
	}

	public void setNF08(double aNF08)
	{
		nF08 = aNF08;
	}

	public void setNF08(String aNF08)
	{
		if (aNF08 != null && !aNF08.equals(""))
		{
			Double tDouble = new Double(aNF08);
			double d = tDouble.doubleValue();
			nF08 = d;
		}
	}

	public double getNF09()
	{
		return nF09;
	}

	public void setNF09(double aNF09)
	{
		nF09 = aNF09;
	}

	public void setNF09(String aNF09)
	{
		if (aNF09 != null && !aNF09.equals(""))
		{
			Double tDouble = new Double(aNF09);
			double d = tDouble.doubleValue();
			nF09 = d;
		}
	}

	public double getNF10()
	{
		return nF10;
	}

	public void setNF10(double aNF10)
	{
		nF10 = aNF10;
	}

	public void setNF10(String aNF10)
	{
		if (aNF10 != null && !aNF10.equals(""))
		{
			Double tDouble = new Double(aNF10);
			double d = tDouble.doubleValue();
			nF10 = d;
		}
	}

	public double getNS01()
	{
		return nS01;
	}

	public void setNS01(double aNS01)
	{
		nS01 = aNS01;
	}

	public void setNS01(String aNS01)
	{
		if (aNS01 != null && !aNS01.equals(""))
		{
			Double tDouble = new Double(aNS01);
			double d = tDouble.doubleValue();
			nS01 = d;
		}
	}

	public double getNS02()
	{
		return nS02;
	}

	public void setNS02(double aNS02)
	{
		nS02 = aNS02;
	}

	public void setNS02(String aNS02)
	{
		if (aNS02 != null && !aNS02.equals(""))
		{
			Double tDouble = new Double(aNS02);
			double d = tDouble.doubleValue();
			nS02 = d;
		}
	}

	public double getNS03()
	{
		return nS03;
	}

	public void setNS03(double aNS03)
	{
		nS03 = aNS03;
	}

	public void setNS03(String aNS03)
	{
		if (aNS03 != null && !aNS03.equals(""))
		{
			Double tDouble = new Double(aNS03);
			double d = tDouble.doubleValue();
			nS03 = d;
		}
	}

	public double getNS04()
	{
		return nS04;
	}

	public void setNS04(double aNS04)
	{
		nS04 = aNS04;
	}

	public void setNS04(String aNS04)
	{
		if (aNS04 != null && !aNS04.equals(""))
		{
			Double tDouble = new Double(aNS04);
			double d = tDouble.doubleValue();
			nS04 = d;
		}
	}

	public double getNS05()
	{
		return nS05;
	}

	public void setNS05(double aNS05)
	{
		nS05 = aNS05;
	}

	public void setNS05(String aNS05)
	{
		if (aNS05 != null && !aNS05.equals(""))
		{
			Double tDouble = new Double(aNS05);
			double d = tDouble.doubleValue();
			nS05 = d;
		}
	}

	public double getNS06()
	{
		return nS06;
	}

	public void setNS06(double aNS06)
	{
		nS06 = aNS06;
	}

	public void setNS06(String aNS06)
	{
		if (aNS06 != null && !aNS06.equals(""))
		{
			Double tDouble = new Double(aNS06);
			double d = tDouble.doubleValue();
			nS06 = d;
		}
	}

	public double getNS07()
	{
		return nS07;
	}

	public void setNS07(double aNS07)
	{
		nS07 = aNS07;
	}

	public void setNS07(String aNS07)
	{
		if (aNS07 != null && !aNS07.equals(""))
		{
			Double tDouble = new Double(aNS07);
			double d = tDouble.doubleValue();
			nS07 = d;
		}
	}

	public double getNS08()
	{
		return nS08;
	}

	public void setNS08(double aNS08)
	{
		nS08 = aNS08;
	}

	public void setNS08(String aNS08)
	{
		if (aNS08 != null && !aNS08.equals(""))
		{
			Double tDouble = new Double(aNS08);
			double d = tDouble.doubleValue();
			nS08 = d;
		}
	}

	public double getNS09()
	{
		return nS09;
	}

	public void setNS09(double aNS09)
	{
		nS09 = aNS09;
	}

	public void setNS09(String aNS09)
	{
		if (aNS09 != null && !aNS09.equals(""))
		{
			Double tDouble = new Double(aNS09);
			double d = tDouble.doubleValue();
			nS09 = d;
		}
	}

	public double getNS10()
	{
		return nS10;
	}

	public void setNS10(double aNS10)
	{
		nS10 = aNS10;
	}

	public void setNS10(String aNS10)
	{
		if (aNS10 != null && !aNS10.equals(""))
		{
			Double tDouble = new Double(aNS10);
			double d = tDouble.doubleValue();
			nS10 = d;
		}
	}

	public int getINT01()
	{
		return iNT01;
	}

	public void setINT01(int aINT01)
	{
		iNT01 = aINT01;
	}

	public void setINT01(String aINT01)
	{
		if (aINT01 != null && !aINT01.equals(""))
		{
			Integer tInteger = new Integer(aINT01);
			int i = tInteger.intValue();
			iNT01 = i;
		}
	}

	public int getINT02()
	{
		return iNT02;
	}

	public void setINT02(int aINT02)
	{
		iNT02 = aINT02;
	}

	public void setINT02(String aINT02)
	{
		if (aINT02 != null && !aINT02.equals(""))
		{
			Integer tInteger = new Integer(aINT02);
			int i = tInteger.intValue();
			iNT02 = i;
		}
	}

	public int getINT03()
	{
		return iNT03;
	}

	public void setINT03(int aINT03)
	{
		iNT03 = aINT03;
	}

	public void setINT03(String aINT03)
	{
		if (aINT03 != null && !aINT03.equals(""))
		{
			Integer tInteger = new Integer(aINT03);
			int i = tInteger.intValue();
			iNT03 = i;
		}
	}

	public int getINT04()
	{
		return iNT04;
	}

	public void setINT04(int aINT04)
	{
		iNT04 = aINT04;
	}

	public void setINT04(String aINT04)
	{
		if (aINT04 != null && !aINT04.equals(""))
		{
			Integer tInteger = new Integer(aINT04);
			int i = tInteger.intValue();
			iNT04 = i;
		}
	}

	public int getINT05()
	{
		return iNT05;
	}

	public void setINT05(int aINT05)
	{
		iNT05 = aINT05;
	}

	public void setINT05(String aINT05)
	{
		if (aINT05 != null && !aINT05.equals(""))
		{
			Integer tInteger = new Integer(aINT05);
			int i = tInteger.intValue();
			iNT05 = i;
		}
	}

	public int getINT06()
	{
		return iNT06;
	}

	public void setINT06(int aINT06)
	{
		iNT06 = aINT06;
	}

	public void setINT06(String aINT06)
	{
		if (aINT06 != null && !aINT06.equals(""))
		{
			Integer tInteger = new Integer(aINT06);
			int i = tInteger.intValue();
			iNT06 = i;
		}
	}

	public int getINT07()
	{
		return iNT07;
	}

	public void setINT07(int aINT07)
	{
		iNT07 = aINT07;
	}

	public void setINT07(String aINT07)
	{
		if (aINT07 != null && !aINT07.equals(""))
		{
			Integer tInteger = new Integer(aINT07);
			int i = tInteger.intValue();
			iNT07 = i;
		}
	}

	public int getINT08()
	{
		return iNT08;
	}

	public void setINT08(int aINT08)
	{
		iNT08 = aINT08;
	}

	public void setINT08(String aINT08)
	{
		if (aINT08 != null && !aINT08.equals(""))
		{
			Integer tInteger = new Integer(aINT08);
			int i = tInteger.intValue();
			iNT08 = i;
		}
	}

	public int getINT09()
	{
		return iNT09;
	}

	public void setINT09(int aINT09)
	{
		iNT09 = aINT09;
	}

	public void setINT09(String aINT09)
	{
		if (aINT09 != null && !aINT09.equals(""))
		{
			Integer tInteger = new Integer(aINT09);
			int i = tInteger.intValue();
			iNT09 = i;
		}
	}

	public int getINT10()
	{
		return iNT10;
	}

	public void setINT10(int aINT10)
	{
		iNT10 = aINT10;
	}

	public void setINT10(String aINT10)
	{
		if (aINT10 != null && !aINT10.equals(""))
		{
			Integer tInteger = new Integer(aINT10);
			int i = tInteger.intValue();
			iNT10 = i;
		}
	}

	public int getINT11()
	{
		return iNT11;
	}

	public void setINT11(int aINT11)
	{
		iNT11 = aINT11;
	}

	public void setINT11(String aINT11)
	{
		if (aINT11 != null && !aINT11.equals(""))
		{
			Integer tInteger = new Integer(aINT11);
			int i = tInteger.intValue();
			iNT11 = i;
		}
	}

	public int getINT12()
	{
		return iNT12;
	}

	public void setINT12(int aINT12)
	{
		iNT12 = aINT12;
	}

	public void setINT12(String aINT12)
	{
		if (aINT12 != null && !aINT12.equals(""))
		{
			Integer tInteger = new Integer(aINT12);
			int i = tInteger.intValue();
			iNT12 = i;
		}
	}

	public int getINT13()
	{
		return iNT13;
	}

	public void setINT13(int aINT13)
	{
		iNT13 = aINT13;
	}

	public void setINT13(String aINT13)
	{
		if (aINT13 != null && !aINT13.equals(""))
		{
			Integer tInteger = new Integer(aINT13);
			int i = tInteger.intValue();
			iNT13 = i;
		}
	}

	public int getINT14()
	{
		return iNT14;
	}

	public void setINT14(int aINT14)
	{
		iNT14 = aINT14;
	}

	public void setINT14(String aINT14)
	{
		if (aINT14 != null && !aINT14.equals(""))
		{
			Integer tInteger = new Integer(aINT14);
			int i = tInteger.intValue();
			iNT14 = i;
		}
	}

	public int getINT15()
	{
		return iNT15;
	}

	public void setINT15(int aINT15)
	{
		iNT15 = aINT15;
	}

	public void setINT15(String aINT15)
	{
		if (aINT15 != null && !aINT15.equals(""))
		{
			Integer tInteger = new Integer(aINT15);
			int i = tInteger.intValue();
			iNT15 = i;
		}
	}

	public int getINT16()
	{
		return iNT16;
	}

	public void setINT16(int aINT16)
	{
		iNT16 = aINT16;
	}

	public void setINT16(String aINT16)
	{
		if (aINT16 != null && !aINT16.equals(""))
		{
			Integer tInteger = new Integer(aINT16);
			int i = tInteger.intValue();
			iNT16 = i;
		}
	}

	public int getINT17()
	{
		return iNT17;
	}

	public void setINT17(int aINT17)
	{
		iNT17 = aINT17;
	}

	public void setINT17(String aINT17)
	{
		if (aINT17 != null && !aINT17.equals(""))
		{
			Integer tInteger = new Integer(aINT17);
			int i = tInteger.intValue();
			iNT17 = i;
		}
	}

	public int getINT18()
	{
		return iNT18;
	}

	public void setINT18(int aINT18)
	{
		iNT18 = aINT18;
	}

	public void setINT18(String aINT18)
	{
		if (aINT18 != null && !aINT18.equals(""))
		{
			Integer tInteger = new Integer(aINT18);
			int i = tInteger.intValue();
			iNT18 = i;
		}
	}

	public int getINT19()
	{
		return iNT19;
	}

	public void setINT19(int aINT19)
	{
		iNT19 = aINT19;
	}

	public void setINT19(String aINT19)
	{
		if (aINT19 != null && !aINT19.equals(""))
		{
			Integer tInteger = new Integer(aINT19);
			int i = tInteger.intValue();
			iNT19 = i;
		}
	}

	public int getINT20()
	{
		return iNT20;
	}

	public void setINT20(int aINT20)
	{
		iNT20 = aINT20;
	}

	public void setINT20(String aINT20)
	{
		if (aINT20 != null && !aINT20.equals(""))
		{
			Integer tInteger = new Integer(aINT20);
			int i = tInteger.intValue();
			iNT20 = i;
		}
	}

	public int getINT21()
	{
		return iNT21;
	}

	public void setINT21(int aINT21)
	{
		iNT21 = aINT21;
	}

	public void setINT21(String aINT21)
	{
		if (aINT21 != null && !aINT21.equals(""))
		{
			Integer tInteger = new Integer(aINT21);
			int i = tInteger.intValue();
			iNT21 = i;
		}
	}

	public int getINT22()
	{
		return iNT22;
	}

	public void setINT22(int aINT22)
	{
		iNT22 = aINT22;
	}

	public void setINT22(String aINT22)
	{
		if (aINT22 != null && !aINT22.equals(""))
		{
			Integer tInteger = new Integer(aINT22);
			int i = tInteger.intValue();
			iNT22 = i;
		}
	}

	public int getINT23()
	{
		return iNT23;
	}

	public void setINT23(int aINT23)
	{
		iNT23 = aINT23;
	}

	public void setINT23(String aINT23)
	{
		if (aINT23 != null && !aINT23.equals(""))
		{
			Integer tInteger = new Integer(aINT23);
			int i = tInteger.intValue();
			iNT23 = i;
		}
	}

	public int getINT24()
	{
		return iNT24;
	}

	public void setINT24(int aINT24)
	{
		iNT24 = aINT24;
	}

	public void setINT24(String aINT24)
	{
		if (aINT24 != null && !aINT24.equals(""))
		{
			Integer tInteger = new Integer(aINT24);
			int i = tInteger.intValue();
			iNT24 = i;
		}
	}

	public int getINT25()
	{
		return iNT25;
	}

	public void setINT25(int aINT25)
	{
		iNT25 = aINT25;
	}

	public void setINT25(String aINT25)
	{
		if (aINT25 != null && !aINT25.equals(""))
		{
			Integer tInteger = new Integer(aINT25);
			int i = tInteger.intValue();
			iNT25 = i;
		}
	}

	public String getV1()
	{
		return v1;
	}

	public void setV1(String aV1)
	{
		v1 = aV1;
	}

	public String getV2()
	{
		return v2;
	}

	public void setV2(String aV2)
	{
		v2 = aV2;
	}

	public String getV3()
	{
		return v3;
	}

	public void setV3(String aV3)
	{
		v3 = aV3;
	}

	public String getV4()
	{
		return v4;
	}

	public void setV4(String aV4)
	{
		v4 = aV4;
	}

	public String getV5()
	{
		return v5;
	}

	public void setV5(String aV5)
	{
		v5 = aV5;
	}

	public String getV6()
	{
		return v6;
	}

	public void setV6(String aV6)
	{
		v6 = aV6;
	}

	public String getV7()
	{
		return v7;
	}

	public void setV7(String aV7)
	{
		v7 = aV7;
	}

	public String getV8()
	{
		return v8;
	}

	public void setV8(String aV8)
	{
		v8 = aV8;
	}

	public String getV9()
	{
		return v9;
	}

	public void setV9(String aV9)
	{
		v9 = aV9;
	}

	public String getV10()
	{
		return v10;
	}

	public void setV10(String aV10)
	{
		v10 = aV10;
	}

	public String getV11()
	{
		return v11;
	}

	public void setV11(String aV11)
	{
		v11 = aV11;
	}

	public String getV12()
	{
		return v12;
	}

	public void setV12(String aV12)
	{
		v12 = aV12;
	}

	public String getV13()
	{
		return v13;
	}

	public void setV13(String aV13)
	{
		v13 = aV13;
	}

	public String getV14()
	{
		return v14;
	}

	public void setV14(String aV14)
	{
		v14 = aV14;
	}

	public String getV15()
	{
		return v15;
	}

	public void setV15(String aV15)
	{
		v15 = aV15;
	}

	public String getV16()
	{
		return v16;
	}

	public void setV16(String aV16)
	{
		v16 = aV16;
	}

	public String getV17()
	{
		return v17;
	}

	public void setV17(String aV17)
	{
		v17 = aV17;
	}

	public String getV18()
	{
		return v18;
	}

	public void setV18(String aV18)
	{
		v18 = aV18;
	}

	public String getV19()
	{
		return v19;
	}

	public void setV19(String aV19)
	{
		v19 = aV19;
	}

	public String getV20()
	{
		return v20;
	}

	public void setV20(String aV20)
	{
		v20 = aV20;
	}

	public String getVT1()
	{
		return vT1;
	}

	public void setVT1(String aVT1)
	{
		vT1 = aVT1;
	}

	public String getVT2()
	{
		return vT2;
	}

	public void setVT2(String aVT2)
	{
		vT2 = aVT2;
	}

	public String getVT3()
	{
		return vT3;
	}

	public void setVT3(String aVT3)
	{
		vT3 = aVT3;
	}

	public String getVT4()
	{
		return vT4;
	}

	public void setVT4(String aVT4)
	{
		vT4 = aVT4;
	}

	public String getVT5()
	{
		return vT5;
	}

	public void setVT5(String aVT5)
	{
		vT5 = aVT5;
	}

	public String getVT6()
	{
		return vT6;
	}

	public void setVT6(String aVT6)
	{
		vT6 = aVT6;
	}

	public String getVT7()
	{
		return vT7;
	}

	public void setVT7(String aVT7)
	{
		vT7 = aVT7;
	}

	public String getVT8()
	{
		return vT8;
	}

	public void setVT8(String aVT8)
	{
		vT8 = aVT8;
	}

	public String getVE1()
	{
		return vE1;
	}

	public void setVE1(String aVE1)
	{
		vE1 = aVE1;
	}

	public String getVE2()
	{
		return vE2;
	}

	public void setVE2(String aVE2)
	{
		vE2 = aVE2;
	}

	public String getVE3()
	{
		return vE3;
	}

	public void setVE3(String aVE3)
	{
		vE3 = aVE3;
	}

	public String getVE4()
	{
		return vE4;
	}

	public void setVE4(String aVE4)
	{
		vE4 = aVE4;
	}

	public String getVE5()
	{
		return vE5;
	}

	public void setVE5(String aVE5)
	{
		vE5 = aVE5;
	}

	public String getVE6()
	{
		return vE6;
	}

	public void setVE6(String aVE6)
	{
		vE6 = aVE6;
	}

	public String getVE7()
	{
		return vE7;
	}

	public void setVE7(String aVE7)
	{
		vE7 = aVE7;
	}

	public String getVE8()
	{
		return vE8;
	}

	public void setVE8(String aVE8)
	{
		vE8 = aVE8;
	}

	public String getVE9()
	{
		return vE9;
	}

	public void setVE9(String aVE9)
	{
		vE9 = aVE9;
	}

	public String getVE10()
	{
		return vE10;
	}

	public void setVE10(String aVE10)
	{
		vE10 = aVE10;
	}

	public String getD1()
	{
		if (d1 != null)
			return fDate.getString(d1);
		else
			return null;
	}

	public void setD1(Date aD1)
	{
		d1 = aD1;
	}

	public void setD1(String aD1)
	{
		if (aD1 != null && !aD1.equals(""))
			d1 = fDate.getDate(aD1);
		else
			d1 = null;
	}

	public String getD2()
	{
		if (d2 != null)
			return fDate.getString(d2);
		else
			return null;
	}

	public void setD2(Date aD2)
	{
		d2 = aD2;
	}

	public void setD2(String aD2)
	{
		if (aD2 != null && !aD2.equals(""))
			d2 = fDate.getDate(aD2);
		else
			d2 = null;
	}

	public String getD3()
	{
		if (d3 != null)
			return fDate.getString(d3);
		else
			return null;
	}

	public void setD3(Date aD3)
	{
		d3 = aD3;
	}

	public void setD3(String aD3)
	{
		if (aD3 != null && !aD3.equals(""))
			d3 = fDate.getDate(aD3);
		else
			d3 = null;
	}

	public String getD4()
	{
		if (d4 != null)
			return fDate.getString(d4);
		else
			return null;
	}

	public void setD4(Date aD4)
	{
		d4 = aD4;
	}

	public void setD4(String aD4)
	{
		if (aD4 != null && !aD4.equals(""))
			d4 = fDate.getDate(aD4);
		else
			d4 = null;
	}

	public String getD5()
	{
		if (d5 != null)
			return fDate.getString(d5);
		else
			return null;
	}

	public void setD5(Date aD5)
	{
		d5 = aD5;
	}

	public void setD5(String aD5)
	{
		if (aD5 != null && !aD5.equals(""))
			d5 = fDate.getDate(aD5);
		else
			d5 = null;
	}

	public String getD6()
	{
		if (d6 != null)
			return fDate.getString(d6);
		else
			return null;
	}

	public void setD6(Date aD6)
	{
		d6 = aD6;
	}

	public void setD6(String aD6)
	{
		if (aD6 != null && !aD6.equals(""))
			d6 = fDate.getDate(aD6);
		else
			d6 = null;
	}

	public String getD7()
	{
		if (d7 != null)
			return fDate.getString(d7);
		else
			return null;
	}

	public void setD7(Date aD7)
	{
		d7 = aD7;
	}

	public void setD7(String aD7)
	{
		if (aD7 != null && !aD7.equals(""))
			d7 = fDate.getDate(aD7);
		else
			d7 = null;
	}

	public String getD8()
	{
		if (d8 != null)
			return fDate.getString(d8);
		else
			return null;
	}

	public void setD8(Date aD8)
	{
		d8 = aD8;
	}

	public void setD8(String aD8)
	{
		if (aD8 != null && !aD8.equals(""))
			d8 = fDate.getDate(aD8);
		else
			d8 = null;
	}

	public String getD9()
	{
		if (d9 != null)
			return fDate.getString(d9);
		else
			return null;
	}

	public void setD9(Date aD9)
	{
		d9 = aD9;
	}

	public void setD9(String aD9)
	{
		if (aD9 != null && !aD9.equals(""))
			d9 = fDate.getDate(aD9);
		else
			d9 = null;
	}

	public String getD10()
	{
		if (d10 != null)
			return fDate.getString(d10);
		else
			return null;
	}

	public void setD10(Date aD10)
	{
		d10 = aD10;
	}

	public void setD10(String aD10)
	{
		if (aD10 != null && !aD10.equals(""))
			d10 = fDate.getDate(aD10);
		else
			d10 = null;
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

	public void setSchema(LAIndexInfoNewSchema aLAIndexInfoNewSchema)
	{
		indexCalNo = aLAIndexInfoNewSchema.getIndexCalNo();
		indexType = aLAIndexInfoNewSchema.getIndexType();
		manageCom = aLAIndexInfoNewSchema.getManageCom();
		agentGroup = aLAIndexInfoNewSchema.getAgentGroup();
		branchAttr = aLAIndexInfoNewSchema.getBranchAttr();
		agentCode = aLAIndexInfoNewSchema.getAgentCode();
		agentGrade = aLAIndexInfoNewSchema.getAgentGrade();
		agentTitle = aLAIndexInfoNewSchema.getAgentTitle();
		quaBgnMark = aLAIndexInfoNewSchema.getQuaBgnMark();
		postMonths = aLAIndexInfoNewSchema.getPostMonths();
		assessMonth = aLAIndexInfoNewSchema.getAssessMonth();
		agentGrade1 = aLAIndexInfoNewSchema.getAgentGrade1();
		agentTitle1 = aLAIndexInfoNewSchema.getAgentTitle1();
		agentGrade2 = aLAIndexInfoNewSchema.getAgentGrade2();
		agentTitle2 = aLAIndexInfoNewSchema.getAgentTitle2();
		agentGrade3 = aLAIndexInfoNewSchema.getAgentGrade3();
		agentTitle3 = aLAIndexInfoNewSchema.getAgentTitle3();
		startDate = fDate.getDate(aLAIndexInfoNewSchema.getStartDate());
		startEnd = fDate.getDate(aLAIndexInfoNewSchema.getStartEnd());
		startDate1 = fDate.getDate(aLAIndexInfoNewSchema.getStartDate1());
		startEnd1 = fDate.getDate(aLAIndexInfoNewSchema.getStartEnd1());
		startDate2 = fDate.getDate(aLAIndexInfoNewSchema.getStartDate2());
		startEnd2 = fDate.getDate(aLAIndexInfoNewSchema.getStartEnd2());
		startDate3 = fDate.getDate(aLAIndexInfoNewSchema.getStartDate3());
		startEnd3 = fDate.getDate(aLAIndexInfoNewSchema.getStartEnd3());
		startEnd4 = fDate.getDate(aLAIndexInfoNewSchema.getStartEnd4());
		startDate4 = fDate.getDate(aLAIndexInfoNewSchema.getStartDate4());
		serverMonths = aLAIndexInfoNewSchema.getServerMonths();
		nT01 = aLAIndexInfoNewSchema.getNT01();
		nT02 = aLAIndexInfoNewSchema.getNT02();
		nT03 = aLAIndexInfoNewSchema.getNT03();
		nT04 = aLAIndexInfoNewSchema.getNT04();
		nT05 = aLAIndexInfoNewSchema.getNT05();
		nT06 = aLAIndexInfoNewSchema.getNT06();
		nT07 = aLAIndexInfoNewSchema.getNT07();
		nT08 = aLAIndexInfoNewSchema.getNT08();
		nT09 = aLAIndexInfoNewSchema.getNT09();
		nT10 = aLAIndexInfoNewSchema.getNT10();
		nT11 = aLAIndexInfoNewSchema.getNT11();
		nT12 = aLAIndexInfoNewSchema.getNT12();
		nT13 = aLAIndexInfoNewSchema.getNT13();
		nT14 = aLAIndexInfoNewSchema.getNT14();
		nT15 = aLAIndexInfoNewSchema.getNT15();
		nT16 = aLAIndexInfoNewSchema.getNT16();
		nT17 = aLAIndexInfoNewSchema.getNT17();
		nT18 = aLAIndexInfoNewSchema.getNT18();
		nT19 = aLAIndexInfoNewSchema.getNT19();
		nT20 = aLAIndexInfoNewSchema.getNT20();
		nT21 = aLAIndexInfoNewSchema.getNT21();
		nT22 = aLAIndexInfoNewSchema.getNT22();
		nT23 = aLAIndexInfoNewSchema.getNT23();
		nT24 = aLAIndexInfoNewSchema.getNT24();
		nT25 = aLAIndexInfoNewSchema.getNT25();
		nT26 = aLAIndexInfoNewSchema.getNT26();
		nT27 = aLAIndexInfoNewSchema.getNT27();
		nT28 = aLAIndexInfoNewSchema.getNT28();
		nT29 = aLAIndexInfoNewSchema.getNT29();
		nT30 = aLAIndexInfoNewSchema.getNT30();
		nT31 = aLAIndexInfoNewSchema.getNT31();
		nT32 = aLAIndexInfoNewSchema.getNT32();
		nT33 = aLAIndexInfoNewSchema.getNT33();
		nT34 = aLAIndexInfoNewSchema.getNT34();
		nT35 = aLAIndexInfoNewSchema.getNT35();
		nT36 = aLAIndexInfoNewSchema.getNT36();
		nT37 = aLAIndexInfoNewSchema.getNT37();
		nT38 = aLAIndexInfoNewSchema.getNT38();
		nT39 = aLAIndexInfoNewSchema.getNT39();
		nT40 = aLAIndexInfoNewSchema.getNT40();
		nT41 = aLAIndexInfoNewSchema.getNT41();
		nT42 = aLAIndexInfoNewSchema.getNT42();
		nT43 = aLAIndexInfoNewSchema.getNT43();
		nT44 = aLAIndexInfoNewSchema.getNT44();
		nT45 = aLAIndexInfoNewSchema.getNT45();
		nT46 = aLAIndexInfoNewSchema.getNT46();
		nT47 = aLAIndexInfoNewSchema.getNT47();
		nT48 = aLAIndexInfoNewSchema.getNT48();
		nT49 = aLAIndexInfoNewSchema.getNT49();
		nT50 = aLAIndexInfoNewSchema.getNT50();
		nT51 = aLAIndexInfoNewSchema.getNT51();
		nT52 = aLAIndexInfoNewSchema.getNT52();
		nT53 = aLAIndexInfoNewSchema.getNT53();
		nT54 = aLAIndexInfoNewSchema.getNT54();
		nT55 = aLAIndexInfoNewSchema.getNT55();
		nT56 = aLAIndexInfoNewSchema.getNT56();
		nT57 = aLAIndexInfoNewSchema.getNT57();
		nT58 = aLAIndexInfoNewSchema.getNT58();
		nT59 = aLAIndexInfoNewSchema.getNT59();
		nT60 = aLAIndexInfoNewSchema.getNT60();
		nT61 = aLAIndexInfoNewSchema.getNT61();
		nT62 = aLAIndexInfoNewSchema.getNT62();
		nT63 = aLAIndexInfoNewSchema.getNT63();
		nT64 = aLAIndexInfoNewSchema.getNT64();
		nT65 = aLAIndexInfoNewSchema.getNT65();
		nT66 = aLAIndexInfoNewSchema.getNT66();
		nT67 = aLAIndexInfoNewSchema.getNT67();
		nT68 = aLAIndexInfoNewSchema.getNT68();
		nT69 = aLAIndexInfoNewSchema.getNT69();
		nT70 = aLAIndexInfoNewSchema.getNT70();
		nT71 = aLAIndexInfoNewSchema.getNT71();
		nT72 = aLAIndexInfoNewSchema.getNT72();
		nT73 = aLAIndexInfoNewSchema.getNT73();
		nT74 = aLAIndexInfoNewSchema.getNT74();
		nT75 = aLAIndexInfoNewSchema.getNT75();
		nT76 = aLAIndexInfoNewSchema.getNT76();
		nT77 = aLAIndexInfoNewSchema.getNT77();
		nT78 = aLAIndexInfoNewSchema.getNT78();
		nT79 = aLAIndexInfoNewSchema.getNT79();
		nT80 = aLAIndexInfoNewSchema.getNT80();
		nF01 = aLAIndexInfoNewSchema.getNF01();
		nF02 = aLAIndexInfoNewSchema.getNF02();
		nF03 = aLAIndexInfoNewSchema.getNF03();
		nF04 = aLAIndexInfoNewSchema.getNF04();
		nF05 = aLAIndexInfoNewSchema.getNF05();
		nF06 = aLAIndexInfoNewSchema.getNF06();
		nF07 = aLAIndexInfoNewSchema.getNF07();
		nF08 = aLAIndexInfoNewSchema.getNF08();
		nF09 = aLAIndexInfoNewSchema.getNF09();
		nF10 = aLAIndexInfoNewSchema.getNF10();
		nS01 = aLAIndexInfoNewSchema.getNS01();
		nS02 = aLAIndexInfoNewSchema.getNS02();
		nS03 = aLAIndexInfoNewSchema.getNS03();
		nS04 = aLAIndexInfoNewSchema.getNS04();
		nS05 = aLAIndexInfoNewSchema.getNS05();
		nS06 = aLAIndexInfoNewSchema.getNS06();
		nS07 = aLAIndexInfoNewSchema.getNS07();
		nS08 = aLAIndexInfoNewSchema.getNS08();
		nS09 = aLAIndexInfoNewSchema.getNS09();
		nS10 = aLAIndexInfoNewSchema.getNS10();
		iNT01 = aLAIndexInfoNewSchema.getINT01();
		iNT02 = aLAIndexInfoNewSchema.getINT02();
		iNT03 = aLAIndexInfoNewSchema.getINT03();
		iNT04 = aLAIndexInfoNewSchema.getINT04();
		iNT05 = aLAIndexInfoNewSchema.getINT05();
		iNT06 = aLAIndexInfoNewSchema.getINT06();
		iNT07 = aLAIndexInfoNewSchema.getINT07();
		iNT08 = aLAIndexInfoNewSchema.getINT08();
		iNT09 = aLAIndexInfoNewSchema.getINT09();
		iNT10 = aLAIndexInfoNewSchema.getINT10();
		iNT11 = aLAIndexInfoNewSchema.getINT11();
		iNT12 = aLAIndexInfoNewSchema.getINT12();
		iNT13 = aLAIndexInfoNewSchema.getINT13();
		iNT14 = aLAIndexInfoNewSchema.getINT14();
		iNT15 = aLAIndexInfoNewSchema.getINT15();
		iNT16 = aLAIndexInfoNewSchema.getINT16();
		iNT17 = aLAIndexInfoNewSchema.getINT17();
		iNT18 = aLAIndexInfoNewSchema.getINT18();
		iNT19 = aLAIndexInfoNewSchema.getINT19();
		iNT20 = aLAIndexInfoNewSchema.getINT20();
		iNT21 = aLAIndexInfoNewSchema.getINT21();
		iNT22 = aLAIndexInfoNewSchema.getINT22();
		iNT23 = aLAIndexInfoNewSchema.getINT23();
		iNT24 = aLAIndexInfoNewSchema.getINT24();
		iNT25 = aLAIndexInfoNewSchema.getINT25();
		v1 = aLAIndexInfoNewSchema.getV1();
		v2 = aLAIndexInfoNewSchema.getV2();
		v3 = aLAIndexInfoNewSchema.getV3();
		v4 = aLAIndexInfoNewSchema.getV4();
		v5 = aLAIndexInfoNewSchema.getV5();
		v6 = aLAIndexInfoNewSchema.getV6();
		v7 = aLAIndexInfoNewSchema.getV7();
		v8 = aLAIndexInfoNewSchema.getV8();
		v9 = aLAIndexInfoNewSchema.getV9();
		v10 = aLAIndexInfoNewSchema.getV10();
		v11 = aLAIndexInfoNewSchema.getV11();
		v12 = aLAIndexInfoNewSchema.getV12();
		v13 = aLAIndexInfoNewSchema.getV13();
		v14 = aLAIndexInfoNewSchema.getV14();
		v15 = aLAIndexInfoNewSchema.getV15();
		v16 = aLAIndexInfoNewSchema.getV16();
		v17 = aLAIndexInfoNewSchema.getV17();
		v18 = aLAIndexInfoNewSchema.getV18();
		v19 = aLAIndexInfoNewSchema.getV19();
		v20 = aLAIndexInfoNewSchema.getV20();
		vT1 = aLAIndexInfoNewSchema.getVT1();
		vT2 = aLAIndexInfoNewSchema.getVT2();
		vT3 = aLAIndexInfoNewSchema.getVT3();
		vT4 = aLAIndexInfoNewSchema.getVT4();
		vT5 = aLAIndexInfoNewSchema.getVT5();
		vT6 = aLAIndexInfoNewSchema.getVT6();
		vT7 = aLAIndexInfoNewSchema.getVT7();
		vT8 = aLAIndexInfoNewSchema.getVT8();
		vE1 = aLAIndexInfoNewSchema.getVE1();
		vE2 = aLAIndexInfoNewSchema.getVE2();
		vE3 = aLAIndexInfoNewSchema.getVE3();
		vE4 = aLAIndexInfoNewSchema.getVE4();
		vE5 = aLAIndexInfoNewSchema.getVE5();
		vE6 = aLAIndexInfoNewSchema.getVE6();
		vE7 = aLAIndexInfoNewSchema.getVE7();
		vE8 = aLAIndexInfoNewSchema.getVE8();
		vE9 = aLAIndexInfoNewSchema.getVE9();
		vE10 = aLAIndexInfoNewSchema.getVE10();
		d1 = fDate.getDate(aLAIndexInfoNewSchema.getD1());
		d2 = fDate.getDate(aLAIndexInfoNewSchema.getD2());
		d3 = fDate.getDate(aLAIndexInfoNewSchema.getD3());
		d4 = fDate.getDate(aLAIndexInfoNewSchema.getD4());
		d5 = fDate.getDate(aLAIndexInfoNewSchema.getD5());
		d6 = fDate.getDate(aLAIndexInfoNewSchema.getD6());
		d7 = fDate.getDate(aLAIndexInfoNewSchema.getD7());
		d8 = fDate.getDate(aLAIndexInfoNewSchema.getD8());
		d9 = fDate.getDate(aLAIndexInfoNewSchema.getD9());
		d10 = fDate.getDate(aLAIndexInfoNewSchema.getD10());
		state = aLAIndexInfoNewSchema.getState();
		operator = aLAIndexInfoNewSchema.getOperator();
		makeDate = fDate.getDate(aLAIndexInfoNewSchema.getMakeDate());
		makeTime = aLAIndexInfoNewSchema.getMakeTime();
		modifyDate = fDate.getDate(aLAIndexInfoNewSchema.getModifyDate());
		modifyTime = aLAIndexInfoNewSchema.getModifyTime();
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
			if (rs.getString("ManageCom") == null)
				manageCom = null;
			else
				manageCom = rs.getString("ManageCom").trim();
			if (rs.getString("AgentGroup") == null)
				agentGroup = null;
			else
				agentGroup = rs.getString("AgentGroup").trim();
			if (rs.getString("BranchAttr") == null)
				branchAttr = null;
			else
				branchAttr = rs.getString("BranchAttr").trim();
			if (rs.getString("AgentCode") == null)
				agentCode = null;
			else
				agentCode = rs.getString("AgentCode").trim();
			if (rs.getString("AgentGrade") == null)
				agentGrade = null;
			else
				agentGrade = rs.getString("AgentGrade").trim();
			if (rs.getString("AgentTitle") == null)
				agentTitle = null;
			else
				agentTitle = rs.getString("AgentTitle").trim();
			quaBgnMark = rs.getInt("QuaBgnMark");
			postMonths = rs.getInt("PostMonths");
			if (rs.getString("AssessMonth") == null)
				assessMonth = null;
			else
				assessMonth = rs.getString("AssessMonth").trim();
			if (rs.getString("AgentGrade1") == null)
				agentGrade1 = null;
			else
				agentGrade1 = rs.getString("AgentGrade1").trim();
			if (rs.getString("AgentTitle1") == null)
				agentTitle1 = null;
			else
				agentTitle1 = rs.getString("AgentTitle1").trim();
			if (rs.getString("AgentGrade2") == null)
				agentGrade2 = null;
			else
				agentGrade2 = rs.getString("AgentGrade2").trim();
			if (rs.getString("AgentTitle2") == null)
				agentTitle2 = null;
			else
				agentTitle2 = rs.getString("AgentTitle2").trim();
			if (rs.getString("AgentGrade3") == null)
				agentGrade3 = null;
			else
				agentGrade3 = rs.getString("AgentGrade3").trim();
			if (rs.getString("AgentTitle3") == null)
				agentTitle3 = null;
			else
				agentTitle3 = rs.getString("AgentTitle3").trim();
			startDate = rs.getDate("StartDate");
			startEnd = rs.getDate("StartEnd");
			startDate1 = rs.getDate("StartDate1");
			startEnd1 = rs.getDate("StartEnd1");
			startDate2 = rs.getDate("StartDate2");
			startEnd2 = rs.getDate("StartEnd2");
			startDate3 = rs.getDate("StartDate3");
			startEnd3 = rs.getDate("StartEnd3");
			startEnd4 = rs.getDate("StartEnd4");
			startDate4 = rs.getDate("StartDate4");
			serverMonths = rs.getInt("ServerMonths");
			nT01 = rs.getDouble("NT01");
			nT02 = rs.getDouble("NT02");
			nT03 = rs.getDouble("NT03");
			nT04 = rs.getDouble("NT04");
			nT05 = rs.getDouble("NT05");
			nT06 = rs.getDouble("NT06");
			nT07 = rs.getDouble("NT07");
			nT08 = rs.getDouble("NT08");
			nT09 = rs.getDouble("NT09");
			nT10 = rs.getDouble("NT10");
			nT11 = rs.getDouble("NT11");
			nT12 = rs.getDouble("NT12");
			nT13 = rs.getDouble("NT13");
			nT14 = rs.getDouble("NT14");
			nT15 = rs.getDouble("NT15");
			nT16 = rs.getDouble("NT16");
			nT17 = rs.getDouble("NT17");
			nT18 = rs.getDouble("NT18");
			nT19 = rs.getDouble("NT19");
			nT20 = rs.getDouble("NT20");
			nT21 = rs.getDouble("NT21");
			nT22 = rs.getDouble("NT22");
			nT23 = rs.getDouble("NT23");
			nT24 = rs.getDouble("NT24");
			nT25 = rs.getDouble("NT25");
			nT26 = rs.getDouble("NT26");
			nT27 = rs.getDouble("NT27");
			nT28 = rs.getDouble("NT28");
			nT29 = rs.getDouble("NT29");
			nT30 = rs.getDouble("NT30");
			nT31 = rs.getDouble("NT31");
			nT32 = rs.getDouble("NT32");
			nT33 = rs.getDouble("NT33");
			nT34 = rs.getDouble("NT34");
			nT35 = rs.getDouble("NT35");
			nT36 = rs.getDouble("NT36");
			nT37 = rs.getDouble("NT37");
			nT38 = rs.getDouble("NT38");
			nT39 = rs.getDouble("NT39");
			nT40 = rs.getDouble("NT40");
			nT41 = rs.getDouble("NT41");
			nT42 = rs.getDouble("NT42");
			nT43 = rs.getDouble("NT43");
			nT44 = rs.getDouble("NT44");
			nT45 = rs.getDouble("NT45");
			nT46 = rs.getDouble("NT46");
			nT47 = rs.getDouble("NT47");
			nT48 = rs.getDouble("NT48");
			nT49 = rs.getDouble("NT49");
			nT50 = rs.getDouble("NT50");
			nT51 = rs.getDouble("NT51");
			nT52 = rs.getDouble("NT52");
			nT53 = rs.getDouble("NT53");
			nT54 = rs.getDouble("NT54");
			nT55 = rs.getDouble("NT55");
			nT56 = rs.getDouble("NT56");
			nT57 = rs.getDouble("NT57");
			nT58 = rs.getDouble("NT58");
			nT59 = rs.getDouble("NT59");
			nT60 = rs.getDouble("NT60");
			nT61 = rs.getDouble("NT61");
			nT62 = rs.getDouble("NT62");
			nT63 = rs.getDouble("NT63");
			nT64 = rs.getDouble("NT64");
			nT65 = rs.getDouble("NT65");
			nT66 = rs.getDouble("NT66");
			nT67 = rs.getDouble("NT67");
			nT68 = rs.getDouble("NT68");
			nT69 = rs.getDouble("NT69");
			nT70 = rs.getDouble("NT70");
			nT71 = rs.getDouble("NT71");
			nT72 = rs.getDouble("NT72");
			nT73 = rs.getDouble("NT73");
			nT74 = rs.getDouble("NT74");
			nT75 = rs.getDouble("NT75");
			nT76 = rs.getDouble("NT76");
			nT77 = rs.getDouble("NT77");
			nT78 = rs.getDouble("NT78");
			nT79 = rs.getDouble("NT79");
			nT80 = rs.getDouble("NT80");
			nF01 = rs.getDouble("NF01");
			nF02 = rs.getDouble("NF02");
			nF03 = rs.getDouble("NF03");
			nF04 = rs.getDouble("NF04");
			nF05 = rs.getDouble("NF05");
			nF06 = rs.getDouble("NF06");
			nF07 = rs.getDouble("NF07");
			nF08 = rs.getDouble("NF08");
			nF09 = rs.getDouble("NF09");
			nF10 = rs.getDouble("NF10");
			nS01 = rs.getDouble("NS01");
			nS02 = rs.getDouble("NS02");
			nS03 = rs.getDouble("NS03");
			nS04 = rs.getDouble("NS04");
			nS05 = rs.getDouble("NS05");
			nS06 = rs.getDouble("NS06");
			nS07 = rs.getDouble("NS07");
			nS08 = rs.getDouble("NS08");
			nS09 = rs.getDouble("NS09");
			nS10 = rs.getDouble("NS10");
			iNT01 = rs.getInt("INT01");
			iNT02 = rs.getInt("INT02");
			iNT03 = rs.getInt("INT03");
			iNT04 = rs.getInt("INT04");
			iNT05 = rs.getInt("INT05");
			iNT06 = rs.getInt("INT06");
			iNT07 = rs.getInt("INT07");
			iNT08 = rs.getInt("INT08");
			iNT09 = rs.getInt("INT09");
			iNT10 = rs.getInt("INT10");
			iNT11 = rs.getInt("INT11");
			iNT12 = rs.getInt("INT12");
			iNT13 = rs.getInt("INT13");
			iNT14 = rs.getInt("INT14");
			iNT15 = rs.getInt("INT15");
			iNT16 = rs.getInt("INT16");
			iNT17 = rs.getInt("INT17");
			iNT18 = rs.getInt("INT18");
			iNT19 = rs.getInt("INT19");
			iNT20 = rs.getInt("INT20");
			iNT21 = rs.getInt("INT21");
			iNT22 = rs.getInt("INT22");
			iNT23 = rs.getInt("INT23");
			iNT24 = rs.getInt("INT24");
			iNT25 = rs.getInt("INT25");
			if (rs.getString("V1") == null)
				v1 = null;
			else
				v1 = rs.getString("V1").trim();
			if (rs.getString("V2") == null)
				v2 = null;
			else
				v2 = rs.getString("V2").trim();
			if (rs.getString("V3") == null)
				v3 = null;
			else
				v3 = rs.getString("V3").trim();
			if (rs.getString("V4") == null)
				v4 = null;
			else
				v4 = rs.getString("V4").trim();
			if (rs.getString("V5") == null)
				v5 = null;
			else
				v5 = rs.getString("V5").trim();
			if (rs.getString("V6") == null)
				v6 = null;
			else
				v6 = rs.getString("V6").trim();
			if (rs.getString("V7") == null)
				v7 = null;
			else
				v7 = rs.getString("V7").trim();
			if (rs.getString("V8") == null)
				v8 = null;
			else
				v8 = rs.getString("V8").trim();
			if (rs.getString("V9") == null)
				v9 = null;
			else
				v9 = rs.getString("V9").trim();
			if (rs.getString("V10") == null)
				v10 = null;
			else
				v10 = rs.getString("V10").trim();
			if (rs.getString("V11") == null)
				v11 = null;
			else
				v11 = rs.getString("V11").trim();
			if (rs.getString("V12") == null)
				v12 = null;
			else
				v12 = rs.getString("V12").trim();
			if (rs.getString("V13") == null)
				v13 = null;
			else
				v13 = rs.getString("V13").trim();
			if (rs.getString("V14") == null)
				v14 = null;
			else
				v14 = rs.getString("V14").trim();
			if (rs.getString("V15") == null)
				v15 = null;
			else
				v15 = rs.getString("V15").trim();
			if (rs.getString("V16") == null)
				v16 = null;
			else
				v16 = rs.getString("V16").trim();
			if (rs.getString("V17") == null)
				v17 = null;
			else
				v17 = rs.getString("V17").trim();
			if (rs.getString("V18") == null)
				v18 = null;
			else
				v18 = rs.getString("V18").trim();
			if (rs.getString("V19") == null)
				v19 = null;
			else
				v19 = rs.getString("V19").trim();
			if (rs.getString("V20") == null)
				v20 = null;
			else
				v20 = rs.getString("V20").trim();
			if (rs.getString("VT1") == null)
				vT1 = null;
			else
				vT1 = rs.getString("VT1").trim();
			if (rs.getString("VT2") == null)
				vT2 = null;
			else
				vT2 = rs.getString("VT2").trim();
			if (rs.getString("VT3") == null)
				vT3 = null;
			else
				vT3 = rs.getString("VT3").trim();
			if (rs.getString("VT4") == null)
				vT4 = null;
			else
				vT4 = rs.getString("VT4").trim();
			if (rs.getString("VT5") == null)
				vT5 = null;
			else
				vT5 = rs.getString("VT5").trim();
			if (rs.getString("VT6") == null)
				vT6 = null;
			else
				vT6 = rs.getString("VT6").trim();
			if (rs.getString("VT7") == null)
				vT7 = null;
			else
				vT7 = rs.getString("VT7").trim();
			if (rs.getString("VT8") == null)
				vT8 = null;
			else
				vT8 = rs.getString("VT8").trim();
			if (rs.getString("VE1") == null)
				vE1 = null;
			else
				vE1 = rs.getString("VE1").trim();
			if (rs.getString("VE2") == null)
				vE2 = null;
			else
				vE2 = rs.getString("VE2").trim();
			if (rs.getString("VE3") == null)
				vE3 = null;
			else
				vE3 = rs.getString("VE3").trim();
			if (rs.getString("VE4") == null)
				vE4 = null;
			else
				vE4 = rs.getString("VE4").trim();
			if (rs.getString("VE5") == null)
				vE5 = null;
			else
				vE5 = rs.getString("VE5").trim();
			if (rs.getString("VE6") == null)
				vE6 = null;
			else
				vE6 = rs.getString("VE6").trim();
			if (rs.getString("VE7") == null)
				vE7 = null;
			else
				vE7 = rs.getString("VE7").trim();
			if (rs.getString("VE8") == null)
				vE8 = null;
			else
				vE8 = rs.getString("VE8").trim();
			if (rs.getString("VE9") == null)
				vE9 = null;
			else
				vE9 = rs.getString("VE9").trim();
			if (rs.getString("VE10") == null)
				vE10 = null;
			else
				vE10 = rs.getString("VE10").trim();
			d1 = rs.getDate("D1");
			d2 = rs.getDate("D2");
			d3 = rs.getDate("D3");
			d4 = rs.getDate("D4");
			d5 = rs.getDate("D5");
			d6 = rs.getDate("D6");
			d7 = rs.getDate("D7");
			d8 = rs.getDate("D8");
			d9 = rs.getDate("D9");
			d10 = rs.getDate("D10");
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
		}
		catch (SQLException sqle)
		{
			System.out.println("数据库中的LAIndexInfoNew表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LAIndexInfoNewSchema getSchema()
	{
		LAIndexInfoNewSchema aLAIndexInfoNewSchema = new LAIndexInfoNewSchema();
		aLAIndexInfoNewSchema.setSchema(this);
		return aLAIndexInfoNewSchema;
	}

	public LAIndexInfoNewDB getDB()
	{
		LAIndexInfoNewDB aDBOper = new LAIndexInfoNewDB();
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
		strReturn.append(StrTool.cTrim(manageCom));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGroup));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(branchAttr));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentCode));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentTitle));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(quaBgnMark));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(postMonths));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(assessMonth));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentTitle1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentTitle2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentGrade3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(agentTitle3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startEnd)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate1)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startEnd1)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startEnd2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate3)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startEnd3)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startEnd4)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(startDate4)));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(serverMonths));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT02));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT03));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT04));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT05));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT06));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT07));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT08));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT09));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT10));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT11));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT12));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT13));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT14));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT15));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT16));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT17));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT18));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT19));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT20));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT21));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT22));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT23));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT24));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT25));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT26));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT27));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT28));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT29));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT30));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT31));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT32));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT33));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT34));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT35));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT36));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT37));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT38));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT39));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT40));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT41));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT42));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT43));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT44));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT45));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT46));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT47));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT48));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT49));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT50));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT51));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT52));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT53));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT54));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT55));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT56));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT57));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT58));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT59));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT60));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT61));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT62));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT63));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT64));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT65));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT66));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT67));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT68));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT69));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT70));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT71));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT72));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT73));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT74));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT75));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT76));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT77));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT78));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT79));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nT80));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF02));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF03));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF04));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF05));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF06));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF07));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF08));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF09));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nF10));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS02));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS03));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS04));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS05));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS06));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS07));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS08));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS09));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(nS10));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT01));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT02));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT03));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT04));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT05));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT06));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT07));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT08));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT09));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT10));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT11));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT12));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT13));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT14));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT15));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT16));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT17));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT18));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT19));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT20));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT21));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT22));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT23));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT24));
		strReturn.append("|");
		strReturn.append(ChgData.chgData(iNT25));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v5));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v6));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v7));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v8));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v9));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v10));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v11));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v12));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v13));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v14));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v15));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v16));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v17));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v18));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v19));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(v20));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT5));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT6));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT7));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vT8));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE1));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE2));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE3));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE4));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE5));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE6));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE7));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE8));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE9));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(vE10));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d1)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d2)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d3)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d4)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d5)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d6)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d7)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d8)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d9)));
		strReturn.append("|");
		strReturn.append(StrTool.cTrim(fDate.getString(d10)));
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
		return strReturn.toString();
	}

	public boolean decode(String strMessage)
	{
		try
		{
			indexCalNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			indexType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			agentGroup = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			branchAttr = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			agentCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			agentGrade = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			agentTitle = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			quaBgnMark = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|")))).intValue();
			postMonths = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|")))).intValue();
			assessMonth = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			agentGrade1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			agentTitle1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			agentGrade2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			agentTitle2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			agentGrade3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			agentTitle3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			startDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|"));
			startEnd = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|"));
			startDate1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|"));
			startEnd1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|"));
			startDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|"));
			startEnd2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|"));
			startDate3 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|"));
			startEnd3 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|"));
			startEnd4 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|"));
			startDate4 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
			serverMonths = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 28, "|")))).intValue();
			nT01 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 29, "|")))).doubleValue();
			nT02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 30, "|")))).doubleValue();
			nT03 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 31, "|")))).doubleValue();
			nT04 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 32, "|")))).doubleValue();
			nT05 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 33, "|")))).doubleValue();
			nT06 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 34, "|")))).doubleValue();
			nT07 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 35, "|")))).doubleValue();
			nT08 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 36, "|")))).doubleValue();
			nT09 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 37, "|")))).doubleValue();
			nT10 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 38, "|")))).doubleValue();
			nT11 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 39, "|")))).doubleValue();
			nT12 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 40, "|")))).doubleValue();
			nT13 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 41, "|")))).doubleValue();
			nT14 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 42, "|")))).doubleValue();
			nT15 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 43, "|")))).doubleValue();
			nT16 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 44, "|")))).doubleValue();
			nT17 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 45, "|")))).doubleValue();
			nT18 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 46, "|")))).doubleValue();
			nT19 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 47, "|")))).doubleValue();
			nT20 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 48, "|")))).doubleValue();
			nT21 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 49, "|")))).doubleValue();
			nT22 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 50, "|")))).doubleValue();
			nT23 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 51, "|")))).doubleValue();
			nT24 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 52, "|")))).doubleValue();
			nT25 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 53, "|")))).doubleValue();
			nT26 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 54, "|")))).doubleValue();
			nT27 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 55, "|")))).doubleValue();
			nT28 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 56, "|")))).doubleValue();
			nT29 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 57, "|")))).doubleValue();
			nT30 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 58, "|")))).doubleValue();
			nT31 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 59, "|")))).doubleValue();
			nT32 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 60, "|")))).doubleValue();
			nT33 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 61, "|")))).doubleValue();
			nT34 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 62, "|")))).doubleValue();
			nT35 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 63, "|")))).doubleValue();
			nT36 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 64, "|")))).doubleValue();
			nT37 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 65, "|")))).doubleValue();
			nT38 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 66, "|")))).doubleValue();
			nT39 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 67, "|")))).doubleValue();
			nT40 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 68, "|")))).doubleValue();
			nT41 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 69, "|")))).doubleValue();
			nT42 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 70, "|")))).doubleValue();
			nT43 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 71, "|")))).doubleValue();
			nT44 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 72, "|")))).doubleValue();
			nT45 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 73, "|")))).doubleValue();
			nT46 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 74, "|")))).doubleValue();
			nT47 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 75, "|")))).doubleValue();
			nT48 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 76, "|")))).doubleValue();
			nT49 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 77, "|")))).doubleValue();
			nT50 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 78, "|")))).doubleValue();
			nT51 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 79, "|")))).doubleValue();
			nT52 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 80, "|")))).doubleValue();
			nT53 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 81, "|")))).doubleValue();
			nT54 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 82, "|")))).doubleValue();
			nT55 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 83, "|")))).doubleValue();
			nT56 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 84, "|")))).doubleValue();
			nT57 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 85, "|")))).doubleValue();
			nT58 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 86, "|")))).doubleValue();
			nT59 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 87, "|")))).doubleValue();
			nT60 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 88, "|")))).doubleValue();
			nT61 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 89, "|")))).doubleValue();
			nT62 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 90, "|")))).doubleValue();
			nT63 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 91, "|")))).doubleValue();
			nT64 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 92, "|")))).doubleValue();
			nT65 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 93, "|")))).doubleValue();
			nT66 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 94, "|")))).doubleValue();
			nT67 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 95, "|")))).doubleValue();
			nT68 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 96, "|")))).doubleValue();
			nT69 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 97, "|")))).doubleValue();
			nT70 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 98, "|")))).doubleValue();
			nT71 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 99, "|")))).doubleValue();
			nT72 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 100, "|")))).doubleValue();
			nT73 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 101, "|")))).doubleValue();
			nT74 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 102, "|")))).doubleValue();
			nT75 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 103, "|")))).doubleValue();
			nT76 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 104, "|")))).doubleValue();
			nT77 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 105, "|")))).doubleValue();
			nT78 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 106, "|")))).doubleValue();
			nT79 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 107, "|")))).doubleValue();
			nT80 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 108, "|")))).doubleValue();
			nF01 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 109, "|")))).doubleValue();
			nF02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 110, "|")))).doubleValue();
			nF03 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 111, "|")))).doubleValue();
			nF04 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 112, "|")))).doubleValue();
			nF05 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 113, "|")))).doubleValue();
			nF06 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 114, "|")))).doubleValue();
			nF07 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 115, "|")))).doubleValue();
			nF08 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 116, "|")))).doubleValue();
			nF09 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 117, "|")))).doubleValue();
			nF10 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 118, "|")))).doubleValue();
			nS01 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 119, "|")))).doubleValue();
			nS02 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 120, "|")))).doubleValue();
			nS03 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 121, "|")))).doubleValue();
			nS04 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 122, "|")))).doubleValue();
			nS05 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 123, "|")))).doubleValue();
			nS06 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 124, "|")))).doubleValue();
			nS07 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 125, "|")))).doubleValue();
			nS08 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 126, "|")))).doubleValue();
			nS09 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 127, "|")))).doubleValue();
			nS10 = (new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 128, "|")))).doubleValue();
			iNT01 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 129, "|")))).intValue();
			iNT02 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 130, "|")))).intValue();
			iNT03 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 131, "|")))).intValue();
			iNT04 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 132, "|")))).intValue();
			iNT05 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 133, "|")))).intValue();
			iNT06 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 134, "|")))).intValue();
			iNT07 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 135, "|")))).intValue();
			iNT08 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 136, "|")))).intValue();
			iNT09 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 137, "|")))).intValue();
			iNT10 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 138, "|")))).intValue();
			iNT11 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 139, "|")))).intValue();
			iNT12 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 140, "|")))).intValue();
			iNT13 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 141, "|")))).intValue();
			iNT14 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 142, "|")))).intValue();
			iNT15 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 143, "|")))).intValue();
			iNT16 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 144, "|")))).intValue();
			iNT17 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 145, "|")))).intValue();
			iNT18 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 146, "|")))).intValue();
			iNT19 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 147, "|")))).intValue();
			iNT20 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 148, "|")))).intValue();
			iNT21 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 149, "|")))).intValue();
			iNT22 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 150, "|")))).intValue();
			iNT23 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 151, "|")))).intValue();
			iNT24 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 152, "|")))).intValue();
			iNT25 = (new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 153, "|")))).intValue();
			v1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 154, "|");
			v2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 155, "|");
			v3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 156, "|");
			v4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 157, "|");
			v5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 158, "|");
			v6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 159, "|");
			v7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 160, "|");
			v8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 161, "|");
			v9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 162, "|");
			v10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 163, "|");
			v11 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 164, "|");
			v12 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 165, "|");
			v13 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 166, "|");
			v14 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 167, "|");
			v15 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 168, "|");
			v16 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 169, "|");
			v17 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 170, "|");
			v18 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 171, "|");
			v19 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 172, "|");
			v20 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 173, "|");
			vT1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 174, "|");
			vT2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 175, "|");
			vT3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 176, "|");
			vT4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 177, "|");
			vT5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 178, "|");
			vT6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 179, "|");
			vT7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 180, "|");
			vT8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 181, "|");
			vE1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 182, "|");
			vE2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 183, "|");
			vE3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 184, "|");
			vE4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 185, "|");
			vE5 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 186, "|");
			vE6 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 187, "|");
			vE7 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 188, "|");
			vE8 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 189, "|");
			vE9 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 190, "|");
			vE10 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 191, "|");
			d1 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 192, "|"));
			d2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 193, "|"));
			d3 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 194, "|"));
			d4 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 195, "|"));
			d5 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 196, "|"));
			d6 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 197, "|"));
			d7 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 198, "|"));
			d8 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 199, "|"));
			d9 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 200, "|"));
			d10 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 201, "|"));
			state = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 202, "|");
			operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 203, "|");
			makeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 204, "|"));
			makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 205, "|");
			modifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 206, "|"));
			modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 207, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LAIndexInfoNewSchema";
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
		if (FCode.equalsIgnoreCase("manageCom"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(manageCom));
		if (FCode.equalsIgnoreCase("agentGroup"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGroup));
		if (FCode.equalsIgnoreCase("branchAttr"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(branchAttr));
		if (FCode.equalsIgnoreCase("agentCode"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentCode));
		if (FCode.equalsIgnoreCase("agentGrade"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade));
		if (FCode.equalsIgnoreCase("agentTitle"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentTitle));
		if (FCode.equalsIgnoreCase("quaBgnMark"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(quaBgnMark));
		if (FCode.equalsIgnoreCase("postMonths"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(postMonths));
		if (FCode.equalsIgnoreCase("assessMonth"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(assessMonth));
		if (FCode.equalsIgnoreCase("agentGrade1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade1));
		if (FCode.equalsIgnoreCase("agentTitle1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentTitle1));
		if (FCode.equalsIgnoreCase("agentGrade2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade2));
		if (FCode.equalsIgnoreCase("agentTitle2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentTitle2));
		if (FCode.equalsIgnoreCase("agentGrade3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentGrade3));
		if (FCode.equalsIgnoreCase("agentTitle3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(agentTitle3));
		if (FCode.equalsIgnoreCase("startDate"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
		if (FCode.equalsIgnoreCase("startEnd"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
		if (FCode.equalsIgnoreCase("startDate1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate1()));
		if (FCode.equalsIgnoreCase("startEnd1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd1()));
		if (FCode.equalsIgnoreCase("startDate2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate2()));
		if (FCode.equalsIgnoreCase("startEnd2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd2()));
		if (FCode.equalsIgnoreCase("startDate3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate3()));
		if (FCode.equalsIgnoreCase("startEnd3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd3()));
		if (FCode.equalsIgnoreCase("startEnd4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartEnd4()));
		if (FCode.equalsIgnoreCase("startDate4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate4()));
		if (FCode.equalsIgnoreCase("serverMonths"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(serverMonths));
		if (FCode.equalsIgnoreCase("nT01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT01));
		if (FCode.equalsIgnoreCase("nT02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT02));
		if (FCode.equalsIgnoreCase("nT03"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT03));
		if (FCode.equalsIgnoreCase("nT04"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT04));
		if (FCode.equalsIgnoreCase("nT05"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT05));
		if (FCode.equalsIgnoreCase("nT06"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT06));
		if (FCode.equalsIgnoreCase("nT07"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT07));
		if (FCode.equalsIgnoreCase("nT08"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT08));
		if (FCode.equalsIgnoreCase("nT09"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT09));
		if (FCode.equalsIgnoreCase("nT10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT10));
		if (FCode.equalsIgnoreCase("nT11"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT11));
		if (FCode.equalsIgnoreCase("nT12"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT12));
		if (FCode.equalsIgnoreCase("nT13"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT13));
		if (FCode.equalsIgnoreCase("nT14"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT14));
		if (FCode.equalsIgnoreCase("nT15"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT15));
		if (FCode.equalsIgnoreCase("nT16"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT16));
		if (FCode.equalsIgnoreCase("nT17"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT17));
		if (FCode.equalsIgnoreCase("nT18"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT18));
		if (FCode.equalsIgnoreCase("nT19"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT19));
		if (FCode.equalsIgnoreCase("nT20"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT20));
		if (FCode.equalsIgnoreCase("nT21"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT21));
		if (FCode.equalsIgnoreCase("nT22"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT22));
		if (FCode.equalsIgnoreCase("nT23"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT23));
		if (FCode.equalsIgnoreCase("nT24"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT24));
		if (FCode.equalsIgnoreCase("nT25"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT25));
		if (FCode.equalsIgnoreCase("nT26"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT26));
		if (FCode.equalsIgnoreCase("nT27"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT27));
		if (FCode.equalsIgnoreCase("nT28"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT28));
		if (FCode.equalsIgnoreCase("nT29"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT29));
		if (FCode.equalsIgnoreCase("nT30"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT30));
		if (FCode.equalsIgnoreCase("nT31"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT31));
		if (FCode.equalsIgnoreCase("nT32"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT32));
		if (FCode.equalsIgnoreCase("nT33"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT33));
		if (FCode.equalsIgnoreCase("nT34"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT34));
		if (FCode.equalsIgnoreCase("nT35"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT35));
		if (FCode.equalsIgnoreCase("nT36"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT36));
		if (FCode.equalsIgnoreCase("nT37"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT37));
		if (FCode.equalsIgnoreCase("nT38"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT38));
		if (FCode.equalsIgnoreCase("nT39"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT39));
		if (FCode.equalsIgnoreCase("nT40"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT40));
		if (FCode.equalsIgnoreCase("nT41"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT41));
		if (FCode.equalsIgnoreCase("nT42"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT42));
		if (FCode.equalsIgnoreCase("nT43"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT43));
		if (FCode.equalsIgnoreCase("nT44"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT44));
		if (FCode.equalsIgnoreCase("nT45"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT45));
		if (FCode.equalsIgnoreCase("nT46"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT46));
		if (FCode.equalsIgnoreCase("nT47"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT47));
		if (FCode.equalsIgnoreCase("nT48"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT48));
		if (FCode.equalsIgnoreCase("nT49"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT49));
		if (FCode.equalsIgnoreCase("nT50"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT50));
		if (FCode.equalsIgnoreCase("nT51"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT51));
		if (FCode.equalsIgnoreCase("nT52"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT52));
		if (FCode.equalsIgnoreCase("nT53"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT53));
		if (FCode.equalsIgnoreCase("nT54"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT54));
		if (FCode.equalsIgnoreCase("nT55"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT55));
		if (FCode.equalsIgnoreCase("nT56"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT56));
		if (FCode.equalsIgnoreCase("nT57"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT57));
		if (FCode.equalsIgnoreCase("nT58"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT58));
		if (FCode.equalsIgnoreCase("nT59"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT59));
		if (FCode.equalsIgnoreCase("nT60"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT60));
		if (FCode.equalsIgnoreCase("nT61"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT61));
		if (FCode.equalsIgnoreCase("nT62"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT62));
		if (FCode.equalsIgnoreCase("nT63"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT63));
		if (FCode.equalsIgnoreCase("nT64"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT64));
		if (FCode.equalsIgnoreCase("nT65"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT65));
		if (FCode.equalsIgnoreCase("nT66"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT66));
		if (FCode.equalsIgnoreCase("nT67"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT67));
		if (FCode.equalsIgnoreCase("nT68"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT68));
		if (FCode.equalsIgnoreCase("nT69"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT69));
		if (FCode.equalsIgnoreCase("nT70"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT70));
		if (FCode.equalsIgnoreCase("nT71"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT71));
		if (FCode.equalsIgnoreCase("nT72"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT72));
		if (FCode.equalsIgnoreCase("nT73"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT73));
		if (FCode.equalsIgnoreCase("nT74"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT74));
		if (FCode.equalsIgnoreCase("nT75"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT75));
		if (FCode.equalsIgnoreCase("nT76"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT76));
		if (FCode.equalsIgnoreCase("nT77"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT77));
		if (FCode.equalsIgnoreCase("nT78"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT78));
		if (FCode.equalsIgnoreCase("nT79"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT79));
		if (FCode.equalsIgnoreCase("nT80"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nT80));
		if (FCode.equalsIgnoreCase("nF01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF01));
		if (FCode.equalsIgnoreCase("nF02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF02));
		if (FCode.equalsIgnoreCase("nF03"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF03));
		if (FCode.equalsIgnoreCase("nF04"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF04));
		if (FCode.equalsIgnoreCase("nF05"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF05));
		if (FCode.equalsIgnoreCase("nF06"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF06));
		if (FCode.equalsIgnoreCase("nF07"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF07));
		if (FCode.equalsIgnoreCase("nF08"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF08));
		if (FCode.equalsIgnoreCase("nF09"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF09));
		if (FCode.equalsIgnoreCase("nF10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nF10));
		if (FCode.equalsIgnoreCase("nS01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS01));
		if (FCode.equalsIgnoreCase("nS02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS02));
		if (FCode.equalsIgnoreCase("nS03"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS03));
		if (FCode.equalsIgnoreCase("nS04"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS04));
		if (FCode.equalsIgnoreCase("nS05"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS05));
		if (FCode.equalsIgnoreCase("nS06"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS06));
		if (FCode.equalsIgnoreCase("nS07"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS07));
		if (FCode.equalsIgnoreCase("nS08"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS08));
		if (FCode.equalsIgnoreCase("nS09"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS09));
		if (FCode.equalsIgnoreCase("nS10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(nS10));
		if (FCode.equalsIgnoreCase("iNT01"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT01));
		if (FCode.equalsIgnoreCase("iNT02"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT02));
		if (FCode.equalsIgnoreCase("iNT03"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT03));
		if (FCode.equalsIgnoreCase("iNT04"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT04));
		if (FCode.equalsIgnoreCase("iNT05"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT05));
		if (FCode.equalsIgnoreCase("iNT06"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT06));
		if (FCode.equalsIgnoreCase("iNT07"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT07));
		if (FCode.equalsIgnoreCase("iNT08"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT08));
		if (FCode.equalsIgnoreCase("iNT09"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT09));
		if (FCode.equalsIgnoreCase("iNT10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT10));
		if (FCode.equalsIgnoreCase("iNT11"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT11));
		if (FCode.equalsIgnoreCase("iNT12"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT12));
		if (FCode.equalsIgnoreCase("iNT13"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT13));
		if (FCode.equalsIgnoreCase("iNT14"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT14));
		if (FCode.equalsIgnoreCase("iNT15"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT15));
		if (FCode.equalsIgnoreCase("iNT16"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT16));
		if (FCode.equalsIgnoreCase("iNT17"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT17));
		if (FCode.equalsIgnoreCase("iNT18"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT18));
		if (FCode.equalsIgnoreCase("iNT19"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT19));
		if (FCode.equalsIgnoreCase("iNT20"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT20));
		if (FCode.equalsIgnoreCase("iNT21"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT21));
		if (FCode.equalsIgnoreCase("iNT22"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT22));
		if (FCode.equalsIgnoreCase("iNT23"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT23));
		if (FCode.equalsIgnoreCase("iNT24"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT24));
		if (FCode.equalsIgnoreCase("iNT25"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(iNT25));
		if (FCode.equalsIgnoreCase("v1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v1));
		if (FCode.equalsIgnoreCase("v2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v2));
		if (FCode.equalsIgnoreCase("v3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v3));
		if (FCode.equalsIgnoreCase("v4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v4));
		if (FCode.equalsIgnoreCase("v5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v5));
		if (FCode.equalsIgnoreCase("v6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v6));
		if (FCode.equalsIgnoreCase("v7"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v7));
		if (FCode.equalsIgnoreCase("v8"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v8));
		if (FCode.equalsIgnoreCase("v9"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v9));
		if (FCode.equalsIgnoreCase("v10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v10));
		if (FCode.equalsIgnoreCase("v11"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v11));
		if (FCode.equalsIgnoreCase("v12"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v12));
		if (FCode.equalsIgnoreCase("v13"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v13));
		if (FCode.equalsIgnoreCase("v14"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v14));
		if (FCode.equalsIgnoreCase("v15"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v15));
		if (FCode.equalsIgnoreCase("v16"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v16));
		if (FCode.equalsIgnoreCase("v17"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v17));
		if (FCode.equalsIgnoreCase("v18"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v18));
		if (FCode.equalsIgnoreCase("v19"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v19));
		if (FCode.equalsIgnoreCase("v20"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(v20));
		if (FCode.equalsIgnoreCase("vT1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT1));
		if (FCode.equalsIgnoreCase("vT2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT2));
		if (FCode.equalsIgnoreCase("vT3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT3));
		if (FCode.equalsIgnoreCase("vT4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT4));
		if (FCode.equalsIgnoreCase("vT5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT5));
		if (FCode.equalsIgnoreCase("vT6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT6));
		if (FCode.equalsIgnoreCase("vT7"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT7));
		if (FCode.equalsIgnoreCase("vT8"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vT8));
		if (FCode.equalsIgnoreCase("vE1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE1));
		if (FCode.equalsIgnoreCase("vE2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE2));
		if (FCode.equalsIgnoreCase("vE3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE3));
		if (FCode.equalsIgnoreCase("vE4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE4));
		if (FCode.equalsIgnoreCase("vE5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE5));
		if (FCode.equalsIgnoreCase("vE6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE6));
		if (FCode.equalsIgnoreCase("vE7"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE7));
		if (FCode.equalsIgnoreCase("vE8"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE8));
		if (FCode.equalsIgnoreCase("vE9"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE9));
		if (FCode.equalsIgnoreCase("vE10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(vE10));
		if (FCode.equalsIgnoreCase("d1"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD1()));
		if (FCode.equalsIgnoreCase("d2"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD2()));
		if (FCode.equalsIgnoreCase("d3"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD3()));
		if (FCode.equalsIgnoreCase("d4"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD4()));
		if (FCode.equalsIgnoreCase("d5"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD5()));
		if (FCode.equalsIgnoreCase("d6"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD6()));
		if (FCode.equalsIgnoreCase("d7"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD7()));
		if (FCode.equalsIgnoreCase("d8"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD8()));
		if (FCode.equalsIgnoreCase("d9"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD9()));
		if (FCode.equalsIgnoreCase("d10"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(getD10()));
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
			strFieldValue = StrTool.GBKToUnicode(manageCom);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(agentGroup);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(branchAttr);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(agentCode);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(agentGrade);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(agentTitle);
			break;

		case 8: // '\b'
			strFieldValue = String.valueOf(quaBgnMark);
			break;

		case 9: // '\t'
			strFieldValue = String.valueOf(postMonths);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(assessMonth);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(agentGrade1);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(agentTitle1);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(agentGrade2);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(agentTitle2);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(agentGrade3);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(agentTitle3);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd()));
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate1()));
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd1()));
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate2()));
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd2()));
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate3()));
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd3()));
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartEnd4()));
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate4()));
			break;

		case 27: // '\033'
			strFieldValue = String.valueOf(serverMonths);
			break;

		case 28: // '\034'
			strFieldValue = String.valueOf(nT01);
			break;

		case 29: // '\035'
			strFieldValue = String.valueOf(nT02);
			break;

		case 30: // '\036'
			strFieldValue = String.valueOf(nT03);
			break;

		case 31: // '\037'
			strFieldValue = String.valueOf(nT04);
			break;

		case 32: // ' '
			strFieldValue = String.valueOf(nT05);
			break;

		case 33: // '!'
			strFieldValue = String.valueOf(nT06);
			break;

		case 34: // '"'
			strFieldValue = String.valueOf(nT07);
			break;

		case 35: // '#'
			strFieldValue = String.valueOf(nT08);
			break;

		case 36: // '$'
			strFieldValue = String.valueOf(nT09);
			break;

		case 37: // '%'
			strFieldValue = String.valueOf(nT10);
			break;

		case 38: // '&'
			strFieldValue = String.valueOf(nT11);
			break;

		case 39: // '\''
			strFieldValue = String.valueOf(nT12);
			break;

		case 40: // '('
			strFieldValue = String.valueOf(nT13);
			break;

		case 41: // ')'
			strFieldValue = String.valueOf(nT14);
			break;

		case 42: // '*'
			strFieldValue = String.valueOf(nT15);
			break;

		case 43: // '+'
			strFieldValue = String.valueOf(nT16);
			break;

		case 44: // ','
			strFieldValue = String.valueOf(nT17);
			break;

		case 45: // '-'
			strFieldValue = String.valueOf(nT18);
			break;

		case 46: // '.'
			strFieldValue = String.valueOf(nT19);
			break;

		case 47: // '/'
			strFieldValue = String.valueOf(nT20);
			break;

		case 48: // '0'
			strFieldValue = String.valueOf(nT21);
			break;

		case 49: // '1'
			strFieldValue = String.valueOf(nT22);
			break;

		case 50: // '2'
			strFieldValue = String.valueOf(nT23);
			break;

		case 51: // '3'
			strFieldValue = String.valueOf(nT24);
			break;

		case 52: // '4'
			strFieldValue = String.valueOf(nT25);
			break;

		case 53: // '5'
			strFieldValue = String.valueOf(nT26);
			break;

		case 54: // '6'
			strFieldValue = String.valueOf(nT27);
			break;

		case 55: // '7'
			strFieldValue = String.valueOf(nT28);
			break;

		case 56: // '8'
			strFieldValue = String.valueOf(nT29);
			break;

		case 57: // '9'
			strFieldValue = String.valueOf(nT30);
			break;

		case 58: // ':'
			strFieldValue = String.valueOf(nT31);
			break;

		case 59: // ';'
			strFieldValue = String.valueOf(nT32);
			break;

		case 60: // '<'
			strFieldValue = String.valueOf(nT33);
			break;

		case 61: // '='
			strFieldValue = String.valueOf(nT34);
			break;

		case 62: // '>'
			strFieldValue = String.valueOf(nT35);
			break;

		case 63: // '?'
			strFieldValue = String.valueOf(nT36);
			break;

		case 64: // '@'
			strFieldValue = String.valueOf(nT37);
			break;

		case 65: // 'A'
			strFieldValue = String.valueOf(nT38);
			break;

		case 66: // 'B'
			strFieldValue = String.valueOf(nT39);
			break;

		case 67: // 'C'
			strFieldValue = String.valueOf(nT40);
			break;

		case 68: // 'D'
			strFieldValue = String.valueOf(nT41);
			break;

		case 69: // 'E'
			strFieldValue = String.valueOf(nT42);
			break;

		case 70: // 'F'
			strFieldValue = String.valueOf(nT43);
			break;

		case 71: // 'G'
			strFieldValue = String.valueOf(nT44);
			break;

		case 72: // 'H'
			strFieldValue = String.valueOf(nT45);
			break;

		case 73: // 'I'
			strFieldValue = String.valueOf(nT46);
			break;

		case 74: // 'J'
			strFieldValue = String.valueOf(nT47);
			break;

		case 75: // 'K'
			strFieldValue = String.valueOf(nT48);
			break;

		case 76: // 'L'
			strFieldValue = String.valueOf(nT49);
			break;

		case 77: // 'M'
			strFieldValue = String.valueOf(nT50);
			break;

		case 78: // 'N'
			strFieldValue = String.valueOf(nT51);
			break;

		case 79: // 'O'
			strFieldValue = String.valueOf(nT52);
			break;

		case 80: // 'P'
			strFieldValue = String.valueOf(nT53);
			break;

		case 81: // 'Q'
			strFieldValue = String.valueOf(nT54);
			break;

		case 82: // 'R'
			strFieldValue = String.valueOf(nT55);
			break;

		case 83: // 'S'
			strFieldValue = String.valueOf(nT56);
			break;

		case 84: // 'T'
			strFieldValue = String.valueOf(nT57);
			break;

		case 85: // 'U'
			strFieldValue = String.valueOf(nT58);
			break;

		case 86: // 'V'
			strFieldValue = String.valueOf(nT59);
			break;

		case 87: // 'W'
			strFieldValue = String.valueOf(nT60);
			break;

		case 88: // 'X'
			strFieldValue = String.valueOf(nT61);
			break;

		case 89: // 'Y'
			strFieldValue = String.valueOf(nT62);
			break;

		case 90: // 'Z'
			strFieldValue = String.valueOf(nT63);
			break;

		case 91: // '['
			strFieldValue = String.valueOf(nT64);
			break;

		case 92: // '\\'
			strFieldValue = String.valueOf(nT65);
			break;

		case 93: // ']'
			strFieldValue = String.valueOf(nT66);
			break;

		case 94: // '^'
			strFieldValue = String.valueOf(nT67);
			break;

		case 95: // '_'
			strFieldValue = String.valueOf(nT68);
			break;

		case 96: // '`'
			strFieldValue = String.valueOf(nT69);
			break;

		case 97: // 'a'
			strFieldValue = String.valueOf(nT70);
			break;

		case 98: // 'b'
			strFieldValue = String.valueOf(nT71);
			break;

		case 99: // 'c'
			strFieldValue = String.valueOf(nT72);
			break;

		case 100: // 'd'
			strFieldValue = String.valueOf(nT73);
			break;

		case 101: // 'e'
			strFieldValue = String.valueOf(nT74);
			break;

		case 102: // 'f'
			strFieldValue = String.valueOf(nT75);
			break;

		case 103: // 'g'
			strFieldValue = String.valueOf(nT76);
			break;

		case 104: // 'h'
			strFieldValue = String.valueOf(nT77);
			break;

		case 105: // 'i'
			strFieldValue = String.valueOf(nT78);
			break;

		case 106: // 'j'
			strFieldValue = String.valueOf(nT79);
			break;

		case 107: // 'k'
			strFieldValue = String.valueOf(nT80);
			break;

		case 108: // 'l'
			strFieldValue = String.valueOf(nF01);
			break;

		case 109: // 'm'
			strFieldValue = String.valueOf(nF02);
			break;

		case 110: // 'n'
			strFieldValue = String.valueOf(nF03);
			break;

		case 111: // 'o'
			strFieldValue = String.valueOf(nF04);
			break;

		case 112: // 'p'
			strFieldValue = String.valueOf(nF05);
			break;

		case 113: // 'q'
			strFieldValue = String.valueOf(nF06);
			break;

		case 114: // 'r'
			strFieldValue = String.valueOf(nF07);
			break;

		case 115: // 's'
			strFieldValue = String.valueOf(nF08);
			break;

		case 116: // 't'
			strFieldValue = String.valueOf(nF09);
			break;

		case 117: // 'u'
			strFieldValue = String.valueOf(nF10);
			break;

		case 118: // 'v'
			strFieldValue = String.valueOf(nS01);
			break;

		case 119: // 'w'
			strFieldValue = String.valueOf(nS02);
			break;

		case 120: // 'x'
			strFieldValue = String.valueOf(nS03);
			break;

		case 121: // 'y'
			strFieldValue = String.valueOf(nS04);
			break;

		case 122: // 'z'
			strFieldValue = String.valueOf(nS05);
			break;

		case 123: // '{'
			strFieldValue = String.valueOf(nS06);
			break;

		case 124: // '|'
			strFieldValue = String.valueOf(nS07);
			break;

		case 125: // '}'
			strFieldValue = String.valueOf(nS08);
			break;

		case 126: // '~'
			strFieldValue = String.valueOf(nS09);
			break;

		case 127: // '\177'
			strFieldValue = String.valueOf(nS10);
			break;

		case 128: 
			strFieldValue = String.valueOf(iNT01);
			break;

		case 129: 
			strFieldValue = String.valueOf(iNT02);
			break;

		case 130: 
			strFieldValue = String.valueOf(iNT03);
			break;

		case 131: 
			strFieldValue = String.valueOf(iNT04);
			break;

		case 132: 
			strFieldValue = String.valueOf(iNT05);
			break;

		case 133: 
			strFieldValue = String.valueOf(iNT06);
			break;

		case 134: 
			strFieldValue = String.valueOf(iNT07);
			break;

		case 135: 
			strFieldValue = String.valueOf(iNT08);
			break;

		case 136: 
			strFieldValue = String.valueOf(iNT09);
			break;

		case 137: 
			strFieldValue = String.valueOf(iNT10);
			break;

		case 138: 
			strFieldValue = String.valueOf(iNT11);
			break;

		case 139: 
			strFieldValue = String.valueOf(iNT12);
			break;

		case 140: 
			strFieldValue = String.valueOf(iNT13);
			break;

		case 141: 
			strFieldValue = String.valueOf(iNT14);
			break;

		case 142: 
			strFieldValue = String.valueOf(iNT15);
			break;

		case 143: 
			strFieldValue = String.valueOf(iNT16);
			break;

		case 144: 
			strFieldValue = String.valueOf(iNT17);
			break;

		case 145: 
			strFieldValue = String.valueOf(iNT18);
			break;

		case 146: 
			strFieldValue = String.valueOf(iNT19);
			break;

		case 147: 
			strFieldValue = String.valueOf(iNT20);
			break;

		case 148: 
			strFieldValue = String.valueOf(iNT21);
			break;

		case 149: 
			strFieldValue = String.valueOf(iNT22);
			break;

		case 150: 
			strFieldValue = String.valueOf(iNT23);
			break;

		case 151: 
			strFieldValue = String.valueOf(iNT24);
			break;

		case 152: 
			strFieldValue = String.valueOf(iNT25);
			break;

		case 153: 
			strFieldValue = StrTool.GBKToUnicode(v1);
			break;

		case 154: 
			strFieldValue = StrTool.GBKToUnicode(v2);
			break;

		case 155: 
			strFieldValue = StrTool.GBKToUnicode(v3);
			break;

		case 156: 
			strFieldValue = StrTool.GBKToUnicode(v4);
			break;

		case 157: 
			strFieldValue = StrTool.GBKToUnicode(v5);
			break;

		case 158: 
			strFieldValue = StrTool.GBKToUnicode(v6);
			break;

		case 159: 
			strFieldValue = StrTool.GBKToUnicode(v7);
			break;

		case 160: 
			strFieldValue = StrTool.GBKToUnicode(v8);
			break;

		case 161: 
			strFieldValue = StrTool.GBKToUnicode(v9);
			break;

		case 162: 
			strFieldValue = StrTool.GBKToUnicode(v10);
			break;

		case 163: 
			strFieldValue = StrTool.GBKToUnicode(v11);
			break;

		case 164: 
			strFieldValue = StrTool.GBKToUnicode(v12);
			break;

		case 165: 
			strFieldValue = StrTool.GBKToUnicode(v13);
			break;

		case 166: 
			strFieldValue = StrTool.GBKToUnicode(v14);
			break;

		case 167: 
			strFieldValue = StrTool.GBKToUnicode(v15);
			break;

		case 168: 
			strFieldValue = StrTool.GBKToUnicode(v16);
			break;

		case 169: 
			strFieldValue = StrTool.GBKToUnicode(v17);
			break;

		case 170: 
			strFieldValue = StrTool.GBKToUnicode(v18);
			break;

		case 171: 
			strFieldValue = StrTool.GBKToUnicode(v19);
			break;

		case 172: 
			strFieldValue = StrTool.GBKToUnicode(v20);
			break;

		case 173: 
			strFieldValue = StrTool.GBKToUnicode(vT1);
			break;

		case 174: 
			strFieldValue = StrTool.GBKToUnicode(vT2);
			break;

		case 175: 
			strFieldValue = StrTool.GBKToUnicode(vT3);
			break;

		case 176: 
			strFieldValue = StrTool.GBKToUnicode(vT4);
			break;

		case 177: 
			strFieldValue = StrTool.GBKToUnicode(vT5);
			break;

		case 178: 
			strFieldValue = StrTool.GBKToUnicode(vT6);
			break;

		case 179: 
			strFieldValue = StrTool.GBKToUnicode(vT7);
			break;

		case 180: 
			strFieldValue = StrTool.GBKToUnicode(vT8);
			break;

		case 181: 
			strFieldValue = StrTool.GBKToUnicode(vE1);
			break;

		case 182: 
			strFieldValue = StrTool.GBKToUnicode(vE2);
			break;

		case 183: 
			strFieldValue = StrTool.GBKToUnicode(vE3);
			break;

		case 184: 
			strFieldValue = StrTool.GBKToUnicode(vE4);
			break;

		case 185: 
			strFieldValue = StrTool.GBKToUnicode(vE5);
			break;

		case 186: 
			strFieldValue = StrTool.GBKToUnicode(vE6);
			break;

		case 187: 
			strFieldValue = StrTool.GBKToUnicode(vE7);
			break;

		case 188: 
			strFieldValue = StrTool.GBKToUnicode(vE8);
			break;

		case 189: 
			strFieldValue = StrTool.GBKToUnicode(vE9);
			break;

		case 190: 
			strFieldValue = StrTool.GBKToUnicode(vE10);
			break;

		case 191: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD1()));
			break;

		case 192: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD2()));
			break;

		case 193: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD3()));
			break;

		case 194: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD4()));
			break;

		case 195: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD5()));
			break;

		case 196: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD6()));
			break;

		case 197: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD7()));
			break;

		case 198: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD8()));
			break;

		case 199: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD9()));
			break;

		case 200: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getD10()));
			break;

		case 201: 
			strFieldValue = StrTool.GBKToUnicode(state);
			break;

		case 202: 
			strFieldValue = StrTool.GBKToUnicode(operator);
			break;

		case 203: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
			break;

		case 204: 
			strFieldValue = StrTool.GBKToUnicode(makeTime);
			break;

		case 205: 
			strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
			break;

		case 206: 
			strFieldValue = StrTool.GBKToUnicode(modifyTime);
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
		if (FCode.equalsIgnoreCase("manageCom"))
			if (FValue != null && !FValue.equals(""))
				manageCom = FValue.trim();
			else
				manageCom = null;
		if (FCode.equalsIgnoreCase("agentGroup"))
			if (FValue != null && !FValue.equals(""))
				agentGroup = FValue.trim();
			else
				agentGroup = null;
		if (FCode.equalsIgnoreCase("branchAttr"))
			if (FValue != null && !FValue.equals(""))
				branchAttr = FValue.trim();
			else
				branchAttr = null;
		if (FCode.equalsIgnoreCase("agentCode"))
			if (FValue != null && !FValue.equals(""))
				agentCode = FValue.trim();
			else
				agentCode = null;
		if (FCode.equalsIgnoreCase("agentGrade"))
			if (FValue != null && !FValue.equals(""))
				agentGrade = FValue.trim();
			else
				agentGrade = null;
		if (FCode.equalsIgnoreCase("agentTitle"))
			if (FValue != null && !FValue.equals(""))
				agentTitle = FValue.trim();
			else
				agentTitle = null;
		if (FCode.equalsIgnoreCase("quaBgnMark") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			quaBgnMark = i;
		}
		if (FCode.equalsIgnoreCase("postMonths") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			postMonths = i;
		}
		if (FCode.equalsIgnoreCase("assessMonth"))
			if (FValue != null && !FValue.equals(""))
				assessMonth = FValue.trim();
			else
				assessMonth = null;
		if (FCode.equalsIgnoreCase("agentGrade1"))
			if (FValue != null && !FValue.equals(""))
				agentGrade1 = FValue.trim();
			else
				agentGrade1 = null;
		if (FCode.equalsIgnoreCase("agentTitle1"))
			if (FValue != null && !FValue.equals(""))
				agentTitle1 = FValue.trim();
			else
				agentTitle1 = null;
		if (FCode.equalsIgnoreCase("agentGrade2"))
			if (FValue != null && !FValue.equals(""))
				agentGrade2 = FValue.trim();
			else
				agentGrade2 = null;
		if (FCode.equalsIgnoreCase("agentTitle2"))
			if (FValue != null && !FValue.equals(""))
				agentTitle2 = FValue.trim();
			else
				agentTitle2 = null;
		if (FCode.equalsIgnoreCase("agentGrade3"))
			if (FValue != null && !FValue.equals(""))
				agentGrade3 = FValue.trim();
			else
				agentGrade3 = null;
		if (FCode.equalsIgnoreCase("agentTitle3"))
			if (FValue != null && !FValue.equals(""))
				agentTitle3 = FValue.trim();
			else
				agentTitle3 = null;
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
		if (FCode.equalsIgnoreCase("startDate1"))
			if (FValue != null && !FValue.equals(""))
				startDate1 = fDate.getDate(FValue);
			else
				startDate1 = null;
		if (FCode.equalsIgnoreCase("startEnd1"))
			if (FValue != null && !FValue.equals(""))
				startEnd1 = fDate.getDate(FValue);
			else
				startEnd1 = null;
		if (FCode.equalsIgnoreCase("startDate2"))
			if (FValue != null && !FValue.equals(""))
				startDate2 = fDate.getDate(FValue);
			else
				startDate2 = null;
		if (FCode.equalsIgnoreCase("startEnd2"))
			if (FValue != null && !FValue.equals(""))
				startEnd2 = fDate.getDate(FValue);
			else
				startEnd2 = null;
		if (FCode.equalsIgnoreCase("startDate3"))
			if (FValue != null && !FValue.equals(""))
				startDate3 = fDate.getDate(FValue);
			else
				startDate3 = null;
		if (FCode.equalsIgnoreCase("startEnd3"))
			if (FValue != null && !FValue.equals(""))
				startEnd3 = fDate.getDate(FValue);
			else
				startEnd3 = null;
		if (FCode.equalsIgnoreCase("startEnd4"))
			if (FValue != null && !FValue.equals(""))
				startEnd4 = fDate.getDate(FValue);
			else
				startEnd4 = null;
		if (FCode.equalsIgnoreCase("startDate4"))
			if (FValue != null && !FValue.equals(""))
				startDate4 = fDate.getDate(FValue);
			else
				startDate4 = null;
		if (FCode.equalsIgnoreCase("serverMonths") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			serverMonths = i;
		}
		if (FCode.equalsIgnoreCase("nT01") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT01 = d;
		}
		if (FCode.equalsIgnoreCase("nT02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT02 = d;
		}
		if (FCode.equalsIgnoreCase("nT03") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT03 = d;
		}
		if (FCode.equalsIgnoreCase("nT04") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT04 = d;
		}
		if (FCode.equalsIgnoreCase("nT05") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT05 = d;
		}
		if (FCode.equalsIgnoreCase("nT06") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT06 = d;
		}
		if (FCode.equalsIgnoreCase("nT07") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT07 = d;
		}
		if (FCode.equalsIgnoreCase("nT08") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT08 = d;
		}
		if (FCode.equalsIgnoreCase("nT09") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT09 = d;
		}
		if (FCode.equalsIgnoreCase("nT10") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT10 = d;
		}
		if (FCode.equalsIgnoreCase("nT11") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT11 = d;
		}
		if (FCode.equalsIgnoreCase("nT12") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT12 = d;
		}
		if (FCode.equalsIgnoreCase("nT13") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT13 = d;
		}
		if (FCode.equalsIgnoreCase("nT14") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT14 = d;
		}
		if (FCode.equalsIgnoreCase("nT15") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT15 = d;
		}
		if (FCode.equalsIgnoreCase("nT16") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT16 = d;
		}
		if (FCode.equalsIgnoreCase("nT17") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT17 = d;
		}
		if (FCode.equalsIgnoreCase("nT18") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT18 = d;
		}
		if (FCode.equalsIgnoreCase("nT19") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT19 = d;
		}
		if (FCode.equalsIgnoreCase("nT20") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT20 = d;
		}
		if (FCode.equalsIgnoreCase("nT21") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT21 = d;
		}
		if (FCode.equalsIgnoreCase("nT22") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT22 = d;
		}
		if (FCode.equalsIgnoreCase("nT23") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT23 = d;
		}
		if (FCode.equalsIgnoreCase("nT24") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT24 = d;
		}
		if (FCode.equalsIgnoreCase("nT25") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT25 = d;
		}
		if (FCode.equalsIgnoreCase("nT26") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT26 = d;
		}
		if (FCode.equalsIgnoreCase("nT27") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT27 = d;
		}
		if (FCode.equalsIgnoreCase("nT28") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT28 = d;
		}
		if (FCode.equalsIgnoreCase("nT29") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT29 = d;
		}
		if (FCode.equalsIgnoreCase("nT30") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT30 = d;
		}
		if (FCode.equalsIgnoreCase("nT31") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT31 = d;
		}
		if (FCode.equalsIgnoreCase("nT32") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT32 = d;
		}
		if (FCode.equalsIgnoreCase("nT33") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT33 = d;
		}
		if (FCode.equalsIgnoreCase("nT34") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT34 = d;
		}
		if (FCode.equalsIgnoreCase("nT35") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT35 = d;
		}
		if (FCode.equalsIgnoreCase("nT36") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT36 = d;
		}
		if (FCode.equalsIgnoreCase("nT37") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT37 = d;
		}
		if (FCode.equalsIgnoreCase("nT38") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT38 = d;
		}
		if (FCode.equalsIgnoreCase("nT39") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT39 = d;
		}
		if (FCode.equalsIgnoreCase("nT40") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT40 = d;
		}
		if (FCode.equalsIgnoreCase("nT41") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT41 = d;
		}
		if (FCode.equalsIgnoreCase("nT42") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT42 = d;
		}
		if (FCode.equalsIgnoreCase("nT43") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT43 = d;
		}
		if (FCode.equalsIgnoreCase("nT44") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT44 = d;
		}
		if (FCode.equalsIgnoreCase("nT45") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT45 = d;
		}
		if (FCode.equalsIgnoreCase("nT46") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT46 = d;
		}
		if (FCode.equalsIgnoreCase("nT47") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT47 = d;
		}
		if (FCode.equalsIgnoreCase("nT48") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT48 = d;
		}
		if (FCode.equalsIgnoreCase("nT49") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT49 = d;
		}
		if (FCode.equalsIgnoreCase("nT50") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT50 = d;
		}
		if (FCode.equalsIgnoreCase("nT51") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT51 = d;
		}
		if (FCode.equalsIgnoreCase("nT52") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT52 = d;
		}
		if (FCode.equalsIgnoreCase("nT53") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT53 = d;
		}
		if (FCode.equalsIgnoreCase("nT54") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT54 = d;
		}
		if (FCode.equalsIgnoreCase("nT55") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT55 = d;
		}
		if (FCode.equalsIgnoreCase("nT56") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT56 = d;
		}
		if (FCode.equalsIgnoreCase("nT57") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT57 = d;
		}
		if (FCode.equalsIgnoreCase("nT58") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT58 = d;
		}
		if (FCode.equalsIgnoreCase("nT59") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT59 = d;
		}
		if (FCode.equalsIgnoreCase("nT60") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT60 = d;
		}
		if (FCode.equalsIgnoreCase("nT61") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT61 = d;
		}
		if (FCode.equalsIgnoreCase("nT62") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT62 = d;
		}
		if (FCode.equalsIgnoreCase("nT63") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT63 = d;
		}
		if (FCode.equalsIgnoreCase("nT64") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT64 = d;
		}
		if (FCode.equalsIgnoreCase("nT65") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT65 = d;
		}
		if (FCode.equalsIgnoreCase("nT66") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT66 = d;
		}
		if (FCode.equalsIgnoreCase("nT67") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT67 = d;
		}
		if (FCode.equalsIgnoreCase("nT68") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT68 = d;
		}
		if (FCode.equalsIgnoreCase("nT69") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT69 = d;
		}
		if (FCode.equalsIgnoreCase("nT70") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT70 = d;
		}
		if (FCode.equalsIgnoreCase("nT71") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT71 = d;
		}
		if (FCode.equalsIgnoreCase("nT72") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT72 = d;
		}
		if (FCode.equalsIgnoreCase("nT73") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT73 = d;
		}
		if (FCode.equalsIgnoreCase("nT74") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT74 = d;
		}
		if (FCode.equalsIgnoreCase("nT75") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT75 = d;
		}
		if (FCode.equalsIgnoreCase("nT76") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT76 = d;
		}
		if (FCode.equalsIgnoreCase("nT77") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT77 = d;
		}
		if (FCode.equalsIgnoreCase("nT78") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT78 = d;
		}
		if (FCode.equalsIgnoreCase("nT79") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT79 = d;
		}
		if (FCode.equalsIgnoreCase("nT80") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nT80 = d;
		}
		if (FCode.equalsIgnoreCase("nF01") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF01 = d;
		}
		if (FCode.equalsIgnoreCase("nF02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF02 = d;
		}
		if (FCode.equalsIgnoreCase("nF03") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF03 = d;
		}
		if (FCode.equalsIgnoreCase("nF04") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF04 = d;
		}
		if (FCode.equalsIgnoreCase("nF05") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF05 = d;
		}
		if (FCode.equalsIgnoreCase("nF06") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF06 = d;
		}
		if (FCode.equalsIgnoreCase("nF07") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF07 = d;
		}
		if (FCode.equalsIgnoreCase("nF08") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF08 = d;
		}
		if (FCode.equalsIgnoreCase("nF09") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF09 = d;
		}
		if (FCode.equalsIgnoreCase("nF10") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nF10 = d;
		}
		if (FCode.equalsIgnoreCase("nS01") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS01 = d;
		}
		if (FCode.equalsIgnoreCase("nS02") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS02 = d;
		}
		if (FCode.equalsIgnoreCase("nS03") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS03 = d;
		}
		if (FCode.equalsIgnoreCase("nS04") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS04 = d;
		}
		if (FCode.equalsIgnoreCase("nS05") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS05 = d;
		}
		if (FCode.equalsIgnoreCase("nS06") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS06 = d;
		}
		if (FCode.equalsIgnoreCase("nS07") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS07 = d;
		}
		if (FCode.equalsIgnoreCase("nS08") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS08 = d;
		}
		if (FCode.equalsIgnoreCase("nS09") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS09 = d;
		}
		if (FCode.equalsIgnoreCase("nS10") && FValue != null && !FValue.equals(""))
		{
			Double tDouble = new Double(FValue);
			double d = tDouble.doubleValue();
			nS10 = d;
		}
		if (FCode.equalsIgnoreCase("iNT01") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT01 = i;
		}
		if (FCode.equalsIgnoreCase("iNT02") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT02 = i;
		}
		if (FCode.equalsIgnoreCase("iNT03") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT03 = i;
		}
		if (FCode.equalsIgnoreCase("iNT04") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT04 = i;
		}
		if (FCode.equalsIgnoreCase("iNT05") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT05 = i;
		}
		if (FCode.equalsIgnoreCase("iNT06") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT06 = i;
		}
		if (FCode.equalsIgnoreCase("iNT07") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT07 = i;
		}
		if (FCode.equalsIgnoreCase("iNT08") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT08 = i;
		}
		if (FCode.equalsIgnoreCase("iNT09") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT09 = i;
		}
		if (FCode.equalsIgnoreCase("iNT10") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT10 = i;
		}
		if (FCode.equalsIgnoreCase("iNT11") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT11 = i;
		}
		if (FCode.equalsIgnoreCase("iNT12") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT12 = i;
		}
		if (FCode.equalsIgnoreCase("iNT13") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT13 = i;
		}
		if (FCode.equalsIgnoreCase("iNT14") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT14 = i;
		}
		if (FCode.equalsIgnoreCase("iNT15") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT15 = i;
		}
		if (FCode.equalsIgnoreCase("iNT16") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT16 = i;
		}
		if (FCode.equalsIgnoreCase("iNT17") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT17 = i;
		}
		if (FCode.equalsIgnoreCase("iNT18") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT18 = i;
		}
		if (FCode.equalsIgnoreCase("iNT19") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT19 = i;
		}
		if (FCode.equalsIgnoreCase("iNT20") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT20 = i;
		}
		if (FCode.equalsIgnoreCase("iNT21") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT21 = i;
		}
		if (FCode.equalsIgnoreCase("iNT22") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT22 = i;
		}
		if (FCode.equalsIgnoreCase("iNT23") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT23 = i;
		}
		if (FCode.equalsIgnoreCase("iNT24") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT24 = i;
		}
		if (FCode.equalsIgnoreCase("iNT25") && FValue != null && !FValue.equals(""))
		{
			Integer tInteger = new Integer(FValue);
			int i = tInteger.intValue();
			iNT25 = i;
		}
		if (FCode.equalsIgnoreCase("v1"))
			if (FValue != null && !FValue.equals(""))
				v1 = FValue.trim();
			else
				v1 = null;
		if (FCode.equalsIgnoreCase("v2"))
			if (FValue != null && !FValue.equals(""))
				v2 = FValue.trim();
			else
				v2 = null;
		if (FCode.equalsIgnoreCase("v3"))
			if (FValue != null && !FValue.equals(""))
				v3 = FValue.trim();
			else
				v3 = null;
		if (FCode.equalsIgnoreCase("v4"))
			if (FValue != null && !FValue.equals(""))
				v4 = FValue.trim();
			else
				v4 = null;
		if (FCode.equalsIgnoreCase("v5"))
			if (FValue != null && !FValue.equals(""))
				v5 = FValue.trim();
			else
				v5 = null;
		if (FCode.equalsIgnoreCase("v6"))
			if (FValue != null && !FValue.equals(""))
				v6 = FValue.trim();
			else
				v6 = null;
		if (FCode.equalsIgnoreCase("v7"))
			if (FValue != null && !FValue.equals(""))
				v7 = FValue.trim();
			else
				v7 = null;
		if (FCode.equalsIgnoreCase("v8"))
			if (FValue != null && !FValue.equals(""))
				v8 = FValue.trim();
			else
				v8 = null;
		if (FCode.equalsIgnoreCase("v9"))
			if (FValue != null && !FValue.equals(""))
				v9 = FValue.trim();
			else
				v9 = null;
		if (FCode.equalsIgnoreCase("v10"))
			if (FValue != null && !FValue.equals(""))
				v10 = FValue.trim();
			else
				v10 = null;
		if (FCode.equalsIgnoreCase("v11"))
			if (FValue != null && !FValue.equals(""))
				v11 = FValue.trim();
			else
				v11 = null;
		if (FCode.equalsIgnoreCase("v12"))
			if (FValue != null && !FValue.equals(""))
				v12 = FValue.trim();
			else
				v12 = null;
		if (FCode.equalsIgnoreCase("v13"))
			if (FValue != null && !FValue.equals(""))
				v13 = FValue.trim();
			else
				v13 = null;
		if (FCode.equalsIgnoreCase("v14"))
			if (FValue != null && !FValue.equals(""))
				v14 = FValue.trim();
			else
				v14 = null;
		if (FCode.equalsIgnoreCase("v15"))
			if (FValue != null && !FValue.equals(""))
				v15 = FValue.trim();
			else
				v15 = null;
		if (FCode.equalsIgnoreCase("v16"))
			if (FValue != null && !FValue.equals(""))
				v16 = FValue.trim();
			else
				v16 = null;
		if (FCode.equalsIgnoreCase("v17"))
			if (FValue != null && !FValue.equals(""))
				v17 = FValue.trim();
			else
				v17 = null;
		if (FCode.equalsIgnoreCase("v18"))
			if (FValue != null && !FValue.equals(""))
				v18 = FValue.trim();
			else
				v18 = null;
		if (FCode.equalsIgnoreCase("v19"))
			if (FValue != null && !FValue.equals(""))
				v19 = FValue.trim();
			else
				v19 = null;
		if (FCode.equalsIgnoreCase("v20"))
			if (FValue != null && !FValue.equals(""))
				v20 = FValue.trim();
			else
				v20 = null;
		if (FCode.equalsIgnoreCase("vT1"))
			if (FValue != null && !FValue.equals(""))
				vT1 = FValue.trim();
			else
				vT1 = null;
		if (FCode.equalsIgnoreCase("vT2"))
			if (FValue != null && !FValue.equals(""))
				vT2 = FValue.trim();
			else
				vT2 = null;
		if (FCode.equalsIgnoreCase("vT3"))
			if (FValue != null && !FValue.equals(""))
				vT3 = FValue.trim();
			else
				vT3 = null;
		if (FCode.equalsIgnoreCase("vT4"))
			if (FValue != null && !FValue.equals(""))
				vT4 = FValue.trim();
			else
				vT4 = null;
		if (FCode.equalsIgnoreCase("vT5"))
			if (FValue != null && !FValue.equals(""))
				vT5 = FValue.trim();
			else
				vT5 = null;
		if (FCode.equalsIgnoreCase("vT6"))
			if (FValue != null && !FValue.equals(""))
				vT6 = FValue.trim();
			else
				vT6 = null;
		if (FCode.equalsIgnoreCase("vT7"))
			if (FValue != null && !FValue.equals(""))
				vT7 = FValue.trim();
			else
				vT7 = null;
		if (FCode.equalsIgnoreCase("vT8"))
			if (FValue != null && !FValue.equals(""))
				vT8 = FValue.trim();
			else
				vT8 = null;
		if (FCode.equalsIgnoreCase("vE1"))
			if (FValue != null && !FValue.equals(""))
				vE1 = FValue.trim();
			else
				vE1 = null;
		if (FCode.equalsIgnoreCase("vE2"))
			if (FValue != null && !FValue.equals(""))
				vE2 = FValue.trim();
			else
				vE2 = null;
		if (FCode.equalsIgnoreCase("vE3"))
			if (FValue != null && !FValue.equals(""))
				vE3 = FValue.trim();
			else
				vE3 = null;
		if (FCode.equalsIgnoreCase("vE4"))
			if (FValue != null && !FValue.equals(""))
				vE4 = FValue.trim();
			else
				vE4 = null;
		if (FCode.equalsIgnoreCase("vE5"))
			if (FValue != null && !FValue.equals(""))
				vE5 = FValue.trim();
			else
				vE5 = null;
		if (FCode.equalsIgnoreCase("vE6"))
			if (FValue != null && !FValue.equals(""))
				vE6 = FValue.trim();
			else
				vE6 = null;
		if (FCode.equalsIgnoreCase("vE7"))
			if (FValue != null && !FValue.equals(""))
				vE7 = FValue.trim();
			else
				vE7 = null;
		if (FCode.equalsIgnoreCase("vE8"))
			if (FValue != null && !FValue.equals(""))
				vE8 = FValue.trim();
			else
				vE8 = null;
		if (FCode.equalsIgnoreCase("vE9"))
			if (FValue != null && !FValue.equals(""))
				vE9 = FValue.trim();
			else
				vE9 = null;
		if (FCode.equalsIgnoreCase("vE10"))
			if (FValue != null && !FValue.equals(""))
				vE10 = FValue.trim();
			else
				vE10 = null;
		if (FCode.equalsIgnoreCase("d1"))
			if (FValue != null && !FValue.equals(""))
				d1 = fDate.getDate(FValue);
			else
				d1 = null;
		if (FCode.equalsIgnoreCase("d2"))
			if (FValue != null && !FValue.equals(""))
				d2 = fDate.getDate(FValue);
			else
				d2 = null;
		if (FCode.equalsIgnoreCase("d3"))
			if (FValue != null && !FValue.equals(""))
				d3 = fDate.getDate(FValue);
			else
				d3 = null;
		if (FCode.equalsIgnoreCase("d4"))
			if (FValue != null && !FValue.equals(""))
				d4 = fDate.getDate(FValue);
			else
				d4 = null;
		if (FCode.equalsIgnoreCase("d5"))
			if (FValue != null && !FValue.equals(""))
				d5 = fDate.getDate(FValue);
			else
				d5 = null;
		if (FCode.equalsIgnoreCase("d6"))
			if (FValue != null && !FValue.equals(""))
				d6 = fDate.getDate(FValue);
			else
				d6 = null;
		if (FCode.equalsIgnoreCase("d7"))
			if (FValue != null && !FValue.equals(""))
				d7 = fDate.getDate(FValue);
			else
				d7 = null;
		if (FCode.equalsIgnoreCase("d8"))
			if (FValue != null && !FValue.equals(""))
				d8 = fDate.getDate(FValue);
			else
				d8 = null;
		if (FCode.equalsIgnoreCase("d9"))
			if (FValue != null && !FValue.equals(""))
				d9 = fDate.getDate(FValue);
			else
				d9 = null;
		if (FCode.equalsIgnoreCase("d10"))
			if (FValue != null && !FValue.equals(""))
				d10 = fDate.getDate(FValue);
			else
				d10 = null;
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
		LAIndexInfoNewSchema other = (LAIndexInfoNewSchema)otherObject;
		if (indexCalNo == null && other.getIndexCalNo() != null)
			return false;
		if (indexCalNo != null && !indexCalNo.equals(other.getIndexCalNo()))
			return false;
		if (indexType == null && other.getIndexType() != null)
			return false;
		if (indexType != null && !indexType.equals(other.getIndexType()))
			return false;
		if (manageCom == null && other.getManageCom() != null)
			return false;
		if (manageCom != null && !manageCom.equals(other.getManageCom()))
			return false;
		if (agentGroup == null && other.getAgentGroup() != null)
			return false;
		if (agentGroup != null && !agentGroup.equals(other.getAgentGroup()))
			return false;
		if (branchAttr == null && other.getBranchAttr() != null)
			return false;
		if (branchAttr != null && !branchAttr.equals(other.getBranchAttr()))
			return false;
		if (agentCode == null && other.getAgentCode() != null)
			return false;
		if (agentCode != null && !agentCode.equals(other.getAgentCode()))
			return false;
		if (agentGrade == null && other.getAgentGrade() != null)
			return false;
		if (agentGrade != null && !agentGrade.equals(other.getAgentGrade()))
			return false;
		if (agentTitle == null && other.getAgentTitle() != null)
			return false;
		if (agentTitle != null && !agentTitle.equals(other.getAgentTitle()))
			return false;
		if (quaBgnMark != other.getQuaBgnMark())
			return false;
		if (postMonths != other.getPostMonths())
			return false;
		if (assessMonth == null && other.getAssessMonth() != null)
			return false;
		if (assessMonth != null && !assessMonth.equals(other.getAssessMonth()))
			return false;
		if (agentGrade1 == null && other.getAgentGrade1() != null)
			return false;
		if (agentGrade1 != null && !agentGrade1.equals(other.getAgentGrade1()))
			return false;
		if (agentTitle1 == null && other.getAgentTitle1() != null)
			return false;
		if (agentTitle1 != null && !agentTitle1.equals(other.getAgentTitle1()))
			return false;
		if (agentGrade2 == null && other.getAgentGrade2() != null)
			return false;
		if (agentGrade2 != null && !agentGrade2.equals(other.getAgentGrade2()))
			return false;
		if (agentTitle2 == null && other.getAgentTitle2() != null)
			return false;
		if (agentTitle2 != null && !agentTitle2.equals(other.getAgentTitle2()))
			return false;
		if (agentGrade3 == null && other.getAgentGrade3() != null)
			return false;
		if (agentGrade3 != null && !agentGrade3.equals(other.getAgentGrade3()))
			return false;
		if (agentTitle3 == null && other.getAgentTitle3() != null)
			return false;
		if (agentTitle3 != null && !agentTitle3.equals(other.getAgentTitle3()))
			return false;
		if (startDate == null && other.getStartDate() != null)
			return false;
		if (startDate != null && !fDate.getString(startDate).equals(other.getStartDate()))
			return false;
		if (startEnd == null && other.getStartEnd() != null)
			return false;
		if (startEnd != null && !fDate.getString(startEnd).equals(other.getStartEnd()))
			return false;
		if (startDate1 == null && other.getStartDate1() != null)
			return false;
		if (startDate1 != null && !fDate.getString(startDate1).equals(other.getStartDate1()))
			return false;
		if (startEnd1 == null && other.getStartEnd1() != null)
			return false;
		if (startEnd1 != null && !fDate.getString(startEnd1).equals(other.getStartEnd1()))
			return false;
		if (startDate2 == null && other.getStartDate2() != null)
			return false;
		if (startDate2 != null && !fDate.getString(startDate2).equals(other.getStartDate2()))
			return false;
		if (startEnd2 == null && other.getStartEnd2() != null)
			return false;
		if (startEnd2 != null && !fDate.getString(startEnd2).equals(other.getStartEnd2()))
			return false;
		if (startDate3 == null && other.getStartDate3() != null)
			return false;
		if (startDate3 != null && !fDate.getString(startDate3).equals(other.getStartDate3()))
			return false;
		if (startEnd3 == null && other.getStartEnd3() != null)
			return false;
		if (startEnd3 != null && !fDate.getString(startEnd3).equals(other.getStartEnd3()))
			return false;
		if (startEnd4 == null && other.getStartEnd4() != null)
			return false;
		if (startEnd4 != null && !fDate.getString(startEnd4).equals(other.getStartEnd4()))
			return false;
		if (startDate4 == null && other.getStartDate4() != null)
			return false;
		if (startDate4 != null && !fDate.getString(startDate4).equals(other.getStartDate4()))
			return false;
		if (serverMonths != other.getServerMonths())
			return false;
		if (Double.doubleToLongBits(nT01) != Double.doubleToLongBits(other.getNT01()))
			return false;
		if (Double.doubleToLongBits(nT02) != Double.doubleToLongBits(other.getNT02()))
			return false;
		if (Double.doubleToLongBits(nT03) != Double.doubleToLongBits(other.getNT03()))
			return false;
		if (Double.doubleToLongBits(nT04) != Double.doubleToLongBits(other.getNT04()))
			return false;
		if (Double.doubleToLongBits(nT05) != Double.doubleToLongBits(other.getNT05()))
			return false;
		if (Double.doubleToLongBits(nT06) != Double.doubleToLongBits(other.getNT06()))
			return false;
		if (Double.doubleToLongBits(nT07) != Double.doubleToLongBits(other.getNT07()))
			return false;
		if (Double.doubleToLongBits(nT08) != Double.doubleToLongBits(other.getNT08()))
			return false;
		if (Double.doubleToLongBits(nT09) != Double.doubleToLongBits(other.getNT09()))
			return false;
		if (Double.doubleToLongBits(nT10) != Double.doubleToLongBits(other.getNT10()))
			return false;
		if (Double.doubleToLongBits(nT11) != Double.doubleToLongBits(other.getNT11()))
			return false;
		if (Double.doubleToLongBits(nT12) != Double.doubleToLongBits(other.getNT12()))
			return false;
		if (Double.doubleToLongBits(nT13) != Double.doubleToLongBits(other.getNT13()))
			return false;
		if (Double.doubleToLongBits(nT14) != Double.doubleToLongBits(other.getNT14()))
			return false;
		if (Double.doubleToLongBits(nT15) != Double.doubleToLongBits(other.getNT15()))
			return false;
		if (Double.doubleToLongBits(nT16) != Double.doubleToLongBits(other.getNT16()))
			return false;
		if (Double.doubleToLongBits(nT17) != Double.doubleToLongBits(other.getNT17()))
			return false;
		if (Double.doubleToLongBits(nT18) != Double.doubleToLongBits(other.getNT18()))
			return false;
		if (Double.doubleToLongBits(nT19) != Double.doubleToLongBits(other.getNT19()))
			return false;
		if (Double.doubleToLongBits(nT20) != Double.doubleToLongBits(other.getNT20()))
			return false;
		if (Double.doubleToLongBits(nT21) != Double.doubleToLongBits(other.getNT21()))
			return false;
		if (Double.doubleToLongBits(nT22) != Double.doubleToLongBits(other.getNT22()))
			return false;
		if (Double.doubleToLongBits(nT23) != Double.doubleToLongBits(other.getNT23()))
			return false;
		if (Double.doubleToLongBits(nT24) != Double.doubleToLongBits(other.getNT24()))
			return false;
		if (Double.doubleToLongBits(nT25) != Double.doubleToLongBits(other.getNT25()))
			return false;
		if (Double.doubleToLongBits(nT26) != Double.doubleToLongBits(other.getNT26()))
			return false;
		if (Double.doubleToLongBits(nT27) != Double.doubleToLongBits(other.getNT27()))
			return false;
		if (Double.doubleToLongBits(nT28) != Double.doubleToLongBits(other.getNT28()))
			return false;
		if (Double.doubleToLongBits(nT29) != Double.doubleToLongBits(other.getNT29()))
			return false;
		if (Double.doubleToLongBits(nT30) != Double.doubleToLongBits(other.getNT30()))
			return false;
		if (Double.doubleToLongBits(nT31) != Double.doubleToLongBits(other.getNT31()))
			return false;
		if (Double.doubleToLongBits(nT32) != Double.doubleToLongBits(other.getNT32()))
			return false;
		if (Double.doubleToLongBits(nT33) != Double.doubleToLongBits(other.getNT33()))
			return false;
		if (Double.doubleToLongBits(nT34) != Double.doubleToLongBits(other.getNT34()))
			return false;
		if (Double.doubleToLongBits(nT35) != Double.doubleToLongBits(other.getNT35()))
			return false;
		if (Double.doubleToLongBits(nT36) != Double.doubleToLongBits(other.getNT36()))
			return false;
		if (Double.doubleToLongBits(nT37) != Double.doubleToLongBits(other.getNT37()))
			return false;
		if (Double.doubleToLongBits(nT38) != Double.doubleToLongBits(other.getNT38()))
			return false;
		if (Double.doubleToLongBits(nT39) != Double.doubleToLongBits(other.getNT39()))
			return false;
		if (Double.doubleToLongBits(nT40) != Double.doubleToLongBits(other.getNT40()))
			return false;
		if (Double.doubleToLongBits(nT41) != Double.doubleToLongBits(other.getNT41()))
			return false;
		if (Double.doubleToLongBits(nT42) != Double.doubleToLongBits(other.getNT42()))
			return false;
		if (Double.doubleToLongBits(nT43) != Double.doubleToLongBits(other.getNT43()))
			return false;
		if (Double.doubleToLongBits(nT44) != Double.doubleToLongBits(other.getNT44()))
			return false;
		if (Double.doubleToLongBits(nT45) != Double.doubleToLongBits(other.getNT45()))
			return false;
		if (Double.doubleToLongBits(nT46) != Double.doubleToLongBits(other.getNT46()))
			return false;
		if (Double.doubleToLongBits(nT47) != Double.doubleToLongBits(other.getNT47()))
			return false;
		if (Double.doubleToLongBits(nT48) != Double.doubleToLongBits(other.getNT48()))
			return false;
		if (Double.doubleToLongBits(nT49) != Double.doubleToLongBits(other.getNT49()))
			return false;
		if (Double.doubleToLongBits(nT50) != Double.doubleToLongBits(other.getNT50()))
			return false;
		if (Double.doubleToLongBits(nT51) != Double.doubleToLongBits(other.getNT51()))
			return false;
		if (Double.doubleToLongBits(nT52) != Double.doubleToLongBits(other.getNT52()))
			return false;
		if (Double.doubleToLongBits(nT53) != Double.doubleToLongBits(other.getNT53()))
			return false;
		if (Double.doubleToLongBits(nT54) != Double.doubleToLongBits(other.getNT54()))
			return false;
		if (Double.doubleToLongBits(nT55) != Double.doubleToLongBits(other.getNT55()))
			return false;
		if (Double.doubleToLongBits(nT56) != Double.doubleToLongBits(other.getNT56()))
			return false;
		if (Double.doubleToLongBits(nT57) != Double.doubleToLongBits(other.getNT57()))
			return false;
		if (Double.doubleToLongBits(nT58) != Double.doubleToLongBits(other.getNT58()))
			return false;
		if (Double.doubleToLongBits(nT59) != Double.doubleToLongBits(other.getNT59()))
			return false;
		if (Double.doubleToLongBits(nT60) != Double.doubleToLongBits(other.getNT60()))
			return false;
		if (Double.doubleToLongBits(nT61) != Double.doubleToLongBits(other.getNT61()))
			return false;
		if (Double.doubleToLongBits(nT62) != Double.doubleToLongBits(other.getNT62()))
			return false;
		if (Double.doubleToLongBits(nT63) != Double.doubleToLongBits(other.getNT63()))
			return false;
		if (Double.doubleToLongBits(nT64) != Double.doubleToLongBits(other.getNT64()))
			return false;
		if (Double.doubleToLongBits(nT65) != Double.doubleToLongBits(other.getNT65()))
			return false;
		if (Double.doubleToLongBits(nT66) != Double.doubleToLongBits(other.getNT66()))
			return false;
		if (Double.doubleToLongBits(nT67) != Double.doubleToLongBits(other.getNT67()))
			return false;
		if (Double.doubleToLongBits(nT68) != Double.doubleToLongBits(other.getNT68()))
			return false;
		if (Double.doubleToLongBits(nT69) != Double.doubleToLongBits(other.getNT69()))
			return false;
		if (Double.doubleToLongBits(nT70) != Double.doubleToLongBits(other.getNT70()))
			return false;
		if (Double.doubleToLongBits(nT71) != Double.doubleToLongBits(other.getNT71()))
			return false;
		if (Double.doubleToLongBits(nT72) != Double.doubleToLongBits(other.getNT72()))
			return false;
		if (Double.doubleToLongBits(nT73) != Double.doubleToLongBits(other.getNT73()))
			return false;
		if (Double.doubleToLongBits(nT74) != Double.doubleToLongBits(other.getNT74()))
			return false;
		if (Double.doubleToLongBits(nT75) != Double.doubleToLongBits(other.getNT75()))
			return false;
		if (Double.doubleToLongBits(nT76) != Double.doubleToLongBits(other.getNT76()))
			return false;
		if (Double.doubleToLongBits(nT77) != Double.doubleToLongBits(other.getNT77()))
			return false;
		if (Double.doubleToLongBits(nT78) != Double.doubleToLongBits(other.getNT78()))
			return false;
		if (Double.doubleToLongBits(nT79) != Double.doubleToLongBits(other.getNT79()))
			return false;
		if (Double.doubleToLongBits(nT80) != Double.doubleToLongBits(other.getNT80()))
			return false;
		if (Double.doubleToLongBits(nF01) != Double.doubleToLongBits(other.getNF01()))
			return false;
		if (Double.doubleToLongBits(nF02) != Double.doubleToLongBits(other.getNF02()))
			return false;
		if (Double.doubleToLongBits(nF03) != Double.doubleToLongBits(other.getNF03()))
			return false;
		if (Double.doubleToLongBits(nF04) != Double.doubleToLongBits(other.getNF04()))
			return false;
		if (Double.doubleToLongBits(nF05) != Double.doubleToLongBits(other.getNF05()))
			return false;
		if (Double.doubleToLongBits(nF06) != Double.doubleToLongBits(other.getNF06()))
			return false;
		if (Double.doubleToLongBits(nF07) != Double.doubleToLongBits(other.getNF07()))
			return false;
		if (Double.doubleToLongBits(nF08) != Double.doubleToLongBits(other.getNF08()))
			return false;
		if (Double.doubleToLongBits(nF09) != Double.doubleToLongBits(other.getNF09()))
			return false;
		if (Double.doubleToLongBits(nF10) != Double.doubleToLongBits(other.getNF10()))
			return false;
		if (Double.doubleToLongBits(nS01) != Double.doubleToLongBits(other.getNS01()))
			return false;
		if (Double.doubleToLongBits(nS02) != Double.doubleToLongBits(other.getNS02()))
			return false;
		if (Double.doubleToLongBits(nS03) != Double.doubleToLongBits(other.getNS03()))
			return false;
		if (Double.doubleToLongBits(nS04) != Double.doubleToLongBits(other.getNS04()))
			return false;
		if (Double.doubleToLongBits(nS05) != Double.doubleToLongBits(other.getNS05()))
			return false;
		if (Double.doubleToLongBits(nS06) != Double.doubleToLongBits(other.getNS06()))
			return false;
		if (Double.doubleToLongBits(nS07) != Double.doubleToLongBits(other.getNS07()))
			return false;
		if (Double.doubleToLongBits(nS08) != Double.doubleToLongBits(other.getNS08()))
			return false;
		if (Double.doubleToLongBits(nS09) != Double.doubleToLongBits(other.getNS09()))
			return false;
		if (Double.doubleToLongBits(nS10) != Double.doubleToLongBits(other.getNS10()))
			return false;
		if (iNT01 != other.getINT01())
			return false;
		if (iNT02 != other.getINT02())
			return false;
		if (iNT03 != other.getINT03())
			return false;
		if (iNT04 != other.getINT04())
			return false;
		if (iNT05 != other.getINT05())
			return false;
		if (iNT06 != other.getINT06())
			return false;
		if (iNT07 != other.getINT07())
			return false;
		if (iNT08 != other.getINT08())
			return false;
		if (iNT09 != other.getINT09())
			return false;
		if (iNT10 != other.getINT10())
			return false;
		if (iNT11 != other.getINT11())
			return false;
		if (iNT12 != other.getINT12())
			return false;
		if (iNT13 != other.getINT13())
			return false;
		if (iNT14 != other.getINT14())
			return false;
		if (iNT15 != other.getINT15())
			return false;
		if (iNT16 != other.getINT16())
			return false;
		if (iNT17 != other.getINT17())
			return false;
		if (iNT18 != other.getINT18())
			return false;
		if (iNT19 != other.getINT19())
			return false;
		if (iNT20 != other.getINT20())
			return false;
		if (iNT21 != other.getINT21())
			return false;
		if (iNT22 != other.getINT22())
			return false;
		if (iNT23 != other.getINT23())
			return false;
		if (iNT24 != other.getINT24())
			return false;
		if (iNT25 != other.getINT25())
			return false;
		if (v1 == null && other.getV1() != null)
			return false;
		if (v1 != null && !v1.equals(other.getV1()))
			return false;
		if (v2 == null && other.getV2() != null)
			return false;
		if (v2 != null && !v2.equals(other.getV2()))
			return false;
		if (v3 == null && other.getV3() != null)
			return false;
		if (v3 != null && !v3.equals(other.getV3()))
			return false;
		if (v4 == null && other.getV4() != null)
			return false;
		if (v4 != null && !v4.equals(other.getV4()))
			return false;
		if (v5 == null && other.getV5() != null)
			return false;
		if (v5 != null && !v5.equals(other.getV5()))
			return false;
		if (v6 == null && other.getV6() != null)
			return false;
		if (v6 != null && !v6.equals(other.getV6()))
			return false;
		if (v7 == null && other.getV7() != null)
			return false;
		if (v7 != null && !v7.equals(other.getV7()))
			return false;
		if (v8 == null && other.getV8() != null)
			return false;
		if (v8 != null && !v8.equals(other.getV8()))
			return false;
		if (v9 == null && other.getV9() != null)
			return false;
		if (v9 != null && !v9.equals(other.getV9()))
			return false;
		if (v10 == null && other.getV10() != null)
			return false;
		if (v10 != null && !v10.equals(other.getV10()))
			return false;
		if (v11 == null && other.getV11() != null)
			return false;
		if (v11 != null && !v11.equals(other.getV11()))
			return false;
		if (v12 == null && other.getV12() != null)
			return false;
		if (v12 != null && !v12.equals(other.getV12()))
			return false;
		if (v13 == null && other.getV13() != null)
			return false;
		if (v13 != null && !v13.equals(other.getV13()))
			return false;
		if (v14 == null && other.getV14() != null)
			return false;
		if (v14 != null && !v14.equals(other.getV14()))
			return false;
		if (v15 == null && other.getV15() != null)
			return false;
		if (v15 != null && !v15.equals(other.getV15()))
			return false;
		if (v16 == null && other.getV16() != null)
			return false;
		if (v16 != null && !v16.equals(other.getV16()))
			return false;
		if (v17 == null && other.getV17() != null)
			return false;
		if (v17 != null && !v17.equals(other.getV17()))
			return false;
		if (v18 == null && other.getV18() != null)
			return false;
		if (v18 != null && !v18.equals(other.getV18()))
			return false;
		if (v19 == null && other.getV19() != null)
			return false;
		if (v19 != null && !v19.equals(other.getV19()))
			return false;
		if (v20 == null && other.getV20() != null)
			return false;
		if (v20 != null && !v20.equals(other.getV20()))
			return false;
		if (vT1 == null && other.getVT1() != null)
			return false;
		if (vT1 != null && !vT1.equals(other.getVT1()))
			return false;
		if (vT2 == null && other.getVT2() != null)
			return false;
		if (vT2 != null && !vT2.equals(other.getVT2()))
			return false;
		if (vT3 == null && other.getVT3() != null)
			return false;
		if (vT3 != null && !vT3.equals(other.getVT3()))
			return false;
		if (vT4 == null && other.getVT4() != null)
			return false;
		if (vT4 != null && !vT4.equals(other.getVT4()))
			return false;
		if (vT5 == null && other.getVT5() != null)
			return false;
		if (vT5 != null && !vT5.equals(other.getVT5()))
			return false;
		if (vT6 == null && other.getVT6() != null)
			return false;
		if (vT6 != null && !vT6.equals(other.getVT6()))
			return false;
		if (vT7 == null && other.getVT7() != null)
			return false;
		if (vT7 != null && !vT7.equals(other.getVT7()))
			return false;
		if (vT8 == null && other.getVT8() != null)
			return false;
		if (vT8 != null && !vT8.equals(other.getVT8()))
			return false;
		if (vE1 == null && other.getVE1() != null)
			return false;
		if (vE1 != null && !vE1.equals(other.getVE1()))
			return false;
		if (vE2 == null && other.getVE2() != null)
			return false;
		if (vE2 != null && !vE2.equals(other.getVE2()))
			return false;
		if (vE3 == null && other.getVE3() != null)
			return false;
		if (vE3 != null && !vE3.equals(other.getVE3()))
			return false;
		if (vE4 == null && other.getVE4() != null)
			return false;
		if (vE4 != null && !vE4.equals(other.getVE4()))
			return false;
		if (vE5 == null && other.getVE5() != null)
			return false;
		if (vE5 != null && !vE5.equals(other.getVE5()))
			return false;
		if (vE6 == null && other.getVE6() != null)
			return false;
		if (vE6 != null && !vE6.equals(other.getVE6()))
			return false;
		if (vE7 == null && other.getVE7() != null)
			return false;
		if (vE7 != null && !vE7.equals(other.getVE7()))
			return false;
		if (vE8 == null && other.getVE8() != null)
			return false;
		if (vE8 != null && !vE8.equals(other.getVE8()))
			return false;
		if (vE9 == null && other.getVE9() != null)
			return false;
		if (vE9 != null && !vE9.equals(other.getVE9()))
			return false;
		if (vE10 == null && other.getVE10() != null)
			return false;
		if (vE10 != null && !vE10.equals(other.getVE10()))
			return false;
		if (d1 == null && other.getD1() != null)
			return false;
		if (d1 != null && !fDate.getString(d1).equals(other.getD1()))
			return false;
		if (d2 == null && other.getD2() != null)
			return false;
		if (d2 != null && !fDate.getString(d2).equals(other.getD2()))
			return false;
		if (d3 == null && other.getD3() != null)
			return false;
		if (d3 != null && !fDate.getString(d3).equals(other.getD3()))
			return false;
		if (d4 == null && other.getD4() != null)
			return false;
		if (d4 != null && !fDate.getString(d4).equals(other.getD4()))
			return false;
		if (d5 == null && other.getD5() != null)
			return false;
		if (d5 != null && !fDate.getString(d5).equals(other.getD5()))
			return false;
		if (d6 == null && other.getD6() != null)
			return false;
		if (d6 != null && !fDate.getString(d6).equals(other.getD6()))
			return false;
		if (d7 == null && other.getD7() != null)
			return false;
		if (d7 != null && !fDate.getString(d7).equals(other.getD7()))
			return false;
		if (d8 == null && other.getD8() != null)
			return false;
		if (d8 != null && !fDate.getString(d8).equals(other.getD8()))
			return false;
		if (d9 == null && other.getD9() != null)
			return false;
		if (d9 != null && !fDate.getString(d9).equals(other.getD9()))
			return false;
		if (d10 == null && other.getD10() != null)
			return false;
		if (d10 != null && !fDate.getString(d10).equals(other.getD10()))
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
		return modifyTime == null || modifyTime.equals(other.getModifyTime());
	}

	public int getFieldCount()
	{
		return 207;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("indexCalNo"))
			return 0;
		if (strFieldName.equals("indexType"))
			return 1;
		if (strFieldName.equals("manageCom"))
			return 2;
		if (strFieldName.equals("agentGroup"))
			return 3;
		if (strFieldName.equals("branchAttr"))
			return 4;
		if (strFieldName.equals("agentCode"))
			return 5;
		if (strFieldName.equals("agentGrade"))
			return 6;
		if (strFieldName.equals("agentTitle"))
			return 7;
		if (strFieldName.equals("quaBgnMark"))
			return 8;
		if (strFieldName.equals("postMonths"))
			return 9;
		if (strFieldName.equals("assessMonth"))
			return 10;
		if (strFieldName.equals("agentGrade1"))
			return 11;
		if (strFieldName.equals("agentTitle1"))
			return 12;
		if (strFieldName.equals("agentGrade2"))
			return 13;
		if (strFieldName.equals("agentTitle2"))
			return 14;
		if (strFieldName.equals("agentGrade3"))
			return 15;
		if (strFieldName.equals("agentTitle3"))
			return 16;
		if (strFieldName.equals("startDate"))
			return 17;
		if (strFieldName.equals("startEnd"))
			return 18;
		if (strFieldName.equals("startDate1"))
			return 19;
		if (strFieldName.equals("startEnd1"))
			return 20;
		if (strFieldName.equals("startDate2"))
			return 21;
		if (strFieldName.equals("startEnd2"))
			return 22;
		if (strFieldName.equals("startDate3"))
			return 23;
		if (strFieldName.equals("startEnd3"))
			return 24;
		if (strFieldName.equals("startEnd4"))
			return 25;
		if (strFieldName.equals("startDate4"))
			return 26;
		if (strFieldName.equals("serverMonths"))
			return 27;
		if (strFieldName.equals("nT01"))
			return 28;
		if (strFieldName.equals("nT02"))
			return 29;
		if (strFieldName.equals("nT03"))
			return 30;
		if (strFieldName.equals("nT04"))
			return 31;
		if (strFieldName.equals("nT05"))
			return 32;
		if (strFieldName.equals("nT06"))
			return 33;
		if (strFieldName.equals("nT07"))
			return 34;
		if (strFieldName.equals("nT08"))
			return 35;
		if (strFieldName.equals("nT09"))
			return 36;
		if (strFieldName.equals("nT10"))
			return 37;
		if (strFieldName.equals("nT11"))
			return 38;
		if (strFieldName.equals("nT12"))
			return 39;
		if (strFieldName.equals("nT13"))
			return 40;
		if (strFieldName.equals("nT14"))
			return 41;
		if (strFieldName.equals("nT15"))
			return 42;
		if (strFieldName.equals("nT16"))
			return 43;
		if (strFieldName.equals("nT17"))
			return 44;
		if (strFieldName.equals("nT18"))
			return 45;
		if (strFieldName.equals("nT19"))
			return 46;
		if (strFieldName.equals("nT20"))
			return 47;
		if (strFieldName.equals("nT21"))
			return 48;
		if (strFieldName.equals("nT22"))
			return 49;
		if (strFieldName.equals("nT23"))
			return 50;
		if (strFieldName.equals("nT24"))
			return 51;
		if (strFieldName.equals("nT25"))
			return 52;
		if (strFieldName.equals("nT26"))
			return 53;
		if (strFieldName.equals("nT27"))
			return 54;
		if (strFieldName.equals("nT28"))
			return 55;
		if (strFieldName.equals("nT29"))
			return 56;
		if (strFieldName.equals("nT30"))
			return 57;
		if (strFieldName.equals("nT31"))
			return 58;
		if (strFieldName.equals("nT32"))
			return 59;
		if (strFieldName.equals("nT33"))
			return 60;
		if (strFieldName.equals("nT34"))
			return 61;
		if (strFieldName.equals("nT35"))
			return 62;
		if (strFieldName.equals("nT36"))
			return 63;
		if (strFieldName.equals("nT37"))
			return 64;
		if (strFieldName.equals("nT38"))
			return 65;
		if (strFieldName.equals("nT39"))
			return 66;
		if (strFieldName.equals("nT40"))
			return 67;
		if (strFieldName.equals("nT41"))
			return 68;
		if (strFieldName.equals("nT42"))
			return 69;
		if (strFieldName.equals("nT43"))
			return 70;
		if (strFieldName.equals("nT44"))
			return 71;
		if (strFieldName.equals("nT45"))
			return 72;
		if (strFieldName.equals("nT46"))
			return 73;
		if (strFieldName.equals("nT47"))
			return 74;
		if (strFieldName.equals("nT48"))
			return 75;
		if (strFieldName.equals("nT49"))
			return 76;
		if (strFieldName.equals("nT50"))
			return 77;
		if (strFieldName.equals("nT51"))
			return 78;
		if (strFieldName.equals("nT52"))
			return 79;
		if (strFieldName.equals("nT53"))
			return 80;
		if (strFieldName.equals("nT54"))
			return 81;
		if (strFieldName.equals("nT55"))
			return 82;
		if (strFieldName.equals("nT56"))
			return 83;
		if (strFieldName.equals("nT57"))
			return 84;
		if (strFieldName.equals("nT58"))
			return 85;
		if (strFieldName.equals("nT59"))
			return 86;
		if (strFieldName.equals("nT60"))
			return 87;
		if (strFieldName.equals("nT61"))
			return 88;
		if (strFieldName.equals("nT62"))
			return 89;
		if (strFieldName.equals("nT63"))
			return 90;
		if (strFieldName.equals("nT64"))
			return 91;
		if (strFieldName.equals("nT65"))
			return 92;
		if (strFieldName.equals("nT66"))
			return 93;
		if (strFieldName.equals("nT67"))
			return 94;
		if (strFieldName.equals("nT68"))
			return 95;
		if (strFieldName.equals("nT69"))
			return 96;
		if (strFieldName.equals("nT70"))
			return 97;
		if (strFieldName.equals("nT71"))
			return 98;
		if (strFieldName.equals("nT72"))
			return 99;
		if (strFieldName.equals("nT73"))
			return 100;
		if (strFieldName.equals("nT74"))
			return 101;
		if (strFieldName.equals("nT75"))
			return 102;
		if (strFieldName.equals("nT76"))
			return 103;
		if (strFieldName.equals("nT77"))
			return 104;
		if (strFieldName.equals("nT78"))
			return 105;
		if (strFieldName.equals("nT79"))
			return 106;
		if (strFieldName.equals("nT80"))
			return 107;
		if (strFieldName.equals("nF01"))
			return 108;
		if (strFieldName.equals("nF02"))
			return 109;
		if (strFieldName.equals("nF03"))
			return 110;
		if (strFieldName.equals("nF04"))
			return 111;
		if (strFieldName.equals("nF05"))
			return 112;
		if (strFieldName.equals("nF06"))
			return 113;
		if (strFieldName.equals("nF07"))
			return 114;
		if (strFieldName.equals("nF08"))
			return 115;
		if (strFieldName.equals("nF09"))
			return 116;
		if (strFieldName.equals("nF10"))
			return 117;
		if (strFieldName.equals("nS01"))
			return 118;
		if (strFieldName.equals("nS02"))
			return 119;
		if (strFieldName.equals("nS03"))
			return 120;
		if (strFieldName.equals("nS04"))
			return 121;
		if (strFieldName.equals("nS05"))
			return 122;
		if (strFieldName.equals("nS06"))
			return 123;
		if (strFieldName.equals("nS07"))
			return 124;
		if (strFieldName.equals("nS08"))
			return 125;
		if (strFieldName.equals("nS09"))
			return 126;
		if (strFieldName.equals("nS10"))
			return 127;
		if (strFieldName.equals("iNT01"))
			return 128;
		if (strFieldName.equals("iNT02"))
			return 129;
		if (strFieldName.equals("iNT03"))
			return 130;
		if (strFieldName.equals("iNT04"))
			return 131;
		if (strFieldName.equals("iNT05"))
			return 132;
		if (strFieldName.equals("iNT06"))
			return 133;
		if (strFieldName.equals("iNT07"))
			return 134;
		if (strFieldName.equals("iNT08"))
			return 135;
		if (strFieldName.equals("iNT09"))
			return 136;
		if (strFieldName.equals("iNT10"))
			return 137;
		if (strFieldName.equals("iNT11"))
			return 138;
		if (strFieldName.equals("iNT12"))
			return 139;
		if (strFieldName.equals("iNT13"))
			return 140;
		if (strFieldName.equals("iNT14"))
			return 141;
		if (strFieldName.equals("iNT15"))
			return 142;
		if (strFieldName.equals("iNT16"))
			return 143;
		if (strFieldName.equals("iNT17"))
			return 144;
		if (strFieldName.equals("iNT18"))
			return 145;
		if (strFieldName.equals("iNT19"))
			return 146;
		if (strFieldName.equals("iNT20"))
			return 147;
		if (strFieldName.equals("iNT21"))
			return 148;
		if (strFieldName.equals("iNT22"))
			return 149;
		if (strFieldName.equals("iNT23"))
			return 150;
		if (strFieldName.equals("iNT24"))
			return 151;
		if (strFieldName.equals("iNT25"))
			return 152;
		if (strFieldName.equals("v1"))
			return 153;
		if (strFieldName.equals("v2"))
			return 154;
		if (strFieldName.equals("v3"))
			return 155;
		if (strFieldName.equals("v4"))
			return 156;
		if (strFieldName.equals("v5"))
			return 157;
		if (strFieldName.equals("v6"))
			return 158;
		if (strFieldName.equals("v7"))
			return 159;
		if (strFieldName.equals("v8"))
			return 160;
		if (strFieldName.equals("v9"))
			return 161;
		if (strFieldName.equals("v10"))
			return 162;
		if (strFieldName.equals("v11"))
			return 163;
		if (strFieldName.equals("v12"))
			return 164;
		if (strFieldName.equals("v13"))
			return 165;
		if (strFieldName.equals("v14"))
			return 166;
		if (strFieldName.equals("v15"))
			return 167;
		if (strFieldName.equals("v16"))
			return 168;
		if (strFieldName.equals("v17"))
			return 169;
		if (strFieldName.equals("v18"))
			return 170;
		if (strFieldName.equals("v19"))
			return 171;
		if (strFieldName.equals("v20"))
			return 172;
		if (strFieldName.equals("vT1"))
			return 173;
		if (strFieldName.equals("vT2"))
			return 174;
		if (strFieldName.equals("vT3"))
			return 175;
		if (strFieldName.equals("vT4"))
			return 176;
		if (strFieldName.equals("vT5"))
			return 177;
		if (strFieldName.equals("vT6"))
			return 178;
		if (strFieldName.equals("vT7"))
			return 179;
		if (strFieldName.equals("vT8"))
			return 180;
		if (strFieldName.equals("vE1"))
			return 181;
		if (strFieldName.equals("vE2"))
			return 182;
		if (strFieldName.equals("vE3"))
			return 183;
		if (strFieldName.equals("vE4"))
			return 184;
		if (strFieldName.equals("vE5"))
			return 185;
		if (strFieldName.equals("vE6"))
			return 186;
		if (strFieldName.equals("vE7"))
			return 187;
		if (strFieldName.equals("vE8"))
			return 188;
		if (strFieldName.equals("vE9"))
			return 189;
		if (strFieldName.equals("vE10"))
			return 190;
		if (strFieldName.equals("d1"))
			return 191;
		if (strFieldName.equals("d2"))
			return 192;
		if (strFieldName.equals("d3"))
			return 193;
		if (strFieldName.equals("d4"))
			return 194;
		if (strFieldName.equals("d5"))
			return 195;
		if (strFieldName.equals("d6"))
			return 196;
		if (strFieldName.equals("d7"))
			return 197;
		if (strFieldName.equals("d8"))
			return 198;
		if (strFieldName.equals("d9"))
			return 199;
		if (strFieldName.equals("d10"))
			return 200;
		if (strFieldName.equals("state"))
			return 201;
		if (strFieldName.equals("operator"))
			return 202;
		if (strFieldName.equals("makeDate"))
			return 203;
		if (strFieldName.equals("makeTime"))
			return 204;
		if (strFieldName.equals("modifyDate"))
			return 205;
		return !strFieldName.equals("modifyTime") ? -1 : 206;
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
			strFieldName = "manageCom";
			break;

		case 3: // '\003'
			strFieldName = "agentGroup";
			break;

		case 4: // '\004'
			strFieldName = "branchAttr";
			break;

		case 5: // '\005'
			strFieldName = "agentCode";
			break;

		case 6: // '\006'
			strFieldName = "agentGrade";
			break;

		case 7: // '\007'
			strFieldName = "agentTitle";
			break;

		case 8: // '\b'
			strFieldName = "quaBgnMark";
			break;

		case 9: // '\t'
			strFieldName = "postMonths";
			break;

		case 10: // '\n'
			strFieldName = "assessMonth";
			break;

		case 11: // '\013'
			strFieldName = "agentGrade1";
			break;

		case 12: // '\f'
			strFieldName = "agentTitle1";
			break;

		case 13: // '\r'
			strFieldName = "agentGrade2";
			break;

		case 14: // '\016'
			strFieldName = "agentTitle2";
			break;

		case 15: // '\017'
			strFieldName = "agentGrade3";
			break;

		case 16: // '\020'
			strFieldName = "agentTitle3";
			break;

		case 17: // '\021'
			strFieldName = "startDate";
			break;

		case 18: // '\022'
			strFieldName = "startEnd";
			break;

		case 19: // '\023'
			strFieldName = "startDate1";
			break;

		case 20: // '\024'
			strFieldName = "startEnd1";
			break;

		case 21: // '\025'
			strFieldName = "startDate2";
			break;

		case 22: // '\026'
			strFieldName = "startEnd2";
			break;

		case 23: // '\027'
			strFieldName = "startDate3";
			break;

		case 24: // '\030'
			strFieldName = "startEnd3";
			break;

		case 25: // '\031'
			strFieldName = "startEnd4";
			break;

		case 26: // '\032'
			strFieldName = "startDate4";
			break;

		case 27: // '\033'
			strFieldName = "serverMonths";
			break;

		case 28: // '\034'
			strFieldName = "nT01";
			break;

		case 29: // '\035'
			strFieldName = "nT02";
			break;

		case 30: // '\036'
			strFieldName = "nT03";
			break;

		case 31: // '\037'
			strFieldName = "nT04";
			break;

		case 32: // ' '
			strFieldName = "nT05";
			break;

		case 33: // '!'
			strFieldName = "nT06";
			break;

		case 34: // '"'
			strFieldName = "nT07";
			break;

		case 35: // '#'
			strFieldName = "nT08";
			break;

		case 36: // '$'
			strFieldName = "nT09";
			break;

		case 37: // '%'
			strFieldName = "nT10";
			break;

		case 38: // '&'
			strFieldName = "nT11";
			break;

		case 39: // '\''
			strFieldName = "nT12";
			break;

		case 40: // '('
			strFieldName = "nT13";
			break;

		case 41: // ')'
			strFieldName = "nT14";
			break;

		case 42: // '*'
			strFieldName = "nT15";
			break;

		case 43: // '+'
			strFieldName = "nT16";
			break;

		case 44: // ','
			strFieldName = "nT17";
			break;

		case 45: // '-'
			strFieldName = "nT18";
			break;

		case 46: // '.'
			strFieldName = "nT19";
			break;

		case 47: // '/'
			strFieldName = "nT20";
			break;

		case 48: // '0'
			strFieldName = "nT21";
			break;

		case 49: // '1'
			strFieldName = "nT22";
			break;

		case 50: // '2'
			strFieldName = "nT23";
			break;

		case 51: // '3'
			strFieldName = "nT24";
			break;

		case 52: // '4'
			strFieldName = "nT25";
			break;

		case 53: // '5'
			strFieldName = "nT26";
			break;

		case 54: // '6'
			strFieldName = "nT27";
			break;

		case 55: // '7'
			strFieldName = "nT28";
			break;

		case 56: // '8'
			strFieldName = "nT29";
			break;

		case 57: // '9'
			strFieldName = "nT30";
			break;

		case 58: // ':'
			strFieldName = "nT31";
			break;

		case 59: // ';'
			strFieldName = "nT32";
			break;

		case 60: // '<'
			strFieldName = "nT33";
			break;

		case 61: // '='
			strFieldName = "nT34";
			break;

		case 62: // '>'
			strFieldName = "nT35";
			break;

		case 63: // '?'
			strFieldName = "nT36";
			break;

		case 64: // '@'
			strFieldName = "nT37";
			break;

		case 65: // 'A'
			strFieldName = "nT38";
			break;

		case 66: // 'B'
			strFieldName = "nT39";
			break;

		case 67: // 'C'
			strFieldName = "nT40";
			break;

		case 68: // 'D'
			strFieldName = "nT41";
			break;

		case 69: // 'E'
			strFieldName = "nT42";
			break;

		case 70: // 'F'
			strFieldName = "nT43";
			break;

		case 71: // 'G'
			strFieldName = "nT44";
			break;

		case 72: // 'H'
			strFieldName = "nT45";
			break;

		case 73: // 'I'
			strFieldName = "nT46";
			break;

		case 74: // 'J'
			strFieldName = "nT47";
			break;

		case 75: // 'K'
			strFieldName = "nT48";
			break;

		case 76: // 'L'
			strFieldName = "nT49";
			break;

		case 77: // 'M'
			strFieldName = "nT50";
			break;

		case 78: // 'N'
			strFieldName = "nT51";
			break;

		case 79: // 'O'
			strFieldName = "nT52";
			break;

		case 80: // 'P'
			strFieldName = "nT53";
			break;

		case 81: // 'Q'
			strFieldName = "nT54";
			break;

		case 82: // 'R'
			strFieldName = "nT55";
			break;

		case 83: // 'S'
			strFieldName = "nT56";
			break;

		case 84: // 'T'
			strFieldName = "nT57";
			break;

		case 85: // 'U'
			strFieldName = "nT58";
			break;

		case 86: // 'V'
			strFieldName = "nT59";
			break;

		case 87: // 'W'
			strFieldName = "nT60";
			break;

		case 88: // 'X'
			strFieldName = "nT61";
			break;

		case 89: // 'Y'
			strFieldName = "nT62";
			break;

		case 90: // 'Z'
			strFieldName = "nT63";
			break;

		case 91: // '['
			strFieldName = "nT64";
			break;

		case 92: // '\\'
			strFieldName = "nT65";
			break;

		case 93: // ']'
			strFieldName = "nT66";
			break;

		case 94: // '^'
			strFieldName = "nT67";
			break;

		case 95: // '_'
			strFieldName = "nT68";
			break;

		case 96: // '`'
			strFieldName = "nT69";
			break;

		case 97: // 'a'
			strFieldName = "nT70";
			break;

		case 98: // 'b'
			strFieldName = "nT71";
			break;

		case 99: // 'c'
			strFieldName = "nT72";
			break;

		case 100: // 'd'
			strFieldName = "nT73";
			break;

		case 101: // 'e'
			strFieldName = "nT74";
			break;

		case 102: // 'f'
			strFieldName = "nT75";
			break;

		case 103: // 'g'
			strFieldName = "nT76";
			break;

		case 104: // 'h'
			strFieldName = "nT77";
			break;

		case 105: // 'i'
			strFieldName = "nT78";
			break;

		case 106: // 'j'
			strFieldName = "nT79";
			break;

		case 107: // 'k'
			strFieldName = "nT80";
			break;

		case 108: // 'l'
			strFieldName = "nF01";
			break;

		case 109: // 'm'
			strFieldName = "nF02";
			break;

		case 110: // 'n'
			strFieldName = "nF03";
			break;

		case 111: // 'o'
			strFieldName = "nF04";
			break;

		case 112: // 'p'
			strFieldName = "nF05";
			break;

		case 113: // 'q'
			strFieldName = "nF06";
			break;

		case 114: // 'r'
			strFieldName = "nF07";
			break;

		case 115: // 's'
			strFieldName = "nF08";
			break;

		case 116: // 't'
			strFieldName = "nF09";
			break;

		case 117: // 'u'
			strFieldName = "nF10";
			break;

		case 118: // 'v'
			strFieldName = "nS01";
			break;

		case 119: // 'w'
			strFieldName = "nS02";
			break;

		case 120: // 'x'
			strFieldName = "nS03";
			break;

		case 121: // 'y'
			strFieldName = "nS04";
			break;

		case 122: // 'z'
			strFieldName = "nS05";
			break;

		case 123: // '{'
			strFieldName = "nS06";
			break;

		case 124: // '|'
			strFieldName = "nS07";
			break;

		case 125: // '}'
			strFieldName = "nS08";
			break;

		case 126: // '~'
			strFieldName = "nS09";
			break;

		case 127: // '\177'
			strFieldName = "nS10";
			break;

		case 128: 
			strFieldName = "iNT01";
			break;

		case 129: 
			strFieldName = "iNT02";
			break;

		case 130: 
			strFieldName = "iNT03";
			break;

		case 131: 
			strFieldName = "iNT04";
			break;

		case 132: 
			strFieldName = "iNT05";
			break;

		case 133: 
			strFieldName = "iNT06";
			break;

		case 134: 
			strFieldName = "iNT07";
			break;

		case 135: 
			strFieldName = "iNT08";
			break;

		case 136: 
			strFieldName = "iNT09";
			break;

		case 137: 
			strFieldName = "iNT10";
			break;

		case 138: 
			strFieldName = "iNT11";
			break;

		case 139: 
			strFieldName = "iNT12";
			break;

		case 140: 
			strFieldName = "iNT13";
			break;

		case 141: 
			strFieldName = "iNT14";
			break;

		case 142: 
			strFieldName = "iNT15";
			break;

		case 143: 
			strFieldName = "iNT16";
			break;

		case 144: 
			strFieldName = "iNT17";
			break;

		case 145: 
			strFieldName = "iNT18";
			break;

		case 146: 
			strFieldName = "iNT19";
			break;

		case 147: 
			strFieldName = "iNT20";
			break;

		case 148: 
			strFieldName = "iNT21";
			break;

		case 149: 
			strFieldName = "iNT22";
			break;

		case 150: 
			strFieldName = "iNT23";
			break;

		case 151: 
			strFieldName = "iNT24";
			break;

		case 152: 
			strFieldName = "iNT25";
			break;

		case 153: 
			strFieldName = "v1";
			break;

		case 154: 
			strFieldName = "v2";
			break;

		case 155: 
			strFieldName = "v3";
			break;

		case 156: 
			strFieldName = "v4";
			break;

		case 157: 
			strFieldName = "v5";
			break;

		case 158: 
			strFieldName = "v6";
			break;

		case 159: 
			strFieldName = "v7";
			break;

		case 160: 
			strFieldName = "v8";
			break;

		case 161: 
			strFieldName = "v9";
			break;

		case 162: 
			strFieldName = "v10";
			break;

		case 163: 
			strFieldName = "v11";
			break;

		case 164: 
			strFieldName = "v12";
			break;

		case 165: 
			strFieldName = "v13";
			break;

		case 166: 
			strFieldName = "v14";
			break;

		case 167: 
			strFieldName = "v15";
			break;

		case 168: 
			strFieldName = "v16";
			break;

		case 169: 
			strFieldName = "v17";
			break;

		case 170: 
			strFieldName = "v18";
			break;

		case 171: 
			strFieldName = "v19";
			break;

		case 172: 
			strFieldName = "v20";
			break;

		case 173: 
			strFieldName = "vT1";
			break;

		case 174: 
			strFieldName = "vT2";
			break;

		case 175: 
			strFieldName = "vT3";
			break;

		case 176: 
			strFieldName = "vT4";
			break;

		case 177: 
			strFieldName = "vT5";
			break;

		case 178: 
			strFieldName = "vT6";
			break;

		case 179: 
			strFieldName = "vT7";
			break;

		case 180: 
			strFieldName = "vT8";
			break;

		case 181: 
			strFieldName = "vE1";
			break;

		case 182: 
			strFieldName = "vE2";
			break;

		case 183: 
			strFieldName = "vE3";
			break;

		case 184: 
			strFieldName = "vE4";
			break;

		case 185: 
			strFieldName = "vE5";
			break;

		case 186: 
			strFieldName = "vE6";
			break;

		case 187: 
			strFieldName = "vE7";
			break;

		case 188: 
			strFieldName = "vE8";
			break;

		case 189: 
			strFieldName = "vE9";
			break;

		case 190: 
			strFieldName = "vE10";
			break;

		case 191: 
			strFieldName = "d1";
			break;

		case 192: 
			strFieldName = "d2";
			break;

		case 193: 
			strFieldName = "d3";
			break;

		case 194: 
			strFieldName = "d4";
			break;

		case 195: 
			strFieldName = "d5";
			break;

		case 196: 
			strFieldName = "d6";
			break;

		case 197: 
			strFieldName = "d7";
			break;

		case 198: 
			strFieldName = "d8";
			break;

		case 199: 
			strFieldName = "d9";
			break;

		case 200: 
			strFieldName = "d10";
			break;

		case 201: 
			strFieldName = "state";
			break;

		case 202: 
			strFieldName = "operator";
			break;

		case 203: 
			strFieldName = "makeDate";
			break;

		case 204: 
			strFieldName = "makeTime";
			break;

		case 205: 
			strFieldName = "modifyDate";
			break;

		case 206: 
			strFieldName = "modifyTime";
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
		if (strFieldName.equals("manageCom"))
			return 0;
		if (strFieldName.equals("agentGroup"))
			return 0;
		if (strFieldName.equals("branchAttr"))
			return 0;
		if (strFieldName.equals("agentCode"))
			return 0;
		if (strFieldName.equals("agentGrade"))
			return 0;
		if (strFieldName.equals("agentTitle"))
			return 0;
		if (strFieldName.equals("quaBgnMark"))
			return 3;
		if (strFieldName.equals("postMonths"))
			return 3;
		if (strFieldName.equals("assessMonth"))
			return 0;
		if (strFieldName.equals("agentGrade1"))
			return 0;
		if (strFieldName.equals("agentTitle1"))
			return 0;
		if (strFieldName.equals("agentGrade2"))
			return 0;
		if (strFieldName.equals("agentTitle2"))
			return 0;
		if (strFieldName.equals("agentGrade3"))
			return 0;
		if (strFieldName.equals("agentTitle3"))
			return 0;
		if (strFieldName.equals("startDate"))
			return 1;
		if (strFieldName.equals("startEnd"))
			return 1;
		if (strFieldName.equals("startDate1"))
			return 1;
		if (strFieldName.equals("startEnd1"))
			return 1;
		if (strFieldName.equals("startDate2"))
			return 1;
		if (strFieldName.equals("startEnd2"))
			return 1;
		if (strFieldName.equals("startDate3"))
			return 1;
		if (strFieldName.equals("startEnd3"))
			return 1;
		if (strFieldName.equals("startEnd4"))
			return 1;
		if (strFieldName.equals("startDate4"))
			return 1;
		if (strFieldName.equals("serverMonths"))
			return 3;
		if (strFieldName.equals("nT01"))
			return 4;
		if (strFieldName.equals("nT02"))
			return 4;
		if (strFieldName.equals("nT03"))
			return 4;
		if (strFieldName.equals("nT04"))
			return 4;
		if (strFieldName.equals("nT05"))
			return 4;
		if (strFieldName.equals("nT06"))
			return 4;
		if (strFieldName.equals("nT07"))
			return 4;
		if (strFieldName.equals("nT08"))
			return 4;
		if (strFieldName.equals("nT09"))
			return 4;
		if (strFieldName.equals("nT10"))
			return 4;
		if (strFieldName.equals("nT11"))
			return 4;
		if (strFieldName.equals("nT12"))
			return 4;
		if (strFieldName.equals("nT13"))
			return 4;
		if (strFieldName.equals("nT14"))
			return 4;
		if (strFieldName.equals("nT15"))
			return 4;
		if (strFieldName.equals("nT16"))
			return 4;
		if (strFieldName.equals("nT17"))
			return 4;
		if (strFieldName.equals("nT18"))
			return 4;
		if (strFieldName.equals("nT19"))
			return 4;
		if (strFieldName.equals("nT20"))
			return 4;
		if (strFieldName.equals("nT21"))
			return 4;
		if (strFieldName.equals("nT22"))
			return 4;
		if (strFieldName.equals("nT23"))
			return 4;
		if (strFieldName.equals("nT24"))
			return 4;
		if (strFieldName.equals("nT25"))
			return 4;
		if (strFieldName.equals("nT26"))
			return 4;
		if (strFieldName.equals("nT27"))
			return 4;
		if (strFieldName.equals("nT28"))
			return 4;
		if (strFieldName.equals("nT29"))
			return 4;
		if (strFieldName.equals("nT30"))
			return 4;
		if (strFieldName.equals("nT31"))
			return 4;
		if (strFieldName.equals("nT32"))
			return 4;
		if (strFieldName.equals("nT33"))
			return 4;
		if (strFieldName.equals("nT34"))
			return 4;
		if (strFieldName.equals("nT35"))
			return 4;
		if (strFieldName.equals("nT36"))
			return 4;
		if (strFieldName.equals("nT37"))
			return 4;
		if (strFieldName.equals("nT38"))
			return 4;
		if (strFieldName.equals("nT39"))
			return 4;
		if (strFieldName.equals("nT40"))
			return 4;
		if (strFieldName.equals("nT41"))
			return 4;
		if (strFieldName.equals("nT42"))
			return 4;
		if (strFieldName.equals("nT43"))
			return 4;
		if (strFieldName.equals("nT44"))
			return 4;
		if (strFieldName.equals("nT45"))
			return 4;
		if (strFieldName.equals("nT46"))
			return 4;
		if (strFieldName.equals("nT47"))
			return 4;
		if (strFieldName.equals("nT48"))
			return 4;
		if (strFieldName.equals("nT49"))
			return 4;
		if (strFieldName.equals("nT50"))
			return 4;
		if (strFieldName.equals("nT51"))
			return 4;
		if (strFieldName.equals("nT52"))
			return 4;
		if (strFieldName.equals("nT53"))
			return 4;
		if (strFieldName.equals("nT54"))
			return 4;
		if (strFieldName.equals("nT55"))
			return 4;
		if (strFieldName.equals("nT56"))
			return 4;
		if (strFieldName.equals("nT57"))
			return 4;
		if (strFieldName.equals("nT58"))
			return 4;
		if (strFieldName.equals("nT59"))
			return 4;
		if (strFieldName.equals("nT60"))
			return 4;
		if (strFieldName.equals("nT61"))
			return 4;
		if (strFieldName.equals("nT62"))
			return 4;
		if (strFieldName.equals("nT63"))
			return 4;
		if (strFieldName.equals("nT64"))
			return 4;
		if (strFieldName.equals("nT65"))
			return 4;
		if (strFieldName.equals("nT66"))
			return 4;
		if (strFieldName.equals("nT67"))
			return 4;
		if (strFieldName.equals("nT68"))
			return 4;
		if (strFieldName.equals("nT69"))
			return 4;
		if (strFieldName.equals("nT70"))
			return 4;
		if (strFieldName.equals("nT71"))
			return 4;
		if (strFieldName.equals("nT72"))
			return 4;
		if (strFieldName.equals("nT73"))
			return 4;
		if (strFieldName.equals("nT74"))
			return 4;
		if (strFieldName.equals("nT75"))
			return 4;
		if (strFieldName.equals("nT76"))
			return 4;
		if (strFieldName.equals("nT77"))
			return 4;
		if (strFieldName.equals("nT78"))
			return 4;
		if (strFieldName.equals("nT79"))
			return 4;
		if (strFieldName.equals("nT80"))
			return 4;
		if (strFieldName.equals("nF01"))
			return 4;
		if (strFieldName.equals("nF02"))
			return 4;
		if (strFieldName.equals("nF03"))
			return 4;
		if (strFieldName.equals("nF04"))
			return 4;
		if (strFieldName.equals("nF05"))
			return 4;
		if (strFieldName.equals("nF06"))
			return 4;
		if (strFieldName.equals("nF07"))
			return 4;
		if (strFieldName.equals("nF08"))
			return 4;
		if (strFieldName.equals("nF09"))
			return 4;
		if (strFieldName.equals("nF10"))
			return 4;
		if (strFieldName.equals("nS01"))
			return 4;
		if (strFieldName.equals("nS02"))
			return 4;
		if (strFieldName.equals("nS03"))
			return 4;
		if (strFieldName.equals("nS04"))
			return 4;
		if (strFieldName.equals("nS05"))
			return 4;
		if (strFieldName.equals("nS06"))
			return 4;
		if (strFieldName.equals("nS07"))
			return 4;
		if (strFieldName.equals("nS08"))
			return 4;
		if (strFieldName.equals("nS09"))
			return 4;
		if (strFieldName.equals("nS10"))
			return 4;
		if (strFieldName.equals("iNT01"))
			return 3;
		if (strFieldName.equals("iNT02"))
			return 3;
		if (strFieldName.equals("iNT03"))
			return 3;
		if (strFieldName.equals("iNT04"))
			return 3;
		if (strFieldName.equals("iNT05"))
			return 3;
		if (strFieldName.equals("iNT06"))
			return 3;
		if (strFieldName.equals("iNT07"))
			return 3;
		if (strFieldName.equals("iNT08"))
			return 3;
		if (strFieldName.equals("iNT09"))
			return 3;
		if (strFieldName.equals("iNT10"))
			return 3;
		if (strFieldName.equals("iNT11"))
			return 3;
		if (strFieldName.equals("iNT12"))
			return 3;
		if (strFieldName.equals("iNT13"))
			return 3;
		if (strFieldName.equals("iNT14"))
			return 3;
		if (strFieldName.equals("iNT15"))
			return 3;
		if (strFieldName.equals("iNT16"))
			return 3;
		if (strFieldName.equals("iNT17"))
			return 3;
		if (strFieldName.equals("iNT18"))
			return 3;
		if (strFieldName.equals("iNT19"))
			return 3;
		if (strFieldName.equals("iNT20"))
			return 3;
		if (strFieldName.equals("iNT21"))
			return 3;
		if (strFieldName.equals("iNT22"))
			return 3;
		if (strFieldName.equals("iNT23"))
			return 3;
		if (strFieldName.equals("iNT24"))
			return 3;
		if (strFieldName.equals("iNT25"))
			return 3;
		if (strFieldName.equals("v1"))
			return 0;
		if (strFieldName.equals("v2"))
			return 0;
		if (strFieldName.equals("v3"))
			return 0;
		if (strFieldName.equals("v4"))
			return 0;
		if (strFieldName.equals("v5"))
			return 0;
		if (strFieldName.equals("v6"))
			return 0;
		if (strFieldName.equals("v7"))
			return 0;
		if (strFieldName.equals("v8"))
			return 0;
		if (strFieldName.equals("v9"))
			return 0;
		if (strFieldName.equals("v10"))
			return 0;
		if (strFieldName.equals("v11"))
			return 0;
		if (strFieldName.equals("v12"))
			return 0;
		if (strFieldName.equals("v13"))
			return 0;
		if (strFieldName.equals("v14"))
			return 0;
		if (strFieldName.equals("v15"))
			return 0;
		if (strFieldName.equals("v16"))
			return 0;
		if (strFieldName.equals("v17"))
			return 0;
		if (strFieldName.equals("v18"))
			return 0;
		if (strFieldName.equals("v19"))
			return 0;
		if (strFieldName.equals("v20"))
			return 0;
		if (strFieldName.equals("vT1"))
			return 0;
		if (strFieldName.equals("vT2"))
			return 0;
		if (strFieldName.equals("vT3"))
			return 0;
		if (strFieldName.equals("vT4"))
			return 0;
		if (strFieldName.equals("vT5"))
			return 0;
		if (strFieldName.equals("vT6"))
			return 0;
		if (strFieldName.equals("vT7"))
			return 0;
		if (strFieldName.equals("vT8"))
			return 0;
		if (strFieldName.equals("vE1"))
			return 0;
		if (strFieldName.equals("vE2"))
			return 0;
		if (strFieldName.equals("vE3"))
			return 0;
		if (strFieldName.equals("vE4"))
			return 0;
		if (strFieldName.equals("vE5"))
			return 0;
		if (strFieldName.equals("vE6"))
			return 0;
		if (strFieldName.equals("vE7"))
			return 0;
		if (strFieldName.equals("vE8"))
			return 0;
		if (strFieldName.equals("vE9"))
			return 0;
		if (strFieldName.equals("vE10"))
			return 0;
		if (strFieldName.equals("d1"))
			return 1;
		if (strFieldName.equals("d2"))
			return 1;
		if (strFieldName.equals("d3"))
			return 1;
		if (strFieldName.equals("d4"))
			return 1;
		if (strFieldName.equals("d5"))
			return 1;
		if (strFieldName.equals("d6"))
			return 1;
		if (strFieldName.equals("d7"))
			return 1;
		if (strFieldName.equals("d8"))
			return 1;
		if (strFieldName.equals("d9"))
			return 1;
		if (strFieldName.equals("d10"))
			return 1;
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
		return !strFieldName.equals("modifyTime") ? -1 : 0;
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
			nFieldType = 0;
			break;

		case 6: // '\006'
			nFieldType = 0;
			break;

		case 7: // '\007'
			nFieldType = 0;
			break;

		case 8: // '\b'
			nFieldType = 3;
			break;

		case 9: // '\t'
			nFieldType = 3;
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
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 1;
			break;

		case 18: // '\022'
			nFieldType = 1;
			break;

		case 19: // '\023'
			nFieldType = 1;
			break;

		case 20: // '\024'
			nFieldType = 1;
			break;

		case 21: // '\025'
			nFieldType = 1;
			break;

		case 22: // '\026'
			nFieldType = 1;
			break;

		case 23: // '\027'
			nFieldType = 1;
			break;

		case 24: // '\030'
			nFieldType = 1;
			break;

		case 25: // '\031'
			nFieldType = 1;
			break;

		case 26: // '\032'
			nFieldType = 1;
			break;

		case 27: // '\033'
			nFieldType = 3;
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
			nFieldType = 4;
			break;

		case 120: // 'x'
			nFieldType = 4;
			break;

		case 121: // 'y'
			nFieldType = 4;
			break;

		case 122: // 'z'
			nFieldType = 4;
			break;

		case 123: // '{'
			nFieldType = 4;
			break;

		case 124: // '|'
			nFieldType = 4;
			break;

		case 125: // '}'
			nFieldType = 4;
			break;

		case 126: // '~'
			nFieldType = 4;
			break;

		case 127: // '\177'
			nFieldType = 4;
			break;

		case 128: 
			nFieldType = 3;
			break;

		case 129: 
			nFieldType = 3;
			break;

		case 130: 
			nFieldType = 3;
			break;

		case 131: 
			nFieldType = 3;
			break;

		case 132: 
			nFieldType = 3;
			break;

		case 133: 
			nFieldType = 3;
			break;

		case 134: 
			nFieldType = 3;
			break;

		case 135: 
			nFieldType = 3;
			break;

		case 136: 
			nFieldType = 3;
			break;

		case 137: 
			nFieldType = 3;
			break;

		case 138: 
			nFieldType = 3;
			break;

		case 139: 
			nFieldType = 3;
			break;

		case 140: 
			nFieldType = 3;
			break;

		case 141: 
			nFieldType = 3;
			break;

		case 142: 
			nFieldType = 3;
			break;

		case 143: 
			nFieldType = 3;
			break;

		case 144: 
			nFieldType = 3;
			break;

		case 145: 
			nFieldType = 3;
			break;

		case 146: 
			nFieldType = 3;
			break;

		case 147: 
			nFieldType = 3;
			break;

		case 148: 
			nFieldType = 3;
			break;

		case 149: 
			nFieldType = 3;
			break;

		case 150: 
			nFieldType = 3;
			break;

		case 151: 
			nFieldType = 3;
			break;

		case 152: 
			nFieldType = 3;
			break;

		case 153: 
			nFieldType = 0;
			break;

		case 154: 
			nFieldType = 0;
			break;

		case 155: 
			nFieldType = 0;
			break;

		case 156: 
			nFieldType = 0;
			break;

		case 157: 
			nFieldType = 0;
			break;

		case 158: 
			nFieldType = 0;
			break;

		case 159: 
			nFieldType = 0;
			break;

		case 160: 
			nFieldType = 0;
			break;

		case 161: 
			nFieldType = 0;
			break;

		case 162: 
			nFieldType = 0;
			break;

		case 163: 
			nFieldType = 0;
			break;

		case 164: 
			nFieldType = 0;
			break;

		case 165: 
			nFieldType = 0;
			break;

		case 166: 
			nFieldType = 0;
			break;

		case 167: 
			nFieldType = 0;
			break;

		case 168: 
			nFieldType = 0;
			break;

		case 169: 
			nFieldType = 0;
			break;

		case 170: 
			nFieldType = 0;
			break;

		case 171: 
			nFieldType = 0;
			break;

		case 172: 
			nFieldType = 0;
			break;

		case 173: 
			nFieldType = 0;
			break;

		case 174: 
			nFieldType = 0;
			break;

		case 175: 
			nFieldType = 0;
			break;

		case 176: 
			nFieldType = 0;
			break;

		case 177: 
			nFieldType = 0;
			break;

		case 178: 
			nFieldType = 0;
			break;

		case 179: 
			nFieldType = 0;
			break;

		case 180: 
			nFieldType = 0;
			break;

		case 181: 
			nFieldType = 0;
			break;

		case 182: 
			nFieldType = 0;
			break;

		case 183: 
			nFieldType = 0;
			break;

		case 184: 
			nFieldType = 0;
			break;

		case 185: 
			nFieldType = 0;
			break;

		case 186: 
			nFieldType = 0;
			break;

		case 187: 
			nFieldType = 0;
			break;

		case 188: 
			nFieldType = 0;
			break;

		case 189: 
			nFieldType = 0;
			break;

		case 190: 
			nFieldType = 0;
			break;

		case 191: 
			nFieldType = 1;
			break;

		case 192: 
			nFieldType = 1;
			break;

		case 193: 
			nFieldType = 1;
			break;

		case 194: 
			nFieldType = 1;
			break;

		case 195: 
			nFieldType = 1;
			break;

		case 196: 
			nFieldType = 1;
			break;

		case 197: 
			nFieldType = 1;
			break;

		case 198: 
			nFieldType = 1;
			break;

		case 199: 
			nFieldType = 1;
			break;

		case 200: 
			nFieldType = 1;
			break;

		case 201: 
			nFieldType = 0;
			break;

		case 202: 
			nFieldType = 0;
			break;

		case 203: 
			nFieldType = 1;
			break;

		case 204: 
			nFieldType = 0;
			break;

		case 205: 
			nFieldType = 1;
			break;

		case 206: 
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
