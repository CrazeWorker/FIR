import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");


//        添加
//        jdbcTemplate.execute("insert into account(name,money) values ('刘备',2000);");
//        修改
//        jdbcTemplate.update("update account set money = 10002 where name = '刘备';");
//        删除
//        jdbcTemplate.update("delete from account where name = '关羽';");
//        查询所有
//        List<com.bean.Account> query = jdbcTemplate.query("select * from account where money > ?", new BeanPropertyRowMapper<>(com.bean.Account.class), 1000);
//        for (com.bean.Account  a : query){
//            System.out.println(a);
//        }
//        聚集函数的使用
        Integer integer = jdbcTemplate.queryForObject("select count(name) from account where money > ?", Integer.class, 1000);
        System.out.println(integer);

    }
}
