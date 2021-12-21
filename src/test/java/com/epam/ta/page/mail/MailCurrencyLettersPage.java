package com.epam.ta.page.mail;

import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailCurrencyLettersPage extends AbstractPage {
    protected MailCurrencyLettersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "letter__date")
    public WebElement dateOfLastLetter;
    @FindBy(className = "thread__letter_first")
    public WebElement latestLetterFromCurrency;

    public MailCurrencyLettersPage showLatestLetterFromCurrency() {
        waitForElementToBeClickable(driver, latestLetterFromCurrency);
        latestLetterFromCurrency.click();
        return this;
    }

    public String getDateOfLastLetterFromCurrency() {
        waitForVisibilityOfElement(driver, dateOfLastLetter);
        return dateOfLastLetter.getText();
    }
}
