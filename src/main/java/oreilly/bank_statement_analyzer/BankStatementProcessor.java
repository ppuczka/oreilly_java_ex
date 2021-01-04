package oreilly.bank_statement_analyzer;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public Double calculateTotalBalance(List<BankTransaction> transactions) {
        return transactions.stream().mapToDouble(t -> t.amount).sum();
    }

    public Double calculateTotalMonthlyBalance(List<BankTransaction> transactions, String selectedMonth) {
        Month month = Month.valueOf(selectedMonth.toUpperCase());
        return transactions.stream()
                .filter(t -> t.date.getMonth() == month)
                .mapToDouble(c -> c.amount).sum();
    }

    public Double calculateTotalForCategory(List<BankTransaction> transactions, String category) {
        return transactions.stream()
                .filter(t -> t.description.equals(category))
                .mapToDouble(c -> c.amount).sum();
    }

}
