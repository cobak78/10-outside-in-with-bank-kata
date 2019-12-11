package bank;

import java.util.List;

public class StatementPrinter implements Printer {
    private Display display;
    private StatementFormatter formatter;

    public StatementPrinter(Display display, StatementFormatter formatter) {
        this.display = display;
        this.formatter = formatter;
    }

    @Override
    public void print(Statement statement) {
        String output = formatter.formatHeader();

        List<StatementLine> statementLines = statement.getLines();

        for (int i = statementLines.size() - 1; i >= 0; i--) {
            output += formatter.formatLine(statementLines.get(i));
        }

        display.print(output);
    }
}
