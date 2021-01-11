package oreilly.bank_statement_analyzer;

import org.junit.jupiter.api.Assertions;
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
        Double resultExpected = 2970d;
        Assertions.assertEquals(resultExpected, processor.calculateTotalBalance(), tolerance);
    }

    @Test
    void shouldCalculateTotalMonthlyBalance() {
        Double resultExpected = 2970d;
        Assertions.assertEquals(resultExpected, processor.calculateTotalMonthlyBalance(Month.FEBRUARY.toString()), tolerance);
    }

    @Test
    void shouldCalculateTotalForCategory() {
        Double resultExpected = -30d;
        Assertions.assertEquals(resultExpected, processor.calculateTotalForCategory("Cinema"), tolerance);
    }
}