package cut_strings;

import java.util.List;

public class ExtractFileNameFormatTXT implements CutString{
    @Override
    public String tryCut(List<String> strings) {
        if (strings.size() == 0)
            return "Fail";

        String result = strings.get(0);
        strings.remove(0);

        if(result.indexOf(".txt") == -1)
            return "Fail";

        return result;
    }
}
