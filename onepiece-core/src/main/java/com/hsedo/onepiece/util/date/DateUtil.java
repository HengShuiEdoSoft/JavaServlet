package com.hsedo.onepiece.util.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author  作者:CC
 * @Date	时间: 2020年9月22日 上午11:29:28
 * 类说明
 * 时间工具
 */
public class DateUtil {
	
	   /**
     * date类型进行格式化输出（返回类型：String）
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }
    
    /**
     * 将"2020-09-22 11:31:06"型字符串转化为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String str) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) formatter.parse(str);
        return date;
    }
    
    /**
     * 获取系统当前时间
     * @return  系统当前时间(年月日)
     */
    public static String getCurrentDateHalf() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        return date;

    }

}
