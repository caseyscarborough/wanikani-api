package com.wanikani.api.v2.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void testGetApiDate() {
        Date date = DateUtils.getApiDate("2018-11-03T21:00:00.000000Z");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(10, calendar.get(Calendar.MONTH));
        assertEquals(17, calendar.get(Calendar.HOUR_OF_DAY));
    }
}
