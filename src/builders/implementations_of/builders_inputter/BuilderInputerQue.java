package builders.implementations_of.builders_inputter;

import cut_strings.CutString;
import cut_strings.ExtractFileNameFormatTXT;
import main_interfaces.BuilderInputter;
import main_interfaces.InputterFromFiles;
import strategies.inputter.InputFile;

import java.util.List;
import java.util.stream.Collectors;

public class BuilderInputerQue implements BuilderInputter {
    private CutString extractFileName;
    List<InputterFromFiles> files;
    int index = 0;

    public BuilderInputerQue() {

        extractFileName = new ExtractFileNameFormatTXT();
    }

    @Override
    public void setResources(List<String> files) {
        if(files.isEmpty())
            throw new RuntimeException("Don't exist input files");

        if (files.stream().anyMatch(s -> s.indexOf(".txt") == -1 || s.length() < 5))
            throw new RuntimeException("Extra operations found or input files specified incorrectly");

        this.files = files
                .stream()
                .map(InputFile::new)
                .collect(Collectors.toList());
    }

    @Override
    public InputterFromFiles getInputter(){
        return new InputterFromFiles() {
            @Override
            public String extractLine() {
                String res = files.get(index).extractLine();
                if(res != null) {
                    index = (index + 1) % files.size();
                    return res;
                }

                files.remove(index);
                if(files.size() == 0)
                    return null;

                index = index % files.size();
                return extractLine();
            }
        };
    }
}
