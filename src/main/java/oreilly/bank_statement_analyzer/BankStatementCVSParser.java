package oreilly.bank_statement_analyzer;

import oreilly.bank_statement_analyzer.utils.Notification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementCVSParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public BankStatementCVSParser() {
    }

    @Override
    public BankTransaction parseFrom(String line) {
        String[] cols = line.split(",");
        return new BankTransaction((LocalDate.parse(cols[0], DATE_PATTERN)), Double.parseDouble(cols[1]), cols[2]);
    }


    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        List<String[]> cols;
        List<BankTransaction> bankTransactions = new ArrayList<>();
        cols = lines.stream().map(l -> l.split(",")).collect(Collectors.toList());
        cols.forEach(c -> bankTransactions.add(new BankTransaction(LocalDate.parse(c[0], DATE_PATTERN),
                Double.parseDouble(c[1]), c[2])));
        return bankTransactions;
    }
}
