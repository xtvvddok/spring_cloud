package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.MNewsService;
import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.bean.News;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.imageutil.Image;
import com.sofmit.fits.common.utils.DataModel;
import com.sofmit.fits.manage.dao.MNewsDao;



@Service
public class MNewsServiceImpl implements MNewsService  {
	@Resource
	private MNewsDao mnewsDao;
	
	@Resource
	private IUploadService uploadService;

	@Override
	public void add(News news) {
//		news.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mnewsDao.save(news);
	}

	@Override
	public void deleteByID(String id) {
		mnewsDao.deleteById(id);
	}
	public void delete(News news){
		mnewsDao.delete(news);
	}
	@Override
	public void update(News news) {
		mnewsDao.update(news);
	}

	@Override
	public News get(String id) {
		return mnewsDao.get(id);
	}

	@Override
	public List<News> getAll() {
		return mnewsDao.getAll();
	}

	@Override
	public DataModel getPage(SkParam param) {
		// TODO Auto-generated method stub
		return mnewsDao.getPage(param);
	}

	@Override
	public RunMsg addNews(News news) {
		RunMsg msg = new RunMsg();
		try {
			if(news.getNavigational() != null){
				String t = news.getNavigational().substring(0, 4);
				if(t.equals("data")){
					String navigational = news.getNavigational().split(",")[1];
					byte[] img = Image.getImage(navigational);
					String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String fileurl = uploadService.saveCompressImg(filename, img);
					news.setNavigational(fileurl);
				}
			}
			if(news.getTopimage() != null){
				String t = news.getTopimage().substring(0, 4);
				if(t.equals("data")){
					String topimage = news.getTopimage().split(",")[1];
					byte[] img = Image.getImage(topimage);
					String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String fileurl = uploadService.saveCompressImg(filename, img);
					news.setTopimage(fileurl);
				}
			}
			if(news.getId() == null || "".equals(news.getId())){
				mnewsDao.save(news);
			} else {
				mnewsDao.update(news);
			}
			msg.setState(true);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setState(false);
		}
		return msg;
	}
	
	public static void main(String[] args) {
		String a = "http://102";
		String b = "jhdfungur";
		
		System.out.println(a.indexOf("http"));
		System.out.println(b.indexOf("http"));
	}

	
	
}
	


