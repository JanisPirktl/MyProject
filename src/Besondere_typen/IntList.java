package Besondere_typen;

import java.util.* ;
import java.util.stream.* ;
import javax.lang.model.element.Element;

public class IntList
{
  public static void main( String[] args )
  {
    // Don't worry, we will study this later. It creates an ArrayList containing the Integers 0..100
    ArrayList<Integer> list =
        IntStream.range( 0, 101 ).boxed().collect( Collectors.toCollection(ArrayList::new) ) ;

    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(num -> System.out.println(num));
    list.forEach(System.out::println);

    // Remove all elements from the list which are divisible by 3
    list.removeIf(num -> num % 3 == 0);

    // Print the number of elements in the list
    System.out.println(list.size());

    // Randomize the list using shuffle() -> no lambda needed
    Collections.shuffle(list);

    // Sort the list according to the natural order
    list.sort(Comparator.comparingInt(Integer::intValue));
    list.sort((Comparator.naturalOrder())); //best one
    list.sort((num1, num2) -> Integer.compare(num1, num2));
    list.sort(Integer::compare);

    // Sort the list according in reverse natural order
    list.sort(Comparator.comparingInt(Integer::intValue).reversed());
    list.sort((Comparator.reverseOrder())); //best one
    list.sort((num1, num2) -> Integer.compare(num2, num1));

    // Sort the list such that elements which are divisible by 2 come first
    // (a, b) -> (a % 2) - (b % 2)     is identical to     Comparator.comparingInt(a -> (a % 2))
    Comparator<Integer> evenFirstComparator = Comparator.comparingInt(a -> (a % 2));
    list.sort(evenFirstComparator);



    // Sort the list such that elements which are divisible by 2 come first
    // and the numbers in both groups are sorted ascending
    list.sort(evenFirstComparator.thenComparing(Comparator.naturalOrder()));


    //Removing all elements greater than 24 and less than 42
    list.removeIf(num -> 24 < num && num < 42);

    //Removing all elements which are less than 12 or greater than 88
    list.removeIf(num -> 12 > num || 88 < num);
  }
}