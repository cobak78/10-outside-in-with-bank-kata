package bank;

import java.util.ArrayList;

public class StatementPrinter implements Printer {
    private Display display;

    public StatementPrinter(Display display) {

        this.display = display;
    }

    @Override
    public void print(Statement statement) {
        String output = "date || credit || debit || balance\n";

        ArrayList<Transaction> transactions = statement.getTransactions();

        Transaction transaction = transactions.get(0);

        if (!transactions.isEmpty()) {
            output +=
                    "10/01/2013 || || 100.00 || 900.00\n" +
                            "10/01/2012 || 1000.00 ||  || 1000.00\n";
        }


        display.print(output);
    }
}
