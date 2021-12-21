package com.epam.ta.test;

import com.epam.ta.page.currency.CurrencyEditWatchListsPage;
import com.epam.ta.page.currency.CurrencyHomePage;
import com.epam.ta.page.currency.CurrencyTradeTab;
import com.epam.ta.page.currency.CurrencyTradingPlatformPage;
import com.epam.ta.page.mail.MailCurrencyLettersPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CurrencyTestsWithPositiveBalance extends CommonConditions {
    private CurrencyTradingPlatformPage currencyTradingPlatformPage;
    private CurrencyTradeTab currencyTradeTab;
    private CurrencyEditWatchListsPage currencyEditWatchListsPage;
    private MailCurrencyLettersPage mailCurrencyLettersPage;

    private List<String> ITEMS = Arrays.asList("Bitcoin / USD", "Crude Oil", "Gold", "Silver");

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        currencyTradingPlatformPage = new CurrencyHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(TEST_POSITIVE_USER)
                .enterPassword(TEST_POSITIVE_USER)
                .signIn()
                .changeAccountToDemo();
    }
    @Test(description = "Send report to user email on Currency.com", priority = 1)
    public void sendReportToUserEmail() {
        mailCurrencyLettersPage = currencyTradingPlatformPage
                .linkToReportsPage()
                .switchToActivityTab()
                .sendReportToEmail()
                .openEmail()
                .loginEmail()
                .enterUserData(TEST_POSITIVE_USER)
                .signInEmail()
                .openNewLetters()
                .showLatestLetterFromCurrency();

        String dateFormat = new SimpleDateFormat("H:mm").format(new Date());

        assertThat(mailCurrencyLettersPage.getDateOfLastLetterFromCurrency()).isEqualTo("Сегодня, "+ dateFormat +"");
    }
    @Test(description = "Sell 10 tokens of Silver on Currency.com", priority = 2)
    public void sellTokensOnCurrency() {
        String textOfNotificationAboutGoodRequest = currencyTradingPlatformPage
                .clickSellToken(SILVER_SELL_TOKEN)
                .enterQuantityOfTokens(SILVER_SELL_TOKEN)
                .clickRadioButtonWhenPriceWillBe()
                .enterPriceWillBe(SILVER_SELL_TOKEN)
                .setLimitRequest(SILVER_SELL_TOKEN)
                .getTextOfNotificationAboutGoodRequest();

        assertThat(textOfNotificationAboutGoodRequest).isEqualTo("Заявка размещена");
    }
    @Test(description = "Add refuse date while buying token of Silver on Currency.com", priority = 3)
    public void addRefuseDateOnCurrency() {
        String textOfNotificationAboutGoodRequest = currencyTradingPlatformPage
                .clickBuyToken(SILVER_BUY_TOKEN)
                .enterQuantityOfTokens(SILVER_BUY_TOKEN)
                .clickRadioButtonWhenPriceWillBe()
                .enterPriceWillBe(SILVER_BUY_TOKEN)
                .setDateRefuseForBuyingTokens(SILVER_BUY_TOKEN)
                .offModalOverlayCalendar()
                .setLimitRequest(SILVER_BUY_TOKEN)
                .getTextOfNotificationAboutGoodRequest();

        assertThat(textOfNotificationAboutGoodRequest).isEqualTo("Заявка размещена");
    }
    @Test(description = "Add new list in WatchLists on Currency.com", priority = 4)
    public void addNewListInWatchLists() {
        currencyEditWatchListsPage = currencyTradingPlatformPage
                .linkToEditWatchListsPage()
                .addNewWatchList(NAME_OF_NEW_LIST);

        assertThat(currencyEditWatchListsPage.checkNameOfFirstList()).isEqualTo(NAME_OF_NEW_LIST.getName());
    }
    @Test(description = "Add all tokens from list to charting on Currency.com", priority = 5)
    public void addTokensToCharting() {
        List<String> list = currencyTradingPlatformPage
                .linkToChartingPage()
                .clickAddAllInListButton()
                .chooseWatchList()
                .saveAdditionToList()
                .linkToTradingPlatformPage()
                .chooseCategoryItem()
                .getWatchListItems();

        assertThat(list).isEqualTo(ITEMS);
    }
    @Test(description = "Edit request by addition of take-profit on Currency.con", priority = 6)
    public void editRequestInPortfolio() {
        String text = currencyTradingPlatformPage
                .linkToPortfolioPage()
                .openRequestsTab()
                .clickButtonToAddTakeProfit()
                .selectTypeOfTakeProfit()
                .setPriceLevelOfTakeProfit(PRICE_FOR_UPDATE_SILVER)
                .completeAdditionOfTakeProfit()
                .getTextOfNotificationAboutGoodRequest();

        assertThat(text).isEqualTo("Заявка изменена.");
    }
    @Test(description = "Buy 10 tokens of Bitcoin / USD on Currency.com", priority = 7)
    public void buyTokensOnCurrency() {
        currencyTradeTab = currencyTradingPlatformPage
                .switchToActivelyGrowingMarketsTab()
                .clickBuyToken(BITCOIN_TOKEN)
                .enterQuantityOfTokens(BITCOIN_TOKEN)
                .confirmBuyingOfTokens();

        assertThat(currencyTradeTab.haveTokensBeenBought()).isTrue();
    }
}
