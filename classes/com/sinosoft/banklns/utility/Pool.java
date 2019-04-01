// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Pool.java

package com.sinosoft.banklns.utility;


// Referenced classes of package com.sinosoft.banklns.utility:
//			ThreadPool

public class Pool
{

	private static ThreadPool tThreadPool = new ThreadPool();

	public Pool()
	{
	}

	public static ThreadPool getThreadPool()
	{
		return tThreadPool;
	}

	public static void main(String args[])
	{
		Pool pool1 = new Pool();
	}

}
