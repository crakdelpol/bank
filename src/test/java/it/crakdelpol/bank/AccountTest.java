package it.crakdelpol.bank;

import it.crakdelpol.bank.enitity.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private ArrayList<Transaction> list;

    private Account account;

    @Before
    public void setUpStreams() {

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        this.list = new ArrayList<>();
        this.account = new Account(list);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void deposit() {

        int amount = 200;
        this.account.deposit(amount);

        Assert.assertEquals(1, list.size());
        Assert.assertEquals(amount, list.get(0).getAmount() );

    }


    @Test
    public void withdraw() {
        int amount = 500;
        this.account.withdraw(amount);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(-amount, list.get(0).getAmount());
    }

    @Test
    public void printStatement() {

        this.account.printStatement();
        assertEquals("Date || Amount || Balance\n", outContent.toString());
    }

    @Test
    public void finalTestRequired(){

        this.account.deposit(1000, LocalDate.parse("2012-01-10"));
        this.account.deposit(2000, LocalDate.parse("2012-01-13"));
        this.account.withdraw(500, LocalDate.parse("2012-01-14"));
        this.account.printStatement();
        assertEquals("Date || Amount || Balance\n" +
                "14/01/2012 || -500 || 2500\n" +
                "13/01/2012 || 2000 || 3000\n" +
                "10/01/2012 || 1000 || 1000\n", outContent.toString());

    }
}