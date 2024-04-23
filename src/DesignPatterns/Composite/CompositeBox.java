package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeBox implements Box {
    private final List<Box> children = new ArrayList<>();
    public CompositeBox(Box... boxes) {
        children.addAll(Arrays.asList(boxes));
    }
    @Override
    public double calculatePrice() {
        return children.stream().mapToDouble(Box::calculatePrice).sum();
    }
}
interface Box {
    double calculatePrice();
}

abstract class Product implements Box {
    protected final String name;
    protected final double price;
    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
}

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
    public double calculatePrice() {
        return getPrice();
    }
}

class VideoGame extends Product {
    public VideoGame(String name, double price) {
        super(name, price);
    }
    public double calculatePrice() {
            return getPrice();
    }
}

class OrderService {
    private Box box;
    public void setupOrder(Box... boxes) {
        this.box = new CompositeBox(boxes);
    }
    public double calculateOrderPrice() {
        return box.calculatePrice();
    }
}
class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", 20);
        Book book2 = new Book("Book2", 25);
        VideoGame videoGame1 = new VideoGame("VG1", 60);
        VideoGame videoGame2 = new VideoGame("VG2", 70);
        VideoGame videoGame3 = new VideoGame("VG3", 80);

        OrderService orderService = new OrderService();

        orderService.setupOrder(book1,
                new CompositeBox(book2, videoGame1,
                        new CompositeBox(videoGame2, videoGame3)));

        orderService.calculateOrderPrice();
    }
}