package org.sky.x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sky.x.string.StrUtil;

public class MapUtil {
	
	/**
	 * 将from里的键值对覆盖拷贝到to中
	 * @param to
	 * @param from
	 * @return 更改后的to
	 */
	public static final <K,V> Map<K,V> dupMap(Map<K,V> to, Map<K,V> from) {
		return dupMap(to, from, 1);
	}
	/**
	 * 将to里没有且存在from中的键值对拷贝到to中
	 * @param to
	 * @param from
	 * @return 更改后的to
	 */
	public static final <K,V> Map<K,V> dupMapIfNull(Map<K,V> to, Map<K,V> from) {
		return dupMap(to, from, 0);
	}
	/**
	 * 将from里的键值对覆盖拷贝到to中
	 * @param to
	 * @param from
	 * @param mode bit 1: 覆盖拷贝
	 * @return 更改后的to
	 */
	public static final <K,V> Map<K,V> dupMap(Map<K,V> to, Map<K,V> from,int mode) {
		if (from == null)
			return to;
		if (to == null)
			to = new HashMap<K,V>();
		for (final K key : from.keySet()) {
			if((mode&1) == 0){
				if(!to.containsKey(key))
					to.put(key, from.get(key));
			}else{
				to.put(key, from.get(key));
			}
		}
		return to;
	}
	
	/**
	 * 将内容格式为paramName1=value1\nparamName2=value2\n...的in解析后放入props中
	 * 同下面的方法loadProperties(String srcText, boolean removeQuotes),只不过这个是将in的内容解析后放入props中
	 * @param props
	 * @param in
	 * @param removeQuotes
	 * @throws IOException
	 * PS:<br/>
	 *  Map<String, String> props = new HashMap<String, String>();
		BufferedReader in = new BufferedReader(new StringReader("paramName1=value1\nparamName2=value2\nparamName3=value3"));
		MapUtil.loadToMap(props, in, false);//{paramName1=value1, paramName3=value3, paramName2=value2}
	 */
	public static void loadToMap(Map<String, String> props,BufferedReader in, boolean removeQuotes) throws IOException{ // 1.1
		if (in == null)
			return;
		for (;;) {
			String lineText = in.readLine();
			if (lineText == null)
				break;
			lineText = lineText.trim();
			if (lineText.length() == 0 || lineText.charAt(0) == '#'
					|| lineText.charAt(0) == '!' || lineText.startsWith("//"))
				continue;
			String[] a = parseProperty(lineText, removeQuotes);
			if (a != null)
				props.put(a[0], a[1]);
		}
	}
	/**
	 * 将格式为paramName1=value1\nparamName2=value2\n...的srcText解析为二维数组<br/>
	 * 这里相当于解析.properties文件的内容
	 * @param srcText
	 * @param removeQuotes
	 * @return 解析后的二位数组
	 * @throws IOException <br/>
	 * PS:<br/>
	 * MapUtil.loadProperties("paramName1=value1\nparamName2=value2\nparamName3=value3", false);
	 * [[paramName1, value1],[paramName2, value2],[paramName3, value3]]
	 */
	public static String[][] loadProperties(String srcText, boolean removeQuotes)throws IOException{// 1.1
		if (srcText == null)
			return null;
		return loadProperties(new BufferedReader(new StringReader(srcText)),removeQuotes);
	}
	/**
	 * 将内容格式为paramName1=value1\nparamName2=value2\n...的in解析为二维数组<br/>
	 * 这里相当于解析.properties文件的内容
	 * @param in
	 * @param removeQuotes
	 * @return 解析后的二维数组
	 * @throws IOException
	 */
	public static String[][] loadProperties(BufferedReader in,boolean removeQuotes) throws IOException{ // 1.1
		if (in == null)
			return null;
		final List<String[]> v = new ArrayList<String[]>();
		for (;;) {
			String lineText = in.readLine();
			if (lineText == null)
				break;
			lineText = lineText.trim();
			if (lineText.length() == 0 || lineText.charAt(0) == '#'
					|| lineText.charAt(0) == '!' || lineText.startsWith("//"))
				continue;
			String[] a = parseProperty(lineText, removeQuotes);
			if (a != null)
				v.add(a);
		}
		return v.toArray(new String[v.size()][]);
	}
	/**
	 * 将paramName1=value1格式的text转化成字符串数组<br/>
	 * 这里相当于解析.properties文件的一行
	 * @param text
	 * @param removeQuotes
	 * @return 解析后的二位数组
	 * PS:<br/>
	 * MapUtil.parseProperty("paramName1=value1", false);//[paramName1, value1]
	 */
	public static String[] parseProperty(String text, boolean removeQuotes) {
		if (text == null)
			return null;
		int p = (text = text.trim()).indexOf('=');
		if (p <= 0)
			return null;
		String name = text.substring(0, p).trim();
		if (removeQuotes && text.charAt(0) == '"') {
			int q = text.indexOf('"', 1);
			if (q < 0)
				return null;
			name = text.substring(1, q);
			p = text.indexOf('=', q);
			if (p <= 0)
				return null;
		}
		if (name.length() == 0)
			return null;
		String value = text.substring(p + 1).trim();
		if (removeQuotes && value.length() > 2 && value.charAt(0) == '"'
				&& value.charAt(value.length() - 1) == '"')
			value = value.substring(1, value.length() - 1);
		return new String[] { name, value };
	}
	
