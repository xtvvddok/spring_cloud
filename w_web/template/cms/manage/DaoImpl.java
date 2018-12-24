package com.sofmit.fits.manage.dao.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.M${entity}Dao;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.sk.common.entity.${entity};


@Repository
public class M${entity}DaoImpl extends BaseDaoImpl<${entity}, String> implements
		M${entity}Dao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
}
