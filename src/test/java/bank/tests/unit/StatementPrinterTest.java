package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class StatementPrinterTest {

    private Display display;
    private Printer statementPrinter;
    private StatementFormatter formatter;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        formatter = mock(StatementFormatter.class);
        statementPrinter = new StatementPrinter(display, formatter);

        when(formatter.formatHeader())
                .thenReturn("date || credit || debit || balance\n");
    }

    @Test
    public void test_print_empty_statement() {
        Statement statement = new Statement(new ArrayList< Transaction >());

        statementPrinter.print(statement);

        verify(display).print("date || credit || debit || balance\n");
    }

    @Test
    public void test_print_statement_with_deposit() {
        String transactionDate = "10/01/2012";
        int transactionAmount = 1000;
        String transactionDate1 = "10/01/2013";
        int transactionAmount1 = -100;
        ArrayList< Transaction > transactions = new ArrayList< Transaction >();
        transactions.add(new Transaction(transactionDate, transactionAmount));
        transactions.add(new Transaction(transactionDate1, transactionAmount1));
        Statement statement = new Statement(transactions);

        when(formatter.formatLine(any(StatementLine.class)))
                .thenReturn("10/01/2013 || || 100.00 || 900.00\n")
                .thenReturn("10/01/2012 || 1000.00 || || 1000.00\n");

        statementPrinter.print(statement);

        verify(display).print("date || credit || debit || balance\n" +
                        "10/01/2013 || || 100.00 || 900.00\n" +
                "10/01/2012 || 1000.00 || || 1000.00\n");

    }
}