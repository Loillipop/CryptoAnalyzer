package userinterface;

public enum Choise {
    ENCODER ("Encoder"),
    DECODER ("Decoder"),
    BRUTFORCE ("BruteForce"),
    STATICANALYZER ("StaticAnalyzer"),
    EXIT ("Выход");
    private final String choise;
    Choise (String choise) {
        this.choise = choise;
    }
    public String getChoise () {
     return choise;
    }
}
