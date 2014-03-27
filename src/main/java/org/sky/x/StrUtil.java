package org.sky.x;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.sky.x.date.DateUtil;

public class StrUtil {
	
	/**
	 * 判断是否为null或空白符或空字符串
	 * @param o
	 * @return 为空白则true,否则false
	 */
	public static boolean isBlack(Object o){
		if(o instanceof String){
			return StringUtils.isBlank((String)o);
		}else{
			return (o == null) ? true : StringUtils.isBlank(o.toString());
		}
	}
	
	/**
	 * 判断是否为null或空字符串
	 * @param o
	 * @return 为空则true,否则false
	 */
	public static boolean isEmpty(Object o){
		if(o instanceof String){
			return StringUtils.isEmpty((String)o);
		}else{
			return (o == null) ? true : StringUtils.isEmpty(o.toString());
		}
	}
	
	/**
	 * 将对象转化为字符串
	 * @param o
	 * @return 转化后字符串
	 */
	public static String obj2str(Object o){
		return o!=null ?  o.toString() : null;
	}
	
	public static final String toStr2(int x){
        //return x<10?"0"+x:""+x;
        return toString(x, 2);
    }
	
	/**
     * 将x转化为字符串,若x位数不够len则前缀加0
     * @param x
     * @param len
     * @return 转化后字符串
     */
    public static String toString(int x,int len){
    	String s = Integer.toString(x);
    	if( s.length()<len ){
    		int count = len - s.length();
    		StringBuffer strBuffer = new StringBuffer();
    		for(;count>0;count--)
    			strBuffer.append('0');
    		strBuffer.append(x);
    		return strBuffer.toString();
    	}
    	return s;	
    }
	
	/**
	 * 将obj转化为字符串,为空时返回defaultValue
	 * @param obj
	 * @param defaultValue
	 * @return 转化后字符串
	 */
	public static String obj2str(Object obj,String defaultValue){
		return obj!=null ?  obj.toString() : defaultValue;
	}
	
	/**
	 * 将Object数组的j下标的元素转化成int,不存在或为空时返回defaultValue
	 * @param o
	 * @param j
	 * @param defaultValue
	 * @return 转化后字符串
	 */
	public static final int obj2int(Object o[],int j,int defaultValue){
        if( o==null || j<0 || j>=o.length ) return defaultValue;
        return obj2int(o[j],defaultValue);
    }
	
	/**
	 * 讲一个Object数组转化成int数组
	 * @param o
	 * @param defaultValue
	 * @return 转化后数组
	 */
	public static final int[] obja2inta(Object[] o,int defaultValue){
        if( o==null ) return null;
        int a[] = new int[o.length];
        for(int i=0;i<o.length;i++) a[i] = obj2int(o[i],defaultValue);
        return a;
	}
	
	/**
	 * 将对象转化为int类型的数
	 * @param o
	 * @return 转化后int
	 */
	public static final int obj2int(Object o){
		return obj2int(o,0);
	}
	
	/**
	 * 从一个对象(Number,String)得到一个整数
	 * @param o Number,String类型的对象
	 * @param defaultValue
	 * @return 转化后int
	 */
	public static final int obj2int(Object o, int defaultValue) {
		if (o instanceof Number)
			return ((Number) o).intValue();
		if (o instanceof String) {
			String s = ((String) o).trim();
			try {
				return Integer.parseInt(s);
			} catch (Exception ex) {

			}
			try {
				return Double.valueOf(s).intValue();
			} catch (Exception ex) {

			}
		}
		return defaultValue;
	}
	
	/**
	 * 判断两个对象是否equals
	 * @param o1
	 * @param o2
	 * @return
	 */
	final public static boolean objEquals(Object o1, Object o2) {
		return o1 == o2 || (o1 != null && o1.equals(o2));
	}
	
	/**
	 * 取出一个字符串中左边(十进制的)数字部分. 
	 * 例如 getLeftDigit("234XYB34JH") 为 "234"
	 * @param str
	 * @param start
	 * @return 左边(十进制的)数字部分
	 */
	public static final String getLeftDigit(String str,int start){
		if(str==null)
			return null;
		str = str.trim();
		int l = str.length();  if(start>l) return null;
		int i;
		for( i=start;i<l;i++ )
		{
			char c = str.charAt(i);
			if( c<'0' || c>'9' ) break;
		}
		return  str.substring(start,i);
	}
	public static final String getLeftDigit(String str){
		return  getLeftDigit(str,0);
	}
	
	/**
	 * 将对象转化为boolean类型
	 * @param o
	 * @return 转化后boolean值
	 */
	public static final boolean obj2bool(Object o){
		return obj2bool(o,false);
	}
	/**
	 * 将对象转化为boolean类型
	 * @param o
	 * @param defaulValuet
	 * @return 转化后boolean值
	 */
	public static final boolean obj2bool(Object o, boolean defaulValuet) {
		if (o != null) {
			if (o instanceof Boolean) {
				return ((Boolean) o).booleanValue();
			}
			if (o instanceof String) {
				String s = (String) o;
				if (s.equalsIgnoreCase("true"))
					return true;
				if (s.equalsIgnoreCase("false"))
					return false;
			}
		}
		return defaulValuet;
	}
	
	/**
	 * 将对象转化为double
	 * @param o
	 * @return 转化后double值
	 */
	public static final double obj2double(Object o){
          return obj2double(o,0D);
	}
	/**
	 * 将对象转化为double
	 * @param o
	 * @param defaultValue
	 * @return 转化后double值
	 */
	public static final double obj2double(Object o, double defaultValue) {
		if (o instanceof Number)
			return ((Number) o).doubleValue();
		if (o instanceof String) {
			String s = ((String) o).trim();
			try {
				return Double.parseDouble(s);
			} catch (Exception ex) {
			}
		}
		return defaultValue;
	}
	/**
	 * 将对象转为为long
	 * @param o
	 * @return 转化后long值
	 */
	public static final long obj2long(Object o){
		return obj2long(o,0);
    }
	/**
	 * 将对象转为为long
	 * @param o
	 * @param defaultValue
	 * @return 转化后long值
	 */
	public static final long obj2long(Object o, int defaultValue) {
		if (o instanceof Number)
			return ((Number) o).longValue();
		if (o instanceof String) {
			String s = ((String) o).trim();
			try {
				return Long.parseLong(s);
			} catch (Exception ex) {
			}
			try {
				return Double.valueOf(s).longValue();
			} catch (Exception ex) {
			}
		}
		return defaultValue;
	}
	
	/**
	 * 将text转化成int<br/>
	 *  0x作为前缀的看成16进制, 0b作为前缀的看成二进制<br/>
	 *  例如  parseInt("0x1F")结果为 31, parseInt("0b1011011") 结果为 91
	 * @param text
	 * @return 转化后int值
	 */
	public static final int parseInt(String text){
		text = text.trim();
		int start = 0, base =10;
		if( text.startsWith("0x") || text.startsWith("0X") ){
			start = 2;  base = 16;
		}
		else if( text.startsWith("0b") || text.startsWith("0B") ){
			start = 2;  base = 2;
		}
		return Integer.parseInt(text.substring(start),base);
	}
	/**
	 * 将text转化成long<br/>
	 *  0x作为前缀的看成16进制, 0b作为前缀的看成二进制<br/>
	 *  例如  parseInt("0x1F") 结果为 31, parseInt("0b1011011") 结果为 91
	 * @param text
	 * @return 转化后long值
	 */
    public static final long parseLong(String text){
        text = text.trim();
        int start = 0, base =10;
        if( text.startsWith("0x") || text.startsWith("0X") ){
            start = 2;  base = 16;
        }
        else if( text.startsWith("0b") || text.startsWith("0B") ){
            start = 2;  base = 2;
        }
        return Long.parseLong(text.substring(start),base);
    }
	
