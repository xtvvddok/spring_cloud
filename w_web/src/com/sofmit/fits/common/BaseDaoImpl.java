package com.sofmit.fits.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.sofmit.fits.common.IBaseDao;

public class BaseDaoImpl<T, ID extends Serializable> implements IBaseDao<T, ID> {

	private Class<T> clazz;

	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.clazz = (Class<T>) (((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T get(ID id) {
		T t = (T) getSession().get(clazz, id);
		return t;
	}

	@Override
	public T load(ID id) {
		T t = (T) getSession().load(clazz, id);
		return t;
	}

	@Override
	public List<T> getAll() {
		Query query = getSession().createQuery(
				" from " + clazz.getName() + " t");
		return query.list();
	}

	@Override
	public List<T> find(String hql, Object... objects) {
		Query query = getSession().createQuery(hql);
		if (objects != null && objects.length > 0) {
			int i = 0;
			for (Object obj : objects) {
				query.setParameter(i, obj);
				i++;
			}
		}
		return query.list();
	}

	@Override
	public Serializable save(T t) {
		return getSession().save(t);

	}

	@Override
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public void executeHql(String hql, Object... objects) {
		Query query = getSession().createQuery(hql);
		if (objects != null && objects.length > 0) {
			int i = 0;
			for (Object obj : objects) {
				query.setParameter(i, obj);
				i++;
			}
		}
		query.executeUpdate();
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public void deleteById(ID id) {
		T t = (T) getSession().get(clazz, id);
		if (t != null) {
			getSession().delete(t);
		}
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public Long count(String hql, List<Object> param) {
		Query q = getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(Class objClass, List<Map> param) {
		Criteria criteria = this.getSession().createCriteria(objClass);
		for (Map map : param) {
			criteria.add(Restrictions.eq(map.get("fieldName").toString(),
					map.get("fieldValue")));
		}
		return null;
	}

	public List<T> findForPage(String hql, int page, int rows,
			List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<?> findForPage1(String hql, int page, int rows,
			List<Object> param) {

		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<?> find1(String hql, List<Object> objects) {
		Query query = getSession().createQuery(hql);
		if (objects != null && objects.size() > 0) {
			int i = 0;
			for (Object obj : objects) {
				query.setParameter(i, obj);
				i++;
			}
		}
		return query.list();
	}

	@Override
	public Object getUniqueResult(String hql, List<Object> params) {
		Query query = getSession().createQuery(hql);
		if (params != null && params.size() > 0) {
			int i = 0;
			for (Object obj : params) {
				query.setParameter(i, obj);
				i++;
			}
		}
		return query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(Class<T> clazz, List<Criterion> criterions,
			Integer start, Integer pageSize, Order... orders) {
		Criteria criteria = getSession().createCriteria(clazz);
		if (criterions != null) {
			for (Criterion param : criterions) {
				criteria.add(param);
			}
		}

		if (start != null)
			criteria.setFirstResult(start);
			//criteria.setFetchSize(start);
		if (pageSize != null)
			criteria.setMaxResults(pageSize);

		if (orders != null) {
			for (Order order : orders) {
				criteria.addOrder(order);
			}
		}
		return criteria.list();
	}

	@Override
	public <T> Long qbccount(Class<T> clazz, List<Criterion> criterions) {
		Criteria criteria = getSession().createCriteria(clazz);
		if (criterions != null) {
			for (Criterion param : criterions) {
				criteria.add(param);
			}
		}
		criteria.setProjection(Projections.count("id"));
		Object obj = criteria.uniqueResult();
		if (obj instanceof Number) {
			return (Long) obj;
		} else {
			return 0L;
		}
	}

	@Override
	public <T> List<T> getList(Class<T> clazz, List<Criterion> criterions,
			Order... orders) {
		return getList(clazz, criterions, null, null, orders);
	}
}
