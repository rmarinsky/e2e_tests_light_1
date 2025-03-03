package io.testomat.e2e_tests_light_1.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor = "of")
@Accessors(chain = true)
public class SuiteRequest {

    private DataWrapper data;

    @Data(staticConstructor = "of")
    @Accessors(chain = true)
    public static class DataWrapper {

        private String type = "suites";
        private Attributes attributes;

    }

    @Data(staticConstructor = "of")
    @Accessors(chain = true)
    public static class Attributes {

        private String title;
        private String description = "sample suite description";

    }

}