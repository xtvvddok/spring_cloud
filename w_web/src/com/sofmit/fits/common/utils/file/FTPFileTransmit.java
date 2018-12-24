/**
 * @projectName: cdsk
 * @fileName: FTPFileTransmit.java
 * @author: HEXY
 * @CreateDate: 2015�?�?5�?下午2:53:52
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
 * @Description: FTP�ļ�����
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
	 * Description: ���ļ��洢��FTP�� <BR>
	 * Remark: <BR>
	 * 
	 * @param FolderName ʾ��"xxx/xxx/"
	 * @param FileName ʾ��"thefilename"
	 * @param f �ļ�
	 * @return boolean<BR>
	 */
	public boolean saveInFTP(String FolderName, String FileName, File f) {
		boolean flag = false;

		// ����FTP�ͻ���
		FTPClient ftpClient = new FTPClient();
		// ���������ڶ�ȡ�ļ�
		// FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			// ���FolderName �� FileName�������ϻ���Ҫ��, ��ô��û�б�Ҫ����ftp����
			if (StringUtils.isNotEmpty(FileName)) {

				// ����FTP����
				//ftpClient.connect(this.ftp_url);
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));
				// �����¼�ɹ���, �Ž��д���������
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					ftpClient.enterLocalPassiveMode();
					// File srcClientFile = new File("C:/ParseXML.xml");

					// ʵ����������
					// fis = new FileInputStream(srcClientFile);
					mkdirs(FolderName, ftpClient);
					//					if (!ftpClient.changeWorkingDirectory(FolderName)) {
					//						mkdirs(FolderName, ftpClient);
					//					}
					// ��byte[]д�뵽��������, ʵ����
					bis = new BufferedInputStream(new FileInputStream(f));

					// ���û���
					ftpClient.setBufferSize(1024);

					// �����ļ�����(����������)
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
				// �ر�������
				IOUtils.closeQuietly(bis);
				// �ر�����
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	
	public boolean saveInFTP(String FolderName, String FileName, InputStream f) {
		boolean flag = false;

		// ����FTP�ͻ���
		FTPClient ftpClient = new FTPClient();

		try {
			// ���FolderName �� FileName�������ϻ���Ҫ��, ��ô��û�б�Ҫ����ftp����
			if (StringUtils.isNotEmpty(FileName)) {

				// ����FTP����
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));

				// �����¼�ɹ���, �Ž��д���������
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					ftpClient.enterLocalPassiveMode();
					mkdirs(FolderName, ftpClient);
			
					ftpClient.setBufferSize(1024);

					// �����ļ�����(����������)
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
				// �ر�����
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	

	/**
	 * Method name: saveInFTP <BR>
	 * Description: ���ļ��洢��FTP�� <BR>
	 * Remark: <BR>
	 * 
	 * @param FolderName ʾ��"xxx/xxx/"
	 * @param FileName ʾ��"thefilename"
	 * @param f �ļ�
	 * @return boolean<BR>
	 */
	public boolean saveInFTP(String FolderName, String FileName, byte[] data) {
		boolean flag = false;

		// ����FTP�ͻ���
		FTPClient ftpClient = new FTPClient();
		// ���������ڶ�ȡ�ļ�
		// FileInputStream fis = null;
		ByteArrayInputStream bis = null;

		try {
			// ���FolderName �� FileName�������ϻ���Ҫ��, ��ô��û�б�Ҫ����ftp����
			if (StringUtils.isNotEmpty(FileName)) {

				// ����FTP����
				
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));
				System.out.println("����FTP����");
				// �����¼�ɹ���, �Ž��д���������
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					System.out.println("��¼�ɹ�FTP");
					ftpClient.enterLocalPassiveMode();
					// File srcClientFile = new File("C:/ParseXML.xml");

					// ʵ����������
					// fis = new FileInputStream(srcClientFile);
					System.out.println("ʵ����������");
					mkdirs(FolderName, ftpClient);
					//					if (!ftpClient.changeWorkingDirectory(FolderName)) {
					//						mkdirs(FolderName, ftpClient);
					//					}
					// ��byte[]д�뵽��������, ʵ����
					System.out.println("��byte[]д�뵽��������, ʵ����");
					bis = new ByteArrayInputStream(data);

					// ���û���
					System.out.println("���û���");
					ftpClient.setBufferSize(1024);

					// �����ļ�����(����������)
					System.out.println("����������");
					if (ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)) {
						flag = ftpClient.storeFile(FileName, bis);
					}
				} else {
					System.out.println("��¼ʧ��");
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
				// �ر�������
				IOUtils.closeQuietly(bis);
				// �ر�����
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	private boolean exists(FTPClient ftpClient, String dir) {
		try {
			return ftpClient.changeWorkingDirectory(dir); // �벻��ʲô�ð취���ж�Ŀ¼�Ƿ���ڣ�ֻ�����쳣��(�Ƚϱ�).��֪���ĸ�����һ��`
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
	 * Description: ���ļ��洢��FTP�� <BR>
	 * Remark: <BR>
	 * 
	 * @param FolderName ʾ��"xxx/xxx/"
	 * @param FileName ʾ��"thefilename"
	 * @param f �ļ�
	 * @return boolean<BR>
	 */
	public boolean delete(String pathFileName) {
		boolean flag = false;

		// ����FTP�ͻ���
		FTPClient ftpClient = new FTPClient();
		// ���������ڶ�ȡ�ļ�
		// FileInputStream fis = null;
		ByteArrayInputStream bis = null;

		try {
			// ���FolderName �� FileName�������ϻ���Ҫ��, ��ô��û�б�Ҫ����ftp����
			if (StringUtils.isNotEmpty(pathFileName)) {

				// ����FTP����
				ftpClient.connect(ftp_url, Integer.valueOf(ftp_port));

				// �����¼�ɹ���, �Ž��д���������
				if (ftpClient.login(this.ftp_user, this.ftp_passwd)) {
					boolean success = false;
					String path ="resources/upload_Images/view_images/";
			        try {
			        	ftpClient.changeWorkingDirectory(path);//ת�Ƶ�ָ��FTP������Ŀ¼  
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
				// �ر�������
				IOUtils.closeQuietly(bis);
				// �ر�����
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}
	
}
