package com.moguichun.webframe.dao.test;

import com.moguichun.webframe.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by MoGuichun on 2016-7-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetAllUser() {
        System.out.println(userDao.getAllUser());
    }

}
