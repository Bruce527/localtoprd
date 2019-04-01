// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CalendarEx.java

package com.sinosoft.banklns.utility;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class JCalendar extends JPanel
{

	private int year;
	private int month;
	private int day;
	private JPanel Main;
	private JPanel jPanelDay;
	private JPanel jPanelMonth;
	private JTextField Year;
	private JTextField Month;
	private JButton MonthDown;
	private JButton MonthUp;
	private JPanel jPanelButton;
	private JButton YearDown;
	private JButton YearUp;
	private JLabel Out;
	private Locale l;
	private GregorianCalendar cal;
	private JPanel weekPanel;
	private JToggleButton days[];
	private JPanel Days;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JToggleButton cur;
	private int mm[] = {
		31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 
		30, 31
	};

	public JCalendar()
	{
		year = 0;
		month = 0;
		day = 0;
		Main = new JPanel();
		jPanelDay = new JPanel();
		jPanelMonth = new JPanel();
		Year = new JTextField();
		Month = new JTextField();
		MonthDown = new JButton();
		MonthUp = new JButton();
		jPanelButton = new JPanel();
		YearDown = new JButton();
		YearUp = new JButton();
		Out = new JLabel();
		l = Locale.CHINESE;
		cal = new GregorianCalendar(l);
		weekPanel = new JPanel();
		days = new JToggleButton[42];
		Days = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		cur = null;
		try
		{
			jbInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public JCalendar(int year, int month, int day)
	{
		this.year = 0;
		this.month = 0;
		this.day = 0;
		Main = new JPanel();
		jPanelDay = new JPanel();
		jPanelMonth = new JPanel();
		Year = new JTextField();
		Month = new JTextField();
		MonthDown = new JButton();
		MonthUp = new JButton();
		jPanelButton = new JPanel();
		YearDown = new JButton();
		YearUp = new JButton();
		Out = new JLabel();
		l = Locale.CHINESE;
		cal = new GregorianCalendar(l);
		weekPanel = new JPanel();
		days = new JToggleButton[42];
		Days = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		cur = null;
		cal.set(year, month, day);
		try
		{
			jbInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public JCalendar(GregorianCalendar calendar)
	{
		year = 0;
		month = 0;
		day = 0;
		Main = new JPanel();
		jPanelDay = new JPanel();
		jPanelMonth = new JPanel();
		Year = new JTextField();
		Month = new JTextField();
		MonthDown = new JButton();
		MonthUp = new JButton();
		jPanelButton = new JPanel();
		YearDown = new JButton();
		YearUp = new JButton();
		Out = new JLabel();
		l = Locale.CHINESE;
		cal = new GregorianCalendar(l);
		weekPanel = new JPanel();
		days = new JToggleButton[42];
		Days = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		cur = null;
		cal = calendar;
		try
		{
			jbInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public JCalendar(Date date)
	{
		year = 0;
		month = 0;
		day = 0;
		Main = new JPanel();
		jPanelDay = new JPanel();
		jPanelMonth = new JPanel();
		Year = new JTextField();
		Month = new JTextField();
		MonthDown = new JButton();
		MonthUp = new JButton();
		jPanelButton = new JPanel();
		YearDown = new JButton();
		YearUp = new JButton();
		Out = new JLabel();
		l = Locale.CHINESE;
		cal = new GregorianCalendar(l);
		weekPanel = new JPanel();
		days = new JToggleButton[42];
		Days = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		cur = null;
		cal.setTime(date);
		try
		{
			jbInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void jbInit()
		throws Exception
	{
		iniCalender();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createRaisedBevelBorder());
		setMaximumSize(new Dimension(200, 200));
		setMinimumSize(new Dimension(200, 200));
		setPreferredSize(new Dimension(200, 200));
		Main.setLayout(new BorderLayout());
		Main.setBackground(SystemColor.info);
		Main.setBorder(null);
		Out.setBackground(Color.lightGray);
		Out.setHorizontalAlignment(0);
		Out.setMaximumSize(new Dimension(100, 19));
		Out.setMinimumSize(new Dimension(100, 19));
		Out.setPreferredSize(new Dimension(100, 19));
		jLabel1.setForeground(Color.red);
		jLabel1.setHorizontalAlignment(0);
		jLabel1.setHorizontalTextPosition(0);
		jLabel1.setText("æ—?");
		jLabel2.setForeground(Color.blue);
		jLabel2.setHorizontalAlignment(0);
		jLabel2.setHorizontalTextPosition(0);
		jLabel2.setText("å…?");
		jLabel3.setHorizontalAlignment(0);
		jLabel3.setHorizontalTextPosition(0);
		jLabel3.setText("äº?");
		jLabel4.setHorizontalAlignment(0);
		jLabel4.setHorizontalTextPosition(0);
		jLabel4.setText("å›?");
		jLabel5.setHorizontalAlignment(0);
		jLabel5.setHorizontalTextPosition(0);
		jLabel5.setText("ä¸?");
		jLabel6.setBorder(null);
		jLabel6.setHorizontalAlignment(0);
		jLabel6.setHorizontalTextPosition(0);
		jLabel6.setText("äº?");
		jLabel7.setBackground(Color.lightGray);
		jLabel7.setForeground(Color.black);
		jLabel7.setBorder(null);
		jLabel7.setHorizontalAlignment(0);
		jLabel7.setHorizontalTextPosition(0);
		jLabel7.setText("ä¸?");
		weekPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		weekPanel.setBorder(BorderFactory.createEtchedBorder());
		weekPanel.setLayout(new GridLayout(1, 7));
		weekPanel.add(jLabel1, null);
		weekPanel.add(jLabel7, null);
		weekPanel.add(jLabel6, null);
		weekPanel.add(jLabel5, null);
		weekPanel.add(jLabel4, null);
		weekPanel.add(jLabel3, null);
		weekPanel.add(jLabel2, null);
		MonthUp.setAlignmentX(0.0F);
		MonthUp.setActionMap(null);
		jPanelMonth.setBackground(SystemColor.info);
		jPanelMonth.setLayout(new BorderLayout());
		jPanelMonth.setBorder(BorderFactory.createEtchedBorder());
		Month.setBorder(null);
		Month.setHorizontalAlignment(0);
		Month.addMouseListener(new MouseAdapter() {

			final JCalendar this$0;

			public void mouseClicked(MouseEvent e)
			{
				Month_mouseClicked(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		Month.addKeyListener(new KeyAdapter() {

			final JCalendar this$0;

			public void keyPressed(KeyEvent e)
			{
				Month_keyPressed(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		MonthDown.setBorder(null);
		MonthDown.setText("?");
		MonthDown.addActionListener(new ActionListener() {

			final JCalendar this$0;

			public void actionPerformed(ActionEvent e)
			{
				MonthDown_actionPerformed(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		MonthUp.setBorder(null);
		MonthUp.setText("?");
		MonthUp.addActionListener(new ActionListener() {

			final JCalendar this$0;

			public void actionPerformed(ActionEvent e)
			{
				MonthUp_actionPerformed(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		jPanelButton.setLayout(null);
		jPanelButton.setBorder(null);
		jPanelButton.addComponentListener(new ComponentAdapter() {

			final JCalendar this$0;

			public void componentResized(ComponentEvent evt)
			{
				jPanelButtonComponentResized(evt);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		Year.setBorder(BorderFactory.createEtchedBorder());
		Year.setMaximumSize(new Dimension(80, 25));
		Year.setMinimumSize(new Dimension(80, 25));
		Year.setPreferredSize(new Dimension(80, 25));
		Year.setHorizontalAlignment(0);
		Year.addMouseListener(new MouseAdapter() {

			final JCalendar this$0;

			public void mouseClicked(MouseEvent e)
			{
				Year_mouseClicked(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		Year.addKeyListener(new KeyAdapter() {

			final JCalendar this$0;

			public void keyPressed(KeyEvent e)
			{
				Year_keyPressed(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		YearDown.setBorder(null);
		YearDown.setMaximumSize(new Dimension(16, 16));
		YearDown.setMinimumSize(new Dimension(16, 16));
		YearDown.setPreferredSize(new Dimension(16, 16));
		YearDown.setSize(new Dimension(16, 16));
		YearDown.setText("â–?");
		YearDown.addActionListener(new ActionListener() {

			final JCalendar this$0;

			public void actionPerformed(ActionEvent e)
			{
				YearDown_actionPerformed(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		YearUp.setBorder(null);
		YearUp.setMaximumSize(new Dimension(16, 16));
		YearUp.setMinimumSize(new Dimension(16, 16));
		YearUp.setPreferredSize(new Dimension(16, 16));
		YearUp.setSize(new Dimension(16, 16));
		YearUp.setText("â–?");
		YearUp.addActionListener(new ActionListener() {

			final JCalendar this$0;

			public void actionPerformed(ActionEvent e)
			{
				YearUp_actionPerformed(e);
			}

			
			{
				this$0 = JCalendar.this;
				super();
			}
		});
		jPanelDay.setLayout(new BorderLayout());
		Days.setLayout(new GridLayout(6, 7));
		Days.setBackground(SystemColor.info);
		for (int i = 0; i < 42; i++)
		{
			days[i] = new JToggleButton();
			days[i].setBorder(null);
			days[i].setBackground(SystemColor.info);
			days[i].setHorizontalAlignment(0);
			days[i].setHorizontalTextPosition(0);
			days[i].addActionListener(new ActionListener() {

				final JCalendar this$0;

				public void actionPerformed(ActionEvent e)
				{
					day = Integer.parseInt(((JToggleButton)e.getSource()).getText());
					showDate();
					showDays();
				}

			
			{
				this$0 = JCalendar.this;
				super();
			}
			});
			Days.add(days[i]);
		}

		add(Main, "North");
		add(jPanelDay, "Center");
		add(jPanelMonth, "South");
		Main.add(Year, "Center");
		Main.add(Out, "West");
		Main.add(jPanelButton, "East");
		jPanelButton.add(YearUp);
		jPanelButton.add(YearDown);
		jPanelDay.add(weekPanel, "North");
		jPanelDay.add(Days, "Center");
		jPanelMonth.add(Month, "Center");
		jPanelMonth.add(MonthDown, "West");
		jPanelMonth.add(MonthUp, "East");
		showMonth();
		showYear();
		showDate();
		showDays();
	}

	void jPanelButtonComponentResized(ComponentEvent evt)
	{
		YearUp.setLocation(0, 0);
		YearDown.setLocation(0, YearUp.getHeight());
		jPanelButton.setSize(YearUp.getWidth(), YearUp.getHeight() * 2);
		jPanelButton.setPreferredSize(new Dimension(YearUp.getWidth(), YearUp.getHeight() * 2));
		jPanelButton.updateUI();
	}

	public static void main(String args[])
	{
		JFrame f = new JFrame();
		f.setContentPane(new JCalendar());
		f.pack();
		f.show();
	}

	void YearUp_actionPerformed(ActionEvent e)
	{
		year++;
		showYear();
		showDate();
		showDays();
	}

	void YearDown_actionPerformed(ActionEvent e)
	{
		year--;
		showYear();
		showDate();
		showDays();
	}

	void MonthDown_actionPerformed(ActionEvent e)
	{
		month--;
		if (month < 0)
		{
			month = 11;
			year--;
			showYear();
		}
		showMonth();
		showDate();
		showDays();
	}

	void MonthUp_actionPerformed(ActionEvent e)
	{
		month++;
		if (month == 12)
		{
			month = 0;
			year++;
			showYear();
		}
		showMonth();
		showDate();
		showDays();
	}

	void iniCalender()
	{
		year = cal.get(1);
		month = cal.get(2);
		day = cal.get(5);
	}

	void showMonth()
	{
		Month.setText((new StringBuilder(String.valueOf(Integer.toString(month + 1)))).append("æœ?").toString());
	}

	void showYear()
	{
		Year.setText((new StringBuilder(String.valueOf(Integer.toString(year)))).append("å¹?").toString());
	}

	void showDate()
	{
		Out.setText((new StringBuilder(String.valueOf(Integer.toString(year)))).append("-").append(Integer.toString(month + 1)).append("-").append(Integer.toString(day)).toString());
	}

	void showDays()
	{
		cal.set(year, month, 1);
		int firstDayOfWeek = cal.get(7);
		int n = mm[month];
		if (cal.isLeapYear(year) && month == 1)
			n++;
		int i;
		for (i = 0; i < firstDayOfWeek - 1; i++)
		{
			days[i].setEnabled(false);
			days[i].setSelected(false);
			days[i].setText("");
		}

		for (int d = 1; d <= n; d++)
		{
			days[i].setText(Integer.toString(d));
			days[i].setEnabled(true);
			if (d == day)
				days[i].setSelected(true);
			else
				days[i].setSelected(false);
			i++;
		}

		for (; i < 42; i++)
		{
			days[i].setEnabled(false);
			days[i].setSelected(false);
			days[i].setText("");
		}

	}

	void SelectionYear()
	{
		Year.setSelectionStart(0);
		Year.setSelectionEnd(Year.getText().length());
	}

	void SelectionMonth()
	{
		Month.setSelectionStart(0);
		Month.setSelectionEnd(Month.getText().length());
	}

	void Month_mouseClicked(MouseEvent e)
	{
		inputMonth();
	}

	void inputMonth()
	{
		String s;
		if (Month.getText().endsWith("æœ?"))
			s = Month.getText().substring(0, Month.getText().length() - 1);
		else
			s = Month.getText();
		month = Integer.parseInt(s) - 1;
		showMe();
	}

	void Month_keyPressed(KeyEvent e)
	{
		if (e.getKeyChar() == '\n')
			inputMonth();
	}

	void Year_mouseClicked(MouseEvent e)
	{
		inputYear();
	}

	void Year_keyPressed(KeyEvent e)
	{
		if (e.getKeyChar() == '\n')
			inputYear();
	}

	void inputYear()
	{
		String s;
		if (Year.getText().endsWith("å¹?"))
			s = Year.getText().substring(0, Year.getText().length() - 1);
		else
			s = Year.getText();
		year = Integer.parseInt(s);
		showMe();
	}

	public String getDate()
	{
		return Out.getText();
	}

	public void setDate(String date)
	{
		if (date != null)
		{
			StringTokenizer f = new StringTokenizer(date, "-");
			if (f.hasMoreTokens())
				year = Integer.parseInt(f.nextToken());
			if (f.hasMoreTokens())
				month = Integer.parseInt(f.nextToken());
			if (f.hasMoreTokens())
				day = Integer.parseInt(f.nextToken());
			cal.set(year, month, day);
		}
		showMe();
	}

	public void setTime(Date date)
	{
		cal.setTime(date);
		iniCalender();
		showMe();
	}

	public Date getTime()
	{
		return cal.getTime();
	}

	public int getDay()
	{
		return day;
	}

	public void setDay(int day)
	{
		this.day = day;
		cal.set(year, month, this.day);
		showMe();
	}

	public void setYear(int year)
	{
		this.year = year;
		cal.set(this.year, month, day);
		showMe();
	}

	public int getYear()
	{
		return year;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
		cal.set(year, this.month, day);
		showMe();
	}

	public void showMe()
	{
		showDays();
		showMonth();
		showYear();
		showDate();
	}

}
