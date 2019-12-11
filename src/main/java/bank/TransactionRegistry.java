package bank;

import java.util.ArrayList;

public interface TransactionRegistry {
    void save(int money);
    ArrayList<Transaction> getTransactions();
}
