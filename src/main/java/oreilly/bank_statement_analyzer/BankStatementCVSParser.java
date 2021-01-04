package oreilly.bank_statement_analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementCVSParser {

    private static final String RESOURCES = "src/main/resources/";
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public BankStatementCVSParser() {
    }

    public static List<BankTransaction> statementFileParser(String filename) {
        List<String[]> cols;
        List<BankTransaction> statements = new ArrayList<>();
        Path path = Paths.get(RESOURCES + filename);

        try {
            List<String> lines = Files.readAllLines(path);
            cols = lines.stream().map(l -> l.split(",")).collect(Collectors.toList());
            cols.forEach(c -> statements.add(new BankTransaction(LocalDate.parse(c[0], DATE_PATTERN),
                    Double.parseDouble(c[1]), c[2])));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return statements;
    }
}
