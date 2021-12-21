package com.epam.ta.service;

import java.util.ResourceBundle;

public class TestDataReader {
    public static ResourceBundle resourceBundlePositiveUser =
            ResourceBundle.getBundle(System.getProperty("environment"));
    public static String getUserData(String key) {
        return resourceBundlePositiveUser.getString(key);
    }
}
