package org.sky.x.algorithm.md5;

import java.security.MessageDigest;

//字符串转换成MD5编码
public class SecurityMD5 {
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7","8", "9", "a", "b", "c", "d", "e", "f"};

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
	    for (int i = 0; i < b.length; i++) {
	      resultSb.append(byteToHexString(b[i]));
	    }
	    return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
	    if (n < 0){
	    	n = 256 + n;
	    }
	    int d1 = n / 16;
	    int d2 = n % 16;
	    return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String password) throws Exception {
		if(null == password){
			password = "";
		}
		MessageDigest md = MessageDigest.getInstance("MD5");
		return byteArrayToHexString(md.digest(password.getBytes()));
	}
	
	public static String testMD5Encode(String password, Integer channelId) {
		String md5Password = "";
		try {
			if (XIU_GROUP == channelId || GROUP_GOODS == channelId) {
				md5Password = MD5Encode(password + PASSWORD_MIX);// 秀团和团货的加密
			} else {
				md5Password = MD5Encode(password);// 官网及别的渠道加密
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return md5Password;
	}
	
	/**
	 * 秀团，团货MD5加密时的混入值
	 */
	private static final String PASSWORD_MIX = "@4!@#$%@";
	
	/**
	 * 11:官网 12：秀团 13：团货 15：分销
	 */
	private static final int XIU_OFFICIAL = 11;
	private static final int XIU_GROUP = 12;
	private static final int GROUP_GOODS = 13;
	private static final int PART_SELL = 15; 
	
	
	public static void main(String[] args) {
		
		System.out.println("testMD5Encode('123456',11)="+testMD5Encode("123456",Integer.valueOf(11)));
		System.out.println("testMD5Encode('302302',11)="+testMD5Encode("302302",Integer.valueOf(11)));
		System.out.println("testMD5Encode('111111',11)="+testMD5Encode("111111",Integer.valueOf(11)));
		System.out.println("testMD5Encode('888888',11)="+testMD5Encode("888888",Integer.valueOf(11)));
		System.out.println("testMD5Encode('5201314',11)="+testMD5Encode("5201314",Integer.valueOf(11)));
		
		System.out.println("testMD5Encode('123456',12)="+testMD5Encode("123456",Integer.valueOf(12)));
		System.out.println("testMD5Encode('302302',12)="+testMD5Encode("302302",Integer.valueOf(12)));
		System.out.println("testMD5Encode('111111',12)="+testMD5Encode("111111",Integer.valueOf(12)));
		System.out.println("testMD5Encode('888888',12)="+testMD5Encode("888888",Integer.valueOf(12)));
		System.out.println("testMD5Encode('5201314',12)="+testMD5Encode("5201314",Integer.valueOf(12)));
		
	}
}
