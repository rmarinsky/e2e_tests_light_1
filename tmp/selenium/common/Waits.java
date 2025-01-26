package io.testomat.e2e_tests_light_1.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class Waits {

    private final By selector;

    private final WebDriverWait wait;

    public Waits(By element) {
        this.selector = element;
        this.wait = new WebDriverWait(WebDriverManager.driver(), Duration.ofSeconds(10));
        this.wait.ignoring(NoSuchElementException.class);
    }

    public ElementActions toBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return new ElementActions(selector);
    }

    public ElementActions toBeNotVisible() {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(selector)));
        return new ElementActions(selector);
    }

    public ElementActions enable() {
        this.wait.until(ExpectedConditions.elementToBeClickable(selector));
        return new ElementActions(selector);
    }

    public ElementActions toBeClickable() {
        this.wait.until(ExpectedConditions.elementToBeClickable(selector));
        return new ElementActions(selector);

    }

    public ElementActions hasText(String text) {
        this.wait.until(ExpectedConditions.textToBePresentInElementLocated(selector, text));
        return new ElementActions(selector);

    }

    public ElementActions containsText(String expectedText) {
        this.wait.until(ExpectedConditions.textMatches(
                this.selector, Pattern.compile(
                        Pattern.quote(expectedText),
                        Pattern.CASE_INSENSITIVE
                )
        ));
        return new ElementActions(selector);
    }

}
