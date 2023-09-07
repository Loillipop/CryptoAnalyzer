package stages;

import iostreams.FilesToListReader;
import iostreams.ListToFilesWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BrutForce {
    private static int usedkey = 0;
    private static final String nameAction = "BruteForce";
    public static String getNameAction () {
        return nameAction;
    }
    public static void letsBrutThisFile (Path input, int key) throws IOException {

        for (int i = 0; i < key; i++) {
            List<Character> unEncryptedArrayList = FilesToListReader.readFileFromString(input);
            ArrayList<Character> encryptedArrayList = new ArrayList<>();
            for (int value : unEncryptedArrayList) {
                encryptedArrayList.add((char) (value + key));
            }
            Path output = Path.of(ListToFilesWriter.writeToFileReturnString(encryptedArrayList, input));
            BufferedReader in = new BufferedReader(new FileReader(input.toFile()));
            BufferedReader out = new BufferedReader(new FileReader(output.toFile()));
                if (in.hashCode() == out.hashCode()) {
                    usedkey = i;
                }
            }
        }
        String output = "Нужный нам ключ для расшифровки:" + usedkey;

}
