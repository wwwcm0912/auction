package org.xm.auction.userserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class LoginController {
//    @GetMapping("/")
//    public String index(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient auth2AuthorizedClient, @AuthenticationPrincipal OAuth2User oAuth2User) {
//        model.addAttribute("userName",oAuth2User.getName());
//        model.addAttribute("clientName",auth2AuthorizedClient.getClientRegistration().getClientName());
//        model.addAttribute("userAttributes",oAuth2User.getAttributes());
//        return "index";
//    }

//    @GetMapping("/")
//    public String index() {
//        String resStr = "";
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        // 参数
//        StringBuffer params = new StringBuffer();
//        params.append("grant_type=client_credentials").append("&").append("scope=message:read");
//        HttpPost httpPost = new HttpPost("http://localhost:31001/oauth2/token?"+params);
//        // 设置contentType
//        httpPost.setHeader("Content-Type","application/json;charset=utf8");
//        httpPost.setHeader("Authorization","Basic bWVzc2FnaW5nLWNsaWVudDpzZWNyZXQ=");
//        // 响应模型
//        CloseableHttpResponse response = null;
//        try{
//            // 由客户端执行(发送)Get请求
//            response = httpClient.execute(httpPost);
//            // 从响应模型中获取响应实体
//            HttpEntity responseEntity = response.getEntity();
//            log.info("响应状态为：{}",response.getStatusLine());
//            if(responseEntity != null) {
//                String str = EntityUtils.toString(responseEntity);
//                log.info("响应内容为：{}", str);
//                return str;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(httpClient != null) {
//                    httpClient.close();
//                }
//                if(response != null) {
//                    response.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return "";
//    }
}
