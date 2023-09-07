package DecryptEncrypt;

import IOStream.FilesReader;
import IOStream.FilesWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Encryptor {
    private static final String nameAction = "Encrypt";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsEncryptThisFile (Path input, int key) throws IOException {
        List<Character> unEncryptedArrayList = FilesReader.readFileFromString(input);
        ArrayList<Character> encryptedArrayList = new ArrayList<>();
        String path = FilesWriter.writeToFileReturnString(encryptedArrayList, input);
        String output = "Зашифрованный файл находится по пути:" + path;
        System.out.println(output);
    }

}
