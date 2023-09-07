package DecryptEncrypt;

public class Decryptor {
    private static final String nameAction = "Decrypt";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsDecryptThisFile (String input) {
        String s = "c:\\";
        String output = "Зашифрованный файл находится по пути:" +s;
        System.out.println(output);
    }

}
