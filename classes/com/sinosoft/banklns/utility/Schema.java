// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Schema.java

package com.sinosoft.banklns.utility;


public interface Schema
{

	public static final int TYPE_NOFOUND = -1;
	public static final int TYPE_MIN = -1;
	public static final int TYPE_STRING = 0;
	public static final int TYPE_DATE = 1;
	public static final int TYPE_FLOAT = 2;
	public static final int TYPE_INT = 3;
	public static final int TYPE_DOUBLE = 4;
	public static final int TYPE_MAX = 5;

	public abstract String[] getPK();

	public abstract String getV(String s);

	public abstract String getV(int i);

	public abstract int getFieldType(String s);

	public abstract int getFieldType(int i);

	public abstract int getFieldCount();

	public abstract int getFieldIndex(String s);

	public abstract String getFieldName(int i);

	public abstract boolean setV(String s, String s1);
}
