package com.wanikani.api.v2.request;

import com.wanikani.api.v2.util.DateUtils;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Function;

class QueryString {
    private final StringBuilder builder = new StringBuilder();

    public <T> QueryString append(String parameter, T value) {
        if (value != null) {
            appendParameter(parameter);
            builder.append(value);
        }
        return this;
    }

    public <T> QueryString appendList(String parameter, List<T> items) {
        return appendList(parameter, items, String::valueOf);
    }

    public <T> QueryString appendList(String parameter, List<T> items, Function<T, String> mapToString) {
        if (items == null || items.isEmpty()) {
            return this;
        }

        appendParameter(parameter);
        items.forEach(i -> builder.append(mapToString.apply(i)).append(","));
        builder.deleteCharAt(builder.length() - 1);
        return this;
    }

    public QueryString appendDate(String parameter, ZonedDateTime date) {
        if (date != null) {
            append(parameter, DateUtils.getApiDate(date));
        }
        return this;
    }

    private void appendParameter(String parameter) {
        boolean firstParameterUsed = builder.length() > 0 && builder.charAt(0) == '?';
        builder
            .append(firstParameterUsed ? "&" : "?")
            .append(parameter)
            .append("=");
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
