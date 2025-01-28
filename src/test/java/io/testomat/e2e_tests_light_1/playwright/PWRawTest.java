package io.testomat.e2e_tests_light_1.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PWRawTest {

    @Test
    void projectPossibleToFilterPWTest() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Open the website
        page.navigate("https://app.testomat.io/");

        // Login user
        page.locator("#content-desktop #user_email").fill("newromka@gmail.com");
        page.locator("#content-desktop #user_password").fill("c27sXAn#8R5hQUd");
        page.locator("#content-desktop #user_remember_me").click();
        page.locator("#content-desktop [name=\"commit\"]").click();

        // Wait for success message
        assertThat(page.locator(".common-flash-success")).isVisible();

        // Search project
        page.locator("#search").fill("manufacture light");

        // Select project
        page.locator("text=Manufacture light").click();

        // Wait for project to load
        assertThat(page.locator("h2")).containsText("Manufacture light");
        // Close browser
        browser.close();
    }

}
