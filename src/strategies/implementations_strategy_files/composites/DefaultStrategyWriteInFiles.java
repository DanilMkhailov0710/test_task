package strategies.implementations_strategy_files.composites;

import strategies.implementations_strategy_files.node.DefaultWriteInFile;

public class DefaultStrategyWriteInFiles extends StrategyWriteInFilesSimpleImplementation{
    public DefaultStrategyWriteInFiles(String fileIntegerPath, String fileFloatPath, String fileStringPath) {
        fileInteger = new DefaultWriteInFile(fileIntegerPath);
        fileFloat = new DefaultWriteInFile(fileFloatPath);
        fileString = new DefaultWriteInFile(fileStringPath);
    }
}
