package oreilly.bank_statement_analyzer;

public interface Exporter {

    String export(SummaryStatistics statistics);
}
