package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Waits {

    private final By selector;
    private final WebDriverWait wait;

    public Waits(By selector) {
        this.selector = selector;
        this.wait = new WebDriverWait(WebDriverProvider.driver(), Duration.ofSeconds(10));
        this.wait.ignoring(StaleElementReferenceException.class);
        this.wait.pollingEvery(Duration.ofMillis(100));
    }

    public ElementActions visibility() {
        this.wait.until(visibilityOfElementLocated(selector));
        return new ElementActions(selector);
    }

    public void isHidden() {
        this.wait.until(invisibilityOfElementLocated(selector));
    }

    public void hasTest(String expectedText) {
        this.wait.until(ExpectedConditions.textToBe(selector, expectedText));
    }

    public void containsText(String expectedText) {
        this.wait.until(ExpectedConditions.textMatches(
                selector, Pattern.compile(
                        Pattern.quote(expectedText),
                        Pattern.CASE_INSENSITIVE
                )
        ));
    }

    public void customWait() {
        this.wait.until(new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(selector).isDisplayed();
                    driver.findElement(selector).isEnabled();
                    this.currentValue = driver.findElement(selector).getText();

                    return true;
                } catch (Exception var3) {
                    return false;
                }
            }

            public String toString() {
                return "text found by %s to match pattern \"%s\". Current text: \"%s\"";
            }
        });
    }

}