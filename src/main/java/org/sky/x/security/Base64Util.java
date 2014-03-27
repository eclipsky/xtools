package org.sky.x.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Base64Util {

	/**
	 * 使用Base64算法加密解密
	 * 
	 * @param text
	 * @param isEncode
	 *            true为加密,false为解密
	 * @return 加/解密后的字符串
	 */
	public static String convertPasswordString(String text, boolean isEncode) {
		if (text == null || text.length() == 0)
			return text;
		if (isEncode) {
			Base64Encode os = null;
			String str = null;
			try {
				os = new Base64Encode();
				byte ba[] = text.getBytes();
				for (int i = 0; i < ba.length; i++)
					ba[i] ^= 0x13;
				os.write(ba);
				os.close();
			} catch (IOException e) {
				throw new RuntimeException("Can't convertPasswordString:"
						+ text);
			} finally {
				try {
					if (os != null)
						str = "`" + os.getAsString() + "`";
				} catch (IOException e) {
					throw new RuntimeException("Can't convertPasswordString:"
							+ e.getMessage());
				}
			}
			return str;
		} else {
			int ltext = text.length();
			if (ltext >= 2 && text.charAt(0) == '`'
					&& text.charAt(ltext - 1) == '`') {
				String str = null;
				ByteArrayOutputStream os = null;
				Base64Decode is = null;
				try {
					is = new Base64Decode(text.substring(1, ltext - 1));
					os = new ByteArrayOutputStream();
					/*
					 * for (;;) { int c = is.read(); if (c <= 0) break;
					 * os.write(c ^ 0x13); }
					 */
					int c = is.read();
					while (c > 0) {
						os.write(c ^ 0x13);
						c = is.read();
					}
				} catch (IOException e) {
					throw new RuntimeException("Can't convertPasswordString:"
							+ e.getMessage());
				} finally {
					if (os != null)
						str = new String(os.toByteArray());
					try {
						if (is != null)
							is.close();
					} catch (IOException e) {
						throw new RuntimeException(
								"Can't convertPasswordString:" + e.getMessage());
					}
					try {
						if (os != null)
							os.close();
					} catch (IOException e) {
						throw new RuntimeException(
								"Can't convertPasswordString:" + e.getMessage());
					}
				}
				return str;
			}
		}
		return text;
	}
}
