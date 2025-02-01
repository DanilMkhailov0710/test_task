package strategies.strategies_statistic.small.fulls;

import strategies.Strategy;
import strategies.strategies_statistic.small.shorts.SmallStrategyStringShort;

public class SmallStrategyStringFull implements Strategy<String> {
    private Strategy<String> strategy;
    private int min;
    private int max;
    public SmallStrategyStringFull() {
        strategy = new SmallStrategyStringShort();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    @Override
    public void call(String value) {
        strategy.call(value);
        min = (value.length() < min) ? value.length() : min;
        max = (value.length() > max) ? value.length() : max;
    }

    @Override
    public String getCalculateResult() {
        String result = "";
        result += "Min: " + min + "\n";
        result += "Max: " + max + "\n";
        result += "Count: " + strategy.getCalculateResult() + "\n";
        return result;
    }
}
