package bank;

public class StatementLine {
    private final Transaction transaction;
    private final int balance;

    public StatementLine(Transaction transaction, int balance) {

        this.transaction = transaction;
        this.balance = balance;
    }
}
