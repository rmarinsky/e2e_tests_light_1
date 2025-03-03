package io.testomat.e2e_tests_light_1.api;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.testomat.e2e_tests_light_1.api.common.LogFilter;
import io.testomat.e2e_tests_light_1.api.controller.AuthController;
import io.testomat.e2e_tests_light_1.api.controller.ProjectsController;
import io.testomat.e2e_tests_light_1.api.controller.SuitesController;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class BaseApiTest {

    private static String jwtToken;

    static {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(objectMapperConfig()
                        .jackson2ObjectMapperFactory((cls, charset) -> {
                            var om = new ObjectMapper().findAndRegisterModules();
                            om.configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature(), true);
                            return om;
                        }));
        RestAssured.filters(new LogFilter());
    }

    @BeforeAll
    public static void login() {
        jwtToken = new AuthController().loginUser(username, password);
    }

    protected static Dotenv env = Dotenv.load();
    protected static String username = env.get("USERNAME");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "manufacture-light";
    protected Faker faker = new Faker();

    protected ProjectsController projectsController = new ProjectsController()
            .withToken(jwtToken);
    protected SuitesController suitesController = new SuitesController().withToken(jwtToken);

}
