package com.example.java.spring.pets.util;

public class MyRunnableClass implements Runnable {

    private String localName;

    public MyRunnableClass() {
    }

    public MyRunnableClass(String localName) {
        this.localName = localName;
    }

    @Override
    public void run() {
        System.out.println("run() " + localName + " running");
    }

    public String getLocalName() {return localName;}
    public void setLocalName(String localName) {this.localName = localName;}
}
