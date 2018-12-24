package com.sofmit.fits.Interface.dao.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.Interface.dao.I${entity}Dao;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.sk.common.entity.${entity};


@Repository
public class I${entity}DaoImpl extends BaseDaoImpl<${entity}, String> implements
		I${entity}Dao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
}
