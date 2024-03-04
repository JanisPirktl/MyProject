package Besondere_typen;

import java.util.Objects;

public class Cat implements Comparable<Cat> {

  private final String name;
  private final int weight;

  public Cat(String name, int weight) {
    Objects.requireNonNull(name);
    this.name = name;
    this.weight = weight;
  }

  public Cat(Cat cat) {
    name = cat.name;
    weight = cat.weight;
  }

  public int compareTo(Cat otherCat) {
    if (!name.equals(otherCat.name)) {
      return name.compareTo(otherCat.name);
    } else {
      return Integer.compare(weight, otherCat.weight);
    }
  }

  String getName() {
    return name;
  }

  int getWeight() {
    return weight;
  }

  public String toString() {
    return name + " " + weight;
  }


  public boolean equals(Object o) {
    if (!(o instanceof Cat)) {
      return false; //instance of ist auch true, wenn subklasse von Cat ist.
      //o.getClass == Cat wäre falsch, wenn es eine Subkklasse von Cat ist.
    }
    Cat cat = (Cat) o;
    return name.equals(cat.name) && weight == cat.weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, weight);
  }
}