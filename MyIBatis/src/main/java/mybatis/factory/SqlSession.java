package mybatis.factory;

public interface SqlSession {
    /**
     * 获得dao接口的代理对象
     * @param daoInterfaceClass dao接口的字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);


    /**
     * 释放资源
     */
    void close();
}
