package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;

public class ElementActions {

    private final By selector;
    private WebElement element;

    public ElementActions(By selector) {
        this.selector = selector;
    }

    public ElementActions targetElement(WebElement element) {
        this.element = element;
        return this;
    }

    public void click() {
        waitFor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitFor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public ElementActions find(By locator) {
        driver().findElement(selector).findElement(locator);
        return this;
    }

    public Waits waitFor() {
        return new Waits(this.selector);
    }

}
