package aop.anno.client;

import aop.anno.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountClient {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop_anno.xml ");
        AccountService accountService = (AccountService)ac.getBean("accountService");
        accountService.saveAccount();
        /*accountService.deleteAccount();
        accountService.updateAccount(1);*/
    }
}
