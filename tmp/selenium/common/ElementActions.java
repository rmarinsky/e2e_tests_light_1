package io.testomat.e2e_tests_light_1.selenium.common;

import org.openqa.selenium.By;

public class ElementActions {

    private final By targetSelector;

    public ElementActions(By selector) {
        this.targetSelector = selector;
    }

    public void click() {
        WebDriverManager.driver().findElement(targetSelector).click();
    }

    public void sendKeys(final String text) {
        WebDriverManager.driver().findElement(targetSelector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.targetSelector);
    }

}
