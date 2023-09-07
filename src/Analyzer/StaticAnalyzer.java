package Analyzer;

public class StaticAnalyzer {
    private static final String nameAction = "StaticAnalyzer";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsMakeStaticAnalyze (String input) {
        String s = "c:\\";
        String output = "Зашифрованный файл находится по пути:" +s;
        System.out.println(output);
    }

}
