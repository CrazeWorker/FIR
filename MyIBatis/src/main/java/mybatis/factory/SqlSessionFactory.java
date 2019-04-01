package mybatis.factory;

public interface SqlSessionFactory {
    /**
     * 打开一个新的session对象
     * @return
     */
    SqlSession openSession();
}
