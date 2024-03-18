package PVA1und2.rocket;

import java.util.* ;

class A2
{
  public String toString() { return "A"; }
}

class B2 extends A2
{
  public String toString() { return "B"; }
}


public class A4
{

  private static <T extends A2> void meth(List<T> meineListe) {

    for (T element : meineListe) {
      System.out.println(element);
    }
  }

  private static void meth2(List<? extends A2> meineListe) {

    for(A2 a : meineListe) {
      System.out.println(a);
    }
  }

  private static void meth3(List<? extends A2> meineListe) {

    for(var a : meineListe) {
      System.out.println(a);
    }
  }

  public static void main( String[] args )
  {
    List<A2> la = new ArrayList<>( List.of(new A2(),new A2(),new A2()) ) ;
    List<B2> lb = new ArrayList<>( List.of(new B2(),new B2(),new B2()) ) ;

    meth3( la ) ;
    meth3( lb ) ;
  }
}
