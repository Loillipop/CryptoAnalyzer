package stages;

import iostreams.FilesToListReader;
import iostreams.ListToFilesWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class StaticAnalyzer {

    public static void letsMakeStaticAnalyze(Path input, int key) throws IOException {
        Path output = null;
        int usedkey = 0;
        for (int i = 1; i <= key; i++) {
            ArrayList<Character> encryptedArrayList = readDecodeWriteToArray(input, i);
            StringBuilder builder = convertListToString(encryptedArrayList);
            if (compareBuilderToAlphabet(builder)) {
                output = Path.of(ListToFilesWriter.writeToFileReturnString(encryptedArrayList, input));
                usedkey = i;
            }
        }
        System.out.println("Нужный нам ключ для расшифровки:" + usedkey);
        System.out.println("Расшифрованный файл :" + output);
    }

    public static ArrayList<Character> readDecodeWriteToArray(Path input, int key) throws IOException {
        List<Character> unEncryptedArrayList = FilesToListReader.readFileFromString(input);
        ArrayList<Character> encryptedArrayList = new ArrayList<>();
        for (int value : unEncryptedArrayList) {
            encryptedArrayList.add((char) (value - key));
        }
        return encryptedArrayList;
    }

    public static StringBuilder convertListToString(ArrayList<Character> encryptedArrayList) throws InputMismatchException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < encryptedArrayList.size(); i++) {
            builder.append(encryptedArrayList.get(i));
        }
        return builder;
    }

    public static boolean compareBuilderToAlphabet(StringBuilder builder) throws InputMismatchException, NullPointerException {
        String[] alphabet = {" в ", " на ", "ой ", "оя ", "ов ", "ие ", "ая ", "ся ", "ыи ", "ые ", "ых ", " и ", "ый", " от ", " к ", " над ", " под ", " до ", " после ", " за ", " перед ", " при ", " с ", " со ", " ко ", " обо ", " во ", " "};
        int count = 0;
        Scanner scanner = new Scanner(builder.toString());
        while (scanner.hasNextLine()) {
            String oneLine = scanner.nextLine();
            for (String alpha : alphabet) {
                if (oneLine.contains(alpha)) {
                    count++;
                }
            }
        }
        return count >= 20;
    }
}
