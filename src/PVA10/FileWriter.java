package PVA10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {

    public static void readFileAsStream(Path readFilePath, Path writeFilePath) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(readFilePath);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(writeFilePath)) {

            String line;
            int lineNumber = 1;

            while ((line = bufferedReader.readLine()) != null) {

                if (lineNumber % 2 != 0) {

                    bufferedWriter.write(line);
                    bufferedWriter.newLine();

                }
                lineNumber++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Path readFilePath = Paths.get("res/textFile1.txt");
        Path writeFilePath = Paths.get("res/textFile2.txt");

        readFileAsStream(readFilePath, writeFilePath);
    }
}
