// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMenuDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MMenuSchema;
import com.sinosoft.map.lis.vschema.MMenuSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MMenuDBSet extends MMenuSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MMenuDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MMenu");
		mflag = true;
	}

	public MMenuDBSet()
	{
		mflag = false;
		db = new DBOper("MMenu");
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
			tError.moduleName = "MMenuDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MMenu WHERE  NodeCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeCode() == null || get(i).getNodeCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeCode());
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
			tError.moduleName = "MMenuDBSet";
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
			pstmt = con.prepareStatement("UPDATE MMenu SET  NodeCode = ? , NodeName = ? , ParentNodeCode = ? , NodeLevel = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeCode() == null || get(i).getNodeCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeCode());
				if (get(i).getNodeName() == null || get(i).getNodeName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNodeName());
				if (get(i).getParentNodeCode() == null || get(i).getParentNodeCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParentNodeCode());
				if (get(i).getNodeLevel() == null || get(i).getNodeLevel().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNodeLevel());
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
				if (get(i).getNodeCode() == null || get(i).getNodeCode().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getNodeCode());
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
			tError.moduleName = "MMenuDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MMenu VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNodeCode() == null || get(i).getNodeCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNodeCode());
				if (get(i).getNodeName() == null || get(i).getNodeName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNodeName());
				if (get(i).getParentNodeCode() == null || get(i).getParentNodeCode().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getParentNodeCode());
				if (get(i).getNodeLevel() == null || get(i).getNodeLevel().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNodeLevel());
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
			tError.moduleName = "MMenuDBSet";
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
