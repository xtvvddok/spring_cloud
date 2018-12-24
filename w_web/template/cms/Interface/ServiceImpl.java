package com.sofmit.fits.Interface.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.Interface.service.I${entity}Service;
import com.sofmit.fits.Interface.dao.I${entity}Dao;
import com.sofmit.sk.common.entity.${entity};



@Service
public class I${entity}ServiceImpl implements I${entity}Service {
	@Resource
	private I${entity}Dao i${lowerEntity}Dao;

	@Override
	public void add(${entity} ${lowerEntity}) {
//		${lowerEntity}.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		i${lowerEntity}Dao.save(${lowerEntity});
	}

	@Override
	public void deleteByID(String id) {
		i${lowerEntity}Dao.deleteById(id);
	}
	public void delete(${entity} ${lowerEntity}){
		i${lowerEntity}Dao.delete(${lowerEntity});
	}
	@Override
	public void update(${entity} ${lowerEntity}) {
		i${lowerEntity}Dao.update(${lowerEntity});
	}

	@Override
	public ${entity} get(String id) {
		return i${lowerEntity}Dao.get(id);
	}

	@Override
	public List<${entity}> getAll() {
		return i${lowerEntity}Dao.getAll();
	}

	
	
}
	


