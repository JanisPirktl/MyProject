package PVA1und2.rocket;

public class GenericExample {

  public static void main( String[] args )
  {
    Integer[]   intArray    = { 3, 6, 2, 8, 6 } ;
    Character[] charArray   = { 'a', 'r', 'V', 'A' } ;
    String[]    stringArray = { "xyz", "abc", "pqr" } ;

    System.out.println( "intArray:    " + new Generic<>(intArray).min() ) ;
    System.out.println( "charArray:   " + new Generic<>(charArray).min() ) ;
    System.out.println( "stringArray: " + new Generic<>(stringArray).min() ) ;
  }
  public static class Generic <T extends Comparable<T>> {
    private T[] meineListe;
    public Generic(T[] meineListe) {
      this.meineListe = meineListe;
    }
    public T min() {
      if (meineListe == null || meineListe.length == 0) {
        return null;
      }
      T minValue = meineListe[0];
      for (int i = 1; i < meineListe.length; i++) {
        if (meineListe[i].compareTo(minValue) < 0) {
          minValue = meineListe[i];
        }
      }
      return minValue;
    }
  }
}
