package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Statement {
    private final List<StatementLine> lines;
    private ArrayList<Transaction> transactions;

    public Statement(ArrayList<Transaction> transactions) {
        this.lines = createLines(transactions);
        this.transactions = transactions;
    }

    private List<StatementLine> createLines(ArrayList<Transaction> transactions) {
        List <StatementLine> lines = new ArrayList<>();
        int balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            lines.add(new StatementLine(transaction, balance));
        }
        return lines;
    }

    public List<StatementLine> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(transactions, statement.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }
}
