package io.testomat.e2e_tests_light_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadmeIframeTest extends BaseTest {

    @Test
    @DisplayName("Update readme text in iframe")
    void updateReadmeTextInIframe() {
        app.projectsPage.isLoaded()
                .searchForProject(targetProjectName)
                .selectProject(targetProjectName);

        app.projectPage.openReadme().clickOnEdit();

        app.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("OLOLO")
                .clickOnUpdate();

    }

    @Test
    @DisplayName("Readme test")
    void readmeTest() {
        /*new SignInPage().open().loginUser(username, password);
        projectsPage.searchForProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);

        $(Selectors.byLinkText("Readme")).click();
        $(Selectors.byLinkText("Edit")).click();
        $("#app-loader").shouldBe(Condition.hidden, Duration.ofSeconds(20));
        $(byText("Edit Readme")).shouldBe(Condition.visible).click();
        switchTo().frame($("#modal-overlays [src='/ember-monaco/frame.html']"));

        $(".view-lines div span").click();
        $("textarea").pressEnter();
        $("textarea").sendKeys("OLOLO");
        switchTo().defaultContent();
        $(".primary-btn").click();*/

    }

}
