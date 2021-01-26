package oreilly.bank_statement_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Exporter {

    String export(SummaryStatistics statistics) throws JsonProcessingException;
}
