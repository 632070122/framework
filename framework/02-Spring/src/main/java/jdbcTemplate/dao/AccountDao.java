package jdbcTemplate.dao;

import jdbcTemplate.domain.Account;

import java.util.List;

public interface AccountDao {

    Account findByAccountId(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

    void saveAccount(Account account);

    void deleteAccount(Integer accountId);

    List<Account> findAll();

    Account findById(Integer accountId);

    int findMoney(Float money);
}
