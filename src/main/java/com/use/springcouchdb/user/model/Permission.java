package com.use.springcouchdb.user.model;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * Created by usegutierrez on 12/11/14.
 */

@Document
public class Permission {

    @Field
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
