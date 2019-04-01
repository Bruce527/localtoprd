// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileViewer.java

package com.sinosoft.map.utility;

import java.io.File;
import java.util.*;

public class FileViewer
{

	File myDir;
	File contents[];
	Vector vectorList;
	Iterator currentFileView;
	File currentFile;
	String path;

	public FileViewer()
	{
		path = new String("");
		vectorList = new Vector();
	}

	public FileViewer(String path)
	{
		this.path = path;
		vectorList = new Vector();
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getDirectory()
	{
		return myDir.getPath();
	}

	public void refreshList()
	{
		if (path.equals(""))
			path = "c:\\";
		myDir = new File(path);
		vectorList.clear();
		contents = myDir.listFiles();
		for (int i = 0; i < contents.length; i++)
			vectorList.add(contents[i]);

		currentFileView = vectorList.iterator();
	}

	public boolean nextFile()
	{
		if (currentFileView.hasNext())
		{
			currentFile = (File)currentFileView.next();
			return true;
		} else
		{
			return false;
		}
	}

	public String getFileName()
	{
		return currentFile.getName();
	}

	public String getFileSize()
	{
		return (new Long(currentFile.length())).toString();
	}

	public String getFileTimeStamp()
	{
		return (new Date(currentFile.lastModified())).toString();
	}

	public boolean getFileType()
	{
		return currentFile.isDirectory();
	}

	public static void main(String args1[])
	{
	}
}
