package org.sky.x.design.pattern.template;

public abstract class AbstractJob {

	public void execute(){
		printString("调用doJob()之前可以做一些事情");
		doJob();
		printString("调用doJob()之后可以做一些事情");
	}
	
	public abstract void doJob();
	
	private void printString(String print){
		System.out.println(print);
	}
}
