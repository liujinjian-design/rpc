package test;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Author: liujinjian
 * @Date: 2020/8/19 13:10
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {



        DateTime dt1 = new DateTime(new Date(), DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Shanghai")));
//        DateTime dt11 = new DateTime(new Date(), DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Beijing")));
        System.out.println(dt1.toString());

    }
}
