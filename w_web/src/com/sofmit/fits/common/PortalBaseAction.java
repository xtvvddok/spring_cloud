package com.sofmit.fits.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Session;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class PortalBaseAction {

	public static String SUCCESS = "1";
	public static String ERROR = "0";
	
	protected void writeText(String text, HttpServletResponse response) {
		createHeader(response);
		Writer writer = null;
		try {
			writer = response.getWriter();
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	protected void writerJson(Map jsonMap, HttpServletResponse response) {
		createHeader(response);
		ajax(getJsonFromObject(jsonMap), "text/html", response);
	}

	/***
	 * ���سɹ���Ϣ���������ͷ��ض���
	 * 
	 * @param msg
	 * @param result
	 * @param response
	 */
	protected void SuccessInfo(String msg, JSONObject result, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 1);
		jsonMap.put("msg", msg);
		jsonMap.put("result", result);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	protected void SuccessInfo(String msg, JSONArray result, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 1);
		jsonMap.put("msg", msg);
		jsonMap.put("result", result);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}
	
	protected void Warning(String msg, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 2);
		jsonMap.put("msg", msg);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}
	

	/***
	 * ���سɹ���Ϣ��������
	 * 
	 * @param msg
	 * @param response
	 */
	protected void SuccessMsg(String msg, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 1);
		jsonMap.put("msg", msg);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	/***
	 * ���سɹ���Ϣ�������ض���
	 * 
	 * @param msg
	 * @param result
	 * @param response
	 */
	protected void SuccessInfo(JSONObject result, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 1);
		jsonMap.put("result", result);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	protected void SuccessInfo(JSONArray result, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 1);
		jsonMap.put("result", result);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	/***
	 * ���سɹ���Ϣ
	 * 
	 * @param msg
	 * @param result
	 * @param response
	 */
	protected void Success(HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 1);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	/***
	 * ����ʧ����Ϣ�����������������ͷ��ض���
	 * 
	 * @param msg
	 * @param errorCode
	 * @param result
	 * @param response
	 */
	protected void Error(String msg, String errorCode, JSONObject result, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 0);
		jsonMap.put("msg", msg);
		jsonMap.put("errorCode", errorCode);
		jsonMap.put("result", result);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	/***
	 * ����ʧ����Ϣ�����������������
	 * 
	 * @param msg
	 * @param errorCode
	 * @param result
	 */
	protected void Error(String msg, String errorCode, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 0);
		jsonMap.put("msg", msg);
		jsonMap.put("errorCode", errorCode);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	/***
	 * ����ʧ����Ϣ��������
	 * 
	 * @param msg
	 * @param errorCode
	 * @param result
	 */
	protected void Error(String msg, HttpServletResponse rp) {
		Map jsonMap = new HashMap();
		jsonMap.put("status", 0);
		jsonMap.put("msg", msg);
		ajax(getJsonFromObject(jsonMap), "text/html", rp);
	}

	public static final String CUSTOMER_LOGIN_SESSION = "customer_login_session";

	private void createHeader(HttpServletResponse response) {
		response.addHeader("pragma", "no-cache");
		response.addHeader("cache-control", "no-cache,must-revalidate");
		response.addHeader("expires", "0");
		response.setHeader("Access-Control-Allow-Origin", "*");
		// response.setContentType(type + ";charset=UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setDateHeader("Expires", 0L);
	}

	// protected void ErrorMsg(String msg, HttpServletResponse response) {
	//// createHeader(response);
	// Map jsonMap = new HashMap();
	// jsonMap.put("success", Boolean.valueOf(false));
	// jsonMap.put("msg", msg);
	// ajax(getJsonFromObject(jsonMap), "text/html", response);
	// }
	//
	// protected void SuccessMsg(String msg, HttpServletResponse response) {
	// // createHeader(response);
	// Map jsonMap = new HashMap();
	// jsonMap.put("success", Boolean.valueOf(true));
	// jsonMap.put("msg", msg);
	// ajax(getJsonFromObject(jsonMap), "text/html", response);
	// }
	// /***
	// * 回包含订单创建结果，支付信息，支付链接信息等
	// * @param msg
	// * @param map
	// * @param url
	// * @param response
	// */
	// protected void SuccessMsg(String msg,Map map, Map
	// alipay,HttpServletResponse response) {
	// Map jsonMap = new HashMap();
	// jsonMap.put("success", Boolean.valueOf(true));
	// jsonMap.put("info", map);
	// jsonMap.put("msg", msg);
	// jsonMap.put("alipay", alipay);
	// ajax(getJsonFromObject(jsonMap), "text/html", response);
	// }
	// /**
	// * 返回包含订单创建结果，支付信息等信息
	// * @param msg
	// * @param map
	// * @param response
	// */
	// protected void SuccessMsg(String msg,Map alipay, HttpServletResponse
	// response) {
	// Map jsonMap = new HashMap();
	// jsonMap.put("success", Boolean.valueOf(true));
	// jsonMap.put("alipay", alipay);
	// jsonMap.put("msg", msg);
	// ajax(getJsonFromObject(jsonMap), "text/html", response);
	// }
	// protected void SuccessMsg(Map prams,String msg, HttpServletResponse
	// response) {
	// Map jsonMap = new HashMap();
	// jsonMap.put("success", Boolean.valueOf(true));
	// jsonMap.put("prams", prams);
	// jsonMap.put("msg", msg);
	// ajax(getJsonFromObject(jsonMap), "text/html", response);
	// }
	// protected void SuccessMsg(String msg,String code, HttpServletResponse
	// response) {
	// Map jsonMap = new HashMap();
	// jsonMap.put("success", Boolean.valueOf(true));
	// jsonMap.put("code", code);
	// jsonMap.put("msg", msg);
	// ajax(getJsonFromObject(jsonMap), "text/html", response);
	// }

	protected static final String getJsonFromObject(Object o) {
		String result = "";
		JSONObject ja = JSONObject.fromObject(o);
		result = result + ja.toString();
		System.out.println(result);
		return result;
	}

	protected void ajax(String content, String type, HttpServletResponse response) {
		try {
			response.addHeader("pragma", "no-cache");
			response.addHeader("cache-control", "no-cache,must-revalidate");
			response.addHeader("expires", "0");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType(type + ";charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setDateHeader("Expires", 0L);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String doPost(Map data, String path) throws Exception {
		try {
			HttpClient httpclient = null;
			PostMethod httpPost = null;
			httpclient = new HttpClient();
			httpclient.getParams().setConnectionManagerTimeout(20000);
			httpclient.getParams().setSoTimeout(20000);
			httpPost = new PostMethod(path);
			httpPost.addRequestHeader("Content-Type", "application/json; charset=UTF-8");
			httpPost.addRequestHeader("DataType", "text");
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			 Iterator entries = data.entrySet().iterator();
			 while (entries.hasNext()) {
			 Map.Entry entry = (Map.Entry) entries.next();
			 String key = entry.getKey().toString();
			 Object value = entry.getValue();
			 list.add(new NameValuePair(key, value.toString()));
			 }
			NameValuePair[] param = list.toArray(new NameValuePair[] {});
			// httpPost.setRequestBody(param);
			// httpPost.setRequestBody(body);
			int statusCode = httpclient.executeMethod(httpPost);
			System.out.println(statusCode);
			String temp = httpPost.getResponseBodyAsString();
			System.out.println(temp);
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��ָ��URL����GET����������
	 * 
	 * @param url
	 *            ���������URL
	 * @param param
	 *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
	 * @return URL ������Զ����Դ����Ӧ���
	 */
	protected static String sendGet(String url, Map<String, String> paramsmap) {
		String result = "";
		BufferedReader in = null;
		try {
			String param = createString(paramsmap);
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// �򿪺�URL֮�������
			URLConnection connection = realUrl.openConnection();
			// ����ͨ�õ���������
			// connection.setRequestProperty("accept", "*/*");
			// connection.setRequestProperty("connection", "Keep-Alive");
			// connection.setRequestProperty("user-agent", "Mozilla/4.0
			// (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.setRequestProperty("DataType", "text");
			// ����ʵ�ʵ�����
			connection.connect();
			// ��ȡ������Ӧͷ�ֶ�
			Map<String, List<String>> map = connection.getHeaderFields();
			// �������е���Ӧͷ�ֶ�
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// ���� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر�������
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setRequestProperty("DataType", "text");
			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);
//			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
			// ��ȡURLConnection�����Ӧ�������
			out = new PrintWriter( new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
			
			// �����������
			out.print(param);
			// flush������Ļ���
			out.flush();
			// ����BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر��������������
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * ����������Ԫ�����򣬲����ա�����=����ֵ����ģʽ�á�&���ַ�ƴ�ӳ��ַ���
	 * 
	 * @param params
	 *            ��Ҫ���򲢲����ַ�ƴ�ӵĲ�����
	 * @return ƴ�Ӻ��ַ���
	 */
	protected static String createString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key).toString();

			if (i == keys.size() - 1) {// ƴ��ʱ�����������һ��&�ַ�
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}
	public static void main(String[] args) {
		System.out.println(11);
	}

}
