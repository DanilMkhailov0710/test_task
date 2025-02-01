package strategies.strategies_statistic.small.fulls;

import strategies.Strategy;
import strategies.strategies_statistic.small.shorts.SmallStrategyFloatShort;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SmallStrategyFloatFull implements Strategy<BigDecimal> {
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal sum;
    private Strategy<BigDecimal> strategy;
    public SmallStrategyFloatFull() {
        sum = new BigDecimal(0);
        strategy = new SmallStrategyFloatShort();
    }
    @Override
    public void call(BigDecimal value) {
        String ini = strategy.getCalculateResult();
        BigInteger nIni = new BigInteger(ini);
        if(nIni.compareTo(BigInteger.ZERO) == 0) {
            min = value;
            max = value;
        }
        strategy.call(value);
        sum = sum.add(value);
        min = (value.compareTo(min) == -1) ? value : min;
        max = (value.compareTo(max) == 1) ? value : max;
    }

    @Override
    public String getCalculateResult() {
        String result = "";
        result += "Min: " + min + "\n";
        result += "Max: " + max + "\n";
        String count = strategy.getCalculateResult();
        result += "Count: " + count + "\n";
        result += "Sum: " + sum + "\n";
        BigDecimal counter = new BigDecimal(count);
        result += "Average: " + (sum.divide(counter, 6)) + "\n";
        return result;
    }
}
