package cut_strings;

import java.util.List;

public class CutStringByTemplate implements CutString{
    private final String template;
    public CutStringByTemplate(String template) {
        this.template = template;
    }

    @Override
    public String tryCut(List<String> strings) {
        int index = CutString
                .findByPredicate(x -> x.equals(template),
                        strings);

        if(index != -1) {
            strings.remove(index);
            return template;
        }

        return "Fail";
    }
}
