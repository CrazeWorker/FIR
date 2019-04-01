package mybatis.utils;

import java.sql.Connection;
import mybatis.cfg.Mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Executor {
    public <E> List<E> selectList(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // 1、取出mapper中的数据
            String queryString = mapper.getQueryString();
            String resultType = mapper.getResultType();
            Class domainClass = Class.forName(resultType);
            // 2、获取PreparedStatement对象
            pstm = conn.prepareStatement(mapper.getQueryString());
            // 3、执行sql语句，获取结果集
            rs = pstm.executeQuery();
            // 4、封装结果集
            List<E> list = new ArrayList<>();
            while (rs.next()) {
                // 实例化要封装的实体类对象
                E obj = (E) domainClass.newInstance();
                // 取出结果集的源信息，ResultSetMetaData
                ResultSetMetaData metaData = rs.getMetaData();
                // 取出总列数
                int columnCount = metaData.getColumnCount();
                // 遍历总列数
                for (int i = 1; i <= columnCount; i++) {
                    // 获取每列的名称，列名的序号是从1开始的
                    String columnName = metaData.getColumnName(i);
                    // 根据列名，获取每一列的值
                    Object columnValue = rs.getObject(columnName);
                    // 给obj赋值，是哦那个java内省机制（借助propertyDescriptor实现属性的封装）
                    PropertyDescriptor pd = new PropertyDescriptor(columnName, domainClass);
                    // 获取它的写入方法
                    Method writeMethod = pd.getWriteMethod();
                    // 把获取的列的值，给对象赋值
                    writeMethod.invoke(obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(pstm, rs);
        }
        return null;
    }

    private void release(PreparedStatement pstm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
