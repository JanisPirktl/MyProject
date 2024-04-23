package DesignPatterns.Observer;

public class Main {
    public static void main(String[] args) {

        Peter peter = new Peter();
        George george = new George();

        Weather weather = new Weather();

        weather.addObserver(peter);
        weather.addObserver(george);

        weather.setWeather(WeatherType.WINDY);
    }
}
