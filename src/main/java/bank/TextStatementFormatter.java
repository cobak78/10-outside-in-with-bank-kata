package bank;

public class TextStatementFormatter implements StatementFormatter {
    @Override
    public String formatLine(StatementLine statementLine) {
        String date = statementLine.getTime().replace('-', '/');
        String balance = formatToDecimals(statementLine.getBalance());
        String amount = formatToDecimals(Math.abs(statementLine.getAmount()));

        if(statementLine.isDeposit())
        {
            return String.format("%s || %s || || %s\n", date, amount, balance);
        } else {
            return String.format("%s || || %s || %s\n", date, amount, balance);
        }
    }

    private String formatToDecimals(int number) {
        return String.format("%d.00", number);
    }

    @Override
    public String formatHeader() {
        return "date || credit || debit || balance\n";
    }
}
