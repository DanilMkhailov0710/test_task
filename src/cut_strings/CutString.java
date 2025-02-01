package cut_strings;

import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface CutString {
    String tryCut(List<String> strings);

    static int findByPredicate(Predicate<String> predicate, List<String> strings) {
        int index = -1;

        for(int i = 0; i < strings.size(); i++) {
            if(predicate.test(strings.get(i))) {
                index = i;
                break;
            }
        }

        return index;
    }
}
