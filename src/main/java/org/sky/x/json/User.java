package org.sky.x.json;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Nov 5, 2012 6:42:55 PM
 * </p>
 **************************************************************** 
 */
public class User {
	
	public User(){
		
	}
	
	public User(int uid,String uname,String upwd,double nubmer) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.number = nubmer;
	}

	private int uid;
	private String uname;
	private String upwd;
	private double number;

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	@Override
	public String toString() {
		return "uid=" + uid + ",uname=" + uname + ",upwd=" + upwd + ",number="+ number;
	}

}
