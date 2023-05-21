package com.example.java.spring.pets.concurrency;

import com.example.java.spring.pets.util.MyRunnableClass;
import com.example.java.spring.pets.util.MyThreadClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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


}
