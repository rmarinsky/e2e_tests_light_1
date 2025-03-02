package io.testomat.e2e_tests_light_1.api;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateTestSuiteTest {

    protected static Dotenv env = Dotenv.load();
    protected static String username = env.get("USERNAME");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "manufacture-light";

    @Test
    @DisplayName("Login user and create test suite")
    void loginUserAndCreateTestSuite() {
        String jwtToken = loginUser();

        getProjects(jwtToken);

        var targetSuite = """
                {
                  "data": {
                    "type": "suites",
                    "attributes": {
                      "title": "%s",
                      "description": "sample suite description"
                    }
                  }
                }
                """;

        String targetSuiteBody = String.format(targetSuite, "aut_test_" + System.currentTimeMillis());

        createNewSuite(jwtToken, targetSuiteBody);

        getSuitesForProject(targetProjectName, jwtToken);
    }

    private void createNewSuite(String jwtToken, String data) {
        testomatApi()
                .header("Authorization", jwtToken)
                .contentType(ContentType.JSON)
                .body(data)
                .post("/" + targetProjectName + "/suites")
                .then().log().all().statusCode(200);
    }

    private void getSuitesForProject(String targetProjectName, String jwtToken) {
        testomatApi()
                .header("Authorization", jwtToken)
                .get("/" + targetProjectName + "/suites")
                .then().log().all().statusCode(200);
    }

    private void getProjects(String jwtToken) {
        testomatApi()
                .header("Authorization", jwtToken)
                .contentType(ContentType.JSON)
                .get("/projects");
    }

    private String loginUser() {
        return testomatApi()
                .formParam("email", username)
                .formParam("password", password)
                .post("/login")
                .jsonPath().getString("jwt");
    }

    private RequestSpecification testomatApi() {
        return RestAssured.given()
                .baseUri("https://app.testomat.io")
                .basePath("/api")
                .accept(ContentType.JSON)
                .log().all();
    }


}
