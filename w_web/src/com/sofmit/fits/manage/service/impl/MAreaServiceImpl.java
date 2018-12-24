package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.MAreaService;
import com.sofmit.fits.manage.dao.MAreaDao;
import com.sofmit.fits.bean.Area;
import com.sofmit.fits.common.SkParam;



@Service
public class MAreaServiceImpl implements MAreaService {
	@Resource
	private MAreaDao mareaDao;

	@Override
	public void add(Area area) {
//		area.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mareaDao.save(area);
	}

	@Override
	public void deleteByID(String id) {
		mareaDao.deleteById(id);
	}
	public void delete(Area area){
		mareaDao.delete(area);
	}
	@Override
	public void update(Area area) {
		mareaDao.update(area);
	}

	@Override
	public Area get(String id) {
		return mareaDao.get(id);
	}

	@Override
	public List<Area> getAll() {
		return mareaDao.getAll();
	}

	@Override
	public List<Map<String, Object>> getAraaCode(SkParam param) {
		// TODO Auto-generated method stub
		return mareaDao.getAraaCode(param);
	}

	
	
}
	


