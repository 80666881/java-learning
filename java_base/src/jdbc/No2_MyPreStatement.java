package jdbc;

/**
 * 和 Statement一样，PreparedStatement也是用来执行sql语句的
 * 与创建Statement不同的是，需要根据sql语句创建PreparedStatement
 * 除此之外，还能够通过设置参数，指定相应的值，而不是Statement那样使用字符串拼接
 *
 * 优点:
 * 1.可读性和维护性好。
 *
 * 2.速度快
 * Statement执行10次，需要10次把SQL语句传输到数据库端
 * 数据库要对每一次来的SQL语句进行编译处理
 *
 * Statement执行10次，需要10次把SQL语句传输到数据库端
 * 数据库要对每一次来的SQL语句进行编译处理
 *
 *  每次执行，只需要传输参数到数据库端
 *      1. 网络传输量比Statement更小
 *      2. 数据库不需要再进行编译，响应更快
 *
 * 3.安全性高，防止sql注入式攻击
 * //见MyPreStatement2
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class No2_MyPreStatement {
    public static void main(String[] args) {
        try{
//            Class.forName("com.mysql.jdbc.Driver");//废弃
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root",
                        "root");
                //根据语句创建PreparedStatement
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            //设置参数
            ps.setString(1,"prepared英雄");
            ps.setFloat(2,333f);
            ps.setInt(3,33);
            //执行
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
