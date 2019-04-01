// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ModifyCaseFileDown.java

package com.sinosoft.map.lis.batch;

import com.sinosoft.map.ec.utility.ECPubFun;
import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.CaseFileDownlLogSchema;
import com.sinosoft.map.pdf.GetPDF;
import com.sinosoft.map.utility.*;
import java.io.PrintStream;

public class ModifyCaseFileDown
{

	private String tCalStatYM;
	private String tCalStartDate;
	private String firstRdxPath;
	private String secondRdxPath;
	private String newPdfPath;
	private String ftpAddress;
	private String ftpPort;
	private String ftpUserName;
	private String ftpPassword;

	public ModifyCaseFileDown()
	{
		tCalStatYM = "";
		tCalStartDate = "";
		firstRdxPath = "";
		secondRdxPath = "";
		newPdfPath = "";
		ftpAddress = "";
		ftpPort = "";
		ftpUserName = "";
		ftpPassword = "";
	}

	public void getInitPath()
	{
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql1 = " select varvalue from msysvar where vartype='casedownloadfile' ";
		tSSRS = tExeSQL.execSQL(sql1);
		firstRdxPath = tSSRS.GetText(1, 1);
		String sql2 = " select varvalue from msysvar where vartype='casexmlfile' ";
		tSSRS = tExeSQL.execSQL(sql2);
		secondRdxPath = tSSRS.GetText(1, 1);
		String sql3 = " select varvalue from msysvar where vartype='casepdffile' ";
		tSSRS = tExeSQL.execSQL(sql3);
		newPdfPath = tSSRS.GetText(1, 1);
		String sql4 = " select varvalue from msysvar where vartype='ftpaddress' ";
		tSSRS = tExeSQL.execSQL(sql4);
		ftpAddress = tSSRS.GetText(1, 1);
		String sql5 = " select varvalue from msysvar where vartype='ftpport' ";
		tSSRS = tExeSQL.execSQL(sql5);
		ftpPort = tSSRS.GetText(1, 1);
		String sql6 = " select varvalue from msysvar where vartype='ftpusername' ";
		tSSRS = tExeSQL.execSQL(sql6);
		ftpUserName = tSSRS.GetText(1, 1);
		String sql7 = " select varvalue from msysvar where vartype='ftppassword' ";
		tSSRS = tExeSQL.execSQL(sql7);
		ftpPassword = tSSRS.GetText(1, 1);
	}

	public void newBatch()
	{
		getInitPath();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String curDate = ECPubFun.getCurrentDate();
		String sql2 = (new StringBuilder(" select year(dateadd(dd,-1,'")).append(curDate).append("')),month(dateadd(dd,-1,'").append(curDate).append("')),day(dateadd(dd,-1,'").append(curDate).append("')) ").append(" from msysvar where vartype='onerow'").toString();
		tSSRS = tExeSQL.execSQL(sql2);
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			String year = tSSRS.GetText(1, 1);
			String month = tSSRS.GetText(1, 2);
			String day = tSSRS.GetText(1, 3);
			GetPDF tGetPDF = new GetPDF();
			tGetPDF.firstRdxPath = firstRdxPath;
			tGetPDF.secondRdxPath = secondRdxPath;
			tGetPDF.newPdfPath = newPdfPath;
			tGetPDF.ftpAddress = ftpAddress;
			tGetPDF.ftpPort = ftpPort;
			tGetPDF.ftpUserName = ftpUserName;
			tGetPDF.ftpPassword = ftpPassword;
			CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
			PubSubmit pb = new PubSubmit();
			MMap map = new MMap();
			String fileDate = (new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString();
			String selectSql = (new StringBuilder(" select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('")).append(fileDate).append("' as datetime) ").toString();
			tSSRS = tExeSQL.execSQL(selectSql);
			if (tSSRS == null || tSSRS.MaxRow == 0)
			{
				SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MCaseFileDownNO", 10, 1);
				String modifyDate = ECPubFun.getCurrentDate();
				String modifyTime = ECPubFun.getCurrentTime();
				String tID = tSysMaxNoMap.next();
				tCaseFileDownlLogSchema.setId(tID);
				tCaseFileDownlLogSchema.setFDownDate(modifyDate);
				tCaseFileDownlLogSchema.setFDownTime(modifyTime);
				tCaseFileDownlLogSchema.setFileDate(fileDate);
				tCaseFileDownlLogSchema.setModifyDate(modifyDate);
				tCaseFileDownlLogSchema.setModityTime(modifyTime);
				tCaseFileDownlLogSchema.setLastOperator("sys");
				tCaseFileDownlLogSchema.setFlag("01");
				map.put(tCaseFileDownlLogSchema, "INSERT");
				VData vd = new VData();
				vd.add(map);
				if (!pb.submitData(vd, ""))
					System.out.println(" INSERT failed ");
			} else
			if (tSSRS != null && tSSRS.MaxRow > 0)
			{
				tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
				tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
				tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
				tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
				String modifyDate = ECPubFun.getCurrentDate();
				String modifyTime = ECPubFun.getCurrentTime();
				tCaseFileDownlLogSchema.setModifyDate(modifyDate);
				tCaseFileDownlLogSchema.setModityTime(modifyTime);
				tCaseFileDownlLogSchema.setLastOperator("sys");
				tCaseFileDownlLogSchema.setFlag("01");
				map.put(tCaseFileDownlLogSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!pb.submitData(vd, ""))
					System.out.println(" update failed ");
			}
			boolean flag = tGetPDF.getPdf(year, month, day);
			if (flag)
			{
				tCaseFileDownlLogSchema.setFlag("02");
				map.put(tCaseFileDownlLogSchema, "UPDATE");
				VData vd = new VData();
				vd.add(map);
				if (!pb.submitData(vd, ""))
					System.out.println(" update failed ");
			}
		}
	}

