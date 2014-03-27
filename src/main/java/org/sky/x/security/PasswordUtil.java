package org.sky.x.security;

public class PasswordUtil {
	/**
	 * 使用base64加密
	 * @param str
	 * @return 加密后字符串
	 */
	public static String base64Encode(String str){
		return Base64Util.convertPasswordString(str, true);
	}
	/**
	 * 使用base64解密
	 * @param str
	 * @return 解密后字符串
	 */
	public static String base64Decode(String str){
		return Base64Util.convertPasswordString(str, false);
	}
	/**
	 * 验证base64加密解密正确性
	 * @param decodedStr
	 * @param encodedStr
	 * @return 正确则true,反之则为false
	 */
	public static boolean base64Verify(String decodedStr,String encodedStr){
		if(decodedStr==null || encodedStr==null) throw new RuntimeException("PwdUtil.base64Verify's argument is null");
		return base64Decode(encodedStr).equals(decodedStr);
	}
}
