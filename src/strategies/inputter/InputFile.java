package strategies.inputter;

import main_interfaces.InputterFromFiles;

import java.io.*;

public class InputFile implements InputterFromFiles {
    BufferedReader reader;
    public InputFile(String fileName){
        File file = new File(fileName);
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("File not found:" + fileName);
        }
    }

    @Override
    public String extractLine() {
        try {
            return reader.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
