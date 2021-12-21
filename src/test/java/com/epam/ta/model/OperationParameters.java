package com.epam.ta.model;

public class OperationParameters {
    private String token;
    private String quantity;
    private String price;
    private String day;
    private String operation;
    public OperationParameters(String price) {
        this.price = price;
    }
    public OperationParameters(String token, String quantity) {
        this.token = token;
        this.quantity = quantity;
    }
    public OperationParameters(String token, String quantity, String price, String operation) {
        this.token = token;
        this.quantity = quantity;
        this.price = price;
        this.operation = operation;
    }
    public OperationParameters(String token, String quantity, String price, String day, String operation) {
        this.token = token;
        this.quantity = quantity;
        this.day = day;
        this.price = price;
        this.operation = operation;
    }

    public String getToken() {
        return token;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getPrice() {
        return price;
    }
    public String getDay() {
        return day;
    }
    public String getOperation() {
        return operation;
    }
}
