package com.sofmit.fits.Interface.service;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public interface IUploadService {
	
	
	/**
	 * 原图片上�?
	 */
	public String saveOneGraph(MultipartFile picFile,
			HttpServletRequest rq, String id, String FileName);
	/**
	 * 
	* @Title: saveGraph 
	* @Description: TODO(保存文件到项目路径中) 
	* @param @param picFile
	* @param @param rq
	* @param @param id          �?存的文件名称 和数据库id�?�?
	* @param @param FileName    �?存文件夹的名�? 
	* @return void    返回类型 
	* @date 2015�?1�?13�? 上午9:37:43
	* @author SKIN
	* @throws
	 */
	public boolean saveGraph(MultipartFile picFile,
			HttpServletRequest rq, String id, String FileName);
	
	/**
	 * 
	* @Title: saveFullAvatarEditorGraph 富士头像上传 
	* @Description: TODO(保存文件到项目路径中) 
	* @param @param picFile
	* @param @param rq
	* @param @param id          �?存的文件名称 和数据库id�?�?
	* @param @param FileName    �?存文件夹的名�? 
	* @return void    返回类型 
	* @date 2015�?1�?13�? 上午9:37:43
	* @author SKIN
	* @throws
	 */
	public boolean saveFullAvatarEditorGraph(MultipartFile picFile,
			HttpServletRequest rq, String id, String FileName);
	
	/**
	 * 
	* @Title: saveVedio 
	* @Description: 上传视频
	* @param @param picFile
	* @param @param rq
	* @param @param id
	* @param @param FileName
	* @param @param address 后缀
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @date 2015�?4�?13�? 下午4:17:20
	* @author SKIN
	* @throws
	 */
	public boolean saveVedio(MultipartFile picFile,
			HttpServletRequest rq, String id, String FileName,String address);
		
	public boolean deleteGrap(String fileName);
	public void updateDiySizeImage(InputStream is, String savePath, String id,
			String name, int param);
	public boolean saveApp(MultipartFile picFile,
			HttpServletRequest rq, String appName, String savePath);
	
	/**
	 * 
	 * @param pathName
	 * @param data
	 * @return 保存路径
	 */
	public String saveCompressImg(String pathName, byte[] data);
	
}
