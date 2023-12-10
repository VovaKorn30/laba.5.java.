package com.example;

import com.Exception.AccountNotFoundException;
import com.Exception.InsufficientFundsException;
import com.Exception.NegativeAmountException;

public class Bank3 {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank();

            BankAccount account1 = bank.createAccount("Jake Air", 1000);
            BankAccount account2 = bank.createAccount("Jake Air", 500);

            System.out.println("Initial state:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            account1.withdraw(200);
            account2.deposit(200);

            System.out.println("\nAfter transactions:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);

            System.out.println("\nAfter transfer:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            bank.findAccount(0);
        } catch (NegativeAmountException e) {
            System.out.println("NegativeAmountException occurred: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("InsufficientFundsException occurred: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("AccountNotFoundException occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some other exception occurred: " + e.getMessage());
        }
    }
}
