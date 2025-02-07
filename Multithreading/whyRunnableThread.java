package Multithreading;

class Meter {
    int cnt = 0;

    public void increment() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Firing: " + this.cnt);
        }
    }
}

class AdvanceMeter extends Meter implements Runnable {
    @Override
    public void increment() {
        super.increment();
    }

    public void run() {
        this.increment();
    }
}

public class whyRunnableThread {
    public static void main(String[] args) {
        AdvanceMeter am = new AdvanceMeter();
        Thread t = new Thread(am); 
        t.start();
    }
}
