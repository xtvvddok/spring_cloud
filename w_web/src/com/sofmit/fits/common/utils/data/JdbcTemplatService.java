package com.sofmit.fits.common.utils.data;

import java.util.Map;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import org.hibernate.HibernateException;

/**
 * spring JDBC
 * 
 * @author Mark
 * 
 */
public interface JdbcTemplatService {

	public abstract DataSource getDS() throws Exception;

	public abstract void update(String s) throws HibernateException;

	public abstract void update(String s, Object[] paras)
			throws HibernateException;

	public abstract CachedRowSet getRowSet(String s) throws HibernateException;

	public abstract CachedRowSet getRowSet(String s, Map<?, ?> map)
			throws HibernateException;

	public abstract int[] batchUpdate(String[] sqls) throws HibernateException;

	public boolean execProcedure(String proName, String... args)
			throws Exception;

	public String[] execProcedureResult(String proName, int size,
			String... args) throws Exception;
}
