package com.sofmit.fits.manage.service;

import java.util.List;

import com.sofmit.fits.bean.CityContent;



public interface MCityContentService {

	/**
	 * ���
	 * @param cityContent
	 */
	void add(CityContent cityContent);
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(CityContent cityContent);
	/**
	 * �޸�
	 * @param cityContent
	 */
	void update(CityContent cityContent);
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	CityContent get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����CityContent
	 * @param @return
	 * @return List<CityContent>
	 * @throws
	 */
	List<CityContent> getAll();

	
	
	
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���

}
	


