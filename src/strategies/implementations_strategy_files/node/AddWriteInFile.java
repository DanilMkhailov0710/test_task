package strategies.implementations_strategy_files.node;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddWriteInFile extends WriteInFileSimpleImplementation {

    public AddWriteInFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void call(String value) {
        if (used) {
            writer.write(value + "\n");
            return;
        }
        used = true;

        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        }
        catch (IOException e) {
            throw new RuntimeException("Not found file " + fileName);
        }
        writer.write(value + "\n");
    }
}
