package com.epam.ta.page.mail;

import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailInboxPage extends AbstractPage {
    public MailInboxPage(WebDriver driver) {super(driver);}
    @FindBy(css = "a.js-letter-list-item.llc_normal:nth-of-type(1)")
    public WebElement newLettersItem;
    /*@FindBy(css = "a.llc_has-indent:nth-of-type(1)")
    public WebElement latestLetterFromCurrency;*/


    public MailCurrencyLettersPage openNewLetters() {
        waitForElementToBeClickable(driver, newLettersItem);
        newLettersItem.click();
        return new MailCurrencyLettersPage(driver);
    }

    /*public MailCurrencyLettersPage switchToLatestLettersPage() {
        waitForElementToBeClickable(driver, latestLetterFromCurrency);
        latestLetterFromCurrency.click();
        return new MailCurrencyLettersPage(driver);
    }*/
}
