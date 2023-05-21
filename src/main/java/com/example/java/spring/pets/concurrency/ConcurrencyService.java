package com.example.java.spring.pets.concurrency;

public interface ConcurrencyService {

    void runThreads();

    int runAsyncMethod() throws InterruptedException;

    int runSyncMethod() throws InterruptedException;

    void runReentrantHello();
}
