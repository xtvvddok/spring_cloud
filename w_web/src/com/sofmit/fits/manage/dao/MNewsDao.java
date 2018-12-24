package com.sofmit.fits.manage.dao;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;


public interface MNewsDao extends IBaseDao<News, String> {
	
	public DataModel getPage(SkParam param);
}
