package spring_transaction.anno.service;

import spring_transaction.anno.domain.Account;

public interface AccountService {

    Account findByAccountName(String accountName);

    void transfer(String sourceName, String targetName, Float money);
}
