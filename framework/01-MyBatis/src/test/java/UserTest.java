import com.hengshui.dao.UserDao;
import com.hengshui.domain.Account;
import com.hengshui.domain.IdentityCard;
import com.hengshui.domain.User;
import com.hengshui.domain.pojo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {

    private InputStream in; //读取配置文件
    private SqlSessionFactoryBuilder builder; //创建SqlSessionFactoryBuilder对象
    private SqlSessionFactory factory; //使用SqlSessionFactoryBuilder的builder方法传递流创建SqlSessionFactory对象
    private SqlSession session; //使用SqlSessionFactory的方法openSession方法来创建SqlSession对象
    private UserDao userDao; //使用SqlSession的getMapper方法来创建Dao接口的代理对象

    @Before
    public void start() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void end() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        System.out.println(users);
    }

    @Test
    public void saveUser1(){
        User user = new User();
        user.setUsername("小明");
        user.setAddress("衡水");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser1(user);
    }

    @Test
    public void saveUser2(){
        User user = new User();
        user.setUsername("小明");
        user.setAddress("衡水");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前："+user);
        userDao.saveUser2(user);
        System.out.println("保存后："+user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUsername("小明");
        user.setAddress("衡水");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setId(52);
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(52);
    }

    @Test
    public void findOne(){
        User user = userDao.findOne(51);
        System.out.println(user);
    }

    @Test
    public void findByName1(){
        List<User> users = userDao.findByName1("%王%");
        System.out.println(users);
    }

    @Test
    public void findByName2(){
        List<User> users = userDao.findByName2("王");
        System.out.println(users);
    }

    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void findUserByQueryVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByQueryVo(vo);
        System.out.println(users);
    }

    @Test
    public void findUserByCondition1(){
        User user = new User();
        user.setUsername("老王");
        user.setAddress("北京");
        List<User> users = userDao.findUserByCondition1(user);
        System.out.println(users);
    }

    @Test
    public void findUserByCondition2(){
        User user = new User();
        user.setUsername("老王");
        user.setAddress("北京");
        List<User> users = userDao.findUserByCondition2(user);
        System.out.println(users);
    }

    @Test
    public void findUserInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        System.out.println(users);
    }

    @Test
    public void findNameAll(){
        List<User> users = userDao.findNameAll("老王");
        System.out.println(users);
    }

    @Test
    public void findUserAccount(){
        List<User> userAccount = userDao.findUserAccount();
        System.out.println(userAccount);
    }

    @Test
    public void findUserAndRole(){
        List<User> users = userDao.findUserAndRole();
        for (User user : users) {
            System.out.println("--------------------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void userDelayAccount(){
        List<User> users = userDao.findUserDelayAccount();
        for (User user : users) {
            System.out.println("--------------------------------------------------------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void findUserDelayIdentityCard(){
        List<User> users = userDao.findUserDelayIdentityCard();
        for (User user : users) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println(user);
            System.out.println(user.getIdentityCard());
        }
    }

    @Test
    public void firstLevelCache() throws InterruptedException {
        User user1 = userDao.findOne(41);
        System.out.println(user1);

        //清空一级缓存方法1
        session.close();
        session = factory.openSession(true);
        userDao = session.getMapper(UserDao.class);
        //清空一级缓存方法2
        session.clearCache();

        User user2 = userDao.findOne(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

}
