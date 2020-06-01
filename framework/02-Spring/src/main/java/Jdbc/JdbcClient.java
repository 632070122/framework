package Jdbc;

import java.sql.*;

//Jdbc链接mysql数据库
public class JdbcClient {
    public static void main(String[] args) throws Exception {   //transfer_accounts
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.21.128:3306/ssm","root","root");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from transfer_accounts");
        //4.执行sql语句,得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("name") + ":" + rs.getString("money"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
