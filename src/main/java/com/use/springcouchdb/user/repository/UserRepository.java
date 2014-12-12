package com.use.springcouchdb.user.repository;

import com.couchbase.client.protocol.views.Query;
import com.use.springcouchdb.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by usegutierrez on 12/10/14.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByUsername(Query query);
}
