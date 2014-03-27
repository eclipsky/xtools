package org.sky.x.date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.sky.x.StrUtil;

public class DateUtil {
	
	final private static Calendar staticCal = newGregorianCalendar();
	
	protected DateUtil() {}

	/**
	 * 从date对象clone一个相同类型的对象<br/>
	 * 目前只考虑 Date,java.sql.Date,java.sql.Timestamp三种类型
	 * @param date 被clone的 <code>Date</code>对象
	 * @return clone的结果
	 */
	public static Date cloneDate(Date date) {
		return (Date) (date.clone());
	}


	/**
	 * 从一date对象得到一个表示该日期的临时Calendar对象,该对象只作为临时使用
	 * @param date
	 * @return 临时Calendar对象
	 */
	private static Calendar getStaticCalendars(Date date) {
		if (date != null)
			staticCal.setTime(date);
		else
			staticCal.setTimeInMillis(System.currentTimeMillis());
		return staticCal;
	}
	
	/**
	 * 获取当前日期的年
	 * @return 当前日期的年
	 */
	public static int getYear() {
		return (new GregorianCalendar()).get(Calendar.YEAR);
	}
	/**
	 * 获取当前日期的月
	 * @return 当前日期的月
	 */
	public static int getMonth() {
		return (new GregorianCalendar()).get(Calendar.MONTH) + 1;
	}
	/**
	 * 获取当前日期的日
	 * @return 当前日期的日
	 */
	public static int getDay() {
		return (new GregorianCalendar()).get(Calendar.DATE);
	}
	
