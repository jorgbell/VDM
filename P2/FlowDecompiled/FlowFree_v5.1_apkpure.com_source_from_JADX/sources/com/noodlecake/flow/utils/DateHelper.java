package com.noodlecake.flow.utils;

import android.os.Build;
import com.facebook.ads.AdError;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateHelper {
    private static int calendarDaysBeforeExact(Calendar calendar, Calendar calendar2) {
        int i = calendar.get(1);
        int i2 = calendar2.get(1);
        int i3 = calendar.get(6);
        int i4 = calendar2.get(6);
        if (i > i2) {
            return 0;
        }
        if (i == i2 && i3 > i4) {
            return 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.clear();
        while (i < i2) {
            gregorianCalendar.set(1, i);
            i4 += gregorianCalendar.getActualMaximum(6);
            i++;
        }
        return i4 - i3;
    }

    private static Calendar calendarDateAfter(Calendar calendar, int i) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, i);
        return calendar2;
    }

    private static double getTimeInSecondsFromDate(Date date) {
        double time = (double) date.getTime();
        Double.isNaN(time);
        return time / 1000.0d;
    }

    private static Date getDateFromTimeInSeconds(double d) {
        return new Date((long) (d * 1000.0d));
    }

    private static Calendar getReferenceDate() {
        return new GregorianCalendar(AdError.INTERNAL_ERROR_CODE, 0, 1, 0, 0, 0);
    }

    public static int getDayNumber(double d) {
        Date dateFromTimeInSeconds = getDateFromTimeInSeconds(d);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(dateFromTimeInSeconds);
        return Math.max(calendarDaysBeforeExact(getReferenceDate(), gregorianCalendar) + 1, 1);
    }

    public static double getTimeWithDayNumber(int i) {
        return getTimeInSecondsFromDate(calendarDateAfter(getReferenceDate(), Math.max(i, 1) - 1).getTime());
    }

    public static String getLocalizedDateString(double d, String str) {
        Locale locale;
        DateFormat dateFormat;
        Date dateFromTimeInSeconds = getDateFromTimeInSeconds(d);
        Locale locale2 = Locale.getDefault();
        String country = locale2 != null ? locale2.getCountry() : null;
        if (country == null) {
            locale = new Locale(str);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            dateFormat = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(locale, "EEEEMMMMd"), locale);
        } else {
            dateFormat = SimpleDateFormat.getDateInstance(0, locale);
        }
        return dateFormat.format(dateFromTimeInSeconds);
    }

    public static int ticksForDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse != null) {
                return (int) (parse.getTime() / 1000);
            }
        } catch (ParseException unused) {
        }
        return 0;
    }
}
