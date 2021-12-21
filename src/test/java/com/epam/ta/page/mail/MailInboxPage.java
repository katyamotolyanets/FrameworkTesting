package com.epam.ta.page.mail;

import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailInboxPage extends AbstractPage {
    public MailInboxPage(WebDriver driver) {super(driver);}
    @FindBy(className = "metathread_collapsed")
    public WebElement newLettersItem;
    @FindBy(css = "a.llc_has-indent:nth-of-type(1)")
    public WebElement latestLetterFromCurrency;


    public MailInboxPage openNewLetters() {
        waitForElementToBeClickable(driver, newLettersItem);
        newLettersItem.click();
        return this;
    }

    public MailCurrencyLettersPage switchToLatestLettersPage() {
        waitForElementToBeClickable(driver, latestLetterFromCurrency);
        latestLetterFromCurrency.click();
        return new MailCurrencyLettersPage(driver);
    }
}
