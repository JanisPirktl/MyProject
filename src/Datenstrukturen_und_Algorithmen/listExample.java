package Datenstrukturen_und_Algorithmen;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class listExample {
    public static void main(String[] args) {

        // TreeSet with natural ordering
        Set<Integer> naturalOrderSet = new TreeSet<>();
        naturalOrderSet.add(5);
        naturalOrderSet.add(3);
        naturalOrderSet.add(1);

        // TREESET CANT HAVE NULL

        // TREESET ORDNEN
        TreeSet<String> customOrderSet = new TreeSet<>(Comparator.comparingInt(String::length));
        customOrderSet.add("apple");
        customOrderSet.add("banana");
        customOrderSet.add("pear");
    }
}
