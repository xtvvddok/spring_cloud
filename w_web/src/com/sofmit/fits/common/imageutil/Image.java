package com.sofmit.fits.common.imageutil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder; 

public class Image {

	public static byte[] getImage(InputStream fromFile) {
		return ImageUtil.resize(fromFile, 300, 190);
	}
	
	public static String getBase64(byte[] base64) {
		return encoder.encodeBuffer(base64).trim();
	}
	
	public static byte[] getImage(String base64) {
		InputStream fromFile = base64StringToImage(base64);
		return ImageUtil.resize(fromFile, 300, 190);
	}

	private static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	private static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	private static InputStream base64StringToImage(String base64String) {
		try {
			byte[] bytes1 = decoder.decodeBuffer(base64String);
			InputStream sbs = new ByteArrayInputStream(bytes1); 
			return sbs;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
