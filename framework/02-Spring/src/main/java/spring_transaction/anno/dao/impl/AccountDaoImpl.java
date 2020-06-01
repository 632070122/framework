package spring_transaction.anno.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import spring_transaction.anno.dao.AccountDao;
import spring_transaction.anno.domain.Account;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl  implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from transfer_accounts where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");

        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update transfer_accounts set name = ?, money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }












}
