package com.use.springcouchdb.controller;

import com.use.springcouchdb.user.model.Permission;
import com.use.springcouchdb.user.model.Role;
import com.use.springcouchdb.user.model.User;
import com.use.springcouchdb.user.service.UserService;
import com.use.springcouchdb.util.PermissionAdmin;
import com.use.springcouchdb.util.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by usegutierrez on 12/10/14.
 */
@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/welcome")
    public ModelAndView getWelcomePage() {

        logger.info("Welcome");

        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("msg", "hello world");
        return mv;
    }

    @RequestMapping(value = "/populate")
    @ResponseBody
    public String populate() {


        userService.insertUser(generateUser());
        logger.info("done inserting admin");

       return "done";
    }

    @RequestMapping(value = "/view")
    @ResponseBody
    public User view() {
        User user = userService.findByUsername("admin");

        logger.info("Username: " + user.getUsername());
        logger.info("Password: " + user.getPassword());
        return user;
    }






    User generateUser () {

        String username = "admin";

        User user = new User();
        user.setUsername(username);
        user.setPassword(username);

        Role adminRole = new Role();
        adminRole.setType(RoleType.ADMIN.toString());

        Permission adminWrite = new Permission();
        adminWrite.setName("ADMIN_WRITE");

        Permission adminRead = new Permission();
        adminRead.setName("ADMIN_READ");

        Permission adminView = new Permission();
        adminView.setName("ADMIN_VIEW");

        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(adminRead);
        permissions.add(adminWrite);
        permissions.add(adminView);


        user.setPermissions(permissions);

        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);

        user.setRoles(adminRole);

        return user;
    }
}
