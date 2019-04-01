package mybatis.defaults;

import mybatis.cfg.Configuration;
import mybatis.factory.SqlSession;
import mybatis.factory.SqlSessionFactory;

public class DefaultSqlSessionFatoryImp implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFatoryImp(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 根据参数字节输人流创建一个sqlsession对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSessionImp(cfg);
    }
}
