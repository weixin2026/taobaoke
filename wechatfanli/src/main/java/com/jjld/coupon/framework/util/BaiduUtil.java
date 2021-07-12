package com.jjld.coupon.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 百度链接实时推送 工具类(需要结合百度站长平台)
 * Created by SongFei on 2017/8/9.
 */
public class BaiduUtil {

    private static final Logger logger = LoggerFactory.getLogger(BaiduUtil.class);
 

    /**
     * post推送url到百度，可以单独，也可以批量
     *
     * @param parameters 需要推送的链接
     *
     * @return 推送结果，参考百度官方定义
     *
     * <p>
     *         成功返回值：
     * <p>
     *         success         int        成功推送的url条数
     * <p>
     *         remain          int        当天剩余的可推送url条数
     * <p>
     *         not_same_site   array      由于不是本站url而未处理的url列表
     * <p>
     *         not_valid       array      不合法的url列表
     * <p>
     *         失败返回值：
     * <p>
     *         error           int        错误码，与状态码相同
     * <p>
     *         message         string     错误描述
     * <p>
     */
    public static String push(List<String> parameters,String ZhanZhang_BaiDu_Token_Url) {

        if (null == parameters || parameters.size()==0) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            //建立URL之间的连接
            URLConnection conn = new URL(ZhanZhang_BaiDu_Token_Url).openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("Host", "data.zz.baidu.com");
            conn.setRequestProperty("User-Agent", "curl/7.12.1");
            conn.setRequestProperty("Content-Length", "83");
            conn.setRequestProperty("Content-Type", "text/plain");

            //发送POST请求必须设置如下两行
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //获取conn对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            StringBuilder param = new StringBuilder();
            for (String s : parameters) {
                param.append(s.trim()).append("\n");
            }
            out.print(param.toString());
            //进行输出流的缓冲
            out.flush();

            //通过BufferedReader输入流来读取Url的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            logger.error("推送url到百度，发送post请求失败，原因：" + ExceptionUtils.getStackTrace(e));
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("推送url到百度，完毕，关闭IO流失败，原因：" + ExceptionUtils.getStackTrace(e));
            }
        }

        logger.info("推送结果：" + result.toString());

        return result.toString();
    }

    public static void main(String[] args) {
    	String BAIDU_POST_URL = "http://data.zz.baidu.com/urls?site=https://www.wuliaokankan.cn&token=DcwKt7b2JndsTg0a";
        List<String> urls = new ArrayList<>();
        urls.add("https://www.wuliaokankan.cn/short_detail/7879.html");
        push(urls,BAIDU_POST_URL);
    }

}
