package strategies.strategies_statistic.composites.fulls;

import strategies.strategies_statistic.composites.CompositeStrategies;
import strategies.strategies_statistic.small.fulls.SmallStrategyFloatFull;
import strategies.strategies_statistic.small.fulls.SmallStrategyIntegerFull;
import strategies.strategies_statistic.small.fulls.SmallStrategyStringFull;

public class StrategyFull extends CompositeStrategies {

    public StrategyFull() {
        super();
        strategyFloat = new SmallStrategyFloatFull();
        strategyInteger = new SmallStrategyIntegerFull();
        strategyString = new SmallStrategyStringFull();
    }

    @Override
    public String getCalculateResult() {
        String result = "";
        result += "Full info:\n\n";

        result += "Integers:\n";
        if(isNotEmptyInteger)
            result += strategyInteger.getCalculateResult() + "\n";

        else
            result += "Empty\n\n";

        result += "Floats:\n";
        if(isNotEmptyFloat)
            result += strategyFloat.getCalculateResult() + "\n";

        else
            result += "Empty\n\n";

        result += "Strings:\n";
        if(isNotEmptyString)
            result += strategyString.getCalculateResult() + "\n";

        else
            result += "Empty\n\n";

        return result;
    }
}
