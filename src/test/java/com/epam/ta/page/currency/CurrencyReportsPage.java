package com.epam.ta.page.currency;

import com.epam.ta.page.mail.MailHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrencyReportsPage extends AbstractPage {
    public CurrencyReportsPage(WebDriver driver) {
        super(driver);
    }
    private static final String EMAIL_URL = "https://mail.ru/";
    @FindBy(css = "button.button-main")
    public WebElement sendReportButton;
    @FindBy(css = "div.alert-popup__button-toolbar button.button-main")
    public WebElement sendReportButtonInPopup;
    @FindBy(xpath = "//history-tab-button[2]")
    public WebElement activityTabButton;

    public CurrencyReportsPage switchToActivityTab() {
        waitForElementToBeClickable(driver, activityTabButton);
        activityTabButton.click();
        return this;
    }

    public CurrencyReportsPage sendReportToEmail() {
        waitForElementToBeClickable(driver, sendReportButton);
        sendReportButton.click();
        waitForElementToBeClickable(driver, sendReportButton);
        sendReportButtonInPopup.click();
        return this;
    }

    public MailHomePage openEmail() {
        driver.get(EMAIL_URL);
        return new MailHomePage(driver);
    }

}
