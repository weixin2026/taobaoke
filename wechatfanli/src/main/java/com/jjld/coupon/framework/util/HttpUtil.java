package com.jjld.coupon.framework.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpUtil {

    /**
     * 请求超时时间，以毫秒为单位
     */
    private static final int TIMEOUT = 5 * 60 * 1000;

    public static String postJson(String url, String json) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //发送json格式数据
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

            //发送POST请求必须设置如下两行
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //超时时间
            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);

            //获取conn对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(json);
            //进行输出流的缓冲
            out.flush();

            //通过BufferedReader输入流来读取Url的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            log.error("发送请求[{}]失败，原因：{}", url, ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("关闭IO流失败，原因：{}", ExceptionUtils.getStackTrace(e));
            }
        }

        log.info("发送请求[{}]完成，结果：{}", url, result.toString());

        return result.toString();
    }

    public static String post(String url, Map<String, Object> map) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //超时时间
            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);

            //获取conn对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(buildParam(map));
            //进行输出流的缓冲
            out.flush();

            //通过BufferedReader输入流来读取Url的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            log.error("发送请求[{}]失败，原因：{}", url, ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("关闭IO流失败，原因：{}", ExceptionUtils.getStackTrace(e));
            }
        }

        log.info("发送请求[{}]完成，结果：{}", url, result.toString());

        return result.toString();
    }

    public static String get(String url, Map<String, Object> map) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            //超时时间
            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);

            //获取conn对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(buildParam(map));
            //进行输出流的缓冲
            out.flush();

            //通过BufferedReader输入流来读取Url的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            log.error("发送请求[{}]失败，原因：{}", url, ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("关闭IO流失败，原因：{}", ExceptionUtils.getStackTrace(e));
            }
        }

        log.info("发送请求[{}]完成，结果：{}", url, result.toString());

        return result.toString();
    }

    private static String buildParam(Map<String, Object> map) {
        if (MapUtils.isEmpty(map)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            builder.append("&").append(key).append("=").append(map.get(key));
        }
        String params = builder.substring(1);
        log.info("请求参数：{}", params);
        return params;
    }

   
}
