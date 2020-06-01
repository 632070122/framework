package spring_transaction.xml.service.impl;
import lombok.Setter;
import spring_transaction.xml.dao.AccountDao;
import spring_transaction.xml.service.AccountService;
import spring_transaction.xml.domain.Account;

public class AccountServiceImpl implements AccountService {

    @Setter
    private AccountDao accountDao;

    public Account findByAccountName(String accountName) {
        return accountDao.findAccountByName(accountName);
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
