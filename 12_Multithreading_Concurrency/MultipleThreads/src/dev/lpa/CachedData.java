package dev.lpa;

import java.util.concurrent.TimeUnit;

public class CachedData {

    private volatile boolean flag = false;

    public void toggleFLag() {
        flag = !flag;
    }

    public boolean isReady() {
        return flag;
    }

    public static void main(String[] args) {

        CachedData example = new CachedData();

        Thread writerThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.toggleFLag();
            System.out.println("A. flag set to " + example.isReady());
        });


        Thread readerThread = new Thread(() -> {
            while (!example.isReady()) {
                //busy
            }
            System.out.println("B. Flag is " + example.isReady());
        });

        writerThread.start();
        readerThread.start();
    }
}
