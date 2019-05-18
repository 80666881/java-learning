package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        list(10, 5);
    }
    public static void mysqlTest(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "root");
             // 注意：使用的是 java.sql.Statement
             // 不要不小心使用到： com.mysql.jdbc.Statement;
             Statement s = c.createStatement();
        ) {

            // 增
            // 注意： 字符串要用单引号'
//            for (int i = 0; i < 100; i++) {
//                String sql = "insert into hero values(null," + "'英雄" + i + "'," + 313.0f + "," + 50 + ")";
//                s.execute(sql);
//            }

            //删
//            String sql = "delete from hero where id = 5";
//            s.execute(sql);

            //改
//            String sql = "update hero set name = 'name 5' where id = 3";
//            s.execute(sql);


            //查
//            String sql = "select * from hero";
            // 执行查询语句，并把结果集返回给ResultSet
//            ResultSet rs = s.executeQuery(sql);
//            while(rs.next()){
//                int id = rs.getInt("id");//获取int类型的id字段
//                String name = rs.getString(2);//也可以使用字段的顺序
//                float hp = rs.getFloat("hp");
//                int damage = rs.getInt(4);
//                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
//            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();


            //查询用户密码是否正确
//            String name = "dashen";
//            String password = "thisispassword";
//            String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
//
//            // 执行查询语句，并把结果集返回给ResultSet
//            ResultSet rs = s.executeQuery(sql);
//
//            if(rs.next())
//                System.out.println("账号密码正确");
//            else
//                System.out.println("账号密码错误");


            //查询总数
//            String sql = "select count(*) from hero";
//            ResultSet rs = s.executeQuery(sql);
//            int total=0;
//            while(rs.next()){
//                total = rs.getInt(1);
//            }
//            System.out.println("hero表中共有"+total+"条数据");


            System.out.println("执行插入语句成功");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //        分页查询方法
    public static void list(int start, int count) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "root"); Statement s = c.createStatement();) {

            String sql = "select * from hero limit " + start + "," + count;

            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}