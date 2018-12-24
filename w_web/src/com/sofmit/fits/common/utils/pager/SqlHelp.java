package com.sofmit.fits.common.utils.pager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sofmit.fits.common.utils.Pager;




public class SqlHelp {
	private static final Logger log = Logger.getLogger(SqlHelp.class);

	
	private QueryParams queryParams;
	private StringBuilder sb = new StringBuilder();
	private int pageNo;
	private int pageSize;
	private List<Object> parameter = new ArrayList<Object>();
	private ISqlPager sqlPager;

	private JdbcTemplate jdbcTemplate;

	public SqlHelp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SqlHelp(JdbcTemplate jdbcTemplate,QueryParams queryParams) {
		this.jdbcTemplate = jdbcTemplate;
		this.queryParams = queryParams;
	}
	
	public SqlHelp append(String sql) {
		sb.append(sql);
		return this;
	}

	public void addParam(Object obj) {
		parameter.add(obj);
	}
	public void addParamList(List<Object> obj) {
		parameter.addAll(obj);
	}

	public Integer queryForInt() {
		try{
			return queryForObject(Integer.class);
		}catch (Exception e) {
			return null;
		}
	}

	public String queryForStr() {
		return queryForObject(String.class);
	}

	public Double queryForDouble() {
		return queryForObject(Double.class);
	}

	public int getTotalSize() {
		String sql = sb.toString();
		StringBuilder tempBulider = new StringBuilder();
		tempBulider.append("select count(*) from ( ");
		tempBulider.append(sql);
		tempBulider.append(" ) a");
		Integer result = jdbcTemplate.queryForObject(tempBulider.toString(),
				parameter.toArray(), Integer.class);
		return result;
	}

	private <T> T queryForObject(Class<T> clazz) {
		return jdbcTemplate.queryForObject(sb.toString(), parameter.toArray(),
				clazz);
	}

	public <T> List<T> queryForList(Class<T> clazz) {
		try {
			return queryForList(BeanPropertyRowMapper.newInstance(clazz));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public <T>  T queryForSingle(Class<T> clazz) {
		return jdbcTemplate.queryForObject(sb.toString(), parameter.toArray(), clazz);
	}

	public <T> List<T> queryForListNoBean(Class<T> clazz) {
		return jdbcTemplate.queryForList(sb.toString(), clazz,
				parameter.toArray());
	}

	public <T> List<T> queryForList(Class<T> clazz, Map<String, Object> param) {
		if (parameter.size() > 0 && param != null && param.size() > 0) {
			throw new RuntimeException("parameter already is exist");
		}
		return null;
	}

	public <T> List<T> queryForList(RowMapper<T> rowMapper)
			throws ClassNotFoundException {
		String sql = null;
		if (getPageNo() > 0 && getPageSize() <= 0) {
			throw new RuntimeException(
					"the query pageSize property can't be 0!");
		}

		if (getPageNo() == 0 && getPageSize() == 0) {
			sql = sb.toString();
		} else {
			String sort = null;
			if(queryParams!=null){
				sort = getSort();
			}
			if (sqlPager != null) {
				sql = sqlPager.getLimitSqlString(sb.toString(), pageNo,
						pageSize,null);
			} else {
				sql = SqlPagerFactory.DEFAULT_SQL_PAGER.getLimitSqlString(
						sb.toString(), pageNo, pageSize,sort);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("JdbcTemplate:" + sql + "\n param:"
					+ parameter.toString());
		}
		List<T> searchList = jdbcTemplate.query(sql, rowMapper,
				parameter.toArray());
		
		return searchList != null ? searchList : new ArrayList<T>(0);
	}

	
	public List<Map<String, Object>> queryForList()
			throws ClassNotFoundException {
		String sql = null;
		if (getPageNo() > 0 && getPageSize() <= 0) {
			throw new RuntimeException(
					"the query pageSize property can't be 0!");
		}
		if (getPageNo() == 0 && getPageSize() == 0) {
			sql = sb.toString();
		} else {
			String sort = null;
			if(queryParams!=null){
				sort = getSort();
			}
			if (sqlPager != null) {
				sql = sqlPager.getLimitSqlString(sb.toString(), pageNo,
						pageSize,sort);
			} else {
				sql = SqlPagerFactory.DEFAULT_SQL_PAGER.getLimitSqlString(
						sb.toString(), pageNo, pageSize,sort);
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("JdbcTemplate:" + sql + "\n param:"
					+ parameter.toString());
		}
		List<Map<String, Object>> searchList = jdbcTemplate.queryForList(sql,parameter.toArray());
		
		return searchList != null ? searchList : new ArrayList<Map<String, Object>>(0);
		
	}
	
//	public <T> Pager<T> queryForPager(Class<T> clazz) {
//		Pager<T> pager = new Pager<T>(getPageNo(), getPageSize(),
//				getTotalSize());
//		pager.setRows(queryForList(clazz));
//		return pager;
//	}
//	public <T> Pager<T> queryForPager() throws ClassNotFoundException {
//		Pager<T> pager = new Pager<T>(getPageNo(), getPageSize(),
//				getTotalSize());
//		pager.setRowsMap(queryForList());
//		return pager; 
//	}
	public <T> Pager<T> queryForPager(Class<T> clazz) {
		Pager<T> pager = new Pager<T>(getPageNo(), getPageSize(),
				getTotalSize());
		pager.setRows(queryForList(clazz));
		return pager;
	}
	public <T> Pager<T> queryForPager() throws ClassNotFoundException {
		Pager<T> pager = new Pager<T>(getPageNo(), getPageSize(),
				getTotalSize());
		pager.setRowsMap(queryForList());
		return pager;
	}
	
	
	public List<Map<String, Object>> queryForMap() {
		return jdbcTemplate.queryForList(sb.toString(), parameter.toArray());
	}
	
	public List<String> queryForListByColumnName(String column) {
		column = column.toUpperCase();
		try {
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sb.toString(), parameter.toArray());
			List<String> columns = new ArrayList<>();
			for (Map<String, Object> m : list) {
				columns.add(m.get(column).toString());
			}
		    return columns;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Object> queryForMapSingle() {
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sb.toString(), parameter.toArray());
		if(list!=null&&list.size()>0){
			return  list.get(0);
		}
		return null;
	}

	public int executeSql() {
		return jdbcTemplate.update(sb.toString(), parameter.toArray());
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @param sqlPager
	 *            the sqlPager to set
	 */
	public void setSqlPager(ISqlPager sqlPager) {
		this.sqlPager = sqlPager;
	}

	public String getSb() {
		return this.sb.toString();
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public QueryParams getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(QueryParams queryParams) {
		this.queryParams = queryParams;
	}

	public String getSort() {
		if (queryParams.getSort().equals("1")) {
			return " 1 " + queryParams.getOrder();
		}
		return queryParams.getSort() + " " + queryParams.getOrder() + ", 1 asc ";
	}
}
