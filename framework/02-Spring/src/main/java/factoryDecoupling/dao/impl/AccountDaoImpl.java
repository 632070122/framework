package factoryDecoupling.dao.impl;

import factoryDecoupling.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("持久层保存了账户");
    }
}
