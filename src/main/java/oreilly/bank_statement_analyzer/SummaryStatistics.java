package oreilly.bank_statement_analyzer;

public class SummaryStatistics {

    private final double sum;
    private final double min;
    private final double max;
    private final double avg;

    public SummaryStatistics(double sum, double min, double max, double avg) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public double getSum() {
        return sum;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAvg() {
        return avg;
    }
}
