package com.sofmit.fits.common.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.sofmit.fits.common.utils.file.PropertyUtil;

public class SystemUtils {
	
	private static ResourceBundle bundle = ResourceBundle
			.getBundle("sysconfig");

	/**
	 * 
	 * @Title: getLoginUser
	 * @Description: TODO(获取当前登录用户)
	 * @param @param rq
	 * @param @return 设定文件
	 * @return AdminUser 返回类型
	 * @date 2015�?�?9�?上午10:21:25
	 * @author SKIN
	 * @throws
	 */
//	public static AdminUser getLoginUser(HttpServletRequest rq) {
//		return (AdminUser) rq.getSession().getAttribute(Contants.LOGIN_SESSION);
//
//	}
	public static Boolean andOrWhere(StringBuilder sh, Boolean flag) {
		if (!flag) {
			if (sh.toString().toLowerCase().contains(" where "))
				flag = true;
		}
		if (!flag) {
			sh.append(" where ");
			flag = true;
		} else {
			sh.append(" and ");
		}
		return flag;
	}

	/**
	 * 
	 * @Title: repalceSpeical
	 * @Description: TODO(替换掉指定字符串前面的内容，�?��被替换掉的字符串首次出现的位�?未找�?则返回原字符�?
	 * @param @param hql 原字符串
	 * @param @param speical �?��被替换的字符�?
	 * @param @param newChar 新字符串
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @date 2015�?�?�?下午4:24:45
	 * @author SKIN
	 * @throws
	 */
	public static String repalceSpeical(String hql, String speical,
			String newChar) {
		if (StringUtils.isNotEmpty(hql)) {
			int index = hql.indexOf(speical);
			if (index != -1) {
				hql = hql.replace(hql.substring(0, index), newChar);
			}

		}
		return hql;
	}

	public static String getJson(Object o) {
		Gson gs = new Gson();
		if (o != null) {
			return gs.toJson(o);
		}
		return "{}";
	}

	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getRealPath(HttpServletRequest rq, String path) {
		return rq.getSession().getServletContext().getRealPath(path);
	}

	/**
	 * 
	 * @Title: getRootPath
	 * @Description: TODO(获取项目的根路径)
	 * @param @param rq
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @date 2015�?�?3�?上午10:17:07
	 * @author SKIN
	 * @throws
	 */
	public static String getRootPath(HttpServletRequest rq) {

		return rq.getContextPath();
	}

	/**
	 * 
	 * @Title: picSaveAddress
	 * @Description: TODO(这里用一句话描述这个方法的作�?
	 * @param @param fileName 文件夹名�?
	 * @param @param file 文件名称 加上后缀�?
	 * @param @param rq
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @date 2015�?�?3�?上午11:14:26
	 * @author SKIN
	 * @throws
	 */

//	public static String picSaveAddress(String fileName, String file,
//			HttpServletRequest rq) {
//		return PropertyUtil.getProperty("web_image_url")+ Contants.FILE_SEPARATOR + "upload_Images" 
//				+ Contants.FILE_SEPARATOR + fileName + Contants.FILE_SEPARATOR 
//				+ file;
////		return 	PropertyUtil.getProperty("web_image_url")+"/skv2/app_upload/"+fileName +Contants.FILE_SEPARATOR;
//
//	}
	
	public static String getFileAddress(String user_id,String file){
		return 	PropertyUtil.getProperty("web_image_url")+"app_upload/"+user_id+"/"+file;
	}

	public static String getUploadPath() {
		return bundle.getString("pic_upload_path");
	}

	/*
	 * 获取配置文件中服务器的URL
	 */
	public static String getServerUrl() {
		return bundle.getString("server_url").trim();
	}

	/**
	 * 订单编号 生成
	 * 
	 * @Title: getOrderCode
	 * @Description: TODO(这里用一句话描述这个方法的作�?
	 * @param @param prefix
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @date 2015�?�?8�?下午3:14:01
	 * @author SKIN
	 * @throws
	 */
	public static String getOrderCode(String prefix) {
		int fetchCode = (int) Math.round(Math.random() * (10000 - 0) + 5);
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String sequ = new DecimalFormat("0000").format(fetchCode++);
		return prefix + date + sequ;
	}

//	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(getOrderCode("T"));
//		}
//		
//	}
	

	/**
	 * 生成�?��编号 规则 年月�?+ 订单编号  + 2位随机数
	 * 20 15 06 19 GC 20 15 06 19 13 15 49 89 56 11
	 * @param type
	 * @param num
	 * @return
	 */
	public static String apliayOrderUnsubscribeNum(
			String orderNum) {
		StringBuffer apliayOrderUnsubscribeNum = new StringBuffer();
		if (StringUtils.isEmpty(orderNum)) {
			return null;
		}
		apliayOrderUnsubscribeNum.append(getCurrentDate());
		apliayOrderUnsubscribeNum.append(orderNum);
		int ran= (int) (Math.random()*100);
		apliayOrderUnsubscribeNum.append(String.valueOf(ran));
		return apliayOrderUnsubscribeNum.toString();
	}
	
	public static String getCurrentDate(){
		return DateUtil.formatShort(new Date()).replace("-", "");
	
	}
	
	public static boolean cheakKeyWord(String content,String val){
		String[] keys = val.split(",");
		for(String key : keys){
			if(content.indexOf(key) > 0){
				return true;
			}
		}
		return false;
	}
}