	public void batch()
	{
		getInitPath();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = " select max(fileDate),dateadd(dd,-1,getDate())  ,datediff(dd,max(fileDate),dateadd(dd,-1,getDate()))  from CaseFileDownlLog  where flag='02' ";
		tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			String finDate = tSSRS.GetText(1, 1);
			int dateCount = Integer.parseInt(tSSRS.GetText(1, 3));
			if (dateCount > 0)
			{
				for (int i = 1; i <= dateCount; i++)
				{
					String sql2 = (new StringBuilder(" select year(dateadd(dd,")).append(i).append(",cast('").append(finDate).append("' as datetime))), ").append(" month(dateadd(dd,").append(i).append(",cast('").append(finDate).append("' as datetime))), ").append(" day(dateadd(dd,").append(i).append(",cast('").append(finDate).append("' as datetime))) ").append(" from msysvar where vartype='onerow' ").toString();
					tSSRS = tExeSQL.execSQL(sql2);
					if (tSSRS != null && tSSRS.MaxRow > 0)
					{
						String year = tSSRS.GetText(1, 1);
						String month = tSSRS.GetText(1, 2);
						String day = tSSRS.GetText(1, 3);
						GetPDF tGetPDF = new GetPDF();
						tGetPDF.firstRdxPath = firstRdxPath;
						tGetPDF.secondRdxPath = secondRdxPath;
						tGetPDF.newPdfPath = newPdfPath;
						tGetPDF.ftpAddress = ftpAddress;
						tGetPDF.ftpPort = ftpPort;
						tGetPDF.ftpUserName = ftpUserName;
						tGetPDF.ftpPassword = ftpPassword;
						CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
						PubSubmit pb = new PubSubmit();
						MMap map = new MMap();
						String fileDate = (new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString();
						String selectSql = (new StringBuilder(" select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('")).append(fileDate).append("' as datetime) ").toString();
						tSSRS = tExeSQL.execSQL(selectSql);
						if (tSSRS == null || tSSRS.MaxRow == 0)
						{
							SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MCaseFileDownNO", 10, 1);
							String modifyDate = ECPubFun.getCurrentDate();
							String modifyTime = ECPubFun.getCurrentTime();
							String tID = tSysMaxNoMap.next();
							tCaseFileDownlLogSchema.setId(tID);
							tCaseFileDownlLogSchema.setFDownDate(modifyDate);
							tCaseFileDownlLogSchema.setFDownTime(modifyTime);
							tCaseFileDownlLogSchema.setFileDate(fileDate);
							tCaseFileDownlLogSchema.setModifyDate(modifyDate);
							tCaseFileDownlLogSchema.setModityTime(modifyTime);
							tCaseFileDownlLogSchema.setLastOperator("sys");
							tCaseFileDownlLogSchema.setFlag("01");
							map.put(tCaseFileDownlLogSchema, "INSERT");
							VData vd = new VData();
							vd.add(map);
							if (!pb.submitData(vd, ""))
								System.out.println(" INSERT failed ");
						} else
						if (tSSRS != null && tSSRS.MaxRow > 0)
						{
							tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
							tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
							tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
							tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
							String modifyDate = ECPubFun.getCurrentDate();
							String modifyTime = ECPubFun.getCurrentTime();
							tCaseFileDownlLogSchema.setModifyDate(modifyDate);
							tCaseFileDownlLogSchema.setModityTime(modifyTime);
							tCaseFileDownlLogSchema.setLastOperator("sys");
							tCaseFileDownlLogSchema.setFlag("01");
							map.put(tCaseFileDownlLogSchema, "UPDATE");
							VData vd = new VData();
							vd.add(map);
							if (!pb.submitData(vd, ""))
								System.out.println(" update failed ");
						}
						boolean flag = tGetPDF.getPdf(year, month, day);
						if (flag)
						{
							tCaseFileDownlLogSchema.setFlag("02");
							map.put(tCaseFileDownlLogSchema, "UPDATE");
							VData vd = new VData();
							vd.add(map);
							if (!pb.submitData(vd, ""))
								System.out.println(" update failed ");
						}
					}
				}

			}
		}
	}

