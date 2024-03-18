package Besondere_typen;


import java.util.ArrayList;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {

    Cat cat1 = new Cat("Mitzi", 15);
    Cat cat2 = new Cat("Mausi", 16);
    Cat cat3 = new Cat("Mitzi", 17);
    Cat cat4 = new Cat(cat1);

    ArrayList<Cat> catList = new ArrayList<>();
    catList.add(cat1);
    catList.add(cat2);
    catList.add(cat3);
    catList.add(cat4);

    catList.sort(Comparator.naturalOrder()); //nach natürlicher Ordnung sortieren
    //cat muss hierfür comparable implementieren und compareTo() haben




    catList.sort((c1, c2) -> c1.getName().compareTo(c2.getName())); //aufsteigend
    catList.sort((c2, c1) -> c2.getName().compareTo(c1.getName())); //aufsteigend
    catList.sort((c2, c1) -> c1.getName().compareTo(c2.getName())); //absteigend
    catList.sort((c1, c2) -> c2.getName().compareTo(c1.getName())); //absteigend

    catList.sort(Comparator.comparing(Cat::getName)); //aufsteigend
    catList.sort(Comparator.comparing(Cat::getName).thenComparing(Cat::getWeight)); //aufsteigend Name, dann gewicht
    catList.sort(Comparator.comparing(Cat::getName).reversed()); //absteigend

    //theoretisch müsste Cat nicht mal Comparable implementieren um das zu können

    for (Cat cat : catList) {
      System.out.println(cat);
    }

    System.out.println();
    SuperCat scat1 = new SuperCat("Mitzi", 15, "Force");
    Cat cat77 = new Cat(scat1);

    System.out.println(cat1.equals(cat1)); //Vergleicht die Attribute - true
    System.out.println(cat1.equals(cat2)); //false
    System.out.println(cat1.equals(cat3)); //true
    System.out.println();
    System.out.println(cat1 == cat1); //verlgeicht die Speicheradresse - true
    System.out.println(cat1 == cat2);//false
    System.out.println(cat1 == cat3);//false

    System.out.println();
    System.out.println(cat1.hashCode() == cat3.hashCode()); //false
    System.out.println();

    System.out.println(cat1.equals(scat1)); //true
    System.out.println(scat1.equals(cat1)); //false

    System.out.println(System.identityHashCode(cat1) == cat1.hashCode());

  }
}