package com.sofmit.fits.manage.service;

import java.util.List;

import com.sofmit.sk.common.entity.${entity};


public interface M${entity}Service {

	/**
	 * ���
	 * @param ${lowerEntity}
	 */
	void add(${entity} ${lowerEntity});
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(${entity} ${lowerEntity});
	/**
	 * �޸�
	 * @param ${lowerEntity}
	 */
	void update(${entity} ${lowerEntity});
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	${entity} get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����${entity}
	 * @param @return
	 * @return List<${entity}>
	 * @throws
	 */
	List<${entity}> getAll();

	
	
	
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���

}
	


