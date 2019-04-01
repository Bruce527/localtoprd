// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Clock.java

package com.sinosoft.banklns.utility;

import java.awt.*;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Referenced classes of package com.sinosoft.banklns.utility:
//			TestClock

class Clock extends Canvas
	implements Runnable
{

	TestClock mf;
	Thread t;
	String time;

	Clock(TestClock mf)
	{
		this.mf = mf;
		setSize(400, 40);
		setBackground(Color.white);
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		do
		{
			try
			{
				Thread.sleep(1000L);
			}
			catch (InterruptedException e)
			{
				System.out.println("�쳣");
			}
			repaint(100L);
		} while (true);
	}

	public void paint(Graphics g)
	{
		Font f = new Font("����", 1, 16);
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy'��'MM'��'dd'��'HH:mm:ss");
		Calendar now = Calendar.getInstance();
		time = SDF.format(now.getTime());
		g.setFont(f);
		g.setColor(Color.orange);
		g.drawString(time, 100, 25);
	}
}
