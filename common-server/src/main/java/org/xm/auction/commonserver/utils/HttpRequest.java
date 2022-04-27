package org.xm.auction.commonserver.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Component
public class HttpRequest {

    public static String sendGet(String url,String param) {
        String result = "";
        try {
            if(StringUtils.isNotEmpty(param)) {
                url = url + "?" + param;
            }
            URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();
            urlConnection.setRequestProperty("User-Agent", "PostmanRuntime/7.28.0");
            urlConnection.setConnectTimeout(1000 * 5); // 设置请求超时时间为5秒
            urlConnection.connect();
            InputStream input = urlConnection.getInputStream();
            result = IOUtils.toString(input, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
