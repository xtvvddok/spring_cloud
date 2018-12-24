package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.M${entity}Service;
import com.sofmit.fits.manage.dao.M${entity}Dao;
import com.sofmit.sk.common.entity.${entity};



@Service
public class M${entity}ServiceImpl implements M${entity}Service {
	@Resource
	private M${entity}Dao m${lowerEntity}Dao;

	@Override
	public void add(${entity} ${lowerEntity}) {
//		${lowerEntity}.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		m${lowerEntity}Dao.save(${lowerEntity});
	}

	@Override
	public void deleteByID(String id) {
		m${lowerEntity}Dao.deleteById(id);
	}
	public void delete(${entity} ${lowerEntity}){
		m${lowerEntity}Dao.delete(${lowerEntity});
	}
	@Override
	public void update(${entity} ${lowerEntity}) {
		m${lowerEntity}Dao.update(${lowerEntity});
	}

	@Override
	public ${entity} get(String id) {
		return m${lowerEntity}Dao.get(id);
	}

	@Override
	public List<${entity}> getAll() {
		return m${lowerEntity}Dao.getAll();
	}

	
	
}
	


