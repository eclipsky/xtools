package org.sky.x.concurrent.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyLock {
	public static void main(String[] args){
		Account account = new Account(12306,10000);
//		Lock lock = new ReentrantLock();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		Operator oper1 = new Operator("小华",+500,account,lock);
		Operator oper2 = new Operator("小强",-1000,account,lock);
		Operator oper3 = new Operator("小刚",+1200,account,lock);
		Operator oper4 = new Operator("小明",+0,account,lock);
		Operator oper5 = new Operator("小七",+1500,account,lock);
		Operator oper6 = new Operator("小亮",-5000,account,lock);
		Operator oper7 = new Operator("小妞",0,account,lock);
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(oper1);
		pool.execute(oper2);
		pool.execute(oper3);
		pool.execute(oper4);
		pool.execute(oper5);
		pool.execute(oper6);
		pool.execute(oper7);
		pool.shutdown();
	}
}

class Operator implements Runnable{
	private String name;
	
	private Integer change;
	
	private Account account;
	
	private ReadWriteLock myLock;
	
	public Operator(String name, Integer change, Account account, ReadWriteLock myLock){
		this.name = name;
		this.change = change;
		this.account = account;
		this.myLock = myLock;
	}
	
	public void run(){
		if(change==0){
			myLock.readLock().lock();
			account.getMoney(name);
			myLock.readLock().unlock();
		}else{
			myLock.writeLock().lock();
			account.setMoney(change,name);
			myLock.writeLock().unlock();
		}
	}
}

class Account{
	
	private Integer id;
	
	private Integer money;
	
	public Account(Integer id, Integer money){
		this.id = id;
		this.money = money;
	}
	
	public void getMoney(String name){
		String type = "查询";
		System.out.println("操作人："+name+"，操作类型："+type+"，账户名："+id+"，金额："+money);
	}
	
	public void setMoney(Integer change, String name){
		String type = change > 0?"入账":"出账";
		System.out.println("操作人："+name+"，操作类型："+type+"，账户名："+id+"，金额："+ money + "，变更：" + change +"，最终金额："+(money+=change));
	}
	
}