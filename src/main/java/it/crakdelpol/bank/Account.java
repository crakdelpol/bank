package it.crakdelpol.bank;

import java.time.LocalDate;
import java.util.List;

public class Account implements AccountService {

    private List transactions;

    public Account(List transactions){
        this.transactions = transactions;
    }


    protected void deposit(int amount, LocalDate date){
        throw new UnsupportedOperationException();

    }
    public void deposit(int amount) {
        this.deposit(amount, LocalDate.now());
    }

    protected void withdraw(int amount, LocalDate date){
        throw new UnsupportedOperationException();
    }

    public void withdraw(int amount) {
        this.withdraw(amount, LocalDate.now());
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }
}
