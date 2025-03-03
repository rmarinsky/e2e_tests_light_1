package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseController<T> {

    private String targetToken;

    protected RequestSpecification testomatApi() {
        var reqSpec = RestAssured.given()
                .baseUri("https://app.testomat.io")
                .basePath("/api")
                .accept(ContentType.JSON);
        if (targetToken != null) {
            reqSpec.header("Authorization", targetToken);
        }
        return reqSpec;
    }

    public void cleanToken() {
        this.targetToken = null;
    }

    @SuppressWarnings("unchecked")
    public T withToken(String targetToken) {
        this.targetToken = targetToken;
        return (T) this;
    }

}
