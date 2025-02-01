package strategies.strategies_statistic.composites.shorts;

import strategies.strategies_statistic.composites.CompositeStrategies;
import strategies.strategies_statistic.small.shorts.SmallStrategyFloatShort;
import strategies.strategies_statistic.small.shorts.SmallStrategyIntegerShort;
import strategies.strategies_statistic.small.shorts.SmallStrategyStringShort;

public class StrategyShort extends CompositeStrategies {

    public StrategyShort() {
        super();
        strategyFloat = new SmallStrategyFloatShort();
        strategyInteger = new SmallStrategyIntegerShort();
        strategyString = new SmallStrategyStringShort();
    }

    @Override
    public String getCalculateResult() {
        String result = "";
        result += "Short info: \n\n";

        result += "Integers:\n";
        result += strategyInteger.getCalculateResult() + "\n\n";

        result += "Floats:\n";
        result += strategyFloat.getCalculateResult() + "\n\n";

        result += "Strings:\n";
        result += strategyString.getCalculateResult() + "\n\n";

        return result;
    }
}
