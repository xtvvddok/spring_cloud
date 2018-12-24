package com.sofmit.fits.manage.dao;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.bean.Activity;
import com.sofmit.fits.common.BaseDaoImpl;

public interface MActivityDao extends IBaseDao<Activity, String> {
	
	public DataModel getPage(SkParam param);
}
