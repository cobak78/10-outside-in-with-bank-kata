package bank;

import java.util.ArrayList;
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

        for (StatementLine statementLine : statementLines) {
            output += formatter.formatLine(statementLine);
        }

        display.print(output);
    }
}
