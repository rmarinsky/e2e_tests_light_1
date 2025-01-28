package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;

public class SignInPage {

    private final Page page;

    public SignInPage(Page page) {
        this.page = page;
    }

    public SignInPage loginUser(String username, String password) {
        page.locator("#content-desktop #user_email").fill(username);
        page.locator("#content-desktop #user_password").fill(password);
        page.locator("#content-desktop #user_remember_me").click();
        page.locator("#content-desktop [name=\"commit\"]").click();
        return this;
    }

}
