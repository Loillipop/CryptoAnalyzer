package DecryptEncrypt;

public class Encryptor {
    private static final String nameAction = "Encrypt";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsEncryptThisFile (String input) {
        String s = "c:\\";
        String output = "Зашифрованный файл находится по пути:" +s;
        System.out.println(output);
    }

}
