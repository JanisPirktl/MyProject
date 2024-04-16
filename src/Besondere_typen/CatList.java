package Besondere_typen;

import java.util.*;
import java.util.function.Predicate;

public class CatList {

  public static <T> int count(List<T> lst, Predicate<T> predicate) {
    int result = 0;

    for (T element : lst) {
      if (predicate.test(element)) {
        ++result;
      }
    }

    return result;
  }


  public static void main(String[] args) {
    ArrayList<Cat> cats = new ArrayList<>(
        List.of(new Cat("Felix", 2500), new Cat("Susi", 1800), new Cat("Garfield", 5000)));

    // Print all the cats
    cats.forEach(cat -> System.out.println(
        "Name: " + cat.getName() + ", Weight: " + cat.getWeight() + " grams"));
    cats.forEach(System.out::println);

    // Define a lambda to compare the weight of two cats
    Comparator<Cat> compareByWeight = (Cat cat1, Cat cat2) -> cat1.getWeight() - cat2.getWeight();
    Comparator<Cat> compareByWeight2 = (c1, c2) -> Integer.compare(c1.getWeight(),
        c2.getWeight()); //besser als 1.
    Comparator<Cat> compareByWeight3 = Comparator.comparingInt(
        Cat::getWeight);    // This is not a lambda

    // Sort the cats by weight, ascending
    cats.sort(compareByWeight2); //mit der eigenen Funktion oben
    cats.sort(Comparator.comparingInt(Cat::getWeight));

    // Sort the cats by weight, descending
    cats.sort(compareByWeight2.reversed()); // mit der eigenen Funktion oben
    cats.sort(Comparator.comparingInt(Cat::getWeight).reversed());

    // Try to use comparing to sort by name
    cats.sort(Comparator.comparing(Cat::getName));

    // Count the cats whose name is longer than 4 characters
    int res = count(cats, c -> c.getName().length() > 4);

    // Count the cats whose name starts with 'X'
    res = count(cats, c -> c.getName().charAt(0) == 'X');
    res = count(cats, c -> c.getName().startsWith("X")); //besser

    // Count the cats whose name ends with 'x'
    res = count(cats, c -> c.getName().charAt(c.getName().length() - 1) == 'x');
    res = count(cats, c -> c.getName().endsWith("x")); //besser

    // Count the cats weighing between 2000 and 4000
    res = count(cats, c -> 2000 < c.getWeight() && c.getWeight() < 4000);

    // Define a named lambda which tests if a cat weighs more than 1000
    Predicate<Cat> weighsMoreThan1000 = cat -> cat.getWeight() > 1000;

    // Use the lambda you just defined and the "and"-method in the interface
    // to count the cats between 1000 and 3000.
    Predicate<Cat> weighsLessThan3000 = cat -> cat.getWeight() < 3000;

    res = count(cats, weighsMoreThan1000.and(weighsLessThan3000));
    res = count(cats, ((Predicate<Cat>) c -> c.getWeight() > 1000).and(c -> c.getWeight() < 3000));
    res = count(cats, weighsMoreThan1000.and(cat -> cat.getWeight() < 3000));

    // Remove cats weighing over 4000
    cats.removeIf(cat -> cat.getWeight() > 4000);

    int gain = 100;
    // Increase the weight of the cats by gain
    cats.forEach(cat -> cat.setWeight(cat.getWeight() + gain));
    cats.replaceAll(cat -> new Cat(cat.getName(), cat.getWeight() + gain));
  }
}
