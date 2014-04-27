package org.sky.x.string;

import java.util.regex.Pattern;

/**
 * @author xieming  2013-10-15 обнГ05:46:45
 */
public class RegexDemo {
	public static void main(String[]args){
		String content = "fuck fck what's wron";
		String pStr = "^f.*n$";
		Pattern p = Pattern.compile(pStr);
		String pattern = Pattern.quote("adfagaeraf");
//		System.out.println(content.split(pStr)[0]);
		System.out.println(p.matches(pStr,content));
		System.out.println(p.flags());
		System.out.println(p.pattern());
		System.out.println(p.toString());
		System.out.println(p.quote(content));
		
	}
}
