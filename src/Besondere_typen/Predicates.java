package Besondere_typen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {

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

    List<String> names = List.of("Janis", "Adam", "Marco");
    List<Cat> cats = new ArrayList<>();

    Predicate<String> myPredicate = name -> name.startsWith("J");
    Predicate<String> mP2 = name -> name.length() == 6;

    Predicate<Integer> mP = num -> num < 15 && num > 0;

    Predicate<String> myPr = str -> str.length() < 5;
    String myString = "HelloWorld";
    boolean bool = myPr.test(myString);

    Predicate<Cat> weighsMoreThan1000 = cat -> cat.getWeight() > 1000;
    Predicate<Cat> weighsLessThan3000 = cat -> cat.getWeight() < 3000;

    // combine predicates with and
    int res = count(cats, weighsMoreThan1000.and(weighsLessThan3000));

    // combine predicates with or
    int res2 = count(cats, weighsMoreThan1000.or(weighsLessThan3000));

    int res3 = count(names, myPredicate); // 1

    int res4 = count(names, myPredicate.negate()); // reverses the condition

    names.stream().filter(myPredicate).forEach(System.out::println);
    // same same
    names.stream().filter(name -> name.startsWith("J")).forEach(System.out::println);
  }
}
