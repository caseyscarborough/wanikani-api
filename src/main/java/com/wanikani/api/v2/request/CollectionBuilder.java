package com.wanikani.api.v2.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.wanikani.api.v2.request.QueryStringUtils.append;
import static com.wanikani.api.v2.request.QueryStringUtils.appendList;

abstract class CollectionBuilder<T, B extends CollectionBuilder<T, B>> extends BaseBuilder<T, B> {

    private List<Long> ids = new ArrayList<>();
    private Long pageAfterId;

    public B ids(Long... ids) {
        return ids(Arrays.asList(ids));
    }

    @SuppressWarnings("unchecked")
    public B ids(List<Long> ids) {
        this.ids = ids;
        return (B) this;
    }

    public B ids(long... ids) {
        return ids(Arrays.stream(ids).boxed().collect(Collectors.toList()));
    }

    public B pageAfterId(Integer id) {
        return pageAfterId(id.longValue());
    }

    @SuppressWarnings("unchecked")
    public B pageAfterId(Long id) {
        this.pageAfterId = id;
        return (B) this;
    }

    @Override
    StringBuilder queryString() {
        StringBuilder queryString = super.queryString();
        appendList(queryString, "ids", ids);
        append(queryString, "page_after_id", pageAfterId);
        return queryString;
    }
}
