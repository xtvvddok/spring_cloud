package com.sofmit.fits.manage.service;

import java.util.List;
import java.util.Map;

import com.sofmit.fits.bean.ActivityContent;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.vo.NewsContentVo;



public interface MActivityContentService {

	/**
	 * ���
	 * @param activityContent
	 */
	void add(ActivityContent activityContent);
	
	/**����idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(ActivityContent activityContent);
	/**
	 * �޸�
	 * @param activityContent
	 */
	void update(ActivityContent activityContent);
	
	
	/**����id�õ�
	 * @param id
	 * @return
	 */
	ActivityContent get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����ActivityContent
	 * @param @return
	 * @return List<ActivityContent>
	 * @throws
	 */
	List<ActivityContent> getAll();

	
	boolean addContent(List<NewsContentVo> vos,String n_id);
	
	List<Map<String,Object>> getContents(SkParam param);
	
	// TODO �ɸ����Լ�ҵ����չģ��ӿڷ���

}
	


