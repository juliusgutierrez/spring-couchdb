package com.use.springcouchdb.phone.service.impl;

import com.couchbase.client.protocol.views.Query;
import com.use.springcouchdb.phone.model.Phone;
import com.use.springcouchdb.phone.repository.PhoneRepository;
import com.use.springcouchdb.phone.service.PhoneService;
import com.use.springcouchdb.security.IdGeneratorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by usegutierrez on 12/12/14.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    static final Logger logger = LoggerFactory.getLogger(PhoneServiceImpl.class);

    @Autowired
    private IdGeneratorUtil idGeneratorUtil;


    @Resource
    private PhoneRepository phoneRepository;

    @Override
    public void insertPhones(List<Phone> phones) {

        List<Phone> phoneList = new ArrayList<>();
        for(Phone phone : phones) {
            phone.setId(idGeneratorUtil.generateId(PHONE_PREFIX, PHONE_KEY));

            phoneList.add(phone);
        }

        if(!phoneList.isEmpty()) {
            phoneRepository.save(phoneList);
            logger.info("Done saving the phones");
        }
    }

    public void deletePhones() {
        Query query = new Query();
        Iterable<Phone> phones = phoneRepository.findAll(query);
        phoneRepository.delete(phones);
    }

    @Override
    public List<Phone> getAllPhone() {
        Query query = new Query();
        return phoneRepository.findAll(query);
    }


}
