import builders.GenericBuilder;
import builders.implementations_of.builders_strategy_statistic.BuilderStatistic;
import builders.implementations_of.builders_strategy_writer.BuilderWriter;
import builders.implementations_of.builders_files_path.BuilderFiles;
import builders.implementations_of.builders_inputter.BuilderInputerQue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        var files = new ArrayList<String>();
        files.add("integer");
        files.add("float");
        files.add("string");

        new GenericBuilder()
                .setArr(Arrays
                        .stream(args)
                        .collect(Collectors.toCollection(ArrayList::new)))
                .setFiles(files)
                .setBuilderPathFiles(new BuilderFiles())
                .setBuilderStrategyStatistics(new BuilderStatistic())
                .setBuilderStrategyWriter(new BuilderWriter())
                .setBuilderInputter(new BuilderInputerQue())
                .setOut(System.out)
                .run();

    }
}