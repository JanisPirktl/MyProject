package PVA8_Streams.NumberStream;

import PVA8_Streams.Person;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class NumberStream {

    public static void main(String[] args) {

        IntStream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);

        // Print the sum of the squares of 1 to 100
        int result2 = IntStream.rangeClosed(1, 100)
                .map(n -> n * n)
                .sum();

        System.out.println(IntStream.rangeClosed(1, 100)
                .map(n -> n * n)
                .sum());

        int result55 = IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .map(n -> n * n)
                .sum();
        System.out.println(result55);

        // Print the average of the odd numbers less than 100
        IntStream.iterate(1, n -> n + 2)
                .limit(50)
                .average()
                .ifPresent(System.out::println);

        OptionalDouble avg = IntStream.iterate(1, n -> n + 2)
                .limit(50)
                .average();

        IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .filter(n -> n % 2 != 0)
                .average().ifPresent(System.out::println);

        // Produce a stream of 1 to 100 and drop 25% of the numbers at random points

        Random random = new Random();

        System.out.println(Arrays.toString(IntStream.rangeClosed(1, 100)
                .filter(n -> random.nextDouble() > 0.25)
                .toArray()));

        int[] numbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 != 0)
                .toArray();

        boolean hasOddNumber = Arrays.stream(numbers).noneMatch(n -> n % 2 == 0);

        int sumOfSquares = IntStream.range(1, 11) // 1 - 10
                .map(n -> n * n)
                .sum();

        System.out.println("Die Summe der Quadrate von 1 bis 10 ist: " + sumOfSquares);


        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 33),
                new Person("Charlie", 36)
        );

        // Umwandlung der Liste in eine Map mit ID als Schlüssel und Name als Wert
        Map<Integer, String> peopleMap = people.stream()
                .collect(Collectors.toMap(Person::getAge, Person::getName));

        // Ausgabe der resultierenden Map
        peopleMap.forEach((id, name) -> System.out.println("ID: " + id + ", Name: " + name));





    }
}