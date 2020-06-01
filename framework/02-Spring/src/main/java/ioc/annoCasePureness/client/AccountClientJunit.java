package ioc.annoCasePureness.client;

import ioc.annoCasePureness.config.SpringConfiguration;
import ioc.annoCasePureness.domain.Account;
import ioc.annoCasePureness.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountClientJunit {

    @Autowired
    private AccountService accountService;

    @Test
    public void findALl(){
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void findAccountById(){
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void saveAccount(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1000F);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(2000F);
        account.setId(4);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount(){
        accountService.deleteAccount(4);
    }

}
