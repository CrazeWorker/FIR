package mybatis.utils;

import mybatis.cfg.Configuration;
import mybatis.cfg.Mapper;
import mybatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLConfigBuilder {
    public static Configuration loadConfiguration(InputStream config) {
        try {
            // 定义封装连接信息的配置对象
            Configuration cfg = new Configuration();

            // 1、获取SAXReader对象
            SAXReader reader = new SAXReader();
            // 2、根据字节输入流获取Document对象
            Document document = reader.read(config);
            // 3、获取根节点
            Element root = document.getRootElement();
            // 4、使用xpath中选择指定字节的方式，获取所有的property结点
            List<Element> propertyElements = root.selectNodes("//property");
            // 5、遍历结点
            for (Element element : propertyElements) {
                // 判断结点是连接数据库的哪个部分
                // 取出name属性的值
                String name = element.attributeValue("name");
                if ("driver".equals(name)) {
                    // 如果值为驱动，获取property的value属性，并把值赋给Configuration对象相应的属性
                    String driver = element.attributeValue("value");
                    cfg.setDriver(driver);
                }
                if ("url".equals(name)) {
                    // 如果值为url，获取property的value属性，并把值赋给Configuration对象相应的属性
                    String url = element.attributeValue("value");
                    cfg.setUrl(url);
                }
                if ("username".equals(name)) {
                    // 如果值为username，获取property的value属性，并把值赋给Configuration对象相应的属性
                    String username = element.attributeValue("value");
                    cfg.setUsername(username);
                }
                if ("password".equals(name)) {
                    // 如果值为password，获取property的value属性，并把值赋给Configuration对象相应的属性
                    String password = element.attributeValue("value");
                    cfg.setPassword(password);
                }
            }
            // 取出mapper中所有的标签，判断他们是resource还是class属性
            List<Element> mapperElements = root.selectNodes("//mapper/mapper");
            // 遍历集合
            for (Element element : mapperElements) {
                // 判断mapper使用的是那个属性
                Attribute attribute = element.attribute("resource");
                if (attribute != null) {
                    // 如果不为空，则表示使用的是xml方式
                    // 取出属性的值
                    String mapperPath = attribute.getValue();//获取属性的值，即xml的namespace
                    // 把映射配置文件的内容取出来，封装成一个Map
                    Map<String, Mapper> mappers = loadMapperConfiguration(mapperPath);
                    // 给Configuration的mappers赋值
                    cfg.setMappers(mappers);
                } else {
                    // 没有使用resource，则使用的是class，注解方式
                }
            }
            return cfg;
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            try {
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static Map<String, Mapper> loadMapperConfiguration(String mapperPath){
        InputStream in = null;
        try {
            // 定义返回值对象
            Map<String, Mapper> mappers = new HashMap<>();
            // 1、根据路径获取字节输入流
            in = Resources.getResourceAsStream(mapperPath);
            // 2、根据字节输入流获取Document对象
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            // 3、获取根节点
            Element root = document.getRootElement();
            // 4、获取根节点的namespace属性
            String namespace = root.attributeValue("namespace");//是组成map中key的一部分
            // 5、获取所有的select结点
            List<Element> list = root.selectNodes("//select");
            // 6、遍历select结点集合
            for (Element element : list) {
                // 取出属性名为id的值，组成map中key的部分
                String id = element.attributeValue("id");
                // 取出resultType属性的值，组成map中value的部分
                String resultType = element.attributeValue("resultType");
                // 取出文本内容，组成map中的value部分
                String queryString = element.getText();//sql
                // 创建key
                String key = namespace + "." + id;
                // 创建value
                Mapper mapper = new Mapper();
                mapper.setQueryString(queryString);
                mapper.setResultType(resultType);
                // 把key和value存到mappers中
                mappers.put(key, mapper);
            }
            return mappers;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
