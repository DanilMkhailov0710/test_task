package builders.implementations_of.builders_files_path.helper_functor;

import java.util.function.Function;

public class BuilderOutputFilesPath implements Function<String, String>{
    private final Function<String, String> function;

    private BuilderOutputFilesPath(Function<String, String> function) {
        this.function = function;
    }

    public static BuilderOutputFilesPath of() {
        return new BuilderOutputFilesPath(str -> str);
    }

    public BuilderOutputFilesPath map(Function<String, String> function) {
        Function<String, String> res =
                str -> function.apply(this.function.apply(str));
        return new BuilderOutputFilesPath(res);
    }

    @Override
    public String apply(String s) {
        return function.apply(s);
    }
}
