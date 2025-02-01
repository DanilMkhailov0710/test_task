package strategies.implementations_strategy_files.node;

import java.io.*;

public class DefaultWriteInFile extends WriteInFileSimpleImplementation {

    public DefaultWriteInFile(String fileName) {
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
            writer = new PrintWriter(new File(fileName));
        }
        catch (IOException e) {
            throw new RuntimeException("Not found file " + fileName);
        }
        writer.write(value + "\n");
    }
}
