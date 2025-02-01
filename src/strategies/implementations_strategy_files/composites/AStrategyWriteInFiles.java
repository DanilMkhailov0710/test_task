package strategies.implementations_strategy_files.composites;

import strategies.implementations_strategy_files.node.AddWriteInFile;

public class AStrategyWriteInFiles extends StrategyWriteInFilesSimpleImplementation{
    public AStrategyWriteInFiles(String fileIntegerPath, String fileFloatPath, String fileStringPath) {
        fileInteger = new AddWriteInFile(fileIntegerPath);
        fileFloat = new AddWriteInFile(fileFloatPath);
        fileString = new AddWriteInFile(fileStringPath);
    }
}
