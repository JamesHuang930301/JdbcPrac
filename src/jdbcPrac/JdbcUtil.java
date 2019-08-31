package jdbcPrac;

import java.sql.*;

public class JdbcUtil {

    public static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://3.113.132.132/incomeMgt";
        String username = "jameshuang";
        String password = "hxn1993@@@";
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void freeConnection(Connection conn, PreparedStatement pstm, ResultSet rs){
        if (null != conn){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (null != pstm){
            try{
                pstm.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (null != rs){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
