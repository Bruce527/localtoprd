// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LARearRelationNewDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.LARearRelationNewSchema;
import com.sinosoft.map.lis.vschema.LARearRelationNewSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class LARearRelationNewDBSet extends LARearRelationNewSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LARearRelationNewDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LARearRelationNew");
		mflag = true;
	}

	public LARearRelationNewDBSet()
	{
		mflag = false;
		db = new DBOper("LARearRelationNew");
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
			tError.moduleName = "LARearRelationNewDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LARearRelationNew WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getAgentCode());
				if (get(i).getRAgentCode() == null || get(i).getRAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRAgentCode());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getDeep());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getState());
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
			tError.moduleName = "LARearRelationNewDBSet";
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
			pstmt = con.prepareStatement("UPDATE LARearRelationNew SET  ManageCom = ? , AgentCode = ? , AgentGrade = ? , AgentGroup = ? , SMAgentCode = ? , AMAgentCode = ? , RAgentCode = ? , AgentTitle = ? , RAgentGrade = ? , RAgentTitle = ? , RAgentGroup = ? , RBranchAttr = ? , Type = ? , Deep = ? , StartDate = ? , BreakDate = ? , PBreakDate = ? , BreakType = ? , State = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator = ? WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getManageCom());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentGrade());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGroup());
				if (get(i).getSMAgentCode() == null || get(i).getSMAgentCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getSMAgentCode());
				if (get(i).getAMAgentCode() == null || get(i).getAMAgentCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAMAgentCode());
				if (get(i).getRAgentCode() == null || get(i).getRAgentCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRAgentCode());
				if (get(i).getAgentTitle() == null || get(i).getAgentTitle().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentTitle());
				if (get(i).getRAgentGrade() == null || get(i).getRAgentGrade().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRAgentGrade());
				if (get(i).getRAgentTitle() == null || get(i).getRAgentTitle().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRAgentTitle());
				if (get(i).getRAgentGroup() == null || get(i).getRAgentGroup().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRAgentGroup());
				if (get(i).getRBranchAttr() == null || get(i).getRBranchAttr().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRBranchAttr());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getType());
				pstmt.setInt(14, get(i).getDeep());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getStartDate()));
				if (get(i).getBreakDate() == null || get(i).getBreakDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getBreakDate()));
				if (get(i).getPBreakDate() == null || get(i).getPBreakDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getPBreakDate()));
				if (get(i).getBreakType() == null || get(i).getBreakType().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getBreakType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getState());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyTime());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getOperator());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getAgentCode());
				if (get(i).getRAgentCode() == null || get(i).getRAgentCode().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getRAgentCode());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getType());
				pstmt.setInt(28, get(i).getDeep());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getState());
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
			tError.moduleName = "LARearRelationNewDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LARearRelationNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getManageCom());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAgentCode());
				if (get(i).getAgentGrade() == null || get(i).getAgentGrade().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAgentGrade());
				if (get(i).getAgentGroup() == null || get(i).getAgentGroup().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getAgentGroup());
				if (get(i).getSMAgentCode() == null || get(i).getSMAgentCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getSMAgentCode());
				if (get(i).getAMAgentCode() == null || get(i).getAMAgentCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAMAgentCode());
				if (get(i).getRAgentCode() == null || get(i).getRAgentCode().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRAgentCode());
				if (get(i).getAgentTitle() == null || get(i).getAgentTitle().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentTitle());
				if (get(i).getRAgentGrade() == null || get(i).getRAgentGrade().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getRAgentGrade());
				if (get(i).getRAgentTitle() == null || get(i).getRAgentTitle().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getRAgentTitle());
				if (get(i).getRAgentGroup() == null || get(i).getRAgentGroup().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRAgentGroup());
				if (get(i).getRBranchAttr() == null || get(i).getRBranchAttr().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getRBranchAttr());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getType());
				pstmt.setInt(14, get(i).getDeep());
				if (get(i).getStartDate() == null || get(i).getStartDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getStartDate()));
				if (get(i).getBreakDate() == null || get(i).getBreakDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getBreakDate()));
				if (get(i).getPBreakDate() == null || get(i).getPBreakDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getPBreakDate()));
				if (get(i).getBreakType() == null || get(i).getBreakType().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getBreakType());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getState());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(20, null);
				else
					pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(22, null);
				else
					pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getModifyTime());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getOperator());
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
			tError.moduleName = "LARearRelationNewDBSet";
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
