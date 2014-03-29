package org.sky.x.design.pattern.decorator;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 装饰类，我要把我的成绩单装饰一下
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 29, 2012 5:41:53 PM
 * </p>
 **************************************************************** 
 */
public abstract class Decorator extends SchoolReport {

	// 成绩单还是要被看到的
	@Override
	public void report() {
		this.sr.report();
	}

	// 看完毕还是要签名的
	@Override
	public void sign(String name) {
		this.sr.sign(name);
	}
	
	// 构造函数，传递成绩单过来
	public Decorator(SchoolReport sr) {
		this.sr = sr;
	}
	
	// 首先我要知道是那个成绩单
	private SchoolReport sr;

}
