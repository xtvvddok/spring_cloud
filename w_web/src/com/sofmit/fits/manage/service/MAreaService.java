package com.sofmit.fits.manage.service;

import java.util.List;
import java.util.Map;

import com.sofmit.fits.bean.Area;
import com.sofmit.fits.common.SkParam;


public interface MAreaService {

	/**
	 * ���
	 * @param area
	 */
	void add(Area area);
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(Area area);
	/**
	 * �޸�
	 * @param area
	 */
	void update(Area area);
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	Area get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����Area
	 * @param @return
	 * @return List<Area>
	 * @throws
	 */
	List<Area> getAll();

	
	List<Map<String,Object>> getAraaCode(SkParam param);
	
	
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���

}
	


