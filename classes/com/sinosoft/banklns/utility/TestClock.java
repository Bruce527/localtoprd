// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Clock.java

package com.sinosoft.banklns.utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			Clock

class TestClock extends JFrame
{

	JPanel panel;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel label[];
	JLabel y_label;
	JLabel m_label;
	JComboBox com1;
	JComboBox com2;
	JButton button;
	int re_year;
	int re_month;
	int x_size;
	int y_size;
	String year_num;
	Calendar now;

	TestClock()
	{
		super("������");
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		panel2 = new JPanel(new GridLayout(7, 7));
		panel3 = new JPanel();
		label = new JLabel[49];
		y_label = new JLabel("���?");
		m_label = new JLabel("�·�");
		com1 = new JComboBox();
		com2 = new JComboBox();
		button = new JButton("�鿴");
		now = Calendar.getInstance();
		setSize(300, 350);
		x_size = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		y_size = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation((x_size - 300) / 2, (y_size - 350) / 2);
		setDefaultCloseOperation(3);
		panel1.add(y_label);
		panel1.add(com1);
		panel1.add(m_label);
		panel1.add(com2);
		panel1.add(button);
		for (int i = 0; i < 49; i++)
		{
			label[i] = new JLabel("", 0);
			panel2.add(label[i]);
		}

		panel3.add(new Clock(this));
		panel.add(panel1, "North");
		panel.add(panel2, "Center");
		panel.add(panel3, "South");
		panel.setBackground(Color.white);
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		Init();
		button.addActionListener(new ActionListener() {

			final TestClock this$0;

			public void actionPerformed(ActionEvent e)
			{
				int c_year = Integer.parseInt(com1.getSelectedItem().toString());
				int c_month = Integer.parseInt(com2.getSelectedItem().toString()) - 1;
				int c_week = use(c_year, c_month);
				Resetday(c_week, c_year, c_month);
			}

			
			{
				this$0 = TestClock.this;
				super();
			}
		});
		setContentPane(panel);
		setVisible(true);
		setResizable(false);
	}

	public void Init()
	{
		String log[] = {
			"��", "һ", "��", "��", "��", "��", "��"
		};
		for (int i = 0; i < 7; i++)
			label[i].setText(log[i]);

		for (int i = 0; i < 49; i += 7)
			label[i].setForeground(Color.red);

		for (int i = 6; i < 49; i += 7)
			label[i].setForeground(Color.green);

		for (int i = 1; i < 10000; i++)
			com1.addItem((new StringBuilder()).append(i).toString());

		for (int i = 1; i < 13; i++)
			com2.addItem((new StringBuilder()).append(i).toString());

		int month_num = now.get(2);
		int year = now.get(1);
		com1.setSelectedIndex(year - 1);
		com2.setSelectedIndex(month_num);
		int first_day_num = use(year, month_num);
		Resetday(first_day_num, year, month_num);
	}

	public int use(int reyear, int remonth)
	{
		now.set(reyear, remonth, 1);
		int week_num = now.get(7);
		return week_num;
	}

	public void Resetday(int week_log, int year_log, int month_log)
	{
		int month_score_log = 0;
		int month_day_score = 0;
		int count = 1;
		if (year_log % 4 == 0 && year_log % 100 != 0 || year_log % 400 == 0)
			month_score_log = 1;
		switch (++month_log)
		{
		default:
			break;

		case 1: // '\001'
		case 3: // '\003'
		case 5: // '\005'
		case 7: // '\007'
		case 8: // '\b'
		case 10: // '\n'
		case 12: // '\f'
			month_day_score = 31;
			break;

		case 4: // '\004'
		case 6: // '\006'
		case 9: // '\t'
		case 11: // '\013'
			month_day_score = 30;
			break;

		case 2: // '\002'
			if (month_score_log == 1)
				month_day_score = 29;
			else
				month_day_score = 28;
			break;
		}
		for (int i = 7; i < 49; i++)
			label[i].setText("");

		week_log += 6;
		month_day_score += week_log;
		for (int i = week_log; i < month_day_score;)
		{
			label[i].setText((new StringBuilder(String.valueOf(count))).toString());
			i++;
			count++;
		}

	}

	public static void main(String args[])
	{
		TestClock start = new TestClock();
	}
}
