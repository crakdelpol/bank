package it.crakdelpol.bank;

import it.crakdelpol.bank.entity.Transaction;
import it.crakdelpol.bank.utils.Args;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

public class Account implements AccountService {

    private List<Transaction> transactions;

    public Account(List transactions){
        this.transactions = transactions;
    }

    public void deposit(int amount) {
        this.deposit(amount, LocalDate.now());
    }

    public void withdraw(int amount) {
        this.withdraw(amount, LocalDate.now());
    }

    public void printStatement() {

        // standard header of table
        String firstLine = "Date || Amount || Balance";

        System.out.println(firstLine);

        // necessary to calculate balance
        AtomicInteger balance = new AtomicInteger(0);

        // create a list of string will be printed
        List<String> transactionListString = transactions.stream().map( transaction ->
                transaction.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " || " + transaction.getAmount() + " || " + balance.addAndGet(transaction.getAmount())
        ).collect(Collectors.toList());

        // reverse order of transaction
        reverse(transactionListString);

        // and print balance
        transactionListString.forEach(System.out::println);

    }

    void deposit(int amount, LocalDate date){
        createTransaction(amount, date);
    }

    void withdraw(int amount, LocalDate date){
        Args.checkForPositive(amount);
        createTransaction(-amount, date);
    }

    private void createTransaction(int amount, LocalDate date){

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(date);
        this.transactions.add(transaction);
    }

}
