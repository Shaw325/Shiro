package com.shaw;

import com.shaw.pojo.User;
import com.shaw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName: MutliDataSourceTest
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/1 23:39
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MutliDataSourceTest {

    private final static Logger logger = LoggerFactory.getLogger(MutliDataSourceTest.class);


    @Autowired
    private UserService userService;




    @Test
    public void test(){
        List<User> all = userService.findAll();
        System.out.println(all);

    }
}
