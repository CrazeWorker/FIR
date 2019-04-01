package mybatis.proxy;

import java.sql.Connection;
import mybatis.cfg.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperHandler implements InvocationHandler {

    // map的key是全限定类名+"."+方法名
    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperHandler(Map<String, Mapper> mappers,Connection connection) {
        this.mappers =  mappers;
        this.connection = connection;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1、获取方法名
        String methodName = method.getName();
        // 2、获取方法所在的类
        String className = method.getDeclaringClass().getName();
        // 3、组合key
        String key = className + "." + methodName;
        // 4、获取mapper对象
        Mapper mapper = mappers.get(key);
        // 5、判断是否为mapper
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        // 6、调用工具类，执行selectList方法
        return new Executor().selectList(mapper, connection);
    }
}
