package com.use.springcouchdb.phone.service;

import com.use.springcouchdb.phone.model.Phone;

import java.util.List;

/**
 * Created by usegutierrez on 12/12/14.
 */
public interface PhoneService {

    String PHONE_PREFIX = "phone-";
    String PHONE_KEY = "phone";

    void insertPhones(List<Phone> phones);
    void deletePhones();
    List<Phone> getAllPhone();
}
