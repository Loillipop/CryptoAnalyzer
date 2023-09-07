package iostreams;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilesToListReader {
    public static List<Character> readFileFromString(Path input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input.toFile()));
        List<Character> redCharArrayList = new ArrayList<>();
        int c;
        while  ((c=reader.read())!= -1) {
            redCharArrayList.add((char) c);
        }
        reader.close();
  return redCharArrayList;
    }



}
