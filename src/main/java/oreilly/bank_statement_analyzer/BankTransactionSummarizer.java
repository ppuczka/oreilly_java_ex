package oreilly.bank_statement_analyzer;

@FunctionalInterface
public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);

}
