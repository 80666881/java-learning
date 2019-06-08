package jdbc;

/*
*
* execute与executeUpdate的相同点：都可以执行增加，删除，修改
  不同1：
    execute可以执行查询语句
    然后通过getResultSet，把结果集取出来
    executeUpdate不能执行查询语句
  不同2:
    execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
    executeUpdate返回的是int，表示有多少条数据受到了影响
 * */

import java.sql.*;

public class No5_UpdateExcute {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root",
                        "root"
                        );
                Statement s = c.createStatement();
                // 不同1：execute可以执行查询语句
                // 然后通过getResultSet，把结果集取出来
                ){
                String sql= "select * from hero";
                s.execute(sql);
                ResultSet rs = s.getResultSet();
                while (rs.next()){
                    System.out.println(rs.getInt("id"));
                }
                // executeUpdate不能执行查询语句
                // s.executeUpdate(sqlSelect);


                // 不同2:
                // execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
                Boolean isSelect = s.execute(sql);
                System.out.println(isSelect);

                //executeUpdate返回的是受影响的数据
                String sqlUpdate = "update Hero set hp = 300 where id < 50";
                int number = s.executeUpdate(sqlUpdate);
                System.out.println(number);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
