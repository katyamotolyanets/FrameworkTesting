package com.epam.ta.page.mail;

import com.epam.ta.model.User;
import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailLoginPage extends AbstractPage {
    public MailLoginPage(WebDriver driver) {super(driver);}
    @FindBy(css = "iframe.ag-popup__frame__layout__iframe")
    public WebElement frameForLogin;
    @FindBy(name = "username")
    public WebElement emailUsernameField;
    @FindBy(name = "password")
    public WebElement emailPasswordField;
    @FindBy(xpath = "//button[contains(@data-test-id, 'next-button')]")
    public WebElement nextEnterPasswordButton;
    @FindBy(xpath = "//button[contains(@data-test-id, 'submit-button')]")
    public WebElement submitEnterButton;

    public MailLoginPage enterUserData(User user) {
        driver.switchTo().frame(frameForLogin);
        waitForVisibilityOfElement(driver, emailUsernameField);
        emailUsernameField.sendKeys(user.getEmail());
        waitForElementToBeClickable(driver, nextEnterPasswordButton);
        nextEnterPasswordButton.click();
        waitForVisibilityOfElement(driver, emailPasswordField);
        emailPasswordField.sendKeys(user.getPassword());
        return this;
    }

    public MailInboxPage signInEmail() {
        waitForElementToBeClickable(driver, submitEnterButton);
        submitEnterButton.click();
        driver.switchTo().defaultContent();
        return new MailInboxPage(driver);
    }
}
