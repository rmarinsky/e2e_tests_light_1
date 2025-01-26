package io.testomat.e2e_tests_light_1.selenium.common;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebDriverRunnerExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        WebDriverManager.quitDriver();
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        WebDriverManager.driver();
    }

}