	/**
	 * 获取一个UUID
	 * @return 新产生的UUID
	 */
	final public static String newUIID(){
		java.util.UUID uiid =  java.util.UUID.randomUUID();
		long mostSigBits = uiid.getMostSignificantBits();
		long leastSigBits = uiid.getLeastSignificantBits();
		return (digits(mostSigBits >> 32, 8) + //"-" +
				digits(mostSigBits >> 16, 4) + //"-" +
				digits(mostSigBits, 4) + //"-" +
				digits(leastSigBits >> 48, 4) + //"-" +
				digits(leastSigBits, 12)).toUpperCase();
    	
    }
    /** Returns val represented by the specified number of hex digits. */
    private static String digits(long val, int digits){
    	long hi = 1L << (digits * 4);
    	return Long.toHexString(hi | (val & (hi - 1))).substring(1);//.toUpperCase();
    }
    
    /**
     * str的首字母变大写
     * @param str
     * @return 首字母大写后的字符串
     */
    final public static String toUpper1(Object str){
    	String text=obj2str(str);
    	if( text==null || text.length()==0 )
    		return text;
    	char c = text.charAt(0);
    	if( c>='a' && c<='z' )
    		return Character.toString((char)(c+'A'-'a'))+text.substring(1);
    	return text;
    }
    
    /**
     * 获取将text按照charset编码获得数组后byteLimit长度范围内最多可有的那部分完整的字符串<br/>
     * 如 : "abc中de国"，编码为UTF8那么中文三个字节英文一个字节<br/>
     * byteLimit为3或<b>4</b>或者<b>5</b>则都返回‘abc’，为6返回‘abc中’，为7则‘abc中d’<br/>
     * @param text
     * @param byteLimit
     * @param charset
     * @return 截取后符合要求的字符串片段
     */
    public static String leftBytes(String text,final int byteLimit,String charset){
    	if(text==null) return null;
    	try {
    		final int n = text.length();
    		final int ls = text.getBytes(charset).length;
    		if( byteLimit>=ls )
    			return text;
    		int lenA[] = new int[n];
    		lenA[n-1] = ls;  int l = 0;
    		for(int i=0;i<n;i++){
    			lenA[i] = l += text.substring(i,i+1).getBytes(charset).length;
    		}
    		if( l!=ls ) // ASSERT
    			throw new RuntimeException();
    		int p = Arrays.binarySearch(lenA,byteLimit);
    		if( p<0 )
    			return text.substring(0,-(p+1));
    		else
    			return text.substring(0,p+1);
    	} catch( Throwable ex){
    		throw new RuntimeException(ex.getMessage());
    	}
    }
    
    /**
     * 将text所有的subtext的内容更换为replace内容<br/>
     * @param text
     * @param subtext
     * @param replace
     * @return 替换后的字符串
     */
    public static String replace(String text,String subtext,String replace){
        if( text==null || subtext==null || subtext.length()==0 || subtext.equals(replace) )
            return text;
        int p = text.indexOf(subtext);
        if( p<0 )
            return text;
        StringBuffer sb = new StringBuffer();
        for(;p>=0;)
        {
            sb.append(text.substring(0,p));
            if(replace!=null) sb.append(replace);
            text = text.substring(p+subtext.length());
            p = text.indexOf(subtext);
        }
        sb.append(text);
        return sb.toString();
    }
    
    /**
     * 若str是以prefix中其中任意一项开头的则返回匹配prefix项的下标,否则返回-1
     * StrUtil.startsWith(str, new String[]{"A","a"});
     * @param str
     * @param prefix
     * @return 匹配项的下标或者-1
     */
	public static int startsWith(String str, String... prefix) {
		if (str == null || prefix == null) return -1;
		for (int i = 0; i < prefix.length; i++) {
			if (str.startsWith(prefix[i])) return i;
		}
		return -1;
	}
	
	/**
	 * 判断字符串s在字符charBefore的前面部分是否全是纯数字
	 * @param s
	 * @param charBefore
	 * @param neg	是否允许负数
	 * @return 若全是数字则返回charBefore的下标,否则-1,可为0
	 */
	public static int startWithInt(String s,char charBefore,boolean neg){
		int p = s.indexOf(charBefore);
		if(p<=0)
			return p;
		int i = 0;
		if(neg && s.charAt(0)=='-') i++;
		for(;i<p;i++){
			char c = s.charAt(i);
			if(c<'0'||c>'9') return -1;
		}
		return p;
	}
	
	/**
	 * 将a转化成String数组
	 * @param a
	 * @return String数组
	 */
	public static String[] toStringArray(Object[] a){
    	if( a==null )
    		return null;
    	final int n = a.length;
    	String sa[] = new String[n];
    	for(int i=0;i<n;i++)
    		//sa[i] = a[i]==null ? null : a[i].toString();
    		sa[i] = obj2str(a[i]);
    	return sa;
    }
	
