package bank.tests.acceptance;

import bank.BankAccount;
import bank.CCalendar;
import bank.OutputPrinter;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.*;

public class PrintingAccountStatementOnConsoleTest {

    private BankAccount bankAccount;
    private OutputPrinter output;
    private CCalendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = mock(CCalendar.class);
        output = mock(OutputPrinter.class);
        bankAccount = new BankAccount(calendar, output);
    }

    @Test
    public void printing_statement_including_deposit_and_withdrawal() throws ParseException {
        /**
         *     > Given a client makes a deposit of 1000 on 10-01-2012
         *     > And a deposit of 2000 on 13-01-2012
         *     > And a withdrawal of 500 on 14-01-2012
         *     > When she prints her bank statement
         *     > Then she would see
         *     > date || credit || debit || balance
         *     > 14/01/2012 || || 500.00 || 2500.00
         *     > 13/01/2012 || 2000.00 || || 3000.00
         *     > 10/01/2012 || 1000.00 || || 1000.00
         */
        //Given
        when(calendar.getDate()).thenReturn(
                new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2012"),
                new SimpleDateFormat("dd-MM-yyyy").parse("13-01-2012"),
                new SimpleDateFormat("dd-MM-yyyy").parse("14-01-2012")
        );
        bankAccount.deposit(1000);
        bankAccount.deposit(2000);
        bankAccount.withdrawal(500);

        spy(output).print("date || credit || debit || balance\n" +
                "14/01/2012 || || 500.00 || 2500.00\n" +
                "13/01/2012 || 2000.00 || || 3000.00\n" +
                "10/01/2012 || 1000.00 || || 1000.00\n");
        bankAccount.print();
    }
}
