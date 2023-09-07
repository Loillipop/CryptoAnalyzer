package Analyzer;

import java.nio.file.Path;

public class StaticAnalyzer {
    private static final String nameAction = "StaticAnalyzer";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsMakeStaticAnalyze (Path input) {
        String s = "c:\\";
        String output = "Зашифрованный файл находится по пути:" +s;
        System.out.println(output);
    }

}
