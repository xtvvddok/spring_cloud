package com.sofmit.fits.manage.service;

import java.util.List;

import com.sofmit.fits.bean.Activity;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;


public interface MActivityService {

	/**
	 * ���
	 * @param activity
	 */
	void add(Activity activity);
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(Activity activity);
	/**
	 * �޸�
	 * @param activity
	 */
	void update(Activity activity);
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	Activity get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����Activity
	 * @param @return
	 * @return List<Activity>
	 * @throws
	 */
	List<Activity> getAll();

	
	
	DataModel getPage(SkParam param);
	
	
	RunMsg addActivity(Activity activity);
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���
	
	

}
	


