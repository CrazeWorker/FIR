package mybatis.factory;

import mybatis.cfg.Configuration;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构件一个sqlsessionfactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return null;
    }
}
