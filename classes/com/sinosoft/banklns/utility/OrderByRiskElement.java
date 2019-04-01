// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OrderByRiskElement.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.db.LNPRiskScreenDB;
import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
import com.sinosoft.banklns.lis.vdb.LNPRiskScreenDBSet;
import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;

// Referenced classes of package com.sinosoft.banklns.utility:
//			ExeSQL

public class OrderByRiskElement
{

	public OrderByRiskElement()
	{
	}

	public static void main(String args[])
	{
		String fssql = "select * from lNPriskscreen group by riskcode";
		LNPRiskScreenDB redLNPRiskScreenDB = new LNPRiskScreenDB();
		LNPRiskScreenSet tereLNPRiskAppSet = redLNPRiskScreenDB.executeQuery(fssql);
		if (tereLNPRiskAppSet != null && tereLNPRiskAppSet.size() > 0)
		{
			for (int i = 1; i <= tereLNPRiskAppSet.size(); i++)
			{
				LNPRiskScreenDB reLNPRiskScreenDB = new LNPRiskScreenDB();
				reLNPRiskScreenDB.setRiskCode(tereLNPRiskAppSet.get(i).getRiskCode());
				LNPRiskScreenSet reLNPRiskScreenSet = reLNPRiskScreenDB.query();
				if (reLNPRiskScreenSet != null && reLNPRiskScreenSet.size() > 0)
				{
					LNPRiskScreenSet tempreLNPRiskScreenSet = new LNPRiskScreenSet();
					for (int j = 1; j <= reLNPRiskScreenSet.size(); j++)
					{
						LNPRiskScreenSchema tLNPRiskScreenSchema = reLNPRiskScreenSet.get(j);
						if (tLNPRiskScreenSchema.getCtrlCode().equals("Mult"))
							tLNPRiskScreenSchema.setCtrlIndex(1);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("DutyCode"))
							tLNPRiskScreenSchema.setCtrlIndex(2);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("Amnt"))
							tLNPRiskScreenSchema.setCtrlIndex(3);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("Prem"))
							tLNPRiskScreenSchema.setCtrlIndex(4);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("PayIntv"))
							tLNPRiskScreenSchema.setCtrlIndex(5);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("InsuYearFlag"))
							tLNPRiskScreenSchema.setCtrlIndex(6);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("InsuYear"))
							tLNPRiskScreenSchema.setCtrlIndex(7);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("PayEndYearFlag"))
							tLNPRiskScreenSchema.setCtrlIndex(8);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("PayEndYear"))
							tLNPRiskScreenSchema.setCtrlIndex(9);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("GetYearFlag"))
							tLNPRiskScreenSchema.setCtrlIndex(10);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("GetYear"))
							tLNPRiskScreenSchema.setCtrlIndex(11);
						else
						if (tLNPRiskScreenSchema.getCtrlCode().equals("BonusGetMode"))
							tLNPRiskScreenSchema.setCtrlIndex(12);
						tempreLNPRiskScreenSet.add(tLNPRiskScreenSchema);
					}

					String sql = (new StringBuilder("delete from lNPriskScreen where riskcode='")).append(tereLNPRiskAppSet.get(i).getRiskCode()).append("'").toString();
					ExeSQL reExeSQL = new ExeSQL();
					reExeSQL.execUpdateSQL(sql);
					LNPRiskScreenDBSet reLMRiskScreenDBSet = new LNPRiskScreenDBSet();
					reLMRiskScreenDBSet.set(tempreLNPRiskScreenSet);
					reLMRiskScreenDBSet.insert();
				}
			}

		}
	}
}
