package com.sofmit.fits.manage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofmit.fits.manage.service.MActivityContentService;
import com.sofmit.fits.vo.NewsContentVo;
import com.sofmit.fits.manage.dao.MActivityContentDao;
import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.bean.ActivityContent;
import com.sofmit.fits.bean.ActivityContent;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.imageutil.Image;



@Service
public class MActivityContentServiceImpl implements MActivityContentService {
	@Resource
	private MActivityContentDao mactivityContentDao;
	@Resource
	private IUploadService uploadService;

	@Override
	public void add(ActivityContent activityContent) {
//		activityContent.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mactivityContentDao.save(activityContent);
	}

	@Override
	public void deleteByID(String id) {
		mactivityContentDao.deleteById(id);
	}
	public void delete(ActivityContent activityContent){
		mactivityContentDao.delete(activityContent);
	}
	@Override
	public void update(ActivityContent activityContent) {
		mactivityContentDao.update(activityContent);
	}

	@Override
	public ActivityContent get(String id) {
		return mactivityContentDao.get(id);
	}

	@Override
	public List<ActivityContent> getAll() {
		return mactivityContentDao.getAll();
	}
	@Override
	@Transactional
	public boolean addContent(List<NewsContentVo> vos,String n_id) {
		try {
			
			int index = 1;
			ActivityContent cc = new ActivityContent();
			cc.setA_id(n_id);
			List<ActivityContent> beans = mactivityContentDao.getBeans(cc);
			for(ActivityContent c : beans){
				mactivityContentDao.delete(c);
			}
			for(NewsContentVo vo : vos){
				ActivityContent c = new ActivityContent();
				c.setCreate_time(new Date());
				c.setSort(index);
				c.setStatus(0);
				c.setA_id(n_id);
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
				mactivityContentDao.save(c);
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
		return mactivityContentDao.getContents(param);
	}
}
	


