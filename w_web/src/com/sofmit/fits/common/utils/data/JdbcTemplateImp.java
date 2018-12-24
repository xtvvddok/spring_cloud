package com.sofmit.fits.common.utils.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Arrays;
import java.util.Map;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.rowset.CachedRowSetImpl;

/**
 * spring JDBC
 * 
 * @author Mark
 * 
 */
public class JdbcTemplateImp implements JdbcTemplatService {
	protected JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private static final Logger logger = Logger
			.getLogger(JdbcTemplateImp.class);

	public JdbcTemplateImp() {
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getTemplate() throws Exception {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

	public DataSource getDS() throws Exception {
		return dataSource;
	}

	public void update(String sql) throws HibernateException {
		if (jdbcTemplate == null)
			throw new HibernateException("jdbcTemplateΪnull");
		try {
			logger.info((new StringBuilder()).append("run  ").append(sql)
					.toString());
			jdbcTemplate.update(sql);
		} catch (Exception e) {
			throw new HibernateException((new StringBuilder())
					.append("jdbcTemplateeִ��sql�쳣").append(sql).append("--")
					.append(e).toString());
		}
	}

	public void update(String sql, Object[] params) throws HibernateException {
		if (jdbcTemplate == null)
			throw new HibernateException("jdbcTemplateΪnull");
		try {
			logger.info((new StringBuilder()).append("run  ").append(sql)
					.toString());
			jdbcTemplate.update(sql, params);
		} catch (Exception e) {
			throw new HibernateException((new StringBuilder())
					.append("jdbcTemplateeִ��sql�쳣").append(sql).append("--")
					.append(e).toString());
		}
	}

	public int[] batchUpdate(String[] sqls) throws HibernateException {
		try {
			return jdbcTemplate.batchUpdate(sqls);
		} catch (Exception e) {
			throw new HibernateException((new StringBuilder())
					.append("jdbcTemplateִ��sql�쳣")
					.append(Arrays.toString(sqls)).append("--").append(e)
					.toString());
		}
	}

	public CachedRowSet getRowSet(String sql) throws HibernateException {
		CachedRowSet crs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			logger.info((new StringBuilder()).append("run  ").append(sql)
					.toString());
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			crs = new CachedRowSetImpl();
			crs.populate(rs);
		} catch (Exception e) {
			throw new HibernateException(e.toString());
		}
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception re) {
			throw new HibernateException((new StringBuilder())
					.append("getRowSet(String sql)�ر�re����")
					.append(re.toString()).toString());
		}
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
		} catch (Exception pe) {
			throw new HibernateException((new StringBuilder())
					.append("getRowSet(String sql)�ر�ps����")
					.append(pe.toString()).toString());
		}
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception pe) {
			throw new HibernateException((new StringBuilder())
					.append("getRowSet(String sql)�ر�con����")
					.append(pe.toString()).toString());
		}
		return crs;
	}

	public CachedRowSet getRowSet(String sql, Map<?, ?> arg)
			throws HibernateException {
		CachedRowSet crs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			logger.info((new StringBuilder()).append("run  ").append(sql)
					.toString());
			ps = con.prepareStatement(sql);
			int k = 0;
			if (arg != null) {
				int len = arg.size();
				if (len > 0)
					for (k = 0; k < len; k++)
						ps.setObject(k + 1, arg.get(String.valueOf(k)));

			}
			rs = ps.executeQuery();
			crs = new CachedRowSetImpl();
			crs.populate(rs);
		} catch (Exception e) {
			throw new HibernateException(e.toString());
		}
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception re) {
			throw new HibernateException((new StringBuilder())
					.append("getRowSet(String sql)�ر�re����")
					.append(re.toString()).toString());
		}
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
		} catch (Exception pe) {
			throw new HibernateException((new StringBuilder())
					.append("getRowSet(String sql)�ر�ps����")
					.append(pe.toString()).toString());
		}
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception pe) {
			throw new HibernateException((new StringBuilder())
					.append("getRowSet(String sql)�ر�con����")
					.append(pe.toString()).toString());
		}
		return crs;
	}

	/**
	 * ִ�д洢���̡�
	 * 
	 * @param proName
	 *            �洢��������
	 * @param args
	 *            ���洢����˳����������ж��ٸ������ٸ�
	 * @return
	 * @throws Exception
	 */
	public boolean execProcedure(String proName, String... args)
			throws Exception {
		boolean flag = true;
		Connection con = null;
		CallableStatement proc = null;
		try {
			con = dataSource.getConnection();
			String para = "(";
			for (int i = 0; i < args.length; i++) {
				if (i > 0) {
					para += ",";
				}
				para += "?";
			}
			para += ")";
			proc = con.prepareCall("{call " + proName + para + "}");
			for (int i = 0; i < args.length; i++) {
				proc.setString(i + 1, args[i]);
			}
			proc.execute();
			logger.info("ִ�в������ز����Ĵ洢���̣�" + proName);
		} catch (Exception e) {
			flag = false;
			throw new Exception((new StringBuilder()).append("ִ�д洢�����쳣")
					.append(e.toString()).toString());
		} finally {
			try {
				if (proc != null)
					proc.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return flag;
	}

	/**
	 * ִ�д�����ֵ�Ĵ洢���̡�
	 * 
	 * @param proName
	 *            �洢��������
	 * @param size
	 *            ����ֵ�ж��ٸ�
	 * @param args
	 *            ���洢����˳����������ж��ٸ������ٸ�
	 * @return
	 */
	public String[] execProcedureResult(String proName, int size,
			String... args) throws Exception {
		String[] result = new String[size];
		Connection con = null;
		CallableStatement proc = null;
		try {
			con = dataSource.getConnection();
			String para = "(";
			int i = 0;
			for (i = 0; i < args.length; i++) {
				if (i > 0) {
					para += ",";
				}
				para += "?";
			}
			for (i = 0; i < size; i++) {
				para += ",?";
			}
			para += ")";
			proc = con.prepareCall("{call " + proName + para + "}");
			for (i = 0; i < args.length; i++) {
				proc.setString(i + 1, args[i]);
			}
			for (i = 0; i < size; i++) {
				proc.registerOutParameter(args.length + i + 1, Types.VARCHAR);
			}
			proc.execute();
			for (i = 0; i < size; i++) {
				result[i] = proc.getString(args.length + i + 1);
			}
			logger.info("ִ�д����ز����Ĵ洢���̣�" + proName);
		} catch (Exception e) {
			throw new Exception((new StringBuilder()).append("ִ�д洢�����쳣")
					.append(e.toString()).toString());
		} finally {
			try {
				if (proc != null)
					proc.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
