package com.sofmit.fits.manage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofmit.fits.manage.service.MNewsContentService;
import com.sofmit.fits.vo.NewsContentVo;
import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.bean.NewsContent;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.imageutil.Image;
import com.sofmit.fits.manage.dao.MNewsContentDao;



@Service
public class MNewsContentServiceImpl implements MNewsContentService {
	@Resource
	private MNewsContentDao mnewsContentDao;

	@Resource
	private IUploadService uploadService;
	
	@Override
	public void add(NewsContent newsContent) {
//		newsContent.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mnewsContentDao.save(newsContent);
	}

	@Override
	public void deleteByID(String id) {
		mnewsContentDao.deleteById(id);
	}
	public void delete(NewsContent newsContent){
		mnewsContentDao.delete(newsContent);
	}
	@Override
	public void update(NewsContent newsContent) {
		mnewsContentDao.update(newsContent);
	}

	@Override
	public NewsContent get(String id) {
		return mnewsContentDao.get(id);
	}

	@Override
	public List<NewsContent> getAll() {
		return mnewsContentDao.getAll();
	}

	@Override
	@Transactional
	public boolean addContent(List<NewsContentVo> vos,String n_id) {
		try {
			
			int index = 1;
			NewsContent cc = new NewsContent();
			cc.setN_id(n_id);
			List<NewsContent> beans = mnewsContentDao.getBeans(cc);
			for(NewsContent c : beans){
				mnewsContentDao.delete(c);
			}
			for(NewsContentVo vo : vos){
				NewsContent c = new NewsContent();
				c.setCreate_time(new Date());
				c.setSort(index);
				c.setStatus(0);
				c.setN_id(n_id);
				if(vo.getType().equals("1")){
					if(vo.getContent().substring(0, 4).equals("data")){
						String base = vo.getContent().split(",")[1];
						byte[] img = Image.getImage(base);
						String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
						String fileurl = uploadService.saveCompressImg(filename, img);
						c.setImage(fileurl);
						c.setType(1);
					} else {
						c.setImage(vo.getContent());
						c.setType(1);
					}
				} else if (vo.getType().equals("2")){
					c.setContent(vo.getContent());
					c.setType(2);
				}
				mnewsContentDao.save(c);
				index++;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Map<String, Object>> getContents(SkParam param) {
		
		return mnewsContentDao.getContents(param);
	}

	
	
}
	


