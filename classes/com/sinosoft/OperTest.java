// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OperTest.java

package com.sinosoft;


public class OperTest
{

	public OperTest()
	{
	}

	public static void main(String args[])
	{
		OperTest test = new OperTest();
		test.tset01();
	}

	private void tset01()
	{
		String arg1[] = {
			"A", "E", "D", "C", "B"
		};
		String find1[] = {
			"C", "B"
		};
		String find2[] = {
			"C", "E"
		};
		for (int i = 0; i < arg1.length; i++)
		{
			boolean flag = false;
			for (int j = 0; j < find1.length; j++)
			{
				if (!find1[j].equals(arg1[i]))
					continue;
				flag = true;
				break;
			}

			if (!flag)
			{
				for (int k = 0; k < find2.length; k++)
				{
					if (!find2[k].equals(arg1[i]))
						continue;
					flag = true;
					break;
				}

			}
		}

	}
}
