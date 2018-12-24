package com.sofmit.fits.common.utils;

import java.io.Reader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @ClassName: ObjectMapperUtil
 * @Description: TODO (������һ�仰��������������)
 * @author: HEXY
 */
public class ObjectMapperUtil {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	static {
		MAPPER.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static ObjectMapper getObjectMapper() {
		return MAPPER;
	}

	public static <T> T readValue(HttpServletRequest httpRequest, Class<T> c) {
		Enumeration<String> names = httpRequest.getParameterNames();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			while (names.hasMoreElements()) {
				String param = (String) names.nextElement();
				String value = httpRequest.getParameter(param);
				if (value != "" && value != null)
					map.put(param, value);
				// System.out.println(param+"---"+value);
			}
			return MAPPER.readValue(MAPPER.writeValueAsBytes(map), c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T readValue(Map<String, Object> map, Class<T> c) {
		try {
			return MAPPER.readValue(MAPPER.writeValueAsBytes(map), c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T readValue(String json, Class<T> c) {
		try {
			return MAPPER.readValue(json, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T readValue(byte[] byteArray, Class<T> c) {
		try {
			return MAPPER.readValue(byteArray, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T readValue(Reader r, Class<T> c) {
		try {
			return MAPPER.readValue(r, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> readList(String r, Class<T> c) {
		try {
			return MAPPER.readValue(r, MAPPER.getTypeFactory()
					.constructParametricType(List.class, c));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
