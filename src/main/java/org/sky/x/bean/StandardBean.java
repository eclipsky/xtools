package org.sky.x.bean;

/**
 * JavaBean的命名规范
 * 约定：A表示大写，a表示小写
 * 1.一般情况下，属性名对应的存取方法为get/set加上首字母大写的属性名
 * 2.如果属性第2个字母为大写，则存取方法为get/set加上属性原名
 * 3.如果属性名首字母为大写，第二个字母为小写，这是不被允许的
 * 4.如果属性名只有一个大写字母，这也是不被允许的
 * 
 * @author 	xieming
 * @date	2014-2-17
 */
public class StandardBean extends BaseBean{

	private Integer id;
	
	private String name;
	
	private String addr;
	
	private String IP;
	
	private String xRay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getxRay() {
		return xRay;
	}

	public void setxRay(String xRay) {
		this.xRay = xRay;
	}
	
}
