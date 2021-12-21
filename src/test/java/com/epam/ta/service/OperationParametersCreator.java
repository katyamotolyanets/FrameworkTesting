package com.epam.ta.service;

import com.epam.ta.model.OperationParameters;

public class OperationParametersCreator {
    private static final String TEST_DATA_BITCOIN_TOKEN = "test_data.bitcoin_token";
    private static final String TEST_DATA_GOLD_TOKEN = "test_data.gold_token";
    private static final String TEST_DATA_SILVER_TOKEN = "test_data.silver_token";
    private static final String TEST_DATA_QUANTITY_OF_TOKENS = "test_data.quantity_of_tokens";
    private static final String TEST_DATA_PRICE_FOR_SILVER = "test_data.price_for_silver";
    private static final String TEST_DATA_PRICE_FOR_GOLD = "test_data.price_for_gold";
    private static final String TEST_DATA_SELL_OPERATION = "test_data.sell_operation";
    private static final String TEST_DATA_BUY_OPERATION = "test_data.buy_operation";
    private static final String TEST_DATA_DAY_OD_REFUSE_DATE = "test_data.day_of_refuse_date";
    private static final String TEST_DATA_PRICE_FOR_UPDATE_SILVER = "test_data.price_for_update_silver";
    private OperationParametersCreator() {}
    public static OperationParameters getBitcoinToken() {
        return new OperationParameters(TestDataReader.getUserData(TEST_DATA_BITCOIN_TOKEN),
                TestDataReader.getUserData(TEST_DATA_QUANTITY_OF_TOKENS));
    }
    public static OperationParameters getGoldToken() {
        return new OperationParameters(TestDataReader.getUserData(TEST_DATA_BITCOIN_TOKEN),
                TestDataReader.getUserData(TEST_DATA_QUANTITY_OF_TOKENS));
    }
    public static OperationParameters getSilverSellToken() {
        return new OperationParameters(TestDataReader.getUserData(TEST_DATA_SILVER_TOKEN),
                TestDataReader.getUserData(TEST_DATA_QUANTITY_OF_TOKENS),
                TestDataReader.getUserData(TEST_DATA_PRICE_FOR_SILVER),
                TestDataReader.getUserData(TEST_DATA_SELL_OPERATION));
    }
    public static OperationParameters getSilverBuyToken() {
        return new OperationParameters(TestDataReader.getUserData(TEST_DATA_SILVER_TOKEN),
                TestDataReader.getUserData(TEST_DATA_QUANTITY_OF_TOKENS),
                TestDataReader.getUserData(TEST_DATA_PRICE_FOR_SILVER),
                TestDataReader.getUserData(TEST_DATA_DAY_OD_REFUSE_DATE),
                TestDataReader.getUserData(TEST_DATA_BUY_OPERATION));
    }
    public static OperationParameters getPriceForUpdate() {
        return new OperationParameters(TestDataReader.getUserData(TEST_DATA_PRICE_FOR_UPDATE_SILVER));
    }

}
