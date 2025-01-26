package io.testomat.e2e_tests_light_1.selenide.common;

import io.testomat.e2e_tests_light_1.selende.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.selende.pages.ProjectsPage;
import io.testomat.e2e_tests_light_1.selende.pages.ReadmePage;
import io.testomat.e2e_tests_light_1.selende.pages.SignInPage;

public class Application {

    public final ProjectsPage projectsPage = new ProjectsPage();
    public final SignInPage signInPage = new SignInPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final ReadmePage readmePage = new ReadmePage();

}
