package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.model.NameOfList;
import com.epam.ta.model.OperationParameters;
import com.epam.ta.model.User;
import com.epam.ta.service.NameOfListCreator;
import com.epam.ta.service.OperationParametersCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Listeners;

@Listeners({utils.TestListener.class})
public class CommonConditions {
    public WebDriver driver;
    public User TEST_POSITIVE_USER = UserCreator.getUserPosivite();
    public User TEST_NEGATIVE_USER = UserCreator.getUserNegative();
    OperationParameters BITCOIN_TOKEN = OperationParametersCreator.getBitcoinToken();
    OperationParameters GOLD_TOKEN = OperationParametersCreator.getGoldToken();
    OperationParameters SILVER_SELL_TOKEN = OperationParametersCreator.getSilverSellToken();
    OperationParameters SILVER_BUY_TOKEN = OperationParametersCreator.getSilverBuyToken();
    OperationParameters PRICE_FOR_UPDATE_SILVER = OperationParametersCreator.getPriceForUpdate();
    NameOfList NAME_OF_NEW_LIST = NameOfListCreator.getNameOfNewList();
    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
