package PVA8_Streams.NumberStream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
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

        int result = IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .map(n -> n * n)
                .sum();
        System.out.println(result);

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
    }
}