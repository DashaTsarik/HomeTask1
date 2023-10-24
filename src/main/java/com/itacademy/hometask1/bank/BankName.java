package com.itacademy.hometask1.bank;

public enum BankName {

    SBERBANK(1000,1.5),
    BELSWISSBANK (1500,2),
    BNB_BANK(2000,3.5);

    private double overdraftLimit;
    private double cashbackInPercents;

    private BankName(double overdraftLimit,double cashbackInPercents){
        this.cashbackInPercents = cashbackInPercents;
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getCashbackInPercents() {
        return cashbackInPercents;
    }
}
