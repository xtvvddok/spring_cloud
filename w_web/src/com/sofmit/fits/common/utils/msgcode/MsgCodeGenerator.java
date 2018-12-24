package com.sofmit.fits.common.utils.msgcode;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.sofmit.fits.common.utils.Tool;


/**
 * ������֤�������
 * projectName:cdsk
 * packageName:com.sofmit.jjsk.common
 * fileName:MsgCodeGenerator.java
 * ����������
 * @author hlc
 * date:2015��4��25��
 */
public class MsgCodeGenerator {

	// �洢������֤������
	private static Map<String, MsgCode> codeTempMerray = new ConcurrentHashMap<String, MsgCode>();
	public static final long CORRECT_CHECKTIME = 30000;

	// �����µ�6λ��֤��
	public static String createNewCode(String phone) {

//		StringBuilder code = new StringBuilder();
//		// ������֤��������ķ�����
//		cleanData();
//		// code = code.append(buildRandom(6));
//		code = code.append("12345");
//		MsgCode msgCode = new MsgCode();
//		msgCode.setCode(code.toString());
//		msgCode.setCreateTime(System.currentTimeMillis());
//		codeTempMerray.put(phone, msgCode);
//		return code.toString();
		StringBuilder code = new StringBuilder();
		// ������֤��������ķ�����
		cleanData();
		// code = code.append(buildRandom(6));
		//���� 6λ������������
		code = code.append(Tool.createValidateCode());
		MsgCode msgCode = new MsgCode();
		msgCode.setCode(code.toString());
		msgCode.setCreateTime(System.currentTimeMillis());
		codeTempMerray.put(phone, msgCode);
		return code.toString();
	}

	// ������֤��������ķ�����
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
	 * ������ͨ���ֻ��Ż�ȡ��֤��
	 * date:2015��4��25��
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
	 * ������ͨ���ֻ��Ŵ��������Ƴ���Ӧ����֤��
	 * date:2015��4��25��
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
