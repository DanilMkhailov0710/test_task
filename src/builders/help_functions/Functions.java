package builders.help_functions;

import main_interfaces.StrategyFiles;
import main_interfaces.StrategyStatistic;
import strategies.Strategy;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Functions {

    private Functions() {}

    public static boolean isInteger(String number) {
        try{
            BigInteger num = new BigInteger(number);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isFloat(String number) {
        try{
            BigDecimal num = new BigDecimal(number);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static Strategy<String> union(StrategyStatistic statistic, StrategyFiles files) {
        return new Strategy<String>() {

            @Override
            public void call(String value) {
                statistic.call(value);
                files.call(value);
            }

            @Override
            public String getCalculateResult() {
                files.getCalculateResult();
                return statistic.getCalculateResult();
            }
        };
    }

}
