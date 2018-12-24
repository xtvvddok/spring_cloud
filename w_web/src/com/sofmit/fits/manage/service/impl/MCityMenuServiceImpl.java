package com.sofmit.fits.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sofmit.fits.manage.service.MCityMenuService;

import sun.misc.BASE64Decoder;

import com.sofmit.fits.manage.dao.MCityMenuDao;
import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.bean.CityMenu;
import com.sofmit.fits.common.RunMsg;
import com.sofmit.fits.common.SkParam;
import com.sofmit.fits.common.imageutil.Image;
import com.sofmit.fits.common.utils.DataModel;



@Service
public class MCityMenuServiceImpl implements MCityMenuService {
	@Resource
	private MCityMenuDao mcityMenuDao;
	@Resource
	private IUploadService uploadService;
	@Override
	public void add(CityMenu cityMenu) {
//		cityMenu.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		mcityMenuDao.save(cityMenu);
	}

	@Override
	public void deleteByID(String id) {
		mcityMenuDao.deleteById(id);
	}
	public void delete(CityMenu cityMenu){
		mcityMenuDao.delete(cityMenu);
	}
	@Override
	public void update(CityMenu cityMenu) {
		mcityMenuDao.update(cityMenu);
	}

	@Override
	public CityMenu get(String id) {
		return mcityMenuDao.get(id);
	}

	@Override
	public List<CityMenu> getAll() {
		return mcityMenuDao.getAll();
	}

	@Override
	public DataModel getPage(SkParam param) {
		// TODO Auto-generated method stub
		return mcityMenuDao.getPage(param);
	}

	protected static BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	@Override
	public RunMsg addCityMenu(CityMenu menu) {
		RunMsg msg = new RunMsg();
		try {
			if(menu.getIcon() != null){
				String t = menu.getIcon().substring(0, 4);
				if(t.equals("data")){
					String icon = menu.getIcon().split(",")[1];
					byte[] bytes = decoder.decodeBuffer(icon);
					String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String fileurl = uploadService.saveCompressImg(filename, bytes);
					menu.setIcon(fileurl);
				}
			}
			if(menu.getImage() != null){
				String t = menu.getImage().substring(0, 4);
				if(t.equals("data")){
					String topimage = menu.getImage().split(",")[1];
					byte[] img = Image.getImage(topimage);
					String filename = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String fileurl = uploadService.saveCompressImg(filename, img);
					menu.setImage(fileurl);
				}
			}
			if(menu.getId() == null || "".equals(menu.getId())){
				mcityMenuDao.save(menu);
			} else {
				mcityMenuDao.update(menu);
			}
			msg.setState(true);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setState(false);
		}
		return msg;
	}

	@Override
	public List<CityMenu> get(CityMenu menu) {
		// TODO Auto-generated method stub
		return mcityMenuDao.get(menu);
	}

	
	
}
	


