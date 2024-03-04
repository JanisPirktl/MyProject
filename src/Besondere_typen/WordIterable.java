package Besondere_typen;

import java.util.*;

class WordIterable implements Iterable<String> {
  static class StringIterator implements Iterator<String> {
    StringTokenizer tokenizer;
    public StringIterator(String string) {
      tokenizer = new StringTokenizer(string);
    }
    public boolean hasNext() {
      return tokenizer.hasMoreTokens();
    }
    public String next() {
      if (hasNext()) return tokenizer.nextToken();
      throw new NoSuchElementException();
    }
  }
  String string;
  public WordIterable( String string ) {
    this.string = string;
  }
  @Override public Iterator<String> iterator() {
    return new StringIterator( string );
  }
}