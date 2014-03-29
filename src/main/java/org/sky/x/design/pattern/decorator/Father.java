package org.sky.x.design.pattern.decorator;
/** 
 *************************************************************** 
 * <p>
 * @DESCRIPTION : 
 * @AUTHOR : andy.meng@xiu.com 
 * @DATE :Oct 29, 2012 5:01:34 PM
 * </p>
 **************************************************************** 
 */
public class Father {

	/**
	 * @Description: 
	 * @param args  
	 */
	public static void main(String[] args) {

		// 成绩单拿过来
		SchoolReport fgsr = new FouthGradeSchoolReport();
		
		// 看成绩单 签名？休想！
		//fgsr.report(); 
		
		//美化过的成绩单拿过来
		//SchoolReport sfgsr= new SugarFouthGradeSchoolReport();
		
		//看成绩单
		//sfgsr.report();
		
		//然后老爸，一看，很开心，就签名了
		//sfgsr.sign("老三"); //我叫小三，老爸当然叫老三
		
		
		//加了最高分说明的成绩单
		SchoolReport hd = new HighScoreDecorator(fgsr);
		hd.report();
		hd.sign("李四");

	}

}
