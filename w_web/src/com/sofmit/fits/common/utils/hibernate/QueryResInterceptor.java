package com.sofmit.fits.common.utils.hibernate;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;


public class QueryResInterceptor extends EmptyInterceptor {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示�?��) 
	*/
	private static final long serialVersionUID = -7290158995921425679L;
	private Logger logger = Logger.getLogger(QueryResInterceptor.class);

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		//logger.info("load object");
		// df.web.CurrentSession.increaseDatabaseVisitTimes();
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public String onPrepareStatement(String sql) {
		// TODO Auto-generated method stub
		df.web.CurrentSession.increaseDatabaseVisitTimes();
		return super.onPrepareStatement(sql);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.findDirty(entity, id, currentState, previousState,
				propertyNames, types);
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return super.getEntity(entityName, id);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		logger.info("save object");
		// df.web.CurrentSession.increaseDatabaseVisitTimes();
		return super.onSave(entity, id, state, propertyNames, types);
	}

}