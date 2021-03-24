package ru.netology.manager;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.data.User;

import java.sql.DriverManager;
import java.sql.SQLException;

//public class SqlQuery {
//
////    public static String getVerCode(String userId) throws SQLException {
////        val usersSQL = "SELECT * FROM users;";
////        val runner = new QueryRunner();
////        try (
////                val conn = DriverManager.getConnection(
////                        "jdbc:mysql://localhost:3306/app", "app", "pass"
////                );
////        ) {
////            val first = runner.query(conn, usersSQL, new BeanHandler<>(User.class));
////            System.out.println(first);
////        }
////        return "";
////    }
//}

