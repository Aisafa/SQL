package ru.netology.manager;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.data.AuthCode;
import ru.netology.data.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlQuery {

    public static User getUser() throws SQLException {
        val usersSQL = "SELECT * FROM users;";
        val runner = new QueryRunner();
        User user1;
        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
        ) {
            user1 = runner.query(conn, usersSQL, new BeanHandler<>(User.class));

        }
        return user1;
    }

    public static AuthCode getAuthCodeFromUser() throws SQLException {
        AuthCode code;
        val usersSQL = "SELECT * FROM auth_codes WHERE created = (SELECT MAX(created) FROM auth_codes);";
        val runner = new QueryRunner();
        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
        ) {
            code = runner.query(conn, usersSQL, new BeanHandler<>(AuthCode.class));
        }
        return code;
    }

    public static void clearTables() throws SQLException {
        var runner = new QueryRunner();
        String delUsersSQL = "DELETE FROM users;";
        String delCardsSQL = "DELETE FROM cards;";
        String delAuthSQL = "DELETE FROM auth_codes;";
        String delTransSQL = "DELETE FROM card_transactions;";

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                )
        ) {
            // очистка таблиц
            runner.update(conn, delTransSQL);
            runner.update(conn, delCardsSQL);
            runner.update(conn, delAuthSQL);
            runner.update(conn, delUsersSQL);
        }
    }
}

