package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {

    Optional<String> empty = Optional.empty();

    empty.isPresent();

    empty.isEmpty();

    String name = "Janosch";

    Optional<String> optional = Optional.of(name);

    String nothing = null;

    Optional<String> isSOmethingthere = Optional.of(name);








  }

}
