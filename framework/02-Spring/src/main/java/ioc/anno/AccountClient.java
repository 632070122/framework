package ioc.anno;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建对象的四个注解,属性value用于指定bean的id
 *      @Component,@Repository,@Service,@Controller
 * 用于注入Bean的注解
 *      @Autowired,自动按照类型注入,有多个类型时,按照名称注入
 *      @Qualifier,在自动按照类型注入的基础上,再按照id注入
 *      @Resource,直接按照bean的id注入
 * 用于注入基本类型和String的注解
 *      @Value,用于注入基本类型和String的注解,属性value指定数据的值,用el表达式${}
 * 改变作用范围的注解
 *      @Scope,用于指定bean的作用范围,属性value指定范围的取值(singleton,prototype)
 * 生命周期的注解
 *      @PostConstruct指定初始化方法,@PreDestory用于指定销毁方法
 */

public class AccountClient {

    @Test
    public void Account01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_anno.xml");
        Account01 account01 = (Account01)ac.getBean("account01");
        account01.saveAccount();
    }

    @Test
    public void Account02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_anno.xml");
        Account02 account02 = (Account02)ac.getBean("account02");
        account02.saveAccount();
    }

    @Test
    public void Account03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_anno.xml");
        Account03 account03 = (Account03)ac.getBean("account03");
        account03.saveAccount();
    }

    @Test
    public void Account04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc_anno.xml");
        Account04 account04 = (Account04)ac.getBean("account04");
        account04.saveAccount();
    }
}
