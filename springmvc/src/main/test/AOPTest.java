import aop.CglibProxy;
import aop.JDKProxy;
import com.springmvc.dao.UserDao;
import com.springmvc.dao.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOPTest.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
public class AOPTest {

    @Test
    public void jdkTest() {
        JDKProxy jdkProxy = new JDKProxy();
        UserDao userDao = (UserDao) jdkProxy.createProxy(new UserDaoImpl());
        userDao.addUser();
    }

    @Test
    public void cglibTest() {
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.createProxy(UserDaoImpl.class);
        userDao.addUser();
    }

    @Test
    public void springTest() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = act.getBean(UserDao.class);
        userDao.addUser();
    }

}
