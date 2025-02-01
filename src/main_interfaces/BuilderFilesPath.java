package main_interfaces;

import java.util.List;
import java.util.function.Function;

public interface BuilderFilesPath {

    Function<String, String> getBuilder();

    void setResources(List<String> arr);

}