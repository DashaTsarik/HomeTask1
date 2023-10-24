package com.itacademy.hometask1.entity;

import com.itacademy.hometask1.bank.BankName;
import com.itacademy.hometask1.bank.Cashback;

import java.util.Objects;

public class DebitCard extends Card implements Cashback {

    private BankName bankName;

    private double sumOfBuyings;

    public DebitCard(String name, double balance,BankName bankName){
        super(name,balance);
        this.bankName = bankName;
        sumOfBuyings = 0;
    }

    public DebitCard(String name,BankName bankName){
        super(name);
        this.bankName = bankName;
        sumOfBuyings = 0;

    }

    public BankName getBankName() {
        return bankName;
    }

    public double getSumOfBuyings() {
        return sumOfBuyings;
    }

    public double payCashback() {
        double cashback = (bankName.getCashbackInPercents() / 100) * sumOfBuyings;
        sumOfBuyings = 0;
        setBalance(getBalance() + cashback);
        return cashback;
    }

    public boolean buy(double amount){
        if(withdraw(amount) == false){
            return false;
        }
        sumOfBuyings+=amount;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebitCard debitCard = (DebitCard) o;
        return Double.compare(debitCard.sumOfBuyings, sumOfBuyings) == 0 && bankName == debitCard.bankName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankName, sumOfBuyings);
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "bankName=" + bankName +
                ", sumOfBuyings=" + sumOfBuyings +
                '}';
    }
}
