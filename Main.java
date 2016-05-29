package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:9000/myexample";
        String jsString ="{\"name\":\"intellijmaria\"}";

        HttpPost request = new HttpPost(url);
        Header header = new Header(HttpHeaders.CONTENT_TYPE, "application/json");

        StringEntity params =new StringEntity(jsString);
        request.setEntity(params);


        CloseableHttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        request.setEntity(new StringEntity(jsString));
        HttpResponse response = httpClient.execute(request);
        System.out.println(request);
        System.out.println(response);

    }
}
