package com.sofmit.fits.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class WebApplicationContextUtil {

	private static WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
	private static JdbcTemplate jdbcTemplate  = (JdbcTemplate)wac.getBean("jdbcTemplate");    
	
	private static SessionFactory sessionFactory  = (SessionFactory)wac.getBean("sessionFactory"); 
	
	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