	/**
	 * 将paramText转化成map
	 * MapUtil.parseParameterTo("paramName1=value1&paramName2=value2", m);//{paramName1=value1,paramName2=value2}
	 * @param paramText
	 * @param to
	 * @return 包含解析后信息的map
	 */
	public static Map<String, String> parseParameterTo(String paramText, Map<String, String> to) {
		if (paramText == null)
			return to;
		String a[] = StrUtil.splitString(paramText, '&');
		for (int i = 0; i < a.length; i++) {
			final String si = a[i].trim();
			int p = si.indexOf('=');
			if (p < 0)
				continue;
			if (to == null){
				to = new Hashtable<String, String>(); // 不能用 HashMap
			}
			to.put(si.substring(0, p).trim(), si.substring(p + 1));
		}
		return to;
	}
	
	/**
	 * 遍历m将key符合keyPatterns的元素放进数组中组成二维数组返回<br/>
	 * keyPatterns的匹配规则参照StrUtil.likeOneOf方法
	 * @param m
	 * @param keyPatterns 若为空则不过滤
	 * @return 转化后的数组
	 * PS:<br/>
	 * m.put("aa", 100);m.put("bb", "200");<br/>
	 * MapUtil.mapToArray(m,"aa,b*");//[[aa, 100],[bb, 200]]
	 */
	public static <K, V> Object[][] mapToArray(final Map<K, V> m, String... keyPatterns) {
		if (m == null)
			return null;
		final List<Object[]> v = new ArrayList<Object[]>();
		for (final Object k : m.keySet()) {
			if (keyPatterns == null
					|| (k instanceof String 
						&& StrUtil.likeOneOf((String) k,keyPatterns)))
				v.add(new Object[] { k, m.get(k) });
		}
		return v.isEmpty() ? null : v.toArray(new Object[v.size()][]);
	}
	
	/**
	 * 使用mapToArray方法代替<br/><br/>
	 * 遍历m将key符合keyPatterns的元素放进数组中组成二维数组返回<br/>
	 * keyPatterns的匹配规则参照StrUtil.likeOneOf方法
	 * @param map
	 * @param keyPattern
	 * @return 转化后的数组
	 */
	@Deprecated
	public static  final <K,V> Object[][] getValues(final Map<K,V> map, final String keyPattern) {
		if (map == null)
			return null;
		final List<Object[]> v = new ArrayList<Object[]>();
		String akeyPatterns[] = StrUtil.splitString(keyPattern, ',');
		for (final Object key : map.keySet()) {
			if (keyPattern == null
					|| (key instanceof String && StrUtil.likeOneOf((String) key, akeyPatterns))){
				v.add(new Object[] { key, map.get(key) });
			}
		}
		return v.toArray(new Object[v.size()][]);
	}
	
