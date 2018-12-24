package com.sofmit.fits.common.utils.file;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

import com.sofmit.fits.common.utils.Texting;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * 
 * @ClassName: PropertyUtil
 * @Description: 属�?读取文件
 * @author SKIN
 * @date 2015�?�?3�?下午4:33:51
 *
 */
public class PropertyUtil {

	private static Properties properties = new Properties();
	private static Properties ddsCode = new Properties();
	private static Properties methodCode = new Properties();
	static {
		try {
			properties.load(PropertyUtil.class.getResourceAsStream("/sysconfig.properties"));
//			ddsCode.load(PropertyUtil.class.getResourceAsStream("/ddscode.properties"));
			methodCode.load(PropertyUtil.class.getResourceAsStream("/methodval.properties"));
//			ddsCode.load(new InputStreamReader(PropertyUtil.class.getClassLoader().getResourceAsStream("ddscode.properties"), "UTF-8"));
//			methodCode.load(new InputStreamReader(PropertyUtil.class.getClassLoader().getResourceAsStream("methodval.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getMethodVal(String key) {
		return methodCode.getProperty(key);
	}
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
//	public static String getDdsCodeMsg(String key) {
//		return ddsCode.getProperty(key);
//	}

	public static String getMessage(Texting texting){
		String msg = ddsCode.getProperty(texting.getKey());
		System.out.println("获取到的短信模版为："+msg);
		if(msg == null || "".equals(msg)){
			return null;
		}
		System.out.println("sname:"+texting.getSname()+";proname:"+texting.getProname()+";usetime:"+texting.getUsetime()+";money:"+texting.getMoney()+";call："+texting.getCall()+";msv:"+texting.getMsv());
		if(texting.getUsetime() == null){
			msg = msg.replace("MSG",texting.getSname()+"-"+ texting.getProname());
		} else {
			msg = msg.replace("MSG",texting.getSname()+"-"+ texting.getProname()+"  "+texting.getUsetime());
		}
		
		if(texting.getMoney() != null && !"".equals(texting.getMoney())){
			msg = msg.replace("MONEY", texting.getMoney());
		}
		if(texting.getMsv() != null && !"".equals(texting.getMsv())){
			msg = msg.replace("MSV", texting.getMsv());
		}
		if(texting.getUseNumber() != null && !"".equals(texting.getUseNumber())){
			msg = msg.replace("NUM", texting.getUseNumber());
		}
		if(texting.getCall() != null && !"".equals(texting.getCall())){
			msg = msg.replace("CALL", texting.getCall());
		}
		System.out.println("短信内容为："+msg);
		return msg;
	}
	
}