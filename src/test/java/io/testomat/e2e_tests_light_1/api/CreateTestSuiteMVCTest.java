package io.testomat.e2e_tests_light_1.api;

import io.testomat.e2e_tests_light_1.api.dto.SuiteListResponse;
import io.testomat.e2e_tests_light_1.api.dto.SuiteRequest;
import io.testomat.e2e_tests_light_1.api.dto.SuiteResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateTestSuiteMVCTest extends BaseApiTest {


    @Test
    @DisplayName("Login user and create test suite")
    void loginUserAndCreateTestSuite() {
        projectsController.getProjects();

        var targetSuite = getTestSuite();

        var createdSuite = suitesController.createNewSuite(targetProjectName, targetSuite)
                .as(SuiteResponse.class);

        var actualTitle = suitesController.getSuitesForProject(targetProjectName)
                .as(SuiteListResponse.class);

        Assertions.assertThat(actualTitle.getData()).usingRecursiveFieldByFieldElementComparatorIgnoringFields("labels")
                .contains(createdSuite.getData());
    }


    private SuiteRequest getTestSuite() {
        return SuiteRequest.of()
                .setData(SuiteRequest.DataWrapper.of()
                        .setType("suites")
                        .setAttributes(SuiteRequest.Attributes.of()
                                .setTitle("auto_test_" + faker.book().title())
                                .setDescription(faker.chuckNorris().fact())
                        )
                );
    }

}
