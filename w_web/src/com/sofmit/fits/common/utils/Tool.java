package com.sofmit.fits.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.bcloud.msg.http.HttpSender;
import com.sofmit.fits.common.utils.file.PropertyUtil;

public class Tool {

	public static void writeText(String text, HttpServletResponse response) {
		if (text == null) {
			return;
		}

		response.setContentType("text/html;charset=UTF-8");
		Writer writer = null;
		try {
			writer = response.getWriter();
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static String createValidateCode() {

		return String.valueOf((int) (Math.random() * 1000000 + 100000));
	}
	public static void writeText(String text, HttpServletRequest request,
			HttpServletResponse response) {
		if (text == null) {
			return;
		}
		boolean blReplaceImg = false;// �Ƿ��滻IMG��ǩ��SRC·�������Է�����·��
		try {
			if (request.getRequestURI().toLowerCase().contains("/api/"))// API��������Ҫ�滻�����е�<IMG
																		// ��ǩ��SRC����
			{
				blReplaceImg = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (blReplaceImg) {
			String serverUrl = SystemUtils.getServerUrl();
			String imgPattern = "<\\s*img\\s+[^>]*src=\\\\\"(?<url>[^>\\\\\"]*)\\\\\"[^>]*>";
			Pattern pat = Pattern.compile(imgPattern, Pattern.CASE_INSENSITIVE);
			Matcher mts = pat.matcher(text);
			String strmatch = "";
			StringBuffer sb = new StringBuffer();
			boolean blAddedScript = false;// �Ƿ����ͼƬ����ӦJS�ű�
			while (mts.find()) {
				String img = mts.group();
				strmatch = mts.group("url").toLowerCase().replace(" ", "");
				String newUrl = mts.group("url");
				if (!strmatch.startsWith("http"))// ������HTTP��ͷ��������Ҫ�滻
				{
					if (newUrl.startsWith("/")) {
						newUrl = serverUrl + newUrl;
					} else {
						newUrl = serverUrl + "/" + newUrl;
					}
				}
				img = "<img srcnew=\\\\\"" + newUrl + "\\\\\" \\\\/>";
				if (!blAddedScript)// �������ӦJS�ű���HTML������
				{
					// ͼƬ����Ӧ�ű�
					String strScript = "<div id=\\\\\\\"inStylesheet_tag\\\\\\\" style=\\\\\\\"display:none\\\\\\\"><\\\\\\/div><div  style=\\\\\\\"display:none\\\\\\\"><script type=\\\\\\\"text\\\\\\/javascript\\\\\\\">var width1=document.body.clientWidth-6;var styleString=\\\\\\\"<style   type=\\\\\\\\\\\\\\\"text\\\\\\/css\\\\\\\\\\\\\\\" >img{max-width:\\\\\\\"+width1+\\\\\\\"px;}<\\\\\\/style>\\\\\\\";document.getElementById(\\\\\\\"inStylesheet_tag\\\\\\\").innerHTML=styleString;"
							+ "window.onload=function(){setTimeout(changepic,500);};function changepic(){var imgs=document.getElementsByTagName(\\\\\"img\\\\\");for(var i=0;i<imgs.length;i++){imgs[i].src=imgs[i].getAttribute(\\\\\"srcnew\\\\\");}};<\\\\\\/script><\\\\\\/div>";
					//String imgScript
					img = strScript+img;
					blAddedScript = true;
				}
				mts.appendReplacement(sb, img);
			}
			mts.appendTail(sb);
			text = sb.toString();
		}
		response.setContentType("text/html;charset=UTF-8");
		Writer writer = null;
		try {
			writer = response.getWriter();
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getRealPath(HttpServletRequest rq, String path) {
		return rq.getSession().getServletContext().getRealPath(path);
	}

	public static boolean isContainWhere(String hql) {
		return hql.contains("where");
	}


/*	public static void setResultVo(List<?> listByPage, long count, ResultVo rvo) {
		rvo.setDATA(listByPage);
		rvo.setMAXITEMCOUNT(count);
	}*/

	/**
	 * 
	* @Title: validatePhoneCode 
	* @Description: TODO �����ֻ���֤�뷽��
	* @param @param phoneNum
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @date 2015��4��13�� ����11:00:59
	* @author SKIN
	* @throws
	 */
	public static String validatePhoneCode(String phoneNum) {
		return "123456";
	}

	/**
	 * ������Ϊ�ͻ��˴��������ַ�������
	 * date:2015��5��9��
	 * @param str_
	 * @return
	 * user:Administrator
	 */
	public static String enCode(String str_) {
		if (StringUtils.isNotEmpty(str_)) {
			try {
				str_ = URLDecoder.decode(str_, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str_;
	}
	
	
	
	
	public static void main(String[] args) {
		// ��֤�ֻ������Ƿ�Ϸ�
//		String userPhone = "2111111111";
//		String regex = "^[1][0-9]{10}$";
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(userPhone);
//		if (!matcher.matches()) {
//			System.out.println("�ֻ����벻�Ϸ���������Ϸ����ֻ��š�");
//		} else {
//			System.out.println("�ֻ�����Ϸ�");
//		}
		for (int i = 0; i < 100; i++) {
			System.out.println(getMsvCode());
		}
	}
	 public static String getMsvCode(){  
//	        Random rad=new Random();  
//	        return rad.nextInt(100000000)+"";  
		 
		 StringBuilder str=new StringBuilder();//����䳤�ַ���
		 Random random=new Random();
		 //����������֣�����ӵ��ַ���
		 for(int i=0;i<8;i++){
		 	str.append(random.nextInt(10));
		 }
		 //���ַ���ת��Ϊ���ֲ����
//		 int num=Integer.parseInt(str.toString());
		 return str.toString();
		 
	   }  

}
