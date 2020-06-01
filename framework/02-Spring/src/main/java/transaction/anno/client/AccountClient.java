package transaction.anno.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.anno.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:transaction_anno.xml")
public class AccountClient {

    @Autowired
    private AccountService as;

    @Test
    public void transfer(){
        as.transfer("aaa","bbb",100F);

    }
}
