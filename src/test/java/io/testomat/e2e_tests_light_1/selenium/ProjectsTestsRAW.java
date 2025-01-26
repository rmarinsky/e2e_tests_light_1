package io.testomat.e2e_tests_light_1.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectsTestsRAW {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed

    @BeforeEach
    void beforeEach() {
        driver.get("https://app.testomat.io/");
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }


    @Test
    @DisplayName("Open and filter project selenium raw test")
    void openAndFilterProjectSeleniumRawTest() {
        // Login
        driver.findElement(By.cssSelector("#content-desktop #user_email")).sendKeys("newromka@gmail.com");
        driver.findElement(By.cssSelector("#content-desktop #user_password")).sendKeys("c27sXAn#8R5hQUd");
        driver.findElement(By.cssSelector("#content-desktop #user_remember_me")).click();
        driver.findElement(By.cssSelector("#content-desktop [name='commit']")).click();

        // Wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".common-flash-success")));

        // Search project
        driver.findElement(By.cssSelector("#search")).sendKeys("manufacture light");

        // Select project
        driver.findElement(By.xpath("//*[text()='Manufacture light']")).click();

        // Wait for project to load
        wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Manufacture light"));
    }

}
