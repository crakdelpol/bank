package it.crakdelpol.bank;

/**
 * Interface for handle bank account
 */
public interface AccountService
{
    /**
     * add amount to balance of this account
     * @param amount
     */
    void deposit(int amount);

    /**
     * decreases balance of this account
     * @param amount
     */
    void withdraw(int amount);

    /**
     * print in console list of deposits and withdraws with balance in cronological order
     */
    void printStatement();
}
