package spring_transaction.xml.dao;

import spring_transaction.xml.domain.Account;

import java.util.List;

public interface AccountDao {

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

}
