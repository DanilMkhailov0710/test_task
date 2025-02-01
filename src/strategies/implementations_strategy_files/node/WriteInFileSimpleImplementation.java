package strategies.implementations_strategy_files.node;

import strategies.Strategy;

import java.io.PrintWriter;

public abstract class WriteInFileSimpleImplementation implements Strategy<String> {
    protected PrintWriter writer;
    protected String fileName;
    boolean used = false;

    @Override
    public String getCalculateResult() {
        if (used)
            writer.close();

        return "Success!";
    }
}
