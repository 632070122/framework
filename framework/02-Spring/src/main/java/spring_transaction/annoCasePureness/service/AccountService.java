package spring_transaction.annoCasePureness.service;

import spring_transaction.annoCasePureness.domain.Account;

public interface AccountService {

    Account findByAccountName(String accountName);

    void transfer(String sourceName, String targetName, Float money);
}
