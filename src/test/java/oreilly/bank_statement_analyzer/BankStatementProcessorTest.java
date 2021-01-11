package oreilly.bank_statement_analyzer;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementProcessorTest {

    private final List<BankTransaction> bankTransactionTestList = List.of(new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 3), 3000d, "Tesco"),
            new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 5), -30d, "Cinema"));
    private final Double tolerance = 0.0d;

    BankStatementProcessor processor = new BankStatementProcessor(bankTransactionTestList);

    @Test
    void shouldCalculateTotalBalance() {
        final double resultExpected = 2970d;
        Assertions.assertEquals(resultExpected, processor.calculateTotalBalance(), tolerance);
    }

    @Test
    void shouldCalculateTotalMonthlyBalance() {
        final double resultExpected = 2970d;
        Assertions.assertEquals(resultExpected, processor.calculateTotalMonthlyBalance(Month.FEBRUARY.toString()), tolerance);
    }

    @Test
    void shouldCalculateTotalForCategory() {
        final double resultExpected = -30d;
        Assertions.assertEquals(resultExpected, processor.calculateTotalForCategory("Cinema"), tolerance);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenFindingHighestTransaction() {
        Assertions.assertThrows(RuntimeException.class, () -> processor.findHighestTransactionForSpecificDateRange(
                LocalDate.of(2018, Month.MARCH, 1), LocalDate.of(2018, Month.MARCH, 1)));

    }
}