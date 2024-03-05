package Besondere_typen;


import java.util.List;

public class Statistic {

  public static<T extends Comparable<T>> T max(List<T> myList) {

    if( (myList == null) || (myList.isEmpty()) )
    {
      throw new IllegalArgumentException( "list is invalid" ) ;
    }

    T result = myList.get(0) ;

    for (T t : myList) {
      if (t.compareTo(result) > 0) {
        result = t;
      }
    }

    return result ;
  }
}