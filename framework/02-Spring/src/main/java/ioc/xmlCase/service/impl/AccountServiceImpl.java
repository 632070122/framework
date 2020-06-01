package ioc.xmlCase.service.impl;

import ioc.xmlCase.dao.AccountDao;
import ioc.xmlCase.domain.Account;
import ioc.xmlCase.service.AccountService;
import lombok.Setter;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Setter
    private AccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
