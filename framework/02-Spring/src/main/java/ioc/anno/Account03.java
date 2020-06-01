package ioc.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "account03")
public class Account03 {

    @Autowired
    @Qualifier(value = "account01")
    private Account01 account01;

    public void saveAccount(){
        account01.saveAccount();
        System.out.println("Account03保存账户-03");
    }
}
