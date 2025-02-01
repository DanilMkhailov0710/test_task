package builders.implementations_of.builders_files_path;

import builders.implementations_of.builders_files_path.helper_functor.BuilderOutputFilesPath;
import cut_strings.CutString;
import cut_strings.CutStringO;
import cut_strings.CutStringP;
import main_interfaces.BuilderFilesPath;

import java.util.List;
import java.util.function.Function;

public class BuilderFiles implements BuilderFilesPath {
    private BuilderOutputFilesPath builder;
    private CutString templateO;
    private CutString templateP;
    private List<String> arr;

    private BuilderOutputFilesPath result;

    public BuilderFiles() {
        this.builder = BuilderOutputFilesPath.of();
        templateO = new CutStringO();
        templateP = new CutStringP();
    }

    @Override
    public Function<String, String> getBuilder() {
        if(result != null)
            return result;

        String prefix = templateP.tryCut(arr);
        if(!prefix.equals("Fail")) {
            builder = builder
                    .map(s -> prefix + s);
        }

        String path = templateO.tryCut(arr);
        if(!path.equals("Fail")) {
            builder = builder
                    .map(s -> path + "/" + s);
        }

        result = builder;

        return result.map(s -> s + ".txt");
    }

    @Override
    public void setResources(List<String> arr) {
        result = null;
        this.arr = arr;
    }
}
