package com.sofmit.fits.common.utils.msgcode;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.sofmit.fits.common.utils.Tool;


/**
 * 短信验证码产生器
 * projectName:cdsk
 * packageName:com.sofmit.jjsk.common
 * fileName:MsgCodeGenerator.java
 * 功能描述：
 * @author hlc
 * date:2015年4月25日
 */
public class MsgCodeGenerator {

	// 存储短信验证码容器
	private static Map<String, MsgCode> codeTempMerray = new ConcurrentHashMap<String, MsgCode>();
	public static final long CORRECT_CHECKTIME = 30000;

	// 产生新的6位验证码
	public static String createNewCode(String phone) {

//		StringBuilder code = new StringBuilder();
//		// 清理验证码容器里的废数据
//		cleanData();
//		// code = code.append(buildRandom(6));
//		code = code.append("12345");
//		MsgCode msgCode = new MsgCode();
//		msgCode.setCode(code.toString());
//		msgCode.setCreateTime(System.currentTimeMillis());
//		codeTempMerray.put(phone, msgCode);
//		return code.toString();
		StringBuilder code = new StringBuilder();
		// 清理验证码容器里的废数据
		cleanData();
		// code = code.append(buildRandom(6));
		//生成 6位数的数字密码
		code = code.append(Tool.createValidateCode());
		MsgCode msgCode = new MsgCode();
		msgCode.setCode(code.toString());
		msgCode.setCreateTime(System.currentTimeMillis());
		codeTempMerray.put(phone, msgCode);
		return code.toString();
	}

	// 清理验证码容器里的废数据
	private static void cleanData() {
		Set<String> sets = codeTempMerray.keySet();
		for (String key : sets) {
			MsgCode msgCode = codeTempMerray.get(key);
			long createTime = msgCode.getCreateTime();
			long nowTime = System.currentTimeMillis();
			long factTimeSub = nowTime - createTime;
			if (factTimeSub > CORRECT_CHECKTIME) {
				codeTempMerray.remove(key);
			}
		}
		print();

	}
	

	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	public static void print() {
		Set<String> sets = codeTempMerray.keySet();
		for (String key : sets) {
			MsgCode msgCode = codeTempMerray.get(key);
			String code = msgCode.getCode();
			System.out.println("phone:" + key + "code:" + code);
		}
	}

	/**
	 * 概述：通过手机号获取验证码
	 * date:2015年4月25日
	 * @param phone
	 * @return
	 * user:Administrator
	 */
	public static MsgCode getMsgCodeByPhone(String phone) {
		if (StringUtils.isEmpty(phone)) {
			return null;
		}
		return codeTempMerray.get(phone);
	}

	/**
	 * 概述：通过手机号从容器中移除相应的验证码
	 * date:2015年4月25日
	 * @return
	 * user:Administrator
	 */
	public static boolean removeCode(String phone) {
		if (StringUtils.isEmpty(phone)) {
			return false;
		}
		codeTempMerray.remove(phone);
		return true;
	}

}
