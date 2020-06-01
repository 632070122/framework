package spring_transaction.annoCasePureness.client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_transaction.annoCasePureness.config.SpringConfiguration;
import spring_transaction.annoCasePureness.service.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountClient {

    @Autowired
    private AccountService accountService;

    @Test
    public void transfer(){
        accountService.transfer("aaa","bbb",100F);
    }
}
