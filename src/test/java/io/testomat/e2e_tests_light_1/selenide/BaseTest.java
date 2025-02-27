package io.testomat.e2e_tests_light_1.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light_1.selenide.common.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class BaseTest {

    protected static Dotenv env = Dotenv.load();
    protected static String username = env.get("USERNAME");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "Manufacture light";

    protected static Application app = new Application();


    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(username, password);
        app.projectsPage.signInSuccess();
    }

    static {
        Configuration.baseUrl = env.get("BASE_URL");
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }
}
