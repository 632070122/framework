package ioc.annoCase.service;

import ioc.annoCase.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
