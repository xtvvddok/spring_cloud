package com.sofmit.fits.manage.service;

import java.util.List;

import com.sofmit.fits.bean.Activity;
import com.sofmit.fits.bean.City;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;


public interface MCityService {

	/**
	 * ���
	 * @param city
	 */
	void add(City city);
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(City city);
	/**
	 * �޸�
	 * @param city
	 */
	void update(City city);
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	City get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����City
	 * @param @return
	 * @return List<City>
	 * @throws
	 */
	List<City> getAll();

	
	List<City> get(City c);
	
	DataModel getPage(SkParam param);
	
	
	RunMsg addCity(City city);
	
	
	
	DataModel getCityPage(SkParam param);
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���

}
	


