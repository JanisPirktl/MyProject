package Lambda;

import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = "World";

    Comparator<String> stringComparator = Comparator.comparing(String::trim);

    System.out.println(stringComparator.compare(s1, s2));
  }
}
