package dev.lpa;

public class Main {

    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();

        Thread odd = new Thread( () -> {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.print(" ops ");
                return;
            }
            for (int i = 1; i <= 10; i+=2) {
                System.out.print(" " + i + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println(" NO more...");
                    break;
                }
            }
        });

        customThread.start();
        customThread.interrupt();

        odd.start();
        odd.interrupt();
    }
}
