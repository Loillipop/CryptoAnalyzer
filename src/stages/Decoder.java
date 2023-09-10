package stages;

import iostreams.FilesToListReader;
import iostreams.ListToFilesWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    public static void letsDecryptThisFile(Path input, int key) throws IOException {
        List<Character> unEncryptedArrayList = FilesToListReader.readFileFromString(input);
        ArrayList<Character> encryptedArrayList = new ArrayList<>();
        for (int value : unEncryptedArrayList) {
            encryptedArrayList.add((char) (value - key));
        }
        String path = ListToFilesWriter.writeToFileReturnString(encryptedArrayList, input);
        String output = "Зашифрованный файл находится по пути:" + path;
        System.out.println(output);
    }
}
