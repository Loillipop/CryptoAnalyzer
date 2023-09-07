package IOStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FilesWriter {

    public static String writeToFileReturnString(List<Character> outputArrayList, Path path) throws IOException {
       File outputFile = new File(String.valueOf(path.getParent()), "OutputFile.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (char c: outputArrayList) {
            writer.append(c);
        }
        writer.close();
        return outputFile.getAbsolutePath();
    }
}
