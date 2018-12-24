package com.sofmit.fits.manage.dao;
import java.util.List;
import java.util.Map;

import com.sofmit.fits.bean.NewsContent;
import com.sofmit.fits.common.IBaseDao;
import com.sofmit.fits.common.SkParam;


public interface MNewsContentDao extends IBaseDao<NewsContent, String> {
	public List<Map<String, Object>> getContents(SkParam param);
	
	public List<NewsContent> getBeans(NewsContent c);
	
}
