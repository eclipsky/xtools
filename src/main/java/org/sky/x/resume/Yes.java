package org.sky.x.resume;

public class Yes{
	public static void main(String[] args){
		String str = "��love��";
		int num = trimNum(str.getBytes(),7); 
		String result = str.substring(0,num);
		System.out.println(result);
		int english = 0;
		int chinese = 0;
		int digital = 0;
		char var;
		for(int i=0;i<str.length();i++){
			var=str.charAt(i);
			if((var>='A'&&var<='Z')||(var>='a'&&var<='z')){
				english++;
			}else if(var>='0' && var <= '9'){
				digital++;
			}else{
				chinese++;
			}
		}
		System.out.println("��ĸ"+english);
		System.out.println("����"+digital);
		System.out.println("����"+chinese);
	}
	
	public static int trimNum(byte[] str,int num){
		int a = 0;
		boolean isHalf=false;
		for(int i = 0;i<num;i++){
			if(str[i]<0&&!isHalf){
				isHalf=true;
			}else{
				a++;
				isHalf=false;
			}
		}
		return a;
	}
}
