package PVA10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Dir {
    public static void main(String[] args) throws IOException {
        Path dirPath = Paths.get("C:/Users/svenw/OneDrive/Desktop");
        Files.list(dirPath)
                .map(file -> {
                    try {
                        BasicFileAttributes fileAttr = Files.readAttributes( file, BasicFileAttributes.class);
                        return fileAttr.creationTime() + "\t" +
                                (fileAttr.isDirectory() ? "<DIR>\t" : "\t\t") +
                                fileAttr.size() + "\t" +
                                file.getFileName();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);
    }
}
