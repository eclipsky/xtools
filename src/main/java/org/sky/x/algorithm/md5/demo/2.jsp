<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.security.*"%>
<%@page import="java.util.*"%>
<%@page import="com.algorithm.md5.MD5"%>
<%
	//*****************************转向请求接口实现逻辑***********************
	//md5加密密钥
	String sMD5Key = "YNMD5";
	//合作商ID
	String sClickSysId = "4";
	//重定向rUrl类型
	String srType = "0";
	//重定向地址 编码的的rUrl是在登录时候回到客户当前访问的页面地址,也可能是其它类型，这个依据rType类型，当然这个是第三方根据自身系统情况设置的
	String rUrl = java.net.URLEncoder.encode("http://mail.10086.cn/?id=1&dd=00", "gb2312");
	//时间戳 后面的5*60=5分钟 表示期望在这个时间段内送达,一定要加一个时间差，这个时间差要适中
	String timestamp = String
			.valueOf((System.currentTimeMillis() - (new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
					.getTime())) / 1000 + 5 * 60);
	//拼串加密的的明文
	java.lang.StringBuilder sbMD5ProclaimedText = new java.lang.StringBuilder();
	sbMD5ProclaimedText.append(sClickSysId);
	sbMD5ProclaimedText.append(srType);
	sbMD5ProclaimedText.append(rUrl);
	sbMD5ProclaimedText.append(timestamp);
	sbMD5ProclaimedText.append(sMD5Key);
	//签名
	String smKey = MD5.MD5Encode(sbMD5ProclaimedText.toString());
	//重定向地址&amp;
	String sRedirect = String.format(
					"http://sq.mail.10086.cn/webapi/trustlogin.aspx?clickSysId=%s&rType=%s&rUrl=%s&mKey=%s&timestamp=%s",
					sClickSysId, srType, rUrl, smKey, timestamp);
	//重定向实现转向请求接口
	response.sendRedirect(sRedirect);
%>
