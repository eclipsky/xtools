<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.security.*,java.io.*,java.util.*,org.w3c.dom.*"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="com.algorithm.md5.MD5"%>
<%
//**********************登录接口及确认使用接口************************
 %>
<%!/// <summary>
	/// 确认使用
	/// </summary>
	/// <returns></returns>
	public boolean ConfirmUser(String md5Key, String clickSysId,String userAccount, String retCode) {
		try {
			java.lang.StringBuilder sbReq = new java.lang.StringBuilder();
			sbReq.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			sbReq.append("<RequestData>");
			sbReq.append("<clickSysId>%s</clickSysId>");
			sbReq.append("<userAccount>%s</userAccount>");
			sbReq.append("<retCode>%s</retCode>");
			sbReq.append("<mKey>%s</mKey>");
			sbReq.append("<timestamp>%s</timestamp>");
			sbReq.append("</RequestData>");
			String sReqXml = sbReq.toString();
			//时间戳 后面的5*60=5分钟 表示期望在这个时间段内送达,一定要加一个时间差
			String stimestamp = String
					.valueOf((System.currentTimeMillis() - (new java.text.SimpleDateFormat(
							"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
							.getTime())) / 1000 + 5 * 60);
			//拼串加密的的明文
			java.lang.StringBuilder sbMD5ProclaimedText = new java.lang.StringBuilder();
			sbMD5ProclaimedText.append(clickSysId);
			sbMD5ProclaimedText.append(userAccount);
			sbMD5ProclaimedText.append(retCode);
			sbMD5ProclaimedText.append(stimestamp);
			sbMD5ProclaimedText.append(md5Key);
			//签名
			String smKey = MD5.MD5Encode(sbMD5ProclaimedText.toString());
			//请求包
			sReqXml = String.format(sReqXml, clickSysId, userAccount, retCode,smKey, stimestamp);
			System.out.println(sReqXml);
			String sResponse = MD5.PostRequest(sReqXml,"http://sq.mail.10086.cn/webapi/ConfirmAPI.aspx");
			System.out.println(sResponse);
			if (sResponse != null && !("".equals(sResponse))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}%>
<%
	//md5加密密钥
	String sMD5Key = "YNMD5";
	//合作商id
	String sClickSysId = request.getParameter("clickSysId");
	//登录用户帐号
	String suserAccount = request.getParameter("userAccount");
	//转向Url类型
	String rType = request.getParameter("rType");
	rType = (rType == null) ? "" : rType;
	//转向url
	String rUrl = request.getParameter("rUrl");
	rUrl = (rUrl == null) ? "" : rUrl;
	//签名
	String smkey = request.getParameter("mKey");
	//时间戳
	String timestamp = request.getParameter("timestamp");
	//返回码
	String sretCode = "999";
	try {
		//时间戳是否过期
		if (Long.valueOf(timestamp).longValue() < ((System
				.currentTimeMillis() - (new java.text.SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
				.getTime())) / 1000)) {
			//时间戳过期
			sretCode = "104";
			//调用确认使用接口,向139反馈信息
			ConfirmUser(sMD5Key, sClickSysId, suserAccount, sretCode);
			//针对时间戳过期,第三方站点需要终止其它处理
			//...................
		} else {
			//拼串加密的的明文
			String sencodeUrl = java.net.URLEncoder.encode(rUrl,
					"gb2312");
			java.lang.StringBuilder sbMD5ProclaimedText = new java.lang.StringBuilder();
			sbMD5ProclaimedText.append(sClickSysId);
			sbMD5ProclaimedText.append(suserAccount);
			sbMD5ProclaimedText.append(rType);
			sbMD5ProclaimedText.append(sencodeUrl);
			sbMD5ProclaimedText.append(timestamp);
			sbMD5ProclaimedText.append(sMD5Key);
			String sMD5ProclaimedText = MD5.MD5Encode(sbMD5ProclaimedText
					.toString());
			//签名是否合法
			if (!smkey.equals(sMD5ProclaimedText)) {
				//签名不合法
				sretCode = "006";
				//调用确认使用接口,向139反馈信息
				ConfirmUser(sMD5Key, sClickSysId, suserAccount,
						sretCode);
				//针对签名不合法,第三方站点需要终止其它处理
				//...................
			} else {
				//其它信息验证:这里省略验证全部验证通过后执行下面
				//执行成功
				sretCode = "000";
				//调用确认使用接口,向139反馈信息
				ConfirmUser(sMD5Key, sClickSysId, suserAccount,
						sretCode);
				//第三方站点根据自身需要进行其它业务逻辑处理,处理结束后,然后根据rUrl参数情况跳转到具体栏目
				//建议在转向前要验证下此url地址是否为本站点的地址,防止连接被盗用
				//...................
				//根据参数rType类型实现转向到具体的栏目,若rType为空或是0,那么可以直接转向;要是rType为1,那么根据rUrl找到具体商品地址
				System.out.println(rUrl);
				response.sendRedirect(rUrl);
			}
		}
	} catch (Exception ex) {
		//写错我日志 log.error(ex); //包括错误日志和请求获取的数据包方便定位
		//调用确认使用接口,向139反馈信息
		ConfirmUser(sMD5Key, sClickSysId, suserAccount, sretCode);
		//第三方站点根据异常情况进行处理
		//...................
		System.out.println(ex.getMessage());
	}
	System.out.println(sretCode);
%>