package com.cowboy.commons.http;/**
 * Created by Administrator on 2017/12/12/0012.
 */

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tangyinbo
 * @version 1.0
 * @create 2017-12-12 15:11
 **/
public class HttpClientEdu01 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:18081/springboot/user/createUser2");
        post.setHeader("","");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        NameValuePair p1 = new BasicNameValuePair("name", "tangyinbo");
        NameValuePair p2 = new BasicNameValuePair("age", "12");
        params.add(p1);
        params.add(p2);
        HttpEntity entity = new UrlEncodedFormEntity(params, Charset.forName("utf-8"));
        post.setEntity(entity);

        try (CloseableHttpResponse response = httpClient.execute(post);) {
            StatusLine line = response.getStatusLine();
            System.out.println("code:" + line.getStatusCode());

            HttpEntity responseEntity = response.getEntity();
            Header header = responseEntity.getContentType();
            HeaderElement[] headerElements = header.getElements();
            for (HeaderElement h : headerElements) {
                System.out.println(JSON.toJSONString(h.getParameters()));
            }
            String result = EntityUtils.toString(responseEntity);
            System.out.println(result);
        }


    }
}
