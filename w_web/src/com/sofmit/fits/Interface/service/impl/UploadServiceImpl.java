package com.sofmit.fits.Interface.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sofmit.fits.Interface.service.IUploadService;
import com.sofmit.fits.common.ImageCompressUtil;
import com.sofmit.fits.common.imageutil.ImageSize;
import com.sofmit.fits.common.imageutil.ImageUtil;
import com.sofmit.fits.common.utils.Contants;
import com.sofmit.fits.common.utils.file.FTPFileTransmit;
import com.sofmit.fits.common.utils.file.PropertyUtil;

@Service
public class UploadServiceImpl implements IUploadService {

	@Autowired
	private FTPFileTransmit ftpfiles;

	@Override
	public boolean saveGraph(MultipartFile picFile, HttpServletRequest rq,
			String id, String fileName) {
		String savePath = "resources" + Contants.FILE_SEPARATOR
				+ "upload_Images" + Contants.FILE_SEPARATOR + fileName
				+ Contants.FILE_SEPARATOR;
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(fileName)) {
			try {
				String name = picFile.getOriginalFilename();

				ftpfiles.saveInFTP(
						savePath,
						id
								+ name.substring(name.indexOf("."),
										name.length()).trim(),
						picFile.getBytes());
				String[] imageSize;
				byte[] imageBytes;
				EnumSet<ImageSize> currEnumSet = EnumSet.allOf(ImageSize.class);
				ftpfiles.saveInFTP(
						savePath,
						id+ name.substring(name.indexOf("."),
										name.length()).trim(), picFile.getBytes());
				for (ImageSize element : currEnumSet) {
					imageSize = element.toString().split("_")[1].split("x");
				
					/*imageBytes = ImageCompressUtil.resize(picFile.getInputStream(),
							Integer.valueOf(imageSize[1]),
							Integer.valueOf(imageSize[0]), false);*/
				
					imageBytes=ImageUtil.resize(picFile.getInputStream(), Integer.valueOf(imageSize[1]), Integer.valueOf(imageSize[0]));
						
					ftpfiles.saveInFTP(
								savePath,
								id
										+ element.toString()
										+ name.substring(name.indexOf("."),
												name.length()).trim(), imageBytes);
					

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}

			return true;
		}
		return false;
	}

	public void updateDiySizeImage(InputStream is, String savePath, String id,
			String name, int param) {
		String[] imageSize;
		byte[] imageBytes;
		EnumSet<ImageSize> currEnumSet = EnumSet.allOf(ImageSize.class);
	
		for (ImageSize element : currEnumSet) {
			imageSize = element.toString().split("_")[1].split("x");
			InputStream iss=is;
			imageBytes = ImageCompressUtil.resize(iss,
					Integer.valueOf(imageSize[1]),
					Integer.valueOf(imageSize[0]), false);
			if (param == 1) {

				ftpfiles.saveInFTP(
						savePath,
						id
								+ element.toString()
								+ name.substring(name.indexOf("."),
										name.length()).trim(), imageBytes);
			} else if (param == 2) {
				ftpfiles.saveInFTP(savePath, id
						+ element.toString() + ".jpg", imageBytes);
			} else if (param == 3) {

				ftpfiles.saveInFTP(savePath, id
						+ element.toString() + name, imageBytes);
			}

		}

	}

	public String getRealPath(HttpServletRequest rq, String path) {
		return rq.getSession().getServletContext().getRealPath(path);
	}

	public static void main(String[] args) {

		EnumSet<ImageSize> currEnumSet = EnumSet.allOf(ImageSize.class);

		for (ImageSize element : currEnumSet) {

			System.out.println(" ��ǰ EnumSet ������Ϊ�� "
					+ element.toString().split("_")[1]);

		}

	}

