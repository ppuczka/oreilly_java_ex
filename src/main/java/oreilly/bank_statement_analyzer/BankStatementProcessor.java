package oreilly.bank_statement_analyzer;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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

    public Double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {
        double acc = 0d;
        bankTransactions.forEach(bankTransaction -> bankTransactionSummarizer.summarize(acc, bankTransaction));
        return acc;
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream()
                .filter(bankTransactionFilter::test).collect(Collectors.toList());
    }

    public Double calculateTotalMonthlyBalance(String selectedMonth) {
        Month month = Month.valueOf(selectedMonth.toUpperCase());
        return summarizeTransactions((accumulator, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? accumulator + bankTransaction.getAmount() : accumulator);
    }

    public Double calculateTotalForCategory(String category) {
        return summarizeTransactions((accumulator, bankTransaction) ->
                bankTransaction.getDescription().equals(category) ? accumulator + bankTransaction.getAmount() : accumulator);
    }

    public Optional<BankTransaction> findHighestTransactionForSpecificDateRange(LocalDate from, LocalDate until) {
        return findTransactions(t -> t.date.isAfter(from) && t.date.isBefore(until))
                .stream().max(Comparator.comparingDouble(BankTransaction::getAmount));
    }

    public List<BankTransaction> findTransactionsGraterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }
}