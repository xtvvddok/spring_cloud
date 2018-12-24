package com.sofmit.fits.common.utils.pager;

public interface ISqlPager {

	public String getLimitSqlString(String sql, int pageNo, int pageSize,String order);
	

}
