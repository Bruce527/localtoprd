// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMenuBDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MMenuBSchema;
import com.sinosoft.map.lis.vschema.MMenuBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MMenuBDBSet extends MMenuBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MMenuBDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MMenuB");
		mflag = true;
	}

	public MMenuBDBSet()
	{
		mflag = false;
		db = new DBOper("MMenuB");
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
			tError.moduleName = "MMenuBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MMenuB WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getEdorNo());
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
			tError.moduleName = "MMenuBDBSet";
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
			pstmt = con.prepareStatement("UPDATE MMenuB SET  NodeCode = ? , ParentID = ? , NodeLevel = ? , NodeName = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeCode() == null || get(i).getNodeCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeCode());
				if (get(i).getParentID() == null || get(i).getParentID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getParentID());
				if (get(i).getNodeLevel() == null || get(i).getNodeLevel().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getNodeLevel());
				if (get(i).getNodeName() == null || get(i).getNodeName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNodeName());
				if (get(i).getChildFlag() == null || get(i).getChildFlag().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getChildFlag());
				if (get(i).getNodeKey() == null || get(i).getNodeKey().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getNodeKey());
				if (get(i).getRunScript() == null || get(i).getRunScript().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRunScript());
				if (get(i).getNodeDesc() == null || get(i).getNodeDesc().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getNodeDesc());
				if (get(i).getNodeSign() == null || get(i).getNodeSign().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getNodeSign());
				pstmt.setInt(10, get(i).getNodeOrder());
				pstmt.setInt(11, get(i).getInt1());
				pstmt.setInt(12, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getVarc2());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getModifyTime());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMakeTime2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getEdorNo());
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
			tError.moduleName = "MMenuBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MMenuB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeCode() == null || get(i).getNodeCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeCode());
				if (get(i).getParentID() == null || get(i).getParentID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getParentID());
				if (get(i).getNodeLevel() == null || get(i).getNodeLevel().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getNodeLevel());
				if (get(i).getNodeName() == null || get(i).getNodeName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNodeName());
				if (get(i).getChildFlag() == null || get(i).getChildFlag().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getChildFlag());
				if (get(i).getNodeKey() == null || get(i).getNodeKey().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getNodeKey());
				if (get(i).getRunScript() == null || get(i).getRunScript().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getRunScript());
				if (get(i).getNodeDesc() == null || get(i).getNodeDesc().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getNodeDesc());
				if (get(i).getNodeSign() == null || get(i).getNodeSign().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getNodeSign());
				pstmt.setInt(10, get(i).getNodeOrder());
				pstmt.setInt(11, get(i).getInt1());
				pstmt.setInt(12, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getVarc2());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(18, null);
				else
					pstmt.setDate(18, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getModifyTime());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getOperator2());
				if (get(i).getMakeDate2() == null || get(i).getMakeDate2().equals("null"))
					pstmt.setDate(24, null);
				else
					pstmt.setDate(24, Date.valueOf(get(i).getMakeDate2()));
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getMakeTime2());
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
			tError.moduleName = "MMenuBDBSet";
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
