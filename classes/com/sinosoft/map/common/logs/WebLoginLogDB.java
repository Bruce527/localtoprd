// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WebLoginLogDB.java

package com.sinosoft.map.common.logs;

import com.sinosoft.map.common.WebVisitor;
import com.sinosoft.map.lis.db.MWebLoginLogDB;
import com.sinosoft.map.lis.pubfun.*;
import com.sinosoft.map.lis.schema.MWebLoginLogSchema;
import com.sinosoft.map.lis.vschema.MWebLoginLogSet;
import com.sinosoft.map.user.UserModel;
import com.sinosoft.map.utility.VData;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebLoginLogDB
	implements Serializable
{

	public WebLoginLogDB()
	{
	}

	public static synchronized boolean saveLoginLog(WebVisitor visitor)
	{
		MWebLoginLogSchema tMWebLoginLogSchema = new MWebLoginLogSchema();
		SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MWebLoginLogId", 20, 1);
		tMWebLoginLogSchema.setID(tSysMaxNoMap.next());
		tMWebLoginLogSchema.setUserCode(visitor.getUser().getUserCode());
		tMWebLoginLogSchema.setLoginDate(visitor.getUser().getLoginDate());
		tMWebLoginLogSchema.setLoginTime(visitor.getUser().getLoginTime());
		if (visitor.getUser().getUserType() != null && visitor.getUser().getUserType().equalsIgnoreCase("LP"))
			tMWebLoginLogSchema.setUserType("1");
		else
			tMWebLoginLogSchema.setUserType("2");
		String ip = visitor.getHttpServletRequest().getRemoteAddr();
		String sessionId = visitor.getHttpServletRequest().getSession().getId();
		tMWebLoginLogSchema.setClientName("");
		tMWebLoginLogSchema.setClientType("");
		tMWebLoginLogSchema.setClientIP(ip);
		tMWebLoginLogSchema.setSessionId(sessionId);
		PubSubmit ps = new PubSubmit();
		MMap map = new MMap();
		map.put(tMWebLoginLogSchema, "INSERT");
		VData vd = new VData();
		vd.add(map);
		return ps.submitData(vd, "");
	}

	public static synchronized boolean saveLogoutLog(WebVisitor visitor)
	{
		MWebLoginLogSchema tMWebLoginLogSchema = new MWebLoginLogSchema();
		MWebLoginLogSchema rMWebLoginLogSchema = new MWebLoginLogSchema();
		MWebLoginLogDB tMWebLoginLogDB = new MWebLoginLogDB();
		MWebLoginLogSet tMWebLoginLogSet = new MWebLoginLogSet();
		String sessionId = visitor.getHttpServletRequest().getSession().getId();
		String tUserCode = visitor.getUser().getUserCode();
		tMWebLoginLogSchema.setSessionId(sessionId);
		tMWebLoginLogSchema.setUserCode(tUserCode);
		tMWebLoginLogDB.setSchema(tMWebLoginLogSchema);
		tMWebLoginLogSet = tMWebLoginLogDB.query();
		if (tMWebLoginLogSet != null && tMWebLoginLogSet.size() > 0)
			rMWebLoginLogSchema = tMWebLoginLogSet.get(1);
		if (rMWebLoginLogSchema.getLogoutDate() == null && rMWebLoginLogSchema.getLogoutTime() == null)
		{
			rMWebLoginLogSchema.setLogoutDate(PubFun.getCurrentDate());
			rMWebLoginLogSchema.setLogoutTime(PubFun.getCurrentTime());
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(rMWebLoginLogSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
				return false;
		}
		return true;
	}

	public static synchronized boolean saveLogoutLogOther(String sessionId, String userCode)
	{
		MWebLoginLogSchema tMWebLoginLogSchema = new MWebLoginLogSchema();
		MWebLoginLogSchema rMWebLoginLogSchema = new MWebLoginLogSchema();
		MWebLoginLogDB tMWebLoginLogDB = new MWebLoginLogDB();
		MWebLoginLogSet tMWebLoginLogSet = new MWebLoginLogSet();
		tMWebLoginLogSchema.setSessionId(sessionId);
		tMWebLoginLogSchema.setUserCode(userCode);
		tMWebLoginLogDB.setSchema(tMWebLoginLogSchema);
		tMWebLoginLogSet = tMWebLoginLogDB.query();
		if (tMWebLoginLogSet != null && tMWebLoginLogSet.size() > 0)
			rMWebLoginLogSchema = tMWebLoginLogSet.get(1);
		if (rMWebLoginLogSchema.getLogoutDate() == null && rMWebLoginLogSchema.getLogoutTime() == null)
		{
			rMWebLoginLogSchema.setLogoutDate(PubFun.getCurrentDate());
			rMWebLoginLogSchema.setLogoutTime(PubFun.getCurrentTime());
			PubSubmit ps = new PubSubmit();
			MMap map = new MMap();
			map.put(rMWebLoginLogSchema, "UPDATE");
			VData vd = new VData();
			vd.add(map);
			if (!ps.submitData(vd, ""))
				return false;
		}
		return true;
	}
}
