package aop.xml.client;

import aop.xml.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountClient {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop_xml.xml");
        AccountService accountService = (AccountService)ac.getBean("accountService");
        accountService.saveAccount();
        /*accountService.deleteAccount();
        accountService.updateAccount(1);*/
    }
}
