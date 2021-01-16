package oreilly.bank_statement_analyzer.utils;

import java.util.ArrayList;
import java.util.List;

public class Notification {

    private final List<String> errors = new ArrayList<>();

    public void addError(String message) {
        this.errors.add(message);
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public String errorMessage() {
        return this.errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
