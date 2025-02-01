package builders.implementations_of.builders_inputter;

import cut_strings.CutString;
import cut_strings.ExtractFileNameFormatTXT;
import main_interfaces.BuilderInputter;
import main_interfaces.InputterFromFiles;
import strategies.inputter.InputFile;

import java.util.List;

public class BuilderInputterSequence implements BuilderInputter {
    private CutString extractFileName;
    List<String> files;
    InputterFromFiles tempFile;

    public BuilderInputterSequence() {
        extractFileName = new ExtractFileNameFormatTXT();
    }

    @Override
    public void setResources(List<String> files) {
        this.files = files;
        String file = extractFileName.tryCut(files);

        if(files.isEmpty())
            throw new RuntimeException("Don't exist input files");

        if (file.equals("Fail"))
            throw new RuntimeException("Extra operations found or input files specified incorrectly");

        tempFile = new InputFile(file);
    }

    @Override
    public InputterFromFiles getInputter(){
        return new InputterFromFiles() {
            @Override
            public String extractLine() {

                String result = tempFile.extractLine();

                if(result != null)
                    return result;

                String file = extractFileName.tryCut(files);

                if (file.equals("Fail"))
                    return null;

                tempFile = new InputFile(file);

                return extractLine();
            }
        };
    }
}
