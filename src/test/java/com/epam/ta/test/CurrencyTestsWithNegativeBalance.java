package com.epam.ta.test;

import com.epam.ta.page.currency.CurrencyHomePage;
import com.epam.ta.page.currency.CurrencyTradeTab;
import com.epam.ta.page.currency.CurrencyTradingPlatformPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTestsWithNegativeBalance extends CommonConditions {
    private CurrencyTradingPlatformPage currencyTradingPlatformPage;
    private CurrencyTradeTab currencyTradeTab;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        currencyTradingPlatformPage = new CurrencyHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(TEST_NEGATIVE_USER)
                .enterPassword(TEST_NEGATIVE_USER)
                .signIn()
                .changeAccountToDemo();
    }
    @Test(description = "Buy tokens with negative balance on Currency.com", priority = 1)
    public void buyTokensWithNegativeBalance() {
        currencyTradeTab = currencyTradingPlatformPage
                .clickBuyToken(BITCOIN_TOKEN)
                .enterQuantityOfTokens(BITCOIN_TOKEN)
                .confirmBuyingOfTokens();
        assertThat(currencyTradeTab.getTextOfPopup()).isEqualTo("Пополнить аккаунт");
    }
    @Test(description = "Sell tokens with negative balance on Currency.com", priority = 2)
    public void sellTokensWithNegativeBalance() {
        currencyTradeTab = currencyTradingPlatformPage
                .clickSellToken(GOLD_TOKEN)
                .enterQuantityOfTokens(GOLD_TOKEN)
                .confirmSellingOfTokens();
        assertThat(currencyTradeTab.getTextOfPopup()).isEqualTo("Пополнить аккаунт");
    }
}
