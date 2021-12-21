package com.epam.ta.page.currency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyPortfolioPage extends AbstractPage{
    protected CurrencyPortfolioPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div.tab-button:nth-of-type(2)")
    public WebElement requestsTab;
    @FindBy(xpath = "(//div[contains(@class, 'add')])[2]")
    public WebElement addTakeProfitToTokenRequestButton;

    public CurrencyPortfolioPage openRequestsTab() {
        waitForVisibilityOfElement(driver, requestsTab);
        requestsTab.click();
        return this;
    }

    public CurrencyTradeTab clickButtonToAddTakeProfit() {
        waitForVisibilityOfElement(driver, addTakeProfitToTokenRequestButton);
        addTakeProfitToTokenRequestButton.click();
        return new CurrencyTradeTab(driver);
    }
}
