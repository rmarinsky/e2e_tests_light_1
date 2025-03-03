package io.testomat.e2e_tests_light_1.web.playwright.common;

import com.microsoft.playwright.Page;
import io.testomat.e2e_tests_light_1.web.pw.HomePage;
import io.testomat.e2e_tests_light_1.web.pw.ProjectPage;
import io.testomat.e2e_tests_light_1.web.pw.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.pw.SignInPage;

public class PWApplication {

    private Page page;

    public HomePage homePage;
    public SignInPage signInPage;
    public ProjectsPage projectsPage;
    public ProjectPage projectPage;

    public PWApplication(Page page) {
        this.page = page;
        homePage = new HomePage(page);
        signInPage = new SignInPage(page);
        projectsPage = new ProjectsPage(page);
        projectPage = new ProjectPage(page);
    }



}
