package com.sofmit.fits.common.imageutil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;



public class ImageUtil {
    private static int width;
    private static int height;
    private static int scaleWidth;
    static double support = (double) 3.0;
    static double PI = (double) 3.14159265358978;
    static double[] contrib;
    static double[] normContrib;
    static double[] tmpContrib;
    static int startContrib, stopContrib;
    static int nDots;
    static int nHalfDots;
    public static byte[] resize(InputStream fromFile, int formatWideth, int formatHeight){
    	  try {
			BufferedImage srcImage =  ImageIO.read(fromFile);
			   int imageWideth = srcImage.getWidth(null);
		        int imageHeight = srcImage.getHeight(null);
		        int changeToWideth = 0;
		        int changeToHeight = 0;
		        if (imageWideth > 0 && imageHeight > 0) {
		            // flag=true;
		            if (imageWideth / imageHeight >= formatWideth / formatHeight) {
		                if (imageWideth > formatWideth) {
		                    changeToWideth = formatWideth;
		                    changeToHeight = (imageHeight * formatWideth) / imageWideth;
		                } else {
		                    changeToWideth = imageWideth;
		                    changeToHeight = imageHeight;
		                }
		            } else {
		                if (imageHeight > formatHeight) {
		                    changeToHeight = formatHeight;
		                    changeToWideth = (imageWideth * formatHeight) / imageHeight;
		                } else {
		                    changeToWideth = imageWideth;
		                    changeToHeight = imageHeight;
		                }
		            }
		        }
		        srcImage = imageZoomOut(srcImage, changeToWideth, changeToHeight);
		        return getBufferedImageBytes(srcImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    // fromFileStr原图片地址,saveToFileStr生成缩略图地址,formatWideth生成图片宽度,formatHeight高度
    public void saveImageAsJpg(String fromFileStr, String saveToFileStr,
            int formatWideth, int formatHeight) throws Exception {
        BufferedImage srcImage;
        File saveFile = new File(saveToFileStr);
        File fromFile = new File(fromFileStr);
        srcImage = javax.imageio.ImageIO.read(fromFile); // construct image
        int imageWideth = srcImage.getWidth(null);
        int imageHeight = srcImage.getHeight(null);
        int changeToWideth = 0;
        int changeToHeight = 0;
        if (imageWideth > 0 && imageHeight > 0) {
            // flag=true;
            if (imageWideth / imageHeight >= formatWideth / formatHeight) {
                if (imageWideth > formatWideth) {
                    changeToWideth = formatWideth;
                    changeToHeight = (imageHeight * formatWideth) / imageWideth;
                } else {
                    changeToWideth = imageWideth;
                    changeToHeight = imageHeight;
                }
            } else {
                if (imageHeight > formatHeight) {
                    changeToHeight = formatHeight;
                    changeToWideth = (imageWideth * formatHeight) / imageHeight;
                } else {
                    changeToWideth = imageWideth;
                    changeToHeight = imageHeight;
                }
            }
        }

        srcImage = imageZoomOut(srcImage, changeToWideth, changeToHeight);
        ImageIO.write(srcImage, "JPEG", saveFile);
    }

    public static BufferedImage imageZoomOut(BufferedImage srcBufferImage, int w, int h) {
        width = srcBufferImage.getWidth();
        height = srcBufferImage.getHeight();
        scaleWidth = w;
        if (DetermineResultSize(w, h) == 1) {
            return srcBufferImage;
        }
        CalContrib();
        BufferedImage pbOut = HorizontalFiltering(srcBufferImage, w);
        BufferedImage pbFinalOut = VerticalFiltering(pbOut, h);
        return pbFinalOut;
    }

  
    private static int DetermineResultSize(int w, int h) {
        double scaleH, scaleV;
        scaleH = (double) w / (double) width;
        scaleV = (double) h / (double) height;
        // 需要判断一下scaleH，scaleV，不做放大操作
        if (scaleH >= 1.0 && scaleV >= 1.0) {
            return 1;
        }
        return 0;

    } // end of DetermineResultSize()

    private static double Lanczos(int i, int inWidth, int outWidth, double Support) {
        double x;

        x = (double) i * (double) outWidth / (double) inWidth;

        return Math.sin(x * PI) / (x * PI) * Math.sin(x * PI / Support)
                / (x * PI / Support);

    }

    private static void  CalContrib() {
        nHalfDots = (int) ((double) width * support / (double) scaleWidth);
        nDots = nHalfDots * 2 + 1;
        try {
            contrib = new double[nDots];
            normContrib = new double[nDots];
            tmpContrib = new double[nDots];
        } catch (Exception e) {
            System.out.println("init   contrib,normContrib,tmpContrib" + e);
        }

        int center = nHalfDots;
        contrib[center] = 1.0;

        double weight = 0.0;
        int i = 0;
        for (i = 1; i <= center; i++) {
            contrib[center + i] = Lanczos(i, width, scaleWidth, support);
            weight += contrib[center + i];
        }

        for (i = center - 1; i >= 0; i--) {
            contrib[i] = contrib[center * 2 - i];
        }

        weight = weight * 2 + 1.0;

        for (i = 0; i <= center; i++) {
            normContrib[i] = contrib[i] / weight;
        }

        for (i = center + 1; i < nDots; i++) {
            normContrib[i] = normContrib[center * 2 - i];
        }
    } // end of CalContrib()

    // 处理边缘
    private static void CalTempContrib(int start, int stop) {
        double weight = 0;

        int i = 0;
        for (i = start; i <= stop; i++) {
            weight += contrib[i];
        }

        for (i = start; i <= stop; i++) {
            tmpContrib[i] = contrib[i] / weight;
        }

    } // end of CalTempContrib()

    private static int GetRedValue(int rgbValue) {
        int temp = rgbValue & 0x00ff0000;
        return temp >> 16;
    }

    private static int GetGreenValue(int rgbValue) {
        int temp = rgbValue & 0x0000ff00;
        return temp >> 8;
    }

    private static int GetBlueValue(int rgbValue) {
        return rgbValue & 0x000000ff;
    }

    private static int ComRGB(int redValue, int greenValue, int blueValue) {

        return (redValue << 16) + (greenValue << 8) + blueValue;
    }

    // 行水平滤波
    private static int HorizontalFilter(BufferedImage bufImg, int startX, int stopX,
            int start, int stop, int y, double[] pContrib) {
        double valueRed = 0.0;
        double valueGreen = 0.0;
        double valueBlue = 0.0;
        int valueRGB = 0;
        int i, j;

        for (i = startX, j = start; i <= stopX; i++, j++) {
            valueRGB = bufImg.getRGB(i, y);

            valueRed += GetRedValue(valueRGB) * pContrib[j];
            valueGreen += GetGreenValue(valueRGB) * pContrib[j];
            valueBlue += GetBlueValue(valueRGB) * pContrib[j];
        }

        valueRGB = ComRGB(Clip((int) valueRed), Clip((int) valueGreen),
                Clip((int) valueBlue));
        return valueRGB;

    } // end of HorizontalFilter()

    // 图片水平滤波
    private static BufferedImage HorizontalFiltering(BufferedImage bufImage, int iOutW) {
        int dwInW = bufImage.getWidth();
        int dwInH = bufImage.getHeight();
        int value = 0;
        BufferedImage pbOut = new BufferedImage(iOutW, dwInH,
                BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < iOutW; x++) {

            int startX;
            int start;
            int X = (int) (((double) x) * ((double) dwInW) / ((double) iOutW) + 0.5);
            int y = 0;

            startX = X - nHalfDots;
            if (startX < 0) {
                startX = 0;
                start = nHalfDots - X;
            } else {
                start = 0;
            }

            int stop;
            int stopX = X + nHalfDots;
            if (stopX > (dwInW - 1)) {
                stopX = dwInW - 1;
                stop = nHalfDots + (dwInW - 1 - X);
            } else {
                stop = nHalfDots * 2;
            }

            if (start > 0 || stop < nDots - 1) {
                CalTempContrib(start, stop);
                for (y = 0; y < dwInH; y++) {
                    value = HorizontalFilter(bufImage, startX, stopX, start,
                            stop, y, tmpContrib);
                    pbOut.setRGB(x, y, value);
                }
            } else {
                for (y = 0; y < dwInH; y++) {
                    value = HorizontalFilter(bufImage, startX, stopX, start,
                            stop, y, normContrib);
                    pbOut.setRGB(x, y, value);
                }
            }
        }

        return pbOut;

    } // end of HorizontalFiltering()

    private static int VerticalFilter(BufferedImage pbInImage, int startY, int stopY,
            int start, int stop, int x, double[] pContrib) {
        double valueRed = 0.0;
        double valueGreen = 0.0;
        double valueBlue = 0.0;
        int valueRGB = 0;
        int i, j;

        for (i = startY, j = start; i <= stopY; i++, j++) {
            valueRGB = pbInImage.getRGB(x, i);

            valueRed += GetRedValue(valueRGB) * pContrib[j];
            valueGreen += GetGreenValue(valueRGB) * pContrib[j];
            valueBlue += GetBlueValue(valueRGB) * pContrib[j];
            // System.out.println(valueRed+"->"+Clip((int)valueRed)+"<-");
            // 
            // System.out.println(valueGreen+"->"+Clip((int)valueGreen)+"<-");
            // System.out.println(valueBlue+"->"+Clip((int)valueBlue)+"<-"+"-->");
        }

        valueRGB = ComRGB(Clip((int) valueRed), Clip((int) valueGreen),
                Clip((int) valueBlue));
        // System.out.println(valueRGB);
        return valueRGB;

    } // end of VerticalFilter()

    private static BufferedImage VerticalFiltering(BufferedImage pbImage, int iOutH) {
        int iW = pbImage.getWidth();
        int iH = pbImage.getHeight();
        int value = 0;
        BufferedImage pbOut = new BufferedImage(iW, iOutH,
                BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < iOutH; y++) {

            int startY;
            int start;
            int Y = (int) (((double) y) * ((double) iH) / ((double) iOutH) + 0.5);

            startY = Y - nHalfDots;
            if (startY < 0) {
                startY = 0;
                start = nHalfDots - Y;
            } else {
                start = 0;
            }

            int stop;
            int stopY = Y + nHalfDots;
            if (stopY > (int) (iH - 1)) {
                stopY = iH - 1;
                stop = nHalfDots + (iH - 1 - Y);
            } else {
                stop = nHalfDots * 2;
            }

            if (start > 0 || stop < nDots - 1) {
                CalTempContrib(start, stop);
                for (int x = 0; x < iW; x++) {
                    value = VerticalFilter(pbImage, startY, stopY, start, stop,
                            x, tmpContrib);
                    pbOut.setRGB(x, y, value);
                }
            } else {
                for (int x = 0; x < iW; x++) {
                    value = VerticalFilter(pbImage, startY, stopY, start, stop,
                            x, normContrib);
                    pbOut.setRGB(x, y, value);
                }
            }

        }

        return pbOut;

    } // end of VerticalFiltering()

    static int Clip(int x) {
        if (x < 0)
            return 0;
        if (x > 255)
            return 255;
        return x;
    }
    /**
	 * 通过图片获取字节流
	 * 
	 * @Title: getBufferedImageBytes
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param bfi
	 * @param @return 设定文件
	 * @return byte[] 返回类型
	 * @date 2015年10月8日 下午4:26:17
	 * @author SKIN
	 * @throws
	 */
	public static byte[] getBufferedImageBytes(BufferedImage bfi) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 字节输出流

		try {
			ImageIO.write(bfi, "bmp", bos);
		} catch (IOException e) {
			return null;
		} // 将虚拟图片信息写入到字节输出流中
		return bos.toByteArray();
	}
}
