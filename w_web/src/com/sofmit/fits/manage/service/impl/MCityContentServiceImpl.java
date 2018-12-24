package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.MCityContentService;
import com.sofmit.fits.manage.dao.MCityContentDao;
import com.sofmit.fits.bean.CityContent;

@Service
public class MCityContentServiceImpl implements MCityContentService {
	@Resource
	private MCityContentDao mcityContentDao;

	@Override
	public void add(CityContent cityContent) {
//		cityContent.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mcityContentDao.save(cityContent);
	}

	@Override
	public void deleteByID(String id) {
		mcityContentDao.deleteById(id);
	}
	public void delete(CityContent cityContent){
		mcityContentDao.delete(cityContent);
	}
	@Override
	public void update(CityContent cityContent) {
		mcityContentDao.update(cityContent);
	}

	@Override
	public CityContent get(String id) {
		return mcityContentDao.get(id);
	}

	@Override
	public List<CityContent> getAll() {
		return mcityContentDao.getAll();
	}

	
	
}
	


