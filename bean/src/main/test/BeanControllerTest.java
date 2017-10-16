import com.bean.BeanController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanControllerTest.java
 * <p>
 * Created by didi on 2017/10/9.
 * Copyright © 2017年 bean. All rights reserved.
 */
public class BeanControllerTest {

    @Test
    public void test() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        BeanController bc;
        bc = act.getBean(BeanController.class);
        System.out.println(bc);
        System.out.println(bc.getBeanService());
        bc = act.getBean(BeanController.class);
        System.out.println(bc);
        System.out.println(bc.getBeanService());
    }

}
