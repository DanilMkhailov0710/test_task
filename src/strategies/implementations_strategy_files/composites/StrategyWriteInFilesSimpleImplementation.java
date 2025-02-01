package strategies.implementations_strategy_files.composites;

import main_interfaces.StrategyFiles;
import strategies.Strategy;

import static builders.help_functions.Functions.isFloat;
import static builders.help_functions.Functions.isInteger;

public abstract class StrategyWriteInFilesSimpleImplementation implements StrategyFiles {
    protected Strategy<String> fileInteger;
    protected Strategy<String> fileFloat;
    protected Strategy<String> fileString;


    @Override
    public void call(String value) {
        if(isInteger(value)) {
            fileInteger.call(value);
        }

        else if (isFloat(value)) {
            fileFloat.call(value);
        }

        else {
            fileString.call(value);
        }
    }

    @Override
    public String getCalculateResult() {
        fileInteger.getCalculateResult();
        fileFloat.getCalculateResult();
        fileString.getCalculateResult();
        return "";
    }
}
