package spring_transaction.xml.client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_transaction.xml.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_transaction_xml.xml")
public class AccountClient {

    @Autowired
    private AccountService accountService;


    @Test
    public void transfer(){
        accountService.transfer("aaa","bbb",100F);
    }
}
