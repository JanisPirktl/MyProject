package Besondere_typen;

public class Main2 {

  public static void main(String[] args) {

    Cat cat1 = new Cat("Hello", 12);
    Cat cat2 = new Cat("Hello", 12);
    Dog dog1 = new Dog("Hello", 12);
    SuperCat scat1 = new SuperCat("Hello", 12, "Miau");
    Cat cat = new Cat(null, 12);

    System.out.println(cat1.equals(cat1)); // true
    System.out.println(cat1.equals(cat2)); // true if equals() overwritten
    System.out.println(cat1.equals(scat1)); // true if equals() overwritten
    System.out.println(scat1.equals(cat1)); // false if equals() overwritten
  }
}
