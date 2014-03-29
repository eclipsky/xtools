package org.sky.x.string;

import java.math.BigDecimal;

import org.sky.x.date.DateUtil;
import org.sky.x.number.BigUtil;

/**
 * @version 1.0 将数字、金额、日期等写成中英文大写的相关工具 
 * http://emuch.net/html/200604/237158.html
 */
public class CapitalUtil {
	private CapitalUtil() {}

	private static final String[] digEngCapitalWord = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
	
	/**
	 * 将x转化成中文大写
	 * @param x
	 * @return 转化后结果
	 */
	public static final String toChnCapital(int x) {
		return toChnCapital((long) x);
	}
	/**
	 * 将x转化成中文大写
	 * @param x
	 * @return 转化后结果
	 */
	public static final String toChnCapital(long x) {
		return toCapitalWord(x, false, new String[] { "", "拾", "佰", "仟" }, new String[] { "", "万", "亿", "万亿", "亿亿" });
	}
	/**
	 * 将x转化成英文大写
	 * @param x
	 * @return 转化后结果
	 */
	public static final String toEngCapital(int x) {
		return toEngCapital((long) x);
	}
	/**
	 * 将x转化成英文大写
	 * @param x
	 * @return 转化后结果
	 */
	public static final String toEngCapital(long x) {
		return toCapitalWord(x, true, null, new String[] {""," THOUSAND "," MILLION "," BILLION "});
	}
	private static final String toCapitalWord(long x, boolean eng,String[] grp1CapitalWord, String[] grp2CapitalWord) {
		int ndigits1 = eng ? 3 : grp1CapitalWord.length;
		int ndigits2 = grp2CapitalWord.length;
		int nmax1 = 1;
		for (int i = 0; i < ndigits1; i++)
			nmax1 *= 10;
		boolean zero = false;
		String text = "";
		int y0, y = 0;
		for (int i = 0; i < ndigits2 && x != 0; i++) {
			y0 = y;
			y = (int) (x % (long) nmax1);
			x = x / (long) nmax1;
			if (!zero)
				zero = text.length() > 0
						&& (y0 < nmax1 / 10 || (y > 0 && y % 10 == 0));
			if (y != 0) {
				String s = eng ? toEngCapitalWord3(y) + grp2CapitalWord[i]
						: toChnCapital((int) y, grp1CapitalWord)
								+ grp2CapitalWord[i];
				String link = zero && !eng ? "零" : "";
				/*
				 * 加 y0<100
				 * CapitalUtil.toCyEngCapital(11111)
				 * 输出ELEVEN THOUSAND AND ONE HUNDRED AND ELEVEN ONLY 
				 *   有ELEVEN THOUSAND     ONE HUNDRED AND ELEVEN ONLY才是正确的
				 */
				if (eng && text.length() > 0 && y0 < 100)
					link = " AND ";
				text = s + link + text;
				zero = false;
			}
		}
		return text;
	}
	private static final String toChnCapital(int x, String grpCapitalWord[]) {
		int ndigits = grpCapitalWord.length;
		boolean zero = false;
		String text = "";
		for (int i = 0; i < ndigits; i++) {
			int y = x % 10;
			x = x / 10;
			if (y == 0)
				zero = text.length() > 0;
			else{// y>0
				String s = "零壹贰叁肆伍陆柒捌玖".charAt(y) + grpCapitalWord[i]; // "零壹贰叁肆伍陆柒捌玖" + "仟佰拾"
				if (zero)
					text = s + "零" + text;
				else
					text = s + text;
				zero = false;
			}
		}
		return text;
	}
	
