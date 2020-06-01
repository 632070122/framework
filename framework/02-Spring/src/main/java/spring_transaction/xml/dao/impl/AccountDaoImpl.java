package spring_transaction.xml.dao.impl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import spring_transaction.xml.dao.AccountDao;
import spring_transaction.xml.domain.Account;
import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from transfer_accounts where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");

        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update transfer_accounts set name = ?, money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }












}
