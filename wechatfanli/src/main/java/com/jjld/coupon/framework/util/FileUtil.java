package com.jjld.coupon.framework.util;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String getMd5ByFile(MultipartFile upload) throws Exception {
		byte[] uploadBytes = upload.getBytes();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(uploadBytes);
		String hashString = new BigInteger(1, digest).toString(16);
		// 修改统一方法，在MD5前加上时间戳
		return hashString.toUpperCase();
	}

	/**
	 * 根据传入的url和路径，并保存新文件，最后返回下载链接
	 *
	 * @param file 文件
	 * @return 最终路径
	 * 
	 */
	public static Map<String, Object> saveFile(MultipartFile file, String localPath) throws Exception {
		// 获取文件MD5
		String md5 = FileUtil.getMd5ByFile(file);
		// 这里频繁使用md5做文件目录不好，每次上传都是一个新的md5字符串，在没有批量上传的情况下，一个文件夹就只有一张图片
		// 改成：使用年月做文件目录，一月一个，方便管理
		String datePath = DateUtil.convertDate2String(new Date(), DateUtil.DATE_FORMAT_6);
		String suffix = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");

		// 静态资源目录配置时多了个file：，在做url的时候需要干掉
		localPath = localPath.replace("file:", "");

		String newPath = localPath + File.separator + datePath + File.separator + md5 + "." + suffix;

		File fileTemp = new File(newPath);

		// 将文件流保存至指定路径
		FileUtils.copyInputStreamToFile(file.getInputStream(), fileTemp);
		// 前面这个/image是在拦截器里面配置的静态资源目录，不能删
		String url = "/image" + "/" + datePath + "/" + md5 + "." + suffix;

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("url", url);
		data.put("code", 200);

		return data;
	}

}
