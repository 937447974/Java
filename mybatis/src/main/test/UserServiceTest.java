import com.mybatis.po.User;
import com.mybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * UserServiceTest.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public class UserServiceTest {

    private UserService userService() {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService customerService = act.getBean(UserService.class);
        return customerService;
    }

    @Test
    public void insertUserTest() {
        User user = new User("937447974", "阳君");
        this.userService().insertUser(user);
    }

    @Test
    public void insertUsersTest() {
        List<User> users = new ArrayList<User>();
        users.add(new User("1","阳君-1"));
        users.add(new User("2","阳君-2"));
        users.add(new User("3","阳君-3"));
        this.userService().insertUsers(users);
    }

    @Test
    public void findUserTest() {
        User user = this.userService().findUserByCode("937447974");
        System.out.println(user);
    }

}
