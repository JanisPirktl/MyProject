package Besondere_typen;



public class SuperCat extends Cat {

  private String power;


  public SuperCat(String name, int weight, String power) {
    super(name, weight);
    this.power = power;
  }


  public boolean equals(Object o) {
    if (!(o instanceof SuperCat)) {
      return false; //instance of ist auch true, wenn subklasse von Cat ist.
      //o.getClass == Cat wäre falsch, wenn es eine Subkklasse von Cat ist.
    }
    SuperCat superCat = (SuperCat) o;
    return getName().equals(superCat.getName()) && getWeight() == superCat.getWeight() && power.equals(superCat.power);
  }


}
