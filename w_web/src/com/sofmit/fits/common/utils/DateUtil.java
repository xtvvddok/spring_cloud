package com.sofmit.fits.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期工具�?
 * 
 * @author zhb
 * 
 */
public class DateUtil {
	/**
	 * 短日期格�?(yyyy-MM-dd)
	 */
	public static final String SHORT_DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 长日期格�?(yyyy-MM-dd HH:mm:ss)
	 */
	public static final String LONG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 长日期格�?yyyyMMDDHHmmss)
	 */
	public static final String LONG_DATE_NO_SIGN_PATTERN = "yyyyMMddHHmmss";
	/**
	 * 时间：一分钟
	 */
	private static final long MS_ONE_MINUTE = 60 * 1000;
	/**
	 * 时间：一小时
	 */
	private static final long MS_ONE_HOUR = 60 * MS_ONE_MINUTE;
	/**
	 * 时间：一�?
	 */
	private static final long MS_ONE_DAY = 24 * 60 * MS_ONE_MINUTE;
	/**
	 * 时间：一�?
	 */
	private static final long MS_ONE_WEEK = 7 * MS_ONE_DAY;
	/**
	 * 时间：一个月
	 */
	private static final long MS_ONE_MONTH = 30 * MS_ONE_DAY;
	/**
	 * 时间：一�?
	 */
	private static final long MS_ONE_YEAR = 365 * MS_ONE_DAY;

	private DateUtil() {
	}

	/**
	 * 获取当前日期，短日期格式yyyy-MM-dd
	 * 
	 * @return 当前日期
	 */
	public static String getCurrentDate() {
		return formatShort(new Date());
	}

	/**
	 * 获取当前时间，长日期格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 当前时间
	 */
	public static String getCurrentTime() {
		return formatLong(new Date());
	}

	/**
	 * 获取当前时间�?
	 * 
	 * @return 当前时间�?
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	/**
	 * 按照指定格式解析字符串型日期值为日期对象
	 * 
	 * @param date
	 *            字符串型日期
	 * @param pattern
	 *            日期格式
	 * @return 日期对象
	 */
	public static Date parse(String date, String pattern) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		DateFormat formater = new SimpleDateFormat(pattern);
		try {
			return formater.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 按照指定格式转换日期对象为字符串型日�?
	 * 
	 * @param date
	 *            日期对象
	 * @param pattern
	 *            日期格式
	 * @return 字符串型日期
	 */
	public static String format(Date date, String pattern) {
		DateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(date);
	}

	/**
	 * 按照短日期格�?yyyy-MM-dd)解析字符串型日期值为日期对象
	 * 
	 * @param date
	 *            字符串型日期
	 * @return 日期对象
	 */
	public static Date parseShort(String date) {
		return parse(date, SHORT_DATE_PATTERN);
	}
	public static Date parseShort(Date date){
		return parseShort((format(date, SHORT_DATE_PATTERN)));
	}
	/**
	 * 按照短日期格�?yyyy-MM-dd)转换日期对象为字符串型日�?
	 * 
	 * @param date
	 *            日期对象
	 * @return 字符串型日期
	 */
	public static String formatShort(Date date) {
		return format(date, SHORT_DATE_PATTERN);
	}

	/**
	 * 按照日期格式(yyyyMMddHHmmss)转换日期对象为字符串日期
	 * 
	 * @param date
	 *            日期对象
	 * @return 字符串日�?
	 */
	public static String fromatShortNoSign(Date date) {
		return format(date, LONG_DATE_NO_SIGN_PATTERN);
	}

	/**
	 * 按照长日期格�?yyyy-MM-dd HH:mm:ss)解析字符串型日期值为日期对象
	 * 
	 * @param date
	 *            字符串型日期
	 * @return 日期对象
	 */
	public static Date parseLong(String date) {
		return parse(date, LONG_DATE_PATTERN);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseLong(Date date) {
		return parseLong((format(date, LONG_DATE_PATTERN)));
	}

	/**
	 * 按照长日期格�?yyyy-MM-dd HH:mm:ss)转换日期对象为字符串型日�?
	 * 
	 * @param date
	 *            日期对象
	 * @return 字符串型日期
	 */
	public static String formatLong(Date date) {
		return format(date, LONG_DATE_PATTERN);
	}

	/**
	 * 获取指定时间的日历对�?
	 * 
	 * @param date
	 *            时间
	 * @return 日历对象
	 */
	public static Calendar getCalendar(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	/**
	 * 计算指定两个时间之间的相差天数�?如果earlierDate晚于laterDate，则返回负�?
	 * 
	 * @param earlierDate
	 *            较早时间
	 * @param laterDate
	 *            较晚时间
	 * @return 天数�?
	 */
	public static int daysBetween(Date earlierDate, Date laterDate) {
		long dms = laterDate.getTime() - earlierDate.getTime();
		return (int) (dms / MS_ONE_DAY);
	}

	/**
	 * 计算指定两个时间之间的相差小时之差�?如果earlierDate晚于laterDate，则返回负�?
	 * 
	 * @param earlierDate
	 *            较早时间
	 * @param laterDate
	 *            较晚时间
	 * @return 小时之差
	 */
	public static int hoursBetween(Date earlierDate, Date laterDate) {
		long dms = laterDate.getTime() - earlierDate.getTime();
		return (int) (dms / MS_ONE_HOUR);
	}

	public static int timeDifference(Date earlierDate, Date laterDate) {

		long dms = laterDate.getTime() - earlierDate.getTime();
		long fiveMinute = MS_ONE_MINUTE * 5;
		long tenMinute = MS_ONE_MINUTE * 10;
		long thirtyMinute = MS_ONE_MINUTE * 30;
		long fiveHour = MS_ONE_HOUR * 5;
		long tenHour = MS_ONE_HOUR * 10;
		long trenty_threeHour = MS_ONE_HOUR * 23;
		long twoDay = MS_ONE_DAY * 2;
		long twoWeek = MS_ONE_WEEK * 2;
		long twoMonth = MS_ONE_MONTH * 2;
		long twoYear = MS_ONE_YEAR * 2;

		// 小于5分钟：刚�?
		if (dms < fiveMinute) {
			return 1;
		}
		// 大于5分钟而小�?0分钟�?0分钟之前
		if ((dms > fiveMinute) && dms < tenMinute) {
			return 2;
		}
		// 大于10分钟而小�?0分钟�?0分钟之前
		if (dms > tenMinute && dms < thirtyMinute) {
			return 3;
		}
		// 大于30分钟而小�?小时�?小时之前
		if (dms > thirtyMinute && dms < MS_ONE_HOUR) {
			return 4;
		}
		// 大于1小时而小�?小时�?小时之前
		if (dms > MS_ONE_HOUR && dms < fiveHour) {
			return 5;
		}
		// 大于5小时而小�?0小时�?0小时之前
		if (dms > fiveHour && dms < tenHour) {
			return 6;
		}
		// 大于10小时而小�?3小时�?3小时之前
		if (dms > tenHour && dms < trenty_threeHour) {
			return 7;
		}
		// 大于23小时而小�?天：1天之�?
		if (dms > trenty_threeHour && dms < MS_ONE_DAY) {
			return 8;
		}
		// 大于1天�?小于2天：2天之�?
		if (dms > MS_ONE_DAY && dms < twoDay) {
			return 9;
		}
		// 大于2天�?小于1周：1周之�?
		if (dms > twoDay && dms < MS_ONE_WEEK) {
			return 10;
		}
		// 大于1周�?小于2周：2周之�?
		if (dms > MS_ONE_WEEK && dms < twoWeek) {
			return 11;
		}
		// 大于2周�?小于1个月�?个月之前
		if (dms > twoWeek && dms < MS_ONE_MONTH) {
			return 12;
		}
		// 大于1个月而小�?个月�?个月之前
		if (dms > MS_ONE_MONTH && dms < twoMonth) {
			return 13;
		}
		// 大于2个月而小�?年：1年之�?
		if (dms > twoMonth && dms < MS_ONE_YEAR) {
			return 14;
		}
		// 大于1年�?小于2年：2年之�?
		if (dms > MS_ONE_YEAR && dms < twoYear) {
			return 15;
		}

		return 16;

	}

	/**
	 * 计算指定两个时间之间的相差分钟数。如果earlierDate晚于laterDate，则返回负�?
	 * 
	 * @param earlierDate
	 *            较早时间
	 * @param laterDate
	 *            较晚时间
	 * @return 分钟�?
	 */
	public static int minutesBetween(Date earlierDate, Date laterDate) {
		long dms = laterDate.getTime() - earlierDate.getTime();
		return (int) (dms / MS_ONE_MINUTE);
	}

	/**
	 * 获取指定日期加上指定年份值�?
	 * 
	 * @param date
	 *            原日�?
	 * @param year
	 *            年份
	 * @return 计算后新日期
	 */
	public static Date addYear(Date date, int year) {
		Calendar cal = getCalendar(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	/**
	 * 获取指定日期加上指定天数后的日期值�?若天数为负，则实际进行减操作�?
	 * 
	 * @param date
	 *            原日�?
	 * @param days
	 *            天数
	 * @return 计算后的新日�?
	 */
	public static Date addDays(Date date, int days) {
		Calendar c = getCalendar(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	/**
	 * 获取指定日期加上指定小时数后的日期�?。若小时数为负，则实际进行减操作�?
	 * 
	 * @param date
	 *            原日�?
	 * @param hours
	 *            小时�?
	 * @return 计算后的新日�?
	 */
	public static Date addHours(Date date, int hours) {
		Calendar c = getCalendar(date);
		c.add(Calendar.HOUR_OF_DAY, hours);
		return c.getTime();
	}

	/**
	 * 获取指定日期加上指定分钟数后的日期�?。若分钟数为负，则实际进行减操作�?
	 * 
	 * @param date
	 *            原日�?
	 * @param hours
	 *            分钟�?
	 * @return 计算后的新日�?
	 */
	public static Date addMinutes(Date date, int minutes) {
		Calendar c = getCalendar(date);
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}

	/**
	 * 为指定日期设置年月日，返回新日期
	 * 
	 * @param date
	 *            原日�?
	 * @param year
	 *            �?
	 * @param month
	 *            �?
	 * @param day
	 *            �?
	 * @return 新日�?
	 */
	public static Date setDate(Date date, int year, int month, int day) {
		Calendar c = getCalendar(date);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DATE, day);
		return c.getTime();
	}

	/**
	 * 为指定日期设置时分秒毫秒，返回新日期
	 * 
	 * @param date
	 *            原日�?
	 * @param hour
	 *            �?
	 * @param minute
	 *            �?
	 * @param second
	 *            �?
	 * @param millisecond
	 *            毫秒
	 * @return 新日�?
	 */
	public static Date setTime(Date date, int hour, int minute, int second,
			int millisecond) {
		Calendar c = getCalendar(date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		c.set(Calendar.MILLISECOND, millisecond);
		return c.getTime();
	}

	/**
	 * @Description:获取当前日期的年�?
	 * @author zhb
	 * @return 当前的年�?
	 */
	public static String getCurrentDateYear() {
		return getCurrentDate("year");
	}

	/**
	 * @Description: 获取当前日期的月�?
	 * @author zhb
	 * @return 当前月份
	 */
	public static String getCurrentDateMonth() {
		return getCurrentDate("month");
	}

	/**
	 * 获取上个月的年和�?,比如当前�?011-1 那么取出来的就是2010-12�?
	 * 
	 * @author zhb
	 * @return 上个月的年和�?
	 */
	public static String getPreviousMonthYAndM() {

		return fromatYearAndMonth(getPreviousMonthFirst());
	}

	/**
	 * 获取当前时间的年和月 比如(2010-12)
	 * 
	 * @author zhb
	 * @return 当前时间的年和月 比如(2010-12)
	 */
	public static String getCurrentYearAndMonth() {

		return fromatYearAndMonth(getCurrentMonthFirst());
	}

	/**
	 * 将指定日期格式化为：年－�?比如2011-10
	 * 
	 * @param date
	 *            日期
	 * @return 年－�?
	 */
	public static String fromatYearAndMonth(Date date) {
		String str[] = formatShort(date).split("-");
		int i = 0;
		return str[i] + "-" + str[++i];
	}

	/**
	 * @Description:获取当前日期的天�?
	 * @author zhb
	 * @return 当前天数
	 */
	public static String getCurrentDateDay() {
		return getCurrentDate("day");
	}

	/**
	 * @Description:获取�?��的当前日期相应的内容（如年，月，天）
	 * @author zhb
	 * @param type
	 *            内容类型
	 * @return 日期�?��含的相应内容
	 */
	private static String getCurrentDate(String type) {
		Calendar calendar = Calendar.getInstance();
		int day = 0;
		int month = 0;
		int year = 0;
		if (type.equals("day")) {
			day = calendar.get(Calendar.DAY_OF_MONTH);
			return adjustDate(day);
		} else if (type.equals("month")) {
			month = calendar.get(Calendar.MONTH) + 1;
			return adjustDate(month);
		} else if (type.equals("year")) {
			year = calendar.get(Calendar.YEAR);
			return adjustDate(year);
		}
		return getCurrentDate();
	}

	/**
	 * 
	 * @Description:调整适当的日期格�?
	 * @author zhb
	 * @param date
	 *            日期
	 * @return 合�?的日期格�?
	 */
	private static String adjustDate(int date) {
		if (date < 10) {
			return "0" + date;
		}
		return String.valueOf(date);
	}

	/**
	 * 获取当月第一天的日期
	 * 
	 * @author zhb
	 * @return 当月第一天的日期
	 */
	public static Date getCurrentMonthFirst() {
		Calendar current = Calendar.getInstance();
		return getMonthFirst(current);
	}

	/**
	 * 获取给定日期的月份的�?���?��
	 * 
	 * @param calendar
	 * @return Date
	 */
	public static Date getMonthFirst(Calendar calendar) {
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 获取当月�?���?��的日�?
	 * 
	 * @author zhb
	 * @return 当月�?���?��的日�?
	 */
	public static Date getCurrentMonthEnd() {
		Calendar current = Calendar.getInstance();

		/*
		 * current.set(Calendar.DATE, 1); current.roll(Calendar.DATE, -1); //
		 * 日期回滚�?��，也就是本月�?���?��
		 */
		return getMonthEnd(current);
	}

	/**
	 * 获取给定日期的月份的�?���?��
	 * 
	 * @param calendar
	 * @return
	 */
	public static Date getMonthEnd(Calendar calendar) {
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1); // 日期回滚�?��，也就是月最后一�?

		return calendar.getTime();
	}

	/**
	 * 获取上月第一天的日期
	 * 
	 * @author zhb
	 * @return 上月第一天的日期
	 */
	public static Date getPreviousMonthFirst() {

		Calendar current = Calendar.getInstance();

		current.set(Calendar.DATE, 1); // 设为当前月的1�?
		current.add(Calendar.MONTH, -1);
		return current.getTime();
	}

	public static Date getCurrentDateTime() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 获取上月�?���?��的日�?
	 * 
	 * @author zhb
	 * @return 上月�?���?��的日�?
	 */
	public static Date getPreviousMonthEnd() {

		Calendar current = Calendar.getInstance();
		current.add(Calendar.MONTH, -1); // 减一个月
		current.set(Calendar.DATE, 1); // 把日期设置为当月第一�?
		current.roll(Calendar.DATE, -1); // 日期回滚�?��，也就是本月�?���?��

		return current.getTime();
	}

	/**
	 * 获取下月第一天的日期
	 * 
	 * @author zhb
	 * @return 下月第一天的日期
	 */
	public static String getNextMonthFirst() {

		Calendar current = Calendar.getInstance();
		current.add(Calendar.MONTH, 1); // 减一个月
		current.set(Calendar.DATE, 1); // 把日期设置为当月第一�?

		return formatShort(current.getTime());
	}

	/**
	 * 获取下月�?���?��的日�?
	 * 
	 * @author zhb
	 * @return 下月�?���?��的日�?
	 */
	public static String getNextMonthEnd() {

		Calendar current = Calendar.getInstance();
		current.add(Calendar.MONTH, 1); // 加一个月
		current.set(Calendar.DATE, 1); // 把日期设置为当月第一�?
		current.roll(Calendar.DATE, -1); // 日期回滚�?��，也就是本月�?���?��

		return formatShort(current.getTime()) + "";
	}

	/**
	 * 根据�?��String类型的日期返回一个Calendar
	 * 
	 * @param date
	 *            date中包含年月，�?011-02,注意分隔符请�?���?-"
	 * @return Calendar
	 */
	public static Calendar getCalendarByStringDate(String date) {
		Calendar calendar = Calendar.getInstance();
		if (date.split("-").length >= 2) {
			calendar.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));
			calendar.set(Calendar.MONTH,
					Integer.parseInt(date.split("-")[1]) - 1);
		}
		return calendar;
	}
	
	/**
	 * 时间加上30�? 返回格式�? yyyy-MM-dd
	 * 
	 * @return
	 */
	public static Date countDate(Date date,int day) {
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		long time = 0;
	//	int day = 30;
		Date today = new Date();
		time = (today.getTime() / 1000) + 60 * 60 * 24 * day;
		Date newDate = new Date();
		newDate.setTime(time * 1000);
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(format
					.format(newDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}

	/**
	 * 将String类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @return 日期字符�?
	 */
	public static String formatSrtingToString(String dateString, String patrren) {
		String result = null;
		if (StringUtils.isNotEmpty(dateString)) {
			Date date;
			try {
				date = parse(dateString);
				result = format(date, patrren);
			} catch (ParseException e) {
				return result;
			}

		}
		return result;
	}
	/**
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String strDate) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = ft.parse(strDate);
		return date;
	}
	public static void main(String[] args) {

	}
}
