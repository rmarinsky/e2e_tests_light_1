package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectsPage {

    private final Page page;

    public ProjectsPage(Page page) {
        this.page = page;
    }

    public ProjectsPage signSuccessIsVisible() {
        assertThat(page.locator(".common-flash-success")).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));
        return this;
    }


    public ProjectsPage searchForProject(String targetProjectName) {
        page.locator("#search").fill(targetProjectName);
        return this;
    }

    public ProjectsPage clickOnProjectByName(String targetProjectName) {
        page.getByText(targetProjectName).click();

        return this;
    }

}
