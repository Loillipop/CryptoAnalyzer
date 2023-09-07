package DecryptEncrypt;

import IOStream.FilesReader;
import IOStream.FilesWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Decryptor {
    private static final String nameAction = "Decrypt";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsDecryptThisFile (Path input, int key) throws IOException {
        List<Character> unDecryptedArrayList = FilesReader.readFileFromString(input);
        List<Character> decryptedArrayList = new ArrayList<>();
        String path = FilesWriter.writeToFileReturnString(decryptedArrayList,input);
        String output = "Расшифрованный файл находится по пути:" + path;
        System.out.println(output);
    }

}
