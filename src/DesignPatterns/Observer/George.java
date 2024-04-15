package DesignPatterns.Observer;

public class George implements WeatherObserver {
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("George updated Weather to " + weatherType);
    }
}
