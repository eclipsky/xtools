package org.sky.x.tij.c14;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NameList {
	
	private List nameList = Collections.synchronizedList(new LinkedList());
	
	public void add(String name){
		nameList.add(name);
	}
	
	public synchronized String removeFirst(){
		if(nameList.size()>0){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (String)nameList.remove(0);
		}else{
			return null;
		}
	}
}
