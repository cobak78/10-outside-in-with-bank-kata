package bank;

public interface StatementFormatter {
    String formatLine(StatementLine statementLine);

    String formatHeader();
}
