package oreilly.bank_statement_analyzer;

import oreilly.bank_statement_analyzer.utils.Notification;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    public Notification validate() {
        final Notification notification = new Notification();
        if (this.description.length() > 100) {
            notification.addError("The description is to long");
        }

        final LocalDate parsedDate = LocalDate.parse(this.date.toString());
        try {
            if (parsedDate.isAfter(LocalDate.now())) {
                notification.addError("Date cannot be in the future");
            }
        }catch (DateTimeParseException e) {
            notification.addError("Invalid format of date");

        }
        return notification;
    }
}
