package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.Objects;

public class Weather {
    private WeatherType currentWeather;
    private final ArrayList<WeatherObserver> observers = new ArrayList<>();

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }
    private void notifyObservers() {
        for(WeatherObserver observer : observers) {
            observer.update(currentWeather);
        }
    }
    public void setWeather(WeatherType currentWeather) {
        Objects.requireNonNull(currentWeather);
        this.currentWeather = currentWeather;
        notifyObservers();
    }
}
