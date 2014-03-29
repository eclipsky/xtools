<%@page language="java" contentType="text/xml; charset=GB2312" pageEncoding="GB2312"%>
<%@page import="java.security.*,java.io.*,java.util.*,org.w3c.dom.*"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="com.algorithm.md5.MD5"%>
<%@page import="java.lang.*"%>

<%!/// <summary>
	/// ��֤����ip��Դ�Ƿ�����
	/// </summary>
	/// <param name="ip"></param>
	/// <returns></returns>
	public static boolean AuthIp(String ip) {
		//�����߼�����֤ip�Ƿ�����,�������վ�����ҵ���߼�����
		//....................
		return true;
	}%>
<%
	//**********************ע��ӿ�************************
	//md5������Կ
	String sMD5Key = "YNMD5";
	//��������
	String sReqXml = "";
	//������ҵID
	String sClickSysId = "";
	//ʱ��� �����5*60=5���� ��ʾ���������ʱ������ʹ�,һ��Ҫ��һ��ʱ���
	String timestamp = "";
	//ǩ��
	String smKey = "";
	//�û��ʺ�
	String suserAccount = "";
	//������
	String sretCode = "999";
	//��Ӧ����
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
		//�����ж�ip������Դ, AuthIp������������ʵ��
		String sIP = MD5.GetRequestIP(request);
		boolean bAuthIp = AuthIp(sIP);
		if (!bAuthIp) {
			//ip��Դ�Ƿ�
			sretCode = "102";
		} else {
			//��ȡ�����
			InputStream isReq = request.getInputStream();
			sReqXml = MD5.inputStream2String(isReq);
			//��ʼ����XML
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
			//ʱ����Ƿ����
			if (Long.valueOf(timestamp).longValue() < ((System
					.currentTimeMillis() - (new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
					.getTime())) / 1000)) {
				//ʱ�������
				sretCode = "104";
			} else {
				//ƴ�����ܵĵ�����
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
				//ǩ���Ƿ�Ϸ�
				if (!smKey.equals(sMD5ProclaimedText)) {
					//ǩ�����Ϸ�
					sretCode = "006";
				} else {
					//������Ϣ��֤:����ʡ����֤�����������,�ʺ��Ƿ��ظ��ڵ�����վ���,Ȼ���ڵ�����վ�������û��ʺ���Ϣ,ȫ����֤ͨ����ִ������
					//...................
					//ִ�гɹ�
					sretCode = "000";
				}
			}
		}
	} catch (Exception ex) {
		//д������־ log.error(ex); //����������־�������ȡ�����ݰ����㶨λ
		System.out.println(ex.getMessage());
	}
	//ʱ��� �����5*60=5���� ��ʾ���������ʱ������ʹ�,һ��Ҫ��һ��ʱ���
	timestamp = String
			.valueOf((System.currentTimeMillis() - (new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00")
					.getTime())) / 1000 + 5 * 60);
	//ƴ�����ܵĵ�����
	java.lang.StringBuilder sbMD5ProclaimedText = new java.lang.StringBuilder();
	sbMD5ProclaimedText.append(sClickSysId);
	sbMD5ProclaimedText.append(suserAccount);
	sbMD5ProclaimedText.append(sretCode);
	sbMD5ProclaimedText.append(timestamp);
	sbMD5ProclaimedText.append(sMD5Key);
	//ǩ��
	smKey = MD5.MD5Encode(sbMD5ProclaimedText.toString());
	//��Ӧ��
	sResXml = String.format(sResXml, sClickSysId, suserAccount,
			sretCode, smKey, timestamp);
	//�����Ӧ��
	response.setContentType("text/xml;charset=GB2312");
	response.getWriter().write(sResXml);
	response.flushBuffer();
%>
