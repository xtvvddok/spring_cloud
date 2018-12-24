package com.sofmit.fits.common.MySql;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sofmit.fits.common.WebApplicationContextUtil;
import com.sofmit.fits.common.MySqlException.MySqlException;
import com.sofmit.fits.common.utils.pager.SqlHelp;

@SuppressWarnings("hiding")
public class MySqlUtil<T> {

//	private Map<String,String> expression = new HashMap<>();
//	private Map<String,String> order = new HashMap<>();

	public static final String LIKE = "LIKE%";
	
	private StringBuffer sql_condition = new StringBuffer();

	private List<Object> sql_param = new ArrayList<>();

	private Boolean empty = false;

	private T clazz;

	
	public MySqlUtil(T clazz) {
		this.clazz = clazz;
		try {
			reflectObject(this.clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 反射对象拼接hql
	 * 
	 */
	private void reflectObject(T obj) throws Exception {
		String classname = obj.getClass().getSimpleName();
		//获取传入实体注解的表名
		Annotation[] classAnnotation = obj.getClass().getAnnotations();
		if (obj.getClass().isAnnotationPresent(Table.class)) {
			Table table = obj.getClass().getAnnotation(Table.class);
			sql_condition.append("select o.* from ");
			sql_condition.append(table.name());
			sql_condition.append(" o where ");
		} else {
			throw new MySqlException("传入的参数异常,请传递数据库配置bean!");
		}
		// 获取实体类的所有属性，返回Field数组
		Field[] field = obj.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			// 将属性的首字符大写，方便构造get，set方法
			String UPname = name.substring(0, 1).toUpperCase() + name.substring(1);
			// 获取属性的类型
			String type = field[j].getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
//			Method m = obj.getClass().getMethod("get" + UPname);
			Method m = checkMethod(obj, UPname);
//			PropertyDescriptor pd = new PropertyDescriptor(name, obj.getClass());
//			Method m = pd.getReadMethod();
//			obj.getClass().getm
			// 获取实体bean有Column注解的字段
			if (m.isAnnotationPresent(Column.class)) {
				Column column = m.getAnnotation(Column.class);
				Object value = m.invoke(obj);
				if (value != null) {
					if (empty) {
						sql_condition.append(" and ");
					}
					sql_condition.append("o.").append(column.name());
					checkExpression(value);
//					sql_param.add(value);
					empty = true;
				} else {
					// 继续反射下一个字段
					continue;
				}
			} else {
				continue;
			}

		}
	}

	private Method checkMethod(T obj,String name) throws MySqlException{
		Method[] methods = obj.getClass().getMethods();
		for(Method m : methods){
			if(m.getName().equalsIgnoreCase("get"+name)){
				return m;
			}
		}
		throw new MySqlException("传入的参数异常,未找到相应的方法");
	}
	//拼接条件
	private  void checkExpression(Object value){
		//判断参数类型
		//如果是字符串，判断是否是like查询
		if (value instanceof String) {
		    String s = (String) value;
		    if(s.indexOf("LIKE%")>=0){
				sql_condition.append(" like ? ");
				sql_param.add("%"+s.split("%")[1]+"%");
			} else {
				sql_condition.append(" =? ");
				sql_param.add(value);
			}
		} else {
			sql_condition.append(" =? ");
			sql_param.add(value);
		}
		
	}
	private String getCondition() {
		if (empty) {
			System.out.println(sql_condition);
			return sql_condition.toString();
		} else {
			return null;
		}

	}

	private List<Object> getParam() {
		if (empty) {
			return sql_param;
		} else {
			return null;
		}

	}
	// private Boolean isNotEmpty(){
	// return empty;
	// }

	public T get() {
		if (empty) {
			List<T> list = find(getCondition(), getParam());
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	public List<T> getList() {
		if (empty) {
			return find(getCondition(), getParam());
		}
		return null;
	}

	private List<T> find(String sql, List<Object> objects) {
		SqlHelp sh = new SqlHelp(WebApplicationContextUtil.getJdbcTemplate());
		sh.append(sql);
		sh.addParamList(objects);
		return (List<T>) sh.queryForList(clazz.getClass());
	}

}
