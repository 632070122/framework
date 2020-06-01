package factoryDecoupling.controller;

import factoryDecoupling.factory.BeanFactory;
import factoryDecoupling.service.AccountService;
import org.junit.Test;

//工厂解耦获取对象
public class AccountClient {

    @Test
    public void saveAccount(){
        AccountService accountService = (AccountService)BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
