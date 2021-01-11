package oreilly.bank_statement_analyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


class BankStatementCVSParserTest {

    private final BankStatementParser bankStatementParser = new BankStatementCVSParser();

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-100,Deliveroo";
        final BankTransaction result = bankStatementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100d, "Deliveroo");
        final double tolerance = 0.0d;
        Assertions.assertEquals(expected.getDate(), result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    void shouldParseManyCorrectLines() {
        final List<String> lines = List.of("03-02-2017,3000,Tesco", "05-02-2017,-30,Cinema");
        final List<BankTransaction> result = bankStatementParser.parseLinesFrom(lines);
        final List<BankTransaction> expected = List.of(new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 3), 3000d, "Tesco"),
                new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 5), -30d, "Cinema"));
        final double tolerance = 0.0d;
        Assertions.assertEquals(result.get(1).getDescription(), expected.get(1).getDescription());
        Assertions.assertEquals(result.get(1).getAmount(), expected.get(1).getAmount(), tolerance);
        Assertions.assertEquals(result.get(1).getDate(), expected.get(1).getDate());
    }
}