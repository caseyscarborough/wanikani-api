package com.wanikani.api.v2.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getApiDate(ZonedDateTime date) {
        return DateTimeFormatter.ISO_DATE_TIME.format(date);
    }

    public static ZonedDateTime getApiDate(String date) {
        return ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }
}
