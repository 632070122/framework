package aop.xml.service.impl;

public class AccountService implements aop.xml.service.AccountService {


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
