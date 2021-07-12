package com.jjld.coupon.framework.util;

import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtil {

    private static final String UNDERLINE = "_";

    public static String addPrefix(int num, String prefix, int length) {
        return String.format("%04d", num);
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String makeRandomCode(int length) {
        Random dom = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            code.append(dom.nextInt(10));
        }
        return code.toString();
    }

    public static String buildSecretKey() {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            builder.append(source.charAt(new Random().nextInt(source.length())));
        }
        return builder.toString();
    }

    public static String camelToUnderline(String value) {
        if (value == null || "".equals(value.trim())) {
            return "";
        }
        int len = value.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = value.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(buildSecretKey());
    }

}
