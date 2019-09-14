package it.crakdelpol.bank.enitity;

import lombok.*;

import java.time.LocalDate;

public @Data class Transaction {
    private int amount;
    private LocalDate date;
    private int balance;
}
