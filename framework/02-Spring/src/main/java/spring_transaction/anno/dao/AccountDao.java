package spring_transaction.anno.dao;

import spring_transaction.anno.domain.Account;

public interface AccountDao {

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

}
