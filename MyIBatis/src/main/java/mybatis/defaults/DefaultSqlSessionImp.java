package mybatis.defaults;

import java.sql.Connection;
import mybatis.cfg.Configuration;
import mybatis.factory.SqlSession;
import mybatis.proxy.MapperHandler;
import mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.SQLException;

public class DefaultSqlSessionImp implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSessionImp(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao接口的字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass},new MapperHandler(cfg.getMappers(),conn));
        return null;
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (conn != null) {
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
