package com.epam.ta.page.currency;

import com.epam.ta.model.OperationParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyTradeTab extends AbstractPage {
    public CurrencyTradeTab(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//ml-text[1]/following-sibling::*[1]/div/input")
    private WebElement quantityOfTokensField;
    @FindBy(xpath = "//button[contains(@class, 'button-main--positive')]")
    private WebElement buyTokenInTradeTabButton;
    @FindBy(xpath = "(//button[contains(@class, 'button-main--negative')])[2]")
    private WebElement sellTokenInTradeTabButton;
    @FindBy(id = "popover-notification-0")
    private WebElement notificationAboutSuccessfulBuying;
    @FindBy(xpath = "//radio-button2[1]")
    private WebElement radioButtonWhenPriceWillBe;
    @FindBy(xpath = "(//input[contains(@class, 'form-control form-control--font-medium')])[2]")
    private WebElement priceWillBeField;
    @FindBy(xpath = "//button[contains(@class, 'button-main button-main--negative ng-star-inserted')]")
    private WebElement setLimitRequestSellingTokensButton;
    @FindBy(xpath = "//button[contains(@class, 'button-main button-main--positive ng-star-inserted')]")
    private WebElement setLimitRequestBuyingTokensButton;
    @FindBy(className = "popover-notification__title")
    private WebElement notificationAboutGoodRequest;
    @FindBy(css = "ml-text.initial")
    private WebElement dateRefuseText;
    @FindBy(xpath = "//div[contains(@class, 'modal-overlay ng-tns-c328-0')]")
    private WebElement modalOverlayOfCalendar;
    @FindBy(xpath = "(//risk-type-selector[contains(@class, 'field')])[2]")
    private WebElement dropdownTakeProfit;
    @FindBy(xpath = "(//div[contains(@class, 'dropdown-o-list__text')])[3]")
    private WebElement priceLevelItemOfDropdownTakeProfit;
    @FindBy(xpath = "(//input[contains(@class, 'form-control--font-medium')])[2]")
    private WebElement priceLevelField;
    @FindBy(css = "button.button-main")
    private WebElement updateRequestButton;
    @FindBy(css = "div.alert-popup__title")
    private WebElement depositAccountPopupText;

    public CurrencyTradeTab enterQuantityOfTokens(OperationParameters token) {
        waitForVisibilityOfElement(driver, quantityOfTokensField);
        quantityOfTokensField.clear();
        quantityOfTokensField.sendKeys(Keys.BACK_SPACE + token.getQuantity());
        return this;
    }

    public CurrencyTradeTab confirmBuyingOfTokens() {
        waitForElementToBeClickable(driver, buyTokenInTradeTabButton);
        buyTokenInTradeTabButton.click();
        //waitForVisibilityOfElement(driver, notificationAboutSuccessfulBuying);
        return this;
    }

    public CurrencyTradeTab confirmSellingOfTokens() {
        waitForElementToBeClickable(driver, sellTokenInTradeTabButton);
        sellTokenInTradeTabButton.click();
        //waitForVisibilityOfElement(driver, notificationAboutSuccessfulBuying);
        return this;
    }

    public CurrencyTradeTab clickRadioButtonWhenPriceWillBe() {
        waitForElementToBeClickable(driver, radioButtonWhenPriceWillBe);
        radioButtonWhenPriceWillBe.click();
        return this;
    }

    public CurrencyTradeTab enterPriceWillBe(OperationParameters token) {
        waitForVisibilityOfElement(driver, priceWillBeField);
        priceWillBeField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), token.getPrice());
        return this;
    }

    public CurrencyTradeTab setLimitRequest(OperationParameters token) {
        switch (token.getOperation()) {
            case "buy":
                waitForElementToBeClickable(driver, setLimitRequestBuyingTokensButton);
                setLimitRequestBuyingTokensButton.click();
                break;
            case "sell":
                waitForElementToBeClickable(driver, setLimitRequestSellingTokensButton);
                setLimitRequestSellingTokensButton.click();
                break;
        }
        return this;
    }

    public CurrencyTradeTab setDateRefuseForBuyingTokens(OperationParameters token) {
        waitForVisibilityOfElement(driver, dateRefuseText);
        dateRefuseText.click();
        WebElement dayOfDateRefuseText = driver.findElement(By.xpath
                ("//state-item-button[contains(@class, 'day currentMonth active ng-star-inserted')]/span[text()='"+token.getDay()+"']"));
        waitForVisibilityOfElement(driver, dayOfDateRefuseText);
        dayOfDateRefuseText.click();
        return this;
    }

    public CurrencyTradeTab offModalOverlayCalendar() {
        waitForVisibilityOfElement(driver, modalOverlayOfCalendar);
        modalOverlayOfCalendar.click();
        return this;
    }

    public String getTextOfNotificationAboutGoodRequest() {
        waitForVisibilityOfElement(driver, notificationAboutGoodRequest);
        return notificationAboutGoodRequest.getText();
    }

    public CurrencyTradeTab selectTypeOfTakeProfit() {
        waitForVisibilityOfElement(driver, dropdownTakeProfit);
        dropdownTakeProfit.click();
        waitForVisibilityOfElement(driver, priceLevelItemOfDropdownTakeProfit);
        priceLevelItemOfDropdownTakeProfit.click();
        return this;
    }

    public CurrencyTradeTab setPriceLevelOfTakeProfit(OperationParameters token) {
        waitForVisibilityOfElement(driver, priceLevelField);
        priceWillBeField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), token.getPrice());
        return this;
    }

    public CurrencyTradeTab completeAdditionOfTakeProfit() {
        waitForElementToBeClickable(driver, updateRequestButton);
        updateRequestButton.click();
        return this;
    }

    public String getTextOfPopup() {
        waitForVisibilityOfElement(driver, depositAccountPopupText);
        return depositAccountPopupText.getText();
    }

    public boolean haveTokensBeenBought() {
        waitForVisibilityOfElement(driver,notificationAboutSuccessfulBuying);
        return notificationAboutSuccessfulBuying.isDisplayed();
    }
}
