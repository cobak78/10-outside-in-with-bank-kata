package bank;

import java.util.ArrayList;
import java.util.Calendar;

public class InMemoryTransactionRegistry implements TransactionRegistry {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private CCalendar calendar;

    public InMemoryTransactionRegistry(CCalendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void save(int amount) {
        String date = calendar.getDate();
        Transaction t = new Transaction(date, amount);

        transactions.add(t);

    }
}
