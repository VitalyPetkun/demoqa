package utils;

import framework.utils.MyLogger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
    public static String getDateForTextBoxSelectDate() {
        return new SimpleDateFormat("MM/dd/yyyy",  Locale.ENGLISH).format(new GregorianCalendar().getTime());
    }

    public static String getDateForTextBoxDateAndTime() {
        return new SimpleDateFormat("MMMM d, yyyy h:mm a",  Locale.ENGLISH).format(new GregorianCalendar().getTime());
    }

    public static String getNearestLeapYear() {
        MyLogger.logInfo("get nearest leap year.");
        return String.valueOf(getDateNearest_29_February().get(Calendar.YEAR));
    }

    public static String getNearest_29_February_forTextBoxSelectDate() {
        MyLogger.logInfo("get nearest 29 February.");
        return new SimpleDateFormat("MM/dd/yyyy",  Locale.ENGLISH).format(getDateNearest_29_February().getTime());
    }

    private static GregorianCalendar getDateNearest_29_February() {
        GregorianCalendar currentCalendar = new GregorianCalendar();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int previousLeapYear = currentYear;
        int nextLeapYear = currentYear;
        while (!currentCalendar.isLeapYear(nextLeapYear)) {
            ++nextLeapYear;
        }
        while (!currentCalendar.isLeapYear(previousLeapYear)) {
            --previousLeapYear;
        }
        GregorianCalendar datePrevious_29_February = new GregorianCalendar(previousLeapYear, Calendar.FEBRUARY , 29);
        GregorianCalendar dateNext_29_February = new GregorianCalendar(nextLeapYear, Calendar.FEBRUARY , 29);
        long differenceCurrentDateAndPrevious_29_February = currentCalendar.getTimeInMillis()
                - datePrevious_29_February.getTimeInMillis();
        long differenceNext_29_FebruaryAndCurrentDate = dateNext_29_February.getTimeInMillis()
                - currentCalendar.getTimeInMillis();
        if(differenceNext_29_FebruaryAndCurrentDate < differenceCurrentDateAndPrevious_29_February)
            return dateNext_29_February;
        else
            return datePrevious_29_February;
    }
}
