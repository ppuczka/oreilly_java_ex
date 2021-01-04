package oreilly.bank_statement_analyzer;

import java.time.LocalDate;

public class BankTransaction {

    public final Double amount;
    public final String description;
    public final LocalDate date;

    public BankTransaction(LocalDate date, Double amount, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
