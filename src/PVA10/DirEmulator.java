package PVA10;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class DirEmulator {

    public static void main(String[] args) {

        // Verzeichnis, das aufgelistet werden soll
        String dirPath = args.length > 0 ? args[0] : ".";

        try {
            // Liste der Dateien im Verzeichnis abrufen
            try (Stream<Path> paths = Files.list(Paths.get(dirPath))) {
                paths.forEach(path -> {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                        String fileType = attrs.isDirectory() ? "DIR" : "FILE";
                        String fileSize = attrs.isDirectory() ? "<DIR>" : String.valueOf(attrs.size());
                        String fileTime = attrs.lastModifiedTime().toString();

                        System.out.printf("%-5s %-10s %-20s %s%n", fileType, fileSize, fileTime, path.getFileName());

                    } catch (IOException e) {
                        System.err.println("Fehler beim Lesen der Attribute von " + path.getFileName() + ": " + e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Auflisten des Verzeichnisses: " + e.getMessage());
        }
    }
}

