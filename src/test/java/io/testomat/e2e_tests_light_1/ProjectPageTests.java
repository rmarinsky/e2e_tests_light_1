package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.utils.StringParsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {


    @BeforeEach
    void openProjectsPage() {
        app.projectsPage.open();
        app.projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {
        app.projectsPage.searchForProject(targetProjectName);

        app.projectsPage.selectProject(targetProjectName);

        app.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {
        app.projectsPage.searchForProject(targetProjectName);

        var targetProject = app.projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        app.projectsPage.countOfTestsCasesShouldBeEqualTo(targetProject, 0);

        app.projectsPage.totalCountOfProjectsIsVisible();

        var totalProjects = app.projectsPage.getTotalCountOfTestCases();
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
