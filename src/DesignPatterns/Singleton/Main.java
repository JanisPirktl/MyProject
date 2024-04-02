package DesignPatterns.Singleton;

public class Main {

  public static void main(String[] args) {

    SequenceNumber sn = SequenceNumber.INSTANCE;

    System.out.println(sn.next());
    System.out.println(sn.next());
    System.out.println(sn.next());
  }

}
