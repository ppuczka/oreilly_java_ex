package oreilly.bank_statement_analyzer;

public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics statistics) {
        String result = """
                !<doctype html>
                <html lang = 'en'>
                <head><title>Bank Transactions Report</title></head>
                <body>
                <ul>
                <li><strong>The sum is:</strong>
                """;
        result += statistics.getSum() + "</li>";
        result += "<li><strong>The average is:</strong> " + statistics.getAvg() + "</li>";
        result += "<li><strong>The minimal is:</strong> " + statistics.getMin() + "</li>";
        result += "<li><strong>The maximum is:</strong> " + statistics.getMax() + "</li>";
        result += """
                </ul>
                </body>
                </html>
                """;
        return result;
    }
}
