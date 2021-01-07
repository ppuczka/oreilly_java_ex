package oreilly.bank_statement_analyzer;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCVSParser();
        bankStatementAnalyzer.analyze(args[0],bankStatementParser);
    }
}
