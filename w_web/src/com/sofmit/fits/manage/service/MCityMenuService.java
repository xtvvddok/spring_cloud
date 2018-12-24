package com.sofmit.fits.manage.service;

import java.util.List;

import com.sofmit.fits.bean.City;
import com.sofmit.fits.bean.CityMenu;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;


public interface MCityMenuService {

	/**
	 * ���
	 * @param cityMenu
	 */
	void add(CityMenu cityMenu);
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(CityMenu cityMenu);
	/**
	 * �޸�
	 * @param cityMenu
	 */
	void update(CityMenu cityMenu);
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	CityMenu get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����CityMenu
	 * @param @return
	 * @return List<CityMenu>
	 * @throws
	 */
	List<CityMenu> getAll();

	DataModel getPage(SkParam param);
	
	RunMsg addCityMenu(CityMenu menu);
	List<CityMenu> get(CityMenu menu);
	
	
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���

}
	


