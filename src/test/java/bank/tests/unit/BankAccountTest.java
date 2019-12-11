package bank.tests.unit;

import bank.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class BankAccountTest {

    private BankAccount bankAccount;
    private Printer printer;
    private TransactionRegistry transactions;

    @Before
    public void setUp() {
        transactions = mock(TransactionRegistry.class);
        printer = mock(Printer.class);
        bankAccount = new BankAccount(printer, transactions);
    }

    @Test
    public void test_actions() {
        bankAccount.deposit(100);

        verify(transactions).save(100);
    }

    @Test
    public void test_withdraw() {
        bankAccount.withdrawal(100);

        verify(transactions).save(-100);
    }

    @Test
    public void test_printer() {
        String transactionDate = "10-01-2012";
        int transactionAmount = -100;
        ArrayList<Transaction> transactionsList = new ArrayList<Transaction>();
        transactionsList.add(new Transaction(transactionDate, transactionAmount));


        when(transactions.getTransactions()).thenReturn(
                transactionsList
        );

        bankAccount.print();

        verify(printer).print(new Statement(transactionsList));
    }
}
