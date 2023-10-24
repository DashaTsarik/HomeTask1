package com.itacademy.hometask1.entity;

import java.util.Objects;

public abstract class Card {

    private String name;
    private double balance;

    public Card(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Card(String name) {
        this.name = name;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if (amount > balance){
            return false;
        }
        balance -= amount;
        return true;
    }

    public String getAnotherCurrencyBalance(String currency, double conversion){
        String balanceOutput;
        double balanceInCurrency = balance / conversion;

        balanceOutput = "Валюта: " + currency + "." + " Ваш баланс в этой валюте составляет: " + balanceInCurrency;
        return balanceOutput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Double.compare(card.balance, balance) == 0 && name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
