// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LocaleBean.java

package com.sinosoft.map.common;

import com.sinosoft.map.common.config.BaseConfig;
import java.util.*;
import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class LocaleBean extends BaseConfig
{

	private String locale;
	private List localeList;

	public LocaleBean()
	{
		locale = getFacesContext().getViewRoot().getLocale().toString();
	}

	public void setLocale(String locale)
	{
		this.locale = locale;
	}

	public String getLocale()
	{
		return locale;
	}

	public List getLocaleList()
	{
		localeList = new ArrayList();
		Application app = getApplication();
		Locale theLocale;
		for (Iterator locales = app.getSupportedLocales(); locales.hasNext(); localeList.add(new SelectItem(theLocale.toString(), getStringByID((new StringBuilder("language_")).append(theLocale.toString()).toString(), null))))
			theLocale = (Locale)locales.next();

		if (localeList.size() == 0)
		{
			Locale defaultLocale = app.getDefaultLocale();
			localeList.add(new SelectItem(defaultLocale.toString(), defaultLocale.getDisplayName()));
		}
		return localeList;
	}

	public String selectLocale()
	{
		getFacesContext().getViewRoot().setLocale(new Locale(locale));
		return "success";
	}
}
