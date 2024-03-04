package rocket;

public class Rocket<T> {

  private T value;
  public Rocket() {}
  public Rocket(T value) {
    this.value = value;
  }
  public void set(T value) {
    this.value = value;
  }
  public T get() {
    return value;
  }
  public boolean isEmpty() {
    return value == null;
  }
  public void empty() {
    value = null;
  }

}
