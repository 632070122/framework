package spring_transaction.anno.client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_transaction.anno.domain.Account;
import spring_transaction.anno.service.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_transaction_anno.xml")
public class AccountClient {

    @Autowired
    private AccountService accountService;

    @Test
    public void transfer(){
        accountService.transfer("aaa","bbb",100F);
    }
}
