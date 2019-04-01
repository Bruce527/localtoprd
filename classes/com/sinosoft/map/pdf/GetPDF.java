// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GetPDF.java

package com.sinosoft.map.pdf;

import com.sinosoft.map.lis.pubfun.FtpFunEX;
import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.*;

// Referenced classes of package com.sinosoft.map.pdf:
//			Rdx2Pdf

public class GetPDF
{

	public String firstRdxPath;
	public String secondRdxPath;
	public String newPdfPath;
	private String fullDirPath;
	private String newRdxDirpath;
	private String newPdfDirPath;
	public String ftpAddress;
	public String ftpPort;
	public String ftpUserName;
	public String ftpPassword;
	private int amount;

	public GetPDF()
	{
		firstRdxPath = "";
		secondRdxPath = "";
		newPdfPath = "";
		fullDirPath = "";
		newRdxDirpath = "";
		newPdfDirPath = "";
		ftpAddress = "";
		ftpPort = "";
		ftpUserName = "";
		ftpPassword = "";
		amount = 0;
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

	public boolean getPdf(String year, String month, String day)
	{
label0:
		{
			FtpFunEX tFtpFun;
			String ftpRoot;
			String strDay;
			String strMonth;
			int intYear;
			String downFileFullName;
			boolean flagStr;
			String startTime;
			String endTime;
			String downSql;
			ExeSQL tExeSQL;
			SSRS tSSRS;
			boolean downFileFlag;
			int i;
			File curDir;
			String filePath;
			boolean flag;
			String filePaths[];
			String filedir;
			String filename;
			String aimpath;
			String aimname;
			int j;
			boolean ifOneFail;
			File f;
			try
			{
				tFtpFun = new FtpFunEX();
				ftpRoot = "/";
				strDay = "";
				strMonth = "";
				if (!day.equals("") && day != null)
				{
					int intDay = Integer.parseInt(day);
					strDay = (new StringBuilder("/")).append(intDay).toString();
				}
				if (!month.equals("") && month != null)
				{
					int intMonth = Integer.parseInt(month);
					strMonth = (new StringBuilder("/")).append(intMonth).toString();
				}
				if (!year.equals("") && year != null)
					break label0;
				System.out.println("----------Error:year is nessesary---");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}
			return false;
		}
		intYear = Integer.parseInt(year);
		downFileFullName = (new StringBuilder(String.valueOf(ftpRoot))).append(intYear).append(strMonth).append(strDay).toString();
		System.out.println((new StringBuilder("============= start download from ftp ====== downFileFullName==")).append(downFileFullName).toString());
		firstRdxPath = firstRdxPath.replace("\\", "/");
		tFtpFun.connectFtpServer(ftpAddress, Integer.parseInt(ftpPort), ftpUserName, ftpPassword);
		System.out.println((new StringBuilder("已经连接上ftp server")).append(tFtpFun.getSystemInfo()).toString());
		flagStr = tFtpFun.isFolderExist(downFileFullName);
		tFtpFun.closeConnect();
		if (!flagStr)
			return true;
		startTime = (new StringBuilder(String.valueOf(intYear))).append(strMonth).append(strDay).append(" 00:00:00.000").toString();
		endTime = (new StringBuilder(String.valueOf(intYear))).append(strMonth).append(strDay).append(" 23:59:59.999").toString();
		downSql = (new StringBuilder(" select rrf.r_rpt_file_rp from r_cv_case rcc  inner join r_case_file rcf on rcc.r_key= rcf.rcf_case_key  inner join R_RPT_FILE  rrf on rrf.r_rpt_file_key =rcf_file_key  inner join tb_application tb_app on  rcc.r_policy_num=tb_app.cd_policy_complement  inner join   tb_application_broker tb_a_b on  tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product and tb_app.cd_application=tb_a_b.cd_application  inner join laagent la on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode  where 1=1 and la.branchtype='1'  and rrf.r_rpt_file_btime >= '")).append(startTime).append("' ").append(" and rrf.r_rpt_file_btime<= '").append(endTime).append("' ").toString();
		tExeSQL = new ExeSQL();
		tSSRS = new SSRS();
		tSSRS = tExeSQL.execSQL(downSql);
		downFileFlag = true;
		if (tSSRS == null || tSSRS.MaxRow == 0)
			return true;
		for (i = 1; i <= tSSRS.MaxRow; i++)
		{
			filePath = tSSRS.GetText(i, 1);
			filePaths = filePath.split("\\\\");
			filedir = "";
			filename = "";
			aimpath = "";
			aimname = "";
			System.out.print((new StringBuilder("--filePath.length()--")).append(filePaths.length).toString());
			for (j = 0; j < filePaths.length - 1; j++)
			{
				if (j == 0)
				{
					filedir = (new StringBuilder(String.valueOf(filedir))).append(ftpRoot).append(filePaths[j]).toString();
					aimpath = (new StringBuilder(String.valueOf(aimpath))).append(firstRdxPath).append("/").append(filePaths[j]).toString();
				} else
				{
					filedir = (new StringBuilder(String.valueOf(filedir))).append("/").append(filePaths[j]).toString();
					aimpath = (new StringBuilder(String.valueOf(firstRdxPath))).append(filedir).toString();
				}
				f = new File(aimpath);
				if (!f.exists())
					f.mkdirs();
			}

			filename = filePaths[filePaths.length - 1];
			aimname = filename;
			System.out.println((new StringBuilder("--filedir-FTP文件路径 -")).append(filedir).toString());
			System.out.println((new StringBuilder("--filename-FTP文件名-")).append(filename).toString());
			System.out.println((new StringBuilder("--aimpath-")).append(aimpath).toString());
			System.out.println((new StringBuilder("--aimname-目标文件名 -")).append(aimname).toString());
			tFtpFun.connectFtpServer(ftpAddress, Integer.parseInt(ftpPort), ftpUserName, ftpPassword);
			System.out.println((new StringBuilder("已经连接上ftp server")).append(tFtpFun.getSystemInfo()).toString());
			ifOneFail = tFtpFun.downloadFile(filedir, filename, aimpath, aimname);
			if (!ifOneFail)
				downFileFlag = false;
		}

		System.out.println("=============download rdx ok =============== ");
		fullDirPath = downFileFullName;
		System.out.println((new StringBuilder("============= start modify root element and save  ====")).append(firstRdxPath).append(fullDirPath).toString());
		curDir = new File((new StringBuilder(String.valueOf(firstRdxPath))).append(fullDirPath).toString());
		if (!curDir.exists())
			curDir.mkdirs();
		flag = getFile(downFileFullName);
		System.out.println("===========create pdf  ok====");
		return flag && downFileFlag;
	}

	private boolean getFile(File file)
	{
		amount++;
		if (file.isDirectory())
		{
			if (amount > 1)
				fullDirPath = file.getAbsolutePath();
			File f[] = file.listFiles();
			newRdxDirpath = fullDirPath.replace("download_", "xml_");
			newRdxDirpath = newRdxDirpath.replace("\\", "/");
			File newRdxdir = new File(newRdxDirpath);
			System.out.println((new StringBuilder("==new rdx dir=")).append(newRdxDirpath).toString());
			if (!newRdxdir.exists())
				newRdxdir.mkdirs();
			newPdfDirPath = fullDirPath.replace("download_", "pdf_");
			newPdfDirPath = newPdfDirPath.replace("\\", "/");
			System.out.println((new StringBuilder("===new pdf dir===")).append(newPdfDirPath).toString());
			File newpdfdir = new File(newPdfDirPath);
			if (!newpdfdir.exists())
				newpdfdir.mkdirs();
			for (int i = 0; i < f.length; i++)
			{
				getFile(f[i]);
				amount++;
			}

		}
		if (file.isFile())
		{
			String newRdx = modifyRdx(file);
			String newPdf = newRdx.replace("xml_", "pdf_").replace(".xml", ".pdf");
			if (file.getName().contains(".rdx"))
			{
				boolean flag1 = changeToPdf(newRdx, newPdf);
				if (!flag1)
					return false;
			}
		}
		return true;
	}

	private String modifyRdx(File file)
	{
		String fileName = file.getName();
		String newXmlFile = file.getAbsolutePath().replace("download_", "xml_").replace(".rdx", ".xml");
		newXmlFile = newXmlFile.replace("\\", "/");
		if (fileName.contains(".rdx"))
		{
			File f1 = new File(newXmlFile);
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				FileWriter fw = new FileWriter(f1);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1), "UTF-8"));
				String text;
				while ((text = br.readLine()) != null) 
				{
					if (text.contains("<Report "))
						text = "<Report>";
					bw.write(text);
					bw.newLine();
				}
				bw.close();
				fw.close();
				br.close();
			}
			catch (Exception exception) { }
		}
		return newXmlFile;
	}

	public boolean changeToPdf(String rdxpath, String pdfPath)
	{
		boolean flag = Rdx2Pdf.ChangeToPdf(rdxpath, pdfPath);
		return flag;
	}

	private boolean getFile(String downLoadPath)
	{
		File rdxFile = new File((new StringBuilder(String.valueOf(firstRdxPath))).append(downLoadPath).toString());
		if (!rdxFile.exists())
			return false;
		if (rdxFile.isDirectory())
		{
			File f[] = rdxFile.listFiles();
			File newRdxdir = new File((new StringBuilder(String.valueOf(secondRdxPath))).append(downLoadPath).toString());
			if (!newRdxdir.exists())
				newRdxdir.mkdirs();
			File newpdfdir = new File((new StringBuilder(String.valueOf(newPdfPath))).append(downLoadPath).toString());
			System.out.println((new StringBuilder("===new pdf dir===")).append(newpdfdir).toString());
			if (!newpdfdir.exists())
				newpdfdir.mkdirs();
			for (int i = 0; i < f.length; i++)
				getFile((new StringBuilder(String.valueOf(downLoadPath))).append("/").append(f[i].getName()).toString());

		}
		if (rdxFile.isFile())
		{
			String newRdx = modifyRdx(rdxFile, downLoadPath);
			if (rdxFile.getName().contains(".rdx"))
			{
				String newPdf = (new StringBuilder(String.valueOf(newPdfPath))).append(downLoadPath).toString().replace(".rdx", ".pdf");
				boolean flag1 = changeToPdf(newRdx, newPdf);
				if (!flag1)
					return false;
			}
		}
		return true;
	}

	private String modifyRdx(File file, String downLoadPath)
	{
		String fileName = file.getName();
		String newXmlFile = (new StringBuilder(String.valueOf(secondRdxPath))).append(downLoadPath).toString().replace(".rdx", ".xml");
		if (fileName.contains(".rdx"))
		{
			File f1 = new File(newXmlFile);
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				FileWriter fw = new FileWriter(f1);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f1), "UTF-8"));
				String text;
				while ((text = br.readLine()) != null) 
				{
					if (text.contains("<Report "))
						text = "<Report>";
					bw.write(text);
					bw.newLine();
				}
				bw.close();
				fw.close();
				br.close();
			}
			catch (Exception exception) { }
		}
		return newXmlFile;
	}

	public static void main(String a[])
	{
		File f = new File("D:/1111111111/111.txt");
	}
}
