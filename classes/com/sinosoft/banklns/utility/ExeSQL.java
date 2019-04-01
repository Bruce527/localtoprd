// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExeSQL.java

package com.sinosoft.banklns.utility;

import com.sinosoft.banklns.lis.pubfun.FDate;
import com.sinosoft.banklns.lis.pubfun.PubFun;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;

// Referenced classes of package com.sinosoft.banklns.utility:
//			CErrors, DBConnPool, StrTool, CError, 
//			SSRS

public class ExeSQL
{

	private Connection con;
	private boolean mflag;
	private FDate fDate;
	public CErrors mErrors;

	public ExeSQL(Connection tConnection)
	{
		mflag = false;
		fDate = new FDate();
		mErrors = new CErrors();
		con = tConnection;
		mflag = true;
	}

	public ExeSQL()
	{
		mflag = false;
		fDate = new FDate();
		mErrors = new CErrors();
	}

	public String getOneValue(String sql)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String mValue = "";
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			if (rs.next())
				mValue = rs.getString(1);
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at exeSQL1: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mValue = null;
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception1) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return StrTool.cTrim(mValue);
	}

	private int getResultCount(String sql, PreparedStatement pstmt, ResultSet rs)
	{
		int iCount = 0;
		sql = (new StringBuilder("select count(1) from (")).append(sql).append(") rsc").toString();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			rs.next();
			iCount = rs.getInt(1);
			rs.close();
			pstmt.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			iCount = -1;
			try
			{
				rs.close();
				pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception) { }
		}
		return iCount;
	}

	public String getEncodedResult(String sql, int start)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		StringBuffer mResult = new StringBuffer(256);
		if (start <= 0)
			start = 1;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			int m = start + 200;
			int k = 0;
			while (rs.next()) 
				if (++k >= start && k < m)
				{
					for (int j = 1; j <= n; j++)
						if (j == 1)
							mResult.append(getDataValue(rsmd, rs, j));
						else
							mResult.append((new StringBuilder("|")).append(getDataValue(rsmd, rs, j)).toString());

					mResult.append("^");
				}
			if (k >= start)
			{
				mResult.insert(0, (new StringBuilder("0|")).append(String.valueOf(k)).append("^").toString());
				mResult.delete(mResult.length() - 1, mResult.length());
			} else
			{
				mResult.append("100|δ��ѯ��������!");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at Encode2: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception1) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return mResult.toString();
	}

	public String getEncodedResultLarge(String sql, int start)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		StringBuffer mResult = new StringBuffer(256);
		if (start <= 0)
			start = 1;
		if (!mflag)
			con = DBConnPool.getConnection();
		int iCount = getResultCount(sql, pstmt, rs);
		if (iCount <= 0)
		{
			try
			{
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception) { }
			return "100|δ��ѯ��������!";
		}
		try
		{
			int m = start + 200;
			StringBuffer tSBql = new StringBuffer();
			if ("SQLSERVER".equals("ORACLE"))
			{
				tSBql.append("select * from (select rownum rnm,rs.* from (");
				tSBql.append(sql);
				tSBql.append(") rs where rownum < ");
				tSBql.append(m);
				tSBql.append(") rss where rnm >= ");
				tSBql.append(start);
			} else
			{
				tSBql.append("select * from (select rownumber() OVER () rnm ,rs.* from (");
				tSBql.append(sql);
				tSBql.append(") rs) rss WHERE rnm BETWEEN ");
				tSBql.append(start);
				tSBql.append(" and ");
				tSBql.append(m - 1);
			}
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(tSBql.toString()), 1003, 1007);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			int k = 0;
			for (; rs.next(); mResult.append("^"))
			{
				k++;
				for (int j = 2; j <= n; j++)
					if (j == 2)
						mResult.append(getDataValue(rsmd, rs, j));
					else
						mResult.append((new StringBuilder("|")).append(getDataValue(rsmd, rs, j)).toString());

			}

			if (k > 0)
			{
				mResult.insert(0, (new StringBuilder("0|")).append(String.valueOf(iCount)).append("^").toString());
				mResult.delete(mResult.length() - 1, mResult.length());
			} else
			{
				mResult.append("100|δ��ѯ��������!");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at Encode2: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception2) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception1) { }
		return mResult.toString();
	}

	public String getEncodedResult(String sql)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		StringBuffer mResult = new StringBuffer(256);
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			pstmt.setFetchSize(500);
			rs = pstmt.executeQuery();
			rs.setFetchSize(500);
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			int k = 0;
			for (; rs.next(); mResult.append("^"))
			{
				k++;
				for (int j = 1; j <= n; j++)
					if (j == 1)
					{
						mResult.append(getDataValue(rsmd, rs, j));
					} else
					{
						mResult.append("|");
						mResult.append(getDataValue(rsmd, rs, j));
					}

			}

			if (k > 0)
			{
				mResult.insert(0, (new StringBuilder("0|")).append(String.valueOf(k)).append("^").toString());
				mResult.delete(mResult.length() - 1, mResult.length());
			} else
			{
				mResult.append("100|δ��ѯ�������ݣ�");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at Encode1: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception1) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return mResult.toString();
	}

	public String getEncodedResult(String sql, int start, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		StringBuffer mResult = new StringBuffer(256);
		if (start <= 0)
			start = 1;
		if (nCount <= 0)
			nCount = 1;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			int m = start + nCount;
			int k = 0;
			while (rs.next()) 
			{
				if (++k >= m)
					break;
				if (k >= start && k < m)
				{
					for (int j = 1; j <= n; j++)
						if (j == 1)
							mResult.append(getDataValue(rsmd, rs, j));
						else
							mResult.append("|").append(getDataValue(rsmd, rs, j));

					mResult.append("^");
				}
			}
			if (k >= start)
			{
				mResult.insert(0, (new StringBuilder("0|")).append(String.valueOf(k)).append("^").toString());
				mResult.delete(mResult.length() - 1, mResult.length());
			} else
			{
				mResult.append("100|δ��ѯ�������ݣ�");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at Encode3: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception1) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return mResult.toString();
	}

	public String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
	{
		String strValue = "";
		try
		{
			int dataType = rsmd.getColumnType(i);
			int dataScale = rsmd.getScale(i);
			int dataPrecision = rsmd.getPrecision(i);
			if (dataType == 1 || dataType == 12)
				strValue = StrTool.unicodeToGBK(rs.getString(i));
			else
			if (dataType == 93 || dataType == 91)
			{
				strValue = rs.getString(i);
				if (strValue != null && strValue.length() > 10)
					strValue = strValue.substring(0, 19);
			} else
			if (dataType == 3 || dataType == 6 || dataType == 7)
			{
				strValue = String.valueOf(rs.getBigDecimal(i));
				strValue = PubFun.getInt(strValue);
			} else
			if (dataType == 8)
			{
				strValue = String.valueOf(rs.getDouble(i));
				strValue = PubFun.getInt(strValue);
			} else
			if (dataType == 4 || dataType == 5)
			{
				strValue = String.valueOf(rs.getInt(i));
				strValue = PubFun.getInt(strValue);
			} else
			if (dataType == 2)
			{
				if (dataScale == 0)
				{
					if (dataPrecision == 0)
						strValue = String.valueOf(rs.getBigDecimal(i));
					else
						strValue = String.valueOf(rs.getLong(i));
				} else
				{
					strValue = String.valueOf(rs.getBigDecimal(i));
				}
				strValue = PubFun.getInt(strValue);
			} else
			if (dataType == 8)
				strValue = String.valueOf(rs.getDouble(i));
			else
				strValue = rs.getString(i);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return StrTool.cTrim(strValue);
	}

	public boolean execUpdateSQL(String sql)
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1008);
			pstmt.executeUpdate();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at Update: ")).append(sql).toString());
			CError.buildErr(this, e.toString());
			try
			{
				pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException ex)
			{
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return true;
	}

	public void execSQL(String csql, PrintWriter ous)
	{
		String tStr = "";
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(csql));
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			while (rs.next()) 
			{
				for (int j = 1; j <= n; j++)
				{
					String strValue = "";
					strValue = getDataValue(rsmd, rs, j);
					tStr = (new StringBuilder(String.valueOf(tStr))).append(strValue).toString();
					if (j != n)
						tStr = (new StringBuilder(String.valueOf(tStr))).append(",").toString();
				}

				ous.println(tStr);
				tStr = "";
			}
			ous.flush();
			ous.close();
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			CError tError = new CError();
			tError.moduleName = "ExeSQL";
			tError.functionName = "ExecSQL";
			tError.errorMessage = (new StringBuilder("��ѯʧ�ܣ�ԭ���ǣ�")).append(e.toString()).toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
				stmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
	}

	public SSRS execSQL(String sql)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		SSRS tSSRS = null;
		System.out.println((new StringBuilder("MDES ExecSQL : ")).append(sql).toString());
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			tSSRS = new SSRS(n);
			while (rs.next()) 
			{
				for (int j = 1; j <= n; j++)
					tSSRS.SetText(getDataValue(rsmd, rs, j));

			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at exeSQL1: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			tSSRS = null;
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception1) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return tSSRS;
	}

	public SSRS execSQL(String sql, int start, int nCount)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		SSRS tSSRS = null;
		if (start <= 0)
			start = 1;
		if (nCount <= 0)
			nCount = 1;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			tSSRS = new SSRS(n);
			int m = start + nCount;
			int k = 0;
			while (rs.next()) 
				if (++k >= start && k < m)
				{
					for (int j = 1; j <= n; j++)
						tSSRS.SetText(getDataValue(rsmd, rs, j));

				}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at exeSQL2: ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			tSSRS = null;
			try
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (!mflag)
					con.close();
			}
			catch (SQLException sqlexception1) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (SQLException sqlexception) { }
		return tSSRS;
	}

	public static void main(String args1[])
	{
	}
}
