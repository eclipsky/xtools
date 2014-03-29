package org.sky.x.design.pattern.prototype.demo;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Nov 5, 2012 12:19:12 PM
 * </p>
 **************************************************************** 
 */
public class Mail implements Cloneable {

	// 收件人
	private String receiver;
	// 邮件名称
	private String subject;
	// 称谓
	private String appellation;
	// 邮件内容
	private String contxt;
	// 邮件的尾部，一般都是加上“XXX版权所有”等信息
	private String tail;

	// 构造函数
	public Mail(AdvTemplate advTemplate) {
		this.contxt = advTemplate.getAdvContext();
		this.subject = advTemplate.getAdvSubject();
	}

	// 以下为getter/setter方法
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getContxt() {
		return contxt;
	}

	public void setContxt(String contxt) {
		this.contxt = contxt;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}
	
	@Override
	public Mail clone() {
		Mail mail = null;
		try {
			mail = (Mail) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return mail;
	}
	
	public Mail(){
		System.out.println("Mail class Mail()");
	}
	
	/**
	 * @Description: 对象拷贝时，类的构造函数是不会被执行的。
	 *               对象拷贝时确实构造函数没有被执行，这个从原理来讲也是可以讲得通的，
	 *               Object类的clone方法的原理是从内存中（具体的说就是堆内存）以二进制流的方式进行拷贝，
	 *               重新分配一个内存块，那构造函数没有被执行也是非常正常的了。
	 * @param args
	 */
	public static void main(String[] args) {
		
		//产生一个对象
		Mail mail =  new Mail();
		
		//拷贝一个对象
		Mail cloneMail =  mail.clone();
		
		System.out.println("mail.hashCode()="+mail.hashCode()+",cloneMail.hashCode()="+cloneMail.hashCode());
		System.err.println("mail!=cloneMail : "+(mail!=cloneMail));
		
	}

}
