package stages;

import java.nio.file.Path;

public class StaticAnalyzer {
    private static final String nameAction = "StaticAnalyzer";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsMakeStaticAnalyze (Path input) {
        String output = "В разработке";
        System.out.println(output);
    }

}
