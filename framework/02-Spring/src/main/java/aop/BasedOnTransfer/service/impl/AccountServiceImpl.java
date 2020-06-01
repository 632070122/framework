package aop.BasedOnTransfer.service.impl;

import aop.BasedOnTransfer.dao.AccountDao;
import aop.BasedOnTransfer.domain.Account;
import aop.BasedOnTransfer.service.AccountService;
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

    public void transfer(String sourceName, String targetName, Float money) {
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
    }
}
