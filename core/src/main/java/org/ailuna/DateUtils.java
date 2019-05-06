package org.ailuna;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public final static String BASE_DATE_FORMAT = "dd MMMM yyyy";
    public final static String DATE_TIME_FORMAT = "HH:mm:ss dd.MM.yyyy";
    public final static String YEAR_MONTH_FORMAT = "yyyy-MM";
    public final static String YEAR_MONTH_WORD_FORMAT = "LLLL yyyy";
    public final static String REQUEST_FORMAT = "yyyy-MM-dd";

    public static String getBaseDateString(long date) {
        return formatDate(date, BASE_DATE_FORMAT);
    }

    public static String getBaseDateString(Date date) {
        return formatDate(date.getTime(), BASE_DATE_FORMAT);
    }

    public static String getDateString(long date, String pattern) {
        return formatDate(date, pattern);
    }

    public static String getDayOfMonth(long date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static long getDateAfterNDay(Date initDate, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initDate);
        calendar.add(Calendar.DATE, n);
        return calendar.getTimeInMillis();
    }

    public static int getDaysBetween(Date d1, Date d2){
        int value = (int)( (getDateWithoutTime(d2) - getDateWithoutTime(d1)) / (1000 * 60 * 60 * 24));
        return (value > 0 ? value : value*(-1));
    }

    public static String getDaysCountString(long daysCount){
        if (Locale.getDefault().getLanguage().equals("ru")){
            if (daysCount == 11 || daysCount == 12 || daysCount == 13 || daysCount == 14)
                return daysCount + " дней";
            else if (daysCount % 10 == 1)
                return daysCount + " день";
            else if (daysCount % 10 == 2 || daysCount % 10 == 3 || daysCount % 10 == 4)
                return daysCount + " дня";
            else
                return daysCount + " дней";
        }
        if (Locale.getDefault().getLanguage().equals("kk")){
            return daysCount + " күн";
        }
        if (Locale.getDefault().getLanguage().equals("en")){
            if (daysCount == 1)
                return daysCount + " day";
            else
                return daysCount + " days";
        }
        return String.valueOf(daysCount);
    }

    public static String getMonthCountString(long monthCount){
        if (Locale.getDefault().getLanguage().equals("ru")){
            if (monthCount == 11 || monthCount == 12 || monthCount == 13 || monthCount == 14)
                return monthCount + " месяцев";
            else if (monthCount % 10 == 1)
                return monthCount + " месяц";
            else if (monthCount % 10 == 2 || monthCount % 10 == 3 || monthCount % 10 == 4)
                return monthCount + " месяца";
            else
                return monthCount + " месяцев";
        }
        if (Locale.getDefault().getLanguage().equals("kk")){
            return monthCount + " ай";
        }
        if (Locale.getDefault().getLanguage().equals("en")){
            if (monthCount == 1)
                return monthCount + " month";
            else
                return monthCount + " months";
        }
        return String.valueOf(monthCount);
    }

    public static String getYearsCountString(long yearsCount){
        if (Locale.getDefault().getLanguage().equals("ru")){
            if (yearsCount == 1 || yearsCount%10 == 1)
                return yearsCount + " год";
            else if (yearsCount == 2 || yearsCount == 3 || yearsCount == 4
                    || yearsCount%10 == 2 || yearsCount%10 == 3 || yearsCount%10 == 4)
                return yearsCount + " года";
            else
                return yearsCount + " лет";
        }
        if (Locale.getDefault().getLanguage().equals("kk")){
            return yearsCount + " жыл";
        }
        if (Locale.getDefault().getLanguage().equals("en")){
            if (yearsCount == 1)
                return yearsCount + " year";
            else
                return yearsCount + " years";
        }
        return String.valueOf(yearsCount);
    }

    private static String formatDate(long date, String pattern){
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
    }

    public static long getDateWithoutTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
