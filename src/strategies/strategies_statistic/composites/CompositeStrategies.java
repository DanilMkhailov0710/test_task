package strategies.strategies_statistic.composites;

import main_interfaces.StrategyStatistic;
import strategies.Strategy;

import java.math.BigDecimal;
import java.math.BigInteger;

import static builders.help_functions.Functions.isFloat;
import static builders.help_functions.Functions.isInteger;

public abstract class CompositeStrategies implements StrategyStatistic {
    protected Strategy<BigInteger> strategyInteger;
    protected Strategy<BigDecimal> strategyFloat;
    protected Strategy<String> strategyString;

    protected boolean isNotEmptyInteger;
    protected boolean isNotEmptyFloat;
    protected boolean isNotEmptyString;

    public CompositeStrategies(){
        isNotEmptyInteger = false;
        isNotEmptyFloat = false;
        isNotEmptyString = false;
    }

    @Override
    public void call(String value) {
        if(isInteger(value)) {
            isNotEmptyInteger = true;
            strategyInteger.call(new BigInteger(value));
        }

        else if (isFloat(value)) {
            isNotEmptyFloat = true;
            strategyFloat.call(new BigDecimal(value));
        }

        else {
            isNotEmptyString = true;
            strategyString.call(value);
        }
    }
}
