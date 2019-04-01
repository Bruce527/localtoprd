// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalendarEx.java

package com.sinosoft.banklns.utility;

import javax.swing.JFrame;

// Referenced classes of package com.sinosoft.banklns.utility:
//			JCalendar

public class CalendarEx
{

	public CalendarEx()
	{
	}

	public static void main(String args[])
	{
		JFrame f = new JFrame();
		f.setContentPane(new JCalendar());
		f.pack();
		f.show();
	}
}
