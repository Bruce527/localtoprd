// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MailEnginer.java

package com.sinosoft.map.ec.utility;

import com.sinosoft.map.common.config.BaseConfig;
import com.sun.net.ssl.internal.ssl.Provider;
import java.io.PrintStream;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// Referenced classes of package com.sinosoft.map.ec.utility:
//			MailAuthenticator

public class MailEnginer extends BaseConfig
{

	private String user;
	private String password;
	private String sendServer;
	private String sendSmtpPort;
	private String receiveServer;
	private String receivePort;
	private boolean isSSLSmtp;
	private boolean isSSLPop;
	private String portSSLSmtp;
	private String portSSLPop;
	private String serverType;
	private String from;
	private String to;
	private String subject;
	private Date sendDate;
	private String text;

	public MailEnginer()
	{
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public boolean isSSLPop()
	{
		return isSSLPop;
	}

	public void setSSLPop(boolean isSSLPop)
	{
		this.isSSLPop = isSSLPop;
	}

	public boolean isSSLSmtp()
	{
		return isSSLSmtp;
	}

	public void setSSLSmtp(boolean isSSLSmtp)
	{
		this.isSSLSmtp = isSSLSmtp;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPortSSLPop()
	{
		return portSSLPop;
	}

	public void setPortSSLPop(String portSSLPop)
	{
		this.portSSLPop = portSSLPop;
	}

	public String getPortSSLSmtp()
	{
		return portSSLSmtp;
	}

	public void setPortSSLSmtp(String portSSLSmtp)
	{
		this.portSSLSmtp = portSSLSmtp;
	}

	public String getReceivePort()
	{
		return receivePort;
	}

	public void setReceivePort(String receivePort)
	{
		this.receivePort = receivePort;
	}

	public String getReceiveServer()
	{
		return receiveServer;
	}

	public void setReceiveServer(String receiveServer)
	{
		this.receiveServer = receiveServer;
	}

	public String getSendServer()
	{
		return sendServer;
	}

	public void setSendServer(String sendServer)
	{
		this.sendServer = sendServer;
	}

	public String getSendSmtpPort()
	{
		return sendSmtpPort;
	}

	public void setSendSmtpPort(String sendSmtpPort)
	{
		this.sendSmtpPort = sendSmtpPort;
	}

	public Date getSendDate()
	{
		return sendDate;
	}

	public void setSendDate(Date sendDate)
	{
		this.sendDate = sendDate;
	}

	public String getServerType()
	{
		return serverType;
	}

	public void setServerType(String serverType)
	{
		this.serverType = serverType;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public void receive()
	{
		try
		{
			Properties props = new Properties();
			Session session = null;
			Store store = null;
			Folder folder = null;
			if (isSSLPop)
			{
				Security.addProvider(new Provider());
				String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
				props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.setProperty("mail.pop3.socketFactory.fallback", "false");
				props.setProperty("mail.pop3.port", portSSLPop);
				props.setProperty("mail.pop3.socketFactory.port", portSSLPop);
			}
			props.setProperty("mail.pop3.auth", "true");
			session = Session.getInstance(props);
			URLName urln = new URLName(serverType, receiveServer, Integer.parseInt(receivePort), null, user, password);
			store = session.getStore(urln);
			store.connect();
			folder = store.getFolder("INBOX");
			if (folder != null)
			{
				folder.open(1);
				Message messages[] = folder.getMessages();
				System.out.println((new StringBuilder("¹²ÓÐÓÊ¼þ£º[")).append(folder.getMessageCount()).append("]\n").toString());
				for (int i = 0; i < messages.length; i++)
				{
					System.out.println((new StringBuilder("--------Message:")).append(i + 1).append("--------").toString());
					messages[i].writeTo(System.out);
				}

			}
			folder.close(false);
			store.close();
		}
		catch (Exception err)
		{
			err.printStackTrace();
		}
	}

	public boolean send()
	{
		Security.addProvider(new Provider());
		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", sendServer);
		if (isSSLSmtp)
		{
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", portSSLSmtp);
			props.setProperty("mail.smtp.socketFactory.port", portSSLSmtp);
		}
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new MailAuthenticator(user, password));
		try
		{
			MimeMessage mimeMess = new MimeMessage(session);
			mimeMess.setFrom(new InternetAddress(from));
			mimeMess.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
			mimeMess.setSubject(subject);
			mimeMess.setSentDate(sendDate);
			mimeMess.setText(text);
			Transport.send(mimeMess);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
