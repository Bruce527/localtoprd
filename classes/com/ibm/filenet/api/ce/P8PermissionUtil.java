// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   P8PermissionUtil.java

package com.ibm.filenet.api.ce;

import com.filenet.api.collection.AccessPermissionList;
import com.filenet.api.constants.AccessLevel;
import com.filenet.api.constants.AccessType;
import com.filenet.api.core.Factory;
import com.filenet.api.security.AccessPermission;

public class P8PermissionUtil
{

	public P8PermissionUtil()
	{
	}

	public static void addAccessPermission(AccessPermissionList apl, String granteeName, AccessType accessType, AccessLevel accessLevel)
	{
		AccessPermission ap = com.filenet.api.core.Factory.AccessPermission.createInstance();
		ap.set_GranteeName(granteeName);
		ap.set_AccessType(accessType);
		ap.set_AccessMask(Integer.valueOf(accessLevel.getValue()));
		apl.add(ap);
	}

	public static void addAccessPermission(AccessPermissionList apl, String granteeName, int accessType, int accessMask)
	{
		AccessPermission ap = com.filenet.api.core.Factory.AccessPermission.createInstance();
		ap.set_GranteeName(granteeName);
		ap.set_AccessType(AccessType.getInstanceFromInt(accessType));
		ap.set_AccessMask(Integer.valueOf(accessMask));
		apl.add(ap);
	}

	public static void removeAccessPermission(AccessPermissionList apl, String granteeName, String docId)
	{
		for (int i = 0; i < apl.size(); i++)
		{
			AccessPermission ap = (AccessPermission)apl.get(i);
			String temp = ap.get_GranteeName().split("@")[0];
			if (temp.equals(granteeName) || ap.get_GranteeName().equals(granteeName))
				apl.remove(i);
		}

	}

	public static void removeAccessPermission(AccessPermissionList apl, String granteeName, AccessType accessType)
	{
		removeAccessPermission(apl, granteeName, accessType.getValue());
	}

	public static void removeAccessPermission(AccessPermissionList apl, String granteeName, int accessType)
	{
		for (int i = 0; i < apl.size(); i++)
		{
			AccessPermission ap = (AccessPermission)apl.get(i);
			String temp = ap.get_GranteeName().split("@")[0];
			if ((temp.equals(granteeName) || ap.get_GranteeName().equals(granteeName)) && ap.get_AccessType().equals(AccessType.getInstanceFromInt(accessType)))
				apl.remove(i);
		}

	}
}
