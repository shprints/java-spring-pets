package com.example.java.spring.pets.util;

public class MyThreadClass extends Thread {

    public MyThreadClass() {
    }

    public MyThreadClass(String name) {
        super(name);
    }

    public MyThreadClass(Runnable target) {
        super(target);
        System.out.println(target + " will running");
    }

    @Override
    public void run() {
        System.out.println("ThreadClass run() method " + "Thread name is: " + this.getName());
    }
}
