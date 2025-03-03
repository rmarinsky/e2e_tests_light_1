package io.testomat.e2e_tests_light_1.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class SuiteListResponse {

    @JsonProperty("data")
    private List<SuiteResponse.SuiteData> data;

    private Meta meta;

    @Data
    @Builder
    @Jacksonized
    public static class Meta {
        @JsonProperty("total_pages")
        private Integer totalPages;

        @JsonProperty("per_page")
        private Integer perPage;

        private Integer num;
        private Integer page;

        @JsonProperty("rId")
        private Object rId;
    }

}
