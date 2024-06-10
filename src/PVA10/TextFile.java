package PVA10;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class TextFile {

    public static void readFileAsStream(Path filePath) throws IOException {

        try ( BufferedReader buffered = Files.newBufferedReader(filePath) ) {
            buffered.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\.")))
                    .map(String::trim)
                    .filter(segment -> !segment.isEmpty())
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("res/text.txt");

        readFileAsStream(filePath);
    }
}
