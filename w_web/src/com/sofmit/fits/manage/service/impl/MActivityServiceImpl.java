package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.MActivityService;
import com.sofmit.fits.manage.dao.MActivityDao;
import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.bean.Activity;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.imageutil.Image;
import com.sofmit.fits.common.utils.DataModel;



@Service
public class MActivityServiceImpl implements MActivityService {
	@Resource
	private MActivityDao mactivityDao;

	@Resource
	private IUploadService uploadService;
	@Override
	public void add(Activity activity) {
//		activity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mactivityDao.save(activity);
	}

	@Override
	public void deleteByID(String id) {
		mactivityDao.deleteById(id);
	}
	public void delete(Activity activity){
		mactivityDao.delete(activity);
	}
	@Override
	public void update(Activity activity) {
		mactivityDao.update(activity);
	}

	@Override
	public Activity get(String id) {
		return mactivityDao.get(id);
	}

	@Override
	public List<Activity> getAll() {
		return mactivityDao.getAll();
	}

	@Override
	public DataModel getPage(SkParam param) {
		// TODO Auto-generated method stub
		return mactivityDao.getPage(param);
	}

	@Override
	public RunMsg addActivity(Activity activity) {
		RunMsg msg = new RunMsg();
		try {
			if(activity.getTopimage() != null){
				String t = activity.getTopimage().substring(0, 4);
				if(t.equals("data")){
					String topimage = activity.getTopimage().split(",")[1];
					byte[] img = Image.getImage(topimage);
					String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String fileurl = uploadService.saveCompressImg(filename, img);
					activity.setTopimage(fileurl);
				}
			}
			if(activity.getId() == null || "".equals(activity.getId())){
				mactivityDao.save(activity);
			} else {
				mactivityDao.update(activity);
			}
			msg.setState(true);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setState(false);
		}
		return msg;
		
	}

	
	
}
	


