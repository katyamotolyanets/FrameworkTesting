package com.epam.ta.test;

import com.epam.ta.page.currency.CurrencyHomePage;
import com.epam.ta.page.currency.CurrencyTradeTab;
import com.epam.ta.page.currency.CurrencyTradingPlatformPage;
import com.epam.ta.page.mail.MailCurrencyLettersPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTestsWithNegativeBalance extends CommonConditions {
    private CurrencyTradingPlatformPage currencyTradingPlatformPage;
    private CurrencyTradeTab currencyTradeTab;
    private MailCurrencyLettersPage mailCurrencyLettersPage;
    String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    String dateFormat = new SimpleDateFormat("HH:mm").format(new Date());

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
/*    @Test(description = "Buy tokens ", priority = 1)
    public void buyTokens() {
        currencyTradeTab = currencyTradingPlatformPage
                .clickBuyToken(BITCOIN_TOKEN)
                .enterQuantityOfTokens(BITCOIN_TOKEN)
                .confirmBuyingOfTokens();
        assertThat(currencyTradeTab.getTextOfPopup()).isEqualTo("Пополнить аккаунт");
    }*/
    @Test(description = "Sell tokens ", priority = 2)
    public void sellTokens() {
        currencyTradeTab = currencyTradingPlatformPage
                .clickSellToken(GOLD_TOKEN)
                .enterQuantityOfTokens(GOLD_TOKEN)
                .confirmSellingOfTokens();
        assertThat(currencyTradeTab.getTextOfPopup()).isEqualTo("Пополнить аккаунт");
    }
    /*@Test(description = "Send report to user email on Currency.com", priority = 3)
    public void sendReportToUserEmail() {
        mailCurrencyLettersPage = currencyTradingPlatformPage
                .linkToReportsPage()
                .switchToActivityTab()
                .sendReportToEmail()
                .openEmail()
                .loginEmail()
                .enterUserData(TEST_NEGATIVE_USER)
                .signInEmail()
                .openNavBarOfInbox()
                .switchToLettersPage()
                .linkToLettersFromCurrency()
                .showLatestLetterFromCurrency();

        assertThat(mailCurrencyLettersPage.getDateOfLastLetterFromCurrency()).isEqualTo("Сегодня, "+ dateFormat +"");
    }*/
}
