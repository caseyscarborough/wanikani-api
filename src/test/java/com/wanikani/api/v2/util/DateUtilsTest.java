package com.wanikani.api.v2.util;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilsTest {

    @Test
    public void testDeserialization() {
        final ZonedDateTime date = DateUtils.getApiDate("2022-10-07T00:42:53.811877Z");
        assertEquals(2022, date.get(ChronoField.YEAR));
        assertEquals(10, date.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(7, date.get(ChronoField.DAY_OF_MONTH));
        assertEquals(0, date.get(ChronoField.HOUR_OF_DAY));
        assertEquals(42, date.get(ChronoField.MINUTE_OF_HOUR));
        assertEquals(53, date.get(ChronoField.SECOND_OF_MINUTE));
        assertEquals(811, date.get(ChronoField.MILLI_OF_SECOND));
    }

    @Test
    public void testSerialization() {
        ZonedDateTime time = Instant.ofEpochMilli(1667431825313L).atZone(ZoneOffset.UTC);
        String result = DateUtils.getApiDate(time);
        System.out.println(result);
        assertEquals("2022-11-02T23:30:25.313Z", result);
    }
}
