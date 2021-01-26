package oreilly.bank_statement_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExporter implements Exporter {


    @Override
    public String export(SummaryStatistics statistics) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(statistics);
        System.out.println(jsonStr);
        return jsonStr;
    }
}
