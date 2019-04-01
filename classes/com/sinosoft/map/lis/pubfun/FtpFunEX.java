// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FtpFunEX.java

package com.sinosoft.map.lis.pubfun;

import java.io.*;
import java.util.*;
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.*;

public class FtpFunEX
{

	private FtpClient mFtpClient;
	private OutputStream upOS;
	private FileInputStream upIS;
	private OutputStream downOS;
	private FileInputStream downIS;
	private String upFileFullName;
	private String defPath;
	private String downFileFullName;
	private List FileList;
	public boolean downFileIsEmpty;

	public FtpFunEX()
	{
		mFtpClient = null;
		upOS = null;
		upIS = null;
		downOS = null;
		downIS = null;
		upFileFullName = "";
		defPath = "";
		downFileFullName = "";
		FileList = new ArrayList();
		downFileIsEmpty = true;
	}

	public FtpClient connectFtpServer(String hostname, int port, String username, String password)
	{
		try
		{
			mFtpClient = new FtpClient(hostname, port);
			mFtpClient.login(username, password);
		}
		catch (FtpLoginException e1)
		{
			System.out.print("...... �û����������? ......");
			e1.printStackTrace();
			return null;
		}
		catch (IOException e2)
		{
			System.out.println("...... δ֪���� ......");
			e2.printStackTrace();
			return null;
		}
		catch (SecurityException e3)
		{
			System.out.print("...... Ȩ�޲��� ......");
			e3.printStackTrace();
			return null;
		}
		return mFtpClient;
	}

