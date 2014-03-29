package org.sky.x.number;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sky.x.string.StrUtil;

/**
 * <p>标题： BigDecimal工具类</p>
 * <p>功能： 类型转换 </p>
 * @author 李豪
 * @version 1.0
 */
public class BigUtil{
	public static final BigDecimal	HUNDRED			= new BigDecimal("100.0");
	public static final BigDecimal	ZeroBigDecmail	= BigDecimal.ZERO;
	public static final BigDecimal	OneBigDecmail	= BigDecimal.ONE;

	/**
	 * Object转换为BigDecimal
	 * @param o
	 * @return 转换后的BigDecimal对象
	 */
	public static BigDecimal obj2big(Object o){
		try{
			if (o instanceof BigDecimal)
				return (BigDecimal) o;
			if (o == null)
				return BigDecimal.ZERO;
			if (o instanceof Number){
				if (o instanceof java.math.BigInteger)
					return new BigDecimal(((java.math.BigInteger) o).toString());
				if(  o instanceof Integer || o instanceof Long  || o instanceof Short || o instanceof Byte )
					return BigDecimal.valueOf(((Number)o).longValue());
				/*if (o instanceof Double || o instanceof Float)//这里是不应该的，否则1000.40会变成1000.3999999999999772626324556767940521240234375
					return new BigDecimal(((Number) o).doubleValue());*/
				return new BigDecimal(((Number) o).toString());
			}
			if (o instanceof String){
				//String temp = obj2str(o);
				String temp = StrUtil.obj2str(o);
				if (temp != null){
					temp = temp.trim();
					if (temp.length() == 0 || temp.equalsIgnoreCase("null")){
						return BigDecimal.ZERO;
					} else{
						return new BigDecimal(temp);
					}
				}
			}
			return new BigDecimal(o.toString());
		} catch (Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * 将big数值设置固定的小数位转化成字符串返回。
	 * 1.如果big为空，则返回空；
	 * 2.如果小数位小于零，则直接处理数值的字符串形式，否则设置数值的小数位；
	 * 3.如果不过滤末尾零，则直接返回，否则删除末尾零；
	 * @param num 数值
	 * @param scale 小数位
	 * @param thDel 是否添加千分位分隔符
	 * @param delZero 是否删除小数部分的末尾的零
	 * @return 结果字符串
	 */
	public static String toDecStr(Number num, int scale, boolean thDel, boolean delZero){
		if (num == null)
			return null;
		String str = scale < 0 ? num.toString() : String.format("%1$." + scale + "f", num);
		StringBuilder sb = new StringBuilder(str);
		int dotIdx = str.indexOf('.');
		// 千分位
		if (thDel && (dotIdx > 3 || dotIdx < 0))
			for (int idx = dotIdx > 0 ? dotIdx - 3 : str.length() - 3; idx > 0; idx -= 3){
				sb.insert(idx, ',');
			}
		// 删除尾零
		if (delZero && dotIdx > -1 && str.endsWith("0"))
			for (int idx = sb.length() - 1; idx > -1; idx--){
				char ch = sb.charAt(idx);
				if (ch == '0')
					sb.deleteCharAt(idx);
				else if (ch == '.'){
					sb.deleteCharAt(idx);
					break;
				} else
					break;
			}
		return sb.toString();
	}
	/**
	 * 两数之和
	 * @param o1
	 * @param o2
	 * @return 两数之和的结果
	 */
	public static BigDecimal add(Object o1, Object o2){
		return obj2big(o1).add(obj2big(o2));
	}
	/**
	 * 两数之差
	 * @param o1
	 * @param o2
	 * @return 两数之差的结果
	 */
	public static BigDecimal subtract(Object o1, Object o2){
		return obj2big(o1).subtract(obj2big(o2));
	}
	/**
	 * 两数乘积
	 * @param o1
	 * @param o2
	 * @return 两数乘积的结果
	 */
	public static BigDecimal multiply(Object o1, Object o2){
		return BigUtil.obj2big(o1).multiply(BigUtil.obj2big(o2));
	}
	/**
	 * 两数相除
	 * @param o1
	 * @param o2
	 * @param scale
	 * @param roundingMode
	 * @return 两数相除的结果
	 */
	public static BigDecimal divide(Object o1, Object o2, int scale, int roundingMode){
		return obj2big(o1).divide(obj2big(o2), scale, roundingMode);
	}
	/**
	 * 两数相除
	 * @param o1
	 * @param o2
	 * @return 两数相除的结果
	 */
	public static BigDecimal divideRoundHalfUp(Object o1, Object o2){
		return obj2big(o1).divide(obj2big(o2), 2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 用辗转相除法求取两个数之间的最大公约数,两个整数才有意义
	 * @param o1
	 * @param o2
	 * @return 最大公约数
	 */
	public static BigDecimal getCommonDenominator(Object o1, Object o2){
		BigDecimal b1 = BigUtil.obj2big(o1);
		BigDecimal b2 = BigUtil.obj2big(o2);
		if (b1.compareTo(BigDecimal.ONE) > 0 && b2.compareTo(BigDecimal.ONE) > 0){
			while (true){
				if (b1.compareTo(b2) >= 0){
					b1 = b1.subtract(b2);
				}
				if (b1.compareTo(b2) <= 0){
					b2 = b2.subtract(b1);
				}
				if (b1.compareTo(BigDecimal.ZERO) == 0){
					return b2;
				}
				if (b2.compareTo(BigDecimal.ZERO) == 0){
					return b1;
				}
			}
		}
		return BigDecimal.ONE;
	}
	/**
	 * 从第一个不为零的开始，到下一个不为零的为止，将之间的认为是数值进行解析；
	 * @param numStr 源字符串
	 * @return 解析成功后的数字结果
	 */
	public static BigDecimal parse(String numStr){
		if (numStr == null)
			return ZeroBigDecmail;
		Pattern ptn = Pattern.compile("\\d+(\\.\\d+)*");
		Matcher m = ptn.matcher(numStr);
		if (m.find()){
			String grp = m.group();
			return obj2big(grp);
		}
		return ZeroBigDecmail;
	}
	
	/**
	 * 采用StrUtil.obj2str 代替<br/><br/>
	 * 把对象转换为字符串输出，该对象建议实现toString()方法
	 * 示例：StrUtil.obj2str("abc"); 结果：abc
	 * @param text 要转换的对象
	 * @return 转换为的字符串
	
	@Deprecated
	public static final String obj2str(Object text){
		return text != null ? text.toString() : null;
	} */
}