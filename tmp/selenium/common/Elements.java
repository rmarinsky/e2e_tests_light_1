package io.testomat.e2e_tests_light_1.selenium.common;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class Elements {

    public static ElementActions findBy(By targetSelector) {
        return new ElementActions(targetSelector);
    }

    public static ElementActions find(String targetSelector) {
        By locator = targetSelector.startsWith("/")
                ? xpath(targetSelector)
                : cssSelector(targetSelector);

        return new ElementActions(locator);
    }

}
