package com.use.springcouchdb.phone.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.use.springcouchdb.phone.model.Phone;
import com.use.springcouchdb.phone.service.PhoneService;
import org.elasticsearch.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by usegutierrez on 12/12/14.
 */

@Controller
public class PhoneController {

    static final Logger logger = LoggerFactory.getLogger(PhoneController.class);

    @Autowired
    private PhoneService phoneService;


    @RequestMapping(value = "/read-json-file")
    @ResponseBody
    public String readJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File json = new File("/home/usegutierrez/bitbucket/ecms/spring-couchdb/src/script/data/phones.json");
        try {

            if(json.exists()) {
                logger.info("json file is found");
                Phone[] myPhones = objectMapper.readValue(json, Phone[].class);
                phoneService.insertPhones(Arrays.asList(myPhones));
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "done reading and saving all the data from json file";
    }

    @RequestMapping(value = "/phones")
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/phones-list")
    public ModelAndView phoneslist() {
        ModelAndView mv = new ModelAndView("phones-list");
        return mv;
    }

    @RequestMapping(value = "/phone-details")
    public ModelAndView phonedetails() {
        ModelAndView mv = new ModelAndView("phone-details");
        return mv;
    }



    @RequestMapping(value = "/get-all-phone")
    @ResponseBody
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhone();
    }

    @RequestMapping(value = "/delete-all-phone")
    @ResponseBody
    public String deleteAllPhone() {
        phoneService.deletePhones();
        return "deleted all phone";
    }

    @RequestMapping(value = "/phones-details")
    public ModelAndView phoneDetails() {
        return new ModelAndView("phones-details");
    }
}
