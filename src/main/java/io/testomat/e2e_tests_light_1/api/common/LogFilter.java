package io.testomat.e2e_tests_light_1.api.common;

import io.restassured.filter.FilterContext;
import io.restassured.filter.OrderedFilter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogFilter implements OrderedFilter {

    public Response filter(
            FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx
    ) {
        log.info("{} {}", requestSpec.getMethod().toUpperCase(), requestSpec.getURI());
        if (requestSpec.getBody() != null)
            log.info("Request body:\n{}", requestSpec.getBody().toString());


        var response = ctx.next(requestSpec, responseSpec);

        log.info("{} {}", response.getStatusCode(), requestSpec.getURI());

        if (needToLogResponse()) {
            log.info("Content-Type: {}\n{}", response.getHeader("Content-Type"), response.asPrettyString());
        }

        return response;
    }

    private boolean needToLogResponse() {
        //        Properties properties = new Properties();
        // Assuming you load properties from file/classpath/env
        return true/*Boolean.parseBoolean(properties.getProperty("log.response"))*/;
    }

    public int getOrder() {
        return Integer.MAX_VALUE;
    }

}
