package org.example.concreteClass;

public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv){
        this.amount= 100_00;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCvv() {
        return cvv;
    }
}
