package com.epam.ta.page.currency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrencyChartingPage extends AbstractPage{
    protected CurrencyChartingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button.button-ghost.button-ghost--small.ng-star-inserted")
    public WebElement addAllInListButton;
    @FindBy(xpath = "//save-instruments-to-watchlists-item//label[contains(text(), 'new')]")
    public WebElement watchListCheckBox;
    @FindBy(css = "button.button-main--medium:nth-of-type(2)")
    public WebElement saveButton;
    @FindBy(css = "div.state-item-button.active.ng-star-inserted")
    public List<WebElement> listItems;
    @FindBy(css = "div.side-nav__item:nth-of-type(1)")
    public WebElement tradingSideNavItem;

    public CurrencyChartingPage clickAddAllInListButton() {
        waitForElementToBeClickable(driver, addAllInListButton);
        addAllInListButton.click();
        return this;
    }

    public CurrencyChartingPage chooseWatchList() {
        waitForVisibilityOfElement(driver, watchListCheckBox);
        Actions act = new Actions(driver);
        act.moveToElement(watchListCheckBox).click().build().perform();
        return this;
    }

    public CurrencyChartingPage saveAdditionToList() {
        waitForElementToBeClickable(driver, saveButton);
        saveButton.click();
        return this;
    }

    public CurrencyTradingPlatformPage linkToTradingPlatformPage() {
        waitForElementToBeClickable(driver, tradingSideNavItem);
        tradingSideNavItem.click();
        return new CurrencyTradingPlatformPage(driver);
    }
}
