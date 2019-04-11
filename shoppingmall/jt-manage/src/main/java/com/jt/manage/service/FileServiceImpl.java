package com.jt.manage.service;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.jt.common.vo.PicUploadResult;
@Service
public class FileServiceImpl implements FileService{
	
//	String dirPath="E:/jt-upload/";	
//	String urlPath="http://image.jt.com/";	
//	
	
	@Value("${image.dirPath}")//从spring容器中取值
	private String dirPath;
	@Value("${image.urlPath}")
	private String urlPath;
	
	
	/**
	 * 编程：
	 * 1、判断是否是图片
	 * 2、判断是否为恶意程序
	 * 3、为了方便图片读取，一般分文件存储
	 	  3.1 hash值8位一截
	 	  3.2 时间分割
	 	
	 * 4、防止图片重名
	 * 
	 *
	 */	  	
	@Override
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		//1.获取图片信息
		PicUploadResult result=new PicUploadResult();
		String fileName=uploadFile.getOriginalFilename();
		//2.判断是否为图片类型
		fileName=fileName.toLowerCase();//将字符全部转换为小写
		if(!fileName.matches("^.+\\.(jpg|png|gif)$")) {
			//表示不是图片的类型
			result.setError(1);
			return result;
		}
		/**
		 * 3、判断文件是否恶意程序
		 */		
		try {
			BufferedImage image=ImageIO.read(uploadFile.getInputStream());
			
			int height=image.getHeight();
			int width=image.getWidth();
			if(height==0||width==0) {
				result.setError(1);
				return result;
			}
			
			//4、分文件存储
			String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			
			//4.1创建文件夹
			
			File dirFile=new File(dirPath+datePath);
			if(!dirFile.exists()) {
				//如果文件不存在，则创建文件夹
				dirFile.mkdirs();
			}
			//4.2为文件生成唯一的名称，UUID+后缀
			String uuid=UUID.randomUUID().toString().replace("-", "");
			
			//图片名称 abc.jpg 截串规则：包头不包尾
			String fileType=fileName.substring(fileName.lastIndexOf("."));
			
			String realFileName=uuid+fileType;
			
			//5将文件实现上传
			File realFile=new File(dirPath+datePath+"/"+realFileName);
			uploadFile.transferTo(realFile);
			
			
			/**
			 * 封装返回值数据
			 */
			result.setHeight(height+"");
			result.setWidth(width+"");
			String url=urlPath+datePath+"/"+realFileName;
			result.setUrl(url);
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			result.setError(1);
			return result;
		}
		
		
	}

}
