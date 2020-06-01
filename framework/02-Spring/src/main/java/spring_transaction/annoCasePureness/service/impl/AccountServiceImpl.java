package spring_transaction.annoCasePureness.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring_transaction.annoCasePureness.dao.AccountDao;
import spring_transaction.annoCasePureness.domain.Account;
import spring_transaction.annoCasePureness.service.AccountService;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true) //只读事务的配置
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account findByAccountName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false) //读写事务的配置
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }

}
