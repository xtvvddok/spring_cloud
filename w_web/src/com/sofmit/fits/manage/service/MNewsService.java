package com.sofmit.fits.manage.service;

import java.util.List;

import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.utils.DataModel;



public interface MNewsService {

	/**
	 * ���
	 * @param news
	 */
	void add(News news);
	
	/**���idɾ��
	 * @param id
	 */
	void deleteByID(String id);
	
	void delete(News news);
	/**
	 * �޸�
	 * @param news
	 */
	void update(News news);
	
	
	/**���id�õ�
	 * @param id
	 * @return
	 */
	News get(String id);

	/**
	 * @Title: getAll
	 * @Description: ��ȡ����News
	 * @param @return
	 * @return List<News>
	 * @throws
	 */
	List<News> getAll();

	DataModel getPage(SkParam param);
	
	
	RunMsg addNews(News news);
	
	
	
	// TODO �ɸ���Լ�ҵ����չģ��ӿڷ���

}
	


