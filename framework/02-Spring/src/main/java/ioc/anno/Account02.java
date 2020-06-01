package ioc.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value = "account02")
public class Account02 {

    @Autowired
    private Account01 account01;

    public void saveAccount(){
        account01.saveAccount();
        System.out.println("Account02保存账户-02");
    }
}
