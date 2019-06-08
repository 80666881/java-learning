package jdbc;

/*
 * 事务:要么都成功，要么都失败
 * 在Mysql中，只有当表的类型是INNODB的时候，才支持事务，所以需要把表的类型设置为INNODB,否则无法观察到事务.

    修改表的类型为INNODB的SQL：

    alter table hero ENGINE  = innodb;



    查看表的类型的SQL

    show table status from how2java;
 * */

import java.sql.*;

public class No6_Transition {
    //不使用事务的情况下
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root",
                        "root");
                Statement s = c.createStatement();
        ) {
            //没有事务的前提下
            //假设业务操作时，加血，减血各做一次
            //结束后，英雄的血量不变
//                String sql1 = "update hero set hp = hp+1 where id=22";
//                s.execute(sql1);

            //减血的SQL
            //不小心写错写成了 updata(而非update)
//                String sql2 = "updata hero set hp = hp-1 where id=22";
//                s.execute(sql2);

            // 有事务的前提下
            // 在事务中的多个操作，要么都成功，要么都失败
            c.setAutoCommit(false);
            // 加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);

            // 减血的SQL
            // 不小心写错写成了 updata(而非update)

            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
