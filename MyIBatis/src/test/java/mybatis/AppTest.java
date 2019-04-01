package mybatis;

import static org.junit.Assert.assertTrue;

import com.dao.StudentMapper;
import mybatis.factory.SqlSession;
import mybatis.factory.SqlSessionFactory;
import mybatis.factory.SqlSessionFactoryBuilder;
import mybatis.io.Resources;
import org.junit.Test;

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
    @Test
    public void shouldAnswerWithTrue() {
        // 加载配置文件，把他转换成一个输入流
        InputStream inputStream = Resources.getResourceAsStream("configuration.xml");
        // 获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得dao接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询方法
        studentMapper.selectAll();
    }
}
