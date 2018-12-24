/**
 * @projectName: cdsk
 * @fileName: FTPFileTransmit.java
 * @author: HEXY
 * @CreateDate: 2015骞?鏈?5鏃?涓嬪崍2:53:52
 * @version V1.0  
 */
package com.sofmit.fits.common.utils.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Component;



/**
 * @ClassName: FTPFileTransmit
 * @Description: FTP文件操作
 */
@Component
public class FTPFileTransmit {
//	@Value("${ftp_url}")
	String ftp_url = PropertyUtil.getProperty("ftp_url");
//	@Value("${ftp_user}")
	String ftp_user = PropertyUtil.getProperty("ftp_user");
//	@Value("${ftp_passwd}")
	String ftp_passwd = PropertyUtil.getProperty("ftp_passwd");
	String ftp_port = PropertyUtil.getProperty("ftp_port");
	/**
	 * Method name: saveInFTP <BR>
	 * Description: 把文件存储在FTP上 <BR>
	 * Remark: <BR>
	 * 
	 * @param FolderName 示例"xxx/xxx/"
	 * @param FileName 示例"thefilename"
	 * @param f 文件
	 * @return boolean<BR>
	 */
	public boolean saveInFTP(String FolderName, String FileName, File f) {
		boolean flag = false;

		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		// 输入流用于读取文件
		// FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			// 如果FolderName 和 FileName都不符合基本要求, 那么就没有必要进行ftp操作
			if (StringUtils.isNotEmpty(FileName)) {

				// 建立FTP连接
				//ftpClient.connect(this.ftp_url);
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));
				// 如果登录成功后, 才进行创建输入流
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					ftpClient.enterLocalPassiveMode();
					// File srcClientFile = new File("C:/ParseXML.xml");

					// 实例化输入流
					// fis = new FileInputStream(srcClientFile);
					mkdirs(FolderName, ftpClient);
					//					if (!ftpClient.changeWorkingDirectory(FolderName)) {
					//						mkdirs(FolderName, ftpClient);
					//					}
					// 将byte[]写入到输入流中, 实例化
					bis = new BufferedInputStream(new FileInputStream(f));

					// 设置缓冲
					ftpClient.setBufferSize(1024);

					// 设置文件类型(二进制类型)
					if (ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)) {
						flag = ftpClient.storeFile(FileName, bis);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭输入流
				IOUtils.closeQuietly(bis);
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	
	public boolean saveInFTP(String FolderName, String FileName, InputStream f) {
		boolean flag = false;

		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();

		try {
			// 如果FolderName 和 FileName都不符合基本要求, 那么就没有必要进行ftp操作
			if (StringUtils.isNotEmpty(FileName)) {

				// 建立FTP连接
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));

				// 如果登录成功后, 才进行创建输入流
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					ftpClient.enterLocalPassiveMode();
					mkdirs(FolderName, ftpClient);
			
					ftpClient.setBufferSize(1024);

					// 设置文件类型(二进制类型)
					if (ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)) {
						flag = ftpClient.storeFile(FileName, f);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	

	/**
	 * Method name: saveInFTP <BR>
	 * Description: 把文件存储在FTP上 <BR>
	 * Remark: <BR>
	 * 
	 * @param FolderName 示例"xxx/xxx/"
	 * @param FileName 示例"thefilename"
	 * @param f 文件
	 * @return boolean<BR>
	 */
	public boolean saveInFTP(String FolderName, String FileName, byte[] data) {
		boolean flag = false;

		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		// 输入流用于读取文件
		// FileInputStream fis = null;
		ByteArrayInputStream bis = null;

		try {
			// 如果FolderName 和 FileName都不符合基本要求, 那么就没有必要进行ftp操作
			if (StringUtils.isNotEmpty(FileName)) {

				// 建立FTP连接
				
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));
				System.out.println("建立FTP连接");
				// 如果登录成功后, 才进行创建输入流
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					System.out.println("登录成功FTP");
					ftpClient.enterLocalPassiveMode();
					// File srcClientFile = new File("C:/ParseXML.xml");

					// 实例化输入流
					// fis = new FileInputStream(srcClientFile);
					System.out.println("实例化输入流");
					mkdirs(FolderName, ftpClient);
					//					if (!ftpClient.changeWorkingDirectory(FolderName)) {
					//						mkdirs(FolderName, ftpClient);
					//					}
					// 将byte[]写入到输入流中, 实例化
					System.out.println("将byte[]写入到输入流中, 实例化");
					bis = new ByteArrayInputStream(data);

					// 设置缓冲
					System.out.println("设置缓冲");
					ftpClient.setBufferSize(1024);

					// 设置文件类型(二进制类型)
					System.out.println("二进制类型");
					if (ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)) {
						flag = ftpClient.storeFile(FileName, bis);
					}
				} else {
					System.out.println("登录失败");
				}
			
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭输入流
				IOUtils.closeQuietly(bis);
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	private boolean exists(FTPClient ftpClient, String dir) {
		try {
			return ftpClient.changeWorkingDirectory(dir); // 想不到什么好办法来判断目录是否存在，只能用异常了(比较笨).请知道的告诉我一声`
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void mkdirs(String dir, FTPClient client) throws Exception {
		if (dir == null) {
			return;
		}
		dir = dir.replace("//", "/");
		String[] dirs = dir.split("/");
		for (int i = 0; i < dirs.length; i++) {
			dir = dirs[i];
			if (!StringUtils.isEmpty(dir)) {
				if (!exists(client, dir)) {
					client.makeDirectory(dir);
				}
				client.changeWorkingDirectory(dir);
			}
		}
	}
	/**
	 * Method name: saveInFTP <BR>
	 * Description: 把文件存储在FTP上 <BR>
	 * Remark: <BR>
	 * 
	 * @param FolderName 示例"xxx/xxx/"
	 * @param FileName 示例"thefilename"
	 * @param f 文件
	 * @return boolean<BR>
	 */
	public boolean delete(String pathFileName) {
		boolean flag = false;

		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		// 输入流用于读取文件
		// FileInputStream fis = null;
		ByteArrayInputStream bis = null;

		try {
			// 如果FolderName 和 FileName都不符合基本要求, 那么就没有必要进行ftp操作
			if (StringUtils.isNotEmpty(pathFileName)) {

				// 建立FTP连接
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));

				// 如果登录成功后, 才进行创建输入流
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					boolean success = false;
					String path ="resources/upload_Images/view_images/";
			        try {
			        	ftpClient.changeWorkingDirectory(path);//转移到指定FTP服务器目录  
			        	pathFileName = new String(pathFileName.getBytes("GBK"), "utf-8");  
			            path = new String(path.getBytes("GBK"), "utf-8");  
			            ftpClient.deleteFile(pathFileName);  
			            ftpClient.logout();  
			            success = true;  
			        } catch (Exception e) {  
			            e.printStackTrace();  
			        }  
			        return success;  
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭输入流
				IOUtils.closeQuietly(bis);
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	
}
