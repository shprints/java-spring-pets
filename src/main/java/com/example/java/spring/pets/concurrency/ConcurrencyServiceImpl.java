package com.example.java.spring.pets.concurrency;

import com.example.java.spring.pets.model.AsyncCounter;
import com.example.java.spring.pets.util.MyRunnableClass;
import com.example.java.spring.pets.util.MyThreadClass;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Service
public class ConcurrencyServiceImpl implements ConcurrencyService {

    @Override
    public void runThreads() {
        MyThreadClass threadClass = new MyThreadClass("Thread");
        threadClass.start();

        Thread thread1 = new Thread(new MyRunnableClass("First"));
        Thread thread2 = new Thread(new MyRunnableClass("Second"));
        Thread thread3 = new Thread(new MyRunnableClass("Third"));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public int runAsyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        AsyncCounter summation = new AsyncCounter();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::inc));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        return summation.getSum();
    }

    @Override
    public int runSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        AsyncCounter summation = new AsyncCounter();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::syncInc));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        return summation.getSum();
    }

    @Override
    public void runReentrantHello() {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("First hello");

            synchronized (lock) {
                System.out.println("Second hello");

                synchronized (lock) {
                    System.out.println("Last hello");
                }
            }
        }
    }
}
