package com.wanikani.api.v2.converter;

import com.wanikani.api.v2.model.Resource;
import com.wanikani.api.v2.model.Review;
import com.wanikani.api.v2.model.Subject;
import com.wanikani.api.v2.model.SubjectType;

import java.util.ArrayList;
import java.util.List;

public class ResourceTransformer {

    public <T> T getData(Resource<T> resource) {
        T item = resource.getData();
        if (Subject.class.isAssignableFrom(item.getClass())) {
            Subject subject = (Subject) item;
            subject.setId(resource.getId());
            subject.setType(SubjectType.findByName(resource.getObject()));
        }

        if (Review.class.isAssignableFrom(item.getClass())) {
            Review review = (Review) item;
            review.setId(resource.getId());
        }
        return item;
    }

    public <T> List<T> getListData(Resource<List<Resource<T>>> resource) {
        List<T> output = new ArrayList<>();
        for (Resource<T> r : resource.getData()) {
            output.add(getData(r));
        }
        return output;
    }
}
