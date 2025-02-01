package cut_strings;

import java.util.List;

public class CutStringO implements CutString {
    @Override
    public String tryCut(List<String> strings) {
        int index = CutString
                .findByPredicate(x -> x.equals("-o"),
                        strings);

        if(index != -1) {
            strings.remove(index);
            String path = strings.get(index);
            strings.remove(index);
            return path;
        }

        return "Fail";
    }
}
