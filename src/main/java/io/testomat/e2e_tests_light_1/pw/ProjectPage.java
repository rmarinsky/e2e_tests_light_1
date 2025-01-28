package io.testomat.e2e_tests_light_1.pw;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectPage {

    private final Page page;

    public ProjectPage(Page page) {
        this.page = page;
    }

    public ProjectPage projectTitleIs(String targetProjectName) {
        assertThat(page.locator("h2").first()).containsText(targetProjectName);
        return this;
    }

}
