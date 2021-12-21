package com.epam.ta.page.currency;

import com.epam.ta.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyLoginPage extends AbstractPage {
    protected CurrencyLoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[name='email']")
    private WebElement fieldForEmail;
    @FindBy(css = "input[name='password']")
    private WebElement fieldForPassword;
    @FindBy(css = "button[type='submit']")
    private WebElement submitLogInButton;

    public CurrencyLoginPage enterEmail(User user) {
        waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(user.getEmail());
        return this;
    }

    public CurrencyLoginPage enterPassword(User user) {
        waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(user.getPassword());
        return this;
    }

    public CurrencyTradingPlatformPage signIn() {
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new CurrencyTradingPlatformPage(driver);
    }
}
