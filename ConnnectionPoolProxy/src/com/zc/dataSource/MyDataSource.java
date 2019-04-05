package com.zc.dataSource;

import com.util.JDBCUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDataSource {
    private static List<Connection> conn = Collections.synchronizedList(new ArrayList<>());

    static {
        for (int i = 0; i < 10; i++) {
            conn.add(JDBCUtil.getConnection());
        }
    }

    public static Connection getConnection() {
        Connection remove = conn.remove(0);
        Connection connection = (Connection) Enhancer.create(remove.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object relVal = null;
                if ("close".equals(method.getName())) {
                    conn.add(remove);
                } else {
                    relVal = method.invoke(objects, method);
                }
                return relVal;
            }
        });
        return connection;
    }

    public static int getSize() {
        return conn.size();
    }
}
