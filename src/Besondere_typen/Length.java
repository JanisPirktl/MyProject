package Besondere_typen;

import java.util.Objects;

public class Length {

  public static void main(String[] args) {

    Length l1 = new Length(5, Unit.METER);
  }
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
      Objects.requireNonNull(unit, "Unit must not be null");
      if (value < 0.0)
        throw new IllegalArgumentException("Value must be >= 0.0");
      this.value = value;
      this.unit = unit;
    }
    public Length() {
      this(0, Unit.METER);
    }
    public enum Unit {
      METER(1.0),
      CENTIMETER(0.01),
      INCH(0.0254),
      MILE(1609.344);

      final double factor;

      Unit(double factor) {
        this.factor = factor;
      }
    }
  }
