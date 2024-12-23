package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.utils.StringParsers;
import io.testomat.e2e_tests_light_1.web.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.pages.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");

    private final ProjectPage projectPage = new ProjectPage();
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        signInPage.open();
        signInPage.loginUser(username, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {
        projectsPage.searchForProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
        projectsPage.searchForProject(targetProjectName);

        var targetProject = projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        projectsPage.countOfTestsCasesShouldBeEqualTo(targetProject, 0);

        projectsPage.totalCountOfProjectsIsVisible();

        var totalProjects = projectsPage.getTotalCountOfTestCases();
        var actualCountOfTotalTests = parseIntegerFromString(totalProjects);
        Assertions.assertTrue(actualCountOfTotalTests > 100);
    }

    @Test
    public void exampleAssertDouble() {
        var text = "15.4 coverage";
        Double actualDouble = StringParsers.parseDoubleFromString(text);

        Assertions.assertTrue(15.4 >= actualDouble);
    }

    @Test
    public void exampleParseInteger() {
        var text = "0 tests";
        Integer actual = parseIntegerFromString(text);

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void exampleParseBoolean() {
        var text = "true";
        Boolean actual = Boolean.parseBoolean(text);

        Assertions.assertEquals(true, actual);
    }


}
