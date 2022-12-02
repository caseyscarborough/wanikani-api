package com.wanikani.api.v2.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getApiDate(LocalDateTime date) {
        return DateTimeFormatter.ISO_DATE_TIME.format(date.atZone(ZoneOffset.UTC));
    }

    public static LocalDateTime getApiDate(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }
}
