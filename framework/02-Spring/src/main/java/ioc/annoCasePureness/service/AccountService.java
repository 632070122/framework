package ioc.annoCasePureness.service;

import ioc.annoCasePureness.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
