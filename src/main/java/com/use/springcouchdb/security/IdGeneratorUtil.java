package com.use.springcouchdb.security;

import com.couchbase.client.CouchbaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by genetan on 5/23/14.
 */
@Component
public class IdGeneratorUtil {

    @Autowired
    private CouchbaseClient couchbaseClient;

    private static final String ZERO = "0";

    public String generateId(String prefix, String docKey) {
        if (couchbaseClient.get(docKey) == null) {
            couchbaseClient.add(docKey, ZERO);
        }
        return prefix + couchbaseClient.incr(docKey, 1);
    }
}