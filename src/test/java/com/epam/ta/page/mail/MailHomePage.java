package com.epam.ta.page.mail;

import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailHomePage extends AbstractPage {
    public MailHomePage(WebDriver driver) {super(driver);}
    @FindBy(className = "ph-login")
    public WebElement loginEmailButton;

    public MailLoginPage loginEmail() {
        waitForElementToBeClickable(driver, loginEmailButton);
        loginEmailButton.click();
        return new MailLoginPage(driver);
    }
}
