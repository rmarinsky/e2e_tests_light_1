package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.testomat.e2e_tests_light_1.api.dto.SuiteRequest;

public class SuitesController extends BaseController<SuitesController> {

    public Response createNewSuite(String targetProjectName, SuiteRequest data) {
        return testomatApi()
                .contentType(ContentType.JSON)
                .body(data)
                .post("/" + targetProjectName + "/suites");
    }

    public Response getSuitesForProject(String targetProjectName) {
        return testomatApi()
                .get("/" + targetProjectName + "/suites");
    }

}
