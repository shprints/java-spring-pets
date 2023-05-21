package com.example.java.spring.pets.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsyncCounter {

    private int sum = 0;

    public void inc() {
        setSum(getSum() + 1);
    }

    public synchronized void syncInc() {
        setSum(getSum() + 1);
    }
}
