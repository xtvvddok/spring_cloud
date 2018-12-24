package com.sofmit.fits.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageCompressUtil { 
	/*	*//**
	 * 
	 * 直接指定压缩后的宽高�?
	 * 
	 * (先保存原文件，再压缩、上�?)
	 * 
	 * 壹拍项目中用于二维码压缩
	 * 
	 * @param oldFile
	 *            要进行压缩的文件全路�?
	 * 
	 * @param width
	 *            压缩后的宽度
	 * 
	 * @param height
	 *            压缩后的高度
	 * 
	 * @param quality
	 *            压缩质量
	 * 
	 * @param smallIcon
	 *            文件名的小小后缀(注意，非文件后缀名称),入压缩文件名是yasuo.jpg,则压缩后文件名是yasuo(+smallIcon
	 *            ).jpg
	 * 
	 * @return 返回压缩后的文件的全路径
	 */
	/*
	 * 
	 * public static String zipImageFile(String oldFile, int width, int height,
	 * 
	 * float quality, String smallIcon) {
	 * 
	 * if (oldFile == null) { return null;
	 * 
	 * }
	 * 
	 * String newImage = null;
	 * 
	 * try {
	 *//** 对服务器上的临时文件进行处理 */
	/*
	 * 
	 * Image srcFile = ImageIO.read(new File(oldFile));
	 *//** �?,高设�? */
	/*
	 * 
	 * BufferedImage tag = new BufferedImage(width, height,
	 * BufferedImage.TYPE_INT_RGB);
	 * 
	 * tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
	 * 
	 * String filePrex = oldFile.substring(0, oldFile.indexOf('.'));
	 *//** 压缩后的文件�? */
	/*
	 * 
	 * newImage = filePrex + smallIcon + oldFile.substring(filePrex.length());
	 *//** 压缩之后临时存放位置 */
	/*
	 * 
	 * FileOutputStream out = new FileOutputStream(newImage);
	 * 
	 * JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	 * 
	 * JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
	 *//** 压缩质量 */
	/*
	 * 
	 * jep.setQuality(quality, true);
	 * 
	 * encoder.encode(tag, jep);
	 * 
	 * out.close();
	 * 
	 * } catch (FileNotFoundException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * return newImage;
	 * 
	 * }
	 *//**
	 * 
	 * 保存文件到服务器临时路径(用于文件上传)
	 * 
	 * @param fileName
	 * 
	 * @param is
	 * 
	 * @return 文件全路�?
	 */
	/*
	 * 
	 * public static String writeFile(String fileName, InputStream is) {
	 * 
	 * if (fileName == null || fileName.trim().length() == 0) {
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * try {
	 *//** 首先保存到临时文�? */
	/*
	 * 
	 * FileOutputStream fos = new FileOutputStream(fileName);
	 * 
	 * byte[] readBytes = new byte[512];// 缓冲大小
	 * 
	 * int readed = 0;
	 * 
	 * while ((readed = is.read(readBytes)) > 0) {
	 * 
	 * fos.write(readBytes, 0, readed);
	 * 
	 * }
	 * 
	 * fos.close();
	 * 
	 * is.close();
	 * 
	 * } catch (FileNotFoundException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * return fileName;
	 * 
	 * }
	 *//**
	 * 
	 * 等比例压缩算法：
	 * 
	 * 算法思想：根据压缩基数和压缩比来压缩原图，生产一张图片效果最接近原图的缩略图
	 * 
	 * @param srcURL
	 *            原图地址
	 * 
	 * @param deskURL
	 *            缩略图地�?
	 * 
	 * @param comBase
	 *            压缩基数
	 * 
	 * @param scale
	 *            压缩限制(�?/�?)比例 �?般用1�?
	 * 
	 *            当scale>=1,缩略图height=comBase,width按原图宽高比�?;若scale<1,缩略图width=
	 *            comBase,height按原图宽高比�?
	 * 
	 * @throws Exception
	 * 
	 * @author shenbin
	 * 
	 * @createTime 2014-12-16
	 * 
	 * @lastModifyTime 2014-12-16
	 */
	/*
	 * 
	 * public static void saveMinPhoto(String srcURL, String deskURL, double
	 * comBase,
	 * 
	 * double scale) throws Exception {
	 * 
	 * File srcFile = new java.io.File(srcURL);
	 * 
	 * Image src = ImageIO.read(srcFile);
	 * 
	 * int srcHeight = src.getHeight(null);
	 * 
	 * int srcWidth = src.getWidth(null);
	 * 
	 * int deskHeight = 0;// 缩略图高
	 * 
	 * int deskWidth = 0;// 缩略图宽
	 * 
	 * double srcScale = (double) srcHeight / srcWidth;
	 *//** 缩略图宽高算�? */
	/*
	 * 
	 * if ((double) srcHeight > comBase || (double) srcWidth > comBase) {
	 * 
	 * if (srcScale >= scale || 1 / srcScale > scale) {
	 * 
	 * if (srcScale >= scale) {
	 * 
	 * deskHeight = (int) comBase;
	 * 
	 * deskWidth = srcWidth * deskHeight / srcHeight;
	 * 
	 * } else {
	 * 
	 * deskWidth = (int) comBase;
	 * 
	 * deskHeight = srcHeight * deskWidth / srcWidth;
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * if ((double) srcHeight > comBase) {
	 * 
	 * deskHeight = (int) comBase;
	 * 
	 * deskWidth = srcWidth * deskHeight / srcHeight;
	 * 
	 * } else {
	 * 
	 * deskWidth = (int) comBase;
	 * 
	 * deskHeight = srcHeight * deskWidth / srcWidth;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * deskHeight = srcHeight;
	 * 
	 * deskWidth = srcWidth;
	 * 
	 * }
	 * 
	 * BufferedImage tag = new BufferedImage(deskWidth, deskHeight,
	 * BufferedImage.TYPE_3BYTE_BGR);
	 * 
	 * tag.getGraphics().drawImage(src, 0, 0, deskWidth, deskHeight, null); //
	 * 绘制缩小后的�?
	 * 
	 * FileOutputStream deskImage = new FileOutputStream(deskURL); // 输出到文件流
	 * 
	 * JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(deskImage);
	 * 
	 * encoder.encode(tag); // 近JPEG编码
	 * 
	 * deskImage.close();
	 * 
	 * }
	 */

	/**
	 * 图片缩放
	 * 
	 * @param filePath
	 *            图片路径
	 * @param height
	 *            高度
	 * @param width
	 *            宽度
	 * @param bb
	 *            比例不对时是否需要补�?
	 */
	/**
	 * 
	 * @Title: resize
	 * @Description: 图片缩放
	 * @param @param is 原图片的输入�?
	 * @param @param height
	 * @param @param width
	 * @param @param bb 比例不对时是否需要补�?
	 * @param @return 设定文件
	 * @return byte[] 返回 处理过后的字节流
	 * @date 2015�?10�?8�? 下午4:44:18
	 * @author SKIN
	 * @throws
	 */
	public static byte[] resize(InputStream is, int height, int width,
			boolean bb) {
		try {
			double ratio = 0; // 缩放比例
			// File f = new File(filePath);
			BufferedImage bi = ImageIO.read(is);
			Image itemp = bi.getScaledInstance(width, height,
					BufferedImage.SCALE_SMOOTH);
			// 计算比例
//			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
//				if (bi.getHeight() > bi.getWidth()) {
//					ratio = (new Integer(height)).doubleValue()
//							/ bi.getHeight();
//				} else {
//					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
//				}
//				AffineTransformOp op = new AffineTransformOp(
//						AffineTransform.getScaleInstance(ratio, ratio), null);
//				itemp = op.filter(bi, null);
//			}
			if(bi.getWidth() > width){
				ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}
			if (null != itemp) {
				is.close();
				return getBufferedImageBytes(toBufferedImage(itemp));
			}
			// itemp.get
			// ImageIO.write((BufferedImage) itemp, "jpg", f);
			return null;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过图片获取字节�?
	 * 
	 * @Title: getBufferedImageBytes
	 * @Description: TODO(这里用一句话描述这个方法的作�?)
	 * @param @param bfi
	 * @param @return 设定文件
	 * @return byte[] 返回类型
	 * @date 2015�?10�?8�? 下午4:26:17
	 * @author SKIN
	 * @throws
	 */
	public static byte[] getBufferedImageBytes(BufferedImage bfi) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 字节输出�?

		try {
			ImageIO.write(bfi, "bmp", bos);
		} catch (IOException e) {
			return null;
		} // 将虚拟图片信息写入到字节输出流中
		return bos.toByteArray();
	}
	public static BufferedImage toBufferedImage(Image image) { 
		if (image instanceof BufferedImage) { 
		return (BufferedImage) image; 
		} 

		image = new ImageIcon(image).getImage(); 

		BufferedImage bimage = null; 
		GraphicsEnvironment ge = GraphicsEnvironment 
		.getLocalGraphicsEnvironment(); 
		try { 

		int transparency = Transparency.OPAQUE; 

		GraphicsDevice gs = ge.getDefaultScreenDevice(); 
		GraphicsConfiguration gc = gs.getDefaultConfiguration(); 
		bimage = gc.createCompatibleImage(image.getWidth(null), 
		image.getHeight(null), transparency); 
		} catch (HeadlessException e) { 

		} 
		if (bimage == null) { 
		// Create a buffered image using the default color model 
		int type = BufferedImage.TYPE_INT_RGB; 

		bimage = new BufferedImage(image.getWidth(null), 
		image.getHeight(null), type); 
		} 
		// Copy image to buffered image 
		Graphics g = bimage.createGraphics(); 
		// Paint the image onto the buffered image 
		g.drawImage(image, 0, 0, null); 
		g.dispose(); 
		return bimage; 
	}
}