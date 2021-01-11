package oreilly.bank_statement_analyzer;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public Double calculateTotalBalance() {
        return this.bankTransactions.stream().mapToDouble(t -> t.amount).sum();
    }

    public Double calculateTotalMonthlyBalance(String selectedMonth) {
        Month month = Month.valueOf(selectedMonth.toUpperCase());
        return this.bankTransactions.stream()
                .filter(t -> t.date.getMonth() == month)
                .mapToDouble(c -> c.amount).sum();
    }

    public Double calculateTotalForCategory(String category) {
        return this.bankTransactions.stream()
                .filter(t -> t.description.equals(category))
                .mapToDouble(c -> c.amount).sum();
    }

    public Optional<BankTransaction> findHighestTransactionForSpecificDateRange(LocalDate from, LocalDate until) {
        return bankTransactions.stream()
                .filter(t -> t.date.isAfter(from) && t.date.isBefore(until))
                .max(Comparator.comparingDouble(BankTransaction::getAmount));
    }
}