package com.use.springcouchdb.user.service.impl;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.use.springcouchdb.security.IdGeneratorUtil;
import com.use.springcouchdb.user.model.User;
import com.use.springcouchdb.user.repository.UserRepository;
import com.use.springcouchdb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by usegutierrez on 12/10/14.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String USER_PREFIX = "user-";
    private static final String USER_KEY = "user";

    @Resource
    private UserRepository userRepository;

    @Autowired
    private IdGeneratorUtil idGeneratorUtil;

    @Override
    public User findByUsername(String username) {
        Query query = new Query();
        query.setKey(ComplexKey.of(username));
        //query.setStale(Stale.FALSE);

        List<User> users = userRepository.findByUsername(query);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        user.setId(idGeneratorUtil.generateId(USER_PREFIX, USER_KEY));
        userRepository.save(user);
    }
}
