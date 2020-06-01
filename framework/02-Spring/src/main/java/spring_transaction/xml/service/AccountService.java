package spring_transaction.xml.service;

import spring_transaction.xml.domain.Account;

public interface AccountService {

    Account findByAccountName(String accountName);

    void transfer(String sourceName, String targetName, Float money);
}
