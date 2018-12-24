package com.sofmit.fits.manage.dao;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;

import java.util.List;
import java.util.Map;

import com.sofmit.fits.bean.ActivityContent;
import com.sofmit.fits.bean.NewsContent;

public interface MActivityContentDao extends IBaseDao<ActivityContent, String> {
	public List<Map<String, Object>> getContents(SkParam param);
	
	public List<ActivityContent> getBeans(ActivityContent c);
}
