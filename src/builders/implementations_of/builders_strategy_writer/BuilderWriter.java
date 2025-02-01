package builders.implementations_of.builders_strategy_writer;

import cut_strings.CutString;
import cut_strings.CutStringByTemplate;
import main_interfaces.BuilderStrategyWriter;
import main_interfaces.StrategyFiles;
import strategies.implementations_strategy_files.composites.AStrategyWriteInFiles;
import strategies.implementations_strategy_files.composites.DefaultStrategyWriteInFiles;

import java.util.List;

public class BuilderWriter implements BuilderStrategyWriter {
    private StrategyFiles strategy;
    private CutString cutStringA;
    private List<String> arr;
    private List<String> paths;

    public BuilderWriter() {
        cutStringA = new CutStringByTemplate("-a");
    }

    @Override
    public StrategyFiles getStrategyFiles() {
        if (strategy != null)
            return strategy;

        String res = cutStringA.tryCut(arr);
        if (!res.equals("Fail"))
            return new AStrategyWriteInFiles(paths.get(0), paths.get(1), paths.get(2));

        return new DefaultStrategyWriteInFiles(paths.get(0), paths.get(1), paths.get(2));
    }

    @Override
    public void setResources(List<String> paths, List<String> arr) {
        this.arr = arr;
        this.paths = paths;
        if (paths.size() != 3) {
            throw new IllegalArgumentException("The paths list must contain three elements");
        }
        strategy = null;
    }
}