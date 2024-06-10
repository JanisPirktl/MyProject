package PVA10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    public static void main(String[] args){
        Thread threadW1 = new Thread(new Runnable() {
            public void run() {
                Data.write("Thread 1 working");
            }
        });

        Thread threadR1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Data.read());
            }
        });

        Thread threadW2 = new Thread(new Runnable() {
            public void run() {
                Data.write("Thread 2 working");
            }
        });

        Thread threadR2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Data.read());
            }
        });

        Thread threadW3 = new Thread(new Runnable() {
            public void run() {
                Data.write("Thread 3 working");
            }
        });

        Thread threadR3= new Thread(new Runnable() {
            public void run() {
                System.out.println(Data.read());
            }
        });

        ExecutorService executor = Executors.newCachedThreadPool();

        threadW1.start();
        threadR1.start();
        threadW2.start();
        threadR2.start();
        threadW3.start();
        threadR3.start();
    }
}

class Data {
    private static String data = null;
    private static ReentrantLock reentrantlock = new ReentrantLock();
    private static Condition condition = reentrantlock.newCondition();

    public static void write(String data) {
        reentrantlock.lock();
        try {
            while(data != null) {
                condition.await();
            }
            Data.data = data;
            condition.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            reentrantlock.unlock();
        }
    }

    public static String read() {
        reentrantlock.lock();
        try {
            while(data == null) {
                condition.await();
            }
            String tmpData = Data.data;
            Data.data = null;
            condition.signalAll();

            return tmpData;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            reentrantlock.unlock();
        }
        return null;
    }
}