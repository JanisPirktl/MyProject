package Besondere_typen;

import java.util.* ;
import java.util.stream.* ;
import javax.lang.model.element.Element;

public class IntList
{
  public static void main( String[] args )
  {
    // Don't worry, we will study this later. It creates an ArrayList containing the Integers 0..100
    ArrayList<Integer> list = IntStream.range( 0, 101 ).boxed().collect( Collectors.toCollection(ArrayList::new) ) ;

    System.out.println( "The full list:" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(i -> System.out.println(i));
    list.forEach(System.out::println);


    list.forEach(e -> System.out.println(e%2==0));
    
    System.out.println( "\nRemoving all elements which are divisible by 3\n" ) ;
    // Remove all elements from the list which are divisible by 3
    list.removeIf(i -> i % 3 == 0);
    

    // Print the number of elements in the list
    System.out.println(list.size());



    System.out.println( "The remaining elements:" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);
    
    
    
    System.out.println( "\nRandomizing the list\n" ) ;
    // Randomize the list using shuffle() -> no lambda needed
    Collections.shuffle(list);

    
    
    System.out.println( "The randomized list:" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);



    // Sort the list according to the natural order
    list.sort(Comparator.comparingInt(Integer::intValue));
    list.sort((Comparator.naturalOrder())); //best one
    list.sort((i1, i2) -> Integer.compare(i1, i2));




    System.out.println( "The sorted list:" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);



    // Sort the list according in reverse natural order
    list.sort(Comparator.comparingInt(Integer::intValue).reversed());
    list.sort((Comparator.reverseOrder()));
    list.sort((i1, i2) -> Integer.compare(i2, i1));



    System.out.println( "The sorted list (reverse):" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);



    // Sort the list such that elements which are divisible by 2 come first
    list.sort((i1, i2) -> Integer.compare(i1, i2 % 2));



    System.out.println( "The sorted list (even numbers first):" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);



    // Sort the list such that elements which are divisible by 2 come first
    // and the numbers in both groups are sorted ascending
    Comparator<Integer> even = (a,b) -> (a % 2) - (b % 2);

    list.sort((i1, i2) -> {
      if ((i1 % 2 == 0) == (i2 % 2 == 0)) { // Both are even or odd
        return Integer.compare(i1, i2); // Sort in ascending order
      } else {
        return Boolean.compare(i2 % 2 == 0, i1 % 2 == 0); // Even numbers come first
      }
    });



    System.out.println( "The sorted list (even numbers first):" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);



    System.out.println( "\nRemoving all elements greater than 24 and less than 42\n" ) ;
    // Write the code
    list.removeIf(i -> 24 < i && i < 42);



    // Print the number of elements in the list
    System.out.println( "The remaining elements:" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);



    System.out.println( "\nRemoving all elements which are less than 12 or greater than 88\n" ) ;
    // Write the code
    list.removeIf(i -> 12 > i || 88 < i);



    // Print the number of elements in the list

    System.out.println( "The remaining elements:" ) ;
    // Print all elements in the list to the console (using a lambda, of course)
    list.forEach(System.out::println);
  }
}