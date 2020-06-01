package factoryDecoupling.service.impl;
import factoryDecoupling.dao.AccountDao;
import factoryDecoupling.factory.BeanFactory;
import factoryDecoupling.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = (AccountDao)BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println("业务层保存了账户");
    }
}
