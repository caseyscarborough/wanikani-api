package com.wanikani.api.v2.converter;

import com.wanikani.api.v2.model.*;

import java.util.ArrayList;
import java.util.List;

public class ResourceTransformer {

    public <T> T getData(Resource<T> resource) {
        T item = resource.getData();
        if (Subject.class.isAssignableFrom(item.getClass())) {
            Subject subject = (Subject) item;
            subject.setType(SubjectType.findByName(resource.getObject()));
        }

        if (Identifiable.class.isAssignableFrom(item.getClass())) {
            Identifiable identifiable = (Identifiable) item;
            identifiable.setId(resource.getId());
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
