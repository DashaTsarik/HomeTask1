package com.itacademy.hometask1.entity;

import com.itacademy.hometask1.bank.BankName;

import java.util.Objects;

public class CreditCard extends Card{

    private BankName bankName;
    private double sizeOfDebt;

    public CreditCard(String name, BankName bankName){
        super(name);
        this.bankName = bankName;
        this.sizeOfDebt = 0;
    }

    public BankName getBankName() {
        return bankName;
    }

    public double getSizeOfDebt() {
        return sizeOfDebt;
    }
    public boolean withdraw(double amount){
        double balanceAfterWithdraw = getBalance() - amount;
        if (balanceAfterWithdraw < 0 - bankName.getOverdraftLimit()){
            return false;
        }
        setBalance(balanceAfterWithdraw);
        if(getBalance() < 0){
            sizeOfDebt = Math.abs(getBalance());
        }
        return true;
    }

    public void deposit(double amount){
        setBalance(getBalance() + amount);
        if (getBalance() < 0){
            sizeOfDebt = Math.abs(getBalance());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCard that = (CreditCard) o;
        return Double.compare(that.sizeOfDebt, sizeOfDebt) == 0 && bankName == that.bankName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankName, sizeOfDebt);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "bankName=" + bankName +
                ", sizeOfDebt=" + sizeOfDebt +
                '}';
    }
}
