package com.sofmit.fits.manage.dao;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;

import java.util.List;
import java.util.Map;

import com.sofmit.fits.bean.Area;


public interface MAreaDao extends IBaseDao<Area, String> {
	public List<Map<String, Object>> getAraaCode(SkParam param);
}
