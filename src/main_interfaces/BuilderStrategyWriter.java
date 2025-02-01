package main_interfaces;

import java.util.List;

public interface BuilderStrategyWriter {

    StrategyFiles getStrategyFiles();

    void setResources(List<String> paths, List<String> arr);

}
