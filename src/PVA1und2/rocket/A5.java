package PVA1und2.rocket;

import java.util.* ;

class A
{
  public String toString() { return "PVA1und2.rocket.A"; }
}

class B extends A
{
  public String toString() { return "PVA1und2.rocket.B"; }
}

class C extends B
{
  public String toString() { return "PVA1und2.rocket.C"; }
}

public class A5
{

  private void addOneBandOneC(List<? super B> meineListe) {

    meineListe.add(new B());
    meineListe.add(new C());
  }


  public static void main( String[] args )
  {
    List<A> la = new ArrayList<>() ;
    List<B> lb = new ArrayList<>() ;

    A5 a5 = new A5() ;
    a5.addOneBandOneC( la ) ;
    a5.addOneBandOneC( lb ) ;

    la.forEach( System.out::println ) ;
    lb.forEach( System.out::println ) ;
  }
}