package org.sky.x.design.pattern.facade;

/**
 * **************************************************************
 * <p>
 * @DESCRIPTION :
 * @AUTHOR : andy.meng@xiu.com
 * @DATE :Oct 26, 2012 3:24:37 PM
 * </p>
 ****************************************************************
 */
public interface LetterProcess {

	// 首先要写信的内容
	public void writeContext(String context);

	// 其次写信封
	public void fillEnvelope(String address);

	// 把信放到信封里
	public void letterInotoEnvelope();

	// 然后邮递
	public void sendLetter();
	
	//写信，封装，投递，一体化了
	public void sendLetterFacade(String context, String address) ;

}
