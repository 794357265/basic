package com.qianluohan.basic.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class HttpClientUtil {

    public static String insureResponsePost(String url, String param){
        return insureResponsePost(url, param, null);
    }

	
	public static String insureResponsePost(String url, String param, Map<String, String> header) {
        PrintWriter out = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = "";
        HttpURLConnection conn = null;
        StringBuffer strBuffer = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod( "POST");
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(300000);
            conn.setRequestProperty("Charset", "UTF-8");
            // 传输数据为json，如果为其他格式可以进行修改
            conn.setRequestProperty( "Content-Type", "application/json");
            conn.setRequestProperty( "Content-Encoding", "utf-8");
            if(header != null){
                for(String key : header.keySet()){
                    conn.setRequestProperty(key, header.get(key));
                }
            }
            // 发送POST请求必须设置如下两行
            conn.setDoOutput( true);
            conn.setDoInput( true);
            conn.setUseCaches( false);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            is = conn.getInputStream();
            br = new BufferedReader( new InputStreamReader(is));
            String line = null;
            while ((line=br.readLine())!= null) {
                strBuffer.append(line);
            }
            result = strBuffer.toString();
        } catch (Exception e) {
            //System. out.println( "发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (br != null) {
                    br.close();
                }
                if (conn!= null) {
                    conn.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String insureResponseBlockGet(String url) {
        return insureResponseBlockGet(url, null);
    }


	 public static String insureResponseBlockGet(String url, Map<String, String> header) {
	        PrintWriter out = null;
	        String result = "";
	        HttpURLConnection conn = null;
	        InputStream is = null;
	        BufferedReader br = null;
	        StringBuffer strBuffer = new StringBuffer();
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            conn = (HttpURLConnection) realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestMethod("GET");
	            conn.setConnectTimeout(20000);
	            conn.setReadTimeout(300000);
                // 传输数据为json，如果为其他格式可以进行修改
	            conn.setRequestProperty("Content-Type", "application/json");
                if(header != null){
                    for(String key : header.keySet()){
                        conn.setRequestProperty(key, header.get(key));
                    }
                }
	            is = conn.getInputStream();
	            br = new BufferedReader( new InputStreamReader(is));
	            String line = null;
	            while ((line=br.readLine())!= null) {
	                strBuffer.append(line);
	            }
	            result = strBuffer.toString();
	        } catch (Exception e) {
	            //System.out.println( "发送 GET请求出现异常！" + e);
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输出流、输入流
	        finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (br != null) {
	                    br.close();
	                }
	                if (conn != null) {
	                    conn.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }
	}


