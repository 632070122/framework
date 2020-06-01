package jdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateClient {
    public static void main(String[] args) {
        //准备数据源,Spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.21.128:3306/ssm?characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("root");

        //创建对象JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();

        //给JdbcTemplate设置数据源
        jt.setDataSource(ds);

        //执行操作
        jt.execute("insert into transfer_accounts(name,money) values('ddd',2000)");


    }
}
