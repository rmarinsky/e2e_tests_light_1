package io.testomat.e2e_tests_light_1.selende.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private SelenideElement searchInput = $("#search");

    public void open() {
        Selenide.open("");
    }

    public ProjectsPage isLoaded() {
        searchInput.shouldBe(visible);
        return this;
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
    }

    public ProjectsPage searchForProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);
        return this;
    }

    public void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click(ClickOptions.usingJavaScript());
    }


    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }

    public void countOfTestsCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(text(expectedCount + " tests"));

        /*String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);*/
    }

    public void totalCountOfProjectsIsVisible() {
        $("#container kbd").shouldBe(visible);
    }


    public String getTotalCountOfTestCases() {
        return $("#container kbd").getText();
    }

}
