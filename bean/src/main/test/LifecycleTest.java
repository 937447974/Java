import com.bean.BeanController;
import com.lifecycle.StudentBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LifecycleTest.java
 * <p>
 * Created by didi on 2017/10/13.
 * Copyright © 2017年 bean. All rights reserved.
 */
public class LifecycleTest {

    @Test
    public void test() {
        System.out.println("--------------【初始化容器】---------------");
        ApplicationContext act = new ClassPathXmlApplicationContext("lifecycle.xml");

        System.out.println("-------------------【容器初始化成功】------------------");
        System.out.println(act.getBean(StudentBean.class));
        System.out.println(act.getBean(StudentBean.class));

        System.out.println("--------------------【销毁容器】----------------------");
        ((ClassPathXmlApplicationContext)act).registerShutdownHook();
    }

}
