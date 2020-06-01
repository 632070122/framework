package ioc.xml;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Random;

/**
 * 核心容器的两个接口
 *      ApplicationContext 采用立即加载策略,单例对象适用
 *      BeanFactory 采用延迟加载策略,多例对象适用
 * ApplicationContext的三个实现类
 *      ClassPathXmlApplicationContext 读取类路径下的配置文件
 *      FileSystemXmlApplicationContext 读取磁盘路径下的配置文件
 *      AnnotationConfigApplicationContext 读取注解配置文件
 */

public class AccountClient {

    @Test
    public void Account01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Account01 account01 = (Account01)ac.getBean("account01");
        account01.saveAccount();
    }

    @Test
    public void Account02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Date date = (Date)ac.getBean("date");
        System.out.println(date);
    }

    @Test
    public void Account03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Random random = (Random)ac.getBean("account03");
        int i = random.nextInt(10);
        System.out.println(i);
    }

    @Test
    public void Account04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Account04 account04 = (Account04)ac.getBean("account04");
        account04.person();
    }

    @Test
    public void Account05(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Account05 account05 = (Account05)ac.getBean("account05");
        account05.person();
    }

    @Test
    public void Account06(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Account06 account06 = (Account06)ac.getBean("account06");
        account06.person();
    }

    @Test
    public void Account07(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_xml.xml");
        Account01 account01 = (Account01)ac.getBean("account01");
        account01.saveAccount();
    }


}
