package org.sky.x;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.sky.x.security.Base64Encode;

public class GenerateSign {

	private static final String HMAC_SHA1 = "HmacSHA1";

	private static final String UTF8 = "UTF8";

	public static String getSign(byte[] data, byte[] key) {
		SecretKeySpec sigKey = new SecretKeySpec(key, HMAC_SHA1);
		Mac mac;
		try {
			mac = Mac.getInstance(HMAC_SHA1);
			mac.init(sigKey);
			byte[] rawHmac = mac.doFinal(data);
			return Base64Encode.encode(rawHmac);
		} catch (Exception e) {
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		String method = "GET";
		String uri = URLEncoder.encode("/cp/game/getGameList", UTF8);
		String paramSorted = URLEncoder.encode("openid=C0ADC274E6C14C3D&type=0", UTF8);
		String openKey = "3bd188ba37ebe8723&";
		String source = method + "&" + uri + "&" + paramSorted;
		System.out.println("source=" + source);
		String sign = getSign(source.getBytes(), openKey.getBytes());
		System.out.println("HmacSHA1=" + sign);
		System.out.println("Base64Util=" + Base64Encode.encodeString(sign, UTF8));
	}
}
