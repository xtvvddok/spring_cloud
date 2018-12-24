package com.sofmit.fits.manage.dao;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;

import java.util.List;

import com.sofmit.fits.bean.City;
import com.sofmit.fits.bean.CityMenu;


public interface MCityMenuDao extends IBaseDao<CityMenu, String> {
	
	public DataModel getPage(SkParam param);
	public List<CityMenu> get(CityMenu c);
}
