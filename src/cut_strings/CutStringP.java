package cut_strings;

import java.util.List;

public class CutStringP implements CutString{
    @Override
    public String tryCut(List<String> strings) {
        int index = CutString
                .findByPredicate(x -> x.equals("-p"),
                        strings);

        if(index != -1) {
            strings.remove(index);
            String prefix = strings.get(index);
            strings.remove(index);
            return prefix;
        }

        return "Fail";
    }
}
