package io.testomat.e2e_tests_light_1.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.testomat.e2e_tests_light_1.playwright.common.PWApplication;
import io.testomat.e2e_tests_light_1.playwright.common.PWOptions;
import org.junit.jupiter.api.Test;

@UsePlaywright(PWOptions.class)
public class ProjectsPlaywright {

    /*@RegisterExtension
    static PWExtention pw = new PWExtention();*/

    @Test
    void projectPossibleToFilterPWTest(Page page) {
        var app = new PWApplication(page);
        // Open the website
        app.homePage.open();
        app.signInPage.loginUser("newromka@gmail.com", "c27sXAn#8R5hQUd");

        var targetProjectName = "Manufacture light";

        // Wait for success message
        app.projectsPage
                .signSuccessIsVisible()
                .searchForProject(targetProjectName)
                .clickOnProjectByName(targetProjectName);

        app.projectPage.projectTitleIs(targetProjectName);

    }

}
