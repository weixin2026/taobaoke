package com.jjld.coupon.framework.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class MD5Util {

	public static String getMD5(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(str.getBytes());
			String hashString = new BigInteger(1, digest).toString(16);
			return hashString.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String makeToken() {
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

	public static void main(String[] args) {
		System.out.println(getMD5("rootroot"));
	}
}
