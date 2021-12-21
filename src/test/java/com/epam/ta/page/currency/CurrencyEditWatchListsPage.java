package com.epam.ta.page.currency;

import com.epam.ta.model.NameOfList;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyEditWatchListsPage extends AbstractPage {
    protected CurrencyEditWatchListsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "btn-new-watchlist")
    public WebElement addNewListButton;

    @FindBy(css = "input.form-control--valign.ng-pristine")
    public WebElement nameOfNewListField;

    @FindBy(css = "button.button-main:nth-of-type(2)")
    public WebElement createNewListButton;

    @FindBy(xpath = "(//div[contains(@class, 'watchlists-block__content ng-star-inserted')])[1]")
    public WebElement titleOfFirstList;

    public CurrencyEditWatchListsPage addNewWatchList(NameOfList nameOfList) {
        waitForElementToBeClickable(driver, addNewListButton);
        addNewListButton.click();
        waitForVisibilityOfElement(driver, nameOfNewListField);
        nameOfNewListField.sendKeys(Keys.BACK_SPACE + nameOfList.getName());
        waitForElementToBeClickable(driver, createNewListButton);
        createNewListButton.click();
        return this;
    }

    public String checkNameOfFirstList() {
        waitForVisibilityOfElement(driver, titleOfFirstList);
        return titleOfFirstList.getText();
    }

}
