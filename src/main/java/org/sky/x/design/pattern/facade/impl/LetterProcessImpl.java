package org.sky.x.design.pattern.facade.impl;

import org.sky.x.design.pattern.facade.LetterProcess;

/**
 * **************************************************************
 * <p>
 * @DESCRIPTION :
 * @AUTHOR : andy.meng@xiu.com
 * @DATE :Oct 26, 2012 3:25:46 PM
 * </p>
 * ***************************************************************
 */
public class LetterProcessImpl implements LetterProcess {

	@Override
	public void writeContext(String context) {
		System.out.println("填写信的内容...." + context);
	}

	@Override
	public void fillEnvelope(String address) {
		System.out.println("填写收件人地址及姓名...." + address);
	}

	@Override
	public void letterInotoEnvelope() {
		System.out.println("把信放到信封中....");
	}

	@Override
	public void sendLetter() {
		System.out.println("邮递信件...");
	}
	
	//写信，封装，投递，一体化了
	public void sendLetterFacade(String context, String address) {
		
		// 帮你写信
		letterProcess.writeContext(context);
		
		// 写好信封
		letterProcess.fillEnvelope(address);
		
		// 把信放到信封中
		letterProcess.letterInotoEnvelope();
		
		// 邮递信件
		letterProcess.sendLetter();
		
	}

	//写信，封装，投递，客户端调用
	private static void sendLetterClient() {
		
		// 创建一个处理信件的过程
		LetterProcess letterProcess = new LetterProcessImpl();
		
		// 开始写信
		letterProcess.writeContext("Hello,It's me,do you know who I am? I'm your old lover. I'd like to....");
		
		// 开始写信封
		letterProcess.fillEnvelope("Happy Road No. 666,God Province,Heaven");
		
		// 把信放到信封里，并封装好
		letterProcess.letterInotoEnvelope();
		
		// 跑到邮局把信塞到邮箱，投递
		letterProcess.sendLetter();
		
	}
	

	public static void main(String[] args) {

		sendLetterClient();
		
		LetterProcess letterProcessInstall = new LetterProcessImpl();
		String address = "Happy Road No. 666,God Province,Heaven"; //定义一个地址
		String context = "Hello,It's me,do you know who I am? I'm your old lover. I'd like to....";
		letterProcessInstall.sendLetterFacade(context, address);

	}
	
	private LetterProcess letterProcess = new LetterProcessImpl();

}
