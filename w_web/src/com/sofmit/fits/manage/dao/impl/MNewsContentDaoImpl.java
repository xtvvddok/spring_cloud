package com.sofmit.fits.manage.dao.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.MNewsContentDao;
import com.sofmit.fits.bean.NewsContent;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.MySql.MyHqlUtil;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.common.utils.Pager;
import com.sofmit.fits.common.utils.pager.MySqlPager;
import com.sofmit.fits.common.utils.pager.SqlHelp;


@Repository
public class MNewsContentDaoImpl extends BaseDaoImpl<NewsContent, String> implements
		MNewsContentDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getContents(SkParam param) {
		try {
			SqlHelp sh = new SqlHelp(jdbcTemplate);
			sh.append(" select id,type,if(type=1,image,if(type=2,content,'-')) content from news_content where n_id = ?  ");
			sh.addParam(param.getId());
			return sh.queryForMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NewsContent> getBeans(NewsContent c) {
		try {
			MyHqlUtil<NewsContent> hql = new MyHqlUtil<NewsContent>(c);
			List<NewsContent> list = hql.getList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
