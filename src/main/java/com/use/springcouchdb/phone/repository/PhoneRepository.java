package com.use.springcouchdb.phone.repository;

import com.couchbase.client.protocol.views.Query;
import com.use.springcouchdb.phone.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by usegutierrez on 12/12/14.
 */
@Repository
public interface PhoneRepository extends CrudRepository<Phone, String> {

    List<Phone> findAll(Query query);
}
