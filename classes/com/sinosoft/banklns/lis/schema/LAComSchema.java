// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LAComSchema.java

package com.sinosoft.banklns.lis.schema;

import com.sinosoft.banklns.lis.db.LAComDB;
import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.utility.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LAComSchema
	implements Schema
{

	private String AGENTCOM;
	private String MANAGECOM;
	private String AREATYPE;
	private String CHANNELTYPE;
	private String UPAGENTCOM;
	private String NAME;
	private String ADDRESS;
	private String ZIPCODE;
	private String PHONE;
	private String FAX;
	private String EMAIL;
	private String WEBADDRESS;
	private String LINKMAN;
	private String PASSWORD;
	private String CORPORATION;
	private String BANKCODE;
	private String BANKACCNO;
	private String BUSINESSTYPE;
	private String GRPNATURE;
	private String ACTYPE;
	private String SELLFLAG;
	private String OPERATOR;
	private String MAKEDATE;
	private String MAKETIME;
	private String MODIFYDATE;
	private String MODIFYTIME;
	private String BANKTYPE;
	private String CALFLAG;
	private String BUSILICENSECODE;
	private String INSUREID;
	private String INSUREPRINCIPAL;
	private String CHIEFBUSINESS;
	private String BUSIADDRESS;
	private String SUBSCRIBEMAN;
	private String SUBSCRIBEMANDUTY;
	private String LICENSENO;
	private String REGIONALISMCODE;
	private String APPAGENTCOM;
	private String STATE;
	private String NOTI;
	private String BUSINESSCODE;
	private String LICENSESTARTDATE;
	private String LICENSEENDDATE;
	private String COMTYPE;
	private String ETL_DATATIME;
	private String ETL_DATATYPE;
	public static final int FIELDNUM = 46;
	private static String PK[];
	private FDate fDate;
	public CErrors mErrors;

	public LAComSchema()
	{
		fDate = new FDate();
		mErrors = new CErrors();
		String pk[] = new String[1];
		pk[0] = "AGENTCOM";
		PK = pk;
	}

	public String[] getPK()
	{
		return PK;
	}

	public String getAGENTCOM()
	{
		if (AGENTCOM != null)
			AGENTCOM.equals("");
		return AGENTCOM;
	}

	public void setAGENTCOM(String aAGENTCOM)
	{
		AGENTCOM = aAGENTCOM;
	}

	public String getMANAGECOM()
	{
		if (MANAGECOM != null)
			MANAGECOM.equals("");
		return MANAGECOM;
	}

	public void setMANAGECOM(String aMANAGECOM)
	{
		MANAGECOM = aMANAGECOM;
	}

	public String getAREATYPE()
	{
		if (AREATYPE != null)
			AREATYPE.equals("");
		return AREATYPE;
	}

	public void setAREATYPE(String aAREATYPE)
	{
		AREATYPE = aAREATYPE;
	}

	public String getCHANNELTYPE()
	{
		if (CHANNELTYPE != null)
			CHANNELTYPE.equals("");
		return CHANNELTYPE;
	}

	public void setCHANNELTYPE(String aCHANNELTYPE)
	{
		CHANNELTYPE = aCHANNELTYPE;
	}

	public String getUPAGENTCOM()
	{
		if (UPAGENTCOM != null)
			UPAGENTCOM.equals("");
		return UPAGENTCOM;
	}

	public void setUPAGENTCOM(String aUPAGENTCOM)
	{
		UPAGENTCOM = aUPAGENTCOM;
	}

	public String getNAME()
	{
		if (NAME != null)
			NAME.equals("");
		return NAME;
	}

	public void setNAME(String aNAME)
	{
		NAME = aNAME;
	}

	public String getADDRESS()
	{
		if (ADDRESS != null)
			ADDRESS.equals("");
		return ADDRESS;
	}

	public void setADDRESS(String aADDRESS)
	{
		ADDRESS = aADDRESS;
	}

	public String getZIPCODE()
	{
		if (ZIPCODE != null)
			ZIPCODE.equals("");
		return ZIPCODE;
	}

	public void setZIPCODE(String aZIPCODE)
	{
		ZIPCODE = aZIPCODE;
	}

	public String getPHONE()
	{
		if (PHONE != null)
			PHONE.equals("");
		return PHONE;
	}

	public void setPHONE(String aPHONE)
	{
		PHONE = aPHONE;
	}

	public String getFAX()
	{
		if (FAX != null)
			FAX.equals("");
		return FAX;
	}

	public void setFAX(String aFAX)
	{
		FAX = aFAX;
	}

	public String getEMAIL()
	{
		if (EMAIL != null)
			EMAIL.equals("");
		return EMAIL;
	}

	public void setEMAIL(String aEMAIL)
	{
		EMAIL = aEMAIL;
	}

	public String getWEBADDRESS()
	{
		if (WEBADDRESS != null)
			WEBADDRESS.equals("");
		return WEBADDRESS;
	}

	public void setWEBADDRESS(String aWEBADDRESS)
	{
		WEBADDRESS = aWEBADDRESS;
	}

	public String getLINKMAN()
	{
		if (LINKMAN != null)
			LINKMAN.equals("");
		return LINKMAN;
	}

	public void setLINKMAN(String aLINKMAN)
	{
		LINKMAN = aLINKMAN;
	}

	public String getPASSWORD()
	{
		if (PASSWORD != null)
			PASSWORD.equals("");
		return PASSWORD;
	}

	public void setPASSWORD(String aPASSWORD)
	{
		PASSWORD = aPASSWORD;
	}

	public String getCORPORATION()
	{
		if (CORPORATION != null)
			CORPORATION.equals("");
		return CORPORATION;
	}

	public void setCORPORATION(String aCORPORATION)
	{
		CORPORATION = aCORPORATION;
	}

	public String getBANKCODE()
	{
		if (BANKCODE != null)
			BANKCODE.equals("");
		return BANKCODE;
	}

	public void setBANKCODE(String aBANKCODE)
	{
		BANKCODE = aBANKCODE;
	}

	public String getBANKACCNO()
	{
		if (BANKACCNO != null)
			BANKACCNO.equals("");
		return BANKACCNO;
	}

	public void setBANKACCNO(String aBANKACCNO)
	{
		BANKACCNO = aBANKACCNO;
	}

	public String getBUSINESSTYPE()
	{
		if (BUSINESSTYPE != null)
			BUSINESSTYPE.equals("");
		return BUSINESSTYPE;
	}

	public void setBUSINESSTYPE(String aBUSINESSTYPE)
	{
		BUSINESSTYPE = aBUSINESSTYPE;
	}

	public String getGRPNATURE()
	{
		if (GRPNATURE != null)
			GRPNATURE.equals("");
		return GRPNATURE;
	}

	public void setGRPNATURE(String aGRPNATURE)
	{
		GRPNATURE = aGRPNATURE;
	}

	public String getACTYPE()
	{
		if (ACTYPE != null)
			ACTYPE.equals("");
		return ACTYPE;
	}

	public void setACTYPE(String aACTYPE)
	{
		ACTYPE = aACTYPE;
	}

	public String getSELLFLAG()
	{
		if (SELLFLAG != null)
			SELLFLAG.equals("");
		return SELLFLAG;
	}

	public void setSELLFLAG(String aSELLFLAG)
	{
		SELLFLAG = aSELLFLAG;
	}

	public String getOPERATOR()
	{
		if (OPERATOR != null)
			OPERATOR.equals("");
		return OPERATOR;
	}

	public void setOPERATOR(String aOPERATOR)
	{
		OPERATOR = aOPERATOR;
	}

	public String getMAKEDATE()
	{
		if (MAKEDATE != null)
			MAKEDATE.equals("");
		return MAKEDATE;
	}

	public void setMAKEDATE(String aMAKEDATE)
	{
		MAKEDATE = aMAKEDATE;
	}

	public String getMAKETIME()
	{
		if (MAKETIME != null)
			MAKETIME.equals("");
		return MAKETIME;
	}

	public void setMAKETIME(String aMAKETIME)
	{
		MAKETIME = aMAKETIME;
	}

	public String getMODIFYDATE()
	{
		if (MODIFYDATE != null)
			MODIFYDATE.equals("");
		return MODIFYDATE;
	}

	public void setMODIFYDATE(String aMODIFYDATE)
	{
		MODIFYDATE = aMODIFYDATE;
	}

	public String getMODIFYTIME()
	{
		if (MODIFYTIME != null)
			MODIFYTIME.equals("");
		return MODIFYTIME;
	}

	public void setMODIFYTIME(String aMODIFYTIME)
	{
		MODIFYTIME = aMODIFYTIME;
	}

	public String getBANKTYPE()
	{
		if (BANKTYPE != null)
			BANKTYPE.equals("");
		return BANKTYPE;
	}

	public void setBANKTYPE(String aBANKTYPE)
	{
		BANKTYPE = aBANKTYPE;
	}

	public String getCALFLAG()
	{
		if (CALFLAG != null)
			CALFLAG.equals("");
		return CALFLAG;
	}

	public void setCALFLAG(String aCALFLAG)
	{
		CALFLAG = aCALFLAG;
	}

	public String getBUSILICENSECODE()
	{
		if (BUSILICENSECODE != null)
			BUSILICENSECODE.equals("");
		return BUSILICENSECODE;
	}

	public void setBUSILICENSECODE(String aBUSILICENSECODE)
	{
		BUSILICENSECODE = aBUSILICENSECODE;
	}

	public String getINSUREID()
	{
		if (INSUREID != null)
			INSUREID.equals("");
		return INSUREID;
	}

	public void setINSUREID(String aINSUREID)
	{
		INSUREID = aINSUREID;
	}

	public String getINSUREPRINCIPAL()
	{
		if (INSUREPRINCIPAL != null)
			INSUREPRINCIPAL.equals("");
		return INSUREPRINCIPAL;
	}

	public void setINSUREPRINCIPAL(String aINSUREPRINCIPAL)
	{
		INSUREPRINCIPAL = aINSUREPRINCIPAL;
	}

	public String getCHIEFBUSINESS()
	{
		if (CHIEFBUSINESS != null)
			CHIEFBUSINESS.equals("");
		return CHIEFBUSINESS;
	}

	public void setCHIEFBUSINESS(String aCHIEFBUSINESS)
	{
		CHIEFBUSINESS = aCHIEFBUSINESS;
	}

	public String getBUSIADDRESS()
	{
		if (BUSIADDRESS != null)
			BUSIADDRESS.equals("");
		return BUSIADDRESS;
	}

	public void setBUSIADDRESS(String aBUSIADDRESS)
	{
		BUSIADDRESS = aBUSIADDRESS;
	}

	public String getSUBSCRIBEMAN()
	{
		if (SUBSCRIBEMAN != null)
			SUBSCRIBEMAN.equals("");
		return SUBSCRIBEMAN;
	}

	public void setSUBSCRIBEMAN(String aSUBSCRIBEMAN)
	{
		SUBSCRIBEMAN = aSUBSCRIBEMAN;
	}

	public String getSUBSCRIBEMANDUTY()
	{
		if (SUBSCRIBEMANDUTY != null)
			SUBSCRIBEMANDUTY.equals("");
		return SUBSCRIBEMANDUTY;
	}

	public void setSUBSCRIBEMANDUTY(String aSUBSCRIBEMANDUTY)
	{
		SUBSCRIBEMANDUTY = aSUBSCRIBEMANDUTY;
	}

	public String getLICENSENO()
	{
		if (LICENSENO != null)
			LICENSENO.equals("");
		return LICENSENO;
	}

	public void setLICENSENO(String aLICENSENO)
	{
		LICENSENO = aLICENSENO;
	}

	public String getREGIONALISMCODE()
	{
		if (REGIONALISMCODE != null)
			REGIONALISMCODE.equals("");
		return REGIONALISMCODE;
	}

	public void setREGIONALISMCODE(String aREGIONALISMCODE)
	{
		REGIONALISMCODE = aREGIONALISMCODE;
	}

	public String getAPPAGENTCOM()
	{
		if (APPAGENTCOM != null)
			APPAGENTCOM.equals("");
		return APPAGENTCOM;
	}

	public void setAPPAGENTCOM(String aAPPAGENTCOM)
	{
		APPAGENTCOM = aAPPAGENTCOM;
	}

	public String getSTATE()
	{
		if (STATE != null)
			STATE.equals("");
		return STATE;
	}

	public void setSTATE(String aSTATE)
	{
		STATE = aSTATE;
	}

	public String getNOTI()
	{
		if (NOTI != null)
			NOTI.equals("");
		return NOTI;
	}

	public void setNOTI(String aNOTI)
	{
		NOTI = aNOTI;
	}

	public String getBUSINESSCODE()
	{
		if (BUSINESSCODE != null)
			BUSINESSCODE.equals("");
		return BUSINESSCODE;
	}

	public void setBUSINESSCODE(String aBUSINESSCODE)
	{
		BUSINESSCODE = aBUSINESSCODE;
	}

	public String getLICENSESTARTDATE()
	{
		if (LICENSESTARTDATE != null)
			LICENSESTARTDATE.equals("");
		return LICENSESTARTDATE;
	}

	public void setLICENSESTARTDATE(String aLICENSESTARTDATE)
	{
		LICENSESTARTDATE = aLICENSESTARTDATE;
	}

	public String getLICENSEENDDATE()
	{
		if (LICENSEENDDATE != null)
			LICENSEENDDATE.equals("");
		return LICENSEENDDATE;
	}

	public void setLICENSEENDDATE(String aLICENSEENDDATE)
	{
		LICENSEENDDATE = aLICENSEENDDATE;
	}

	public String getCOMTYPE()
	{
		if (COMTYPE != null)
			COMTYPE.equals("");
		return COMTYPE;
	}

	public void setCOMTYPE(String aCOMTYPE)
	{
		COMTYPE = aCOMTYPE;
	}

	public String getETL_DATATIME()
	{
		if (ETL_DATATIME != null)
			ETL_DATATIME.equals("");
		return ETL_DATATIME;
	}

	public void setETL_DATATIME(String aETL_DATATIME)
	{
		ETL_DATATIME = aETL_DATATIME;
	}

	public String getETL_DATATYPE()
	{
		if (ETL_DATATYPE != null)
			ETL_DATATYPE.equals("");
		return ETL_DATATYPE;
	}

	public void setETL_DATATYPE(String aETL_DATATYPE)
	{
		ETL_DATATYPE = aETL_DATATYPE;
	}

	public void setSchema(LAComSchema aLAComSchema)
	{
		AGENTCOM = aLAComSchema.getAGENTCOM();
		MANAGECOM = aLAComSchema.getMANAGECOM();
		AREATYPE = aLAComSchema.getAREATYPE();
		CHANNELTYPE = aLAComSchema.getCHANNELTYPE();
		UPAGENTCOM = aLAComSchema.getUPAGENTCOM();
		NAME = aLAComSchema.getNAME();
		ADDRESS = aLAComSchema.getADDRESS();
		ZIPCODE = aLAComSchema.getZIPCODE();
		PHONE = aLAComSchema.getPHONE();
		FAX = aLAComSchema.getFAX();
		EMAIL = aLAComSchema.getEMAIL();
		WEBADDRESS = aLAComSchema.getWEBADDRESS();
		LINKMAN = aLAComSchema.getLINKMAN();
		PASSWORD = aLAComSchema.getPASSWORD();
		CORPORATION = aLAComSchema.getCORPORATION();
		BANKCODE = aLAComSchema.getBANKCODE();
		BANKACCNO = aLAComSchema.getBANKACCNO();
		BUSINESSTYPE = aLAComSchema.getBUSINESSTYPE();
		GRPNATURE = aLAComSchema.getGRPNATURE();
		ACTYPE = aLAComSchema.getACTYPE();
		SELLFLAG = aLAComSchema.getSELLFLAG();
		OPERATOR = aLAComSchema.getOPERATOR();
		MAKEDATE = aLAComSchema.getMAKEDATE();
		MAKETIME = aLAComSchema.getMAKETIME();
		MODIFYDATE = aLAComSchema.getMODIFYDATE();
		MODIFYTIME = aLAComSchema.getMODIFYTIME();
		BANKTYPE = aLAComSchema.getBANKTYPE();
		CALFLAG = aLAComSchema.getCALFLAG();
		BUSILICENSECODE = aLAComSchema.getBUSILICENSECODE();
		INSUREID = aLAComSchema.getINSUREID();
		INSUREPRINCIPAL = aLAComSchema.getINSUREPRINCIPAL();
		CHIEFBUSINESS = aLAComSchema.getCHIEFBUSINESS();
		BUSIADDRESS = aLAComSchema.getBUSIADDRESS();
		SUBSCRIBEMAN = aLAComSchema.getSUBSCRIBEMAN();
		SUBSCRIBEMANDUTY = aLAComSchema.getSUBSCRIBEMANDUTY();
		LICENSENO = aLAComSchema.getLICENSENO();
		REGIONALISMCODE = aLAComSchema.getREGIONALISMCODE();
		APPAGENTCOM = aLAComSchema.getAPPAGENTCOM();
		STATE = aLAComSchema.getSTATE();
		NOTI = aLAComSchema.getNOTI();
		BUSINESSCODE = aLAComSchema.getBUSINESSCODE();
		LICENSESTARTDATE = aLAComSchema.getLICENSESTARTDATE();
		LICENSEENDDATE = aLAComSchema.getLICENSEENDDATE();
		COMTYPE = aLAComSchema.getCOMTYPE();
		ETL_DATATIME = aLAComSchema.getETL_DATATIME();
		ETL_DATATYPE = aLAComSchema.getETL_DATATYPE();
	}

	public boolean setSchema(ResultSet rs, int i)
	{
		try
		{
			if (rs.getString("AGENTCOM") == null)
				AGENTCOM = null;
			else
				AGENTCOM = rs.getString("AGENTCOM").trim();
			if (rs.getString("MANAGECOM") == null)
				MANAGECOM = null;
			else
				MANAGECOM = rs.getString("MANAGECOM").trim();
			if (rs.getString("AREATYPE") == null)
				AREATYPE = null;
			else
				AREATYPE = rs.getString("AREATYPE").trim();
			if (rs.getString("CHANNELTYPE") == null)
				CHANNELTYPE = null;
			else
				CHANNELTYPE = rs.getString("CHANNELTYPE").trim();
			if (rs.getString("UPAGENTCOM") == null)
				UPAGENTCOM = null;
			else
				UPAGENTCOM = rs.getString("UPAGENTCOM").trim();
			if (rs.getString("NAME") == null)
				NAME = null;
			else
				NAME = rs.getString("NAME").trim();
			if (rs.getString("ADDRESS") == null)
				ADDRESS = null;
			else
				ADDRESS = rs.getString("ADDRESS").trim();
			if (rs.getString("ZIPCODE") == null)
				ZIPCODE = null;
			else
				ZIPCODE = rs.getString("ZIPCODE").trim();
			if (rs.getString("PHONE") == null)
				PHONE = null;
			else
				PHONE = rs.getString("PHONE").trim();
			if (rs.getString("FAX") == null)
				FAX = null;
			else
				FAX = rs.getString("FAX").trim();
			if (rs.getString("EMAIL") == null)
				EMAIL = null;
			else
				EMAIL = rs.getString("EMAIL").trim();
			if (rs.getString("WEBADDRESS") == null)
				WEBADDRESS = null;
			else
				WEBADDRESS = rs.getString("WEBADDRESS").trim();
			if (rs.getString("LINKMAN") == null)
				LINKMAN = null;
			else
				LINKMAN = rs.getString("LINKMAN").trim();
			if (rs.getString("PASSWORD") == null)
				PASSWORD = null;
			else
				PASSWORD = rs.getString("PASSWORD").trim();
			if (rs.getString("CORPORATION") == null)
				CORPORATION = null;
			else
				CORPORATION = rs.getString("CORPORATION").trim();
			if (rs.getString("BANKCODE") == null)
				BANKCODE = null;
			else
				BANKCODE = rs.getString("BANKCODE").trim();
			if (rs.getString("BANKACCNO") == null)
				BANKACCNO = null;
			else
				BANKACCNO = rs.getString("BANKACCNO").trim();
			if (rs.getString("BUSINESSTYPE") == null)
				BUSINESSTYPE = null;
			else
				BUSINESSTYPE = rs.getString("BUSINESSTYPE").trim();
			if (rs.getString("GRPNATURE") == null)
				GRPNATURE = null;
			else
				GRPNATURE = rs.getString("GRPNATURE").trim();
			if (rs.getString("ACTYPE") == null)
				ACTYPE = null;
			else
				ACTYPE = rs.getString("ACTYPE").trim();
			if (rs.getString("SELLFLAG") == null)
				SELLFLAG = null;
			else
				SELLFLAG = rs.getString("SELLFLAG").trim();
			if (rs.getString("OPERATOR") == null)
				OPERATOR = null;
			else
				OPERATOR = rs.getString("OPERATOR").trim();
			if (rs.getString("MAKEDATE") == null)
				MAKEDATE = null;
			else
				MAKEDATE = rs.getString("MAKEDATE").trim();
			if (rs.getString("MAKETIME") == null)
				MAKETIME = null;
			else
				MAKETIME = rs.getString("MAKETIME").trim();
			if (rs.getString("MODIFYDATE") == null)
				MODIFYDATE = null;
			else
				MODIFYDATE = rs.getString("MODIFYDATE").trim();
			if (rs.getString("MODIFYTIME") == null)
				MODIFYTIME = null;
			else
				MODIFYTIME = rs.getString("MODIFYTIME").trim();
			if (rs.getString("BANKTYPE") == null)
				BANKTYPE = null;
			else
				BANKTYPE = rs.getString("BANKTYPE").trim();
			if (rs.getString("CALFLAG") == null)
				CALFLAG = null;
			else
				CALFLAG = rs.getString("CALFLAG").trim();
			if (rs.getString("BUSILICENSECODE") == null)
				BUSILICENSECODE = null;
			else
				BUSILICENSECODE = rs.getString("BUSILICENSECODE").trim();
			if (rs.getString("INSUREID") == null)
				INSUREID = null;
			else
				INSUREID = rs.getString("INSUREID").trim();
			if (rs.getString("INSUREPRINCIPAL") == null)
				INSUREPRINCIPAL = null;
			else
				INSUREPRINCIPAL = rs.getString("INSUREPRINCIPAL").trim();
			if (rs.getString("CHIEFBUSINESS") == null)
				CHIEFBUSINESS = null;
			else
				CHIEFBUSINESS = rs.getString("CHIEFBUSINESS").trim();
			if (rs.getString("BUSIADDRESS") == null)
				BUSIADDRESS = null;
			else
				BUSIADDRESS = rs.getString("BUSIADDRESS").trim();
			if (rs.getString("SUBSCRIBEMAN") == null)
				SUBSCRIBEMAN = null;
			else
				SUBSCRIBEMAN = rs.getString("SUBSCRIBEMAN").trim();
			if (rs.getString("SUBSCRIBEMANDUTY") == null)
				SUBSCRIBEMANDUTY = null;
			else
				SUBSCRIBEMANDUTY = rs.getString("SUBSCRIBEMANDUTY").trim();
			if (rs.getString("LICENSENO") == null)
				LICENSENO = null;
			else
				LICENSENO = rs.getString("LICENSENO").trim();
			if (rs.getString("REGIONALISMCODE") == null)
				REGIONALISMCODE = null;
			else
				REGIONALISMCODE = rs.getString("REGIONALISMCODE").trim();
			if (rs.getString("APPAGENTCOM") == null)
				APPAGENTCOM = null;
			else
				APPAGENTCOM = rs.getString("APPAGENTCOM").trim();
			if (rs.getString("STATE") == null)
				STATE = null;
			else
				STATE = rs.getString("STATE").trim();
			if (rs.getString("NOTI") == null)
				NOTI = null;
			else
				NOTI = rs.getString("NOTI").trim();
			if (rs.getString("BUSINESSCODE") == null)
				BUSINESSCODE = null;
			else
				BUSINESSCODE = rs.getString("BUSINESSCODE").trim();
			if (rs.getString("LICENSESTARTDATE") == null)
				LICENSESTARTDATE = null;
			else
				LICENSESTARTDATE = rs.getString("LICENSESTARTDATE").trim();
			if (rs.getString("LICENSEENDDATE") == null)
				LICENSEENDDATE = null;
			else
				LICENSEENDDATE = rs.getString("LICENSEENDDATE").trim();
			if (rs.getString("COMTYPE") == null)
				COMTYPE = null;
			else
				COMTYPE = rs.getString("COMTYPE").trim();
			if (rs.getString("ETL_DATATIME") == null)
				ETL_DATATIME = null;
			else
				ETL_DATATIME = rs.getString("ETL_DATATIME").trim();
			if (rs.getString("ETL_DATATYPE") == null)
				ETL_DATATYPE = null;
			else
				ETL_DATATYPE = rs.getString("ETL_DATATYPE").trim();
		}
		catch (SQLException sqle)
		{
			CError tError = new CError();
			tError.moduleName = "LAComSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			mErrors.addOneError(tError);
			return false;
		}
		return true;
	}

	public LAComSchema getSchema()
	{
		LAComSchema aLAComSchema = new LAComSchema();
		aLAComSchema.setSchema(this);
		return aLAComSchema;
	}

	public LAComDB getDB()
	{
		LAComDB aDBOper = new LAComDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}

	public String encode()
	{
		String strReturn = "";
		strReturn = (new StringBuilder(String.valueOf(StrTool.cTrim(StrTool.unicodeToGBK(AGENTCOM))))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MANAGECOM))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(AREATYPE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(CHANNELTYPE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(UPAGENTCOM))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(NAME))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ADDRESS))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ZIPCODE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PHONE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(FAX))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(EMAIL))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(WEBADDRESS))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(LINKMAN))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(PASSWORD))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(CORPORATION))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BANKCODE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BANKACCNO))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BUSINESSTYPE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(GRPNATURE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ACTYPE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(SELLFLAG))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(OPERATOR))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MAKEDATE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MAKETIME))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MODIFYDATE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(MODIFYTIME))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BANKTYPE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(CALFLAG))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BUSILICENSECODE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(INSUREID))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(INSUREPRINCIPAL))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(CHIEFBUSINESS))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BUSIADDRESS))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(SUBSCRIBEMAN))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(SUBSCRIBEMANDUTY))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(LICENSENO))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(REGIONALISMCODE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(APPAGENTCOM))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(STATE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(NOTI))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(BUSINESSCODE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(LICENSESTARTDATE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(LICENSEENDDATE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(COMTYPE))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ETL_DATATIME))).append("|").append(StrTool.cTrim(StrTool.unicodeToGBK(ETL_DATATYPE))).toString();
		return strReturn;
	}

	public boolean decode(String strMessage)
	{
		try
		{
			AGENTCOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
			MANAGECOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
			AREATYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
			CHANNELTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
			UPAGENTCOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
			NAME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
			ADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
			ZIPCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
			PHONE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
			FAX = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
			EMAIL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
			WEBADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
			LINKMAN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
			PASSWORD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
			CORPORATION = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
			BANKCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
			BANKACCNO = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
			BUSINESSTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
			GRPNATURE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
			ACTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
			SELLFLAG = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
			OPERATOR = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
			MAKEDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
			MAKETIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
			MODIFYDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
			MODIFYTIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
			BANKTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
			CALFLAG = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
			BUSILICENSECODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
			INSUREID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
			INSUREPRINCIPAL = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
			CHIEFBUSINESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
			BUSIADDRESS = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
			SUBSCRIBEMAN = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
			SUBSCRIBEMANDUTY = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 35, "|");
			LICENSENO = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 36, "|");
			REGIONALISMCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 37, "|");
			APPAGENTCOM = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 38, "|");
			STATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 39, "|");
			NOTI = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 40, "|");
			BUSINESSCODE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 41, "|");
			LICENSESTARTDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 42, "|");
			LICENSEENDDATE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 43, "|");
			COMTYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 44, "|");
			ETL_DATATIME = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 45, "|");
			ETL_DATATYPE = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 46, "|");
		}
		catch (NumberFormatException ex)
		{
			CError tError = new CError();
			tError.moduleName = "LAComSchema";
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
		if (FCode.equals("AGENTCOM"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(AGENTCOM));
		if (FCode.equals("MANAGECOM"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MANAGECOM));
		if (FCode.equals("AREATYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(AREATYPE));
		if (FCode.equals("CHANNELTYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(CHANNELTYPE));
		if (FCode.equals("UPAGENTCOM"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(UPAGENTCOM));
		if (FCode.equals("NAME"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(NAME));
		if (FCode.equals("ADDRESS"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ADDRESS));
		if (FCode.equals("ZIPCODE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ZIPCODE));
		if (FCode.equals("PHONE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PHONE));
		if (FCode.equals("FAX"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(FAX));
		if (FCode.equals("EMAIL"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(EMAIL));
		if (FCode.equals("WEBADDRESS"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(WEBADDRESS));
		if (FCode.equals("LINKMAN"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(LINKMAN));
		if (FCode.equals("PASSWORD"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(PASSWORD));
		if (FCode.equals("CORPORATION"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(CORPORATION));
		if (FCode.equals("BANKCODE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BANKCODE));
		if (FCode.equals("BANKACCNO"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BANKACCNO));
		if (FCode.equals("BUSINESSTYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BUSINESSTYPE));
		if (FCode.equals("GRPNATURE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(GRPNATURE));
		if (FCode.equals("ACTYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ACTYPE));
		if (FCode.equals("SELLFLAG"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(SELLFLAG));
		if (FCode.equals("OPERATOR"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(OPERATOR));
		if (FCode.equals("MAKEDATE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAKEDATE));
		if (FCode.equals("MAKETIME"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MAKETIME));
		if (FCode.equals("MODIFYDATE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MODIFYDATE));
		if (FCode.equals("MODIFYTIME"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(MODIFYTIME));
		if (FCode.equals("BANKTYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BANKTYPE));
		if (FCode.equals("CALFLAG"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(CALFLAG));
		if (FCode.equals("BUSILICENSECODE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BUSILICENSECODE));
		if (FCode.equals("INSUREID"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(INSUREID));
		if (FCode.equals("INSUREPRINCIPAL"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(INSUREPRINCIPAL));
		if (FCode.equals("CHIEFBUSINESS"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(CHIEFBUSINESS));
		if (FCode.equals("BUSIADDRESS"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BUSIADDRESS));
		if (FCode.equals("SUBSCRIBEMAN"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(SUBSCRIBEMAN));
		if (FCode.equals("SUBSCRIBEMANDUTY"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(SUBSCRIBEMANDUTY));
		if (FCode.equals("LICENSENO"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(LICENSENO));
		if (FCode.equals("REGIONALISMCODE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(REGIONALISMCODE));
		if (FCode.equals("APPAGENTCOM"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(APPAGENTCOM));
		if (FCode.equals("STATE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(STATE));
		if (FCode.equals("NOTI"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(NOTI));
		if (FCode.equals("BUSINESSCODE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(BUSINESSCODE));
		if (FCode.equals("LICENSESTARTDATE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(LICENSESTARTDATE));
		if (FCode.equals("LICENSEENDDATE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(LICENSEENDDATE));
		if (FCode.equals("COMTYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(COMTYPE));
		if (FCode.equals("ETL_DATATIME"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ETL_DATATIME));
		if (FCode.equals("ETL_DATATYPE"))
			strReturn = StrTool.GBKToUnicode(String.valueOf(ETL_DATATYPE));
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
			strFieldValue = StrTool.GBKToUnicode(AGENTCOM);
			break;

		case 1: // '\001'
			strFieldValue = StrTool.GBKToUnicode(MANAGECOM);
			break;

		case 2: // '\002'
			strFieldValue = StrTool.GBKToUnicode(AREATYPE);
			break;

		case 3: // '\003'
			strFieldValue = StrTool.GBKToUnicode(CHANNELTYPE);
			break;

		case 4: // '\004'
			strFieldValue = StrTool.GBKToUnicode(UPAGENTCOM);
			break;

		case 5: // '\005'
			strFieldValue = StrTool.GBKToUnicode(NAME);
			break;

		case 6: // '\006'
			strFieldValue = StrTool.GBKToUnicode(ADDRESS);
			break;

		case 7: // '\007'
			strFieldValue = StrTool.GBKToUnicode(ZIPCODE);
			break;

		case 8: // '\b'
			strFieldValue = StrTool.GBKToUnicode(PHONE);
			break;

		case 9: // '\t'
			strFieldValue = StrTool.GBKToUnicode(FAX);
			break;

		case 10: // '\n'
			strFieldValue = StrTool.GBKToUnicode(EMAIL);
			break;

		case 11: // '\013'
			strFieldValue = StrTool.GBKToUnicode(WEBADDRESS);
			break;

		case 12: // '\f'
			strFieldValue = StrTool.GBKToUnicode(LINKMAN);
			break;

		case 13: // '\r'
			strFieldValue = StrTool.GBKToUnicode(PASSWORD);
			break;

		case 14: // '\016'
			strFieldValue = StrTool.GBKToUnicode(CORPORATION);
			break;

		case 15: // '\017'
			strFieldValue = StrTool.GBKToUnicode(BANKCODE);
			break;

		case 16: // '\020'
			strFieldValue = StrTool.GBKToUnicode(BANKACCNO);
			break;

		case 17: // '\021'
			strFieldValue = StrTool.GBKToUnicode(BUSINESSTYPE);
			break;

		case 18: // '\022'
			strFieldValue = StrTool.GBKToUnicode(GRPNATURE);
			break;

		case 19: // '\023'
			strFieldValue = StrTool.GBKToUnicode(ACTYPE);
			break;

		case 20: // '\024'
			strFieldValue = StrTool.GBKToUnicode(SELLFLAG);
			break;

		case 21: // '\025'
			strFieldValue = StrTool.GBKToUnicode(OPERATOR);
			break;

		case 22: // '\026'
			strFieldValue = StrTool.GBKToUnicode(MAKEDATE);
			break;

		case 23: // '\027'
			strFieldValue = StrTool.GBKToUnicode(MAKETIME);
			break;

		case 24: // '\030'
			strFieldValue = StrTool.GBKToUnicode(MODIFYDATE);
			break;

		case 25: // '\031'
			strFieldValue = StrTool.GBKToUnicode(MODIFYTIME);
			break;

		case 26: // '\032'
			strFieldValue = StrTool.GBKToUnicode(BANKTYPE);
			break;

		case 27: // '\033'
			strFieldValue = StrTool.GBKToUnicode(CALFLAG);
			break;

		case 28: // '\034'
			strFieldValue = StrTool.GBKToUnicode(BUSILICENSECODE);
			break;

		case 29: // '\035'
			strFieldValue = StrTool.GBKToUnicode(INSUREID);
			break;

		case 30: // '\036'
			strFieldValue = StrTool.GBKToUnicode(INSUREPRINCIPAL);
			break;

		case 31: // '\037'
			strFieldValue = StrTool.GBKToUnicode(CHIEFBUSINESS);
			break;

		case 32: // ' '
			strFieldValue = StrTool.GBKToUnicode(BUSIADDRESS);
			break;

		case 33: // '!'
			strFieldValue = StrTool.GBKToUnicode(SUBSCRIBEMAN);
			break;

		case 34: // '"'
			strFieldValue = StrTool.GBKToUnicode(SUBSCRIBEMANDUTY);
			break;

		case 35: // '#'
			strFieldValue = StrTool.GBKToUnicode(LICENSENO);
			break;

		case 36: // '$'
			strFieldValue = StrTool.GBKToUnicode(REGIONALISMCODE);
			break;

		case 37: // '%'
			strFieldValue = StrTool.GBKToUnicode(APPAGENTCOM);
			break;

		case 38: // '&'
			strFieldValue = StrTool.GBKToUnicode(STATE);
			break;

		case 39: // '\''
			strFieldValue = StrTool.GBKToUnicode(NOTI);
			break;

		case 40: // '('
			strFieldValue = StrTool.GBKToUnicode(BUSINESSCODE);
			break;

		case 41: // ')'
			strFieldValue = StrTool.GBKToUnicode(LICENSESTARTDATE);
			break;

		case 42: // '*'
			strFieldValue = StrTool.GBKToUnicode(LICENSEENDDATE);
			break;

		case 43: // '+'
			strFieldValue = StrTool.GBKToUnicode(COMTYPE);
			break;

		case 44: // ','
			strFieldValue = StrTool.GBKToUnicode(ETL_DATATIME);
			break;

		case 45: // '-'
			strFieldValue = StrTool.GBKToUnicode(ETL_DATATYPE);
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
		if (FCode.equals("AGENTCOM"))
			if (FValue != null && !FValue.equals(""))
				AGENTCOM = FValue.trim();
			else
				AGENTCOM = null;
		if (FCode.equals("MANAGECOM"))
			if (FValue != null && !FValue.equals(""))
				MANAGECOM = FValue.trim();
			else
				MANAGECOM = null;
		if (FCode.equals("AREATYPE"))
			if (FValue != null && !FValue.equals(""))
				AREATYPE = FValue.trim();
			else
				AREATYPE = null;
		if (FCode.equals("CHANNELTYPE"))
			if (FValue != null && !FValue.equals(""))
				CHANNELTYPE = FValue.trim();
			else
				CHANNELTYPE = null;
		if (FCode.equals("UPAGENTCOM"))
			if (FValue != null && !FValue.equals(""))
				UPAGENTCOM = FValue.trim();
			else
				UPAGENTCOM = null;
		if (FCode.equals("NAME"))
			if (FValue != null && !FValue.equals(""))
				NAME = FValue.trim();
			else
				NAME = null;
		if (FCode.equals("ADDRESS"))
			if (FValue != null && !FValue.equals(""))
				ADDRESS = FValue.trim();
			else
				ADDRESS = null;
		if (FCode.equals("ZIPCODE"))
			if (FValue != null && !FValue.equals(""))
				ZIPCODE = FValue.trim();
			else
				ZIPCODE = null;
		if (FCode.equals("PHONE"))
			if (FValue != null && !FValue.equals(""))
				PHONE = FValue.trim();
			else
				PHONE = null;
		if (FCode.equals("FAX"))
			if (FValue != null && !FValue.equals(""))
				FAX = FValue.trim();
			else
				FAX = null;
		if (FCode.equals("EMAIL"))
			if (FValue != null && !FValue.equals(""))
				EMAIL = FValue.trim();
			else
				EMAIL = null;
		if (FCode.equals("WEBADDRESS"))
			if (FValue != null && !FValue.equals(""))
				WEBADDRESS = FValue.trim();
			else
				WEBADDRESS = null;
		if (FCode.equals("LINKMAN"))
			if (FValue != null && !FValue.equals(""))
				LINKMAN = FValue.trim();
			else
				LINKMAN = null;
		if (FCode.equals("PASSWORD"))
			if (FValue != null && !FValue.equals(""))
				PASSWORD = FValue.trim();
			else
				PASSWORD = null;
		if (FCode.equals("CORPORATION"))
			if (FValue != null && !FValue.equals(""))
				CORPORATION = FValue.trim();
			else
				CORPORATION = null;
		if (FCode.equals("BANKCODE"))
			if (FValue != null && !FValue.equals(""))
				BANKCODE = FValue.trim();
			else
				BANKCODE = null;
		if (FCode.equals("BANKACCNO"))
			if (FValue != null && !FValue.equals(""))
				BANKACCNO = FValue.trim();
			else
				BANKACCNO = null;
		if (FCode.equals("BUSINESSTYPE"))
			if (FValue != null && !FValue.equals(""))
				BUSINESSTYPE = FValue.trim();
			else
				BUSINESSTYPE = null;
		if (FCode.equals("GRPNATURE"))
			if (FValue != null && !FValue.equals(""))
				GRPNATURE = FValue.trim();
			else
				GRPNATURE = null;
		if (FCode.equals("ACTYPE"))
			if (FValue != null && !FValue.equals(""))
				ACTYPE = FValue.trim();
			else
				ACTYPE = null;
		if (FCode.equals("SELLFLAG"))
			if (FValue != null && !FValue.equals(""))
				SELLFLAG = FValue.trim();
			else
				SELLFLAG = null;
		if (FCode.equals("OPERATOR"))
			if (FValue != null && !FValue.equals(""))
				OPERATOR = FValue.trim();
			else
				OPERATOR = null;
		if (FCode.equals("MAKEDATE"))
			if (FValue != null && !FValue.equals(""))
				MAKEDATE = FValue.trim();
			else
				MAKEDATE = null;
		if (FCode.equals("MAKETIME"))
			if (FValue != null && !FValue.equals(""))
				MAKETIME = FValue.trim();
			else
				MAKETIME = null;
		if (FCode.equals("MODIFYDATE"))
			if (FValue != null && !FValue.equals(""))
				MODIFYDATE = FValue.trim();
			else
				MODIFYDATE = null;
		if (FCode.equals("MODIFYTIME"))
			if (FValue != null && !FValue.equals(""))
				MODIFYTIME = FValue.trim();
			else
				MODIFYTIME = null;
		if (FCode.equals("BANKTYPE"))
			if (FValue != null && !FValue.equals(""))
				BANKTYPE = FValue.trim();
			else
				BANKTYPE = null;
		if (FCode.equals("CALFLAG"))
			if (FValue != null && !FValue.equals(""))
				CALFLAG = FValue.trim();
			else
				CALFLAG = null;
		if (FCode.equals("BUSILICENSECODE"))
			if (FValue != null && !FValue.equals(""))
				BUSILICENSECODE = FValue.trim();
			else
				BUSILICENSECODE = null;
		if (FCode.equals("INSUREID"))
			if (FValue != null && !FValue.equals(""))
				INSUREID = FValue.trim();
			else
				INSUREID = null;
		if (FCode.equals("INSUREPRINCIPAL"))
			if (FValue != null && !FValue.equals(""))
				INSUREPRINCIPAL = FValue.trim();
			else
				INSUREPRINCIPAL = null;
		if (FCode.equals("CHIEFBUSINESS"))
			if (FValue != null && !FValue.equals(""))
				CHIEFBUSINESS = FValue.trim();
			else
				CHIEFBUSINESS = null;
		if (FCode.equals("BUSIADDRESS"))
			if (FValue != null && !FValue.equals(""))
				BUSIADDRESS = FValue.trim();
			else
				BUSIADDRESS = null;
		if (FCode.equals("SUBSCRIBEMAN"))
			if (FValue != null && !FValue.equals(""))
				SUBSCRIBEMAN = FValue.trim();
			else
				SUBSCRIBEMAN = null;
		if (FCode.equals("SUBSCRIBEMANDUTY"))
			if (FValue != null && !FValue.equals(""))
				SUBSCRIBEMANDUTY = FValue.trim();
			else
				SUBSCRIBEMANDUTY = null;
		if (FCode.equals("LICENSENO"))
			if (FValue != null && !FValue.equals(""))
				LICENSENO = FValue.trim();
			else
				LICENSENO = null;
		if (FCode.equals("REGIONALISMCODE"))
			if (FValue != null && !FValue.equals(""))
				REGIONALISMCODE = FValue.trim();
			else
				REGIONALISMCODE = null;
		if (FCode.equals("APPAGENTCOM"))
			if (FValue != null && !FValue.equals(""))
				APPAGENTCOM = FValue.trim();
			else
				APPAGENTCOM = null;
		if (FCode.equals("STATE"))
			if (FValue != null && !FValue.equals(""))
				STATE = FValue.trim();
			else
				STATE = null;
		if (FCode.equals("NOTI"))
			if (FValue != null && !FValue.equals(""))
				NOTI = FValue.trim();
			else
				NOTI = null;
		if (FCode.equals("BUSINESSCODE"))
			if (FValue != null && !FValue.equals(""))
				BUSINESSCODE = FValue.trim();
			else
				BUSINESSCODE = null;
		if (FCode.equals("LICENSESTARTDATE"))
			if (FValue != null && !FValue.equals(""))
				LICENSESTARTDATE = FValue.trim();
			else
				LICENSESTARTDATE = null;
		if (FCode.equals("LICENSEENDDATE"))
			if (FValue != null && !FValue.equals(""))
				LICENSEENDDATE = FValue.trim();
			else
				LICENSEENDDATE = null;
		if (FCode.equals("COMTYPE"))
			if (FValue != null && !FValue.equals(""))
				COMTYPE = FValue.trim();
			else
				COMTYPE = null;
		if (FCode.equals("ETL_DATATIME"))
			if (FValue != null && !FValue.equals(""))
				ETL_DATATIME = FValue.trim();
			else
				ETL_DATATIME = null;
		if (FCode.equals("ETL_DATATYPE"))
			if (FValue != null && !FValue.equals(""))
				ETL_DATATYPE = FValue.trim();
			else
				ETL_DATATYPE = null;
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		LAComSchema other = (LAComSchema)otherObject;
		return AGENTCOM.equals(other.getAGENTCOM()) && MANAGECOM.equals(other.getMANAGECOM()) && AREATYPE.equals(other.getAREATYPE()) && CHANNELTYPE.equals(other.getCHANNELTYPE()) && UPAGENTCOM.equals(other.getUPAGENTCOM()) && NAME.equals(other.getNAME()) && ADDRESS.equals(other.getADDRESS()) && ZIPCODE.equals(other.getZIPCODE()) && PHONE.equals(other.getPHONE()) && FAX.equals(other.getFAX()) && EMAIL.equals(other.getEMAIL()) && WEBADDRESS.equals(other.getWEBADDRESS()) && LINKMAN.equals(other.getLINKMAN()) && PASSWORD.equals(other.getPASSWORD()) && CORPORATION.equals(other.getCORPORATION()) && BANKCODE.equals(other.getBANKCODE()) && BANKACCNO.equals(other.getBANKACCNO()) && BUSINESSTYPE.equals(other.getBUSINESSTYPE()) && GRPNATURE.equals(other.getGRPNATURE()) && ACTYPE.equals(other.getACTYPE()) && SELLFLAG.equals(other.getSELLFLAG()) && OPERATOR.equals(other.getOPERATOR()) && MAKEDATE.equals(other.getMAKEDATE()) && MAKETIME.equals(other.getMAKETIME()) && MODIFYDATE.equals(other.getMODIFYDATE()) && MODIFYTIME.equals(other.getMODIFYTIME()) && BANKTYPE.equals(other.getBANKTYPE()) && CALFLAG.equals(other.getCALFLAG()) && BUSILICENSECODE.equals(other.getBUSILICENSECODE()) && INSUREID.equals(other.getINSUREID()) && INSUREPRINCIPAL.equals(other.getINSUREPRINCIPAL()) && CHIEFBUSINESS.equals(other.getCHIEFBUSINESS()) && BUSIADDRESS.equals(other.getBUSIADDRESS()) && SUBSCRIBEMAN.equals(other.getSUBSCRIBEMAN()) && SUBSCRIBEMANDUTY.equals(other.getSUBSCRIBEMANDUTY()) && LICENSENO.equals(other.getLICENSENO()) && REGIONALISMCODE.equals(other.getREGIONALISMCODE()) && APPAGENTCOM.equals(other.getAPPAGENTCOM()) && STATE.equals(other.getSTATE()) && NOTI.equals(other.getNOTI()) && BUSINESSCODE.equals(other.getBUSINESSCODE()) && LICENSESTARTDATE.equals(other.getLICENSESTARTDATE()) && LICENSEENDDATE.equals(other.getLICENSEENDDATE()) && COMTYPE.equals(other.getCOMTYPE()) && ETL_DATATIME.equals(other.getETL_DATATIME()) && ETL_DATATYPE.equals(other.getETL_DATATYPE());
	}

	public int getFieldCount()
	{
		return 46;
	}

	public int getFieldIndex(String strFieldName)
	{
		if (strFieldName.equals("AGENTCOM"))
			return 0;
		if (strFieldName.equals("MANAGECOM"))
			return 1;
		if (strFieldName.equals("AREATYPE"))
			return 2;
		if (strFieldName.equals("CHANNELTYPE"))
			return 3;
		if (strFieldName.equals("UPAGENTCOM"))
			return 4;
		if (strFieldName.equals("NAME"))
			return 5;
		if (strFieldName.equals("ADDRESS"))
			return 6;
		if (strFieldName.equals("ZIPCODE"))
			return 7;
		if (strFieldName.equals("PHONE"))
			return 8;
		if (strFieldName.equals("FAX"))
			return 9;
		if (strFieldName.equals("EMAIL"))
			return 10;
		if (strFieldName.equals("WEBADDRESS"))
			return 11;
		if (strFieldName.equals("LINKMAN"))
			return 12;
		if (strFieldName.equals("PASSWORD"))
			return 13;
		if (strFieldName.equals("CORPORATION"))
			return 14;
		if (strFieldName.equals("BANKCODE"))
			return 15;
		if (strFieldName.equals("BANKACCNO"))
			return 16;
		if (strFieldName.equals("BUSINESSTYPE"))
			return 17;
		if (strFieldName.equals("GRPNATURE"))
			return 18;
		if (strFieldName.equals("ACTYPE"))
			return 19;
		if (strFieldName.equals("SELLFLAG"))
			return 20;
		if (strFieldName.equals("OPERATOR"))
			return 21;
		if (strFieldName.equals("MAKEDATE"))
			return 22;
		if (strFieldName.equals("MAKETIME"))
			return 23;
		if (strFieldName.equals("MODIFYDATE"))
			return 24;
		if (strFieldName.equals("MODIFYTIME"))
			return 25;
		if (strFieldName.equals("BANKTYPE"))
			return 26;
		if (strFieldName.equals("CALFLAG"))
			return 27;
		if (strFieldName.equals("BUSILICENSECODE"))
			return 28;
		if (strFieldName.equals("INSUREID"))
			return 29;
		if (strFieldName.equals("INSUREPRINCIPAL"))
			return 30;
		if (strFieldName.equals("CHIEFBUSINESS"))
			return 31;
		if (strFieldName.equals("BUSIADDRESS"))
			return 32;
		if (strFieldName.equals("SUBSCRIBEMAN"))
			return 33;
		if (strFieldName.equals("SUBSCRIBEMANDUTY"))
			return 34;
		if (strFieldName.equals("LICENSENO"))
			return 35;
		if (strFieldName.equals("REGIONALISMCODE"))
			return 36;
		if (strFieldName.equals("APPAGENTCOM"))
			return 37;
		if (strFieldName.equals("STATE"))
			return 38;
		if (strFieldName.equals("NOTI"))
			return 39;
		if (strFieldName.equals("BUSINESSCODE"))
			return 40;
		if (strFieldName.equals("LICENSESTARTDATE"))
			return 41;
		if (strFieldName.equals("LICENSEENDDATE"))
			return 42;
		if (strFieldName.equals("COMTYPE"))
			return 43;
		if (strFieldName.equals("ETL_DATATIME"))
			return 44;
		return !strFieldName.equals("ETL_DATATYPE") ? -1 : 45;
	}

	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch (nFieldIndex)
		{
		case 0: // '\0'
			strFieldName = "AGENTCOM";
			break;

		case 1: // '\001'
			strFieldName = "MANAGECOM";
			break;

		case 2: // '\002'
			strFieldName = "AREATYPE";
			break;

		case 3: // '\003'
			strFieldName = "CHANNELTYPE";
			break;

		case 4: // '\004'
			strFieldName = "UPAGENTCOM";
			break;

		case 5: // '\005'
			strFieldName = "NAME";
			break;

		case 6: // '\006'
			strFieldName = "ADDRESS";
			break;

		case 7: // '\007'
			strFieldName = "ZIPCODE";
			break;

		case 8: // '\b'
			strFieldName = "PHONE";
			break;

		case 9: // '\t'
			strFieldName = "FAX";
			break;

		case 10: // '\n'
			strFieldName = "EMAIL";
			break;

		case 11: // '\013'
			strFieldName = "WEBADDRESS";
			break;

		case 12: // '\f'
			strFieldName = "LINKMAN";
			break;

		case 13: // '\r'
			strFieldName = "PASSWORD";
			break;

		case 14: // '\016'
			strFieldName = "CORPORATION";
			break;

		case 15: // '\017'
			strFieldName = "BANKCODE";
			break;

		case 16: // '\020'
			strFieldName = "BANKACCNO";
			break;

		case 17: // '\021'
			strFieldName = "BUSINESSTYPE";
			break;

		case 18: // '\022'
			strFieldName = "GRPNATURE";
			break;

		case 19: // '\023'
			strFieldName = "ACTYPE";
			break;

		case 20: // '\024'
			strFieldName = "SELLFLAG";
			break;

		case 21: // '\025'
			strFieldName = "OPERATOR";
			break;

		case 22: // '\026'
			strFieldName = "MAKEDATE";
			break;

		case 23: // '\027'
			strFieldName = "MAKETIME";
			break;

		case 24: // '\030'
			strFieldName = "MODIFYDATE";
			break;

		case 25: // '\031'
			strFieldName = "MODIFYTIME";
			break;

		case 26: // '\032'
			strFieldName = "BANKTYPE";
			break;

		case 27: // '\033'
			strFieldName = "CALFLAG";
			break;

		case 28: // '\034'
			strFieldName = "BUSILICENSECODE";
			break;

		case 29: // '\035'
			strFieldName = "INSUREID";
			break;

		case 30: // '\036'
			strFieldName = "INSUREPRINCIPAL";
			break;

		case 31: // '\037'
			strFieldName = "CHIEFBUSINESS";
			break;

		case 32: // ' '
			strFieldName = "BUSIADDRESS";
			break;

		case 33: // '!'
			strFieldName = "SUBSCRIBEMAN";
			break;

		case 34: // '"'
			strFieldName = "SUBSCRIBEMANDUTY";
			break;

		case 35: // '#'
			strFieldName = "LICENSENO";
			break;

		case 36: // '$'
			strFieldName = "REGIONALISMCODE";
			break;

		case 37: // '%'
			strFieldName = "APPAGENTCOM";
			break;

		case 38: // '&'
			strFieldName = "STATE";
			break;

		case 39: // '\''
			strFieldName = "NOTI";
			break;

		case 40: // '('
			strFieldName = "BUSINESSCODE";
			break;

		case 41: // ')'
			strFieldName = "LICENSESTARTDATE";
			break;

		case 42: // '*'
			strFieldName = "LICENSEENDDATE";
			break;

		case 43: // '+'
			strFieldName = "COMTYPE";
			break;

		case 44: // ','
			strFieldName = "ETL_DATATIME";
			break;

		case 45: // '-'
			strFieldName = "ETL_DATATYPE";
			break;

		default:
			strFieldName = "";
			break;
		}
		return strFieldName;
	}

	public int getFieldType(String strFieldName)
	{
		if (strFieldName.equals("AGENTCOM"))
			return 0;
		if (strFieldName.equals("MANAGECOM"))
			return 0;
		if (strFieldName.equals("AREATYPE"))
			return 0;
		if (strFieldName.equals("CHANNELTYPE"))
			return 0;
		if (strFieldName.equals("UPAGENTCOM"))
			return 0;
		if (strFieldName.equals("NAME"))
			return 0;
		if (strFieldName.equals("ADDRESS"))
			return 0;
		if (strFieldName.equals("ZIPCODE"))
			return 0;
		if (strFieldName.equals("PHONE"))
			return 0;
		if (strFieldName.equals("FAX"))
			return 0;
		if (strFieldName.equals("EMAIL"))
			return 0;
		if (strFieldName.equals("WEBADDRESS"))
			return 0;
		if (strFieldName.equals("LINKMAN"))
			return 0;
		if (strFieldName.equals("PASSWORD"))
			return 0;
		if (strFieldName.equals("CORPORATION"))
			return 0;
		if (strFieldName.equals("BANKCODE"))
			return 0;
		if (strFieldName.equals("BANKACCNO"))
			return 0;
		if (strFieldName.equals("BUSINESSTYPE"))
			return 0;
		if (strFieldName.equals("GRPNATURE"))
			return 0;
		if (strFieldName.equals("ACTYPE"))
			return 0;
		if (strFieldName.equals("SELLFLAG"))
			return 0;
		if (strFieldName.equals("OPERATOR"))
			return 0;
		if (strFieldName.equals("MAKEDATE"))
			return 0;
		if (strFieldName.equals("MAKETIME"))
			return 0;
		if (strFieldName.equals("MODIFYDATE"))
			return 0;
		if (strFieldName.equals("MODIFYTIME"))
			return 0;
		if (strFieldName.equals("BANKTYPE"))
			return 0;
		if (strFieldName.equals("CALFLAG"))
			return 0;
		if (strFieldName.equals("BUSILICENSECODE"))
			return 0;
		if (strFieldName.equals("INSUREID"))
			return 0;
		if (strFieldName.equals("INSUREPRINCIPAL"))
			return 0;
		if (strFieldName.equals("CHIEFBUSINESS"))
			return 0;
		if (strFieldName.equals("BUSIADDRESS"))
			return 0;
		if (strFieldName.equals("SUBSCRIBEMAN"))
			return 0;
		if (strFieldName.equals("SUBSCRIBEMANDUTY"))
			return 0;
		if (strFieldName.equals("LICENSENO"))
			return 0;
		if (strFieldName.equals("REGIONALISMCODE"))
			return 0;
		if (strFieldName.equals("APPAGENTCOM"))
			return 0;
		if (strFieldName.equals("STATE"))
			return 0;
		if (strFieldName.equals("NOTI"))
			return 0;
		if (strFieldName.equals("BUSINESSCODE"))
			return 0;
		if (strFieldName.equals("LICENSESTARTDATE"))
			return 0;
		if (strFieldName.equals("LICENSEENDDATE"))
			return 0;
		if (strFieldName.equals("COMTYPE"))
			return 0;
		if (strFieldName.equals("ETL_DATATIME"))
			return 0;
		return !strFieldName.equals("ETL_DATATYPE") ? -1 : 0;
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
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 15: // '\017'
			nFieldType = 0;
			break;

		case 16: // '\020'
			nFieldType = 0;
			break;

		case 17: // '\021'
			nFieldType = 0;
			break;

		case 18: // '\022'
			nFieldType = 0;
			break;

		case 19: // '\023'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 24: // '\030'
			nFieldType = 0;
			break;

		case 25: // '\031'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 32: // ' '
			nFieldType = 0;
			break;

		case 33: // '!'
			nFieldType = 0;
			break;

		case 34: // '"'
			nFieldType = 0;
			break;

		case 35: // '#'
			nFieldType = 0;
			break;

		case 36: // '$'
			nFieldType = 0;
			break;

		case 37: // '%'
			nFieldType = 0;
			break;

		case 38: // '&'
			nFieldType = 0;
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
			nFieldType = 0;
			break;

		case 45: // '-'
			nFieldType = 0;
			break;

		default:
			nFieldType = -1;
			break;
		}
		return nFieldType;
	}
}
