package builders;

import builders.help_functions.Functions;
import main_interfaces.*;
import strategies.Strategy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericBuilder {
    private List<String> files;
    private List<String> arr;
    private BuilderFilesPath builderFilesPath;
    private BuilderStrategyStatistic builderStrategyStatistic;
    private BuilderStrategyWriter builderStrategyWriter;
    private BuilderInputter builderInputter;
    private PrintStream out;

    private Strategy<String> strategy;

    public void run() {
        if (strategy != null)
            return;

        builderFilesPath.setResources(arr);

        var function = builderFilesPath.getBuilder();

        files = files
                .stream()
                .map(x -> function.apply(x))
                .collect(Collectors.toCollection(ArrayList::new));

        builderStrategyStatistic.setResources(arr);
        StrategyStatistic statistic = builderStrategyStatistic.getStrategy();

        builderStrategyWriter.setResources(files, arr);
        StrategyFiles strategyFiles = builderStrategyWriter.getStrategyFiles();

        var genericStrategy = Functions.union(statistic, strategyFiles);

        builderInputter.setResources(arr);
        InputterFromFiles scanner = builderInputter.getInputter();

        while(true){
            String temp = scanner.extractLine();

            if(temp == null)
                break;

            genericStrategy.call(temp);

        }

        out.println(genericStrategy.getCalculateResult());

    }

    public GenericBuilder setFiles(List<String> files) {
        this.files = files;
        return this;
    }

    public GenericBuilder setArr(List<String> arr) {
        this.arr = arr;
        return this;
    }

    public GenericBuilder setBuilderPathFiles(BuilderFilesPath builderFilesPath) {
        this.builderFilesPath = builderFilesPath;
        return this;
    }

    public GenericBuilder setBuilderStrategyStatistics(BuilderStrategyStatistic builderStrategyStatistic) {
        this.builderStrategyStatistic = builderStrategyStatistic;
        return this;
    }

    public GenericBuilder setBuilderStrategyWriter(BuilderStrategyWriter builderStrategyWriter) {
        this.builderStrategyWriter = builderStrategyWriter;
        return this;
    }

    public GenericBuilder setBuilderInputter(BuilderInputter builderInputter) {
        this.builderInputter = builderInputter;
        return this;
    }

    public GenericBuilder setOut(PrintStream out) {
        this.out = out;
        return this;
    }
}
