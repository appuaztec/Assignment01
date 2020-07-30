package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getCurrentDateAndTime(String dateTimeFormat) {
        //"yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat formatter = new SimpleDateFormat(dateTimeFormat);
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getTSinformat(String sdate, String currDateFormat, String needdateTimeFormat) throws ParseException {
        //"yyyy-MM-dd HH:mm:ss"
        DateFormat parser = new SimpleDateFormat(currDateFormat);
        SimpleDateFormat formatter = new SimpleDateFormat(needdateTimeFormat);
        Date date = parser.parse(sdate);
        return formatter.format(date);
    }

    public static String getDate(String sdate, String currDateFormat, String needdateTimeFormat) throws ParseException {
        //"yyyy-MM-dd HH:mm:ss"
        DateFormat parser = new SimpleDateFormat(currDateFormat);
        SimpleDateFormat formatter = new SimpleDateFormat(needdateTimeFormat);
        Date date = parser.parse(sdate);
        return formatter.format(date);
    }

    public static int monthDiff(String currMonYear, String currMonYearFormat,
                                String endMonYear, String endMonYearFormat) throws Exception {
        //Custom date format
        SimpleDateFormat formatDate1 = new SimpleDateFormat(currMonYearFormat);
        SimpleDateFormat formatDate2 = new SimpleDateFormat(endMonYearFormat);

//        Calendar c1 = null;
//        Calendar c2 = null;
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = formatDate1.parse(currMonYear);
            d2 = formatDate2.parse(endMonYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//
//        c1 = Calendar.getInstance();
//        c1.setTime(d1);
//        c2 = Calendar.getInstance();
//        c2.setTime(d2);

//        int dayOfMonth1 = c1.get(Calendar.MONTH);
//        int dayOfYear1 = c1.get(Calendar.YEAR);
//
//        int dayOfMonth2 = c2.get(Calendar.MONTH);
//        int dayOfYear2 = c2.get(Calendar.YEAR);
//
//        int diffYearC = dayOfYear2 - dayOfYear1;
//        int diffMonthC = diffYearC * 12 + dayOfMonth2 - dayOfMonth1;

        int diffYear = (d2.getYear() - d1.getYear());
        int diffMonth = diffYear * 12 + d2.getMonth() - d1.getMonth();

        System.out.println("diffMonth = " + diffMonth);
      //  System.out.println("diffMonthC = " + diffMonthC);
        return diffMonth;
    }
}
