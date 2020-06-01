package ioc.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "account04")
public class Account04 {

    @Resource(name = "account01")
    private Account01 account00;

    public void saveAccount(){
        account00.saveAccount();
        System.out.println("Account03保存账户-03");
    }
}