	/**
	 * 将一个reader流转换成字符串
	 * @param reader
	 * @return 流转后字符串
	 */
	public static String toString(java.io.Reader reader){
        StringBuffer sb = new StringBuffer();
        try {
			char buffer[] = new char[16*1024];
			int count = reader.read(buffer);
			while(count>0) {
				sb.append(buffer,0,count);
				count = reader.read(buffer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
        return sb.toString();
    }
	
	/**
     *  求两个字符数组的交集
     * @param a1   第一个字符数组
     * @param a2   第二个字符数组
     * @param mode  ==0: a1 与 a2 完全相同的元素, ==1: 考虑级次后的相同的元素
     * @return 数组的交集
     */
    public static String[] createIntersection(String a1[],String a2[],int mode){
        if(a1==null || a2==null ) return null;
        if(a1==a2) return a1;
        final java.util.List<String> v = new java.util.ArrayList<String>();
        createIntersection(a1,a2,mode,v,false);
        return v.toArray(new String[v.size()]);
    }
    /**
     * 求两个字符数组是否有交集
     * @param a1
     * @param a2
     * @param mode
     * @return 有交集返回true,否则返回false
     */
    public static boolean hasIntersection(String a1[],String a2[],int mode){
        if(a1==null || a2==null ) return false;
        if(a1==a2) return a1.length>0;
        java.util.List<String> v = new ArrayList<String>();
        createIntersection(a1,a2,mode,v,false);
        return v.size()>0;
    }
    static final private void createIntersection(String a1[],String a2[],int mode,java.util.List<String> v,boolean forHas){
        a1 = (String[])a1.clone();   Arrays.sort(a1);
        a2 = (String[])a2.clone();   Arrays.sort(a2);
        for(int i=0;i<a1.length;i++) {
            String s = a1[i];
            if( s!=null ) {
                int j = Arrays.binarySearch(a2,s);
                if( j<0 && mode==1 ) {
                    for(int l=s.length()-1;l>0;l--)
                        if( (j = Arrays.binarySearch(a2,s.substring(0,l)))>=0 )
                            break;
                }
                if( j>=0 ) {
                    v.add(s); if(forHas) return;
                }
            }
        }
        if( mode==1 ) for(int i=0;i<a2.length;i++){
                String s = a2[i];
                if( s==null ) continue;
                int j = -1;
                for(int l=s.length()-1;l>0;l--)
                    if( (j = Arrays.binarySearch(a1,s.substring(0,l)))>=0 )
                        break;
                if( j>=0 )
                    v.add(s);
                if(forHas) return;
            }
    }

	/**
	 * 将value用字符串表示
	 * @param value
	 * @param options bit 1: null to "" , 2 是否含千位分节符
	 * @return  value 的字符串表示
	 */
	public static String toDisplayString(Object value,int options){
		if( value==null )
			return (options&1)!=0 ? "" : null;
		if( value instanceof BigDecimal )
			return StrUtil.format((BigDecimal)value,2,((BigDecimal)value).scale(),(options&2)==0);
		if( value instanceof java.util.Date )
			return DateUtil.dateToString((java.util.Date)value);
		return value.toString();
	}
	
	/**
	 * 转化为通用的人民币习惯的表示方式
	 * @param x
	 * @return 人民币习惯的表示方式的字符串
	 */
	public static String rmbFormat(BigDecimal x){
		return format(x,2,2,true);
	}
	/**
	 *  将一个数值格式化指定小数位、可含千位分节符的字符串.例如:
	 *  将x转化为字符串显示,可指定千位分隔符和小数位(注意<b>五舍六入</b>)
	 *  <blockquote><pre>
	 *   StrUtil.format(-6789.004005, 2, 5, true);//-6,789.004
	 *    StrUtil.format(-6789.004006, 2, 5, true);//-6,789.00401
	 *   </pre></blockquote>
	 *   @param   x  被格式化的数值
	 *   @param   minDecimals  最小小数位
	 *   @param   maxDecimals  最大小数位
	 *   @param   groupingSeparator  是否含千位分节符
	 *   @return  格式化后的结果
	 */
	public static String format(double x,int minDecimals,int maxDecimals,boolean groupingSeparator){
		return format(new BigDecimal(x),minDecimals,maxDecimals,groupingSeparator);
	}
	public static String format(int x,int minDecimals,boolean groupingSeparator){
		return format(minDecimals<=0?Integer.toString(x):x+"."+StrUtil.newString('0',minDecimals),minDecimals,groupingSeparator);
	}
    public static String format(long x,int minDecimals,boolean groupingSeparator){
        return format(minDecimals<=0?Long.toString(x):x+"."+StrUtil.newString('0',minDecimals),minDecimals,groupingSeparator);
    }
    public static String format(long x,boolean groupingSeparator){
        return format(Long.toString(x),0,groupingSeparator);
    }
    /**
	 *  将一个数值格式化指定小数位、可含千位分节符的字符串.例如:
	 *  <blockquote><pre>
	 *    String text = Utilities.format(new BigDecimal("3451234.5"),2,4,true); //text为"3,451,234.50"
	 *    text = Utilities.format(new BigDecimal("3451234.55678"),2,4,true); //text为"3,451,234.5568"
	 *   </pre></blockquote>
	 *   @param   x  被格式化的数值
	 *   @param   minDecimals  最小小数位
	 *   @param   maxDecimals  最大小数位
	 *   @param   groupingSeparator  是否含千位分节符
	 *   @return  格式化后的结果
	 */
	public static String format(BigDecimal x, int minDecimals, int maxDecimals,boolean groupingSeparator) {
		if (x == null)
			return null;
		if (minDecimals < 0)
			minDecimals = 2;
		if (maxDecimals >= 0 && maxDecimals < x.scale())
			x = x.setScale(maxDecimals, BigDecimal.ROUND_HALF_UP);
		boolean neg = x.signum() < 0;
		if (neg)
			x = x.negate();
		int d = x.scale();
		String s = x.movePointRight(d).toString();
		if (maxDecimals > d) {
			s += newString('0', maxDecimals - d);
			d = maxDecimals;
		}
		int ls = s.length();
		if (ls > d)
			s = s.substring(0, ls - d) + '.' + s.substring(ls - d);
		else if (ls < d)
			s = "0." + newString('0', d - ls) + s;
		else
			s = "0." + s;
		return format(neg ? "-" + s : s, minDecimals, groupingSeparator);
	}
	final static String format(String str, int minDecimals,boolean groupingSeparator) {
		char tempBuf_64[] = new char[64];
		int n = str.length();
		int p = str.indexOf('.');
		if (p < 0)
			p = n;
		for (; n - 1 - p > minDecimals && n - 1 > p
				&& (str.charAt(n - 1) == '0'); n--)
			;
		if (n > 0 && str.charAt(n - 1) == '.')
			n--;
		int jBuf = 0;
		boolean neg = n > 0 && str.charAt(0) == '-';
		for (int i = 0; i < n; i++) {
			if (groupingSeparator && i > (neg ? 1 : 0) && i < p
					&& (p - i) % 3 == 0)
				tempBuf_64[jBuf++] = ',';
			tempBuf_64[jBuf++] = str.charAt(i);
		}
		return String.valueOf(tempBuf_64, 0, jBuf);
	}
    
    /**
	 * 格式化一个字符串. 被格式化的字符串中 %0,%1,... 作为参数将被替换.
	 * 例如
	 *  <blockquote><pre>
	 *    String parm[] = {"AAA","BBB","CCC"};
	 *    String text = format("xu%0+xv%1+%2",parm);
	 *     //  text 为 "xuAAA+xvBBB+CCC"
	 *   </pre></blockquote>
	 *   @param   fmt   格式
	 *   @param   parm  参数表, fmt中的%0被parm[0]替换,%1被parm[1]替换
	 *   @return  格式化后的字符串
	 */
	public static final String format(String fmt,Object... parm){
		StringBuffer r = new StringBuffer();
		int l = fmt.length();
		for(int i=0;i<l;){
			int p =  fmt.indexOf('%',i);
			if( p<i || p>=l-1 ){
				r.append( fmt.substring(i) ); break;
			}
			r .append( fmt.substring(i,p) );
			char c = fmt.charAt(p+1);
			if( c>='0' && c<='9' ){
				int j = c-'0';
                char c2;
                if( p+2<l && (c2=fmt.charAt(p+2))>='0' && c2<='9' ){
                    int j2 = j*10 + (c2-'0');
                    if( j2<parm.length ){
                        if( parm[j2]!=null )
                            r .append( parm[j2].toString() );
                        i = p+3;
                        continue;
                    }
                }
				if( j<parm.length && parm[j]!=null )
					r .append( parm[j].toString() );
				i = p+2;
			}
			else if(c=='%'){
				r .append( '%' );  i = p+2;
			}else{
				r .append( '%' );  i = p+1;
			}
		}
		return r.toString();
	}
	
    /**
	 * 将c重复count次组成新字符串
	 * @param c
	 * @param count
	 * @return 新生成字符串
	 */
    public static final String newString(char c,int count){
		StringBuffer strBuffer = new StringBuffer();
		for(;count>0;count--)
			strBuffer.append(c);
		return strBuffer.toString();
    }
    
    /**
     * 在text的before之前插入insert
     * @param text
     * @param insert
     * @param before
     * @return 新生成字符串
     */
    final public static String insertBeforeChar(String text,char insert,char before){
		if( text==null )
			return null;
		StringBuffer buffer = new StringBuffer();
		int l = text.length();
		for(int i=0;i<l;i++)
		{
			char c = text.charAt(i);
			if( c==before )
				buffer.append(insert);
			buffer.append(c);
		}
		return buffer.toString();
	}
    
    /**
     * 去掉text右边的空白字符
     * @param text
     * @return 去掉空白字符后的新字符串
     */
	public static final String trimRight(String text){
		if( text==null ) return null;
		int l = text.length();
		for(;l>0 && text.charAt(l-1)<=' ';l--)
			;
		return l==text.length() ? text : text.substring(0,l);
	}
	
	/**
	 * 将text1的右边空白字符串去除后河text2比较看是否相同
	 * @param text1
	 * @param text2
	 * @return 相同则true
	 */
    public static final boolean  equalsIgnorRightSpac(String text1,String text2){
        if( text1==text2 ) return true;
        if( text1==null || text2==null ) return false;
        return trimRight( text1 ).equals( text2 );
    }
    
    /**
     * 从arr中不区分大小写地查找o
     * @param arr
     * @param o
     * @return 若找到则返回o在arr中下标,否则返回-1
     */
	public static int findAtStringArrayIgnoreCase(String[] arr,String o){
		if( arr!=null )
		for(int i=0;i<arr.length;i++)
	        if(o==arr[i] || (o!=null && o.equalsIgnoreCase(arr[i]))) return i;
		return -1;
	}
    
	/**
	*  检查一个字符串中是否是一个有效的数值
	*  @param text  检查的字符串
	*  @param flags  位表示的检查选项  bit 1 : 可含'.' , bit 2 :可含',', bit 4 : 可为负, <br/>
	*  								bit 8 : 可为空串 , 16: 可以是范围(用‘..’连接)
	*  @return  true : 如果检查合法, false : 如果检查不合法
	*/
	public static boolean isValidNumber(String text,int flags){
		if(text==null) 
			return false;
		if( (flags&16)!=0 ){
			int p = text.indexOf("..");
			if( p>=0 ) {
				String text1 = text.substring(0,p).trim();
				String text2 = text.substring(p+2).trim();
				if( text1.length()==0 || text2.length()==0 )
					return false;
				return isValidNumber(text1,flags&~16) && isValidNumber(text2,flags&~16);
			}
		}
		int lText = text.length();
		int i = 0;
		for(;i<lText && text.charAt(i)<=' ';i++)
			;
		if( i==lText )  return (flags&8)!=0;
		if( text.charAt(i)=='-'){
			if((flags&4)==0 || ++i>=lText ) return false;
		}
		int ndig = 0;
		for(;i<lText;i++){
			char c = text.charAt(i);
			if( c>='0' && c<='9'){
				ndig++;  continue;
			}
			if( c==',' && (flags&2)!=0 )
				continue;
			break;
		}
		if( ndig==0 ) return false;
		if( i<lText && text.charAt(i)=='.' ){
			if( (flags&1)==0 ) return false;
			i++;
			for(;i<lText;i++){
				char c = text.charAt(i);
				if( c<'0' || c>'9')
					break;
			}
		}
		for(;i<lText && text.charAt(i)<=' ';i++)
			;
		return i==lText;
	}
	
	/**
	 *  判断一个字符串是否与一含通配符(*,?)的若干模式串(用逗号分开)中的一个通配(大小写敏感).
	 *  例如 like("123A45","1*B??,1*A??",true) 为true,  like("123A45","1*B??,1*A???",true) 为 false
	 *  @param text   被判断的字符串
	 *  @param patternlist  含通配符(*,?)的若干模式串(用逗号分开)
	 *  @return 是否通配, 如通配,返回 true, 否则 false
	*/
	/*public static boolean likeOneOf(String text,String pattern){
		return likeOneOf(text,pattern,false);
	}
	public static boolean likeOneOf(String text,String[] patternlist){
		return likeOneOf(text,patternlist,false);
	}*/
	public static boolean likeOneOf(String text,String... patternlist){
		if(patternlist.length==1 && patternlist[0].indexOf((int)',')>0)
			return likeOneOf(text,patternlist[0],false);
		else
			return likeOneOf(text,patternlist,false);
	}
	public static boolean likeOneOf(String text,String pattern,char deli){
		return likeOneOf(text,pattern,deli,(String)null,(String)null,false);
	}
	public static boolean likeOneOfN(String text,String patternlist[],boolean ignoreCase){
		return likeOneOfN(text,patternlist,null,null,ignoreCase);
	}
	public static boolean likeOneOfN(String text,String pattern,char deli,String patternPrifix,String patternSuffix,boolean ignoreCase){
        return likeOneOfN(text,splitString(pattern,deli),patternPrifix, patternSuffix,ignoreCase);
    }
    public static boolean likeOneOfN(String text,String patternlist[],String patternPrifix,String patternSuffix,boolean ignoreCase){
        if( patternPrifix==null ) patternPrifix = "";
        if( patternSuffix==null ) patternSuffix = "";
        boolean like = false;
        for(int i=0;i<patternlist.length;i++){
            String s = patternlist[i];  boolean k = true;
            if( s.length()>0 && s.charAt(0)=='~' ){
                k = false; s = s.substring(1);
            }
            if(like(text,0,patternPrifix+s+patternSuffix,0,ignoreCase)){
                like = k;
            }
        }
        return like;
    }
	/**
	 *  判断一个字符串是否与一含通配符(*,?)的若干模式串(用逗号分开)中的一个(加上前后缀)通配.
	 *  例如 like("123A45","1*B??,1*A??",true) 为true,  like("123A45","1*B??,1*A???",true) 为 false
	 *  @param text   被判断的字符串
	 *  @param pattern  含通配符(*,?)的若干模式串(用逗号分开),
	 *  @param patternPrifix  前缀
	 *  @param patternSuffix  后缀
	 *  @param ignoreCase 是否忽略字母的大小写
	 *  @return 是否通配, 如通配,返回 true, 否则 false
	*/
	public static boolean likeOneOf(String text,String pattern,String patternPrifix,String patternSuffix,boolean ignoreCase){
		return likeOneOf(text,pattern,',',patternPrifix,patternSuffix,ignoreCase);
	}
	/**
	 *  判断一个字符串是否与一含通配符(*,?)的若干模式串(用逗号分开)中的一个(加上前后缀)通配.
	 *  例如 like("123A45","1*B??,1*A??",true) 为true,  like("123A45","1*B??,1*A???",true) 为 false
	 *  @param text   被判断的字符串
	 *  @param pattern  含通配符(*,?)的若干模式串(用deli分开),
	 *  @param deli   pattern中的分割符
	 *  @param patternPrifix  前缀
	 *  @param patternSuffix  后缀
	 *  @param ignoreCase 是否忽略字母的大小写
	 *  @return 是否通配, 如通配,返回 true, 否则 false
	*/
	public static boolean likeOneOf(String text,String pattern,char deli,String patternPrifix,String patternSuffix,boolean ignoreCase){
		if( patternPrifix==null ) patternPrifix = "";
		if( patternSuffix==null ) patternSuffix = "";
		String patternlist[] = splitString(pattern,deli);
		for(int i=0;i<patternlist.length;i++)
			if(like(text,0,patternPrifix+patternlist[i]+patternSuffix,0,ignoreCase))
				return true;
		return false;
	}
	/**
	 *  判断一个字符串是否与一含通配符(*,?)的若干模式串(用逗号分开)中的一个通配.
	 *  例如 like("123A45","1*B??,1*A??",true) 为true,  like("123A45","1*B??,1*A???",true) 为 false
	 *  @param text   被判断的字符串
	 *  @param pattern  含通配符(*,?)的若干模式串(用逗号分开)
	 *  @param ignoreCase 是否忽略字母的大小写
	 *  @return 若通配返回true否则false
	*/
	public static boolean likeOneOf(String text,String pattern,boolean ignoreCase){
		return likeOneOf(text,splitString(pattern,','),ignoreCase);
	}
	public static final boolean likeOneOf2(String[] texta,String[] patternlist,boolean ignoreCase){
		if( texta==null )
			return false;
		for(int i=0;i<texta.length;i++){
			if( likeOneOf(texta[i],patternlist,ignoreCase) )
				return true;
		}
		return false;
	}
	public static final boolean likeOneOf(String text,String[] patternlist,boolean ignoreCase){
        if( patternlist==null )
        	return false;
		for(int i=0;i<patternlist.length;i++)
			if(like(text,0,patternlist[i],0,ignoreCase))
				return true;
		return false;
	}
	/**
	 *  判断一个字符串(从某位置起)是否与一含通配符(*,?)的模式串(从某位置起)通配.例如
	   StrUtil.like("123A456B", 0, "1*A*B", 0, false); = true
	   StrUtil.like("123A456B", 0, "1*A???B", 0, false); = true
	   StrUtil.like("123A456B", 0, "1*A????B", 0, false); = false
	 *  @param text   被判断的字符串
	 *  @param oText  text的起始位置
	 *  @param pattern  含通配符(*,?)的模式串
	 *  @param oPattern  pattern的起始位置
	 *  @param ignoreCase 是否忽略字母的大小写
	 *  @return 如通配返回 true,否则false
	*/
	public static boolean like(String text,int oText,String pattern,int oPattern,boolean ignoreCase){
        if( text==null ) return pattern==null; 
		final int ltext = text.length()-oText;
		final int lpattern = pattern.length()-oPattern;
		for(int i=0;i<lpattern /*&& i<ltext*/;i++){
			char c = pattern.charAt(oPattern+i);
			if( c=='*'|| c=='%' ){
				if( i==lpattern-1 || endsWithStarsPattern(pattern,oPattern+i) )
					return true;
				for(int iText=oText+i;iText<ltext+oText;iText++)
					if(like(text,iText,pattern,oPattern+i+1,ignoreCase))
						return true;
				return false;
			}
			if( i>=ltext ) 
				return false;
            if(c=='?'||c=='_'){
                continue;
            }
			if(ignoreCase){
				if(Character.toUpperCase(c)!=Character.toUpperCase(text.charAt(oText+i)))
					return false;
			}else{
				if( c!=text.charAt(oText+i) )return false;
			}
		}
		return  ltext==lpattern || (lpattern>=ltext+1 && endsWithStarsPattern(pattern,ltext));
	}
	final private static boolean endsWithStarsPattern(String text,int from){
		if( from<0 ) from = 0;
		for(;from<text.length();from++){
			char c = text.charAt(from);
			if( c!='*' && c!='%' )return false;
		}
		return true;
	}
	
	/**
	 * 将一个字符串以某字符作为分隔符进行分隔(得到每段作为字符串的字符串数组).
	 *   "123.345.678".split("\\.");
	 *   @param  str  被分隔的字符串
	 *   @param  delimiter  分隔符
	 *   @return  分隔的结果
	*/
	public static final String[] splitString(String str,char delimiter){
        if( delimiter==0 ) return str==null? null: new String[]{ str};
		return splitString(str,0,delimiter);
	}
	/**
	 *   将一个字符串从某位置开始以某字符作为分隔符进行分隔(得到每段作为字符串的字符串数组).
	 *  <blockquote><pre>
	 *     String list[] = Utilities.splitString("AAAA,BBBB,CCCC,DDDDD",0,',')
	 *     // list 为  { "AAAA","BBBB","CCCC","DDDD" }
	 *   </pre></blockquote>
	 *   @param  str  被分隔的字符串
	 *   @param  istart 开始位置
	 *   @param  delimiter  分隔符
	 *   @return  分隔的结果
	*/
	public static final String[] splitString(String str,int istart,char delimiter){
		if(str==null)
			return null;
		int sl = str.length();
		int n = 0;
		for(int i=istart;i<sl;i++)
			if(str.charAt(i)==delimiter)
				n++;
		String[] sa = new String[n+1];
		int i=istart,j = 0;
		for(;i<sl;)
		{
			int iend = str.indexOf(delimiter,i);
			if(iend<0)
				break;
			sa[j++] = str.substring(i,iend);
			i = iend+1;
		}
		sa[j++] = str.substring(i);
		return sa;
	}
	public static final String[][] splitString(String str,char delimiter1,char delimiter2){
		String[] a1 = splitString(str,delimiter1);
		if( a1==null )
			return null;
		String a2[][] = new String[a1.length][];
		for(int i=0;i<a1.length;i++){
			a2[i] = splitString(a1[i],delimiter2);
		}
		return a2;
	}
	public static final String[] splitByLine(String str, String lineText) {
		if (str == null)
			return null;
		String a[] = StrUtil.splitString(str, '\n');
		List<String> v = new ArrayList<String>();
		StringBuffer sb = null;
		for (int i = 0; i < a.length; i++) {
			if (a[i].trim().equals(lineText)) {
				v.add(sb == null ? "" : sb.toString());
				sb = null;
			} else {
				if (sb == null)
					sb = new StringBuffer(StrUtil.trimRight(a[i]))
							.append("\r\n");
				else
					sb.append(StrUtil.trimRight(a[i])).append("\r\n");
			}
		}
		if (v.size() == 0)
			return new String[] { str };
		v.add(sb == null ? "" : sb.toString());
		return v.toArray(new String[v.size()]);
	}
	public static final String[] splitString(String str, char delimiter,boolean slash) {
		if (str == null)
			return null;
		int sl = str.length();
		java.util.List<String> v = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < sl; i++) {
			char c = str.charAt(i);
			char c0 = 0;
			if (c == '\\' && i < sl - 1) {
				char c2 = str.charAt(i + 1);
				if (c2 == '\\' || c2 == delimiter) {
					c0 = '\\';
					c = c2;
					i++;
				}
			}
			if (c == delimiter && c0 != '\\') {
				v.add(buffer.toString());
				buffer = new StringBuffer();
			} else {
				buffer.append(c);
			}
		}
		v.add(buffer.toString());
		return v.toArray(new String[v.size()]);
	}
	
	/**
	 *   读入输入流并转换成文本. 从InputStream对象(is)得到 java.io.InputStreamReader(InputStream is)
	 *   对象再从中读出文本. 在一些存储大文本的数据库的字段中，从中得到的是InputStream输入流,
	 *   使用该函数转换成需要的文本。例子：
	 *  <blockquote><pre>
	 *    ResultSet rs = stmt.executeQuery(sql);
	 *    Object obj = rs.getObject(1);
	 *	  if( obj instanceof InputStream )
	 *		 return Utilities.getTextFromInputStream((InputStream)obj);
	 *   </pre></blockquote>
	 *   @param   is  从中转换成文本的输入流
	 *   @return  转换成的文本
	*/
	public static final String getTextFromInputStream(java.io.InputStream is,String charSet){
		if (is == null)
			return null;
		StringBuffer buf = null;
		try {
			is.reset();
			buf = new StringBuffer();
			InputStreamReader r = charSet == null ? new java.io.InputStreamReader(is) : new java.io.InputStreamReader(is, charSet);
			try {
				/*for (;;) {
					int c = r.read();
					if (c <= 0)
						break;
					buf.append((char) c);
				}*/
				int c = r.read();
				while (c > 0){
					buf.append((char) c);
					c = r.read();
				}
			} finally {
				if (r != null)
					r.close();
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return buf==null ? null:buf.toString();
	}
	
	public static final Object parseValue(String valueText){
		if(valueText==null)
			return null;
		valueText = valueText.trim();
		final int lvalueText = valueText.length();
		if( lvalueText==0 )
			return null;
		char c0 = valueText.charAt(0);
		if( (c0>='0' && c0<='9') || c0=='-' ){
			if( valueText.indexOf('.')>0 )
				return Double.valueOf(valueText);
			int l = lvalueText;
			if( c0=='-' )
			{
				valueText = valueText.substring(1);  l--;
			}
			char c1 = valueText.charAt(0);
			char c2 = l>1?valueText.charAt(1):0;
			int x = 0;
			if( c1=='0' && (c2=='x'||c2=='X') )
				x = Integer.parseInt(valueText.substring(2),16);
			else {
				x = Integer.parseInt(valueText);
			}
			return Integer.valueOf(c0=='-'?-x:x);
		}
		if( c0=='"' && lvalueText>=2 && valueText.charAt(lvalueText-1)=='"' ){
			return replaceEscapeChar(valueText.substring(1,lvalueText-1));
		}
		if( c0=='\'' && lvalueText>=2 && valueText.charAt(lvalueText-1)=='\'' ){
			return Character.valueOf(valueText.charAt(1));
		}
		if(valueText.equals("true"))
			return Boolean.TRUE;
		if(valueText.equals("false"))
			return Boolean.FALSE;
		/* 是否为一个对象：
		int p;
		if( valueText.charAt(lvalueText-1)==')' 
				&& (p=valueText.indexOf('('))>0 
				&& valueText.indexOf('.')<p ){
			try{
				//LEEHOWSNCHANGE
				//return InvokeJava.invokeJavaX(valueText,null);
				throw new RuntimeException("");
			 }catch(Throwable ex){
				 throw new RuntimeException(ex.getMessage());
			 }
		}*/
		return null;
	}
	public static final Object[] parseValues(String valueText[]){
		if( valueText==null )
			return null;
		Object a[] = new Object[valueText.length];
		for(int i=0;i<a.length;i++)
			a[i] = parseValue(valueText[i]);
		return a;
	}
	/**
	 * 替换text中的 \", \r, \n, \t, \\ 等
	 * @param text
	 * @return 替换后字符串
	 */
	public static final String replaceEscapeChar(String text){
		if( text==null )
			return text;
		StringBuffer textBuffer = new StringBuffer();
		int n = text.length();
		int m = 0;
		for(int i=0;i<n;i++){
			char c = text.charAt(i);
			if( c=='\\' && ++i<n ){
				m++;
				char c2 = text.charAt(i);
				if( c2=='n' )
					c = '\n';
				else if( c2=='r' )
					c = '\r';
				else
					c = c2;
			}
			textBuffer.append(c);
		}
		return m==0 ? text : textBuffer.toString();
	}
	/**
	 * 把str用delimiter分割成各片段从而查找sub,返回sub下标,支持是否去前后空格和是否忽略大小写
	 * StrUtil.indexOf(" aaa ,bb, zz,de ", ',', "zz", true, false);
	 * @param str 源字符串
	 * @param delimiter	分割字符串
	 * @param sub 目标字符串
	 * @param trim 是否去前后空格
	 * @param ignoreCase 是否忽略大小写
	 * @return 若存在则返回下标,否则返回-1
	 */
	public static final int indexOf(String str,char delimiter,String sub,boolean trim,boolean ignoreCase){
        if( str==null || sub==null )
            return -1;
        int p0 = 0; final int n = str.length();
        final int cmpLen = sub.length();
        int j = 0;
        for(int i=0;i<=n;i++){
            if( i==n || str.charAt(i)==delimiter ){
                if( trim ) {
                    if( ignoreCase ? str.substring(p0,i).trim().equalsIgnoreCase(sub)
                                   : str.substring(p0,i).trim().equals(sub) )
                        return j;
                    //str.regionMatches(p0,);
                } else{
                     if( cmpLen==i-p0 && str.regionMatches(ignoreCase,p0,sub,0,cmpLen) )
                         return j;
                }
                p0 = i+1;
                j++;
            }
        }
        return -1;
    }
    
	/**
	 * a为不定维度的数组,将这个数组中所有String元素都前后去空白
	 * @param a
	 * @return 处理后的原数组
	 */
	public static <T> T stringArrayTrim(T a){
        if( a instanceof Object[] ){
            Object oa[] = (Object[])a;
            for(int i=0;i<oa.length;i++){
                if( oa[i] instanceof String )
                    oa[i] = ((String)oa[i]).trim();
                else
                    stringArrayTrim(oa[i]);
            }
        }
        return a;
    }

	/**
	 * 将数组arr中的元素用link连接起来,并将将连接后的字符串返回<br/>
	 * @param a
	 * @param link
	 * @return 连接后的字符串
	 */
	public static final String objcat(Object a[],char link){
    	return objcat(a,link,null);
    }
	/**
	 * 将数组arr中的元素用link连接起来,对于为null的元素用nullObj来代替<br/>
	 * 将连接后的字符串返回
	 * @param arr
	 * @param link
	 * @param nullObj
	 * @return 连接后的字符串
	 */
	public static final String objcat(Object[] arr,char link,Object nullObj){
        if( arr==null )//|| a.length==0 )
            return null;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
           if( i>0 ) sb.append(link);
           sb.append(arr[i]==null?nullObj:arr[i]);
        }
        return sb.toString();
    }
	/**
	 * 将数组arr中的元素用link连接起来,对于为null的元素用nullObj来代替<br/>
	 * 将连接后的字符串返回
	 * @param arr
	 * @param link
	 * @param nullObj
	 * @return 连接后的字符串
	 */
	public static final String objcat(Object[] arr,String link,Object nullObj){
        if( arr==null || arr.length==0 )
            return null;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
           if( i>0 ) sb.append(link);
           sb.append(arr[i]==null?nullObj:arr[i]);
        }
        return sb.toString();
    }
	
	/**
	 * 将数组arr中的元素用link连接起来,并将将连接后的字符串返回
	 * @param arr
	 * @param link
	 * @return 连接后的字符串
	 */
	public static final String intcat(int[] arr,char link){
        if( arr==null || arr.length==0 )
            return null;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
           if( i>0 ) sb.append(link);
           sb.append(arr[i]);
        }
        return sb.toString();
    }
	
	/**
	 * 将s1和s2连接起来,若s1为null则返回s2
	 * @param s1
	 * @param s2
	 * @return 连接后的字符串,若s1为null则返回s2
	 */
	public static final String strcat(String s1,String s2){
		return s1!=null && s2!=null ? s1+s2 : (s1==null?s2:s1);
	}
	/**
	 * 将s1和s2用link连接起来,若s1为null则返回s2
	 * @param s1
	 * @param link
	 * @param s2
	 * @return 连接后的字符串,若s1为null则返回s2
	 */
	public static final String strcat(String s1,char link,String s2){
		return s1!=null && s2!=null ? s1+link+s2 : (s1==null?s2:s1);
	}
	/**
	 * 将s1和s2用link连接起来,若s1为null则返回s2
	 * @param s1
	 * @param link
	 * @param s2
	 * @return 连接后的字符串,若s1为null则返回s2
	 */
	public static final String strcat(String s1,String link,String s2){
		return s1!=null && s2!=null ? s1+link+s2 : (s1==null?s2:s1);
	}
	/**
	 * 将数组arr中的元素用link连接起来,对于为null的元素用nullStr来代替<br/>
	 * 将连接后的字符串返回
	 * @param arr
	 * @param link
	 * @param nullStr
	 * @return 连接后的字符串
	 */
	public static final String strcat(String[] arr,String link,String nullStr){
		String s = null;
		if( arr!=null ) for(int i=0;i<arr.length;i++){
			String s1 = arr[i]==null ? nullStr : arr[i];
			if( s1==null ) continue;
			s = s!=null ? s+link+s1 : s1;
		}
		return s;
	}
	/**
	 * 统计一个字符串中给定范围内前缀空格的个数
	 * @param text
	 * @param iStart
	 * @param iEnd
	 * @return 前缀空格的个数
	 */
	public static final int countStartSpace(String text,int iStart,int iEnd){
		int n = 0;
		for(;iStart+n<iEnd;n++)
		{
			if(!Character.isSpaceChar(text.charAt(iStart+n)))
				break;
		}
		return n;
	}
	
	/**
	 *   参数表分析.
	 *   例如
	 *  <blockquote><pre>
	 *   String[] arr = new String[64];
	 *   parseParameterList("M(XXX1,XXX2,XXX3)",1,arr)
	 *    //  返回结果为3 , arr[0] = "XXX1", arr[1] = "XXX2", arr[2] = "XXX3"
	 *   </pre></blockquote>
	 *   @param  text  含参数表的字符串
	 *   @param  iStart 参数表在text中的起始位置(该位置除空格外的第一个必须为'('),
	 *   @param  arr  参数分析出的结果放在其中(必须保证arr元素个数足够大)
	 *   @return  参数在text中的长度
	 */
	public static final int parseParameterList(String text,int iStart,String[] arr){
        return parseParameterList(text,iStart,arr,null,null);
	}
	/**
	 * 参数表分析.
	 * @param text
	 * @param iStart
	 * @param arr
	 * @param pCountParams
	 * @return 参数在text中的长度
	 */
	public static final int parseParameterList(String text,int iStart,String[] arr,int[] pCountParams){
		return parseParameterList(text,iStart,arr,null,pCountParams);
	}
	/**
	 * 
	 * @param  text  含参数表的字符串
	 * @param  iStart 参数表在text中的起始位置(该位置除空格外的第一个必须为'('),
	 * @param  arr  参数分析出的结果放在其中(必须保证arr元素个数足够大)
	 * @param  toList	将参数添加到toList中
	 * @param  pCountParams
	 * @return 参数在text中的长度
	 */
	public static final int parseParameterList(String text,int iStart,String[] arr,final java.util.List<String> toList,int[] pCountParams){
		if(arr!=null) for(int i=0;i<arr.length;)
			arr[i++] = null;
		int jStack = 0; final int ltext = text.length();
		int nList = 0;
		int n = countStartSpace(text,iStart,ltext);
		if(iStart+n>=ltext || text.charAt(iStart+n)!='(')
			return 0;
		n++;  // skip '(' ')'
		n += countStartSpace(text,iStart+n,ltext);
		char charStr = 0;
		int i0 = n;
		for(;iStart+n<ltext;){  // for(;n<ltext;)
			char c = text.charAt(iStart+n);
			if(c=='"' || c=='\''){
				if(charStr==0)
					charStr = c;
				else if(c==charStr && text.charAt(iStart+n-1)!='\\')
					charStr = 0;
			}
			if(charStr!=0){
				n++;  continue;
			}
			if(jStack==0 && (c==',' || c==')')){
				String s = text.substring(iStart+i0,iStart+n).trim();
				if(s.length()>0){
					if(arr!=null) arr[nList++] = s;
					if( toList!=null ) toList.add(s);
				} else if( c==',' || nList>0 )
					 throw new java.lang.IllegalArgumentException(text);
				n++;
				if(c==')')
					break;
				i0 = n+=countStartSpace(text,iStart+n,ltext);
				continue;
			}
			if(c==')')
				jStack--;
			else if(c=='(')
				jStack++;
			n++;
		}
        if( pCountParams!=null ) pCountParams[0] = nList;
		return n;
	}
	
	/**
	 *  宏替换. 
	 *  宏名必须为一个标准的Java标识符,对于带参数的宏,宏名后面加$符再加参数个数,
	 *  例如 MNAME$3 表示一个含三个参数的宏名，宏值中使用 $0,%1,... 表示被替换的参数
	 *  <blockquote><pre>
	 *    Hashtable macro = new Hashtable();
	 *    macro.put("MNAME$3","%0+%1+%2");
	 *    macro.put("PROCP","p()");
	 *    String text = macroReplace("MNAME$3(x,y,z)+PROCP",macro);
	 *    text结果为 "x+y+z+p()"
	 *   </pre></blockquote>
	 *  @param  text  将进行宏替换的字符串
	 *  @param  macro  宏定义
	 *  @return 替换后的结果
	 */
	final public static String replaceMacro(String text,Map<Object,Object> macro){
		return replaceMacro(text,macro,(char)0,(char)0,0);
	}
	/**
	 *  宏替换. 宏名必须为一个标准的Java标识符,对于带参数的宏,宏名后面加$符再加参数个数,
	 *  例如 MNAME$3 表示一个含三个参数的宏名，宏值中使用 $0,%1,... 表示被替换的参数
	 *  进行宏替换的字符串中只有被指定括号括住的宏名才被替换
	 *  <blockquote><pre>
	 *    Hashtable macro = new Hashtable();
	 *    macro.put("MNAME$3","%0+%1+%2");  macro.put("PROCP","p()");
     *    macro.put("MNAME(3)","%0+%1+%2");  macro.put("PROCP","p()");
	 *    String text = replaceMacro("{MNAME$3}(x,y,z)+{PROCP}",macro,'{','}');
     *    text = replaceMacro("{MNAME}(x,y,z)+{PROCP}",macro,'{','}');
	 *	  // 结果为 "x+y+x+p()"
	 *   </pre></blockquote>
	 *  @param  text  将进行宏替换的字符串
	 *  @param  macro  宏定义
	 *  @param  prefix  进行宏替换的字符串中括住宏名的左括号
	 *  @param  suffix  进行宏替换的字符串中括住宏名的右括号
	 *  @return 替换后的结果
	 */
	@SuppressWarnings("rawtypes")
	final public static String replaceMacro(String text,Map macro,char prefix,char suffix){
		return replaceMacro(text,macro,prefix,suffix,0);
	}
	/**
	 * 
	 * @param  text  将进行宏替换的字符串
	 * @param  macro  宏定义
	 * @param  prefix  进行宏替换的字符串中括住宏名的左括号
	 * @param  suffix  进行宏替换的字符串中括住宏名的右括号
	 * @param  options : bit <blockquote><p>
	  			  1 : replaceStr <br/>
                  2 : "" for null macro <br/>
                  4 ： 字符串外 含空的宏时返回  null <br/>
                  8 : 字符串内 含空的宏时返回  null <br/>
                 16 : "0" for null macro <br/>
                 32 : 禁止参数型的 宏( XXX$2 不认为代 参数 类型 的宏 ) <br/>
                 64: '.' 不能含在 宏名中 <br/>
                128 : 宏前面的 ＃ 处理为 字符串 "..."</p></blockquote>
	 * @return 替换后的结果
	 */
    @SuppressWarnings("rawtypes")
	final public static String replaceMacro(String text,Map macro,char prefix,char suffix,int options){
        if( text==null || macro==null )
        	return text;
        final boolean replaceStr = (options&1)!=0;
		int nCount = 0;
		StringBuffer strBuffer = new StringBuffer();
		char charStr = 0, charStr2 = 0; // In " or '
		int ltext = text.length();
	//	int j0 = 0;
		for(int i=0;i<ltext;){
			char c = text.charAt(i);
			if(charStr==0 && Character.isJavaIdentifierStart(c)){
				char id[] = new char[64];
				id[0] = c;  int j = 1;  int p$ = -1;
				int nPara = 0;
				for(j=1;j<64 && i+j<ltext;){
					c = text.charAt(i+j);
					if( !Character.isJavaIdentifierPart(c) && (c!='.'||(options&64)!=0) )
						break;
					if(c=='$' && (options&32)==0 )
						p$ = j;
					else if(c<'0' || c>'9')
						p$ = -1;
					else if(p$>0)
						nPara = nPara*10+(c-'0');
					id[j++] = c;
				}
				i += j;
                boolean  notMacroId = suffix!=0 && ( i>=ltext || text.charAt(i)!=suffix);
				if( !notMacroId && prefix!=0 ){
					int l = strBuffer.length();
					if( l==0 || strBuffer.charAt(l-1)!=prefix )
						notMacroId = true;
				}
                String t = null;
                final String [] parmList = new String [64];
                int paramLength = -1, countParams = 0;
                if( !notMacroId ){
                    String  macroName = new String(id,0,j);
					Object ot  = null;
                        paramLength = parseParameterList(text,suffix!=0?i+1:i,parmList);
                        if( paramLength>0 )
                             for(;countParams<64 && parmList[countParams]!=null;countParams++)
                                 ;
                        if( countParams> 0 ){
                        	try { ot = macro.get(macroName+"("+countParams+")"); } catch( Throwable ex ){}
                            if( ot!=null ){
                                t =  ot.toString();
                                nPara = countParams;
                            }
                        }
                    if( t==null ){
                    	try { ot = macro.get(macroName); } catch( Throwable ex ){}
                        t = ot==null ? null : ot.toString();
                    }
                    if( t==null ){
                        if( (charStr2==0 && (options&4)!=0) || (charStr2!=0 && (options&9)==9) ) return null;
                        if( (options&2)!=0 )
                            t = "";
                        else if( (options&16)!=0 )
                            t = "0";
                    }
                    if( t==null )
                        notMacroId = true;
				}
				if( notMacroId ){
					strBuffer.append(id,0,j);
                }else{
					if( prefix!=0 ){
						strBuffer.setLength(strBuffer.length()-1);
					}
					if( suffix!=0 ) i++;
					nCount++;
					if( nPara>0 ){
                        if( paramLength<0 )
                            paramLength = parseParameterList(text,i,parmList);
                        i += paramLength;
						if(parmList[nPara]!=null || parmList[nPara-1]==null){
							System.out.println("Error parameter count");
						}
						strBuffer.append(format(t,(Object[])parmList));
					}else{
						strBuffer.append(t);
                    }
				}
			} else{  //if(charStr==0 && Character.isJavaIdentifierStart(c))
				strBuffer.append(c);
				if( !replaceStr ){
					if(charStr==0 && (c=='"' || c=='\''))
						charStr = c;
					else if(charStr==c && text.charAt(i-1)!='\\')
						charStr = 0;
                    charStr2 = charStr;
				}else{
                    if(charStr2==0 && (c=='"' || c=='\''))
                        charStr2 = c;
                    else if(charStr2==c && text.charAt(i-1)!='\\')
                        charStr2 = 0;
                }
				i++;
			}
		}
		return  nCount>0 ? strBuffer.toString() : text;
	}
	
    /**
     * 	 m.put("AAA","xaaax");
         m.put("BBB","xbbbx");
         System.out.println(StrUtil.macroReplace("00{AAA}22{AA,xaax},8888{BBB}99",m,"{","}","",','));
     * @param text
     * @param macro
     * @param prefix
     * @param suffix
     * @param nullValue  nullValue==null : 不替换
     * @param nulValueDelim
     * @return
     
    @SuppressWarnings("rawtypes")
    public static final String macroReplace(String text,Map macro,String prefix,String suffix,final String nullValue,char nulValueDelim){
        if( text==null )
            return null;
        final int lprefix = prefix.length(),
             lsuffix = suffix.length();
        for(int p0=0;;){
            final int p1 = text.indexOf(prefix,p0);
            if( p1<0 ) break;
            final int p2 = text.indexOf(suffix,p1+lprefix);
            if( p2<0 ) break;
            String nm = text.substring(p1+lprefix,p2);
            String nulValue = nullValue;
            if( nulValueDelim!=0 ) {
                int p = nm.indexOf(nulValueDelim);
                if( p>=0 ) {
                    nulValue = nm.substring(p+1);
                    nm = nm.substring(0,p);
                }
            }
            Object v = macro.get(nm);//||nullValue;
            if( v==null )
                v = nulValue;
            if( v==null )
            {
                p0 = p2 + lsuffix;
                continue;
            }
            text = text.substring(0,p1)+v+text.substring(p2+lsuffix);
            p0 = p1+v.toString().length();
        }
        return text;
     }*/
    
    /**
     * 将x转化为字符串,若x位数不够len则前缀加0
     * @param x
     * @param len
     * @return
    public static String toString(int x,int len){
    	String s = Integer.toString(x);
    	if( s.length()<len ){
    		int count = len - s.length();
    		StringBuffer strBuffer = new StringBuffer();
    		for(;count>0;count--)
    			strBuffer.append('0');
    		strBuffer.append(x);
    		return strBuffer.toString();
    	}
    	return s;	
    }*/
	
	/**
	 * 获取十六进制字符串
	 * @param a
	 * @return
	public static String toHexString(byte a[]){
		if( a==null ) return null;
			char sa[] = new char[a.length*2];
			for(int i=0;i<a.length;i++){
				int x = (a[i]>>4)&0xf;
				sa[i*2] = (char)(x<10 ? '0'+x : 'A'+x-10);
				x = a[i]&0xf;
				sa[i*2+1] = (char)(x<10 ? '0'+x : 'A'+x-10);
			}
			return new String(sa);
	}*/
	
	
	/**
	 * 
	 * @param text
	 * @param forChars
	 * @return
	 
	public static final String insertEscapeChar(String text,String forChars){
		if( text==null || forChars==null )
			return text;
		StringBuffer textBuffer = new StringBuffer();
	    for(int i=0;i<text.length();i++){
			char c = text.charAt(i);
	        if( forChars.indexOf(c)>=0 ){
				textBuffer.append('\\');
	        }
			textBuffer.append(c);
		}
		return textBuffer.toString();
	}*/
	/**
	 * 将一个字符串以某字符作为分隔符进行分隔后取其中某一段.
	 *  <blockquote><pre>
	 *     String subtext = Utilities.splitString("AAAA,BBBB,CCCC,DDDDD",0,',',2)
	 *     // subtext 为 "CCCC"
	 *   </pre></blockquote>
	 *   @param  str  被分隔的字符串
	 *   @param  istart 开始位置
	 *   @param  delimiter  分隔符
	 *   @param  index  分隔后的子串数组下标
	 *   @return  第 index 个子串
	
	public static final String subSplitString(String str,int istart,char delimiter,int index){
		if(str==null) return null;
		int sl = str.length();
		int i=istart,j = 0;
		for(;i<sl;){
			int iend = str.indexOf(delimiter,i);
			if(iend<0)
				break;
			if(j++==index)  return str.substring(i,iend);
			//System.out.println(sa[j-1]);
			i = iend+1;
		}
		return j==index ? str.substring(i) : null;
	}*/
	/**
	*  统计一个字符串中某位置开始连续的空格个数.
	*  例如 countWhitespace("   abc  df",0) 结果为3
	public static final int  countWhitespace(String text,int start){
		int i = 0;
		for(;start+i<text.length() && Character.isWhitespace(text.charAt(start+i));i++)
			;
		return i;
	}*/
	/**
	 * 
	 * @param text
	 * @param c
	 * @return
	 
	public static final int countChar(String text,char c){
        if( text==null )
            return 0;
        int n = 0;
        int ltext = text.length();
        for(int i=0;i<ltext;i++)
            if( text.charAt(i)==c ) n++;
        return n;
    }*/
	/**
	 * 
	 * @param text
	 * @return
	 
	public static Object[] parseParameterValues(String text){
		final java.util.List<String> list = new ArrayList<String>();
		parseParameterList(text,0,null,list,null);
		return StrUtil.parseValues(list.toArray(new String[list.size()]));
	}*/
	
	/**
	 * 
	 * @param id
	 * @return
	 
	public static boolean isJavaIdentifier(String id){
        int n = id==null ? 0 : id.length();//if(id==null || id.length()==0 )
        if( n==0 ) return false;
        if( !Character.isJavaIdentifierStart(id.charAt(0)) )
            return false;
        for(int j=1;j<n;j++)
            if( !Character.isJavaIdentifierPart(id.charAt(j)) )
                return false;
        return true;
    }*/
}
