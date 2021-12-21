package com.epam.ta.page.mail;

import com.epam.ta.page.currency.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailLettersPage extends AbstractPage {
    public MailLettersPage(WebDriver driver) {super(driver);}
    @FindBy(xpath = "(//a[contains(@class, 'js-letter-list-item')])[1]")
    public WebElement lettersFromCurrency;

    public MailCurrencyLettersPage linkToLettersFromCurrency() {
        waitForElementToBeClickable(driver, lettersFromCurrency);
        lettersFromCurrency.click();
        return new MailCurrencyLettersPage(driver);
    }
}
