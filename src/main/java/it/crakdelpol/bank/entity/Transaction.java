package it.crakdelpol.bank.entity;

import lombok.*;

import java.time.LocalDate;

public @Data class Transaction {
    private int amount;
    private LocalDate date;
}
