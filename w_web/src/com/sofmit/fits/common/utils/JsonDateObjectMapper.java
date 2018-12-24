package com.sofmit.fits.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @ClassName: JsonDateObjectMapper
 * @Description: ����Spring MVC��Json���ڸ�ʽ�����̨��Date������ʹ��@ResponseBody���ص�ǰ̨����ʱ���Զ�תΪyyyy-mm-dd hh:mm:ss��ʽ�ַ���
 */
public class JsonDateObjectMapper extends ObjectMapper {
	/**
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = -1576324702054837966L;
	private String formatter = "yyyy-MM-dd HH:mm:ss";//Ĭ�ϸ�ʽ

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public JsonDateObjectMapper() {
		disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);//ȡ��Ĭ��TIMESTAMPS

		DateFormat df = new SimpleDateFormat(this.formatter);
		setDateFormat(df);
	}
}
