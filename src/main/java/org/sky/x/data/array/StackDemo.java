package org.sky.x.data.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

/**
 * @author eclipsky  
 * 2014年6月19日 下午11:39:44
 */
public class StackDemo {
	
//	@Test
	public void testStack(){
		StackI stack = new MyStack(5);
		while(!stack.isFull()){
			stack.push(RandomUtils.nextInt()%100);
		}
		while(!stack.isEmpty()){
			stack.pop();
		}
	}

//	@Test
	public void reverse(){
		Reverse rev = new Reverse(getInput());
		String output = rev.doReverse();
		System.out.println(output);
	}
	
	@Test
	public void bracket(){
		String input;
		while(true){
			System.out.print("please input the sequence:");
			input = getInput();
			if(input.equals("")){
				break;
			}
			Bracket bra = new Bracket(input);
			System.out.println(bra.check());
		}
	}
	
	public String getInput(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	
}

class Reverse{
	private MyStack stack;
	private String input;
	private String output;
	
	public Reverse(String input){
		this.input = input;
		output="";
		stack = new MyStack(input.length());
	}
	
	public String doReverse(){
		for(int i=0; i<input.length();i++){
			char ch = input.charAt(i);
			stack.push(ch);
		}
		while(!stack.isEmpty()){
			char ch = (char)stack.pop();
			output+=ch;
		}
		return output;
	}
}

class Bracket{
	private MyStack stack;
	private String input;
	public Bracket(String input){
		this.input = input;
		stack = new MyStack(input.length());
	}
	
	public boolean check(){
		for(int i=0;i< input.length();i++){
			char ch = (char)input.charAt(i);
			while(ch=='{' || ch=='[' || ch=='('){
				stack.push(ch);
				break;
			}
			if(ch=='}'||ch==']'||ch==')'){
				if(!stack.isEmpty()){
					char old = (char)stack.pop();
					if((old=='{'&&ch=='}')||(old=='['&&ch==']')||(old=='('&&ch==')')){
						System.out.println("match ok,char[" + i+ "]="+ch);
						continue;	
					}else{
						System.out.println("match error,char[" + i+ "]="+ch);
						return false;
					}
				}else{
					return false;
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
