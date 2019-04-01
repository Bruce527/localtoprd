// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ValidateCodeGenerator.java

package com.sinosoft.map.ec.utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ValidateCodeGenerator
	implements Serializable
{

	private static final long serialVersionUID = 0x8ebc4b25bd7c4cd1L;
	private BufferedImage image;
	Integer width;
	Integer height;
	Color bankgroud;
	Color drawColor;
	Font textFont;
	String str;
	Random random;

	public ValidateCodeGenerator()
	{
		width = Integer.valueOf(65);
		height = Integer.valueOf(20);
		bankgroud = new Color(0xffffff);
		drawColor = new Color(0);
		textFont = new Font("Comic Sans ms", 0, 18);
		str = "A,2,X,E,5,J,7,L,9,B,C,D,4,F,G,H,6,K,8,M,N,P,Q,R,S,T,U,V,W,3,Y,Z";
		random = new Random();
	}

	public void paint(OutputStream out, Object data)
		throws IOException
	{
		if (data instanceof ValidateCodeGenerator)
		{
			image = new BufferedImage(width.intValue(), height.intValue(), 1);
			Graphics graphics = image.getGraphics();
			graphics.setColor(bankgroud);
			graphics.fillRect(0, 0, width.intValue(), height.intValue());
			graphics.setColor(drawColor);
			graphics.drawRect(0, 0, width.intValue() - 1, height.intValue() - 1);
			graphics.setFont(textFont);
			for (int i = 0; i < 160; i++)
			{
				int x = random.nextInt(width.intValue());
				int y = random.nextInt(height.intValue());
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				graphics.setColor(getRandColor(100, 250));
				graphics.drawLine(x, y, x + xl, y + yl);
			}

			graphics.setColor(drawColor);
			String code = "";
			String array[] = str.split(",");
			for (int i = 0; i < 4; i++)
			{
				String rand = "";
				rand = array[random.nextInt(32)];
				code = (new StringBuilder(String.valueOf(code))).append(rand).toString();
				graphics.drawString(rand, 13 * i + 6, 16);
			}

			System.out.println((new StringBuilder("ÑéÖ¤ÂëÊÇ£º")).append(code).toString());
			FacesContext tFacesContext = FacesContext.getCurrentInstance();
			HttpServletRequest tHttpServletRequest = (HttpServletRequest)tFacesContext.getExternalContext().getRequest();
			HttpSession tHttpSession = tHttpServletRequest.getSession();
			tHttpSession.setAttribute("validateCode", code);
			graphics.dispose();
		}
		ImageIO.write(image, "JPEG", out);
	}

	private Color getRandColor(int fc, int bc)
	{
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
