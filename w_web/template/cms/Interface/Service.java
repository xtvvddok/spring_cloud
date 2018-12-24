package com.sofmit.fits.Interface.service;

import java.util.List;

import com.sofmit.sk.common.entity.${entity};


public interface I${entity}Service {

	/**
	 * 添加
	 * @param ${lowerEntity}
	 */
	void add(${entity} ${lowerEntity});
	
	/**根据id删除
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(${entity} ${lowerEntity});
	/**
	 * 修改
	 * @param ${lowerEntity}
	 */
	void update(${entity} ${lowerEntity});
	
	
	/**根据id得到
	 * @param id
	 * @return
	 */
	${entity} get(String id);

	/**
	 * @Title: getAll
	 * @Description: 获取所有${entity}
	 * @param @return
	 * @return List<${entity}>
	 * @throws
	 */
	List<${entity}> getAll();

	
	
	
	// TODO 可根据自己业务拓展模版接口方法

}
	


