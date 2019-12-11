package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class StatementFormatterTest {

    @Test
    public void test_header_format() {
        StatementFormatter formatter = new TextStatementFormatter();

        String header = formatter.formatHeader();

        assertThat(header, is("date || credit || debit || balance\n"));
    }

    @Test
    public void test_format_line_for_deposit() {
        StatementFormatter formatter = new TextStatementFormatter();
        Transaction transaction = new Transaction("10-02-2019", 500);
        StatementLine statementLine = new StatementLine(transaction, 1000);

        String line = formatter.formatLine(statementLine);

        assertThat(line, is("10/02/2019 || 500.00 ||  || 1000.00\n"));
    }

    @Test
    public void test_format_line_for_withdrawal() {
        StatementFormatter formatter = new TextStatementFormatter();
        Transaction transaction = new Transaction("16-03-2015", -1500);
        StatementLine statementLine = new StatementLine(transaction, 300);

        String line = formatter.formatLine(statementLine);

        assertThat(line, is("16/03/2015 ||  || 1500.00 || 300.00\n"));
    }
}