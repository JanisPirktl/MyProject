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


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        Optional<Integer> sumResult = integerStream.reduce(Integer::sum);

        if (sumResult.isPresent()) {
            System.out.println("Sum of elements: " + sumResult.get());
        } else {
            System.out.println("No elements found in the stream");
        }


        Stream<String> stringStream = Stream.of("apple", "banana", "cherry");

        Optional<String> concatenationResult = stringStream.reduce((s1, s2) -> s1 + ", " + s2);

        if (concatenationResult.isPresent()) {
            System.out.println("Concatenated string: " + concatenationResult.get());
        } else {
            System.out.println("No elements found in the stream");
        }


        Stream<Person> personStream = Stream.of(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));

        Optional<Person> oldestPersonResult = personStream.reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);

        if (oldestPersonResult.isPresent()) {
            System.out.println("Oldest person: " + oldestPersonResult.get());
        } else {
            System.out.println("No elements found in the stream");
        }

    }
}