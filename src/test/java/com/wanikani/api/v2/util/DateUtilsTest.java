package com.wanikani.api.v2.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void testGetApiDate() {
        Date date = DateUtils.getApiDate("2018-11-22T12:52:38.861676Z");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(10, calendar.get(Calendar.MONTH));
        assertEquals(22, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(7, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(52, calendar.get(Calendar.MINUTE));
        assertEquals(38, calendar.get(Calendar.SECOND));
        assertEquals(0, calendar.get(Calendar.MILLISECOND));
    }
}
