package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.manager.SqlQuery;
import ru.netology.pages.LoginPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
        clearBrowserCookies();
    }

    @AfterAll
    static void deleteTabs() throws SQLException {
        SqlQuery.clearTables();
    }

    @Test
    void shouldLogin() throws SQLException {
        val authInfo = DataHelper.getAuthInfo();
        val loginPage = new LoginPage();
        val user = SqlQuery.getUser();
        val verificationPage = loginPage.validLogin(authInfo);
        val verCode = SqlQuery.getAuthCodeFromUser();
        val dashboardPage = verificationPage.validVerify(verCode);
    }

}

