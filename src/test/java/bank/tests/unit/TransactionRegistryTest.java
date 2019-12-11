package bank.tests.unit;

import bank.CCalendar;
import bank.InMemoryTransactionRegistry;
import bank.Transaction;
import bank.TransactionRegistry;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class TransactionRegistryTest{
        private CCalendar calendar;
        @Test
        public void test_save_a_deposit()  {
            String transactionDate = "10-01-2012";
            int transactionAmount = 100;
            calendar = mock(CCalendar.class);
            when(calendar.getDate()).thenReturn(transactionDate);
            TransactionRegistry transactionRegistry = new InMemoryTransactionRegistry(calendar);

            transactionRegistry.save(transactionAmount);

            verify(calendar).getDate();
            ArrayList<Transaction> transactions = transactionRegistry.getTransactions();
            assertThat(transactions.get(0), is(new Transaction(transactionDate, transactionAmount)));
        }

       @Test
       public void test_save_a_withdrawal() {
           String transactionDate = "10-01-2012";
           int transactionAmount = -100;
           calendar = mock(CCalendar.class);
           when(calendar.getDate()).thenReturn(transactionDate);
           TransactionRegistry transactionRegistry = new InMemoryTransactionRegistry(calendar);

           transactionRegistry.save(transactionAmount);

           verify(calendar).getDate();
           ArrayList<Transaction> transactions = transactionRegistry.getTransactions();
           assertThat(transactions.get(0), is(new Transaction(transactionDate, transactionAmount)));
       }
}
