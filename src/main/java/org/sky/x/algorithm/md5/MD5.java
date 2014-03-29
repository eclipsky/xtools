package org.sky.x.algorithm.md5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MD5 {

	// MD5签名算法
	public static String MD5Encode(String str) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] encodedPassword = md.digest();
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			for (int i = 0; i < encodedPassword.length; i++) {
				if ((encodedPassword[i] & 0xff) < 0x10) {
					sb.append("0");
				}
				sb.append(Long.toString((encodedPassword[i] & 0xff), 16));
			}
			return (sb.toString().toUpperCase());
		} catch (Exception ex) {
		}
		return null;
	}

	// 获取请求来源的ip地址
	public static String GetRequestIP(javax.servlet.http.HttpServletRequest req) {
		String ip = req.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getRemoteAddr();
		}
		return ip;
	}

	// 将请求数据流转成字符串
	public static String inputStream2String(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}

	// 发起请求
	@SuppressWarnings("deprecation")
	public static String PostRequest(String sXml, String url) {
		String sResult = "";
		org.apache.commons.httpclient.HttpClient httpclientobj = null;
		org.apache.commons.httpclient.methods.PostMethod post = null;
		try {
			httpclientobj = new org.apache.commons.httpclient.HttpClient();
			post = new org.apache.commons.httpclient.methods.PostMethod(url);
			post.setRequestHeader("Content-Type", "text/xml; charset=GB2312");
			post.setRequestBody(sXml);
			httpclientobj.executeMethod(post);
			if (post.getStatusCode() != org.apache.commons.httpclient.HttpStatus.SC_OK) {
				post.releaseConnection();
				return sResult;
			}
			InputStream resStream = post.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(resStream));
			StringBuffer resBuffer = new StringBuffer();
			String resTemp = "";
			while ((resTemp = br.readLine()) != null) {
				resBuffer.append(resTemp);
			}
			sResult = resBuffer.toString();
			post.releaseConnection();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
		return sResult;
	}

	public static void main(String[] args) {
		String proclaime1 = "menglei";
		String secret1 =  MD5.MD5Encode(proclaime1);
		System.out.println("明文proclaime1：="+proclaime1 +" ,密文secret1="+secret1);
		
		String secret2 =  MD5.MD5Encode(secret1);
		System.out.println("明文secret1：="+secret1 +" ,密文secret2="+secret2);
	}
}
