package ioc.annoCasePureness.client;

import ioc.annoCasePureness.config.SpringConfiguration;
import ioc.annoCasePureness.domain.Account;
import ioc.annoCasePureness.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountClient {

    @Test
    public void findALl(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService)ac.getBean("accountService");
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void findAccountById(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService)ac.getBean("accountService");
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void saveAccount(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService)ac.getBean("accountService");
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1000F);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService)ac.getBean("accountService");
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(2000F);
        account.setId(4);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService)ac.getBean("accountService");
        accountService.deleteAccount(4);
    }

}
