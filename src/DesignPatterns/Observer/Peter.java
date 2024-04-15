package DesignPatterns.Observer;

public class Peter implements WeatherObserver {
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("Peter updated Weather to " + weatherType);
    }
}
