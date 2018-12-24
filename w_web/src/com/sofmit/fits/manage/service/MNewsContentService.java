package com.sofmit.fits.manage.service;

import java.rmi.server.Skeleton;
import java.util.List;
import java.util.Map;

import com.sofmit.fits.bean.NewsContent;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.vo.NewsContentVo;



public interface MNewsContentService {

	/**
	 * ���
	 * @param newsContent
	 */
	void add(NewsContent newsContent);
	
	/**���idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(NewsContent newsContent);
	/**
	 * �޸�
	 * @param newsContent
	 */
	void update(NewsContent newsContent);
	
	
	/**���id�õ�
	 * @param id
	 * @return
	 */
	NewsContent get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����NewsContent
	 * @param @return
	 * @return List<NewsContent>
	 * @throws
	 */
	List<NewsContent> getAll();

	
	boolean addContent(List<NewsContentVo> vos,String n_id);
	
	List<Map<String,Object>> getContents(SkParam param);
	
	// TODO �ɸ���Լ�ҵ����չģ��ӿڷ���

}
	


