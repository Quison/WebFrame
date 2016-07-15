package com.moguichun.webframe.service.impl;

import com.moguichun.webframe.dao.UserDao;
import com.moguichun.webframe.model.User;
import com.moguichun.webframe.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MoGuichun on 2016-7-15.
 */
@Service
public class UserServiceImpl implements UserService{

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
