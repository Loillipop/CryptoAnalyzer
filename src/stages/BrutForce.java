package stages;

import iostreams.FilesToListReader;
import iostreams.ListToFilesWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BrutForce {

    public static void letsBrutThisFile(Path input, int key) throws IOException {
        Path output = null;
        int usedkey = 0;
            for (int i = 1; i < key; i++) {
                ArrayList<Character> encryptedArrayList = readDecodeWriteToArray(input, i);
                if (checkArrayToAlphabet(encryptedArrayList)) {
                    usedkey = i;
                    output = Path.of(ListToFilesWriter.writeToFileReturnString(encryptedArrayList, input));
                }
        }
            if (usedkey !=0 ) {
                System.out.println("Нужный нам ключ для расшифровки:" + usedkey);
                System.out.println("Расшифрованный файл :" + output);
            }
            else {
                System.out.println("Невозможно подобрать ключ");
            }
    }

    public static boolean checkArrayToAlphabet (ArrayList<Character> encryptedArrayList) throws InputMismatchException {
        boolean result = true;
        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtVvUuWwXxYyZzАаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя \n,.../!?'@#$%^$%^&*()—-_=+{}[]:;~«»…`\"";
        while (result) {
            for (char value : encryptedArrayList) {
                if (!alphabet.contains(String.valueOf(value))) {
                result = false;
                break;
                }
            }
        break;
        }
        return result;
    }

    public static ArrayList<Character> readDecodeWriteToArray(Path input, int key) throws IOException {
        List<Character> unEncryptedArrayList = FilesToListReader.readFileFromString(input);
        ArrayList<Character> encryptedArrayList = new ArrayList<>();
        for (int value : unEncryptedArrayList) {
            encryptedArrayList.add((char) (value - key));
        }
        return encryptedArrayList;
    }
}
