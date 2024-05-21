package PVA8_Streams;

import java.util.*;
import java.util.stream.*;


public class CatListExercise {

    public static void main(String[] args) {



        ArrayList<GenderCat> cats = new ArrayList<>(List.of(
                new GenderCat("Felix", 2500, Gender.M),
                new GenderCat("Susi", 1800, Gender.F),
                new GenderCat("Garfield", 5000, Gender.M)));


        // Produce a String with all the names, delimited by "-" and print it
        String result = cats.stream()
                .map(c -> c.getName())
                .collect(Collectors.joining("-"));

        System.out.println(result);

        // Sum the weight of all cats weighing less than 4000 and print it
        int sumOfWeight = cats.stream()
                .filter(c -> c.getWeight() < 4000)
                .mapToInt(c -> c.getWeight())
                .sum();

        System.out.println(sumOfWeight);

        // Add 100 to the weight of each cat and print the list
        List<GenderCat> cats2 = cats.stream()
                .map(c -> new GenderCat(c.getName(), c.getWeight() + 100, c.getGender()))
                .toList();

        System.out.println(cats2);

        // Count the cats weighing 2000 or more and print the result
        long count = cats.stream()
                .filter(c -> c.getWeight() >= 2000)
                .count();

        System.out.println(count);

        // Print the average weight of all the cats
        cats.stream()
                .mapToInt(c -> c.getWeight())
                .average().ifPresent(System.out::println);

        // Count the male and female cats using groupingBy
        Map<Gender, Long> countByGender = cats.stream()
                .collect(Collectors.groupingBy(c -> c.getGender(), Collectors.counting()));

        countByGender.forEach((gender, genderCount) ->
                System.out.println(gender + " cats: " + genderCount));


        // Write printSorted which can be called like this

        printSorted(cats, Comparator.comparing(GenderCat::getName));
        printSorted(cats, (a, b) -> Integer.compare(a.getWeight(), b.getWeight()));
        printSorted(List.of(3, 1, 4, 2), Comparator.naturalOrder());
    }
    public static <T> void printSorted(List<T> list, Comparator<T> comparator) {
        list.stream()
                .sorted(comparator)
                .forEachOrdered(System.out::println);
    }
}
