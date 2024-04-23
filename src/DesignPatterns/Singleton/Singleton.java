package DesignPatterns.Singleton;

public class Singleton {
    private static Singleton instance;
    private String data;
    private Singleton(String data) {
        this.data = data;
    }
    public static Singleton getInstance(String data) {

        if (instance == null) {
            instance = new Singleton(data);
        }
        return instance;
    }
}

class Main {
    public static void main(String[] args) {

        Singleton.getInstance("data");
    }
}

