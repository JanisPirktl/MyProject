package DesignPatterns.Singleton;


public enum SequenceNumber {
  INSTANCE;
  private int number;
  private SequenceNumber() {
    number = 0;
  }
  public int next() {
    return number++;
  }
}