package com.sofmit.fits.manage.dao.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.MCityDao;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.MySql.MyHqlUtil;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.common.utils.Pager;
import com.sofmit.fits.common.utils.pager.MySqlPager;
import com.sofmit.fits.common.utils.pager.SqlHelp;
import com.sofmit.fits.bean.City;
import com.sofmit.fits.bean.NewsContent;

@Repository
public class MCityDaoImpl extends BaseDaoImpl<City, String> implements
		MCityDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public DataModel getPage(SkParam param) {
		try {
			SqlHelp sh = new SqlHelp(jdbcTemplate);
//			sh.append(" select id,title,navigational,topimage,status,IFNULL(create_user,'-') create_user,date_format(create_time,'%Y%m%d  %H:%i:%s') create_time,IFNULL(date_format(update_time,'%Y%m%d  %H:%i:%s'),'-') update_time,IFNULL(pub_user,'-') pub_user,IFNULL(date_format(pub_time,'%Y%m%d  %H:%i:%s'),'-') pub_time from news order by create_time");
			sh.append(" select id,city_name,topimage,summary,");
			sh.append(" date_format(create_time,'%Y-%m-%d  %H:%i:%s') create_time,");
			sh.append(" IFNULL(pub_user,'-') pub_user,IFNULL(date_format(pub_time,'%Y-%m-%d  %H:%i:%s'),'-') pub_time,create_user, ");
			sh.append(" status from city where status in(1,0) order by create_time desc");
			sh.setPageNo(param.getPid());
			sh.setPageSize(param.getPsize());
			sh.setSqlPager(new MySqlPager());
			Pager<List<Map<String, Object>>> pager = sh.queryForPager();
			DataModel dataLists = new DataModel(pager.getRowsMap(),pager.getTotalRows());
			return dataLists;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<City> get(City c) {
		try {
			MyHqlUtil<City> hql = new MyHqlUtil<City>(c);
			List<City> list = hql.getList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DataModel getCityPage(SkParam param) {
		try {
			SqlHelp sh = new SqlHelp(jdbcTemplate);
//			sh.append(" select id,title,navigational,topimage,status,IFNULL(create_user,'-') create_user,date_format(create_time,'%Y%m%d  %H:%i:%s') create_time,IFNULL(date_format(update_time,'%Y%m%d  %H:%i:%s'),'-') update_time,IFNULL(pub_user,'-') pub_user,IFNULL(date_format(pub_time,'%Y%m%d  %H:%i:%s'),'-') pub_time from news order by create_time");
			sh.append(" select id,city_name,topimage,city_code,");
			sh.append(" (select count(1) from city_menu where city_code = c.city_code) menunum,");
			sh.append(" (select count(1) from news where city_code = c.city_code) newsnum,");
			sh.append(" (select count(1) from tour where city_code = c.city_code) tournum,");
			sh.append(" (select count(1) from activity where city_code=c.city_code) citivitynum ");
			sh.append(" from city c where status in(1,0) order by create_time desc");
			sh.setPageNo(param.getPid());
			sh.setPageSize(param.getPsize());
			sh.setSqlPager(new MySqlPager());
			Pager<List<Map<String, Object>>> pager = sh.queryForPager();
			DataModel dataLists = new DataModel(pager.getRowsMap(),pager.getTotalRows());
			return dataLists;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
