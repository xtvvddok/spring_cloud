package com.sofmit.fits.manage.dao.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.MActivityContentDao;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.MySql.MyHqlUtil;
import com.sofmit.fits.common.utils.pager.SqlHelp;
import com.sofmit.fits.bean.ActivityContent;
import com.sofmit.fits.bean.NewsContent;


@Repository
public class MActivityContentDaoImpl extends BaseDaoImpl<ActivityContent, String> implements
		MActivityContentDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getContents(SkParam param) {
		try {
			SqlHelp sh = new SqlHelp(jdbcTemplate);
			sh.append(" select id,type,if(type=1,image,if(type=2,content,'-')) content from activity_content where a_id = ?  ");
			sh.addParam(param.getId());
			return sh.queryForMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ActivityContent> getBeans(ActivityContent c) {
		try {
			MyHqlUtil<ActivityContent> hql = new MyHqlUtil<ActivityContent>(c);
			List<ActivityContent> list = hql.getList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
