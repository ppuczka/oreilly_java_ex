package oreilly.bank_statement_analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String filename, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        System.out.println(bankStatementProcessor.calculateTotalBalance());
        System.out.println(bankStatementProcessor.calculateTotalMonthlyBalance("January"));
        System.out.println(bankStatementProcessor.calculateTotalForCategory("Cinema"));

        BankTransaction result = Optional.of(bankStatementProcessor.
                findHighestTransactionForSpecificDateRange(LocalDate.of(2017, Month.FEBRUARY, 1),
                        LocalDate.of(2017, Month.MARCH, 30))).get().orElseThrow(RuntimeException::new);
        System.out.println(result);

        System.out.println(bankStatementProcessor.findTransactionsGraterThanEqual(1000));
    }
}