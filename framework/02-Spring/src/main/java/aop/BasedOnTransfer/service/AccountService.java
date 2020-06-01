package aop.BasedOnTransfer.service;

import aop.BasedOnTransfer.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);
}
