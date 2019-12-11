package bank;

public class StatementLine {
    private final int balance;
    private final int amount;
    private final String time;

    public StatementLine(Transaction transaction, int balance) {
        this.amount = transaction.getAmount();
        this.time = transaction.getTime();
        this.balance = balance;
    }

    public String getTime() {
        return this.time;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isDeposit() {
        return amount >= 0;
    }
}
