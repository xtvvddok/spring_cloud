package com.sofmit.fits.manage.dao;
import java.util.List;

import com.sofmit.fits.bean.City;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;


public interface MCityDao extends IBaseDao<City, String> {
	public DataModel getPage(SkParam param);
	public List<City> get(City c);
	public DataModel getCityPage(SkParam param);
}
