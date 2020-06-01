package spring_transaction.annoCasePureness.dao;

import spring_transaction.annoCasePureness.domain.Account;

public interface AccountDao {

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

}
