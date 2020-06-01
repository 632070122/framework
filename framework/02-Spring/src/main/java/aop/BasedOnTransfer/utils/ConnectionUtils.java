package aop.BasedOnTransfer.utils;

import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 链接的工具类,用于从数据源中获取链接,实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Setter
    private DataSource dataSource;

    /**
     * 获取当前线程上的链接
     * @return
     */
    public Connection getThreadConnection(){
        //先从ThreadLocal上获取
        Connection conn = tl.get();
        try {
            //判断当前线程上是否有链接
            if(conn == null){
                //如果没有,就从数据源中获取链接,并且存入ThreadLocal中
                conn = dataSource.getConnection();
                //把Connection存入ThreadLocal中
                tl.set(conn);
            }
            //返回当前线程上的链接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    //把链接和线程解绑
    public void removeConnection(){
        tl.remove();
    }

}