	/**
	 * 将value转化成中文汉字的表示方式,进保留两位小数点且四舍五入
	 * @param value
	 * @return 转化后结果
	 */
	public static final String toCyChnCapital(double value){
		return toCyChnCapital(Double.valueOf(value));
	}
	/**
	 * 将value转化成中文汉字的表示方式,进保留两位小数点且四舍五入
	 * @param value
	 * @return 转化后结果
	 */
	public static final String toCyChnCapital(Number value) {
		return toCyCapital(value, false);
	}
	/**
	 * 将value转化成英文的金额表示,进保留两位小数点且四舍五入
	 * @param value
	 * @return 转化后结果
	 */
	public static final String toCyEngCapital(Number value) {
		return toCyCapital(value, true);
	}
	/**
	 * 将value转化成英文的金额表示,进保留两位小数点且四舍五入<br/>
	 * CapitalUtil.toCyEngCapital(11111)输出ELEVEN THOUSAND ONE HUNDRED AND ELEVEN ONLY
	 * @param value
	 * @return 转化后结果
	 */
	public static final String toCyEngCapital(double value) {
		return toCyCapital(Double.valueOf(value), true);
	}
	/**
	 * 将numberValue转化成英文或者中文汉字的金额,进保留两位小数点且四舍五入
	 * @param numberValue
	 * @param eng	是否是英文形式
	 * @return 转化后结果
	 */
	public static final String toCyCapital(Number numberValue, boolean eng) {
		if (numberValue == null)
			return null;
		BigDecimal value = BigUtil.obj2big(numberValue);
		int signum = value.signum();
		if (signum < 0)
			value = value.negate();
		if (value.scale() > 2)
			value = value.setScale(2, BigDecimal.ROUND_HALF_UP);
		long x = value.movePointRight(2).longValue();
		long y = x / 100;
		String text = eng ? toEngCapital(y) : toChnCapital(y);
		if (text.length() > 0 && !eng)
			text += "元";
		int xdd = (int) (x % 100), xxd = xdd % 10, xdx = xdd / 10;
		if(!eng){
			if(xdd != 0 && y != 0 && (xdx == 0 || y % 10 == 0))
				text += "零";
			if(xdx != 0)
				text += "零壹贰叁肆伍陆柒捌玖".charAt(xdx) + "角";
			if(xxd != 0)
				text += "零壹贰叁肆伍陆柒捌玖".charAt(xxd) + "分";
			if(text.length() == 0)
				text = "零元";
			if(xxd == 0)
				text += "整";
		}else{//eng
			if(xdd != 0) {
				if(text.length() > 0)
					text += " AND ";
				text += "CENTS " + toEngCapitalWord3(xdd);
			}else if(text.length() == 0)
				text = "ZERO ONLY";
			else
				text += " ONLY";
		}
		return text;
	}
	private static final String toEngCapitalWord3(int x) {
		String s2 = toEngCapitalWord2(x % 100);
		int x3 = x / 100;
		String s1 = "";
		if (x3 > 0)
			s1 = digEngCapitalWord[x3] + " HUNDRED";
		if (s1.length() > 0 && s2.length() > 0)
			return s1 + " AND " + s2;
		return s1 + s2;
	}
	private static final String toEngCapitalWord2(int x) {
		if (x == 0)
			return "";
		if (x < 10)
			return digEngCapitalWord[x];
		if (x < 20) {
			String s[] = { "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN",
					"FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
			return s[x - 10];
		}
		String s[] = { "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY",
				"SEVENTY", "EIGHTY", "NINETY" };
		return s[x / 10 - 2]
				+ ((x % 10 == 0) ? "" : " " + digEngCapitalWord[x % 10]);
	}
	/**
	 * 将value转化成中文汉字
	 * @param value
	 * @return 转化后结果
	 */
	public static final String toChnCapital(double value) {
		return toCapital(Double.valueOf(value), false);
	}
	/**
	 * 将value转化成中文汉字或者英文方式<br/>
	 * 如 1001.00翻译出来的句子为‘ONE THOUSAND  AND ONE ONLY’<br/>
	 * 1001.40为'ONE THOUSAND  AND ONE POINT FOUR'或‘壹仟零壹点肆’
	 * @param numberValue
	 * @param eng	是否为英文
	 * @return 转化后结果
	 */
	public static final String toCapital(Number numberValue, boolean eng) {
		if (numberValue == null)
			return null;
		//BigDecimal value = Data.toBigDecimal(numberValue);
		BigDecimal value = BigUtil.obj2big(numberValue);
		int signum = value.signum();
		if (signum < 0)
			value = value.negate();
		long x = value.longValue();
		String text = eng ? toEngCapital(x) : toChnCapital(x);
		String s = value.toString();
		int p = s.indexOf('.');
		if (p < 0 || p >= s.length() - 1)
			return text;
		if (text.length() == 0)
			text = eng ? "ZERO" : "零";
		if (isZero(s, p + 1, s.length())) {
			if (eng) {
				return text + " ONLY";
			}
		}
		/*if (eng && mode == 1) {
			String s2 = s.substring(p + 1);
			if (s2.length() < 2)
				s2 += "00".substring(0, 2 - s2.length());
			return text + " CENTS " + toEngCapital(Long.parseLong(s2));
		}*/
		text += eng ? " POINT" : "点";
		for (; p < s.length() - 1;) {
			p++;
			int d = s.charAt(p) - '0';
			if (eng)
				text += " " + digEngCapitalWord[d];
			else
				text += "零壹贰叁肆伍陆柒捌玖".charAt(d);
		}
		return text;
	}
	static boolean isZero(String text, int from, int end) {
		if (text == null)
			return true;
		if (end > text.length())
			end = text.length();
		for (; from < end; from++) {
			if (text.charAt(from) != '0')
				return false;
		}
		return true;
	}

	/**
	 * 将x转化成汉字(零一二)形式
	 * @param x
	 * @return 转化后结果
	 */
	public static final String toDigitChnCapital(long x) {
		return toDigitChnCapital(x, 0);
	}
	/**
	 * 将x转化成汉字(零一二)形式
	 * @param x
	 * @return 转化后结果
	 */
	public static final String toDigitChnCapital(int x) {
		return toDigitChnCapital((long) x, 0);
	}
	/**
	 * 将x转化成汉字(零一二)或汉字大写(零壹贰)形式
	 * @param x
	 * @param mode 0 代表汉字,其他情况
	 * @return 转化后结果
	 */
	public static final String toDigitChnCapital(int x, int mode) {
		return toDigitChnCapital((long) x, mode);
	}
	/**
	 * 将x转化成汉字(零一二)或汉字大写(零壹贰)形式
	 * @param x	
	 * @param mode 0 代表汉字,其他情况
 	 * @return 转化后结果
	 */
	public static final String toDigitChnCapital(long x, int mode) {
		boolean neg;
		if (neg = x < 0)
			x = -x;
		String a = mode == 0 ? "零一二三四五六七八九" : "零壹贰叁肆伍陆柒捌玖";
		String s = "" + a.charAt(((int) x % 10));
		x = x / 10;
		for (; x != 0;) {
			s = a.charAt(((int) x % 10)) + s;
			x = x / 10;
		}
		if (neg)
			s = "-" + s;
		return s;
	}
	

	/**
	 * 采用DateUtil.toChnCapital代替<br/><br/>
	 * @param date
	 * @return 转化后结果
	 */
	@Deprecated
	public static final String toChnCapital(java.util.Date date) {
		return DateUtil.toChnCapital(date);
	}
	
	/**
	 * 采用DateUtil.dateToEnglishString代替<br/><br/>
	 * @param date
	 * @return 转化后结果
	 */
	@Deprecated
	public static final String toEngCapital(java.util.Date date) {
		return DateUtil.dateToEnglishString(date);
	}
}