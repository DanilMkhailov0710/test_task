package builders.implementations_of.builders_strategy_statistic;

import cut_strings.CutString;
import cut_strings.CutStringByTemplate;
import main_interfaces.BuilderStrategyStatistic;
import main_interfaces.StrategyStatistic;
import strategies.strategies_statistic.composites.fulls.StrategyFull;
import strategies.strategies_statistic.composites.shorts.StrategyShort;

import java.util.List;

public class BuilderStatistic implements BuilderStrategyStatistic {
    private StrategyStatistic strategy;
    private CutString cutStringS;
    private CutString cutStringF;
    private List<String> arr;

    public BuilderStatistic() {
        cutStringS = new CutStringByTemplate("-s");
        cutStringF = new CutStringByTemplate("-f");
    }

    @Override
    public StrategyStatistic getStrategy() {
        if(strategy != null)
            return strategy;

        String res = cutStringS.tryCut(arr);
        if(!res.equals("Fail"))
            return new StrategyShort();

        res = cutStringF.tryCut(arr);
        if (!res.equals("Fail"))
            return new StrategyFull();

        throw new RuntimeException("Console output strategy not set");
    }

    @Override
    public void setResources(List<String> arr) {
        strategy = null;
        this.arr = arr;
    }
}