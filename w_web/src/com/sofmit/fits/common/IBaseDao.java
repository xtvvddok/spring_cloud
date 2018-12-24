package com.sofmit.fits.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public interface IBaseDao<T, ID extends Serializable> {

	public T get(ID id);

	public T load(ID id);

	public List<T> getAll();

	public List<T> find(String hql, Object... objects);

	public Serializable save(T t);

	public void saveOrUpdate(T t);

	public void executeHql(String hql, Object... objects);

	public void delete(T t);

	public void deleteById(ID id);

	public void update(T t);


	public Long count(String hql, List<Object> param);

	
	public Long count(Class objClass, List<Map> param);


	public List<T> findForPage(String hql, int page, int rows,
			List<Object> param);

	
	public List<?> findForPage1(String hql, int page, int rows,
			List<Object> param);

	public List<?> find1(String hql, List<Object> objects);

	public Object getUniqueResult(String hql, List<Object> params);
	
	public <T> List<T> getList(Class<T> clazz, List<Criterion> criterions, Integer start, Integer pageSize, Order... orders);

	public <T> Long qbccount(Class<T> clazz, List<Criterion> criterions);
	
	public <T> List<T> getList(Class<T> clazz, List<Criterion> criterions, Order... orders);
}