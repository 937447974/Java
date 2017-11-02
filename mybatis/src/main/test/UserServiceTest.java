import com.mybatis.po.User;
import com.mybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * UserServiceTest.java
 * <p>
 * Created by 阳君 on 2017/10/26.
 * Copyright © 2017年 mybatis. All rights reserved.
 */
public class UserServiceTest {

    private ApplicationContext appContext;
    private UserService userService;

    @Test
    public void transactionTest() {
        this.userService = this.getAppContext().getBean(UserService.class);
        DataSourceTransactionManager txManager = this.getAppContext().getBean(DataSourceTransactionManager.class);
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(transactionDefinition); // 获得事务状态
        try {
//            this.userTest();
//            this.usersTest();
            this.selectUserAndLanguageTest();
            txManager.commit(status);
        } catch (Exception e) {
            System.out.println(e);
            txManager.rollback(status);
        }
    }


    private void selectUserAndLanguageTest() {
        User user = new User("937447974");
        user = this.userService.selectUserAndLanguage(user);
        System.out.println(user);
    }

    private void userTest() {
        User user = new User("937447974-one", "阳君");
        userService.insertUser(user);

        user.setName("yangjun");
        userService.updateUser(user);

        user = userService.selectUser(user);
        System.out.println(user);
        System.out.println(userService.selectUser(user)); // 缓存

        userService.deleteUser(user.getCode());
    }

    private void usersTest() {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i < 20; i++) {
            users.add(new User("" + i, "阳君-" + i));
        }
        userService.insertUsers(users);

        userService.selectUsers(null, 1, 10);

        int i = 0;
        List<String> codes = new ArrayList<String>();
        for (User user : users) {
            user.setName("Yangjun-" + i);
            codes.add(user.getCode());
            i++;
        }
        userService.updateUsers(users);

        userService.deleteUsers(codes);
    }

    private ApplicationContext getAppContext() {
        if (appContext == null)
            appContext = new ClassPathXmlApplicationContext("spring-config.xml");
        return appContext;
    }

}
