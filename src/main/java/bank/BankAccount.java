package bank;

import java.util.ArrayList;

public class BankAccount {

    private  TransactionRegistry transactionRegistry;
    private  Printer printer;

    public BankAccount(Printer printer, TransactionRegistry transactions) {
        this.printer = printer;
        transactionRegistry = transactions;
    }

    public void deposit(int i) {
        transactionRegistry.save(i);
    }

    public void withdrawal(int i) {
        transactionRegistry.save(-i);
    }

    public void print() {
        ArrayList<Transaction> transactions = transactionRegistry.getTransactions();
        printer.print(new Statement(transactions));
    }
}
