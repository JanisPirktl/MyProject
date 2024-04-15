package DesignPatterns.Observer;

public enum WeatherType {
    SUNNY("Sunny"),
    RAINY("Rainy"),
    WINDY("Windy");
    final String description;

    WeatherType(String description) {
        this.description = description;
    }
}