	/**
	 * 获取日期对象date的年份数的部分
	 * @param date
	 * @return date的年份数的部分
	 */
	public static int getDateYear(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.YEAR); 
		}
	}
	/**
	 * 获取日期对象date的月份数的部分
	 * @param date
	 * @return date的月份数的部分
	 */
	public static int getDateMonth(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.MONTH) + 1;
		}
	}
	/**
	 * 获取日期对象date的日期数的部分
	 * @param date
	 * @return date的数的部分
	 */
	public static int getDateDay(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.DATE);
		}
	}
	/**
	 * 获取日期对象date的小时数的部分
	 * @param date
	 * @return date的小时数的部分
	 */
	public static int getDateHours(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.HOUR_OF_DAY);
		}
	}
	/**
	 * 获取日期对象date的分钟数的部分
	 * @param date
	 * @return date的分钟数的部分
	 */
	public static int getDateMinutes(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.MINUTE);
		}
	}
	/**
	 * 获取日期对象date的秒数的部分
	 * @param date
	 * @return date的秒数的部分
	 */
	public static int getDateSeconds(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.SECOND);
		}
	}

	/**
	 * 返回星期几，周日是0,周一是1,周六是6
	 * @param date
	 * @return date的星期几
	 */
	public static int getWeekDay(Date date) {
		if (date == null)
			return 0;
		synchronized (staticCal) {
			return getStaticCalendars(date).get(Calendar.DAY_OF_WEEK) - 1;
		}
	}

	/**
	 * 获取date在这年中属于第几周(起始是0)
	 * @param date
	 * @return 第几周
	 */
	public static int indexOfYearWeek(Date date) {
		int year = DateUtil.getDateYear(date);
		return indexOfWeek(date, DateUtil.toDate(year, 1, 1));
	}
		
	/**
	 * 从fromDate日开始获取date所在周
	 * @param date
	 * @param fromDate 当前算第0周 
	 * @return 第几周
	 */
	public static int indexOfWeek(Date date, Date fromDate) {
		int days = DateUtil.diffDate(date, fromDate);
		int w0 = getWeekDay(fromDate);
		if(days >= 0){
			if (w0 == 0)
				return days / 7;
			else
				return days < 7 - w0 ? 0 : 1 + (days - (7 - w0)) / 7; 
		}else{
			if(w0 == 0)
				return -1 - (-days - 1) / 7;
			else
				return -days <= w0 ? 0 : -1 - (-days - 1 - w0) / 7;
		}
	}

	/**
	 * 得到一个静态的Calendar临时对象
	 * @return 静态的Calendar临时对象
	 */
	public static Calendar getStaticCalendars() {
		return getStaticCalendars(null);
	}

	/**
	 * 得到一个静态的 给定日期和时间的 Calendar临时对象
	 * @param time 给定Calendar 临时对象表示的日期和时间
	 * @return 一个静态的给定日期和时间(long time)Calendar临时对象
	 */
	public static Calendar getStaticCalendars(long time) {
		synchronized (staticCal) {
			staticCal.setTimeInMillis(time);
			return staticCal;
		}
	}

	/**
	 * 从年月日得到一个Date对象
	 */
	public static Date toDate(int year, int month, int day) {
		synchronized (staticCal) {
			staticCal.clear();
			staticCal.set(Calendar.YEAR, year);
			staticCal.set(Calendar.MONTH, month - 1);
			staticCal.set(Calendar.DAY_OF_MONTH, day); // day-1??
			staticCal.set(Calendar.HOUR_OF_DAY, 0);
			staticCal.set(Calendar.MINUTE, 0);
			staticCal.set(Calendar.SECOND, 0);
			return staticCal.getTime();// .getTime();
		}
	}

	/**
	 * 将value转化成date对象
	 * @param value 可为Date或Long或者String("2000-9-7", "2002-6-1 14:15" , "2002-6-1 14:15:30")
	 * @return 转化后date对象
	 */
	public static Date toDate(Object value) {
		if (value instanceof String)
			return textToDate((String) value);
		if (value instanceof Date)
			return (Date) value;
		if (value instanceof Long)
			return new Date(((Long) value).longValue());
		return null;
	}
	/**
	 * 将一个long转化为日期格式
	 * @param date
	 * @return 转化后date对象
	 */
	public static Date toDate(long date) {
		return new Date(date);
	}

	/**
	 * 从表示日期的字符串("2000-9-7", "2002-6-1 14:15" , "2002-6-1 14:15:30")得到一个Date对象
	 * @param text
	 * @return 转化后date对象
	 */
	public static Date textToDate(String text) {
		if (text == null)
			return null;
		text = text.trim();
		if (text.length() == 0)
			return null;
		int r[] = new int[6];
		if (!DateUtil.parseDateTime(text, r))
			return null;
		return DateUtil.toDate(r[0], r[1], r[2], r[3], r[4], r[5]);
	}

	/**
	 * 从给定的 year,mongth,day 得到时间的long值表示(a point in time that is <tt>time</tt>
	 * milliseconds after January 1, 1970 00:00:00 GMT).
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 给定的 year,mongth,day 得到时间的long值表示
	 */
	public static long toLongTime(int year, int month, int day) {
		return toLongTime(year, month, day, 0, 0, 0);
	}
	
	/**
	 * 通过年月日时分秒获取一个日期对象的毫秒数
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param min
	 * @param sec
	 * @return 毫秒数
	 */
	public static long toLongTime(int year, int month, int day, int hour,int min, int sec) {
		synchronized (staticCal) {
			staticCal.clear();
			staticCal.set(Calendar.YEAR, year);
			staticCal.set(Calendar.MONTH, month - 1);
			staticCal.set(Calendar.DAY_OF_MONTH, day);
			staticCal.set(Calendar.HOUR_OF_DAY, hour);
			staticCal.set(Calendar.MINUTE, min);
			staticCal.set(Calendar.SECOND, sec);
			return staticCal.getTime().getTime();
		}
	}
	
	/**
	 * 通过年月日时分秒毫秒获取一个日期对象的毫秒数
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param min
	 * @param sec
	 * @param millSec
	 * @return 毫秒数
	 */
	public static long toLongTime(int year, int month, int day, int hour,int min, int sec, int millSec) {
		synchronized (staticCal) {
			staticCal.clear();
			staticCal.set(Calendar.YEAR, year);
			staticCal.set(Calendar.MONTH, month - 1);
			staticCal.set(Calendar.DAY_OF_MONTH, day);
			staticCal.set(Calendar.HOUR_OF_DAY, hour);
			staticCal.set(Calendar.MINUTE, min);
			staticCal.set(Calendar.SECOND, sec);
			staticCal.set(Calendar.MILLISECOND, millSec);
			return staticCal.getTime().getTime();
		}
	}
	
	/**
	 * 通过年月日时分秒获取一个日期对象
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param min
	 * @param sec
	 * @return 转化后date对象
	 */
	public static Date toDate(int year, int month, int day, int hour,int min, int sec) {
		return new Date(toLongTime(year, month, day, hour, min, sec));
	}
	
	/**
	 * 将date转化成年月日时分秒毫秒的int数组
	 * @param date
	 * @return 封装日期的七个数值的int数组
	 */
	public static int[] getDateElements(Date date) {
		if (date == null)
			return null;
		synchronized (staticCal) {
			Calendar cal = getStaticCalendars(date);
			int ymd[] = new int[7];
			ymd[0] = cal.get(Calendar.YEAR);
			ymd[1] = cal.get(Calendar.MONTH) + 1;
			ymd[2] = cal.get(Calendar.DATE);
			ymd[3] = cal.get(Calendar.HOUR_OF_DAY);
			ymd[4] = cal.get(Calendar.MINUTE);
			ymd[5] = cal.get(Calendar.SECOND);
			ymd[6] = cal.get(Calendar.MILLISECOND);
			return ymd;
		}
	}
	/**
	 * 将date转化成年月日时分秒毫秒的int数组
	 * @param date
	 * @return 封装日期的六个数值的int数组
	 */
	public static int[] getDateElements(long date) {
		synchronized (staticCal) {
			Calendar cal = getStaticCalendars(date);
			int ymd[] = new int[7];
			ymd[0] = cal.get(Calendar.YEAR);
			ymd[1] = cal.get(Calendar.MONTH) + 1;
			ymd[2] = cal.get(Calendar.DATE);
			ymd[3] = cal.get(Calendar.HOUR_OF_DAY);
			ymd[4] = cal.get(Calendar.MINUTE);
			ymd[5] = cal.get(Calendar.SECOND);
			ymd[6] = cal.get(Calendar.MILLISECOND);
			return ymd;
		}
	}

	/**
	 * 当天日期(不含时分秒)
	 */
	public static Date today0() {
		java.util.Calendar date = newGregorianCalendar();
		date.setTime(today());
		date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		date.set(Calendar.MILLISECOND, 0);
		return date.getTime();
	}
	
	/**
	 * 获取将aDate的时分秒毫秒都抹去后的新的日期对象，原本的aDate不做变动
	 * @param aDate
	 * @return 转化后date对象
	 */
	public static Date toDate0(Date aDate) {
		if (aDate == null)
			return null;
		synchronized (staticCal) {
			java.util.Calendar date = getStaticCalendars(aDate);
			date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			date.set(Calendar.MILLISECOND, 0);
			return date.getTime();
		}
	}
	
	/**
	 * 获取系统当前时间
	 * @return 系统当前时间
	 */
	public static Date today() {
		//获取要因为分布式而扩展成同步的
		return new Date();
	}
	
	/**
	 * 获取当前时间毫秒数
	 * @return 当前时间毫秒数
	 */
	public static long todayTime() {
		//return System.currentTimeMillis();
		return today().getTime();
	}
	
	/**
	 * 获取date的毫秒数
	 * @param date 需要为Date类型的
	 * @return ate的毫秒数
	 */
	public static long getDateTime(Object date) {
		return date instanceof Date ? ((Date) date).getTime() : 0;
	}

	/**
	 * 求给定 某年、某月的最大天数.例如getDaysOfMonth(2000,1)范围31,getDaysOfMonth(2000,2)返回28
	 * @param year 年
	 * @param month 月
	 * @return 给定年、月的最大天数(1月返回31,2月返回28或29,3月返回31,...,12月返回31)
	 */
	public static int getDaysOfMonth(int year, int month) {
		return (int) ( (DateUtil.toLongTime(month == 12 ? 
							(year + 1) 
							: year,month == 12 ? 1 : (month + 1), 1) - DateUtil.toLongTime(year,month, 1)
					   )/(24 * 60 * 60 * 1000)
					 );
	}
	
	/**
	 * 求某一日期加day后的日期
	 * @param date
	 * @param day day为负数时是减
	 * @return 新的日期对象
	 */
	public static Date incDate(Date date, int day) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, day);
		return cal.getTime();
	}
	
	/**
	 * 将日期对象date增加nMonth后获得一个新的时间对象
	 * @param date
	 * @param nMonth
	 * @param options bit 1:防止日期超出月份的最大范围
	 * @return 新的日期对象
	 * DateUtil.incMonth(DateUtil.toDate(2013, 1, 31), 1, 1)//2013-02-28
	 * DateUtil.incMonth(DateUtil.toDate(2013, 1, 31), 1, 0)//2013-03-03
	 */
	public static Date incMonth(Date date, int nMonth,int options) {
		if (date == null || nMonth == 0)
			return date;
		int e[] = DateUtil.getDateElements(date);
		e[1] += nMonth;
		for (; e[1] > 12;) {
			e[1] -= 12;
			e[0]++;
		}
		for (; e[1] <= 0;) {
			e[1] += 12;
			e[0]--;
		}
		if ((options & 1) != 0) {
			int days = DateUtil.getDaysOfMonth(e[0], e[1]);
			if(e[2] > days)
				e[2] = days;
		}
		return new Date(toLongTime(e[0], e[1], e[2], e[3], e[4],e[5], e[6]));
	}

	/**
	 * 将ymd中代表的年月日相加day天后的新日期的年月日更新进ymd数组对应的年月日中
	 * @param ymd  包含年月日的int数组
	 * @param idx0 代表年(y)的元素在ymd中起始坐标
	 * @param day  增加的天数
	 */
	public static void incYearMonthDay(int ymd[], int idx0, int day) {
		Date date = incDate(toDate(ymd[idx0 + 0], ymd[idx0 + 1], ymd[idx0 + 2]), day);
		ymd[idx0 + 0] = getDateYear(date);
		ymd[idx0 + 1] = getDateMonth(date);
		ymd[idx0 + 2] = getDateDay(date);
	}

	/**
	 * 求两个日期之间相差的天数(日期相减)
	 * 
	 * @param date1 相减的第一的日期
	 * @param date2 相减的第二的日期
	 * @return date1 与 date2 之间相差的天数
	 */
	public static int diffDate(Calendar date1, Calendar date2) {
		return (int) (
						(toLongTime(date1.get(Calendar.YEAR),date1.get(Calendar.MONTH) + 1, date1.get(Calendar.DATE)) 
						- toLongTime(date2.get(Calendar.YEAR), date2.get(Calendar.MONTH) + 1,date2.get(Calendar.DATE))
					 ) / (24 * 60 * 60 * 1000));
	}
	
	/**
	 * 求date1和date2相差多少天
	 * @param date1
	 * @param date2
	 * @return 相差的天数
	 */
	public static int diffDate(Date date1, Date date2) {
		return (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
	}
	
	/**
	 * 求date1和date2之间相差多少秒
	 * @param date1
	 * @param date2
	 * @return 相差的秒数
	 */
	public static long diffSeconds(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / 1000l;
	}

	/**
	 * 日期类型转换成字符串表示(yyyy-mm-dd hh:mm:ss)
	 * 
	 * @param date
	 * @return 日期的字符串表示
	 */
	public static final String dateToString(Date date) {
		return dateToString(date, 0);
	}
	public static final String dateToString(long date) {
		return dateToString(new Date(date));
	}
	public static final String dateToString(long date, int hmsFormat) {
		return dateToString(new Date(date), hmsFormat);
	}
	/**
	 * 得到一个日期对象的字符串表示(yyyy-mm-dd hh:mm:ss).
	 * 当时、分、秒都为0时，表示的时间字符串中只含年、月、日形式(yyyy-mm-dd)
	 * 
	 * @param date 日期对象
	 * @param hmsFormat   bit <blockquote><p>
     *                    1： 总是   yyyy-mm-dd hh:mm:ss 格式<br/>
     *                    2: 只含年、月、日形式<br/>
     *                    4: yyyy-mm-dd hh:mm<br/>
     *                    5： 总是   yyyy-mm-dd hh:mm:ss.ms 格式(带毫秒)<br/>
     *                    0x1X :  yyyy 两位 </p></blockquote>
	 * @return 转化后字符串
	 */
	public static final String dateToString(Date date, int hmsFormat) {
		synchronized (staticCal) {
			if (hmsFormat == 0 && date instanceof java.sql.Date)
				hmsFormat = 2;
			return calendarToString(DateUtil.getStaticCalendars(date),hmsFormat);
		}
	}
	public static final String calendarToString(final java.util.Calendar cal, int hmsFormat) {
		final int options = hmsFormat >> 4;
		hmsFormat &= 0xf;
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String yearText = Integer.toString(year);
		if ((options & 1) != 0 && yearText.length() > 2)
			yearText = yearText.substring(yearText.length() - 2);
		String text = yearText + (month < 10 ? "-0" : "-") + month
				+ (day < 10 ? "-0" : "-") + day;
		if (hmsFormat == 2)
			return text;
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		if (hmsFormat == 4)
			return text + " " + StrUtil.toStr2(hour) + ":" + StrUtil.toStr2(min);
		int sec = cal.get(Calendar.SECOND);
		if (hmsFormat == 1)
			return text + " " + StrUtil.toStr2(hour) + ":" + StrUtil.toStr2(min) + ":"
					+ StrUtil.toStr2(sec);
		if (hmsFormat == 5)
			return text + " " + StrUtil.toStr2(hour) + ":" + StrUtil.toStr2(min) + ":"
					+ StrUtil.toStr2(sec) + "." + cal.get(Calendar.MILLISECOND);
		if (hour == 0 && min == 0 && sec == 0)
			return text;
		return sec == 0 ? text + " " + StrUtil.toStr2(hour) + ":" + StrUtil.toStr2(min) : text
				+ " " + StrUtil.toStr2(hour) + ":" + StrUtil.toStr2(min) + ":" + StrUtil.toStr2(sec);
	}
	
	/**
	 * 将秒数转化为hh:mm:ss格式现实
	 * @param seconds
	 * @return 转化后字符串
	 */
	public static String secondsToString(int seconds) {
		int h = seconds / (60 * 60);
		int m = seconds / 60 % 60;
		int s = seconds % 60;
		return StrUtil.toStr2(h) + ":" + StrUtil.toStr2(m) + (s == 0 ? "" : ":" + StrUtil.toStr2(s));
	}
	
	/**
	 * 将date转化成英文的显示方式
	 * @param date
	 * @return 转化后字符串
	 */
	public static String dateToEnglishString(Date date) {
		return dateToEnglishString(date, true, '-', '-');
	}
	/**
	 * 将date转化成英文的显示方式
	 * @param date		待转化的日期对象
	 * @param shortMonth 是否简写月份
	 * @param deliMD	月份与日的连接符
	 * @param deliDY	日与年的连接符
	 * @return 转化后字符串
	 */
	public static String dateToEnglishString(Date date,boolean shortMonth, char deliMD, char deliDY) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int m = calendar.get(Calendar.MONTH);
		String month;
		if (shortMonth)
			month = "JanFebMarAprMayJunJulAugSepOctNovDec".substring(m * 3,m * 3 + 3);
		else {
			String emonth[] = new String[] { "January", "February", "March",
					"April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			month = emonth[m];
		}
		return month + deliMD + calendar.get(Calendar.DATE) + deliDY + calendar.get(Calendar.YEAR);
	}
	/**
	 * 将date转化成中文汉字的显示方式
	 * @param date
	 * @return 转化后字符串
	 */
	public static final String toChnCapital(java.util.Date date) {
		if (date == null)
			return null;
		int year = DateUtil.getDateYear(date);
		int month = DateUtil.getDateMonth(date);
		int day = DateUtil.getDateDay(date);
		if (year < 1000 || year > 9999 || day < 1 || day > 31 || month < 1
				|| month > 12)
			throw new java.lang.IllegalArgumentException();
		String textYear = "";
		for (int i = 0; i < 4; i++) {
			textYear = "零一二三四五六七八九".charAt(year % 10) + textYear;
			year = year / 10;
		}
		String textMonth = month >= 10 ? "十" : "";
		if (month != 10)
			textMonth += "零一二三四五六七八九".charAt(month % 10);
		String textDay = day >= 20 ? ("" + ("零一二三四五六七八九".charAt(day / 10)))
				: "";
		if (day >= 10)
			textDay += "十";
		if (day % 10 != 0)
			textDay += "零一二三四五六七八九".charAt(day % 10);
		return textYear + "年" + textMonth + "月" + textDay + "日";
	}
	
	/**
	 * 获取一个表示起始范围的日期数组
	 * @param text  <blockquote><p>
	 * 				①可为日期格式的字符串<br/>
	 * 				②也可为用..连接的两个日期格式的字符串<br/>
	 * 				③也可为monthtri(1-3代表上中下旬),quarter(1-4代表1-4季度),semiyear(1-2代表上下半年)<br/>
	 * 					或day,month,year,week为后者的时候可加a(代表向后推移)前缀和t(代表是从referDate到推移后的那天)后缀
	 * 				</p></blockquote>
	 * @param referDate	当text为③时才有用,作为参考的日期
	 * @param caseTime 范围中较大的日期是否包含时分秒毫秒
	 * @return 表示起始范围的日期数组
	 * 
	 * 	Date today = DateUtil.toDate(2012, 2, 3,1,0,0);<br/>
		Date[] darr = DateUtil.parseDateRange("monthtri1", today, true);//2012-02-01 ~ 2012-02-10 23:59:59<br/>
		DateUtil.parseDateRange("semiyear2", today, true);//2012-07-01 ~ 2012-12-31 23:59:59<br/>
		DateUtil.parseDateRange("day3", today, true);//2012-02-01 01:00 ~ 2012-02-01 23:59:59 意为当前向前推三天的那一整天的范围<br/>
		DateUtil.parseDateRange("dayt3", today, true);//2012-02-01 01:00 ~ 2012-02-03 23:59:59 意为当前向前推三天知道今天一整天<br/>
		DateUtil.parseDateRange("aday3", today, true);//2012-02-06 01:00 ~ 2012-02-06 23:59:59 意为当当前天向后退三天的那一整天的范围<br/>
		DateUtil.parseDateRange("adayt3", today, true);//2012-02-04 01:00 ~ 2012-02-06 23:59:59 意为当前天结束到向后推三天那一整天的范围<br/>
		DateUtil.parseDateRange("month2", today, true);//2012-01-01 ~ 2012-01-31 23:59:59<br/>
		DateUtil.parseDateRange("amontht3", today, true);//2012-03-01 ~ 2012-05-31 23:59:59<br/>
		DateUtil.parseDateRange("year2", today, true);//2011-01-01 ~ 2011-12-31 23:59:59<br/>
		DateUtil.parseDateRange("ayeart2", today, true);//2013-01-01 ~ 2014-12-31 23:59:59<br/>
		DateUtil.parseDateRange("week2", today, true);//2012-01-23 01:00 ~ 2012-01-29 23:59:59<br/>
		DateUtil.parseDateRange("aweekt2", today, true);//2012-02-06 01:00 ~ 2012-02-19 23:59:59<br/>
	 */
	public final static Date[] parseDateRange(String text,Date referDate, boolean caseTime) {
		if (text == null || (text = text.trim().toLowerCase()).length() == 0)
			return null;
		int p = text.indexOf("..");
		if (p >= 0) {
			String s1 = text.substring(0, p);
			Date date1 = DateUtil.toDate(s1);
			if (date1 == null && s1.trim().length() > 0)
				return null;
			String s2 = text.substring(p + 2);
			Date date2 = DateUtil.toDate(s2);
			if (date2 == null && s2.trim().length() > 0)
				return null;
			return date1 != null || date2 != null ? new Date[] {date1, caseTime ? setDayEndTime(date2) : date2 } : null;
		}
		if (text.charAt(0) >= 'a' && text.charAt(0) <= 'z') {
			if (referDate == null)
				referDate = DateUtil.today0();
			p = text.indexOf(':');
			if (p >= 0) {
				text = text.substring(0, p).trim();
				if (text.length() == 0)
					return null;
			}
			p = text.length();
			for (; p > 0 && text.charAt(p - 1) >= '0' && text.charAt(p - 1) <= '9'; p--)
				;
			if (p == text.length() || p <= 0)
				return null;
			int n = Integer.parseInt(text.substring(p));
			final int thisYear = DateUtil.getDateYear(referDate);
			final int thisMonth = DateUtil.getDateMonth(referDate);
			text = text.substring(0, p);
			Date fromDate = null, toDate = null;
			if("monthtri".equals(text)){ //上中下旬(1-3)
				if (n < 1 || n > 3)
					return null;
				int fromDay = (n - 1) * 10 + 1;
				int toDay = n == 3 ? DateUtil.getDaysOfMonth(thisYear,
						thisMonth) : fromDay + 9;
				fromDate = DateUtil.toDate(thisYear, thisMonth, fromDay);
				toDate = DateUtil.toDate(thisYear, thisMonth, toDay);
			}else if("quarter".equals(text)){ //季度(1-4)
				if (n < 1 || n > 4)
					return null;
				int fromMonth = (n - 1) * 3 + 1, toMonth = fromMonth + 2;
				fromDate = DateUtil.toDate(thisYear, fromMonth, 1);
				toDate = DateUtil.toDate(thisYear, toMonth,
						DateUtil.getDaysOfMonth(thisYear, toMonth));
			}else if("semiyear".equals(text)){ //半年(1-2)
				if (n < 1 || n > 2)
					return null;
				fromDate = DateUtil.toDate(thisYear, n == 1 ? 1 : 7, 1);
				toDate = DateUtil.toDate(thisYear, n == 1 ? 6 : 12, n == 1 ? 30
						: 31);
			}else{
				final boolean total = text.charAt(text.length() - 1) == 't';
				if(total){
					text = text.substring(0, text.length() - 1);
					if (text.length() == 0)
						return null;
				}
				final boolean after = text.charAt(0) == 'a';
				if(after){
					text = text.substring(1);
				}else{//近 xxx
					n = -(n - 1);
				}
				if("day".equals(text)){
					toDate = DateUtil.incDate(referDate, n);
					fromDate = total ? (after ? DateUtil.incDate(referDate, 1) : referDate) : toDate;
				}else if ("month".equals(text)){
					int toMonth = thisMonth + n;
					int fromMonth = total ? (after ? thisMonth + 1 : thisMonth) : toMonth;
					if (toMonth < fromMonth) {
						int tmp = fromMonth;
						fromMonth = toMonth;
						toMonth = tmp;
					}
					int fromYear = thisYear, toYear = thisYear;
					for(; fromMonth < 1; fromMonth += 12, fromYear--)
						;
					for(; fromMonth > 13; fromMonth -= 12, fromYear++)
						;
					for(; toMonth < 1; toMonth += 12, toYear--)
						;
					for(; toMonth > 13; toMonth -= 12, toYear++)
						;
					toDate = DateUtil.toDate(toYear, toMonth, DateUtil.getDaysOfMonth(toYear, toMonth));
					fromDate = DateUtil.toDate(fromYear, fromMonth, 1);
				}else if("year".equals(text)){
					int toYear = thisYear + n;
					int fromYear = total ? (after ? thisYear + 1 : thisYear) : toYear;
					if(toYear < fromYear){
						int tmp = fromYear;
						fromYear = toYear;
						toYear = tmp;
					}
					toDate = DateUtil.toDate(toYear, 12, 31);
					fromDate = DateUtil.toDate(fromYear, 1, 1);
				}else if("week".equals(text)){
					int wd = DateUtil.getWeekDay(referDate);
					final Date week1Date = DateUtil.incDate(referDate, wd == 0 ? -6 : 1 - wd);//week1Date本周的周一那天的日期：
					int toWeek = n;
					int fromWeek = total ? (after ? 1 : 0) : toWeek;
					if (toWeek < fromWeek) {
						int tmp = fromWeek;
						fromWeek = toWeek;
						toWeek = tmp;
					}
					fromDate = DateUtil.incDate(week1Date, fromWeek * 7);
					toDate = DateUtil.incDate(week1Date, toWeek * 7 + 6);
				}
			}
			if(fromDate != null && toDate != null){
				return (toDate.getTime() < fromDate.getTime() ) ? 
							new Date[] {toDate, caseTime ? setDayEndTime(fromDate) : fromDate } 
						: 	new Date[] {fromDate,caseTime ? setDayEndTime(toDate) : toDate };
			}
			return null;
		}
		//如果上面的text不包含字母
		Date date = DateUtil.toDate(text);
		return date == null ? null : new Date[]{ date,caseTime ? setDayEndTime(date) : date };
	}
	private static Date setDayEndTime(Date date) {
		if (date == null)
			return null;
		int a[] = DateUtil.getDateElements(date);
		return DateUtil.toDate(a[0], a[1], a[2], 23, 59, 59);
	}
	
	/**
	 * 将text字符串按照format格式转化成日期格式
	 * @param text
	 * @param format 这里的格式最好用两个字母代表(如HH:MM代替H:M)否则容易出错
	 * @return 转化后日期对象
	 */
	public final static Date parseDate(String text, String format) {
		if (text == null)
			return null;
		format = format.toUpperCase();
		int n = format.length();
		if (text.length() != n)
			throw new RuntimeException("日期格式错:" + text);
		int ymd[] = new int[6];
		boolean hasHour = false;
		for (int i = 0; i < n; i++) {
			char c = text.charAt(i);
			char fc = format.charAt(i);
			int j = "YMDHMS".indexOf(fc);
			if (j >= 0) {
				if (j == 3)
					hasHour = true;
				else if (j == 1 && hasHour)
					j = 4;
				int d = c - '0';
				if (d < 0 || d > 9)
					throw new RuntimeException("日期格式错:" + text);
				ymd[j] = ymd[j] * 10 + d;
			} else if (c != fc)
				throw new RuntimeException("日期格式错:" + text);
		}
		if (ymd[0] < 100)
			ymd[0] += 2000;
		return DateUtil.toDate(ymd[0], ymd[1], ymd[2], ymd[3], ymd[4], ymd[5]);
	}
	
	/**
	 * 将date转化成format标示的字符串形式
	 * @param date	待转换日期对象
	 * @param format	支持Y(年)M(月)D(日)H(时)M(分)S(秒)
	 * @return  转化后字符串
	 */
	public final static String dateToString(Date date, String format) {
		if (date == null || format == null)
			return null;
		synchronized (staticCal) {
			Calendar cal = DateUtil.getStaticCalendars(date);
			int ymd[] = new int[6];
			ymd[0] = cal.get(Calendar.YEAR);
			ymd[1] = cal.get(Calendar.MONTH) + 1;
			ymd[2] = cal.get(Calendar.DAY_OF_MONTH);
			ymd[3] = cal.get(Calendar.HOUR_OF_DAY);
			ymd[4] = cal.get(Calendar.MINUTE);
			ymd[5] = cal.get(Calendar.SECOND);
			format = format.toUpperCase();
			int n = format.length();
			StringBuffer sb = new StringBuffer();
			boolean hasHour = false;
			for (int i = 0; i < n;) {
				char c = format.charAt(i++);
				int nd = 1;
				for (; i < n && format.charAt(i) == c; i++)
					nd++;
				int j = "YMDHMS".indexOf(c);
				if (j >= 0) {
					if (j == 3)
						hasHour = true;
					else if (j == 1 && hasHour)
						j = 4;
					String s = Integer
							.toString(j == 0 && nd == 2 ? ymd[0] % 100 : ymd[j]);
					for (; nd > s.length(); nd--) {
						sb.append('0');
					}
					sb.append(s);
				} else {
					for (; nd > 0; nd--) {
						sb.append(c);
					}
				}
			}
			return sb.toString();
		}
	}

	
	private static String hmdDelim;
	/**
	 * 将格式为YYYYMMDDHHmmss(或者yyyy-mm-dd hh:mm:ss)的text字符串的年，月，日，时，分，秒六部分放入ret中
	 * 如果这个text为标准的日期字符串则返回true
	 * @param text
	 * @param ret
	 * @return 是否转化成功
	 */
	public final static boolean parseDateTime(String text, int[] ret) {
		if (hmdDelim == null) {
			try {
				hmdDelim = System.getProperty("Date.HMDDELIM");
			} catch (Throwable ex) {
			}
			if (hmdDelim == null || hmdDelim.length() == 0)
				hmdDelim = "-";
		}
		text = text.trim();
		if (ret == null)
			ret = new int[6];
		int l = text.length();
		if ((l == 8 || l == 10 || l == 12 || l == 14) && isDigites(text)) {
			ret[0] = Integer.parseInt(text.substring(0, 4));
			ret[1] = Integer.parseInt(text.substring(4, 6));
			ret[2] = Integer.parseInt(text.substring(6, 8));
			ret[3] = l > 8 ? Integer.parseInt(text.substring(8, 10)) : 0;
			ret[4] = l > 10 ? Integer.parseInt(text.substring(10, 12)) : 0;
			ret[5] = l > 12 ? Integer.parseInt(text.substring(12, 14)) : 0;
		} else {
			String[] a = splitDateText(text);
			if (a == null || a.length < 5 || a.length > 13 || (a.length & 1) == 0)
				return false;
			for (int i = 0; i < ret.length && i * 2 < a.length; i++) {
				ret[i] = StrUtil.obj2int(a[i * 2]);
				if (i == 0)
					continue;
				final String s = a[i * 2 - 1];
				if (s.length() > 1)
					return false;
				final String validS;
				if (i <= 2) {
					validS = hmdDelim;
				} else if (i == 3) {
					if (s.length() > 0)
						return false;
					continue;
				} else if (i <= 5) {
					validS = ":";
				} else{ // if( i>5 )
					validS = ".";
				}
				if (s.length() != 1 || validS.indexOf(s.charAt(0)) < 0)
					return false;
			}
			if (ret[0] >= 0 && ret[0] < 100) {
				if (ret[0] >= 70)
					ret[0] += 1900;
				else
					ret[0] += 2000;
			}
		}
		if (ret[3] < 0 || ret[3] >= 24)
			return false;
		if (ret[4] < 0 || ret[4] >= 60)
			return false;
		if (ret[5] < 0 || ret[5] >= 60)
			return false;
		return ret[0] >= 1000 && ret[0] < 3999 && ret[1] >= 1 && ret[1] <= 12
				&& ret[2] >= 1 && ret[2] <= getDaysOfMonth(ret[0], ret[1]);
	}
	/**
	 * 将格式为YYYYMMDD(或者yyyy-mm-dd)的text字符串的年，月，日三部分放入ret中
	 * @param text
	 * @param ret
	 * @return 是否转化成功
	 */
	public final static boolean parseDate(String text, int ret[]) {
		int tmp[] = new int[6];
		if (text.length() == 8 && isDigites(text)) {
			tmp[0] = Integer.parseInt(text.substring(0, 4));
			tmp[1] = Integer.parseInt(text.substring(4, 6));
			tmp[2] = Integer.parseInt(text.substring(6, 8));
		} else {
			if (!parseDateTime(text + " 0:0:0", tmp))
				return false;
		}
		if (ret != null)
			for (int i = 0; i < 3; i++)
				ret[i] = tmp[i];
		return true;
	}
	private static boolean isDigites(String text) {
		final int n = text.length();
		for (int i = 0; i < n; i++) {
			char c = text.charAt(i);
			if (c < '0' || c > '9')
				return false;
		}
		return true;
	}
	private static String[] splitDateText(String text) {
		java.util.List<String> list = new ArrayList<String>();
		final int n = text.length();
		int i = 0;
		int j = 0;
		for (; i < n;) {
			int i0 = i;
			for (; i < n; i++) {
				char c = text.charAt(i);
				if ((j & 1) == 0 ? (c < '0' || c > '9') : (c >= '0' && c <= '9'))
					break;
			}
			if (i <= i0)
				break;
			list.add(text.substring(i0, i).trim());
			j++;
		}
		if (i < n)
			return null;
		return list.toArray(new String[list.size()]);
	}
	
	static Calendar newGregorianCalendar() {
		return Calendar.getInstance();
	}
	
	/**
	 * 获取year年month月中的周六周日的天数,采用的是二进制或运算，前端展示采用与运算进行解释
	 * @param year
	 * @param month
	 * @return
	 
	public static int getDefaultHolidays(int year, int month) {
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);
		int x = 0;
		for (int d = 0;; d++) {
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
				x |= (1 << d);
			cal.add(Calendar.DAY_OF_YEAR, 1);
			if (cal.get(Calendar.MONTH) + 1 != month)
				break;
		}
		return x;
	}*/
	
	/**
	 * 参见toDate0
	 * @param date
	 * @return
	 
	@Deprecated
	public static long getTime0(Date date) {
		synchronized (staticCal) {
			java.util.Calendar cal = getStaticCalendars(date);
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime().getTime();
		}
	}*/

}
