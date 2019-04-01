// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExeSQL.java

package com.sinosoft.map.utility;

import com.sinosoft.map.lis.pubfun.FDate;
import com.sinosoft.map.lis.pubfun.PubFun;
import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package com.sinosoft.map.utility:
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
		PreparedStatement pstmt;
		ResultSet rs;
		String mValue;
		pstmt = null;
		rs = null;
		mValue = "";
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			if (rs.next())
				mValue = rs.getString(1);
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
			break MISSING_BLOCK_LABEL_320;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at OneValue: ")).append(sql).toString());
			CError.buildErr(this, e.toString());
			mValue = "";
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_294;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_261;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_294;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_320;
		ex;
		ex.printStackTrace();
		return StrTool.cTrim(mValue);
	}

	private int getResultCount(String sql, PreparedStatement pstmt, ResultSet rs)
	{
		int iCount;
		iCount = 0;
		sql = (new StringBuilder("select count(1) from (")).append(sql).append(") rsc").toString();
		System.out.println((new StringBuilder("getResultCount : ")).append(sql).toString());
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1007);
			rs = pstmt.executeQuery();
			if (rs.next())
				iCount = rs.getInt(1);
			rs.close();
			pstmt.close();
			break MISSING_BLOCK_LABEL_284;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			iCount = 0;
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_263;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_230;
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		break MISSING_BLOCK_LABEL_263;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception3) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_284;
		SQLException sqlexception;
		sqlexception;
		return iCount;
	}

	public String getEncodedResult(String sql, int start)
	{
		PreparedStatement pstmt;
		ResultSet rs;
		StringBuffer mResult;
		pstmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		mResult = new StringBuffer(256);
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
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
				if (k > 10000)
					System.out.println("建议采用大批量数据查询模式！");
				mResult.insert(0, (new StringBuilder("0|")).append(String.valueOf(k)).append("^").toString());
				mResult.delete(mResult.length() - 1, mResult.length());
			} else
			{
				mResult.append("100|未查询到相关数据!");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
			break MISSING_BLOCK_LABEL_551;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at getEncodedResult(String sql, int start): ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_525;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_492;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_525;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_551;
		ex;
		ex.printStackTrace();
		return mResult.toString();
	}

	public String getEncodedResultLarge(String sql, int start)
	{
		PreparedStatement pstmt;
		ResultSet rs;
		StringBuffer mResult;
		pstmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		mResult = new StringBuffer(256);
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
			return "100|未查询到相关数据!";
		}
		try
		{
			int m = start + 200;
			StringBuffer tSBql = new StringBuffer();
			if ("ORACLE".equals("ORACLE"))
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
			System.out.println((new StringBuilder("ExecSQL : ")).append(tSBql.toString()).toString());
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
				mResult.append("100|未查询到相关数据!");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
			break MISSING_BLOCK_LABEL_684;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at getEncodedResultLarge(String sql, int start): ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_658;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_625;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		break MISSING_BLOCK_LABEL_658;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception3) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_684;
		ex;
		ex.printStackTrace();
		return mResult.toString();
	}

	public String getEncodedResult(String sql)
	{
		PreparedStatement pstmt;
		ResultSet rs;
		StringBuffer mResult;
		pstmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		mResult = new StringBuffer(256);
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
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
				mResult.append("100|未查询到相关数据！");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
			break MISSING_BLOCK_LABEL_510;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at getEncodedResult(String sql): ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_484;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_451;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_484;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_510;
		ex;
		ex.printStackTrace();
		return mResult.toString();
	}

	public String getEncodedResult(String sql, int start, int nCount)
	{
		PreparedStatement pstmt;
		ResultSet rs;
		StringBuffer mResult;
		pstmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		mResult = new StringBuffer(256);
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
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
				mResult.append("100|未查询到相关数据！");
			}
			rs.close();
			pstmt.close();
			if (!mflag)
				con.close();
			break MISSING_BLOCK_LABEL_548;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at getEncodedResult(String sql, int start, int nCount): ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			mResult.setLength(0);
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_522;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_488;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_522;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_548;
		ex;
		ex.printStackTrace();
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
				strValue = rs.getString(i);
			else
			if (dataType == 93 || dataType == 91)
				strValue = fDate.getString(rs.getDate(i));
			else
			if (dataType == 3 || dataType == 6)
			{
				strValue = String.valueOf(rs.getBigDecimal(i));
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
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return StrTool.cTrim(strValue);
	}

	public boolean execUpdateSQL(String sql)
	{
		PreparedStatement pstmt;
		pstmt = null;
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement(StrTool.GBKToUnicode(sql), 1003, 1008);
			pstmt.executeUpdate();
			pstmt.close();
			if (!mflag)
			{
				con.commit();
				con.close();
			}
			break MISSING_BLOCK_LABEL_297;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at execUpdateSQL: ")).append(sql).toString());
			CError.buildErr(this, e.toString());
		}
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_258;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_225;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_258;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
		{
			con.rollback();
			con.close();
		}
		break MISSING_BLOCK_LABEL_295;
		ex;
		ex.printStackTrace();
		return false;
		return false;
		return true;
	}

	public SSRS execSQL(String sql)
	{
		PreparedStatement pstmt;
		ResultSet rs;
		SSRS tSSRS;
		pstmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		tSSRS = null;
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
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
			break MISSING_BLOCK_LABEL_379;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at execSQL(String sql): ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			tSSRS = null;
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_353;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_320;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_353;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_379;
		ex;
		ex.printStackTrace();
		return tSSRS;
	}

	public SSRS execSQL(String sql, int start, int nCount)
	{
		PreparedStatement pstmt;
		ResultSet rs;
		SSRS tSSRS;
		pstmt = null;
		rs = null;
		ResultSetMetaData rsmd = null;
		tSSRS = null;
		System.out.println((new StringBuilder("ExecSQL : ")).append(sql).toString());
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
			break MISSING_BLOCK_LABEL_432;
		}
		catch (SQLException e)
		{
			System.out.println((new StringBuilder("### Error ExeSQL at execSQL(String sql, int start, int nCount): ")).append(sql).toString());
			e.printStackTrace();
			CError.buildErr(this, e.toString());
			tSSRS = null;
		}
		if (rs != null)
			rs.close();
		if (pstmt == null)
			break MISSING_BLOCK_LABEL_406;
		SQLException ex;
		try
		{
			pstmt.close();
			break MISSING_BLOCK_LABEL_372;
		}
		// Misplaced declaration of an exception variable
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception) { }
		break MISSING_BLOCK_LABEL_406;
		Exception exception;
		exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception1) { }
		throw exception;
		try
		{
			System.out.println((new StringBuilder("Sql's bug is very big: ")).append(sql).toString());
			pstmt.close();
		}
		catch (SQLException sqlexception2) { }
		if (!mflag)
			con.close();
		break MISSING_BLOCK_LABEL_432;
		ex;
		ex.printStackTrace();
		return tSSRS;
	}

	public static void main(String args[])
	{
		DBConn conn = DBConnPool.getConnection();
		System.out.println(conn);
	}
}
