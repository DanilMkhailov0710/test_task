package strategies.strategies_statistic.small.fulls;

import strategies.Strategy;
import strategies.strategies_statistic.small.shorts.SmallStrategyIntegerShort;
import java.math.BigInteger;

public class SmallStrategyIntegerFull implements Strategy<BigInteger> {
    private BigInteger min;
    private BigInteger max;
    private BigInteger sum;
    private Strategy<BigInteger> strategy;

    public SmallStrategyIntegerFull() {
        sum = BigInteger.ZERO;
        strategy = new SmallStrategyIntegerShort();

    }
    @Override
    public void call(BigInteger value) {
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
        result += "Count: " + strategy.getCalculateResult() + "\n";
        result += "Sum: " + sum + "\n";
        BigInteger counter = new BigInteger(strategy.getCalculateResult());
        result += "Average: " + (sum.divide(counter)) + "\n";
        return result;
    }
}
