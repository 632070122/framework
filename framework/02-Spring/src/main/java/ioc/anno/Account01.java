package ioc.anno;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value = "account01")
@Component
public class Account01 {

    public void saveAccount(){
        System.out.println("Account01保存账户-01");
    }
}
