import com.hengshui.MySpringBootApplication;
import com.hengshui.controller.QuickController;
import com.hengshui.dao.UserDao;
import com.hengshui.domain.User;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class UserMybatisTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuickController quickController;

    @Test
    public void findAll(){
        List<User> all = userDao.findAll();
        System.out.println(all);
        List<User> all1 = quickController.findAll();
        System.out.println(all1);
        System.out.println("findAll method is running");
    }

}
