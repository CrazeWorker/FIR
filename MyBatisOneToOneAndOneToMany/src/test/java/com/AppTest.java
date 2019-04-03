package com;

import static org.junit.Assert.assertTrue;

import com.bean.Account;
import com.bean.Student;
import com.bean.StudentAccount;
import com.dao.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init(){
        try {
            in = Resources.getResourceAsStream("conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 一对一的查询
    @Test
    public void shouldAnswerWithTrue() {
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = mapper.selectAllAccount();
        for (Account account : accounts) {
            System.out.println("---------每一个账户的信息----------");
            System.out.println(account);
            System.out.println(account.getStudent());
        }
    }

    // 一对一的查询
    @Test
    public void testSelect() {
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<StudentAccount> accounts = mapper.selectAllAccountAndStudent();
        for (StudentAccount studentAccount : accounts) {
            System.out.println("---------每一个账户的信息----------");
            System.out.println(studentAccount);
        }
    }
}
