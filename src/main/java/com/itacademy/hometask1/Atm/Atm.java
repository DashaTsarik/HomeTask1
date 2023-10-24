package com.itacademy.hometask1.Atm;

import com.itacademy.hometask1.entity.Card;

public class Atm {

    Card card;

    public Atm(){}

    public void insert(Card card){
        this.card = card;
    }

    public boolean withdraw(double amount) throws AtmException{
        if(card.withdraw(amount) == false){
            throw new AtmException("Недостаточно денег на карте");
        }
        return true;
    }

    public double getBalanceOfCard(){
        return card.getBalance();
    }

    public void deposit(double amount){
        card.deposit(amount);
    }

    public void getCard(){
        card = null;
    }

    public String getAnotherCurrencyBalance(String currency, double conversion){
        return card.getAnotherCurrencyBalance(currency,conversion);
    }
}
