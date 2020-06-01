package ioc.annoCasePureness.config;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置类,和xml作用是一样的
 * @Configuration 表明当前类是一个配置类
 * @ComponentScan 指定通过注解要扫描的包
 * @Bean 把当前方法的返回值存入Spring容器
 * @Import 导入其他的配置类
 * @PropertySource 加载properties文件
 * @Value 获取properties配置文件的key
 * @RunWith(SpringJUnit4ClassRunner.class) 替换运行器,集成JUnit4测试
 * @ContextConfiguration 告知是XML还是注解
 *      locations 指定xml文件的位置,加上classpath关键字,表示在类路径下
 *      classes 指定注解类所在的位置
 *
 */

@Configuration
@ComponentScan(basePackages = "ioc.annoCasePureness")
@Import(JdbcConfig.class)
public class SpringConfiguration {


}
