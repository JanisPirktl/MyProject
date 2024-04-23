package DesignPatterns.Builder;

public class Main {
    public static void main(String[] args) {

        CarBuilder builder = new CarBuilder();

        Car car1 = builder.setBrand("KIA")
                .setModel("Piccanto")
                .setColor("Red")
                .build();
    }
}

class Car {
    private final String brand;
    private final String model;
    private final String color;
    protected Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
}

class CarBuilder {
    private String brand;
    private String model;
    private String color;

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }
    public Car build() {
        return new Car(brand, model, color);
    }
}


