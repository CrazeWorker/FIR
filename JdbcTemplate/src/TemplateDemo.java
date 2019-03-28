import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TemplateDemo {
    public static void main(String[] args) {
        // 定义数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/transactiontest");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        jdbcTemplate.execute("insert into account value ('关羽',1999);");
    }
}
