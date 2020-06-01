import com.hengshui.dao.AccountDao;
import com.hengshui.dao.RoleDao;
import com.hengshui.domain.Account;
import com.hengshui.domain.Role;
import com.hengshui.domain.User;
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

public class RoleTest {

   private InputStream in; //读取配置文件
    private SqlSessionFactoryBuilder builder; //创建SqlSessionFactoryBuilder对象
    private SqlSessionFactory factory; //使用SqlSessionFactoryBuilder的builder方法传递流创建SqlSessionFactory对象
    private SqlSession session; //使用SqlSessionFactory的方法openSession方法来创建SqlSession对象
    private RoleDao roleDao; //使用SqlSession的getMapper方法来创建Dao接口的代理对象

    @Before
    public void start() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        roleDao = session.getMapper(RoleDao.class);
    }

    @After
    public void end() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Role> all = roleDao.findAll();
        System.out.println(all);
    }

    @Test
    public void findRoleAndUser(){
        List<Role> roles = roleDao.findRoleAndUser();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