	public void doBatchByDate(String date)
	{
		getInitPath();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String strArr[] = date.split("-");
		String year = strArr[0];
		String month = strArr[1];
		String day = strArr[2];
		GetPDF tGetPDF = new GetPDF();
		tGetPDF.firstRdxPath = firstRdxPath;
		tGetPDF.secondRdxPath = secondRdxPath;
		tGetPDF.newPdfPath = newPdfPath;
		tGetPDF.ftpAddress = ftpAddress;
		tGetPDF.ftpPort = ftpPort;
		tGetPDF.ftpUserName = ftpUserName;
		tGetPDF.ftpPassword = ftpPassword;
		CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
		PubSubmit pb = new PubSubmit();
		MMap map = new MMap();
		String fileDate = (new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString();
		String selectSql = (new StringBuilder(" select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('")).append(fileDate).append("' as datetime) ").toString();
		tSSRS = tExeSQL.execSQL(selectSql);
		if (tSSRS == null || tSSRS.MaxRow == 0)
		{
			SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MCaseFileDownNO", 10, 1);
			String modifyDate = ECPubFun.getCurrentDate();
			String modifyTime = ECPubFun.getCurrentTime();
			String tID = tSysMaxNoMap.next();
			tCaseFileDownlLogSchema.setId(tID);
			tCaseFileDownlLogSchema.setFDownDate(modifyDate);
			tCaseFileDownlLogSchema.setFDownTime(modifyTime);
			tCaseFileDownlLogSchema.setFileDate(fileDate);
			tCaseFileDownlLogSchema.setModifyDate(modifyDate);
			tCaseFileDownlLogSchema.setModityTime(modifyTime);
			tCaseFileDownlLogSchema.setLastOperator("sys");
			tCaseFileDownlLogSchema.setFlag("01");
			map.put(tCaseFileDownlLogSchema, "INSERT");
			VData vd = new VData();
			vd.add(map);
			if (!pb.submitData(vd, ""))
				System.out.println(" INSERT failed ");
		} else
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
			tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
			tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
			tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
			String modifyDate = ECPubFun.getCurrentDate();
			String modifyTime = ECPubFun.getCurrentTime();
			tCaseFileDownlLogSchema.setModifyDate(modifyDate);
			tCaseFileDownlLogSchema.setModityTime(modifyTime);
			tCaseFileDownlLogSchema.setLastOperator("sys");
			tCaseFileDownlLogSchema.setFlag("01");
			map.put(tCaseFileDownlLogSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!pb.submitData(vd, ""))
				System.out.println(" update failed ");
		}
		boolean flag = tGetPDF.getPdf(year, month, day);
		if (flag)
		{
			tCaseFileDownlLogSchema.setFlag("02");
			map.put(tCaseFileDownlLogSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!pb.submitData(vd, ""))
				System.out.println(" update failed ");
		}
	}

