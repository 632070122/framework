package ioc.anno;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "account05")
public class Account05 {








    public void saveAccount(){
        System.out.println("Account05保存账户-05");
    }
}
