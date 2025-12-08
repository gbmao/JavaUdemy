package dev.lpa;

public class CustomThread extends Thread{

    @Override
    public void run() {

        for (int i = 0; i <= 10; i += 2) {
            System.out.print(" " + i + " ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
//                currentThread().interrupt();
//                interrupt();
                System.out.println(" Stopped....");
                break;
            }
        }
    }
}
