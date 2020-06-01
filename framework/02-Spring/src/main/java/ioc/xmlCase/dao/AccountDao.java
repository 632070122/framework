package ioc.xmlCase.dao;

import ioc.xmlCase.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
