// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMessageConfigDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MMessageConfigSchema;
import com.sinosoft.map.lis.vschema.MMessageConfigSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MMessageConfigDBSet extends MMessageConfigSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MMessageConfigDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MMessageConfig");
		mflag = true;
	}

	public MMessageConfigDBSet()
	{
		mflag = false;
		db = new DBOper("MMessageConfig");
		con = db.getConnection();
	}

	public boolean deleteSQL()
	{
		if (db.deleteSQL(this))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "²Ù×÷Ê§°Ü!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("DELETE FROM MMessageConfig WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDBSet";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("UPDATE MMessageConfig SET  ID = ? , ManageCom = ? , BranchType = ? , MessageType = ? , MessageName = ? , MessageContent = ? , MessageContent2 = ? , MessageContent3 = ? , MessageContent4 = ? , MessageContent5 = ? , MessageContent6 = ? , BeforeDays = ? , StatDays = ? , StartDate = ? , EndDate = ? , StatCycle = ? , Script = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBranchType());
				if (get(i).getMessageType() == null || get(i).getMessageType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getMessageType());
				if (get(i).getMessageName() == null || get(i).getMessageName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMessageName());
				if (get(i).getMessageContent() == null || get(i).getMessageContent().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMessageContent());
				if (get(i).getMessageContent2() == null || get(i).getMessageContent2().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMessageContent2());
				if (get(i).getMessageContent3() == null || get(i).getMessageContent3().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMessageContent3());
				if (get(i).getMessageContent4() == null || get(i).getMessageContent4().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMessageContent4());
				if (get(i).getMessageContent5() == null || get(i).getMessageContent5().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getMessageContent5());
				if (get(i).getMessageContent6() == null || get(i).getMessageContent6().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMessageContent6());
				pstmt.setInt(12, get(i).getBeforeDays());
				pstmt.setInt(13, get(i).getStatDays());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
				if (get(i).getStatCycle() == null || get(i).getStatCycle().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getStatCycle());
				if (get(i).getScript() == null || get(i).getScript().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getScript());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getNF01());
				pstmt.setInt(20, get(i).getIF01());
				pstmt.setDouble(21, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMakeTime());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getID());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDBSet";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("INSERT INTO MMessageConfig VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getBranchType());
				if (get(i).getMessageType() == null || get(i).getMessageType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getMessageType());
				if (get(i).getMessageName() == null || get(i).getMessageName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getMessageName());
				if (get(i).getMessageContent() == null || get(i).getMessageContent().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getMessageContent());
				if (get(i).getMessageContent2() == null || get(i).getMessageContent2().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMessageContent2());
				if (get(i).getMessageContent3() == null || get(i).getMessageContent3().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMessageContent3());
				if (get(i).getMessageContent4() == null || get(i).getMessageContent4().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMessageContent4());
				if (get(i).getMessageContent5() == null || get(i).getMessageContent5().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getMessageContent5());
				if (get(i).getMessageContent6() == null || get(i).getMessageContent6().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getMessageContent6());
				pstmt.setInt(12, get(i).getBeforeDays());
				pstmt.setInt(13, get(i).getStatDays());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
				if (get(i).getEndDate() == null || get(i).getEndDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
				if (get(i).getStatCycle() == null || get(i).getStatCycle().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getStatCycle());
				if (get(i).getScript() == null || get(i).getScript().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getScript());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getNF01());
				pstmt.setInt(20, get(i).getIF01());
				pstmt.setDouble(21, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMakeTime());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDBSet";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}
}
