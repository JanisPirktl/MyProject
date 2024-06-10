package PVA10;

public class EndlessThread implements Runnable {
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            System.out.println("I am alive");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread bye");
            }
        }
    }
}

class KillEndlessThread {
    public static void main(String[] args) throws InterruptedException {
        Thread endless = new Thread(new EndlessThread());
        endless.start();

        Thread.sleep(15000);
        endless.interrupt();
    }
}
