package org.sky.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class CollectionTest {
	
	@Test
	public void syncMap(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Integer> keyClear = new ArrayList<Integer>();
		List<Integer> keyTmp = new ArrayList<Integer>();
		List<String> valueTmp = new ArrayList<String>();
		map.put(0, "零");
		map.put(1, "壹");
		map.put(2, "贰");
		map.put(3, "叄");
		map.put(4, "肆");
		map.put(5, "伍");
		map.put(6, "陆");
		map.put(7, "柒");
		map.put(8, "捌");
		map.put(9, "玖");
		
		System.out.println(map.toString());
		if(map.size()>0){
			for(Entry<Integer,String> entry: map.entrySet()){
				keyTmp.add(entry.getKey());
				valueTmp.add(entry.getValue());
				if(valueTmp.size()%5==0){
					//批量写数据库
					
					//如无异常，清理已处理对象
					valueTmp.clear();
					keyClear.addAll(keyTmp);
					System.out.println("5 record has bean excute");
					continue;
				}
			}
			//剩下的数据批量写数据库
			
			//
		}
	}
}