	@Override
	public boolean deleteGrap(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveFullAvatarEditorGraph(MultipartFile picFile,
			HttpServletRequest rq, String id, String fileName) {
		String savePath = "resources" + Contants.FILE_SEPARATOR
				+ "upload_Images" + Contants.FILE_SEPARATOR + fileName;
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(fileName)) {

			try {
				String name = picFile.getOriginalFilename();
				
				String[] imageSize;
				byte[] imageBytes;
				EnumSet<ImageSize> currEnumSet = EnumSet.allOf(ImageSize.class);
				ftpfiles.saveInFTP(savePath, id
						 + ".jpg", picFile.getBytes());
				for (ImageSize element : currEnumSet) {
					imageSize = element.toString().split("_")[1].split("x");
				
					imageBytes = ImageCompressUtil.resize(picFile.getInputStream(),
							Integer.valueOf(imageSize[1]),
							Integer.valueOf(imageSize[0]), false);
				
						ftpfiles.saveInFTP(savePath, id
								+ element.toString() + ".jpg", imageBytes);

				// ftpfiles.saveInFTP(savePath, id + ".jpg",
				// picFile.getBytes());
				}
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
			/*
			 * savePath = getRealPath(rq, "") + Contants.FILE_SEPARATOR +
			 * savePath; // �ļ���·�������� �򴴽� File file = new File(savePath); if
			 * (!file.exists() && !file.isDirectory()) { file.mkdirs(); } String
			 * saveBigName = id.trim() + ".jpg"; String fileBigPath = savePath +
			 * Contants.FILE_SEPARATOR + saveBigName; File bigFile = new
			 * File(fileBigPath); if (bigFile.exists()) { bigFile.delete(); }
			 * byte[] data = null; try { data =
			 * IOUtils.toByteArray(picFile.getInputStream());
			 * 
			 * } catch (IOException e) { return false; } FileOutputStream fos =
			 * null; try { fos = new FileOutputStream(bigFile); fos.write(data);
			 * 
			 * } catch (Exception e) { return false; } finally { if (fos !=
			 * null) try { fos.close();
			 * 
			 * } catch (IOException e) { return false; } } return true;
			 */
		}
		return false;
	}

	@Override
	public boolean saveVedio(MultipartFile picFile, HttpServletRequest rq,
			String id, String fileName, String address) {
		String savePath = "resources" + Contants.FILE_SEPARATOR + "index_video"
				+ Contants.FILE_SEPARATOR + fileName;
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(fileName)) {
			try {
				ftpfiles.saveInFTP(savePath, id + address, picFile.getBytes());
//
//				String[] imageSize;
//				byte[] imageBytes;
//				EnumSet<ImageSize> currEnumSet = EnumSet.allOf(ImageSize.class);
//				ftpfiles.saveInFTP(savePath, id
//						 + address, picFile.getBytes());
//				for (ImageSize element : currEnumSet) {
//					imageSize = element.toString().split("_")[1].split("x");
//					imageBytes = ImageCompressUtil.resize(picFile.getInputStream(),
//							Integer.valueOf(imageSize[1]),
//							Integer.valueOf(imageSize[0]), false);
//						ftpfiles.saveInFTP(savePath, id
//								+ element.toString() + address, imageBytes);
//				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean saveApp(MultipartFile picFile, HttpServletRequest rq,String appName,String savePath) {			
			try {
				ftpfiles.saveInFTP(savePath, appName, picFile.getBytes());			
			} catch (IOException e) {
				
				return false;
			}
			return true;	
	}

	@Override
	public String saveOneGraph(MultipartFile picFile, HttpServletRequest rq, 
			String id, String fileName) {
		String datePath=Contants.createDatePath();
		String savePath = "skv2" + Contants.FILE_SEPARATOR
				+ datePath + Contants.FILE_SEPARATOR + fileName
				+ Contants.FILE_SEPARATOR;
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(fileName)) {
			try {
				String name = picFile.getOriginalFilename();			
				ftpfiles.saveInFTP(
						savePath,
						id+ name.substring(name.indexOf("."),
										name.length()).trim(), picFile.getBytes());		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return null;
			}
			return datePath;
		}
		return null;
	}
	
	@Override
	public String saveCompressImg(String FileName, byte[] data) {
		try {
			String datePath=Contants.createDatePath();
			String savePath = PropertyUtil.getProperty("image_content")+ Contants.FILE_SEPARATOR
					+ datePath +Contants.FILE_SEPARATOR;
			
			String viewPath = PropertyUtil.getProperty("web_image_url")+Contants.FILE_SEPARATOR+
							  PropertyUtil.getProperty("image_content")+Contants.FILE_SEPARATOR+
							  datePath+Contants.FILE_SEPARATOR+FileName;
			ftpfiles.saveInFTP(savePath,FileName,data);
			return viewPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