	/**
	 * 将m的所有键(key)值放进一个数组中返回
	 * @param m
	 * @return 包含所有key的数组
	 */
	public static <K, V> K[] keysToArray(Map<K, V> m) {
		return keysToArray(m, null);
	}
	/**
	 * 将m的所有键(key)的值放进一个数组to中返回
	 * @param m
	 * @param to
	 * @return  数组to
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> K[] keysToArray(Map<K, V> m, K[] to) {
		/*if (to == null)
			to = (K[]) new Object[m.size()];
		else if (to !=null && to.length != m.size())
			throw new java.lang.IllegalArgumentException();*/
		int i = 0;
		boolean firstFlag=true;
		for (final K k : m.keySet()) {
			if(firstFlag){
				firstFlag = false;
				if (to == null){
					to = (K[]) ArrayUtil.newArrayByClass(k.getClass(), m.size());
				}else if(to.length != m.size()){
					throw new java.lang.IllegalArgumentException();
				}
			}
			to[i++] = k;
		}
		return to;
	}
	
	/**
	 * 将m转化成一个Entry数组返回
	 * @param map
	 * @return Entry数组
	 */
	public static <K, V> Entry<K, V>[] elementsToArray(Map<K, V> map) {
		return elementsToArray(map, null);
	}
	/**
	 * 将m转化成一个Entry数组返回
	 * @param m
	 * @param to
	 * @return Entry数组
	 */
	@SuppressWarnings("unchecked")
	public static <K, V>  Entry<K, V>[] elementsToArray(Map<K, V> m, Entry<K, V>[] to) {
		if (to == null)
			to = new Entry[m.size()];
		else if (to.length != m.size())
			throw new java.lang.IllegalArgumentException();
		int i = 0;
		for (final Entry<K, V> v : m.entrySet()) {
			to[i++] = v;
		}
		return to;
	}
	
	/**
	 * 将map的元素按照key=value方式用link作为分隔符进行显示
	 * @param map
	 * @param link
	 * @return 转化后字符串
	 */
	public static <K, V> String toString(Map<K, V> map, String link) {
		if (map == null)
			return null;
		StringBuffer sb = new StringBuffer();
		for (final Object key : map.keySet()) {
			Object v = map.get(key);
			if (sb.length() > 0)
				sb.append(link);
			sb.append(key).append('=').append(v);
		}
		return sb.toString();
	}
	
	private MapUtil(){}
	
	/*
	 *  分析一段形式为<key>=<value>的键值对并写入属性字典.
	 *  @param   props  属性字典
	 *  @param   text 形式为<key>=<value>的键值对,如"SystemList=00:系统维护,01:账务系统,02:报表系统,03:工资系统,04:固定资产,05:05表,06:利息计算,07:辅助核算,08:合同核算,09:查询系统,10:工具"
	 *  @return  text中的键名
	*//*
	public static String putProperty(Dictionary props,String text,boolean removeQuotes)
	{
		if( text==null ) return null;
		int p = text.indexOf('=');
		if( p<=0 )
			return null;
		String name = text.substring(0,p).trim();
		if( name.length()==0 ) return null;
		String value = text.substring(p+1).trim();
        if( removeQuotes && value.length()>2 && value.charAt(0)=='"' && value.charAt(value.length()-1)=='"' )
            value = value.substring(1,value.length()-1);
		props.put(name,value);
		return name;
	}*/
    /*public static String findFullname(ValueMap valueMap,String code)
    {
        return findFullname(valueMap,code,null);
    }
    public static String findFullname(ValueMap valueMap,String code,int showLevlFullnm[])
    {
        if( code==null )
            return null;
		//String fullname = null;
        final List<String> v = new ArrayList<String>();
        final int codeLen;
		int l = codeLen = code.length();
		for(;l>0;l--)
		{
            Object o = l<codeLen && valueMap instanceof snsoft.dx.CodeData 
               ? ((snsoft.dx.CodeData)valueMap).getMidCodeValue(code.substring(0,l))  
            	: valueMap.getValue(code.substring(0,l)); // 
			if( o instanceof String )
			{
                v.add((String)o);
                //String name = (String)o;
				//fullname = fullname==null?name.trim():name.trim()+'-'+fullname;
			}
		}
        int n = v.size();   StringBuffer sb = null;//new StringBuffer();
 //       if( n==0 ) return null;
        for(int i=0;i<n;i++) 
        {
            String s = v.get(n-i-1);
            if(s!=null) s = s.trim();
            if( showLevlFullnm!=null )
            {
                int i1 = i+1, i2 = -(n-i);
                boolean show = false;
                for(int j=0;j<showLevlFullnm.length;j++)
                {
                    if( showLevlFullnm[j]==i1 || showLevlFullnm[j]==i2 )
                    {
                        show = true;
                        break;
                    }
                }
                if( !show ) continue;
            }
            if( sb==null )
                sb = new StringBuffer(s);
            else {
                sb.append('-'); sb.append(s);
            }
        }
		return sb==null ? null : sb.toString();
    }*/
	/*public static int[] getIntParameterList(ValueMap map,String keyPattern)
	{
        Object v[][] = map.getValues(keyPattern);
        if( v==null ) return null;
		int a[] = new int[v.length];
		for(int i=0;i<v.length;i++)
		{
			a[i] = StrUtil.obj2int( v[i][1] );
		}
//		v.toArray(a);
		if(a.length>1)  Arrays.sort(a);
		return a;
	}*/
	/*public static void loadParamTo(ValueMap map,Map to,String keyPatterns[])
	{
        if( keyPatterns==null )
        	return;
        for(int i=0;i<keyPatterns.length;i++)
        {
            Object v[][] = map.getValues(keyPatterns[i]);
            if( v!=null ) for(int j=0;j<v.length;j++)
            {
                if( v[j][0]!=null && v[j][1]!=null ) to.put(v[j][0],v[j][1]);
            }
        }
	}*/
	/*
	public static void loadParamTo(Map from,Map to,String keyPatterns[])
	{
        if( keyPatterns==null ) return;
        for(int i=0;i<keyPatterns.length;i++)
        {
            Object v[][] = map.get(keyPatterns[i]);
            if( v!=null ) for(int j=0;j<v.length;j++)
            {
                if( v[j][0]!=null && v[j][1]!=null ) to.put(v[j][0],v[j][1]);
            }
        }
	} */
    /*public static void loadParamTo(ValueMap map,Map to)
	{
            Object v[][] = map.getValues(null);
            if( v!=null ) 		for(int j=0;j<v.length;j++)
            {
                if( v[j][0]!=null && v[j][1]!=null ) to.put(v[j][0],v[j][1]);
            }
	}*/
   /* public static void defineDefaultMacro(ValueMap envParams,Map macro)
    {
        
//            Object a[][] = envParams.getValues("macro.*");
//            if( a!=null ) for(int i=0;i<a.length;i++)
//            {
//                if( a[i][1]!=null ) macro.put(((String)a[i][0]).substring(6),a[i][1]);
//            }
        
        java.util.Date cdate = new java.util.Date(DateUtil.getServerTime(envParams));//  new java.util.Date();
        macro.put("CURDATE",DateUtil.dateToString(cdate,2));
        macro.put("CURDATEP30",DateUtil.dateToString(snsoft.util.DateUtil.incDate(cdate,-30),2));
        macro.put("CURDATETIME",DateUtil.dateToString(cdate));
        int y,m;
        macro.put("CURDATEYEAR",Integer.valueOf(y=DateUtil.getDateYear(cdate)));
        macro.put("PREVDATEYEAR",Integer.valueOf(y=DateUtil.getDateYear(cdate)-1));
        macro.put("NEXTDATEYEAR",Integer.valueOf(y=DateUtil.getDateYear(cdate)+1));
        macro.put("CURDATEMONTH",Integer.valueOf(m=DateUtil.getDateMonth(cdate)));
        macro.put("CURDATEMONTH2",m<10?"0"+m:""+m);
        macro.put("CURDATEDAY",Integer.valueOf(DateUtil.getDateDay(cdate)));
        macro.put("CURDATEMONDAYS",Integer.valueOf(DateUtil.getDaysOfMonth(y,m)));
        // for Sql:
//        macro.put("SQLLEFT$2",snsoft.sql.SqlUtil1.sqlLeftFunction()
        if( envParams!=null ) {
        Object a[][] = envParams.getValues(null);
        if( a!=null ) for(int i=0;i<a.length;i++)
        {
            String v = a[i][1]==null?"":a[i][1].toString();
            if( (""+a[i][0]).startsWith("macro.") )
                macro.put(((String)a[i][0]).substring(6),v);
            else
                macro.put("PARAM."+a[i][0],v);
        }
        }
//System.err.println("macro="+macro);
    }*/
	
	/*
	public static void main(String args[]) {
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("a", 100);
		m.put("b", "200");
		Object[] a = elementsToArray(m);

		System.out.println(a[0] + "," + a[1]);

	}*/

}