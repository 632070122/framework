import com.hengshui.dao.AccountDao;
import com.hengshui.dao.IdentityCardDao;
import com.hengshui.domain.Account;
import com.hengshui.domain.IdentityCard;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream in; //读取配置文件
    private SqlSessionFactoryBuilder builder; //创建SqlSessionFactoryBuilder对象
    private SqlSessionFactory factory; //使用SqlSessionFactoryBuilder的builder方法传递流创建SqlSessionFactory对象
    private SqlSession session; //使用SqlSessionFactory的方法openSession方法来创建SqlSession对象
    private AccountDao accountDao; //使用SqlSession的getMapper方法来创建Dao接口的代理对象

    @Before
    public void start() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void end() throws IOException {
        session.close();
        in.close();
    }

   @Test
    public void findAccountUser(){
        Account account = accountDao.findAccountUser(12345);
        System.out.println(account);
    }

    @Test
    public void findById(){
        List<Account> accounts = accountDao.findById(41);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
