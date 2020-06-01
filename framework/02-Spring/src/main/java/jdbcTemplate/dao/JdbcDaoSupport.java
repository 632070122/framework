package jdbcTemplate.dao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDaoSupport {

    @Setter
    @Getter
    private JdbcTemplate jdbcTemplate;

}
