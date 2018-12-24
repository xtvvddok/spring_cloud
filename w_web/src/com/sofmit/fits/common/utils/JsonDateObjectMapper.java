package com.sofmit.fits.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @ClassName: JsonDateObjectMapper
 * @Description: 用于Spring MVC的Json日期格式处理后台的Date类型在使用@ResponseBody返回到前台呈现时，自动转为yyyy-mm-dd hh:mm:ss格式字符串
 */
public class JsonDateObjectMapper extends ObjectMapper {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -1576324702054837966L;
	private String formatter = "yyyy-MM-dd HH:mm:ss";//默认格式

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public JsonDateObjectMapper() {
		disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);//取消默认TIMESTAMPS

		DateFormat df = new SimpleDateFormat(this.formatter);
		setDateFormat(df);
	}
}
