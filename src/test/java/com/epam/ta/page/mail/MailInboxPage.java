package com.epam.ta.page.mail;

import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailInboxPage extends AbstractPage {
    public MailInboxPage(WebDriver driver) {super(driver);}
    @FindBy(css = "a[href='/inbox/']")
    public WebElement showInboxNavBar;
    @FindBy(css = "a[href='/newsletters/']")
    public WebElement newLettersNavItem;

    public MailInboxPage openNavBarOfInbox() {
        waitForElementToBeClickable(driver, showInboxNavBar);
        showInboxNavBar.click();
        return this;
    }

    public MailLettersPage switchToLettersPage() {
        waitForElementToBeClickable(driver, newLettersNavItem);
        newLettersNavItem.click();
        return new MailLettersPage(driver);
    }
}
