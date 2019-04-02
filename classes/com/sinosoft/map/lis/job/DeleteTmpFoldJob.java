// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DeleteTmpFoldJob.java

package com.sinosoft.map.lis.job;

import com.sinosoft.map.utility.ExeSQL;
import com.sinosoft.map.utility.SSRS;
import java.io.File;
import java.io.PrintStream;
import java.util.Date;
import org.quartz.*;

public class DeleteTmpFoldJob
	implements Job
{

	public DeleteTmpFoldJob()
	{
	}

	public void execute(JobExecutionContext arg0)
		throws JobExecutionException
	{
		ExeSQL tExeSQL = new ExeSQL();
		String delPathSQL = "select varvalue from msysvar where vartype='reportPath'";
		SSRS tSSRS = tExeSQL.execSQL(delPathSQL);
		if (tSSRS != null && tSSRS.MaxCol > 0 && tSSRS.GetText(1, 1) != null && !"".equals(tSSRS.GetText(1, 1).trim()))
		{
			String delPath = tSSRS.GetText(1, 1);
			deleteDirectory(delPath);
		}
	}

	private void deleteDirectory(String tmpPath)
	{
		File file = new File(tmpPath);
		if (file.exists() && file.isDirectory())
		{
			File files[] = file.listFiles();
			boolean flag = false;
			for (int i = 0; i < files.length; i++)
			{
				Date filemakedate = new Date(files[i].lastModified());
				String filemakedateString = (new StringBuilder(String.valueOf(Integer.toString(filemakedate.getYear())))).append(Integer.toString(filemakedate.getMonth())).append(Integer.toString(filemakedate.getDate())).toString();
				Date now = new Date();
				String nowString = (new StringBuilder(String.valueOf(Integer.toString(now.getYear())))).append(Integer.toString(now.getMonth())).append(Integer.toString(now.getDate())).toString();
				if (filemakedateString.equals(nowString))
					continue;
				flag = deleteFile(files[i].getAbsolutePath());
				if (flag)
					continue;
				System.out.println((new StringBuilder("删除临时文件")).append(files[i].getName()).append("失败！").toString());
				break;
			}

			if (flag)
				System.out.println("删除临时文件成功！");
			else
				System.out.println("删除临时文件失败！");
		}
	}

	public static boolean deleteFile(String fileName)
	{
		File file = new File(fileName);
		if (file.exists() && file.isFile())
			return file.delete();
		else
			return false;
	}

	public static void main(String args[])
	{
		ExeSQL tExeSQL = new ExeSQL();
		String delPathSQL = "select varvalue from msysvar where vartype='reportPath'";
		SSRS tSSRS = tExeSQL.execSQL(delPathSQL);
		DeleteTmpFoldJob tt = new DeleteTmpFoldJob();
		if (tSSRS != null && tSSRS.MaxCol > 0 && tSSRS.GetText(1, 1) != null && !"".equals(tSSRS.GetText(1, 1).trim()))
		{
			String delPath = tSSRS.GetText(1, 1);
			tt.deleteDirectory(delPath);
		}
	}
}
