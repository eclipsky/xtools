package org.sky.x.design.pattern.prototype.demo;

import java.util.Random;

/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 原型模式适合在什么场景使用？
 *                一是类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等；
 *                二是通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式；
 *                三是一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
 *                在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone的方法创建一个对象，然后由工厂方法提供给调用者。
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Nov 5, 2012 12:20:15 PM
 * </p>
 **************************************************************** 
 */
public class Client {

	// 发送账单的数量，这个值是从数据库中获得
	private static int MAX_COUNT = 6;

	public static void main(String[] args) {
		
		//支持单线程的邮件发送
		//sendMailSupportSingleThread();
		
		//支持多线程的邮件发送
		sendMailSupportMultiThread();
		
	}

	//支持单线程的邮件发送
	@SuppressWarnings("unused")
	private static void sendMailSupportSingleThread() {
		// 模拟发送邮件
		int i = 0;
		// 把模板定义出来，这个是从数据库中获得
		Mail mail = new Mail(new AdvTemplate());
		mail.setTail("XX银行版权所有");
		while (i < MAX_COUNT) {
			// 以下是每封邮件不同的地方
			mail.setAppellation(getRandString(5) + " 先生（女士）");
			mail.setReceiver(getRandString(5) + "@" + getRandString(8)+ ".com");
			// 然后发送邮件
			sendMail(mail);
			i++;
		}
	}
	
	//支持多线程的邮件发送
	private static void sendMailSupportMultiThread() {
		// 模拟发送邮件
		int i = 0;
		// 把模板定义出来，这个是从数据库中获得
		Mail mail = new Mail(new AdvTemplate());
		mail.setTail("XX银行版权所有");
		while (i < MAX_COUNT) {
			// 以下是每封邮件不同的地方
			Mail cloneMail = mail.clone();
			cloneMail.setAppellation(getRandString(5)+" 先生（女士）");
			cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8)+".com");
			// 然后发送邮件
			sendMail(cloneMail);
			i++;
		}
	}

	// 发送邮件
	public static void sendMail(Mail mail) {
		System.out.println("标题：" + mail.getSubject() + "\t收件人："+ mail.getReceiver() + "\t....发送成功！");
	}

	// 获得指定长度的随机字符串
	public static String getRandString(int maxLength) {
		String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < maxLength; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}

}
