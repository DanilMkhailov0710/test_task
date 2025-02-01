package main_interfaces;

import java.util.List;

public interface BuilderInputter {
    InputterFromFiles getInputter();

    void setResources(List<String> files);

}
