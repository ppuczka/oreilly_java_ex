package oreilly.bank_statement_analyzer;

import java.util.List;

public class BankStatementAnalyzer {

    public static void main(String[] args) {
        String filename = "accounts.csv";
        List<BankTransaction> transactions = BankStatementCVSParser.statementFileParser(filename);
        BankStatementProcessor statementProcessor = new BankStatementProcessor(transactions);

        Double result = statementProcessor.calculateTotalBalance(transactions);
        System.out.println(result);
        Double monthlyResult = statementProcessor.calculateTotalMonthlyBalance(transactions, "January");
        System.out.println(monthlyResult);
        Double resultByCategory = statementProcessor.calculateTotalForCategory(transactions,"Cinema");
        System.out.println(resultByCategory);
    }

}