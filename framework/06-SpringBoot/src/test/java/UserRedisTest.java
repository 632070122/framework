import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengshui.MySpringBootApplication;
import com.hengshui.dao.UserDao;
import com.hengshui.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class UserRedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserDao userDao;

    @Test
    public void test() throws JsonProcessingException {
        //从redis中查询
        String userFindAll = redisTemplate.boundValueOps("user.findAll").get();

        //判断是否有数据
        if(null == userFindAll){
            //不存在数据
            List<User> all = userDao.findAll();
            //将集合转换成json的字符串
            String userListJson = new ObjectMapper().writeValueAsString(all);
            //存储到redis中
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("从数据库查询");
            System.out.println(all);
        }else{
            //将数据控制台打印
            System.out.println("从缓存中查询");
            System.out.println(userFindAll);
        }

    }
}
