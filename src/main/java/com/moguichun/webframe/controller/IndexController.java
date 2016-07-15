package com.moguichun.webframe.controller;

import com.moguichun.webframe.model.User;
import com.moguichun.webframe.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MoGuichun on 2016-7-15.
 */
@RestController
public class IndexController {

    private final static Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public Map<String, Object> getAllUser() {

        List<User> users = userService.getAllUser();
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("users",users);
        return retMap;
    }

}
