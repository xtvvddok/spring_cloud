package com.sofmit.fits.common.utils.pager;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;

import com.sofmit.fits.common.utils.hibernate.HPage;

public class MySqlPager implements ISqlPager {

	@Override
	public String getLimitSqlString(String sql, int pageNo, int pageSize,String order) {	
		HPage<T> page = new HPage<T>(pageNo,pageSize);
		String o = "";
		if(StringUtils.isNotBlank(order)){
			o += " order by "+order;
		}
        return sql + o + " limit "+  page.offset()+","+page.getPageSize();
	}

	

}
