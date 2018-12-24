package com.sofmit.fits.common.utils;

import java.util.Calendar;

import com.sofmit.fits.common.utils.file.PropertyUtil;

public class Contants {
	public static final String POLINFO_IMAGE_ADDRESS = "polInfo_images";
	/**
	 * 景区图片
	 */
	public static final String SCENIC_IMAGE_ADDRESS = "scenic_images";
	public static final String ALL_PRODUCT_IMAGE_ADDRESS = "all_product_images";
	public static final String STRATEGY_IMAGE_ADDRESS = "strategy_images";
	public static final String VIEW_IMAGE_ADDRESS = "view_images";
	public static final String COUNTRY_IMAGE_ADDRESS = "country_images";
	public static final String USER_IMAGE_ADDRESS = "user_photos";
	public static final String VIEDIO_ADDRESS = "index_video";
	
	public static final String VIEDIO_MUSCI_IMAGE ="viedio_musci_image";
	public static final String VIEDIO_MUSCI_VIDEIO ="viedio_musci_videio";
	public static final String FILE_SEPARATOR = "/";
	/* 手机首页存储图片的路径 */
	public static final String PHONE_INDEX_ADDRESS = "phone_index_images";


	/** 存如session中的验证码键 */
	public static final String VALID_CODE = "validCode";

	/** 后台登陆后session中键 */
	public static final String LOGIN_SESSION = "login_session";
	/** 前台登录session */
	public static final String FRONT_LOGIN_SESSION = "front_login_session";
	/** 前台登录session */
	public static final String FRONT_USER_NAME = "front_user_name";
	/**
	 * 请求DDS 参数
	 */
	public static final String IDENTIFICATION = "3";
	public static final String SECURITYTYPE = "MD5";
	public static final String SIGNKEY = "3";
//	public static final String DDS_URL_REQUEST="http://10.10.1.249:8080/dds/ddsservice.do";
	public static final String DDS_URL_REQUEST="http://10.10.100.8:9000/dds/ddsservice.do";
	/**
	 * 图片服务器参数
	 */
	public static final String IMGFTPIP = "10.10.1.241";
	public static final String IMGFTPPATH = "/image/lszsk/hotel";
	public static final int IMGFTPPORT = 9002;
	public static final String IMAGEADDRESS = "ftp://10.10.1.241:9002/image/lszsk/hotel";
	public static final String IMGFTPUSERNAME = "sofmit";
	public static final String IMGFTPPASSWORD = "sofmit";
	public static final String IMG_VIEWS_IMG_RESOURCE = "http://"+IMGFTPIP+":9001/";
	
	
	/**
	 * 
	 * 创建日期路径
	 */
	public static String createDatePath(){
			Calendar calendar=Calendar.getInstance();
			int year=calendar.get(Calendar.YEAR);//获取年
			int month=calendar.get(Calendar.MONTH)+1;
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			//图片保存的根路径
			String datePath=year+Contants.FILE_SEPARATOR+month+Contants.FILE_SEPARATOR+day;
			return datePath;
	}
}
