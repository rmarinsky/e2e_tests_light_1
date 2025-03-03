package io.testomat.e2e_tests_light_1.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

@Data
@Jacksonized
@Builder
public class SuiteResponse {

    @JsonProperty("data")
    private SuiteData data;

    @Data
    @Jacksonized
    @Builder
    public static class SuiteData {

        private String id;
        private String type;
        private Attributes attributes;
        private Relationships relationships;

    }

    @Data
    @Jacksonized
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attributes {

        @Builder.Default
        private List<String> labels = new ArrayList<>();
        private List<String> tags;
        @JsonProperty("is-branched")
        private Boolean isBranched;
        @JsonProperty("is-detail")
        private Boolean isDetail;
        private String title;
        private String path;
        private Boolean sync;
        @JsonProperty("file-type")
        private String fileType;
        @JsonProperty("parent-id")
        private String parentId;
        @JsonProperty("test-count")
        private Integer testCount;
        @JsonProperty("created-at")
        private String createdAt;
        @JsonProperty("updated-at")
        private String updatedAt;
        @JsonProperty("to-url")
        private String toUrl;
        @JsonProperty("jira-issues")
        private String jiraIssues;
        @JsonProperty("filtered-tests")
        private String filteredTests;
        @JsonProperty("assigned-to")
        private String assignedTo;
        private String issues;
        private String notes;
        private String file;
        private String emoji;
        private String code;
        private Integer position;
        @JsonProperty("is-root")
        private Boolean isRoot;
        @JsonProperty("public-title")
        private String publicTitle;

    }

    @Data
    @Jacksonized
    @Builder
    public static class Relationships {

        private Branch branch;

    }

    @Data
    @Jacksonized
    @Builder
    public static class Branch {

        private Object data;

    }

}
