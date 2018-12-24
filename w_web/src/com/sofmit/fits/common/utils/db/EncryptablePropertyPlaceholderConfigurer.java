package com.sofmit.fits.common.utils.db;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.sofmit.utils.aes.EncodeUtil;

public class EncryptablePropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	//private static final String key = "0002000200020002";

	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		try {
			// DES des = new DES();
			String username = props.getProperty("jdbc.username");
			if (username != null) {
//				props.setProperty("jdbc.username",EncodeUtil.aesDecrypt(username));
				props.setProperty("jdbc.username",username);
			}

			String password = props.getProperty("jdbc.password");
			if (password != null) {
//				props.setProperty("jdbc.password", EncodeUtil.aesDecrypt(password));
				props.setProperty("jdbc.password",password);
			}

			String url = props.getProperty("jdbc.url");
			if (url != null) {
//				props.setProperty("jdbc.url", EncodeUtil.aesDecrypt(url));
				props.setProperty("jdbc.password", password);
			}

			String driverClassName = props.getProperty("jdbc.driverClassName");
			if (driverClassName != null) {
//				props.setProperty("jdbc.driverClassName", EncodeUtil.aesDecrypt(driverClassName));
				props.setProperty("jdbc.driverClassName", driverClassName);
			}

			super.processProperties(beanFactory, props);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BeanInitializationException(e.getMessage());
		}
	}
}