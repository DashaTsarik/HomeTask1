package com.itacademy.hometask1.start;

import com.itacademy.hometask1.Atm.Atm;
import com.itacademy.hometask1.Atm.AtmException;
import com.itacademy.hometask1.bank.BankName;
import com.itacademy.hometask1.entity.Card;
import com.itacademy.hometask1.entity.CreditCard;
import com.itacademy.hometask1.entity.DebitCard;

public class Main {
    public static void main(String[] args){
        Card debitCard = new DebitCard("Darya Tsarik", 500,BankName.SBERBANK);
        debitCard.deposit(750);
        debitCard.withdraw(350);

        DebitCard debitCard1 = (DebitCard) debitCard;
        debitCard1.buy(281);
        debitCard1.buy(76.5);
        debitCard1.payCashback();
        System.out.println(debitCard1.getBalance());

        Atm atm = new Atm();
        atm.insert(debitCard1);
        try{
            atm.withdraw(600);
        }catch (AtmException e){
            System.out.println(e.getMessage());
        }

        System.out.println(atm.getBalanceOfCard());
        System.out.println(atm.getAnotherCurrencyBalance("доллар", 3.15));
        try {
            atm.withdraw(375);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(atm.getBalanceOfCard());

        atm.getCard();

        Card creditCard = new CreditCard("Darya Tsarik", BankName.BNB_BANK);
        CreditCard creditCard1 = (CreditCard) creditCard;

        atm.insert(creditCard);
        try {
            atm.withdraw(2000);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(atm.getBalanceOfCard());
        atm.deposit(755);
        System.out.println(creditCard1.getSizeOfDebt());




    }
}
