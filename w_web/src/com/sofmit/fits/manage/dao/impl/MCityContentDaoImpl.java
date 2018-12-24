package com.sofmit.fits.manage.dao.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.MCityContentDao;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.fits.bean.City;
import com.sofmit.fits.bean.CityContent;


@Repository
public class MCityContentDaoImpl extends BaseDaoImpl<CityContent, String> implements
		MCityContentDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
}
