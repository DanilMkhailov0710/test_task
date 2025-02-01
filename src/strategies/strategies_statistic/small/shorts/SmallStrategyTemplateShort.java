package strategies.strategies_statistic.small.shorts;

import strategies.Strategy;

public abstract class SmallStrategyTemplateShort<T> implements Strategy<T> {
    private long counter;
    public SmallStrategyTemplateShort() {
        counter = 0;
    }
    @Override
    public void call(T value) {
        counter++;
    }

    @Override
    public String getCalculateResult() {
        return String.valueOf(counter);
    }
}
