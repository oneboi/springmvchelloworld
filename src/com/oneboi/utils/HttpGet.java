package com.oneboi.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {

	public static void main(String[] args) throws Exception {
		String res=getRequest("http://10.0.36.137/index.php?g=User&m=WxApi&a=gettoken");
		System.out.println(res);
	}
	public static String getRequest(String url) throws Exception{
		String message="";
	    try {
	        URL urlGet = new URL(url);
	        HttpURLConnection http = (HttpURLConnection)urlGet.openConnection();
	        http.setRequestMethod("GET"); 
	        http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	        http.setDoOutput(true);
	        http.setDoInput(true);

	        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
	        System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

	        http.connect();

	        InputStream is = http.getInputStream();
	        int size = is.available();
	            
	        byte[] jsonBytes = new byte[size];
	        is.read(jsonBytes);
	         message = new String(jsonBytes, "UTF-8"); 

	        is.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return message;
	}
}
