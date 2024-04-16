package Besondere_typen;

import java.util.Optional;

public class Optionals {

  public static void main(String[] args) {

    Optional<String> empty = Optional.empty();

    System.out.println(empty.isPresent()); // false

    System.out.println(empty.isEmpty()); // true

    String name = "Janis";
    Optional<String> opt = Optional.of(name);
    //Optional<Integer> opt2 = Optional.of(name); // Compiler-Error

    String nothing = null;
    //Optional<String> opt3 = Optional.of(nothing); // NullPointerException
    //Optional opt4 = Optional.of(nothing); // Raw use warning + NullPointerException

    Optional<String> opt5 = Optional.ofNullable(nothing); // das geht
    Optional<String> opt6 = Optional.ofNullable(null);
    String string = Optional.ofNullable(nothing).orElse("something");

    String string2 = Optional.ofNullable(nothing).orElseGet(() -> "Janis");

    empty.ifPresent(System.out::println);
    empty.ifPresentOrElse(System.out::println, () -> System.out.println("is empty"));
  }

}
