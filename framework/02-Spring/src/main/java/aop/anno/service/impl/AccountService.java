package aop.anno.service.impl;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService implements aop.anno.service.AccountService {


    public void saveAccount() {
        System.out.println("保存");
    }

    public void updateAccount(int i) {
        System.out.println("更新");
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }

}
