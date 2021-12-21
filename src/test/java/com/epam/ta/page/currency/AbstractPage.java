package com.epam.ta.page.currency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected final Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
