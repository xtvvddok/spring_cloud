package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.MCityService;
import com.sofmit.fits.manage.dao.MCityDao;
import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.bean.City;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.imageutil.Image;
import com.sofmit.fits.common.utils.DataModel;



@Service
public class MCityServiceImpl implements MCityService {
	@Resource
	private MCityDao mcityDao;
	@Resource
	private IUploadService uploadService;
	@Override
	public void add(City city) {
//		city.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mcityDao.save(city);
	}

	@Override
	public void deleteByID(String id) {
		mcityDao.deleteById(id);
	}
	public void delete(City city){
		mcityDao.delete(city);
	}
	@Override
	public void update(City city) {
		mcityDao.update(city);
	}

	@Override
	public City get(String id) {
		return mcityDao.get(id);
	}

	@Override
	public List<City> getAll() {
		return mcityDao.getAll();
	}

	@Override
	public DataModel getPage(SkParam param) {
		// TODO Auto-generated method stub
		return mcityDao.getPage(param);
	}

	@Override
	public RunMsg addCity(City city) {
		RunMsg msg = new RunMsg();
		try {
			if(city.getTopimage() != null){
				String t = city.getTopimage().substring(0, 4);
				if(t.equals("data")){
					String topimage = city.getTopimage().split(",")[1];
					byte[] img = Image.getImage(topimage);
					String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String fileurl = uploadService.saveCompressImg(filename, img);
					city.setTopimage(fileurl);
				}
			}
			if(city.getId() == null || "".equals(city.getId())){
				mcityDao.save(city);
			} else {
				mcityDao.update(city);
			}
			msg.setState(true);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setState(false);
		}
		return msg;
	}

	@Override
	public List<City> get(City c) {
		// TODO Auto-generated method stub
		return mcityDao.get(c);
	}

	@Override
	public DataModel getCityPage(SkParam param) {
		// TODO Auto-generated method stub
		return mcityDao.getCityPage(param);
	}

	
	
}
	


