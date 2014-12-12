package com.use.springcouchdb.phone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * Created by usegutierrez on 12/12/14.
 */

@Document
public class Phone {

    @Id
    private String id;
    @Field
    private int age;
    @Field
    private String carrier;
    @Field
    private String imageUrl;
    @Field
    private String name;
    @Field
    private String snippet;
    @Field
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Phone[ ")
                .append("age = " + age + ", ")
                .append("carrier = " + carrier + ", ")
                .append("imageUrl = " + imageUrl + ", ")
                .append("name = " + name + ", ")
                .append("snippet = " + snippet + " ]").toString();
    }
}
