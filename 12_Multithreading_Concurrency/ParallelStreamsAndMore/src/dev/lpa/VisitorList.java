package dev.lpa;

import java.util.concurrent.*;
import java.util.stream.Stream;

public class VisitorList {

    private static final CopyOnWriteArrayList<Person> masterList;

    static {
        masterList = Stream.generate(Person::new)
                .distinct()
                .limit(2500)
                .collect(CopyOnWriteArrayList::new,
                        CopyOnWriteArrayList::add,
                        CopyOnWriteArrayList::addAll);
    }

    private static final ArrayBlockingQueue<Person> newVisitors =
            new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        Runnable producer = () -> {

            Person visitor = new Person();
            System.out.println("Queueing " + visitor);
            boolean queued = false;
            try {
                queued = newVisitors.add(visitor);
            } catch (IllegalStateException e) {
                System.out.println("Illegal State Exception!");
            }
            if (queued) {
//                System.out.println(newVisitors);
            } else {
                System.out.println("Queue is full, cannot add " + visitor);
            }
        };

        Runnable consumer = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Polling queue " + newVisitors.size());
            Person visitor = newVisitors.poll();
            if(visitor != null) {
                System.out.println(threadName + " " + visitor);
                if(!masterList.contains(visitor)) {
                    masterList.add(visitor);
                    System.out.println("---> New Visitor gets Coupon!: " + visitor);
                }
            }
            System.out.println(threadName + " done " + newVisitors.size());
        };

        ScheduledExecutorService producerExecutor =
                Executors.newSingleThreadScheduledExecutor();
        producerExecutor.scheduleWithFixedDelay(producer, 0, 1,
                TimeUnit.SECONDS);

        ScheduledExecutorService consumerPool = 
                Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 3; i++) {
            consumerPool.scheduleAtFixedRate(consumer, 6,3,TimeUnit.SECONDS);
        }

        while (true) {
            try {
                if (!producerExecutor.awaitTermination(10, TimeUnit.SECONDS))
                    break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        producerExecutor.shutdown();



        while (true) {
            try {
                if (!consumerPool.awaitTermination(3, TimeUnit.SECONDS))
                    break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        consumerPool.shutdown();
    }
}
