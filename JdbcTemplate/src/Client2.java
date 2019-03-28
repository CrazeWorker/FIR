import com.bean.Account;
import com.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        List<Account> allAccount = accountDao.getAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
}
