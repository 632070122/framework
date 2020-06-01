package transaction.xml.dao;

import transaction.xml.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountByName(String accountName);
}
