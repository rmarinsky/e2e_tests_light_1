package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.selenium.common.LoginTestomat;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverLifeCycleExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.findByText;

@ExtendWith({WebDriverLifeCycleExtension.class, LoginTestomat.class})
public class ProjectsTests {

    @Test
    @DisplayName("Projects possible to find by name")
    void projectsPossibleToFindByName() {
        find(".common-flash-success").waitFor().visibility();

        //search project
        String targetProjectName = "manufacture light";
        find("#search").sendKeys(targetProjectName);

        //select project
        findByText("Manufacture light").click();

        //wait for project is loaded
        find("h2").waitFor().containsText(targetProjectName);
    }

}
