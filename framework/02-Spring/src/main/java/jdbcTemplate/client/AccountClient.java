package jdbcTemplate.client;
import jdbcTemplate.dao.AccountDao;
import jdbcTemplate.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class AccountClient {

    @Test
    public void findByAccountId(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        Account account = accountDao.findByAccountId(1);
        System.out.println(account);
    }

    @Test
    public void findAccountByName(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        Account aaa = accountDao.findAccountByName("aaa");
        System.out.println(aaa);
    }

    @Test
    public void updateAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        Account account = new Account();
        account.setId(1);
        account.setName("aaa");
        account.setMoney(2000F);
        accountDao.updateAccount(account);
    }

    @Test
    public void saveAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        Account account = new Account();
        account.setName("fff");
        account.setMoney(2000F);
        accountDao.saveAccount(account);
    }

    @Test
    public void deleteAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        accountDao.deleteAccount(5);
    }

    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
    }

    @Test
    public void findById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        Account account = accountDao.findById(1);
        System.out.println(account);
    }

    @Test
    public void findMoney(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        AccountDao accountDao = (AccountDao)ac.getBean("accountDao");
        int count = accountDao.findMoney(100F);
        System.out.println(count);
    }
}
