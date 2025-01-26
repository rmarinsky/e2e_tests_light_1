package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.selenium.common.Elements;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverManager;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverRunnerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.selenium.common.Elements.find;

@ExtendWith(WebDriverRunnerExtension.class)
public class ProjectsPageWithWrapperTests {

    @Test
    @DisplayName("projects possible to find")
    void projectsPossibleToFind() {
        WebDriverManager.driver().get("https://app.testomat.io/");

        find("#content-desktop #user_email").sendKeys("newromka@gmail.com");
        find("#content-desktop #user_password").sendKeys("c27sXAn#8R5hQUd");
        find("#content-desktop #user_remember_me").click();
        find("#content-desktop [name='commit']").click();

        find(".common-flash-success").waitFor().toBeVisible();

        find("#search").sendKeys("manufacture light");
        find("//*[text()='Manufacture light']").click();
        find("h2").waitFor().hasText("Manufacture light");
    }

}
