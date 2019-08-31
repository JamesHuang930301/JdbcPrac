package jdbcPrac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void query(){
        Connection conn = null;
        String sql = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            sql = "SELECT * FROM MAIN";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println("DATE: "+rs.getString(1)
                                 + "\t"+"AMOUNT: "+rs.getString(2)
                                 + "\t"+"EXPENSE: "+rs.getString(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
           JdbcUtil.freeConnection(conn,pstm,rs);
        }
    }
}
