package com.epam.ta.page.currency;

import com.epam.ta.model.OperationParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrencyTradingPlatformPage extends AbstractPage {
    public CurrencyTradingPlatformPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div[class='btn-menu']")
    private WebElement accountMenu;
    @FindBy(xpath = "//div[@class='account-popup__box ng-star-inserted'][3]")
    private WebElement demoAccountMenuItem;
    @FindBy(xpath = "(//div[contains(@class, 'category-item ng-star-inserted')])[3]")
    private WebElement activelyGrowingMarketsTab;
    @FindBy(css = "div.trade-categories-header__edit")
    private WebElement editWatchListsButton;
    @FindBy(css = "div.side-nav__item:nth-of-type(4)")
    public WebElement reportsSideNavItem;
    @FindBy(css = "div.side-nav__item:nth-of-type(3)")
    public WebElement portfolioSideNavItem;
    @FindBy(css = "div.side-nav__item:nth-of-type(2)")
    public WebElement chartingSideNavItem;
    @FindBy(xpath = "//div[contains(text(), 'new')]")
    public WebElement categoryItem;

    public CurrencyTradingPlatformPage changeAccountToDemo() {
        waitForElementToBeClickable(driver, accountMenu);
        accountMenu.click();
        waitForElementToBeClickable(driver, demoAccountMenuItem);
        demoAccountMenuItem.click();
        logger.info("Change account to demo");
        return this;
    }

    public CurrencyTradingPlatformPage switchToActivelyGrowingMarketsTab() {
        waitForElementToBeClickable(driver, activelyGrowingMarketsTab);
        activelyGrowingMarketsTab.click();
        logger.info("Switch to actively growing markets tab");
        return this;
    }

    public CurrencyTradeTab clickBuyToken(OperationParameters token) {
        WebElement buttonBuyTokenInWishlist = driver.findElement(By
                .xpath("//div[contains(text(), '" + token.getToken() + "')]/../following-sibling::div[@class='col buy']/button"));
        waitForElementToBeClickable(driver, buttonBuyTokenInWishlist);
        buttonBuyTokenInWishlist.click();
        logger.info("Click button Buy");
        return new CurrencyTradeTab(driver);
    }

    public CurrencyTradeTab clickSellToken(OperationParameters token) {
        WebElement buttonSellTokenInWishlist = driver.findElement(By
                .xpath("//div[contains(text(), '" + token.getToken() + "')]/../following-sibling::div[@class='col sell']/button"));
        waitForElementToBeClickable(driver, buttonSellTokenInWishlist);
        buttonSellTokenInWishlist.click();
        logger.info("Click button Sell");
        return new CurrencyTradeTab(driver);
    }

    public CurrencyChartingPage linkToChartingPage() {
        waitForElementToBeClickable(driver, chartingSideNavItem);
        chartingSideNavItem.click();
        logger.info("Link to charting page");
        return new CurrencyChartingPage(driver);
    }

    public CurrencyPortfolioPage linkToPortfolioPage() {
        waitForElementToBeClickable(driver, portfolioSideNavItem);
        portfolioSideNavItem.click();
        logger.info("Link to portfolio page");
        return new CurrencyPortfolioPage(driver);
    }

    public CurrencyReportsPage linkToReportsPage() {
        waitForElementToBeClickable(driver, reportsSideNavItem);
        reportsSideNavItem.click();
        logger.info("Link to reports page");
        return new CurrencyReportsPage(driver);
    }

    public CurrencyEditWatchListsPage linkToEditWatchListsPage() {
        waitForElementToBeClickable(driver, editWatchListsButton);
        editWatchListsButton.click();
        logger.info("Link to edit watch lists page");
        return new CurrencyEditWatchListsPage(driver);
    }

    public CurrencyTradingPlatformPage chooseCategoryItem() {
        waitForElementToBeClickable(driver, categoryItem);
        categoryItem.click();
        return this;
    }

    public List<String> getWatchListItems() {
        List<WebElement> watchListItems = driver.findElements(By.className("direction-ltr"));
        List<String> items = new ArrayList<>();
        for (int i = 0; i < watchListItems.size(); i++) {
            items.add(watchListItems.get(i).getText());
        }
        Collections.sort(items);
        return items;
    }
}