	public void doBatchInDays(String beginDate, String endDate)
	{
		getInitPath();
		ExeSQL tExeSQL = new ExeSQL();
		SSRS tSSRS = new SSRS();
		String sql = (new StringBuilder(" select datediff(dd,'")).append(beginDate).append("','").append(endDate).append("')").append(" from msysvar where vartype='onerow' ").toString();
		tSSRS = tExeSQL.execSQL(sql);
		if (tSSRS != null && tSSRS.MaxRow > 0)
		{
			int dateCount = Integer.parseInt(tSSRS.GetText(1, 1));
			if (dateCount >= 0)
			{
				for (int i = 0; i <= dateCount; i++)
				{
					String sql2 = (new StringBuilder(" select year(dateadd(dd,")).append(i).append(",cast('").append(beginDate).append("' as datetime))), ").append(" month(dateadd(dd,").append(i).append(",cast('").append(beginDate).append("' as datetime))), ").append(" day(dateadd(dd,").append(i).append(",cast('").append(beginDate).append("' as datetime))) ").append(" from msysvar where vartype='onerow' ").toString();
					tSSRS = tExeSQL.execSQL(sql2);
					if (tSSRS != null && tSSRS.MaxRow > 0)
					{
						String year = tSSRS.GetText(1, 1);
						String month = tSSRS.GetText(1, 2);
						String day = tSSRS.GetText(1, 3);
						GetPDF tGetPDF = new GetPDF();
						tGetPDF.firstRdxPath = firstRdxPath;
						tGetPDF.secondRdxPath = secondRdxPath;
						tGetPDF.newPdfPath = newPdfPath;
						tGetPDF.ftpAddress = ftpAddress;
						tGetPDF.ftpPort = ftpPort;
						tGetPDF.ftpUserName = ftpUserName;
						tGetPDF.ftpPassword = ftpPassword;
						CaseFileDownlLogSchema tCaseFileDownlLogSchema = new CaseFileDownlLogSchema();
						PubSubmit pb = new PubSubmit();
						MMap map = new MMap();
						String fileDate = (new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString();
						String selectSql = (new StringBuilder(" select top 1 id,fileDate,fdowndate,fdowntime from CaseFileDownlLog where fileDate=cast('")).append(fileDate).append("' as datetime) ").toString();
						tSSRS = tExeSQL.execSQL(selectSql);
						if (tSSRS == null || tSSRS.MaxRow == 0)
						{
							SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MCaseFileDownNO", 10, 1);
							String modifyDate = ECPubFun.getCurrentDate();
							String modifyTime = ECPubFun.getCurrentTime();
							String tID = tSysMaxNoMap.next();
							tCaseFileDownlLogSchema.setId(tID);
							tCaseFileDownlLogSchema.setFDownDate(modifyDate);
							tCaseFileDownlLogSchema.setFDownTime(modifyTime);
							tCaseFileDownlLogSchema.setFileDate(fileDate);
							tCaseFileDownlLogSchema.setModifyDate(modifyDate);
							tCaseFileDownlLogSchema.setModityTime(modifyTime);
							tCaseFileDownlLogSchema.setLastOperator("sys");
							tCaseFileDownlLogSchema.setFlag("01");
							map.put(tCaseFileDownlLogSchema, "INSERT");
							VData vd = new VData();
							vd.add(map);
							if (!pb.submitData(vd, ""))
								System.out.println(" INSERT failed ");
						} else
						if (tSSRS != null && tSSRS.MaxRow > 0)
						{
							tCaseFileDownlLogSchema.setId(tSSRS.GetText(1, 1));
							tCaseFileDownlLogSchema.setFileDate(tSSRS.GetText(1, 2));
							tCaseFileDownlLogSchema.setFDownDate(tSSRS.GetText(1, 3));
							tCaseFileDownlLogSchema.setFDownTime(tSSRS.GetText(1, 4));
							String modifyDate = ECPubFun.getCurrentDate();
							String modifyTime = ECPubFun.getCurrentTime();
							tCaseFileDownlLogSchema.setModifyDate(modifyDate);
							tCaseFileDownlLogSchema.setModityTime(modifyTime);
							tCaseFileDownlLogSchema.setLastOperator("sys");
							tCaseFileDownlLogSchema.setFlag("01");
							map.put(tCaseFileDownlLogSchema, "UPDATE");
							VData vd = new VData();
							vd.add(map);
							if (!pb.submitData(vd, ""))
								System.out.println(" update failed ");
						}
						boolean flag = tGetPDF.getPdf(year, month, day);
						if (flag)
						{
							tCaseFileDownlLogSchema.setFlag("02");
							map.put(tCaseFileDownlLogSchema, "UPDATE");
							VData vd = new VData();
							vd.add(map);
							if (!pb.submitData(vd, ""))
								System.out.println(" update failed ");
						}
					}
				}

			}
		}
	}
}
