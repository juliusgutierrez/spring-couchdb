package com.use.springcouchdb.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by usegutierrez on 12/15/14.
 */

@Controller
public class ContactController {

    @RequestMapping(value = "/main")
    public ModelAndView mainPage() {
        ModelAndView mv = new ModelAndView("ui-router/index");
        return mv;
    }

    @RequestMapping(value = "/contacts")
    public ModelAndView contactPage() {
        ModelAndView mv = new ModelAndView("ui-router/contacts");
        return mv;
    }

    @RequestMapping(value = "/contact-list")
    public ModelAndView contactsListPage() {
        ModelAndView mv = new ModelAndView("ui-router/contact-list");
        return mv;
    }

    @RequestMapping(value = "/contact-details")
    public ModelAndView contactsDetailsPage() {
        ModelAndView mv = new ModelAndView("ui-router/contact-details");
        return mv;
    }


}