	public boolean downloadFile(String ftppath, String ftpname, String aimpath, String aimname)
	{
		try
		{
			if (ftppath.length() != 0)
				mFtpClient.cd(ftppath);
			mFtpClient.binary();
			TelnetInputStream tis = mFtpClient.get((new StringBuilder(String.valueOf(ftppath))).append("/").append(ftpname).toString());
			if (aimname.length() == 0)
				aimname = ftpname;
			File outFile = new File((new StringBuilder(String.valueOf(aimpath))).append("/").append(aimname).toString());
			FileOutputStream fos = new FileOutputStream(outFile);
			byte bytes[] = new byte[2048];
			int c;
			while ((c = tis.read(bytes)) != -1) 
				fos.write(bytes, 0, c);
			tis.close();
			fos.close();
			mFtpClient.closeServer();
		}
		catch (IOException ex)
		{
			System.out.println("...... �����ļ�ʧ�� ......");
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean uploadFile(String inPath, String inFilename, String outPath, String outFilename)
	{
		try
		{
			if (outPath.length() != 0)
				mFtpClient.cd(outPath);
			mFtpClient.binary();
			TelnetOutputStream tos = mFtpClient.put(outFilename);
			File inFile = new File((new StringBuilder(String.valueOf(inPath))).append(inFilename).toString());
			System.out.println((new StringBuilder("...... �����ļ���С:")).append(inFile.length() / 1024L).append("K ......").toString());
			FileInputStream fis = new FileInputStream(inFile);
			System.out.println((new StringBuilder("===== uplaodFile===")).append(inPath).append("\\").append(inFilename).toString());
			byte bytes[] = new byte[2048];
			int c;
			while ((c = fis.read(bytes)) != -1) 
				tos.write(bytes, 0, c);
			fis.close();
			tos.close();
			mFtpClient.closeServer();
		}
		catch (FtpProtocolException ex1)
		{
			System.out.println("...... �����ڸ�Ŀ¼�´����ļ� ......");
			ex1.printStackTrace();
			return false;
		}
		catch (IOException ex2)
		{
			System.out.println("...... δ֪���� ......");
			ex2.printStackTrace();
			return false;
		}
		return true;
	}

	public String getSystemInfo()
	{
		String systemInfo = null;
		try
		{
			systemInfo = mFtpClient.system();
		}
		catch (IOException ex)
		{
			System.out.println("......�õ�ϵͳ��Ϣ���?......");
			ex.printStackTrace();
		}
		return systemInfo;
	}

	public boolean uploadFolder(String upFileFullName, String folderName, String aimPath)
	{
		this.upFileFullName = upFileFullName;
		try
		{
			String savefilename = new String(this.upFileFullName.getBytes("ISO-8859-1"), "UTF-8");
			File file_in = new File(savefilename);
			mFtpClient.cd(aimPath);
			mFtpClient.list();
			processUpFile(file_in, mFtpClient);
			if (upIS != null)
				upIS.close();
			if (upOS != null)
				upOS.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println((new StringBuilder("Exception e in Ftp upload(): ")).append(e.toString()).toString());
			return false;
		}
		return true;
	}

	private void processUpFile(File source, FtpClient ftpClient)
	{
		try
		{
			if (source.exists())
				if (source.isDirectory())
				{
					String tempPaht = source.getPath().substring(upFileFullName.length()).replace("\\", "/");
					if (!isFolderExist(tempPaht, ftpClient))
					{
						createFolder(tempPaht, ftpClient);
					} else
					{
						String xxx[] = tempPaht.split("/");
						for (int n = 0; n < xxx.length; n++)
							if (!xxx[n].equals(""))
								ftpClient.cdUp();

					}
					File sourceFile[] = source.listFiles();
					for (int i = 0; i < sourceFile.length; i++)
						if (sourceFile[i].exists())
							if (sourceFile[i].isDirectory())
							{
								processUpFile(sourceFile[i], ftpClient);
							} else
							{
								String cdPath = cheangPath(sourceFile[i].getPath(), upFileFullName);
								ftpClient.cd(cdPath);
								ftpClient.binary();
								upOS = ftpClient.put(sourceFile[i].getName());
								byte bytes[] = new byte[5120];
								upIS = new FileInputStream(sourceFile[i]);
								int c;
								while ((c = upIS.read(bytes)) != -1) 
									upOS.write(bytes, 0, c);
								upIS.close();
								upOS.close();
								String mmm[] = cdPath.split("/");
								for (int n = 0; n < mmm.length; n++)
									if (!mmm[n].equals(""))
										ftpClient.cdUp();

							}

				} else
				{
					ftpClient.cd(cheangPath(source.getPath(), upFileFullName));
					ftpClient.binary();
					upOS = ftpClient.put(source.getName());
					byte bytes[] = new byte[5120];
					upIS = new FileInputStream(source);
					int c;
					while ((c = upIS.read(bytes)) != -1) 
						upOS.write(bytes, 0, c);
					upIS.close();
					upOS.close();
				}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String downFolder(String downFileFullName, String toAimPath)
	{
		System.out.println((new StringBuilder("================================= FtpFunEX== start downFlolder===root=")).append(downFileFullName).append(" ===download to= ").append(toAimPath).toString());
		this.downFileFullName = downFileFullName;
		String flag = "";
		try
		{
			makeFolder((new StringBuilder(String.valueOf(toAimPath))).append(downFileFullName).toString());
			flag = processDownFile(downFileFullName, (new StringBuilder(String.valueOf(toAimPath))).append(downFileFullName).toString(), mFtpClient);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println((new StringBuilder("Exception e in Ftp download(): ")).append(e.toString()).toString());
			flag = "E";
		}
		return flag;
	}

	public String processDownFile(String source, String toAimPath, FtpClient ftpClient)
	{
		try
		{
			ftpClient.cd(source);
		}
		catch (FileNotFoundException r)
		{
			return "N";
		}
		try
		{
			DataInputStream tDataInputStream = new DataInputStream(ftpClient.list());
			String filename = "";
			String temp[] = null;
			while ((filename = tDataInputStream.readLine()) != null) 
			{
				filename = new String(filename.getBytes("ISO-8859-1"), "gbk");
				temp = filename.split(" ");
				String filename2 = temp[temp.length - 1].trim();
				if (!filename2.equals(".") && !filename2.equals(".."))
					if (filename2.indexOf(".") == -1)
					{
						FileList.add((new StringBuilder("/")).append(filename2).toString());
						processDownFile(filename2, toAimPath, ftpClient);
					} else
					{
						downFileIsEmpty = false;
						ftpClient.binary();
						String temppath = getWritePath(FileList);
						makeFolder((new StringBuilder(String.valueOf(toAimPath))).append(temppath).toString());
						TelnetInputStream tis = ftpClient.get(filename2);
						File outFile = new File((new StringBuilder(String.valueOf(toAimPath))).append(temppath).append("/").append(filename2).toString());
						FileOutputStream fos = new FileOutputStream(outFile);
						byte bytes[] = new byte[5120];
						int c;
						while ((c = tis.read(bytes)) != -1) 
							fos.write(bytes, 0, c);
						tis.close();
						fos.close();
					}
			}
			if (!FileList.isEmpty())
				FileList.remove(FileList.size() - 1);
			ftpClient.cdUp();
			tDataInputStream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public boolean renameFolder(String oldname, String newname)
	{
		try
		{
			mFtpClient.rename(oldname, newname);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean moveFile(String oldname, String newname)
	{
		try
		{
			mFtpClient.rename(oldname, newname);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean createFolder(String folder, FtpClient ftpClient)
	{
		try
		{
			ftpClient.ascii();
			StringTokenizer s = new StringTokenizer(folder, "/");
			s.countTokens();
			String pathName = "";
			for (; s.hasMoreElements(); ftpClient.readServerResponse())
			{
				pathName = (new StringBuilder(String.valueOf(pathName))).append("/").append((String)s.nextElement()).toString();
				if (pathName.substring(0, 1).equals("/"))
					pathName = pathName.substring(1);
				ftpClient.sendServer((new StringBuilder("MKD ")).append(pathName).append("\r\n").toString());
			}

			ftpClient.binary();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean createFolder(String folder)
	{
		try
		{
			mFtpClient.ascii();
			StringTokenizer s = new StringTokenizer(folder, "/");
			s.countTokens();
			String pathName = "";
			for (; s.hasMoreElements(); mFtpClient.readServerResponse())
			{
				pathName = (new StringBuilder(String.valueOf(pathName))).append("/").append((String)s.nextElement()).toString();
				if (pathName.substring(0, 1).equals("/"))
					pathName = pathName.substring(1);
				mFtpClient.sendServer((new StringBuilder("MKD ")).append(pathName).append("\r\n").toString());
			}

			mFtpClient.binary();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean isFolderExist(String dir, FtpClient ftpClient)
	{
		try
		{
			ftpClient.cd(dir);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean isFolderExist(String dir)
	{
		if (mFtpClient != null)
			return isFolderExist(dir, mFtpClient);
		else
			return false;
	}

	public boolean cdFolderIn(String path)
	{
		try
		{
			mFtpClient.cd(path);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean cdFolderUp()
	{
		try
		{
			mFtpClient.cdUp();
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean closeConnect()
	{
		try
		{
			mFtpClient.closeServer();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getWritePath(List list)
	{
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < list.size(); i++)
			temp.append(list.get(i).toString());

		return temp.toString();
	}

	private String cheangPath(String path, String path2)
	{
		path = path.substring(path2.length()).replace("\\", "/");
		if ("".equals(path))
			path = "/";
		else
			path = path.substring(0, path.lastIndexOf("/") + 1);
		if (path.substring(0, 1).equals("/"))
			path = path.substring(1);
		return path;
	}

	private void makeFolder(String folderPath)
	{
		try
		{
			StringTokenizer s = new StringTokenizer(folderPath, "/");
			s.countTokens();
			String pathName = "";
			while (s.hasMoreElements()) 
			{
				pathName = (new StringBuilder(String.valueOf(pathName))).append("/").append((String)s.nextElement()).toString();
				File folder = new File(pathName);
				if (!folder.exists() && !folder.mkdirs())
				{
					System.out.println(" �ļ��д���ʧ�ܣ���ȷ�ϴ���û��д�������ҿռ��㹻");
					System.exit(1);
				}
			}
		}
		catch (Exception err)
		{
			System.err.println("�ļ��д��������쳣");
			err.printStackTrace();
		}
	}

	private static boolean test2()
	{
		String tPath = "D:/lis3.txt";
		File file = new File(tPath);
		if (file.isDirectory())
			System.out.println("�����ļ���");
		if (file.isFile())
			System.out.println("�����ļ�");
		if (file.exists())
		{
			System.out.println("��·�������ļ�����");
			return true;
		} else
		{
			System.out.println("�Ҳ���·�������ļ�");
			return true;
		}
	}

	public static void main(String args[])
	{
		FtpFunEX tFtpFun = new FtpFunEX();
		FtpClient tFtpClient = tFtpFun.connectFtpServer("192.168.2.200", 21, "administrator", "2010");
		if (tFtpClient != null)
		{
			System.out.println((new StringBuilder("�Ѿ�l����ftp server")).append(tFtpFun.getSystemInfo()).toString());
			tFtpFun.moveFile("/ReturnData", "/ReturnDataBackup/2009-11-21");
		}
	}
}
