package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import person.li.model.UserDto;
import person.li.service.UserService;

/**
 * Created by hongjian on 2015/10/21.
 */
public class UserTest {

    private UserService userService;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:config/spring.xml"
                ,"classpath:config/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userService");

    }

    @Test
    public void findUser(){

        UserDto ud = userService.findOne("04abc0ad06764f9480e368fbac950177");
        System.out.println(ud.getUserName());
    }

}
