package factoryDecoupling.factory;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //定义properties对象
    private static Properties props;

    //定义一个Map用于存放要创建的对象,称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        try {
            //初始化properties对象
            props = new Properties();
            //用类加载器来获取流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("factoryDecoupling.properties");
            //使用Properties对象读取一个流
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每一个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            //初始化失败后的提示
            throw new ExceptionInInitializerError(e+"初始化properties失败");
        }
    }

    //根据bean的名称获取bean对象(单利对象)
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
