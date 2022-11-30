package com.wanikani.api.v2.request;

import com.wanikani.api.v2.util.DateUtils;

import java.util.Date;
import java.util.List;

class QueryStringUtils {

    public static <T> void append(StringBuilder queryString, String parameter, T value) {
        if (value == null) {
            return;
        }

        appendParameter(queryString, parameter);
        queryString.append(value);
    }

    public static <T> void appendList(StringBuilder queryString, String parameter, List<T> items) {
        if (items == null || items.isEmpty()) {
            return;
        }

        appendParameter(queryString, parameter);
        items.forEach(i -> queryString.append(i).append(","));
        queryString.deleteCharAt(queryString.length() - 1);
    }

    public static void appendDate(StringBuilder queryString, String parameter, Date date) {
        if (date == null) {
            return;
        }
        append(queryString, parameter, DateUtils.getApiDate(date));
    }

    private static void appendParameter(StringBuilder queryString, String parameter) {
        boolean firstParameterUsed = queryString.length() > 0 && queryString.charAt(0) == '?';
        queryString
            .append(firstParameterUsed ? "&" : "?")
            .append(parameter)
            .append("=");
    }
}
