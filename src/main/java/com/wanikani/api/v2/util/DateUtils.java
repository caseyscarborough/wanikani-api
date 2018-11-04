package com.wanikani.api.v2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static final String ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static Date getApiDate(String apiDate) {
        SimpleDateFormat format = new SimpleDateFormat(ISO8601_FORMAT);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        format.setTimeZone(timeZone);
        try {
            return format.parse(apiDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getApiDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(ISO8601_FORMAT);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        format.setTimeZone(timeZone);
        return format.format(date);
    }
}
