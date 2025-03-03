package io.testomat.e2e_tests_light_1.api.controller;

public class AuthController extends BaseController<AuthController> {

    public String loginUser(String username, String password) {
        return testomatApi()
                .formParam("email", username)
                .formParam("password", password)
                .post("/login")
                .jsonPath().getString("jwt");
    }

}
