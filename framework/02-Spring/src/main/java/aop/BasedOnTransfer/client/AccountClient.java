package aop.BasedOnTransfer.client;

import aop.BasedOnTransfer.domain.Account;
import aop.BasedOnTransfer.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aop_BasedOnTransfer.xml")
public class AccountClient {

    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService as;

    @Test
    public void transfer(){
        as.transfer("aaa","bbb",100F);
    }
}
