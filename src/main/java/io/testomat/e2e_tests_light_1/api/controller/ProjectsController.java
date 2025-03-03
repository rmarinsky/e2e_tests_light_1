package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.http.ContentType;

public class ProjectsController extends BaseController<ProjectsController> {

    public void getProjects() {
        testomatApi()
                .contentType(ContentType.JSON)
                .get("/projects");
    }

}
