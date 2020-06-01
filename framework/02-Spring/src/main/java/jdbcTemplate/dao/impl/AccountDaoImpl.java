package jdbcTemplate.dao.impl;
import jdbcTemplate.dao.AccountDao;
import jdbcTemplate.dao.JdbcDaoSupport;
import jdbcTemplate.domain.Account;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    public Account findByAccountId(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from transfer_accounts where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null : accounts.get(0);
    }

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

    public void saveAccount(Account account) {
        super.getJdbcTemplate().update("insert into transfer_accounts(name,money) values(?,?)",account.getName(),account.getMoney());
    }

    public void deleteAccount(Integer accountId) {
        super.getJdbcTemplate().update("delete from transfer_accounts where id = ?",accountId);
    }

    public List<Account> findAll() {
        List<Account> accounts = super.getJdbcTemplate().query("select * from transfer_accounts",new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }

    public Account findById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from transfer_accounts where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        if(accounts.isEmpty()){
            return null;
        }else {
            return accounts.get(0);
        }
    }

    public int findMoney(Float money) {
        Integer count = super.getJdbcTemplate().queryForObject("select count(*) from transfer_accounts where money > ?",Integer.class,money);
        return count;
    }


}
