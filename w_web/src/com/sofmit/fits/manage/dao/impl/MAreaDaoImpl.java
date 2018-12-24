package com.sofmit.fits.manage.dao.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.MAreaDao;
import com.sofmit.fits.bean.Area;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.pager.SqlHelp;


@Repository
public class MAreaDaoImpl extends BaseDaoImpl<Area, String> implements
		MAreaDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getAraaCode(SkParam param) {
		try {
			SqlHelp sh = new SqlHelp(jdbcTemplate);
			sh.append("select id,parent,name text ,level_type from area");
			return sh.queryForList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
