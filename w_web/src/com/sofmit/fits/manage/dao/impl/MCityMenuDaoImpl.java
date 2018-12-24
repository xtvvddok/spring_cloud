package com.sofmit.fits.manage.dao.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.sofmit.fits.manage.dao.MCityMenuDao;
import com.sofmit.fits.bean.City;
import com.sofmit.fits.bean.CityMenu;
import com.sofmit.fits.common.BaseDaoImpl;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.MySql.MyHqlUtil;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.common.utils.Pager;
import com.sofmit.fits.common.utils.pager.MySqlPager;
import com.sofmit.fits.common.utils.pager.SqlHelp;


@Repository
public class MCityMenuDaoImpl extends BaseDaoImpl<CityMenu, String> implements
		MCityMenuDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public DataModel getPage(SkParam param) {
		try {
			SqlHelp sh = new SqlHelp(jdbcTemplate);
//			sh.append(" select id,title,navigational,topimage,status,IFNULL(create_user,'-') create_user,date_format(create_time,'%Y%m%d  %H:%i:%s') create_time,IFNULL(date_format(update_time,'%Y%m%d  %H:%i:%s'),'-') update_time,IFNULL(pub_user,'-') pub_user,IFNULL(date_format(pub_time,'%Y%m%d  %H:%i:%s'),'-') pub_time from news order by create_time");
			sh.append(" select id,icon,icon_value,image,");
			sh.append(" date_format(create_time,'%Y-%m-%d  %H:%i:%s') create_time,");
			sh.append(" IFNULL(pub_user,'-') pub_user,IFNULL(date_format(pub_time,'%Y-%m-%d  %H:%i:%s'),'-') pub_time,create_user, ");
			sh.append(" status from city_menu where status in(1,0) ");
			if(param.getCity() != null && !"".equals(param.getCity())){
				sh.append(" and city_code = ? ");
				sh.addParam(param.getCity());
			}
			sh.append(" order by create_time desc" );
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
	public List<CityMenu> get(CityMenu c) {
		try {
			MyHqlUtil<CityMenu> hql = new MyHqlUtil<CityMenu>(c);
			List<CityMenu> list = hql.getList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
