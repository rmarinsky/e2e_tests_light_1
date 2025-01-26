package io.testomat.e2e_tests_light_1.selenium.common;

import io.testomat.e2e_tests_light_1.selenium.web.pages.LoginPageSelenium;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;

public class LoginTestomat implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        driver().get("https://app.testomat.io/");

        new LoginPageSelenium()
                .login("newromka@gmail.com", "c27sXAn#8R5hQUd");
    }

}
