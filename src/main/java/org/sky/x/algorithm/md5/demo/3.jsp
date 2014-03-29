<%@page language="java" contentType="text/xml; charset=GB2312" pageEncoding="GB2312"%>
<%@page import="java.security.*,java.io.*,java.util.*,org.w3c.dom.*"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="com.algorithm.md5.MD5"%>
<%@page import="java.lang.*"%>

<%!/// <summary>
	/// 验证请求ip来源是否信任
	/// </summary>
	/// <param name="ip"></param>
	/// <returns></returns>
	public static boolean AuthIp(String ip) {
		//以下逻辑是验证ip是否信任,请第三方站点加上业务逻辑处理
		//....................
		return true;
	}%>
<%
	//**********************注册接口************************
	//md5加密密钥
	String sMD5Key = "YNMD5";
	//请求数据
	String sReqXml = "";
	//合作商业ID
	String sClickSysId = "";
	//时间戳 后面的5*60=5分钟 表示期望在这个时间段内送达,一定要加一个时间差
	String timestamp = "";
	//签名
	String smKey = "";
	//用户帐号
	String suserAccount = "";
	//返回码
	String sretCode = "999";
	//响应数据
	java.lang.StringBuilder sbRes = new java.lang.StringBuilder();
	sbRes.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
	sbRes.append("<ResponseData>");
	sbRes.append("<clickSysId>%s</clickSysId>");
	sbRes.append("<userAccount>%s</userAccount>");
	sbRes.append("<retCode>%s</retCode>");
	sbRes.append("<mKey>%s</mKey>");
	sbRes.append("<timestamp>%s</timestamp>");
	sbRes.append("</ResponseData>");
	String sResXml = sbRes.toString();
	try {
		//首先判断ip信任来源, AuthIp方法第三方来实现
		String sIP = MD5.GetRequestIP(request);
		boolean bAuthIp = AuthIp(sIP);
		if (!bAuthIp) {
			//ip来源非法
			sretCode = "102";
		} else {
			//获取请求包
			InputStream isReq = request.getInputStream();
			sReqXml = MD5.inputStream2String(isReq);
			//开始解析XML
			javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream in = new ByteArrayInputStream(sReqXml.getBytes());
			Document doc = db.parse(in);
			Element root = doc.getDocumentElement();
			sClickSysId = (root.getElementsByTagName("clickSysId") == null) ? ""
					: root.getElementsByTagName("clickSysId").item(0)
							.getFirstChild().getNodeValue();
			suserAccount = (root.getElementsByTagName("userAccount") == null) ? ""
					: root.getElementsByTagName("userAccount").item(0)
							.getFirstChild().getNodeValue();
			String spassword = (root.getElementsByTagName("password") == null) ? ""
					: root.getElementsByTagName("password").item(0)
							.getFirstChild().getNodeValue();
			String snickName = (root.getElementsByTagName("nickName") == null) ? ""
					: root.getElementsByTagName("nickName").item(0)
							.getFirstChild().getNodeValue();
			String suserMail = (root.getElementsByTagName("userMail") == null) ? ""
					: root.getElementsByTagName("userMail").item(0)
							.getFirstChild().getNodeValue();
			String strueName = (root.getElementsByTagName("trueName") == null) ? ""
					: ((root.getElementsByTagName("trueName").item(0)
							.getFirstChild() == null) ? "" : root
							.getElementsByTagName("trueName").item(0)
							.getFirstChild().getNodeValue());
			smKey = (root.getElementsByTagName("mKey") == null) ? ""
					: root.getElementsByTagName("mKey").item(0)
							.getFirstChild().getNodeValue();
			timestamp = (root.getElementsByTagName("timestamp") == null) ? ""
					: root.getElementsByTagName("timestamp").item(0)
							.getFirstChild().getNodeValue();
			//时间戳是否过期
			if (Long.valueOf(timestamp).longValue() < ((System
					.currentTimeMillis() - (new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
					.getTime())) / 1000)) {
				//时间戳过期
				sretCode = "104";
			} else {
				//拼串加密的的明文
				java.lang.StringBuilder sbMD5ProclaimedText = new java.lang.StringBuilder();
				sbMD5ProclaimedText.append(sClickSysId);
				sbMD5ProclaimedText.append(suserAccount);
				sbMD5ProclaimedText.append(spassword);
				sbMD5ProclaimedText.append(snickName);
				sbMD5ProclaimedText.append(suserMail);
				sbMD5ProclaimedText.append(strueName);
				sbMD5ProclaimedText.append(timestamp);
				sbMD5ProclaimedText.append(sMD5Key);
				String sMD5ProclaimedText = MD5.MD5Encode(sbMD5ProclaimedText
						.toString());
				//签名是否合法
				if (!smKey.equals(sMD5ProclaimedText)) {
					//签名不合法
					sretCode = "006";
				} else {
					//其它信息验证:这里省略验证方面包含密码,帐号是否重复在第三方站点等,然后在第三方站点生成用户帐号信息,全部验证通过后执行下面
					//...................
					//执行成功
					sretCode = "000";
				}
			}
		}
	} catch (Exception ex) {
		//写错我日志 log.error(ex); //包括错误日志和请求获取的数据包方便定位
		System.out.println(ex.getMessage());
	}
	//时间戳 后面的5*60=5分钟 表示期望在这个时间段内送达,一定要加一个时间差
	timestamp = String
			.valueOf((System.currentTimeMillis() - (new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
					.getTime())) / 1000 + 5 * 60);
	//拼串加密的的明文
	java.lang.StringBuilder sbMD5ProclaimedText = new java.lang.StringBuilder();
	sbMD5ProclaimedText.append(sClickSysId);
	sbMD5ProclaimedText.append(suserAccount);
	sbMD5ProclaimedText.append(sretCode);
	sbMD5ProclaimedText.append(timestamp);
	sbMD5ProclaimedText.append(sMD5Key);
	//签名
	smKey = MD5.MD5Encode(sbMD5ProclaimedText.toString());
	//响应包
	sResXml = String.format(sResXml, sClickSysId, suserAccount,
			sretCode, smKey, timestamp);
	//输出响应包
	response.setContentType("text/xml;charset=GB2312");
	response.getWriter().write(sResXml);
	response.flushBuffer();
%>
