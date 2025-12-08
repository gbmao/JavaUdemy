package dev.lpa;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread is running");
        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " should take 10 dots  to run.");

            for (int i = 0; i < 10; i++) {
                System.out.print(" . ");
                try {
                    Thread.sleep(500);
//                    System.out.println("A. state = " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    System.out.println("\n Whoops!! " + name + " Interrupted.");
//                    System.out.println("A1. State = " + Thread.currentThread().getState());
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + name + " completed.");
        });


        Thread installThread = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(250);
                    System.out.println("Installation Step " + (i+ 1) +
                            " is completed.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "InstallThread");




        Thread threadMonitor = new Thread(() -> {

        long now = System.currentTimeMillis();
        while (thread.isAlive()) {
//            System.out.println("\nwaiting for thread to complete");

            try {
                Thread.sleep(1000);
//                System.out.println("B. State = " + thread.getState());

                if (System.currentTimeMillis() - now > 2000) {
                    thread.interrupt();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }});
        System.out.println(thread.getName()+ " stating");
        thread.start();
        threadMonitor.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(!thread.isInterrupted()) {
            installThread.start();
        } else {
            System.out.println("previous thread was interrupted, " +
                    installThread.getName() + " can't run");
        }

//        System.out.println("C. state = " + thread.getState());


//        System.out.println("Main thread would continue here");
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
    }
}
